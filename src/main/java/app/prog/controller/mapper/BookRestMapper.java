package app.prog.controller.mapper;

import app.prog.controller.response.book.BookResponse;
import app.prog.controller.response.book.CreateBookResponse;
import app.prog.controller.response.book.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.model.CategoryEntity;
import app.prog.repository.BookRepository;
import app.prog.repository.CategoryRepository;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class BookRestMapper {
    private final AuthorService service;
    private final BookRepository repository;
    public BookResponse toRest(BookEntity domain) {
        String author = service.getByName(domain.getAuthor().getName()).toString();
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(author)
              /*  .category(domain.getCategory())*/
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        AuthorEntity author = service.getByName(rest.getAuthor());
        return BookEntity.builder()
                .author(author)
                .title(rest.getTitle())
                /*  .category(domain.getCategory())*/

                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        AuthorEntity author = service.getByName(rest.getAuthor());/*
        List<CategoryEntity> categoryEntities = repository.getById(String.valueOf(rest.getId())).getCategory();*/
        return BookEntity.builder()
                .id(rest.getId())
                .author(author)
                /*  .category(domain.getCategory())*/

                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
