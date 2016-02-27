package jp.co.ndensan.reams.db.dbc.definition.core.servicecategory;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績集計の合計対象を表す列挙型です。
 *
 * @author LDNS
 */
public enum ServiceCategory {

    /**
     * コード:無し 名称:居宅サービス 略称:定義なし
     */
    居宅サービス("無し", "居宅サービス"),
    /**
     * コード:無し 名称:施設サービス 略称:定義なし
     */
    施設サービス("無し", "施設サービス"),
    /**
     * コード:無し 名称:地域密着型サービス 略称:定義なし
     */
    地域密着型サービス("無し", "地域密着型サービス"),
    /**
     * コード:無し 名称:合計対象外 略称:定義なし
     */
    合計対象外("無し", "合計対象外");

    private final RString code;
    private final RString fullName;

    private ServiceCategory(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 給付実績集計の合計対象のコードを返します。
     *
     * @return 給付実績集計の合計対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付実績集計の合計対象の名称を返します。
     *
     * @return 給付実績集計の合計対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付実績集計の合計対象のコードと一致する内容を探します。
     *
     * @param code 給付実績集計の合計対象のコード
     * @return {@code code} に対応する給付実績集計の合計対象
     */
    public static ServiceCategory toValue(RString code) {

        for (ServiceCategory serviceCategory : ServiceCategory.values()) {
            if (serviceCategory.code.equals(code)) {
                return serviceCategory;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("給付実績集計の合計対象"));
    }
}
