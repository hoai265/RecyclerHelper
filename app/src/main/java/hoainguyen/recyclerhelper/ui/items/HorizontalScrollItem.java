package hoainguyen.recyclerhelper.ui.items;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.lib.recyclerhelper.collection.CollectionDataModel;
import hoainguyen.lib.recyclerhelper.recycler.XRecyclerView;
import hoainguyen.lib.recyclerhelper.recycler.adapter.MultiTypeRVAdapter;
import hoainguyen.lib.recyclerhelper.recycler.item.RecyclerViewRenderItem;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;
import hoainguyen.recyclerhelper.R;
import hoainguyen.recyclerhelper.data.dummy.DummyContent;
import hoainguyen.recyclerhelper.data.model.DataModel;

/**
 * Created by hoainguyen on 3/9/17.
 */

public class HorizontalScrollItem extends RecyclerViewRenderItem<HorizontalScrollItem.HorizontalScrollViewHolder> {
    @Override
    public HorizontalScrollViewHolder makeViewHolder(Context context) {
        return new HorizontalScrollViewHolder(LayoutInflater.from(context).inflate(R.layout.item_horizontal_scroll_layout, null));
    }

    @Override
    public boolean isFullSpan() {
        return true;
    }

    @Override
    public void bindViewHolder(HorizontalScrollViewHolder holder) {
        CollectionDataModel<DataModel> collectionDataModel = DummyContent.getInstance().getDataModelCollection();
        List<RenderItem> renderItems = new ArrayList<>();
        for (DataModel dataModel : collectionDataModel.getData()) {
            renderItems.add(new DataRenderItem(dataModel));
        }
        holder.adapter.append(renderItems);
    }

    static class HorizontalScrollViewHolder extends RecyclerView.ViewHolder {
        MultiTypeRVAdapter adapter;
        XRecyclerView recyclerView;

        public HorizontalScrollViewHolder(View itemView) {
            super(itemView);
            recyclerView = (XRecyclerView) itemView.findViewById(R.id.view_recycler);
            recyclerView.relayout(1, RecyclerView.HORIZONTAL);
            adapter = new MultiTypeRVAdapter();
            recyclerView.setAdapter(adapter);
        }
    }
}
