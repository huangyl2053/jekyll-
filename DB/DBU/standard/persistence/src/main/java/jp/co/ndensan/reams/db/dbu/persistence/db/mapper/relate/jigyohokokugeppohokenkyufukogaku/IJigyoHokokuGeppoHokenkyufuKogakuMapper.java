/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppohokenkyufukogaku.JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogaku.JigyoHokokuDataCsvRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogaku.JigyoJoukyouHoukokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogaku.ShoriKekkaKakuninListRelateEntity;

/**
 * 事業状況報告資料（月報）作成 保険給付決定情報（高額介護サービス費）のMapperクラスです。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
public interface IJigyoHokokuGeppoHokenkyufuKogakuMapper {

    /**
     * 事業状況報告情報へ登録処理です。
     *
     * @param parameter 事業状況報告情報パラメータ
     */
    void insertKougakuData(JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter parameter);

    /**
     * 処理日付管理マスタへ登録処理です。
     *
     * @param parameter 処理日付管理パラメータ
     */
    void insertShoriDateKanri(JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter parameter);

    /**
     * 事業報告統計データの削除処理です。
     *
     * @param parameter 事業状況報告資料パラメータ
     */
    void deleteJigyoHokokuDataToroku(JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter parameter);

    /**
     * 処理結果確認リスト情報の取得処理です。
     *
     * @param parameter 処理結果確認リスト情報パラメータ
     * @return 処理結果確認リスト情報
     */
    List<ShoriKekkaKakuninListRelateEntity> getShoriKekkaKakuninListReport(JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter parameter);

    /**
     * 事業状況報告情報の取得処理です。
     *
     * @param parameter 事業状況報告情報パラメータ
     * @return 事業状況報告情報
     */
    List<JigyoHokokuDataCsvRelateEntity> getJigyoHokokuDataCsv(JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter parameter);

    /**
     * 事業状況報告統計情報の取得処理です。
     *
     * @param parameter 事業状況報告統計情報パラメータ
     * @return 事業状況報告統計情報
     */
    List<JigyoJoukyouHoukokuDataRelateEntity> getJigyohokokuCompYoshiki271Report(JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter parameter);

    /**
     * 事業状況報告統計情報の取得処理です。
     *
     * @param parameter 事業状況報告統計情報パラメータ
     * @return 事業状況報告統計情報
     */
    List<JigyoJoukyouHoukokuDataRelateEntity> getJigyoHokokuDataToroku(JigyoHokokuGeppoHokenkyufuKogakuMybatisParamter parameter);

    /**
     * 事業状況報告統計情報の取得処理です。
     *
     * @return 事業状況報告統計情報
     */
    DbT7021JigyoHokokuTokeiDataEntity selectAll();

    /**
     * 事業状況報告統計元TEMPテーブルを作成します。
     */
    void createTempJigyouJyoukyouHoukokuKougakuMotoData();
}
