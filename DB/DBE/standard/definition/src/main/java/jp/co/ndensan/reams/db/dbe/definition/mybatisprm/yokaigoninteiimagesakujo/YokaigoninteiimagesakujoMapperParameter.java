/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteiimagesakujo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定イメージ情報削除をするためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1670-012 dingyi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class YokaigoninteiimagesakujoMapperParameter {

    private final ShinseishoKanriNo shinseishoKanriNo;
    private final int ninteichosaRirekiNo;
    private final RString imageKubun;
    private final RString genponMaskKubun;
    private final int ikenshoIraiRirekiNo;
    private final RString maskDataKubun;
    private final boolean hasGenponMaskKubun;
    private final boolean hasMaskDataKubun;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     * @param imageKubun imageKubun
     * @param genponMaskKubun genponMaskKubun
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     * @param maskDataKubun maskDataKubun
     * @param hasGenponMaskKubun hasGenponMaskKubun
     * @param hasMaskDataKubun hasMaskDataKubun
     */
    private YokaigoninteiimagesakujoMapperParameter(ShinseishoKanriNo shinseishoKanriNo,
            int ninteichosaRirekiNo,
            RString imageKubun,
            RString genponMaskKubun,
            int ikenshoIraiRirekiNo,
            RString maskDataKubun,
            boolean hasGenponMaskKubun,
            boolean hasMaskDataKubun) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
        this.imageKubun = imageKubun;
        this.genponMaskKubun = genponMaskKubun;
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
        this.maskDataKubun = maskDataKubun;
        this.hasGenponMaskKubun = hasGenponMaskKubun;
        this.hasMaskDataKubun = hasMaskDataKubun;

    }

    /**
     * キー削除用のパラメータを生成します。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     * @param imageKubun imageKubun
     * @param genponMaskKubun genponMaskKubun
     * @param hasGenponMaskKubun hasGenponMaskKubun
     * @return 要介護認定イメージ情報削除パラメータ
     */
    public static YokaigoninteiimagesakujoMapperParameter createDeleteByKeyParam_認定調査票(
            ShinseishoKanriNo shinseishoKanriNo,
            int ninteichosaRirekiNo,
            RString imageKubun,
            RString genponMaskKubun,
            boolean hasGenponMaskKubun) {
        return new YokaigoninteiimagesakujoMapperParameter(
                shinseishoKanriNo, ninteichosaRirekiNo, imageKubun, genponMaskKubun, 0, RString.EMPTY, hasGenponMaskKubun, false);
    }

    /**
     * キー削除用のパラメータを生成します。
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     * @param maskDataKubun maskDataKubun
     * @param hasMaskDataKubun hasMaskDataKubun
     * @return 要介護認定イメージ情報削除パラメータ
     */
    public static YokaigoninteiimagesakujoMapperParameter createDeleteByKeyParam_主治医意見書(
            ShinseishoKanriNo shinseishoKanriNo,
            int ikenshoIraiRirekiNo,
            RString maskDataKubun,
            boolean hasMaskDataKubun) {
        return new YokaigoninteiimagesakujoMapperParameter(
                shinseishoKanriNo, 0, RString.EMPTY, RString.EMPTY, ikenshoIraiRirekiNo, maskDataKubun, false, hasMaskDataKubun);
    }

}
