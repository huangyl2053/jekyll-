package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_支給不支給区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_ShikyuFushikyuKubun {

    /**
     * コード:1 名称:支給
     */
    支給("1", "支給"),
    /**
     * コード:2 名称:不支給
     */
    不支給("2", "不支給");

    private final RString code;
    private final RString fullName;

    private Kaigogassan_ShikyuFushikyuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_支給不支給区分のコードを返します。
     *
     * @return 介護合算_支給不支給区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_支給不支給区分の名称を返します。
     *
     * @return 介護合算_支給不支給区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_支給不支給区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_支給不支給区分のコード
     * @return {@code code} に対応する介護合算_支給不支給区分
     */
    public static Kaigogassan_ShikyuFushikyuKubun toValue(RString code) {
        for (Kaigogassan_ShikyuFushikyuKubun value : Kaigogassan_ShikyuFushikyuKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過誤申立_保険者区分"));
    }
}
