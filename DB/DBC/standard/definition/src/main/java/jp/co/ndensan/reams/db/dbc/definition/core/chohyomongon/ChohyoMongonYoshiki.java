package jp.co.ndensan.reams.db.dbc.definition.core.chohyomongon;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票文言様式を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum ChohyoMongonYoshiki {

    /**
     * コード:1 名称:フォント小 略称:定義なし
     */
    フォント小("1", "フォント小"),
    /**
     * コード:2 名称:フォント大 略称:定義なし
     */
    フォント大("2", "フォント大"),
    /**
     * コード:3 名称:フォント混在（上大・下小） 略称:定義なし
     */
    フォント混在_上大_下小("4", "フォント混在（上大・下小）"),
    /**
     * コード:4 名称:フォント混在（上小・下大） 略称:定義なし
     */
    フォント混在_上小_下大("3", "フォント混在（上小・下大）");

    private final RString code;
    private final RString fullName;

    private ChohyoMongonYoshiki(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 帳票文言様式のコードを返します。
     *
     * @return 帳票文言様式のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 帳票文言様式の名称を返します。
     *
     * @return 帳票文言様式の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 帳票文言様式のコードと一致する内容を探します。
     *
     * @param code 帳票文言様式のコード
     * @return {@code code} に対応する帳票文言様式
     */
    public static ChohyoMongonYoshiki toValue(RString code) {

        for (ChohyoMongonYoshiki chohyoMongonYoshiki : ChohyoMongonYoshiki.values()) {
            if (chohyoMongonYoshiki.code.equals(code)) {
                return chohyoMongonYoshiki;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("帳票文言様式のコード"));
    }
}
