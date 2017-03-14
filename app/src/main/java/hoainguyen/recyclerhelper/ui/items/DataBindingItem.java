package hoainguyen.recyclerhelper.ui.items;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;

import hoainguyen.lib.recyclerhelper.recycler.item.binding.BindingRecyclerViewRenderItem;
import hoainguyen.lib.recyclerhelper.recycler.item.binding.BindingViewHolder;
import hoainguyen.recyclerhelper.R;
import hoainguyen.recyclerhelper.data.model.DataModel;
import hoainguyen.recyclerhelper.databinding.ItemDataBindingLayoutBinding;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class DataBindingItem extends BindingRecyclerViewRenderItem<DataBindingItem.DataBindingViewHolder> {
    private DataModel mDataModel;

    public DataBindingItem(DataModel dataModel) {
        mDataModel = dataModel;
    }

    @Override
    public DataBindingViewHolder makeViewHolder(Context context) {
        ItemDataBindingLayoutBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.item_data_binding_layout, null, false);

        return new DataBindingViewHolder(dataBinding);
    }

    @Override
    public void bindViewHolder(final DataBindingViewHolder holder) {
        holder.bind(mDataModel, new DataBindingItemClickListener() {
            @Override
            public void onDataBindingItemClick(DataModel dataModel) {
                Snackbar.make(holder.itemView, "DataBindingItem " + dataModel.getName() + " item clicked!", 2000).show();
            }
        });
    }

    static class DataBindingViewHolder extends BindingViewHolder<ItemDataBindingLayoutBinding> {
        public DataBindingViewHolder(ItemDataBindingLayoutBinding binding) {
            super(binding);
        }

        public void bind(DataModel data, DataBindingItemClickListener listener) {
            getBinding().setDataModel(data);
            getBinding().setOnClickListener(listener);
        }
    }

    public interface DataBindingItemClickListener {
        void onDataBindingItemClick(DataModel dataModel);
    }
}
