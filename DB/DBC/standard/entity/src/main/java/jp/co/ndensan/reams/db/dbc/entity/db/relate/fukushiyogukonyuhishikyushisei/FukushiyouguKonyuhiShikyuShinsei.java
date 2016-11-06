/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 支給申請一覧取得RelateEntityクラスです。
 *
 * @reamsid_L DBC-1020-040 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class FukushiyouguKonyuhiShikyuShinsei implements Serializable {

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 整理番号;
    private JigyoshaNo 事業者番号;
    private RString 様式番号;
    private RString 明細番号;
    private FlexibleDate 申請年月日;
    private RString 支給_不支給決定区分;
    private FlexibleDate 決定日;
    private RString 商品名;
    private Decimal 保険対象費用額;
}
