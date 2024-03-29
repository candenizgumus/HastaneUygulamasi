package com.candenizgumus.repositories;

import com.candenizgumus.entities.Brans;
import com.candenizgumus.entities.Doktor;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;

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
    public Integer findRandevuOfDoktorByTarihAraligi(String doktorAd) {
        TypedQuery<Long> hastaSayisiQuery = getEntityManager().createQuery(
                "SELECT COUNT(r.hastaid) FROM Doktor d JOIN Randevu r ON r.doktorid = d.id WHERE d.ad = :doktorAd", Long.class);
        hastaSayisiQuery.setParameter("doktorAd", doktorAd);
        Long hastaSayisi = hastaSayisiQuery.getSingleResult();
        return hastaSayisi.intValue();
    }
}
