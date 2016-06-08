package jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抽出日種類を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ChushutsuDateShurui {

    /**
     * コード:01 名称:認定日 略称:定義なし
     */
    認定日("01", "認定日"),
    /**
     * コード:02 名称:申請日 略称:定義なし
     */
    申請日("02", "申請日"),
    /**
     * コード:03 名称:調査依頼日 略称:定義なし
     */
    調査依頼日("03", "調査依頼日"),
    /**
     * コード:04 名称:調査実施予定日 略称:定義なし
     */
    調査実施予定日("04", "調査実施予定日"),
    /**
     * コード:05 名称:調査実施日 略称:定義なし
     */
    調査実施日("05", "調査実施日"),
    /**
     * コード:06 名称:意見書依頼日 略称:定義なし
     */
    意見書依頼日("06", "意見書依頼日"),
    /**
     * コード:07 名称:意見書入手予定日 略称:定義なし
     */
    意見書入手予定日("07", "意見書入手予定日"),
    /**
     * コード:08 名称:意見書入手日 略称:定義なし
     */
    意見書入手日("08", "意見書入手日"),
    /**
     * コード:09 名称:審査会資料作成日 略称:定義なし
     */
    審査会資料作成日("09", "審査会資料作成日"),
    /**
     * コード:10 名称:審査会回答予定日 略称:定義なし
     */
    審査会回答予定日("10", "審査会回答予定日"),
    /**
     * コード:11 名称:審査会回答日 略称:定義なし
     */
    審査会回答日("11", "審査会回答日"),
    /**
     * コード:12 名称:認定有効開始日 略称:定義なし
     */
    認定有効開始日("12", "認定有効開始日"),
    /**
     * コード:13 名称:認定有効終了日 略称:定義なし
     */
    認定有効終了日("13", "認定有効終了日");

    private final RString code;
    private final RString fullName;

    private ChushutsuDateShurui(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 抽出日種類のコードを返します。
     *
     * @return 抽出日種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 抽出日種類の名称を返します。
     *
     * @return 抽出日種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 抽出日種類のコードと一致する内容を探します。
     *
     * @param code 抽出日種類のコード
     * @return {@code code} に対応する抽出日種類
     */
    public static ChushutsuDateShurui toValue(RString code) {
        for (ChushutsuDateShurui chushutsuDateShurui : ChushutsuDateShurui.values()) {
            if (chushutsuDateShurui.code.equals(code)) {
                return chushutsuDateShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("抽出日種類"));
    }
}
