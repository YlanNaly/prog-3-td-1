package app.prog.controller.mapper;

import app.prog.controller.response.book.BookResponse;
import app.prog.controller.response.book.CreateBookResponse;
import app.prog.controller.response.book.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookRestMapper {
    private final AuthorService authorService;
    public BookResponse toRest(BookEntity domain) {
        AuthorEntity entity = authorService.getById(domain.getAuthor().getId());
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor().getName())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        return BookEntity.builder()
                .title(rest.getTitle())
                /*  .category(domain.getCategory())*/
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
      /*
        List<CategoryEntity> categoryEntities = repository.getById(String.valueOf(rest.getId())).getCategory();*/
        return BookEntity.builder()
                .id(rest.getId())
                /* .author(domain.getAuthor()*/
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
