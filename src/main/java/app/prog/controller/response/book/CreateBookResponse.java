package app.prog.controller.response.book;

import app.prog.model.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class CreateBookResponse {
    private String author;
    private String title;
}
