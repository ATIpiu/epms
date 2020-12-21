package com.epms.service;

import com.epms.utils.result.Result;

public interface StaffService {
    Result Login(String userName, String password);
}
