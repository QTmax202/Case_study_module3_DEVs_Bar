package service;

import DAO.HospitalDAO;
import model.pet_shop;

import java.util.ArrayList;

public class HospitalService {
    private static final HospitalDAO hospitalDAO = new HospitalDAO();

    public ArrayList<pet_shop> getLimit8Pet_shop(){
        return hospitalDAO.getLimit8Pet_Shop();
    }
}
