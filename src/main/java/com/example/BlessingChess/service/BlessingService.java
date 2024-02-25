package com.example.BlessingChess.service;

import com.example.BlessingChess.data.dto.BlessingReceiver;
import com.example.BlessingChess.data.po.Blessing;
import com.example.BlessingChess.data.vo.Result;
import com.example.BlessingChess.mapper.BlessingMapper;
import com.example.BlessingChess.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlessingService {
    //注入BlessingMapper
    @Autowired
    BlessingMapper blessingMapper;
    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户ID查询所有该用户收到的祝福。
     *
     * @param id 用户的ID
     * @return 查询结果，包含贺卡信息的列表,如果错误返回error
     */
    public Result selectByReceiverId(Integer id){
        if (id == null) {
            return Result.error(0,"id不能为空");
        }
        return Result.success(blessingMapper.selectByReceiverId(id),"success");
    }
    /**
     * 根据用户ID查询所有该用户发送的贺卡。
     *
     * @param id 用户的ID
     * @return 查询结果，包含贺卡信息的列表,如果错误返回error
     */
    public Result selectBySenderId(Integer id){
        //TODO 健壮性！！
        if (id == null) {
            return Result.error(0,"id不能为空");
        }
        return Result.success(blessingMapper.selectBySenderId(id),"success");
    }

    /**
     * 插入新祝福
     * @param blessingReceiver 前端传入的dto数据
     * @return Result.ok()
     */
    public Result insertNewBlessing(BlessingReceiver blessingReceiver) {
        if (blessingReceiver == null) {
            return Result.error(0,"用户格式错误");
        }
        if (blessingReceiver.getInvitationCode() == null) {
            return Result.error(0,"用户邀请码为空");
        }
        Blessing blessing =new Blessing(blessingReceiver);
        blessing.setViewed(false);
        try {
            blessing.setReceiverId(userMapper.findUserByInvitationCode(blessingReceiver.getInvitationCode()).getId());
            blessingMapper.insertNewBlessing(blessing);
        }catch (NullPointerException e){    //假如邀请码不存在
            return Result.error(0,"邀请码不存在！");
        }
        return Result.ok();
    }

    /**
     * 更改祝福
     * @param blessingReceiver 前端传入的dto数据
     * @return Result.ok()
     */
    public Result updateBlessing(Integer id,BlessingReceiver blessingReceiver) {
        if (blessingReceiver == null) {
            return Result.error(0,"用户格式错误");
        }
        if (blessingMapper.selectByBlessingId(id) == null) {
            return Result.error(0,"无此贺卡,无法更改");
        }
        Blessing blessing =new Blessing(blessingReceiver);
        blessing.setViewed(false);
        blessing.setReceiverId(userMapper.findUserByInvitationCode(blessingReceiver.getInvitationCode()).getId());
        blessingMapper.updateBlessing(blessing);
        return Result.ok();
    }

    /**
     * 删除祝福
     * @param id
     * @return Result.ok()
     */
    public Result deleteBlessing(Integer id) {
        if (blessingMapper.selectByBlessingId(id) == null) {
            return Result.error(0,"无此贺卡,无法删除");
        }
        ;
        if ( blessingMapper.selectByBlessingId(id).isViewed() == true) {
            return Result.error(0,"已查看祝福不能删除");
        }
        blessingMapper.deleteBlessing(id);
        return Result.ok();
    }
}
