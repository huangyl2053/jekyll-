/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 通知内容コードを表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 liangbc
 */
public enum TsuchiNaiyoCode {

    /**
     * コード:93 名称:補足給付初回回付(年次) 略称:定義なし
     */
    補足給付初回回付_年次("93", "補足給付初回回付(年次)"),
    /**
     * コード:94 名称:補足給付初回回付(月次) 略称:定義なし
     */
    補足給付初回回付_月次("94", "補足給付初回回付(月次)");

    private final RString code;
    private final RString fullName;

    private TsuchiNaiyoCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 通知内容コードのコードを返します。
     *
     * @return 通知内容コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 通知内容コードの名称を返します。
     *
     * @return 通知内容コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 通知内容コードのコードと一致する内容を探します。
     *
     * @param code 通知内容コードのコード
     * @return {@code code} に対応する通知内容コード
     */
    public static TsuchiNaiyoCode toValue(RString code) {
        for (TsuchiNaiyoCode tsuchiNaiyoCode : TsuchiNaiyoCode.values()) {
            if (tsuchiNaiyoCode.code.equals(code)) {
                return tsuchiNaiyoCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("通知内容コード"));
    }
}
