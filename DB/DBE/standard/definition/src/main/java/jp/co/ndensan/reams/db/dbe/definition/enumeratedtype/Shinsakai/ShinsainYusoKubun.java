package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査員郵送区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinsainYusoKubun {

    /**
     * コード:1 名称:自宅 略称:定義なし
     */
    自宅("1", "自宅"),
    /**
     * コード:2 名称:所属機関 略称:定義なし
     */
    所属機関("2", "所属機関");

    private final RString code;
    private final RString fullName;

    private ShinsainYusoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 審査員郵送区分のコードを返します。
     *
     * @return 審査員郵送区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 審査員郵送区分の名称を返します。
     *
     * @return 審査員郵送区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 審査員郵送区分のコードと一致する内容を探します。
     *
     * @param code 審査員郵送区分のコード
     * @return {@code code} に対応する審査員郵送区分
     */
    public static ShinsainYusoKubun toValue(RString code) {

        for (ShinsainYusoKubun shinsainYusoKubun : ShinsainYusoKubun.values()) {
            if (shinsainYusoKubun.code.equals(code)) {
                return shinsainYusoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("審査員郵送区分"));
    }
}
