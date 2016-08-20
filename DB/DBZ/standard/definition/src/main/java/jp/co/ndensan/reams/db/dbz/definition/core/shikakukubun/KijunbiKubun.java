/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準日区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 surun
 */
public enum KijunbiKubun {

    /**
     * コード:1 名称:賦課基準日で抽出
     */
    賦課基準日で抽出("1", "賦課基準日で抽出"),
    /**
     * コード:2 名称:調定日（処理日）で抽出
     */
    調定日で抽出("2", "調定日（処理日）で抽出");

    private final RString code;
    private final RString fullName;

    private KijunbiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 基準日区分のコードを返します。
     *
     * @return 基準日区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 基準日区分の名称を返します。
     *
     * @return 基準日区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 基準日区分のコードと一致する内容を探します。
     *
     * @param code 基準日区分のコード
     * @return {@code code} に対応する基準日区分
     */
    public static KijunbiKubun toValue(RString code) {
        for (KijunbiKubun kijunbiKubun : KijunbiKubun.values()) {
            if (kijunbiKubun.code.equals(code)) {
                return kijunbiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("基準日区分"));
    }

}
