package org.example.prac.questions.snake_ladder.models;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Ladder {
    private int start;
    private int end;
}
