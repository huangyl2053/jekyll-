package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 変更通知書タイプを表す列挙型です。
 *
 * @author LDNS
 */
public enum HenkoTsuchishoType {

    /**
     * コード:01 名称:B5横 略称:定義なし
     */
    B5横("01", "B5横"),
    /**
     * コード:02 名称:A4縦 略称:定義なし
     */
    A4縦("02", "A4縦");

    private final RString code;
    private final RString fullName;

    private HenkoTsuchishoType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 変更通知書タイプのコードを返します。
     *
     * @return 変更通知書タイプのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 変更通知書タイプの名称を返します。
     *
     * @return 変更通知書タイプの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 変更通知書タイプのコードと一致する内容を探します。
     *
     * @param code 変更通知書タイプのコード
     * @return {@code code} に対応する変更通知書タイプ
     */
    public static HenkoTsuchishoType toValue(RString code) {
        for (HenkoTsuchishoType henkoTsuchishoType : HenkoTsuchishoType.values()) {
            if (henkoTsuchishoType.code.equals(code)) {
                return henkoTsuchishoType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("変更通知書タイプ"));
    }
}
