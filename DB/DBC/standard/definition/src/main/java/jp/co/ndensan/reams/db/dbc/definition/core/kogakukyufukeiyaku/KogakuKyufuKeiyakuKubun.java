package jp.co.ndensan.reams.db.dbc.definition.core.kogakukyufukeiyaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額給付契約を表す列挙型です。
 *
 * @author LDNS
 */
public enum KogakuKyufuKeiyakuKubun {

    /**
     * コード:true 名称:契約有り 略称:定義なし
     */
    契約有り("true", "契約有り"),
    /**
     * コード:false 名称:契約無し 略称:定義なし
     */
    契約無し("false", "契約無し");

    private final RString code;
    private final RString fullName;

    private KogakuKyufuKeiyakuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 高額給付契約のコードを返します。
     *
     * @return 高額給付契約のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額給付契約の名称を返します。
     *
     * @return 高額給付契約の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額給付契約のコードと一致する内容を探します。
     *
     * @param code 高額給付契約のコード
     * @return {@code code} に対応する高額給付契約
     */
    public static KogakuKyufuKeiyakuKubun toValue(RString code) {

        for (KogakuKyufuKeiyakuKubun kogakuKyufuKeiyakuKubun : KogakuKyufuKeiyakuKubun.values()) {
            if (kogakuKyufuKeiyakuKubun.code.equals(code)) {
                return kogakuKyufuKeiyakuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額給付契約"));
    }
}
