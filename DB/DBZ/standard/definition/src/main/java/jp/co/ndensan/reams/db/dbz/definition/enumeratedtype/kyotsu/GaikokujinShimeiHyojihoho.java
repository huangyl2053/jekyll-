package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 外国人氏名表示方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum GaikokujinShimeiHyojihoho {

    /**
     * コード:1 名称:通称名優先表示 略称:定義なし
     */
    通称名優先表示("1", "通称名優先表示"),
    /**
     * コード:2 名称:正式名表示 略称:定義なし
     */
    正式名表示("2", "正式名表示");

    private final RString code;
    private final RString fullName;

    private GaikokujinShimeiHyojihoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 外国人氏名表示方法のコードを返します。
     *
     * @return 外国人氏名表示方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 外国人氏名表示方法の名称を返します。
     *
     * @return 外国人氏名表示方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 外国人氏名表示方法のコードと一致する内容を探します。
     *
     * @param code 外国人氏名表示方法のコード
     * @return {@code code} に対応する外国人氏名表示方法
     */
    public static GaikokujinShimeiHyojihoho toValue(RString code) {

        for (GaikokujinShimeiHyojihoho gaikokujinShimeiHyojihoho : GaikokujinShimeiHyojihoho.values()) {
            if (gaikokujinShimeiHyojihoho.code.equals(code)) {
                return gaikokujinShimeiHyojihoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("外国人氏名表示方法"));
    }
}
