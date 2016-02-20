/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.divcontroller.viewbox;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoHokokuGeppoParameter implements Serializable {

    private RString 行報告年;
    private RString 行報告月;
    private RString 行集計対象年;
    private RString 行集計対象月;
    private RString 行統計対象区分;
    private RString 行市町村コード;
    private RString 行表番号;
    private RString 行集計番号;
    private RString 行様式種類コード;
    private RString 報告年月;
    private RString 集計年月;
    private RString 市町村名称;
    private RString 保険者コード;
    private RString 選択した市町村コード;
    
//    private final FlexibleYear hokokuYSeireki;
//    private final RString hokokuM;
//    private final FlexibleYear shukeiTaishoYSeireki;
//    private final RString shukeiTaishoM;
//    private final RString toukeiTaishoKubun;
//    private final LasdecCode shichosonCode;
//    private final Code hyoNo;
//    private final Code shukeiNo;
//    private final RString hdnYoshikiCode;
//    private final TextBoxFlexibleDate txtHokokuYM;
//    private final TextBoxFlexibleDate txtShukeiTaishoYM;
//    private final RString shichosonName;
//    private final RString hokenShaCode;
    

//    public JigyoHokokuGeppoParameter(FlexibleYear hokokuYSeireki, RString hokokuM, FlexibleYear shukeiTaishoYSeireki,
//            RString shukeiTaishoM, RString toukeiTaishoKubun, LasdecCode shichosonCode, Code hyoNo, Code shukeiNo,
//            TextBoxFlexibleDate txtHokokuYM, TextBoxFlexibleDate txtShukeiTaishoYM, RString shichosonName, RString hokenShaCode, RString hdnYoshikiCode) {
//        this.hokokuYSeireki = hokokuYSeireki;
//        this.hokokuM = hokokuM;
//        this.shukeiTaishoYSeireki = shukeiTaishoYSeireki;
//        this.shukeiTaishoM = shukeiTaishoM;
//        this.toukeiTaishoKubun = toukeiTaishoKubun;
//        this.shichosonCode = shichosonCode;
//        this.hyoNo = hyoNo;
//        this.shukeiNo = shukeiNo;
//        this.txtHokokuYM = txtHokokuYM;
//        this.txtShukeiTaishoYM = txtShukeiTaishoYM;
//        this.shichosonName = shichosonName;
//        this.hokenShaCode = hokenShaCode;
//        this.hdnYoshikiCode = hdnYoshikiCode;
//    }

}
