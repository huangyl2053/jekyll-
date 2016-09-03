/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ファイル出力（根拠CSV）_受給者台帳情報CSVEntityクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IppanJokyoJigyouHoukokuTokeiEntity {

    private FlexibleYearMonth shukeiYM;
    private LasdecCode shichosonCode;
    private RString toukeiTaishoKubun;
    private Code hyoNo;
    private Code shukeiNo;
    private Code shukeiTani;
    private Decimal tateNo;
    private Decimal yokoNo;
    private Decimal shukeiKekkaAtai;
    private Code tateKomokuCode;
    private Code yokoKomokuCode;
}
