package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 代行プリント有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum DaikoPrintUmu {

    /**
     * コード:0 名称:プリントしない 略称:定義なし
     */
    プリントしない("0", "プリントしない"),
    /**
     * コード:1 名称:プリントする 略称:定義なし
     */
    プリントする("1", "プリントする");

    private final RString code;
    private final RString fullName;

    private DaikoPrintUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 代行プリント有無のコードを返します。
     *
     * @return 代行プリント有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 代行プリント有無の名称を返します。
     *
     * @return 代行プリント有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 代行プリント有無のコードと一致する内容を探します。
     *
     * @param code 代行プリント有無のコード
     * @return {@code code} に対応する代行プリント有無
     */
    public static DaikoPrintUmu toValue(RString code) {

        for (DaikoPrintUmu daikoPrintUmu : DaikoPrintUmu.values()) {
            if (daikoPrintUmu.code.equals(code)) {
                return daikoPrintUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("代行プリント有無"));
    }
}
