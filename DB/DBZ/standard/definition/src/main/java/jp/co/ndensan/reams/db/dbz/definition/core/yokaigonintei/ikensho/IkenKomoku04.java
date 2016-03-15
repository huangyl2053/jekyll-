/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容04を表す列挙型です。
 *
 *
 */
public enum IkenKomoku04 {

    /**
     * コード:1 名称:問題なし 略称:定義なし
     */
    問題なし("1", "問題なし"),
    /**
     * コード:2 名称:問題あり 略称:定義なし
     */
    問題あり("2", "問題あり"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku04(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容04のコードを返します。
     *
     * @return 意見書項目内容04のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容04の名称を返します。
     *
     * @return 意見書項目内容04の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容04のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容04のコード
     * @return {@code code} に対応する意見書項目内容04
     */
    public static IkenKomoku04 toValue(RString code) {
        for (IkenKomoku04 ikenKomoku04 : IkenKomoku04.values()) {
            if (ikenKomoku04.code.equals(code)) {
                return ikenKomoku04;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容04"));
    }
}
