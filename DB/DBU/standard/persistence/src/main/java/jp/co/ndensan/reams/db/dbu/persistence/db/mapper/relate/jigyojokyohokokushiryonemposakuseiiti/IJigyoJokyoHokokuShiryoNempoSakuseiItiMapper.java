/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyojokyohokokushiryonemposakuseiiti;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.jigyojokyohokokushiryonemposakuseiiti.JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyojokyohokokushiryonemposakuseiiti.JigyoHokokuDataRelateEntity;

/**
 *
 * 事業状況報告資料（年報）作成　一般状況（１～１１）のMapperクラスです。
 *
 * @reamsid_L DBU-5600-030 dingyi
 */
public interface IJigyoJokyoHokokuShiryoNempoSakuseiItiMapper {

    /**
     * 事業報告統計データの削除処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　一般状況（１～１１）パラメータ
     */
    void deleteJigyouHokokuTokei(JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter parameter);

    /**
     * 事業状況報告統計情報の取得処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　一般状況（１～１１）パラメータ
     *
     * @return 事業状況報告統計情報
     */
    List<JigyoHokokuDataRelateEntity> getJigyouHokokuTokeiJyoho(JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter parameter);

    /**
     * 処理日付管理マスタへ登録処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　一般状況（１～１１）パラメータ
     */
    void insertShoriDateKanri(JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter parameter);

    /**
     * 事業状況報告統計帳票用情報の取得処理です。
     *
     * @param parameter 事業状況報告資料（年報）作成　一般状況（１～１１）パラメータ
     *
     * @return 事業状況報告統計帳票用情報
     */
    List<JigyoHokokuDataRelateEntity> getJigyouHokokuTokeiReportJyoho(JigyoJokyoHokokuShiryoNempoSakuseiItiMybatisParamter parameter);

}
