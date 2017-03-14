/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報RelateEntityクラスです。
 *
 * @reamsid_L DBE-0220-010 wangkun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YouKaiGoNinTeiKekTesuChiRelateEntity {

    private RString shujiiIryokikanCode;
    private RString iryoKikanMeisho;
    private RString yubinNo;
    private RString telNo;
    private RString jusho;
    private RString shujiiCode;
    private RString shujiiName;
    private int taiSyouCount;
    private int renNo;
    private RString hihokenshaNo;
    private RString hihokenshaName;
    private RString seibetsu;
    private RString seinengappiYMD;
    private int age;
    private RString ninteiShinseiYMD;
    private RString ninteiShinseiShinseijiKubunCod;
    private RString ninteiShinseiHoreiKubunCode;
    private RString koroshoIfShikibetsuCode;
    private RString nijiHanteiYokaigoJotaiKubunCod;
    private RString nijiHanteiNinteiYukoKikan;
    private RString nijiHanteiNinteiYukoKaishiYMD;
    private RString nijiHanteiNinteiYukoShuryoYMD;
    private RString nijiHanteiYMD;
    private RString ninteiJohoTeikyoYMD;
    private boolean ninteiJohoTeikyoKiboFlag;
    private RString shinseishoKanriNo;
    private RString shichosonMeisho;
    private RString shinsakaiIken;
    private RString ikenshoIraiRirekiNo;
    private RString shichosonCode;
    private RString shoKisaiHokenshaNo;
}
