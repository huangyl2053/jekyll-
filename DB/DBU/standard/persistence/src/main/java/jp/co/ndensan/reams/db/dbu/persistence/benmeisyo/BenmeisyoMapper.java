/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.benmeisyo;

import jp.co.ndensan.reams.db.dbu.definition.core.benmeisyo.BenmeiAtenaParameter;
import jp.co.ndensan.reams.db.dbu.definition.core.benmeisyo.BenmeisyoMapperParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.benmeisyo.BenmeiJohoResultEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 *
 * 弁明情報取得のマッパーインタフェースです。
 */
public interface BenmeisyoMapper {

    BenmeiJohoResultEntity getBenmeijoho(BenmeisyoMapperParameter 検索条件);

    UaFt200FindShikibetsuTaishoEntity selectAtena(BenmeiAtenaParameter param);
}
