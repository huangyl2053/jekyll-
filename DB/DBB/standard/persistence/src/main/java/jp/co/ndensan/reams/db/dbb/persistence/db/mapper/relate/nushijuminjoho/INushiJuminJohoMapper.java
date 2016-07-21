/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nushijuminjoho;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nushijuminjoho.NushiJuminJohoParameter;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 画面設計_DBBGM51002_所得照会票作成
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public interface INushiJuminJohoMapper {

    /**
     * 宛名識別対象の取得する
     *
     * @param parameter NushiJuminJohoParameter
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity get宛名識別対象(NushiJuminJohoParameter parameter);

}
