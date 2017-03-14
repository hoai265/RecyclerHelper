package hoainguyen.lib.recyclerhelper.recycler.adapter;

import java.util.List;

import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;

/**
 * Created by hoainguyen on 2/24/17.
 */

public interface RenderItemRVAdapter {
    void refresh(List<RenderItem> renderItems);

    void insert(int position, List<RenderItem> items);

    void update(int position, RenderItem renderItem);

    void move(int beforePosition, int afterPosition);

    void append(List<RenderItem> renderItems);

    void append(RenderItem renderItem);

    void remove(int position);
}
