package com.rosalyn.userhunter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rosalyn.userhunter.Model.UserResponse;
import com.rosalyn.userhunter.R;
import com.rosalyn.userhunter.databinding.UserLayoutBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<UserResponse> usersList;
    private LayoutInflater mInflater;

    public UserRecyclerViewAdapter(Context context, ArrayList<UserResponse> users) {
        this.mInflater = LayoutInflater.from(context);
        this.usersList = users;
    }

    /**
     * Creates new views
     * @param parent
     * @param viewType
     * @return viewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UserLayoutBinding userLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.user_layout, parent, false);

        return new ViewHolder(userLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data model based on position
        UserResponse user = usersList.get(position);

        holder.userLayoutBinding.tvFirstName.setText(user.getFirst_name());
        holder.userLayoutBinding.tvLastName.setText(user.getLast_name());
        holder.userLayoutBinding.tvEmail.setText(user.getEmail());

        Picasso.get()
                .load(user.getPhoto_url())
                .fit()
                .centerCrop()
                .placeholder(R.drawable.ic_user_placeholder)
                .error(R.drawable.ic_user_placeholder)
                .into(holder.userLayoutBinding.ivPhoto);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public UserLayoutBinding userLayoutBinding;

        public ViewHolder(UserLayoutBinding binding) {
            super(binding.getRoot());
            userLayoutBinding = binding;
        }
    }
}
