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
import com.example.nftwallet.database.Entities.CollectionWithNFT;
import com.example.nftwallet.database.Entities.NFT;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.List;
import java.util.Locale;

public class NFTListItemAdapter extends RecyclerView.Adapter<NFTListItemAdapter.NFTListItemViewHolder> {
    private Context context;
    private List<NFT> nfts;

    public NFTListItemAdapter(Context context, List<NFT> nfts) {
        this.context = context;
        this.nfts = nfts;

        System.out.println(nfts);
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
            System.out.println("entering bind");

            NFTListItemOnClickListener listener = new NFTListItemOnClickListener(context, nft.name);

            itemView.setOnClickListener(listener);
            ImageView imageView = itemView.findViewById(R.id.nft_list_item_image);
            TextView nameTextView = itemView.findViewById(R.id.nft_list_item_name);
            TextView priceTextView = itemView.findViewById(R.id.nft_list_item_price);

            nameTextView.setText(nft.name);
            priceTextView.setText(String.format(Locale.US, "%.4f ETH", nft.price));

            new ImageLoadTask(nft.imageUrl, imageView).execute();

        }

        private class NFTListItemOnClickListener implements View.OnClickListener {
            public Context context;
            public String name;
            public NFTListItemOnClickListener(Context context, String name) {
                this.context = context;
                this.name = name;
            }

            @Override
            public void onClick(View v) {
                Log.d("JEBOTE", name);
                Intent intent = new Intent(context, NFTViewActivity.class);
                Bundle extras = new Bundle();

                extras.putString("name", name);
                intent.putExtras(extras);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }

    }
}


