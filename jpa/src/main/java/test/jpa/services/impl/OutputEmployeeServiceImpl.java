package test.jpa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.jpa.entities.Employee;
import test.jpa.propreties.FileOutputProperty;
import test.jpa.repositories.EmployeeRepository;
import test.jpa.services.OutputEmployeeService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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
                log.debug("出力行：[{}]", employee.toString());
                outputLines.add(employee.toString());
            });
            Files.write(
                    Paths.get(getPath(), getName())
                    , outputLines
                    , StandardCharsets.UTF_8
                    , StandardOpenOption.TRUNCATE_EXISTING
                    , StandardOpenOption.CREATE
            );
            log.info("出力処理正常終了");
        } catch (IOException e) {
            log.error("出力処理異常終了", e);
            System.exit(9);
        }
    }
}
