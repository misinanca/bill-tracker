package de.jonashackt.springbootvuejs.controller.impl;

import de.jonashackt.springbootvuejs.controller.BillRestApi;
import de.jonashackt.springbootvuejs.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController implements BillRestApi {

    private final BillService billService;

    public BillRestController(BillService billService) {
        this.billService = billService;
    }

    @Override
    public ResponseEntity<Boolean> update(@PathVariable("id") Long id) {
        Long response = billService.updateBillStatus(id);
        if(response!=null)
            return new ResponseEntity<>(true, HttpStatus.OK);

        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
}
