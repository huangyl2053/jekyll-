/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.masking;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 完了処理・マスキングのParameterクラスです。
 *
 * @reamsid_L DBE-2080-010 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MaskingParameter {

    private RString shinseishoKanriNo;
    private RString maskDataKubun;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public MaskingParameter(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

}
