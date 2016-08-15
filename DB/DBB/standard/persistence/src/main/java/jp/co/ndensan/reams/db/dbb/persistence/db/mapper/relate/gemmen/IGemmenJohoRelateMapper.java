/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.gemmen;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen.GemmenJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen.GemmenJohoRelateSonotaMapperParameter;
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

    /**
     * 最新の減免情報をキー検索で１件取得します。
     *
     * @param 減免の情報検索条件 減免の情報検索条件
     * @return GemmenJohoRelateEntity
     */
    List<GemmenJohoRelateEntity> select最新の減免情報ByKey(GemmenJohoRelateMapperParameter 減免の情報検索条件);

    /**
     * 減免の情報情報をキー検索で１件取得します。
     *
     * @param 減免の情報検索条件 減免の情報検索条件
     * @return GemmenJohoRelateEntity
     */
    GemmenJohoRelateEntity select減免の情報_決定更正後(GemmenJohoRelateSonotaMapperParameter 減免の情報検索条件);

    /**
     * 減免の情報情報をキー検索で１件取得します。
     *
     * @param 減免の情報検索条件 減免の情報検索条件
     * @return GemmenJohoRelateEntity
     */
    GemmenJohoRelateEntity select減免の情報_取消更正後(GemmenJohoRelateSonotaMapperParameter 減免の情報検索条件);
}
