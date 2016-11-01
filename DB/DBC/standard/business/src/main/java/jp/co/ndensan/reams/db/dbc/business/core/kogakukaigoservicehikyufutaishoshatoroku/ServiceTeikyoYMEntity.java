/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakukaigoservicehikyufutaishoshatoroku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;
import lombok.Setter;

/**
 * サービス提供年月クラスです。
 *
 * @reamsid_L DBC-2010-070 tianshuai
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceTeikyoYMEntity implements Serializable {

    private FlexibleYearMonth 最古のサービス提供年月;
    private FlexibleYearMonth 最新のサービス提供年月;
}
