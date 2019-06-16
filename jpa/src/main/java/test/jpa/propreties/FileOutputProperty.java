package test.jpa.propreties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "file.output")
public class FileOutputProperty {
  /** ファイル出力パス. */
  private String path;
  /** ファイル出力名. */
  private String name;
  /** ファイルヘッダー. */
  private String header;
}
