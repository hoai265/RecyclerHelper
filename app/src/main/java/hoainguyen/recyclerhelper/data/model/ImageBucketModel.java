package hoainguyen.recyclerhelper.data.model;

import hoainguyen.recyclerhelper.ui.gallery.GalleryImage;

/**
 * Created by hoainguyen on 3/10/17.
 */

public class ImageBucketModel {

    int id;
    String name;
    GalleryImage[] images;

    public ImageBucketModel(int bucketId, String bucketName) {
        id = bucketId;
        name = bucketName;
    }
}
