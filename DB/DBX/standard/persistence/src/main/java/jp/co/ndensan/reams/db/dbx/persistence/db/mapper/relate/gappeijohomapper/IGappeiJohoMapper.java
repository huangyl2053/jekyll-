/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.gappeijohomapper;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.gappeijoho.GappeiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.gappeijoho.GappeiJyohoSpecificParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.GappeiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.GappeiJyohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KouikiGappeiJyohoEntity;

/**
 * 合併情報のマッパーインタフェースです。
 */
public interface IGappeiJohoMapper {

    /**
     * 合併情報情報をキー検索で１件取得します。
     *
     * @param 合併情報検索条件 合併情報検索条件
     * @return GappeiJohoRelateEntity
     */
    GappeiJohoRelateEntity getGappeiJohoRelateEntity(GappeiJohoMapperParameter 合併情報検索条件);

    /**
     * 単一全合併市町村情報の取得処理
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiJyohoEntity>
     */
    List<GappeiJyohoEntity> getTannitsugappeijoho(GappeiJyohoSpecificParameter params);

    /**
     * 単一全合併市町村情報検索の取得処理
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiJyohoEntity>
     */
    List<GappeiJyohoEntity> getTannitsugappeijohokensaku(GappeiJyohoSpecificParameter params);

    /**
     * 広域全合併市町村情報の取得処理
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiJyohoEntity>
     */
    List<GappeiJyohoEntity> getKouikigappeijoho(GappeiJyohoSpecificParameter params);

    /**
     * 広域全合併市町村情報検索の取得処理
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiJyohoEntity>
     */
    List<GappeiJyohoEntity> getKouikigappeijohokensaku(GappeiJyohoSpecificParameter params);

    /**
     * 最新単一合併市町村情報の取得処理
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiJyohoEntity>
     */
    List<GappeiJyohoEntity> getSaishintannitsugappeijoho(GappeiJyohoSpecificParameter params);

    /**
     * 最新広域合併市町村情報の取得処理
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiJyohoEntity>
     */
    List<GappeiJyohoEntity> getKouikigappeijohokennsaku(GappeiJyohoSpecificParameter params);

    /**
     * 検索キーによる単一合併市町村情報の取得処理
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiJyohoEntity>
     */
    List<GappeiJyohoEntity> getKensakukitannitsugappeijoho(GappeiJyohoSpecificParameter params);

    /**
     * 検索キーによる広域合併市町村情報の取得処理
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<KouikiGappeiJyohoEntity>
     */
    List<KouikiGappeiJyohoEntity> getKensakukikouikigappeijoho(GappeiJyohoSpecificParameter params);

}
