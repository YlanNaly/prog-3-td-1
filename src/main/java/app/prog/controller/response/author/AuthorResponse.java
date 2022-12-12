package app.prog.controller.response.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class AuthorResponse {
  private String name;
  private String particularity;
  private Integer id;
  private boolean hasParticularity;
}
