package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再送付区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SaiSoufuKubun {

    /**
     * コード:01 名称:再送信 略称:定義なし
     */
    再送信("01", "再送信"),
    /**
     * コード:02 名称:再送信送付済 略称:定義なし
     */
    再送信送付済("02", "再送信送付済");

    private final RString code;
    private final RString fullName;

    private SaiSoufuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 再送付区分のコードを返します。
     *
     * @return 再送付区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 再送付区分の名称を返します。
     *
     * @return 再送付区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 再送付区分のコードと一致する内容を探します。
     *
     * @param code 再送付区分のコード
     * @return {@code code} に対応する再送付区分
     */
    public static SaiSoufuKubun toValue(RString code) {

        for (SaiSoufuKubun saiSoufuKubun : SaiSoufuKubun.values()) {
            if (saiSoufuKubun.code.equals(code)) {
                return saiSoufuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("再送付区分"));
    }
}
