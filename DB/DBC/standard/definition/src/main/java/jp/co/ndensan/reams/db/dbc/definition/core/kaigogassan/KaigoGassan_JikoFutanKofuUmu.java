/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_自己負担額証明書交付申請の有無列挙型です
 *
 * @reamsid_L DBC-9999-022 zhengshenlei
 */
public enum KaigoGassan_JikoFutanKofuUmu {

    /**
     * コード:1 名称:無 略称:定義なし
     */
    無("1", "無"),
    /**
     * コード:2 名称:有 略称:定義なし
     */
    有("2", "有");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_JikoFutanKofuUmu(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 介護合算_自己負担額証明書交付申請の有無のコードを返します。
     *
     * @return 介護合算_自己負担額証明書交付申請の有無のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 介護合算_自己負担額証明書交付申請の有無を返します。
     *
     * @return 介護合算_自己負担額証明書交付申請の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_自己負担額証明書交付申請の有無のコードと一致する内容を探します。
     *
     * @param code 介護合算_自己負担額証明書交付申請の有無のコード
     * @return {@code code} に対応する介護合算_自己負担額証明書交付申請の有無
     */
    public static KaigoGassan_JikoFutanKofuUmu toValue(RString code) {
        for (KaigoGassan_JikoFutanKofuUmu jikoFutanKofuUmu : KaigoGassan_JikoFutanKofuUmu.values()) {
            if (jikoFutanKofuUmu.code.equals(code)) {
                return jikoFutanKofuUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_自己負担額証明書交付申請の有無"));
    }
}
