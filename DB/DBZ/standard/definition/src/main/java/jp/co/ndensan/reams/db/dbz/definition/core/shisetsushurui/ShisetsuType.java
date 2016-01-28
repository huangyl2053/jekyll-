package jp.co.ndensan.reams.db.dbz.definition.core.shisetsushurui;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設種類を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShisetsuType {

    /**
     * コード:11 名称:介護保険施設 略称:定義なし
     */
    介護保険施設("11", "介護保険施設"),
    /**
     * コード:12 名称:住所地特例対象施設 略称:定義なし
     */
    住所地特例対象施設("12", "住所地特例対象施設"),
    /**
     * コード:21 名称:適用除外施設 略称:定義なし
     */
    適用除外施設("21", "適用除外施設");

    private final RString code;
    private final RString fullName;

    private ShisetsuType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設種類のコードを返します。
     *
     * @return 施設種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設種類の名称を返します。
     *
     * @return 施設種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設種類のコードと一致する内容を探します。
     *
     * @param code 施設種類のコード
     * @return {@code code} に対応する施設種類
     */
    public static ShisetsuType toValue(RString code) {

        for (ShisetsuType shisetsuType : ShisetsuType.values()) {
            if (shisetsuType.code.equals(code)) {
                return shisetsuType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設種類"));
    }
}
