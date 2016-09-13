/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd511002;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd511002.NinshiuUpdateProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者台帳異動チェックリストのバッチパラメータクラスです。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinshiuUpdateMyBatisParameter extends BatchParameterBase {

    private final List<RString> 申請書管理番号リスト;
    private final RString 出力対象区分;
    private final FlexibleDate 抽出対象期間_開始;
    private final FlexibleDate 抽出対象期間_終了;
    private final FlexibleDate 通知書発行日;
    private final RString 出力順;

    public NinshiuUpdateMyBatisParameter(List<RString> 申請書管理番号リスト, RString 出力対象区分,
            FlexibleDate 抽出対象期間_開始, FlexibleDate 抽出対象期間_終了,
            FlexibleDate 通知書発行日, RString 出力順) {
        this.申請書管理番号リスト = 申請書管理番号リスト;
        this.出力対象区分 = 出力対象区分;
        this.抽出対象期間_開始 = 抽出対象期間_開始;
        this.抽出対象期間_終了 = 抽出対象期間_終了;
        this.通知書発行日 = 通知書発行日;
        this.出力順 = 出力順;

    }

    /**
     *
     * @return KoshinTaishoshaKanriProcessParameter
     */
    public NinshiuUpdateProcessParameter toNinshiuUpdateProcessParameter() {
        return new NinshiuUpdateProcessParameter(申請書管理番号リスト,
                出力対象区分,
                抽出対象期間_開始,
                抽出対象期間_終了,
                通知書発行日,
                出力順);
    }

}
