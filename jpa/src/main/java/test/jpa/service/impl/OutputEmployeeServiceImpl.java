package test.jpa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.jpa.service.OutputEmployeeService;

@Slf4j
@Service("OutputEmployeeService")
public class OutputEmployeeServiceImpl implements OutputEmployeeService {
    /** {@inheritDoc} */
    @Override
    public void output() {
    }
}
