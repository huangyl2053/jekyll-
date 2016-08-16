/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.choshuyuyo;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.ChoshuYuyoJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo.ChoshuYuyoJohoRelateSonotaMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.choshuyuyo.ChoshuYuyoJohoRelateEntity;

/**
 * 徴収猶予の情報のマッパーインタフェースです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public interface IChoshuYuyoJohoRelateMapper {

    /**
     * 徴収猶予の情報情報をキー検索で１件取得します。
     *
     * @param 徴収猶予の情報検索条件 徴収猶予の情報検索条件
     * @return ChoshuYuyoJohoRelateEntity
     */
    ChoshuYuyoJohoRelateEntity select徴収猶予の情報ByKey(ChoshuYuyoJohoRelateMapperParameter 徴収猶予の情報検索条件);

    /**
     * 徴収猶予の情報情報をキー検索で１件取得します。
     *
     * @param 徴収猶予の情報検索条件 徴収猶予の情報検索条件
     * @return ChoshuYuyoJohoRelateEntity
     */
    ChoshuYuyoJohoRelateEntity select徴収猶予の情報_決定更正後(ChoshuYuyoJohoRelateSonotaMapperParameter 徴収猶予の情報検索条件);

    /**
     * 徴収猶予の情報情報をキー検索で１件取得します。
     *
     * @param 徴収猶予の情報検索条件 徴収猶予の情報検索条件
     * @return ChoshuYuyoJohoRelateEntity
     */
    ChoshuYuyoJohoRelateEntity select徴収猶予の情報_取消更正後(ChoshuYuyoJohoRelateSonotaMapperParameter 徴収猶予の情報検索条件);

    /**
     * 徴収猶予の情報情報をキー検索で１件取得します。
     *
     * @param 徴収猶予の情報検索条件 徴収猶予の情報検索条件
     * @return ChoshuYuyoJohoRelateEntity
     */
    ChoshuYuyoJohoRelateEntity select徴収猶予の情報_最新(ChoshuYuyoJohoRelateMapperParameter 徴収猶予の情報検索条件);

    /**
     * 徴収猶予の情報情報をキー検索で１件取得します。
     *
     * @param 徴収猶予の情報検索条件 徴収猶予の情報検索条件
     * @return ChoshuYuyoJohoRelateEntity
     */
    ChoshuYuyoJohoRelateEntity select最新の徴収猶予の情報(ChoshuYuyoJohoRelateMapperParameter 徴収猶予の情報検索条件);
}
