package com.candenizgumus.repositories;

import com.candenizgumus.entities.Doktor;
import com.candenizgumus.entities.Hasta;

public class HastaRepository extends RepositoryManager<Hasta, Long>
{
    public HastaRepository()
    {
        super(Hasta.class);
    }
}
