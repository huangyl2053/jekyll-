/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.gemmen;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen.GemmenJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen.GemmenJohoRelateEntity;

/**
 * 減免の情報のマッパーインタフェースです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public interface IGemmenJohoRelateMapper {

    /**
     * 減免の情報情報をキー検索で１件取得します。
     *
     * @param 減免の情報検索条件 減免の情報検索条件
     * @return GemmenJohoRelateEntity
     */
    GemmenJohoRelateEntity select減免の情報ByKey(GemmenJohoRelateMapperParameter 減免の情報検索条件);

}
