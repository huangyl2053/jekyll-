/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakukaigotaishoshachushutsusokyubun;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護対象者抽出（遡及分）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-5750-050 houtianpeng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KogakukaigotaishoshachushutsusokyubunParameter {

    private final RDateTime 抽出期間開始日時;
    private final RDateTime 抽出期間終了日時;
    private final FlexibleYearMonth 開始年月;
    private final FlexibleYearMonth 終了年月;
    private final RString 宛名識別対象PSM;
    private final RString 介護保険;
    private final FlexibleYearMonth 処理年月;

    /**
     * コンストラクタです。
     *
     * @param 抽出期間開始日時 YMDHMS
     * @param 抽出期間終了日時 YMDHMS
     * @param 開始年月 FlexibleYearMonth
     * @param 終了年月 FlexibleYearMonth
     * @param 宛名識別対象PSM RString
     * @param 介護保険 RString
     * @param 処理年月 FlexibleYearMonth
     */
    private KogakukaigotaishoshachushutsusokyubunParameter(
            RDateTime 抽出期間開始日時,
            RDateTime 抽出期間終了日時,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月,
            RString 宛名識別対象PSM,
            RString 介護保険,
            FlexibleYearMonth 処理年月) {
        this.抽出期間開始日時 = 抽出期間開始日時;
        this.抽出期間終了日時 = 抽出期間終了日時;
        this.開始年月 = 開始年月;
        this.終了年月 = 終了年月;
        this.宛名識別対象PSM = 宛名識別対象PSM;
        this.介護保険 = 介護保険;
        this.処理年月 = 処理年月;
    }

    /**
     * 識別コード検索用のパラメータを生成します。
     *
     * @param 抽出期間開始日時 RDateTime
     * @param 抽出期間終了日時 RDateTime
     * @param 開始年月 FlexibleYearMonth
     * @param 終了年月 FlexibleYearMonth
     * @param 宛名識別対象PSM RString
     * @param 介護保険 RString
     * @param 処理年月 FlexibleYearMonth
     * @return KogakukaigotaishoshachushutsusokyubunParameter
     */
    public static KogakukaigotaishoshachushutsusokyubunParameter createParam(
            RDateTime 抽出期間開始日時,
            RDateTime 抽出期間終了日時,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月,
            RString 宛名識別対象PSM,
            RString 介護保険,
            FlexibleYearMonth 処理年月) {
        return new KogakukaigotaishoshachushutsusokyubunParameter(
                抽出期間開始日時,
                抽出期間終了日時,
                開始年月,
                終了年月,
                宛名識別対象PSM,
                介護保険,
                処理年月);
    }
}
