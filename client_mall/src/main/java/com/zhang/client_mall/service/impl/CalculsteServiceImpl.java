package com.zhang.client_mall.service.impl;

import com.zhang.client_mall.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @author zhang
 * @date 2020-08-21
 * @descript
 */
@Service
@Profile("java7")
public class CalculsteServiceImpl implements CalculateService {
    @Override
    public Integer sum(Integer... number) {
        int sum = 0;
        for (int i = 0; i < number.length; i++) {
            sum += number[i];
        }
        return sum;
    }
}
