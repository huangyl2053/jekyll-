/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容10を表す列挙型です。
 *
 *
 */
public enum IkenKomoku10 {

    /**
     * コード:1 名称:軽 略称:定義なし
     */
    軽("1", "軽"),
    /**
     * コード:2 名称:中 略称:定義なし
     */
    中("2", "中"),
    /**
     * コード:3 名称:重 略称:定義なし
     */
    重("3", "重"),
    /**
     * コード:4 名称:記載なし 略称:定義なし
     */
    記載なし("4", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku10(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容10のコードを返します。
     *
     * @return 意見書項目内容10のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容10の名称を返します。
     *
     * @return 意見書項目内容10の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容10のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容10のコード
     * @return {@code code} に対応する意見書項目内容10
     */
    public static IkenKomoku10 toValue(RString code) {
        for (IkenKomoku10 ikenKomoku10 : IkenKomoku10.values()) {
            if (ikenKomoku10.code.equals(code)) {
                return ikenKomoku10;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容10"));
    }
}
