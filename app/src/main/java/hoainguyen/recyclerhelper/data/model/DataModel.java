package hoainguyen.recyclerhelper.data.model;

/**
 * Created by hoainguyen on 3/7/17.
 */

public class DataModel {
    String name;
    String value;

    public DataModel(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
