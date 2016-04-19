/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定延期通知発行しないことに対する同意有無を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum IsExistEnkitsuchiNashiDoi {

    /**
     * コード:True 名称:同意する 略称:定義なし
     */
    同意する(true, "同意する"),
    /**
     * コード:False 名称:同意しない 略称:定義なし
     */
    同意しない(false, "同意しない");

    private final boolean code;
    private final RString fullName;

    private IsExistEnkitsuchiNashiDoi(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 認定延期通知発行しないことに対する同意有無のコードを返します。
     *
     * @return 認定延期通知発行しないことに対する同意有無のコード
     */
    public boolean is同意する() {
        return code;
    }

    /**
     * 認定延期通知発行しないことに対する同意有無の名称を返します。
     *
     * @return 認定延期通知発行しないことに対する同意有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定延期通知発行しないことに対する同意有無のコードと一致する内容を探します。
     *
     * @param code 認定延期通知発行しないことに対する同意有無のコード
     * @return {@code code} に対応する認定延期通知発行しないことに対する同意有無
     */
    public static IsExistEnkitsuchiNashiDoi toValue(boolean code) {
        for (IsExistEnkitsuchiNashiDoi isExistEnkitsuchiNashiDoi : IsExistEnkitsuchiNashiDoi.values()) {
            if (isExistEnkitsuchiNashiDoi.code == code) {
                return isExistEnkitsuchiNashiDoi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定延期通知発行しないことに対する同意有無"));
    }
}
