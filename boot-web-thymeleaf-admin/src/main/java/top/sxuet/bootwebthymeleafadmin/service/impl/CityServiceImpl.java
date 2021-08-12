package top.sxuet.bootwebthymeleafadmin.service.impl;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sxuet.bootwebthymeleafadmin.bean.City;
import top.sxuet.bootwebthymeleafadmin.mapper.CityMapper;
import top.sxuet.bootwebthymeleafadmin.service.CityService;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-10 15:40
 */
@Service
public class CityServiceImpl implements CityService {
  @Autowired CityMapper mapper;

  Counter counter;

  public CityServiceImpl(MeterRegistry registry) {
    registry.counter("cityService.saveCity.count");
  }

  public void saveCity(City city) {
    counter.increment();
    mapper.insert(city);
  }

  @Override
  public City findById(long id) {
    return mapper.findById(id);
  }
}
