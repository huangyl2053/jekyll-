package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Hoshu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 銀行振込出力フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum IsGinkoFurikomiShutsuryoku {

    /**
     * コード:True 名称:出力済 略称:定義なし
     */
    出力済(true, "出力済"),
    /**
     * コード:False 名称:出力未 略称:定義なし
     */
    出力未(false, "出力未");

    private final boolean code;
    private final RString fullName;

    private IsGinkoFurikomiShutsuryoku(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 銀行振込出力フラグのコードを返します。
     *
     * @return 銀行振込出力フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 銀行振込出力フラグの名称を返します。
     *
     * @return 銀行振込出力フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 銀行振込出力フラグのコードと一致する内容を探します。
     *
     * @param code 銀行振込出力フラグのコード
     * @return {@code code} に対応する銀行振込出力フラグ
     */
    public static IsGinkoFurikomiShutsuryoku toValue(boolean code) {
        for (IsGinkoFurikomiShutsuryoku isGinkoFurikomiShutsuryoku : IsGinkoFurikomiShutsuryoku.values()) {
            if (isGinkoFurikomiShutsuryoku.code == code) {
                return isGinkoFurikomiShutsuryoku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("銀行振込出力フラグ"));
    }
}
