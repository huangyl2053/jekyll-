/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容16を表す列挙型です。
 *
 *
 */
public enum IkenKomoku16 {

    /**
     * コード:1 名称:期待できる 略称:定義なし
     */
    期待できる("1", "期待できる"),
    /**
     * コード:2 名称:期待できない 略称:定義なし
     */
    期待できない("2", "期待できない"),
    /**
     * コード:3 名称:不明 略称:定義なし
     */
    不明("3", "不明"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku16(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容16のコードを返します。
     *
     * @return 意見書項目内容16のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容16の名称を返します。
     *
     * @return 意見書項目内容16の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容16のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容16のコード
     * @return {@code code} に対応する意見書項目内容16
     */
    public static IkenKomoku16 toValue(RString code) {
        for (IkenKomoku16 ikenKomoku16 : IkenKomoku16.values()) {
            if (ikenKomoku16.code.equals(code)) {
                return ikenKomoku16;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容16"));
    }
}
