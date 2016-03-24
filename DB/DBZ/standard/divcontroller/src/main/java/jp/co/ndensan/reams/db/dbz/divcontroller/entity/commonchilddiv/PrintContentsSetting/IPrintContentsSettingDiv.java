package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.PrintContentsSetting;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IPrintContentsSettingDiv extends ICommonChildDivBaseProperties {

    /**
     * 印刷設定に初期化を設定します。
     *
     * @param 発行日表示有無 boolean
     * @param 発行日初期表示日付 RDate
     * @param 発行日システム日付有無 boolean
     * @param 送付日表示有無 boolean
     * @param 送付日初期表示日付 RDate
     * @param 送付日システム日付有無 boolean
     */
    void initialize(boolean 発行日表示有無, RDate 発行日初期表示日付,
            boolean 発行日システム日付有無, boolean 送付日表示有無,
            RDate 送付日初期表示日付, boolean 送付日システム日付有無);

    /**
     * 発行日を取得します。
     *
     * @return RDate
     */
    RDate getIssueDate();

    /**
     * 送付日を取得します。
     *
     * @return RDate
     */
    RDate getSendDate();
}
