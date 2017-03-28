package hoainguyen.recyclerhelper.ui.endless;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.lib.recyclerhelper.recycler.ExpandableDataSectionRVAdapter;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;
import hoainguyen.lib.recyclerhelper.recycler.model.PaginationModel;
import hoainguyen.recyclerhelper.data.dummy.DummyContent;
import hoainguyen.recyclerhelper.data.model.DataModel;
import hoainguyen.recyclerhelper.ui.items.DataRenderItem;

/**
 * Created by hoainguyen on 3/29/17.
 */

public class EndlessAdapter extends ExpandableDataSectionRVAdapter<DataModel> {
    @Override
    public void onStartLoadData() {
        refreshDataCollection(DummyContent.getInstance().getDataModelCollection());
    }

    @Override
    public void onExpandDown(PaginationModel pagination) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoadExpandDownDataCompleted();
                if (mDataCollection.getData().length < 100) {
                    appendDataCollection(DummyContent.getInstance().getDataModelCollection());
                } else {
                    appendDataCollection(DummyContent.getInstance().getEndDataModelCollection());
                }
            }
        }, 500);
    }

    @Override
    public void onExpandUp(PaginationModel paginationModel) {

    }

    @Override
    public List<RenderItem> makeRenderItem(DataModel[] data) {
        List<RenderItem> renderItemList = new ArrayList<>();
        for (DataModel dataModel : data) {
            renderItemList.add(new DataRenderItem(dataModel));
        }
        return renderItemList;
    }
}
