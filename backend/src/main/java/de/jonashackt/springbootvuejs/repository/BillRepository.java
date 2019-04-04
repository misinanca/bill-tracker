package de.jonashackt.springbootvuejs.repository;

import de.jonashackt.springbootvuejs.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
