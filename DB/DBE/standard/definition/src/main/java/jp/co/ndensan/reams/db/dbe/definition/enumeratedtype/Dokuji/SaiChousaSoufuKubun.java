package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再調査送付区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SaiChousaSoufuKubun {

    /**
     * コード:0 名称:未使用 略称:定義なし
     */
    未使用("0", "未使用"),
    /**
     * コード:1 名称:再送信 略称:定義なし
     */
    再送信("1", "再送信"),
    /**
     * コード:2 名称:再調査 略称:定義なし
     */
    再調査("2", "再調査"),
    /**
     * コード:3 名称:再調査送付済 略称:定義なし
     */
    再調査送付済("3", "再調査送付済");

    private final RString code;
    private final RString fullName;

    private SaiChousaSoufuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 再調査送付区分のコードを返します。
     *
     * @return 再調査送付区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 再調査送付区分の名称を返します。
     *
     * @return 再調査送付区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 再調査送付区分のコードと一致する内容を探します。
     *
     * @param code 再調査送付区分のコード
     * @return {@code code} に対応する再調査送付区分
     */
    public static SaiChousaSoufuKubun toValue(RString code) {

        for (SaiChousaSoufuKubun saiChousaSoufuKubun : SaiChousaSoufuKubun.values()) {
            if (saiChousaSoufuKubun.code.equals(code)) {
                return saiChousaSoufuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("再調査送付区分"));
    }
}
