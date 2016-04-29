/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jukyushikakushomeisho;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jukyushikakushomeisho.JukyuShikakuShomeishoMyBatisParameter;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 受給資格証明書データ作成 Mapper
 *
 * @reamsid_L DBU-0490-050 wangchao
 */
public interface IJukyuShikakuShomeishoMapper {

    /**
     * 宛名識別対象PSMを取得します。
     *
     * @param searchkey JukyuShikakuShomeishoMyBatisParameter
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity get宛名識別対象PSM(JukyuShikakuShomeishoMyBatisParameter searchkey);

}
