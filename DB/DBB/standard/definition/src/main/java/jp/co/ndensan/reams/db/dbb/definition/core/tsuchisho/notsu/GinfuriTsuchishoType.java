package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 銀振納入通知書タイプを表す列挙型です。
 *
 * @author LDNS
 */
public enum GinfuriTsuchishoType {

    /**
     * コード:001 名称:標準版銀振タイプ 略称:定義なし
     */
    標準版銀振タイプ("001", "標準版銀振タイプ");

    private final RString code;
    private final RString fullName;

    private GinfuriTsuchishoType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 銀振納入通知書タイプのコードを返します。
     *
     * @return 銀振納入通知書タイプのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 銀振納入通知書タイプの名称を返します。
     *
     * @return 銀振納入通知書タイプの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 銀振納入通知書タイプのコードと一致する内容を探します。
     *
     * @param code 銀振納入通知書タイプのコード
     * @return {@code code} に対応する銀振納入通知書タイプ
     */
    public static GinfuriTsuchishoType toValue(RString code) {
        for (GinfuriTsuchishoType ginfuriTsuchishoType : GinfuriTsuchishoType.values()) {
            if (ginfuriTsuchishoType.code.equals(code)) {
                return ginfuriTsuchishoType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("銀振納入通知書タイプ"));
    }
}
