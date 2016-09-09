/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.iryohikojokakuninsinsei;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 受給者台帳情報
 *
 * @reamsid_L DBD-5770-030 tz_chengpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogoJigyouTaisyouSyaJyohoJoho {

    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private FlexibleDate 主治医意見書受領年月日;
}
