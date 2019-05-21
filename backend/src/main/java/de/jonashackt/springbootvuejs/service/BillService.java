package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.controller.dtos.BillDTO;
import de.jonashackt.springbootvuejs.entity.Bill;

import java.util.List;

public interface BillService {
    Bill findById(Long id);

    Long updateBillStatus(Long id);

    Long update(BillDTO billDTO);

    List<BillDTO> filterBills(Boolean status);
}
