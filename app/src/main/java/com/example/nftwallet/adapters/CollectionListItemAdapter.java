package com.example.nftwallet.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nftwallet.R;
import com.example.nftwallet.database.Entities.CollectionWithNFT;

import java.util.List;
/*
public class CollectionListItemAdapter extends BaseAdapter {
    private Context context;
    private List<CollectionWithNFT> collectionWithNFTList;

    private LayoutInflater inflater;

    public CollectionListItemAdapter(Context context, List<CollectionWithNFT> collectionWithNFTList) {
        this.context = context;
        this.collectionWithNFTList = collectionWithNFTList;
    }

    @Override
    public int getCount() {
        return collectionWithNFTList.size();
    }

    @Override
    public Object getItem(int position) {
        return collectionWithNFTList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return collectionWithNFTList.get(position).collection.id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_main, null);
        TextView nameTextView = convertView.findViewById(R.id.collection_list_item_name);
        TextView sizeTextView = convertView.findViewById(R.id.collection_list_item_size);
        nameTextView.setText(collectionWithNFTList.get(position).collection.name);
        sizeTextView.setText(collectionWithNFTList.get(position).nfts.size());
        return convertView;
    }
}
*/
public class CollectionListItemAdapter extends RecyclerView.Adapter<CollectionListItemAdapter.CollectionListItemViewHolder> {
    private Context context;
    public CollectionListItemAdapter(Context context) {}
    private List<CollectionWithNFT> collections;

    public CollectionListItemAdapter(List<CollectionWithNFT> collections) {
        this.collections = collections;
    }

    @NonNull
    @Override
    public CollectionListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.collection_list_item, parent, false);
        return new CollectionListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionListItemViewHolder holder, int position) {
        CollectionWithNFT collection = collections.get(position);

        holder.bind(collection);
    }

    @Override
    public int getItemCount() {
        return collections.size();
    }

    public class CollectionListItemViewHolder extends RecyclerView.ViewHolder {
        private final View itemView;

        public CollectionListItemViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void bind(CollectionWithNFT collection) {
            System.out.println("entering bind");

            TextView nameTextView = itemView.findViewById(R.id.collection_list_item_name);
            TextView sizeTextView = itemView.findViewById(R.id.collection_list_item_size);

            nameTextView.setText(collection.collection.name);
            sizeTextView.setText(((Integer)collection.nfts.size()).toString());
;
        }
    }

}

