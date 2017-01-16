/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ChosaKubun {

    /**
     * コード:0 名称:新規調査 略称:定義なし
     */
    新規調査("0", "新規調査"),
    /**
     * コード:1 名称:再調査 略称:定義なし
     */
    再調査("1", "再調査");

    private final RString code;
    private final Code theCode;
    private final RString fullName;

    private ChosaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.theCode = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 調査区分のコードを返します。
     *
     * @return 調査区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * コードを{@link Code}型で返します。
     *
     * @return コード({@link Code}型)
     */
    public Code asCode() {
        return theCode;
    }

    /**
     * 調査区分の名称を返します。
     *
     * @return 調査区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 調査区分のコードと一致する内容を探します。
     *
     * @param code 調査区分のコード
     * @return {@code code} に対応する調査区分
     */
    public static ChosaKubun toValue(RString code) {

        for (ChosaKubun chosaKubun : ChosaKubun.values()) {
            if (chosaKubun.code.equals(code)) {
                return chosaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("調査区分"));
    }
}
