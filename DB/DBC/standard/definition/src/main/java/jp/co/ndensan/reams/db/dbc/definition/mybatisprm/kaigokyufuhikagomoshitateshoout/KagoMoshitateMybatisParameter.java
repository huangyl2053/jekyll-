/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigokyufuhikagomoshitateshoout;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 送付対象データ取得のMybatisパラメータです。
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoMoshitateMybatisParameter implements IMyBatisParameter {

    private RString 再処理区分;
    private RString 送付対象情報;
    private FlexibleYearMonth 処理年月;
    private RString 申立書区分コード;

}
