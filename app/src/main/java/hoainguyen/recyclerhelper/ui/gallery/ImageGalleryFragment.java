package hoainguyen.recyclerhelper.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;

import hoainguyen.lib.recyclerhelper.collection.CollectionFragment;
import hoainguyen.recyclerhelper.ui.groupadapter.GalleryAdapter;

/**
 * Created by hoainguyen on 3/9/17.
 */

public class ImageGalleryFragment extends CollectionFragment {
    @Override
    protected void onMakeAdapters() {
        mRecyclerView.appendAdapter(new GalleryAdapter(getActivity().getContentResolver()));
    }

    @Override
    public void onCreateCustomView(LayoutInflater inflater, View rootView) {
        super.onCreateCustomView(inflater, rootView);
        mRecyclerView.setSpanCount(3);
    }
}
