package service;

import DAO.HospitalDAO;
import model.pet_shop;

import java.util.ArrayList;

public class HospitalService {
    private static final HospitalDAO hospitalDAO = new HospitalDAO();

    public ArrayList<pet_shop> getAllPet_shop(){
        return hospitalDAO.getAllPet_shop();
    }
}
