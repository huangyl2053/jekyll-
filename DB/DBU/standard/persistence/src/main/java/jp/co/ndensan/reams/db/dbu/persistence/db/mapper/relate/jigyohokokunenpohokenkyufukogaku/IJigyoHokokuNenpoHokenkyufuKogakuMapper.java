/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpohokenkyufukogaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpohokenkyufukogaku.JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoippangenbutsu.GassanJigyouHoukokuTokeiEntity;

/**
 * 事業状況報告資料（年報）作成　保険給付決定状況(高額分)のMapperクラスです。
 *
 * @reamsid_L DBU-5600-060 lishengli
 */
public interface IJigyoHokokuNenpoHokenkyufuKogakuMapper {

    /**
     * 事業報告統計データの削除処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　保険給付決定状況(高額分)
     */
    void deleteJigyouHokokuTokei(JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter parameter);

    /**
     * 事業状況報告統計情報の取得処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　保険給付決定状況(高額分)
     *
     * @return 事業状況報告統計情報
     */
    List<GassanJigyouHoukokuTokeiEntity> getJigyouHokokuTokeiJyoho(JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter parameter);

    /**
     * 処理日付管理マスタへ登録処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　保険給付決定状況(高額分)
     */
    void insertShoriDateKanri(JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter parameter);

    /**
     * 事業状況報告統計帳票用情報の取得処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　保険給付決定状況(高額分)
     *
     * @return 事業状況報告統計帳票用情報
     */
    List<GassanJigyouHoukokuTokeiEntity> getJigyouHokokuTokeiReportJyoho(JigyoHokokuNenpoHokenkyufuKogakuMybatisParamter parameter);
}
