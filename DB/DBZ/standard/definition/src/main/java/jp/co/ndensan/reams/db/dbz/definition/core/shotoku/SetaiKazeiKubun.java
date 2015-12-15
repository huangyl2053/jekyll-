package jp.co.ndensan.reams.db.dbz.definition.core.shotoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯課税区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SetaiKazeiKubun {

    /**
     * コード:1 名称:課税 略称:定義なし
     */
    課税("1", "課税"),
    /**
     * コード:2 名称:非課税 略称:定義なし
     */
    非課税("2", "非課税");

    private final RString code;
    private final RString fullName;

    private SetaiKazeiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 世帯課税区分のコードを返します。
     *
     * @return 世帯課税区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 世帯課税区分の名称を返します。
     *
     * @return 世帯課税区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 世帯課税区分のコードと一致する内容を探します。
     *
     * @param code 世帯課税区分のコード
     * @return {@code code} に対応する世帯課税区分
     */
    public static SetaiKazeiKubun toValue(RString code) {

        for (SetaiKazeiKubun setaiKazeiKubun : SetaiKazeiKubun.values()) {
            if (setaiKazeiKubun.code.equals(code)) {
                return setaiKazeiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("世帯課税区分"));
    }
}
