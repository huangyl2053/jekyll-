package jp.co.ndensan.reams.db.dba.definition.core.shohyojitype;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証表示タイプを表す列挙型です。
 *
 */
public enum HihokenshashoHyojiType {

    /**
     * コード:01 名称:A4横 略称:定義なし
     */
    A4横("01", "A4横"),
    /**
     * コード:21 名称:B4横 略称:定義なし
     */
    B4横("21", "B4横");

    private final RString code;
    private final RString fullName;

    private HihokenshashoHyojiType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 被保険者証表示タイプのコードを返します。
     *
     * @return 被保険者証表示タイプのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者証表示タイプの名称を返します。
     *
     * @return 被保険者証表示タイプの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者証表示タイプのコードと一致する内容を探します。
     *
     * @param code 被保険者証表示タイプのコード
     * @return {@code code} に対応する被保険者証表示タイプ
     */
    public static HihokenshashoHyojiType toValue(RString code) {
        for (HihokenshashoHyojiType hihokenshashoHyojiType : HihokenshashoHyojiType.values()) {
            if (hihokenshashoHyojiType.code.equals(code)) {
                return hihokenshashoHyojiType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者証表示タイプ"));
    }
}
