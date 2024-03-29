package com.candenizgumus.services;

import com.candenizgumus.entities.Brans;
import com.candenizgumus.entities.Doktor;
import com.candenizgumus.entities.Hasta;
import com.candenizgumus.entities.Randevu;
import com.candenizgumus.repositories.BransRepository;
import com.candenizgumus.repositories.DoktorRepository;
import com.candenizgumus.repositories.HastaRepository;
import com.candenizgumus.repositories.RandevuRepository;

import java.time.LocalDate;
import java.util.List;

public class HastaneService
{
    BransRepository bransRepository = new BransRepository();
    DoktorRepository doktorRepository = new DoktorRepository();
    HastaRepository hastaRepository = new HastaRepository();
    RandevuRepository randevuRepository = new RandevuRepository();

    //Adı verilen hastanın tüm randevularını listelesin.
    public void findRandevuByHastaAd(String hastaAdi){
        List<Hasta> hastalar = hastaRepository.findByColumnAndValue("ad", hastaAdi);

        hastalar.forEach(hasta -> {
            System.out.println("Hasta Adı: "+ hasta.getAd());
            List<Randevu> randevuList = randevuRepository.findByColumnAndValue("hastaid", hasta.getId());
            randevuList.forEach(System.out::println);

        });
    }


    //Adı verilen hasta Hangi branştan kaç randevu almış, listelesin. SQL İLE YAZ

    public void findBransByHastaAd(String hastaAdi){
        List<Hasta> hastalar = hastaRepository.findByColumnAndValue("ad", hastaAdi);
        hastalar.forEach(hasta -> {
            List<Randevu> randevuList = randevuRepository.findByColumnAndValue("hastaid", hasta.getId());
            randevuList.forEach(randevu -> {
                List<Doktor> doktorList = doktorRepository.findByColumnAndValue("id", randevu.getDoktorid());
                doktorList.forEach(doktor -> {
                    List<Brans> bransList = bransRepository.findByColumnAndValue("id", doktor.getBransid());
                    bransList.forEach(System.out::println);

                });
            });

        });

    }

    //Adı verilen hasta Belirli bir tarih aralığında aldığı tüm randevuları listelensin.

    public void findRandevularByDate(String hastaAdi , LocalDate tarih1, LocalDate tarih2){
        List<Hasta> hastalar = hastaRepository.findByColumnAndValue("ad", hastaAdi);
        hastalar.forEach(hasta -> {
            List<Randevu> randevuList = randevuRepository.findByColumnAndValue("hastaid", hasta.getId());
            randevuList.forEach(randevu -> {
                if (randevu.getTarih().isAfter(tarih1) && randevu.getTarih().isBefore(tarih2) )
                {
                    System.out.println(randevu);

                }

            });


        });

    }

    //Bellirli bir branşta görev yapan doktorlar kimlerdir?
    public void findDoktorByBransAd(String bransAd){
        System.out.println("Seçilen Branş: " + bransAd);
        List<Brans> branslar = bransRepository.findByColumnAndValue("ad", bransAd);
        branslar.forEach(brans -> {
            List<Doktor> bransliDoktorlar = doktorRepository.findByColumnAndValue("bransid", brans.getId());
            bransliDoktorlar.forEach(System.out::println);
        });


    }
}
