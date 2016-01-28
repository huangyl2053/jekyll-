/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteischedule.chikushichoson;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteischedule.chikushichoson.ChikuShichosonMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.chikushichoson.ChikuShichosonEntity;

/**
 * 地区市町村のマッパーインタフェースです。
 */
public interface IChikuShichosonMapper {

    /**
     * 地区市町村情報をキー検索で１件取得します。
     *
     * @param 地区市町村検索条件 地区市町村検索条件
     * @return ChikuShichosonEntity
     */
    ChikuShichosonEntity select地区市町村ByKey(ChikuShichosonMapperParameter 地区市町村検索条件);
}
