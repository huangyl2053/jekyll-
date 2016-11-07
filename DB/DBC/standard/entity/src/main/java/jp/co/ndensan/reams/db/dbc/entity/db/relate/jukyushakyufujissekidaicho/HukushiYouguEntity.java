/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳の福祉用具Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HukushiYouguEntity {

    private RString 入力識別番号;
    private RString 被保険者番号;
    private RString サービス提供年月;
    private RString 事業所番号;
    private RString 通し番号;
    private RString 明細番号;
    private RString サービスコード;
    private RString 福祉用具購入年月日;
    private RString 摘要;
    private RString 審査年月;
    private RString 福祉用具商品名;
    private RString 福祉用具製造事業者名;
    private RString 福祉用具販売事業者名;
    private RString 福祉用具種目コード;
    private RString 購入金額;

}
