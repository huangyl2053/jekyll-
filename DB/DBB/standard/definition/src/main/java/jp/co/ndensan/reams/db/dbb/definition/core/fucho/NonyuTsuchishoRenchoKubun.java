package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納入通知書連帳区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum NonyuTsuchishoRenchoKubun {

    /**
     * コード:0 名称:カット紙 略称:定義なし
     */
    カット紙("0", "カット紙"),
    /**
     * コード:1 名称:連帳 略称:定義なし
     */
    連帳("1", "連帳");

    private final RString code;
    private final RString fullName;

    private NonyuTsuchishoRenchoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 納入通知書連帳区分のコードを返します。
     *
     * @return 納入通知書連帳区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 納入通知書連帳区分の名称を返します。
     *
     * @return 納入通知書連帳区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 納入通知書連帳区分のコードと一致する内容を探します。
     *
     * @param code 納入通知書連帳区分のコード
     * @return {@code code} に対応する納入通知書連帳区分
     */
    public static NonyuTsuchishoRenchoKubun toValue(RString code) {
        for (NonyuTsuchishoRenchoKubun nonyuTsuchishoRenchoKubun : NonyuTsuchishoRenchoKubun.values()) {
            if (nonyuTsuchishoRenchoKubun.code.equals(code)) {
                return nonyuTsuchishoRenchoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("納入通知書連帳区分"));
    }
}
