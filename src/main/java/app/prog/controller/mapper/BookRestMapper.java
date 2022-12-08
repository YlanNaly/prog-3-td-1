package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.model.Book;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class BookRestMapper {
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
    public Book toRestBook(PostBook domain) {
        return Book.builder()
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .pageNumber(0)
                .releaseDate(LocalDate.parse("2000-01-01"))
                .build();
    }

    public List<Book> toDomain(List<PostBook> list){
        return list.stream().map(this::toRestBook).toList();
    }

}
