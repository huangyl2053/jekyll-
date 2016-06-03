package jp.co.ndensan.reams.db.dbc.definition.core.servicetitle;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * タイトルを表す列挙型です。
 *
 * @author LDNS
 */
public enum ServiceCategoryTitle {

    /**
     * コード:無し 名称:指定居宅サービス 略称:定義なし
     */
    指定居宅サービス("無し", "指定居宅サービス"),
    /**
     * コード:無し 名称:居宅介護 略称:定義なし
     */
    居宅介護("無し", "居宅介護"),
    /**
     * コード:無し 名称:指定施設サービス等 略称:定義なし
     */
    指定施設サービス等("無し", "指定施設サービス等");

    private final RString code;
    private final RString fullName;

    private ServiceCategoryTitle(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * タイトルのコードを返します。
     *
     * @return タイトルのコード
     */
    public RString getコード() {
        return code;
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
     * タイトルのコードと一致する内容を探します。
     *
     * @param code タイトルのコード
     * @return {@code code} に対応するタイトル
     */
    public static ServiceCategoryTitle toValue(RString code) {

        for (ServiceCategoryTitle serviceCategoryTitle : ServiceCategoryTitle.values()) {
            if (serviceCategoryTitle.code.equals(code)) {
                return serviceCategoryTitle;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("タイトル"));
    }
}
