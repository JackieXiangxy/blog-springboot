package com.jackie.blogasd.mapper;

import com.jackie.blogasd.model.Torganization;
import org.springframework.stereotype.Repository;

@Repository
public interface TorganizationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_organization
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    int deleteByPrimaryKey(String toId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_organization
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    int insert(Torganization record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_organization
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    int insertSelective(Torganization record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_organization
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    Torganization selectByPrimaryKey(String toId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_organization
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    int updateByPrimaryKeySelective(Torganization record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_organization
     *
     * @mbg.generated Mon Jul 08 09:23:15 CST 2019
     */
    int updateByPrimaryKey(Torganization record);
}