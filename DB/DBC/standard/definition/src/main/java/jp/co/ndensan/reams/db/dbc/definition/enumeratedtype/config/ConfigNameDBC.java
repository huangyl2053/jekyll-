/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.config;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author soft863
 */
public enum ConfigNameDBC {

    /**
     * 初期表示_償還支給申請登録初期。
     */
    初期表示_償還支給申請登録初期("初期表示_償還支給申請登録初期");

    private final RString fullName;

    private ConfigNameDBC(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * コンフィグ名称(DBU)の名称を返します。
     *
     * @return コンフィグ名称(DBU)の名称
     */
    public RString get名称() {
        return fullName;
    }
}
