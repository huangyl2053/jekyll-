/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.batchprm;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力方法を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-022 chenyadong
 */
public enum ShutsuryokuHoho {

    /**
     * コード:1 名称:帳票で出力 略称:無
     */
    帳票で出力("1", "帳票で出力"),
    /**
     * コード:2 名称:ＣＳＶファイルで出力 略称:無
     */
    ＣＳＶファイルで出力("2", "ＣＳＶファイルで出力");

    private final RString code;
    private final RString fullName;

    private ShutsuryokuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 出力方法のコードを返します。
     *
     * @return 出力方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 出力方法の名称を返します。
     *
     * @return 出力方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 出力方法のコードと一致する内容を探します。
     *
     * @param code 出力方法のコード
     * @return {@code code} に対応する出力方法
     */
    public static ShutsuryokuHoho toValue(RString code) {
        for (ShutsuryokuHoho shutsuryokuHoho : ShutsuryokuHoho.values()) {
            if (shutsuryokuHoho.code.equals(code)) {
                return shutsuryokuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("出力方法"));
    }
}
