package de.jonashackt.springbootvuejs.controller;

import de.jonashackt.springbootvuejs.controller.dtos.BillDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface BillRestApi {

    @PostMapping("/updateBillStatus/{id}")
    ResponseEntity<Boolean> updateStatus(@PathVariable("id") Long id);

    @PostMapping("/updateBill")
    ResponseEntity<Boolean> update(BillDTO billDTO);

    @PostMapping("/saveBill")
    ResponseEntity<Boolean> save(BillDTO billDTO);

}
