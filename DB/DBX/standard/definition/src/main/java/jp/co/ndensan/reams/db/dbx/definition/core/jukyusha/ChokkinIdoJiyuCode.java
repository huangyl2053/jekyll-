package jp.co.ndensan.reams.db.dbx.definition.core.jukyusha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 直近異動事由コードを表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 liangbc
 */
public enum ChokkinIdoJiyuCode {

    /**
     * コード:00 名称:定義なし 略称:定義なし
     */
    未登録("00", ""),
    /**
     * コード:01 名称:認定 略称:定義なし
     */
    追加_認定("01", "認定"),
    /**
     * コード:02 名称:変更申請認定 略称:定義なし
     */
    要介護度変更申請認定("02", "変更申請認定"),
    /**
     * コード:03 名称:変更申請却下 略称:定義なし
     */
    要介護度変更申請却下("03", "変更申請却下"),
    /**
     * コード:04 名称:サ変更申請認定 略称:定義なし
     */
    サービス種類変更申請認定("04", "サ変更申請認定"),
    /**
     * コード:05 名称:サ変更申請却下 略称:定義なし
     */
    サービス種類変更申請却下("05", "サ変更申請却下"),
    /**
     * コード:06 名称:削除 略称:定義なし
     */
    削除("06", "削除"),
    /**
     * コード:07 名称:修正 略称:定義なし
     */
    修正("07", "修正"),
    /**
     * コード:08 名称:受給申請却下 略称:定義なし
     */
    受給申請却下("08", "受給申請却下"),
    /**
     * コード:09 名称:削除回復 略称:定義なし
     */
    削除回復("09", "削除回復"),
    /**
     * コード:10 名称:職権記載 略称:定義なし
     */
    職権記載("10", "職権記載"),
    /**
     * コード:11 名称:職権修正 略称:定義なし
     */
    職権修正("11", "職権修正"),
    /**
     * コード:12 名称:職権取消 略称:定義なし
     */
    職権取消("12", "職権取消"),
    /**
     * コード:20 名称:履歴修正 略称:定義なし
     */
    履歴修正("20", "履歴修正");

    private final RString code;
    private final RString fullName;

    private ChokkinIdoJiyuCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 直近異動事由コードのコードを返します。
     *
     * @return 直近異動事由コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 直近異動事由コードの名称を返します。
     *
     * @return 直近異動事由コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 直近異動事由コードのコードと一致する内容を探します。
     *
     * @param code 直近異動事由コードのコード
     * @return {@code code} に対応する直近異動事由コード
     */
    public static ChokkinIdoJiyuCode toValue(RString code) {

        for (ChokkinIdoJiyuCode chokkinIdoJiyuCode : ChokkinIdoJiyuCode.values()) {
            if (chokkinIdoJiyuCode.code.equals(code)) {
                return chokkinIdoJiyuCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("直近異動事由コード"));
    }
}
