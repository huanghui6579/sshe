package edu.hbmy.sshe.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.hbmy.sshe.service.RepairService;

@Service("repairService")
@Transactional(readOnly = true)
public class RepairServiceImpl implements RepairService {

}
