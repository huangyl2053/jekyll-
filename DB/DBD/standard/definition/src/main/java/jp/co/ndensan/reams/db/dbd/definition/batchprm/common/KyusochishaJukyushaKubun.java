package jp.co.ndensan.reams.db.dbd.definition.batchprm.common;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 旧措置者受給者区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum KyusochishaJukyushaKubun {

    /**
     * コード:1 名称:両方 略称:定義なし
     */
    両方("1", "両方"),
    /**
     * コード:3 名称:旧措置者のみ 略称:定義なし
     */
    旧措置者のみ("3", "旧措置者のみ"),
    /**
     * コード:2 名称:旧措置者以外 略称:定義なし
     */
    旧措置者以外("2", "旧措置者以外");

    private final RString code;
    private final RString fullName;

    private KyusochishaJukyushaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 旧措置者受給者区分のコードを返します。
     *
     * @return 旧措置者受給者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 旧措置者受給者区分の名称を返します。
     *
     * @return 旧措置者受給者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 旧措置者受給者区分のコードと一致する内容を探します。
     *
     * @param code 旧措置者受給者区分のコード
     * @return {@code code} に対応する旧措置者受給者区分
     */
    public static KyusochishaJukyushaKubun toValue(RString code) {
        for (KyusochishaJukyushaKubun kyusochishaJukyushaKubun : KyusochishaJukyushaKubun.values()) {
            if (kyusochishaJukyushaKubun.code.equals(code)) {
                return kyusochishaJukyushaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("旧措置者受給者区分"));
    }
}
