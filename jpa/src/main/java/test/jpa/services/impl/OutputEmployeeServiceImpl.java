package test.jpa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;
import test.jpa.entity.Employee;
import test.jpa.proprety.FileOutputProperty;
import test.jpa.repository.EmployeeRepository;
import test.jpa.service.OutputEmployeeService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service("OutputEmployeeService")
public class OutputEmployeeServiceImpl extends FileOutputProperty implements OutputEmployeeService {

    /** 従業員リポジトリ. */
    @Autowired
    private EmployeeRepository employeeRepository;

    /** {@inheritDoc} */
    @Override
    public void output() {
        log.info("出力処理開始");
        List<String> outputLines = new ArrayList<>();
        // ヘッダー行出力
        outputLines.add(getHeader());
        try {
            List<Employee> employeeList = employeeRepository.findAll();
            employeeList.forEach(employee -> {
                log.debug("社員コード：[{}]", employee.getEmployeeCode());
                outputLines
            });
            Files.write(
                    Paths.get(getPath(), getName())
                    , StandardCharsets.UTF_8
                    , new OpenOption() {
                        StandardOpenOption.TRUNCATE_EXISTING
                    , StandardOpenOption.CREATE
                    }
            );
            log.info("出力処理正常終了");
        } catch (IOException e) {
            log.error("出力処理異常終了", e);
            System.exit(9);
        }
    }
}
