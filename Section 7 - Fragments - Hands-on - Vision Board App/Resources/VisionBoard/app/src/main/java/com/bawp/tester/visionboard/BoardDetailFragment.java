package com.bawp.tester.visionboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawp.tester.visionboard.model.Board;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BoardDetailFragment extends Fragment {
    private Board board;

    static BoardDetailFragment newInstance(Board board) {
         BoardDetailFragment fragment = new BoardDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable("board", board);
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
             board = (Board) getArguments().getSerializable("board");

        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView title = view.findViewById(R.id.board_name);
        TextView description = view.findViewById(R.id.board_description);

        title.setText(board.getName());
        description.setText(board.getDescription());
    }
}
