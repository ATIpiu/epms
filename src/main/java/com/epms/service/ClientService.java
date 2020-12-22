package com.epms.service;

import com.epms.utils.result.Result;

public interface ClientService {
    Result Login(String userName, String password);
}
