/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別地域加算減免情報Entity
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChiikiKasanGenmenJohoEntity {

    private RString 特別地域加算減免区分;
    private RString 明細番号;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private FlexibleDate 適用年月日;
    private FlexibleDate 有効期限;
    private RString 減額率;
    private RString 確認番号;
}
