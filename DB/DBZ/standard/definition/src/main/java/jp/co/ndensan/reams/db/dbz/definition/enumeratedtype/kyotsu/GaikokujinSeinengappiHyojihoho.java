package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 外国人生年月日表示方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum GaikokujinSeinengappiHyojihoho {

    /**
     * コード:1 名称:和暦表示 略称:定義なし
     */
    和暦表示("1", "和暦表示"),
    /**
     * コード:2 名称:西暦表示 略称:定義なし
     */
    西暦表示("2", "西暦表示");

    private final RString code;
    private final RString fullName;

    private GaikokujinSeinengappiHyojihoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 外国人生年月日表示方法のコードを返します。
     *
     * @return 外国人生年月日表示方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 外国人生年月日表示方法の名称を返します。
     *
     * @return 外国人生年月日表示方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 外国人生年月日表示方法のコードと一致する内容を探します。
     *
     * @param code 外国人生年月日表示方法のコード
     * @return {@code code} に対応する外国人生年月日表示方法
     */
    public static GaikokujinSeinengappiHyojihoho toValue(RString code) {

        for (GaikokujinSeinengappiHyojihoho value : GaikokujinSeinengappiHyojihoho.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("外国人生年月日表示方法"));
    }
}
