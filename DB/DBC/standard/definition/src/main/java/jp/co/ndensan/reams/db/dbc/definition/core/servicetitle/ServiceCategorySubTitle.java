package jp.co.ndensan.reams.db.dbc.definition.core.servicetitle;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サブタイトルを表す列挙型です。
 *
 * @author LDNS
 */
public enum ServiceCategorySubTitle {

    /**
     * コード:無し 名称:訪問通所 略称:定義なし
     */
    訪問通所("無し", "訪問通所"),
    /**
     * コード:無し 名称:短期入所 略称:定義なし
     */
    短期入所("無し", "短期入所"),
    /**
     * コード:無し 名称:地域密着 略称:定義なし
     */
    地域密着("無し", "地域密着"),
    /**
     * コード:無し 名称:サブタイトルなし 略称:定義なし
     */
    サブタイトルなし("無し", "サブタイトルなし");

    private final RString code;
    private final RString fullName;

    private ServiceCategorySubTitle(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * サブタイトルのコードを返します。
     *
     * @return サブタイトルのコード
     */
    public RString getコード() {
        return code;
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
     * サブタイトルのコードと一致する内容を探します。
     *
     * @param code サブタイトルのコード
     * @return {@code code} に対応するサブタイトル
     */
    public static ServiceCategorySubTitle toValue(RString code) {

        for (ServiceCategorySubTitle serviceCategorySubTitle : ServiceCategorySubTitle.values()) {
            if (serviceCategorySubTitle.code.equals(code)) {
                return serviceCategorySubTitle;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("サブタイトル"));
    }
}
