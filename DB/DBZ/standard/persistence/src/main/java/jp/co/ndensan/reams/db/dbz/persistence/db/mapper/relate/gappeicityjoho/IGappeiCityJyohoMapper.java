/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.gappeicityjoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.gappeijoho.GappeiJyohoSpecificParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.GappeiCityJyohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.KouikiGappeiJyohoRelateEntity;

/**
 * 合併市町村情報取得用データアクセスクラスです。
 *
 * @reamsid_L DBU-0090-010 linghuhang
 */
public interface IGappeiCityJyohoMapper {

    /**
     * 単一全合併市町村情報の取得処理します。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiCityJyohoRelateEntity>
     */
    List<GappeiCityJyohoRelateEntity> getTannitsugappeijoho(GappeiJyohoSpecificParameter params);

    /**
     * 単一全合併市町村情報検索の取得処理します。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiCityJyohoRelateEntity>
     */
    List<GappeiCityJyohoRelateEntity> getTannitsugappeijohokensaku(GappeiJyohoSpecificParameter params);

    /**
     * 広域全合併市町村情報の取得処理します。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiCityJyohoRelateEntity>
     */
    List<GappeiCityJyohoRelateEntity> getKouikigappeijoho(GappeiJyohoSpecificParameter params);

    /**
     * 広域全合併市町村情報検索の取得処理します。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiCityJyohoRelateEntity>
     */
    List<GappeiCityJyohoRelateEntity> getKouikigappeijohokensaku(GappeiJyohoSpecificParameter params);

    /**
     * 最新単一合併市町村情報の取得処理します。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiCityJyohoRelateEntity>
     */
    List<GappeiCityJyohoRelateEntity> getSaishintannitsugappeijoho(GappeiJyohoSpecificParameter params);

    /**
     * 最新広域合併市町村情報の取得処理します。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiCityJyohoRelateEntity>
     */
    List<GappeiCityJyohoRelateEntity> getKouikigappeijohokennsaku(GappeiJyohoSpecificParameter params);

    /**
     * 合併市町村情報検索の取得処理します。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiCityJyohoRelateEntity>
     */
    List<GappeiCityJyohoRelateEntity> getSennyoukouikigappeijohokensaku単一(GappeiJyohoSpecificParameter params);

    /**
     * 合併市町村情報検索の取得処理します。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiCityJyohoRelateEntity>
     */
    List<GappeiCityJyohoRelateEntity> getSennyoukouikigappeijohokensaku広域(GappeiJyohoSpecificParameter params);

    /**
     * 検索キーによる単一合併市町村情報の取得処理します。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiCityJyohoRelateEntity>
     */
    List<GappeiCityJyohoRelateEntity> getKensakukitannitsugappeijoho(GappeiJyohoSpecificParameter params);

    /**
     * 検索キーによる広域合併市町村情報の取得処理します。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<KouikiGappeiJyohoRelateEntity>
     */
    List<KouikiGappeiJyohoRelateEntity> getKensakukikouikigappeijoho(GappeiJyohoSpecificParameter params);

    /**
     * ソート順を指定して全合併旧市町村情報を取得します（広域内合併に対応する）。
     *
     * @param params 合併市町村情報取得用パラメータクラス
     * @return List<GappeiCityJyohoRelateEntity>
     */
    List<GappeiCityJyohoRelateEntity> getKouikigappeijohoWithSort(GappeiJyohoSpecificParameter params);
}
