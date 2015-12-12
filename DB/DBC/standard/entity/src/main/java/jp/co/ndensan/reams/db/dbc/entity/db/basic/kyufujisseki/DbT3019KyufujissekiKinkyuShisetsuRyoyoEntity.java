package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付実績緊急時施設療養テーブルのエンティティクラスです。
 */
public class DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity extends DbTableEntityBase<DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3019KyufujissekiKinkyuShisetsuRyoyo");

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
    private Decimal oshinNissu;
    private RString oshinIryoKikanName;
    private Decimal tsuinNissu;
    private RString tsuinIryoKikanName;
    private int kinkyuChiryoKanriTanisu;
    private Decimal kinkyuChiryoKanriNissu;
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
    private int kinkyuShisetsuRyoyoHiTotalTensu;
    private Decimal atoOshinNissu;
    private Decimal atoTsuinNissu;
    private int atoKinkyuChiryoKanriTanisu;
    private Decimal atoKinkyuChiryoKanriNissu;
    private int atoRehabilitationTensu;
    private int atoShochiTensu;
    private int atoShujutsuTensu;
    private int atoMasuiTensu;
    private int atoHoshasenChiryoTensu;
    private Decimal saishinsaKaisu;
    private Decimal kagoKaisu;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
    private FlexibleYearMonth torikomiYM;

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
     * 交換情報識別番号のgetメソッドです。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * 交換情報識別番号のsetメソッドです。
     *
     * @param kokanJohoShikibetsuNo 交換情報識別番号
     */
    public void setKokanJohoShikibetsuNo(KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
    }

    /**
     * 入力識別番号のgetメソッドです。
     *
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * 入力識別番号のsetメソッドです。
     *
     * @param inputShikibetsuNo 入力識別番号
     */
    public void setInputShikibetsuNo(NyuryokuShikibetsuNo inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * レコード種別コードのgetメソッドです。
     *
     * @return レコード種別コード
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * レコード種別コードのsetメソッドです。
     *
     * @param recodeShubetsuCode レコード種別コード
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shokisaiHokenshaNo 証記載保険者番号
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
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
     * 事業所番号のgetメソッドです。
     *
     * @return 事業所番号
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * 事業所番号のsetメソッドです。
     *
     * @param jigyoshoNo 事業所番号
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * 通し番号のgetメソッドです。
     *
     * @return 通し番号
     */
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * 通し番号のsetメソッドです。
     *
     * @param toshiNo 通し番号
     */
    public void setToshiNo(RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * 緊急時施設療養情報レコード順次番号のgetメソッドです。
     *
     * @return 緊急時施設療養情報レコード順次番号
     */
    public RString getRecodeJunjiNo() {
        return recodeJunjiNo;
    }

    /**
     * 緊急時施設療養情報レコード順次番号のsetメソッドです。
     *
     * @param recodeJunjiNo 緊急時施設療養情報レコード順次番号
     */
    public void setRecodeJunjiNo(RString recodeJunjiNo) {
        this.recodeJunjiNo = recodeJunjiNo;
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
    public RString getTsuinIryoKikanName() {
        return tsuinIryoKikanName;
    }

    /**
     * 通院医療機関名のsetメソッドです。
     *
     * @param tsuinIryoKikanName 通院医療機関名
     */
    public void setTsuinIryoKikanName(RString tsuinIryoKikanName) {
        this.tsuinIryoKikanName = tsuinIryoKikanName;
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
     * リハビリテーション点数のgetメソッドです。
     *
     * @return リハビリテーション点数
     */
    public int getRehabilitationTensu() {
        return rehabilitationTensu;
    }

    /**
     * リハビリテーション点数のsetメソッドです。
     *
     * @param rehabilitationTensu リハビリテーション点数
     */
    public void setRehabilitationTensu(int rehabilitationTensu) {
        this.rehabilitationTensu = rehabilitationTensu;
    }

    /**
     * 処置点数のgetメソッドです。
     *
     * @return 処置点数
     */
    public int getShochiTensu() {
        return shochiTensu;
    }

    /**
     * 処置点数のsetメソッドです。
     *
     * @param shochiTensu 処置点数
     */
    public void setShochiTensu(int shochiTensu) {
        this.shochiTensu = shochiTensu;
    }

    /**
     * 手術点数のgetメソッドです。
     *
     * @return 手術点数
     */
    public int getShujutsuTensu() {
        return shujutsuTensu;
    }

    /**
     * 手術点数のsetメソッドです。
     *
     * @param shujutsuTensu 手術点数
     */
    public void setShujutsuTensu(int shujutsuTensu) {
        this.shujutsuTensu = shujutsuTensu;
    }

    /**
     * 麻酔点数のgetメソッドです。
     *
     * @return 麻酔点数
     */
    public int getMasuiTensu() {
        return masuiTensu;
    }

    /**
     * 麻酔点数のsetメソッドです。
     *
     * @param masuiTensu 麻酔点数
     */
    public void setMasuiTensu(int masuiTensu) {
        this.masuiTensu = masuiTensu;
    }

    /**
     * 放射線治療点数のgetメソッドです。
     *
     * @return 放射線治療点数
     */
    public int getHoshasenChiryoTensu() {
        return hoshasenChiryoTensu;
    }

    /**
     * 放射線治療点数のsetメソッドです。
     *
     * @param hoshasenChiryoTensu 放射線治療点数
     */
    public void setHoshasenChiryoTensu(int hoshasenChiryoTensu) {
        this.hoshasenChiryoTensu = hoshasenChiryoTensu;
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
     * 緊急時施設療養費合計点数のgetメソッドです。
     *
     * @return 緊急時施設療養費合計点数
     */
    public int getKinkyuShisetsuRyoyoHiTotalTensu() {
        return kinkyuShisetsuRyoyoHiTotalTensu;
    }

    /**
     * 緊急時施設療養費合計点数のsetメソッドです。
     *
     * @param kinkyuShisetsuRyoyoHiTotalTensu 緊急時施設療養費合計点数
     */
    public void setKinkyuShisetsuRyoyoHiTotalTensu(int kinkyuShisetsuRyoyoHiTotalTensu) {
        this.kinkyuShisetsuRyoyoHiTotalTensu = kinkyuShisetsuRyoyoHiTotalTensu;
    }

    /**
     * 後・往診日数のgetメソッドです。
     *
     * @return 後・往診日数
     */
    public Decimal getAtoOshinNissu() {
        return atoOshinNissu;
    }

    /**
     * 後・往診日数のsetメソッドです。
     *
     * @param atoOshinNissu 後・往診日数
     */
    public void setAtoOshinNissu(Decimal atoOshinNissu) {
        this.atoOshinNissu = atoOshinNissu;
    }

    /**
     * 後・通院日数のgetメソッドです。
     *
     * @return 後・通院日数
     */
    public Decimal getAtoTsuinNissu() {
        return atoTsuinNissu;
    }

    /**
     * 後・通院日数のsetメソッドです。
     *
     * @param atoTsuinNissu 後・通院日数
     */
    public void setAtoTsuinNissu(Decimal atoTsuinNissu) {
        this.atoTsuinNissu = atoTsuinNissu;
    }

    /**
     * 後・緊急時治療管理単位数のgetメソッドです。
     *
     * @return 後・緊急時治療管理単位数
     */
    public int getAtoKinkyuChiryoKanriTanisu() {
        return atoKinkyuChiryoKanriTanisu;
    }

    /**
     * 後・緊急時治療管理単位数のsetメソッドです。
     *
     * @param atoKinkyuChiryoKanriTanisu 後・緊急時治療管理単位数
     */
    public void setAtoKinkyuChiryoKanriTanisu(int atoKinkyuChiryoKanriTanisu) {
        this.atoKinkyuChiryoKanriTanisu = atoKinkyuChiryoKanriTanisu;
    }

    /**
     * 後・緊急時治療管理日数のgetメソッドです。
     *
     * @return 後・緊急時治療管理日数
     */
    public Decimal getAtoKinkyuChiryoKanriNissu() {
        return atoKinkyuChiryoKanriNissu;
    }

    /**
     * 後・緊急時治療管理日数のsetメソッドです。
     *
     * @param atoKinkyuChiryoKanriNissu 後・緊急時治療管理日数
     */
    public void setAtoKinkyuChiryoKanriNissu(Decimal atoKinkyuChiryoKanriNissu) {
        this.atoKinkyuChiryoKanriNissu = atoKinkyuChiryoKanriNissu;
    }

    /**
     * 後・リハビリテーション点数のgetメソッドです。
     *
     * @return 後・リハビリテーション点数
     */
    public int getAtoRehabilitationTensu() {
        return atoRehabilitationTensu;
    }

    /**
     * 後・リハビリテーション点数のsetメソッドです。
     *
     * @param atoRehabilitationTensu 後・リハビリテーション点数
     */
    public void setAtoRehabilitationTensu(int atoRehabilitationTensu) {
        this.atoRehabilitationTensu = atoRehabilitationTensu;
    }

    /**
     * 後・処置点数のgetメソッドです。
     *
     * @return 後・処置点数
     */
    public int getAtoShochiTensu() {
        return atoShochiTensu;
    }

    /**
     * 後・処置点数のsetメソッドです。
     *
     * @param atoShochiTensu 後・処置点数
     */
    public void setAtoShochiTensu(int atoShochiTensu) {
        this.atoShochiTensu = atoShochiTensu;
    }

    /**
     * 後・手術点数のgetメソッドです。
     *
     * @return 後・手術点数
     */
    public int getAtoShujutsuTensu() {
        return atoShujutsuTensu;
    }

    /**
     * 後・手術点数のsetメソッドです。
     *
     * @param atoShujutsuTensu 後・手術点数
     */
    public void setAtoShujutsuTensu(int atoShujutsuTensu) {
        this.atoShujutsuTensu = atoShujutsuTensu;
    }

    /**
     * 後・麻酔点数のgetメソッドです。
     *
     * @return 後・麻酔点数
     */
    public int getAtoMasuiTensu() {
        return atoMasuiTensu;
    }

    /**
     * 後・麻酔点数のsetメソッドです。
     *
     * @param atoMasuiTensu 後・麻酔点数
     */
    public void setAtoMasuiTensu(int atoMasuiTensu) {
        this.atoMasuiTensu = atoMasuiTensu;
    }

    /**
     * 後・放射線治療点数のgetメソッドです。
     *
     * @return 後・放射線治療点数
     */
    public int getAtoHoshasenChiryoTensu() {
        return atoHoshasenChiryoTensu;
    }

    /**
     * 後・放射線治療点数のsetメソッドです。
     *
     * @param atoHoshasenChiryoTensu 後・放射線治療点数
     */
    public void setAtoHoshasenChiryoTensu(int atoHoshasenChiryoTensu) {
        this.atoHoshasenChiryoTensu = atoHoshasenChiryoTensu;
    }

    /**
     * 再審査回数のgetメソッドです。
     *
     * @return 再審査回数
     */
    public Decimal getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * 再審査回数のsetメソッドです。
     *
     * @param saishinsaKaisu 再審査回数
     */
    public void setSaishinsaKaisu(Decimal saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * 過誤回数のgetメソッドです。
     *
     * @return 過誤回数
     */
    public Decimal getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * 過誤回数のsetメソッドです。
     *
     * @param kagoKaisu 過誤回数
     */
    public void setKagoKaisu(Decimal kagoKaisu) {
        this.kagoKaisu = kagoKaisu;
    }

    /**
     * 審査年月のgetメソッドです。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * 審査年月のsetメソッドです。
     *
     * @param shinsaYM 審査年月
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
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
     * 取込年月のgetメソッドです。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * 取込年月のsetメソッドです。
     *
     * @param torikomiYM 取込年月
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity other) {
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
    public void shallowCopy(DbT3019KyufujissekiKinkyuShisetsuRyoyoEntity entity) {
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
        this.kinkyuShisetsuRyoyoHiTotalTensu = entity.kinkyuShisetsuRyoyoHiTotalTensu;
        this.atoOshinNissu = entity.atoOshinNissu;
        this.atoTsuinNissu = entity.atoTsuinNissu;
        this.atoKinkyuChiryoKanriTanisu = entity.atoKinkyuChiryoKanriTanisu;
        this.atoKinkyuChiryoKanriNissu = entity.atoKinkyuChiryoKanriNissu;
        this.atoRehabilitationTensu = entity.atoRehabilitationTensu;
        this.atoShochiTensu = entity.atoShochiTensu;
        this.atoShujutsuTensu = entity.atoShujutsuTensu;
        this.atoMasuiTensu = entity.atoMasuiTensu;
        this.atoHoshasenChiryoTensu = entity.atoHoshasenChiryoTensu;
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
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, recodeJunjiNo, kinkyuShobyoName1, kinkyuShobyoName2, kinkyuShobyoName3, kinkyuChiryoKaishiYMD1, kinkyuChiryoKaishiYMD2, kinkyuChiryoKaishiYMD3, oshinNissu, oshinIryoKikanName, tsuinNissu, tsuinIryoKikanName, kinkyuChiryoKanriTanisu, kinkyuChiryoKanriNissu, kinkyuChiryoKanriSubTotal, rehabilitationTensu, shochiTensu, shujutsuTensu, masuiTensu, hoshasenChiryoTensu, tekiyo1, tekiyo2, tekiyo3, tekiyo4, tekiyo5, tekiyo6, tekiyo7, tekiyo8, tekiyo9, tekiyo10, tekiyo11, tekiyo12, tekiyo13, tekiyo14, tekiyo15, tekiyo16, tekiyo17, tekiyo18, tekiyo19, tekiyo20, kinkyuShisetsuRyoyoHiTotalTensu, atoOshinNissu, atoTsuinNissu, atoKinkyuChiryoKanriTanisu, atoKinkyuChiryoKanriNissu, atoRehabilitationTensu, atoShochiTensu, atoShujutsuTensu, atoMasuiTensu, atoHoshasenChiryoTensu, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
