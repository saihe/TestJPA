package test.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import test.jpa.enums.ResultCode;
import test.jpa.exceptions.FileException;
import test.jpa.services.OutputEmployeeService;

/**
 * 処理class
 */
@Slf4j
@Component
public class Batch extends BaseBatch implements CommandLineRunner {

    /** 従業員情報出力サービス. */
    @Autowired
    private OutputEmployeeService outputEmployeeService;

    /**
     * バッチ処理
     */
    @Override
    public void run (String... args) {
        ResultCode resultCode = ResultCode.NORMAL;
        log.info("バッチ開始 バッチID：[batch001]");
        try {
            // 従業員情報出力処理
            resultCode = outputEmployeeService.output();
        } catch (FileException e) {
            log.error(e.getMessage(), e);
        }
        log.info("バッチ終了 バッチID：[batch001]");
        exit(resultCode);
    }
}
