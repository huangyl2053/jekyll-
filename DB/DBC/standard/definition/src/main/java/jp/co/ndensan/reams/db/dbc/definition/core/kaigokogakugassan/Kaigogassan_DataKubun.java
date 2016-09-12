package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_データ区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_DataKubun {

    /**
     * コード:1 名称:国保連作成
     */
    国保連作成("1", "国保連作成"),
    /**
     * コード:2 名称:保険者作成
     */
    保険者作成("2", "保険者作成"),
    /**
     * コード:3 名称:国保連作成(２の返却)
     */
    国保連作成_２の返却("3", "国保連作成(２の返却)");

    private final RString code;
    private final RString fullName;

    private Kaigogassan_DataKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_データ区分のコードを返します。
     *
     * @return 介護合算_データ区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_データ区分の名称を返します。
     *
     * @return 介護合算_データ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_データ区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_データ区分のコード
     * @return {@code code} に対応する介護合算_データ区分
     */
    public static Kaigogassan_DataKubun toValue(RString code) {
        for (Kaigogassan_DataKubun kaigogassan_DataKubun : Kaigogassan_DataKubun.values()) {
            if (kaigogassan_DataKubun.code.equals(code)) {
                return kaigogassan_DataKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_データ区分"));
    }
}
