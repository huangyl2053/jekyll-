/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.hokenshakyufujissekiout;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 被保険者番号変換対象データの取得パラメータです。
 *
 * @reamsid_L DBC-2460-012 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaKyufujissekiOutGetHihokenshaNoBatchParameter implements IMyBatisParameter {

    private FlexibleDate 年月;

}
