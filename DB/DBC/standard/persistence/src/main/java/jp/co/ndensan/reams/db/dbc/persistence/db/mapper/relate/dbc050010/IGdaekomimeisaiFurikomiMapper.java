/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.KogakuFurikomiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.GdaekomiDetaiResultEntity;

/**
 * 高額データ取得のmapperです
 *
 * @reamsid_L DBC-2180-030 x_miaocl
 */
public interface IGdaekomimeisaiFurikomiMapper {

    /**
     * 高額データ取得します．
     *
     * @param parameter SQL用パラメター
     * @return 高額データ情報
     */
    List<GdaekomiDetaiResultEntity> get高額データ取得(KogakuFurikomiMybatisParameter parameter);

}
