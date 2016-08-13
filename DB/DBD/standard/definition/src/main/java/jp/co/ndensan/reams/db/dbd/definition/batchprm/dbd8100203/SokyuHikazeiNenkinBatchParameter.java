/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100203;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 遡及非課税年金対象者同定のバッチパラメタークラスです．
 *
 * @reamsid_L DBD-4910-050 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SokyuHikazeiNenkinBatchParameter extends BatchParameterBase {

    private FlexibleYear 処理年度;
    private RString 処理区分;
    private RString 処理月;
    private RString テスト処理;
    private Long 出力順ID1;
    private Long 出力順ID2;
    private Long 出力順ID3;
    private Long 出力順ID4;
}
