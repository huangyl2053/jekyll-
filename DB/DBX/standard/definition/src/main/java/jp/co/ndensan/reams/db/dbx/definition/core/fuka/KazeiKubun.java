package jp.co.ndensan.reams.db.dbx.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 課税区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum KazeiKubun {

    /**
     * コード:1 名称:課税 略称:定義なし
     */
    課税("1", "課税"),
    /**
     * コード:2 名称:非課税 略称:定義なし
     */
    非課税("2", "非課税"),
    /**
     * コード:3 名称:未申告 略称:定義なし
     */
    未申告("3", "未申告"),
    /**
     * コード:4 名称:所得調査中 略称:定義なし
     */
    所得調査中("4", "所得調査中"),
    /**
     * コード:5 名称:課税取消 略称:定義なし
     */
    課税取消("5", "課税取消");

    private final RString code;
    private final RString fullName;

    private KazeiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 課税区分のコードを返します。
     *
     * @return 課税区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 課税区分の名称を返します。
     *
     * @return 課税区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 課税区分のコードと一致する内容を探します。
     *
     * @param code 課税区分のコード
     * @return {@code code} に対応する課税区分
     */
    public static KazeiKubun toValue(RString code) {

        for (KazeiKubun kazeiKubun : KazeiKubun.values()) {
            if (kazeiKubun.code.equals(code)) {
                return kazeiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("課税区分"));
    }
}
