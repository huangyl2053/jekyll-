/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容19を表す列挙型です。
 *
 *
 */
public enum IkenKomoku19 {

    /**
     * コード:1 名称:改善 略称:定義なし
     */
    改善("1", "改善"),
    /**
     * コード:2 名称:不変 略称:定義なし
     */
    不変("2", "不変"),
    /**
     * コード:3 名称:改善 略称:定義なし
     */
    悪化("3", "悪化");

    private final RString code;
    private final RString fullName;

    private IkenKomoku19(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容19のコードを返します。
     *
     * @return 意見書項目内容19のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容19の名称を返します。
     *
     * @return 意見書項目内容19の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容19のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容19のコード
     * @return {@code code} に対応する意見書項目内容19
     */
    public static IkenKomoku19 toValue(RString code) {
        for (IkenKomoku19 ikenKomoku19 : IkenKomoku19.values()) {
            if (ikenKomoku19.code.equals(code)) {
                return ikenKomoku19;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容19"));
    }
}
