package hoainguyen.recyclerhelper.ui.mvp;

import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.lib.recyclerhelper.collection.mvp.BaseCollectionPresenter;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;
import hoainguyen.recyclerhelper.data.dummy.DummyContent;
import hoainguyen.recyclerhelper.data.model.DataModel;
import hoainguyen.recyclerhelper.ui.items.DataRenderItem;

/**
 * Created by hoainguyen on 3/7/17.
 */
public class MVPEndlessDataPresenter extends BaseCollectionPresenter<MVPEndlessContract.MVPEndlessView, DataModel> implements MVPEndlessContract.Presenter {
    @Override
    public void onLoadCollectionData() {
        refreshDataCollection(DummyContent.getInstance().getDataModelCollection());
    }

    @Override
    public void onLoadMore(String nextUrl) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                onLoadMoreCompleted();
                if (mDataCollection.getData().length < 100) {
                    appendDataCollection(DummyContent.getInstance().getDataModelCollection());
                } else {
                    appendDataCollection(DummyContent.getInstance().getEndDataModelCollection());
                }
            }
        }, 500);
    }

    @Override
    public void onLoadPrevious(String previousUrl) {

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