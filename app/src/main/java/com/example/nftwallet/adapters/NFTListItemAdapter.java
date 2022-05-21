package com.example.nftwallet.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nftwallet.R;
import com.example.nftwallet.database.Entities.CollectionWithNFT;
import com.example.nftwallet.database.Entities.NFT;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Locale;

public class NFTListItemAdapter extends RecyclerView.Adapter<NFTListItemAdapter.NFTListItemViewHolder> {
    private Context context;
    private List<NFT> nfts;

    public NFTListItemAdapter(List<NFT> nfts) {
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

            ImageView imageView = itemView.findViewById(R.id.nft_list_item_image);
            TextView nameTextView = itemView.findViewById(R.id.nft_list_item_name);
            TextView priceTextView = itemView.findViewById(R.id.nft_list_item_price);

            nameTextView.setText(nft.name);
            priceTextView.setText(String.format(Locale.US, "%.4f ETH", nft.price));
//            imageView.setImageBitmap(); // TODO
        }
    }
}


