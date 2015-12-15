package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum NinteichosaTokusokuHoho {

    /**
     * コード:0 名称:督促状郵送 略称:定義なし
     */
    督促状郵送("0", "督促状郵送"),
    /**
     * コード:1 名称:督促状ＦＡＸ 略称:定義なし
     */
    督促状ＦＡＸ("1", "督促状ＦＡＸ"),
    /**
     * コード:2 名称:電話 略称:定義なし
     */
    電話("2", "電話"),
    /**
     * コード:3 名称:その他 略称:定義なし
     */
    その他("3", "その他");

    private final RString code;
    private final RString fullName;

    private NinteichosaTokusokuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査督促方法のコードを返します。
     *
     * @return 認定調査督促方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査督促方法の名称を返します。
     *
     * @return 認定調査督促方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査督促方法のコードと一致する内容を探します。
     *
     * @param code 認定調査督促方法のコード
     * @return {@code code} に対応する認定調査督促方法
     */
    public static NinteichosaTokusokuHoho toValue(RString code) {

        for (NinteichosaTokusokuHoho ninteichosaTokusokuHoho : NinteichosaTokusokuHoho.values()) {
            if (ninteichosaTokusokuHoho.code.equals(code)) {
                return ninteichosaTokusokuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査督促方法"));
    }
}
