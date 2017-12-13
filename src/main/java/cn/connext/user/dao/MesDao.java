package cn.connext.user.dao;

import cn.connext.user.entity.Mes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * 消息模块持久层
 * */
@Repository
public interface MesDao {

    String findTitle(@Param("title") String title);

    Mes findText(@Param("mid") int mid);

    List<Mes> findMes(@Param("phone") String phone);

    List<Mes> findAll();

    void saveMes(@Param("mes") Mes mes);

    void delMes(@Param("mid") int mid);

    void editMes(@Param("mes") Mes mes);

}
