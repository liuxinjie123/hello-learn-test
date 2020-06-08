package com.springboot.easycode.service.impl;

import com.springboot.easycode.entity.UserTable;
import com.springboot.easycode.dao.UserTableDao;
import com.springboot.easycode.service.UserTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserTable)表服务实现类
 *
 * @author makejava
 * @since 2020-06-08 16:52:54
 */
@Service("userTableService")
public class UserTableServiceImpl implements UserTableService {
    @Resource
    private UserTableDao userTableDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserTable queryById(Long id) {
        return this.userTableDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserTable> queryAllByLimit(int offset, int limit) {
        return this.userTableDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userTable 实例对象
     * @return 实例对象
     */
    @Override
    public UserTable insert(UserTable userTable) {
        this.userTableDao.insert(userTable);
        return userTable;
    }

    /**
     * 修改数据
     *
     * @param userTable 实例对象
     * @return 实例对象
     */
    @Override
    public UserTable update(UserTable userTable) {
        this.userTableDao.update(userTable);
        return this.queryById(userTable.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userTableDao.deleteById(id) > 0;
    }
}