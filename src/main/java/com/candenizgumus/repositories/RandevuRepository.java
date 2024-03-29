package com.candenizgumus.repositories;

import com.candenizgumus.entities.Hasta;
import com.candenizgumus.entities.Randevu;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class RandevuRepository extends RepositoryManager<Randevu, Long>
{
    public RandevuRepository()
    {
        super(Randevu.class);
    }

    //Bir hastanın son ziyaret tarihini döndürün
    public LocalDate findUsersByComponentType(String hastaAdi)
    {
        TypedQuery<LocalDate> date = getEntityManager().createQuery("SELECT r.tarih FROM Hasta h JOIN Randevu r ON r.hastaid = h.id WHERE h.ad = :hastaAdi ORDER BY r.tarih DESC", LocalDate.class);
        date.setMaxResults(1);

        return date.setParameter("hastaAdi",hastaAdi).getSingleResult();

    }
}
