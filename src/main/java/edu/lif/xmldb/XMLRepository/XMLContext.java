package edu.lif.xmldb.XMLRepository;

import java.util.List;


public interface XMLContext<T> {

    /**
     * 数据重写：会覆盖源文件
     * 用于初始化数据和数据最终存储
     *
     * @param entity 实例类
     */
    void save(T... entity);

    /**
     * 动态添加数据
     * @param entity
     */
    void add(T... entity);


    /**
     * 解析XML文件：通过XML文件创建实例
     * @return 返回该类的实例对象
     */
    List<T> init();

    /**
     * 根据ID删除XML数据库中的数据
     *
     * @param id 需要删除元素的id
     */
    void deleteById(String id);

    /**
     * 根据ID寻找对象
     *
     * @param id 元素ID
     * @return 返回相同ID组成的对象
     */
    T findById(String id);


    /**
     * 数据更新
     * @param oldValue 旧值
     * @param newValue 新值
     * @return 返回对象
     */
    T updateById(String oldValue, String newValue);

    /**
     * 清除所有数据
     */
    void deleteAll();
}
