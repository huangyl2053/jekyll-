/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.ippangenbutsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業状況報告統計情報のRelateEntityクラスです。
 *
 * @reamsid_L DBU-5540-030 suguangjun
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class JigyouHoukokuTokeiRelateEntity {

    private RString shukeiNum;
    private RString tateNo;
    private RString yokoNo;
    private Decimal result;
}
