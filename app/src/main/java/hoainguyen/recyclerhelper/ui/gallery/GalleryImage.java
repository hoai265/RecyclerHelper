package hoainguyen.recyclerhelper.ui.gallery;

/**
 * Created by hoainguyen on 3/9/17.
 */

public class GalleryImage {
    private final long id;
    private final String path;
    private final String thumbnail;

    public GalleryImage(long id, String path, String thumbnail) {
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
