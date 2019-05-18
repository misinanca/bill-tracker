package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.controller.dtos.BillDTO;

public interface BillService {

    Long updateBillStatus(Long id);

    Long update(BillDTO billDTO);
}
