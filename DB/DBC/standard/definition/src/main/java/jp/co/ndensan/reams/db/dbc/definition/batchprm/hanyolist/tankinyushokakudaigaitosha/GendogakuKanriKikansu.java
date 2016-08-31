package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.tankinyushokakudaigaitosha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 限度額管理期間数を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum GendogakuKanriKikansu {

    /**
     * コード:1 名称:入力済みを含む 略称:定義なし
     */
    入力済みを含む("1", "入力済みを含む"),
    /**
     * コード:2 名称:入力済みを含まない 略称:定義なし
     */
    入力済みを含まない("2", "入力済みを含まない");

    private final RString code;
    private final RString fullName;

    private GendogakuKanriKikansu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 限度額管理期間数のコードを返します。
     *
     * @return 限度額管理期間数のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 限度額管理期間数の名称を返します。
     *
     * @return 限度額管理期間数の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 限度額管理期間数のコードと一致する内容を探します。
     *
     * @param code 限度額管理期間数のコード
     * @return {@code code} に対応する限度額管理期間数
     */
    public static GendogakuKanriKikansu toValue(RString code) {
        for (GendogakuKanriKikansu gendogakuKanriKikansu : GendogakuKanriKikansu.values()) {
            if (gendogakuKanriKikansu.code.equals(code)) {
                return gendogakuKanriKikansu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("限度額管理期間数"));
    }
}
