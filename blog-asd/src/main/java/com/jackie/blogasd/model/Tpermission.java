package com.jackie.blogasd.model;

public class Tpermission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_permission.tp_id
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    private String tpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_permission.parent_tp_id
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    private String parentTpId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_permission.permisssion_name
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    private String permisssionName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_permission.description
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    private String description;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_permission.tp_id
     *
     * @return the value of t_permission.tp_id
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    public String getTpId() {
        return tpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_permission.tp_id
     *
     * @param tpId the value for t_permission.tp_id
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    public void setTpId(String tpId) {
        this.tpId = tpId == null ? null : tpId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_permission.parent_tp_id
     *
     * @return the value of t_permission.parent_tp_id
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    public String getParentTpId() {
        return parentTpId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_permission.parent_tp_id
     *
     * @param parentTpId the value for t_permission.parent_tp_id
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    public void setParentTpId(String parentTpId) {
        this.parentTpId = parentTpId == null ? null : parentTpId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_permission.permisssion_name
     *
     * @return the value of t_permission.permisssion_name
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    public String getPermisssionName() {
        return permisssionName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_permission.permisssion_name
     *
     * @param permisssionName the value for t_permission.permisssion_name
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    public void setPermisssionName(String permisssionName) {
        this.permisssionName = permisssionName == null ? null : permisssionName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_permission.description
     *
     * @return the value of t_permission.description
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_permission.description
     *
     * @param description the value for t_permission.description
     *
     * @mbg.generated Tue Jun 18 15:39:52 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}