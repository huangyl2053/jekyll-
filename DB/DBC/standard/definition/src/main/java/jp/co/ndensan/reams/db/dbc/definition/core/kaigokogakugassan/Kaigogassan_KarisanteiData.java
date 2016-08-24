package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_仮算定データを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_KarisanteiData {

    /**
     * コード:9999999 名称:仮算定データ
     */
    仮算定データ("9999999", "仮算定データ");

    private final RString code;
    private final RString fullName;

    private Kaigogassan_KarisanteiData(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_仮算定データのコードを返します。
     *
     * @return 介護合算_仮算定データのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_仮算定データの名称を返します。
     *
     * @return 介護合算_仮算定データの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_仮算定データのコードと一致する内容を探します。
     *
     * @param code 介護合算_仮算定データのコード
     * @return {@code code} に対応する介護合算_仮算定データ
     */
    public static Kaigogassan_KarisanteiData toValue(RString code) {
        for (Kaigogassan_KarisanteiData kaigogassan_KarisanteiData : Kaigogassan_KarisanteiData.values()) {
            if (kaigogassan_KarisanteiData.code.equals(code)) {
                return kaigogassan_KarisanteiData;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_仮算定データ"));
    }
}
