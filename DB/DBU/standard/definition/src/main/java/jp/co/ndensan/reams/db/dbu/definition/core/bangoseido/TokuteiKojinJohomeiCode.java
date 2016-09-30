package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定個人情報名コードを表す列挙型です。
 *
 *  @reamsid_L DBU-9999-023 sunhaidi
 */
public enum TokuteiKojinJohomeiCode {

    /**
     * コード:TM00000000000004 名称:特定個人情報版管理番号04 略称:定義なし
     */
    特定個人情報版管理番号04("TM00000000000004", "特定個人情報版管理番号04"),

    /**
     * コード:TM00000000000033 名称:特定個人情報版管理番号33 略称:定義なし
     */
    特定個人情報版管理番号33("TM00000000000033", "特定個人情報版管理番号33"),

    /**
     * コード:TM00000000000034 名称:特定個人情報版管理番号34 略称:定義なし
     */
    特定個人情報版管理番号34("TM00000000000034", "特定個人情報版管理番号34"),

    /**
     * コード:TM00000000000035 名称:特定個人情報版管理番号35 略称:定義なし
     */
    特定個人情報版管理番号35("TM00000000000035", "特定個人情報版管理番号35"),

    /**
     * コード:TM00000000000036 名称:特定個人情報版管理番号36 略称:定義なし
     */
    特定個人情報版管理番号36("TM00000000000036", "特定個人情報版管理番号36"),

    /**
     * コード:TM00000000000037 名称:特定個人情報版管理番号37 略称:定義なし
     */
    特定個人情報版管理番号37("TM00000000000037", "特定個人情報版管理番号37"),

    /**
     * コード:TM00000000000044 名称:特定個人情報版管理番号44 略称:定義なし
     */
    特定個人情報版管理番号44("TM00000000000044", "特定個人情報版管理番号44"),

    /**
     * コード:TM00000000000046 名称:特定個人情報版管理番号46 略称:定義なし
     */
    特定個人情報版管理番号46("TM00000000000046", "特定個人情報版管理番号46"),

    /**
     * コード:TM00000000000047 名称:特定個人情報版管理番号47 略称:定義なし
     */
    特定個人情報版管理番号47("TM00000000000047", "特定個人情報版管理番号47"),

    /**
     * コード:TM00000000000050 名称:特定個人情報版管理番号50 略称:定義なし
     */
    特定個人情報版管理番号50("TM00000000000050", "特定個人情報版管理番号50"),

    /**
     * コード:TM00000000000083 名称:特定個人情報版管理番号83 略称:定義なし
     */
    特定個人情報版管理番号83("TM00000000000083", "特定個人情報版管理番号83");

    private final RString code;
    private final RString fullName;

    private TokuteiKojinJohomeiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特定個人情報名コードのコードを返します。
     *
     * @return 特定個人情報名コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定個人情報名コードの名称を返します。
     *
     * @return 特定個人情報名コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定個人情報名コードのコードと一致する内容を探します。
     *
     * @param code 特定個人情報名コードのコード
     * @return {@code code} に対応する特定個人情報名コード
     */
    public static TokuteiKojinJohomeiCode toValue(RString code) {
        for (TokuteiKojinJohomeiCode tokuteiKojinJohomeiCode : TokuteiKojinJohomeiCode.values()) {
            if (tokuteiKojinJohomeiCode.code.equals(code)) {
                return tokuteiKojinJohomeiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
