package de.jonashackt.springbootvuejs.mapper;

import de.jonashackt.springbootvuejs.controller.dtos.BillDTO;
import de.jonashackt.springbootvuejs.entity.Bill;

import java.text.ParseException;

public interface BillMapper {
    Bill toEntity(final BillDTO billDTO) throws ParseException;
    BillDTO toDto(Bill bill);
}
