package cn.connext.user.dao;

import cn.connext.user.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论模块消息层
 */
@Repository
public interface ComDao {
    void putCom(@Param("com") Comment com);

    void countAdd(@Param("mid") int mid);

    List<Comment> findCom(@Param("mid") int mid);

    void delCom(@Param("mid") int mid);

    void delComByCid(@Param("cid") int cid);

    void countMinus(@Param("mid") int mid);

    Comment getComByCid(@Param("cid") int cid);

}
