package com.bawp.tester.visionboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawp.tester.visionboard.model.Board;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class BoardListFragment extends Fragment {
    private ArrayList<Board> boardArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BoardRecyclerViewAdapter boardRecyclerViewAdapter = new BoardRecyclerViewAdapter(boardArrayList);



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_board_list, container, false);

        recyclerView = view.findViewById(R.id.list);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final Context context = view.getContext();
//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(boardRecyclerViewAdapter);

    }

    void setBoards(final List<Board> boardList) {
        for (Board board : boardList) {
             if (!boardArrayList.contains(board)) {
                  boardArrayList.add(board);
                  boardRecyclerViewAdapter.notifyItemInserted(boardArrayList.indexOf(board));
             }
        }

        boardRecyclerViewAdapter.setOnRowClickListener(new BoardRecyclerViewAdapter.OnRowClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                Board board = boardList.get(position);

                Intent i = new Intent(getContext(), BoardDetailActivity.class);
                i.putExtra("board", board);

                startActivity(i);


//                Log.d("S", "onItemClick: " + board.getName());

            }
        });

    }
}
