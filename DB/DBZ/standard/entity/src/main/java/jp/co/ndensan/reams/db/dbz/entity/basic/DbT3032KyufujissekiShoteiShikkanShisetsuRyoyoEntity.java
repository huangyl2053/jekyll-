package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoの項目定義クラスです
 *
 */
public class DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity extends DbTableEntityBase<DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3032KyufujissekiShoteiShikkanShisetsuRyoyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @PrimaryKey
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @PrimaryKey
    private RString recodeShubetsuCode;
    @PrimaryKey
    private HokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private RString toshiNo;
    @PrimaryKey
    private RString recodeJunjiNo;
    private RString kinkyuShobyoName1;
    private RString kinkyuShobyoName2;
    private RString kinkyuShobyoName3;
    private FlexibleDate kinkyuChiryoKaishiYMD1;
    private FlexibleDate kinkyuChiryoKaishiYMD2;
    private FlexibleDate kinkyuChiryoKaishiYMD3;
    private int oshinNissu;
    private RString oshinIryoKikanName;
    private int tsuinNissu;
    private RString tsuinIryoKikanName;
    private int kinkyuChiryoKanriTanisu;
    private int kinkyuChiryoKanriNissu;
    private int kinkyuChiryoKanriSubTotal;
    private int rehabilitationTensu;
    private int shochiTensu;
    private int shujutsuTensu;
    private int masuiTensu;
    private int hoshasenChiryoTensu;
    private RString tekiyo1;
    private RString tekiyo2;
    private RString tekiyo3;
    private RString tekiyo4;
    private RString tekiyo5;
    private RString tekiyo6;
    private RString tekiyo7;
    private RString tekiyo8;
    private RString tekiyo9;
    private RString tekiyo10;
    private RString tekiyo11;
    private RString tekiyo12;
    private RString tekiyo13;
    private RString tekiyo14;
    private RString tekiyo15;
    private RString tekiyo16;
    private RString tekiyo17;
    private RString tekiyo18;
    private RString tekiyo19;
    private RString tekiyo20;
    private int kinkyuShisetsuRyoyohiTotalTensu;
    private RString shoteiShikkanShisetsuRyoyohiShobyoName1;
    private RString shoteiShikkanShisetsuRyoyohiShobyoName2;
    private RString shoteiShikkanShisetsuRyoyohiShobyoName3;
    private FlexibleDate shoteiShikkanShisetsuRyoyohiKaishiYMD1;
    private FlexibleDate shoteiShikkanShisetsuRyoyohiKaishiYMD2;
    private FlexibleDate shoteiShikkanShisetsuRyoyohiKaishiYMD3;
    private int shoteiShikkanShisetsuRyoyohiTanisu;
    private int shoteiShikkanShisetsuRyoyohiNissu;
    private int shoteiShikkanShisetsuRyoyohiSubTotal;
    private int atoOshinNissu;
    private int atoTsuinNissu;
    private int atoKinkyuChiryoKanriTanisu;
    private int atoKinkyuChiryoKanriNissu;
    private int atoRehabilitationTensu;
    private int atoShochiTensu;
    private int atoShujutsuTensu;
    private int atoMasuiTensu;
    private int atoHoshasenChiryoTensu;
    private int atoShoteiShikkanShisetsuRyoyoHiTanisu;
    private int atoShoteiShikkanShisetsuRyoyoHiNissu;
    private int saishinsaKaisu;
    private int kagoKaisu;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
    private FlexibleYearMonth torikomiYM;

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
     * getKokanJohoShikibetsuNo
     *
     * @return kokanJohoShikibetsuNo
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * setKokanJohoShikibetsuNo
     *
     * @param kokanJohoShikibetsuNo kokanJohoShikibetsuNo
     */
    public void setKokanJohoShikibetsuNo(KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
    }

    /**
     * getInputShikibetsuNo
     *
     * @return inputShikibetsuNo
     */
    public NyuryokuShikibetsuNo getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * setInputShikibetsuNo
     *
     * @param inputShikibetsuNo inputShikibetsuNo
     */
    public void setInputShikibetsuNo(NyuryokuShikibetsuNo inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * getRecodeShubetsuCode
     *
     * @return recodeShubetsuCode
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * setRecodeShubetsuCode
     *
     * @param recodeShubetsuCode recodeShubetsuCode
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * getShokisaiHokenshaNo
     *
     * @return shokisaiHokenshaNo
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * setShokisaiHokenshaNo
     *
     * @param shokisaiHokenshaNo shokisaiHokenshaNo
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getJigyoshoNo
     *
     * @return jigyoshoNo
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * setJigyoshoNo
     *
     * @param jigyoshoNo jigyoshoNo
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * getToshiNo
     *
     * @return toshiNo
     */
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * setToshiNo
     *
     * @param toshiNo toshiNo
     */
    public void setToshiNo(RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * getRecodeJunjiNo
     *
     * @return recodeJunjiNo
     */
    public RString getRecodeJunjiNo() {
        return recodeJunjiNo;
    }

    /**
     * setRecodeJunjiNo
     *
     * @param recodeJunjiNo recodeJunjiNo
     */
    public void setRecodeJunjiNo(RString recodeJunjiNo) {
        this.recodeJunjiNo = recodeJunjiNo;
    }

    /**
     * getKinkyuShobyoName1
     *
     * @return kinkyuShobyoName1
     */
    public RString getKinkyuShobyoName1() {
        return kinkyuShobyoName1;
    }

    /**
     * setKinkyuShobyoName1
     *
     * @param kinkyuShobyoName1 kinkyuShobyoName1
     */
    public void setKinkyuShobyoName1(RString kinkyuShobyoName1) {
        this.kinkyuShobyoName1 = kinkyuShobyoName1;
    }

    /**
     * getKinkyuShobyoName2
     *
     * @return kinkyuShobyoName2
     */
    public RString getKinkyuShobyoName2() {
        return kinkyuShobyoName2;
    }

    /**
     * setKinkyuShobyoName2
     *
     * @param kinkyuShobyoName2 kinkyuShobyoName2
     */
    public void setKinkyuShobyoName2(RString kinkyuShobyoName2) {
        this.kinkyuShobyoName2 = kinkyuShobyoName2;
    }

    /**
     * getKinkyuShobyoName3
     *
     * @return kinkyuShobyoName3
     */
    public RString getKinkyuShobyoName3() {
        return kinkyuShobyoName3;
    }

    /**
     * setKinkyuShobyoName3
     *
     * @param kinkyuShobyoName3 kinkyuShobyoName3
     */
    public void setKinkyuShobyoName3(RString kinkyuShobyoName3) {
        this.kinkyuShobyoName3 = kinkyuShobyoName3;
    }

    /**
     * getKinkyuChiryoKaishiYMD1
     *
     * @return kinkyuChiryoKaishiYMD1
     */
    public FlexibleDate getKinkyuChiryoKaishiYMD1() {
        return kinkyuChiryoKaishiYMD1;
    }

    /**
     * setKinkyuChiryoKaishiYMD1
     *
     * @param kinkyuChiryoKaishiYMD1 kinkyuChiryoKaishiYMD1
     */
    public void setKinkyuChiryoKaishiYMD1(FlexibleDate kinkyuChiryoKaishiYMD1) {
        this.kinkyuChiryoKaishiYMD1 = kinkyuChiryoKaishiYMD1;
    }

    /**
     * getKinkyuChiryoKaishiYMD2
     *
     * @return kinkyuChiryoKaishiYMD2
     */
    public FlexibleDate getKinkyuChiryoKaishiYMD2() {
        return kinkyuChiryoKaishiYMD2;
    }

    /**
     * setKinkyuChiryoKaishiYMD2
     *
     * @param kinkyuChiryoKaishiYMD2 kinkyuChiryoKaishiYMD2
     */
    public void setKinkyuChiryoKaishiYMD2(FlexibleDate kinkyuChiryoKaishiYMD2) {
        this.kinkyuChiryoKaishiYMD2 = kinkyuChiryoKaishiYMD2;
    }

    /**
     * getKinkyuChiryoKaishiYMD3
     *
     * @return kinkyuChiryoKaishiYMD3
     */
    public FlexibleDate getKinkyuChiryoKaishiYMD3() {
        return kinkyuChiryoKaishiYMD3;
    }

    /**
     * setKinkyuChiryoKaishiYMD3
     *
     * @param kinkyuChiryoKaishiYMD3 kinkyuChiryoKaishiYMD3
     */
    public void setKinkyuChiryoKaishiYMD3(FlexibleDate kinkyuChiryoKaishiYMD3) {
        this.kinkyuChiryoKaishiYMD3 = kinkyuChiryoKaishiYMD3;
    }

    /**
     * getOshinNissu
     *
     * @return oshinNissu
     */
    public int getOshinNissu() {
        return oshinNissu;
    }

    /**
     * setOshinNissu
     *
     * @param oshinNissu oshinNissu
     */
    public void setOshinNissu(int oshinNissu) {
        this.oshinNissu = oshinNissu;
    }

    /**
     * getOshinIryoKikanName
     *
     * @return oshinIryoKikanName
     */
    public RString getOshinIryoKikanName() {
        return oshinIryoKikanName;
    }

    /**
     * setOshinIryoKikanName
     *
     * @param oshinIryoKikanName oshinIryoKikanName
     */
    public void setOshinIryoKikanName(RString oshinIryoKikanName) {
        this.oshinIryoKikanName = oshinIryoKikanName;
    }

    /**
     * getTsuinNissu
     *
     * @return tsuinNissu
     */
    public int getTsuinNissu() {
        return tsuinNissu;
    }

    /**
     * setTsuinNissu
     *
     * @param tsuinNissu tsuinNissu
     */
    public void setTsuinNissu(int tsuinNissu) {
        this.tsuinNissu = tsuinNissu;
    }

    /**
     * getTsuinIryoKikanName
     *
     * @return tsuinIryoKikanName
     */
    public RString getTsuinIryoKikanName() {
        return tsuinIryoKikanName;
    }

    /**
     * setTsuinIryoKikanName
     *
     * @param tsuinIryoKikanName tsuinIryoKikanName
     */
    public void setTsuinIryoKikanName(RString tsuinIryoKikanName) {
        this.tsuinIryoKikanName = tsuinIryoKikanName;
    }

    /**
     * getKinkyuChiryoKanriTanisu
     *
     * @return kinkyuChiryoKanriTanisu
     */
    public int getKinkyuChiryoKanriTanisu() {
        return kinkyuChiryoKanriTanisu;
    }

    /**
     * setKinkyuChiryoKanriTanisu
     *
     * @param kinkyuChiryoKanriTanisu kinkyuChiryoKanriTanisu
     */
    public void setKinkyuChiryoKanriTanisu(int kinkyuChiryoKanriTanisu) {
        this.kinkyuChiryoKanriTanisu = kinkyuChiryoKanriTanisu;
    }

    /**
     * getKinkyuChiryoKanriNissu
     *
     * @return kinkyuChiryoKanriNissu
     */
    public int getKinkyuChiryoKanriNissu() {
        return kinkyuChiryoKanriNissu;
    }

    /**
     * setKinkyuChiryoKanriNissu
     *
     * @param kinkyuChiryoKanriNissu kinkyuChiryoKanriNissu
     */
    public void setKinkyuChiryoKanriNissu(int kinkyuChiryoKanriNissu) {
        this.kinkyuChiryoKanriNissu = kinkyuChiryoKanriNissu;
    }

    /**
     * getKinkyuChiryoKanriSubTotal
     *
     * @return kinkyuChiryoKanriSubTotal
     */
    public int getKinkyuChiryoKanriSubTotal() {
        return kinkyuChiryoKanriSubTotal;
    }

    /**
     * setKinkyuChiryoKanriSubTotal
     *
     * @param kinkyuChiryoKanriSubTotal kinkyuChiryoKanriSubTotal
     */
    public void setKinkyuChiryoKanriSubTotal(int kinkyuChiryoKanriSubTotal) {
        this.kinkyuChiryoKanriSubTotal = kinkyuChiryoKanriSubTotal;
    }

    /**
     * getRehabilitationTensu
     *
     * @return rehabilitationTensu
     */
    public int getRehabilitationTensu() {
        return rehabilitationTensu;
    }

    /**
     * setRehabilitationTensu
     *
     * @param rehabilitationTensu rehabilitationTensu
     */
    public void setRehabilitationTensu(int rehabilitationTensu) {
        this.rehabilitationTensu = rehabilitationTensu;
    }

    /**
     * getShochiTensu
     *
     * @return shochiTensu
     */
    public int getShochiTensu() {
        return shochiTensu;
    }

    /**
     * setShochiTensu
     *
     * @param shochiTensu shochiTensu
     */
    public void setShochiTensu(int shochiTensu) {
        this.shochiTensu = shochiTensu;
    }

    /**
     * getShujutsuTensu
     *
     * @return shujutsuTensu
     */
    public int getShujutsuTensu() {
        return shujutsuTensu;
    }

    /**
     * setShujutsuTensu
     *
     * @param shujutsuTensu shujutsuTensu
     */
    public void setShujutsuTensu(int shujutsuTensu) {
        this.shujutsuTensu = shujutsuTensu;
    }

    /**
     * getMasuiTensu
     *
     * @return masuiTensu
     */
    public int getMasuiTensu() {
        return masuiTensu;
    }

    /**
     * setMasuiTensu
     *
     * @param masuiTensu masuiTensu
     */
    public void setMasuiTensu(int masuiTensu) {
        this.masuiTensu = masuiTensu;
    }

    /**
     * getHoshasenChiryoTensu
     *
     * @return hoshasenChiryoTensu
     */
    public int getHoshasenChiryoTensu() {
        return hoshasenChiryoTensu;
    }

    /**
     * setHoshasenChiryoTensu
     *
     * @param hoshasenChiryoTensu hoshasenChiryoTensu
     */
    public void setHoshasenChiryoTensu(int hoshasenChiryoTensu) {
        this.hoshasenChiryoTensu = hoshasenChiryoTensu;
    }

    /**
     * getTekiyo1
     *
     * @return tekiyo1
     */
    public RString getTekiyo1() {
        return tekiyo1;
    }

    /**
     * setTekiyo1
     *
     * @param tekiyo1 tekiyo1
     */
    public void setTekiyo1(RString tekiyo1) {
        this.tekiyo1 = tekiyo1;
    }

    /**
     * getTekiyo2
     *
     * @return tekiyo2
     */
    public RString getTekiyo2() {
        return tekiyo2;
    }

    /**
     * setTekiyo2
     *
     * @param tekiyo2 tekiyo2
     */
    public void setTekiyo2(RString tekiyo2) {
        this.tekiyo2 = tekiyo2;
    }

    /**
     * getTekiyo3
     *
     * @return tekiyo3
     */
    public RString getTekiyo3() {
        return tekiyo3;
    }

    /**
     * setTekiyo3
     *
     * @param tekiyo3 tekiyo3
     */
    public void setTekiyo3(RString tekiyo3) {
        this.tekiyo3 = tekiyo3;
    }

    /**
     * getTekiyo4
     *
     * @return tekiyo4
     */
    public RString getTekiyo4() {
        return tekiyo4;
    }

    /**
     * setTekiyo4
     *
     * @param tekiyo4 tekiyo4
     */
    public void setTekiyo4(RString tekiyo4) {
        this.tekiyo4 = tekiyo4;
    }

    /**
     * getTekiyo5
     *
     * @return tekiyo5
     */
    public RString getTekiyo5() {
        return tekiyo5;
    }

    /**
     * setTekiyo5
     *
     * @param tekiyo5 tekiyo5
     */
    public void setTekiyo5(RString tekiyo5) {
        this.tekiyo5 = tekiyo5;
    }

    /**
     * getTekiyo6
     *
     * @return tekiyo6
     */
    public RString getTekiyo6() {
        return tekiyo6;
    }

    /**
     * setTekiyo6
     *
     * @param tekiyo6 tekiyo6
     */
    public void setTekiyo6(RString tekiyo6) {
        this.tekiyo6 = tekiyo6;
    }

    /**
     * getTekiyo7
     *
     * @return tekiyo7
     */
    public RString getTekiyo7() {
        return tekiyo7;
    }

    /**
     * setTekiyo7
     *
     * @param tekiyo7 tekiyo7
     */
    public void setTekiyo7(RString tekiyo7) {
        this.tekiyo7 = tekiyo7;
    }

    /**
     * getTekiyo8
     *
     * @return tekiyo8
     */
    public RString getTekiyo8() {
        return tekiyo8;
    }

    /**
     * setTekiyo8
     *
     * @param tekiyo8 tekiyo8
     */
    public void setTekiyo8(RString tekiyo8) {
        this.tekiyo8 = tekiyo8;
    }

    /**
     * getTekiyo9
     *
     * @return tekiyo9
     */
    public RString getTekiyo9() {
        return tekiyo9;
    }

    /**
     * setTekiyo9
     *
     * @param tekiyo9 tekiyo9
     */
    public void setTekiyo9(RString tekiyo9) {
        this.tekiyo9 = tekiyo9;
    }

    /**
     * getTekiyo10
     *
     * @return tekiyo10
     */
    public RString getTekiyo10() {
        return tekiyo10;
    }

    /**
     * setTekiyo10
     *
     * @param tekiyo10 tekiyo10
     */
    public void setTekiyo10(RString tekiyo10) {
        this.tekiyo10 = tekiyo10;
    }

    /**
     * getTekiyo11
     *
     * @return tekiyo11
     */
    public RString getTekiyo11() {
        return tekiyo11;
    }

    /**
     * setTekiyo11
     *
     * @param tekiyo11 tekiyo11
     */
    public void setTekiyo11(RString tekiyo11) {
        this.tekiyo11 = tekiyo11;
    }

    /**
     * getTekiyo12
     *
     * @return tekiyo12
     */
    public RString getTekiyo12() {
        return tekiyo12;
    }

    /**
     * setTekiyo12
     *
     * @param tekiyo12 tekiyo12
     */
    public void setTekiyo12(RString tekiyo12) {
        this.tekiyo12 = tekiyo12;
    }

    /**
     * getTekiyo13
     *
     * @return tekiyo13
     */
    public RString getTekiyo13() {
        return tekiyo13;
    }

    /**
     * setTekiyo13
     *
     * @param tekiyo13 tekiyo13
     */
    public void setTekiyo13(RString tekiyo13) {
        this.tekiyo13 = tekiyo13;
    }

    /**
     * getTekiyo14
     *
     * @return tekiyo14
     */
    public RString getTekiyo14() {
        return tekiyo14;
    }

    /**
     * setTekiyo14
     *
     * @param tekiyo14 tekiyo14
     */
    public void setTekiyo14(RString tekiyo14) {
        this.tekiyo14 = tekiyo14;
    }

    /**
     * getTekiyo15
     *
     * @return tekiyo15
     */
    public RString getTekiyo15() {
        return tekiyo15;
    }

    /**
     * setTekiyo15
     *
     * @param tekiyo15 tekiyo15
     */
    public void setTekiyo15(RString tekiyo15) {
        this.tekiyo15 = tekiyo15;
    }

    /**
     * getTekiyo16
     *
     * @return tekiyo16
     */
    public RString getTekiyo16() {
        return tekiyo16;
    }

    /**
     * setTekiyo16
     *
     * @param tekiyo16 tekiyo16
     */
    public void setTekiyo16(RString tekiyo16) {
        this.tekiyo16 = tekiyo16;
    }

    /**
     * getTekiyo17
     *
     * @return tekiyo17
     */
    public RString getTekiyo17() {
        return tekiyo17;
    }

    /**
     * setTekiyo17
     *
     * @param tekiyo17 tekiyo17
     */
    public void setTekiyo17(RString tekiyo17) {
        this.tekiyo17 = tekiyo17;
    }

    /**
     * getTekiyo18
     *
     * @return tekiyo18
     */
    public RString getTekiyo18() {
        return tekiyo18;
    }

    /**
     * setTekiyo18
     *
     * @param tekiyo18 tekiyo18
     */
    public void setTekiyo18(RString tekiyo18) {
        this.tekiyo18 = tekiyo18;
    }

    /**
     * getTekiyo19
     *
     * @return tekiyo19
     */
    public RString getTekiyo19() {
        return tekiyo19;
    }

    /**
     * setTekiyo19
     *
     * @param tekiyo19 tekiyo19
     */
    public void setTekiyo19(RString tekiyo19) {
        this.tekiyo19 = tekiyo19;
    }

    /**
     * getTekiyo20
     *
     * @return tekiyo20
     */
    public RString getTekiyo20() {
        return tekiyo20;
    }

    /**
     * setTekiyo20
     *
     * @param tekiyo20 tekiyo20
     */
    public void setTekiyo20(RString tekiyo20) {
        this.tekiyo20 = tekiyo20;
    }

    /**
     * getKinkyuShisetsuRyoyohiTotalTensu
     *
     * @return kinkyuShisetsuRyoyohiTotalTensu
     */
    public int getKinkyuShisetsuRyoyohiTotalTensu() {
        return kinkyuShisetsuRyoyohiTotalTensu;
    }

    /**
     * setKinkyuShisetsuRyoyohiTotalTensu
     *
     * @param kinkyuShisetsuRyoyohiTotalTensu kinkyuShisetsuRyoyohiTotalTensu
     */
    public void setKinkyuShisetsuRyoyohiTotalTensu(int kinkyuShisetsuRyoyohiTotalTensu) {
        this.kinkyuShisetsuRyoyohiTotalTensu = kinkyuShisetsuRyoyohiTotalTensu;
    }

    /**
     * getShoteiShikkanShisetsuRyoyohiShobyoName1
     *
     * @return shoteiShikkanShisetsuRyoyohiShobyoName1
     */
    public RString getShoteiShikkanShisetsuRyoyohiShobyoName1() {
        return shoteiShikkanShisetsuRyoyohiShobyoName1;
    }

    /**
     * setShoteiShikkanShisetsuRyoyohiShobyoName1
     *
     * @param shoteiShikkanShisetsuRyoyohiShobyoName1 shoteiShikkanShisetsuRyoyohiShobyoName1
     */
    public void setShoteiShikkanShisetsuRyoyohiShobyoName1(RString shoteiShikkanShisetsuRyoyohiShobyoName1) {
        this.shoteiShikkanShisetsuRyoyohiShobyoName1 = shoteiShikkanShisetsuRyoyohiShobyoName1;
    }

    /**
     * getShoteiShikkanShisetsuRyoyohiShobyoName2
     *
     * @return shoteiShikkanShisetsuRyoyohiShobyoName2
     */
    public RString getShoteiShikkanShisetsuRyoyohiShobyoName2() {
        return shoteiShikkanShisetsuRyoyohiShobyoName2;
    }

    /**
     * setShoteiShikkanShisetsuRyoyohiShobyoName2
     *
     * @param shoteiShikkanShisetsuRyoyohiShobyoName2 shoteiShikkanShisetsuRyoyohiShobyoName2
     */
    public void setShoteiShikkanShisetsuRyoyohiShobyoName2(RString shoteiShikkanShisetsuRyoyohiShobyoName2) {
        this.shoteiShikkanShisetsuRyoyohiShobyoName2 = shoteiShikkanShisetsuRyoyohiShobyoName2;
    }

    /**
     * getShoteiShikkanShisetsuRyoyohiShobyoName3
     *
     * @return shoteiShikkanShisetsuRyoyohiShobyoName3
     */
    public RString getShoteiShikkanShisetsuRyoyohiShobyoName3() {
        return shoteiShikkanShisetsuRyoyohiShobyoName3;
    }

    /**
     * setShoteiShikkanShisetsuRyoyohiShobyoName3
     *
     * @param shoteiShikkanShisetsuRyoyohiShobyoName3 shoteiShikkanShisetsuRyoyohiShobyoName3
     */
    public void setShoteiShikkanShisetsuRyoyohiShobyoName3(RString shoteiShikkanShisetsuRyoyohiShobyoName3) {
        this.shoteiShikkanShisetsuRyoyohiShobyoName3 = shoteiShikkanShisetsuRyoyohiShobyoName3;
    }

    /**
     * getShoteiShikkanShisetsuRyoyohiKaishiYMD1
     *
     * @return shoteiShikkanShisetsuRyoyohiKaishiYMD1
     */
    public FlexibleDate getShoteiShikkanShisetsuRyoyohiKaishiYMD1() {
        return shoteiShikkanShisetsuRyoyohiKaishiYMD1;
    }

    /**
     * setShoteiShikkanShisetsuRyoyohiKaishiYMD1
     *
     * @param shoteiShikkanShisetsuRyoyohiKaishiYMD1 shoteiShikkanShisetsuRyoyohiKaishiYMD1
     */
    public void setShoteiShikkanShisetsuRyoyohiKaishiYMD1(FlexibleDate shoteiShikkanShisetsuRyoyohiKaishiYMD1) {
        this.shoteiShikkanShisetsuRyoyohiKaishiYMD1 = shoteiShikkanShisetsuRyoyohiKaishiYMD1;
    }

    /**
     * getShoteiShikkanShisetsuRyoyohiKaishiYMD2
     *
     * @return shoteiShikkanShisetsuRyoyohiKaishiYMD2
     */
    public FlexibleDate getShoteiShikkanShisetsuRyoyohiKaishiYMD2() {
        return shoteiShikkanShisetsuRyoyohiKaishiYMD2;
    }

    /**
     * setShoteiShikkanShisetsuRyoyohiKaishiYMD2
     *
     * @param shoteiShikkanShisetsuRyoyohiKaishiYMD2 shoteiShikkanShisetsuRyoyohiKaishiYMD2
     */
    public void setShoteiShikkanShisetsuRyoyohiKaishiYMD2(FlexibleDate shoteiShikkanShisetsuRyoyohiKaishiYMD2) {
        this.shoteiShikkanShisetsuRyoyohiKaishiYMD2 = shoteiShikkanShisetsuRyoyohiKaishiYMD2;
    }

    /**
     * getShoteiShikkanShisetsuRyoyohiKaishiYMD3
     *
     * @return shoteiShikkanShisetsuRyoyohiKaishiYMD3
     */
    public FlexibleDate getShoteiShikkanShisetsuRyoyohiKaishiYMD3() {
        return shoteiShikkanShisetsuRyoyohiKaishiYMD3;
    }

    /**
     * setShoteiShikkanShisetsuRyoyohiKaishiYMD3
     *
     * @param shoteiShikkanShisetsuRyoyohiKaishiYMD3 shoteiShikkanShisetsuRyoyohiKaishiYMD3
     */
    public void setShoteiShikkanShisetsuRyoyohiKaishiYMD3(FlexibleDate shoteiShikkanShisetsuRyoyohiKaishiYMD3) {
        this.shoteiShikkanShisetsuRyoyohiKaishiYMD3 = shoteiShikkanShisetsuRyoyohiKaishiYMD3;
    }

    /**
     * getShoteiShikkanShisetsuRyoyohiTanisu
     *
     * @return shoteiShikkanShisetsuRyoyohiTanisu
     */
    public int getShoteiShikkanShisetsuRyoyohiTanisu() {
        return shoteiShikkanShisetsuRyoyohiTanisu;
    }

    /**
     * setShoteiShikkanShisetsuRyoyohiTanisu
     *
     * @param shoteiShikkanShisetsuRyoyohiTanisu shoteiShikkanShisetsuRyoyohiTanisu
     */
    public void setShoteiShikkanShisetsuRyoyohiTanisu(int shoteiShikkanShisetsuRyoyohiTanisu) {
        this.shoteiShikkanShisetsuRyoyohiTanisu = shoteiShikkanShisetsuRyoyohiTanisu;
    }

    /**
     * getShoteiShikkanShisetsuRyoyohiNissu
     *
     * @return shoteiShikkanShisetsuRyoyohiNissu
     */
    public int getShoteiShikkanShisetsuRyoyohiNissu() {
        return shoteiShikkanShisetsuRyoyohiNissu;
    }

    /**
     * setShoteiShikkanShisetsuRyoyohiNissu
     *
     * @param shoteiShikkanShisetsuRyoyohiNissu shoteiShikkanShisetsuRyoyohiNissu
     */
    public void setShoteiShikkanShisetsuRyoyohiNissu(int shoteiShikkanShisetsuRyoyohiNissu) {
        this.shoteiShikkanShisetsuRyoyohiNissu = shoteiShikkanShisetsuRyoyohiNissu;
    }

    /**
     * getShoteiShikkanShisetsuRyoyohiSubTotal
     *
     * @return shoteiShikkanShisetsuRyoyohiSubTotal
     */
    public int getShoteiShikkanShisetsuRyoyohiSubTotal() {
        return shoteiShikkanShisetsuRyoyohiSubTotal;
    }

    /**
     * setShoteiShikkanShisetsuRyoyohiSubTotal
     *
     * @param shoteiShikkanShisetsuRyoyohiSubTotal shoteiShikkanShisetsuRyoyohiSubTotal
     */
    public void setShoteiShikkanShisetsuRyoyohiSubTotal(int shoteiShikkanShisetsuRyoyohiSubTotal) {
        this.shoteiShikkanShisetsuRyoyohiSubTotal = shoteiShikkanShisetsuRyoyohiSubTotal;
    }

    /**
     * getAtoOshinNissu
     *
     * @return atoOshinNissu
     */
    public int getAtoOshinNissu() {
        return atoOshinNissu;
    }

    /**
     * setAtoOshinNissu
     *
     * @param atoOshinNissu atoOshinNissu
     */
    public void setAtoOshinNissu(int atoOshinNissu) {
        this.atoOshinNissu = atoOshinNissu;
    }

    /**
     * getAtoTsuinNissu
     *
     * @return atoTsuinNissu
     */
    public int getAtoTsuinNissu() {
        return atoTsuinNissu;
    }

    /**
     * setAtoTsuinNissu
     *
     * @param atoTsuinNissu atoTsuinNissu
     */
    public void setAtoTsuinNissu(int atoTsuinNissu) {
        this.atoTsuinNissu = atoTsuinNissu;
    }

    /**
     * getAtoKinkyuChiryoKanriTanisu
     *
     * @return atoKinkyuChiryoKanriTanisu
     */
    public int getAtoKinkyuChiryoKanriTanisu() {
        return atoKinkyuChiryoKanriTanisu;
    }

    /**
     * setAtoKinkyuChiryoKanriTanisu
     *
     * @param atoKinkyuChiryoKanriTanisu atoKinkyuChiryoKanriTanisu
     */
    public void setAtoKinkyuChiryoKanriTanisu(int atoKinkyuChiryoKanriTanisu) {
        this.atoKinkyuChiryoKanriTanisu = atoKinkyuChiryoKanriTanisu;
    }

    /**
     * getAtoKinkyuChiryoKanriNissu
     *
     * @return atoKinkyuChiryoKanriNissu
     */
    public int getAtoKinkyuChiryoKanriNissu() {
        return atoKinkyuChiryoKanriNissu;
    }

    /**
     * setAtoKinkyuChiryoKanriNissu
     *
     * @param atoKinkyuChiryoKanriNissu atoKinkyuChiryoKanriNissu
     */
    public void setAtoKinkyuChiryoKanriNissu(int atoKinkyuChiryoKanriNissu) {
        this.atoKinkyuChiryoKanriNissu = atoKinkyuChiryoKanriNissu;
    }

    /**
     * getAtoRehabilitationTensu
     *
     * @return atoRehabilitationTensu
     */
    public int getAtoRehabilitationTensu() {
        return atoRehabilitationTensu;
    }

    /**
     * setAtoRehabilitationTensu
     *
     * @param atoRehabilitationTensu atoRehabilitationTensu
     */
    public void setAtoRehabilitationTensu(int atoRehabilitationTensu) {
        this.atoRehabilitationTensu = atoRehabilitationTensu;
    }

    /**
     * getAtoShochiTensu
     *
     * @return atoShochiTensu
     */
    public int getAtoShochiTensu() {
        return atoShochiTensu;
    }

    /**
     * setAtoShochiTensu
     *
     * @param atoShochiTensu atoShochiTensu
     */
    public void setAtoShochiTensu(int atoShochiTensu) {
        this.atoShochiTensu = atoShochiTensu;
    }

    /**
     * getAtoShujutsuTensu
     *
     * @return atoShujutsuTensu
     */
    public int getAtoShujutsuTensu() {
        return atoShujutsuTensu;
    }

    /**
     * setAtoShujutsuTensu
     *
     * @param atoShujutsuTensu atoShujutsuTensu
     */
    public void setAtoShujutsuTensu(int atoShujutsuTensu) {
        this.atoShujutsuTensu = atoShujutsuTensu;
    }

    /**
     * getAtoMasuiTensu
     *
     * @return atoMasuiTensu
     */
    public int getAtoMasuiTensu() {
        return atoMasuiTensu;
    }

    /**
     * setAtoMasuiTensu
     *
     * @param atoMasuiTensu atoMasuiTensu
     */
    public void setAtoMasuiTensu(int atoMasuiTensu) {
        this.atoMasuiTensu = atoMasuiTensu;
    }

    /**
     * getAtoHoshasenChiryoTensu
     *
     * @return atoHoshasenChiryoTensu
     */
    public int getAtoHoshasenChiryoTensu() {
        return atoHoshasenChiryoTensu;
    }

    /**
     * setAtoHoshasenChiryoTensu
     *
     * @param atoHoshasenChiryoTensu atoHoshasenChiryoTensu
     */
    public void setAtoHoshasenChiryoTensu(int atoHoshasenChiryoTensu) {
        this.atoHoshasenChiryoTensu = atoHoshasenChiryoTensu;
    }

    /**
     * getAtoShoteiShikkanShisetsuRyoyoHiTanisu
     *
     * @return atoShoteiShikkanShisetsuRyoyoHiTanisu
     */
    public int getAtoShoteiShikkanShisetsuRyoyoHiTanisu() {
        return atoShoteiShikkanShisetsuRyoyoHiTanisu;
    }

    /**
     * setAtoShoteiShikkanShisetsuRyoyoHiTanisu
     *
     * @param atoShoteiShikkanShisetsuRyoyoHiTanisu atoShoteiShikkanShisetsuRyoyoHiTanisu
     */
    public void setAtoShoteiShikkanShisetsuRyoyoHiTanisu(int atoShoteiShikkanShisetsuRyoyoHiTanisu) {
        this.atoShoteiShikkanShisetsuRyoyoHiTanisu = atoShoteiShikkanShisetsuRyoyoHiTanisu;
    }

    /**
     * getAtoShoteiShikkanShisetsuRyoyoHiNissu
     *
     * @return atoShoteiShikkanShisetsuRyoyoHiNissu
     */
    public int getAtoShoteiShikkanShisetsuRyoyoHiNissu() {
        return atoShoteiShikkanShisetsuRyoyoHiNissu;
    }

    /**
     * setAtoShoteiShikkanShisetsuRyoyoHiNissu
     *
     * @param atoShoteiShikkanShisetsuRyoyoHiNissu atoShoteiShikkanShisetsuRyoyoHiNissu
     */
    public void setAtoShoteiShikkanShisetsuRyoyoHiNissu(int atoShoteiShikkanShisetsuRyoyoHiNissu) {
        this.atoShoteiShikkanShisetsuRyoyoHiNissu = atoShoteiShikkanShisetsuRyoyoHiNissu;
    }

    /**
     * getSaishinsaKaisu
     *
     * @return saishinsaKaisu
     */
    public int getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * setSaishinsaKaisu
     *
     * @param saishinsaKaisu saishinsaKaisu
     */
    public void setSaishinsaKaisu(int saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * getKagoKaisu
     *
     * @return kagoKaisu
     */
    public int getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * setKagoKaisu
     *
     * @param kagoKaisu kagoKaisu
     */
    public void setKagoKaisu(int kagoKaisu) {
        this.kagoKaisu = kagoKaisu;
    }

    /**
     * getShinsaYM
     *
     * @return shinsaYM
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * setShinsaYM
     *
     * @param shinsaYM shinsaYM
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * getSeiriNo
     *
     * @return seiriNo
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * setSeiriNo
     *
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * getTorikomiYM
     *
     * @return torikomiYM
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * setTorikomiYM
     *
     * @param torikomiYM torikomiYM
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kokanJohoShikibetsuNo, other.kokanJohoShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.inputShikibetsuNo, other.inputShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeShubetsuCode, other.recodeShubetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shokisaiHokenshaNo, other.shokisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshoNo, other.jigyoshoNo)) {
            return false;
        }
        if (!Objects.equals(this.toshiNo, other.toshiNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeJunjiNo, other.recodeJunjiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3032KyufujissekiShoteiShikkanShisetsuRyoyoEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.recodeJunjiNo = entity.recodeJunjiNo;
        this.kinkyuShobyoName1 = entity.kinkyuShobyoName1;
        this.kinkyuShobyoName2 = entity.kinkyuShobyoName2;
        this.kinkyuShobyoName3 = entity.kinkyuShobyoName3;
        this.kinkyuChiryoKaishiYMD1 = entity.kinkyuChiryoKaishiYMD1;
        this.kinkyuChiryoKaishiYMD2 = entity.kinkyuChiryoKaishiYMD2;
        this.kinkyuChiryoKaishiYMD3 = entity.kinkyuChiryoKaishiYMD3;
        this.oshinNissu = entity.oshinNissu;
        this.oshinIryoKikanName = entity.oshinIryoKikanName;
        this.tsuinNissu = entity.tsuinNissu;
        this.tsuinIryoKikanName = entity.tsuinIryoKikanName;
        this.kinkyuChiryoKanriTanisu = entity.kinkyuChiryoKanriTanisu;
        this.kinkyuChiryoKanriNissu = entity.kinkyuChiryoKanriNissu;
        this.kinkyuChiryoKanriSubTotal = entity.kinkyuChiryoKanriSubTotal;
        this.rehabilitationTensu = entity.rehabilitationTensu;
        this.shochiTensu = entity.shochiTensu;
        this.shujutsuTensu = entity.shujutsuTensu;
        this.masuiTensu = entity.masuiTensu;
        this.hoshasenChiryoTensu = entity.hoshasenChiryoTensu;
        this.tekiyo1 = entity.tekiyo1;
        this.tekiyo2 = entity.tekiyo2;
        this.tekiyo3 = entity.tekiyo3;
        this.tekiyo4 = entity.tekiyo4;
        this.tekiyo5 = entity.tekiyo5;
        this.tekiyo6 = entity.tekiyo6;
        this.tekiyo7 = entity.tekiyo7;
        this.tekiyo8 = entity.tekiyo8;
        this.tekiyo9 = entity.tekiyo9;
        this.tekiyo10 = entity.tekiyo10;
        this.tekiyo11 = entity.tekiyo11;
        this.tekiyo12 = entity.tekiyo12;
        this.tekiyo13 = entity.tekiyo13;
        this.tekiyo14 = entity.tekiyo14;
        this.tekiyo15 = entity.tekiyo15;
        this.tekiyo16 = entity.tekiyo16;
        this.tekiyo17 = entity.tekiyo17;
        this.tekiyo18 = entity.tekiyo18;
        this.tekiyo19 = entity.tekiyo19;
        this.tekiyo20 = entity.tekiyo20;
        this.kinkyuShisetsuRyoyohiTotalTensu = entity.kinkyuShisetsuRyoyohiTotalTensu;
        this.shoteiShikkanShisetsuRyoyohiShobyoName1 = entity.shoteiShikkanShisetsuRyoyohiShobyoName1;
        this.shoteiShikkanShisetsuRyoyohiShobyoName2 = entity.shoteiShikkanShisetsuRyoyohiShobyoName2;
        this.shoteiShikkanShisetsuRyoyohiShobyoName3 = entity.shoteiShikkanShisetsuRyoyohiShobyoName3;
        this.shoteiShikkanShisetsuRyoyohiKaishiYMD1 = entity.shoteiShikkanShisetsuRyoyohiKaishiYMD1;
        this.shoteiShikkanShisetsuRyoyohiKaishiYMD2 = entity.shoteiShikkanShisetsuRyoyohiKaishiYMD2;
        this.shoteiShikkanShisetsuRyoyohiKaishiYMD3 = entity.shoteiShikkanShisetsuRyoyohiKaishiYMD3;
        this.shoteiShikkanShisetsuRyoyohiTanisu = entity.shoteiShikkanShisetsuRyoyohiTanisu;
        this.shoteiShikkanShisetsuRyoyohiNissu = entity.shoteiShikkanShisetsuRyoyohiNissu;
        this.shoteiShikkanShisetsuRyoyohiSubTotal = entity.shoteiShikkanShisetsuRyoyohiSubTotal;
        this.atoOshinNissu = entity.atoOshinNissu;
        this.atoTsuinNissu = entity.atoTsuinNissu;
        this.atoKinkyuChiryoKanriTanisu = entity.atoKinkyuChiryoKanriTanisu;
        this.atoKinkyuChiryoKanriNissu = entity.atoKinkyuChiryoKanriNissu;
        this.atoRehabilitationTensu = entity.atoRehabilitationTensu;
        this.atoShochiTensu = entity.atoShochiTensu;
        this.atoShujutsuTensu = entity.atoShujutsuTensu;
        this.atoMasuiTensu = entity.atoMasuiTensu;
        this.atoHoshasenChiryoTensu = entity.atoHoshasenChiryoTensu;
        this.atoShoteiShikkanShisetsuRyoyoHiTanisu = entity.atoShoteiShikkanShisetsuRyoyoHiTanisu;
        this.atoShoteiShikkanShisetsuRyoyoHiNissu = entity.atoShoteiShikkanShisetsuRyoyoHiNissu;
        this.saishinsaKaisu = entity.saishinsaKaisu;
        this.kagoKaisu = entity.kagoKaisu;
        this.shinsaYM = entity.shinsaYM;
        this.seiriNo = entity.seiriNo;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, recodeJunjiNo, kinkyuShobyoName1, kinkyuShobyoName2, kinkyuShobyoName3, kinkyuChiryoKaishiYMD1, kinkyuChiryoKaishiYMD2, kinkyuChiryoKaishiYMD3, oshinNissu, oshinIryoKikanName, tsuinNissu, tsuinIryoKikanName, kinkyuChiryoKanriTanisu, kinkyuChiryoKanriNissu, kinkyuChiryoKanriSubTotal, rehabilitationTensu, shochiTensu, shujutsuTensu, masuiTensu, hoshasenChiryoTensu, tekiyo1, tekiyo2, tekiyo3, tekiyo4, tekiyo5, tekiyo6, tekiyo7, tekiyo8, tekiyo9, tekiyo10, tekiyo11, tekiyo12, tekiyo13, tekiyo14, tekiyo15, tekiyo16, tekiyo17, tekiyo18, tekiyo19, tekiyo20, kinkyuShisetsuRyoyohiTotalTensu, shoteiShikkanShisetsuRyoyohiShobyoName1, shoteiShikkanShisetsuRyoyohiShobyoName2, shoteiShikkanShisetsuRyoyohiShobyoName3, shoteiShikkanShisetsuRyoyohiKaishiYMD1, shoteiShikkanShisetsuRyoyohiKaishiYMD2, shoteiShikkanShisetsuRyoyohiKaishiYMD3, shoteiShikkanShisetsuRyoyohiTanisu, shoteiShikkanShisetsuRyoyohiNissu, shoteiShikkanShisetsuRyoyohiSubTotal, atoOshinNissu, atoTsuinNissu, atoKinkyuChiryoKanriTanisu, atoKinkyuChiryoKanriNissu, atoRehabilitationTensu, atoShochiTensu, atoShujutsuTensu, atoMasuiTensu, atoHoshasenChiryoTensu, atoShoteiShikkanShisetsuRyoyoHiTanisu, atoShoteiShikkanShisetsuRyoyoHiNissu, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
