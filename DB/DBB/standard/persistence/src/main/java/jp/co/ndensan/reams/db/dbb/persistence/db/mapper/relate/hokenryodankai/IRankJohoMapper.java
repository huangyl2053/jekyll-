/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.hokenryodankai;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.hokenryodankai.RankJohoMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.hokenryodankai.RankJohoEntity;

/**
 * ランク情報のマッパーインタフェースです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public interface IRankJohoMapper {

    /**
     * ランク情報情報をキー検索で１件取得します。
     *
     * @param ランク情報検索条件 ランク情報検索条件
     * @return RankJohoEntity
     */
    RankJohoEntity selectランク情報ByKey(RankJohoMapperParameter ランク情報検索条件);

}
