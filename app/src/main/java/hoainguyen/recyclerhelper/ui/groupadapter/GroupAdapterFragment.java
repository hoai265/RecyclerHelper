package hoainguyen.recyclerhelper.ui.groupadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hoainguyen.lib.recyclerhelper.recycler.ExRecyclerView;
import hoainguyen.recyclerhelper.R;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class GroupAdapterFragment extends Fragment {
    protected ExRecyclerView viewRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_group_adapter_layout, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        viewRecycler = (ExRecyclerView) rootView.findViewById(R.id.view_recycler);
        viewRecycler.setOrientation(RecyclerView.VERTICAL);
        viewRecycler.setSpanCount(3);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewRecycler.appendAdapter(new FirstAdapter());
        viewRecycler.appendAdapter(new SecondAdapter());
        viewRecycler.appendAdapter(new GalleryAdapter(getActivity().getContentResolver()));
        viewRecycler.start();
    }
}
