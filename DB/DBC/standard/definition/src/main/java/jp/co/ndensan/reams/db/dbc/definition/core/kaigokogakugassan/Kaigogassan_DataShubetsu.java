package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_データ種類を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_DataShubetsu {

    /**
     * コード:1 名称:通常データ
     */
    通常("1", "通常データ"),
    /**
     * コード:2 名称:仮算定データ
     */
    仮算定("2", "仮算定データ");

    private final RString code;
    private final RString fullName;

    private Kaigogassan_DataShubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_データ種類のコードを返します。
     *
     * @return 介護合算_データ種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_データ種類の名称を返します。
     *
     * @return 介護合算_データ種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_データ種類のコードと一致する内容を探します。
     *
     * @param code 介護合算_データ種類のコード
     * @return {@code code} に対応する介護合算_データ種類
     */
    public static Kaigogassan_DataShubetsu toValue(RString code) {
        for (Kaigogassan_DataShubetsu kaigogassan_DataShubetsu : Kaigogassan_DataShubetsu.values()) {
            if (kaigogassan_DataShubetsu.code.equals(code)) {
                return kaigogassan_DataShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_データ種類"));
    }
}
