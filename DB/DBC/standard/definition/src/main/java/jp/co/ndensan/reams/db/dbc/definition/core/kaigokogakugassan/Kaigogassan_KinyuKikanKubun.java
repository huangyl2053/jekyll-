package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_金融機関区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_KinyuKikanKubun {

    /**
     * コード:1 名称:普通銀行
     */
    普銀("1", "普通銀行"),
    /**
     * コード:2 名称:ゆうちょ銀行
     */
    ゆうちょ("2", "ゆうちょ銀行");

    private final RString code;
    private final RString fullName;

    private Kaigogassan_KinyuKikanKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_金融機関区分のコードを返します。
     *
     * @return 介護合算_金融機関区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_金融機関区分の名称を返します。
     *
     * @return 介護合算_金融機関区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_金融機関区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_金融機関区分のコード
     * @return {@code code} に対応する介護合算_金融機関区分
     */
    public static Kaigogassan_KinyuKikanKubun toValue(RString code) {
        for (Kaigogassan_KinyuKikanKubun kaigogassan_KinyuKikanKubun : Kaigogassan_KinyuKikanKubun.values()) {
            if (kaigogassan_KinyuKikanKubun.code.equals(code)) {
                return kaigogassan_KinyuKikanKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_金融機関区分"));
    }
}
