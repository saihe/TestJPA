package test.jpa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 終了コードenum
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
  /** 正常終了. */
  NORMAL(0, "正常終了"),
  /** 異常終了. */
  ERROR(9, "異常終了");

  /** コード. */
  private int code;
  /** 名称. */
  private String name;
}
