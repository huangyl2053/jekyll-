/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容03を表す列挙型です。
 *
 *
 */
public enum IkenKomoku03 {

    /**
     * コード:1 名称:自立 略称:定義なし
     */
    自立("1", "自立"),
    /**
     * コード:2 名称:Ⅰ 略称:定義なし
     */
    Ⅰ("2", "Ⅰ"),
    /**
     * コード:3 名称:Ⅱa 略称:定義なし
     */
    Ⅱa("3", "Ⅱa"),
    /**
     * コード:4 名称:Ⅱb 略称:定義なし
     */
    Ⅱb("4", "Ⅱb"),
    /**
     * コード:5 名称:Ⅲa 略称:定義なし
     */
    Ⅲa("5", "Ⅲa"),
    /**
     * コード:6 名称:Ⅲb 略称:定義なし
     */
    Ⅲb("6", "Ⅲb"),
    /**
     * コード:7 名称:Ⅳ 略称:定義なし
     */
    Ⅳ("7", "Ⅳ"),
    /**
     * コード:8 名称:M 略称:定義なし
     */
    M("8", "M"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし"),;
    private final RString code;
    private final RString fullName;

    private IkenKomoku03(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容03のコードを返します。
     *
     * @return 意見書項目内容03のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容03の名称を返します。
     *
     * @return 意見書項目内容03の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容03のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容03のコード
     * @return {@code code} に対応する意見書項目内容03
     */
    public static IkenKomoku03 toValue(RString code) {
        for (IkenKomoku03 ikenKomoku03 : IkenKomoku03.values()) {
            if (ikenKomoku03.code.equals(code)) {
                return ikenKomoku03;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容03"));
    }
}
