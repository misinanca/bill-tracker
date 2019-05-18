package de.jonashackt.springbootvuejs.service;

import de.jonashackt.springbootvuejs.controller.dtos.BillDTO;
import java.util.List;

public interface BillService {

    Long updateBillStatus(Long id);

    Long update(BillDTO billDTO);

    List<BillDTO> filterBills(Boolean status);
}
