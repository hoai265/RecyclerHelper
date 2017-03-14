package hoainguyen.recyclerhelper;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import hoainguyen.recyclerhelper.utils.ScreenUtils;

/**
 * Created by hoainguyen on 3/9/17.
 */

public class RecyclerHelperApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ScreenUtils.getScreenSize(getApplicationContext());
    }
}
