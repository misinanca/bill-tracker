package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.controller.dtos.BillDTO;
import de.jonashackt.springbootvuejs.entity.Bill;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface BillService {
    Bill findById(Long id);

    Long updateBillStatus(Long id);

    Long update(BillDTO billDTO);

    List<BillDTO> filterBills(Boolean status);

    Map<Date, Double> filterBills(String startDate, String endDate);

    List<BillDTO> findAll();

    Boolean delete(Long id);
}
