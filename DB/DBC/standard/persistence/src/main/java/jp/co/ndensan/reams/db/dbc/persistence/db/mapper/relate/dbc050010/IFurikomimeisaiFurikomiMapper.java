/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.ShoukanFurikomiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetaiResultEntity;

/**
 * 償還データ取得のmapperです
 *
 * @reamsid_L DBC-2180-030 x_miaocl
 */
public interface IFurikomimeisaiFurikomiMapper {

    /**
     * 償還データ情報を取得します．
     *
     * @param parameter SQL用パラメター
     * @return 償還データ取得情報
     */
    List<FurikomiDetaiResultEntity> get償還データ取得(ShoukanFurikomiMybatisParameter parameter);
}
