package com.candenizgumus.repositories;

import com.candenizgumus.entities.Brans;
import com.candenizgumus.entities.Hasta;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class BransRepository extends RepositoryManager<Brans,Long>
{
    public BransRepository()
    {
        super(Brans.class);
    }

    public void enCokRandevuAlan3Brans() {
        TypedQuery<Object[]> bransTypedQuery = getEntityManager().createQuery(
                "SELECT b.ad, COUNT (b.ad) FROM Doktor d JOIN Randevu r ON r.doktorid = d.id JOIN Brans b ON d.bransid = b.id GROUP BY b.ad ORDER BY COUNT(b.ad) DESC", Object[].class);


        bransTypedQuery.setMaxResults(3);

        List<Object[]> resultList = bransTypedQuery.getResultList();
        resultList.forEach(b -> {
            System.out.println("Bolum: " + b[0] + " Adet: " + b[1]);
        });
    }

    //Belirli bir branşta en çok randevuya sahip hastaları listeleyen bir metod.
    public Hasta belirli1BranstaEnCokRandevuyaSahipHastalar(String bransAd) {
        TypedQuery<Hasta> bransTypedQuery = getEntityManager().createQuery(
                "SELECT h  FROM Doktor d JOIN Randevu r ON r.doktorid = d.id JOIN Brans b ON d.bransid = b.id JOIN Hasta h ON h.id = r.hastaid WHERE b.ad =: bransAd GROUP BY h ORDER BY COUNT(h) DESC ", Hasta.class);

        bransTypedQuery.setParameter("bransAd",bransAd);
        bransTypedQuery.setMaxResults(1);

        return bransTypedQuery.getSingleResult();



    }

}
