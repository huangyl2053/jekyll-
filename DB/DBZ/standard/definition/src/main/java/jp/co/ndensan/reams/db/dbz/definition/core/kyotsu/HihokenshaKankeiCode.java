package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者との関係コードを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum HihokenshaKankeiCode {

    /**
     * コード:1 名称:本人 略称:定義なし
     */
    本人("1", "本人"),
    /**
     * コード:2 名称:家族 略称:定義なし
     */
    家族("2", "家族"),
    /**
     * コード:3 名称:代理人 略称:定義なし
     */
    代理人("3", "代理人"),
    /**
     * コード:4 名称:サービス事業者 略称:定義なし
     */
    サービス事業者("4", "サービス事業者"),
    /**
     * コード:5 名称:ケアマネージャ 略称:定義なし
     */
    ケアマネージャ("5", "ケアマネージャ");

    private final RString code;
    private final RString fullName;

    private HihokenshaKankeiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 被保険者との関係コードのコードを返します。
     *
     * @return 被保険者との関係コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者との関係コードの名称を返します。
     *
     * @return 被保険者との関係コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者との関係コードのコードと一致する内容を探します。
     *
     * @param code 被保険者との関係コードのコード
     * @return {@code code} に対応する被保険者との関係コード
     */
    public static HihokenshaKankeiCode toValue(RString code) {

        for (HihokenshaKankeiCode hihokenshaKankeiCode : HihokenshaKankeiCode.values()) {
            if (hihokenshaKankeiCode.code.equals(code)) {
                return hihokenshaKankeiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者との関係コード"));
    }
}
