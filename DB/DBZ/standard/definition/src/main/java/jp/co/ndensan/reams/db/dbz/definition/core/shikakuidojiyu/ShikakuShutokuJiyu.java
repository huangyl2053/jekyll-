package jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得事由を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum ShikakuShutokuJiyu {

    /**
     * コード:01 名称:転入 備考:転入【資格取得】
     */
    転入("01", "転入", "転入【資格取得】"),
    /**
     * コード:02 名称:年齢到達 備考:年齢到達【資格取得】
     */
    年齢到達("02", "年齢到達", "年齢到達【資格取得】"),
    /**
     * コード:03 名称:外国人 備考:外国人申請【資格取得】
     */
    外国人("03", "外国人", "外国人申請【資格取得】"),
    /**
     * コード:04 名称:２号申請 備考:２号申請【資格取得】
     */
    _２号申請("04", "２号申請", "２号申請【資格取得】"),
    /**
     * コード:07 名称:他特例居住 備考:他住所特例者が施設退所居住【資格取得】
     */
    他特例居住("07", "他特例居住", "他住所特例者が施設退所居住【資格取得】"),
    /**
     * コード:08 名称:除外者居住 備考:適用除外者が施設退所居住【資格取得】
     */
    除外者居住("08", "除外者居住", "適用除外者が施設退所居住【資格取得】"),
    /**
     * コード:09 名称:帰化 備考:外国人が日本人になった【資格取得】
     */
    帰化("09", "帰化", "外国人が日本人になった【資格取得】"),
    /**
     * コード:12 名称:国籍取得 備考:外国人が日本国籍を取得した【資格取得】
     */
    国籍取得("12", "国籍取得", "外国人が日本国籍を取得した【資格取得】"),
    /**
     * コード:18 名称:職権取得 備考:住民として職権記載【資格取得】
     */
    職権取得("18", "職権取得", "住民として職権記載【資格取得】"),
    /**
     * コード:46 名称:施行時取得 備考:定義なし
     */
    施行時取得("46", "施行時取得", "法施行時に資格を取得する【資格取得】"),
    /**
     * コード:49 名称:その他 備考:その他の理由により資格を取得【資格取得】
     */
    その他("49", "その他", "その他の理由により資格を取得【資格取得】");

    private final RString code;
    private final RString fullName;
    private final RString bikouName;

    private ShikakuShutokuJiyu(String code, String fullname, String bikouName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.bikouName = new RString(bikouName);
    }

    /**
     * 資格取得事由のコードを返します。
     *
     * @return 資格取得事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格取得事由の名称を返します。
     *
     * @return 資格取得事由の備考
     */
    public RString get備考() {
        return bikouName;
    }

    /**
     * 資格取得事由の名称を返します。
     *
     * @return 資格取得事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格取得事由のコードと一致する内容を探します。
     *
     * @param code 資格取得事由のコード
     * @return {@code code} に対応する資格取得事由
     */
    public static ShikakuShutokuJiyu toValue(RString code) {
        for (ShikakuShutokuJiyu shikakuShutokuJiyu : ShikakuShutokuJiyu.values()) {
            if (shikakuShutokuJiyu.code.equals(code)) {
                return shikakuShutokuJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格取得事由"));
    }
}
