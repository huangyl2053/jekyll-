/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.shunojoho;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 収納情報【共有子Div】のresultクラスです。
 *
 * @reamsid_L DBB-5710-010 xuxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJohoResult {

    private int 期;
    private Decimal 調定ID;
    private Decimal 調定額;
    private Decimal 収入額;
    private RDate 収入日;
    private RDate 領収日;
    private Decimal 督促手数料;
    private Decimal 延滞金;
    private RDate 調定日;
    private RDate 納期限;
}
