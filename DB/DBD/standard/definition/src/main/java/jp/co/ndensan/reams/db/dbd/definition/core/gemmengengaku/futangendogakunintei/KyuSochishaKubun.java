package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 旧措置者区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum KyuSochishaKubun {

    /**
     * コード: 名称:非該当 略称:""
     */
    非該当("", "非該当", ""),
    /**
     * コード:1 名称:旧措置 略称:旧措置者
     */
    旧措置者("1", "旧措置者", "旧措置者"),
    /**
     * コード:2 名称:負担段階 略称:定義なし
     */
    旧措置者実質的負担軽減者("2", "旧措置者実質的負担軽減者", "負担軽減者");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KyuSochishaKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 旧措置者区分のコードを返します。
     *
     * @return 旧措置者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 旧措置者区分の名称を返します。
     *
     * @return 旧措置者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 旧措置者区分の略称を返します。
     *
     * @return 旧措置者区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 旧措置者区分のコードと一致する内容を探します。
     *
     * @param code 旧措置者区分のコード
     * @return {@code code} に対応する旧措置者区分
     */
    public static KyuSochishaKubun toValue(RString code) {

        for (KyuSochishaKubun kyuSochishaKubun : KyuSochishaKubun.values()) {
            if (kyuSochishaKubun.code.equals(code)) {
                return kyuSochishaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("旧措置者区分"));
    }
}
