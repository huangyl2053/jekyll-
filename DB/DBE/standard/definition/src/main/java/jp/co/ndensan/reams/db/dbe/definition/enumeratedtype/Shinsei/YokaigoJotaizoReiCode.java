package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護状態像例コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum YokaigoJotaizoReiCode {

    /**
     * コード:01 名称:認知機能の低下等 略称:定義なし
     */
    認知機能の低下等("01", "認知機能の低下等"),
    /**
     * コード:02 名称:不安定な状態 略称:定義なし
     */
    不安定な状態("02", "不安定な状態"),
    /**
     * コード:99 名称:その他 略称:定義なし
     */
    その他("99", "その他");

    private final RString code;
    private final RString fullName;

    private YokaigoJotaizoReiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 要介護状態像例コードのコードを返します。
     *
     * @return 要介護状態像例コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 要介護状態像例コードの名称を返します。
     *
     * @return 要介護状態像例コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護状態像例コードのコードと一致する内容を探します。
     *
     * @param code 要介護状態像例コードのコード
     * @return {@code code} に対応する要介護状態像例コード
     */
    public static YokaigoJotaizoReiCode toValue(RString code) {

        for (YokaigoJotaizoReiCode yokaigoJotaizoReiCode : YokaigoJotaizoReiCode.values()) {
            if (yokaigoJotaizoReiCode.code.equals(code)) {
                return yokaigoJotaizoReiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護状態像例"));
    }
}
