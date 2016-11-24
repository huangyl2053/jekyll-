/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.homonkaigogemmen;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 法別区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangjie2
 */
public enum HobetsuKubun {

    /**
     * コード:56 名称:施行時ホームヘルプ 略称:定義なし
     */
    施行時ホームヘルプ("56", "施行時ホームヘルプ"),
    /**
     * コード:57 名称:障害時ホームヘルプ 略称:定義なし
     */
    障害時ホームヘルプ("57", "障害時ホームヘルプ"),
    /**
     * コード:58 名称:障害ヘルプ全額免除 略称:定義なし
     */
    障害ヘルプ全額免除("58", "障害ヘルプ全額免除");

    private final RString code;
    private final RString fullName;

    private HobetsuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 法別区分のコードを返します。
     *
     * @return 法別区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 法別区分の名称を返します。
     *
     * @return 法別区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 法別区分のコードと一致する内容を探します。
     *
     * @param code 法別区分のコード
     * @return {@code code} に対応する法別区分
     */
    public static HobetsuKubun toValue(RString code) {
        for (HobetsuKubun hobetsuKubun : HobetsuKubun.values()) {
            if (hobetsuKubun.code.equals(code)) {
                return hobetsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("法別区分"));
    }

    /**
     * 法別区分の正式名称と一致する内容を探します。
     *
     * @param fullname 法別区分の正式名称
     * @return {
     * @fullname fullname} に対応する法別区分
     */
    public static HobetsuKubun toValueFromFullName(RString fullname) {
        for (HobetsuKubun hobetsuKubun : HobetsuKubun.values()) {
            if (hobetsuKubun.fullName.equals(fullname)) {
                return hobetsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("法別区分"));
    }
}
