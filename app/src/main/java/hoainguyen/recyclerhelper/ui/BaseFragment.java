package hoainguyen.recyclerhelper.ui;

import android.view.LayoutInflater;
import android.view.View;

import hoainguyen.lib.recyclerhelper.collection.CollectionFragment;
import hoainguyen.lib.recyclerhelper.recycler.DataSectionRVAdapter;
import hoainguyen.lib.recyclerhelper.recycler.item.StaticRenderItem;
import hoainguyen.lib.recyclerhelper.recycler.item.indicator.LoadingIndicatorRenderItem;
import hoainguyen.recyclerhelper.R;
import hoainguyen.recyclerhelper.data.model.DataModel;
import hoainguyen.recyclerhelper.ui.items.DataRenderItem;
import hoainguyen.recyclerhelper.ui.items.HeaderRenderItem;
import hoainguyen.recyclerhelper.ui.items.HorizontalScrollItem;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class BaseFragment extends CollectionFragment {
    @Override
    protected void onMakeAdapters() {
        mRecyclerView.appendAdapter(new DataSectionRVAdapter() {
            @Override
            public void onStartLoadData() {
                append(new HeaderRenderItem());
                append(new DataRenderItem(new DataModel("COD", "20")));
                append(new DataRenderItem(new DataModel("DO", "25")));
                append(new DataRenderItem(new DataModel("PH", "7")));
                append(new DataRenderItem(new DataModel("TSS", "20")));
                append(new StaticRenderItem(R.layout.item_static_full_span_layout, true));
                append(new StaticRenderItem(R.layout.item_static_layout, false));
                append(new StaticRenderItem(R.layout.item_static_layout, false));
                append(new HorizontalScrollItem());
                append(new LoadingIndicatorRenderItem());
                append(new DataRenderItem(new DataModel("COD", "20")));
                append(new DataRenderItem(new DataModel("DO", "25")));
                append(new DataRenderItem(new DataModel("PH", "7")));
                append(new DataRenderItem(new DataModel("TSS", "20")));
            }
        });
    }

    @Override
    public void onCreateCustomView(LayoutInflater inflater, View rootView) {
        super.onCreateCustomView(inflater, rootView);
        mRecyclerView.setSpanCount(2);
    }
}
