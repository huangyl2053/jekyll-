/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
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
    private RString ninteiShinseiShinseijiKubunCode;
    private RString ninteiShinseiHoreiKubunCode;
    private RString nijiHanteiYokaigoJotaiKubunCode;
    private RString nijiHanteiNinteiYukoKikan;
    private RString nijiHanteiNinteiYukoKaishiYMD;
    private RString nijiHanteiNinteiYukoShuryoYMD;
    private RString nijiHanteiYMD;
    private RString ninteiJohoTeikyoYMD;
    private RString shinseishoKanriNo;
    private RString shichosonMeisho;
    private RString shinsakaiIken;
    private RString ikenshoIraiRirekiNo;
}
