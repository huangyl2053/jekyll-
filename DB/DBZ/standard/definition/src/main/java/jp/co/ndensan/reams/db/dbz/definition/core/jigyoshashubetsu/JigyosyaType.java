package jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業者種別を表す列挙型です。
 *
 * @author LDNS
 */
public enum JigyosyaType {

    /**
     * コード:01 名称:住所地特例対象施設 略称:定義なし
     */
    住所地特例対象施設("01", "住所地特例対象施設"),
    /**
     * コード:02 名称:適用除外施設 略称:定義なし
     */
    適用除外施設("02", "適用除外施設");

    private final RString code;
    private final RString fullName;

    private JigyosyaType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 事業者種別のコードを返します。
     *
     * @return 事業者種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 事業者種別の名称を返します。
     *
     * @return 事業者種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 事業者種別のコードと一致する内容を探します。
     *
     * @param code 事業者種別のコード
     * @return {@code code} に対応する事業者種別
     */
    public static JigyosyaType toValue(RString code) {

        for (JigyosyaType jigyosyaType : JigyosyaType.values()) {
            if (jigyosyaType.code.equals(code)) {
                return jigyosyaType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("事業者種別"));
    }
}
