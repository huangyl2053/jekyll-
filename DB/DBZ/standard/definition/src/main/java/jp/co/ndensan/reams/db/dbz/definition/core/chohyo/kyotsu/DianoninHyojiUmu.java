package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 代納人表示有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum DianoninHyojiUmu {

    /**
     * コード:0 名称:表示しない 略称:定義なし
     */
    表示しない("0", "表示しない"),
    /**
     * コード:1 名称:表示する 略称:定義なし
     */
    表示する("1", "表示する");

    private final RString code;
    private final RString fullName;

    private DianoninHyojiUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 代納人表示有無のコードを返します。
     *
     * @return 代納人表示有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 代納人表示有無の名称を返します。
     *
     * @return 代納人表示有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 代納人表示有無のコードと一致する内容を探します。
     *
     * @param code 代納人表示有無のコード
     * @return {@code code} に対応する代納人表示有無
     */
    public static DianoninHyojiUmu toValue(RString code) {

        for (DianoninHyojiUmu dianoninHyojiUmu : DianoninHyojiUmu.values()) {
            if (dianoninHyojiUmu.code.equals(code)) {
                return dianoninHyojiUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("代納人表示有無"));
    }
}
