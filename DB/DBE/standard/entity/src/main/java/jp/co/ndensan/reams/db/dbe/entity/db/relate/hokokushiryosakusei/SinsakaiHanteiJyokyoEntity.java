/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei;

import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 介護認定審査会判定状況表情報の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SinsakaiHanteiJyokyoEntity {

    private Code ichijiHanteiKekkaNinchishoKasanCode;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code ninteiShinseiHoreiKubunCode;
    private int hihokenshaCount;

}
