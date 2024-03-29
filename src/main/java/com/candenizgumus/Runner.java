package com.candenizgumus;

import com.candenizgumus.repositories.BransRepository;
import com.candenizgumus.repositories.DoktorRepository;
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
        DoktorRepository doktorRepository = new DoktorRepository();
        BransRepository bransRepository = new BransRepository();


        //Adı verilen hastanın tüm randevularını listelesin.

        //hastaneService.findRandevuByHastaAd("Deniz");

        //Adı verilen hasta Hangi branştan kaç randevu almış, listelesin.
        //hastaneService.findBransByHastaAd("Deniz");

        //Adı verilen hasta Belirli bir tarih aralığında aldığı tüm randevuları listelensin.
        //hastaneService.findRandevularByDate("Deniz", LocalDate.of(2024,03,01),LocalDate.of(2024,03,30));

        //Bir hastanın son ziyaret tarihini döndürün
        //System.out.println(randevuRepository.findUsersByComponentType("Elif"));

        //Adı verilen doktor kaç hasta bakmıştır?
        //System.out.println(doktorRepository.findHastaSayisiByDoktor("Gizem"));

        //Bellirli bir branşta görev yapan doktorlar kimlerdir?
        //hastaneService.findDoktorByBransAd("Onkoloji");

        //Bir doktorun belirli bir tarih aralığında kaç randevusu olduğunu listeleyin
        //doktorRepository.findRandevuOfDoktorByTarihAraligi("Elif",LocalDate.of(2024,01,01),LocalDate.of(2024,03,12)).forEach(System.out::println);

        //Belirli bir tarih aralığında en çok randevu veren doktoru listeleyen bir metod.
       // System.out.println(doktorRepository.findMostRandevuluDoktorByTarihAraligi(LocalDate.of(2024, 01, 01), LocalDate.of(2024, 05, 12)));

        //En çok randevu alan 3 branş
        //bransRepository.enCokRandevuAlan3Brans();

        //Belirli bir branşta en çok randevuya sahip hastaları listeleyen bir metod.

        System.out.println(bransRepository.belirli1BranstaEnCokRandevuyaSahipHastalar("Psikiyatri"));
    }
}