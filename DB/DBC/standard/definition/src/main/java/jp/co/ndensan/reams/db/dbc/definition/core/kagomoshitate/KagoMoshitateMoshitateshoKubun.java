/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤申立_申立書区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 pengxingyi
 */
public enum KagoMoshitateMoshitateshoKubun {

    /**
     * コード:1 名称:過誤申立書 略称:定義なし
     */
    過誤申立書("1", "過誤申立書情報"),
    /**
     * コード:2 名称:総合事業申立書_経過 略称:定義なし
     */
    総合事業申立書_経過("2", "総合事業過誤申立書情報（経過措置）"),
    /**
     * コード:3 名称:総合事業申立書 略称:定義なし
     */
    総合事業申立書("3", "総合事業過誤申立書情報");

    private final RString code;
    private final RString fullName;

    private KagoMoshitateMoshitateshoKubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 過誤申立_申立書区分のコードを返します。
     *
     * @return 介護合算_異動区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 過誤申立_申立書区分の名称を返します。
     *
     * @return 介護合算_異動区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 過誤申立_申立書区分のコードと一致する内容を探します。
     *
     * @param code 過誤申立_申立書区分のコード
     * @return {@code code} に対応する過誤申立_申立書区分
     */
    public static KagoMoshitateMoshitateshoKubun toValue(RString code) {
        for (KagoMoshitateMoshitateshoKubun kagoMoshitateMoshitateshoKubun : KagoMoshitateMoshitateshoKubun.values()) {
            if (kagoMoshitateMoshitateshoKubun.code.equals(code)) {
                return kagoMoshitateMoshitateshoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過誤申立_申立書区分"));
    }
}
