package app.prog.controller.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PutBook {
  private Integer id;
  private String title ;
  private String author;

  public boolean hasAuthor() {
    return author != null;
  }
}
