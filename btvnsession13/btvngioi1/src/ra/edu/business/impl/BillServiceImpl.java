package ra.edu.business.impl;

import ra.edu.business.IBillService;
import ra.edu.model.Bill;

import java.util.List;

public class BillServiceImpl implements IBillService {
    @Override
    public int getMaxId() {
        return 0;
    }

    @Override
    public void add(Bill bill) {

    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void update(Bill bill, Integer integer) {

    }

    @Override
    public Bill findById(Integer integer) {
        return null;
    }

    @Override
    public List<Bill> findAll() {
        return List.of();
    }

    @Override
    public void sort() {

    }
}
