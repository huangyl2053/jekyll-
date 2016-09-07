/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinchokudataoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinchokudataoutput.ShinchokuDataOutputMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.NinteichosahyoServiceJokyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.ShinchokuDataOutputRelateEntity;

/**
 * バッチ設計_DBE491001_日次進捗データ作成ですためのBatch用Mapperクラスです。
 *
 * @reamsid_L DBE-1500-020 wanghui
 */
public interface IShinchokuDataOutputMapper {

    /**
     * 調査票（概況調査）サービスの状況一時テーブルをキー検索で取得します。
     *
     * @param paramter ShinchokuDataOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<NinteichosahyoServiceJokyoRelateEntity> getNinteiShinseiJohoEntity(ShinchokuDataOutputMybitisParamter paramter);

    /**
     * 認定調査票（基本調査）調査項目一時テーブルをキー検索で取得します。
     *
     * @param paramter ShinchokuDataOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<NinteichosahyoServiceJokyoRelateEntity> getNinteichosahyoChosa(ShinchokuDataOutputMybitisParamter paramter);

    /**
     * 要介護認定主治医意見書意見項目一時テーブルをキー検索で取得します。
     *
     * @param paramter ShinchokuDataOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<NinteichosahyoServiceJokyoRelateEntity> get要介護認定主治医意見書意見項目(ShinchokuDataOutputMybitisParamter paramter);

    /**
     * 前回調査票（概況調査）サービスの状況一時テーブルをキー検索で取得します。
     *
     * @param paramter ShinchokuDataOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<NinteichosahyoServiceJokyoRelateEntity> get前回調査票概況調査サービスの状況(ShinchokuDataOutputMybitisParamter paramter);

    /**
     * 前回調査票（概況調査）サービスの状況一時テーブルをキー検索で取得します。
     *
     * @param paramter ShinchokuDataOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<NinteichosahyoServiceJokyoRelateEntity> get前回認定調査票基本調査調査項目(ShinchokuDataOutputMybitisParamter paramter);

    /**
     * 日次進捗データ作成CSV出力をキー検索で取得します。
     *
     * @param paramter ShinchokuDataOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<ShinchokuDataOutputRelateEntity> get日次進捗データ作成CSV出力(ShinchokuDataOutputMybitisParamter paramter);
}
