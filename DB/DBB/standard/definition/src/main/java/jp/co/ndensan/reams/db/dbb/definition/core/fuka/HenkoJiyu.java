package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 変更事由を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum HenkoJiyu {

    /**
     * コード:01 名称:氏名変更 略称:定義なし
     */
    氏名変更("01", "氏名変更"),
    /**
     * コード:02 名称:生年月日変更 略称:定義なし
     */
    生年月日変更("02", "生年月日変更"),
    /**
     * コード:03 名称:性別変更 略称:定義なし
     */
    性別変更("03", "性別変更"),
    /**
     * コード:04 名称:住所等変更 略称:定義なし
     */
    住所等変更("04", "住所等変更"),
    /**
     * コード:05 名称:行政区変更 略称:定義なし
     */
    行政区変更("05", "行政区変更"),
    /**
     * コード:06 名称:代納人変更 略称:定義なし
     */
    代納人変更("06", "代納人変更"),
    /**
     * コード:07 名称:連絡先変更 略称:定義なし
     */
    連絡先変更("07", "連絡先変更"),
    /**
     * コード:08 名称:口座情報変更 略称:定義なし
     */
    口座情報変更("08", "口座情報変更"),
    /**
     * コード:09 名称:資格変更 略称:定義なし
     */
    資格変更("09", "資格変更"),
    /**
     * コード:10 名称:老齢年金変更 略称:定義なし
     */
    老齢年金変更("10", "老齢年金変更"),
    /**
     * コード:11 名称:生活保護変更 略称:定義なし
     */
    生活保護変更("11", "生活保護変更"),
    /**
     * コード:12 名称:所得更正 略称:定義なし
     */
    所得更正("12", "所得更正"),
    /**
     * コード:13 名称:世帯員変更 略称:定義なし
     */
    世帯員変更("13", "世帯員変更");

    private final RString code;
    private final RString fullName;

    private HenkoJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 変更事由のコードを返します。
     *
     * @return 変更事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 変更事由の名称を返します。
     *
     * @return 変更事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 変更事由のコードと一致する内容を探します。
     *
     * @param code 変更事由のコード
     * @return {@code code} に対応する変更事由
     */
    public static HenkoJiyu toValue(RString code) {
        for (HenkoJiyu henkoJiyu : HenkoJiyu.values()) {
            if (henkoJiyu.code.equals(code)) {
                return henkoJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("変更事由"));
    }
}
