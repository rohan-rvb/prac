package org.example.prac.questions.snake_ladder.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private String id;
    private String name;
}
