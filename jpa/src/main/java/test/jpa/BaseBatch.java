package test.jpa;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.jpa.enums.ResultCode;
import test.jpa.propreties.FileOutputProperty;

/**
 * 基底class
 */
@Getter
@Component
public class BaseBatch {
  /** ファイル出力プロパティ. */
  @Autowired
  private FileOutputProperty fileOutputProperty;

  /**
   * アプリケーション終了
   * @param resultCode .
   */
  protected static void exit(ResultCode resultCode) {
    System.exit(resultCode.getCode());
  }
}
