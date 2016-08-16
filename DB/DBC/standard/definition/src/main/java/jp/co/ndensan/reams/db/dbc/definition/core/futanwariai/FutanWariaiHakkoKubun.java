package jp.co.ndensan.reams.db.dbc.definition.core.futanwariai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合発行区分を表す列挙型です。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public enum FutanWariaiHakkoKubun {

    /**
     * コード:1 名称:未発行 略称:無
     */
    未発行("0", "未発行"),
    /**
     * コード:2 名称:異動分判定 略称:無
     */
    一括発行("1", "一括発行で発行済み"),
    /**
     * コード:3 名称:過年度分判定 略称:無
     */
    単票発行("2", "単票発行で発行済み");

    private final RString code;
    private final RString fullName;

    private FutanWariaiHakkoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 負担割合発行区分のコードを返します。
     *
     * @return 負担割合発行区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 負担割合発行区分の名称を返します。
     *
     * @return 負担割合発行区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 負担割合発行区分のコードと一致する内容を探します。
     *
     * @param code 高額介護サービス費支給区分のコード
     * @return {@code code} に対応する負担割合発行区分
     */
    public static FutanWariaiHakkoKubun toValue(RString code) {
        for (FutanWariaiHakkoKubun futanWariai : FutanWariaiHakkoKubun.values()) {
            if (futanWariai.code.equals(code)) {
                return futanWariai;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("負担割合発行区分"));
    }
}
