package hoainguyen.recyclerhelper.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

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

public class BaseFragment extends RecyclerViewFragment {
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter.append(new HeaderRenderItem());
        adapter.append(new DataRenderItem(new DataModel("COD", "20")));
        adapter.append(new DataRenderItem(new DataModel("DO", "25")));
        adapter.append(new DataRenderItem(new DataModel("PH", "7")));
        adapter.append(new DataRenderItem(new DataModel("TSS", "20")));
        adapter.append(new StaticRenderItem(R.layout.item_static_full_span_layout, true));
        adapter.append(new StaticRenderItem(R.layout.item_static_layout, false));
        adapter.append(new StaticRenderItem(R.layout.item_static_layout, false));
        adapter.append(new HorizontalScrollItem());
        adapter.append(new LoadingIndicatorRenderItem());
        adapter.append(new DataRenderItem(new DataModel("COD", "20")));
        adapter.append(new DataRenderItem(new DataModel("DO", "25")));
        adapter.append(new DataRenderItem(new DataModel("PH", "7")));
        adapter.append(new DataRenderItem(new DataModel("TSS", "20")));
    }
}
