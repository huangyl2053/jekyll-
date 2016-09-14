/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.ippanshokanketteiym;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業状況報告統計情報のRelateEntityクラスです。
 *
 * @reamsid_L DBU-5550-030 suguangjun
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class JigyouHoukokuTokTyhyouRelateEntity {

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
