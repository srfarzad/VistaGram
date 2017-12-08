package com.vistagram.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vistagram.BR;
import com.vistagram.R;
import com.vistagram.model.Post;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.POST;

/**
 * Created by Android on 12/8/2017.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private PostsAdapter() {}

    Context context;
    List<Post> postList;

    public PostsAdapter(Context context, List<Post> postList) {
        this.postList = postList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.posts_row, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        Post post=postList.get(position);
        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
   /*     @BindView(R.id.img_profile)
        ImageView img_profile;

        @BindView(R.id.txt_userName)
        TextView txt_userName;
        @BindView(R.id.img_post)ImageView img_post;
        @BindView(R.id.img_favorite)ImageView img_favorite;
        @BindView(R.id.img_comments)ImageView img_comments;
        @BindView(R.id.img_forward)ImageView img_forward;
        @BindView(R.id.img_bookmark)ImageView img_bookmark;

*/

        ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
        public void bind(Object post) {
            binding.setVariable(BR.post,post);
            binding.executePendingBindings();
        }
    }

}
