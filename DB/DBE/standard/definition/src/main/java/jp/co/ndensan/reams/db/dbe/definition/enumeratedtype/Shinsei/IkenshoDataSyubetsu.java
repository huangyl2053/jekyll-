package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書データ種別を表す列挙型です。
 *
 * @author LDNS
 */
public enum IkenshoDataSyubetsu {

    /**
     * コード:0 名称:意見書定型 略称:定義なし
     */
    意見書定型("0", "意見書定型"),
    /**
     * コード:1 名称:意見書定型外 略称:定義なし
     */
    意見書定型外("1", "意見書定型外"),
    /**
     * コード:2 名称:外部ｿﾌﾄ 略称:定義なし
     */
    外部ｿﾌﾄ("2", "外部ｿﾌﾄ");

    private final RString code;
    private final RString fullName;

    private IkenshoDataSyubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書データ種別のコードを返します。
     *
     * @return 意見書データ種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書データ種別の名称を返します。
     *
     * @return 意見書データ種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書データ種別のコードと一致する内容を探します。
     *
     * @param code 意見書データ種別のコード
     * @return {@code code} に対応する意見書データ種別
     */
    public static IkenshoDataSyubetsu toValue(RString code) {

        for (IkenshoDataSyubetsu ikenshoDataSyubetsu : IkenshoDataSyubetsu.values()) {
            if (ikenshoDataSyubetsu.code.equals(code)) {
                return ikenshoDataSyubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書データ種別"));
    }
}
