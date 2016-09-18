package jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格喪失事由を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum ShikakuSoshitsuJiyu {

    /**
     * コード:51 名称:転出 備考:転出【資格喪失】
     */
    転出("51", "転出", "転出【資格喪失】"),
    /**
     * コード:52 名称:死亡 備考:死亡【資格喪失】
     */
    死亡("52", "死亡", "死亡【資格喪失】"),
    /**
     * コード:53 名称:除外者 備考:適用除外者【資格喪失】
     */
    除外者("53", "除外者", "適用除外者【資格喪失】"),
    /**
     * コード:55 名称:自特例解除 備考:自住所特例者が施設退所外居住
     */
    自特例解除("55", "自特例解除", "自住所特例者が施設退所外居住"),
    /**
     * コード:57 名称:国籍喪失 備考:日本人が国籍を喪失した【資格喪失】
     */
    国籍喪失("57", "国籍喪失", "日本人が国籍を喪失した【資格喪失】"),
    /**
     * コード:58 名称:他特例者 備考:転入者が他特例者として特養施設に入所。
     */
    他特例者("58", "他特例者", "転入者が他特例者として特養施設に入所。"),
    /**
     * コード:68 名称:職権喪失 備考:住民を職権削除【資格喪失】
     */
    職権喪失("68", "職権喪失", "住民を職権削除【資格喪失】"),
    /**
     * コード:99 名称:その他 備考:その他の理由により資格を喪失【資格喪失】
     */
    その他("99", "その他", "その他の理由により資格を喪失【資格喪失】"),
    /**
     * 空の場合に設定される項目
     */
    EMPTY("", "", "");

    private final RString code;
    private final RString fullName;
    private final RString bikouName;

    private ShikakuSoshitsuJiyu(String code, String fullname, String bikouName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.bikouName = new RString(bikouName);
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
     * 資格喪失事由の備考を返します。
     *
     * @return 資格喪失事由の備考
     */
    public RString get備考() {
        return bikouName;
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
        return EMPTY;
    }
}
