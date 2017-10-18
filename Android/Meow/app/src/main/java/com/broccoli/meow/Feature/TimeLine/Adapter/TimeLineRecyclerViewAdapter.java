package com.broccoli.meow.Feature.TimeLine.Adapter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.broccoli.meow.Feature.TimeLine.Activity.TimeLineActivity;
import com.broccoli.meow.Feature.TimeLine.Model.TimeLineEntity;
import com.broccoli.meow.R;
import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Broccoli on 2017/10/17.
 */

public class TimeLineRecyclerViewAdapter extends RecyclerView.Adapter<TimeLineRecyclerViewAdapter.NormalTextViewHolder> {

    private ArrayList<TimeLineEntity> mData;

    private Context mContext;

    public TimeLineRecyclerViewAdapter(ArrayList<TimeLineEntity> mData, Context context) {
        this.mData = mData;
        this.mContext = context;
    }

    public void updateData(ArrayList<TimeLineEntity> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_line_item,parent, false);

        NormalTextViewHolder normalTextViewHolder = new NormalTextViewHolder(v);

        return normalTextViewHolder;
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {
        System.out.println("图片链接: " + mData.get(position).getGifURL());
        Uri uri = Uri.parse(mData.get(position).getGifURL());
        Glide.with(mContext).load(mData.get(position).getGifURL()).into(holder.mImageView);

//        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
//            @Override
//            public void onFinalImageSet(
//                    String id,
//                    @Nullable ImageInfo imageInfo,
//                    @NonNull Animatable anim) {
//                System.out.println("下载完成了~~~~~ anim: imageInfo: " + anim + imageInfo);
//                if (anim != null) {
//                    // 其他控制逻辑
//                    anim.start();
//                }
//            }
//        };
//
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setUri(uri)
//                .setControllerListener(controllerListener)
//                // 其他设置（如果有的话）
//                .build();
//        holder.mImageView.setController(controller);

        //获得布局参数
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();

        System.out.println("第" + position + "行");
        WindowManager wm = (WindowManager) mContext
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        System.out.println("宽度: " + outMetrics.widthPixels);

        lp.height= position * 100;

        double aspectRatio = mData.get(position).getWidth() / mData.get(position).getHeight();

        lp.height = (int) ((outMetrics.widthPixels - 20) / aspectRatio);

        //设置参数，使得每个子view的高度都不相同
        holder.itemView.setLayoutParams(lp);

        Random random = new Random();
        int ranColor = 0xff000000 | random.nextInt(0x00ffffff);
        holder.mImageView.setBackgroundColor(ranColor);

//        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
//                .build();
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//                .setImageRequest(request)
//                .setAutoPlayAnimations(true)
//                .build();
//        holder.mImageView.setController(controller);
    }



    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public class NormalTextViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView mImageView;

        public NormalTextViewHolder(View itemView) {
            super(itemView);
            mImageView = (SimpleDraweeView) itemView.findViewById(R.id.image);
        }
    }
}