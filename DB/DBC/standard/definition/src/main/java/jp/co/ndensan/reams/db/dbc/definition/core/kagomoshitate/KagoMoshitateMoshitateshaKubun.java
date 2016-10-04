/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申立者区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 pengxingyi
 */
public enum KagoMoshitateMoshitateshaKubun {

    /**
     * コード:1 名称:サービス事業者等申立 略称:定義なし
     */
    サービス事業者等申立("1", "サービス事業者等申立"),
    /**
     * コード:2 名称:保険者申立 略称:定義なし
     */
    保険者申立("2", "保険者申立");

    private final RString code;
    private final RString fullName;

    private KagoMoshitateMoshitateshaKubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 申立者区分のコードを返します。
     *
     * @return 介護合算_異動区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 申立者区分の名称を返します。
     *
     * @return 介護合算_異動区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申立者区分のコードと一致する内容を探します。
     *
     * @param code 申立者区分のコード
     * @return {@code code} に対応する申立者区分
     */
    public static KagoMoshitateMoshitateshaKubun toValue(RString code) {
        for (KagoMoshitateMoshitateshaKubun kagoMoshitateMoshitateshaKubun : KagoMoshitateMoshitateshaKubun.values()) {
            if (kagoMoshitateMoshitateshaKubun.code.equals(code)) {
                return kagoMoshitateMoshitateshaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申立者区分"));
    }
}
