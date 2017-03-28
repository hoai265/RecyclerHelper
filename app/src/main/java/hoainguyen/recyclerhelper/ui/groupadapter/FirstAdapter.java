package hoainguyen.recyclerhelper.ui.groupadapter;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.lib.recyclerhelper.recycler.DataSectionRVAdapter;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;
import hoainguyen.recyclerhelper.data.dummy.DummyContent;
import hoainguyen.recyclerhelper.ui.items.HeaderRenderItem;

/**
 * Created by hoainguyen on 3/28/17.
 */

public class FirstAdapter extends DataSectionRVAdapter {
    @Override
    public void onStartLoadData() {
        List<RenderItem> renderItems = new ArrayList<>();
        renderItems.add(new HeaderRenderItem());
        renderItems.addAll(DummyContent.getInstance().getDataRenderItemList());
        append(renderItems);
    }
}
