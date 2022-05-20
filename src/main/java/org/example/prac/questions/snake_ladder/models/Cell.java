package org.example.prac.questions.snake_ladder.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cell {
    private Snake snake;
    private Ladder ladder;
}
