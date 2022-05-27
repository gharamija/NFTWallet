package com.example.nftwallet.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nftwallet.NFTViewActivity;
import com.example.nftwallet.R;
import com.example.nftwallet.data.ImageLoadTask;
import com.example.nftwallet.database.Entities.Collection;
import com.example.nftwallet.database.Entities.CollectionWithNFT;
import com.example.nftwallet.database.Entities.NFT;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.List;
import java.util.Locale;

public class NFTListItemAdapter extends RecyclerView.Adapter<NFTListItemAdapter.NFTListItemViewHolder> {
    private Context context;
    private List<NFT> nfts;
    private Collection collection;

    public NFTListItemAdapter(Context context, List<NFT> nfts,Collection collection) {
        this.context = context;
        this.nfts = nfts;
        this.collection = collection;
    }

    @NonNull
    @Override
    public NFTListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nft_list_item, parent, false);

        System.out.println("\n\nU CREATE VIEW HOLDER\n\n");
        return new NFTListItemAdapter.NFTListItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NFTListItemViewHolder holder, int position) {
        NFT nft = nfts.get(position);

        holder.bind(nft);
    }

    @Override
    public int getItemCount() {
        return nfts.size();
    }

    public class NFTListItemViewHolder extends RecyclerView.ViewHolder {
        private final View itemView;

        public NFTListItemViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public void bind(NFT nft) {

            NFTListItemOnClickListener listener = new NFTListItemOnClickListener(context, nft);

            itemView.setOnClickListener(listener);
            ImageView imageView = itemView.findViewById(R.id.nft_list_item_image);
            TextView nameTextView = itemView.findViewById(R.id.nft_list_item_name);
            TextView priceTextView = itemView.findViewById(R.id.nft_list_item_price);

            nameTextView.setText(nft.name);
            priceTextView.setText(String.format(Locale.US, "%.4f ETH", nft.price));

            imageView.setImageBitmap(BitmapFactory.decodeFile(nft.imageUrl));

        }

        private class NFTListItemOnClickListener implements View.OnClickListener {
            public Context context;
            public NFT nft;
            public NFTListItemOnClickListener(Context context, NFT nft) {
                this.context = context;
                this.nft = nft;
            }

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NFTViewActivity.class);

                intent.putExtra("id",nft.id);
                intent.putExtra("name",nft.name);
                intent.putExtra("description", nft.description);
                intent.putExtra("price",nft.price);
                intent.putExtra("image",nft.imageUrl);


                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }

    }
}


