/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(トリガデータTempデータ取得引数パラメーター)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TorigaDataTempMybatisParameter implements IMyBatisParameter {

    private HihokenshaNo 被保険者番号;
    private FlexibleYear 年度;
    private FlexibleYearMonth 年月;

}
