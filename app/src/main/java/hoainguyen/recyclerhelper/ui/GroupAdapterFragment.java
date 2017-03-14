package hoainguyen.recyclerhelper.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hoainguyen.lib.recyclerhelper.recycler.XRecyclerView;
import hoainguyen.lib.recyclerhelper.recycler.adapter.MultiTypeRVAdapter;
import hoainguyen.lib.recyclerhelper.recycler.adapter.StackRecyclerAdapter;
import hoainguyen.lib.recyclerhelper.recycler.item.StaticRenderItem;
import hoainguyen.recyclerhelper.R;
import hoainguyen.recyclerhelper.data.dummy.DummyContent;
import hoainguyen.recyclerhelper.ui.items.HeaderRenderItem;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class GroupAdapterFragment extends Fragment {
    protected XRecyclerView viewRecycler;
    private StackRecyclerAdapter groupAdapter;
    private MultiTypeRVAdapter firstAdapter;
    private MultiTypeRVAdapter secondAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_group_adapter_layout, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        viewRecycler = (XRecyclerView) rootView.findViewById(R.id.view_recycler);
        viewRecycler.relayout(2, RecyclerView.VERTICAL);
        groupAdapter = new StackRecyclerAdapter();
        viewRecycler.setAdapter(groupAdapter);

        firstAdapter = new MultiTypeRVAdapter();

        secondAdapter = new MultiTypeRVAdapter();
        secondAdapter.append(new StaticRenderItem(R.layout.item_static_full_span_layout, true));
        secondAdapter.append(new StaticRenderItem(R.layout.item_static_full_span_layout, true));

        groupAdapter.appendAdapter(firstAdapter);
        groupAdapter.appendAdapter(secondAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        firstAdapter.append(new HeaderRenderItem());
        firstAdapter.append(DummyContent.getInstance().getDataRenderItemList());
    }
}
