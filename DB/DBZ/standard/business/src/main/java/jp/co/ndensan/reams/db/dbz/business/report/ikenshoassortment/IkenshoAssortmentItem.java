/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.report.ikenshoassortment;

import jp.co.ndensan.reams.db.dbz.definition.core.ikenshoassortment.IkenshoAssortmentLayout;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import lombok.Getter;
import lombok.Setter;

/**
 * 意見書まとめて印刷のitemです。
 * @author n8438
 */
@Getter
@Setter
public class IkenshoAssortmentItem {
    private RString hakkoYMD1;
    private RString denshiKoin;
    private RString ninshoshaYakushokuMei;
    private RString ninshoshaYakushokuMei1;
    private RString ninshoshaYakushokuMei2;
    private RString ninshoshaShimeiKakenai;
    private RString ninshoshaShimeiKakeru;
    private RString koinMojiretsu;
    private RString koinShoryaku;
    private RString bunshoNo;
    private RString yubinNo1;
    private RString jushoText;
    private RString kikanNameText;
    private RString shimeiText;
    private RString meishoFuyo;
    private RString customerBarCode;
    private RString sonota;
    private RString pageCount;
    private RString title;
    private RString tsuchibun1;
    private RString hihokenshaNo1;
    private RString hihokenshaNo2;
    private RString hihokenshaNo3;
    private RString hihokenshaNo4;
    private RString hihokenshaNo5;
    private RString hihokenshaNo6;
    private RString hihokenshaNo7;
    private RString hihokenshaNo8;
    private RString hihokenshaNo9;
    private RString hihokenshaNo10;
    private RString hokenshaNo1;
    private RString hokenshaNo2;
    private RString hokenshaNo3;
    private RString hokenshaNo4;
    private RString hokenshaNo5;
    private RString hokenshaNo6;
    private RString shinseiKubun;
    private RString hihokenshaNameKana;
    private RString seibetsu;
    private RString hihokenshaName;
    private RString birthGengo;
    private RString birthYMD;
    private RString yubinNo;
    private RString jusho;
    private RString shinseiYMD;
    private RString teishutsuKigen;
    private RString tsuchibun2;
    private RString shoriName;
    private RString hihokenshaKana;
    private RString seibetsuMan;
    private RString seibetsuWoman;
    private RString hihokenshaTel;
    private RString birthGengoMeiji;
    private RString birthGengoTaisho;
    private RString birthGengoShowa;
    private RString age;
    private RString birthYY;
    private RString birthMM;
    private RString birthDD;
    private RString shujiiName;
    private RString iryokikanName;
    private RString iryokikanNameTel;
    private RString iryokikanFax;
    private RString iryokikanAdress;
    private RString shinseiYMDNo1;
    private RString shinseiYMDNo2;
    private RString shinseiYMDNo3;
    private RString shinseiYMDNo4;
    private RString shinseiYMDNo5;
    private RString shinseiYMDNo6;
    private RString shinseiYY1;
    private RString shinseiYY2;
    private RString shinseiMM1;
    private RString shinseiMM2;
    private RString shinseiD1;
    private RString shinseiDD2;
    private RString shinseishaNameKana;
    private RString shinseishaYubinNo;
    private RString shinseishaTelNo;
    private RString shinseishaName;
    private RString shinseishaJusho;
    private RString meiji;
    private RString taisho;
    private RString showa;
    private RString iryokikanTelNo;
    private RString iryokikanJusho;
    private RString iryokikanFaxNo;
    private RString inkanMark;
    private RString iryokikanDaihyosha;
    private RString iryokikanTel;
    private RString ikenshoSakuseiRyo2;
    private RString ikenshoSakuseiRyo4;
    private RString ikenshoSakuseiRyo1;
    private RString ikenshoSakuseiRyo3;
    private RString shubetsuZaitaku;
    private RString shubetsuKeizoku;
    private RString shubetsuShisetsu;
    private RString shubetsuShinki;
    private RString seikyugakuIkenshoSakuseiRyo1;
    private RString seikyugakuIkenshoSakuseiRyo2;
    private RString seikyugakuIkenshoSakuseiRyo3;
    private RString seikyugakuIkenshoSakuseiRyo4;
    private RString gengo;
    private RString atesakiHokenshaName;
    private RString shinkiShisetsuKingaku;
    private RString shinkiZaitakuKingaku;
    private RString keizokuZaitakuKingaku;
    private RString keizokuShisetsuKingaku;
    private RString hakkoYMD;
    private RString hihokenshaName1;
    private RString hihokenshaName2;
    private RString tantoIshiName;
    private RString iryokikanYubinNo;
    private RString telNo;
    private RString jushinKikan;
    private RString jushinArea;
    private RString atenaRemban;
    private RString remban;
    private ShikibetsuCode 識別コード;
    private ExpandedInformation 拡張情報;
    private IkenshoAssortmentLayout layout;
}
