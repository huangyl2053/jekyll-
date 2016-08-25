package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_データ作成区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_DataSakuseiKubun {

    /**
     * コード:1 名称:国保連取込情報
     */
    国保連取込情報("1", "国保連取込情報"),
    /**
     * コード:2 名称:証明書計算処理時作成（申請書有）
     */
    計算処理時_申請書有("2", "証明書計算処理時作成（申請書有）"),
    /**
     * コード:3 名称:証明書計算処理時作成（全受給者）
     */
    計算処理時_全受給者("3", "証明書計算処理時作成（全受給者）");

    private final RString code;
    private final RString fullName;

    private Kaigogassan_DataSakuseiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_データ作成区分のコードを返します。
     *
     * @return 介護合算_データ作成区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_データ作成区分の名称を返します。
     *
     * @return 介護合算_データ作成区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_データ作成区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_データ作成区分のコード
     * @return {@code code} に対応する介護合算_データ作成区分
     */
    public static Kaigogassan_DataSakuseiKubun toValue(RString code) {
        for (Kaigogassan_DataSakuseiKubun kaigogassan_DataSakuseiKubun : Kaigogassan_DataSakuseiKubun.values()) {
            if (kaigogassan_DataSakuseiKubun.code.equals(code)) {
                return kaigogassan_DataSakuseiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護合算_データ作成区分"));
    }
}
