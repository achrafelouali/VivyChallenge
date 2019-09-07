package com.vivy.challenge.mvp.ui.doctors;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.vivy.challenge.mvp.R;
import com.vivy.challenge.mvp.data.network.ApiEndPoint;
import com.vivy.challenge.mvp.data.network.model.DoctorResponse;
import com.vivy.challenge.mvp.ui.base.BaseViewHolder;
import com.vivy.challenge.mvp.utils.AppConstants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DoctorAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;


    private List<DoctorResponse.Doctor> mDoctorResponseList;

    private DoctorPresenter mPresenter;

    public DoctorAdapter(List<DoctorResponse.Doctor> DoctorResponseList, DoctorPresenter presenter) {
        mDoctorResponseList = DoctorResponseList;
        mPresenter = presenter;

    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor_view, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mDoctorResponseList != null && mDoctorResponseList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mDoctorResponseList != null && mDoctorResponseList.size() > 0) {
            return mDoctorResponseList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<DoctorResponse.Doctor> DoctorList) {
        mDoctorResponseList.addAll(DoctorList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mDoctorResponseList.clear();
        notifyDataSetChanged();
    }

    public interface Callback {
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.place_image_view)
        ImageView placeImageView;

        @BindView(R.id.name_text_view)
        TextView nameTextView;

        @BindView(R.id.address_text_view)
        TextView addressTextView;

        @BindView(R.id.pb_loading)
        ProgressBar photoProgressBar;

        @BindView(R.id.photo_container)
        RelativeLayout photoContainer;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            placeImageView.setImageDrawable(null);
            nameTextView.setText("");
            addressTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final DoctorResponse.Doctor Doctor = mDoctorResponseList.get(position);

            if (Doctor.getPhotoId() != null) {

                photoContainer.setVisibility(View.VISIBLE);
                GlideUrl glideUrl = new GlideUrl("" + ApiEndPoint.ENDPOINT_DOCTOR_PHOTO
                        + Doctor.getId()
                        + ApiEndPoint.KEYS_PROFILEPICTURES, new LazyHeaders.Builder()
                        .addHeader(AppConstants.AUTHORIZATION, AppConstants.AUTHORIZATION_TYPE_BEARER + " " + mPresenter.getDataManager().getAccessToken())
                        .build());

                photoProgressBar.setVisibility(View.VISIBLE);
                Glide.with(itemView.getContext())
                        .load(glideUrl)
                        .listener(new RequestListener<GlideUrl, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, GlideUrl model, Target<GlideDrawable> target, boolean isFirstResource) {
                                photoProgressBar.setVisibility(View.GONE);
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, GlideUrl model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                photoProgressBar.setVisibility(View.GONE);
                                return false;
                            }
                        })
                        .centerCrop()
                        .into(placeImageView);

            } else {
                photoContainer.setVisibility(View.GONE);
            }

            if (Doctor.getName() != null) {
                nameTextView.setText(Doctor.getName());
            }

            if (Doctor.getAddress() != null) {
                addressTextView.setText(Doctor.getAddress());
            }


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {


        @BindView(R.id.tv_message)
        TextView messageTextView;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

    }
}
