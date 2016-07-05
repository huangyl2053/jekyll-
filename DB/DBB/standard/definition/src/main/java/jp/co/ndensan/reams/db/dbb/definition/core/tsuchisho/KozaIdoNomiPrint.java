/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座異動のみプリントを表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 wangchao
 */
public enum KozaIdoNomiPrint {

    /**
     * コード:0 名称:発行しない 略称:無
     */
    口座異動のみの場合にﾌﾟﾘﾝﾄは不要("0", "発行しない"),
    /**
     * コード:1 名称:発行する 略称:無
     */
    口座異動のみの場合にﾌﾟﾘﾝﾄを行う("1", "発行する");

    private final RString code;
    private final RString fullName;

    private KozaIdoNomiPrint(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 口座異動のみプリントのコードを返します。
     *
     * @return 口座異動のみプリントのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 口座異動のみプリントの名称を返します。
     *
     * @return 口座異動のみプリントの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 口座異動のみプリントのコードと一致する内容を探します。
     *
     * @param code 口座異動のみプリントのコード
     * @return {@code code} に対応する口座異動のみプリント
     */
    public static KozaIdoNomiPrint toValue(RString code) {
        for (KozaIdoNomiPrint kozaIdoNomiPrint : KozaIdoNomiPrint.values()) {
            if (kozaIdoNomiPrint.code.equals(code)) {
                return kozaIdoNomiPrint;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("口座異動のみプリント"));
    }
}
