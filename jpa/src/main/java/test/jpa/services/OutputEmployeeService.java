package test.jpa.services;

import org.springframework.stereotype.Service;
import test.jpa.enums.ResultCode;
import test.jpa.exceptions.FileException;

/**
 * 従業員情報取得service
 */
@Service
public interface OutputEmployeeService {
    /**
     * DBから従業員情報を取得し出力する処理.
     * @throws FileException .
     */
    ResultCode output() throws FileException;
}
