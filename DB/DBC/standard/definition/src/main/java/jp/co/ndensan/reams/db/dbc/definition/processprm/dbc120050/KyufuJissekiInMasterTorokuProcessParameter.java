/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120050;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 給付更新結果情報取込・マスタ登録のプロセスパラメターです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiInMasterTorokuProcessParameter implements IBatchProcessParameter {

    private Long 番号;

    private FlexibleYearMonth 処理年月;

}
