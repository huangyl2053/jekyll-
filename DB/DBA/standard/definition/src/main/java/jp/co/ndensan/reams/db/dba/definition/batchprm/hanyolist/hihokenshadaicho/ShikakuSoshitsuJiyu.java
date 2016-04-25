package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 喪失事由を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum ShikakuSoshitsuJiyu {

    /**
     * コード:51 名称:転出 略称:定義なし
     */
    転出("51", "転出"),
    /**
     * コード:02 名称:年齢到達 略称:定義なし
     */
    年齢到達("02", "年齢到達"),
    /**
     * コード:52 名称:死亡 略称:定義なし
     */
    死亡("52", "死亡"),
    /**
     * コード:57 名称:国籍喪失 略称:定義なし
     */
    国籍喪失("57", "国籍喪失"),
    /**
     * コード:71 名称:自特例転入 略称:定義なし
     */
    自特例転入("71", "自特例転入"),
    /**
     * コード:58 名称:他特例者 略称:定義なし
     */
    他特例者("58", "他特例者"),
    /**
     * コード:55 名称:自特例解除 略称:定義なし
     */
    自特例解除("55", "自特例解除"),
    /**
     * コード:23 名称:帰化 略称:定義なし
     */
    帰化("23", "帰化"),
    /**
     * コード:68 名称:職権喪失 略称:定義なし
     */
    職権喪失("68", "職権喪失"),
    /**
     * コード:11 名称:広域内転出 略称:定義なし
     */
    広域内転出("11", "広域内転出"),
    /**
     * コード:53 名称:除外者 略称:定義なし
     */
    除外者("53", "除外者"),
    /**
     * コード:49 名称:その他 略称:定義なし
     */
    その他("49", "その他"),
    /**
     * コード:12 名称:国籍取得 略称:定義なし
     */
    国籍取得("12", "国籍取得"),
    /**
     * コード:14 名称:広住特転入 略称:定義なし
     */
    広住特転入("14", "広住特転入"),
    /**
     * コード:17 名称:広住特解除 略称:定義なし
     */
    広住特解除("17", "広住特解除"),
    /**
     * コード:41 名称:一本化 略称:定義なし
     */
    一本化("41", "一本化"),
    /**
     * コード:42 名称:合併 略称:定義なし
     */
    合併("42", "合併");

    private final RString code;
    private final RString fullName;

    private ShikakuSoshitsuJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 喪失事由のコードを返します。
     *
     * @return 喪失事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 喪失事由の名称を返します。
     *
     * @return 喪失事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 喪失事由のコードと一致する内容を探します。
     *
     * @param code 喪失事由のコード
     * @return {@code code} に対応する喪失事由
     */
    public static ShikakuSoshitsuJiyu toValue(RString code) {
        for (ShikakuSoshitsuJiyu shikakuSoshitsuJiyu : ShikakuSoshitsuJiyu.values()) {
            if (shikakuSoshitsuJiyu.code.equals(code)) {
                return shikakuSoshitsuJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("喪失事由"));
    }
}
