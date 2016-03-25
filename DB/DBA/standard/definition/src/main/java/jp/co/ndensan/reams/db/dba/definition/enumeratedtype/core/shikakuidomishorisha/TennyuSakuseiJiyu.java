package jp.co.ndensan.reams.db.dba.definition.enumeratedtype.core.shikakuidomishorisha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転入作成事由を表す列挙型です。
 *
 * @author LDNS
 */
public enum TennyuSakuseiJiyu {

    /**
     * コード:0001 名称:広域内転入 略称:定義なし
     */
    広域内転入("0001", "広域内転入"),
    /**
     * コード:0002 名称:日付不整合 略称:定義なし
     */
    日付不整合("0002", "日付不整合"),
    /**
     * コード:0003 名称:排他制御エラー 略称:定義なし
     */
    排他制御エラー("0003", "排他制御エラー"),
    /**
     * コード:0004 名称:死亡喪失 略称:定義なし
     */
    死亡喪失("0004", "死亡喪失"),
    /**
     * コード:0005 名称:外国人の転入 略称:定義なし
     */
    外国人の転入("0005", "外国人の転入"),
    /**
     * コード:0006 名称:特定住所への転入 略称:定義なし
     */
    特定住所への転入("0006", "特定住所への転入"),
    /**
     * コード:0007 名称:別住民コードでの再転入 略称:定義なし
     */
    別住民コードでの再転入("0007", "別住民コードでの再転入");

    private final RString code;
    private final RString fullName;

    private TennyuSakuseiJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 転入作成事由のコードを返します。
     *
     * @return 転入作成事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 転入作成事由の名称を返します。
     *
     * @return 転入作成事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 転入作成事由のコードと一致する内容を探します。
     *
     * @param code 転入作成事由のコード
     * @return {@code code} に対応する転入作成事由
     */
    public static TennyuSakuseiJiyu toValue(RString code) {
        for (TennyuSakuseiJiyu tennyuSakuseiJiyu : TennyuSakuseiJiyu.values()) {
            if (tennyuSakuseiJiyu.code.equals(code)) {
                return tennyuSakuseiJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("転入作成事由"));
    }
}
