package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.core.kofusho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 交付証種類を表す列挙型です。
 */
public enum KofushoShurui {

    /**
     * コード:001 名称:被保険者証 略称:定義なし
     */
    被保険者証("001", "被保険者証"),
    /**
     * コード:002 名称:資格者証 略称:定義なし
     */
    資格者証("002", "資格者証");

    private final RString code;
    private final RString fullName;

    private KofushoShurui(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 交付証種類のコードを返します。
     *
     * @return 交付証種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 交付証種類の名称を返します。
     *
     * @return 交付証種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 交付証種類のコードと一致する内容を探します。
     *
     * @param code 交付証種類のコード
     * @return {@code code} に対応する交付証種類
     */
    public static KofushoShurui toValue(RString code) {
        for (KofushoShurui kofushoShurui : KofushoShurui.values()) {
            if (kofushoShurui.code.equals(code)) {
                return kofushoShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("交付証種類"));
    }
}
