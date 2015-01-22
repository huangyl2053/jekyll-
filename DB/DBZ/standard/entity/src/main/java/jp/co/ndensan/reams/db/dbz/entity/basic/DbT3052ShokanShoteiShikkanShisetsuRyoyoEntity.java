package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3052ShokanShoteiShikkanShisetsuRyoyoの項目定義クラスです
 *
 */
public class DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity extends DbTableEntityBase<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3052ShokanShoteiShikkanShisetsuRyoyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private RString yoshikiNo;
    @PrimaryKey
    private RString junjiNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString kinkyuShobyoName1;
    private RString kinkyuShobyoName2;
    private RString kinkyuShobyoName3;
    private FlexibleDate kinkyuChiryoKaishiYMD1;
    private FlexibleDate kinkyuChiryoKaishiYMD2;
    private FlexibleDate kinkyuChiryoKaishiYMD3;
    private int oshinNissu;
    private RString oshinIryoKikanName;
    private int tsuinNissu;
    private RString tsuinKikanName;
    private int kinkyuChiryoKanriTanisu;
    private int kinkyuChiryoKanriNissu;
    private int kinkyuChiryoKanriSubTotal;
    private int rehabilitationTanisu;
    private int shochiTanisu;
    private int shujutsuTanisu;
    private int masuiTanisu;
    private int hoshasenChiryoTanisu;
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
    private int kinkyuShisetsuRyoyohiTotalTanisu;
    private RString shoteiShikkanShobyoName1;
    private RString shoteiShikkanShobyoName2;
    private RString shoteiShikkanShobyoName3;
    private FlexibleDate shoteiShikkanShobyoKaishiYMD1;
    private FlexibleDate shoteiShikkanShobyoKaishiYMD2;
    private FlexibleDate shoteiShikkanShobyoKaishiYMD3;
    private int shoteiShikkanTanisu;
    private int shoteiShikkanNissu;
    private int shoteiShikkanSubTotal;

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
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getYoshikiNo
     *
     * @return yoshikiNo
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * setYoshikiNo
     *
     * @param yoshikiNo yoshikiNo
     */
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * getJunjiNo
     *
     * @return junjiNo
     */
    public RString getJunjiNo() {
        return junjiNo;
    }

    /**
     * setJunjiNo
     *
     * @param junjiNo junjiNo
     */
    public void setJunjiNo(RString junjiNo) {
        this.junjiNo = junjiNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
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
     * getTsuinKikanName
     *
     * @return tsuinKikanName
     */
    public RString getTsuinKikanName() {
        return tsuinKikanName;
    }

    /**
     * setTsuinKikanName
     *
     * @param tsuinKikanName tsuinKikanName
     */
    public void setTsuinKikanName(RString tsuinKikanName) {
        this.tsuinKikanName = tsuinKikanName;
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
     * getRehabilitationTanisu
     *
     * @return rehabilitationTanisu
     */
    public int getRehabilitationTanisu() {
        return rehabilitationTanisu;
    }

    /**
     * setRehabilitationTanisu
     *
     * @param rehabilitationTanisu rehabilitationTanisu
     */
    public void setRehabilitationTanisu(int rehabilitationTanisu) {
        this.rehabilitationTanisu = rehabilitationTanisu;
    }

    /**
     * getShochiTanisu
     *
     * @return shochiTanisu
     */
    public int getShochiTanisu() {
        return shochiTanisu;
    }

    /**
     * setShochiTanisu
     *
     * @param shochiTanisu shochiTanisu
     */
    public void setShochiTanisu(int shochiTanisu) {
        this.shochiTanisu = shochiTanisu;
    }

    /**
     * getShujutsuTanisu
     *
     * @return shujutsuTanisu
     */
    public int getShujutsuTanisu() {
        return shujutsuTanisu;
    }

    /**
     * setShujutsuTanisu
     *
     * @param shujutsuTanisu shujutsuTanisu
     */
    public void setShujutsuTanisu(int shujutsuTanisu) {
        this.shujutsuTanisu = shujutsuTanisu;
    }

    /**
     * getMasuiTanisu
     *
     * @return masuiTanisu
     */
    public int getMasuiTanisu() {
        return masuiTanisu;
    }

    /**
     * setMasuiTanisu
     *
     * @param masuiTanisu masuiTanisu
     */
    public void setMasuiTanisu(int masuiTanisu) {
        this.masuiTanisu = masuiTanisu;
    }

    /**
     * getHoshasenChiryoTanisu
     *
     * @return hoshasenChiryoTanisu
     */
    public int getHoshasenChiryoTanisu() {
        return hoshasenChiryoTanisu;
    }

    /**
     * setHoshasenChiryoTanisu
     *
     * @param hoshasenChiryoTanisu hoshasenChiryoTanisu
     */
    public void setHoshasenChiryoTanisu(int hoshasenChiryoTanisu) {
        this.hoshasenChiryoTanisu = hoshasenChiryoTanisu;
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
     * getKinkyuShisetsuRyoyohiTotalTanisu
     *
     * @return kinkyuShisetsuRyoyohiTotalTanisu
     */
    public int getKinkyuShisetsuRyoyohiTotalTanisu() {
        return kinkyuShisetsuRyoyohiTotalTanisu;
    }

    /**
     * setKinkyuShisetsuRyoyohiTotalTanisu
     *
     * @param kinkyuShisetsuRyoyohiTotalTanisu kinkyuShisetsuRyoyohiTotalTanisu
     */
    public void setKinkyuShisetsuRyoyohiTotalTanisu(int kinkyuShisetsuRyoyohiTotalTanisu) {
        this.kinkyuShisetsuRyoyohiTotalTanisu = kinkyuShisetsuRyoyohiTotalTanisu;
    }

    /**
     * getShoteiShikkanShobyoName1
     *
     * @return shoteiShikkanShobyoName1
     */
    public RString getShoteiShikkanShobyoName1() {
        return shoteiShikkanShobyoName1;
    }

    /**
     * setShoteiShikkanShobyoName1
     *
     * @param shoteiShikkanShobyoName1 shoteiShikkanShobyoName1
     */
    public void setShoteiShikkanShobyoName1(RString shoteiShikkanShobyoName1) {
        this.shoteiShikkanShobyoName1 = shoteiShikkanShobyoName1;
    }

    /**
     * getShoteiShikkanShobyoName2
     *
     * @return shoteiShikkanShobyoName2
     */
    public RString getShoteiShikkanShobyoName2() {
        return shoteiShikkanShobyoName2;
    }

    /**
     * setShoteiShikkanShobyoName2
     *
     * @param shoteiShikkanShobyoName2 shoteiShikkanShobyoName2
     */
    public void setShoteiShikkanShobyoName2(RString shoteiShikkanShobyoName2) {
        this.shoteiShikkanShobyoName2 = shoteiShikkanShobyoName2;
    }

    /**
     * getShoteiShikkanShobyoName3
     *
     * @return shoteiShikkanShobyoName3
     */
    public RString getShoteiShikkanShobyoName3() {
        return shoteiShikkanShobyoName3;
    }

    /**
     * setShoteiShikkanShobyoName3
     *
     * @param shoteiShikkanShobyoName3 shoteiShikkanShobyoName3
     */
    public void setShoteiShikkanShobyoName3(RString shoteiShikkanShobyoName3) {
        this.shoteiShikkanShobyoName3 = shoteiShikkanShobyoName3;
    }

    /**
     * getShoteiShikkanShobyoKaishiYMD1
     *
     * @return shoteiShikkanShobyoKaishiYMD1
     */
    public FlexibleDate getShoteiShikkanShobyoKaishiYMD1() {
        return shoteiShikkanShobyoKaishiYMD1;
    }

    /**
     * setShoteiShikkanShobyoKaishiYMD1
     *
     * @param shoteiShikkanShobyoKaishiYMD1 shoteiShikkanShobyoKaishiYMD1
     */
    public void setShoteiShikkanShobyoKaishiYMD1(FlexibleDate shoteiShikkanShobyoKaishiYMD1) {
        this.shoteiShikkanShobyoKaishiYMD1 = shoteiShikkanShobyoKaishiYMD1;
    }

    /**
     * getShoteiShikkanShobyoKaishiYMD2
     *
     * @return shoteiShikkanShobyoKaishiYMD2
     */
    public FlexibleDate getShoteiShikkanShobyoKaishiYMD2() {
        return shoteiShikkanShobyoKaishiYMD2;
    }

    /**
     * setShoteiShikkanShobyoKaishiYMD2
     *
     * @param shoteiShikkanShobyoKaishiYMD2 shoteiShikkanShobyoKaishiYMD2
     */
    public void setShoteiShikkanShobyoKaishiYMD2(FlexibleDate shoteiShikkanShobyoKaishiYMD2) {
        this.shoteiShikkanShobyoKaishiYMD2 = shoteiShikkanShobyoKaishiYMD2;
    }

    /**
     * getShoteiShikkanShobyoKaishiYMD3
     *
     * @return shoteiShikkanShobyoKaishiYMD3
     */
    public FlexibleDate getShoteiShikkanShobyoKaishiYMD3() {
        return shoteiShikkanShobyoKaishiYMD3;
    }

    /**
     * setShoteiShikkanShobyoKaishiYMD3
     *
     * @param shoteiShikkanShobyoKaishiYMD3 shoteiShikkanShobyoKaishiYMD3
     */
    public void setShoteiShikkanShobyoKaishiYMD3(FlexibleDate shoteiShikkanShobyoKaishiYMD3) {
        this.shoteiShikkanShobyoKaishiYMD3 = shoteiShikkanShobyoKaishiYMD3;
    }

    /**
     * getShoteiShikkanTanisu
     *
     * @return shoteiShikkanTanisu
     */
    public int getShoteiShikkanTanisu() {
        return shoteiShikkanTanisu;
    }

    /**
     * setShoteiShikkanTanisu
     *
     * @param shoteiShikkanTanisu shoteiShikkanTanisu
     */
    public void setShoteiShikkanTanisu(int shoteiShikkanTanisu) {
        this.shoteiShikkanTanisu = shoteiShikkanTanisu;
    }

    /**
     * getShoteiShikkanNissu
     *
     * @return shoteiShikkanNissu
     */
    public int getShoteiShikkanNissu() {
        return shoteiShikkanNissu;
    }

    /**
     * setShoteiShikkanNissu
     *
     * @param shoteiShikkanNissu shoteiShikkanNissu
     */
    public void setShoteiShikkanNissu(int shoteiShikkanNissu) {
        this.shoteiShikkanNissu = shoteiShikkanNissu;
    }

    /**
     * getShoteiShikkanSubTotal
     *
     * @return shoteiShikkanSubTotal
     */
    public int getShoteiShikkanSubTotal() {
        return shoteiShikkanSubTotal;
    }

    /**
     * setShoteiShikkanSubTotal
     *
     * @param shoteiShikkanSubTotal shoteiShikkanSubTotal
     */
    public void setShoteiShikkanSubTotal(int shoteiShikkanSubTotal) {
        this.shoteiShikkanSubTotal = shoteiShikkanSubTotal;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yoshikiNo, other.yoshikiNo)) {
            return false;
        }
        if (!Objects.equals(this.junjiNo, other.junjiNo)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.junjiNo = entity.junjiNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kinkyuShobyoName1 = entity.kinkyuShobyoName1;
        this.kinkyuShobyoName2 = entity.kinkyuShobyoName2;
        this.kinkyuShobyoName3 = entity.kinkyuShobyoName3;
        this.kinkyuChiryoKaishiYMD1 = entity.kinkyuChiryoKaishiYMD1;
        this.kinkyuChiryoKaishiYMD2 = entity.kinkyuChiryoKaishiYMD2;
        this.kinkyuChiryoKaishiYMD3 = entity.kinkyuChiryoKaishiYMD3;
        this.oshinNissu = entity.oshinNissu;
        this.oshinIryoKikanName = entity.oshinIryoKikanName;
        this.tsuinNissu = entity.tsuinNissu;
        this.tsuinKikanName = entity.tsuinKikanName;
        this.kinkyuChiryoKanriTanisu = entity.kinkyuChiryoKanriTanisu;
        this.kinkyuChiryoKanriNissu = entity.kinkyuChiryoKanriNissu;
        this.kinkyuChiryoKanriSubTotal = entity.kinkyuChiryoKanriSubTotal;
        this.rehabilitationTanisu = entity.rehabilitationTanisu;
        this.shochiTanisu = entity.shochiTanisu;
        this.shujutsuTanisu = entity.shujutsuTanisu;
        this.masuiTanisu = entity.masuiTanisu;
        this.hoshasenChiryoTanisu = entity.hoshasenChiryoTanisu;
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
        this.kinkyuShisetsuRyoyohiTotalTanisu = entity.kinkyuShisetsuRyoyohiTotalTanisu;
        this.shoteiShikkanShobyoName1 = entity.shoteiShikkanShobyoName1;
        this.shoteiShikkanShobyoName2 = entity.shoteiShikkanShobyoName2;
        this.shoteiShikkanShobyoName3 = entity.shoteiShikkanShobyoName3;
        this.shoteiShikkanShobyoKaishiYMD1 = entity.shoteiShikkanShobyoKaishiYMD1;
        this.shoteiShikkanShobyoKaishiYMD2 = entity.shoteiShikkanShobyoKaishiYMD2;
        this.shoteiShikkanShobyoKaishiYMD3 = entity.shoteiShikkanShobyoKaishiYMD3;
        this.shoteiShikkanTanisu = entity.shoteiShikkanTanisu;
        this.shoteiShikkanNissu = entity.shoteiShikkanNissu;
        this.shoteiShikkanSubTotal = entity.shoteiShikkanSubTotal;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, junjiNo, shoriTimestamp, kinkyuShobyoName1, kinkyuShobyoName2, kinkyuShobyoName3, kinkyuChiryoKaishiYMD1, kinkyuChiryoKaishiYMD2, kinkyuChiryoKaishiYMD3, oshinNissu, oshinIryoKikanName, tsuinNissu, tsuinKikanName, kinkyuChiryoKanriTanisu, kinkyuChiryoKanriNissu, kinkyuChiryoKanriSubTotal, rehabilitationTanisu, shochiTanisu, shujutsuTanisu, masuiTanisu, hoshasenChiryoTanisu, tekiyo1, tekiyo2, tekiyo3, tekiyo4, tekiyo5, tekiyo6, tekiyo7, tekiyo8, tekiyo9, tekiyo10, tekiyo11, tekiyo12, tekiyo13, tekiyo14, tekiyo15, tekiyo16, tekiyo17, tekiyo18, tekiyo19, tekiyo20, kinkyuShisetsuRyoyohiTotalTanisu, shoteiShikkanShobyoName1, shoteiShikkanShobyoName2, shoteiShikkanShobyoName3, shoteiShikkanShobyoKaishiYMD1, shoteiShikkanShobyoKaishiYMD2, shoteiShikkanShobyoKaishiYMD3, shoteiShikkanTanisu, shoteiShikkanNissu, shoteiShikkanSubTotal);
    }

// </editor-fold>
}
