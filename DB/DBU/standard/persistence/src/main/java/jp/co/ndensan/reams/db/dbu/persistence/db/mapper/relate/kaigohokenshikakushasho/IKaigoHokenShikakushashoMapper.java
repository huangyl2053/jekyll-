/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigohokenshikakushasho;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigohokenshikakushasho.KaigoHokenShikakushashoParameter;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 介護保険資格者証のMapperです。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
public interface IKaigoHokenShikakushashoMapper {

    /**
     * 宛名識別対象を取得します。
     *
     * @param parameter 宛名識別対象PSM用パラメータ
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity getPsmShikibetsuTaisho(KaigoHokenShikakushashoParameter parameter);
}
