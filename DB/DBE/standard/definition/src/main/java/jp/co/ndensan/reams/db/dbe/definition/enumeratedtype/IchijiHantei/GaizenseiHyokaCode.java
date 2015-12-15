package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認知症高齢者の日常生活自立度の蓋然性評価コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum GaizenseiHyokaCode {

    /**
     * コード:0 名称:判定なし 略称:定義なし
     */
    判定なし("0", "判定なし"),
    /**
     * コード:1 名称:A 略称:定義なし
     */
    A("1", "A"),
    /**
     * コード:2 名称:B 略称:定義なし
     */
    B("2", "B"),
    /**
     * コード:3 名称:C 略称:定義なし
     */
    C("3", "C"),
    /**
     * コード:4 名称:D 略称:定義なし
     */
    D("4", "D");

    private final RString code;
    private final RString fullName;

    private GaizenseiHyokaCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価コードのコードを返します。
     *
     * @return 認知症高齢者の日常生活自立度の蓋然性評価コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価コードの名称を返します。
     *
     * @return 認知症高齢者の日常生活自立度の蓋然性評価コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価コードのコードと一致する内容を探します。
     *
     * @param code 認知症高齢者の日常生活自立度の蓋然性評価コードのコード
     * @return {@code code} に対応する認知症高齢者の日常生活自立度の蓋然性評価コード
     */
    public static GaizenseiHyokaCode toValue(RString code) {

        for (GaizenseiHyokaCode gaizenseiHyokaCode : GaizenseiHyokaCode.values()) {
            if (gaizenseiHyokaCode.code.equals(code)) {
                return gaizenseiHyokaCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認知症高齢者の日常生活自立度の蓋然性評価"));
    }
}
