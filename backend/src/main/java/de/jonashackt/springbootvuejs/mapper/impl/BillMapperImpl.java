package de.jonashackt.springbootvuejs.mapper.impl;

import de.jonashackt.springbootvuejs.controller.dtos.BillDTO;
import de.jonashackt.springbootvuejs.entity.Bill;
import de.jonashackt.springbootvuejs.mapper.BillMapper;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BillMapperImpl implements BillMapper {
    @Override
    public Bill toEntity(BillDTO billDTO) throws ParseException {
        if (billDTO != null) {
            // convert the string date into a Date() object
            //pattern of string date should be "dd-MM-yy"
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(billDTO.getDue());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            Bill bill = new Bill();
            bill.setId(billDTO.getId());
            bill.setName(billDTO.getName());
            bill.setDue(sqlDate);
            bill.setStatus(billDTO.getStatus());

            return bill;
        } else return null;
    }

    @Override
    public BillDTO toDto(Bill bill) {
        if (bill != null) {
            BillDTO billDTO = new BillDTO();
            billDTO.setId(bill.getId());
            billDTO.setName(bill.getName());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(bill.getDue());
            billDTO.setDue(strDate);
            billDTO.setStatus(bill.getStatus());

            return billDTO;
        } else return null;
    }
}
