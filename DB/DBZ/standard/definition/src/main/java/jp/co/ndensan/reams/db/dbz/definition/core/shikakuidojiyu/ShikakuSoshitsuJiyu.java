package jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格喪失事由を表す列挙型です。
 *
 */
public enum ShikakuSoshitsuJiyu {

    /**
     * コード:51 名称:転出 略称:定義なし
     */
    転出("51", "転出"),
    /**
     * コード:52 名称:死亡 略称:定義なし
     */
    死亡("52", "死亡"),
    /**
     * コード:53 名称:除外者 略称:定義なし
     */
    除外者("53", "除外者"),
    /**
     * コード:55 名称:自特例解除 略称:定義なし
     */
    自特例解除("55", "自特例解除"),
    /**
     * コード:57 名称:国籍喪失 略称:定義なし
     */
    国籍喪失("57", "国籍喪失"),
    /**
     * コード:58 名称:他特例者 略称:定義なし
     */
    他特例者("58", "他特例者"),
    /**
     * コード:68 名称:職権喪失 略称:定義なし
     */
    職権喪失("68", "職権喪失"),
    /**
     * コード:99 名称:その他 略称:定義なし
     */
    その他("99", "その他");

    private final RString code;
    private final RString fullName;

    private ShikakuSoshitsuJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 資格喪失事由のコードを返します。
     *
     * @return 資格喪失事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格喪失事由の名称を返します。
     *
     * @return 資格喪失事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格喪失事由のコードと一致する内容を探します。
     *
     * @param code 資格喪失事由のコード
     * @return {@code code} に対応する資格喪失事由
     */
    public static ShikakuSoshitsuJiyu toValue(RString code) {
        for (ShikakuSoshitsuJiyu shikakuSoshitsuJiyu : ShikakuSoshitsuJiyu.values()) {
            if (shikakuSoshitsuJiyu.code.equals(code)) {
                return shikakuSoshitsuJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格喪失事由"));
    }
}
