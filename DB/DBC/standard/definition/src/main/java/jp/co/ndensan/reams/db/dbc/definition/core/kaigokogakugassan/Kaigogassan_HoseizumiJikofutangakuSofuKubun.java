package jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護合算_補正済自己負担額送付区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Kaigogassan_HoseizumiJikofutangakuSofuKubun {

    /**
     * コード:0 名称:未送付
     */
    未送付("0", "未送付"),
    /**
     * コード:1 名称:送付済
     */
    送付済("1", "送付済");

    private final RString code;
    private final RString fullName;

    private Kaigogassan_HoseizumiJikofutangakuSofuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 介護合算_補正済自己負担額送付区分のコードを返します。
     *
     * @return 介護合算_補正済自己負担額送付区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護合算_補正済自己負担額送付区分の名称を返します。
     *
     * @return 介護合算_補正済自己負担額送付区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護合算_補正済自己負担額送付区分のコードと一致する内容を探します。
     *
     * @param code 介護合算_補正済自己負担額送付区分のコード
     * @return {@code code} に対応する介護合算_補正済自己負担額送付区分
     */
    public static Kaigogassan_HoseizumiJikofutangakuSofuKubun toValue(RString code) {
        for (Kaigogassan_HoseizumiJikofutangakuSofuKubun value : Kaigogassan_HoseizumiJikofutangakuSofuKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過誤申立_保険者区分"));
    }
}
