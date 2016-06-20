/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 liangbc
 */
public enum KakushuKubun {

    /**
     * コード:01 名称:新規者 略称:定義なし
     */
    新規者("01", "新規者"),
    /**
     * コード:01 名称:前年度継続者 略称:定義なし
     */
    前年度継続者("02", "前年度継続者");

    private final RString code;
    private final RString fullName;

    private KakushuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 各種区分のコードを返します。
     *
     * @return 各種区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 各種区分の名称を返します。
     *
     * @return 各種区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 各種区分のコードと一致する内容を探します。
     *
     * @param code 各種区分のコード
     * @return {@code code} に対応する各種区分
     */
    public static KakushuKubun toValue(RString code) {
        for (KakushuKubun kakushuKubun : KakushuKubun.values()) {
            if (kakushuKubun.code.equals(code)) {
                return kakushuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("各種区分"));
    }
}
