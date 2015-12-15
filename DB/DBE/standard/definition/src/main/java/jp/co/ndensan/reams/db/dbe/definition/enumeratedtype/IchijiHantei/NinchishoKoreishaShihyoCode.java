package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 運動能力の低下していない認知症高齢者の指標コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum NinchishoKoreishaShihyoCode {

    /**
     * コード:XX1 名称:？？？ 略称:定義なし
     */
    _XX1("XX1", "？？？"),
    /**
     * コード:XX2 名称:？？？ 略称:定義なし
     */
    _XX2("XX2", "？？？");

    private final RString code;
    private final RString fullName;

    private NinchishoKoreishaShihyoCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 運動能力の低下していない認知症高齢者の指標コードのコードを返します。
     *
     * @return 運動能力の低下していない認知症高齢者の指標コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 運動能力の低下していない認知症高齢者の指標コードの名称を返します。
     *
     * @return 運動能力の低下していない認知症高齢者の指標コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 運動能力の低下していない認知症高齢者の指標コードのコードと一致する内容を探します。
     *
     * @param code 運動能力の低下していない認知症高齢者の指標コードのコード
     * @return {@code code} に対応する運動能力の低下していない認知症高齢者の指標コード
     */
    public static NinchishoKoreishaShihyoCode toValue(RString code) {

        for (NinchishoKoreishaShihyoCode ninchishoKoreishaShihyoCode : NinchishoKoreishaShihyoCode.values()) {
            if (ninchishoKoreishaShihyoCode.code.equals(code)) {
                return ninchishoKoreishaShihyoCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("運動能力の低下していない認知症高齢者の指標コード"));
    }
}
