/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.taishoshaichijitokutei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人軽減認定者リスト作成のパラメータ
 *
 * @reamsid_LDBD-3830-040 tianyh
 */
@Getter
@Setter
public final class TaishoshaIchijiTokuteiParameter implements IMyBatisParameter {

    private int 対象リスト;
    private int 対象期間指定;
    private FlexibleDate 対象年度の開始年月日;
    private FlexibleDate 対象年度の終了年月日;
    private int 旧措置者区分;
    private FlexibleDate 基準日;
    private FlexibleDate 課税判定等基準日;
    private int 受給者区分;
    private int 抽出対象;

    /**
     * コンストラクタです。
     *
     * @param 対象リスト 対象リスト
     * @param 対象期間指定 対象期間指定
     * @param 対象年度の開始年月日 対象年度の開始年月日
     * @param 対象年度の終了年月日 対象年度の終了年月日
     * *@param 対象リスト 対象リスト
     * @param 旧措置者区分 旧措置者区分
     * @param 基準日 基準日
     * @param 課税判定等基準日 課税判定等基準日
     * @param 受給者区分
     * @param 抽出対象
     */
    public TaishoshaIchijiTokuteiParameter(
            int 対象リスト,
            int 対象期間指定,
            FlexibleDate 対象年度の開始年月日,
            FlexibleDate 対象年度の終了年月日,
            int 旧措置者区分,
            FlexibleDate 基準日,
            FlexibleDate 課税判定等基準日,
            int 受給者区分,
            int 抽出対象) {
        this.対象リスト = 対象リスト;
        this.対象期間指定 = 対象期間指定;
        this.対象年度の開始年月日 = 対象年度の開始年月日;
        this.対象年度の終了年月日 = 対象年度の終了年月日;
        this.旧措置者区分 = 旧措置者区分;
        this.基準日 = 基準日;
        this.課税判定等基準日 = 課税判定等基準日;
        this.受給者区分 = 受給者区分;
        this.抽出対象 = 抽出対象;
    }

}
