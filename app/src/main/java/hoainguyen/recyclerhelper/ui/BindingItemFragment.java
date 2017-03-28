package hoainguyen.recyclerhelper.ui;

import hoainguyen.lib.recyclerhelper.collection.CollectionFragment;
import hoainguyen.lib.recyclerhelper.recycler.DataSectionRVAdapter;
import hoainguyen.lib.recyclerhelper.recycler.item.indicator.LoadingIndicatorRenderItem;
import hoainguyen.recyclerhelper.data.model.DataModel;
import hoainguyen.recyclerhelper.ui.items.DataBindingItem;
import hoainguyen.recyclerhelper.ui.items.HeaderRenderItem;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class BindingItemFragment extends CollectionFragment {
    @Override
    protected void onMakeAdapters() {
        mRecyclerView.appendAdapter(new DataSectionRVAdapter() {
            @Override
            public void onStartLoadData() {
                append(new HeaderRenderItem());
                append(new LoadingIndicatorRenderItem());
                append(new DataBindingItem(new DataModel("COD", "28")));
                append(new DataBindingItem(new DataModel("DO", "29")));
                append(new DataBindingItem(new DataModel("PH", "5")));
                append(new DataBindingItem(new DataModel("TSS", "20")));
            }
        });
    }
}
