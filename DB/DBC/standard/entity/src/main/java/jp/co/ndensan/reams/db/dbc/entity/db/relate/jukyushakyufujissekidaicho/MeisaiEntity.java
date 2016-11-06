/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者給付実績台帳の明細Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MeisaiEntity {

    private RString 入力識別番号;
    private RString 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 事業所番号;
    private RString 通し番号;
    private RString サービス種類コード;
    private RString サービス項目コード;
    private RString サービス内容;
    private Decimal 単位数;
    private Decimal 後単位数;
    private RString 単位数識別;
    private Integer 日数回数;
    private Integer 後日数回数;
    private Decimal サービス単位数;
    private Decimal 後サービス単位数;
    private Integer 公費１対象日数回数;
    private Integer 後公費１対象日数回数;
    private Decimal 公費１対象サービス点数;
    private Decimal 後公費１対象サービス点数;
    private Integer 公費２対象日数回数;
    private Integer 後公費２対象日数回数;
    private Decimal 公費２対象サービス点数;
    private Decimal 後公費２対象サービス点数;
    private Integer 公費３対象日数回数;
    private Integer 後公費３対象日数回数;
    private Decimal 公費３対象サービス点数;
    private Decimal 後公費３対象サービス点数;
    private RString 摘要;
    private Integer 再審査回数;
    private Integer 過誤回数;
    private FlexibleYearMonth 審査年月;

}
