package com.jackie.blogasd.mapper;

import com.jackie.blogasd.model.Tuser;
import org.apache.ibatis.annotations.Param;

public interface TuserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    int deleteByPrimaryKey(String tuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    int insert(Tuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    int insertSelective(Tuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    Tuser selectByPrimaryKey(String tuId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    int updateByPrimaryKeySelective(Tuser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    int updateByPrimaryKey(Tuser record);

    //通过用户名获取用户信息
    public Tuser getUserByUserName(@Param("userName")String userName);
}