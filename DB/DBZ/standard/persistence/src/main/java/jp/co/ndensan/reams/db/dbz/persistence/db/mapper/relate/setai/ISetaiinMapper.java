/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.setai;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.setai.SetaiinParameter;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 世帯員取得データ作成 Mapper
 *
 * @reamsid_L DBB-1750-030 sunhui
 */
public interface ISetaiinMapper {

    /**
     * 宛名識別対象PSMから識別対象を取得する。
     *
     * @param searchkey searchkey
     * @return List<UaFt200FindShikibetsuTaishoEntity>
     */
    List<UaFt200FindShikibetsuTaishoEntity> get宛名識別対象PSM(SetaiinParameter searchkey);

}
