/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShoKaishuKirokuKanri;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証回収記録管理共有子Divの大まかな状態を、外部で指定するために使用します。
 *
 * @author n8178
 */
public enum ShoKaishuKirokuState {

    /**
     * 照会モード
     */
    照会("照会"),
    /**
     * 更新モード
     */
    更新("更新"),
    /**
     * 削除モード
     */
    削除("削除");

    private final RString stateValue;

    private ShoKaishuKirokuState(String value) {
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
