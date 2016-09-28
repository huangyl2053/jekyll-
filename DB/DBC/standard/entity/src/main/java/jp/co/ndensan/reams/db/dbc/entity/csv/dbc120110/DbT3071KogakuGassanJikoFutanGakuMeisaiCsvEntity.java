/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算自己負担額明細TBL
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private HokenshaNo 保険者番号;
    private RString 支給申請書整理番号;
    private int 履歴番号;
    private RString 対象月;
    private Decimal 自己負担額;
    private Decimal 自己負担額_内数70_74;
    private Decimal 未満70高額支給額;
    private Decimal 高額支給額70_74;
    private RString 摘要;
    private Decimal 補正済_自己負担額;
    private Decimal 補正済_70_74自己負担額_内数_;
    private Decimal 補正済_70未満高額支給額;
    private Decimal 補正済_70_74高額支給額;
    private RString 補正済_摘要;

}
