package hoainguyen.recyclerhelper.ui.items;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import hoainguyen.lib.recyclerhelper.recycler.item.RecyclerViewRenderItem;
import hoainguyen.recyclerhelper.R;
import hoainguyen.recyclerhelper.data.dummy.DummyContent;
import hoainguyen.recyclerhelper.data.model.DataModel;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class DataRenderItem extends RecyclerViewRenderItem<DataRenderItem.DataViewHolder> {
    private final DataModel mData;

    public DataRenderItem(DataModel data) {
        mData = data;
    }

    @Override
    public DataViewHolder makeViewHolder(Context context) {
        return new DataViewHolder(LayoutInflater.from(context).inflate(R.layout.item_data_layout, null));
    }

    @Override
    public void bindViewHolder(DataViewHolder holder) {
        holder.tvData.setText(mData.getValue());
        holder.tvName.setText(mData.getName());
        holder.viewItemContainer.setBackgroundResource(DummyContent.getInstance().getRandomDataBackgroundResource());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "DataRenderItem " + mData.getName() + " clicked!", 2000).show();
            }
        });
    }

    static class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvData;
        private LinearLayout viewItemContainer;

        public DataViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvData = (TextView) itemView.findViewById(R.id.tv_data);
            viewItemContainer = (LinearLayout) itemView.findViewById(R.id.view_item_container);
        }
    }
}
