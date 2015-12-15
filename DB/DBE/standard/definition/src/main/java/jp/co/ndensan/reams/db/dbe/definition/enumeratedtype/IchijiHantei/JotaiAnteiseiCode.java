package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定状態の安定性コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum JotaiAnteiseiCode {

    /**
     * コード:1 名称:安定 略称:定義なし
     */
    安定("1", "安定"),
    /**
     * コード:2 名称:不安定 略称:定義なし
     */
    不安定("2", "不安定");

    private final RString code;
    private final RString fullName;

    private JotaiAnteiseiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 要介護認定状態の安定性コードのコードを返します。
     *
     * @return 要介護認定状態の安定性コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 要介護認定状態の安定性コードの名称を返します。
     *
     * @return 要介護認定状態の安定性コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護認定状態の安定性コードのコードと一致する内容を探します。
     *
     * @param code 要介護認定状態の安定性コードのコード
     * @return {@code code} に対応する要介護認定状態の安定性コード
     */
    public static JotaiAnteiseiCode toValue(RString code) {

        for (JotaiAnteiseiCode jotaiAnteiseiCode : JotaiAnteiseiCode.values()) {
            if (jotaiAnteiseiCode.code.equals(code)) {
                return jotaiAnteiseiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護認定状態の安定性コード"));
    }
}
