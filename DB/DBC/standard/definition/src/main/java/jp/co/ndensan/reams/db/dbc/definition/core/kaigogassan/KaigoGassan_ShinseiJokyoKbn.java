/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_申請状況区分を表す列挙型です。
 *
 * @reamsid_L DBC-3103-010 dingminghao
 */
public enum KaigoGassan_ShinseiJokyoKbn {

    /**
     * コード:1 名称:1:支給申請書 略称:定義なし
     */
    支給申請書("1", "支給申請書"),
    /**
     * コード:2 名称:2:証明書交付申請書 略称:定義なし
     */
    証明書交付申請書("2", "証明書交付申請書"),
    /**
     * コード:3 名称:3:未発行分のみ 略称:定義なし
     */
    支給申請書_写("3", "支給申請書（写）");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_ShinseiJokyoKbn(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_申請状況区分のコードを返します。
     *
     * @return 介護合算_申請状況区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_申請状況区分の名称を返します。
     *
     * @return 介護合算_申請状況区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_申請状況区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_申請状況区分のコード
     * @return {@code code} に対応する介護合算_申請状況区分
     */
    public static KaigoGassan_ShinseiJokyoKbn toValue(RString code) {

        for (KaigoGassan_ShinseiJokyoKbn insho : KaigoGassan_ShinseiJokyoKbn.values()) {
            if (insho.code.equals(code)) {
                return insho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_申請状況区分"));
    }
}
