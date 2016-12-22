package jp.co.ndensan.reams.db.dbz.definition.core.shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会進捗状況を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum ShinsakaiShinchokuJokyo {

    /**
     * コード:0 名称:未開催 略称:定義なし
     */
    未開催("0", "未開催", ""),
    /**
     * コード:1 名称:未開催/割付完了 略称:定義なし
     */
    未開催_割付完了("1", "未開催/割付完了", "割付完了"),
    /**
     * コード:2 名称:完了 略称:定義なし
     */
    完了("2", "完了", "完了"),
    /**
     * コード:3 名称:中止 略称:定義なし
     */
    中止("3", "中止", "中止"),
    /**
     * コード:9 名称:その他 略称:定義なし
     */
    その他("9", "その他", "その他");

    private final RString code;
    private final RString fullName;
    private final RString diplayName;

    private ShinsakaiShinchokuJokyo(String code, String fullname, String diplayName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.diplayName = new RString(diplayName);
    }

    /**
     * 介護認定審査会進捗状況のコードを返します。
     *
     * @return 介護認定審査会進捗状況のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 介護認定審査会進捗状況の名称を返します。
     *
     * @return 介護認定審査会進捗状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 介護認定審査会進捗状況の画面表示名称を返します。
     *
     * @return 介護認定審査会進捗状況の画面表示名称
     */
    public RString get画面表示名称() {
        return diplayName;
    }

    /**
     * 介護認定審査会進捗状況のコードと一致する内容を探します。
     *
     * @param code 介護認定審査会進捗状況のコード
     * @return {@code code} に対応する介護認定審査会進捗状況
     */
    public static ShinsakaiShinchokuJokyo toValue(RString code) {

        for (ShinsakaiShinchokuJokyo shinsakaiShinchokuJokyo : ShinsakaiShinchokuJokyo.values()) {
            if (shinsakaiShinchokuJokyo.code.equals(code)) {
                return shinsakaiShinchokuJokyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("介護認定審査会進捗状況"));
    }
}
