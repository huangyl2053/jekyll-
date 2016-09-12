/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.yoshikibetsurenkeijoho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 集計年月取得パラメータを作成します。
 *
 * @reamsid_L DBU-4050-030 suguangjun
 *
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShukeiYearMouthGetterParameter {

    private final FlexibleYearMonth 報告年月;
    private final FlexibleYear 報告年;
    private final RString 報告月;

    /**
     * コンストラクタです。
     *
     * @param shikibetsuCode 識別コード
     * @param genshobunHihokenshaNo 原書弁被保険者番号
     * @param shinsaseikyuTodokedeYMD 審査請求届出年月日
     */
    private ShukeiYearMouthGetterParameter(
            FlexibleYearMonth 報告年月,
            FlexibleYear 報告年,
            RString 報告月) {

        this.報告年月 = 報告年月;
        this.報告年 = 報告年;
        this.報告月 = 報告月;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 報告年月 報告年月
     * @param 報告年 報告年
     * @param 報告月 報告月
     * @return 検索用のパラメータ
     */
    public static ShukeiYearMouthGetterParameter createParam_common(
            FlexibleYearMonth 報告年月,
            FlexibleYear 報告年,
            RString 報告月) {
        return new ShukeiYearMouthGetterParameter(報告年月, 報告年, 報告月);
    }
}
