package jp.co.ndensan.reams.db.dbz.definition.core.sortjun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併情報ソート順を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum GappeiJohoSortOrder {

    /**
     * コード:1 名称:合併日 略称:定義なし
     */
    合併日(1, "合併日"),
    /**
     * コード:2 名称:国保連データ連携開始日 略称:定義なし
     */
    国保連データ連携開始日(2, "国保連データ連携開始日");

    private final int code;
    private final RString fullName;

    private GappeiJohoSortOrder(int code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 合併情報ソート順のコードを返します。
     *
     * @return 合併情報ソート順のコード
     */
    public int getコード() {
        return code;
    }

    /**
     * 合併情報ソート順の名称を返します。
     *
     * @return 合併情報ソート順の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 合併情報ソート順のコードと一致する内容を探します。
     *
     * @param code 合併情報ソート順のコード
     * @return {@code code} に対応する合併情報ソート順
     */
    public static GappeiJohoSortOrder toValue(int code) {
        for (GappeiJohoSortOrder gappeiJohoSortOrder : GappeiJohoSortOrder.values()) {
            if (gappeiJohoSortOrder.code == code) {
                return gappeiJohoSortOrder;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("合併情報ソート順"));
    }
}
