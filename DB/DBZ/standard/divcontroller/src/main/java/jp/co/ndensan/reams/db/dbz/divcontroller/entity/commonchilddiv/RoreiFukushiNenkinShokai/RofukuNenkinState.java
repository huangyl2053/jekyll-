/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 老齢福祉年金の内部的な状態を表す項目を定義する列挙値です。 ダイアログで老齢福祉年金の共有子Divを開く際などに、 状態を指定するために使用します。
 *
 * @author n8178 城間篤人
 */
public enum RofukuNenkinState {

    /**
     * 照会モード
     */
    照会("照会"),
    /**
     * 登録モード
     */
    登録("登録");

    private final RString stateValue;

    private RofukuNenkinState(String value) {
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
