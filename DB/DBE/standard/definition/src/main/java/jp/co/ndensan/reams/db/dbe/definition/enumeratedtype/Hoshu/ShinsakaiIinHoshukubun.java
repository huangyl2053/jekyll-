package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会委員報酬区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinsakaiIinHoshukubun {

    /**
     * コード:1 名称:審査報酬 略称:定義なし
     */
    審査報酬("1", "審査報酬"),
    /**
     * コード:2 名称:その他報酬 略称:定義なし
     */
    その他報酬("2", "その他報酬");

    private final RString code;
    private final RString fullName;

    private ShinsakaiIinHoshukubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 審査会委員報酬区分のコードを返します。
     *
     * @return 審査会委員報酬区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 審査会委員報酬区分の名称を返します。
     *
     * @return 審査会委員報酬区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 審査会委員報酬区分のコードと一致する内容を探します。
     *
     * @param code 審査会委員報酬区分のコード
     * @return {@code code} に対応する審査会委員報酬区分
     */
    public static ShinsakaiIinHoshukubun toValue(RString code) {

        for (ShinsakaiIinHoshukubun shinsakaiIinHoshukubun : ShinsakaiIinHoshukubun.values()) {
            if (shinsakaiIinHoshukubun.code.equals(code)) {
                return shinsakaiIinHoshukubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("審査会委員報酬区分"));
    }
}
