package jp.co.ndensan.reams.db.dbc.definition.core.servicetitle;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * タイトルを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum ServiceCategoryTitle {

    /**
     * コード:無し 名称:指定居宅サービス 略称:定義なし
     */
    指定居宅サービス("指定居宅サービス"),
    /**
     * コード:無し 名称:居宅介護 略称:定義なし
     */
    居宅介護("居宅介護"),
    /**
     * コード:無し 名称:指定施設サービス等 略称:定義なし
     */
    指定施設サービス等("指定施設サービス等");

    private final RString fullName;

    private ServiceCategoryTitle(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * タイトルの名称を返します。
     *
     * @return タイトルの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * タイトルと一致する内容を探します。
     *
     * @param fullname タイトル
     * @return {fullname} に対応するタイトル
     */
    public static ServiceCategoryTitle toValue(RString fullname) {

        for (ServiceCategoryTitle serviceCategoryTitle : ServiceCategoryTitle.values()) {
            if (serviceCategoryTitle.get名称().equals(fullname)) {
                return serviceCategoryTitle;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("タイトル"));
    }
}
