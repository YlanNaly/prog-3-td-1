package app.prog.service;

import app.prog.model.AuthorEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Data
public class AuthorService {
    private final AuthorRepository repository;

    public List<AuthorEntity> getAuthors(int pageNumber, int pageSize) {
        Pageable request = PageRequest.of(pageNumber, pageSize, Sort.Direction.DESC, "birthDate");
        return repository.findAll(request).toList();
    }

    public List<AuthorEntity> createAuthor(List<AuthorEntity> authorEntityList) {
        return repository.saveAll(authorEntityList);
    }

    public List<AuthorEntity> updateAuthor(List<AuthorEntity> authorEntityList) {
        return repository.saveAll(authorEntityList);
    }

    public AuthorEntity deleteAuthor(int authorId) {

        Optional<AuthorEntity> optional = repository.findById(authorId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "AuthorId " + authorId + " not found");
        }
    }

    public AuthorEntity getById(int id) {
        return repository.getById(id);
    }
}