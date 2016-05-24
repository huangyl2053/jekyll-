package jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者区分を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum JukyushaKubun {

    /**
     * コード:1 名称:被保険者 略称:定義なし
     */
    被保険者("1", "被保険者"),
    /**
     * コード:2 名称:受給者 略称:定義なし
     */
    受給者("2", "受給者");

    private final RString code;
    private final RString fullName;

    private JukyushaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者区分のコードを返します。
     *
     * @return 受給者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者区分の名称を返します。
     *
     * @return 受給者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者区分のコードと一致する内容を探します。
     *
     * @param code 受給者区分のコード
     * @return {@code code} に対応する受給者区分
     */
    public static JukyushaKubun toValue(RString code) {
        for (JukyushaKubun jukyushaKubun : JukyushaKubun.values()) {
            if (jukyushaKubun.code.equals(code)) {
                return jukyushaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("受給者区分"));
    }
}
