package de.jonashackt.springbootvuejs.controller.impl;

import de.jonashackt.springbootvuejs.controller.BillRestApi;
import de.jonashackt.springbootvuejs.controller.dtos.BillChartDto;
import de.jonashackt.springbootvuejs.controller.dtos.BillDTO;
import de.jonashackt.springbootvuejs.entity.Bill;
import de.jonashackt.springbootvuejs.service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
public class BillRestController implements BillRestApi {

    private final BillService billService;

    public BillRestController(BillService billService) {
        this.billService = billService;
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        Bill bill = billService.findById(id);
        if(bill == null) {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bill, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> updateStatus(@PathVariable("id") Long id) {
        Long response = billService.updateBillStatus(id);
        if(response!=null)
            return new ResponseEntity<>(true, HttpStatus.OK);

        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Boolean> update(@RequestBody BillDTO billDTO) {
        Long response = billService.update(billDTO);
        if(response != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Boolean> save(@RequestBody BillDTO billDTO) {
        Long response = billService.update(billDTO);
            if(response != null) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> filterBills(Boolean status) {
        List<BillDTO> bills = billService.filterBills(status);

        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> filterBillsByDate(String startDate, String endDate) {
        List<BillChartDto> bills = billService.filterBills(startDate, endDate);

        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findAll() {
        List<BillDTO> bills = billService.findAll();

        return new ResponseEntity<>(bills, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        Boolean response = billService.delete(id);
        if (response) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }


}
