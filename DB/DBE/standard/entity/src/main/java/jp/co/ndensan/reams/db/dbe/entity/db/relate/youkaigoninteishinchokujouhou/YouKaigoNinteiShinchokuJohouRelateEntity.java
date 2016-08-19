/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteishinchokujouhou;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定進捗情報データ出力のRelateEntityです。
 *
 * @reamsid_L DBE-1500-010 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YouKaigoNinteiShinchokuJohouRelateEntity {

    private RString hihokenshaNo;
    private RString hihokenshaName;
    private RString seibetsu;
    private RString seinengappiYMD;
    private RString ninteiShinseiYMD;
    private RString ninteiShinseiShinseijiKubunCode;
    private RString ninteiShinseiHoreiKubunCode;
    private RString koroshoIfShikibetsuCode;
    private RString shinseishoKanriNo;
    private RString ninteichosaIraiYMD;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
    private RString ninteichosaJisshiYMD;
    private RString ikenshoJuryoYMD;
    private RString nijiHanteiYokaigoJotaiKubunCode;
    private RString ichijiHanteiYMD;
    private RString ichijiHanteiKekkaCode;
    private RString shinsakaiShiryoSakuseiYMD;
    private RString shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaisaiYMD;

}
