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
 * 受給者給付実績台帳の特定入所者介護サービス費用Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiServiceHiEntity {

    private RString 入力識別番号;
    private RString 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 事業所番号;
    private RString 通し番号;
    private RString 順次番号;
    private RString サービス種別コード;
    private RString サービス項目コード;
    private RString サービス内容;
    private Decimal 費用単価;
    private Decimal 後費用単価;
    private Decimal 負担限度額;
    private Integer 日数;
    private Integer 後日数;
    private Integer 公費１日数;
    private Integer 後公費１日数;
    private Integer 公費２日数;
    private Integer 後公費２日数;
    private Integer 公費３日数;
    private Integer 後公費３日数;
    private Decimal 費用額;
    private Decimal 後費用額;
    private Decimal 保険分請求額;
    private Decimal 後保険分請求額;
    private Decimal 公費１負担額明細;
    private Decimal 後公費１負担額明細;
    private Decimal 公費２負担額明細;
    private Decimal 後公費２負担額明細;
    private Decimal 公費３負担額明細;
    private Decimal 後公費３負担額明細;
    private Decimal 利用者負担額;
    private Decimal 後利用者負担額;
    private Integer 再審査回数;
    private Integer 過誤回数;
    private FlexibleYearMonth 審査年月;
    private Decimal 費用額合計;
    private Decimal 後費用額合計;
    private Decimal 保険分請求額合計;
    private Decimal 後保険分請求額合計;
    private Decimal 利用者負担額合計;
    private Decimal 後利用者負担額合計;
    private Decimal 公費１負担額合計;
    private Decimal 後公費１負担額合計;
    private Decimal 公費１保険分請求額合計;
    private Decimal 後公費１保険分請求額合計;
    private Decimal 公費１本人負担月額;
    private Decimal 後公費１本人負担月額;
    private Decimal 公費２負担額合計;
    private Decimal 後公費２負担額合計;
    private Decimal 公費２保険分請求額合計;
    private Decimal 後公費２保険分請求額合計;
    private Decimal 公費２本人負担月額;
    private Decimal 後公費２本人負担月額;
    private Decimal 公費３負担額合計;
    private Decimal 後公費３負担額合計;
    private Decimal 公費３保険分請求額合計;
    private Decimal 後公費３保険分請求額合計;
    private Decimal 公費３本人負担月額;
    private Decimal 後公費３本人負担月額;

}
