package hoainguyen.lib.recyclerhelper.collection.mvp;

import java.util.List;

import hoainguyen.lib.recyclerhelper.collection.CollectionDataModel;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;

/**
 * Created by hoainguyen on 1/14/17.
 */

public interface BaseCollectionContract {
    interface BaseCollectionView {
        void appendRenderItems(List<RenderItem> renderItems);

        void refreshRenderItems(List<RenderItem> renderItems);

        void hideLoadingMoreIndicator();

        void showLoadingMoreIndicator();
    }

    interface Presenter<V extends BaseCollectionView, T> {
        void onLoadCollectionData();

        void appendDataCollection(CollectionDataModel<T> dataCollection);

        void refreshDataCollection(CollectionDataModel<T> dataCollection);

        void onLoadMoreRequest();

        void onLoadMore(String nextUrl);

        void onLoadPreviousRequest();

        void onLoadPrevious(String previousUrl);

        List<RenderItem> makeRenderItem(T[] data);

        void onLoadMoreCompleted();

        void onLoadPreviousCompleted();

        void onStartLoading();

        void onLoadDataError();

        void setView(V view);
    }
}
