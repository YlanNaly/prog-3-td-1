package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.model.Book;
import app.prog.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class BookRestMapper {

    private final BookRepository repository;
    public BookResponse toRest(Book domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .hasAuthor(domain.hasAuthor())
                .build();
    }
    public BookResponse toRestBookResponse(Book domain) {
        return BookResponse.builder()
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .hasAuthor(domain.hasAuthor())
                .build();
    }
    public Book toRestBook(CreateBook domain) {
        return Book.builder()
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .pageNumber(0)
                .releaseDate(LocalDate.parse("2000-01-01"))
                .build();
    }
    public Book toChange(PutBook domain) {
        Book book =  repository.getById(domain.getId());
        return Book.builder()
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .pageNumber(book.getPageNumber())
                .releaseDate(book.getReleaseDate())
                .id(book.getId())
                .build();
    }
    public List<Book> toDomain(List<CreateBook> list){
        return list.stream().map(this::toRestBook).toList();
    }

    public List<Book> toDomainChange(List<PutBook> list){
        return list.stream().map(this::toChange).toList();
    }
}
