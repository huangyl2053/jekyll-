/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険システムを導入しているかどうかの区分です。
 */
public enum KaigoDonyuKubun {

    /**
     * 導入済み
     */
    導入済("1"),
    /**
     * 未導入
     */
    未導入("0");
    private final RString aCode;

    private KaigoDonyuKubun(String code) {
        this.aCode = new RString(code);
    }

    /**
     * コードを返却します。
     *
     * @return コード
     */
    public RString code() {
        return this.aCode;
    }
}
