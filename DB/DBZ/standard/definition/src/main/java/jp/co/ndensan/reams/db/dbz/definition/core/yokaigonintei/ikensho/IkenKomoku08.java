/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書項目内容08を表す列挙型です。
 *
 *
 */
public enum IkenKomoku08 {

    /**
     * コード:1 名称:右 略称:定義なし
     */
    右("1", "右"),
    /**
     * コード:2 名称:左 略称:定義なし
     */
    左("2", "左"),
    /**
     * コード:9 名称:記載なし 略称:定義なし
     */
    記載なし("9", "記載なし");

    private final RString code;
    private final RString fullName;

    private IkenKomoku08(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書項目内容08のコードを返します。
     *
     * @return 意見書項目内容08のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書項目内容08の名称を返します。
     *
     * @return 意見書項目内容08の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書項目内容08のコードと一致する内容を探します。
     *
     * @param code 意見書項目内容08のコード
     * @return {@code code} に対応する意見書項目内容08
     */
    public static IkenKomoku08 toValue(RString code) {
        for (IkenKomoku08 ikenKomoku08 : IkenKomoku08.values()) {
            if (ikenKomoku08.code.equals(code)) {
                return ikenKomoku08;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書項目内容08"));
    }
}
