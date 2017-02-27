/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3601
 */
public enum ShisakaiIinJissekiIchiranShozokuKikan {

    /**
     * 名称:医療機関 略称:定義なし
     */
    医療機関("医療機関"),
    /**
     * 名称:調査委託先 略称:定義なし
     */
    調査委託先("調査委託先"),
    /**
     * 名称:その他機関 略称:定義なし
     */
    その他機関("その他機関");

    private final RString code;

    private ShisakaiIinJissekiIchiranShozokuKikan(String code) {
        this.code = new RString(code);
    }

    /**
     * 所属機関の名称を返します。
     *
     * @return 所属機関の名称
     */
    public RString get名称() {
        return code;
    }
}
