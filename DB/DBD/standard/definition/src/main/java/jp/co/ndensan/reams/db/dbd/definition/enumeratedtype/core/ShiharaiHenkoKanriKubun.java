package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更管理区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiharaiHenkoKanriKubun {

    /**
     * コード:1 名称:２号差止 略称:定義なし
     */
    _２号差止("1", "２号差止"),
    /**
     * コード:2 名称:１号償還払い化 略称:定義なし
     */
    _１号償還払い化("2", "１号償還払い化"),
    /**
     * コード:3 名称:１号給付額減額 略称:定義なし
     */
    _１号給付額減額("3", "１号給付額減額");

    private final RString code;
    private final RString fullName;

    private ShiharaiHenkoKanriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更管理区分のコードを返します。
     *
     * @return 支払方法変更管理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更管理区分の名称を返します。
     *
     * @return 支払方法変更管理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更管理区分のコードと一致する内容を探します。
     *
     * @param code 支払方法変更管理区分のコード
     * @return {@code code} に対応する支払方法変更管理区分
     */
    public static ShiharaiHenkoKanriKubun toValue(RString code) {

        for (ShiharaiHenkoKanriKubun shiharaiHenkoKanriKubun : ShiharaiHenkoKanriKubun.values()) {
            if (shiharaiHenkoKanriKubun.code.equals(code)) {
                return shiharaiHenkoKanriKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更管理区分"));
    }
}
