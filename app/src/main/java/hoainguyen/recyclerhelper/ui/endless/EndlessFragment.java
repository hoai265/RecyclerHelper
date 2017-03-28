package hoainguyen.recyclerhelper.ui.endless;

import hoainguyen.lib.recyclerhelper.collection.CollectionFragment;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class EndlessFragment extends CollectionFragment {
    @Override
    protected void onMakeAdapters() {
        mRecyclerView.appendAdapter(new EndlessAdapter());
    }
}
