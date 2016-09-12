/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichigojihanteikekkajoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJohoEntity;

/**
 * 一五次判定結果情報のマッパーインタフェースです。
 *
 * @reamsid_L DBE-3000-290 chenxiangyu
 */
public interface IIchiGojiHanteiKekkaJohoMapper {

    /**
     * 厚労省IF識別コードを取得します。
     *
     * @param 一五次判定結果情報_検索条件 一五次判定結果情報_検索条件
     * @return IchiGojiHanteiKekkaJohoEntity
     */
    IchiGojiHanteiKekkaJohoEntity getKoroshoIfShikibetsuCode(IchiGojiHanteiKekkaJohoMapperParameter 一五次判定結果情報_検索条件);

    /**
     * 一五次判定結果情報を取得します。
     *
     * @param 一五次判定結果情報_検索条件 一五次判定結果情報_検索条件
     * @return IchiGojiHanteiKekkaJohoEntity
     */
    IchiGojiHanteiKekkaJohoEntity getIchiGojiHanteiKekkaJoho(IchiGojiHanteiKekkaJohoMapperParameter 一五次判定結果情報_検索条件);

    /**
     * 認定調査結果_件数を取得します。
     *
     * @param 一五次判定結果情報_検索条件 一五次判定結果情報_検索条件
     * @return 認定調査結果件数
     */
    Integer get認定調査結果件数(IchiGojiHanteiKekkaJohoMapperParameter 一五次判定結果情報_検索条件);

    /**
     * 主治医意見書_件数を取得します。
     *
     * @param 一五次判定結果情報_検索条件 一五次判定結果情報_検索条件
     * @return 主治医意見書件数
     */
    Integer get主治医意見書件数(IchiGojiHanteiKekkaJohoMapperParameter 一五次判定結果情報_検索条件);

    /**
     * 基本調査項目を取得します。
     *
     * @param 一五次判定結果情報_検索条件 一五次判定結果情報_検索条件
     * @return 基本調査項目の値
     */
    List<IchiGojiHanteiKekkaJohoEntity> get基本調査項目(IchiGojiHanteiKekkaJohoMapperParameter 一五次判定結果情報_検索条件);

    /**
     * 主治医意見書項目を取得します。
     *
     * @param 一五次判定結果情報_検索条件 一五次判定結果情報_検索条件
     * @return 主治医意見書項目の値
     */
    List<IchiGojiHanteiKekkaJohoEntity> get主治医意見書項目(IchiGojiHanteiKekkaJohoMapperParameter 一五次判定結果情報_検索条件);

    /**
     * 障害高齢者自立度と認定調査における認知症高齢者自立度を取得します。
     *
     * @param 一五次判定結果情報_検索条件 一五次判定結果情報_検索条件
     * @return 障害高齢者自立度と認定調査における認知症高齢者自立度の値
     */
    IchiGojiHanteiKekkaJohoEntity get認定調査高齢者自立度(IchiGojiHanteiKekkaJohoMapperParameter 一五次判定結果情報_検索条件);

    /**
     * 主治医意見書における認知症高齢者自立度を取得します。
     *
     * @param 一五次判定結果情報_検索条件 一五次判定結果情報_検索条件
     * @return 主治医意見書における認知症高齢者自立度の値
     */
    IchiGojiHanteiKekkaJohoEntity get主治医意見書高齢者自立度(IchiGojiHanteiKekkaJohoMapperParameter 一五次判定結果情報_検索条件);
}
