/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei;

import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 要介護認定情報のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiJyoho {

    private Code 要介護認定状態区分コード;
    private boolean 旧措置者フラグ;

    public YokaigoNinteiJyoho(Code 要介護認定状態区分コード, boolean 旧措置者フラグ) {
        this.要介護認定状態区分コード = 要介護認定状態区分コード;
        this.旧措置者フラグ = 旧措置者フラグ;
    }

}
