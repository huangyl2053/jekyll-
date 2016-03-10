/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.ikenshosakuseiryo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書作成料を表す列挙型です。
 *
 */
public enum IkenshoSakuseiRyo {

    /**
     * コード:11 名称:定義なし 略称:定義なし
     */
    _5000("11", ""),
    /**
     * コード:11 名称:定義なし 略称:定義なし
     */
    _4000("12", ""),
    /**
     * コード:11 名称:定義なし 略称:定義なし
     */
    // _4000("21", ""),
    /**
     * コード:11 名称:定義なし 略称:定義なし
     */
    _3000("22", "");

    private final RString code;
    private final RString fullName;

    private IkenshoSakuseiRyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書作成料のコードを返します。
     *
     * @return 意見書作成料のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書作成料の名称を返します。
     *
     * @return 意見書作成料の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書作成料のコードと一致する内容を探します。
     *
     * @param code 意見書作成料のコード
     * @return {@code code} に対応する意見書作成料
     */
    public static IkenshoSakuseiRyo toValue(RString code) {
        for (IkenshoSakuseiRyo ikenshoSakuseiRyo : IkenshoSakuseiRyo.values()) {
            if (ikenshoSakuseiRyo.code == code) {
                return ikenshoSakuseiRyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書作成料"));
    }
}
