/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 予備判定記入の情報です。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanteiJohoEntity {

    private int shinsakaiOrder;
    private RString shichosonMeisho;
    private Code shinseijiKubunCode;
    private RString hihokenshaKubunCode;
    private RString hihokenshaNo;
    private RString shoKisaiHokenshaNo;
    private AtenaMeisho hihokenshaName;
    private Code seibetsu;
    private int age;
    private Code nigoTokuteiShippeiCode;
    private Code yokaigoJotaiKubunCode;
    private int hanteiNinteiYukoKikan;
    private Code ichijiHanteiKekkaCode;
    private RString ichijiHnateiKeikokuCode;
}
