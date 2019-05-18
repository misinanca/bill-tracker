package de.jonashackt.springbootvuejs.service.impl;

import de.jonashackt.springbootvuejs.controller.dtos.BillDTO;
import de.jonashackt.springbootvuejs.entity.Bill;
import de.jonashackt.springbootvuejs.entity.CurrentUser;
import de.jonashackt.springbootvuejs.mapper.BillMapper;
import de.jonashackt.springbootvuejs.mapper.impl.BillMapperImpl;
import de.jonashackt.springbootvuejs.repository.BillRepository;
import de.jonashackt.springbootvuejs.repository.UserRepository;
import de.jonashackt.springbootvuejs.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final UserRepository userRepository;
    private final BillMapper billMapper;

    @Autowired
    public BillServiceImpl(BillRepository billRepository, UserRepository userRepository, BillMapper billMapper) {
        this.billRepository = billRepository;
        this.userRepository = userRepository;
        this.billMapper = billMapper;
    }


    @Override
    public Long updateBillStatus(Long id) {
        Bill bill = billRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Cannot find article with ID: " + id));
        bill.setStatus(true);
      return billRepository.save(bill).getId();
    }

    @Override
    public List<BillDTO> filterBills(Boolean status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CurrentUser userPrincipal = (CurrentUser) authentication.getPrincipal();
        return billRepository.findAll().stream().filter(bill -> bill.getStatus().equals(status) && bill.getUser().getId().equals(userPrincipal.getId())).map(entity -> billMapper.toDto(entity)).collect(Collectors.toList());
    }

    @Override
    public Long update(BillDTO billDTO) {
        try {
            Bill bill = billMapper.toEntity(billDTO);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            CurrentUser userPrincipal = (CurrentUser) authentication.getPrincipal();
            bill.setUser(userRepository.findById(userPrincipal.getId()).get());

            return billRepository.save(bill).getId();

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
