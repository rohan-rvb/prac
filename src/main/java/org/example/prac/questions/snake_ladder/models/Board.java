package org.example.prac.questions.snake_ladder.models;


import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> cells;
    private int size;

    public Board(int size) {
        this.cells = new ArrayList<>();
        for(int i=0;i<size;i++) {
        }
    }
}
