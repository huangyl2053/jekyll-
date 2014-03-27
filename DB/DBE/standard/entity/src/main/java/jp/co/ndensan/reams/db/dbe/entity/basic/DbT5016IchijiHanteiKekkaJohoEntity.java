package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

/**
 * DbT5016IchijiHanteiKekkaJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5016IchijiHanteiKekkaJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5016IchijiHanteiKekkaJoho");
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
    private RString koroshoIfShikibetsuCode;
    private boolean kariIchijiHanteiKubun;
    private FlexibleDate ichijiHanteiYMD;
    private Code ichijiHanteiKekkaCode;
    private Code ichijiHanteiKekkaNinchishoKasanCode;
    private int kijunJikan;
    private int kijunJikanShokuji;
    private int kijunJikanHaisetsu;
    private int kijunJikanIdo;
    private int kijunJikanSeiketsuHoji;
    private int kijunJikanKansetsuCare;
    private int kijunJikanBPSDKanren;
    private int kijunJikanKinoKunren;
    private int kijunJikanIryoKanren;
    private int kijunJikanNinchishoKasan;
    private int chukanHyokaKomoku1gun;
    private int chukanHyokaKomoku2gun;
    private int chukanHyokaKomoku3gun;
    private int chukanHyokaKomoku4gun;
    private int chukanHyokaKomoku5gun;
    private int chukanHyokaKomoku6gun;
    private int chukanHyokaKomoku7gun;
    private RString ichijiHnateiKeikokuCode;
    private Code jotaiAnteiseiCode;
    private Decimal ninchishoJiritsudoIIijoNoGaizensei;
    private Code suiteiKyufuKubunCode;
    private Code ninchishoKoreishaShihyoCode;
    private int jiiritsudoKumiawase1;
    private int jiiritsudoKumiawase2;
    private int jiiritsudoKumiawase3;
    private int jiiritsudoKumiawase4;
    private int jiiritsudoKumiawase5;
    private int jiiritsudoKumiawase6;
    private int jiiritsudoKumiawase7;
    private Code gaizenseiHyokaCode;
    private int gaizenseiHyokaPercent;
    private RString ichijiHanteiSofuKubun;
    private FlexibleDate ichijiHanteiKekkaSofuYMD;

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
     * getKariIchijiHanteiKubun
     *
     * @return kariIchijiHanteiKubun
     */
    public boolean getKariIchijiHanteiKubun() {
        return kariIchijiHanteiKubun;
    }

    /**
     * setKariIchijiHanteiKubun
     *
     * @param kariIchijiHanteiKubun kariIchijiHanteiKubun
     */
    public void setKariIchijiHanteiKubun(boolean kariIchijiHanteiKubun) {
        this.kariIchijiHanteiKubun = kariIchijiHanteiKubun;
    }

    /**
     * getIchijiHanteiYMD
     *
     * @return ichijiHanteiYMD
     */
    public FlexibleDate getIchijiHanteiYMD() {
        return ichijiHanteiYMD;
    }

    /**
     * setIchijiHanteiYMD
     *
     * @param ichijiHanteiYMD ichijiHanteiYMD
     */
    public void setIchijiHanteiYMD(FlexibleDate ichijiHanteiYMD) {
        this.ichijiHanteiYMD = ichijiHanteiYMD;
    }

    /**
     * getIchijiHanteiKekkaCode
     *
     * @return ichijiHanteiKekkaCode
     */
    public Code getIchijiHanteiKekkaCode() {
        return ichijiHanteiKekkaCode;
    }

    /**
     * setIchijiHanteiKekkaCode
     *
     * @param ichijiHanteiKekkaCode ichijiHanteiKekkaCode
     */
    public void setIchijiHanteiKekkaCode(Code ichijiHanteiKekkaCode) {
        this.ichijiHanteiKekkaCode = ichijiHanteiKekkaCode;
    }

    /**
     * getIchijiHanteiKekkaCodeMeisho
     *
     * @return Meisho
     */
    public RString getIchijiHanteiKekkaCodeMeisho() {
        return CodeMaster.getCodeMeisho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0028")), ichijiHanteiKekkaCode);
    }

    /**
     * getIchijiHanteiKekkaCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getIchijiHanteiKekkaCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0028")), ichijiHanteiKekkaCode);
    }

    /**
     * getIchijiHanteiKekkaNinchishoKasanCode
     *
     * @return ichijiHanteiKekkaNinchishoKasanCode
     */
    public Code getIchijiHanteiKekkaNinchishoKasanCode() {
        return ichijiHanteiKekkaNinchishoKasanCode;
    }

    /**
     * setIchijiHanteiKekkaNinchishoKasanCode
     *
     * @param ichijiHanteiKekkaNinchishoKasanCode
     * ichijiHanteiKekkaNinchishoKasanCode
     */
    public void setIchijiHanteiKekkaNinchishoKasanCode(Code ichijiHanteiKekkaNinchishoKasanCode) {
        this.ichijiHanteiKekkaNinchishoKasanCode = ichijiHanteiKekkaNinchishoKasanCode;
    }

    /**
     * getIchijiHanteiKekkaNinchishoKasanCodeMeisho
     *
     * @return Meisho
     */
    public RString getIchijiHanteiKekkaNinchishoKasanCodeMeisho() {
        return CodeMaster.getCodeMeisho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0028")), ichijiHanteiKekkaNinchishoKasanCode);
    }

    /**
     * getIchijiHanteiKekkaNinchishoKasanCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getIchijiHanteiKekkaNinchishoKasanCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0028")), ichijiHanteiKekkaNinchishoKasanCode);
    }

    /**
     * getKijunJikan
     *
     * @return kijunJikan
     */
    public int getKijunJikan() {
        return kijunJikan;
    }

    /**
     * setKijunJikan
     *
     * @param kijunJikan kijunJikan
     */
    public void setKijunJikan(int kijunJikan) {
        this.kijunJikan = kijunJikan;
    }

    /**
     * getKijunJikanShokuji
     *
     * @return kijunJikanShokuji
     */
    public int getKijunJikanShokuji() {
        return kijunJikanShokuji;
    }

    /**
     * setKijunJikanShokuji
     *
     * @param kijunJikanShokuji kijunJikanShokuji
     */
    public void setKijunJikanShokuji(int kijunJikanShokuji) {
        this.kijunJikanShokuji = kijunJikanShokuji;
    }

    /**
     * getKijunJikanHaisetsu
     *
     * @return kijunJikanHaisetsu
     */
    public int getKijunJikanHaisetsu() {
        return kijunJikanHaisetsu;
    }

    /**
     * setKijunJikanHaisetsu
     *
     * @param kijunJikanHaisetsu kijunJikanHaisetsu
     */
    public void setKijunJikanHaisetsu(int kijunJikanHaisetsu) {
        this.kijunJikanHaisetsu = kijunJikanHaisetsu;
    }

    /**
     * getKijunJikanIdo
     *
     * @return kijunJikanIdo
     */
    public int getKijunJikanIdo() {
        return kijunJikanIdo;
    }

    /**
     * setKijunJikanIdo
     *
     * @param kijunJikanIdo kijunJikanIdo
     */
    public void setKijunJikanIdo(int kijunJikanIdo) {
        this.kijunJikanIdo = kijunJikanIdo;
    }

    /**
     * getKijunJikanSeiketsuHoji
     *
     * @return kijunJikanSeiketsuHoji
     */
    public int getKijunJikanSeiketsuHoji() {
        return kijunJikanSeiketsuHoji;
    }

    /**
     * setKijunJikanSeiketsuHoji
     *
     * @param kijunJikanSeiketsuHoji kijunJikanSeiketsuHoji
     */
    public void setKijunJikanSeiketsuHoji(int kijunJikanSeiketsuHoji) {
        this.kijunJikanSeiketsuHoji = kijunJikanSeiketsuHoji;
    }

    /**
     * getKijunJikanKansetsuCare
     *
     * @return kijunJikanKansetsuCare
     */
    public int getKijunJikanKansetsuCare() {
        return kijunJikanKansetsuCare;
    }

    /**
     * setKijunJikanKansetsuCare
     *
     * @param kijunJikanKansetsuCare kijunJikanKansetsuCare
     */
    public void setKijunJikanKansetsuCare(int kijunJikanKansetsuCare) {
        this.kijunJikanKansetsuCare = kijunJikanKansetsuCare;
    }

    /**
     * getKijunJikanBPSDKanren
     *
     * @return kijunJikanBPSDKanren
     */
    public int getKijunJikanBPSDKanren() {
        return kijunJikanBPSDKanren;
    }

    /**
     * setKijunJikanBPSDKanren
     *
     * @param kijunJikanBPSDKanren kijunJikanBPSDKanren
     */
    public void setKijunJikanBPSDKanren(int kijunJikanBPSDKanren) {
        this.kijunJikanBPSDKanren = kijunJikanBPSDKanren;
    }

    /**
     * getKijunJikanKinoKunren
     *
     * @return kijunJikanKinoKunren
     */
    public int getKijunJikanKinoKunren() {
        return kijunJikanKinoKunren;
    }

    /**
     * setKijunJikanKinoKunren
     *
     * @param kijunJikanKinoKunren kijunJikanKinoKunren
     */
    public void setKijunJikanKinoKunren(int kijunJikanKinoKunren) {
        this.kijunJikanKinoKunren = kijunJikanKinoKunren;
    }

    /**
     * getKijunJikanIryoKanren
     *
     * @return kijunJikanIryoKanren
     */
    public int getKijunJikanIryoKanren() {
        return kijunJikanIryoKanren;
    }

    /**
     * setKijunJikanIryoKanren
     *
     * @param kijunJikanIryoKanren kijunJikanIryoKanren
     */
    public void setKijunJikanIryoKanren(int kijunJikanIryoKanren) {
        this.kijunJikanIryoKanren = kijunJikanIryoKanren;
    }

    /**
     * getKijunJikanNinchishoKasan
     *
     * @return kijunJikanNinchishoKasan
     */
    public int getKijunJikanNinchishoKasan() {
        return kijunJikanNinchishoKasan;
    }

    /**
     * setKijunJikanNinchishoKasan
     *
     * @param kijunJikanNinchishoKasan kijunJikanNinchishoKasan
     */
    public void setKijunJikanNinchishoKasan(int kijunJikanNinchishoKasan) {
        this.kijunJikanNinchishoKasan = kijunJikanNinchishoKasan;
    }

    /**
     * getChukanHyokaKomoku1gun
     *
     * @return chukanHyokaKomoku1gun
     */
    public int getChukanHyokaKomoku1gun() {
        return chukanHyokaKomoku1gun;
    }

    /**
     * setChukanHyokaKomoku1gun
     *
     * @param chukanHyokaKomoku1gun chukanHyokaKomoku1gun
     */
    public void setChukanHyokaKomoku1gun(int chukanHyokaKomoku1gun) {
        this.chukanHyokaKomoku1gun = chukanHyokaKomoku1gun;
    }

    /**
     * getChukanHyokaKomoku2gun
     *
     * @return chukanHyokaKomoku2gun
     */
    public int getChukanHyokaKomoku2gun() {
        return chukanHyokaKomoku2gun;
    }

    /**
     * setChukanHyokaKomoku2gun
     *
     * @param chukanHyokaKomoku2gun chukanHyokaKomoku2gun
     */
    public void setChukanHyokaKomoku2gun(int chukanHyokaKomoku2gun) {
        this.chukanHyokaKomoku2gun = chukanHyokaKomoku2gun;
    }

    /**
     * getChukanHyokaKomoku3gun
     *
     * @return chukanHyokaKomoku3gun
     */
    public int getChukanHyokaKomoku3gun() {
        return chukanHyokaKomoku3gun;
    }

    /**
     * setChukanHyokaKomoku3gun
     *
     * @param chukanHyokaKomoku3gun chukanHyokaKomoku3gun
     */
    public void setChukanHyokaKomoku3gun(int chukanHyokaKomoku3gun) {
        this.chukanHyokaKomoku3gun = chukanHyokaKomoku3gun;
    }

    /**
     * getChukanHyokaKomoku4gun
     *
     * @return chukanHyokaKomoku4gun
     */
    public int getChukanHyokaKomoku4gun() {
        return chukanHyokaKomoku4gun;
    }

    /**
     * setChukanHyokaKomoku4gun
     *
     * @param chukanHyokaKomoku4gun chukanHyokaKomoku4gun
     */
    public void setChukanHyokaKomoku4gun(int chukanHyokaKomoku4gun) {
        this.chukanHyokaKomoku4gun = chukanHyokaKomoku4gun;
    }

    /**
     * getChukanHyokaKomoku5gun
     *
     * @return chukanHyokaKomoku5gun
     */
    public int getChukanHyokaKomoku5gun() {
        return chukanHyokaKomoku5gun;
    }

    /**
     * setChukanHyokaKomoku5gun
     *
     * @param chukanHyokaKomoku5gun chukanHyokaKomoku5gun
     */
    public void setChukanHyokaKomoku5gun(int chukanHyokaKomoku5gun) {
        this.chukanHyokaKomoku5gun = chukanHyokaKomoku5gun;
    }

    /**
     * getChukanHyokaKomoku6gun
     *
     * @return chukanHyokaKomoku6gun
     */
    public int getChukanHyokaKomoku6gun() {
        return chukanHyokaKomoku6gun;
    }

    /**
     * setChukanHyokaKomoku6gun
     *
     * @param chukanHyokaKomoku6gun chukanHyokaKomoku6gun
     */
    public void setChukanHyokaKomoku6gun(int chukanHyokaKomoku6gun) {
        this.chukanHyokaKomoku6gun = chukanHyokaKomoku6gun;
    }

    /**
     * getChukanHyokaKomoku7gun
     *
     * @return chukanHyokaKomoku7gun
     */
    public int getChukanHyokaKomoku7gun() {
        return chukanHyokaKomoku7gun;
    }

    /**
     * setChukanHyokaKomoku7gun
     *
     * @param chukanHyokaKomoku7gun chukanHyokaKomoku7gun
     */
    public void setChukanHyokaKomoku7gun(int chukanHyokaKomoku7gun) {
        this.chukanHyokaKomoku7gun = chukanHyokaKomoku7gun;
    }

    /**
     * getIchijiHnateiKeikokuCode
     *
     * @return ichijiHnateiKeikokuCode
     */
    public RString getIchijiHnateiKeikokuCode() {
        return ichijiHnateiKeikokuCode;
    }

    /**
     * setIchijiHnateiKeikokuCode
     *
     * @param ichijiHnateiKeikokuCode ichijiHnateiKeikokuCode
     */
    public void setIchijiHnateiKeikokuCode(RString ichijiHnateiKeikokuCode) {
        this.ichijiHnateiKeikokuCode = ichijiHnateiKeikokuCode;
    }

    /**
     * getJotaiAnteiseiCode
     *
     * @return jotaiAnteiseiCode
     */
    public Code getJotaiAnteiseiCode() {
        return jotaiAnteiseiCode;
    }

    /**
     * setJotaiAnteiseiCode
     *
     * @param jotaiAnteiseiCode jotaiAnteiseiCode
     */
    public void setJotaiAnteiseiCode(Code jotaiAnteiseiCode) {
        this.jotaiAnteiseiCode = jotaiAnteiseiCode;
    }

    /**
     * getJotaiAnteiseiCodeMeisho
     *
     * @return Meisho
     */
    public RString getJotaiAnteiseiCodeMeisho() {
        return CodeMaster.getCodeMeisho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0018")), jotaiAnteiseiCode);
    }

    /**
     * getJotaiAnteiseiCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getJotaiAnteiseiCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0018")), jotaiAnteiseiCode);
    }

    /**
     * getNinchishoJiritsudoIIijoNoGaizensei
     *
     * @return ninchishoJiritsudoIIijoNoGaizensei
     */
    public Decimal getNinchishoJiritsudoIIijoNoGaizensei() {
        return ninchishoJiritsudoIIijoNoGaizensei;
    }

    /**
     * setNinchishoJiritsudoIIijoNoGaizensei
     *
     * @param ninchishoJiritsudoIIijoNoGaizensei
     * ninchishoJiritsudoIIijoNoGaizensei
     */
    public void setNinchishoJiritsudoIIijoNoGaizensei(Decimal ninchishoJiritsudoIIijoNoGaizensei) {
        this.ninchishoJiritsudoIIijoNoGaizensei = ninchishoJiritsudoIIijoNoGaizensei;
    }

    /**
     * getSuiteiKyufuKubunCode
     *
     * @return suiteiKyufuKubunCode
     */
    public Code getSuiteiKyufuKubunCode() {
        return suiteiKyufuKubunCode;
    }

    /**
     * setSuiteiKyufuKubunCode
     *
     * @param suiteiKyufuKubunCode suiteiKyufuKubunCode
     */
    public void setSuiteiKyufuKubunCode(Code suiteiKyufuKubunCode) {
        this.suiteiKyufuKubunCode = suiteiKyufuKubunCode;
    }

    /**
     * getSuiteiKyufuKubunCodeMeisho
     *
     * @return Meisho
     */
    public RString getSuiteiKyufuKubunCodeMeisho() {
        return CodeMaster.getCodeMeisho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0022")), suiteiKyufuKubunCode);
    }

    /**
     * getSuiteiKyufuKubunCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getSuiteiKyufuKubunCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0022")), suiteiKyufuKubunCode);
    }

    /**
     * getNinchishoKoreishaShihyoCode
     *
     * @return ninchishoKoreishaShihyoCode
     */
    public Code getNinchishoKoreishaShihyoCode() {
        return ninchishoKoreishaShihyoCode;
    }

    /**
     * setNinchishoKoreishaShihyoCode
     *
     * @param ninchishoKoreishaShihyoCode ninchishoKoreishaShihyoCode
     */
    public void setNinchishoKoreishaShihyoCode(Code ninchishoKoreishaShihyoCode) {
        this.ninchishoKoreishaShihyoCode = ninchishoKoreishaShihyoCode;
    }

    /**
     * getNinchishoKoreishaShihyoCodeMeisho
     *
     * @return Meisho
     */
    public RString getNinchishoKoreishaShihyoCodeMeisho() {
        return CodeMaster.getCodeMeisho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0020")), ninchishoKoreishaShihyoCode);
    }

    /**
     * getNinchishoKoreishaShihyoCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getNinchishoKoreishaShihyoCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0020")), ninchishoKoreishaShihyoCode);
    }

    /**
     * getJiiritsudoKumiawase1
     *
     * @return jiiritsudoKumiawase1
     */
    public int getJiiritsudoKumiawase1() {
        return jiiritsudoKumiawase1;
    }

    /**
     * setJiiritsudoKumiawase1
     *
     * @param jiiritsudoKumiawase1 jiiritsudoKumiawase1
     */
    public void setJiiritsudoKumiawase1(int jiiritsudoKumiawase1) {
        this.jiiritsudoKumiawase1 = jiiritsudoKumiawase1;
    }

    /**
     * getJiiritsudoKumiawase2
     *
     * @return jiiritsudoKumiawase2
     */
    public int getJiiritsudoKumiawase2() {
        return jiiritsudoKumiawase2;
    }

    /**
     * setJiiritsudoKumiawase2
     *
     * @param jiiritsudoKumiawase2 jiiritsudoKumiawase2
     */
    public void setJiiritsudoKumiawase2(int jiiritsudoKumiawase2) {
        this.jiiritsudoKumiawase2 = jiiritsudoKumiawase2;
    }

    /**
     * getJiiritsudoKumiawase3
     *
     * @return jiiritsudoKumiawase3
     */
    public int getJiiritsudoKumiawase3() {
        return jiiritsudoKumiawase3;
    }

    /**
     * setJiiritsudoKumiawase3
     *
     * @param jiiritsudoKumiawase3 jiiritsudoKumiawase3
     */
    public void setJiiritsudoKumiawase3(int jiiritsudoKumiawase3) {
        this.jiiritsudoKumiawase3 = jiiritsudoKumiawase3;
    }

    /**
     * getJiiritsudoKumiawase4
     *
     * @return jiiritsudoKumiawase4
     */
    public int getJiiritsudoKumiawase4() {
        return jiiritsudoKumiawase4;
    }

    /**
     * setJiiritsudoKumiawase4
     *
     * @param jiiritsudoKumiawase4 jiiritsudoKumiawase4
     */
    public void setJiiritsudoKumiawase4(int jiiritsudoKumiawase4) {
        this.jiiritsudoKumiawase4 = jiiritsudoKumiawase4;
    }

    /**
     * getJiiritsudoKumiawase5
     *
     * @return jiiritsudoKumiawase5
     */
    public int getJiiritsudoKumiawase5() {
        return jiiritsudoKumiawase5;
    }

    /**
     * setJiiritsudoKumiawase5
     *
     * @param jiiritsudoKumiawase5 jiiritsudoKumiawase5
     */
    public void setJiiritsudoKumiawase5(int jiiritsudoKumiawase5) {
        this.jiiritsudoKumiawase5 = jiiritsudoKumiawase5;
    }

    /**
     * getJiiritsudoKumiawase6
     *
     * @return jiiritsudoKumiawase6
     */
    public int getJiiritsudoKumiawase6() {
        return jiiritsudoKumiawase6;
    }

    /**
     * setJiiritsudoKumiawase6
     *
     * @param jiiritsudoKumiawase6 jiiritsudoKumiawase6
     */
    public void setJiiritsudoKumiawase6(int jiiritsudoKumiawase6) {
        this.jiiritsudoKumiawase6 = jiiritsudoKumiawase6;
    }

    /**
     * getJiiritsudoKumiawase7
     *
     * @return jiiritsudoKumiawase7
     */
    public int getJiiritsudoKumiawase7() {
        return jiiritsudoKumiawase7;
    }

    /**
     * setJiiritsudoKumiawase7
     *
     * @param jiiritsudoKumiawase7 jiiritsudoKumiawase7
     */
    public void setJiiritsudoKumiawase7(int jiiritsudoKumiawase7) {
        this.jiiritsudoKumiawase7 = jiiritsudoKumiawase7;
    }

    /**
     * getGaizenseiHyokaCode
     *
     * @return gaizenseiHyokaCode
     */
    public Code getGaizenseiHyokaCode() {
        return gaizenseiHyokaCode;
    }

    /**
     * setGaizenseiHyokaCode
     *
     * @param gaizenseiHyokaCode gaizenseiHyokaCode
     */
    public void setGaizenseiHyokaCode(Code gaizenseiHyokaCode) {
        this.gaizenseiHyokaCode = gaizenseiHyokaCode;
    }

    /**
     * getGaizenseiHyokaCodeMeisho
     *
     * @return Meisho
     */
    public RString getGaizenseiHyokaCodeMeisho() {
        return CodeMaster.getCodeMeisho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0021")), gaizenseiHyokaCode);
    }

    /**
     * getGaizenseiHyokaCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getGaizenseiHyokaCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(new SubGyomuCode(new RString("DBE")), new CodeShubetsu(new RString("0021")), gaizenseiHyokaCode);
    }

    /**
     * getGaizenseiHyokaPercent
     *
     * @return gaizenseiHyokaPercent
     */
    public int getGaizenseiHyokaPercent() {
        return gaizenseiHyokaPercent;
    }

    /**
     * setGaizenseiHyokaPercent
     *
     * @param gaizenseiHyokaPercent gaizenseiHyokaPercent
     */
    public void setGaizenseiHyokaPercent(int gaizenseiHyokaPercent) {
        this.gaizenseiHyokaPercent = gaizenseiHyokaPercent;
    }

    /**
     * getIchijiHanteiSofuKubun
     *
     * @return ichijiHanteiSofuKubun
     */
    public RString getIchijiHanteiSofuKubun() {
        return ichijiHanteiSofuKubun;
    }

    /**
     * setIchijiHanteiSofuKubun
     *
     * @param ichijiHanteiSofuKubun ichijiHanteiSofuKubun
     */
    public void setIchijiHanteiSofuKubun(RString ichijiHanteiSofuKubun) {
        this.ichijiHanteiSofuKubun = ichijiHanteiSofuKubun;
    }

    /**
     * getIchijiHanteiKekkaSofuYMD
     *
     * @return ichijiHanteiKekkaSofuYMD
     */
    public FlexibleDate getIchijiHanteiKekkaSofuYMD() {
        return ichijiHanteiKekkaSofuYMD;
    }

    /**
     * setIchijiHanteiKekkaSofuYMD
     *
     * @param ichijiHanteiKekkaSofuYMD ichijiHanteiKekkaSofuYMD
     */
    public void setIchijiHanteiKekkaSofuYMD(FlexibleDate ichijiHanteiKekkaSofuYMD) {
        this.ichijiHanteiKekkaSofuYMD = ichijiHanteiKekkaSofuYMD;
    }
// </editor-fold>
}
