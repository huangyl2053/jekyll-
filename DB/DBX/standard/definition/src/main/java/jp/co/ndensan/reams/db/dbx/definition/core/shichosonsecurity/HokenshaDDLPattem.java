/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3601
 */
public enum HokenshaDDLPattem {

    /**
     * 全市町村以外
     */
    全市町村以外("0"),
    /**
     * 構成市町村全て
     */
    構成市町村全て("2"),
    /**
     * 構成市町村全て_空白含む
     */
    構成市町村全て_空白含む("2"),
    /**
     * 構成市町村全て_市町村コード
     */
    構成市町村全て_市町村コード("2"),
    /**
     * 広域保険者のみ
     */
    広域保険者のみ("4");

    private final RString aCode;

    private HokenshaDDLPattem(String code) {
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
