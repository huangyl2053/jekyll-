package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過年度の歳出を表す列挙型です。
 *
 * @author LDNS
 */
public enum KanendoSaishutsu {

    /**
     * コード:1 名称:過年度 略称:定義なし
     */
    過年度("1", "過年度"),
    /**
     * コード:2 名称:現年度 略称:定義なし
     */
    現年度("2", "現年度");

    private final RString code;
    private final RString fullName;

    private KanendoSaishutsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 過年度の歳出のコードを返します。
     *
     * @return 過年度の歳出のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 過年度の歳出の名称を返します。
     *
     * @return 過年度の歳出の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 過年度の歳出のコードと一致する内容を探します。
     *
     * @param code 過年度の歳出のコード
     * @return {@code code} に対応する過年度の歳出
     */
    public static KanendoSaishutsu toValue(RString code) {
        for (KanendoSaishutsu kanendoSaishutsu : KanendoSaishutsu.values()) {
            if (kanendoSaishutsu.code.equals(code)) {
                return kanendoSaishutsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過年度の歳出"));
    }
}
