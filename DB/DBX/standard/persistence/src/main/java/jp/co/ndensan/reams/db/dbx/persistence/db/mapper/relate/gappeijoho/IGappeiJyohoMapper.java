/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.gappeijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.gappeijoho.GappeiJyohoSpecificParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.GappeiJyohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho.KouikiGappeiJyohoEntity;

/**
 * 合併市町村情報取得用データアクセスクラスです。
 */
public interface IGappeiJyohoMapper {

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
