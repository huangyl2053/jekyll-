package jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得事由を表す列挙型です。
 *
 */
public enum ShikakuShutokuJiyu {

    /**
     * コード:01 名称:転入 略称:定義なし
     */
    転入("01", "転入"),
    /**
     * コード:02 名称:年齢到達 略称:定義なし
     */
    年齢到達("02", "年齢到達"),
    /**
     * コード:03 名称:外国人 略称:定義なし
     */
    外国人("03", "外国人"),
    /**
     * コード:04 名称:２号申請 略称:定義なし
     */
    _２号申請("04", "２号申請"),
    /**
     * コード:07 名称:他特例居住 略称:定義なし
     */
    他特例居住("07", "他特例居住"),
    /**
     * コード:08 名称:除外者居住 略称:定義なし
     */
    除外者居住("08", "除外者居住"),
    /**
     * コード:09 名称:帰化 略称:定義なし
     */
    帰化("09", "帰化"),
    /**
     * コード:12 名称:国籍取得 略称:定義なし
     */
    国籍取得("12", "国籍取得"),
    /**
     * コード:18 名称:職権取得 略称:定義なし
     */
    職権取得("18", "職権取得"),
    /**
     * コード:46 名称:施行時取得 略称:定義なし
     */
    施行時取得("46", "施行時取得"),
    /**
     * コード:49 名称:その他 略称:定義なし
     */
    その他("49", "その他");

    private final RString code;
    private final RString fullName;

    private ShikakuShutokuJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
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
