/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteishinchokujohoshokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 申請者一覧内容検索情報RelateEntityクラスです。
 *
 * @reamsid_L DBE-0210-010 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiShinchokuJohoShokaiRelateEntity {

    private RString shichosonMeisho;
    private ShinseishoKanriNo hihokenshaNo;
    private RString hihokenshaName;
    private RString hihokenshaKubunCode;
    private FlexibleDate ninteiShinseiYMD;
    private RString ninteiShinShinseijiKubunCode;
    private RString tokki;
    private RString yubinNo;
    private RString jusho;
    private RString seibetsu;
    private FlexibleDate seinengappiYMD;
    private int age;
    private FlexibleDate ninteichosaIraiKanryoYMD;
    private FlexibleDate ninteichosaKanryoYMD;
    private FlexibleDate ikenshoSakuseiIraiKanryoYMD;
    private FlexibleDate ikenshoTorokuKanryoYMD;
    private FlexibleDate ichijiHanteiKanryoYMD;
    private FlexibleDate maskingKanryoYMD;
    private FlexibleDate ninteiShinsaWariateKanryoYMD;
    private FlexibleDate ninteiShinsakaiKanryoYMD;
    private FlexibleDate ninteichosaIraiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
    private FlexibleDate ikenshoSakuseiIraiYMD;
    private FlexibleDate ikenshoJuryoYMD;
    private RString iryoKikanMeisho;
    private RString shujiiName;
    private FlexibleDate ichijiHanteiYMD;
    private RString ichijiHanteiKekkaCode;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private FlexibleDate shinsakaiShiryoSakuseiYMD;
    private FlexibleDate shinsakaiKaisaiYMD;
    private RString shinsakaiKaisaiNo;
    private int gogitaiNo;
    private RString gogitaiMei;
    private RString nijiHanYokaigoJotaiKubunCode;
    private RString shinseishoKanriNo;
    private int ninteichosaIraiRirekiNo;
}
