package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 速報取込区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SokuhoTorikomiKubun {

    /**
     * コード:0 名称:取り込まない 略称:定義なし
     */
    取り込まない("0", "取り込まない"),
    /**
     * コード:1 名称:取り込む 略称:定義なし
     */
    取り込む("1", "取り込む");

    private final RString code;
    private final RString fullName;

    private SokuhoTorikomiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 速報取込区分のコードを返します。
     *
     * @return 速報取込区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 速報取込区分の名称を返します。
     *
     * @return 速報取込区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 速報取込区分のコードと一致する内容を探します。
     *
     * @param code 速報取込区分のコード
     * @return {@code code} に対応する速報取込区分
     */
    public static SokuhoTorikomiKubun toValue(RString code) {
        for (SokuhoTorikomiKubun sokuhoTorikomiKubun : SokuhoTorikomiKubun.values()) {
            if (sokuhoTorikomiKubun.code.equals(code)) {
                return sokuhoTorikomiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("速報取込区分"));
    }
}
