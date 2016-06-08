package jp.co.ndensan.reams.db.dbc.definition.core.servicetitle;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サブタイトルを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum ServiceCategorySubTitle {

    /**
     * コード:無し 名称:訪問通所 略称:定義なし
     */
    訪問通所("訪問通所"),
    /**
     * コード:無し 名称:短期入所 略称:定義なし
     */
    短期入所("短期入所"),
    /**
     * コード:無し 名称:地域密着 略称:定義なし
     */
    地域密着("地域密着"),
    /**
     * コード:無し 名称:サブタイトルなし 略称:定義なし
     */
    サブタイトルなし("サブタイトルなし");

    private final RString fullName;

    private ServiceCategorySubTitle(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * サブタイトルの名称を返します。
     *
     * @return サブタイトルの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * サブタイトルと一致する内容を探します。
     *
     * @param fullname サブタイトル
     * @return {fullname} に対応するサブタイトル
     */
    public static ServiceCategorySubTitle toValue(RString fullname) {

        for (ServiceCategorySubTitle serviceCategorySubTitle : ServiceCategorySubTitle.values()) {
            if (serviceCategorySubTitle.get名称().equals(fullname)) {
                return serviceCategorySubTitle;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サブタイトル"));
    }
}
