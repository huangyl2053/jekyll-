/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.divcontroller.viewbox;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import lombok.Getter;

/**
 *
 */
@Getter
public class JigyoHokokuGeppoHoseiHako implements Serializable {

    private final FlexibleYear hokokuYSeireki;
    private final RString hokokuM;
    private final FlexibleYear shukeiTaishoYSeireki;
    private final RString shukeiTaishoM;
    private final RString toukeiTaishoKubun;
    private final LasdecCode shichosonCode;
    private final Code hyoNo;
    private final Code shukeiNo;
    private final RString hdnYoshikiCode;
    private final TextBoxFlexibleDate txtHokokuYM;
    private final TextBoxFlexibleDate txtShukeiTaishoYM;
    private final RString shichosonName;
    private final RString hokenShaCode;
    

    public JigyoHokokuGeppoHoseiHako(FlexibleYear hokokuYSeireki, RString hokokuM, FlexibleYear shukeiTaishoYSeireki,
            RString shukeiTaishoM, RString toukeiTaishoKubun, LasdecCode shichosonCode, Code hyoNo, Code shukeiNo,
            TextBoxFlexibleDate txtHokokuYM, TextBoxFlexibleDate txtShukeiTaishoYM, RString shichosonName, RString hokenShaCode, RString hdnYoshikiCode) {
        this.hokokuYSeireki = hokokuYSeireki;
        this.hokokuM = hokokuM;
        this.shukeiTaishoYSeireki = shukeiTaishoYSeireki;
        this.shukeiTaishoM = shukeiTaishoM;
        this.toukeiTaishoKubun = toukeiTaishoKubun;
        this.shichosonCode = shichosonCode;
        this.hyoNo = hyoNo;
        this.shukeiNo = shukeiNo;
        this.txtHokokuYM = txtHokokuYM;
        this.txtShukeiTaishoYM = txtShukeiTaishoYM;
        this.shichosonName = shichosonName;
        this.hokenShaCode = hokenShaCode;
        this.hdnYoshikiCode = hdnYoshikiCode;
    }

}
