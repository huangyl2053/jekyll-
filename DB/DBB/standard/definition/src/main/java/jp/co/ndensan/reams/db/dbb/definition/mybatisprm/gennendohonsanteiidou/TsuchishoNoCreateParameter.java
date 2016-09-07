/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gennendohonsanteiidou;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 通知書番号発番用パラメータクラスです。
 *
 * @reamsid_L DBB-0930-020 cuilin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TsuchishoNoCreateParameter {

    private final FlexibleYear 賦課年度;
    private final FlexibleYear 調定年度;
    private final RDateTime 抽出開始日時;
    private final RDateTime 抽出終了日時;

    /**
     * コンストラクタです。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     */
    private TsuchishoNoCreateParameter(FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            RDateTime 抽出開始日時,
            RDateTime 抽出終了日時) {
        this.賦課年度 = 賦課年度;
        this.調定年度 = 調定年度;
        this.抽出開始日時 = 抽出開始日時;
        this.抽出終了日時 = 抽出終了日時;
    }

    /**
     * 通知書番号発番のパラメータを生成します。
     *
     * @param 賦課年度 FlexibleYear
     * @param 調定年度 FlexibleYear
     * @param 抽出開始日時 RDateTime
     * @param 抽出終了日時 RDateTime
     * @return パラメータ
     */
    public static TsuchishoNoCreateParameter createParam(FlexibleYear 賦課年度,
            FlexibleYear 調定年度,
            RDateTime 抽出開始日時,
            RDateTime 抽出終了日時) {
        return new TsuchishoNoCreateParameter(賦課年度, 調定年度, 抽出開始日時, 抽出終了日時);
    }
}
