package cn.connext.messages.dao;

import cn.connext.messages.entity.Mes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * 消息模块持久层
 * */
@Repository
public interface MesDao {
    String findTitle(@Param("title") String title);

    String findText(@Param("title") String title);

    List<Mes> findMes(@Param("phone") String phone);

    void saveMes(@Param("mes") Mes mes);

    void delMes(@Param("title") String title);

}
