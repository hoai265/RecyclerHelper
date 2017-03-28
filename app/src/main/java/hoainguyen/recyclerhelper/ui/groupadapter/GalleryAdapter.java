package hoainguyen.recyclerhelper.ui.groupadapter;

import android.content.ContentResolver;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.lib.recyclerhelper.recycler.model.CollectionDataModel;
import hoainguyen.lib.recyclerhelper.recycler.model.PaginationModel;
import hoainguyen.lib.recyclerhelper.recycler.ExpandableDataSectionRVAdapter;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;
import hoainguyen.recyclerhelper.ui.gallery.GalleryImage;
import hoainguyen.recyclerhelper.ui.gallery.GalleryImageItem;
import hoainguyen.recyclerhelper.ui.gallery.GalleryImageRepository;

/**
 * Created by hoainguyen on 3/29/17.
 */

public class GalleryAdapter extends ExpandableDataSectionRVAdapter<GalleryImage> {
    private GalleryImageRepository galleryImageRepository;
    private ContentResolver mContentResolver;

    public GalleryAdapter(ContentResolver contentResolver) {
        mContentResolver = contentResolver;
        galleryImageRepository = new GalleryImageRepository();
        galleryImageRepository.initImageParams(0, 15);
    }

    @Override
    public void onStartLoadData() {
        galleryImageRepository.getGalleryCollection(mContentResolver,
                galleryImageRepository.populateLimitParams(),
                new GalleryImageRepository.ResponseListener<CollectionDataModel<GalleryImage>>() {
                    @Override
                    public void onSuccess(CollectionDataModel<GalleryImage> collectionDataModel) {
                        onLoadDataCompleted();
                        refreshDataCollection(collectionDataModel);
                    }
                });
    }

    @Override
    public void onExpandDown(final PaginationModel pagination) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                galleryImageRepository.getGalleryCollection(mContentResolver, pagination.getNextUrl(),
                        new GalleryImageRepository.ResponseListener<CollectionDataModel<GalleryImage>>() {
                            @Override
                            public void onSuccess(CollectionDataModel<GalleryImage> collectionDataModel) {
                                onLoadExpandDownDataCompleted();
                                appendDataCollection(collectionDataModel);
                            }
                        });
            }
        }, 2000);
    }

    @Override
    public void onExpandUp(PaginationModel paginationModel) {

    }

    @Override
    public List<RenderItem> makeRenderItem(GalleryImage[] data) {
        List<RenderItem> renderItems = new ArrayList<>();

        for (GalleryImage galleryImage : data) {
            renderItems.add(new GalleryImageItem(galleryImage));
        }
        return renderItems;
    }
}
