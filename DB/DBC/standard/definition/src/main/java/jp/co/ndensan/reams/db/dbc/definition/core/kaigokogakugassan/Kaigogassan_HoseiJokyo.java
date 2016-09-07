package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_補正状況を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_HoseiJokyo {

    /**
     * コード:1 名称:補正済
     */
    補正済("1", "補正済"),
    /**
     * コード:2 名称:未補正
     */
    未補正("2", "未補正");

    private final RString code;
    private final RString fullName;

    private Kaigogassan_HoseiJokyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_補正状況のコードを返します。
     *
     * @return 介護合算_補正状況のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_補正状況の名称を返します。
     *
     * @return 介護合算_補正状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_補正状況のコードと一致する内容を探します。
     *
     * @param code 介護合算_補正状況のコード
     * @return {@code code} に対応する介護合算_補正状況
     */
    public static Kaigogassan_HoseiJokyo toValue(RString code) {
        for (Kaigogassan_HoseiJokyo kaigogassan_HoseiJokyo : Kaigogassan_HoseiJokyo.values()) {
            if (kaigogassan_HoseiJokyo.code.equals(code)) {
                return kaigogassan_HoseiJokyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_補正状況"));
    }
}
