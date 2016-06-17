/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共有子Div「居宅計画」の自己作成計画情報Entityです。
 *
 * @reamsid_L DBD-3560-080 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JikoSakuseiKeikakuJohoEntity {

    private FlexibleYearMonth 対象年月;
    private FlexibleDate 計画作成年月日;
    private FlexibleDate 届出年月日;
    private FlexibleDate 適用開始年月日;
    private FlexibleDate 適用終了年月日;
    private RString 暫定区分;
}
