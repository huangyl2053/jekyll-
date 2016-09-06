package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_給付実績作成区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 sunhaidi
 */
public enum KaigoGassan_KyufuJissekiSakuseiKubun {

    /**
     * コード:1 名称:新規 略称:定義なし
     */
    新規("1", "新規"),
    /**
     * コード:2 名称:修正 略称:定義なし
     */
    修正("2", "修正"),
    /**
     * コード:3 名称:取消 略称:定義なし
     */
    取消("3", "取消");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_KyufuJissekiSakuseiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_給付実績作成区分のコードを返します。
     *
     * @return 介護合算_給付実績作成区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_給付実績作成区分の名称を返します。
     *
     * @return 介護合算_給付実績作成区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_給付実績作成区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_給付実績作成区分のコード
     * @return {@code code} に対応する介護合算_給付実績作成区分
     */
    public static KaigoGassan_KyufuJissekiSakuseiKubun toValue(RString code) {
        for (KaigoGassan_KyufuJissekiSakuseiKubun value : KaigoGassan_KyufuJissekiSakuseiKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
