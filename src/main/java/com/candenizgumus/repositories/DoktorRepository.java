package com.candenizgumus.repositories;

import com.candenizgumus.entities.Brans;
import com.candenizgumus.entities.Doktor;
import com.candenizgumus.entities.Randevu;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class DoktorRepository extends RepositoryManager<Doktor, Long>
{
    public DoktorRepository()
    {
        super(Doktor.class);
    }

    //Adı verilen doktor kaç hasta bakmıştır?

    public Integer findHastaSayisiByDoktor(String doktorAd) {
        TypedQuery<Long> hastaSayisiQuery = getEntityManager().createQuery(
                "SELECT COUNT(r.hastaid) FROM Doktor d JOIN Randevu r ON r.doktorid = d.id WHERE d.ad = :doktorAd", Long.class);
        hastaSayisiQuery.setParameter("doktorAd", doktorAd);
        Long hastaSayisi = hastaSayisiQuery.getSingleResult();
        return hastaSayisi.intValue();
    }

    //Bir doktorun belirli bir tarih aralığında kaç randevusu olduğunu listeleyin
    public List<Randevu> findRandevuOfDoktorByTarihAraligi(String doktorAd, LocalDate tarih1, LocalDate tarih2) {
        TypedQuery<Randevu> randevular = getEntityManager().createQuery(
                "SELECT r FROM Doktor d JOIN Randevu r ON r.doktorid = d.id WHERE d.ad = :doktorAd AND r.tarih BETWEEN :tarih1 AND :tarih2", Randevu.class);
        TypedQuery<Randevu> hastaSayisiQuery = randevular;
        hastaSayisiQuery.setParameter("tarih1", tarih1);
        hastaSayisiQuery.setParameter("tarih2", tarih2);
        hastaSayisiQuery.setParameter("doktorAd", doktorAd);

        return randevular.getResultList();
    }

    //Belirli bir tarih aralığında en çok randevu veren doktoru listeleyen bir metod.

    public String findMostRandevuluDoktorByTarihAraligi(LocalDate tarih1, LocalDate tarih2) {
        TypedQuery<Object[]> randevularQuery = getEntityManager().createQuery(
                "SELECT d.ad, count(r.doktorid) FROM Doktor d JOIN Randevu r ON r.doktorid = d.id WHERE r.tarih BETWEEN :tarih1 AND :tarih2 GROUP BY d.ad ORDER BY COUNT(r.doktorid) DESC", Object[].class);
        randevularQuery.setParameter("tarih1", tarih1);
        randevularQuery.setParameter("tarih2", tarih2);

        List<Object[]> resultList = randevularQuery.getResultList();
        if (!resultList.isEmpty()) {
            Object[] mostRandevuluDoktor = resultList.get(0);
            String doktorAdi = (String) mostRandevuluDoktor[0];
            Long randevuSayisi = (Long) mostRandevuluDoktor[1];
            return "En çok randevulu doktor Adı: " + doktorAdi + ", Randevu Sayısı: " + randevuSayisi;
        } else {
            return "Belirtilen tarih aralığında randevulu doktor bulunamadı.";
        }
    }



}
