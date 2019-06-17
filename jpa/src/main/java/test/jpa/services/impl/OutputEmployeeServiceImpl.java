package test.jpa.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.jpa.BaseBatch;
import test.jpa.entities.Employee;
import test.jpa.enums.ResultCode;
import test.jpa.exceptions.FileException;
import test.jpa.repositories.EmployeeRepository;
import test.jpa.services.OutputEmployeeService;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("OutputEmployeeService")
public class OutputEmployeeServiceImpl extends BaseBatch implements OutputEmployeeService {

    /** 従業員リポジトリ. */
    @Autowired
    private EmployeeRepository employeeRepository;

    /** {@inheritDoc} */
    @Override
    public ResultCode output() throws FileException {
        log.info("出力処理開始");
        List<String> outputLines = new ArrayList<>();
        // ヘッダー行作成
        outputLines.add(fileOutputProperty.getHeader());

        try {
            // テーブル「従業員（employee）」からデータを取得
            List<Employee> employeeList = employeeRepository.findAll();
            employeeList.forEach(employee -> {
                log.debug("出力行：[{}]", employee.toString());
                // データ行作成
                outputLines.add(employee.toString());
            });
        } catch (Exception e) {
            log.error("テーブル「従業員（employee）」からデータを取得に失敗しました。");
        }

        try {
            // ファイル出力
            Files.write(
                    Paths.get(fileOutputProperty.getPath(), fileOutputProperty.getName())
                    , outputLines
                    , StandardCharsets.UTF_8
                    , StandardOpenOption.TRUNCATE_EXISTING
                    , StandardOpenOption.CREATE);
            log.info("出力処理正常終了");
        } catch (Exception e) {
            throw new FileException(
                    "ファイル出力に失敗しました。（ファイルパス：[{}]）"
                    , new Object[] {Paths.get(fileOutputProperty.getPath(), fileOutputProperty.getName()).toString()}
                    , e
            );
        }
        return ResultCode.NORMAL;
    }
}
