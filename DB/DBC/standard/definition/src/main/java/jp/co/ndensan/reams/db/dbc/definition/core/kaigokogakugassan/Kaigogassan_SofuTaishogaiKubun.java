package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_送付対象外を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_SofuTaishogaiKubun {

    /**
     * コード:1 名称:送付対象外
     */
    送付対象外("1", "送付対象外");

    private final RString code;
    private final RString fullName;

    private Kaigogassan_SofuTaishogaiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_送付対象外のコードを返します。
     *
     * @return 介護合算_送付対象外のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_送付対象外の名称を返します。
     *
     * @return 介護合算_送付対象外の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_送付対象外のコードと一致する内容を探します。
     *
     * @param code 介護合算_送付対象外のコード
     * @return {@code code} に対応する介護合算_送付対象外
     */
    public static Kaigogassan_SofuTaishogaiKubun toValue(RString code) {
        for (Kaigogassan_SofuTaishogaiKubun value : Kaigogassan_SofuTaishogaiKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_送付対象外"));
    }
}
