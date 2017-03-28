package hoainguyen.recyclerhelper.ui.groupadapter;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.lib.recyclerhelper.recycler.DataSectionRVAdapter;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;
import hoainguyen.lib.recyclerhelper.recycler.item.StaticRenderItem;
import hoainguyen.recyclerhelper.R;

/**
 * Created by hoainguyen on 3/28/17.
 */

public class SecondAdapter extends DataSectionRVAdapter {
    @Override
    public void onStartLoadData() {
        List<RenderItem> renderItems = new ArrayList<>();
        renderItems.add(new StaticRenderItem(R.layout.item_static_full_span_layout, true));
        renderItems.add(new StaticRenderItem(R.layout.item_static_full_span_layout, true));
        append(renderItems);
    }
}
