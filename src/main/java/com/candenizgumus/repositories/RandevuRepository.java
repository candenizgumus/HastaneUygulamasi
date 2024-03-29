package com.candenizgumus.repositories;

import com.candenizgumus.entities.Hasta;
import com.candenizgumus.entities.Randevu;

public class RandevuRepository extends RepositoryManager<Randevu, Long>
{
    public RandevuRepository()
    {
        super(Randevu.class);
    }
}
