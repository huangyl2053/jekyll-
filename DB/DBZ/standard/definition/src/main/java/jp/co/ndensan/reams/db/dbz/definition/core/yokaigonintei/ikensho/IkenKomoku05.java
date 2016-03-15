/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容05を表す列挙型です。
 *
 *
 */
public enum IkenKomoku05 {

    /**
     * コード:1 名称:自立 略称:定義なし
     */
    自立("1", "自立"),
    /**
     * コード:2 名称:いくらか困難 略称:定義なし
     */
    いくらか困難("2", "いくらか困難"),
    /**
     * コード:3 名称:見守りが必要 略称:定義なし
     */
    見守りが必要("3", "見守りが必要"),
    /**
     * コード:4 名称:判断できない 略称:定義なし
     */
    判断できない("4", "判断できない"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku05(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容05のコードを返します。
     *
     * @return 意見書項目内容05のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容05の名称を返します。
     *
     * @return 意見書項目内容05の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容05のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容05のコード
     * @return {@code code} に対応する意見書項目内容05
     */
    public static IkenKomoku05 toValue(RString code) {
        for (IkenKomoku05 ikenKomoku05 : IkenKomoku05.values()) {
            if (ikenKomoku05.code.equals(code)) {
                return ikenKomoku05;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容05"));
    }
}
