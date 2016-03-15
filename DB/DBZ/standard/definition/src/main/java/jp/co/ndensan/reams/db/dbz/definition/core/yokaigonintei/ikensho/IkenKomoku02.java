/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容02を表す列挙型です。
 *
 *
 */
public enum IkenKomoku02 {

    /**
     * コード:1 名称:自立 略称:定義なし
     */
    自立("1", "自立"),
    /**
     * コード:2 名称:J1 略称:定義なし
     */
    J1("2", "J1"),
    /**
     * コード:3 名称:J2 略称:定義なし
     */
    J2("3", "J2"),
    /**
     * コード:4 名称:A1 略称:定義なし
     */
    A1("4", "A1"),
    /**
     * コード:5 名称:A2 略称:定義なし
     */
    A2("5", "A2"),
    /**
     * コード:6 名称:B1 略称:定義なし
     */
    B1("6", "B1"),
    /**
     * コード:7 名称:B2 略称:定義なし
     */
    B2("7", "B2"),
    /**
     * コード:8 名称:C1 略称:定義なし
     */
    C1("8", "C1"),
    /**
     * コード:9 名称:C2 略称:定義なし
     */
    C2("9", "C2"),
    /**
     * コード:0 名称:未記入 略称:定義なし
     */
    未記入("0", "未記入");
    private final RString code;
    private final RString fullName;

    private IkenKomoku02(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容02のコードを返します。
     *
     * @return 意見書項目内容02のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容02の名称を返します。
     *
     * @return 意見書項目内容02の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容02のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容02のコード
     * @return {@code code} に対応する意見書項目内容02
     */
    public static IkenKomoku02 toValue(RString code) {
        for (IkenKomoku02 ikenKomoku02 : IkenKomoku02.values()) {
            if (ikenKomoku02.code.equals(code)) {
                return ikenKomoku02;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容02"));
    }
}
