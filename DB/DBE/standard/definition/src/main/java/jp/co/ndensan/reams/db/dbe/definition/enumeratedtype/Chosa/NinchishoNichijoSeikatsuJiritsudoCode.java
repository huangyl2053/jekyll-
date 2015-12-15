package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認知症高齢者自立度コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum NinchishoNichijoSeikatsuJiritsudoCode {

    /**
     * コード:1 名称:自立 略称:定義なし
     */
    自立("1", "自立"),
    /**
     * コード:2 名称:Ⅰ 略称:定義なし
     */
    Ⅰ("2", "Ⅰ"),
    /**
     * コード:3 名称:Ⅱa 略称:定義なし
     */
    Ⅱa("3", "Ⅱa"),
    /**
     * コード:4 名称:Ⅱb 略称:定義なし
     */
    Ⅱb("4", "Ⅱb"),
    /**
     * コード:5 名称:Ⅲa 略称:定義なし
     */
    Ⅲa("5", "Ⅲa"),
    /**
     * コード:6 名称:Ⅲb 略称:定義なし
     */
    Ⅲb("6", "Ⅲb"),
    /**
     * コード:7 名称:Ⅳ 略称:定義なし
     */
    Ⅳ("7", "Ⅳ"),
    /**
     * コード:8 名称:M 略称:定義なし
     */
    M("8", "M"),
    /**
     * コード:9 名称:記載無し 略称:定義なし
     */
    記載無し("9", "記載無し");

    private final RString code;
    private final RString fullName;

    private NinchishoNichijoSeikatsuJiritsudoCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認知症高齢者自立度コードのコードを返します。
     *
     * @return 認知症高齢者自立度コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認知症高齢者自立度コードの名称を返します。
     *
     * @return 認知症高齢者自立度コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認知症高齢者自立度コードのコードと一致する内容を探します。
     *
     * @param code 認知症高齢者自立度コードのコード
     * @return {@code code} に対応する認知症高齢者自立度コード
     */
    public static NinchishoNichijoSeikatsuJiritsudoCode toValue(RString code) {

        for (NinchishoNichijoSeikatsuJiritsudoCode value : NinchishoNichijoSeikatsuJiritsudoCode.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認知症高齢者自立度コード"));
    }
}
