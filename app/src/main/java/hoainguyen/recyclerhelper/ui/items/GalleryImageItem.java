package hoainguyen.recyclerhelper.ui.items;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import hoainguyen.lib.recyclerhelper.recycler.item.RecyclerViewRenderItem;
import hoainguyen.recyclerhelper.R;
import hoainguyen.recyclerhelper.data.model.GalleryImageModel;
import hoainguyen.recyclerhelper.utils.ScreenUtils;

/**
 * Created by hoainguyen on 3/9/17.
 */

public class GalleryImageItem extends RecyclerViewRenderItem<GalleryImageItem.GalleryImageViewHolder> {
    private static com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder PipelineDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
    private final GalleryImageModel mDataModel;

    public GalleryImageItem(GalleryImageModel galleryImageModel) {
        mDataModel = galleryImageModel;
    }

    @Override
    public GalleryImageViewHolder makeViewHolder(Context context) {
        return new GalleryImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_gallery_image_layout, null));
    }

    @Override
    public void bindViewHolder(GalleryImageViewHolder holder) {
        String imageUrl = mDataModel.getPath() == null ? mDataModel.getThumbnail() : mDataModel.getPath();
        Uri uri = Uri.parse("file://" + imageUrl);

        int size = ScreenUtils.getScreenWidth() / 3;
        ImageRequest request =
                ImageRequestBuilder.newBuilderWithSource(uri)
                        .setResizeOptions(new ResizeOptions(size, size))
                        .build();

        PipelineDraweeController controller =
                (PipelineDraweeController) PipelineDraweeControllerBuilder
                        .setOldController(holder.imgImage.getController())
                        .setImageRequest(request)
                        .build();
        holder.imgImage.setController(controller);
    }

    static class GalleryImageViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView imgImage;

        public GalleryImageViewHolder(View itemView) {
            super(itemView);
            imgImage = (SimpleDraweeView) itemView.findViewById(R.id.img_image);
        }
    }
}
