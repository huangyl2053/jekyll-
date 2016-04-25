package jp.co.ndensan.reams.db.dbz.definition.core.kyusochisha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 旧措置者区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum KyusochishaKubun {

    /**
     * コード:true 名称:旧措置者 略称:定義なし
     */
    旧措置者(true, "旧措置者"),
    /**
     * コード:false 名称:通常者 略称:定義なし
     */
    通常者(false, "通常者");

    private final boolean code;
    private final RString fullName;

    private KyusochishaKubun(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 旧措置者区分のコードを返します。
     *
     * @return 旧措置者区分のコード
     */
    public boolean isコード() {
        return code;
    }

    /**
     * 旧措置者区分の名称を返します。
     *
     * @return 旧措置者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 旧措置者区分のコードと一致する内容を探します。
     *
     * @param code 旧措置者区分のコード
     * @return {@code code} に対応する旧措置者区分
     */
    public static KyusochishaKubun toValue(boolean code) {
        for (KyusochishaKubun value : KyusochishaKubun.values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("旧措置者区分"));
    }
}
