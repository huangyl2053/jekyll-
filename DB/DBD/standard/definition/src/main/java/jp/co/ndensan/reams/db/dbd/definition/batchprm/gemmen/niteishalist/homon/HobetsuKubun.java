/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.homon;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 法別区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum HobetsuKubun {

    /**
     * コード:0 名称:すべて 略称:定義なし
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:施行時ホームヘルプ 略称:定義なし
     */
    施行時ホームヘルプ("1", "施行時ホームヘルプ"),
    /**
     * コード:2 名称:障害時ホームヘルプ 略称:定義なし
     */
    障害時ホームヘルプ("2", "障害時ホームヘルプ"),
    /**
     * コード:3 名称:障害ヘルプ全額免除 略称:定義なし
     */
    障害ヘルプ全額免除("3", "障害ヘルプ全額免除");

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

}
