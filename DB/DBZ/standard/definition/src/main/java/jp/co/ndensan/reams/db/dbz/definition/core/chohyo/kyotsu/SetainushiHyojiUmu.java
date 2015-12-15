package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯主表示有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum SetainushiHyojiUmu {

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

    private SetainushiHyojiUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 世帯主表示有無のコードを返します。
     *
     * @return 世帯主表示有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 世帯主表示有無の名称を返します。
     *
     * @return 世帯主表示有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 世帯主表示有無のコードと一致する内容を探します。
     *
     * @param code 世帯主表示有無のコード
     * @return {@code code} に対応する世帯主表示有無
     */
    public static SetainushiHyojiUmu toValue(RString code) {

        for (SetainushiHyojiUmu setainushiHyojiUmu : SetainushiHyojiUmu.values()) {
            if (setainushiHyojiUmu.code.equals(code)) {
                return setainushiHyojiUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("世帯主表示有無"));
    }
}
