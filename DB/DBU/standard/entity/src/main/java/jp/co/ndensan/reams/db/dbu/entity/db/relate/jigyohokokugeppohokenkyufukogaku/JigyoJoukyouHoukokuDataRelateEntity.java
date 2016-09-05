/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogaku;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業状況報告統計情報のRelateEntityクラスです。
 *
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class JigyoJoukyouHoukokuDataRelateEntity {

    private RString syukeiYM;
    private LasdecCode shichosonCode;
    private RString toukeiTaishoKubun;
    private Code hyoNo;
    private Code syukeiNo;
    private Code syukeiTani;
    private Decimal tateNo;
    private Decimal yokoNo;
    private Decimal sukeiKekkaAtai;
    private Code tateKomokuCode;
    private Code yokoKomokuCode;
}
