package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishukeiyaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修契約を表す列挙型です。
 *
 * @author LDNS
 */
public enum JutakuKaishuKeiyakuKubun {

    /**
     * コード:true 名称:契約有り 略称:定義なし
     */
    契約有り(true, "契約有り"),
    /**
     * コード:false 名称:契約無し 略称:定義なし
     */
    契約無し(false, "契約無し");

    private final boolean code;
    private final RString fullName;

    private JutakuKaishuKeiyakuKubun(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 住宅改修契約のコードを返します。
     *
     * @return 住宅改修契約のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 住宅改修契約の名称を返します。
     *
     * @return 住宅改修契約の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 住宅改修契約のコードと一致する内容を探します。
     *
     * @param code 住宅改修契約のコード
     * @return {@code code} に対応する住宅改修契約
     */
    public static JutakuKaishuKeiyakuKubun toValue(boolean code) {
        for (JutakuKaishuKeiyakuKubun jutakuKaishuKeiyakuKubun : JutakuKaishuKeiyakuKubun.values()) {
            if (jutakuKaishuKeiyakuKubun.code == code) {
                return jutakuKaishuKeiyakuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("住宅改修契約"));
    }
}
