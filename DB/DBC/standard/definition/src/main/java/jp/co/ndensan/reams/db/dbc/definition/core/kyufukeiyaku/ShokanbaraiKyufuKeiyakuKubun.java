package jp.co.ndensan.reams.db.dbc.definition.core.kyufukeiyaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払給付契約の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShokanbaraiKyufuKeiyakuKubun {

    /**
     * コード:true 名称:契約有り 略称:定義なし
     */
    契約有り("true", "契約有り"),
    /**
     * コード:false 名称:契約無し 略称:定義なし
     */
    契約無し("false", "契約無し");

    private final RString code;
    private final RString fullName;

    private ShokanbaraiKyufuKeiyakuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 償還払給付契約の有無のコードを返します。
     *
     * @return 償還払給付契約の有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 償還払給付契約の有無の名称を返します。
     *
     * @return 償還払給付契約の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 償還払給付契約の有無のコードと一致する内容を探します。
     *
     * @param code 償還払給付契約の有無のコード
     * @return {@code code} に対応する償還払給付契約の有無
     */
    public static ShokanbaraiKyufuKeiyakuKubun toValue(RString code) {

        for (ShokanbaraiKyufuKeiyakuKubun shokanbaraiKyufuKeiyakuKubun : ShokanbaraiKyufuKeiyakuKubun.values()) {
            if (shokanbaraiKyufuKeiyakuKubun.code.equals(code)) {
                return shokanbaraiKyufuKeiyakuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("償還払給付契約の有無"));
    }
}
