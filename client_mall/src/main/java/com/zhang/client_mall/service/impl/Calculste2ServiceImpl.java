package com.zhang.client_mall.service.impl;

import com.zhang.client_mall.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @author zhang
 * @date 2020-08-21
 * @descript
 */
@Service
@Profile("java8")
public class Calculste2ServiceImpl implements CalculateService {
    @Override
    public Integer sum(Integer... number) {
        int sum = Stream.of(number).reduce(0,Integer::sum);
        return sum;
    }
}
