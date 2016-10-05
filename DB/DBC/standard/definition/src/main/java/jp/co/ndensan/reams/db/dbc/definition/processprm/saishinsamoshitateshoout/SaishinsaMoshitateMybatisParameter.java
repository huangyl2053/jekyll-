/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 送付対象データ取得パラメータです。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaMoshitateMybatisParameter implements IMyBatisParameter {

    private RString 再処理区分;
    private FlexibleYearMonth 処理年月;
    private RString 保険者番号;

}
