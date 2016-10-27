/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_自己負担額証明書リアル発行フラグを表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 qinzhen
 */
public enum KaigoGassan_JikofutangakuShomeishoRealHakkoFlag {

    /**
     * コード:0 名称:未発行 略称:未発行
     */
    未発行("0", "未発行", "未発行"),
    /**
     * コード:1 名称:発行済 略称:発行済
     */
    発行済("1", "発行済", "発行済");
    private final RString code;
    private final RString shortName;
    private final RString fullName;

    private KaigoGassan_JikofutangakuShomeishoRealHakkoFlag(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 介護合算_自己負担額証明書リアル発行フラグのコードを返します。
     *
     * @return 介護合算_自己負担額証明書リアル発行フラグのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_自己負担額証明書リアル発行フラグの名称を返します。
     *
     * @return 介護合算_自己負担額証明書リアル発行フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_自己負担額証明書リアル発行フラグを返します。
     *
     * @return 介護合算_自己負担額証明書リアル発行フラグの略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 介護合算_自己負担額証明書リアル発行フラグのコードと一致する内容を探します。
     *
     * @param code 介護合算_自己負担額証明書リアル発行フラグのコード
     * @return {@code code} に対応する介護合算_自己負担額証明書リアル発行フラグ
     */
    public static KaigoGassan_JikofutangakuShomeishoRealHakkoFlag toValue(RString code) {

        for (KaigoGassan_JikofutangakuShomeishoRealHakkoFlag realHakkoFlag : KaigoGassan_JikofutangakuShomeishoRealHakkoFlag.values()) {
            if (realHakkoFlag.code.equals(code)) {
                return realHakkoFlag;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_自己負担額証明書リアル発行フラグ"));
    }
}
