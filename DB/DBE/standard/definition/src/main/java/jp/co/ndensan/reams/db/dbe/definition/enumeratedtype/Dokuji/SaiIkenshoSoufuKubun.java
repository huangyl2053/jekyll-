package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再意見書送付区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SaiIkenshoSoufuKubun {

    /**
     * コード:0 名称:未使用 略称:定義なし
     */
    未使用("0", "未使用"),
    /**
     * コード:1 名称:再送信 略称:定義なし
     */
    再送信("1", "再送信"),
    /**
     * コード:2 名称:再意見書 略称:定義なし
     */
    再意見書("2", "再意見書"),
    /**
     * コード:3 名称:再意見書送付済 略称:定義なし
     */
    再意見書送付済("3", "再意見書送付済");

    private final RString code;
    private final RString fullName;

    private SaiIkenshoSoufuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 再意見書送付区分のコードを返します。
     *
     * @return 再意見書送付区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 再意見書送付区分の名称を返します。
     *
     * @return 再意見書送付区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 再意見書送付区分のコードと一致する内容を探します。
     *
     * @param code 再意見書送付区分のコード
     * @return {@code code} に対応する再意見書送付区分
     */
    public static SaiIkenshoSoufuKubun toValue(RString code) {

        for (SaiIkenshoSoufuKubun saiIkenshoSoufuKubun : SaiIkenshoSoufuKubun.values()) {
            if (saiIkenshoSoufuKubun.code.equals(code)) {
                return saiIkenshoSoufuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("再意見書送付区分"));
    }
}
