package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座マスク有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum KozaMaskUmu {

    /**
     * コード:0 名称:マスクしない 略称:定義なし
     */
    マスクしない("0", "マスクしない"),
    /**
     * コード:1 名称:マスクする 略称:定義なし
     */
    マスクする("1", "マスクする");

    private final RString code;
    private final RString fullName;

    private KozaMaskUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 口座マスク有無のコードを返します。
     *
     * @return 口座マスク有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 口座マスク有無の名称を返します。
     *
     * @return 口座マスク有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 口座マスク有無のコードと一致する内容を探します。
     *
     * @param code 口座マスク有無のコード
     * @return {@code code} に対応する口座マスク有無
     */
    public static KozaMaskUmu toValue(RString code) {

        for (KozaMaskUmu kozaMaskUmu : KozaMaskUmu.values()) {
            if (kozaMaskUmu.code.equals(code)) {
                return kozaMaskUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("口座マスク有無"));
    }
}
