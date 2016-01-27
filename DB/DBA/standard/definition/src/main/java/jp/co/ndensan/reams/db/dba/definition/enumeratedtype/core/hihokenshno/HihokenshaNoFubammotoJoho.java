package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.core.hihokenshno;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者番号付番元情報を表す列挙型です。
 *
 */
public enum HihokenshaNoFubammotoJoho {

    /**
     * コード:0 名称:未設定 略称:定義なし
     */
    未設定("0", "未設定"),
    /**
     * コード:1 名称:住民コード 略称:定義なし
     */
    住民コード("1", "住民コード"),
    /**
     * コード:2 名称:自動連番 略称:定義なし
     */
    自動連番("2", "自動連番");

    private final RString code;
    private final RString fullName;

    private HihokenshaNoFubammotoJoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 被保険者番号付番元情報のコードを返します。
     *
     * @return 被保険者番号付番元情報のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者番号付番元情報の名称を返します。
     *
     * @return 被保険者番号付番元情報の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者番号付番元情報のコードと一致する内容を探します。
     *
     * @param code 被保険者番号付番元情報のコード
     * @return {@code code} に対応する被保険者番号付番元情報
     */
    public static HihokenshaNoFubammotoJoho toValue(RString code) {
        for (HihokenshaNoFubammotoJoho hihokenshaNoFubammotoJoho : HihokenshaNoFubammotoJoho.values()) {
            if (hihokenshaNoFubammotoJoho.code.equals(code)) {
                return hihokenshaNoFubammotoJoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者番号付番元情報"));
    }
}
