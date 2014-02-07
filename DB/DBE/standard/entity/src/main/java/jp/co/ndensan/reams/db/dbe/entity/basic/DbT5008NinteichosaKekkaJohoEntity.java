package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 要介護認定調査結果情報のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class DbT5008NinteichosaKekkaJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    @TableName
    public final static String TABLE_NAME = "DbT5008NinteichosaKekkaJoho";
    @PrimaryKey
    private RString shinseishoKanriNo;
    private RString ninteichousaIraiKubunCode;
    private int ninteichosaIraiKaisu;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private RString chosaItakuKubunCode;
    private RString ninteiChosaKubunCode;
    private RString chosaItakusakiCode;
    private RString chosainCode;
    private RString chosaJisshiBashoCode;
    private RString chosaJisshiBashoMeisho;
    private RString genzainoJokyoCode;
    private RString serviceKubunCode;
    private int homonKaigo;
    private int homonNyuyokuKaigo;
    private int homonKango;
    private int homonRehabilitation;
    private int kyotakuRyoyoKanriShido;
    private int tushoKaigo;
    private int tushoRehabilitation;
    private int tankiNyushoSeikatsuKaigo;
    private int tankiNyushoRyoyoKaigo;
    private int tokuteiShisetsuNyushoshaSeikatsuKaigo;
    private int hukushiYoguTaiyo;
    private int tokuteiHukushiYoguHanbai;
    private int jutakuKaishu;
    private int yakanTaiogataHomonKaigo;
    private int ninchishoTaiogataTushoKaigo;
    private int shokiboTakinogataKyotakuKaigo;
    private int ninchishoTaiogataKyodoSeikatsuKaigo;
    private int chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo;
    private int chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo;
    private int teikijunkaiZuijiTaiogataHomonKaigoKango;
    private int hukugogataService;
    private int kaigoyoboHomonKaigo;
    private int kaigoyoboNyuyokuKaigo;
    private int kaigoyoboHomonKango;
    private int kaigoyoboHomonRehabilitation;
    private int kaigoyoboKyotakuRyoyoKanriShido;
    private int kaigoyoboTushoKaigo;
    private int kaigoyoboTushoRehabilitation;
    private int kaigoyoboTankiNyushoSeikatsuKaigo;
    private int kaigooyoboTankiNyushoRyoyoKaigo;
    private int kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo;
    private int kaigoyoboHukushiYoguTaiyo;
    private int kaigoyoboHukushiYoguHanbai;
    private int kaigoyoboJutakuKaishuYobokyufu;
    private int kaigoyoboNinchishoTaiogataTushoKaigo;
    private int kaigoyoboShokiboTakinogataKyotakuKaigo;
    private int kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo;
    private RString shichosonTokubetsuKyufu;
    private RString kaigohokenKyufuIgaiNoZaitakuService;
    private RString riyoShisetsuCode;
    private RString riyoShisetsuShimei;
    private RString riyoShisetsuJusho;
    private RString riyoShisetsuTelNo;
    private RString riyoShisetsuYubinNo;
    private RString gaikyochosaTokkijiko;
    private RString ninchishoNichijoSeikatsuJiritsudoCode;
    private RString shogaiNichijoSeikatsuJiritsudoCode;
    private RString shinsakaiYusenWaritsukeKubunCode;
    private FlexibleDate tokkijikoUketsukeYMD;
    private FlexibleDate tokkijikoJuryoYMD;

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public RString getNinteichousaIraiKubunCode() {
        return ninteichousaIraiKubunCode;
    }

    public void setNinteichousaIraiKubunCode(RString ninteichousaIraiKubunCode) {
        this.ninteichousaIraiKubunCode = ninteichousaIraiKubunCode;
    }

    public int getNinteichosaIraiKaisu() {
        return ninteichosaIraiKaisu;
    }

    public void setNinteichosaIraiKaisu(int ninteichosaIraiKaisu) {
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
    }

    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    public void setNinteichosaRirekiNo(int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    public FlexibleDate getNinteichosaJisshiYMD() {
        return ninteichosaJisshiYMD;
    }

    public void setNinteichosaJisshiYMD(FlexibleDate ninteichosaJisshiYMD) {
        this.ninteichosaJisshiYMD = ninteichosaJisshiYMD;
    }

    public FlexibleDate getNinteichosaJuryoYMD() {
        return ninteichosaJuryoYMD;
    }

    public void setNinteichosaJuryoYMD(FlexibleDate ninteichosaJuryoYMD) {
        this.ninteichosaJuryoYMD = ninteichosaJuryoYMD;
    }

    public RString getChosaItakuKubunCode() {
        return chosaItakuKubunCode;
    }

    public void setChosaItakuKubunCode(RString chosaItakuKubunCode) {
        this.chosaItakuKubunCode = chosaItakuKubunCode;
    }

    public RString getNinteiChosaKubunCode() {
        return ninteiChosaKubunCode;
    }

    public void setNinteiChosaKubunCode(RString ninteiChosaKubunCode) {
        this.ninteiChosaKubunCode = ninteiChosaKubunCode;
    }

    public RString getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    public void setChosaItakusakiCode(RString chosaItakusakiCode) {
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    public RString getChosainCode() {
        return chosainCode;
    }

    public void setChosainCode(RString chosainCode) {
        this.chosainCode = chosainCode;
    }

    public RString getChosaJisshiBashoCode() {
        return chosaJisshiBashoCode;
    }

    public void setChosaJisshiBashoCode(RString chosaJisshiBashoCode) {
        this.chosaJisshiBashoCode = chosaJisshiBashoCode;
    }

    public RString getChosaJisshiBashoMeisho() {
        return chosaJisshiBashoMeisho;
    }

    public void setChosaJisshiBashoMeisho(RString chosaJisshiBashoMeisho) {
        this.chosaJisshiBashoMeisho = chosaJisshiBashoMeisho;
    }

    public RString getGenzainoJokyoCode() {
        return genzainoJokyoCode;
    }

    public void setGenzainoJokyoCode(RString genzainoJokyoCode) {
        this.genzainoJokyoCode = genzainoJokyoCode;
    }

    public RString getServiceKubunCode() {
        return serviceKubunCode;
    }

    public void setServiceKubunCode(RString serviceKubunCode) {
        this.serviceKubunCode = serviceKubunCode;
    }

    public int getHomonKaigo() {
        return homonKaigo;
    }

    public void setHomonKaigo(int homonKaigo) {
        this.homonKaigo = homonKaigo;
    }

    public int getHomonNyuyokuKaigo() {
        return homonNyuyokuKaigo;
    }

    public void setHomonNyuyokuKaigo(int homonNyuyokuKaigo) {
        this.homonNyuyokuKaigo = homonNyuyokuKaigo;
    }

    public int getHomonKango() {
        return homonKango;
    }

    public void setHomonKango(int homonKango) {
        this.homonKango = homonKango;
    }

    public int getHomonRehabilitation() {
        return homonRehabilitation;
    }

    public void setHomonRehabilitation(int homonRehabilitation) {
        this.homonRehabilitation = homonRehabilitation;
    }

    public int getKyotakuRyoyoKanriShido() {
        return kyotakuRyoyoKanriShido;
    }

    public void setKyotakuRyoyoKanriShido(int kyotakuRyoyoKanriShido) {
        this.kyotakuRyoyoKanriShido = kyotakuRyoyoKanriShido;
    }

    public int getTushoKaigo() {
        return tushoKaigo;
    }

    public void setTushoKaigo(int tushoKaigo) {
        this.tushoKaigo = tushoKaigo;
    }

    public int getTushoRehabilitation() {
        return tushoRehabilitation;
    }

    public void setTushoRehabilitation(int tushoRehabilitation) {
        this.tushoRehabilitation = tushoRehabilitation;
    }

    public int getTankiNyushoSeikatsuKaigo() {
        return tankiNyushoSeikatsuKaigo;
    }

    public void setTankiNyushoSeikatsuKaigo(int tankiNyushoSeikatsuKaigo) {
        this.tankiNyushoSeikatsuKaigo = tankiNyushoSeikatsuKaigo;
    }

    public int getTankiNyushoRyoyoKaigo() {
        return tankiNyushoRyoyoKaigo;
    }

    public void setTankiNyushoRyoyoKaigo(int tankiNyushoRyoyoKaigo) {
        this.tankiNyushoRyoyoKaigo = tankiNyushoRyoyoKaigo;
    }

    public int getTokuteiShisetsuNyushoshaSeikatsuKaigo() {
        return tokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    public void setTokuteiShisetsuNyushoshaSeikatsuKaigo(int tokuteiShisetsuNyushoshaSeikatsuKaigo) {
        this.tokuteiShisetsuNyushoshaSeikatsuKaigo = tokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    public int getHukushiYoguTaiyo() {
        return hukushiYoguTaiyo;
    }

    public void setHukushiYoguTaiyo(int hukushiYoguTaiyo) {
        this.hukushiYoguTaiyo = hukushiYoguTaiyo;
    }

    public int getTokuteiHukushiYoguHanbai() {
        return tokuteiHukushiYoguHanbai;
    }

    public void setTokuteiHukushiYoguHanbai(int tokuteiHukushiYoguHanbai) {
        this.tokuteiHukushiYoguHanbai = tokuteiHukushiYoguHanbai;
    }

    public int getJutakuKaishu() {
        return jutakuKaishu;
    }

    public void setJutakuKaishu(int jutakuKaishu) {
        this.jutakuKaishu = jutakuKaishu;
    }

    public int getYakanTaiogataHomonKaigo() {
        return yakanTaiogataHomonKaigo;
    }

    public void setYakanTaiogataHomonKaigo(int yakanTaiogataHomonKaigo) {
        this.yakanTaiogataHomonKaigo = yakanTaiogataHomonKaigo;
    }

    public int getNinchishoTaiogataTushoKaigo() {
        return ninchishoTaiogataTushoKaigo;
    }

    public void setNinchishoTaiogataTushoKaigo(int ninchishoTaiogataTushoKaigo) {
        this.ninchishoTaiogataTushoKaigo = ninchishoTaiogataTushoKaigo;
    }

    public int getShokiboTakinogataKyotakuKaigo() {
        return shokiboTakinogataKyotakuKaigo;
    }

    public void setShokiboTakinogataKyotakuKaigo(int shokiboTakinogataKyotakuKaigo) {
        this.shokiboTakinogataKyotakuKaigo = shokiboTakinogataKyotakuKaigo;
    }

    public int getNinchishoTaiogataKyodoSeikatsuKaigo() {
        return ninchishoTaiogataKyodoSeikatsuKaigo;
    }

    public void setNinchishoTaiogataKyodoSeikatsuKaigo(int ninchishoTaiogataKyodoSeikatsuKaigo) {
        this.ninchishoTaiogataKyodoSeikatsuKaigo = ninchishoTaiogataKyodoSeikatsuKaigo;
    }

    public int getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo() {
        return chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    public void setChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(int chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo) {
        this.chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo = chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    public int getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo() {
        return chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo;
    }

    public void setChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(int chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo) {
        this.chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo = chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo;
    }

    public int getTeikijunkaiZuijiTaiogataHomonKaigoKango() {
        return teikijunkaiZuijiTaiogataHomonKaigoKango;
    }

    public void setTeikijunkaiZuijiTaiogataHomonKaigoKango(int teikijunkaiZuijiTaiogataHomonKaigoKango) {
        this.teikijunkaiZuijiTaiogataHomonKaigoKango = teikijunkaiZuijiTaiogataHomonKaigoKango;
    }

    public int getHukugogataService() {
        return hukugogataService;
    }

    public void setHukugogataService(int hukugogataService) {
        this.hukugogataService = hukugogataService;
    }

    public int getKaigoyoboHomonKaigo() {
        return kaigoyoboHomonKaigo;
    }

    public void setKaigoyoboHomonKaigo(int kaigoyoboHomonKaigo) {
        this.kaigoyoboHomonKaigo = kaigoyoboHomonKaigo;
    }

    public int getKaigoyoboNyuyokuKaigo() {
        return kaigoyoboNyuyokuKaigo;
    }

    public void setKaigoyoboNyuyokuKaigo(int kaigoyoboNyuyokuKaigo) {
        this.kaigoyoboNyuyokuKaigo = kaigoyoboNyuyokuKaigo;
    }

    public int getKaigoyoboHomonKango() {
        return kaigoyoboHomonKango;
    }

    public void setKaigoyoboHomonKango(int kaigoyoboHomonKango) {
        this.kaigoyoboHomonKango = kaigoyoboHomonKango;
    }

    public int getKaigoyoboHomonRehabilitation() {
        return kaigoyoboHomonRehabilitation;
    }

    public void setKaigoyoboHomonRehabilitation(int kaigoyoboHomonRehabilitation) {
        this.kaigoyoboHomonRehabilitation = kaigoyoboHomonRehabilitation;
    }

    public int getKaigoyoboKyotakuRyoyoKanriShido() {
        return kaigoyoboKyotakuRyoyoKanriShido;
    }

    public void setKaigoyoboKyotakuRyoyoKanriShido(int kaigoyoboKyotakuRyoyoKanriShido) {
        this.kaigoyoboKyotakuRyoyoKanriShido = kaigoyoboKyotakuRyoyoKanriShido;
    }

    public int getKaigoyoboTushoKaigo() {
        return kaigoyoboTushoKaigo;
    }

    public void setKaigoyoboTushoKaigo(int kaigoyoboTushoKaigo) {
        this.kaigoyoboTushoKaigo = kaigoyoboTushoKaigo;
    }

    public int getKaigoyoboTushoRehabilitation() {
        return kaigoyoboTushoRehabilitation;
    }

    public void setKaigoyoboTushoRehabilitation(int kaigoyoboTushoRehabilitation) {
        this.kaigoyoboTushoRehabilitation = kaigoyoboTushoRehabilitation;
    }

    public int getKaigoyoboTankiNyushoSeikatsuKaigo() {
        return kaigoyoboTankiNyushoSeikatsuKaigo;
    }

    public void setKaigoyoboTankiNyushoSeikatsuKaigo(int kaigoyoboTankiNyushoSeikatsuKaigo) {
        this.kaigoyoboTankiNyushoSeikatsuKaigo = kaigoyoboTankiNyushoSeikatsuKaigo;
    }

    public int getKaigooyoboTankiNyushoRyoyoKaigo() {
        return kaigooyoboTankiNyushoRyoyoKaigo;
    }

    public void setKaigooyoboTankiNyushoRyoyoKaigo(int kaigooyoboTankiNyushoRyoyoKaigo) {
        this.kaigooyoboTankiNyushoRyoyoKaigo = kaigooyoboTankiNyushoRyoyoKaigo;
    }

    public int getKaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo() {
        return kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    public void setKaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo(int kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo) {
        this.kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo = kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    public int getKaigoyoboHukushiYoguTaiyo() {
        return kaigoyoboHukushiYoguTaiyo;
    }

    public void setKaigoyoboHukushiYoguTaiyo(int kaigoyoboHukushiYoguTaiyo) {
        this.kaigoyoboHukushiYoguTaiyo = kaigoyoboHukushiYoguTaiyo;
    }

    public int getKaigoyoboHukushiYoguHanbai() {
        return kaigoyoboHukushiYoguHanbai;
    }

    public void setKaigoyoboHukushiYoguHanbai(int kaigoyoboHukushiYoguHanbai) {
        this.kaigoyoboHukushiYoguHanbai = kaigoyoboHukushiYoguHanbai;
    }

    public int getKaigoyoboJutakuKaishuYobokyufu() {
        return kaigoyoboJutakuKaishuYobokyufu;
    }

    public void setKaigoyoboJutakuKaishuYobokyufu(int kaigoyoboJutakuKaishuYobokyufu) {
        this.kaigoyoboJutakuKaishuYobokyufu = kaigoyoboJutakuKaishuYobokyufu;
    }

    public int getKaigoyoboNinchishoTaiogataTushoKaigo() {
        return kaigoyoboNinchishoTaiogataTushoKaigo;
    }

    public void setKaigoyoboNinchishoTaiogataTushoKaigo(int kaigoyoboNinchishoTaiogataTushoKaigo) {
        this.kaigoyoboNinchishoTaiogataTushoKaigo = kaigoyoboNinchishoTaiogataTushoKaigo;
    }

    public int getKaigoyoboShokiboTakinogataKyotakuKaigo() {
        return kaigoyoboShokiboTakinogataKyotakuKaigo;
    }

    public void setKaigoyoboShokiboTakinogataKyotakuKaigo(int kaigoyoboShokiboTakinogataKyotakuKaigo) {
        this.kaigoyoboShokiboTakinogataKyotakuKaigo = kaigoyoboShokiboTakinogataKyotakuKaigo;
    }

    public int getKaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo() {
        return kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo;
    }

    public void setKaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo(int kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo) {
        this.kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo = kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo;
    }

    public RString getShichosonTokubetsuKyufu() {
        return shichosonTokubetsuKyufu;
    }

    public void setShichosonTokubetsuKyufu(RString shichosonTokubetsuKyufu) {
        this.shichosonTokubetsuKyufu = shichosonTokubetsuKyufu;
    }

    public RString getKaigohokenKyufuIgaiNoZaitakuService() {
        return kaigohokenKyufuIgaiNoZaitakuService;
    }

    public void setKaigohokenKyufuIgaiNoZaitakuService(RString kaigohokenKyufuIgaiNoZaitakuService) {
        this.kaigohokenKyufuIgaiNoZaitakuService = kaigohokenKyufuIgaiNoZaitakuService;
    }

    public RString getRiyoShisetsuCode() {
        return riyoShisetsuCode;
    }

    public void setRiyoShisetsuCode(RString riyoShisetsuCode) {
        this.riyoShisetsuCode = riyoShisetsuCode;
    }

    public RString getRiyoShisetsuShimei() {
        return riyoShisetsuShimei;
    }

    public void setRiyoShisetsuShimei(RString riyoShisetsuShimei) {
        this.riyoShisetsuShimei = riyoShisetsuShimei;
    }

    public RString getRiyoShisetsuJusho() {
        return riyoShisetsuJusho;
    }

    public void setRiyoShisetsuJusho(RString riyoShisetsuJusho) {
        this.riyoShisetsuJusho = riyoShisetsuJusho;
    }

    public RString getRiyoShisetsuTelNo() {
        return riyoShisetsuTelNo;
    }

    public void setRiyoShisetsuTelNo(RString riyoShisetsuTelNo) {
        this.riyoShisetsuTelNo = riyoShisetsuTelNo;
    }

    public RString getRiyoShisetsuYubinNo() {
        return riyoShisetsuYubinNo;
    }

    public void setRiyoShisetsuYubinNo(RString riyoShisetsuYubinNo) {
        this.riyoShisetsuYubinNo = riyoShisetsuYubinNo;
    }

    public RString getGaikyochosaTokkijiko() {
        return gaikyochosaTokkijiko;
    }

    public void setGaikyochosaTokkijiko(RString gaikyochosaTokkijiko) {
        this.gaikyochosaTokkijiko = gaikyochosaTokkijiko;
    }

    public RString getNinchishoNichijoSeikatsuJiritsudoCode() {
        return ninchishoNichijoSeikatsuJiritsudoCode;
    }

    public void setNinchishoNichijoSeikatsuJiritsudoCode(RString ninchishoNichijoSeikatsuJiritsudoCode) {
        this.ninchishoNichijoSeikatsuJiritsudoCode = ninchishoNichijoSeikatsuJiritsudoCode;
    }

    public RString getShogaiNichijoSeikatsuJiritsudoCode() {
        return shogaiNichijoSeikatsuJiritsudoCode;
    }

    public void setShogaiNichijoSeikatsuJiritsudoCode(RString shogaiNichijoSeikatsuJiritsudoCode) {
        this.shogaiNichijoSeikatsuJiritsudoCode = shogaiNichijoSeikatsuJiritsudoCode;
    }

    public RString getShinsakaiYusenWaritsukeKubunCode() {
        return shinsakaiYusenWaritsukeKubunCode;
    }

    public void setShinsakaiYusenWaritsukeKubunCode(RString shinsakaiYusenWaritsukeKubunCode) {
        this.shinsakaiYusenWaritsukeKubunCode = shinsakaiYusenWaritsukeKubunCode;
    }

    public FlexibleDate getTokkijikoUketsukeYMD() {
        return tokkijikoUketsukeYMD;
    }

    public void setTokkijikoUketsukeYMD(FlexibleDate tokkijikoUketsukeYMD) {
        this.tokkijikoUketsukeYMD = tokkijikoUketsukeYMD;
    }

    public FlexibleDate getTokkijikoJuryoYMD() {
        return tokkijikoJuryoYMD;
    }

    public void setTokkijikoJuryoYMD(FlexibleDate tokkijikoJuryoYMD) {
        this.tokkijikoJuryoYMD = tokkijikoJuryoYMD;
    }
// </editor-fold>
}
