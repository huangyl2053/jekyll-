/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteizumifoutput;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.itizihanteishori.ItziHanteiShoriMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.NinteichosahyoServiceJokyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.niinteichosajoho.ShinchokuDataOutputRelateEntity;

/**
 * バッチ設計_DBE309001_一次判定IF作成のMapperクラスです。
 *
 * @reamsid_L DBE-1470-021 wanghui
 */
public interface IchijiHanteizumIfOutputMapper {

    /**
     * 調査票（概況調査）サービスの状況一時テーブルをキー検索で取得します。
     *
     * @param paramter IchijiHanteizumIfOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<NinteichosahyoServiceJokyoRelateEntity> getNinteiShinseiJohoEntity(ItziHanteiShoriMybitisParamter paramter);

    /**
     * 認定調査票（基本調査）調査項目一時テーブルをキー検索で取得します。
     *
     * @param paramter IchijiHanteizumIfOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<NinteichosahyoServiceJokyoRelateEntity> getNinteichosahyoChosa(ItziHanteiShoriMybitisParamter paramter);

    /**
     * 要介護認定主治医意見書意見項目一時テーブルをキー検索で取得します。
     *
     * @param paramter IchijiHanteizumIfOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<NinteichosahyoServiceJokyoRelateEntity> get要介護認定主治医意見書意見項目(ItziHanteiShoriMybitisParamter paramter);

    /**
     * 前回調査票（概況調査）サービスの状況一時テーブルをキー検索で取得します。
     *
     * @param paramter IchijiHanteizumIfOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<NinteichosahyoServiceJokyoRelateEntity> get前回調査票概況調査サービスの状況(ItziHanteiShoriMybitisParamter paramter);

    /**
     * 前回調査票（概況調査）サービスの状況一時テーブルをキー検索で取得します。
     *
     * @param paramter IchijiHanteizumIfOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<NinteichosahyoServiceJokyoRelateEntity> get前回認定調査票基本調査調査項目(ItziHanteiShoriMybitisParamter paramter);

    /**
     * 日次進捗データ作成CSV出力をキー検索で取得します。
     *
     * @param paramter IchijiHanteizumIfOutputMybitisParamter
     * @return NinteichosahyoServiceJokyoRelateEntity
     */
    List<ShinchokuDataOutputRelateEntity> get日次進捗データ作成CSV出力(ItziHanteiShoriMybitisParamter paramter);
}
