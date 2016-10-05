/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.saishinsamoshitate;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.saishinsamoshitate.SaishinsamoshitateMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitate.SaishinsaMoshitateRelateEntity;

/**
 * 汎用リスト 再審査申立情報のマッパーインタフェースです。
 *
 * @reamsid_L DBC-3106-020 zhengsongling
 */
public interface ISaishinsaMoshitateMapper {

    /**
     * 再審査申立情報データを取得します。
     *
     * @param parameter parameter
     * @return SaishinsaMoshitateRelateEntity
     */
    List<SaishinsaMoshitateRelateEntity> get再審査申立情報(SaishinsamoshitateMybatisParameter parameter);
}
