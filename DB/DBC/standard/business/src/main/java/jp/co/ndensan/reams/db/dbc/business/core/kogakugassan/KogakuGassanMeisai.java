/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakugassan;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算明細のクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KogakuGassanMeisai {

    private RString 対象月;
    private Decimal 自己負担額;
    private Decimal 単70_74自己負担額_内数;
    private RString 摘要;

}
