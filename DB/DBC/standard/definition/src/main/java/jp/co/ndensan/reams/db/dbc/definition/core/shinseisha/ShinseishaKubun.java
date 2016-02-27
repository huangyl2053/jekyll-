package jp.co.ndensan.reams.db.dbc.definition.core.shinseisha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請者区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinseishaKubun {

    /**
     * コード:1 名称:本人 略称:定義なし
     */
    本人("1", "本人"),
    /**
     * コード:2 名称:代理人 略称:定義なし
     */
    代理人("2", "代理人"),
    /**
     * コード:3 名称:受領委任事業者 略称:定義なし
     */
    受領委任事業者("3", "受領委任事業者");

    private final RString code;
    private final RString fullName;

    private ShinseishaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 申請者区分のコードを返します。
     *
     * @return 申請者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請者区分の名称を返します。
     *
     * @return 申請者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請者区分のコードと一致する内容を探します。
     *
     * @param code 申請者区分のコード
     * @return {@code code} に対応する申請者区分
     */
    public static ShinseishaKubun toValue(RString code) {

        for (ShinseishaKubun shinseishaKubun : ShinseishaKubun.values()) {
            if (shinseishaKubun.code.equals(code)) {
                return shinseishaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請者区分"));
    }
}
