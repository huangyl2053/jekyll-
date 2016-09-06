package jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 表番号を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 wangchao
 */
public enum HyoNo {

    /**
     * コード:01 名称:現物_一般状況 略称:定義なし
     */
    現物_一般状況("01", "現物_一般状況"),
    /**
     * コード:02 名称:現物_保険給付決定状況 略称:定義なし
     */
    現物_保険給付決定状況("02", "現物_保険給付決定状況"),
    /**
     * コード:03 名称:償還_審査年月_一般状況 略称:定義なし
     */
    償還_審査年月_一般状況("03", "償還_審査年月_一般状況"),
    /**
     * コード:04 名称:償還_審査年月_保険給付決定状況 略称:定義なし
     */
    償還_審査年月_保険給付決定状況("04", "償還_審査年月_保険給付決定状況"),
    /**
     * コード:05 名称:償還_決定年月_一般状況 略称:定義なし
     */
    償還_決定年月_一般状況("05", "償還_決定年月_一般状況"),
    /**
     * コード:06 名称:償還_決定年月_保険給付決定状況 略称:定義なし
     */
    償還_決定年月_保険給付決定状況("06", "償還_決定年月_保険給付決定状況"),
    /**
     * コード:07 名称:高額合算_保険給付決定状況 略称:定義なし
     */
    高額合算_保険給付決定状況("07", "高額合算_保険給付決定状況"),
    /**
     * コード:11 名称:現物_一般状況（旧市町村） 略称:定義なし
     */
    現物_一般状況_旧市町村("11", "現物_一般状況（旧市町村）"),
    /**
     * コード:15 名称:償還_決定年月_一般状況（旧市町村） 略称:定義なし
     */
    償還_決定年月_一般状況_旧市町村("15", "償還_決定年月_一般状況（旧市町村）"),
    /**
     * コード:16 名称:高額サービス費_保険給付決定状況（旧市町村） 略称:定義なし
     */
    高額サービス費_保険給付決定状況_旧市町村("16", "高額サービス費_保険給付決定状況（旧市町村）"),
    /**
     * コード:17 名称:高額合算_保険給付決定状況（旧市町村） 略称:定義なし
     */
    高額合算_保険給付決定状況_旧市町村("17", "高額合算_保険給付決定状況（旧市町村）");

    private final RString code;
    private final RString fullName;

    private HyoNo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 表番号のコードを返します。
     *
     * @return 表番号のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 表番号の名称を返します。
     *
     * @return 表番号の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 表番号のコードと一致する内容を探します。
     *
     * @param code 表番号のコード
     * @return {@code code} に対応する表番号
     */
    public static HyoNo toValue(RString code) {
        for (HyoNo hyoNo : HyoNo.values()) {
            if (hyoNo.code.equals(code)) {
                return hyoNo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("表番号"));
    }
}
