package service;

import DAO.HospitalDAO;
import model.Pet_shop;

import java.util.ArrayList;

public class HospitalService {
    private static final HospitalDAO hospitalDAO = new HospitalDAO();

    public ArrayList<Pet_shop> getLimit8Pet_shop() {
        return hospitalDAO.getLimit8Pet_Shop();
    }
}
