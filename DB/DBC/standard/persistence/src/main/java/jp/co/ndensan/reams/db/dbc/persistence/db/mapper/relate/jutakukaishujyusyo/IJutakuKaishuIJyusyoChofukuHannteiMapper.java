/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishujyusyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.JutakuKaishuJyusyoChofukuHannteiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujyusyo.JutakuKaishuJyusyoChofukuHannteiEntity;

/**
 *
 * @author ycb
 */
public interface IJutakuKaishuIJyusyoChofukuHannteiMapper {

    List<JutakuKaishuJyusyoChofukuHannteiEntity> selectKaishuJyusyoChofukuToroku(JutakuKaishuJyusyoChofukuHannteiMapperParameter parameter);

}
