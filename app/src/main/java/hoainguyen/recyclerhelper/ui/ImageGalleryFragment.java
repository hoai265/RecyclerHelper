package hoainguyen.recyclerhelper.ui;

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
import hoainguyen.recyclerhelper.data.GalleryImageRepository;
import hoainguyen.recyclerhelper.data.model.GalleryImageModel;
import hoainguyen.recyclerhelper.ui.items.GalleryImageItem;

/**
 * Created by hoainguyen on 3/9/17.
 */

public class ImageGalleryFragment extends BaseCollectionFragment<GalleryImageModel> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GalleryImageRepository.init();
    }

    @Override
    protected void onLoadData() {
        GalleryImageRepository.getInstance().getGalleryCollection(getActivity().getContentResolver(),
                GalleryImageRepository.getInstance().populateLimitParams(),
                new GalleryImageRepository.ResponseListener<CollectionDataModel<GalleryImageModel>>() {
                    @Override
                    public void onSuccess(CollectionDataModel<GalleryImageModel> collectionDataModel) {
                        refreshDataCollection(collectionDataModel);
                    }
                });
    }

    @Override
    public void onCreateViewMore(LayoutInflater inflater, View rootView) {
        mRecycleView.relayout(3, RecyclerView.VERTICAL);
    }

    @Override
    public List<RenderItem> makeRenderItem(GalleryImageModel[] data) {
        List<RenderItem> renderItems = new ArrayList<>();

        for (GalleryImageModel galleryImageModel : data) {
            renderItems.add(new GalleryImageItem(galleryImageModel));
        }
        return renderItems;
    }

    @Override
    public void onLoadMore(String nextUrl) {
        GalleryImageRepository.getInstance().getGalleryCollection(getActivity().getContentResolver(),
                nextUrl,
                new GalleryImageRepository.ResponseListener<CollectionDataModel<GalleryImageModel>>() {
                    @Override
                    public void onSuccess(CollectionDataModel<GalleryImageModel> collectionDataModel) {
                        onLoadMoreCompleted();
                        appendDataCollection(collectionDataModel);
                    }
                });
    }

    @Override
    public void onLoadPrevious(String previousUrl) {

    }
}
