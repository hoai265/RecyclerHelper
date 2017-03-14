package hoainguyen.lib.recyclerhelper.collection.mvp;

import hoainguyen.lib.recyclerhelper.collection.CollectionDataModel;

/**
 * Created by hoainguyen on 1/13/17.
 */

public abstract class BaseCollectionPresenter<V extends BaseCollectionContract.BaseCollectionView, T> implements BaseCollectionContract.Presenter<V, T> {
    public V mCollectionView;
    private boolean mLoading = false;
    protected CollectionDataModel<T> mDataCollection;

    @Override
    public void setView(V view) {
        mCollectionView = view;
    }

    @Override
    public void appendDataCollection(CollectionDataModel<T> dataCollection) {
        mDataCollection.join(dataCollection);
        mCollectionView.appendRenderItems(makeRenderItem(dataCollection.getData()));
    }

    @Override
    public void refreshDataCollection(CollectionDataModel<T> dataCollection) {
        mDataCollection = dataCollection;
        mCollectionView.refreshRenderItems(makeRenderItem(dataCollection.getData()));
    }

    @Override
    public void onLoadMoreRequest() {
        if (!mLoading) {
            if (isHaveMoreData()) {
                mCollectionView.showLoadingMoreIndicator();
                mLoading = true;
                onLoadMore(mDataCollection.getPagination().getNextUrl());
            }
        }
    }

    @Override
    public void onLoadPreviousRequest() {
        if (!mLoading) {
            if (isHavePreviousData()) {
                mLoading = true;
                onLoadPrevious(mDataCollection.getPagination().getPreviousUrl());
            }
        }
    }

    private boolean isHavePreviousData() {
        return (mDataCollection != null && !mDataCollection.getPagination().getPreviousUrl().isEmpty());
    }

    private boolean isHaveMoreData() {
        return (mDataCollection != null && !mDataCollection.getPagination().getNextUrl().isEmpty());
    }

    @Override
    public void onLoadMoreCompleted() {
        if (mLoading) {
            mLoading = false;
            mCollectionView.hideLoadingMoreIndicator();
        }
    }

    @Override
    public void onLoadPreviousCompleted() {
        if (mLoading) {
            mLoading = false;
        }
    }

    @Override
    public void onLoadDataError() {
        if (mLoading)
            mLoading = false;
    }

    @Override
    public void onStartLoading() {
        mLoading = true;
    }
}
