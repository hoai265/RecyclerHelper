package hoainguyen.recyclerhelper.ui.gallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import hoainguyen.recyclerhelper.R;

public class ChooseImageActivity extends AppCompatActivity {

    private int numberOfImage;
    private List<GalleryImage> galleryImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_image);
        galleryImageList = new ArrayList<>();
    }
}
