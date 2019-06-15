package test.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import test.jpa.service.OutputEmployeeService;

@Slf4j
@Component
public class Batch {

    /** 従業員情報出力サービス. */
    @Autowired
    private OutputEmployeeService outputEmployeeService;

    @Scheduled(initialDelayString = "${scheduled.delay.initial}", fixedDelayString = "${scheduled.delay.fixed}")
    public void batch001(){
//        log.info("バッチ起動 バッチID：[batch001]");
        outputEmployeeService.output();
    }
}

