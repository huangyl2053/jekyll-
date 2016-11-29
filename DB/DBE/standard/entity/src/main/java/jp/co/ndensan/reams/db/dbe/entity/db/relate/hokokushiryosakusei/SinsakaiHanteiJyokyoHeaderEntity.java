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
 * 介護認定審査会判定状況表情報のヘッダ情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SinsakaiHanteiJyokyoHeaderEntity {

    private int gogitaiNo;
    private RString gogitaiMei;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private RString shoKisaiHokenshaNo;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code ninteiShinseiHoreiKubunCode;
    private RString shinsakaiKaisaiYMDMin;
    private RString shinsakaiKaisaiYMDMax;
    private int shinsakaiKaisaiNoCount;
}
