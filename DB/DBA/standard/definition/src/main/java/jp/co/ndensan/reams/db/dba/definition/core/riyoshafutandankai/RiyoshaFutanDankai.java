package jp.co.ndensan.reams.db.dba.definition.core.riyoshafutandankai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担段階を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum RiyoshaFutanDankai {

    /**
     * コード:01 名称:第１段階 略称:定義なし
     */
    第１段階("01", "第１段階"),
    /**
     * コード:02 名称:第２段階 略称:定義なし
     */
    第２段階("02", "第２段階"),
    /**
     * コード:03 名称:第３段階 略称:定義なし
     */
    第３段階("03", "第３段階"),
    /**
     * コード:04 名称:第４段階 略称:定義なし
     */
    第４段階("04", "第４段階");

    private final RString code;
    private final RString fullName;

    private RiyoshaFutanDankai(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);

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
