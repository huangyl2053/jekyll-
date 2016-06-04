/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会集計表（申請区分別）情報の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiShukeihyoGenzaiEntity {

    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private int shinseiKubun;
    private int yukoKikan;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private int countHihokenshaNo;

}
