/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00004;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.taishoshaichijitokutei.TaishoshaIchijiTokuteiParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人軽減認定者リスト作成のバッチProcess用パラメータクラスです
 *
 * @reamsid_L DBD-3830-030 tianyh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TaishoshaIchijiTokuteiProcessParameter implements IBatchProcessParameter {

    private RString 対象リスト;
    private RString 対象期間指定;
    private FlexibleDate 対象年度の開始年月日;
    private FlexibleDate 対象年度の終了年月日;
    private RString 旧措置者区分;
    private FlexibleDate 基準日;
    private FlexibleDate 課税判定等基準日;
    private RString 受給者区分;
    private RString 抽出対象;

    /**
     * パラメターを返却します．
     *
     * @param 対象リスト
     * @param 対象期間指定
     * @param 対象年度の開始年月日
     * @param 対象年度の終了年月日
     * @param 旧措置者区分
     * @param 基準日
     * @param 課税判定等基準日
     * @param 受給者区分
     * @param 抽出対象
     */
    public TaishoshaIchijiTokuteiProcessParameter(
            RString 対象リスト,
            RString 対象期間指定,
            FlexibleDate 対象年度の開始年月日,
            FlexibleDate 対象年度の終了年月日,
            RString 旧措置者区分,
            FlexibleDate 基準日,
            FlexibleDate 課税判定等基準日,
            RString 受給者区分,
            RString 抽出対象) {
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

    /**
     * 負担限度額認定更新のお知らせ通知書が発行可能である場合、介護負担限度額認定の情報を取得する。
     *
     * @return TaishoshaIchijiTokuteiParameter
     */
    public TaishoshaIchijiTokuteiParameter toTaishoshaIchijiTokuteiParameter() {
        int 対象リスト1 = Integer.parseInt(対象リスト.toString());
        int 対象期間指定1 = Integer.parseInt(対象期間指定.toString());
        int 旧措置者区分1 = Integer.parseInt(旧措置者区分.toString());
        int 受給者区分1 = Integer.parseInt(受給者区分.toString());
        int 抽出対象1 = Integer.parseInt(抽出対象.toString());

        return new TaishoshaIchijiTokuteiParameter(
                対象リスト1,
                対象期間指定1,
                対象年度の開始年月日,
                対象年度の終了年月日,
                旧措置者区分1,
                基準日,
                課税判定等基準日,
                受給者区分1,
                抽出対象1
        );
    }

}
