package hoainguyen.recyclerhelper.ui.items;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import hoainguyen.lib.recyclerhelper.recycler.item.RecyclerViewRenderItem;
import hoainguyen.recyclerhelper.R;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class HeaderRenderItem extends RecyclerViewRenderItem<HeaderRenderItem.HeaderViewHolder> {

    @Override
    public HeaderViewHolder makeViewHolder(Context context) {
        return new HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.item_header_layout, null));
    }

    @Override
    public void bindViewHolder(HeaderViewHolder holder) {

    }

    @Override
    public boolean isFullSpan() {
        return true;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
