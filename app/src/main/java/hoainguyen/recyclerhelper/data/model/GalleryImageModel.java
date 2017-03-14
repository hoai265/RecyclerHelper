package hoainguyen.recyclerhelper.data.model;

/**
 * Created by hoainguyen on 3/9/17.
 */

public class GalleryImageModel {
    private final long id;
    private final String path;
    private final String thumbnail;

    public GalleryImageModel(long id, String path, String thumbnail) {
        this.id = id;
        this.path = path;
        this.thumbnail = thumbnail;
    }

    public long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
