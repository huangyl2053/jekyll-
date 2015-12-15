package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更情報分類区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiharaiHenkoJohoBunruiKubun {

    /**
     * コード:1 名称:差止情報 略称:定義なし
     */
    差止情報("1", "差止情報"),
    /**
     * コード:2 名称:保険料控除情報 略称:定義なし
     */
    保険料控除情報("2", "保険料控除情報");

    private final RString code;
    private final RString fullName;

    private ShiharaiHenkoJohoBunruiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更情報分類区分のコードを返します。
     *
     * @return 支払方法変更情報分類区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更情報分類区分の名称を返します。
     *
     * @return 支払方法変更情報分類区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更情報分類区分のコードと一致する内容を探します。
     *
     * @param code 支払方法変更情報分類区分のコード
     * @return {@code code} に対応する支払方法変更情報分類区分
     */
    public static ShiharaiHenkoJohoBunruiKubun toValue(RString code) {

        for (ShiharaiHenkoJohoBunruiKubun shiharaiHenkoJohoBunruiKubun : ShiharaiHenkoJohoBunruiKubun.values()) {
            if (shiharaiHenkoJohoBunruiKubun.code.equals(code)) {
                return shiharaiHenkoJohoBunruiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更情報分類区分"));
    }
}
