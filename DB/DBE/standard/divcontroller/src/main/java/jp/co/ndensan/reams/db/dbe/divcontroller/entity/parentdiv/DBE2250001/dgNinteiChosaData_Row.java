package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Feb 22 11:23:24 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgNinteiChosaData_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteiChosaData_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-20_05-03-35">

    private RString jyotai;
    private RString hokenja;
    private TextBoxFlexibleDate ninteiShinseiYMD;
    private TextBoxCode hihokenshaNo;
    private RString hihokenshaName;
    private RString ninteiShinseiShinseijiKubunCode;
    private TextBoxFlexibleDate ninteichosaIraiKanryoYMD;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosaItakusakimei;
    private RString ninteiChosainCode;
    private RString ninteiChosainName;
    private TextBoxFlexibleDate ninteichosaJisshiYMD;
    private RString shinseishoKanriNo;
    private TextBoxNum ninteichosaIraiRirekiNo;
    private RString remban;
    private RString koroshoIfShikibetsuCode;
    private RString shisetsuRiyoFlag;
    private RString serviceJokyoKinyu;
    private RString serviceJokyo;
    private RString researchItem;
    private RString ninchishoNichijoSeikatsuJiritsudoCode;
    private RString shogaiNichijoSeikatsuJiritsudoCode;
    private RString ninteichosaTokkijikoNoRemban;
    private RString gaikyoTokkiTextImageKubun;
    private RString jutakuKaishu;
    private RString tokubetsuKyufuService;
    private RString zaitakuService;
    private RString shuso;
    private RString kazokuJokyo;
    private RString kyojuKankyo;
    private RString kikaiKiki;
    private RString ninteichousaIraiKubunCode;
    private RString ninteichosaIraiKaisu;
    private TextBoxFlexibleDate ninteichosaJuryoYMD;
    private RString ninteiChosaKubunCode;
    private RString chosaJisshiBashoCode;
    private RString chosaJisshiBashoMeisho;
    private RString serviceKubunCode;
    private RString riyoShisetsuShimei;
    private RString riyoShisetsuJusho;
    private RString riyoShisetsuTelNo;
    private RString riyoShisetsuYubinNo;
    private RString tokki;
    private TextBoxFlexibleDate tokkijikoUketsukeYMD;
    private TextBoxFlexibleDate tokkijikoJuryoYMD;
    private RString serviceJokyoFlag;
    private RString serviceJokyoRemban;
    private RString serviceJokyoFlagRemban;
    private RString serviceJokyoKinyuRemban;
    private RString shisetsuRiyoFlagRemban;
    private RString errorJiyu;

    public dgNinteiChosaData_Row() {
        super();
        this.jyotai = RString.EMPTY;
        this.hokenja = RString.EMPTY;
        this.ninteiShinseiYMD = new TextBoxFlexibleDate();
        this.hihokenshaNo = new TextBoxCode();
        this.hihokenshaName = RString.EMPTY;
        this.ninteiShinseiShinseijiKubunCode = RString.EMPTY;
        this.ninteichosaIraiKanryoYMD = new TextBoxFlexibleDate();
        this.ninteiChosaItakusakiCode = RString.EMPTY;
        this.ninteiChosaItakusakimei = RString.EMPTY;
        this.ninteiChosainCode = RString.EMPTY;
        this.ninteiChosainName = RString.EMPTY;
        this.ninteichosaJisshiYMD = new TextBoxFlexibleDate();
        this.shinseishoKanriNo = RString.EMPTY;
        this.ninteichosaIraiRirekiNo = new TextBoxNum();
        this.remban = RString.EMPTY;
        this.koroshoIfShikibetsuCode = RString.EMPTY;
        this.shisetsuRiyoFlag = RString.EMPTY;
        this.serviceJokyoKinyu = RString.EMPTY;
        this.serviceJokyo = RString.EMPTY;
        this.researchItem = RString.EMPTY;
        this.ninchishoNichijoSeikatsuJiritsudoCode = RString.EMPTY;
        this.shogaiNichijoSeikatsuJiritsudoCode = RString.EMPTY;
        this.ninteichosaTokkijikoNoRemban = RString.EMPTY;
        this.gaikyoTokkiTextImageKubun = RString.EMPTY;
        this.jutakuKaishu = RString.EMPTY;
        this.tokubetsuKyufuService = RString.EMPTY;
        this.zaitakuService = RString.EMPTY;
        this.shuso = RString.EMPTY;
        this.kazokuJokyo = RString.EMPTY;
        this.kyojuKankyo = RString.EMPTY;
        this.kikaiKiki = RString.EMPTY;
        this.ninteichousaIraiKubunCode = RString.EMPTY;
        this.ninteichosaIraiKaisu = RString.EMPTY;
        this.ninteichosaJuryoYMD = new TextBoxFlexibleDate();
        this.ninteiChosaKubunCode = RString.EMPTY;
        this.chosaJisshiBashoCode = RString.EMPTY;
        this.chosaJisshiBashoMeisho = RString.EMPTY;
        this.serviceKubunCode = RString.EMPTY;
        this.riyoShisetsuShimei = RString.EMPTY;
        this.riyoShisetsuJusho = RString.EMPTY;
        this.riyoShisetsuTelNo = RString.EMPTY;
        this.riyoShisetsuYubinNo = RString.EMPTY;
        this.tokki = RString.EMPTY;
        this.tokkijikoUketsukeYMD = new TextBoxFlexibleDate();
        this.tokkijikoJuryoYMD = new TextBoxFlexibleDate();
        this.serviceJokyoFlag = RString.EMPTY;
        this.serviceJokyoRemban = RString.EMPTY;
        this.serviceJokyoFlagRemban = RString.EMPTY;
        this.serviceJokyoKinyuRemban = RString.EMPTY;
        this.shisetsuRiyoFlagRemban = RString.EMPTY;
        this.errorJiyu = RString.EMPTY;
        this.setOriginalData("jyotai", jyotai);
        this.setOriginalData("hokenja", hokenja);
        this.setOriginalData("ninteiShinseiYMD", ninteiShinseiYMD);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("ninteiShinseiShinseijiKubunCode", ninteiShinseiShinseijiKubunCode);
        this.setOriginalData("ninteichosaIraiKanryoYMD", ninteichosaIraiKanryoYMD);
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.setOriginalData("ninteiChosaItakusakimei", ninteiChosaItakusakimei);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("ninteiChosainName", ninteiChosainName);
        this.setOriginalData("ninteichosaJisshiYMD", ninteichosaJisshiYMD);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.setOriginalData("remban", remban);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.setOriginalData("shisetsuRiyoFlag", shisetsuRiyoFlag);
        this.setOriginalData("serviceJokyoKinyu", serviceJokyoKinyu);
        this.setOriginalData("serviceJokyo", serviceJokyo);
        this.setOriginalData("researchItem", researchItem);
        this.setOriginalData("ninchishoNichijoSeikatsuJiritsudoCode", ninchishoNichijoSeikatsuJiritsudoCode);
        this.setOriginalData("shogaiNichijoSeikatsuJiritsudoCode", shogaiNichijoSeikatsuJiritsudoCode);
        this.setOriginalData("ninteichosaTokkijikoNoRemban", ninteichosaTokkijikoNoRemban);
        this.setOriginalData("gaikyoTokkiTextImageKubun", gaikyoTokkiTextImageKubun);
        this.setOriginalData("jutakuKaishu", jutakuKaishu);
        this.setOriginalData("tokubetsuKyufuService", tokubetsuKyufuService);
        this.setOriginalData("zaitakuService", zaitakuService);
        this.setOriginalData("shuso", shuso);
        this.setOriginalData("kazokuJokyo", kazokuJokyo);
        this.setOriginalData("kyojuKankyo", kyojuKankyo);
        this.setOriginalData("kikaiKiki", kikaiKiki);
        this.setOriginalData("ninteichousaIraiKubunCode", ninteichousaIraiKubunCode);
        this.setOriginalData("ninteichosaIraiKaisu", ninteichosaIraiKaisu);
        this.setOriginalData("ninteichosaJuryoYMD", ninteichosaJuryoYMD);
        this.setOriginalData("ninteiChosaKubunCode", ninteiChosaKubunCode);
        this.setOriginalData("chosaJisshiBashoCode", chosaJisshiBashoCode);
        this.setOriginalData("chosaJisshiBashoMeisho", chosaJisshiBashoMeisho);
        this.setOriginalData("serviceKubunCode", serviceKubunCode);
        this.setOriginalData("riyoShisetsuShimei", riyoShisetsuShimei);
        this.setOriginalData("riyoShisetsuJusho", riyoShisetsuJusho);
        this.setOriginalData("riyoShisetsuTelNo", riyoShisetsuTelNo);
        this.setOriginalData("riyoShisetsuYubinNo", riyoShisetsuYubinNo);
        this.setOriginalData("tokki", tokki);
        this.setOriginalData("tokkijikoUketsukeYMD", tokkijikoUketsukeYMD);
        this.setOriginalData("tokkijikoJuryoYMD", tokkijikoJuryoYMD);
        this.setOriginalData("serviceJokyoFlag", serviceJokyoFlag);
        this.setOriginalData("serviceJokyoRemban", serviceJokyoRemban);
        this.setOriginalData("serviceJokyoFlagRemban", serviceJokyoFlagRemban);
        this.setOriginalData("serviceJokyoKinyuRemban", serviceJokyoKinyuRemban);
        this.setOriginalData("shisetsuRiyoFlagRemban", shisetsuRiyoFlagRemban);
        this.setOriginalData("errorJiyu", errorJiyu);
    }

    public dgNinteiChosaData_Row(RString jyotai, RString hokenja, TextBoxFlexibleDate ninteiShinseiYMD, TextBoxCode hihokenshaNo, RString hihokenshaName, RString ninteiShinseiShinseijiKubunCode, TextBoxFlexibleDate ninteichosaIraiKanryoYMD, RString ninteiChosaItakusakiCode, RString ninteiChosaItakusakimei, RString ninteiChosainCode, RString ninteiChosainName, TextBoxFlexibleDate ninteichosaJisshiYMD, RString shinseishoKanriNo, TextBoxNum ninteichosaIraiRirekiNo, RString remban, RString koroshoIfShikibetsuCode, RString shisetsuRiyoFlag, RString serviceJokyoKinyu, RString serviceJokyo, RString researchItem, RString ninchishoNichijoSeikatsuJiritsudoCode, RString shogaiNichijoSeikatsuJiritsudoCode, RString ninteichosaTokkijikoNoRemban, RString gaikyoTokkiTextImageKubun, RString jutakuKaishu, RString tokubetsuKyufuService, RString zaitakuService, RString shuso, RString kazokuJokyo, RString kyojuKankyo, RString kikaiKiki, RString ninteichousaIraiKubunCode, RString ninteichosaIraiKaisu, TextBoxFlexibleDate ninteichosaJuryoYMD, RString ninteiChosaKubunCode, RString chosaJisshiBashoCode, RString chosaJisshiBashoMeisho, RString serviceKubunCode, RString riyoShisetsuShimei, RString riyoShisetsuJusho, RString riyoShisetsuTelNo, RString riyoShisetsuYubinNo, RString tokki, TextBoxFlexibleDate tokkijikoUketsukeYMD, TextBoxFlexibleDate tokkijikoJuryoYMD, RString serviceJokyoFlag, RString serviceJokyoRemban, RString serviceJokyoFlagRemban, RString serviceJokyoKinyuRemban, RString shisetsuRiyoFlagRemban, RString errorJiyu) {
        super();
        this.setOriginalData("jyotai", jyotai);
        this.setOriginalData("hokenja", hokenja);
        this.setOriginalData("ninteiShinseiYMD", ninteiShinseiYMD);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("ninteiShinseiShinseijiKubunCode", ninteiShinseiShinseijiKubunCode);
        this.setOriginalData("ninteichosaIraiKanryoYMD", ninteichosaIraiKanryoYMD);
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.setOriginalData("ninteiChosaItakusakimei", ninteiChosaItakusakimei);
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.setOriginalData("ninteiChosainName", ninteiChosainName);
        this.setOriginalData("ninteichosaJisshiYMD", ninteichosaJisshiYMD);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.setOriginalData("remban", remban);
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.setOriginalData("shisetsuRiyoFlag", shisetsuRiyoFlag);
        this.setOriginalData("serviceJokyoKinyu", serviceJokyoKinyu);
        this.setOriginalData("serviceJokyo", serviceJokyo);
        this.setOriginalData("researchItem", researchItem);
        this.setOriginalData("ninchishoNichijoSeikatsuJiritsudoCode", ninchishoNichijoSeikatsuJiritsudoCode);
        this.setOriginalData("shogaiNichijoSeikatsuJiritsudoCode", shogaiNichijoSeikatsuJiritsudoCode);
        this.setOriginalData("ninteichosaTokkijikoNoRemban", ninteichosaTokkijikoNoRemban);
        this.setOriginalData("gaikyoTokkiTextImageKubun", gaikyoTokkiTextImageKubun);
        this.setOriginalData("jutakuKaishu", jutakuKaishu);
        this.setOriginalData("tokubetsuKyufuService", tokubetsuKyufuService);
        this.setOriginalData("zaitakuService", zaitakuService);
        this.setOriginalData("shuso", shuso);
        this.setOriginalData("kazokuJokyo", kazokuJokyo);
        this.setOriginalData("kyojuKankyo", kyojuKankyo);
        this.setOriginalData("kikaiKiki", kikaiKiki);
        this.setOriginalData("ninteichousaIraiKubunCode", ninteichousaIraiKubunCode);
        this.setOriginalData("ninteichosaIraiKaisu", ninteichosaIraiKaisu);
        this.setOriginalData("ninteichosaJuryoYMD", ninteichosaJuryoYMD);
        this.setOriginalData("ninteiChosaKubunCode", ninteiChosaKubunCode);
        this.setOriginalData("chosaJisshiBashoCode", chosaJisshiBashoCode);
        this.setOriginalData("chosaJisshiBashoMeisho", chosaJisshiBashoMeisho);
        this.setOriginalData("serviceKubunCode", serviceKubunCode);
        this.setOriginalData("riyoShisetsuShimei", riyoShisetsuShimei);
        this.setOriginalData("riyoShisetsuJusho", riyoShisetsuJusho);
        this.setOriginalData("riyoShisetsuTelNo", riyoShisetsuTelNo);
        this.setOriginalData("riyoShisetsuYubinNo", riyoShisetsuYubinNo);
        this.setOriginalData("tokki", tokki);
        this.setOriginalData("tokkijikoUketsukeYMD", tokkijikoUketsukeYMD);
        this.setOriginalData("tokkijikoJuryoYMD", tokkijikoJuryoYMD);
        this.setOriginalData("serviceJokyoFlag", serviceJokyoFlag);
        this.setOriginalData("serviceJokyoRemban", serviceJokyoRemban);
        this.setOriginalData("serviceJokyoFlagRemban", serviceJokyoFlagRemban);
        this.setOriginalData("serviceJokyoKinyuRemban", serviceJokyoKinyuRemban);
        this.setOriginalData("shisetsuRiyoFlagRemban", shisetsuRiyoFlagRemban);
        this.setOriginalData("errorJiyu", errorJiyu);
        this.jyotai = jyotai;
        this.hokenja = hokenja;
        this.ninteiShinseiYMD = ninteiShinseiYMD;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
        this.ninteichosaIraiKanryoYMD = ninteichosaIraiKanryoYMD;
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
        this.ninteiChosaItakusakimei = ninteiChosaItakusakimei;
        this.ninteiChosainCode = ninteiChosainCode;
        this.ninteiChosainName = ninteiChosainName;
        this.ninteichosaJisshiYMD = ninteichosaJisshiYMD;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
        this.remban = remban;
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
        this.shisetsuRiyoFlag = shisetsuRiyoFlag;
        this.serviceJokyoKinyu = serviceJokyoKinyu;
        this.serviceJokyo = serviceJokyo;
        this.researchItem = researchItem;
        this.ninchishoNichijoSeikatsuJiritsudoCode = ninchishoNichijoSeikatsuJiritsudoCode;
        this.shogaiNichijoSeikatsuJiritsudoCode = shogaiNichijoSeikatsuJiritsudoCode;
        this.ninteichosaTokkijikoNoRemban = ninteichosaTokkijikoNoRemban;
        this.gaikyoTokkiTextImageKubun = gaikyoTokkiTextImageKubun;
        this.jutakuKaishu = jutakuKaishu;
        this.tokubetsuKyufuService = tokubetsuKyufuService;
        this.zaitakuService = zaitakuService;
        this.shuso = shuso;
        this.kazokuJokyo = kazokuJokyo;
        this.kyojuKankyo = kyojuKankyo;
        this.kikaiKiki = kikaiKiki;
        this.ninteichousaIraiKubunCode = ninteichousaIraiKubunCode;
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
        this.ninteichosaJuryoYMD = ninteichosaJuryoYMD;
        this.ninteiChosaKubunCode = ninteiChosaKubunCode;
        this.chosaJisshiBashoCode = chosaJisshiBashoCode;
        this.chosaJisshiBashoMeisho = chosaJisshiBashoMeisho;
        this.serviceKubunCode = serviceKubunCode;
        this.riyoShisetsuShimei = riyoShisetsuShimei;
        this.riyoShisetsuJusho = riyoShisetsuJusho;
        this.riyoShisetsuTelNo = riyoShisetsuTelNo;
        this.riyoShisetsuYubinNo = riyoShisetsuYubinNo;
        this.tokki = tokki;
        this.tokkijikoUketsukeYMD = tokkijikoUketsukeYMD;
        this.tokkijikoJuryoYMD = tokkijikoJuryoYMD;
        this.serviceJokyoFlag = serviceJokyoFlag;
        this.serviceJokyoRemban = serviceJokyoRemban;
        this.serviceJokyoFlagRemban = serviceJokyoFlagRemban;
        this.serviceJokyoKinyuRemban = serviceJokyoKinyuRemban;
        this.shisetsuRiyoFlagRemban = shisetsuRiyoFlagRemban;
        this.errorJiyu = errorJiyu;
    }

    public RString getJyotai() {
        return jyotai;
    }

    public RString getHokenja() {
        return hokenja;
    }

    public TextBoxFlexibleDate getNinteiShinseiYMD() {
        return ninteiShinseiYMD;
    }

    public TextBoxCode getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getHihokenshaName() {
        return hihokenshaName;
    }

    public RString getNinteiShinseiShinseijiKubunCode() {
        return ninteiShinseiShinseijiKubunCode;
    }

    public TextBoxFlexibleDate getNinteichosaIraiKanryoYMD() {
        return ninteichosaIraiKanryoYMD;
    }

    public RString getNinteiChosaItakusakiCode() {
        return ninteiChosaItakusakiCode;
    }

    public RString getNinteiChosaItakusakimei() {
        return ninteiChosaItakusakimei;
    }

    public RString getNinteiChosainCode() {
        return ninteiChosainCode;
    }

    public RString getNinteiChosainName() {
        return ninteiChosainName;
    }

    public TextBoxFlexibleDate getNinteichosaJisshiYMD() {
        return ninteichosaJisshiYMD;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public TextBoxNum getNinteichosaIraiRirekiNo() {
        return ninteichosaIraiRirekiNo;
    }

    public RString getRemban() {
        return remban;
    }

    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    public RString getShisetsuRiyoFlag() {
        return shisetsuRiyoFlag;
    }

    public RString getServiceJokyoKinyu() {
        return serviceJokyoKinyu;
    }

    public RString getServiceJokyo() {
        return serviceJokyo;
    }

    public RString getResearchItem() {
        return researchItem;
    }

    public RString getNinchishoNichijoSeikatsuJiritsudoCode() {
        return ninchishoNichijoSeikatsuJiritsudoCode;
    }

    public RString getShogaiNichijoSeikatsuJiritsudoCode() {
        return shogaiNichijoSeikatsuJiritsudoCode;
    }

    public RString getNinteichosaTokkijikoNoRemban() {
        return ninteichosaTokkijikoNoRemban;
    }

    public RString getGaikyoTokkiTextImageKubun() {
        return gaikyoTokkiTextImageKubun;
    }

    public RString getJutakuKaishu() {
        return jutakuKaishu;
    }

    public RString getTokubetsuKyufuService() {
        return tokubetsuKyufuService;
    }

    public RString getZaitakuService() {
        return zaitakuService;
    }

    public RString getShuso() {
        return shuso;
    }

    public RString getKazokuJokyo() {
        return kazokuJokyo;
    }

    public RString getKyojuKankyo() {
        return kyojuKankyo;
    }

    public RString getKikaiKiki() {
        return kikaiKiki;
    }

    public RString getNinteichousaIraiKubunCode() {
        return ninteichousaIraiKubunCode;
    }

    public RString getNinteichosaIraiKaisu() {
        return ninteichosaIraiKaisu;
    }

    public TextBoxFlexibleDate getNinteichosaJuryoYMD() {
        return ninteichosaJuryoYMD;
    }

    public RString getNinteiChosaKubunCode() {
        return ninteiChosaKubunCode;
    }

    public RString getChosaJisshiBashoCode() {
        return chosaJisshiBashoCode;
    }

    public RString getChosaJisshiBashoMeisho() {
        return chosaJisshiBashoMeisho;
    }

    public RString getServiceKubunCode() {
        return serviceKubunCode;
    }

    public RString getRiyoShisetsuShimei() {
        return riyoShisetsuShimei;
    }

    public RString getRiyoShisetsuJusho() {
        return riyoShisetsuJusho;
    }

    public RString getRiyoShisetsuTelNo() {
        return riyoShisetsuTelNo;
    }

    public RString getRiyoShisetsuYubinNo() {
        return riyoShisetsuYubinNo;
    }

    public RString getTokki() {
        return tokki;
    }

    public TextBoxFlexibleDate getTokkijikoUketsukeYMD() {
        return tokkijikoUketsukeYMD;
    }

    public TextBoxFlexibleDate getTokkijikoJuryoYMD() {
        return tokkijikoJuryoYMD;
    }

    public RString getServiceJokyoFlag() {
        return serviceJokyoFlag;
    }

    public RString getServiceJokyoRemban() {
        return serviceJokyoRemban;
    }

    public RString getServiceJokyoFlagRemban() {
        return serviceJokyoFlagRemban;
    }

    public RString getServiceJokyoKinyuRemban() {
        return serviceJokyoKinyuRemban;
    }

    public RString getShisetsuRiyoFlagRemban() {
        return shisetsuRiyoFlagRemban;
    }

    public RString getErrorJiyu() {
        return errorJiyu;
    }

    public void setJyotai(RString jyotai) {
        this.setOriginalData("jyotai", jyotai);
        this.jyotai = jyotai;
    }

    public void setHokenja(RString hokenja) {
        this.setOriginalData("hokenja", hokenja);
        this.hokenja = hokenja;
    }

    public void setNinteiShinseiYMD(TextBoxFlexibleDate ninteiShinseiYMD) {
        this.setOriginalData("ninteiShinseiYMD", ninteiShinseiYMD);
        this.ninteiShinseiYMD = ninteiShinseiYMD;
    }

    public void setHihokenshaNo(TextBoxCode hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setHihokenshaName(RString hihokenshaName) {
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.hihokenshaName = hihokenshaName;
    }

    public void setNinteiShinseiShinseijiKubunCode(RString ninteiShinseiShinseijiKubunCode) {
        this.setOriginalData("ninteiShinseiShinseijiKubunCode", ninteiShinseiShinseijiKubunCode);
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
    }

    public void setNinteichosaIraiKanryoYMD(TextBoxFlexibleDate ninteichosaIraiKanryoYMD) {
        this.setOriginalData("ninteichosaIraiKanryoYMD", ninteichosaIraiKanryoYMD);
        this.ninteichosaIraiKanryoYMD = ninteichosaIraiKanryoYMD;
    }

    public void setNinteiChosaItakusakiCode(RString ninteiChosaItakusakiCode) {
        this.setOriginalData("ninteiChosaItakusakiCode", ninteiChosaItakusakiCode);
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
    }

    public void setNinteiChosaItakusakimei(RString ninteiChosaItakusakimei) {
        this.setOriginalData("ninteiChosaItakusakimei", ninteiChosaItakusakimei);
        this.ninteiChosaItakusakimei = ninteiChosaItakusakimei;
    }

    public void setNinteiChosainCode(RString ninteiChosainCode) {
        this.setOriginalData("ninteiChosainCode", ninteiChosainCode);
        this.ninteiChosainCode = ninteiChosainCode;
    }

    public void setNinteiChosainName(RString ninteiChosainName) {
        this.setOriginalData("ninteiChosainName", ninteiChosainName);
        this.ninteiChosainName = ninteiChosainName;
    }

    public void setNinteichosaJisshiYMD(TextBoxFlexibleDate ninteichosaJisshiYMD) {
        this.setOriginalData("ninteichosaJisshiYMD", ninteichosaJisshiYMD);
        this.ninteichosaJisshiYMD = ninteichosaJisshiYMD;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setNinteichosaIraiRirekiNo(TextBoxNum ninteichosaIraiRirekiNo) {
        this.setOriginalData("ninteichosaIraiRirekiNo", ninteichosaIraiRirekiNo);
        this.ninteichosaIraiRirekiNo = ninteichosaIraiRirekiNo;
    }

    public void setRemban(RString remban) {
        this.setOriginalData("remban", remban);
        this.remban = remban;
    }

    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.setOriginalData("koroshoIfShikibetsuCode", koroshoIfShikibetsuCode);
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    public void setShisetsuRiyoFlag(RString shisetsuRiyoFlag) {
        this.setOriginalData("shisetsuRiyoFlag", shisetsuRiyoFlag);
        this.shisetsuRiyoFlag = shisetsuRiyoFlag;
    }

    public void setServiceJokyoKinyu(RString serviceJokyoKinyu) {
        this.setOriginalData("serviceJokyoKinyu", serviceJokyoKinyu);
        this.serviceJokyoKinyu = serviceJokyoKinyu;
    }

    public void setServiceJokyo(RString serviceJokyo) {
        this.setOriginalData("serviceJokyo", serviceJokyo);
        this.serviceJokyo = serviceJokyo;
    }

    public void setResearchItem(RString researchItem) {
        this.setOriginalData("researchItem", researchItem);
        this.researchItem = researchItem;
    }

    public void setNinchishoNichijoSeikatsuJiritsudoCode(RString ninchishoNichijoSeikatsuJiritsudoCode) {
        this.setOriginalData("ninchishoNichijoSeikatsuJiritsudoCode", ninchishoNichijoSeikatsuJiritsudoCode);
        this.ninchishoNichijoSeikatsuJiritsudoCode = ninchishoNichijoSeikatsuJiritsudoCode;
    }

    public void setShogaiNichijoSeikatsuJiritsudoCode(RString shogaiNichijoSeikatsuJiritsudoCode) {
        this.setOriginalData("shogaiNichijoSeikatsuJiritsudoCode", shogaiNichijoSeikatsuJiritsudoCode);
        this.shogaiNichijoSeikatsuJiritsudoCode = shogaiNichijoSeikatsuJiritsudoCode;
    }

    public void setNinteichosaTokkijikoNoRemban(RString ninteichosaTokkijikoNoRemban) {
        this.setOriginalData("ninteichosaTokkijikoNoRemban", ninteichosaTokkijikoNoRemban);
        this.ninteichosaTokkijikoNoRemban = ninteichosaTokkijikoNoRemban;
    }

    public void setGaikyoTokkiTextImageKubun(RString gaikyoTokkiTextImageKubun) {
        this.setOriginalData("gaikyoTokkiTextImageKubun", gaikyoTokkiTextImageKubun);
        this.gaikyoTokkiTextImageKubun = gaikyoTokkiTextImageKubun;
    }

    public void setJutakuKaishu(RString jutakuKaishu) {
        this.setOriginalData("jutakuKaishu", jutakuKaishu);
        this.jutakuKaishu = jutakuKaishu;
    }

    public void setTokubetsuKyufuService(RString tokubetsuKyufuService) {
        this.setOriginalData("tokubetsuKyufuService", tokubetsuKyufuService);
        this.tokubetsuKyufuService = tokubetsuKyufuService;
    }

    public void setZaitakuService(RString zaitakuService) {
        this.setOriginalData("zaitakuService", zaitakuService);
        this.zaitakuService = zaitakuService;
    }

    public void setShuso(RString shuso) {
        this.setOriginalData("shuso", shuso);
        this.shuso = shuso;
    }

    public void setKazokuJokyo(RString kazokuJokyo) {
        this.setOriginalData("kazokuJokyo", kazokuJokyo);
        this.kazokuJokyo = kazokuJokyo;
    }

    public void setKyojuKankyo(RString kyojuKankyo) {
        this.setOriginalData("kyojuKankyo", kyojuKankyo);
        this.kyojuKankyo = kyojuKankyo;
    }

    public void setKikaiKiki(RString kikaiKiki) {
        this.setOriginalData("kikaiKiki", kikaiKiki);
        this.kikaiKiki = kikaiKiki;
    }

    public void setNinteichousaIraiKubunCode(RString ninteichousaIraiKubunCode) {
        this.setOriginalData("ninteichousaIraiKubunCode", ninteichousaIraiKubunCode);
        this.ninteichousaIraiKubunCode = ninteichousaIraiKubunCode;
    }

    public void setNinteichosaIraiKaisu(RString ninteichosaIraiKaisu) {
        this.setOriginalData("ninteichosaIraiKaisu", ninteichosaIraiKaisu);
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
    }

    public void setNinteichosaJuryoYMD(TextBoxFlexibleDate ninteichosaJuryoYMD) {
        this.setOriginalData("ninteichosaJuryoYMD", ninteichosaJuryoYMD);
        this.ninteichosaJuryoYMD = ninteichosaJuryoYMD;
    }

    public void setNinteiChosaKubunCode(RString ninteiChosaKubunCode) {
        this.setOriginalData("ninteiChosaKubunCode", ninteiChosaKubunCode);
        this.ninteiChosaKubunCode = ninteiChosaKubunCode;
    }

    public void setChosaJisshiBashoCode(RString chosaJisshiBashoCode) {
        this.setOriginalData("chosaJisshiBashoCode", chosaJisshiBashoCode);
        this.chosaJisshiBashoCode = chosaJisshiBashoCode;
    }

    public void setChosaJisshiBashoMeisho(RString chosaJisshiBashoMeisho) {
        this.setOriginalData("chosaJisshiBashoMeisho", chosaJisshiBashoMeisho);
        this.chosaJisshiBashoMeisho = chosaJisshiBashoMeisho;
    }

    public void setServiceKubunCode(RString serviceKubunCode) {
        this.setOriginalData("serviceKubunCode", serviceKubunCode);
        this.serviceKubunCode = serviceKubunCode;
    }

    public void setRiyoShisetsuShimei(RString riyoShisetsuShimei) {
        this.setOriginalData("riyoShisetsuShimei", riyoShisetsuShimei);
        this.riyoShisetsuShimei = riyoShisetsuShimei;
    }

    public void setRiyoShisetsuJusho(RString riyoShisetsuJusho) {
        this.setOriginalData("riyoShisetsuJusho", riyoShisetsuJusho);
        this.riyoShisetsuJusho = riyoShisetsuJusho;
    }

    public void setRiyoShisetsuTelNo(RString riyoShisetsuTelNo) {
        this.setOriginalData("riyoShisetsuTelNo", riyoShisetsuTelNo);
        this.riyoShisetsuTelNo = riyoShisetsuTelNo;
    }

    public void setRiyoShisetsuYubinNo(RString riyoShisetsuYubinNo) {
        this.setOriginalData("riyoShisetsuYubinNo", riyoShisetsuYubinNo);
        this.riyoShisetsuYubinNo = riyoShisetsuYubinNo;
    }

    public void setTokki(RString tokki) {
        this.setOriginalData("tokki", tokki);
        this.tokki = tokki;
    }

    public void setTokkijikoUketsukeYMD(TextBoxFlexibleDate tokkijikoUketsukeYMD) {
        this.setOriginalData("tokkijikoUketsukeYMD", tokkijikoUketsukeYMD);
        this.tokkijikoUketsukeYMD = tokkijikoUketsukeYMD;
    }

    public void setTokkijikoJuryoYMD(TextBoxFlexibleDate tokkijikoJuryoYMD) {
        this.setOriginalData("tokkijikoJuryoYMD", tokkijikoJuryoYMD);
        this.tokkijikoJuryoYMD = tokkijikoJuryoYMD;
    }

    public void setServiceJokyoFlag(RString serviceJokyoFlag) {
        this.setOriginalData("serviceJokyoFlag", serviceJokyoFlag);
        this.serviceJokyoFlag = serviceJokyoFlag;
    }

    public void setServiceJokyoRemban(RString serviceJokyoRemban) {
        this.setOriginalData("serviceJokyoRemban", serviceJokyoRemban);
        this.serviceJokyoRemban = serviceJokyoRemban;
    }

    public void setServiceJokyoFlagRemban(RString serviceJokyoFlagRemban) {
        this.setOriginalData("serviceJokyoFlagRemban", serviceJokyoFlagRemban);
        this.serviceJokyoFlagRemban = serviceJokyoFlagRemban;
    }

    public void setServiceJokyoKinyuRemban(RString serviceJokyoKinyuRemban) {
        this.setOriginalData("serviceJokyoKinyuRemban", serviceJokyoKinyuRemban);
        this.serviceJokyoKinyuRemban = serviceJokyoKinyuRemban;
    }

    public void setShisetsuRiyoFlagRemban(RString shisetsuRiyoFlagRemban) {
        this.setOriginalData("shisetsuRiyoFlagRemban", shisetsuRiyoFlagRemban);
        this.shisetsuRiyoFlagRemban = shisetsuRiyoFlagRemban;
    }

    public void setErrorJiyu(RString errorJiyu) {
        this.setOriginalData("errorJiyu", errorJiyu);
        this.errorJiyu = errorJiyu;
    }

    // </editor-fold>
}
