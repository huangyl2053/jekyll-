/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogakugassan;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokugeppohokenkyufukogakugassan.JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogakugassan.JigyoHokokuDataCsvRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogakugassan.JigyoJoukyouHoukokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogakugassan.ShoriKekkaKakuninListRelateEntity;

/**
 * 事業状況報告資料（月報）作成 保険給付決定状況（高額合算分）のMapperクラスです。
 *
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
public interface IJigyoHokokuGeppoHokenkyufuKogakuGassanMapper {

    /**
     * 事業状況報告情報へ登録処理です。
     *
     * @param parameter 事業状況報告情報パラメータ
     */
    void insertKougakuData(JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter parameter);

    /**
     * 処理日付管理マスタへ登録処理です。
     *
     * @param parameter 処理日付管理パラメータ
     */
    void insertShoriDateKanri(JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter parameter);

    /**
     * 事業報告統計データの削除処理です。
     *
     * @param parameter 事業状況報告資料パラメータ
     */
    void deleteJigyoHokokuDataToroku(JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter parameter);

    /**
     * 処理結果確認リスト情報の取得処理です。
     *
     * @param parameter 処理結果確認リスト情報パラメータ
     * @return 処理結果確認リスト情報
     */
    List<ShoriKekkaKakuninListRelateEntity> getShoriKekkaKakuninListReport(JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter parameter);

    /**
     * 事業状況報告情報の取得処理です。
     *
     * @param parameter 事業状況報告情報パラメータ
     * @return 事業状況報告情報
     */
    List<JigyoHokokuDataCsvRelateEntity> getJigyoHokokuDataCsv(JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter parameter);

    /**
     * 事業状況報告統計情報の取得処理です。
     *
     * @param parameter 事業状況報告統計情報パラメータ
     * @return 事業状況報告統計情報
     */
    List<JigyoJoukyouHoukokuDataRelateEntity> getJigyohokokuCompYoshiki272Report(JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter parameter);

    /**
     * 事業状況報告統計情報の取得処理です。
     *
     * @param parameter 事業状況報告統計情報パラメータ
     * @return 事業状況報告統計情報
     */
    List<JigyoJoukyouHoukokuDataRelateEntity> getJigyoHokokuDataToroku(JigyoHokokuGeppoHokenkyufuKogakuGassanMybatisParamter parameter);

    /**
     * 事業状況報告統計情報の取得処理です。
     *
     * @return 事業状況報告統計情報
     */
    DbT7021JigyoHokokuTokeiDataEntity selectAll();

    /**
     * 事業状況報告統計元TEMPテーブルを作成します。
     */
    void createTempJigyouJyoukyouHoukokuGassanMotoData();
}
