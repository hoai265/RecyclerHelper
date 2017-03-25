package hoainguyen.recyclerhelper.ui.gallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.lib.recyclerhelper.collection.BaseCollectionFragment;
import hoainguyen.lib.recyclerhelper.collection.CollectionDataModel;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;

/**
 * Created by hoainguyen on 3/9/17.
 */

public class ImageGalleryFragment extends BaseCollectionFragment<GalleryImage> {

    private GalleryImageRepository galleryImageRepository;
    private ImageGalleryListener imageGalleryListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        galleryImageRepository = new GalleryImageRepository();
        galleryImageRepository.initImageParams(0, 15);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof ImageGalleryListener) {
            imageGalleryListener = (ImageGalleryListener) getActivity();
        }
    }

    @Override
    protected void onLoadData() {
        galleryImageRepository.getGalleryCollection(getActivity().getContentResolver(),
                galleryImageRepository.populateLimitParams(),
                new GalleryImageRepository.ResponseListener<CollectionDataModel<GalleryImage>>() {
                    @Override
                    public void onSuccess(CollectionDataModel<GalleryImage> collectionDataModel) {
                        refreshDataCollection(collectionDataModel);
                    }
                });
    }

    @Override
    public void onCreateViewMore(LayoutInflater inflater, View rootView) {
        mRecycleView.relayout(3, RecyclerView.VERTICAL);
    }

    @Override
    public List<RenderItem> makeRenderItem(GalleryImage[] data) {
        List<RenderItem> renderItems = new ArrayList<>();

        for (GalleryImage galleryImage : data) {
            renderItems.add(new GalleryImageItem(galleryImage));
        }
        return renderItems;
    }

    @Override
    public void onLoadMore(String nextUrl) {
        galleryImageRepository.getGalleryCollection(getActivity().getContentResolver(), nextUrl,
                new GalleryImageRepository.ResponseListener<CollectionDataModel<GalleryImage>>() {
                    @Override
                    public void onSuccess(CollectionDataModel<GalleryImage> collectionDataModel) {
                        onLoadMoreCompleted();
                        appendDataCollection(collectionDataModel);
                    }
                });
    }

    @Override
    public void onLoadPrevious(String previousUrl) {

    }

    public interface ImageGalleryListener {
        void onGalleryImageSelected(GalleryImage galleryImage);

        void onGalleryImageUnSelected(GalleryImage galleryImage);
    }
}
