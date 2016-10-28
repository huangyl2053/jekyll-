/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳の社会福祉法人軽減額Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaiHukushiHouzinKeigenEntity {

    private RString 入力識別番号;
    private RString 被保険者番号;
    private RString サービス提供年月;
    private RString 事業所番号;
    private RString 通し番号;
    private RString サービス種類コード;
    private RString 軽減率;
    private RString 受領すべき利用者負担の総額;
    private RString 軽減額;
    private RString 軽減後利用者負担額;
    private RString 備考;
    private RString 後受領すべき利用者負担の総額;
    private RString 後軽減額;
    private RString 後軽減後利用者負担額;
    private RString 再審査回数;
    private RString 過誤回数;
    private RString 審査年月;

}
