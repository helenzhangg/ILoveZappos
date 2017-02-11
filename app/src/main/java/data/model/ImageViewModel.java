package data.model;

/**
 * Created by helenZhang on 2/11/17.
 */

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class ImageViewModel {

    private String mImageUrl;

    public ImageViewModel(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getImageUrl() {
        // The URL will usually come from a model (i.e Profile)
        return mImageUrl;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(null)
                .into(view);
    }
}