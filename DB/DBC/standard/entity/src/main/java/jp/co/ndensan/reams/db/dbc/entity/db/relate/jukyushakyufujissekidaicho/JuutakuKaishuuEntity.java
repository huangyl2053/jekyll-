/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳の住宅改修Entityクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JuutakuKaishuuEntity {

    private RString 入力識別番号;
    private RString 被保険者番号;
    private RString サービス提供年月;
    private RString 事業所番号;
    private RString 通し番号;
    private RString 明細番号;
    private RString サービスコード;
    private RString 住宅改修着工年月日;
    private RString 改修金額;
    private RString 審査年月;
    private RString 住宅改修事業者名;
    private RString 住宅改修住宅住所;

}
