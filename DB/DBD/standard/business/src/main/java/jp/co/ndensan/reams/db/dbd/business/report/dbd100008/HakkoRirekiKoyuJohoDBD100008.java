/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100008;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定更新のお知らせ通知書の発行履歴固有情報DBD100008
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public enum HakkoRirekiKoyuJohoDBD100008 {

    /**
     * 被保番号
     */
    被保番号("1", "被保番号");

    private final Code code;
    private final RString fullName;

    private HakkoRirekiKoyuJohoDBD100008(String code, String fullname) {
        this.code = new Code(code);
        this.fullName = new RString(fullname);
    }

    /**
     * サンプル文書グループコードのコードを返します。
     *
     * @return サンプル文書グループコードのコード
     */
    public Code getコード() {
        return code;
    }

    /**
     * サンプル文書グループコードの名称を返します。
     *
     * @return サンプル文書グループコードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 発行履歴固有情報DBD100008のコードと一致する内容を探します。
     *
     * @param code 発行履歴固有情報DBD100008のコード
     * @return {@code code} に対応する発行履歴固有情報DBD100008
     */
    public static HakkoRirekiKoyuJohoDBD100008 toValue(Code code) {
        for (HakkoRirekiKoyuJohoDBD100008 sampleBunshoGroupCodes : HakkoRirekiKoyuJohoDBD100008.values()) {
            if (sampleBunshoGroupCodes.code.equals(code)) {
                return sampleBunshoGroupCodes;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("発行履歴固有情報DBD100008"));
    }
}
