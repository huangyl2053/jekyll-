package jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請届出代行区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinseiTodokedeDaikoKubun {

    /**
     * コード:1 名称:本人 略称:定義なし
     */
    本人("1", "本人"),
    /**
     * コード:2 名称:家族 略称:定義なし
     */
    家族("2", "家族"),
    /**
     * コード:3 名称:委任 略称:定義なし
     */
    委任("3", "委任"),
    /**
     * コード:4 名称:代行 略称:定義なし
     */
    代行("4", "代行"),
    /**
     * コード:9 名称:その他 略称:定義なし
     */
    その他("9", "その他");

    private final RString code;
    private final RString fullName;

    private ShinseiTodokedeDaikoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 申請届出代行区分のコードを返します。
     *
     * @return 申請届出代行区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請届出代行区分の名称を返します。
     *
     * @return 申請届出代行区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請届出代行区分のコードと一致する内容を探します。
     *
     * @param code 申請届出代行区分のコード
     * @return {@code code} に対応する申請届出代行区分
     */
    public static ShinseiTodokedeDaikoKubun toValue(RString code) {
        for (ShinseiTodokedeDaikoKubun shinseiTodokedeDaikoKubun : ShinseiTodokedeDaikoKubun.values()) {
            if (shinseiTodokedeDaikoKubun.code.equals(code)) {
                return shinseiTodokedeDaikoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請届出代行区分"));
    }
}
