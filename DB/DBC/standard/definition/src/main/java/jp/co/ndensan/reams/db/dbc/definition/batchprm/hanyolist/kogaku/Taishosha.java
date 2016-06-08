package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum Taishosha {

    /**
     * コード:0 名称:すべて 略称:定義なし
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:抽出あり 略称:定義なし
     */
    抽出あり("1", "抽出あり"),
    /**
     * コード:2 名称:抽出なし 略称:定義なし
     */
    抽出なし("2", "抽出なし");

    private final RString code;
    private final RString fullName;

    private Taishosha(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 対象者のコードを返します。
     *
     * @return 対象者のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 対象者の名称を返します。
     *
     * @return 対象者の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 対象者のコードと一致する内容を探します。
     *
     * @param code 対象者のコード
     * @return {@code code} に対応する対象者
     */
    public static Taishosha toValue(RString code) {
        for (Taishosha taishosha : Taishosha.values()) {
            if (taishosha.code.equals(code)) {
                return taishosha;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対象者"));
    }
}
