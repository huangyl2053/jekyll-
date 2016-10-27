/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業報告資料情報のRelateEntityクラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class JigyoHokokuShiryouRelateEntity {

    private RString syukeiYM;
    private RString shichosonCode;
    private RString toukeiTaishoKubun;
    private RString hyoNo;
    private RString syukeiNo;
    private RString syukeiTani;
    private RString tateNo;
    private RString yokoNo;
    private Decimal syukeiKekkaAtai;
    private RString tateKomokuCode;
    private RString yokoKomokuCode;
}
