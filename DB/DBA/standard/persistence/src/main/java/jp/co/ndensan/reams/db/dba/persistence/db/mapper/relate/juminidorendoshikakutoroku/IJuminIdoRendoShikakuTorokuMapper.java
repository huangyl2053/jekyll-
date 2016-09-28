/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.juminidorendoshikakutoroku;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.juminidorendoshikakutoroku.JuminIdoRendoShikakuTorokuMybatisParameter;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 宛名識別対象を取得めのMapperクラスです。
 *
 * @reamsid_L DBA-1410-010 yaodongsheng
 */
public interface IJuminIdoRendoShikakuTorokuMapper {

    /**
     * 宛名識別対象を取得します
     *
     * @param param JuminIdoRendoShikakuTorokuMybatisParameter
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity getShikibetsuTaishoPsm(JuminIdoRendoShikakuTorokuMybatisParameter param);
}
