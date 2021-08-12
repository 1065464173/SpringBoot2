package top.sxuet.bootwebthymeleafadmin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.sxuet.bootwebthymeleafadmin.bean.Account;

/**
 * @program: SpringBoot2
 * @description:
 * @author: Sxuet
 * @create: 2021-08-10 14:26
 */

/** xml mapper 文件示例 */
@Mapper
public interface AccountMapper {
  /**
   * 根据id查找account
   *
   * @param id
   * @return
   */
  @Select("select * from `account` where id = #{id}")
  public Account getAccount(@Param("id") Long id);
}
