/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imagejohomasking;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TextMaskingParameter {

    private final RString 申請書管理番号;
    private final int 認定調査履歴番号;

    private TextMaskingParameter(
            RString 申請書管理番号,
            int 認定調査履歴番号) {
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査履歴番号 = 認定調査履歴番号;
    }

    /**
     *
     * @param 申請書管理番号
     * @param 認定調査履歴番号
     * @return
     */
    public static TextMaskingParameter createTextMaskingParameter(
            RString 申請書管理番号,
            RString 認定調査履歴番号) {
        return new TextMaskingParameter(申請書管理番号, Integer.parseInt(認定調査履歴番号.toString()));
    }
}
