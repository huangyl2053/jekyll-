/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容11を表す列挙型です。
 *
 *
 */
public enum IkenKomoku11 {

    /**
     * コード:1 名称:自立 略称:定義なし
     */
    自立("1", "自立"),
    /**
     * コード:2 名称:介助があればしている 略称:定義なし
     */
    介助があればしている("2", "介助があればしている"),
    /**
     * コード:3 名称:していない 略称:定義なし
     */
    していない("3", "していない"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku11(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容11のコードを返します。
     *
     * @return 意見書項目内容11のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容11の名称を返します。
     *
     * @return 意見書項目内容11の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容11のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容11のコード
     * @return {@code code} に対応する意見書項目内容11
     */
    public static IkenKomoku11 toValue(RString code) {
        for (IkenKomoku11 ikenKomoku11 : IkenKomoku11.values()) {
            if (ikenKomoku11.code.equals(code)) {
                return ikenKomoku11;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容11"));
    }
}
