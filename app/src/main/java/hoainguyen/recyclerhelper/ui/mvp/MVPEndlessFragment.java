package hoainguyen.recyclerhelper.ui.mvp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import hoainguyen.lib.recyclerhelper.collection.mvp.MVPBaseCollectionFragment;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class MVPEndlessFragment extends MVPBaseCollectionFragment<MVPEndlessDataPresenter> implements MVPEndlessContract.MVPEndlessView {
    @Override
    public MVPEndlessDataPresenter onCreatePresenter() {
        return new MVPEndlessDataPresenter();
    }

    @Override
    public void onCreateViewMore(LayoutInflater inflater, View rootView) {
        super.onCreateViewMore(inflater, rootView);
        mRecycleView.relayout(2, RecyclerView.VERTICAL);
    }
}
