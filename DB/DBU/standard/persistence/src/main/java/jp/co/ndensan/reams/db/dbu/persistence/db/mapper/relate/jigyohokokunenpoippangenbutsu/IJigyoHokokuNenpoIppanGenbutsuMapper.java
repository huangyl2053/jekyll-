/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpoippangenbutsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyohokokunenpoippangenbutsu.JigyoHokokuNenpoIppanGenbutsuMybatisParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoippangenbutsu.GassanJigyouHoukokuTokeiEntity;

/**
 * 事業状況報告資料（年報）作成　一般状況（１２～１４）のMapperクラスです。
 *
 * @reamsid_L DBU-5600-040 lishengli
 */
public interface IJigyoHokokuNenpoIppanGenbutsuMapper {

    /**
     * 事業報告統計データの削除処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成 一般状況（１２～１４）パラメータ
     */
    void deleteJigyouHokokuTokei(JigyoHokokuNenpoIppanGenbutsuMybatisParamter parameter);

    /**
     * 事業状況報告統計情報の取得処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成 一般状況（１２～１４）パラメータ
     *
     * @return 事業状況報告統計情報
     */
    List<GassanJigyouHoukokuTokeiEntity> getJigyouHokokuTokeiJyoho(JigyoHokokuNenpoIppanGenbutsuMybatisParamter parameter);

    /**
     * 処理日付管理マスタへ登録処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成 一般状況（１２～１４）パラメータ
     */
    void insertShoriDateKanri(JigyoHokokuNenpoIppanGenbutsuMybatisParamter parameter);

    /**
     * 事業状況報告統計帳票用情報の取得処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成 一般状況（１２～１４）パラメータ
     *
     * @return 事業状況報告統計帳票用情報
     */
    List<GassanJigyouHoukokuTokeiEntity> getJigyouHokokuTokeiReportJyoho(JigyoHokokuNenpoIppanGenbutsuMybatisParamter parameter);
}
