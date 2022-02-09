package service;

import DAO.HospitalDAO;
import model.Pet_shop;

import java.util.ArrayList;

public class HospitalService {
    private static final HospitalDAO hospitalDAO = new HospitalDAO();

    public ArrayList<Pet_shop> getAllPet_shop(){
        return hospitalDAO.getAllPet_shop();
    }
}
