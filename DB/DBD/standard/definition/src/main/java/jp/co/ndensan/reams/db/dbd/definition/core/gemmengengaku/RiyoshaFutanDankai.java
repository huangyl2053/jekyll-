package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担段階を表す列挙型です。
 *
 * @author LDNS
 */
public enum RiyoshaFutanDankai {

    /**
     * コード:1 名称:第一段階 略称:第一段階
     */
    第一段階("1", "第一段階", "第一段階"),
    /**
     * コード:2 名称:第二段階 略称:第二段階
     */
    第二段階("2", "第二段階", "第二段階"),
    /**
     * コード:3 名称:第三段階 略称:第三段階
     */
    第三段階("3", "第三段階", "第三段階"),
    /**
     * コード:4 名称:課税層第三段階 略称:課税層第三段階
     */
    課税層第三段階("4", "課税層第三段階", "課税層第三段階"),
    /**
     * コード:5 名称:第四段階 略称:第四段階
     */
    第四段階("5", "第四段階", "第四段階");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private RiyoshaFutanDankai(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 利用者負担段階のコードを返します。
     *
     * @return 利用者負担段階のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用者負担段階の名称を返します。
     *
     * @return 利用者負担段階の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用者負担段階の略称を返します。
     *
     * @return 利用者負担段階の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 利用者負担段階のコードと一致する内容を探します。
     *
     * @param code 利用者負担段階のコード
     * @return {@code code} に対応する利用者負担段階
     */
    public static RiyoshaFutanDankai toValue(RString code) {
        for (RiyoshaFutanDankai riyoshaFutanDankai : RiyoshaFutanDankai.values()) {
            if (riyoshaFutanDankai.code.equals(code)) {
                return riyoshaFutanDankai;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("利用者負担段階"));
    }
}
