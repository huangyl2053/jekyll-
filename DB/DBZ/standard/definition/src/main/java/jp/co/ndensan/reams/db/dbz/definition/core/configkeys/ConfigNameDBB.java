/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.configkeys;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コンフィグ名称(DBB)を表す列挙型です。
 */
public enum ConfigNameDBB {

    /**
     * コード:無し 名称:動作関連_特徴分配集約システム 略称:定義なし
     */
    動作関連_特徴分配集約システム("動作関連_特徴分配集約システム"),
    /**
     * コード:無し 名称:日付関連_調定年度 略称:定義なし
     */
    日付関連_調定年度("日付関連_調定年度");
    private final RString fullName;

    private ConfigNameDBB(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * コンフィグ名称(DBB)の名称を返します。
     *
     * @return コンフィグ名称(DBB)の名称
     */
    public RString get名称() {
        return fullName;
    }
}
