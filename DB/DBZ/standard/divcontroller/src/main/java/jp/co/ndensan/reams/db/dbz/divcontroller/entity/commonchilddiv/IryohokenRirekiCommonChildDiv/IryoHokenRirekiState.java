/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 医療保険履歴の内部的な状態を表す項目を定義する列挙値です。
 *
 * @author n8178 城間篤人
 */
public enum IryoHokenRirekiState {

    /**
     * 照会モード
     */
    照会("照会"),
    /**
     * 登録モード
     */
    登録("登録");

    private final RString stateValue;

    private IryoHokenRirekiState(String value) {
        this.stateValue = new RString(value);
    }

    /**
     * 状態を示す文字列を返します。
     *
     * @return 詳細を示す文字列
     */
    public RString getStateValue() {
        return stateValue;
    }
}
