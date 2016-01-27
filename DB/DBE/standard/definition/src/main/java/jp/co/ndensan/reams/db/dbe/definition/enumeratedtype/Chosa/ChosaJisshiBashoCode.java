package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査実施場所コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum ChosaJisshiBashoCode {

    /**
     * コード:1 名称:自宅内 略称:定義なし
     */
    自宅内("1", "自宅内"),
    /**
     * コード:2 名称:自宅外 略称:定義なし
     */
    自宅外("2", "自宅外"),
    /**
     * コード:3 名称:その他 略称:定義なし
     */
    その他("3", "その他");

    private final RString code;
    private final RString fullName;

    private ChosaJisshiBashoCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 調査実施場所コードのコードを返します。
     *
     * @return 調査実施場所コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 調査実施場所コードの名称を返します。
     *
     * @return 調査実施場所コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 調査実施場所コードのコードと一致する内容を探します。
     *
     * @param code 調査実施場所コードのコード
     * @return {@code code} に対応する調査実施場所コード
     */
    public static ChosaJisshiBashoCode toValue(RString code) {

        for (ChosaJisshiBashoCode chosaJisshiBashoCode : ChosaJisshiBashoCode.values()) {
            if (chosaJisshiBashoCode.code.equals(code)) {
                return chosaJisshiBashoCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("調査実施場所"));
    }
}
