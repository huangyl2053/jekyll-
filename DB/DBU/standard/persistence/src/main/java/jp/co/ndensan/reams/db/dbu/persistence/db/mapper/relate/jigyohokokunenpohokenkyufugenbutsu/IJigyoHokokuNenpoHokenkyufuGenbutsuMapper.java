/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpohokenkyufugenbutsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpohokenkyufugenbutsu.JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoippangenbutsu.GassanJigyouHoukokuTokeiEntity;

/**
 * 事業状況報告資料（年報）作成　保険給付決定状況のMapperクラスです。
 *
 * @reamsid_L DBU-5600-050 lishengli
 */
public interface IJigyoHokokuNenpoHokenkyufuGenbutsuMapper {

    /**
     * 事業報告統計データの削除処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　保険給付決定状況パラメータ
     */
    void deleteJigyouHokokuTokei(JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter parameter);

    /**
     * 事業状況報告統計情報の取得処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　保険給付決定状況パラメータ
     *
     * @return 事業状況報告統計情報
     */
    List<GassanJigyouHoukokuTokeiEntity> getJigyouHokokuTokeiJyoho(JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter parameter);

    /**
     * 処理日付管理マスタへ登録処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　保険給付決定状況パラメータ
     */
    void insertShoriDateKanri(JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter parameter);

    /**
     * 事業状況報告統計帳票用情報の取得処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　保険給付決定状況パラメータ
     *
     * @return 事業状況報告統計帳票用情報
     */
    List<GassanJigyouHoukokuTokeiEntity> getJigyouHokokuTokeiReportJyoho(JigyoHokokuNenpoHokenkyufuGenbutsuMybatisParamter parameter);
}
