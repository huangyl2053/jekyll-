/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.helper;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * モードを表す文字列を管理する列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum ModeType {

    /**
     * 照会モード
     */
    SHOKAI_MODE("shokai"),
    /**
     * 追加モード
     */
    ADD_MODE("add"),
    /**
     * 修正モード
     */
    MODIFY_MODE("modify"),
    /**
     * 削除モード
     */
    DELETE_MODE("delete");
    private final RString mode;

    private ModeType(String str) {
        mode = new RString(str);
    }

    /**
     * 現在のモードを表す文字列を取得します。
     *
     * @return モード
     */
    public RString toValue() {
        return mode;
    }
}
