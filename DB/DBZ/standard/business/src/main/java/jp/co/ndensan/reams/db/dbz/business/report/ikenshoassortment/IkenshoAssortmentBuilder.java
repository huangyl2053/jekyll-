/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.report.ikenshoassortment;

import jp.co.ndensan.reams.db.dbz.entity.report.ikenshoassortment.IkenshoAssortmentReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.IReportBuilder;

/**
 * 意見書個人別まとめて印刷のビルダです。
 * @author n8438
 */
public class IkenshoAssortmentBuilder implements IReportBuilder<IkenshoAssortmentReportSource> {
    private final IkenshoAssortmentItem item;
    
    /**
     * コンストラクタです。
     * @param item 
     */
    public IkenshoAssortmentBuilder(IkenshoAssortmentItem item) {
        this.item = item;
    }
    
    @Override
    public IkenshoAssortmentReportSource build() {
        IkenshoAssortmentReportSource source = new IkenshoAssortmentReportSource();
        source.hakkoYMD1 = item.getHakkoYMD1();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.koinShoryaku = item.getKoinShoryaku();
        source.bunshoNo = item.getBunshoNo();
        source.yubinNo1 = item.getYubinNo1();
        source.jushoText = item.getJushoText();
        source.kikanNameText = item.getKikanNameText();
        source.shimeiText = item.getShimeiText();
        source.meishoFuyo = item.getMeishoFuyo();
        source.customerBarCode = item.getCustomerBarCode();
        source.sonota = item.getSonota();
        source.pageCount = item.getPageCount();
        source.title = item.getTitle();
        source.tsuchibun1 = item.getTsuchibun1();
        source.hihokenshaNo1 = item.getHihokenshaNo1();
        source.hihokenshaNo2 = item.getHihokenshaNo2();
        source.hihokenshaNo3 = item.getHihokenshaNo3();
        source.hihokenshaNo4 = item.getHihokenshaNo4();
        source.hihokenshaNo5 = item.getHihokenshaNo5();
        source.hihokenshaNo6 = item.getHihokenshaNo6();
        source.hihokenshaNo7 = item.getHihokenshaNo7();
        source.hihokenshaNo8 = item.getHihokenshaNo8();
        source.hihokenshaNo9 = item.getHihokenshaNo9();
        source.hihokenshaNo10 = item.getHihokenshaNo10();
        source.hokenshaNo1 = item.getHokenshaNo1();
        source.hokenshaNo2 = item.getHokenshaNo2();
        source.hokenshaNo3 = item.getHokenshaNo3();
        source.hokenshaNo4 = item.getHokenshaNo4();
        source.hokenshaNo5 = item.getHokenshaNo5();
        source.hokenshaNo6 = item.getHokenshaNo6();
        source.shinseiKubun = item.getShinseiKubun();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.seibetsu = item.getSeibetsu();
        source.hihokenshaName = item.getHihokenshaName();
        source.birthGengo = item.getBirthGengo();
        source.birthYMD = item.getBirthYMD();
        source.yubinNo = item.getYubinNo();
        source.jusho = item.getJusho();
        source.shinseiYMD = item.getShinseiYMD();
        source.teishutsuKigen = item.getTeishutsuKigen();
        source.tsuchibun2 = item.getTsuchibun2();
        source.shoriName = item.getShoriName();
        source.hihokenshaKana = item.getHihokenshaKana();
        source.seibetsuMan = item.getSeibetsuMan();
        source.seibetsuWoman = item.getSeibetsuWoman();
        source.hihokenshaTel = item.getHihokenshaTel();
        source.birthGengoMeiji = item.getBirthGengoMeiji();
        source.birthGengoTaisho = item.getBirthGengoTaisho();
        source.birthGengoShowa = item.getBirthGengoShowa();
        source.age = item.getAge();
        source.birthYY = item.getBirthYY();
        source.birthMM = item.getBirthMM();
        source.birthDD = item.getBirthDD();
        source.shujiiName = item.getShujiiName();
        source.iryokikanName = item.getIryokikanName();
        source.iryokikanNameTel = item.getIryokikanNameTel();
        source.iryokikanFax = item.getIryokikanFax();
        source.iryokikanAdress = item.getIryokikanAdress();
        source.shinseiYMDNo1 = item.getShinseiYMDNo1();
        source.shinseiYMDNo2 = item.getShinseiYMDNo2();
        source.shinseiYMDNo3 = item.getShinseiYMDNo3();
        source.shinseiYMDNo4 = item.getShinseiYMDNo4();
        source.shinseiYMDNo5 = item.getShinseiYMDNo5();
        source.shinseiYMDNo6 = item.getShinseiYMDNo6();
        source.shinseiYY1 = item.getShinseiYY1();
        source.shinseiYY2 = item.getShinseiYY2();
        source.shinseiMM1 = item.getShinseiMM1();
        source.shinseiMM2 = item.getShinseiMM2();
        source.shinseiD1 = item.getShinseiD1();
        source.shinseiDD2 = item.getShinseiDD2();
        source.shinseishaNameKana = item.getShinseishaNameKana();
        source.shinseishaYubinNo = item.getShinseishaYubinNo();
        source.shinseishaTelNo = item.getShinseishaTelNo();
        source.shinseishaName = item.getShinseishaName();
        source.shinseishaJusho = item.getShinseishaJusho();
        source.meiji = item.getMeiji();
        source.taisho = item.getTaisho();
        source.showa = item.getShowa();
        source.iryokikanTelNo = item.getIryokikanTelNo();
        source.iryokikanJusho = item.getIryokikanJusho();
        source.iryokikanFaxNo = item.getIryokikanFaxNo();
        source.inkanMark = item.getInkanMark();
        source.iryokikanDaihyosha = item.getIryokikanDaihyosha();
        source.iryokikanTel = item.getIryokikanTel();
        source.ikenshoSakuseiRyo2 = item.getIkenshoSakuseiRyo2();
        source.ikenshoSakuseiRyo4 = item.getIkenshoSakuseiRyo4();
        source.ikenshoSakuseiRyo1 = item.getIkenshoSakuseiRyo1();
        source.ikenshoSakuseiRyo3 = item.getIkenshoSakuseiRyo3();
        source.shubetsuZaitaku = item.getShubetsuZaitaku();
        source.shubetsuKeizoku = item.getShubetsuKeizoku();
        source.shubetsuShisetsu = item.getShubetsuShisetsu();
        source.shubetsuShinki = item.getShubetsuShinki();
        source.seikyugakuIkenshoSakuseiRyo1 = item.getSeikyugakuIkenshoSakuseiRyo1();
        source.seikyugakuIkenshoSakuseiRyo2 = item.getSeikyugakuIkenshoSakuseiRyo2();
        source.seikyugakuIkenshoSakuseiRyo3 = item.getSeikyugakuIkenshoSakuseiRyo3();
        source.seikyugakuIkenshoSakuseiRyo4 = item.getSeikyugakuIkenshoSakuseiRyo4();
        source.gengo = item.getGengo();
        source.atesakiHokenshaName = item.getAtesakiHokenshaName();
        source.shinkiShisetsuKingaku = RString.isNullOrEmpty(item.getShinkiShisetsuKingaku()) ? Decimal.ZERO : new Decimal(item.getShinkiShisetsuKingaku().toString());
        source.shinkiZaitakuKingaku = RString.isNullOrEmpty(item.getShinkiZaitakuKingaku()) ? Decimal.ZERO : new Decimal(item.getShinkiZaitakuKingaku().toString());
        source.keizokuZaitakuKingaku = RString.isNullOrEmpty(item.getKeizokuZaitakuKingaku()) ? Decimal.ZERO : new Decimal(item.getKeizokuZaitakuKingaku().toString());
        source.keizokuShisetsuKingaku = RString.isNullOrEmpty(item.getKeizokuShisetsuKingaku()) ? Decimal.ZERO : new Decimal(item.getKeizokuShisetsuKingaku().toString());
        source.hakkoYMD = item.getHakkoYMD();
        source.hihokenshaName1 = item.getHihokenshaName1();
        source.hihokenshaName2 = item.getHihokenshaName2();
        source.tantoIshiName = item.getTantoIshiName();
        source.iryokikanYubinNo = item.getIryokikanYubinNo();
        source.telNo = item.getTelNo();
        source.jushinKikan = item.getJushinKikan();
        source.jushinArea = item.getJushinArea();
        source.atenaRemban = item.getAtenaRemban();
        source.remban = item.getRemban();
        source.layout = item.getLayout();
        source.識別コード = item.get識別コード();
        source.拡張情報 = item.get拡張情報();
        return source;
    }
    
}
