package hoainguyen.recyclerhelper.ui.gallery;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.lib.recyclerhelper.recycler.model.CollectionDataModel;
import hoainguyen.lib.recyclerhelper.recycler.model.PaginationModel;

/**
 * Created by thongbeo on 7/11/16.
 */
public class GalleryImageRepository {

    private int mImageLimit;
    private int mImageOffset;

    private static final String[] PROJECTION_BUCKET = {
            MediaStore.Images.ImageColumns.BUCKET_ID,
            MediaStore.Images.Media._ID,
            MediaStore.MediaColumns.DATA,
            MediaStore.MediaColumns.DISPLAY_NAME,
            MediaStore.MediaColumns.DATE_ADDED};
    private static final String ORDER = MediaStore.MediaColumns.DATE_ADDED + " DESC";

    public void initImageParams(int offset, int limit) {
        mImageLimit = limit;
        mImageOffset = offset;
    }

    private String getThumbnailPath(ContentResolver cs, long id) {
        Cursor cursor = MediaStore.Images.Thumbnails.queryMiniThumbnail(
                cs, id,
                MediaStore.Images.Thumbnails.MINI_KIND,
                null);
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            String uri = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Thumbnails.DATA));
            cursor.close();

            return uri;
        }

        if (cursor != null)
            cursor.close();

        return null;
    }

    private List<GalleryImage> getGalleryImages(ContentResolver cs, String limitParams) {
        List<GalleryImage> galleryImages = new ArrayList<>();

        Cursor cursor = cs.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                PROJECTION_BUCKET,
                null,
                null,
                ORDER + " " + limitParams);

        if (cursor != null
                && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media._ID));
                String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA));
                String thumbnail = getThumbnailPath(cs, id);
                galleryImages.add(new GalleryImage(id, path, thumbnail));
            }
        }

        if (cursor != null)
            cursor.close();

        return galleryImages;
    }

    public void getGalleryCollection(ContentResolver contentResolver, String queryParams, ResponseListener responseListener) {
        List<GalleryImage> galleryImages = getGalleryImages(contentResolver, queryParams);

        PaginationModel paginationModel;
        if (galleryImages.size() < mImageLimit) {
            paginationModel = new PaginationModel("", "");
        } else {
            mImageOffset += mImageLimit;
            paginationModel = new PaginationModel("", populateLimitParams());
        }

        CollectionDataModel<GalleryImage> collectionDataModel
                = new CollectionDataModel<>(galleryImages.toArray(new GalleryImage[galleryImages.size()]), paginationModel);

        responseListener.onSuccess(collectionDataModel);
    }

    public String populateLimitParams() {
        return String.format("LIMIT %s OFFSET %s", mImageLimit, mImageOffset);
    }

    public interface ResponseListener<T> {
        void onSuccess(T data);
    }
}
