/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110090;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費過誤申立書作成の送付ファイル作成Processパラメータです。
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigokyufuhiKagoMoshitateshoSoufuFairuSakuseiProcessParameter implements IBatchProcessParameter {

    private HokenshaNo 保険者番号;
    private RString コード;
    private FlexibleYearMonth 処理年月;
    private int 件数;

}
