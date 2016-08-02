package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 要介護認定インタフェース情報・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7513YokaigoNinteiInterfaceFukushiEntity extends DbTableEntityBase<DbV7513YokaigoNinteiInterfaceFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7513YokaigoNinteiInterfaceFukushi");

    private ShinseishoKanriNo shinseishoKanriNo;
    private HihokenshaNo hihokenshaNo;
    private RString rirekiNo;
    private YMDHMS torikomiTimestamp;
    private RString torikomiKubun;
    private RString shinseiShubetsuCode;
    private RString torisageKubunCode;
    private FlexibleDate shinseiYMD;
    private RString iryoKikanCode;
    private RString shujiiCode;
    private FlexibleDate ikenshoIraiYMD;
    private FlexibleDate ikenshoToriyoseYMD;
    private FlexibleDate chosaItakuYMD;
    private FlexibleDate chosaShuryoYMD;
    private DbUDD004JigyoshaNo chosaItakusakiCode;
    private RString chosainCode;
    private FlexibleDate ichijiHanteiYMD;
    private RString ichijiHanteiKekkaCode;
    private RString ichijiHanteiKekkaKasanCode;
    private FlexibleDate shinsakaiShiryoSakuseiYMD;
    private FlexibleDate shinsakaiYoteiYMD;
    private int gogitaiNo;
    private FlexibleDate nijiHanteiYMD;
    private RString nijiHanteiKekkaCode;
    private FlexibleDate ninteiYukoKikanStart;
    private FlexibleDate ninteiYukoKikanEnd;
    private RString serviceHenkoRiyuCode;
    private RString tokuteiShippeiCode;
    private RString shogaiKoreiJiritsudo;
    private RString ninchishoKoreiJiritsudo;
    private RString shinsakaiIken;
    private RString versionNo;
    private RString ichijiHanteiNaiyo;
    private RString ichijiHanteiNaiyo2;
    private YMDHMS zenTorikomiTimestamp;
    private RString keshikomiFlag;
    private YMDHMS keshikomiTimestamp;
    private RString yobiKomoku1;
    private RString yobiKomoku2;
    private RString yobiKomoku3;
    private RString yobiKomoku4;
    private RString yobiKomoku5;
    private RString yobiKubun1;
    private RString yobiKubun2;
    private RString yobiKubun3;
    private RString yobiKubun4;
    private RString yobiKubun5;
    private RString reserve;

    /**
     * shinseishoKanriNoのgetメソッドです。
     * 
     * @return shinseishoKanriNo
     */
    @CheckForNull
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * shinseishoKanriNoのsetメソッドです。
     * 
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * hihokenshaNoのgetメソッドです。
     * 
     * @return hihokenshaNo
     */
    @CheckForNull
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * hihokenshaNoのsetメソッドです。
     * 
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * rirekiNoのgetメソッドです。
     * 
     * @return rirekiNo
     */
    @CheckForNull
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     * 
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * torikomiTimestampのgetメソッドです。
     * 
     * @return torikomiTimestamp
     */
    @CheckForNull
    public YMDHMS getTorikomiTimestamp() {
        return torikomiTimestamp;
    }

    /**
     * torikomiTimestampのsetメソッドです。
     * 
     * @param torikomiTimestamp torikomiTimestamp
     */
    public void setTorikomiTimestamp(YMDHMS torikomiTimestamp) {
        this.torikomiTimestamp = torikomiTimestamp;
    }

    /**
     * torikomiKubunのgetメソッドです。
     * 
     * @return torikomiKubun
     */
    @CheckForNull
    public RString getTorikomiKubun() {
        return torikomiKubun;
    }

    /**
     * torikomiKubunのsetメソッドです。
     * 
     * @param torikomiKubun torikomiKubun
     */
    public void setTorikomiKubun(RString torikomiKubun) {
        this.torikomiKubun = torikomiKubun;
    }

    /**
     * shinseiShubetsuCodeのgetメソッドです。
     * 
     * @return shinseiShubetsuCode
     */
    @CheckForNull
    public RString getShinseiShubetsuCode() {
        return shinseiShubetsuCode;
    }

    /**
     * shinseiShubetsuCodeのsetメソッドです。
     * 
     * @param shinseiShubetsuCode shinseiShubetsuCode
     */
    public void setShinseiShubetsuCode(RString shinseiShubetsuCode) {
        this.shinseiShubetsuCode = shinseiShubetsuCode;
    }

    /**
     * torisageKubunCodeのgetメソッドです。
     * 
     * @return torisageKubunCode
     */
    @CheckForNull
    public RString getTorisageKubunCode() {
        return torisageKubunCode;
    }

    /**
     * torisageKubunCodeのsetメソッドです。
     * 
     * @param torisageKubunCode torisageKubunCode
     */
    public void setTorisageKubunCode(RString torisageKubunCode) {
        this.torisageKubunCode = torisageKubunCode;
    }

    /**
     * shinseiYMDのgetメソッドです。
     * 
     * @return shinseiYMD
     */
    @CheckForNull
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * shinseiYMDのsetメソッドです。
     * 
     * @param shinseiYMD shinseiYMD
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * iryoKikanCodeのgetメソッドです。
     * 
     * @return iryoKikanCode
     */
    @CheckForNull
    public RString getIryoKikanCode() {
        return iryoKikanCode;
    }

    /**
     * iryoKikanCodeのsetメソッドです。
     * 
     * @param iryoKikanCode iryoKikanCode
     */
    public void setIryoKikanCode(RString iryoKikanCode) {
        this.iryoKikanCode = iryoKikanCode;
    }

    /**
     * shujiiCodeのgetメソッドです。
     * 
     * @return shujiiCode
     */
    @CheckForNull
    public RString getShujiiCode() {
        return shujiiCode;
    }

    /**
     * shujiiCodeのsetメソッドです。
     * 
     * @param shujiiCode shujiiCode
     */
    public void setShujiiCode(RString shujiiCode) {
        this.shujiiCode = shujiiCode;
    }

    /**
     * ikenshoIraiYMDのgetメソッドです。
     * 
     * @return ikenshoIraiYMD
     */
    @CheckForNull
    public FlexibleDate getIkenshoIraiYMD() {
        return ikenshoIraiYMD;
    }

    /**
     * ikenshoIraiYMDのsetメソッドです。
     * 
     * @param ikenshoIraiYMD ikenshoIraiYMD
     */
    public void setIkenshoIraiYMD(FlexibleDate ikenshoIraiYMD) {
        this.ikenshoIraiYMD = ikenshoIraiYMD;
    }

    /**
     * ikenshoToriyoseYMDのgetメソッドです。
     * 
     * @return ikenshoToriyoseYMD
     */
    @CheckForNull
    public FlexibleDate getIkenshoToriyoseYMD() {
        return ikenshoToriyoseYMD;
    }

    /**
     * ikenshoToriyoseYMDのsetメソッドです。
     * 
     * @param ikenshoToriyoseYMD ikenshoToriyoseYMD
     */
    public void setIkenshoToriyoseYMD(FlexibleDate ikenshoToriyoseYMD) {
        this.ikenshoToriyoseYMD = ikenshoToriyoseYMD;
    }

    /**
     * chosaItakuYMDのgetメソッドです。
     * 
     * @return chosaItakuYMD
     */
    @CheckForNull
    public FlexibleDate getChosaItakuYMD() {
        return chosaItakuYMD;
    }

    /**
     * chosaItakuYMDのsetメソッドです。
     * 
     * @param chosaItakuYMD chosaItakuYMD
     */
    public void setChosaItakuYMD(FlexibleDate chosaItakuYMD) {
        this.chosaItakuYMD = chosaItakuYMD;
    }

    /**
     * chosaShuryoYMDのgetメソッドです。
     * 
     * @return chosaShuryoYMD
     */
    @CheckForNull
    public FlexibleDate getChosaShuryoYMD() {
        return chosaShuryoYMD;
    }

    /**
     * chosaShuryoYMDのsetメソッドです。
     * 
     * @param chosaShuryoYMD chosaShuryoYMD
     */
    public void setChosaShuryoYMD(FlexibleDate chosaShuryoYMD) {
        this.chosaShuryoYMD = chosaShuryoYMD;
    }

    /**
     * chosaItakusakiCodeのgetメソッドです。
     * 
     * @return chosaItakusakiCode
     */
    @CheckForNull
    public DbUDD004JigyoshaNo getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    /**
     * chosaItakusakiCodeのsetメソッドです。
     * 
     * @param chosaItakusakiCode chosaItakusakiCode
     */
    public void setChosaItakusakiCode(DbUDD004JigyoshaNo chosaItakusakiCode) {
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    /**
     * chosainCodeのgetメソッドです。
     * 
     * @return chosainCode
     */
    @CheckForNull
    public RString getChosainCode() {
        return chosainCode;
    }

    /**
     * chosainCodeのsetメソッドです。
     * 
     * @param chosainCode chosainCode
     */
    public void setChosainCode(RString chosainCode) {
        this.chosainCode = chosainCode;
    }

    /**
     * ichijiHanteiYMDのgetメソッドです。
     * 
     * @return ichijiHanteiYMD
     */
    @CheckForNull
    public FlexibleDate getIchijiHanteiYMD() {
        return ichijiHanteiYMD;
    }

    /**
     * ichijiHanteiYMDのsetメソッドです。
     * 
     * @param ichijiHanteiYMD ichijiHanteiYMD
     */
    public void setIchijiHanteiYMD(FlexibleDate ichijiHanteiYMD) {
        this.ichijiHanteiYMD = ichijiHanteiYMD;
    }

    /**
     * ichijiHanteiKekkaCodeのgetメソッドです。
     * 
     * @return ichijiHanteiKekkaCode
     */
    @CheckForNull
    public RString getIchijiHanteiKekkaCode() {
        return ichijiHanteiKekkaCode;
    }

    /**
     * ichijiHanteiKekkaCodeのsetメソッドです。
     * 
     * @param ichijiHanteiKekkaCode ichijiHanteiKekkaCode
     */
    public void setIchijiHanteiKekkaCode(RString ichijiHanteiKekkaCode) {
        this.ichijiHanteiKekkaCode = ichijiHanteiKekkaCode;
    }

    /**
     * ichijiHanteiKekkaKasanCodeのgetメソッドです。
     * 
     * @return ichijiHanteiKekkaKasanCode
     */
    @CheckForNull
    public RString getIchijiHanteiKekkaKasanCode() {
        return ichijiHanteiKekkaKasanCode;
    }

    /**
     * ichijiHanteiKekkaKasanCodeのsetメソッドです。
     * 
     * @param ichijiHanteiKekkaKasanCode ichijiHanteiKekkaKasanCode
     */
    public void setIchijiHanteiKekkaKasanCode(RString ichijiHanteiKekkaKasanCode) {
        this.ichijiHanteiKekkaKasanCode = ichijiHanteiKekkaKasanCode;
    }

    /**
     * shinsakaiShiryoSakuseiYMDのgetメソッドです。
     * 
     * @return shinsakaiShiryoSakuseiYMD
     */
    @CheckForNull
    public FlexibleDate getShinsakaiShiryoSakuseiYMD() {
        return shinsakaiShiryoSakuseiYMD;
    }

    /**
     * shinsakaiShiryoSakuseiYMDのsetメソッドです。
     * 
     * @param shinsakaiShiryoSakuseiYMD shinsakaiShiryoSakuseiYMD
     */
    public void setShinsakaiShiryoSakuseiYMD(FlexibleDate shinsakaiShiryoSakuseiYMD) {
        this.shinsakaiShiryoSakuseiYMD = shinsakaiShiryoSakuseiYMD;
    }

    /**
     * shinsakaiYoteiYMDのgetメソッドです。
     * 
     * @return shinsakaiYoteiYMD
     */
    @CheckForNull
    public FlexibleDate getShinsakaiYoteiYMD() {
        return shinsakaiYoteiYMD;
    }

    /**
     * shinsakaiYoteiYMDのsetメソッドです。
     * 
     * @param shinsakaiYoteiYMD shinsakaiYoteiYMD
     */
    public void setShinsakaiYoteiYMD(FlexibleDate shinsakaiYoteiYMD) {
        this.shinsakaiYoteiYMD = shinsakaiYoteiYMD;
    }

    /**
     * gogitaiNoのgetメソッドです。
     * 
     * @return gogitaiNo
     */
    @CheckForNull
    public int getGogitaiNo() {
        return gogitaiNo;
    }

    /**
     * gogitaiNoのsetメソッドです。
     * 
     * @param gogitaiNo gogitaiNo
     */
    public void setGogitaiNo(int gogitaiNo) {
        this.gogitaiNo = gogitaiNo;
    }

    /**
     * nijiHanteiYMDのgetメソッドです。
     * 
     * @return nijiHanteiYMD
     */
    @CheckForNull
    public FlexibleDate getNijiHanteiYMD() {
        return nijiHanteiYMD;
    }

    /**
     * nijiHanteiYMDのsetメソッドです。
     * 
     * @param nijiHanteiYMD nijiHanteiYMD
     */
    public void setNijiHanteiYMD(FlexibleDate nijiHanteiYMD) {
        this.nijiHanteiYMD = nijiHanteiYMD;
    }

    /**
     * nijiHanteiKekkaCodeのgetメソッドです。
     * 
     * @return nijiHanteiKekkaCode
     */
    @CheckForNull
    public RString getNijiHanteiKekkaCode() {
        return nijiHanteiKekkaCode;
    }

    /**
     * nijiHanteiKekkaCodeのsetメソッドです。
     * 
     * @param nijiHanteiKekkaCode nijiHanteiKekkaCode
     */
    public void setNijiHanteiKekkaCode(RString nijiHanteiKekkaCode) {
        this.nijiHanteiKekkaCode = nijiHanteiKekkaCode;
    }

    /**
     * ninteiYukoKikanStartのgetメソッドです。
     * 
     * @return ninteiYukoKikanStart
     */
    @CheckForNull
    public FlexibleDate getNinteiYukoKikanStart() {
        return ninteiYukoKikanStart;
    }

    /**
     * ninteiYukoKikanStartのsetメソッドです。
     * 
     * @param ninteiYukoKikanStart ninteiYukoKikanStart
     */
    public void setNinteiYukoKikanStart(FlexibleDate ninteiYukoKikanStart) {
        this.ninteiYukoKikanStart = ninteiYukoKikanStart;
    }

    /**
     * ninteiYukoKikanEndのgetメソッドです。
     * 
     * @return ninteiYukoKikanEnd
     */
    @CheckForNull
    public FlexibleDate getNinteiYukoKikanEnd() {
        return ninteiYukoKikanEnd;
    }

    /**
     * ninteiYukoKikanEndのsetメソッドです。
     * 
     * @param ninteiYukoKikanEnd ninteiYukoKikanEnd
     */
    public void setNinteiYukoKikanEnd(FlexibleDate ninteiYukoKikanEnd) {
        this.ninteiYukoKikanEnd = ninteiYukoKikanEnd;
    }

    /**
     * serviceHenkoRiyuCodeのgetメソッドです。
     * 
     * @return serviceHenkoRiyuCode
     */
    @CheckForNull
    public RString getServiceHenkoRiyuCode() {
        return serviceHenkoRiyuCode;
    }

    /**
     * serviceHenkoRiyuCodeのsetメソッドです。
     * 
     * @param serviceHenkoRiyuCode serviceHenkoRiyuCode
     */
    public void setServiceHenkoRiyuCode(RString serviceHenkoRiyuCode) {
        this.serviceHenkoRiyuCode = serviceHenkoRiyuCode;
    }

    /**
     * tokuteiShippeiCodeのgetメソッドです。
     * 
     * @return tokuteiShippeiCode
     */
    @CheckForNull
    public RString getTokuteiShippeiCode() {
        return tokuteiShippeiCode;
    }

    /**
     * tokuteiShippeiCodeのsetメソッドです。
     * 
     * @param tokuteiShippeiCode tokuteiShippeiCode
     */
    public void setTokuteiShippeiCode(RString tokuteiShippeiCode) {
        this.tokuteiShippeiCode = tokuteiShippeiCode;
    }

    /**
     * shogaiKoreiJiritsudoのgetメソッドです。
     * 
     * @return shogaiKoreiJiritsudo
     */
    @CheckForNull
    public RString getShogaiKoreiJiritsudo() {
        return shogaiKoreiJiritsudo;
    }

    /**
     * shogaiKoreiJiritsudoのsetメソッドです。
     * 
     * @param shogaiKoreiJiritsudo shogaiKoreiJiritsudo
     */
    public void setShogaiKoreiJiritsudo(RString shogaiKoreiJiritsudo) {
        this.shogaiKoreiJiritsudo = shogaiKoreiJiritsudo;
    }

    /**
     * ninchishoKoreiJiritsudoのgetメソッドです。
     * 
     * @return ninchishoKoreiJiritsudo
     */
    @CheckForNull
    public RString getNinchishoKoreiJiritsudo() {
        return ninchishoKoreiJiritsudo;
    }

    /**
     * ninchishoKoreiJiritsudoのsetメソッドです。
     * 
     * @param ninchishoKoreiJiritsudo ninchishoKoreiJiritsudo
     */
    public void setNinchishoKoreiJiritsudo(RString ninchishoKoreiJiritsudo) {
        this.ninchishoKoreiJiritsudo = ninchishoKoreiJiritsudo;
    }

    /**
     * shinsakaiIkenのgetメソッドです。
     * 
     * @return shinsakaiIken
     */
    @CheckForNull
    public RString getShinsakaiIken() {
        return shinsakaiIken;
    }

    /**
     * shinsakaiIkenのsetメソッドです。
     * 
     * @param shinsakaiIken shinsakaiIken
     */
    public void setShinsakaiIken(RString shinsakaiIken) {
        this.shinsakaiIken = shinsakaiIken;
    }

    /**
     * versionNoのgetメソッドです。
     * 
     * @return versionNo
     */
    @CheckForNull
    public RString getVersionNo() {
        return versionNo;
    }

    /**
     * versionNoのsetメソッドです。
     * 
     * @param versionNo versionNo
     */
    public void setVersionNo(RString versionNo) {
        this.versionNo = versionNo;
    }

    /**
     * ichijiHanteiNaiyoのgetメソッドです。
     * 
     * @return ichijiHanteiNaiyo
     */
    @CheckForNull
    public RString getIchijiHanteiNaiyo() {
        return ichijiHanteiNaiyo;
    }

    /**
     * ichijiHanteiNaiyoのsetメソッドです。
     * 
     * @param ichijiHanteiNaiyo ichijiHanteiNaiyo
     */
    public void setIchijiHanteiNaiyo(RString ichijiHanteiNaiyo) {
        this.ichijiHanteiNaiyo = ichijiHanteiNaiyo;
    }

    /**
     * ichijiHanteiNaiyo2のgetメソッドです。
     * 
     * @return ichijiHanteiNaiyo2
     */
    @CheckForNull
    public RString getIchijiHanteiNaiyo2() {
        return ichijiHanteiNaiyo2;
    }

    /**
     * ichijiHanteiNaiyo2のsetメソッドです。
     * 
     * @param ichijiHanteiNaiyo2 ichijiHanteiNaiyo2
     */
    public void setIchijiHanteiNaiyo2(RString ichijiHanteiNaiyo2) {
        this.ichijiHanteiNaiyo2 = ichijiHanteiNaiyo2;
    }

    /**
     * zenTorikomiTimestampのgetメソッドです。
     * 
     * @return zenTorikomiTimestamp
     */
    @CheckForNull
    public YMDHMS getZenTorikomiTimestamp() {
        return zenTorikomiTimestamp;
    }

    /**
     * zenTorikomiTimestampのsetメソッドです。
     * 
     * @param zenTorikomiTimestamp zenTorikomiTimestamp
     */
    public void setZenTorikomiTimestamp(YMDHMS zenTorikomiTimestamp) {
        this.zenTorikomiTimestamp = zenTorikomiTimestamp;
    }

    /**
     * keshikomiFlagのgetメソッドです。
     * 
     * @return keshikomiFlag
     */
    @CheckForNull
    public RString getKeshikomiFlag() {
        return keshikomiFlag;
    }

    /**
     * keshikomiFlagのsetメソッドです。
     * 
     * @param keshikomiFlag keshikomiFlag
     */
    public void setKeshikomiFlag(RString keshikomiFlag) {
        this.keshikomiFlag = keshikomiFlag;
    }

    /**
     * keshikomiTimestampのgetメソッドです。
     * 
     * @return keshikomiTimestamp
     */
    @CheckForNull
    public YMDHMS getKeshikomiTimestamp() {
        return keshikomiTimestamp;
    }

    /**
     * keshikomiTimestampのsetメソッドです。
     * 
     * @param keshikomiTimestamp keshikomiTimestamp
     */
    public void setKeshikomiTimestamp(YMDHMS keshikomiTimestamp) {
        this.keshikomiTimestamp = keshikomiTimestamp;
    }

    /**
     * yobiKomoku1のgetメソッドです。
     * 
     * @return yobiKomoku1
     */
    @CheckForNull
    public RString getYobiKomoku1() {
        return yobiKomoku1;
    }

    /**
     * yobiKomoku1のsetメソッドです。
     * 
     * @param yobiKomoku1 yobiKomoku1
     */
    public void setYobiKomoku1(RString yobiKomoku1) {
        this.yobiKomoku1 = yobiKomoku1;
    }

    /**
     * yobiKomoku2のgetメソッドです。
     * 
     * @return yobiKomoku2
     */
    @CheckForNull
    public RString getYobiKomoku2() {
        return yobiKomoku2;
    }

    /**
     * yobiKomoku2のsetメソッドです。
     * 
     * @param yobiKomoku2 yobiKomoku2
     */
    public void setYobiKomoku2(RString yobiKomoku2) {
        this.yobiKomoku2 = yobiKomoku2;
    }

    /**
     * yobiKomoku3のgetメソッドです。
     * 
     * @return yobiKomoku3
     */
    @CheckForNull
    public RString getYobiKomoku3() {
        return yobiKomoku3;
    }

    /**
     * yobiKomoku3のsetメソッドです。
     * 
     * @param yobiKomoku3 yobiKomoku3
     */
    public void setYobiKomoku3(RString yobiKomoku3) {
        this.yobiKomoku3 = yobiKomoku3;
    }

    /**
     * yobiKomoku4のgetメソッドです。
     * 
     * @return yobiKomoku4
     */
    @CheckForNull
    public RString getYobiKomoku4() {
        return yobiKomoku4;
    }

    /**
     * yobiKomoku4のsetメソッドです。
     * 
     * @param yobiKomoku4 yobiKomoku4
     */
    public void setYobiKomoku4(RString yobiKomoku4) {
        this.yobiKomoku4 = yobiKomoku4;
    }

    /**
     * yobiKomoku5のgetメソッドです。
     * 
     * @return yobiKomoku5
     */
    @CheckForNull
    public RString getYobiKomoku5() {
        return yobiKomoku5;
    }

    /**
     * yobiKomoku5のsetメソッドです。
     * 
     * @param yobiKomoku5 yobiKomoku5
     */
    public void setYobiKomoku5(RString yobiKomoku5) {
        this.yobiKomoku5 = yobiKomoku5;
    }

    /**
     * yobiKubun1のgetメソッドです。
     * 
     * @return yobiKubun1
     */
    @CheckForNull
    public RString getYobiKubun1() {
        return yobiKubun1;
    }

    /**
     * yobiKubun1のsetメソッドです。
     * 
     * @param yobiKubun1 yobiKubun1
     */
    public void setYobiKubun1(RString yobiKubun1) {
        this.yobiKubun1 = yobiKubun1;
    }

    /**
     * yobiKubun2のgetメソッドです。
     * 
     * @return yobiKubun2
     */
    @CheckForNull
    public RString getYobiKubun2() {
        return yobiKubun2;
    }

    /**
     * yobiKubun2のsetメソッドです。
     * 
     * @param yobiKubun2 yobiKubun2
     */
    public void setYobiKubun2(RString yobiKubun2) {
        this.yobiKubun2 = yobiKubun2;
    }

    /**
     * yobiKubun3のgetメソッドです。
     * 
     * @return yobiKubun3
     */
    @CheckForNull
    public RString getYobiKubun3() {
        return yobiKubun3;
    }

    /**
     * yobiKubun3のsetメソッドです。
     * 
     * @param yobiKubun3 yobiKubun3
     */
    public void setYobiKubun3(RString yobiKubun3) {
        this.yobiKubun3 = yobiKubun3;
    }

    /**
     * yobiKubun4のgetメソッドです。
     * 
     * @return yobiKubun4
     */
    @CheckForNull
    public RString getYobiKubun4() {
        return yobiKubun4;
    }

    /**
     * yobiKubun4のsetメソッドです。
     * 
     * @param yobiKubun4 yobiKubun4
     */
    public void setYobiKubun4(RString yobiKubun4) {
        this.yobiKubun4 = yobiKubun4;
    }

    /**
     * yobiKubun5のgetメソッドです。
     * 
     * @return yobiKubun5
     */
    @CheckForNull
    public RString getYobiKubun5() {
        return yobiKubun5;
    }

    /**
     * yobiKubun5のsetメソッドです。
     * 
     * @param yobiKubun5 yobiKubun5
     */
    public void setYobiKubun5(RString yobiKubun5) {
        this.yobiKubun5 = yobiKubun5;
    }

    /**
     * reserveのgetメソッドです。
     * 
     * @return reserve
     */
    @CheckForNull
    public RString getReserve() {
        return reserve;
    }

    /**
     * reserveのsetメソッドです。
     * 
     * @param reserve reserve
     */
    public void setReserve(RString reserve) {
        this.reserve = reserve;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV7513YokaigoNinteiInterfaceFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7513YokaigoNinteiInterfaceFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7513YokaigoNinteiInterfaceFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7513YokaigoNinteiInterfaceFukushiEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.torikomiTimestamp = entity.torikomiTimestamp;
        this.torikomiKubun = entity.torikomiKubun;
        this.shinseiShubetsuCode = entity.shinseiShubetsuCode;
        this.torisageKubunCode = entity.torisageKubunCode;
        this.shinseiYMD = entity.shinseiYMD;
        this.iryoKikanCode = entity.iryoKikanCode;
        this.shujiiCode = entity.shujiiCode;
        this.ikenshoIraiYMD = entity.ikenshoIraiYMD;
        this.ikenshoToriyoseYMD = entity.ikenshoToriyoseYMD;
        this.chosaItakuYMD = entity.chosaItakuYMD;
        this.chosaShuryoYMD = entity.chosaShuryoYMD;
        this.chosaItakusakiCode = entity.chosaItakusakiCode;
        this.chosainCode = entity.chosainCode;
        this.ichijiHanteiYMD = entity.ichijiHanteiYMD;
        this.ichijiHanteiKekkaCode = entity.ichijiHanteiKekkaCode;
        this.ichijiHanteiKekkaKasanCode = entity.ichijiHanteiKekkaKasanCode;
        this.shinsakaiShiryoSakuseiYMD = entity.shinsakaiShiryoSakuseiYMD;
        this.shinsakaiYoteiYMD = entity.shinsakaiYoteiYMD;
        this.gogitaiNo = entity.gogitaiNo;
        this.nijiHanteiYMD = entity.nijiHanteiYMD;
        this.nijiHanteiKekkaCode = entity.nijiHanteiKekkaCode;
        this.ninteiYukoKikanStart = entity.ninteiYukoKikanStart;
        this.ninteiYukoKikanEnd = entity.ninteiYukoKikanEnd;
        this.serviceHenkoRiyuCode = entity.serviceHenkoRiyuCode;
        this.tokuteiShippeiCode = entity.tokuteiShippeiCode;
        this.shogaiKoreiJiritsudo = entity.shogaiKoreiJiritsudo;
        this.ninchishoKoreiJiritsudo = entity.ninchishoKoreiJiritsudo;
        this.shinsakaiIken = entity.shinsakaiIken;
        this.versionNo = entity.versionNo;
        this.ichijiHanteiNaiyo = entity.ichijiHanteiNaiyo;
        this.ichijiHanteiNaiyo2 = entity.ichijiHanteiNaiyo2;
        this.zenTorikomiTimestamp = entity.zenTorikomiTimestamp;
        this.keshikomiFlag = entity.keshikomiFlag;
        this.keshikomiTimestamp = entity.keshikomiTimestamp;
        this.yobiKomoku1 = entity.yobiKomoku1;
        this.yobiKomoku2 = entity.yobiKomoku2;
        this.yobiKomoku3 = entity.yobiKomoku3;
        this.yobiKomoku4 = entity.yobiKomoku4;
        this.yobiKomoku5 = entity.yobiKomoku5;
        this.yobiKubun1 = entity.yobiKubun1;
        this.yobiKubun2 = entity.yobiKubun2;
        this.yobiKubun3 = entity.yobiKubun3;
        this.yobiKubun4 = entity.yobiKubun4;
        this.yobiKubun5 = entity.yobiKubun5;
        this.reserve = entity.reserve;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, hihokenshaNo, rirekiNo, torikomiTimestamp, torikomiKubun, shinseiShubetsuCode, torisageKubunCode, shinseiYMD, iryoKikanCode, shujiiCode, ikenshoIraiYMD, ikenshoToriyoseYMD, chosaItakuYMD, chosaShuryoYMD, chosaItakusakiCode, chosainCode, ichijiHanteiYMD, ichijiHanteiKekkaCode, ichijiHanteiKekkaKasanCode, shinsakaiShiryoSakuseiYMD, shinsakaiYoteiYMD, gogitaiNo, nijiHanteiYMD, nijiHanteiKekkaCode, ninteiYukoKikanStart, ninteiYukoKikanEnd, serviceHenkoRiyuCode, tokuteiShippeiCode, shogaiKoreiJiritsudo, ninchishoKoreiJiritsudo, shinsakaiIken, versionNo, ichijiHanteiNaiyo, ichijiHanteiNaiyo2, zenTorikomiTimestamp, keshikomiFlag, keshikomiTimestamp, yobiKomoku1, yobiKomoku2, yobiKomoku3, yobiKomoku4, yobiKomoku5, yobiKubun1, yobiKubun2, yobiKubun3, yobiKubun4, yobiKubun5, reserve);
    }

// </editor-fold>
}
