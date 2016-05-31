package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.hyojunfutangakugemmen;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 標準負担区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum HyojunFutanKubun {

    /**
     * コード:1 名称:標準負担 略称:定義なし
     */
    標準負担("1", "標準負担"),
    /**
     * コード:2 名称:特定標準負担 略称:定義なし
     */
    特定標準負担("2", "特定標準負担");

    private final RString code;
    private final RString fullName;

    private HyojunFutanKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 標準負担区分のコードを返します。
     *
     * @return 標準負担区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 標準負担区分の名称を返します。
     *
     * @return 標準負担区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 標準負担区分のコードと一致する内容を探します。
     *
     * @param code 標準負担区分のコード
     * @return {@code code} に対応する標準負担区分
     */
    public static HyojunFutanKubun toValue(RString code) {
        for (HyojunFutanKubun hyojunFutanKubun : HyojunFutanKubun.values()) {
            if (hyojunFutanKubun.code.equals(code)) {
                return hyojunFutanKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("標準負担区分"));
    }
}
