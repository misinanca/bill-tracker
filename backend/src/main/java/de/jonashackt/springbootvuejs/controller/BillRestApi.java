package de.jonashackt.springbootvuejs.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface BillRestApi {

    @PostMapping("/updateBillStatus/{id}")
    ResponseEntity<Boolean> update(@PathVariable("id") Long id);
}
