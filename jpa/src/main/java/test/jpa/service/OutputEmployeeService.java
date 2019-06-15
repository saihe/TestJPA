package test.jpa.service;

import org.springframework.stereotype.Service;

/**
 * 従業員情報取得クラス.
 */
@Service
public interface OutputEmployeeService {
    /**
     * DBから従業員情報を取得し出力する処理.
     */
    void output();
}
