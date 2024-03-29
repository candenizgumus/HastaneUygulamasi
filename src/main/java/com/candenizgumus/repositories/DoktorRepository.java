package com.candenizgumus.repositories;

import com.candenizgumus.entities.Brans;
import com.candenizgumus.entities.Doktor;

public class DoktorRepository extends RepositoryManager<Doktor, Long>
{
    public DoktorRepository()
    {
        super(Doktor.class);
    }
}
