package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 併徴者山分け出力を表す列挙型です。
 *
 * @author LDNS
 */
public enum HeichoshaYamawakeShutsuryoku {

    /**
     * コード:0 名称:山分けしない 略称:定義なし
     */
    山分けしない("0", "山分けしない"),
    /**
     * コード:1 名称:山分けする 略称:定義なし
     */
    山分けする("1", "山分けする");

    private final RString code;
    private final RString fullName;

    private HeichoshaYamawakeShutsuryoku(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 併徴者山分け出力のコードを返します。
     *
     * @return 併徴者山分け出力のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 併徴者山分け出力の名称を返します。
     *
     * @return 併徴者山分け出力の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 併徴者山分け出力のコードと一致する内容を探します。
     *
     * @param code 併徴者山分け出力のコード
     * @return {@code code} に対応する併徴者山分け出力
     */
    public static HeichoshaYamawakeShutsuryoku toValue(RString code) {
        for (HeichoshaYamawakeShutsuryoku heichoshaYamawakeShutsuryoku : HeichoshaYamawakeShutsuryoku.values()) {
            if (heichoshaYamawakeShutsuryoku.code.equals(code)) {
                return heichoshaYamawakeShutsuryoku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("併徴者山分け出力"));
    }
}
