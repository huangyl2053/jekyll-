/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容06を表す列挙型です。
 *
 *
 */
public enum IkenKomoku06 {

    /**
     * コード:1 名称:伝えられる 略称:定義なし
     */
    伝えられる("1", "伝えられる"),
    /**
     * コード:2 名称:いくらか困難 略称:定義なし
     */
    いくらか困難("2", "いくらか困難"),
    /**
     * コード:3 名称:具体的要求に限られる 略称:定義なし
     */
    具体的要求に限られる("3", "具体的要求に限られる"),
    /**
     * コード:4 名称:伝えられない 略称:定義なし
     */
    伝えられない("4", "伝えられない"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku06(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容06のコードを返します。
     *
     * @return 意見書項目内容06のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容06の名称を返します。
     *
     * @return 意見書項目内容06の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容06のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容06のコード
     * @return {@code code} に対応する意見書項目内容06
     */
    public static IkenKomoku06 toValue(RString code) {
        for (IkenKomoku06 ikenKomoku06 : IkenKomoku06.values()) {
            if (ikenKomoku06.code.equals(code)) {
                return ikenKomoku06;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容06"));
    }
}
