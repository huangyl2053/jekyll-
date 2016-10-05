/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.servicecode;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 限度額対象外フラグを表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 zhaowei
 */
public enum GendogakuTaisyogaiFlg {

    /**
     * コード:0 名称:限度額対象 略称:定義なし
     */
    新規("0", "限度額対象"),
    /**
     * コード:1 名称:限度額対象外 略称:定義なし
     */
    修正("1", "限度額対象外");
    private final RString code;
    private final RString fullName;

    private GendogakuTaisyogaiFlg(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 限度額対象外フラグのコードを返します。
     *
     * @return 限度額対象外フラグのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 限度額対象外フラグの名称を返します。
     *
     * @return 限度額対象外フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 限度額対象外フラグのコードと一致する内容を探します。
     *
     * @param code 限度額対象外フラグのコード
     * @return {@code code} に対応する限度額対象外フラグ
     */
    public static GendogakuTaisyogaiFlg toValue(RString code) {

        for (GendogakuTaisyogaiFlg flag : GendogakuTaisyogaiFlg.values()) {
            if (flag.code.equals(code)) {
                return flag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("限度額対象外フラグ"));
    }
}
