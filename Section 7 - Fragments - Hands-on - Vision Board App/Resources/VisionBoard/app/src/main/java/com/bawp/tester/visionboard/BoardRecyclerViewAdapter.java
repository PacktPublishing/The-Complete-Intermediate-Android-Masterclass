package com.bawp.tester.visionboard;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawp.tester.visionboard.model.Board;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BoardRecyclerViewAdapter extends RecyclerView.Adapter<BoardRecyclerViewAdapter.ViewHolder> {
 private List<Board> boardList;
 private OnRowClickListener listener;

    public BoardRecyclerViewAdapter(List<Board> boardList) {
        Log.d("LALA", "BoardReclyclerViewAdapter: " + boardList.size());
        this.boardList = boardList;
    }

    public void setOnRowClickListener(OnRowClickListener listener) {
         this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.list_item_row, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.board = boardList.get(position);
        holder.boardName.setText(boardList.get(position).getName());
        holder.imageView.setImageResource(boardList.get(position).getImageUrl());


    }

    @Override
    public int getItemCount() {
        return boardList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        final View parentView;
        final TextView boardName;
        final ImageView imageView;

        Board board;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentView = itemView;
            boardName = itemView.findViewById(R.id.list_item_board);
            imageView = itemView.findViewById(R.id.board_item_image);

            parentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                         int position = getAdapterPosition();
                         if (position != RecyclerView.NO_POSITION) {
                             listener.onItemClick(parentView, position);
                         }
                    }

                }
            });
        }
    }

    public interface OnRowClickListener {
         void onItemClick(View itemView, int position);
    }
}
