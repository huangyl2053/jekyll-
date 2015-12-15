package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会開催場所状況を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinsakaiKaisaiBashoJokyo {

    /**
     * コード:True 名称:有効 略称:定義なし
     */
    有効(true, "有効"),
    /**
     * コード:False 名称:無効 略称:定義なし
     */
    無効(false, "無効");

    private final boolean code;
    private final RString fullName;

    private ShinsakaiKaisaiBashoJokyo(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 審査会開催場所状況のコードを返します。
     *
     * @return 審査会開催場所状況のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 審査会開催場所状況の名称を返します。
     *
     * @return 審査会開催場所状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 審査会開催場所状況のコードと一致する内容を探します。
     *
     * @param code 審査会開催場所状況のコード
     * @return {@code code} に対応する審査会開催場所状況
     */
    public static ShinsakaiKaisaiBashoJokyo toValue(boolean code) {
        for (ShinsakaiKaisaiBashoJokyo shinsakaiKaisaiBashoJokyo : ShinsakaiKaisaiBashoJokyo.values()) {
            if (shinsakaiKaisaiBashoJokyo.code == code) {
                return shinsakaiKaisaiBashoJokyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("審査会開催場所状況"));
    }
}
