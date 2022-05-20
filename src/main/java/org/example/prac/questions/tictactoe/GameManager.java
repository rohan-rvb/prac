package org.example.prac.questions.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<List<Integer>> board = new ArrayList<>();

    public GameManager() {
        for(int i=0;i<3;i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<3;j++) {
                temp.add(0);
            }
            board.add(temp);
        }

    }
}
