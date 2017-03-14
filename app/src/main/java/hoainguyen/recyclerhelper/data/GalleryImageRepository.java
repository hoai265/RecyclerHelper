package hoainguyen.recyclerhelper.data;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.lib.recyclerhelper.collection.CollectionDataModel;
import hoainguyen.lib.recyclerhelper.collection.PaginationModel;
import hoainguyen.recyclerhelper.data.model.GalleryImageModel;
import hoainguyen.recyclerhelper.data.model.GalleryModel;

/**
 * Created by thongbeo on 7/11/16.
 */
public class GalleryImageRepository {

    private static int mLimit;
    private static int mOffset;

    private static final String[] PROJECTION_BUCKET = {
            MediaStore.Images.ImageColumns.BUCKET_ID,
            MediaStore.Images.Media._ID,
            MediaStore.MediaColumns.DATA,
            MediaStore.MediaColumns.DISPLAY_NAME,
            MediaStore.MediaColumns.DATE_ADDED};

    private static final String[] PROJECTION_BUCKET_IN_TABLE = {
            MediaStore.Images.ImageColumns.BUCKET_ID,
            MediaStore.Images.Media.DATE_TAKEN,
            MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME};

    private static final String BUCKET_GROUP_BY_IN_TABLE = "1) GROUP BY (1";
    private static final String BUCKET_ORDER_BY = "MIN(date_added) ASC";
    private static final String ORDER = MediaStore.MediaColumns.DATE_ADDED + " DESC";
    private static final String QUERY = MediaStore.Images.ImageColumns.BUCKET_ID + " = ?";

    private static GalleryImageRepository mInstance;

    private GalleryImageRepository() {
    }

    public static void init() {
        mLimit = 15;
        mOffset = 0;
    }

    public static GalleryImageRepository getInstance() {
        if (mInstance == null)
            mInstance = new GalleryImageRepository();
        return mInstance;
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

    private List<GalleryImageModel> getGalleryImages(ContentResolver cs, String limitParams) {
        List<GalleryImageModel> galleryImageModels = new ArrayList<>();

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
                galleryImageModels.add(new GalleryImageModel(id, path, thumbnail));
            }
        }

        if (cursor != null)
            cursor.close();

        return galleryImageModels;
    }

    public void getGalleryCollection(ContentResolver contentResolver, String queryParams, ResponseListener responseListener) {
        List<GalleryImageModel> galleryImageModels = getGalleryImages(contentResolver, queryParams);

        PaginationModel paginationModel;
        if (galleryImageModels.size() < mLimit) {
            paginationModel = new PaginationModel("", "");
        } else {
            mOffset += mLimit;
            paginationModel = new PaginationModel("", populateLimitParams());
        }

        CollectionDataModel<GalleryImageModel> collectionDataModel
                = new CollectionDataModel<>(galleryImageModels.toArray(new GalleryImageModel[galleryImageModels.size()]), paginationModel);

        responseListener.onSuccess(collectionDataModel);
    }

    public String populateLimitParams() {
        return String.format("LIMIT %s OFFSET %s", mLimit, mOffset);
    }

    public List<GalleryModel> getGalleries(ContentResolver cs) {
        List<GalleryModel> galleries = new ArrayList<>();

        Cursor cursor = cs.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                PROJECTION_BUCKET_IN_TABLE,
                BUCKET_GROUP_BY_IN_TABLE,
                null,
                BUCKET_ORDER_BY);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                int bucketId = cursor.getInt(cursor.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_ID));
                String bucketName = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME));
                galleries.add(new GalleryModel(bucketId, bucketName));
            }
            cursor.close();
        }

        return galleries;
    }

    public List<GalleryImageModel> getGalleryImages(ContentResolver cs, int bucketId, String limitParams) {
        List<GalleryImageModel> galleryImageModels = new ArrayList<>();

        Cursor cursor = cs.query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                PROJECTION_BUCKET,
                QUERY,
                new String[]{String.valueOf(bucketId)},
                ORDER + " " + limitParams);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media._ID));
                String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA));
                String thumbnail = getThumbnailPath(cs, id);
                galleryImageModels.add(new GalleryImageModel(id, path, thumbnail));
            }
            cursor.close();
        }

        return galleryImageModels;
    }

    public interface ResponseListener<T> {
        void onSuccess(T data);
    }
}
