package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.core.shikakuidomishorisha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転出作成事由を表す列挙型です。
 *
 * @author LDNS
 */
public enum TenshutsuSakuseiJiyu {

    /**
     * コード:0001 名称:広域内転出 略称:定義なし
     */
    広域内転出("0001", "広域内転出"),
    /**
     * コード:0002 名称:日付不整合 略称:定義なし
     */
    日付不整合("0002", "日付不整合"),
    /**
     * コード:0003 名称:受給者転出 略称:定義なし
     */
    受給者転出("0003", "受給者転出");

    private final RString code;
    private final RString fullName;

    private TenshutsuSakuseiJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 転出作成事由のコードを返します。
     *
     * @return 転出作成事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 転出作成事由の名称を返します。
     *
     * @return 転出作成事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 転出作成事由のコードと一致する内容を探します。
     *
     * @param code 転出作成事由のコード
     * @return {@code code} に対応する転出作成事由
     */
    public static TenshutsuSakuseiJiyu toValue(RString code) {
        for (TenshutsuSakuseiJiyu tenshutsuSakuseiJiyu : TenshutsuSakuseiJiyu.values()) {
            if (tenshutsuSakuseiJiyu.code.equals(code)) {
                return tenshutsuSakuseiJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("転出作成事由"));
    }
}
