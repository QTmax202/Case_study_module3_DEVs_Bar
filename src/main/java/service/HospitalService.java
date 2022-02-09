package service;

import DAO.HospitalDAO;
import model.Pet_shop;

import java.util.ArrayList;

public class HospitalService {
    private static final HospitalDAO hospitalDAO = new HospitalDAO();

    public ArrayList<Pet_shop> getAllPet_shop(){
        return hospitalDAO.getAllPet_shop();
    }

    public static void main(String[] args) {
        ArrayList<pet_shop> pet_shops = hospitalDAO.getAllPet_shop();
        for (pet_shop ps: pet_shops) {
            System.out.println(ps);
        }
    }
}
