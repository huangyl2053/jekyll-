package jp.co.ndensan.reams.db.dbd.definition.batchprm.common;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 旧措置者区分(バッチ)を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum KyusochishaKubun {

    /**
     * コード:1 名称:旧措置者以外 略称:定義なし
     */
    旧措置者以外("1", "旧措置者以外"),
    /**
     * コード:2 名称:旧措置者 略称:定義なし
     */
    旧措置者("2", "旧措置者");

    private final RString code;
    private final RString fullName;

    private KyusochishaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 旧措置者区分(バッチ)のコードを返します。
     *
     * @return 旧措置者区分(バッチ)のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 旧措置者区分(バッチ)の名称を返します。
     *
     * @return 旧措置者区分(バッチ)の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 旧措置者区分(バッチ)のコードと一致する内容を探します。
     *
     * @param code 旧措置者区分(バッチ)のコード
     * @return {@code code} に対応する旧措置者区分(バッチ)
     */
    public static KyusochishaKubun toValue(RString code) {

        for (KyusochishaKubun kyusochishaKubun : KyusochishaKubun.values()) {
            if (kyusochishaKubun.code.equals(code)) {
                return kyusochishaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("旧措置者区分(バッチ)"));
    }
}
