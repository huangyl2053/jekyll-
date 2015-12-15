package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Dokuji;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再イメージ送付区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SaiImageSoufuKubun {

    /**
     * コード:0 名称:未使用 略称:定義なし
     */
    未使用("0", "未使用"),
    /**
     * コード:1 名称:再送信 略称:定義なし
     */
    再送信("1", "再送信"),
    /**
     * コード:2 名称:再イメージ 略称:定義なし
     */
    再イメージ("2", "再イメージ"),
    /**
     * コード:3 名称:再イメージ送付済 略称:定義なし
     */
    再イメージ送付済("3", "再イメージ送付済");

    private final RString code;
    private final RString fullName;

    private SaiImageSoufuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 再イメージ送付区分のコードを返します。
     *
     * @return 再イメージ送付区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 再イメージ送付区分の名称を返します。
     *
     * @return 再イメージ送付区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 再イメージ送付区分のコードと一致する内容を探します。
     *
     * @param code 再イメージ送付区分のコード
     * @return {@code code} に対応する再イメージ送付区分
     */
    public static SaiImageSoufuKubun toValue(RString code) {

        for (SaiImageSoufuKubun saiImageSoufuKubun : SaiImageSoufuKubun.values()) {
            if (saiImageSoufuKubun.code.equals(code)) {
                return saiImageSoufuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("再イメージ送付区分"));
    }
}
