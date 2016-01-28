package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過年度歳出管理区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KanendoSaishutsuKanriKubun {

    /**
     * コード:0 名称:管理しない 略称:定義なし
     */
    管理しない("0", "管理しない"),
    /**
     * コード:1 名称:管理する 略称:定義なし
     */
    管理する("1", "管理する");

    private final RString code;
    private final RString fullName;

    private KanendoSaishutsuKanriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 過年度歳出管理区分のコードを返します。
     *
     * @return 過年度歳出管理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 過年度歳出管理区分の名称を返します。
     *
     * @return 過年度歳出管理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 過年度歳出管理区分のコードと一致する内容を探します。
     *
     * @param code 過年度歳出管理区分のコード
     * @return {@code code} に対応する過年度歳出管理区分
     */
    public static KanendoSaishutsuKanriKubun toValue(RString code) {
        for (KanendoSaishutsuKanriKubun kanendoSaishutsuKanriKubun : KanendoSaishutsuKanriKubun.values()) {
            if (kanendoSaishutsuKanriKubun.code.equals(code)) {
                return kanendoSaishutsuKanriKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過年度歳出管理区分"));
    }
}
