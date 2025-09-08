package com.home.wupupupu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.home.wupupupu.util.ArticleState;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class Article {
  @NotNull(groups = update.class)
  private long id;
  @Pattern(regexp = "^\\S{1,30}$")
  @NotBlank(groups = add.class)
  private String title;
  private String content;
  @URL
  private String coverImg;
  @ArticleState(groups = add.class)
  private String state;
  @NotNull(groups = add.class)
  private Integer categoryBelongs;
  private Integer createUser;
  @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
  private java.sql.Timestamp createTime;
  @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
  private java.sql.Timestamp updateTime;
  public interface add extends Default {}
  public interface update extends Default{}
}
