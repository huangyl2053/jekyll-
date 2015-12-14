package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過年度文言を表す列挙型です。
 *
 * @author LDNS
 */
public enum KanendoMongon {

    /**
     * コード:1 名称:随時 略称:定義なし
     */
    随時("1", "随時"),
    /**
     * コード:2 名称:スペース 略称:定義なし
     */
    スペース("2", "スペース");

    private final RString code;
    private final RString fullName;

    private KanendoMongon(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 過年度文言のコードを返します。
     *
     * @return 過年度文言のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 過年度文言の名称を返します。
     *
     * @return 過年度文言の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 過年度文言のコードと一致する内容を探します。
     *
     * @param code 過年度文言のコード
     * @return {@code code} に対応する過年度文言
     */
    public static KanendoMongon toValue(RString code) {
        for (KanendoMongon kanendoMongon : KanendoMongon.values()) {
            if (kanendoMongon.code.equals(code)) {
                return kanendoMongon;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過年度文言"));
    }
}
