package ra.edu.business;

import ra.edu.model.Bill;

public interface IBillService extends IBaseService<Bill,Integer> {
    int getMaxId();
}
