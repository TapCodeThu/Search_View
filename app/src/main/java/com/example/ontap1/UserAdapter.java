package com.example.ontap1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> implements Filterable {
    private int lastPosition = -1;
    private List<User> mListUser;
    private List<User> mListUserOld;


    public UserAdapter(List<User> list) {
        this.mListUser = list;
        this.mListUserOld = list;

    }

    public void setData(List<User> list) {
        mListUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_user, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = mListUser.get(position);
        holder.HinhAvarta.setImageResource(user.getImageAvarta());
        holder.NameUser.setText(user.getNameUser());
        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return mListUser.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString().trim();
                if (strSearch.isEmpty()) {
                    mListUser = mListUserOld;
                } else {
                    List<User> userList = new ArrayList<>();
                    for (User user : mListUserOld) {
                        if (user.getNameUser().toLowerCase().contains(strSearch.toLowerCase())) {
                            userList.add(user);
                        }
                    }
                    mListUser = userList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mListUser;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mListUser = (List<User>) results.values;
                notifyDataSetChanged();

            }
        };
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView HinhAvarta;
        TextView NameUser;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            HinhAvarta = itemView.findViewById(R.id.id_circle_avarta);
            NameUser = itemView.findViewById(R.id.id_ten_user);
        }
    }

    private void setAnimation(View viewanimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils
                    .loadAnimation(viewanimate.getContext(), R.anim.down_to_up);
            viewanimate.setAnimation(animation);
        }
        lastPosition = position;

    }
}
