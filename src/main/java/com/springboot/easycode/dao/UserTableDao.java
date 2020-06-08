package com.springboot.easycode.dao;

import com.springboot.easycode.entity.UserTable;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * (UserTable)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-08 16:52:53
 */
public interface UserTableDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserTable queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserTable> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userTable 实例对象
     * @return 对象列表
     */
    List<UserTable> queryAll(UserTable userTable);

    /**
     * 新增数据
     *
     * @param userTable 实例对象
     * @return 影响行数
     */
    int insert(UserTable userTable);

    /**
     * 修改数据
     *
     * @param userTable 实例对象
     * @return 影响行数
     */
    int update(UserTable userTable);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}