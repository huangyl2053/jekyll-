/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.benmeisyo;

import jp.co.ndensan.reams.db.dbu.definition.core.benmeisyo.BenmeiAtenaParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.benmeisyo.BenmeisyoMapperParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.benmeisyo.BenmeiJohoResultEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 弁明情報取得のマッパーインタフェースです。
 *
 * @reamsid_L DBU-1080-010 zhengshukai
 *
 */
public interface IBenmeisyoMapper {

    /**
     * 弁明情報を検索です。
     *
     * @param 検索条件 弁明情報パラメータ
     * @return BenmeiJohoResultEntity
     */
    BenmeiJohoResultEntity getBenmeijoho(BenmeisyoMapperParameter 検索条件);

    /**
     * 宛名識別対象PSMを検索です。
     *
     * @param param 宛名識別対象PSMパラメータ
     * @return UaFt200FindShikibetsuTaishoEntity
     */
    UaFt200FindShikibetsuTaishoEntity selectAtena(BenmeiAtenaParameter param);
}
