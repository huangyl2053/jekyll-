/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufukanrihyosokatsuhyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付管理票総括票のパラメータクラスです。
 *
 * @reamsid_L DBC-2840-042 kanghongsong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuKanrihyoSokatsuhyo {

    private FlexibleYearMonth 処理年月;
    private RString 保険者番号;
    private RString 給付管理票タイトル;
    private Decimal 他県分_訪問_新規分_枚数;
    private Decimal 他県分_訪問_新規分_件数;
    private Decimal 他県分_訪問_修正分_枚数;
    private Decimal 他県分_訪問_修正分_件数;
    private Decimal 他県分_訪問_取消分_枚数;
    private Decimal 他県分_訪問_取消分_件数;
    private Decimal 他県分_短期_新規分_枚数;
    private Decimal 他県分_短期_新規分_件数;
    private Decimal 他県分_短期_修正分_枚数;
    private Decimal 他県分_短期_修正分_件数;
    private Decimal 他県分_短期_取消分_枚数;
    private Decimal 他県分_短期_取消分_件数;
    private Decimal 自県分_訪問_新規分_枚数;
    private Decimal 自県分_訪問_新規分_件数;
    private Decimal 自県分_訪問_修正分_枚数;
    private Decimal 自県分_訪問_修正分_件数;
    private Decimal 自県分_訪問_取消分_枚数;
    private Decimal 自県分_訪問_取消分_件数;
    private Decimal 自県分_短期_新規分_枚数;
    private Decimal 自県分_短期_新規分_件数;
    private Decimal 自県分_短期_修正分_枚数;
    private Decimal 自県分_短期_修正分_件数;
    private Decimal 自県分_短期_取消分_枚数;
    private Decimal 自県分_短期_取消分_件数;

}
