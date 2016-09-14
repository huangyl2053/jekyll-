/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyokyotakuyobosogojigyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付管理票用Entityクラスです。
 *
 * @reamsid_L DBC-2840-040 sunhaidi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuKanrihyoKyotakuYoboSogoJigyoServiceEntity {

    private RString 更新区分;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 被保険者番号;
    private RString 宛名カナ名称;
    private RString 宛名名称;
    private FlexibleDate 生年月日;
    private RString 性別コード;
    private RString 表示用要介護状態区分コード;
    private FlexibleYearMonth 利用年月;
    private Decimal 表示用支給限度単位数;
    private FlexibleYearMonth 限度額適用期間_開始年月;
    private FlexibleYearMonth 支給限度有効終了年月;
    private RString サービス提供事業者名称;
    private RString サービス提供事業者番号;
    private RString サービス種類コード;
    private Decimal 給付計画単位数;
}
