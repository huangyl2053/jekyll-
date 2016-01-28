package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 平準化開始期を表す列挙型です。
 *
 * @author LDNS
 */
public enum HeijunkaKaishiKi {

    /**
     * コード:1 名称:二期から平準化 略称:定義なし
     */
    二期から平準化("1", "二期から平準化"),
    /**
     * コード:2 名称:三期から平準化 略称:定義なし
     */
    三期から平準化("2", "三期から平準化");

    private final RString code;
    private final RString fullName;

    private HeijunkaKaishiKi(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 平準化開始期のコードを返します。
     *
     * @return 平準化開始期のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 平準化開始期の名称を返します。
     *
     * @return 平準化開始期の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 平準化開始期のコードと一致する内容を探します。
     *
     * @param code 平準化開始期のコード
     * @return {@code code} に対応する平準化開始期
     */
    public static HeijunkaKaishiKi toValue(RString code) {
        for (HeijunkaKaishiKi heijunkaKaishiKi : HeijunkaKaishiKi.values()) {
            if (heijunkaKaishiKi.code.equals(code)) {
                return heijunkaKaishiKi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("平準化開始期"));
    }
}
