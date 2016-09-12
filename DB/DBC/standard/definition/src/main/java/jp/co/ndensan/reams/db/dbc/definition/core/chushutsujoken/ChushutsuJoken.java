/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.chushutsujoken;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(給付管理票)
 *
 * @reamsid_L DBC-3096-010 zhengshenlei
 */
public enum ChushutsuJoken {

    /**
     * コード:0 表示名称:集計行のみ 定義名:集計行のみ
     */
    集計行のみ("0", "集計行のみ"),
    /**
     * コード:1 表示名称:明細行含む 定義名:明細行含む
     */
    明細行含む("1", "明細行含む"),
    /**
     * コード:99 表示名称:集計行のみ 定義名:終端行
     */
    終端行("99", "終端行");

    private final RString code;
    private final RString fullName;

    private ChushutsuJoken(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 明細行出力有無のコードを返します。
     *
     * @return 承認区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 明細行出力有無の名称を返します。
     *
     * @return 承認区分の名称
     */
    public RString get名称() {
        return fullName;
    }
}
