package jp.co.ndensan.reams.db.dbc.definition.core.kyufukeiyaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定福祉用具販売契約の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum TokuteiFukushiYoguHanbaiKeiyakuKubun {

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

    private TokuteiFukushiYoguHanbaiKeiyakuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特定福祉用具販売契約の有無のコードを返します。
     *
     * @return 特定福祉用具販売契約の有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定福祉用具販売契約の有無の名称を返します。
     *
     * @return 特定福祉用具販売契約の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定福祉用具販売契約の有無のコードと一致する内容を探します。
     *
     * @param code 特定福祉用具販売契約の有無のコード
     * @return {@code code} に対応する特定福祉用具販売契約の有無
     */
    public static TokuteiFukushiYoguHanbaiKeiyakuKubun toValue(RString code) {

        for (TokuteiFukushiYoguHanbaiKeiyakuKubun value : TokuteiFukushiYoguHanbaiKeiyakuKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特定福祉用具販売契約の有無"));
    }
}
