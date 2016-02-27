/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.yokaigoninteikubunhenkoshinseisho;

import jp.co.ndensan.reams.db.dba.definition.core.yokaigoninteikubunhenkoshinseisho.YokaigoNinteikubunHenkoShinseishoParameter;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 *
 * 要介護認定区分変更申請書Mapperクラスです。
 */
public interface IYokaigoNinteikubunHenkoShinseishoMapper {

    /**
     * 宛名識別対象を取得します。
     *
     * @param parameter 宛名識別対象PSM用パラメータ
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity getPsm(YokaigoNinteikubunHenkoShinseishoParameter parameter);
}
