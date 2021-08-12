package top.sxuet.bootwebthymeleafadmin.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import top.sxuet.bootwebthymeleafadmin.bean.City;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-10 15:38
 */

/** 纯注解示例 */
// @Mapper
public interface CityMapper {
  @Insert("INSERT INTO city (name, state, country) VALUES(#{name}, #{state}, #{country})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(City city);

  @Select("SELECT id, name, state, country FROM city WHERE id = #{id}")
  City findById(long id);
}
