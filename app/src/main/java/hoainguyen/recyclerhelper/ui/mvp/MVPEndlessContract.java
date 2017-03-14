package hoainguyen.recyclerhelper.ui.mvp;

import hoainguyen.lib.recyclerhelper.collection.mvp.BaseCollectionContract;
import hoainguyen.recyclerhelper.data.model.DataModel;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class MVPEndlessContract {
    public interface MVPEndlessView extends BaseCollectionContract.BaseCollectionView {

    }

    public interface Presenter extends BaseCollectionContract.Presenter<MVPEndlessView, DataModel> {

    }
}
