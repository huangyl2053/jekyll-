package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 障害高齢者自立度コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum ShogaiNichijoSeikatsuJiritsudoCode {

    /**
     * コード:1 名称:自立 略称:定義なし
     */
    自立("1", "自立"),
    /**
     * コード:2 名称:J1 略称:定義なし
     */
    J1("2", "J1"),
    /**
     * コード:3 名称:J2 略称:定義なし
     */
    J2("3", "J2"),
    /**
     * コード:4 名称:A1 略称:定義なし
     */
    A1("4", "A1"),
    /**
     * コード:5 名称:A2 略称:定義なし
     */
    A2("5", "A2"),
    /**
     * コード:6 名称:B1 略称:定義なし
     */
    B1("6", "B1"),
    /**
     * コード:7 名称:B2 略称:定義なし
     */
    B2("7", "B2"),
    /**
     * コード:8 名称:C1 略称:定義なし
     */
    C1("8", "C1"),
    /**
     * コード:9 名称:C2 略称:定義なし
     */
    C2("9", "C2"),
    /**
     * コード:10 名称:記載無し 略称:定義なし
     */
    記載無し("10", "記載無し");

    private final RString code;
    private final RString fullName;

    private ShogaiNichijoSeikatsuJiritsudoCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 障害高齢者自立度コードのコードを返します。
     *
     * @return 障害高齢者自立度コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 障害高齢者自立度コードの名称を返します。
     *
     * @return 障害高齢者自立度コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 障害高齢者自立度コードのコードと一致する内容を探します。
     *
     * @param code 障害高齢者自立度コードのコード
     * @return {@code code} に対応する障害高齢者自立度コード
     */
    public static ShogaiNichijoSeikatsuJiritsudoCode toValue(RString code) {

        for (ShogaiNichijoSeikatsuJiritsudoCode value : ShogaiNichijoSeikatsuJiritsudoCode.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("障害高齢者自立度コード"));
    }
}
