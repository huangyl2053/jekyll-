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
public enum ShisakaiIinJissekiIchiranShinsakaiTanka {

    /**
     * 名称:審査会単価パターン_委員 略称:定義なし
     */
    審査会単価パターン_委員("1"),
    /**
     * 名称:審査会単価パターン_医師 略称:定義なし
     */
    審査会単価パターン_医師("2");

    private final RString code;

    private ShisakaiIinJissekiIchiranShinsakaiTanka(String code) {
        this.code = new RString(code);
    }

    /**
     * 審査会単価パターンのコードを返します。
     *
     * @return 審査会単価パターンのコード
     */
    public RString getコード() {
        return code;
    }
}
