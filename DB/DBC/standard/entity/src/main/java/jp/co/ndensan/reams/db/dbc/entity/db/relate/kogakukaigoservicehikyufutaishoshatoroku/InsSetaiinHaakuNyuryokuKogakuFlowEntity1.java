/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 給付実績基本抽出02のデータを抽出するのエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsSetaiinHaakuNyuryokuKogakuFlowEntity1 {

    private FlexibleYearMonth 最古のサービス提供年月;
    private FlexibleYearMonth 最新のサービス提供年月;
}
