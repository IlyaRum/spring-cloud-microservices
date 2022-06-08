package com.javastart.bill.service;


import com.javastart.bill.entity.Bill;
import com.javastart.bill.exception.BillNotFoundException;
import com.javastart.bill.repository.BillRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class BillService {
    private BillRepository billRepository;

    @Autowired
    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill getBillById(Long billId) {
        return billRepository.findById(billId)
                .orElseThrow(() -> new BillNotFoundException("Unable to find bill with " + billId));
    }


    public Long createBill(Long accountId,
                           BigDecimal amount,
                           Boolean isDefault,
                           Boolean overdraftEnabled) {
        Bill bill = new Bill(accountId, amount, isDefault, OffsetDateTime.now(), overdraftEnabled);
        return billRepository.save(bill).getAccountId();
    }

    public Bill updateBill(Long billId,
                           Long accountId,
                           BigDecimal amount,
                           Boolean isDefault,
                           Boolean overdraftEnabled) {
        Bill bill = new Bill(accountId, amount, isDefault, overdraftEnabled);
        bill.setBillId(billId);
        return billRepository.save(bill);
    }

    public Bill deleteBill(Long billId){
        Bill deleteBill = getBillById(billId);
        billRepository.deleteById(billId);
        return deleteBill;
    }


}
