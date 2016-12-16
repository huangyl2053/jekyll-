package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 15 14:14:58 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;


/**
 * dgNinteiTaskList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteiTaskList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">

    private RString hokensha;
    private TextBoxDate ninteiShinseiDay;
    private RString hihoNumber;
    private RString hihoShimei;
    private RString shinseiKubunShinseiji;
    private RString shinseiKubunHorei;
    private TextBoxDate koshinKanryoDay;
    private TextBoxDate koshinTsuchiYMD;
    private TextBoxDate shinseiUketsukeKanryoDay;
    private TextBoxDate chosaIraiKanryoDay;
    private TextBoxNum chosaIraiSaichosaCount;
    private TextBoxDate chosaIraishoHakkoDay;
    private TextBoxDate chousahyoOutput;
    private TextBoxDate chosaIraiDataShutsuryokuDay;
    private TextBoxDate chosaIraiKigen;
    private RString chosaIraiKubun;
    private RString konkaiChosaItakusaki;
    private RString konkaiChosain;
    private TextBoxNum konkaiChosaCount;
    private RString zenkaiChosaItakusaki;
    private RString zenkaiChosain;
    private RString zenzenkaiChosaItakusaki;
    private RString zenzenkaiChosain;
    private TextBoxDate chosahyoKanryoDay;
    private TextBoxDate chosahyoDataNyuryokuDay;
    private TextBoxDate ikenshoIraiKanryoDay;
    private TextBoxNum ikenshoIraiIkenCount;
    private TextBoxDate ikenshoIraiDay;
    private TextBoxDate ikenshoIraiIraishoHakkoDay;
    private TextBoxDate ikenshoIraiIkenshoShutsuryokuDay;
    private TextBoxDate ikenshoIraiKigen;
    private TextBoxDate ikenshoNyushuKanryoDay;
    private TextBoxDate ikenshoNyushuTeikei;
    private RString ikenshoIraiShokai;
    private RString konkaiShujiiIryokikan;
    private RString konkaiShujii;
    private RString zenkaiIryokikan;
    private RString zenkaiShujii;
    private RString yubinNumber;
    private RString jusho;
    private RString nyushoShisetsu;
    private TextBoxDate chosaTokusokuHakkoDay;
    private RString chosaTokusokuHoho;
    private TextBoxNum chosaTokusokuCount;
    private TextBoxDate chosaTokusokuLiit;
    private RString chosaTokusokuChiku;
    private TextBoxDate ikenshoTokusokuHakkoDay;
    private RString ikenshoTokusokuHoho;
    private TextBoxNum ikenshoTokusokuCount;
    private TextBoxDate ikenshoTokusokuLimit;
    private TextBoxDate ichijiHanteiKanryoDay;
    private TextBoxDate ichijiHanteiKanri;
    private TextBoxDate ichijiHantei;
    private RString ichijiHanteiKekka;
    private RString ichijiHanteiWarningCode;
    private TextBoxDate maskingKanryoDay;
    private TextBoxDate shinsakaiKanryoDay;
    private TextBoxDate shinsakaiwaritukeDay;
    private TextBoxDate shinsakaiKaisaiDay;
    private TextBoxTime shinsakaiKaisaiJikan;
    private RString yusenWaritsukesha;
    private RString kaisaiNumber;
    private RString gogitai;
    private TextBoxDate nijihanteiKanryoDay;
    private TextBoxDate nijihanteiKekkaToroku;
    private RString nyuryokuHoho;
    private RString nijihanteiKekka;
    private RString nijihanteiYukoKikan;
    private TextBoxDate nijihanteiShinsakaiKaisaiDay;
    private RString nijihanteiKaisaiNumber;
    private TextBoxDate getsureiShoriKanryoDay;
    private TextBoxDate centerSoshinDay;
    private TextBoxNum keikaNissu;
    private RString shinseishoKanriNo;
    private RString ninteichosaIraiRirekiNo;
    private RString ikenshoIraiRirekiNo;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosainCode;
    private RString chikuCode;
    private RString nijiHanteiYokaigoJotaiKubunCode;
    private RString koroshoIfShikibetsuCode;
    private RString nyushoShisetsuCode;
    private RString cyoSaHyo;
    private RString cyoSaHyoToKi;
    private RString jyuJiIiKenJyo;
    private RString soNoTaShiRyo;

    public dgNinteiTaskList_Row() {
        super();
        this.hokensha = RString.EMPTY;
        this.ninteiShinseiDay = new TextBoxDate();
        this.hihoNumber = RString.EMPTY;
        this.hihoShimei = RString.EMPTY;
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.shinseiKubunHorei = RString.EMPTY;
        this.koshinKanryoDay = new TextBoxDate();
        this.koshinTsuchiYMD = new TextBoxDate();
        this.shinseiUketsukeKanryoDay = new TextBoxDate();
        this.chosaIraiKanryoDay = new TextBoxDate();
        this.chosaIraiSaichosaCount = new TextBoxNum();
        this.chosaIraishoHakkoDay = new TextBoxDate();
        this.chousahyoOutput = new TextBoxDate();
        this.chosaIraiDataShutsuryokuDay = new TextBoxDate();
        this.chosaIraiKigen = new TextBoxDate();
        this.chosaIraiKubun = RString.EMPTY;
        this.konkaiChosaItakusaki = RString.EMPTY;
        this.konkaiChosain = RString.EMPTY;
        this.konkaiChosaCount = new TextBoxNum();
        this.zenkaiChosaItakusaki = RString.EMPTY;
        this.zenkaiChosain = RString.EMPTY;
        this.zenzenkaiChosaItakusaki = RString.EMPTY;
        this.zenzenkaiChosain = RString.EMPTY;
        this.chosahyoKanryoDay = new TextBoxDate();
        this.chosahyoDataNyuryokuDay = new TextBoxDate();
        this.ikenshoIraiKanryoDay = new TextBoxDate();
        this.ikenshoIraiIkenCount = new TextBoxNum();
        this.ikenshoIraiDay = new TextBoxDate();
        this.ikenshoIraiIraishoHakkoDay = new TextBoxDate();
        this.ikenshoIraiIkenshoShutsuryokuDay = new TextBoxDate();
        this.ikenshoIraiKigen = new TextBoxDate();
        this.ikenshoNyushuKanryoDay = new TextBoxDate();
        this.ikenshoNyushuTeikei = new TextBoxDate();
        this.ikenshoIraiShokai = RString.EMPTY;
        this.konkaiShujiiIryokikan = RString.EMPTY;
        this.konkaiShujii = RString.EMPTY;
        this.zenkaiIryokikan = RString.EMPTY;
        this.zenkaiShujii = RString.EMPTY;
        this.yubinNumber = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.nyushoShisetsu = RString.EMPTY;
        this.chosaTokusokuHakkoDay = new TextBoxDate();
        this.chosaTokusokuHoho = RString.EMPTY;
        this.chosaTokusokuCount = new TextBoxNum();
        this.chosaTokusokuLiit = new TextBoxDate();
        this.chosaTokusokuChiku = RString.EMPTY;
        this.ikenshoTokusokuHakkoDay = new TextBoxDate();
        this.ikenshoTokusokuHoho = RString.EMPTY;
        this.ikenshoTokusokuCount = new TextBoxNum();
        this.ikenshoTokusokuLimit = new TextBoxDate();
        this.ichijiHanteiKanryoDay = new TextBoxDate();
        this.ichijiHanteiKanri = new TextBoxDate();
        this.ichijiHantei = new TextBoxDate();
        this.ichijiHanteiKekka = RString.EMPTY;
        this.ichijiHanteiWarningCode = RString.EMPTY;
        this.maskingKanryoDay = new TextBoxDate();
        this.shinsakaiKanryoDay = new TextBoxDate();
        this.shinsakaiwaritukeDay = new TextBoxDate();
        this.shinsakaiKaisaiDay = new TextBoxDate();
        this.shinsakaiKaisaiJikan = new TextBoxTime();
        this.yusenWaritsukesha = RString.EMPTY;
        this.kaisaiNumber = RString.EMPTY;
        this.gogitai = RString.EMPTY;
        this.nijihanteiKanryoDay = new TextBoxDate();
        this.nijihanteiKekkaToroku = new TextBoxDate();
        this.nyuryokuHoho = RString.EMPTY;
        this.nijihanteiKekka = RString.EMPTY;
        this.nijihanteiYukoKikan = RString.EMPTY;
        this.nijihanteiShinsakaiKaisaiDay = new TextBoxDate();
        this.nijihanteiKaisaiNumber = RString.EMPTY;
        this.getsureiShoriKanryoDay = new TextBoxDate();
        this.centerSoshinDay = new TextBoxDate();
        this.keikaNissu = new TextBoxNum();
        this.shinseishoKanriNo = RString.EMPTY;
        this.ninteichosaIraiRirekiNo = RString.EMPTY;
        this.ikenshoIraiRirekiNo = RString.EMPTY;
        this.ninteiChosaItakusakiCode = RString.EMPTY;
        this.ninteiChosainCode = RString.EMPTY;
        this.chikuCode = RString.EMPTY;
        this.nijiHanteiYokaigoJotaiKubunCode = RString.EMPTY;
        this.koroshoIfShikibetsuCode = RString.EMPTY;
        this.nyushoShisetsuCode = RString.EMPTY;
        this.cyoSaHyo = RString.EMPTY;
        this.cyoSaHyoToKi = RString.EMPTY;
        this.jyuJiIiKenJyo = RString.EMPTY;
        this.soNoTaShiRyo = RString.EMPTY;
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("hihoNumber", hihoNumber);
        this.setOriginalData("hihoShimei", hihoShimei);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("shinseiKubunHorei", shinseiKubunHorei);
        this.setOriginalData("koshinKanryoDay", koshinKanryoDay);
        this.setOriginalData("koshinTsuchiYMD", koshinTsuchiYMD);
        this.setOriginalData("shinseiUketsukeKanryoDay", shinseiUketsukeKanryoDay);
        this.setOriginalData("chosaIraiKanryoDay", chosaIraiKanryoDay);
        this.setOriginalData("chosaIraiSaichosaCount", chosaIraiSaichosaCount);
        this.setOriginalData("chosaIraishoHakkoDay", chosaIraishoHakkoDay);
        this.setOriginalData("chousahyoOutput", chousahyoOutput);
        this.setOriginalData("chosaIraiDataShutsuryokuDay", chosaIraiDataShutsuryokuDay);
        this.setOriginalData("chosaIraiKigen", chosaIraiKigen);
        this.setOriginalData("chosaIraiKubun", chosaIraiKubun);
        this.setOriginalData("konkaiChosaItakusaki", konkaiChosaItakusaki);
        this.setOriginalData("konkaiChosain", konkaiChosain);
        this.setOriginalData("konkaiChosaCount", konkaiChosaCount);
        this.setOriginalData("zenkaiChosaItakusaki", zenkaiChosaItakusaki);
        this.setOriginalData("zenkaiChosain", zenkaiChosain);
        this.setOriginalData("zenzenkaiChosaItakusaki", zenzenkaiChosaItakusaki);
        this.setOriginalData("zenzenkaiChosain", zenzenkaiChosain);
        this.setOriginalData("chosahyoKanryoDay", chosahyoKanryoDay);
        this.setOriginalData("chosahyoDataNyuryokuDay", chosahyoDataNyuryokuDay);
        this.setOriginalData("ikenshoIraiKanryoDay", ikenshoIraiKanryoDay);
        this.setOriginalData("ikenshoIraiIkenCount", ikenshoIraiIkenCount);
        this.setOriginalData("ikenshoIraiDay", ikenshoIraiDay);
        this.setOriginalData("ikenshoIraiIraishoHakkoDay", ikenshoIraiIraishoHakkoDay);
        this.setOriginalData("ikenshoIraiIkenshoShutsuryokuDay", ikenshoIraiIkenshoShutsuryokuDay);
        this.setOriginalData("ikenshoIraiKigen", ikenshoIraiKigen);
        this.setOriginalData("ikenshoNyushuKanryoDay", ikenshoNyushuKanryoDay);
        this.setOriginalData("ikenshoNyushuTeikei", ikenshoNyushuTeikei);
        this.setOriginalData("ikenshoIraiShokai", ikenshoIraiShokai);
        this.setOriginalData("konkaiShujiiIryokikan", konkaiShujiiIryokikan);
        this.setOriginalData("konkaiShujii", konkaiShujii);
        this.setOriginalData("zenkaiIryokikan", zenkaiIryokikan);
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.setOriginalData("yubinNumber", yubinNumber);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.setOriginalData("chosaTokusokuHakkoDay", chosaTokusokuHakkoDay);
        this.setOriginalData("chosaTokusokuHoho", chosaTokusokuHoho);
        this.setOriginalData("chosaTokusokuCount", chosaTokusokuCount);
        this.setOriginalData("chosaTokusokuLiit", chosaTokusokuLiit);
        this.setOriginalData("chosaTokusokuChiku", chosaTokusokuChiku);
        this.setOriginalData("ikenshoTokusokuHakkoDay", ikenshoTokusokuHakkoDay);
        this.setOriginalData("ikenshoTokusokuHoho", ikenshoTokusokuHoho);
        this.setOriginalData("ikenshoTokusokuCount", ikenshoTokusokuCount);
        this.setOriginalData("ikenshoTokusokuLimit", ikenshoTokusokuLimit);
        this.setOriginalData("ichijiHanteiKanryoDay", ichijiHanteiKanryoDay);
        this.setOriginalData("ichijiHanteiKanri", ichijiHanteiKanri);
        this.setOriginalData("ichijiHantei", ichijiHantei);
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.setOriginalData("ichijiHanteiWarningCode", ichijiHanteiWarningCode);
        this.setOriginalData("maskingKanryoDay", maskingKanryoDay);
        this.setOriginalData("shinsakaiKanryoDay", shinsakaiKanryoDay);
        this.setOriginalData("shinsakaiwaritukeDay", shinsakaiwaritukeDay);
        this.setOriginalData("shinsakaiKaisaiDay", shinsakaiKaisaiDay);
        this.setOriginalData("shinsakaiKaisaiJikan", shinsakaiKaisaiJikan);
        this.setOriginalData("yusenWaritsukesha", yusenWaritsukesha);
        this.setOriginalData("kaisaiNumber", kaisaiNumber);
        this.setOriginalData("gogitai", gogitai);
        this.setOriginalData("nijihanteiKanryoDay", nijihanteiKanryoDay);
        this.setOriginalData("nijihanteiKekkaToroku", nijihanteiKekkaToroku);
        this.setOriginalData("nyuryokuHoho", nyuryokuHoho);
        this.setOriginalData("nijihanteiKekka", nijihanteiKekka);
        this.setOriginalData("nijihanteiYukoKikan", nijihanteiYukoKikan);
        this.setOriginalData("nijihanteiShinsakaiKaisaiDay", nijihanteiShinsakaiKaisaiDay);
        this.setOriginalData("nijihanteiKaisaiNumber", nijihanteiKaisaiNumber);
        this.setOriginalData("getsureiShoriKanryoDay", getsureiShoriKanryoDay);
        this.setOriginalData("centerSoshinDay", centerSoshinDay);
        this.setOriginalData("keikaNissu", keikaNissu);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.setOriginalData("ikenshoIraiRirekiNo", ikenshoIraiRirekiNo);
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("chikuCode", chikuCode);
        this.setOriginalData("nijiHanteiYokaigoJotaiKubunCode", nijiHanteiYokaigoJotaiKubunCode);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.setOriginalData("cyoSaHyo", cyoSaHyo);
        this.setOriginalData("cyoSaHyoToKi", cyoSaHyoToKi);
        this.setOriginalData("jyuJiIiKenJyo", jyuJiIiKenJyo);
        this.setOriginalData("soNoTaShiRyo", soNoTaShiRyo);
    }

    public dgNinteiTaskList_Row(RString hokensha, TextBoxDate ninteiShinseiDay, RString hihoNumber, RString hihoShimei, RString shinseiKubunShinseiji, RString shinseiKubunHorei, TextBoxDate koshinKanryoDay, TextBoxDate koshinTsuchiYMD, TextBoxDate shinseiUketsukeKanryoDay, TextBoxDate chosaIraiKanryoDay, TextBoxNum chosaIraiSaichosaCount, TextBoxDate chosaIraishoHakkoDay, TextBoxDate chousahyoOutput, TextBoxDate chosaIraiDataShutsuryokuDay, TextBoxDate chosaIraiKigen, RString chosaIraiKubun, RString konkaiChosaItakusaki, RString konkaiChosain, TextBoxNum konkaiChosaCount, RString zenkaiChosaItakusaki, RString zenkaiChosain, RString zenzenkaiChosaItakusaki, RString zenzenkaiChosain, TextBoxDate chosahyoKanryoDay, TextBoxDate chosahyoDataNyuryokuDay, TextBoxDate ikenshoIraiKanryoDay, TextBoxNum ikenshoIraiIkenCount, TextBoxDate ikenshoIraiDay, TextBoxDate ikenshoIraiIraishoHakkoDay, TextBoxDate ikenshoIraiIkenshoShutsuryokuDay, TextBoxDate ikenshoIraiKigen, TextBoxDate ikenshoNyushuKanryoDay, TextBoxDate ikenshoNyushuTeikei, RString ikenshoIraiShokai, RString konkaiShujiiIryokikan, RString konkaiShujii, RString zenkaiIryokikan, RString zenkaiShujii, RString yubinNumber, RString jusho, RString nyushoShisetsu, TextBoxDate chosaTokusokuHakkoDay, RString chosaTokusokuHoho, TextBoxNum chosaTokusokuCount, TextBoxDate chosaTokusokuLiit, RString chosaTokusokuChiku, TextBoxDate ikenshoTokusokuHakkoDay, RString ikenshoTokusokuHoho, TextBoxNum ikenshoTokusokuCount, TextBoxDate ikenshoTokusokuLimit, TextBoxDate ichijiHanteiKanryoDay, TextBoxDate ichijiHanteiKanri, TextBoxDate ichijiHantei, RString ichijiHanteiKekka, RString ichijiHanteiWarningCode, TextBoxDate maskingKanryoDay, TextBoxDate shinsakaiKanryoDay, TextBoxDate shinsakaiwaritukeDay, TextBoxDate shinsakaiKaisaiDay, TextBoxTime shinsakaiKaisaiJikan, RString yusenWaritsukesha, RString kaisaiNumber, RString gogitai, TextBoxDate nijihanteiKanryoDay, TextBoxDate nijihanteiKekkaToroku, RString nyuryokuHoho, RString nijihanteiKekka, RString nijihanteiYukoKikan, TextBoxDate nijihanteiShinsakaiKaisaiDay, RString nijihanteiKaisaiNumber, TextBoxDate getsureiShoriKanryoDay, TextBoxDate centerSoshinDay, TextBoxNum keikaNissu, RString shinseishoKanriNo, RString ninteichosaIraiRirekiNo, RString ikenshoIraiRirekiNo, RString ninteiChosaItakusakiCode, RString ninteiChosainCode, RString chikuCode, RString nijiHanteiYokaigoJotaiKubunCode, RString koroshoIfShikibetsuCode, RString nyushoShisetsuCode, RString cyoSaHyo, RString cyoSaHyoToKi, RString jyuJiIiKenJyo, RString soNoTaShiRyo) {
        super();
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("hihoNumber", hihoNumber);
        this.setOriginalData("hihoShimei", hihoShimei);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("shinseiKubunHorei", shinseiKubunHorei);
        this.setOriginalData("koshinKanryoDay", koshinKanryoDay);
        this.setOriginalData("koshinTsuchiYMD", koshinTsuchiYMD);
        this.setOriginalData("shinseiUketsukeKanryoDay", shinseiUketsukeKanryoDay);
        this.setOriginalData("chosaIraiKanryoDay", chosaIraiKanryoDay);
        this.setOriginalData("chosaIraiSaichosaCount", chosaIraiSaichosaCount);
        this.setOriginalData("chosaIraishoHakkoDay", chosaIraishoHakkoDay);
        this.setOriginalData("chousahyoOutput", chousahyoOutput);
        this.setOriginalData("chosaIraiDataShutsuryokuDay", chosaIraiDataShutsuryokuDay);
        this.setOriginalData("chosaIraiKigen", chosaIraiKigen);
        this.setOriginalData("chosaIraiKubun", chosaIraiKubun);
        this.setOriginalData("konkaiChosaItakusaki", konkaiChosaItakusaki);
        this.setOriginalData("konkaiChosain", konkaiChosain);
        this.setOriginalData("konkaiChosaCount", konkaiChosaCount);
        this.setOriginalData("zenkaiChosaItakusaki", zenkaiChosaItakusaki);
        this.setOriginalData("zenkaiChosain", zenkaiChosain);
        this.setOriginalData("zenzenkaiChosaItakusaki", zenzenkaiChosaItakusaki);
        this.setOriginalData("zenzenkaiChosain", zenzenkaiChosain);
        this.setOriginalData("chosahyoKanryoDay", chosahyoKanryoDay);
        this.setOriginalData("chosahyoDataNyuryokuDay", chosahyoDataNyuryokuDay);
        this.setOriginalData("ikenshoIraiKanryoDay", ikenshoIraiKanryoDay);
        this.setOriginalData("ikenshoIraiIkenCount", ikenshoIraiIkenCount);
        this.setOriginalData("ikenshoIraiDay", ikenshoIraiDay);
        this.setOriginalData("ikenshoIraiIraishoHakkoDay", ikenshoIraiIraishoHakkoDay);
        this.setOriginalData("ikenshoIraiIkenshoShutsuryokuDay", ikenshoIraiIkenshoShutsuryokuDay);
        this.setOriginalData("ikenshoIraiKigen", ikenshoIraiKigen);
        this.setOriginalData("ikenshoNyushuKanryoDay", ikenshoNyushuKanryoDay);
        this.setOriginalData("ikenshoNyushuTeikei", ikenshoNyushuTeikei);
        this.setOriginalData("ikenshoIraiShokai", ikenshoIraiShokai);
        this.setOriginalData("konkaiShujiiIryokikan", konkaiShujiiIryokikan);
        this.setOriginalData("konkaiShujii", konkaiShujii);
        this.setOriginalData("zenkaiIryokikan", zenkaiIryokikan);
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.setOriginalData("yubinNumber", yubinNumber);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.setOriginalData("chosaTokusokuHakkoDay", chosaTokusokuHakkoDay);
        this.setOriginalData("chosaTokusokuHoho", chosaTokusokuHoho);
        this.setOriginalData("chosaTokusokuCount", chosaTokusokuCount);
        this.setOriginalData("chosaTokusokuLiit", chosaTokusokuLiit);
        this.setOriginalData("chosaTokusokuChiku", chosaTokusokuChiku);
        this.setOriginalData("ikenshoTokusokuHakkoDay", ikenshoTokusokuHakkoDay);
        this.setOriginalData("ikenshoTokusokuHoho", ikenshoTokusokuHoho);
        this.setOriginalData("ikenshoTokusokuCount", ikenshoTokusokuCount);
        this.setOriginalData("ikenshoTokusokuLimit", ikenshoTokusokuLimit);
        this.setOriginalData("ichijiHanteiKanryoDay", ichijiHanteiKanryoDay);
        this.setOriginalData("ichijiHanteiKanri", ichijiHanteiKanri);
        this.setOriginalData("ichijiHantei", ichijiHantei);
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.setOriginalData("ichijiHanteiWarningCode", ichijiHanteiWarningCode);
        this.setOriginalData("maskingKanryoDay", maskingKanryoDay);
        this.setOriginalData("shinsakaiKanryoDay", shinsakaiKanryoDay);
        this.setOriginalData("shinsakaiwaritukeDay", shinsakaiwaritukeDay);
        this.setOriginalData("shinsakaiKaisaiDay", shinsakaiKaisaiDay);
        this.setOriginalData("shinsakaiKaisaiJikan", shinsakaiKaisaiJikan);
        this.setOriginalData("yusenWaritsukesha", yusenWaritsukesha);
        this.setOriginalData("kaisaiNumber", kaisaiNumber);
        this.setOriginalData("gogitai", gogitai);
        this.setOriginalData("nijihanteiKanryoDay", nijihanteiKanryoDay);
        this.setOriginalData("nijihanteiKekkaToroku", nijihanteiKekkaToroku);
        this.setOriginalData("nyuryokuHoho", nyuryokuHoho);
        this.setOriginalData("nijihanteiKekka", nijihanteiKekka);
        this.setOriginalData("nijihanteiYukoKikan", nijihanteiYukoKikan);
        this.setOriginalData("nijihanteiShinsakaiKaisaiDay", nijihanteiShinsakaiKaisaiDay);
        this.setOriginalData("nijihanteiKaisaiNumber", nijihanteiKaisaiNumber);
        this.setOriginalData("getsureiShoriKanryoDay", getsureiShoriKanryoDay);
        this.setOriginalData("centerSoshinDay", centerSoshinDay);
        this.setOriginalData("keikaNissu", keikaNissu);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.setOriginalData("ikenshoIraiRirekiNo", ikenshoIraiRirekiNo);
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("chikuCode", chikuCode);
        this.setOriginalData("nijiHanteiYokaigoJotaiKubunCode", nijiHanteiYokaigoJotaiKubunCode);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.setOriginalData("cyoSaHyo", cyoSaHyo);
        this.setOriginalData("cyoSaHyoToKi", cyoSaHyoToKi);
        this.setOriginalData("jyuJiIiKenJyo", jyuJiIiKenJyo);
        this.setOriginalData("soNoTaShiRyo", soNoTaShiRyo);
        this.hokensha = hokensha;
        this.ninteiShinseiDay = ninteiShinseiDay;
        this.hihoNumber = hihoNumber;
        this.hihoShimei = hihoShimei;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.shinseiKubunHorei = shinseiKubunHorei;
        this.koshinKanryoDay = koshinKanryoDay;
        this.koshinTsuchiYMD = koshinTsuchiYMD;
        this.shinseiUketsukeKanryoDay = shinseiUketsukeKanryoDay;
        this.chosaIraiKanryoDay = chosaIraiKanryoDay;
        this.chosaIraiSaichosaCount = chosaIraiSaichosaCount;
        this.chosaIraishoHakkoDay = chosaIraishoHakkoDay;
        this.chousahyoOutput = chousahyoOutput;
        this.chosaIraiDataShutsuryokuDay = chosaIraiDataShutsuryokuDay;
        this.chosaIraiKigen = chosaIraiKigen;
        this.chosaIraiKubun = chosaIraiKubun;
        this.konkaiChosaItakusaki = konkaiChosaItakusaki;
        this.konkaiChosain = konkaiChosain;
        this.konkaiChosaCount = konkaiChosaCount;
        this.zenkaiChosaItakusaki = zenkaiChosaItakusaki;
        this.zenkaiChosain = zenkaiChosain;
        this.zenzenkaiChosaItakusaki = zenzenkaiChosaItakusaki;
        this.zenzenkaiChosain = zenzenkaiChosain;
        this.chosahyoKanryoDay = chosahyoKanryoDay;
        this.chosahyoDataNyuryokuDay = chosahyoDataNyuryokuDay;
        this.ikenshoIraiKanryoDay = ikenshoIraiKanryoDay;
        this.ikenshoIraiIkenCount = ikenshoIraiIkenCount;
        this.ikenshoIraiDay = ikenshoIraiDay;
        this.ikenshoIraiIraishoHakkoDay = ikenshoIraiIraishoHakkoDay;
        this.ikenshoIraiIkenshoShutsuryokuDay = ikenshoIraiIkenshoShutsuryokuDay;
        this.ikenshoIraiKigen = ikenshoIraiKigen;
        this.ikenshoNyushuKanryoDay = ikenshoNyushuKanryoDay;
        this.ikenshoNyushuTeikei = ikenshoNyushuTeikei;
        this.ikenshoIraiShokai = ikenshoIraiShokai;
        this.konkaiShujiiIryokikan = konkaiShujiiIryokikan;
        this.konkaiShujii = konkaiShujii;
        this.zenkaiIryokikan = zenkaiIryokikan;
        this.zenkaiShujii = zenkaiShujii;
        this.yubinNumber = yubinNumber;
        this.jusho = jusho;
        this.nyushoShisetsu = nyushoShisetsu;
        this.chosaTokusokuHakkoDay = chosaTokusokuHakkoDay;
        this.chosaTokusokuHoho = chosaTokusokuHoho;
        this.chosaTokusokuCount = chosaTokusokuCount;
        this.chosaTokusokuLiit = chosaTokusokuLiit;
        this.chosaTokusokuChiku = chosaTokusokuChiku;
        this.ikenshoTokusokuHakkoDay = ikenshoTokusokuHakkoDay;
        this.ikenshoTokusokuHoho = ikenshoTokusokuHoho;
        this.ikenshoTokusokuCount = ikenshoTokusokuCount;
        this.ikenshoTokusokuLimit = ikenshoTokusokuLimit;
        this.ichijiHanteiKanryoDay = ichijiHanteiKanryoDay;
        this.ichijiHanteiKanri = ichijiHanteiKanri;
        this.ichijiHantei = ichijiHantei;
        this.ichijiHanteiKekka = ichijiHanteiKekka;
        this.ichijiHanteiWarningCode = ichijiHanteiWarningCode;
        this.maskingKanryoDay = maskingKanryoDay;
        this.shinsakaiKanryoDay = shinsakaiKanryoDay;
        this.shinsakaiwaritukeDay = shinsakaiwaritukeDay;
        this.shinsakaiKaisaiDay = shinsakaiKaisaiDay;
        this.shinsakaiKaisaiJikan = shinsakaiKaisaiJikan;
        this.yusenWaritsukesha = yusenWaritsukesha;
        this.kaisaiNumber = kaisaiNumber;
        this.gogitai = gogitai;
        this.nijihanteiKanryoDay = nijihanteiKanryoDay;
        this.nijihanteiKekkaToroku = nijihanteiKekkaToroku;
        this.nyuryokuHoho = nyuryokuHoho;
        this.nijihanteiKekka = nijihanteiKekka;
        this.nijihanteiYukoKikan = nijihanteiYukoKikan;
        this.nijihanteiShinsakaiKaisaiDay = nijihanteiShinsakaiKaisaiDay;
        this.nijihanteiKaisaiNumber = nijihanteiKaisaiNumber;
        this.getsureiShoriKanryoDay = getsureiShoriKanryoDay;
        this.centerSoshinDay = centerSoshinDay;
        this.keikaNissu = keikaNissu;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
        this.ninteiChosainCode = ninteiChosainCode;
        this.chikuCode = chikuCode;
        this.nijiHanteiYokaigoJotaiKubunCode = nijiHanteiYokaigoJotaiKubunCode;
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
        this.nyushoShisetsuCode = nyushoShisetsuCode;
        this.cyoSaHyo = cyoSaHyo;
        this.cyoSaHyoToKi = cyoSaHyoToKi;
        this.jyuJiIiKenJyo = jyuJiIiKenJyo;
        this.soNoTaShiRyo = soNoTaShiRyo;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public TextBoxDate getNinteiShinseiDay() {
        return ninteiShinseiDay;
    }

    public RString getHihoNumber() {
        return hihoNumber;
    }

    public RString getHihoShimei() {
        return hihoShimei;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public RString getShinseiKubunHorei() {
        return shinseiKubunHorei;
    }

    public TextBoxDate getKoshinKanryoDay() {
        return koshinKanryoDay;
    }

    public TextBoxDate getKoshinTsuchiYMD() {
        return koshinTsuchiYMD;
    }

    public TextBoxDate getShinseiUketsukeKanryoDay() {
        return shinseiUketsukeKanryoDay;
    }

    public TextBoxDate getChosaIraiKanryoDay() {
        return chosaIraiKanryoDay;
    }

    public TextBoxNum getChosaIraiSaichosaCount() {
        return chosaIraiSaichosaCount;
    }

    public TextBoxDate getChosaIraishoHakkoDay() {
        return chosaIraishoHakkoDay;
    }

    public TextBoxDate getChousahyoOutput() {
        return chousahyoOutput;
    }

    public TextBoxDate getChosaIraiDataShutsuryokuDay() {
        return chosaIraiDataShutsuryokuDay;
    }

    public TextBoxDate getChosaIraiKigen() {
        return chosaIraiKigen;
    }

    public RString getChosaIraiKubun() {
        return chosaIraiKubun;
    }

    public RString getKonkaiChosaItakusaki() {
        return konkaiChosaItakusaki;
    }

    public RString getKonkaiChosain() {
        return konkaiChosain;
    }

    public TextBoxNum getKonkaiChosaCount() {
        return konkaiChosaCount;
    }

    public RString getZenkaiChosaItakusaki() {
        return zenkaiChosaItakusaki;
    }

    public RString getZenkaiChosain() {
        return zenkaiChosain;
    }

    public RString getZenzenkaiChosaItakusaki() {
        return zenzenkaiChosaItakusaki;
    }

    public RString getZenzenkaiChosain() {
        return zenzenkaiChosain;
    }

    public TextBoxDate getChosahyoKanryoDay() {
        return chosahyoKanryoDay;
    }

    public TextBoxDate getChosahyoDataNyuryokuDay() {
        return chosahyoDataNyuryokuDay;
    }

    public TextBoxDate getIkenshoIraiKanryoDay() {
        return ikenshoIraiKanryoDay;
    }

    public TextBoxNum getIkenshoIraiIkenCount() {
        return ikenshoIraiIkenCount;
    }

    public TextBoxDate getIkenshoIraiDay() {
        return ikenshoIraiDay;
    }

    public TextBoxDate getIkenshoIraiIraishoHakkoDay() {
        return ikenshoIraiIraishoHakkoDay;
    }

    public TextBoxDate getIkenshoIraiIkenshoShutsuryokuDay() {
        return ikenshoIraiIkenshoShutsuryokuDay;
    }

    public TextBoxDate getIkenshoIraiKigen() {
        return ikenshoIraiKigen;
    }

    public TextBoxDate getIkenshoNyushuKanryoDay() {
        return ikenshoNyushuKanryoDay;
    }

    public TextBoxDate getIkenshoNyushuTeikei() {
        return ikenshoNyushuTeikei;
    }

    public RString getIkenshoIraiShokai() {
        return ikenshoIraiShokai;
    }

    public RString getKonkaiShujiiIryokikan() {
        return konkaiShujiiIryokikan;
    }

    public RString getKonkaiShujii() {
        return konkaiShujii;
    }

    public RString getZenkaiIryokikan() {
        return zenkaiIryokikan;
    }

    public RString getZenkaiShujii() {
        return zenkaiShujii;
    }

    public RString getYubinNumber() {
        return yubinNumber;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getNyushoShisetsu() {
        return nyushoShisetsu;
    }

    public TextBoxDate getChosaTokusokuHakkoDay() {
        return chosaTokusokuHakkoDay;
    }

    public RString getChosaTokusokuHoho() {
        return chosaTokusokuHoho;
    }

    public TextBoxNum getChosaTokusokuCount() {
        return chosaTokusokuCount;
    }

    public TextBoxDate getChosaTokusokuLiit() {
        return chosaTokusokuLiit;
    }

    public RString getChosaTokusokuChiku() {
        return chosaTokusokuChiku;
    }

    public TextBoxDate getIkenshoTokusokuHakkoDay() {
        return ikenshoTokusokuHakkoDay;
    }

    public RString getIkenshoTokusokuHoho() {
        return ikenshoTokusokuHoho;
    }

    public TextBoxNum getIkenshoTokusokuCount() {
        return ikenshoTokusokuCount;
    }

    public TextBoxDate getIkenshoTokusokuLimit() {
        return ikenshoTokusokuLimit;
    }

    public TextBoxDate getIchijiHanteiKanryoDay() {
        return ichijiHanteiKanryoDay;
    }

    public TextBoxDate getIchijiHanteiKanri() {
        return ichijiHanteiKanri;
    }

    public TextBoxDate getIchijiHantei() {
        return ichijiHantei;
    }

    public RString getIchijiHanteiKekka() {
        return ichijiHanteiKekka;
    }

    public RString getIchijiHanteiWarningCode() {
        return ichijiHanteiWarningCode;
    }

    public TextBoxDate getMaskingKanryoDay() {
        return maskingKanryoDay;
    }

    public TextBoxDate getShinsakaiKanryoDay() {
        return shinsakaiKanryoDay;
    }

    public TextBoxDate getShinsakaiwaritukeDay() {
        return shinsakaiwaritukeDay;
    }

    public TextBoxDate getShinsakaiKaisaiDay() {
        return shinsakaiKaisaiDay;
    }

    public TextBoxTime getShinsakaiKaisaiJikan() {
        return shinsakaiKaisaiJikan;
    }

    public RString getYusenWaritsukesha() {
        return yusenWaritsukesha;
    }

    public RString getKaisaiNumber() {
        return kaisaiNumber;
    }

    public RString getGogitai() {
        return gogitai;
    }

    public TextBoxDate getNijihanteiKanryoDay() {
        return nijihanteiKanryoDay;
    }

    public TextBoxDate getNijihanteiKekkaToroku() {
        return nijihanteiKekkaToroku;
    }

    public RString getNyuryokuHoho() {
        return nyuryokuHoho;
    }

    public RString getNijihanteiKekka() {
        return nijihanteiKekka;
    }

    public RString getNijihanteiYukoKikan() {
        return nijihanteiYukoKikan;
    }

    public TextBoxDate getNijihanteiShinsakaiKaisaiDay() {
        return nijihanteiShinsakaiKaisaiDay;
    }

    public RString getNijihanteiKaisaiNumber() {
        return nijihanteiKaisaiNumber;
    }

    public TextBoxDate getGetsureiShoriKanryoDay() {
        return getsureiShoriKanryoDay;
    }

    public TextBoxDate getCenterSoshinDay() {
        return centerSoshinDay;
    }

    public TextBoxNum getKeikaNissu() {
        return keikaNissu;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public RString getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    public RString getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    public RString getNinteiChosaItakusakiCode() {
        return ninteiChosaItakusakiCode;
    }

    public RString getNinteiChosainCode() {
        return ninteiChosainCode;
    }

    public RString getChikuCode() {
        return chikuCode;
    }

    public RString getNijiHanteiYokaigoJotaiKubunCode() {
        return nijiHanteiYokaigoJotaiKubunCode;
    }

    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    public RString getNyushoShisetsuCode() {
        return nyushoShisetsuCode;
    }

    public RString getCyoSaHyo() {
        return cyoSaHyo;
    }

    public RString getCyoSaHyoToKi() {
        return cyoSaHyoToKi;
    }

    public RString getJyuJiIiKenJyo() {
        return jyuJiIiKenJyo;
    }

    public RString getSoNoTaShiRyo() {
        return soNoTaShiRyo;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setNinteiShinseiDay(TextBoxDate ninteiShinseiDay) {
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.ninteiShinseiDay = ninteiShinseiDay;
    }

    public void setHihoNumber(RString hihoNumber) {
        this.setOriginalData("hihoNumber", hihoNumber);
        this.hihoNumber = hihoNumber;
    }

    public void setHihoShimei(RString hihoShimei) {
        this.setOriginalData("hihoShimei", hihoShimei);
        this.hihoShimei = hihoShimei;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public void setShinseiKubunHorei(RString shinseiKubunHorei) {
        this.setOriginalData("shinseiKubunHorei", shinseiKubunHorei);
        this.shinseiKubunHorei = shinseiKubunHorei;
    }

    public void setKoshinKanryoDay(TextBoxDate koshinKanryoDay) {
        this.setOriginalData("koshinKanryoDay", koshinKanryoDay);
        this.koshinKanryoDay = koshinKanryoDay;
    }

    public void setKoshinTsuchiYMD(TextBoxDate koshinTsuchiYMD) {
        this.setOriginalData("koshinTsuchiYMD", koshinTsuchiYMD);
        this.koshinTsuchiYMD = koshinTsuchiYMD;
    }

    public void setShinseiUketsukeKanryoDay(TextBoxDate shinseiUketsukeKanryoDay) {
        this.setOriginalData("shinseiUketsukeKanryoDay", shinseiUketsukeKanryoDay);
        this.shinseiUketsukeKanryoDay = shinseiUketsukeKanryoDay;
    }

    public void setChosaIraiKanryoDay(TextBoxDate chosaIraiKanryoDay) {
        this.setOriginalData("chosaIraiKanryoDay", chosaIraiKanryoDay);
        this.chosaIraiKanryoDay = chosaIraiKanryoDay;
    }

    public void setChosaIraiSaichosaCount(TextBoxNum chosaIraiSaichosaCount) {
        this.setOriginalData("chosaIraiSaichosaCount", chosaIraiSaichosaCount);
        this.chosaIraiSaichosaCount = chosaIraiSaichosaCount;
    }

    public void setChosaIraishoHakkoDay(TextBoxDate chosaIraishoHakkoDay) {
        this.setOriginalData("chosaIraishoHakkoDay", chosaIraishoHakkoDay);
        this.chosaIraishoHakkoDay = chosaIraishoHakkoDay;
    }

    public void setChousahyoOutput(TextBoxDate chousahyoOutput) {
        this.setOriginalData("chousahyoOutput", chousahyoOutput);
        this.chousahyoOutput = chousahyoOutput;
    }

    public void setChosaIraiDataShutsuryokuDay(TextBoxDate chosaIraiDataShutsuryokuDay) {
        this.setOriginalData("chosaIraiDataShutsuryokuDay", chosaIraiDataShutsuryokuDay);
        this.chosaIraiDataShutsuryokuDay = chosaIraiDataShutsuryokuDay;
    }

    public void setChosaIraiKigen(TextBoxDate chosaIraiKigen) {
        this.setOriginalData("chosaIraiKigen", chosaIraiKigen);
        this.chosaIraiKigen = chosaIraiKigen;
    }

    public void setChosaIraiKubun(RString chosaIraiKubun) {
        this.setOriginalData("chosaIraiKubun", chosaIraiKubun);
        this.chosaIraiKubun = chosaIraiKubun;
    }

    public void setKonkaiChosaItakusaki(RString konkaiChosaItakusaki) {
        this.setOriginalData("konkaiChosaItakusaki", konkaiChosaItakusaki);
        this.konkaiChosaItakusaki = konkaiChosaItakusaki;
    }

    public void setKonkaiChosain(RString konkaiChosain) {
        this.setOriginalData("konkaiChosain", konkaiChosain);
        this.konkaiChosain = konkaiChosain;
    }

    public void setKonkaiChosaCount(TextBoxNum konkaiChosaCount) {
        this.setOriginalData("konkaiChosaCount", konkaiChosaCount);
        this.konkaiChosaCount = konkaiChosaCount;
    }

    public void setZenkaiChosaItakusaki(RString zenkaiChosaItakusaki) {
        this.setOriginalData("zenkaiChosaItakusaki", zenkaiChosaItakusaki);
        this.zenkaiChosaItakusaki = zenkaiChosaItakusaki;
    }

    public void setZenkaiChosain(RString zenkaiChosain) {
        this.setOriginalData("zenkaiChosain", zenkaiChosain);
        this.zenkaiChosain = zenkaiChosain;
    }

    public void setZenzenkaiChosaItakusaki(RString zenzenkaiChosaItakusaki) {
        this.setOriginalData("zenzenkaiChosaItakusaki", zenzenkaiChosaItakusaki);
        this.zenzenkaiChosaItakusaki = zenzenkaiChosaItakusaki;
    }

    public void setZenzenkaiChosain(RString zenzenkaiChosain) {
        this.setOriginalData("zenzenkaiChosain", zenzenkaiChosain);
        this.zenzenkaiChosain = zenzenkaiChosain;
    }

    public void setChosahyoKanryoDay(TextBoxDate chosahyoKanryoDay) {
        this.setOriginalData("chosahyoKanryoDay", chosahyoKanryoDay);
        this.chosahyoKanryoDay = chosahyoKanryoDay;
    }

    public void setChosahyoDataNyuryokuDay(TextBoxDate chosahyoDataNyuryokuDay) {
        this.setOriginalData("chosahyoDataNyuryokuDay", chosahyoDataNyuryokuDay);
        this.chosahyoDataNyuryokuDay = chosahyoDataNyuryokuDay;
    }

    public void setIkenshoIraiKanryoDay(TextBoxDate ikenshoIraiKanryoDay) {
        this.setOriginalData("ikenshoIraiKanryoDay", ikenshoIraiKanryoDay);
        this.ikenshoIraiKanryoDay = ikenshoIraiKanryoDay;
    }

    public void setIkenshoIraiIkenCount(TextBoxNum ikenshoIraiIkenCount) {
        this.setOriginalData("ikenshoIraiIkenCount", ikenshoIraiIkenCount);
        this.ikenshoIraiIkenCount = ikenshoIraiIkenCount;
    }

    public void setIkenshoIraiDay(TextBoxDate ikenshoIraiDay) {
        this.setOriginalData("ikenshoIraiDay", ikenshoIraiDay);
        this.ikenshoIraiDay = ikenshoIraiDay;
    }

    public void setIkenshoIraiIraishoHakkoDay(TextBoxDate ikenshoIraiIraishoHakkoDay) {
        this.setOriginalData("ikenshoIraiIraishoHakkoDay", ikenshoIraiIraishoHakkoDay);
        this.ikenshoIraiIraishoHakkoDay = ikenshoIraiIraishoHakkoDay;
    }

    public void setIkenshoIraiIkenshoShutsuryokuDay(TextBoxDate ikenshoIraiIkenshoShutsuryokuDay) {
        this.setOriginalData("ikenshoIraiIkenshoShutsuryokuDay", ikenshoIraiIkenshoShutsuryokuDay);
        this.ikenshoIraiIkenshoShutsuryokuDay = ikenshoIraiIkenshoShutsuryokuDay;
    }

    public void setIkenshoIraiKigen(TextBoxDate ikenshoIraiKigen) {
        this.setOriginalData("ikenshoIraiKigen", ikenshoIraiKigen);
        this.ikenshoIraiKigen = ikenshoIraiKigen;
    }

    public void setIkenshoNyushuKanryoDay(TextBoxDate ikenshoNyushuKanryoDay) {
        this.setOriginalData("ikenshoNyushuKanryoDay", ikenshoNyushuKanryoDay);
        this.ikenshoNyushuKanryoDay = ikenshoNyushuKanryoDay;
    }

    public void setIkenshoNyushuTeikei(TextBoxDate ikenshoNyushuTeikei) {
        this.setOriginalData("ikenshoNyushuTeikei", ikenshoNyushuTeikei);
        this.ikenshoNyushuTeikei = ikenshoNyushuTeikei;
    }

    public void setIkenshoIraiShokai(RString ikenshoIraiShokai) {
        this.setOriginalData("ikenshoIraiShokai", ikenshoIraiShokai);
        this.ikenshoIraiShokai = ikenshoIraiShokai;
    }

    public void setKonkaiShujiiIryokikan(RString konkaiShujiiIryokikan) {
        this.setOriginalData("konkaiShujiiIryokikan", konkaiShujiiIryokikan);
        this.konkaiShujiiIryokikan = konkaiShujiiIryokikan;
    }

    public void setKonkaiShujii(RString konkaiShujii) {
        this.setOriginalData("konkaiShujii", konkaiShujii);
        this.konkaiShujii = konkaiShujii;
    }

    public void setZenkaiIryokikan(RString zenkaiIryokikan) {
        this.setOriginalData("zenkaiIryokikan", zenkaiIryokikan);
        this.zenkaiIryokikan = zenkaiIryokikan;
    }

    public void setZenkaiShujii(RString zenkaiShujii) {
        this.setOriginalData("zenkaiShujii", zenkaiShujii);
        this.zenkaiShujii = zenkaiShujii;
    }

    public void setYubinNumber(RString yubinNumber) {
        this.setOriginalData("yubinNumber", yubinNumber);
        this.yubinNumber = yubinNumber;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setNyushoShisetsu(RString nyushoShisetsu) {
        this.setOriginalData("nyushoShisetsu", nyushoShisetsu);
        this.nyushoShisetsu = nyushoShisetsu;
    }

    public void setChosaTokusokuHakkoDay(TextBoxDate chosaTokusokuHakkoDay) {
        this.setOriginalData("chosaTokusokuHakkoDay", chosaTokusokuHakkoDay);
        this.chosaTokusokuHakkoDay = chosaTokusokuHakkoDay;
    }

    public void setChosaTokusokuHoho(RString chosaTokusokuHoho) {
        this.setOriginalData("chosaTokusokuHoho", chosaTokusokuHoho);
        this.chosaTokusokuHoho = chosaTokusokuHoho;
    }

    public void setChosaTokusokuCount(TextBoxNum chosaTokusokuCount) {
        this.setOriginalData("chosaTokusokuCount", chosaTokusokuCount);
        this.chosaTokusokuCount = chosaTokusokuCount;
    }

    public void setChosaTokusokuLiit(TextBoxDate chosaTokusokuLiit) {
        this.setOriginalData("chosaTokusokuLiit", chosaTokusokuLiit);
        this.chosaTokusokuLiit = chosaTokusokuLiit;
    }

    public void setChosaTokusokuChiku(RString chosaTokusokuChiku) {
        this.setOriginalData("chosaTokusokuChiku", chosaTokusokuChiku);
        this.chosaTokusokuChiku = chosaTokusokuChiku;
    }

    public void setIkenshoTokusokuHakkoDay(TextBoxDate ikenshoTokusokuHakkoDay) {
        this.setOriginalData("ikenshoTokusokuHakkoDay", ikenshoTokusokuHakkoDay);
        this.ikenshoTokusokuHakkoDay = ikenshoTokusokuHakkoDay;
    }

    public void setIkenshoTokusokuHoho(RString ikenshoTokusokuHoho) {
        this.setOriginalData("ikenshoTokusokuHoho", ikenshoTokusokuHoho);
        this.ikenshoTokusokuHoho = ikenshoTokusokuHoho;
    }

    public void setIkenshoTokusokuCount(TextBoxNum ikenshoTokusokuCount) {
        this.setOriginalData("ikenshoTokusokuCount", ikenshoTokusokuCount);
        this.ikenshoTokusokuCount = ikenshoTokusokuCount;
    }

    public void setIkenshoTokusokuLimit(TextBoxDate ikenshoTokusokuLimit) {
        this.setOriginalData("ikenshoTokusokuLimit", ikenshoTokusokuLimit);
        this.ikenshoTokusokuLimit = ikenshoTokusokuLimit;
    }

    public void setIchijiHanteiKanryoDay(TextBoxDate ichijiHanteiKanryoDay) {
        this.setOriginalData("ichijiHanteiKanryoDay", ichijiHanteiKanryoDay);
        this.ichijiHanteiKanryoDay = ichijiHanteiKanryoDay;
    }

    public void setIchijiHanteiKanri(TextBoxDate ichijiHanteiKanri) {
        this.setOriginalData("ichijiHanteiKanri", ichijiHanteiKanri);
        this.ichijiHanteiKanri = ichijiHanteiKanri;
    }

    public void setIchijiHantei(TextBoxDate ichijiHantei) {
        this.setOriginalData("ichijiHantei", ichijiHantei);
        this.ichijiHantei = ichijiHantei;
    }

    public void setIchijiHanteiKekka(RString ichijiHanteiKekka) {
        this.setOriginalData("ichijiHanteiKekka", ichijiHanteiKekka);
        this.ichijiHanteiKekka = ichijiHanteiKekka;
    }

    public void setIchijiHanteiWarningCode(RString ichijiHanteiWarningCode) {
        this.setOriginalData("ichijiHanteiWarningCode", ichijiHanteiWarningCode);
        this.ichijiHanteiWarningCode = ichijiHanteiWarningCode;
    }

    public void setMaskingKanryoDay(TextBoxDate maskingKanryoDay) {
        this.setOriginalData("maskingKanryoDay", maskingKanryoDay);
        this.maskingKanryoDay = maskingKanryoDay;
    }

    public void setShinsakaiKanryoDay(TextBoxDate shinsakaiKanryoDay) {
        this.setOriginalData("shinsakaiKanryoDay", shinsakaiKanryoDay);
        this.shinsakaiKanryoDay = shinsakaiKanryoDay;
    }

    public void setShinsakaiwaritukeDay(TextBoxDate shinsakaiwaritukeDay) {
        this.setOriginalData("shinsakaiwaritukeDay", shinsakaiwaritukeDay);
        this.shinsakaiwaritukeDay = shinsakaiwaritukeDay;
    }

    public void setShinsakaiKaisaiDay(TextBoxDate shinsakaiKaisaiDay) {
        this.setOriginalData("shinsakaiKaisaiDay", shinsakaiKaisaiDay);
        this.shinsakaiKaisaiDay = shinsakaiKaisaiDay;
    }

    public void setShinsakaiKaisaiJikan(TextBoxTime shinsakaiKaisaiJikan) {
        this.setOriginalData("shinsakaiKaisaiJikan", shinsakaiKaisaiJikan);
        this.shinsakaiKaisaiJikan = shinsakaiKaisaiJikan;
    }

    public void setYusenWaritsukesha(RString yusenWaritsukesha) {
        this.setOriginalData("yusenWaritsukesha", yusenWaritsukesha);
        this.yusenWaritsukesha = yusenWaritsukesha;
    }

    public void setKaisaiNumber(RString kaisaiNumber) {
        this.setOriginalData("kaisaiNumber", kaisaiNumber);
        this.kaisaiNumber = kaisaiNumber;
    }

    public void setGogitai(RString gogitai) {
        this.setOriginalData("gogitai", gogitai);
        this.gogitai = gogitai;
    }

    public void setNijihanteiKanryoDay(TextBoxDate nijihanteiKanryoDay) {
        this.setOriginalData("nijihanteiKanryoDay", nijihanteiKanryoDay);
        this.nijihanteiKanryoDay = nijihanteiKanryoDay;
    }

    public void setNijihanteiKekkaToroku(TextBoxDate nijihanteiKekkaToroku) {
        this.setOriginalData("nijihanteiKekkaToroku", nijihanteiKekkaToroku);
        this.nijihanteiKekkaToroku = nijihanteiKekkaToroku;
    }

    public void setNyuryokuHoho(RString nyuryokuHoho) {
        this.setOriginalData("nyuryokuHoho", nyuryokuHoho);
        this.nyuryokuHoho = nyuryokuHoho;
    }

    public void setNijihanteiKekka(RString nijihanteiKekka) {
        this.setOriginalData("nijihanteiKekka", nijihanteiKekka);
        this.nijihanteiKekka = nijihanteiKekka;
    }

    public void setNijihanteiYukoKikan(RString nijihanteiYukoKikan) {
        this.setOriginalData("nijihanteiYukoKikan", nijihanteiYukoKikan);
        this.nijihanteiYukoKikan = nijihanteiYukoKikan;
    }

    public void setNijihanteiShinsakaiKaisaiDay(TextBoxDate nijihanteiShinsakaiKaisaiDay) {
        this.setOriginalData("nijihanteiShinsakaiKaisaiDay", nijihanteiShinsakaiKaisaiDay);
        this.nijihanteiShinsakaiKaisaiDay = nijihanteiShinsakaiKaisaiDay;
    }

    public void setNijihanteiKaisaiNumber(RString nijihanteiKaisaiNumber) {
        this.setOriginalData("nijihanteiKaisaiNumber", nijihanteiKaisaiNumber);
        this.nijihanteiKaisaiNumber = nijihanteiKaisaiNumber;
    }

    public void setGetsureiShoriKanryoDay(TextBoxDate getsureiShoriKanryoDay) {
        this.setOriginalData("getsureiShoriKanryoDay", getsureiShoriKanryoDay);
        this.getsureiShoriKanryoDay = getsureiShoriKanryoDay;
    }

    public void setCenterSoshinDay(TextBoxDate centerSoshinDay) {
        this.setOriginalData("centerSoshinDay", centerSoshinDay);
        this.centerSoshinDay = centerSoshinDay;
    }

    public void setKeikaNissu(TextBoxNum keikaNissu) {
        this.setOriginalData("keikaNissu", keikaNissu);
        this.keikaNissu = keikaNissu;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setNinteichosaIraiRirekiNo(RString ninteichosaIraiRirekiNo) {
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    public void setIkenshoIraiRirekiNo(RString ikenshoIraiRirekiNo) {
        this.setOriginalData("ikenshoIraiRirekiNo", ikenshoIraiRirekiNo);
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    public void setNinteiChosaItakusakiCode(RString ninteiChosaItakusakiCode) {
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
    }

    public void setNinteiChosainCode(RString ninteiChosainCode) {
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.ninteiChosainCode = ninteiChosainCode;
    }

    public void setChikuCode(RString chikuCode) {
        this.setOriginalData("chikuCode", chikuCode);
        this.chikuCode = chikuCode;
    }

    public void setNijiHanteiYokaigoJotaiKubunCode(RString nijiHanteiYokaigoJotaiKubunCode) {
        this.setOriginalData("nijiHanteiYokaigoJotaiKubunCode", nijiHanteiYokaigoJotaiKubunCode);
        this.nijiHanteiYokaigoJotaiKubunCode = nijiHanteiYokaigoJotaiKubunCode;
    }

    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    public void setNyushoShisetsuCode(RString nyushoShisetsuCode) {
        this.setOriginalData("nyushoShisetsuCode", nyushoShisetsuCode);
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    public void setCyoSaHyo(RString cyoSaHyo) {
        this.setOriginalData("cyoSaHyo", cyoSaHyo);
        this.cyoSaHyo = cyoSaHyo;
    }

    public void setCyoSaHyoToKi(RString cyoSaHyoToKi) {
        this.setOriginalData("cyoSaHyoToKi", cyoSaHyoToKi);
        this.cyoSaHyoToKi = cyoSaHyoToKi;
    }

    public void setJyuJiIiKenJyo(RString jyuJiIiKenJyo) {
        this.setOriginalData("jyuJiIiKenJyo", jyuJiIiKenJyo);
        this.jyuJiIiKenJyo = jyuJiIiKenJyo;
    }

    public void setSoNoTaShiRyo(RString soNoTaShiRyo) {
        this.setOriginalData("soNoTaShiRyo", soNoTaShiRyo);
        this.soNoTaShiRyo = soNoTaShiRyo;
    }

    // </editor-fold>
}
