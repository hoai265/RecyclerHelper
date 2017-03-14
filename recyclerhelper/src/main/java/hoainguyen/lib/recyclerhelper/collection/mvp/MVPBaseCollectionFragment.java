package hoainguyen.lib.recyclerhelper.collection.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hoainguyen.lib.recyclerhelper.R;
import hoainguyen.lib.recyclerhelper.recycler.XRecyclerView;
import hoainguyen.lib.recyclerhelper.recycler.adapter.MultiTypeRVAdapter;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;
import hoainguyen.lib.recyclerhelper.recycler.item.indicator.LoadingIndicatorRenderItem;

/**
 * Created by hoainguyen on 1/13/17.
 */

public abstract class MVPBaseCollectionFragment<P extends BaseCollectionPresenter> extends Fragment implements BaseCollectionContract.BaseCollectionView, XRecyclerView.EndlessScrollListener {
    protected XRecyclerView mRecycleView;
    public MultiTypeRVAdapter mDataAdapter;
    public P mCollectionPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCollectionPresenter = onCreatePresenter();
        mCollectionPresenter.setView(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = getRootLayout(inflater, container);
        mRecycleView = (XRecyclerView) rootView.findViewById(R.id.recycle_view);
        mDataAdapter = new MultiTypeRVAdapter();
        mRecycleView.setEndlessScrollListener(this);
        mRecycleView.setAdapter(mDataAdapter);
        onCreateViewMore(inflater, rootView);
        return rootView;
    }

    public abstract P onCreatePresenter();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mCollectionPresenter.onLoadCollectionData();
    }

    @Override
    public void appendRenderItems(List<RenderItem> renderItems) {
        mDataAdapter.append(renderItems);
    }

    @Override
    public void refreshRenderItems(List<RenderItem> renderItems) {
        mDataAdapter.refresh(renderItems);
    }

    public View getRootLayout(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_base_collection_layout, null);
    }

    public void onCreateViewMore(LayoutInflater inflater, View rootView) {

    }

    @Override
    public void onLoadMoreRequest() {
        mCollectionPresenter.onLoadMoreRequest();
    }

    @Override
    public void onLoadPreviousRequest() {
        mCollectionPresenter.onLoadPreviousRequest();
    }

    @Override
    public void hideLoadingMoreIndicator() {
        mDataAdapter.remove(mDataAdapter.getItemCount() - 1);
    }

    @Override
    public void showLoadingMoreIndicator() {
        mDataAdapter.append(new LoadingIndicatorRenderItem());
    }
}
