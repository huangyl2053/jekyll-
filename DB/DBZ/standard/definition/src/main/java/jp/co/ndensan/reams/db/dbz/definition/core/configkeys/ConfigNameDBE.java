/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.configkeys;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コンフィグ名称(DBE)を表す列挙型です。
 */
public enum ConfigNameDBE {

    /**
     * 要支援認定結果
     */
    要支援認定結果("要支援認定結果"),
    /**
     * 合議体最大委員数
     */
    合議体最大委員数("合議体最大委員数");
    private final RString fullName;

    private ConfigNameDBE(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * コンフィグ名称(DBE)の名称を返します。
     *
     * @return コンフィグ名称(DBE)の名称
     */
    public RString get名称() {
        return fullName;
    }
}
