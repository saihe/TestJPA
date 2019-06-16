package test.jpa.services;

import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 従業員情報取得service
 */
@Service
public interface OutputEmployeeService {
    /**
     * DBから従業員情報を取得し出力する処理.
     */
    void output() throws IOException;
}
