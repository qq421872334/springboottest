package com.app.mapper;

import com.app.entity.TRemoteinfomanage;
import com.app.entity.TRemoteinfomanageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TRemoteinfomanageMapper {
	
	
	@Select("select * from protect.t_remoteinfomanage")
	List<TRemoteinfomanage> findAll();
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    long countByExample(TRemoteinfomanageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    int deleteByExample(TRemoteinfomanageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    int deleteByPrimaryKey(String infoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    int insert(TRemoteinfomanage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    int insertSelective(TRemoteinfomanage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    List<TRemoteinfomanage> selectByExample(TRemoteinfomanageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    TRemoteinfomanage selectByPrimaryKey(String infoId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    int updateByExampleSelective(@Param("record") TRemoteinfomanage record, @Param("example") TRemoteinfomanageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    int updateByExample(@Param("record") TRemoteinfomanage record, @Param("example") TRemoteinfomanageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    int updateByPrimaryKeySelective(TRemoteinfomanage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PROTECT.T_REMOTEINFOMANAGE
     *
     * @mbg.generated Sat Oct 27 11:19:42 CST 2018
     */
    int updateByPrimaryKey(TRemoteinfomanage record);
}