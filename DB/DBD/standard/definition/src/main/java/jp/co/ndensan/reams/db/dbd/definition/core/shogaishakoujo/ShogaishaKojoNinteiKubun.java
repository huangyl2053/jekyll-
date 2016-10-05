/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.shogaishakoujo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 障がい者控除認定区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 xuyue
 */
public enum ShogaishaKojoNinteiKubun {

    /**
     * コード:01 名称:障がい者 略称:定義なし
     */
    障がい者("01", "障がい者"),
    /**
     * コード:2 名称:特別障がい者 略称:定義なし
     */
    特別障がい者("02", "特別障がい者");

    private final RString code;
    private final RString fullName;

    private ShogaishaKojoNinteiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 障がい者控除認定区分のコードを返します。
     *
     * @return 障がい者控除認定区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 障がい者控除認定区分の名称を返します。
     *
     * @return 障がい者控除認定区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 障がい者控除認定区分のコードと一致する内容を探します。
     *
     * @param code 障がい者控除認定区分のコード
     * @return {@code code} に対応する障がい者控除認定区分
     */
    public static ShogaishaKojoNinteiKubun toValue(RString code) {

        for (ShogaishaKojoNinteiKubun shogaishaKojoNinteiKubun : ShogaishaKojoNinteiKubun.values()) {
            if (shogaishaKojoNinteiKubun.code.equals(code)) {
                return shogaishaKojoNinteiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("障がい者控除認定区分"));
    }
}
