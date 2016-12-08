/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoJyokyoHokokuEntity {

    private FlexibleYearMonth nijiHanteiYM;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private RString shoKisaiHokenshaNo;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private RString hihokenshaKubunCode;
    private int countHokensha;
    private boolean allshichoson;

}
