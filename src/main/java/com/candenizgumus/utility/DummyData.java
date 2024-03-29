package com.candenizgumus.utility;

import com.candenizgumus.entities.Brans;
import com.candenizgumus.entities.Doktor;
import com.candenizgumus.entities.Hasta;
import com.candenizgumus.entities.Randevu;
import com.candenizgumus.repositories.BransRepository;
import com.candenizgumus.repositories.DoktorRepository;
import com.candenizgumus.repositories.HastaRepository;
import com.candenizgumus.repositories.RandevuRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public class DummyData
{
    BransRepository bransRepository;
    DoktorRepository doktorRepository;
    HastaRepository hastaRepository;
    RandevuRepository randevuRepository;

    public DummyData()
    {
        this.bransRepository = new BransRepository();
        this.doktorRepository = new DoktorRepository();
        this.hastaRepository = new HastaRepository();
        this.randevuRepository = new RandevuRepository();
        createData();
    }

    public void createData()
    {
        createBrans();
        createDoktor();
        createHasta();
        createRandevu();
    }

    private void createDoktor()
    {
        String[] doktorIsimleri = {"Ali", "Ayşe", "Fatma", "Mehmet", "Zeynep", "Mustafa", "Elif", "Can", "Gizem", "Emre"};
        String[] adresler = {"İstanbul", "Ankara", "İzmir", "Bursa", "Adana", "Antalya", "Eskişehir", "Trabzon", "Samsun", "Denizli"};
        String[] telefonlar = {"05301234567", "05412345678", "05523456789", "05634567890", "05745678901", "05856789012", "05967890123", "06078901234", "06189012345", "06290123456"};
        String[] unvanlar = {"Profesör", "Doçent", "Yardımcı Doçent", "Uzman Doktor", "Uzmanlık Eğitimi Gören", "Araştırma Görevlisi", "Asistan", "Pratisyen Doktor", "Başhekim", "Klinik Şefi"};

        for (int i = 0; i < 10; i++)
        {
            doktorRepository.save(Doktor.builder()
                    .ad(doktorIsimleri[i])
                    .adres(adresler[i])
                    .unvan(unvanlar[i])
                    .bransid((long) (i + 1))
                    .telefon(telefonlar[i])
                    .build());
        }

    }

    private void createBrans()
    {
        String[] branslar = {"Kardiyoloji", "Dermatoloji", "Gastroenteroloji", "Nöroloji", "Ortopedi", "Onkoloji", "Üroloji", "Pediatri", "Endokrinoloji", "Psikiyatri"};

        for (int i = 0; i < 10; i++)
        {
            bransRepository.save(Brans.builder().ad(branslar[i]).build());
        }

    }

    private void createHasta()
    {
        String[] hastaIsimleri = {"Deniz", "Elif", "Mehmet", "Ayşe", "Ali", "Zeynep", "Ahmet", "Fatma", "Can", "Gizem", "Emre", "İrem", "Burak", "Aslı", "Cem", "Derya", "Hakan", "Nehir", "Kaan", "Selma"};
        String[] adresler = {"Ankara", "İstanbul", "İzmir", "Antalya", "Bursa", "Adana", "Trabzon", "Eskişehir", "Konya", "Diyarbakır", "Malatya", "Samsun", "Balıkesir", "Gaziantep", "Mersin", "Denizli", "Van", "Kocaeli", "Erzurum", "Tekirdağ"};
        String[] telefonlar = {"05301234567", "05412345678", "05523456789", "05634567890", "05745678901", "05856789012", "05967890123", "06078901234", "06189012345", "06290123456", "06391234567", "06492345678", "06593456789", "06694567890", "06795678901", "06896789012", "06997890123", "07008901234", "07119012345", "07220123456"};
        String[] yaslar = {"33", "25", "45", "38", "29", "51", "42", "36", "48", "31", "40", "27", "55", "34", "47", "39", "30", "43", "26", "37"};
        String[] cinsiyetler = {"ERKEK", "KADIN", "ERKEK", "KADIN", "ERKEK", "KADIN", "ERKEK", "KADIN", "ERKEK", "KADIN", "ERKEK", "KADIN", "ERKEK", "KADIN", "ERKEK", "KADIN", "ERKEK", "KADIN", "ERKEK", "KADIN"};

        for (int i = 0; i < 20; i++)
        {
            hastaRepository.save(Hasta.builder()
                    .ad(hastaIsimleri[i])
                    .adres(adresler[i])
                    .telefon(telefonlar[i])
                    .yas(yaslar[i])
                    .cinsiyet(cinsiyetler[i])
                    .build());
        }


    }

    private void createRandevu()
    {

        for (int i = 0; i < 100; i++)
        {
            randevuRepository.save(Randevu.builder()
                    .doktorid(getRandomDoktorId())
                    .hastaid(getRandomHastaId())
                    .durum(1)
                    .tarih(LocalDate.now())
                    .zaman(LocalTime.now())
                    .build());
        }
    }

    private Long getRandomDoktorId()
    {
        return (long) (Math.random() * 10) + 1;
    }

    // Hasta ID'lerini rastgele oluşturmak için kullanılacak metot
    private Long getRandomHastaId()
    {
        return (long) (Math.random() * 20) + 1;
    }

}
