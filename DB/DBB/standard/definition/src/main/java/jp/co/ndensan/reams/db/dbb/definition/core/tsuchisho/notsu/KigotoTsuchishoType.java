package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期毎納入通知書タイプを表す列挙型です。
 *
 * @author LDNS
 */
public enum KigotoTsuchishoType {

    /**
     * コード:001 名称:標準版期毎タイプ 略称:定義なし
     */
    標準版期毎タイプ("001", "標準版期毎タイプ");

    private final RString code;
    private final RString fullName;

    private KigotoTsuchishoType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 期毎納入通知書タイプのコードを返します。
     *
     * @return 期毎納入通知書タイプのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 期毎納入通知書タイプの名称を返します。
     *
     * @return 期毎納入通知書タイプの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 期毎納入通知書タイプのコードと一致する内容を探します。
     *
     * @param code 期毎納入通知書タイプのコード
     * @return {@code code} に対応する期毎納入通知書タイプ
     */
    public static KigotoTsuchishoType toValue(RString code) {
        for (KigotoTsuchishoType kigotoTsuchishoType : KigotoTsuchishoType.values()) {
            if (kigotoTsuchishoType.code.equals(code)) {
                return kigotoTsuchishoType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("期毎納入通知書タイプ"));
    }
}
