package hoainguyen.recyclerhelper.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import hoainguyen.lib.recyclerhelper.recycler.item.indicator.LoadingIndicatorRenderItem;
import hoainguyen.recyclerhelper.data.model.DataModel;
import hoainguyen.recyclerhelper.ui.items.DataBindingItem;
import hoainguyen.recyclerhelper.ui.items.HeaderRenderItem;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class BindingItemFragment extends RecyclerViewFragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter.append(new HeaderRenderItem());
        adapter.append(new LoadingIndicatorRenderItem());
        adapter.append(new DataBindingItem(new DataModel("COD", "28")));
        adapter.append(new DataBindingItem(new DataModel("DO", "29")));
        adapter.append(new DataBindingItem(new DataModel("PH", "5")));
        adapter.append(new DataBindingItem(new DataModel("TSS", "20")));
    }
}
