package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認知機能及び状態安定性から推定される給付区分コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum SuiteiKyufuKubunCode {

    /**
     * コード:1 名称:予防給付相当 略称:定義なし
     */
    予防給付相当("1", "予防給付相当"),
    /**
     * コード:2 名称:介護給付相当 略称:定義なし
     */
    介護給付相当("2", "介護給付相当");

    private final RString code;
    private final RString fullName;

    private SuiteiKyufuKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分コードのコードを返します。
     *
     * @return 認知機能及び状態安定性から推定される給付区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分コードの名称を返します。
     *
     * @return 認知機能及び状態安定性から推定される給付区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分コードのコードと一致する内容を探します。
     *
     * @param code 認知機能及び状態安定性から推定される給付区分コードのコード
     * @return {@code code} に対応する認知機能及び状態安定性から推定される給付区分コード
     */
    public static SuiteiKyufuKubunCode toValue(RString code) {

        for (SuiteiKyufuKubunCode suiteiKyufuKubunCode : SuiteiKyufuKubunCode.values()) {
            if (suiteiKyufuKubunCode.code.equals(code)) {
                return suiteiKyufuKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認知機能及び状態安定性から推定される給付区分コード"));
    }
}
