/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshikyuketteiin;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給判定結果データの取得のMybatisパラメタてす。
 *
 * @reamsid_L DBC-0980-331 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShikyuMyBatisParameter {

    private FlexibleYearMonth 処理年月;
    private RString 再処理区分;
    private RString 支給不支給区分;
}
