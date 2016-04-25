/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.hanyolist.kogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査方法を表す列挙型です。
 *
 * @reamsid_L DBC-3092-010 zhuliangwei
 */
public enum ShinsaHoho {

    /**
     * コード:0 名称:すべて
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:審査依頼
     */
    審査依頼("1", "審査依頼"),
    /**
     * コード:2 名称:審査済み
     */
    審査済み("2", "審査済み");

    private final RString code;
    private final RString fullName;

    private ShinsaHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 審査方法のコードを返します。
     *
     * @return 審査方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 審査方法の名称を返します。
     *
     * @return 審査方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 審査方法のコードと一致する内容を探します。
     *
     * @param code 審査方法のコード
     * @return {@code code} に対応する審査方法
     */
    public static ShinsaHoho toValue(RString code) {

        for (ShinsaHoho shinsaHoho : ShinsaHoho.values()) {
            if (shinsaHoho.code.equals(code)) {
                return shinsaHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("審査方法"));
    }
}
