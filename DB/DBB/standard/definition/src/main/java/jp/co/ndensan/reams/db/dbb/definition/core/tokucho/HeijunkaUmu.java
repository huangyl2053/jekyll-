package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 平準化有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum HeijunkaUmu {

    /**
     * コード:0 名称:しない 略称:定義なし
     */
    しない("0", "しない"),
    /**
     * コード:1 名称:する 略称:定義なし
     */
    する("1", "する");

    private final RString code;
    private final RString fullName;

    private HeijunkaUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 平準化有無のコードを返します。
     *
     * @return 平準化有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 平準化有無の名称を返します。
     *
     * @return 平準化有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 平準化有無のコードと一致する内容を探します。
     *
     * @param code 平準化有無のコード
     * @return {@code code} に対応する平準化有無
     */
    public static HeijunkaUmu toValue(RString code) {
        for (HeijunkaUmu heijunkaUmu : HeijunkaUmu.values()) {
            if (heijunkaUmu.code.equals(code)) {
                return heijunkaUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("平準化有無"));
    }
}
