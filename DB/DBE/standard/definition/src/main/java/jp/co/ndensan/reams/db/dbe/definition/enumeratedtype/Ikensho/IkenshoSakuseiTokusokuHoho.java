package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書作成督促方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum IkenshoSakuseiTokusokuHoho {

    /**
     * コード:1 名称:督促状郵送 略称:定義なし
     */
    督促状郵送("1", "督促状郵送"),
    /**
     * コード:2 名称:督促状ＦＡＸ 略称:定義なし
     */
    督促状ＦＡＸ("2", "督促状ＦＡＸ"),
    /**
     * コード:3 名称:電話 略称:定義なし
     */
    電話("3", "電話"),
    /**
     * コード:4 名称:その他 略称:定義なし
     */
    その他("4", "その他");

    private final RString code;
    private final RString fullName;

    private IkenshoSakuseiTokusokuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書作成督促方法のコードを返します。
     *
     * @return 意見書作成督促方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書作成督促方法の名称を返します。
     *
     * @return 意見書作成督促方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書作成督促方法のコードと一致する内容を探します。
     *
     * @param code 意見書作成督促方法のコード
     * @return {@code code} に対応する意見書作成督促方法
     */
    public static IkenshoSakuseiTokusokuHoho toValue(RString code) {

        for (IkenshoSakuseiTokusokuHoho ikenshoSakuseiTokusokuHoho : IkenshoSakuseiTokusokuHoho.values()) {
            if (ikenshoSakuseiTokusokuHoho.code.equals(code)) {
                return ikenshoSakuseiTokusokuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書作成督促方法"));
    }
}
