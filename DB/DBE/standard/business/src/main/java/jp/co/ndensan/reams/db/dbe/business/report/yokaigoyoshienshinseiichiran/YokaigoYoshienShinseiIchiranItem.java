/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定・要支援認定等申請者一覧表のITEMです。
 *
 * @reamsid_L DBE-1370-020 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoYoshienShinseiIchiranItem {

    private RString title;
    private RString printTimeStamp;
    private RString renban;
    private RString shoKisaiHokenshaNo;
    private RString shichosonName;
    private RString hihokenshaName;
    private RString hihokenshaNo;
    private FlexibleDate seinengappiYMD;
    private Code seibetsu;
    private Code koroshoIfShikibetsuCode;
    private Code nijiHanteiYokaigoJotaiKubun;
    private RString nijiHanteiNinteiYukoKikan;
    private FlexibleDate nijiHanteiNinteiYukoKaishiYMD;
    private FlexibleDate nijiHanteiNinteiYukoShuryoYMD;
    private FlexibleDate ninteiShinseiYMD;
    private Code ninteiShinseiShinseijiKubun;
    private RString jigyoshaMeisho;
    private RString chosainShimei;
    private RString iryoKikanMeisho;
    private RString shujiiName;
    private Code zenkaiKoroshoIfShikibetsuCode;
}
