package hoainguyen.recyclerhelper.data.dummy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hoainguyen.lib.recyclerhelper.recycler.model.CollectionDataModel;
import hoainguyen.lib.recyclerhelper.recycler.model.PaginationModel;
import hoainguyen.lib.recyclerhelper.recycler.item.RenderItem;
import hoainguyen.recyclerhelper.R;
import hoainguyen.recyclerhelper.data.model.DataModel;
import hoainguyen.recyclerhelper.ui.items.DataRenderItem;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class DummyContent {
    private static DummyContent mInstance;
    private static List<Integer> mListBackgroundResource;

    static {
        mListBackgroundResource = new ArrayList<>();
        mListBackgroundResource.add(R.color.color_1);
        mListBackgroundResource.add(R.color.color_2);
        mListBackgroundResource.add(R.color.color_3);
        mListBackgroundResource.add(R.color.color_4);
        mListBackgroundResource.add(R.color.color_5);
        mListBackgroundResource.add(R.color.color_6);
        mListBackgroundResource.add(R.color.color_7);
        mListBackgroundResource.add(R.color.color_8);
        mListBackgroundResource.add(R.color.color_9);
        mListBackgroundResource.add(R.color.color_10);
        mListBackgroundResource.add(R.color.color_11);
        mListBackgroundResource.add(R.color.color_12);
        mListBackgroundResource.add(R.color.color_13);
        mListBackgroundResource.add(R.color.color_14);
        mListBackgroundResource.add(R.color.color_15);
    }

    private DummyContent() {

    }

    public static DummyContent getInstance() {
        if (mInstance == null)
            mInstance = new DummyContent();
        return mInstance;
    }

    public int getRandomDataBackgroundResource() {
        int pos = nextInt(0, mListBackgroundResource.size() - 1);
        return mListBackgroundResource.get(pos);
    }

    private int nextInt(int min, int max) {
        Random random = new Random();
        if (min >= max)
            throw new IllegalArgumentException();
        return random.nextInt(max - min + 1) + min;
    }

    public List<RenderItem> getDataRenderItemList() {
        List<RenderItem> renderItemList = new ArrayList<>();
        renderItemList.add(new DataRenderItem(new DataModel("COD", "20")));
        renderItemList.add(new DataRenderItem(new DataModel("DO", "25")));
        renderItemList.add(new DataRenderItem(new DataModel("PH", "7")));
        renderItemList.add(new DataRenderItem(new DataModel("TSS", "20")));
        return renderItemList;
    }

    public CollectionDataModel<DataModel> getDataModelCollection() {
        DataModel[] dataArray = new DataModel[10];
        dataArray[0] = new DataModel("A", "1.0");
        dataArray[1] = new DataModel("B", "2.0");
        dataArray[2] = new DataModel("C", "3.0");
        dataArray[3] = new DataModel("D", "4.0");
        dataArray[4] = new DataModel("E", "5.0");
        dataArray[5] = new DataModel("F", "6.0");
        dataArray[6] = new DataModel("G", "7.0");
        dataArray[7] = new DataModel("H", "8.0");
        dataArray[8] = new DataModel("I", "9.0");
        dataArray[9] = new DataModel("J", "10.0");
        return new CollectionDataModel(dataArray, new PaginationModel("", "mockNextUrl"));
    }

    public CollectionDataModel<DataModel> getEndDataModelCollection() {
        DataModel[] dataArray = new DataModel[10];
        dataArray[0] = new DataModel("A", "1.0");
        dataArray[1] = new DataModel("B", "2.0");
        dataArray[2] = new DataModel("C", "3.0");
        dataArray[3] = new DataModel("D", "4.0");
        dataArray[4] = new DataModel("E", "5.0");
        dataArray[5] = new DataModel("F", "6.0");
        dataArray[6] = new DataModel("G", "7.0");
        dataArray[7] = new DataModel("H", "8.0");
        dataArray[8] = new DataModel("I", "9.0");
        dataArray[9] = new DataModel("J", "10.0");
        return new CollectionDataModel(dataArray, new PaginationModel("", ""));
    }
}
