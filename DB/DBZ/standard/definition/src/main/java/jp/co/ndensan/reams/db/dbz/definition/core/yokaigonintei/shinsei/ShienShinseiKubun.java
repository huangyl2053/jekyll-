/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護申請・要支援申請の区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShienShinseiKubun {

    /**
     * コード:1 名称:要介護 略称:定義なし
     */
    要介護("1", "要介護"),
    /**
     * コード:2 名称:要支援 略称:定義なし
     */
    要支援("2", "要支援"),
    /**
     * コード:3 名称:不明 略称:定義なし
     */
    不明("3", "不明");

    private final RString code;
    private final RString fullName;

    private ShienShinseiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 要介護申請・要支援申請の区分のコードを返します。
     *
     * @return 要介護申請・要支援申請の区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 要介護申請・要支援申請の区分の名称を返します。
     *
     * @return 要介護申請・要支援申請の区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護申請・要支援申請の区分のコードと一致する内容を探します。
     *
     * @param code 要介護申請・要支援申請の区分のコード
     * @return {@code code} に対応する要介護申請・要支援申請の区分
     */
    public static ShienShinseiKubun toValue(RString code) {

        for (ShienShinseiKubun hihokenshaKubunCode : ShienShinseiKubun.values()) {
            if (hihokenshaKubunCode.code.equals(code)) {
                return hihokenshaKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護申請・要支援申請の区分"));
    }
}
