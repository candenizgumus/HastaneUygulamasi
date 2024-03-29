package com.candenizgumus;

import com.candenizgumus.repositories.RandevuRepository;
import com.candenizgumus.services.HastaneService;
import com.candenizgumus.utility.DummyData;

import java.time.LocalDate;

public class Runner
{
    public static void main(String[] args)
    {
       // new DummyData();
        HastaneService hastaneService = new HastaneService();
        RandevuRepository randevuRepository = new RandevuRepository();


        //Adı verilen hastanın tüm randevularını listelesin.

        //hastaneService.findRandevuByHastaAd("Deniz");

        //Adı verilen hasta Hangi branştan kaç randevu almış, listelesin.
        //hastaneService.findBransByHastaAd("Deniz");

        //Adı verilen hasta Belirli bir tarih aralığında aldığı tüm randevuları listelensin.
        //hastaneService.findRandevularByDate("Deniz", LocalDate.of(2024,03,01),LocalDate.of(2024,03,30));

        //Bir hastanın son ziyaret tarihini döndürün
        System.out.println(randevuRepository.findUsersByComponentType("Deniz"));
    }
}