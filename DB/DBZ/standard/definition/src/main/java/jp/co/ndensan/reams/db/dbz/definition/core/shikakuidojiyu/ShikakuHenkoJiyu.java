package jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格変更事由を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum ShikakuHenkoJiyu {

    /**
     * コード:21 名称:転居 備考:転居
     */
    転居("21", "転居", "転居"),
    /**
     * コード:22 名称:氏名変更 備考:氏名変更
     */
    氏名変更("22", "氏名変更", "氏名変更"),
    /**
     * コード:11 名称:広域内転居 備考:広域内転居
     */
    広域内転居("11", "広域内転居", "広域内転居"),
    /**
     * コード:13 名称:広住特適用 備考:広域内住所地特例適用
     */
    広住特適用("13", "広住特適用", "広域内住所地特例適用"),
    /**
     * コード:14 名称:広住特転入 備考:広域内住所地特例転入
     */
    広住特転入("14", "広住特転入", "広域内住所地特例転入"),
    /**
     * コード:15 名称:広住特居住 備考:広域内住所地特例居住
     */
    広住特居住("15", "広住特居住", "広域内住所地特例居住"),
    /**
     * コード:17 名称:広住特転居 備考:広域内住所地特例転居
     */
    広住特転居("17", "広住特転居", "広域内住所地特例転居"),
    /**
     * コード:16 名称:合併内転居 備考:合併市町村内転居
     */
    合併内転居("16", "合併内転居", "合併市町村内転居"),
    /**
     * コード:41 名称:一本化 備考:一本化
     */
    一本化("41", "一本化", "一本化"),
    /**
     * コード:31 名称:１号到達 備考:１号被保険者到達
     */
    _１号到達("31", "１号到達", "１号被保険者到達"),
    /**
     * コード:42 名称:合併 備考:合併取得
     */
    合併("42", "合併", "合併取得"),
    /**
     * コード:23 名称:帰化 備考:外国人が日本人になった
     */
    帰化("23", "帰化", "外国人が日本人になった"),
    /**
     * コード:24 名称:国籍取得 備考:外国人が日本国籍を取得した
     */
    国籍取得("24", "国籍取得", "外国人が日本国籍を取得した"),
    /**
     * コード:48 名称:その他 備考:その他
     */
    その他("48", "その他", "その他");

    private final RString code;
    private final RString fullName;
    private final RString bikouName;

    private ShikakuHenkoJiyu(String code, String fullname, String bikouName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.bikouName = new RString(bikouName);
    }

    /**
     * 資格変更事由のコードを返します。
     *
     * @return 資格変更事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格変更事由の備考を返します。
     *
     * @return 資格変更事由の備考
     */
    public RString get備考() {
        return bikouName;
    }

    /**
     * 資格変更事由の名称を返します。
     *
     * @return 資格変更事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格変更事由のコードと一致する内容を探します。
     *
     * @param code 資格変更事由のコード
     * @return {@code code} に対応する資格変更事由
     */
    public static ShikakuHenkoJiyu toValue(RString code) {
        for (ShikakuHenkoJiyu shikakuHenkoJiyu : ShikakuHenkoJiyu.values()) {
            if (shikakuHenkoJiyu.code.equals(code)) {
                return shikakuHenkoJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格変更事由"));
    }
}
