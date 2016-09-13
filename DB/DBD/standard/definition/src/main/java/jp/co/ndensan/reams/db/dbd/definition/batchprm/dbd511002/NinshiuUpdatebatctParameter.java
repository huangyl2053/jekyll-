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
 * 障がい者控除対象者認定書リスト_batchパラメータクラスです。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinshiuUpdatebatctParameter extends BatchParameterBase {

    private List<RString> 申請書管理番号リスト;
    private RString 出力対象区分;
    private FlexibleDate 抽出対象期間_開始;
    private FlexibleDate 抽出対象期間_終了;
    private FlexibleDate 通知書発行日;
    private List<RString> 出力順;

    /**
     * 引数作成
     *
     * @return NinshiuUpdateProcessParameter
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
