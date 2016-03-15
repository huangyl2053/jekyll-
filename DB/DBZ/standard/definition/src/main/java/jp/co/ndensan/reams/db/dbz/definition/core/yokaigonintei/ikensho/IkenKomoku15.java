/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容15を表す列挙型です。
 *
 *
 */
public enum IkenKomoku15 {

    /**
     * コード:1 名称:良好 略称:定義なし
     */
    良好("1", "良好"),
    /**
     * コード:2 名称:不良 略称:定義なし
     */
    不良("2", "不良"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku15(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容15のコードを返します。
     *
     * @return 意見書項目内容15のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容15の名称を返します。
     *
     * @return 意見書項目内容15の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容15のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容15のコード
     * @return {@code code} に対応する意見書項目内容15
     */
    public static IkenKomoku15 toValue(RString code) {
        for (IkenKomoku15 ikenKomoku15 : IkenKomoku15.values()) {
            if (ikenKomoku15.code.equals(code)) {
                return ikenKomoku15;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容15"));
    }
}
