package jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 取得事由を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum ShikakuShutokuJiyu {

    /**
     * コード:01 名称:転入 略称:転入
     */
    転入("01", "転入", "転入"),
    /**
     * コード:02 名称:年齢到達 略称:年齢到達
     */
    年齢到達("02", "年齢到達", "年齢到達"),
    /**
     * コード:04 名称:２号申請 略称:２号申請
     */
    _２号申請("04", "２号申請", "２号申請"),
    /**
     * コード:03 名称:外国人 略称:外国人
     */
    外国人("03", "外国人", "外国人"),
    /**
     * コード:71 名称:自特例転入 略称:自特例転入
     */
    自特例転入("71", "自特例転入", "自特例転入"),
    /**
     * コード:07 名称:他特例居住 略称:他特例居住
     */
    他特例居住("07", "他特例居住", "他特例居住"),
    /**
     * コード:05 名称:自特例適用 略称:自特例適用
     */
    自特例適用("05", "自特例適用", "自特例適用"),
    /**
     * コード:23 名称:帰化 略称:帰化
     */
    帰化("23", "帰化", "帰化"),
    /**
     * コード:18 名称:職権取得 略称:職権取得
     */
    職権取得("18", "職権取得", "職権取得"),
    /**
     * コード:11 名称:広域内転入 略称:広域内転入
     */
    広域内転入("11", "広域内転入", "広域内転入"),
    /**
     * コード:08 名称:除外者居住 略称:除外者居住
     */
    除外者居住("08", "除外者居住", "除外者居住"),
    /**
     * コード:49 名称:その他 略称:その他
     */
    その他("49", "その他", "その他"),
    /**
     * コード:12 名称:国籍取得 略称:国籍取得
     */
    国籍取得("12", "国籍取得", "国籍取得"),
    /**
     * コード:46 名称:施行時取得 略称:施行時取得
     */
    施行時取得("46", "施行時取得", "施行時取得"),
    /**
     * コード:13 名称:広住特適用 略称:広住特適用
     */
    広住特適用("13", "広住特適用", "広住特適用"),
    /**
     * コード:14 名称:広住特転入 略称:広住特転入
     */
    広住特転入("14", "広住特転入", "広住特転入"),
    /**
     * コード:15 名称:広住特居住 略称:広住特居住
     */
    広住特居住("15", "広住特居住", "広住特居住"),
    /**
     * コード:41 名称:一本化 略称:一本化
     */
    一本化("41", "一本化", "一本化"),
    /**
     * コード:42 名称:合併 略称:合併
     */
    合併("42", "合併", "合併"),
    /**
     * コード:72 名称:自特例解除 略称:自特例解除
     */
    自特例解除("72", "自特例解除", "自特例解除");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ShikakuShutokuJiyu(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 取得事由のコードを返します。
     *
     * @return 取得事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 取得事由の名称を返します。
     *
     * @return 取得事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 取得事由の略称を返します。
     *
     * @return 取得事由の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 取得事由のコードと一致する内容を探します。
     *
     * @param code 取得事由のコード
     * @return {@code code} に対応する取得事由
     */
    public static ShikakuShutokuJiyu toValue(RString code) {
        for (ShikakuShutokuJiyu shikakuShutokuJiyu : ShikakuShutokuJiyu.values()) {
            if (shikakuShutokuJiyu.code.equals(code)) {
                return shikakuShutokuJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("取得事由"));
    }
}
