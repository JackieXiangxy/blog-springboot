package com.jackie.blogasd.mapper;

import com.jackie.blogasd.model.Tlog;

public interface TlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_log
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    int deleteByPrimaryKey(String logId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_log
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    int insert(Tlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_log
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    int insertSelective(Tlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_log
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    Tlog selectByPrimaryKey(String logId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_log
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    int updateByPrimaryKeySelective(Tlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_log
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    int updateByPrimaryKey(Tlog record);
}