package jp.co.ndensan.reams.db.dbb.definition.core.kanendo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過年度月処理区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KanendoTsukiShoriKubun {

    /**
     * コード:6 名称:随時 略称:定義なし
     */
    随時("6", "随時");

    private final RString code;
    private final RString fullName;

    private KanendoTsukiShoriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 過年度月処理区分のコードを返します。
     *
     * @return 過年度月処理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 過年度月処理区分の名称を返します。
     *
     * @return 過年度月処理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 過年度月処理区分のコードと一致する内容を探します。
     *
     * @param code 過年度月処理区分のコード
     * @return {@code code} に対応する過年度月処理区分
     */
    public static KanendoTsukiShoriKubun toValue(RString code) {
        for (KanendoTsukiShoriKubun kanendoTsukiShoriKubun : KanendoTsukiShoriKubun.values()) {
            if (kanendoTsukiShoriKubun.code.equals(code)) {
                return kanendoTsukiShoriKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過年度月処理区分"));
    }
}
