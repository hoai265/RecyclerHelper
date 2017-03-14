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
import hoainguyen.recyclerhelper.R;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class RecyclerViewFragment extends Fragment {
    protected XRecyclerView viewRecycler;
    protected MultiTypeRVAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_view_layout, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        viewRecycler = (XRecyclerView) rootView.findViewById(R.id.view_recycler);
        viewRecycler.relayout(2, RecyclerView.VERTICAL);
        adapter = new MultiTypeRVAdapter();
        viewRecycler.setAdapter(adapter);
    }
}
