package jp.co.ndensan.reams.db.dbz.business.report.chosahyomatome;

import jp.co.ndensan.reams.db.dbz.entity.report.chosahyomatome.ChosahyoMatomeReportSource;
import jp.co.ndensan.reams.uz.uza.report.IReportBuilder;

/**
 * 調査票まとめて印刷のビルダです。
 * @author n8438
 */
public class ChosahyoMatomeBuilder implements IReportBuilder<ChosahyoMatomeReportSource>{
    private final ChosahyoMatomeItem item;
    
    /**
     * コンストラクタです。
     * @param item 
     */
    public ChosahyoMatomeBuilder(ChosahyoMatomeItem item) {
        this.item = item;
    }
    
    @Override
    public ChosahyoMatomeReportSource build() {
        ChosahyoMatomeReportSource source = new ChosahyoMatomeReportSource();
        source.hakkoYMD1 = item.getHakkoYMD1();
        source.denshiKoin = item.getDenshiKoin();
        source.ninshoshaYakushokuMei = item.getNinshoshaYakushokuMei();
        source.ninshoshaYakushokuMei2 = item.getNinshoshaYakushokuMei2();
        source.ninshoshaYakushokuMei1 = item.getNinshoshaYakushokuMei1();
        source.koinMojiretsu = item.getKoinMojiretsu();
        source.ninshoshaShimeiKakeru = item.getNinshoshaShimeiKakeru();
        source.ninshoshaShimeiKakenai = item.getNinshoshaShimeiKakenai();
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
        source.birthGengo = item.getBirthGengo();
        source.birthYMD = item.getBirthYMD();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.hihokenshaName = item.getHihokenshaName();
        source.seibetsu = item.getSeibetsu();
        source.yubinNo = item.getYubinNo();
        source.jusho = item.getJusho();
        source.telNo = item.getTelNo();
        source.homonChosasakiYubinNo = item.getHomonChosasakiYubinNo();
        source.homonChosasakiJusho = item.getHomonChosasakiJusho();
        source.homonChosasakiName = item.getHomonChosasakiName();
        source.homonChosasakiTelNo = item.getHomonChosasakiTelNo();
        source.shinseiYMD = item.getShinseiYMD();
        source.teishutsuKigen = item.getTeishutsuKigen();
        source.tsuchibun2 = item.getTsuchibun2();
        source.atenaRemban = item.getAtenaRemban();
                
        source.shinseiYY1 = item.getShinseiYY1();
        source.shinseiYY2 = item.getShinseiYY2();
        source.shinseiMM1 = item.getShinseiMM1();
        source.shinseiMM2 = item.getShinseiMM2();
        source.shinseiDD1 = item.getShinseiDD1();
        source.shinseiDD2 = item.getShinseiDD2();
        source.hokenshaNo1 = item.getHokenshaNo1();
        source.hokenshaNo2 = item.getHokenshaNo2();
        source.hokenshaNo3 = item.getHokenshaNo3();
        source.hokenshaNo4 = item.getHokenshaNo4();
        source.hokenshaNo5 = item.getHokenshaNo5();
        source.hokenshaNo6 = item.getHokenshaNo6();
        source.hishokenshaNo7 = item.getHishokenshaNo7();
        source.hishokenshaNo8 = item.getHishokenshaNo8();
        source.hishokenshaNo9 = item.getHishokenshaNo9();
        source.hishokenshaNo10 = item.getHishokenshaNo10();
        source.hishokenshaNo1 = item.getHishokenshaNo1();
        source.hishokenshaNo2 = item.getHishokenshaNo2();
        source.hishokenshaNo3 = item.getHishokenshaNo3();
        source.hishokenshaNo4 = item.getHishokenshaNo4();
        source.hishokenshaNo5 = item.getHishokenshaNo5();
        source.hishokenshaNo6 = item.getHishokenshaNo6();
        source.再調査 = item.get再調査();
        source.新規 = item.get新規();
        source.homonChosainName = item.getHomonChosainName();
        source.homonChosainNo1 = item.getHomonChosainNo1();
        source.homonChosainNo2 = item.getHomonChosainNo2();
        source.homonChosainNo3 = item.getHomonChosainNo3();
        source.homonChosainNo4 = item.getHomonChosainNo4();
        source.homonChosainNo5 = item.getHomonChosainNo5();
        source.homonChosainNo6 = item.getHomonChosainNo6();
        source.homonChosainNo7 = item.getHomonChosainNo7();
        source.homonChosainNo8 = item.getHomonChosainNo8();
        source.homonChosasakiNo1 = item.getHomonChosasakiNo1();
        source.homonChosasakiNo2 = item.getHomonChosasakiNo2();
        source.homonChosasakiNo3 = item.getHomonChosasakiNo3();
        source.homonChosasakiNo4 = item.getHomonChosasakiNo4();
        source.homonChosasakiNo5 = item.getHomonChosasakiNo5();
        source.homonChosasakiNo6 = item.getHomonChosasakiNo6();
        source.homonChosasakiNo7 = item.getHomonChosasakiNo7();
        source.homonChosasakiNo8 = item.getHomonChosasakiNo8();
        source.homonChosasakiNo9 = item.getHomonChosasakiNo9();
        source.homonChosasakiNo10 = item.getHomonChosasakiNo10();
        source.homonChosasakiNo11 = item.getHomonChosasakiNo11();
        source.homonChosasakiNo12 = item.getHomonChosasakiNo12();
        source.shinseishaNameKana = item.getShinseishaNameKana();
        source.seibetsuMan = item.getSeibetsuMan();
        source.shinseishaYubinNo = item.getShinseishaYubinNo();
        source.shinseishTelNo = item.getShinseishTelNo();
        source.shinseishaName = item.getShinseishaName();
        source.seibetsuWoman = item.getSeibetsuWoman();
        source.shinseishaJusho = item.getShinseishaJusho();
        source.kazokuRenrakusakiTel1 = item.getKazokuRenrakusakiTel1();
        source.meiji = item.getMeiji();
        source.taisho = item.getTaisho();
        source.showa = item.getShowa();
        source.kazokuRenrakusakiYubinNo = item.getKazokuRenrakusakiYubinNo();
        source.kazokuRenrakusakiTel2 = item.getKazokuRenrakusakiTel2();
        source.kazokuRenrakusakiJusho = item.getKazokuRenrakusakiJusho();
        source.birthMM = item.getBirthMM();
        source.birthYY = item.getBirthYY();
        source.birthDD = item.getBirthDD();
        source.age = item.getAge();
        source.shinseishatonoKankei = item.getShinseishatonoKankei();
        source.kazokuRenrakusakiName = item.getKazokuRenrakusakiName();
        source.nikaime = item.getNikaime();
        source.shokai = item.getShokai();
        source.higaito = item.getHigaito();
        source.yoshien = item.getYoshien();
        source.yoshiendo = item.getYoshiendo();
        source.yokaigo = item.getYokaigo();
        source.yokaigodo = item.getYokaigodo();
        source.zenkaiNinteiYYYY = item.getZenkaiNinteiYYYY();
        source.zenkaiNinteiMM = item.getZenkaiNinteiMM();
        source.zenkaiNinteiDD = item.getZenkaiNinteiDD();
        source.識別コード = item.getShikibetsuCode();
        source.layout = item.getLayout();
        return source;
    }
}
