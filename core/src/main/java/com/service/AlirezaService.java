package com.service;

import com.entity.AlirezaEntity;

public interface AlirezaService {
    void persistAlireza(AlirezaEntity alireza);

    AlirezaEntity retrieveData();
}
