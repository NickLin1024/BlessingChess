package com.example.BlessingChess.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.BlessingChess.data.po.Blessing;
import com.example.BlessingChess.data.po.GreetingCard;
import com.example.BlessingChess.data.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlessingMapper extends BaseMapper<Blessing> {

    /**
     * 根据发送者 ID 查询 Blessing 列表。
     *
     * @param id 发送者的 ID
     * @return Blessing 列表，包含所有由指定发送者发送的卡片
     */
    @Select("select id,sender_id,receiver_id,delivery_time,content,icon,background,is_viewed,is_public from blessing where sender_id = #{id}")
     List<Blessing> selectBySenderId(Integer id);

    /**
     * 根据接收者 ID 查询 Blessing 列表。
     *
     * @param id 接收者的 ID
     * @return Blessing 列表，包含所有发送给指定接收者的卡片
     */
    @Select("select * from blessing where receiver_id = #{id} and is_viewed = 1")
    public List<Blessing> selectByReceiverId(Integer id);

    /**
     * 插入新祝福
     *
     * @param blessing 需要插入的祝福对象
     */
    @Insert("insert into blessing(sender_id,receiver_id,delivery_time,content,icon,background,is_viewed,is_public) values (#{senderId}, #{receiverId}, #{deliveryTime}, #{content},#{icon},#{background},#{isViewed},#{isPublic})")
    public void insertNewBlessing(Blessing blessing);

    /**
     * 更改祝福
     *
     * @param blessing 需要更改的祝福对象
     */
    @Update("update blessing set receiver_id = #{receiverId}, content=#{content}, icon=#{icon}, background=#{background}, is_public=#{isPublic} where id = #{id}")
    public void updateBlessing(Blessing blessing);

    /**
     * 删除祝福
     *
     * @param id 需要删除的祝福id
     */
    @Delete("DELETE FROM blessing WHERE id=#{id}")
    void deleteBlessing(Integer id);

    @Select("select * from blessing where id = #{id}")
    Blessing selectByBlessingId(Integer id);

    @Select("select * from blessing where receiver_id = #{id} and is_viewed = 0")
    public List<Blessing> selectNewByReceiverId(Integer id);
}
