/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshoirai;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査の情報Entityクラスです。
 *
 * @reamsid_L DBE-0200-030 zhangzhiming
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiIkenshoIraiEntity {

    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiCode;
    private FlexibleDate torisageYMD;
    private FlexibleDate nijiHanteiYMD;
    private Code nijiHanteiYokaigoJotaiCode;
    private int nijiHanteiNinteiYukoKikan;
    private RString shujiiIryokikanCode;
    private RString iryoKikanMeisho;
    private RString shujiiCode;
    private AtenaMeisho shujiiName;
    private FlexibleDate ikenshoJuryoYMD;
    private FlexibleDate ikenshoKinyuYMD;
    private RString ikenshoIraiKubun;
}
