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
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum IkenshoSakuseiRyo {

    /**
     * コード:11 名称:在宅新規 略称:定義なし
     */
    在宅新規("11", "5000"),
    /**
     * コード:12 名称:施設新規 略称:定義なし
     */
    施設新規("12", "4000"),
    /**
     * コード:21 名称:在宅継続 略称:定義なし
     */
    在宅継続("21", "4000"),
    /**
     * コード:22 名称:施設継続 略称:定義なし
     */
    施設継続("22", "3000");

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
            if (ikenshoSakuseiRyo.code.equals(code)) {
                return ikenshoSakuseiRyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書作成料"));
    }
}
