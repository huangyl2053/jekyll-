/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容18を表す列挙型です。
 *
 *
 */
public enum IkenKomoku18 {

    /**
     * コード:1 名称:無 略称:定義なし
     */
    無("1", "無"),
    /**
     * コード:2 名称:有 略称:定義なし
     */
    有("2", "有"),
    /**
     * コード:3 名称:不明 略称:定義なし
     */
    不明("3", "不明"),
    /**
     * コード:9 名称:無 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku18(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容18のコードを返します。
     *
     * @return 意見書項目内容18のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容18の名称を返します。
     *
     * @return 意見書項目内容18の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容18のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容18のコード
     * @return {@code code} に対応する意見書項目内容18
     */
    public static IkenKomoku18 toValue(RString code) {
        for (IkenKomoku18 ikenKomoku18 : IkenKomoku18.values()) {
            if (ikenKomoku18.code.equals(code)) {
                return ikenKomoku18;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容18"));
    }
}
