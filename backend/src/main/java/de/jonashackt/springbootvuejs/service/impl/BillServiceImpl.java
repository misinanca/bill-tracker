package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.entity.Bill;
import de.jonashackt.springbootvuejs.repository.BillRepository;
import de.jonashackt.springbootvuejs.service.BillService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }


    @Override
    public Long updateBillStatus(Long id) {
        Bill bill = billRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Cannot find article with ID: " + id));
        bill.setStatus(true);
      return billRepository.save(bill).getId();

    }
}
