/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd511002;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 認定更新お知らせ通知書発行_SQLパラメータクラスです。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoshinOshiraseTsuchiMyBatisParameter implements IMyBatisParameter {

    private final List<RString> 申請書管理番号リスト;
    private final RString 出力対象区分;
    private final FlexibleDate 抽出対象期間_開始;
    private final FlexibleDate 抽出対象期間_終了;
    private final FlexibleDate 通知書発行日;
    private final RString 出力順;

    /**
     *
     * @param 申請書管理番号リスト 申請書管理番号リスト
     * @param 出力対象区分 出力対象区分
     * @param 抽出対象期間_開始 抽出対象期間_開始
     * @param 抽出対象期間_終了 抽出対象期間_終了
     * @param 通知書発行日 通知書発行日
     * @param 出力順 出力順
     */
    public KoshinOshiraseTsuchiMyBatisParameter(List<RString> 申請書管理番号リスト, RString 出力対象区分,
            FlexibleDate 抽出対象期間_開始, FlexibleDate 抽出対象期間_終了,
            FlexibleDate 通知書発行日, RString 出力順) {
        this.申請書管理番号リスト = 申請書管理番号リスト;
        this.出力対象区分 = 出力対象区分;
        this.抽出対象期間_開始 = 抽出対象期間_開始;
        this.抽出対象期間_終了 = 抽出対象期間_終了;
        this.通知書発行日 = 通知書発行日;
        this.出力順 = 出力順;

    }

}
