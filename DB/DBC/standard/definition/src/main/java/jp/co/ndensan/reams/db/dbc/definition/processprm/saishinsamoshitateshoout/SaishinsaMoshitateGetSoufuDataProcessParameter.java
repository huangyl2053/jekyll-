/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsamoshitateshoout;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * SaishinsaMoshitateGetSoufuDataProcessパラメータです。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaMoshitateGetSoufuDataProcessParameter implements IBatchProcessParameter {

    private RString 再処理区分;
    private FlexibleYearMonth 処理年月;
    private List<RString> 送付ファイルエントリ情報List;
    private RString 保険者番号;
    private int レコード件数;

}
