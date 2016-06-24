package jp.co.ndensan.reams.db.dbc.definition.core.servicecategory;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績集計の合計対象を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum ServiceCategory {

    /**
     * コード:無し 名称:居宅サービス 略称:定義なし
     */
    居宅サービス("居宅サービス"),
    /**
     * コード:無し 名称:施設サービス 略称:定義なし
     */
    施設サービス("施設サービス"),
    /**
     * コード:無し 名称:地域密着型サービス 略称:定義なし
     */
    地域密着型サービス("地域密着型サービス"),
    /**
     * コード:無し 名称:合計対象外 略称:定義なし
     */
    合計対象外("合計対象外");

    private final RString fullName;

    private ServiceCategory(String fullname) {
        this.fullName = new RString(fullname);
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
     * @param fullname 給付実績集計の合計対象
     * @return { fullname} に対応する給付実績集計の合計対象
     */
    public static ServiceCategory toValue(RString fullname) {

        for (ServiceCategory serviceCategory : ServiceCategory.values()) {
            if (serviceCategory.get名称().equals(fullname)) {
                return serviceCategory;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("給付実績集計の合計対象"));
    }
}
