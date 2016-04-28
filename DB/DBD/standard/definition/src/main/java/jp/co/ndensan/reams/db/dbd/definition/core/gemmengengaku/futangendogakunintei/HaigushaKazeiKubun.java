package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 配偶者課税区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 huangh
 */
public enum HaigushaKazeiKubun {

    /**
     * コード:0 名称:空白 略称:空白
     */
    空白("", "", ""),
    /**
     * コード:1 名称:課税 略称:課税
     */
    課税("1", "課税", "課税"),
    /**
     * コード:2 名称:非課税 略称:非課税
     */
    非課税("2", "非課税", "非課税");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private HaigushaKazeiKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 配偶者課税区分のコードを返します。
     *
     * @return 配偶者課税区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 配偶者課税区分の名称を返します。
     *
     * @return 配偶者課税区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 配偶者課税区分の略称を返します。
     *
     * @return 配偶者課税区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 配偶者課税区分のコードと一致する内容を探します。
     *
     * @param code 配偶者課税区分のコード
     * @return {@code code} に対応する配偶者課税区分
     */
    public static HaigushaKazeiKubun toValue(RString code) {
        for (HaigushaKazeiKubun haigushaKazeiKubun : HaigushaKazeiKubun.values()) {
            if (haigushaKazeiKubun.code.equals(code)) {
                return haigushaKazeiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("配偶者課税区分"));
    }
}
