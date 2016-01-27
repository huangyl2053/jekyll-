/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppo;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 
 */
@Getter
@Setter
public class JigyoHokokuGeppoEntity {

    private FlexibleYear hokokuYSeireki;
    private RString hokokuM;
    private FlexibleYear shukeiTaishoYSeireki;
    private RString shukeiTaishoM;
    private RString toukeiTaishoKubun;
    private LasdecCode shichosonCode;
    private Code hyoNo;
    private Code shukeiNo;
    private Code shukeiTani;
    private Decimal tateNo;
    private Decimal yokoNo;
    private Decimal shukeiKekkaAtai;
    private RString shukeiKomokuMeisho;
    private Code tateKomokuCode;
    private Code yokoKomokuCode;
    private LasdecCode toukeiTaishoCode;
    private TextBoxFlexibleDate txtHokokuYM;
    private TextBoxFlexibleDate txtShukeiTaishoYM;
    private RString shichosonName;
    private RString hokenShaCode;

}
