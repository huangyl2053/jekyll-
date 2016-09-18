package jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum ShikakuKubun {
//TODO DBAから遷移か

    /**
     * コード:1 名称:_1号被保険者 略称:１号
     */
    _１号("1", "１号被保険者", "１号"),
    /**
     * コード:2 名称:_2号被保険者 略称:２号
     */
    _２号("2", "２号被保険者", "２号"),
    /**
     * コード:3 名称:１号被保険者（外国人） 略称:１号外
     */
    _１号外("3", "１号被保険者（外国人）", "１号外"),
    /**
     * コード:4 名称:２号被保険者（外国人） 略称:２号外
     */
    _２号外("4", "２号被保険者（外国人）", "２号外");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ShikakuKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 資格区分のコードを返します。
     *
     * @return 資格区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格区分の名称を返します。
     *
     * @return 資格区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格区分の略称を返します。
     *
     * @return 資格区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 資格区分のコードと一致する内容を探します。
     *
     * @param code 資格区分のコード
     * @return {@code code} に対応する資格区分
     */
    public static ShikakuKubun toValue(RString code) {
        for (ShikakuKubun shikakuKubun : ShikakuKubun.values()) {
            if (shikakuKubun.code.equals(code)) {
                return shikakuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格区分"));
    }
}
