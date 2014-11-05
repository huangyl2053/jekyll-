package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.DbeShubetsuKey;

/**
 * DbT5008NinteichosaKekkaJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5008NinteichosaKekkaJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5008NinteichosaKekkaJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    private RString koroshoIfShikibetsuCode;
    private Code ninteichosaIraiKubunCode;
    private int ninteichosaIraiKaisu;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private Code chosaItakuKubunCode;
    private Code ninteiChosaKubunCode;
    private JigyoshaNo chosaItakusakiCode;
    private RString chosainCode;
    private Code chosaJisshiBashoCode;
    private RString chosaJisshiBashoMeisho;
    private Code genzainoJokyoCode;
    private Code serviceKubunCode;
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
    private JigyoshaNo riyoShisetsuCode;
    private RString riyoShisetsuShimei;
    private AtenaJusho riyoShisetsuJusho;
    private TelNo riyoShisetsuTelNo;
    private YubinNo riyoShisetsuYubinNo;
    private RString gaikyochosaTokkijiko;
    private Code ninchishoNichijoSeikatsuJiritsudoCode;
    private Code shogaiNichijoSeikatsuJiritsudoCode;
    private Code shinsakaiYusenWaritsukeKubunCode;
    private FlexibleDate tokkijikoUketsukeYMD;
    private FlexibleDate tokkijikoJuryoYMD;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShinseishoKanriNo
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * setShinseishoKanriNo
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * getNinteichosaRirekiNo
     *
     * @return ninteichosaRirekiNo
     */
    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /**
     * setNinteichosaRirekiNo
     *
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     */
    public void setNinteichosaRirekiNo(int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * getKoroshoIfShikibetsuCode
     *
     * @return koroshoIfShikibetsuCode
     */
    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * setKoroshoIfShikibetsuCode
     *
     * @param koroshoIfShikibetsuCode koroshoIfShikibetsuCode
     */
    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * getNinteichosaIraiKubunCode
     *
     * @return ninteichosaIraiKubunCode
     */
    public Code getNinteichosaIraiKubunCode() {
        return ninteichosaIraiKubunCode;
    }

    /**
     * setNinteichosaIraiKubunCode
     *
     * @param ninteichosaIraiKubunCode ninteichosaIraiKubunCode
     */
    public void setNinteichosaIraiKubunCode(Code ninteichosaIraiKubunCode) {
        this.ninteichosaIraiKubunCode = ninteichosaIraiKubunCode;
    }

    /**
     * getNinteichosaIraiKaisu
     *
     * @return ninteichosaIraiKaisu
     */
    public int getNinteichosaIraiKaisu() {
        return ninteichosaIraiKaisu;
    }

    /**
     * setNinteichosaIraiKaisu
     *
     * @param ninteichosaIraiKaisu ninteichosaIraiKaisu
     */
    public void setNinteichosaIraiKaisu(int ninteichosaIraiKaisu) {
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
    }

    /**
     * getNinteichosaJisshiYMD
     *
     * @return ninteichosaJisshiYMD
     */
    public FlexibleDate getNinteichosaJisshiYMD() {
        return ninteichosaJisshiYMD;
    }

    /**
     * setNinteichosaJisshiYMD
     *
     * @param ninteichosaJisshiYMD ninteichosaJisshiYMD
     */
    public void setNinteichosaJisshiYMD(FlexibleDate ninteichosaJisshiYMD) {
        this.ninteichosaJisshiYMD = ninteichosaJisshiYMD;
    }

    /**
     * getNinteichosaJuryoYMD
     *
     * @return ninteichosaJuryoYMD
     */
    public FlexibleDate getNinteichosaJuryoYMD() {
        return ninteichosaJuryoYMD;
    }

    /**
     * setNinteichosaJuryoYMD
     *
     * @param ninteichosaJuryoYMD ninteichosaJuryoYMD
     */
    public void setNinteichosaJuryoYMD(FlexibleDate ninteichosaJuryoYMD) {
        this.ninteichosaJuryoYMD = ninteichosaJuryoYMD;
    }

    /**
     * getChosaItakuKubunCode
     *
     * @return chosaItakuKubunCode
     */
    public Code getChosaItakuKubunCode() {
        return chosaItakuKubunCode;
    }

    /**
     * setChosaItakuKubunCode
     *
     * @param chosaItakuKubunCode chosaItakuKubunCode
     */
    public void setChosaItakuKubunCode(Code chosaItakuKubunCode) {
        this.chosaItakuKubunCode = chosaItakuKubunCode;
    }

    /**
     * getChosaItakuKubunCodeMeisho
     *
     * @return Meisho
     */
    public RString getChosaItakuKubunCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.調査委託区分, chosaItakuKubunCode);
    }

    /**
     * getChosaItakuKubunCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getChosaItakuKubunCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.調査委託区分, chosaItakuKubunCode);
    }

    /**
     * getNinteiChosaKubunCode
     *
     * @return ninteiChosaKubunCode
     */
    public Code getNinteiChosaKubunCode() {
        return ninteiChosaKubunCode;
    }

    /**
     * setNinteiChosaKubunCode
     *
     * @param ninteiChosaKubunCode ninteiChosaKubunCode
     */
    public void setNinteiChosaKubunCode(Code ninteiChosaKubunCode) {
        this.ninteiChosaKubunCode = ninteiChosaKubunCode;
    }

    /**
     * getNinteiChosaKubunCodeMeisho
     *
     * @return Meisho
     */
    public RString getNinteiChosaKubunCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認定調査区分, ninteiChosaKubunCode);
    }

    /**
     * getNinteiChosaKubunCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getNinteiChosaKubunCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認定調査区分, ninteiChosaKubunCode);
    }

    /**
     * getChosaItakusakiCode
     *
     * @return chosaItakusakiCode
     */
    public JigyoshaNo getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    /**
     * setChosaItakusakiCode
     *
     * @param chosaItakusakiCode chosaItakusakiCode
     */
    public void setChosaItakusakiCode(JigyoshaNo chosaItakusakiCode) {
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    /**
     * getChosainCode
     *
     * @return chosainCode
     */
    public RString getChosainCode() {
        return chosainCode;
    }

    /**
     * setChosainCode
     *
     * @param chosainCode chosainCode
     */
    public void setChosainCode(RString chosainCode) {
        this.chosainCode = chosainCode;
    }

    /**
     * getChosaJisshiBashoCode
     *
     * @return chosaJisshiBashoCode
     */
    public Code getChosaJisshiBashoCode() {
        return chosaJisshiBashoCode;
    }

    /**
     * setChosaJisshiBashoCode
     *
     * @param chosaJisshiBashoCode chosaJisshiBashoCode
     */
    public void setChosaJisshiBashoCode(Code chosaJisshiBashoCode) {
        this.chosaJisshiBashoCode = chosaJisshiBashoCode;
    }

    /**
     * getChosaJisshiBashoCodeMeisho
     *
     * @return Meisho
     */
    public RString getChosaJisshiBashoCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.実施場所, chosaJisshiBashoCode);
    }

    /**
     * getChosaJisshiBashoCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getChosaJisshiBashoCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.実施場所, chosaJisshiBashoCode);
    }

    /**
     * getChosaJisshiBashoMeisho
     *
     * @return chosaJisshiBashoMeisho
     */
    public RString getChosaJisshiBashoMeisho() {
        return chosaJisshiBashoMeisho;
    }

    /**
     * setChosaJisshiBashoMeisho
     *
     * @param chosaJisshiBashoMeisho chosaJisshiBashoMeisho
     */
    public void setChosaJisshiBashoMeisho(RString chosaJisshiBashoMeisho) {
        this.chosaJisshiBashoMeisho = chosaJisshiBashoMeisho;
    }

    /**
     * getGenzainoJokyoCode
     *
     * @return genzainoJokyoCode
     */
    public Code getGenzainoJokyoCode() {
        return genzainoJokyoCode;
    }

    /**
     * setGenzainoJokyoCode
     *
     * @param genzainoJokyoCode genzainoJokyoCode
     */
    public void setGenzainoJokyoCode(Code genzainoJokyoCode) {
        this.genzainoJokyoCode = genzainoJokyoCode;
    }

    /**
     * getGenzainoJokyoCodeMeisho
     *
     * @return Meisho
     */
    public RString getGenzainoJokyoCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.現在の状況, genzainoJokyoCode);
    }

    /**
     * getGenzainoJokyoCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getGenzainoJokyoCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.現在の状況, genzainoJokyoCode);
    }

    /**
     * getServiceKubunCode
     *
     * @return serviceKubunCode
     */
    public Code getServiceKubunCode() {
        return serviceKubunCode;
    }

    /**
     * setServiceKubunCode
     *
     * @param serviceKubunCode serviceKubunCode
     */
    public void setServiceKubunCode(Code serviceKubunCode) {
        this.serviceKubunCode = serviceKubunCode;
    }

    /**
     * getServiceKubunCodeMeisho
     *
     * @return Meisho
     */
    public RString getServiceKubunCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.現在のサービス区分, serviceKubunCode);
    }

    /**
     * getServiceKubunCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getServiceKubunCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.現在のサービス区分, serviceKubunCode);
    }

    /**
     * getHomonKaigo
     *
     * @return homonKaigo
     */
    public int getHomonKaigo() {
        return homonKaigo;
    }

    /**
     * setHomonKaigo
     *
     * @param homonKaigo homonKaigo
     */
    public void setHomonKaigo(int homonKaigo) {
        this.homonKaigo = homonKaigo;
    }

    /**
     * getHomonNyuyokuKaigo
     *
     * @return homonNyuyokuKaigo
     */
    public int getHomonNyuyokuKaigo() {
        return homonNyuyokuKaigo;
    }

    /**
     * setHomonNyuyokuKaigo
     *
     * @param homonNyuyokuKaigo homonNyuyokuKaigo
     */
    public void setHomonNyuyokuKaigo(int homonNyuyokuKaigo) {
        this.homonNyuyokuKaigo = homonNyuyokuKaigo;
    }

    /**
     * getHomonKango
     *
     * @return homonKango
     */
    public int getHomonKango() {
        return homonKango;
    }

    /**
     * setHomonKango
     *
     * @param homonKango homonKango
     */
    public void setHomonKango(int homonKango) {
        this.homonKango = homonKango;
    }

    /**
     * getHomonRehabilitation
     *
     * @return homonRehabilitation
     */
    public int getHomonRehabilitation() {
        return homonRehabilitation;
    }

    /**
     * setHomonRehabilitation
     *
     * @param homonRehabilitation homonRehabilitation
     */
    public void setHomonRehabilitation(int homonRehabilitation) {
        this.homonRehabilitation = homonRehabilitation;
    }

    /**
     * getKyotakuRyoyoKanriShido
     *
     * @return kyotakuRyoyoKanriShido
     */
    public int getKyotakuRyoyoKanriShido() {
        return kyotakuRyoyoKanriShido;
    }

    /**
     * setKyotakuRyoyoKanriShido
     *
     * @param kyotakuRyoyoKanriShido kyotakuRyoyoKanriShido
     */
    public void setKyotakuRyoyoKanriShido(int kyotakuRyoyoKanriShido) {
        this.kyotakuRyoyoKanriShido = kyotakuRyoyoKanriShido;
    }

    /**
     * getTushoKaigo
     *
     * @return tushoKaigo
     */
    public int getTushoKaigo() {
        return tushoKaigo;
    }

    /**
     * setTushoKaigo
     *
     * @param tushoKaigo tushoKaigo
     */
    public void setTushoKaigo(int tushoKaigo) {
        this.tushoKaigo = tushoKaigo;
    }

    /**
     * getTushoRehabilitation
     *
     * @return tushoRehabilitation
     */
    public int getTushoRehabilitation() {
        return tushoRehabilitation;
    }

    /**
     * setTushoRehabilitation
     *
     * @param tushoRehabilitation tushoRehabilitation
     */
    public void setTushoRehabilitation(int tushoRehabilitation) {
        this.tushoRehabilitation = tushoRehabilitation;
    }

    /**
     * getTankiNyushoSeikatsuKaigo
     *
     * @return tankiNyushoSeikatsuKaigo
     */
    public int getTankiNyushoSeikatsuKaigo() {
        return tankiNyushoSeikatsuKaigo;
    }

    /**
     * setTankiNyushoSeikatsuKaigo
     *
     * @param tankiNyushoSeikatsuKaigo tankiNyushoSeikatsuKaigo
     */
    public void setTankiNyushoSeikatsuKaigo(int tankiNyushoSeikatsuKaigo) {
        this.tankiNyushoSeikatsuKaigo = tankiNyushoSeikatsuKaigo;
    }

    /**
     * getTankiNyushoRyoyoKaigo
     *
     * @return tankiNyushoRyoyoKaigo
     */
    public int getTankiNyushoRyoyoKaigo() {
        return tankiNyushoRyoyoKaigo;
    }

    /**
     * setTankiNyushoRyoyoKaigo
     *
     * @param tankiNyushoRyoyoKaigo tankiNyushoRyoyoKaigo
     */
    public void setTankiNyushoRyoyoKaigo(int tankiNyushoRyoyoKaigo) {
        this.tankiNyushoRyoyoKaigo = tankiNyushoRyoyoKaigo;
    }

    /**
     * getTokuteiShisetsuNyushoshaSeikatsuKaigo
     *
     * @return tokuteiShisetsuNyushoshaSeikatsuKaigo
     */
    public int getTokuteiShisetsuNyushoshaSeikatsuKaigo() {
        return tokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    /**
     * setTokuteiShisetsuNyushoshaSeikatsuKaigo
     *
     * @param tokuteiShisetsuNyushoshaSeikatsuKaigo
     * tokuteiShisetsuNyushoshaSeikatsuKaigo
     */
    public void setTokuteiShisetsuNyushoshaSeikatsuKaigo(int tokuteiShisetsuNyushoshaSeikatsuKaigo) {
        this.tokuteiShisetsuNyushoshaSeikatsuKaigo = tokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    /**
     * getHukushiYoguTaiyo
     *
     * @return hukushiYoguTaiyo
     */
    public int getHukushiYoguTaiyo() {
        return hukushiYoguTaiyo;
    }

    /**
     * setHukushiYoguTaiyo
     *
     * @param hukushiYoguTaiyo hukushiYoguTaiyo
     */
    public void setHukushiYoguTaiyo(int hukushiYoguTaiyo) {
        this.hukushiYoguTaiyo = hukushiYoguTaiyo;
    }

    /**
     * getTokuteiHukushiYoguHanbai
     *
     * @return tokuteiHukushiYoguHanbai
     */
    public int getTokuteiHukushiYoguHanbai() {
        return tokuteiHukushiYoguHanbai;
    }

    /**
     * setTokuteiHukushiYoguHanbai
     *
     * @param tokuteiHukushiYoguHanbai tokuteiHukushiYoguHanbai
     */
    public void setTokuteiHukushiYoguHanbai(int tokuteiHukushiYoguHanbai) {
        this.tokuteiHukushiYoguHanbai = tokuteiHukushiYoguHanbai;
    }

    /**
     * getJutakuKaishu
     *
     * @return jutakuKaishu
     */
    public int getJutakuKaishu() {
        return jutakuKaishu;
    }

    /**
     * setJutakuKaishu
     *
     * @param jutakuKaishu jutakuKaishu
     */
    public void setJutakuKaishu(int jutakuKaishu) {
        this.jutakuKaishu = jutakuKaishu;
    }

    /**
     * getYakanTaiogataHomonKaigo
     *
     * @return yakanTaiogataHomonKaigo
     */
    public int getYakanTaiogataHomonKaigo() {
        return yakanTaiogataHomonKaigo;
    }

    /**
     * setYakanTaiogataHomonKaigo
     *
     * @param yakanTaiogataHomonKaigo yakanTaiogataHomonKaigo
     */
    public void setYakanTaiogataHomonKaigo(int yakanTaiogataHomonKaigo) {
        this.yakanTaiogataHomonKaigo = yakanTaiogataHomonKaigo;
    }

    /**
     * getNinchishoTaiogataTushoKaigo
     *
     * @return ninchishoTaiogataTushoKaigo
     */
    public int getNinchishoTaiogataTushoKaigo() {
        return ninchishoTaiogataTushoKaigo;
    }

    /**
     * setNinchishoTaiogataTushoKaigo
     *
     * @param ninchishoTaiogataTushoKaigo ninchishoTaiogataTushoKaigo
     */
    public void setNinchishoTaiogataTushoKaigo(int ninchishoTaiogataTushoKaigo) {
        this.ninchishoTaiogataTushoKaigo = ninchishoTaiogataTushoKaigo;
    }

    /**
     * getShokiboTakinogataKyotakuKaigo
     *
     * @return shokiboTakinogataKyotakuKaigo
     */
    public int getShokiboTakinogataKyotakuKaigo() {
        return shokiboTakinogataKyotakuKaigo;
    }

    /**
     * setShokiboTakinogataKyotakuKaigo
     *
     * @param shokiboTakinogataKyotakuKaigo shokiboTakinogataKyotakuKaigo
     */
    public void setShokiboTakinogataKyotakuKaigo(int shokiboTakinogataKyotakuKaigo) {
        this.shokiboTakinogataKyotakuKaigo = shokiboTakinogataKyotakuKaigo;
    }

    /**
     * getNinchishoTaiogataKyodoSeikatsuKaigo
     *
     * @return ninchishoTaiogataKyodoSeikatsuKaigo
     */
    public int getNinchishoTaiogataKyodoSeikatsuKaigo() {
        return ninchishoTaiogataKyodoSeikatsuKaigo;
    }

    /**
     * setNinchishoTaiogataKyodoSeikatsuKaigo
     *
     * @param ninchishoTaiogataKyodoSeikatsuKaigo
     * ninchishoTaiogataKyodoSeikatsuKaigo
     */
    public void setNinchishoTaiogataKyodoSeikatsuKaigo(int ninchishoTaiogataKyodoSeikatsuKaigo) {
        this.ninchishoTaiogataKyodoSeikatsuKaigo = ninchishoTaiogataKyodoSeikatsuKaigo;
    }

    /**
     * getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo
     *
     * @return chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo
     */
    public int getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo() {
        return chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    /**
     * setChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo
     *
     * @param chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo
     * chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo
     */
    public void setChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(int chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo) {
        this.chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo = chiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    /**
     * getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo
     *
     * @return chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo
     */
    public int getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo() {
        return chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo;
    }

    /**
     * setChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo
     *
     * @param chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo
     * chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo
     */
    public void setChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(int chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo) {
        this.chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo = chiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo;
    }

    /**
     * getTeikijunkaiZuijiTaiogataHomonKaigoKango
     *
     * @return teikijunkaiZuijiTaiogataHomonKaigoKango
     */
    public int getTeikijunkaiZuijiTaiogataHomonKaigoKango() {
        return teikijunkaiZuijiTaiogataHomonKaigoKango;
    }

    /**
     * setTeikijunkaiZuijiTaiogataHomonKaigoKango
     *
     * @param teikijunkaiZuijiTaiogataHomonKaigoKango
     * teikijunkaiZuijiTaiogataHomonKaigoKango
     */
    public void setTeikijunkaiZuijiTaiogataHomonKaigoKango(int teikijunkaiZuijiTaiogataHomonKaigoKango) {
        this.teikijunkaiZuijiTaiogataHomonKaigoKango = teikijunkaiZuijiTaiogataHomonKaigoKango;
    }

    /**
     * getHukugogataService
     *
     * @return hukugogataService
     */
    public int getHukugogataService() {
        return hukugogataService;
    }

    /**
     * setHukugogataService
     *
     * @param hukugogataService hukugogataService
     */
    public void setHukugogataService(int hukugogataService) {
        this.hukugogataService = hukugogataService;
    }

    /**
     * getKaigoyoboHomonKaigo
     *
     * @return kaigoyoboHomonKaigo
     */
    public int getKaigoyoboHomonKaigo() {
        return kaigoyoboHomonKaigo;
    }

    /**
     * setKaigoyoboHomonKaigo
     *
     * @param kaigoyoboHomonKaigo kaigoyoboHomonKaigo
     */
    public void setKaigoyoboHomonKaigo(int kaigoyoboHomonKaigo) {
        this.kaigoyoboHomonKaigo = kaigoyoboHomonKaigo;
    }

    /**
     * getKaigoyoboNyuyokuKaigo
     *
     * @return kaigoyoboNyuyokuKaigo
     */
    public int getKaigoyoboNyuyokuKaigo() {
        return kaigoyoboNyuyokuKaigo;
    }

    /**
     * setKaigoyoboNyuyokuKaigo
     *
     * @param kaigoyoboNyuyokuKaigo kaigoyoboNyuyokuKaigo
     */
    public void setKaigoyoboNyuyokuKaigo(int kaigoyoboNyuyokuKaigo) {
        this.kaigoyoboNyuyokuKaigo = kaigoyoboNyuyokuKaigo;
    }

    /**
     * getKaigoyoboHomonKango
     *
     * @return kaigoyoboHomonKango
     */
    public int getKaigoyoboHomonKango() {
        return kaigoyoboHomonKango;
    }

    /**
     * setKaigoyoboHomonKango
     *
     * @param kaigoyoboHomonKango kaigoyoboHomonKango
     */
    public void setKaigoyoboHomonKango(int kaigoyoboHomonKango) {
        this.kaigoyoboHomonKango = kaigoyoboHomonKango;
    }

    /**
     * getKaigoyoboHomonRehabilitation
     *
     * @return kaigoyoboHomonRehabilitation
     */
    public int getKaigoyoboHomonRehabilitation() {
        return kaigoyoboHomonRehabilitation;
    }

    /**
     * setKaigoyoboHomonRehabilitation
     *
     * @param kaigoyoboHomonRehabilitation kaigoyoboHomonRehabilitation
     */
    public void setKaigoyoboHomonRehabilitation(int kaigoyoboHomonRehabilitation) {
        this.kaigoyoboHomonRehabilitation = kaigoyoboHomonRehabilitation;
    }

    /**
     * getKaigoyoboKyotakuRyoyoKanriShido
     *
     * @return kaigoyoboKyotakuRyoyoKanriShido
     */
    public int getKaigoyoboKyotakuRyoyoKanriShido() {
        return kaigoyoboKyotakuRyoyoKanriShido;
    }

    /**
     * setKaigoyoboKyotakuRyoyoKanriShido
     *
     * @param kaigoyoboKyotakuRyoyoKanriShido kaigoyoboKyotakuRyoyoKanriShido
     */
    public void setKaigoyoboKyotakuRyoyoKanriShido(int kaigoyoboKyotakuRyoyoKanriShido) {
        this.kaigoyoboKyotakuRyoyoKanriShido = kaigoyoboKyotakuRyoyoKanriShido;
    }

    /**
     * getKaigoyoboTushoKaigo
     *
     * @return kaigoyoboTushoKaigo
     */
    public int getKaigoyoboTushoKaigo() {
        return kaigoyoboTushoKaigo;
    }

    /**
     * setKaigoyoboTushoKaigo
     *
     * @param kaigoyoboTushoKaigo kaigoyoboTushoKaigo
     */
    public void setKaigoyoboTushoKaigo(int kaigoyoboTushoKaigo) {
        this.kaigoyoboTushoKaigo = kaigoyoboTushoKaigo;
    }

    /**
     * getKaigoyoboTushoRehabilitation
     *
     * @return kaigoyoboTushoRehabilitation
     */
    public int getKaigoyoboTushoRehabilitation() {
        return kaigoyoboTushoRehabilitation;
    }

    /**
     * setKaigoyoboTushoRehabilitation
     *
     * @param kaigoyoboTushoRehabilitation kaigoyoboTushoRehabilitation
     */
    public void setKaigoyoboTushoRehabilitation(int kaigoyoboTushoRehabilitation) {
        this.kaigoyoboTushoRehabilitation = kaigoyoboTushoRehabilitation;
    }

    /**
     * getKaigoyoboTankiNyushoSeikatsuKaigo
     *
     * @return kaigoyoboTankiNyushoSeikatsuKaigo
     */
    public int getKaigoyoboTankiNyushoSeikatsuKaigo() {
        return kaigoyoboTankiNyushoSeikatsuKaigo;
    }

    /**
     * setKaigoyoboTankiNyushoSeikatsuKaigo
     *
     * @param kaigoyoboTankiNyushoSeikatsuKaigo
     * kaigoyoboTankiNyushoSeikatsuKaigo
     */
    public void setKaigoyoboTankiNyushoSeikatsuKaigo(int kaigoyoboTankiNyushoSeikatsuKaigo) {
        this.kaigoyoboTankiNyushoSeikatsuKaigo = kaigoyoboTankiNyushoSeikatsuKaigo;
    }

    /**
     * getKaigooyoboTankiNyushoRyoyoKaigo
     *
     * @return kaigooyoboTankiNyushoRyoyoKaigo
     */
    public int getKaigooyoboTankiNyushoRyoyoKaigo() {
        return kaigooyoboTankiNyushoRyoyoKaigo;
    }

    /**
     * setKaigooyoboTankiNyushoRyoyoKaigo
     *
     * @param kaigooyoboTankiNyushoRyoyoKaigo kaigooyoboTankiNyushoRyoyoKaigo
     */
    public void setKaigooyoboTankiNyushoRyoyoKaigo(int kaigooyoboTankiNyushoRyoyoKaigo) {
        this.kaigooyoboTankiNyushoRyoyoKaigo = kaigooyoboTankiNyushoRyoyoKaigo;
    }

    /**
     * getKaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo
     *
     * @return kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo
     */
    public int getKaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo() {
        return kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    /**
     * setKaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo
     *
     * @param kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo
     * kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo
     */
    public void setKaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo(int kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo) {
        this.kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo = kaigoyoboTokuteiShisetsuNyushoshaSeikatsuKaigo;
    }

    /**
     * getKaigoyoboHukushiYoguTaiyo
     *
     * @return kaigoyoboHukushiYoguTaiyo
     */
    public int getKaigoyoboHukushiYoguTaiyo() {
        return kaigoyoboHukushiYoguTaiyo;
    }

    /**
     * setKaigoyoboHukushiYoguTaiyo
     *
     * @param kaigoyoboHukushiYoguTaiyo kaigoyoboHukushiYoguTaiyo
     */
    public void setKaigoyoboHukushiYoguTaiyo(int kaigoyoboHukushiYoguTaiyo) {
        this.kaigoyoboHukushiYoguTaiyo = kaigoyoboHukushiYoguTaiyo;
    }

    /**
     * getKaigoyoboHukushiYoguHanbai
     *
     * @return kaigoyoboHukushiYoguHanbai
     */
    public int getKaigoyoboHukushiYoguHanbai() {
        return kaigoyoboHukushiYoguHanbai;
    }

    /**
     * setKaigoyoboHukushiYoguHanbai
     *
     * @param kaigoyoboHukushiYoguHanbai kaigoyoboHukushiYoguHanbai
     */
    public void setKaigoyoboHukushiYoguHanbai(int kaigoyoboHukushiYoguHanbai) {
        this.kaigoyoboHukushiYoguHanbai = kaigoyoboHukushiYoguHanbai;
    }

    /**
     * getKaigoyoboJutakuKaishuYobokyufu
     *
     * @return kaigoyoboJutakuKaishuYobokyufu
     */
    public int getKaigoyoboJutakuKaishuYobokyufu() {
        return kaigoyoboJutakuKaishuYobokyufu;
    }

    /**
     * setKaigoyoboJutakuKaishuYobokyufu
     *
     * @param kaigoyoboJutakuKaishuYobokyufu kaigoyoboJutakuKaishuYobokyufu
     */
    public void setKaigoyoboJutakuKaishuYobokyufu(int kaigoyoboJutakuKaishuYobokyufu) {
        this.kaigoyoboJutakuKaishuYobokyufu = kaigoyoboJutakuKaishuYobokyufu;
    }

    /**
     * getKaigoyoboNinchishoTaiogataTushoKaigo
     *
     * @return kaigoyoboNinchishoTaiogataTushoKaigo
     */
    public int getKaigoyoboNinchishoTaiogataTushoKaigo() {
        return kaigoyoboNinchishoTaiogataTushoKaigo;
    }

    /**
     * setKaigoyoboNinchishoTaiogataTushoKaigo
     *
     * @param kaigoyoboNinchishoTaiogataTushoKaigo
     * kaigoyoboNinchishoTaiogataTushoKaigo
     */
    public void setKaigoyoboNinchishoTaiogataTushoKaigo(int kaigoyoboNinchishoTaiogataTushoKaigo) {
        this.kaigoyoboNinchishoTaiogataTushoKaigo = kaigoyoboNinchishoTaiogataTushoKaigo;
    }

    /**
     * getKaigoyoboShokiboTakinogataKyotakuKaigo
     *
     * @return kaigoyoboShokiboTakinogataKyotakuKaigo
     */
    public int getKaigoyoboShokiboTakinogataKyotakuKaigo() {
        return kaigoyoboShokiboTakinogataKyotakuKaigo;
    }

    /**
     * setKaigoyoboShokiboTakinogataKyotakuKaigo
     *
     * @param kaigoyoboShokiboTakinogataKyotakuKaigo
     * kaigoyoboShokiboTakinogataKyotakuKaigo
     */
    public void setKaigoyoboShokiboTakinogataKyotakuKaigo(int kaigoyoboShokiboTakinogataKyotakuKaigo) {
        this.kaigoyoboShokiboTakinogataKyotakuKaigo = kaigoyoboShokiboTakinogataKyotakuKaigo;
    }

    /**
     * getKaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo
     *
     * @return kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo
     */
    public int getKaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo() {
        return kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo;
    }

    /**
     * setKaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo
     *
     * @param kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo
     * kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo
     */
    public void setKaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo(int kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo) {
        this.kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo = kaigoyoboNinchishoTaiogataKyodoSeikatsuKaigo;
    }

    /**
     * getShichosonTokubetsuKyufu
     *
     * @return shichosonTokubetsuKyufu
     */
    public RString getShichosonTokubetsuKyufu() {
        return shichosonTokubetsuKyufu;
    }

    /**
     * setShichosonTokubetsuKyufu
     *
     * @param shichosonTokubetsuKyufu shichosonTokubetsuKyufu
     */
    public void setShichosonTokubetsuKyufu(RString shichosonTokubetsuKyufu) {
        this.shichosonTokubetsuKyufu = shichosonTokubetsuKyufu;
    }

    /**
     * getKaigohokenKyufuIgaiNoZaitakuService
     *
     * @return kaigohokenKyufuIgaiNoZaitakuService
     */
    public RString getKaigohokenKyufuIgaiNoZaitakuService() {
        return kaigohokenKyufuIgaiNoZaitakuService;
    }

    /**
     * setKaigohokenKyufuIgaiNoZaitakuService
     *
     * @param kaigohokenKyufuIgaiNoZaitakuService
     * kaigohokenKyufuIgaiNoZaitakuService
     */
    public void setKaigohokenKyufuIgaiNoZaitakuService(RString kaigohokenKyufuIgaiNoZaitakuService) {
        this.kaigohokenKyufuIgaiNoZaitakuService = kaigohokenKyufuIgaiNoZaitakuService;
    }

    /**
     * getRiyoShisetsuCode
     *
     * @return riyoShisetsuCode
     */
    public JigyoshaNo getRiyoShisetsuCode() {
        return riyoShisetsuCode;
    }

    /**
     * setRiyoShisetsuCode
     *
     * @param riyoShisetsuCode riyoShisetsuCode
     */
    public void setRiyoShisetsuCode(JigyoshaNo riyoShisetsuCode) {
        this.riyoShisetsuCode = riyoShisetsuCode;
    }

    /**
     * getRiyoShisetsuShimei
     *
     * @return riyoShisetsuShimei
     */
    public RString getRiyoShisetsuShimei() {
        return riyoShisetsuShimei;
    }

    /**
     * setRiyoShisetsuShimei
     *
     * @param riyoShisetsuShimei riyoShisetsuShimei
     */
    public void setRiyoShisetsuShimei(RString riyoShisetsuShimei) {
        this.riyoShisetsuShimei = riyoShisetsuShimei;
    }

    /**
     * getRiyoShisetsuJusho
     *
     * @return riyoShisetsuJusho
     */
    public AtenaJusho getRiyoShisetsuJusho() {
        return riyoShisetsuJusho;
    }

    /**
     * setRiyoShisetsuJusho
     *
     * @param riyoShisetsuJusho riyoShisetsuJusho
     */
    public void setRiyoShisetsuJusho(AtenaJusho riyoShisetsuJusho) {
        this.riyoShisetsuJusho = riyoShisetsuJusho;
    }

    /**
     * getRiyoShisetsuTelNo
     *
     * @return riyoShisetsuTelNo
     */
    public TelNo getRiyoShisetsuTelNo() {
        return riyoShisetsuTelNo;
    }

    /**
     * setRiyoShisetsuTelNo
     *
     * @param riyoShisetsuTelNo riyoShisetsuTelNo
     */
    public void setRiyoShisetsuTelNo(TelNo riyoShisetsuTelNo) {
        this.riyoShisetsuTelNo = riyoShisetsuTelNo;
    }

    /**
     * getRiyoShisetsuYubinNo
     *
     * @return riyoShisetsuYubinNo
     */
    public YubinNo getRiyoShisetsuYubinNo() {
        return riyoShisetsuYubinNo;
    }

    /**
     * setRiyoShisetsuYubinNo
     *
     * @param riyoShisetsuYubinNo riyoShisetsuYubinNo
     */
    public void setRiyoShisetsuYubinNo(YubinNo riyoShisetsuYubinNo) {
        this.riyoShisetsuYubinNo = riyoShisetsuYubinNo;
    }

    /**
     * getGaikyochosaTokkijiko
     *
     * @return gaikyochosaTokkijiko
     */
    public RString getGaikyochosaTokkijiko() {
        return gaikyochosaTokkijiko;
    }

    /**
     * setGaikyochosaTokkijiko
     *
     * @param gaikyochosaTokkijiko gaikyochosaTokkijiko
     */
    public void setGaikyochosaTokkijiko(RString gaikyochosaTokkijiko) {
        this.gaikyochosaTokkijiko = gaikyochosaTokkijiko;
    }

    /**
     * getNinchishoNichijoSeikatsuJiritsudoCode
     *
     * @return ninchishoNichijoSeikatsuJiritsudoCode
     */
    public Code getNinchishoNichijoSeikatsuJiritsudoCode() {
        return ninchishoNichijoSeikatsuJiritsudoCode;
    }

    /**
     * setNinchishoNichijoSeikatsuJiritsudoCode
     *
     * @param ninchishoNichijoSeikatsuJiritsudoCode
     * ninchishoNichijoSeikatsuJiritsudoCode
     */
    public void setNinchishoNichijoSeikatsuJiritsudoCode(Code ninchishoNichijoSeikatsuJiritsudoCode) {
        this.ninchishoNichijoSeikatsuJiritsudoCode = ninchishoNichijoSeikatsuJiritsudoCode;
    }

    /**
     * getNinchishoNichijoSeikatsuJiritsudoCodeMeisho
     *
     * @return Meisho
     */
    public RString getNinchishoNichijoSeikatsuJiritsudoCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認知症高齢者自立度, ninchishoNichijoSeikatsuJiritsudoCode);
    }

    /**
     * getNinchishoNichijoSeikatsuJiritsudoCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getNinchishoNichijoSeikatsuJiritsudoCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認知症高齢者自立度, ninchishoNichijoSeikatsuJiritsudoCode);
    }

    /**
     * getShogaiNichijoSeikatsuJiritsudoCode
     *
     * @return shogaiNichijoSeikatsuJiritsudoCode
     */
    public Code getShogaiNichijoSeikatsuJiritsudoCode() {
        return shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * setShogaiNichijoSeikatsuJiritsudoCode
     *
     * @param shogaiNichijoSeikatsuJiritsudoCode
     * shogaiNichijoSeikatsuJiritsudoCode
     */
    public void setShogaiNichijoSeikatsuJiritsudoCode(Code shogaiNichijoSeikatsuJiritsudoCode) {
        this.shogaiNichijoSeikatsuJiritsudoCode = shogaiNichijoSeikatsuJiritsudoCode;
    }

    /**
     * getShogaiNichijoSeikatsuJiritsudoCodeMeisho
     *
     * @return Meisho
     */
    public RString getShogaiNichijoSeikatsuJiritsudoCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.障害高齢者自立度, shogaiNichijoSeikatsuJiritsudoCode);
    }

    /**
     * getShogaiNichijoSeikatsuJiritsudoCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getShogaiNichijoSeikatsuJiritsudoCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.障害高齢者自立度, shogaiNichijoSeikatsuJiritsudoCode);
    }

    /**
     * getShinsakaiYusenWaritsukeKubunCode
     *
     * @return shinsakaiYusenWaritsukeKubunCode
     */
    public Code getShinsakaiYusenWaritsukeKubunCode() {
        return shinsakaiYusenWaritsukeKubunCode;
    }

    /**
     * setShinsakaiYusenWaritsukeKubunCode
     *
     * @param shinsakaiYusenWaritsukeKubunCode shinsakaiYusenWaritsukeKubunCode
     */
    public void setShinsakaiYusenWaritsukeKubunCode(Code shinsakaiYusenWaritsukeKubunCode) {
        this.shinsakaiYusenWaritsukeKubunCode = shinsakaiYusenWaritsukeKubunCode;
    }

    /**
     * getShinsakaiYusenWaritsukeKubunCodeMeisho
     *
     * @return Meisho
     */
    public RString getShinsakaiYusenWaritsukeKubunCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.要介護認定審査会優先振分区分, shinsakaiYusenWaritsukeKubunCode);
    }

    /**
     * getShinsakaiYusenWaritsukeKubunCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getShinsakaiYusenWaritsukeKubunCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.要介護認定審査会優先振分区分, shinsakaiYusenWaritsukeKubunCode);
    }

    /**
     * getTokkijikoUketsukeYMD
     *
     * @return tokkijikoUketsukeYMD
     */
    public FlexibleDate getTokkijikoUketsukeYMD() {
        return tokkijikoUketsukeYMD;
    }

    /**
     * setTokkijikoUketsukeYMD
     *
     * @param tokkijikoUketsukeYMD tokkijikoUketsukeYMD
     */
    public void setTokkijikoUketsukeYMD(FlexibleDate tokkijikoUketsukeYMD) {
        this.tokkijikoUketsukeYMD = tokkijikoUketsukeYMD;
    }

    /**
     * getTokkijikoJuryoYMD
     *
     * @return tokkijikoJuryoYMD
     */
    public FlexibleDate getTokkijikoJuryoYMD() {
        return tokkijikoJuryoYMD;
    }

    /**
     * setTokkijikoJuryoYMD
     *
     * @param tokkijikoJuryoYMD tokkijikoJuryoYMD
     */
    public void setTokkijikoJuryoYMD(FlexibleDate tokkijikoJuryoYMD) {
        this.tokkijikoJuryoYMD = tokkijikoJuryoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5008NinteichosaKekkaJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5008NinteichosaKekkaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5008NinteichosaKekkaJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaRirekiNo != other.ninteichosaRirekiNo) {
            return false;
        }
        return true;
    }
// </editor-fold>
}
