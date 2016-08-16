/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付管理票一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT1121KyufuKanrihyoTempEntity {

    private int 連番;
    private RString 交換情報識別番号;
    private FlexibleYearMonth 審査年月;
    private FlexibleYearMonth サービス提供年月;
    private RString 給付管理票種別区分コード;
    private RString 給付管理票明細行番号;
    private RString 居宅支援事業所番号;
    private RString 給付管理票情報作成区分コード;
    private FlexibleDate 給付管理票作成年月日;
    private RString 保険者番号;
    private FlexibleDate 被保険者生年月日;
    private RString 性別コード;
    private RString 要介護状態区分コード;
    private FlexibleYearMonth 限度額適用開始年月;
    private FlexibleYearMonth 限度額適用終了年月;
    private Decimal 居宅_介護予防支給限度額;
    private RString 居宅サービス計画作成区分コード;
    private RString サービス事業所番号;
    private RString 指定_基準該当_地域密着型サービス識別コード;
    private RString サービス種類コード;
    private Decimal 給付計画単位数_日数;
    private Decimal 限度額管理期間における前月までの給付計画日数;
    private Decimal 指定サービス分小計;
    private Decimal 基準該当サービス分小計;
    private Decimal 給付計画合計単位数_日数;
    private RString 担当介護支援専門員番号;
    private RString 委託先の居宅介護支援事業所番号;
    private RString 委託先の担当介護支援専門員番号;
    private FlexibleDate 当初登録年月日;
    private FlexibleYearMonth 取込年月;
    private RString コントロールレコード保険者番号;
    private RString コントロールレコード保険者名;
    private RString 事業者名称;

}
