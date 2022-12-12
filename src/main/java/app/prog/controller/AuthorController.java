package app.prog.controller;

import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.author.AuthorResponse;
import app.prog.controller.response.author.CreateAuthorResponse;
import app.prog.controller.response.author.UpdateAuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Data
@RestController
@Controller
@RequestMapping("/authors")
public class AuthorController {
  private final AuthorService authorService;
  private AuthorRestMapper mapper;
  @GetMapping
  public List<AuthorResponse> getAll(){
    return authorService.getAuthors().stream()
            .map(mapper::toRest)
            .toList();
  }
  @PostMapping
  public List<AuthorResponse> createAuthor(@RequestBody List<CreateAuthorResponse> createAuthorResponse){
    authorService.createAuthor(mapper.toDomainPost(createAuthorResponse)).stream()
            .map(mapper::toRest)
            .toList();
    return authorService.getAuthors().stream()
            .map(mapper::toRest)
            .toList();
  }

  @PutMapping
  public List<AuthorResponse> updateAuthor(@RequestBody List<UpdateAuthorResponse> updateAuthorResponse){
    authorService.createAuthor(mapper.toDomain(updateAuthorResponse)).stream()
            .map(mapper::toRest)
            .toList();
    return authorService.getAuthors().stream()
            .map(mapper::toRest)
            .toList();
  }

  @DeleteMapping("/{authorId}")
  public List<AuthorResponse> deleteAuthor(@RequestParam Integer id){
    authorService.deleteAuthor(id);
    return authorService.getAuthors().stream()
            .map(mapper::toRest)
            .toList();
  }
}
