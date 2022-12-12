package app.prog.controller.mapper;

import app.prog.controller.response.author.AuthorResponse;
import app.prog.controller.response.author.CreateAuthorResponse;
import app.prog.controller.response.author.UpdateAuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Data
@Component
@Builder
public class AuthorRestMapper {
  private final AuthorRepository repository;

  public AuthorResponse toRest(AuthorEntity rest) {
    return AuthorResponse.builder()
            .id(rest.getId())
            .hasParticularity(rest.hasParticularity())
            .name(rest.getName())
            .particularity(rest.getParticularity())
            .build();
  }
  public AuthorEntity toRest(CreateAuthorResponse rest) {
    return AuthorEntity.builder()
            .name(rest.getName())
            .particularity(rest.getParticularity())
            .build();
  }
  public List<AuthorEntity> toDomainPost(List<CreateAuthorResponse> list){
    return list.stream().map(this::toRest).toList();
  }

  public AuthorEntity toRest(UpdateAuthorResponse rest) {
    AuthorEntity author = repository.getById(rest.getId());
    return AuthorEntity.builder()
            .id(author.getId())
            .name(rest.getName())
            .particularity(rest.getParticularity())
            .build();
  }
  public List<AuthorEntity> toDomain(List<UpdateAuthorResponse> list){
    return list.stream().map(this::toRest).toList();
  }
}
