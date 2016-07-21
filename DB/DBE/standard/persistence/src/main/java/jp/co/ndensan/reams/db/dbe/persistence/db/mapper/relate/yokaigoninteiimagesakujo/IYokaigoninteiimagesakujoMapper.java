/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteiimagesakujo;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteiimagesakujo.YokaigoninteiimagesakujoMapperParameter;

/**
 * 要介護認定イメージ情報削除のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1670-012 dingyi
 */
public interface IYokaigoninteiimagesakujoMapper {

    /**
     * 認定調査票（概況調査）情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5202PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 認定調査票（特記情報）情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5205PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 認定調査票（基本調査）情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5203PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 認定調査票（基本調査素点）情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5204PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 認定調査票（概況調査）サービスの状況情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5207PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 認定調査票（概況調査）サービスの状況フラグ情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5208PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 認定調査票（概況調査）記入項目情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5209PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 認定調査票（概況調査）施設利用情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5210PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 認定調査票（基本調査）調査項目情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5211PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 認定調査票（基本調査素点項目）情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5212PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 認定調査票（概況特記）情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5206PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 要介護認定意見書イメージ情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5305PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 要介護認定主治医意見書情報を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5302PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 要介護認定主治医意見書記入項目を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5303PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

    /**
     * 要介護認定主治医意見書意見項目を削除します。
     *
     * @param 削除パラメータ 要介護認定イメージ情報削除パラメータ
     */
    void deleteDbT5304PhysicalBy(YokaigoninteiimagesakujoMapperParameter 削除パラメータ);

}
