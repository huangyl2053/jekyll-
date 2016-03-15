/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容17を表す列挙型です。
 *
 *
 */
public enum IkenKomoku17 {

    /**
     * コード:1 名称:特になし 略称:定義なし
     */
    特になし("1", "特になし"),
    /**
     * コード:2 名称:あり 略称:定義なし
     */
    あり("2", "あり"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku17(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容17のコードを返します。
     *
     * @return 意見書項目内容17のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容17の名称を返します。
     *
     * @return 意見書項目内容17の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容17のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容17のコード
     * @return {@code code} に対応する意見書項目内容17
     */
    public static IkenKomoku17 toValue(RString code) {
        for (IkenKomoku17 ikenKomoku17 : IkenKomoku17.values()) {
            if (ikenKomoku17.code.equals(code)) {
                return ikenKomoku17;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容17"));
    }
}
