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

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final UserRepository userRepository;
    private final BillMapper billMapper = new BillMapperImpl();

    @Autowired
    public BillServiceImpl(BillRepository billRepository, UserRepository userRepository) {
        this.billRepository = billRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Long updateBillStatus(Long id) {
        Bill bill = billRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Cannot find article with ID: " + id));
        bill.setStatus(true);
      return billRepository.save(bill).getId();

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
