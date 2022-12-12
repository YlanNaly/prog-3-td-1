package app.prog.service;

import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Data
public class AuthorService {
    private final AuthorRepository repository;
    public List<AuthorEntity> getAuthors(){
      return repository.findAll();
    }

    public List<AuthorEntity> createAuthor(List<AuthorEntity> authorEntityList){
      return repository.saveAll(authorEntityList);
    }

    public List<AuthorEntity> updateAuthor(List<AuthorEntity> authorEntityList){
        return repository.saveAll(authorEntityList);
    }

    public AuthorEntity deleteAuthor(int authorId) {

        Optional<AuthorEntity> optional = repository.findById(authorId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new RuntimeException("BookEntity." + authorId + " not found");
        }
    }

}
