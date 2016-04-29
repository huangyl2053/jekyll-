package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 預貯金申告区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 huangh
 */
public enum YochokinShinkokuKubun {

    /**
     * コード:1 名称:以下 略称:定義なし
     */
    以下("1", "以下"),
    /**
     * コード:0 名称:超過 略称:定義なし
     */
    超過("0", "超過");

    private final RString code;
    private final RString fullName;

    private YochokinShinkokuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 預貯金申告区分のコードを返します。
     *
     * @return 預貯金申告区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 預貯金申告区分の名称を返します。
     *
     * @return 預貯金申告区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 預貯金申告区分のコードと一致する内容を探します。
     *
     * @param code 預貯金申告区分のコード
     * @return {@code code} に対応する預貯金申告区分
     */
    public static YochokinShinkokuKubun toValue(RString code) {
        for (YochokinShinkokuKubun yochokinShinkokuKubun : YochokinShinkokuKubun.values()) {
            if (yochokinShinkokuKubun.code.equals(code)) {
                return yochokinShinkokuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("預貯金申告区分"));
    }
}
