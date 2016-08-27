package jp.co.ndensan.reams.db.dbc.definition.core.futanwariai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合資格区分を表す列挙型です。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public enum FutanWariaiShikakuKubun {

    /**
     * コード:1 名称:１号 略称:無
     */
    一号("01", "１号"),
    /**
     * コード:2 名称:２号 略称:無
     */
    二号("02", "２号"),
    /**
     * コード:3 名称:１号（予定） 略称:無
     */
    一号_予定("03", "１号（予定）");

    private final RString code;
    private final RString fullName;

    private FutanWariaiShikakuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 負担割合資格区分のコードを返します。
     *
     * @return 負担割合資格区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 負担割合資格区分の名称を返します。
     *
     * @return 負担割合資格区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 負担割合資格区分のコードと一致する内容を探します。
     *
     * @param code 負担割合資格区分のコード
     * @return {@code code} に対応する負担割合資格区分
     */
    public static FutanWariaiShikakuKubun toValue(RString code) {
        for (FutanWariaiShikakuKubun futanWariai : FutanWariaiShikakuKubun.values()) {
            if (futanWariai.code.equals(code)) {
                return futanWariai;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("負担割合資格区分"));
    }
}
