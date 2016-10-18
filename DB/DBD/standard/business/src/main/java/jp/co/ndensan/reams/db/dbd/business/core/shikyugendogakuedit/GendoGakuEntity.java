/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shikyugendogakuedit;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 限度額Entityクラスです。
 *
 * @reamsid_L DBD-3000-010 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GendoGakuEntity {

    private Code 要介護区分;
    private FlexibleYearMonth 適用開始年月;
    private FlexibleYearMonth 適用終了年月;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private RString 認定期間月数;
    private RString 拡大倍数;

}
