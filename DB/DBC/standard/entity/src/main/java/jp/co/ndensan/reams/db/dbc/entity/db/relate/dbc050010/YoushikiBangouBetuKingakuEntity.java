/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 振込明細様式番号別支給金額集計のentityです。
 * @reamsid_L DBC-2180-070 x_liuwei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YoushikiBangouBetuKingakuEntity {

    private RString 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 整理番号;
    private RString 様式番号;
    private Decimal 支給金額計;
    private Decimal 差額金額計;
}
