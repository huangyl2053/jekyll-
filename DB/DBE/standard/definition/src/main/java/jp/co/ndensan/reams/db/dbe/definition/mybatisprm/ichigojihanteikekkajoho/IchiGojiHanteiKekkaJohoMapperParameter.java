/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichigojihanteikekkajoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一五次判定結果情報のマッパーパラメータです。
 *
 * @reamsid_L DBE-3000-290 chenxiangyu
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IchiGojiHanteiKekkaJohoMapperParameter {

    private final RString shinseishoKanriNo;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    private IchiGojiHanteiKekkaJohoMapperParameter(RString 申請書管理番号) {
        this.shinseishoKanriNo = 申請書管理番号;
    }

    /**
     * 一五次判定結果情報のパラメータを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 一五次判定結果情報のパラメータ
     */
    public static IchiGojiHanteiKekkaJohoMapperParameter createParamter(RString 申請書管理番号) {
        return new IchiGojiHanteiKekkaJohoMapperParameter(申請書管理番号);
    }
}
