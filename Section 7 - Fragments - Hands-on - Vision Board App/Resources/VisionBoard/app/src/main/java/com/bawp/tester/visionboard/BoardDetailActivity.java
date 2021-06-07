package com.bawp.tester.visionboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.bawp.tester.visionboard.model.Board;

public class BoardDetailActivity extends AppCompatActivity {
    BoardDetailFragment boardDetailFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_detail);

        Board board = (Board) getIntent().getSerializableExtra("board");
        if (savedInstanceState == null) {
             boardDetailFragment = BoardDetailFragment.newInstance(board);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_detail_container, boardDetailFragment);
            ft.commit();
        }

    }
}
