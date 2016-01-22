package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 償還払請求所定疾患施設療養費等テーブルのエンティティクラスです。
 */
public class DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity extends DbTableEntityBase<DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private RString meisaiNo;
    @PrimaryKey
    private RString renban;
    private RString kinkyuShobyoName1;
    private RString kinkyuShobyoName2;
    private RString kinkyuShobyoName3;
    private FlexibleDate kinkyuChiryoKaishiYMD1;
    private FlexibleDate kinkyuChiryoKaishiYMD2;
    private FlexibleDate kinkyuChiryoKaishiYMD3;
    private Decimal oshinNissu;
    private RString oshinIryoKikanName;
    private Decimal tsuinNissu;
    private RString tsuinKikanName;
    private int kinkyuChiryoKanriTanisu;
    private Decimal kinkyuChiryoKanriNissu;
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
    private Decimal shoteiShikkanNissu;
    private int shoteiShikkanSubTotal;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hiHokenshaNo 被保険者番号
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * サービス提供年月のsetメソッドです。
     *
     * @param serviceTeikyoYM サービス提供年月
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * 整理番号のsetメソッドです。
     *
     * @param seiriNo 整理番号
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * 事業者番号のgetメソッドです。
     *
     * @return 事業者番号
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     *
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 様式番号のgetメソッドです。
     *
     * @return 様式番号
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * 様式番号のsetメソッドです。
     *
     * @param yoshikiNo 様式番号
     */
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * 明細番号のgetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @return 明細番号
     */
    public RString getMeisaiNo() {
        return meisaiNo;
    }

    /**
     * 明細番号のsetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @param meisaiNo 明細番号
     */
    public void setMeisaiNo(RString meisaiNo) {
        this.meisaiNo = meisaiNo;
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public RString getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     *
     * @param renban 連番
     */
    public void setRenban(RString renban) {
        this.renban = renban;
    }

    /**
     * 緊急時傷病名１のgetメソッドです。
     *
     * @return 緊急時傷病名１
     */
    public RString getKinkyuShobyoName1() {
        return kinkyuShobyoName1;
    }

    /**
     * 緊急時傷病名１のsetメソッドです。
     *
     * @param kinkyuShobyoName1 緊急時傷病名１
     */
    public void setKinkyuShobyoName1(RString kinkyuShobyoName1) {
        this.kinkyuShobyoName1 = kinkyuShobyoName1;
    }

    /**
     * 緊急時傷病名２のgetメソッドです。
     *
     * @return 緊急時傷病名２
     */
    public RString getKinkyuShobyoName2() {
        return kinkyuShobyoName2;
    }

    /**
     * 緊急時傷病名２のsetメソッドです。
     *
     * @param kinkyuShobyoName2 緊急時傷病名２
     */
    public void setKinkyuShobyoName2(RString kinkyuShobyoName2) {
        this.kinkyuShobyoName2 = kinkyuShobyoName2;
    }

    /**
     * 緊急時傷病名３のgetメソッドです。
     *
     * @return 緊急時傷病名３
     */
    public RString getKinkyuShobyoName3() {
        return kinkyuShobyoName3;
    }

    /**
     * 緊急時傷病名３のsetメソッドです。
     *
     * @param kinkyuShobyoName3 緊急時傷病名３
     */
    public void setKinkyuShobyoName3(RString kinkyuShobyoName3) {
        this.kinkyuShobyoName3 = kinkyuShobyoName3;
    }

    /**
     * 緊急時治療開始年月日１のgetメソッドです。
     *
     * @return 緊急時治療開始年月日１
     */
    public FlexibleDate getKinkyuChiryoKaishiYMD1() {
        return kinkyuChiryoKaishiYMD1;
    }

    /**
     * 緊急時治療開始年月日１のsetメソッドです。
     *
     * @param kinkyuChiryoKaishiYMD1 緊急時治療開始年月日１
     */
    public void setKinkyuChiryoKaishiYMD1(FlexibleDate kinkyuChiryoKaishiYMD1) {
        this.kinkyuChiryoKaishiYMD1 = kinkyuChiryoKaishiYMD1;
    }

    /**
     * 緊急時治療開始年月日２のgetメソッドです。
     *
     * @return 緊急時治療開始年月日２
     */
    public FlexibleDate getKinkyuChiryoKaishiYMD2() {
        return kinkyuChiryoKaishiYMD2;
    }

    /**
     * 緊急時治療開始年月日２のsetメソッドです。
     *
     * @param kinkyuChiryoKaishiYMD2 緊急時治療開始年月日２
     */
    public void setKinkyuChiryoKaishiYMD2(FlexibleDate kinkyuChiryoKaishiYMD2) {
        this.kinkyuChiryoKaishiYMD2 = kinkyuChiryoKaishiYMD2;
    }

    /**
     * 緊急時治療開始年月日３のgetメソッドです。
     *
     * @return 緊急時治療開始年月日３
     */
    public FlexibleDate getKinkyuChiryoKaishiYMD3() {
        return kinkyuChiryoKaishiYMD3;
    }

    /**
     * 緊急時治療開始年月日３のsetメソッドです。
     *
     * @param kinkyuChiryoKaishiYMD3 緊急時治療開始年月日３
     */
    public void setKinkyuChiryoKaishiYMD3(FlexibleDate kinkyuChiryoKaishiYMD3) {
        this.kinkyuChiryoKaishiYMD3 = kinkyuChiryoKaishiYMD3;
    }

    /**
     * 往診日数のgetメソッドです。
     *
     * @return 往診日数
     */
    public Decimal getOshinNissu() {
        return oshinNissu;
    }

    /**
     * 往診日数のsetメソッドです。
     *
     * @param oshinNissu 往診日数
     */
    public void setOshinNissu(Decimal oshinNissu) {
        this.oshinNissu = oshinNissu;
    }

    /**
     * 往診医療機関名のgetメソッドです。
     *
     * @return 往診医療機関名
     */
    public RString getOshinIryoKikanName() {
        return oshinIryoKikanName;
    }

    /**
     * 往診医療機関名のsetメソッドです。
     *
     * @param oshinIryoKikanName 往診医療機関名
     */
    public void setOshinIryoKikanName(RString oshinIryoKikanName) {
        this.oshinIryoKikanName = oshinIryoKikanName;
    }

    /**
     * 通院日数のgetメソッドです。
     *
     * @return 通院日数
     */
    public Decimal getTsuinNissu() {
        return tsuinNissu;
    }

    /**
     * 通院日数のsetメソッドです。
     *
     * @param tsuinNissu 通院日数
     */
    public void setTsuinNissu(Decimal tsuinNissu) {
        this.tsuinNissu = tsuinNissu;
    }

    /**
     * 通院医療機関名のgetメソッドです。
     *
     * @return 通院医療機関名
     */
    public RString getTsuinKikanName() {
        return tsuinKikanName;
    }

    /**
     * 通院医療機関名のsetメソッドです。
     *
     * @param tsuinKikanName 通院医療機関名
     */
    public void setTsuinKikanName(RString tsuinKikanName) {
        this.tsuinKikanName = tsuinKikanName;
    }

    /**
     * 緊急時治療管理単位数のgetメソッドです。
     *
     * @return 緊急時治療管理単位数
     */
    public int getKinkyuChiryoKanriTanisu() {
        return kinkyuChiryoKanriTanisu;
    }

    /**
     * 緊急時治療管理単位数のsetメソッドです。
     *
     * @param kinkyuChiryoKanriTanisu 緊急時治療管理単位数
     */
    public void setKinkyuChiryoKanriTanisu(int kinkyuChiryoKanriTanisu) {
        this.kinkyuChiryoKanriTanisu = kinkyuChiryoKanriTanisu;
    }

    /**
     * 緊急時治療管理日数のgetメソッドです。
     *
     * @return 緊急時治療管理日数
     */
    public Decimal getKinkyuChiryoKanriNissu() {
        return kinkyuChiryoKanriNissu;
    }

    /**
     * 緊急時治療管理日数のsetメソッドです。
     *
     * @param kinkyuChiryoKanriNissu 緊急時治療管理日数
     */
    public void setKinkyuChiryoKanriNissu(Decimal kinkyuChiryoKanriNissu) {
        this.kinkyuChiryoKanriNissu = kinkyuChiryoKanriNissu;
    }

    /**
     * 緊急時治療管理小計のgetメソッドです。
     *
     * @return 緊急時治療管理小計
     */
    public int getKinkyuChiryoKanriSubTotal() {
        return kinkyuChiryoKanriSubTotal;
    }

    /**
     * 緊急時治療管理小計のsetメソッドです。
     *
     * @param kinkyuChiryoKanriSubTotal 緊急時治療管理小計
     */
    public void setKinkyuChiryoKanriSubTotal(int kinkyuChiryoKanriSubTotal) {
        this.kinkyuChiryoKanriSubTotal = kinkyuChiryoKanriSubTotal;
    }

    /**
     * リハビリテーション単位数のgetメソッドです。
     *
     * @return リハビリテーション単位数
     */
    public int getRehabilitationTanisu() {
        return rehabilitationTanisu;
    }

    /**
     * リハビリテーション単位数のsetメソッドです。
     *
     * @param rehabilitationTanisu リハビリテーション単位数
     */
    public void setRehabilitationTanisu(int rehabilitationTanisu) {
        this.rehabilitationTanisu = rehabilitationTanisu;
    }

    /**
     * 処置単位数のgetメソッドです。
     *
     * @return 処置単位数
     */
    public int getShochiTanisu() {
        return shochiTanisu;
    }

    /**
     * 処置単位数のsetメソッドです。
     *
     * @param shochiTanisu 処置単位数
     */
    public void setShochiTanisu(int shochiTanisu) {
        this.shochiTanisu = shochiTanisu;
    }

    /**
     * 手術単位数のgetメソッドです。
     *
     * @return 手術単位数
     */
    public int getShujutsuTanisu() {
        return shujutsuTanisu;
    }

    /**
     * 手術単位数のsetメソッドです。
     *
     * @param shujutsuTanisu 手術単位数
     */
    public void setShujutsuTanisu(int shujutsuTanisu) {
        this.shujutsuTanisu = shujutsuTanisu;
    }

    /**
     * 麻酔単位数のgetメソッドです。
     *
     * @return 麻酔単位数
     */
    public int getMasuiTanisu() {
        return masuiTanisu;
    }

    /**
     * 麻酔単位数のsetメソッドです。
     *
     * @param masuiTanisu 麻酔単位数
     */
    public void setMasuiTanisu(int masuiTanisu) {
        this.masuiTanisu = masuiTanisu;
    }

    /**
     * 放射線治療単位数のgetメソッドです。
     *
     * @return 放射線治療単位数
     */
    public int getHoshasenChiryoTanisu() {
        return hoshasenChiryoTanisu;
    }

    /**
     * 放射線治療単位数のsetメソッドです。
     *
     * @param hoshasenChiryoTanisu 放射線治療単位数
     */
    public void setHoshasenChiryoTanisu(int hoshasenChiryoTanisu) {
        this.hoshasenChiryoTanisu = hoshasenChiryoTanisu;
    }

    /**
     * 摘要１のgetメソッドです。
     *
     * @return 摘要１
     */
    public RString getTekiyo1() {
        return tekiyo1;
    }

    /**
     * 摘要１のsetメソッドです。
     *
     * @param tekiyo1 摘要１
     */
    public void setTekiyo1(RString tekiyo1) {
        this.tekiyo1 = tekiyo1;
    }

    /**
     * 摘要２のgetメソッドです。
     *
     * @return 摘要２
     */
    public RString getTekiyo2() {
        return tekiyo2;
    }

    /**
     * 摘要２のsetメソッドです。
     *
     * @param tekiyo2 摘要２
     */
    public void setTekiyo2(RString tekiyo2) {
        this.tekiyo2 = tekiyo2;
    }

    /**
     * 摘要３のgetメソッドです。
     *
     * @return 摘要３
     */
    public RString getTekiyo3() {
        return tekiyo3;
    }

    /**
     * 摘要３のsetメソッドです。
     *
     * @param tekiyo3 摘要３
     */
    public void setTekiyo3(RString tekiyo3) {
        this.tekiyo3 = tekiyo3;
    }

    /**
     * 摘要４のgetメソッドです。
     *
     * @return 摘要４
     */
    public RString getTekiyo4() {
        return tekiyo4;
    }

    /**
     * 摘要４のsetメソッドです。
     *
     * @param tekiyo4 摘要４
     */
    public void setTekiyo4(RString tekiyo4) {
        this.tekiyo4 = tekiyo4;
    }

    /**
     * 摘要５のgetメソッドです。
     *
     * @return 摘要５
     */
    public RString getTekiyo5() {
        return tekiyo5;
    }

    /**
     * 摘要５のsetメソッドです。
     *
     * @param tekiyo5 摘要５
     */
    public void setTekiyo5(RString tekiyo5) {
        this.tekiyo5 = tekiyo5;
    }

    /**
     * 摘要６のgetメソッドです。
     *
     * @return 摘要６
     */
    public RString getTekiyo6() {
        return tekiyo6;
    }

    /**
     * 摘要６のsetメソッドです。
     *
     * @param tekiyo6 摘要６
     */
    public void setTekiyo6(RString tekiyo6) {
        this.tekiyo6 = tekiyo6;
    }

    /**
     * 摘要７のgetメソッドです。
     *
     * @return 摘要７
     */
    public RString getTekiyo7() {
        return tekiyo7;
    }

    /**
     * 摘要７のsetメソッドです。
     *
     * @param tekiyo7 摘要７
     */
    public void setTekiyo7(RString tekiyo7) {
        this.tekiyo7 = tekiyo7;
    }

    /**
     * 摘要８のgetメソッドです。
     *
     * @return 摘要８
     */
    public RString getTekiyo8() {
        return tekiyo8;
    }

    /**
     * 摘要８のsetメソッドです。
     *
     * @param tekiyo8 摘要８
     */
    public void setTekiyo8(RString tekiyo8) {
        this.tekiyo8 = tekiyo8;
    }

    /**
     * 摘要９のgetメソッドです。
     *
     * @return 摘要９
     */
    public RString getTekiyo9() {
        return tekiyo9;
    }

    /**
     * 摘要９のsetメソッドです。
     *
     * @param tekiyo9 摘要９
     */
    public void setTekiyo9(RString tekiyo9) {
        this.tekiyo9 = tekiyo9;
    }

    /**
     * 摘要１０のgetメソッドです。
     *
     * @return 摘要１０
     */
    public RString getTekiyo10() {
        return tekiyo10;
    }

    /**
     * 摘要１０のsetメソッドです。
     *
     * @param tekiyo10 摘要１０
     */
    public void setTekiyo10(RString tekiyo10) {
        this.tekiyo10 = tekiyo10;
    }

    /**
     * 摘要１１のgetメソッドです。
     *
     * @return 摘要１１
     */
    public RString getTekiyo11() {
        return tekiyo11;
    }

    /**
     * 摘要１１のsetメソッドです。
     *
     * @param tekiyo11 摘要１１
     */
    public void setTekiyo11(RString tekiyo11) {
        this.tekiyo11 = tekiyo11;
    }

    /**
     * 摘要１２のgetメソッドです。
     *
     * @return 摘要１２
     */
    public RString getTekiyo12() {
        return tekiyo12;
    }

    /**
     * 摘要１２のsetメソッドです。
     *
     * @param tekiyo12 摘要１２
     */
    public void setTekiyo12(RString tekiyo12) {
        this.tekiyo12 = tekiyo12;
    }

    /**
     * 摘要１３のgetメソッドです。
     *
     * @return 摘要１３
     */
    public RString getTekiyo13() {
        return tekiyo13;
    }

    /**
     * 摘要１３のsetメソッドです。
     *
     * @param tekiyo13 摘要１３
     */
    public void setTekiyo13(RString tekiyo13) {
        this.tekiyo13 = tekiyo13;
    }

    /**
     * 摘要１４のgetメソッドです。
     *
     * @return 摘要１４
     */
    public RString getTekiyo14() {
        return tekiyo14;
    }

    /**
     * 摘要１４のsetメソッドです。
     *
     * @param tekiyo14 摘要１４
     */
    public void setTekiyo14(RString tekiyo14) {
        this.tekiyo14 = tekiyo14;
    }

    /**
     * 摘要１５のgetメソッドです。
     *
     * @return 摘要１５
     */
    public RString getTekiyo15() {
        return tekiyo15;
    }

    /**
     * 摘要１５のsetメソッドです。
     *
     * @param tekiyo15 摘要１５
     */
    public void setTekiyo15(RString tekiyo15) {
        this.tekiyo15 = tekiyo15;
    }

    /**
     * 摘要１６のgetメソッドです。
     *
     * @return 摘要１６
     */
    public RString getTekiyo16() {
        return tekiyo16;
    }

    /**
     * 摘要１６のsetメソッドです。
     *
     * @param tekiyo16 摘要１６
     */
    public void setTekiyo16(RString tekiyo16) {
        this.tekiyo16 = tekiyo16;
    }

    /**
     * 摘要１７のgetメソッドです。
     *
     * @return 摘要１７
     */
    public RString getTekiyo17() {
        return tekiyo17;
    }

    /**
     * 摘要１７のsetメソッドです。
     *
     * @param tekiyo17 摘要１７
     */
    public void setTekiyo17(RString tekiyo17) {
        this.tekiyo17 = tekiyo17;
    }

    /**
     * 摘要１８のgetメソッドです。
     *
     * @return 摘要１８
     */
    public RString getTekiyo18() {
        return tekiyo18;
    }

    /**
     * 摘要１８のsetメソッドです。
     *
     * @param tekiyo18 摘要１８
     */
    public void setTekiyo18(RString tekiyo18) {
        this.tekiyo18 = tekiyo18;
    }

    /**
     * 摘要１９のgetメソッドです。
     *
     * @return 摘要１９
     */
    public RString getTekiyo19() {
        return tekiyo19;
    }

    /**
     * 摘要１９のsetメソッドです。
     *
     * @param tekiyo19 摘要１９
     */
    public void setTekiyo19(RString tekiyo19) {
        this.tekiyo19 = tekiyo19;
    }

    /**
     * 摘要２０のgetメソッドです。
     *
     * @return 摘要２０
     */
    public RString getTekiyo20() {
        return tekiyo20;
    }

    /**
     * 摘要２０のsetメソッドです。
     *
     * @param tekiyo20 摘要２０
     */
    public void setTekiyo20(RString tekiyo20) {
        this.tekiyo20 = tekiyo20;
    }

    /**
     * 緊急時施設療養費合計単位数のgetメソッドです。
     *
     * @return 緊急時施設療養費合計単位数
     */
    public int getKinkyuShisetsuRyoyohiTotalTanisu() {
        return kinkyuShisetsuRyoyohiTotalTanisu;
    }

    /**
     * 緊急時施設療養費合計単位数のsetメソッドです。
     *
     * @param kinkyuShisetsuRyoyohiTotalTanisu 緊急時施設療養費合計単位数
     */
    public void setKinkyuShisetsuRyoyohiTotalTanisu(int kinkyuShisetsuRyoyohiTotalTanisu) {
        this.kinkyuShisetsuRyoyohiTotalTanisu = kinkyuShisetsuRyoyohiTotalTanisu;
    }

    /**
     * 所定疾患施設療養費傷病名１のgetメソッドです。
     *
     * @return 所定疾患施設療養費傷病名１
     */
    public RString getShoteiShikkanShobyoName1() {
        return shoteiShikkanShobyoName1;
    }

    /**
     * 所定疾患施設療養費傷病名１のsetメソッドです。
     *
     * @param shoteiShikkanShobyoName1 所定疾患施設療養費傷病名１
     */
    public void setShoteiShikkanShobyoName1(RString shoteiShikkanShobyoName1) {
        this.shoteiShikkanShobyoName1 = shoteiShikkanShobyoName1;
    }

    /**
     * 所定疾患施設療養費傷病名２のgetメソッドです。
     *
     * @return 所定疾患施設療養費傷病名２
     */
    public RString getShoteiShikkanShobyoName2() {
        return shoteiShikkanShobyoName2;
    }

    /**
     * 所定疾患施設療養費傷病名２のsetメソッドです。
     *
     * @param shoteiShikkanShobyoName2 所定疾患施設療養費傷病名２
     */
    public void setShoteiShikkanShobyoName2(RString shoteiShikkanShobyoName2) {
        this.shoteiShikkanShobyoName2 = shoteiShikkanShobyoName2;
    }

    /**
     * 所定疾患施設療養費傷病名３のgetメソッドです。
     *
     * @return 所定疾患施設療養費傷病名３
     */
    public RString getShoteiShikkanShobyoName3() {
        return shoteiShikkanShobyoName3;
    }

    /**
     * 所定疾患施設療養費傷病名３のsetメソッドです。
     *
     * @param shoteiShikkanShobyoName3 所定疾患施設療養費傷病名３
     */
    public void setShoteiShikkanShobyoName3(RString shoteiShikkanShobyoName3) {
        this.shoteiShikkanShobyoName3 = shoteiShikkanShobyoName3;
    }

    /**
     * 所定疾患施設療養費開始年月日１のgetメソッドです。
     *
     * @return 所定疾患施設療養費開始年月日１
     */
    public FlexibleDate getShoteiShikkanShobyoKaishiYMD1() {
        return shoteiShikkanShobyoKaishiYMD1;
    }

    /**
     * 所定疾患施設療養費開始年月日１のsetメソッドです。
     *
     * @param shoteiShikkanShobyoKaishiYMD1 所定疾患施設療養費開始年月日１
     */
    public void setShoteiShikkanShobyoKaishiYMD1(FlexibleDate shoteiShikkanShobyoKaishiYMD1) {
        this.shoteiShikkanShobyoKaishiYMD1 = shoteiShikkanShobyoKaishiYMD1;
    }

    /**
     * 所定疾患施設療養費開始年月日２のgetメソッドです。
     *
     * @return 所定疾患施設療養費開始年月日２
     */
    public FlexibleDate getShoteiShikkanShobyoKaishiYMD2() {
        return shoteiShikkanShobyoKaishiYMD2;
    }

    /**
     * 所定疾患施設療養費開始年月日２のsetメソッドです。
     *
     * @param shoteiShikkanShobyoKaishiYMD2 所定疾患施設療養費開始年月日２
     */
    public void setShoteiShikkanShobyoKaishiYMD2(FlexibleDate shoteiShikkanShobyoKaishiYMD2) {
        this.shoteiShikkanShobyoKaishiYMD2 = shoteiShikkanShobyoKaishiYMD2;
    }

    /**
     * 所定疾患施設療養費開始年月日３のgetメソッドです。
     *
     * @return 所定疾患施設療養費開始年月日３
     */
    public FlexibleDate getShoteiShikkanShobyoKaishiYMD3() {
        return shoteiShikkanShobyoKaishiYMD3;
    }

    /**
     * 所定疾患施設療養費開始年月日３のsetメソッドです。
     *
     * @param shoteiShikkanShobyoKaishiYMD3 所定疾患施設療養費開始年月日３
     */
    public void setShoteiShikkanShobyoKaishiYMD3(FlexibleDate shoteiShikkanShobyoKaishiYMD3) {
        this.shoteiShikkanShobyoKaishiYMD3 = shoteiShikkanShobyoKaishiYMD3;
    }

    /**
     * 所定疾患施設療養費単位数のgetメソッドです。
     *
     * @return 所定疾患施設療養費単位数
     */
    public int getShoteiShikkanTanisu() {
        return shoteiShikkanTanisu;
    }

    /**
     * 所定疾患施設療養費単位数のsetメソッドです。
     *
     * @param shoteiShikkanTanisu 所定疾患施設療養費単位数
     */
    public void setShoteiShikkanTanisu(int shoteiShikkanTanisu) {
        this.shoteiShikkanTanisu = shoteiShikkanTanisu;
    }

    /**
     * 所定疾患施設療養費日数のgetメソッドです。
     *
     * @return 所定疾患施設療養費日数
     */
    public Decimal getShoteiShikkanNissu() {
        return shoteiShikkanNissu;
    }

    /**
     * 所定疾患施設療養費日数のsetメソッドです。
     *
     * @param shoteiShikkanNissu 所定疾患施設療養費日数
     */
    public void setShoteiShikkanNissu(Decimal shoteiShikkanNissu) {
        this.shoteiShikkanNissu = shoteiShikkanNissu;
    }

    /**
     * 所定疾患施設療養費小計のgetメソッドです。
     *
     * @return 所定疾患施設療養費小計
     */
    public int getShoteiShikkanSubTotal() {
        return shoteiShikkanSubTotal;
    }

    /**
     * 所定疾患施設療養費小計のsetメソッドです。
     *
     * @param shoteiShikkanSubTotal 所定疾患施設療養費小計
     */
    public void setShoteiShikkanSubTotal(int shoteiShikkanSubTotal) {
        this.shoteiShikkanSubTotal = shoteiShikkanSubTotal;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3052ShokanShoteiShikkanShisetsuRyoyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (!Objects.equals(this.meisaiNo, other.meisaiNo)) {
            return false;
        }
        if (this.renban != other.renban) {
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
        this.meisaiNo = entity.meisaiNo;
        this.renban = entity.renban;
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
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, meisaiNo, renban, kinkyuShobyoName1, kinkyuShobyoName2, kinkyuShobyoName3, kinkyuChiryoKaishiYMD1, kinkyuChiryoKaishiYMD2, kinkyuChiryoKaishiYMD3, oshinNissu, oshinIryoKikanName, tsuinNissu, tsuinKikanName, kinkyuChiryoKanriTanisu, kinkyuChiryoKanriNissu, kinkyuChiryoKanriSubTotal, rehabilitationTanisu, shochiTanisu, shujutsuTanisu, masuiTanisu, hoshasenChiryoTanisu, tekiyo1, tekiyo2, tekiyo3, tekiyo4, tekiyo5, tekiyo6, tekiyo7, tekiyo8, tekiyo9, tekiyo10, tekiyo11, tekiyo12, tekiyo13, tekiyo14, tekiyo15, tekiyo16, tekiyo17, tekiyo18, tekiyo19, tekiyo20, kinkyuShisetsuRyoyohiTotalTanisu, shoteiShikkanShobyoName1, shoteiShikkanShobyoName2, shoteiShikkanShobyoName3, shoteiShikkanShobyoKaishiYMD1, shoteiShikkanShobyoKaishiYMD2, shoteiShikkanShobyoKaishiYMD3, shoteiShikkanTanisu, shoteiShikkanNissu, shoteiShikkanSubTotal);
    }

// </editor-fold>
}
