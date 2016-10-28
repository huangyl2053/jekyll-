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
 * 受給者給付実績台帳の集計Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShuukeiEntity {

    private RString 入力識別番号;
    private RString 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 事業所番号;
    private RString 通し番号;
    private RString サービス種類コード;
    private RString サービス種類名称1;
    private RString サービス種類名称2;
    private Integer サービス実日数;
    private Decimal 計画単位数;
    private Decimal 限度額管理対象単位数;
    private Decimal 限度額管理対象外単位数;
    private Decimal 請求点数合計;
    private Decimal 後点数合計;
    private Decimal 後請求点数単価;
    private Decimal 請求額;
    private Decimal 後保険請求分請求額;
    private Decimal 利用者負担額;
    private Decimal 出来高点数合計;
    private Decimal 後出来高点数合計;
    private Decimal 出来高請求額;
    private Decimal 後出来高請求額;
    private Decimal 出来高医療費利用者負担額;
    private Decimal 公費１点数合計;
    private Decimal 後公費１点数合計;
    private Decimal 公費１請求額;
    private Decimal 後公費１請求額;
    private Decimal 公費１公費分本人負担額;
    private Decimal 公費１出来高点数合計;
    private Decimal 後公費１出来高点数合計;
    private Decimal 公費１出来高請求額;
    private Decimal 後公費１出来高請求額;
    private Decimal 公費２点数合計;
    private Decimal 後公費２点数合計;
    private Decimal 公費２請求額;
    private Decimal 後公費２請求額;
    private Decimal 公費２公費分本人負担額;
    private Decimal 公費２出来高点数合計;
    private Decimal 後公費２出来高点数合計;
    private Decimal 公費２出来高請求額;
    private Decimal 後公費２出来高請求額;
    private Decimal 公費３点数合計;
    private Decimal 後公費３点数合計;
    private Decimal 公費３請求額;
    private Decimal 後公費３請求額;
    private Decimal 公費３公費分本人負担額;
    private Decimal 公費３出来高点数合計;
    private Decimal 後公費３出来高点数合計;
    private Decimal 公費３出来高請求額;
    private Decimal 後公費３出来高請求額;
    private Integer 再審査回数;
    private Integer 過誤回数;
    private FlexibleYearMonth 審査年月;

}
