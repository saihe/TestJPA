package test.jpa.exceptions;

import java.text.MessageFormat;

/**
 * ファイル操作に関するexception
 */
public class FileException extends Exception {
  public FileException(String format, Object[] arguments, Throwable cause) {
    super(MessageFormat.format(format, arguments), cause);
  }
}
