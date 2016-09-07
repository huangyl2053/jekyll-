/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 廃止フラグを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum IsHaishi {

    /**
     * コード:True 名称:廃止 略称:定義なし
     */
    廃止(true, "廃止"),
    /**
     * コード:False 名称:有効 略称:定義なし
     */
    有効(false, "有効");

    private final boolean code;
    private final RString fullName;

    private IsHaishi(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 廃止フラグのコードを返します。
     *
     * @return 廃止フラグのコード
     */
    public boolean is廃止() {
        return code;
    }

    /**
     * 廃止フラグの名称を返します。
     *
     * @return 廃止フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 廃止フラグのコードと一致する内容を探します。
     *
     * @param code 廃止フラグのコード
     * @return {@code code} に対応する廃止フラグ
     */
    public static IsHaishi toValue(boolean code) {
        for (IsHaishi isHaishi : IsHaishi.values()) {
            if (isHaishi.code == code) {
                return isHaishi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("廃止フラグ"));
    }
}
