/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容09を表す列挙型です。
 *
 *
 */
public enum IkenKomoku09 {

    /**
     * コード:1 名称:増加 略称:定義なし
     */
    増加("1", "増加"),
    /**
     * コード:2 名称:維持 略称:定義なし
     */
    維持("2", "維持"),
    /**
     * コード:3 名称:減少 略称:定義なし
     */
    減少("3", "減少"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku09(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容09のコードを返します。
     *
     * @return 意見書項目内容09のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容09の名称を返します。
     *
     * @return 意見書項目内容09の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容09のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容09のコード
     * @return {@code code} に対応する意見書項目内容09
     */
    public static IkenKomoku09 toValue(RString code) {
        for (IkenKomoku09 ikenKomoku09 : IkenKomoku09.values()) {
            if (ikenKomoku09.code.equals(code)) {
                return ikenKomoku09;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容09"));
    }
}
