package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_抽出区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_ChushutsuKubun {

    /**
     * コード:1 名称:直近データ
     */
    直近("1", "直近データ");

    private final RString code;
    private final RString fullName;

    private Kaigogassan_ChushutsuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_抽出区分のコードを返します。
     *
     * @return 介護合算_抽出区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_抽出区分の名称を返します。
     *
     * @return 介護合算_抽出区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_抽出区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_抽出区分のコード
     * @return {@code code} に対応する介護合算_抽出区分
     */
    public static Kaigogassan_ChushutsuKubun toValue(RString code) {
        for (Kaigogassan_ChushutsuKubun kaigogassan_ChushutsuKubun : Kaigogassan_ChushutsuKubun.values()) {
            if (kaigogassan_ChushutsuKubun.code.equals(code)) {
                return kaigogassan_ChushutsuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_抽出区分"));
    }
}
