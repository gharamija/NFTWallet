package com.example.nftwallet.NFTview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nftwallet.R;
import com.google.android.material.appbar.MaterialToolbar;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.ArrayList;
import java.util.List;

public class NFTviewActivity extends AppCompatActivity {

    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context,  NFTviewActivity.class);
    }


    private MaterialToolbar toolbar;
    private ImageView nftImage;
    private TextView nftName;
    private TextView nftPrice;
    private TextView nftDescription;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.);
        toolbar = findViewById(R.id.layout_button_id);
        nftImage = findViewById(R.id.nft_image);
        nftName = findViewById(R.id.group_tool_selection);
        nftPrice.setNavigationOnClickListener(v -> finish());
        nftDescription.setOnMenuItemClickListener(item ->{
            final int ID = item.getItemId();
            if(ID == R.id.action_undo){
                undo();
                return true;
            }else if (ID == R.id.action_redo){
                redo();
                return true;
            }
            return false;
        });

        drawingView.setOnTouchListener((v,event) -> {
            if(event.getAction() == MotionEvent.ACTION_DOWN){
                state.down(event.getX(),event.getY());
                return true;
            }else if (event.getAction() == MotionEvent.ACTION_MOVE){
                state.move(event.getX(),event.getY());
                return true;
            }else if (event.getAction() == MotionEvent.ACTION_UP){
                state.up(event.getX(),event.getY());
                return true;
            }
            return false;
        });
        groupToolSelection.addOnButtonCheckedListener((button,id,isChecked)->{
            if (!isChecked){
                return;
            }
            if (id == R.id.button_tool_line){
                state = new LinesState();
            }
            else if (id ==R.id.button_tool_line){
                state = new CircleState();
            }
        });
        groupToolSelection.check(R.id.button_tool_line);
        setDrawingListener(drawingView);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onDestroy() {
        super.onDestroy();
        groupToolSelection = null;
        //Memory leak..
        drawingView.setOnTouchListener((null));
        drawingView = null;
        toolbar.setNavigationOnClickListener(null);
        toolbar = null;
    }





}
