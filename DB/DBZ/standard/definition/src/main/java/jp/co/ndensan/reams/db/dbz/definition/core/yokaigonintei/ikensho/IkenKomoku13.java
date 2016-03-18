/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容13を表す列挙型です。
 *
 *
 */
public enum IkenKomoku13 {

    /**
     * コード:1 名称:チェック無 略称:定義なし
     */
    チェック無("1", "チェック無"),
    /**
     * コード:2 名称:チェック有 略称:定義なし
     */
    チェック有("2", "チェック有");

    private final RString code;
    private final RString fullName;

    private IkenKomoku13(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容13のコードを返します。
     *
     * @return 意見書項目内容13のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容13の名称を返します。
     *
     * @return 意見書項目内容13の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容13のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容13のコード
     * @return {@code code} に対応する意見書項目内容13
     */
    public static IkenKomoku13 toValue(RString code) {
        for (IkenKomoku13 ikenKomoku13 : IkenKomoku13.values()) {
            if (ikenKomoku13.code.equals(code)) {
                return ikenKomoku13;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容13"));
    }
}
