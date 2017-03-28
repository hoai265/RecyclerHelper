package hoainguyen.recyclerhelper.ui.items;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.lib.recyclerhelper.recycler.DataSectionRVAdapter;
import hoainguyen.lib.recyclerhelper.recycler.ExRecyclerView;
import hoainguyen.lib.recyclerhelper.recycler.item.RecyclerViewRenderItem;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;
import hoainguyen.lib.recyclerhelper.recycler.model.CollectionDataModel;
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
    public void bindViewHolder(final HorizontalScrollViewHolder holder) {
        holder.recyclerView.appendAdapter(new DataSectionRVAdapter() {
            @Override
            public void onStartLoadData() {
                CollectionDataModel<DataModel> collectionDataModel = DummyContent.getInstance().getDataModelCollection();
                List<RenderItem> renderItems = new ArrayList<>();
                for (DataModel dataModel : collectionDataModel.getData()) {
                    renderItems.add(new DataRenderItem(dataModel));
                }

                refresh(renderItems);
            }
        });

        holder.recyclerView.start();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(holder.itemView, "Horizontal", 2000).show();
            }
        });
    }

    static class HorizontalScrollViewHolder extends RecyclerView.ViewHolder {
        ExRecyclerView recyclerView;

        public HorizontalScrollViewHolder(View itemView) {
            super(itemView);
            recyclerView = (ExRecyclerView) itemView.findViewById(R.id.view_recycler);
            recyclerView.setSpanCount(1);
            recyclerView.setOrientation(RecyclerView.HORIZONTAL);
        }
    }
}
