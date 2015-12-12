package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;

/**
 * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoの項目定義クラスです
 *
 */
public class DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity extends DbTableEntityBase<DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyo");

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
    private ServiceShuruiCode serviceSyuruiCode;
    private ServiceKomokuCode serviceKomokuCode;
    private Decimal hiyoTanka;
    private Decimal futanGendogaku;
    private Decimal nissu;
    private Decimal kohi1Nissu;
    private Decimal kohi2Nissu;
    private Decimal kohi3Nissu;
    private Decimal hiyogaku;
    private Decimal hokenbunSeikyugaku;
    private Decimal kohi1Futangaku;
    private Decimal kohi2Futangaku;
    private Decimal kohi3Futangaku;
    private Decimal riyoshaFutangaku;
    private Decimal hiyogakuTotal;
    private Decimal hokenbunSeikyugakuTotal;
    private Decimal riyoshaFutangakuTotal;
    private Decimal kohi1FutangakuTotal;
    private Decimal kohi1Seikyugaku;
    private Decimal kohi1HonninFutanGetsugaku;
    private Decimal kohi2FutangakuTotal;
    private Decimal kohi2Seikyugaku;
    private Decimal kohi2HonninFutanGetsugaku;
    private Decimal kohi3FutangakuTotal;
    private Decimal kohi3Seikyugaku;
    private Decimal kohi3HonninFutanGetsugaku;
    private Decimal atoHiyoTanka;
    private Decimal atoNissu;
    private Decimal atoKohi1Nissu;
    private Decimal atoKohi2Nissu;
    private Decimal atoKohi3Nissu;
    private Decimal atoHiyogaku;
    private Decimal atoHokenbunSeikyugaku;
    private Decimal atoKohi1Futangaku;
    private Decimal atoKohi2Futangaku;
    private Decimal atoKohi3Futangaku;
    private Decimal atoRiyoshaFutangaku;
    private Decimal atoHiyogakuTotal;
    private Decimal atoHokenbunSeikyugakuTotal;
    private Decimal atoRiyoshaFutangakuTotal;
    private Decimal atoKohi1FutangakuTotal;
    private Decimal atoKohi1Seikyugaku;
    private Decimal atoKohi1HonninFutanGetsugaku;
    private Decimal atoKohi2FutangakuTotal;
    private Decimal atoKohi2Seikyugaku;
    private Decimal atoKohi2HonninFutanGetsugaku;
    private Decimal atoKohi3FutangakuTotal;
    private Decimal atoKohi3Seikyugaku;
    private Decimal atoKohi3HonninFutanGetsugaku;
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
     * 特定入所者介護サービス費用情報レコード順次番号のgetメソッドです。
     *
     * @return 特定入所者介護サービス費用情報レコード順次番号
     */
    public RString getRecodeJunjiNo() {
        return recodeJunjiNo;
    }

    /**
     * 特定入所者介護サービス費用情報レコード順次番号のsetメソッドです。
     *
     * @param recodeJunjiNo 特定入所者介護サービス費用情報レコード順次番号
     */
    public void setRecodeJunjiNo(RString recodeJunjiNo) {
        this.recodeJunjiNo = recodeJunjiNo;
    }

    /**
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceSyuruiCode() {
        return serviceSyuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     *
     * @param serviceSyuruiCode サービス種類コード
     */
    public void setServiceSyuruiCode(ServiceShuruiCode serviceSyuruiCode) {
        this.serviceSyuruiCode = serviceSyuruiCode;
    }

    /**
     * サービス項目コードのgetメソッドです。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * サービス項目コードのsetメソッドです。
     *
     * @param serviceKomokuCode サービス項目コード
     */
    public void setServiceKomokuCode(ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
    }

    /**
     * 費用単価のgetメソッドです。
     *
     * @return 費用単価
     */
    public Decimal getHiyoTanka() {
        return hiyoTanka;
    }

    /**
     * 費用単価のsetメソッドです。
     *
     * @param hiyoTanka 費用単価
     */
    public void setHiyoTanka(Decimal hiyoTanka) {
        this.hiyoTanka = hiyoTanka;
    }

    /**
     * 負担限度額のgetメソッドです。
     *
     * @return 負担限度額
     */
    public Decimal getFutanGendogaku() {
        return futanGendogaku;
    }

    /**
     * 負担限度額のsetメソッドです。
     *
     * @param futanGendogaku 負担限度額
     */
    public void setFutanGendogaku(Decimal futanGendogaku) {
        this.futanGendogaku = futanGendogaku;
    }

    /**
     * 日数のgetメソッドです。
     *
     * @return 日数
     */
    public Decimal getNissu() {
        return nissu;
    }

    /**
     * 日数のsetメソッドです。
     *
     * @param nissu 日数
     */
    public void setNissu(Decimal nissu) {
        this.nissu = nissu;
    }

    /**
     * 公費１日数のgetメソッドです。
     *
     * @return 公費１日数
     */
    public Decimal getKohi1Nissu() {
        return kohi1Nissu;
    }

    /**
     * 公費１日数のsetメソッドです。
     *
     * @param kohi1Nissu 公費１日数
     */
    public void setKohi1Nissu(Decimal kohi1Nissu) {
        this.kohi1Nissu = kohi1Nissu;
    }

    /**
     * 公費２日数のgetメソッドです。
     *
     * @return 公費２日数
     */
    public Decimal getKohi2Nissu() {
        return kohi2Nissu;
    }

    /**
     * 公費２日数のsetメソッドです。
     *
     * @param kohi2Nissu 公費２日数
     */
    public void setKohi2Nissu(Decimal kohi2Nissu) {
        this.kohi2Nissu = kohi2Nissu;
    }

    /**
     * 公費３日数のgetメソッドです。
     *
     * @return 公費３日数
     */
    public Decimal getKohi3Nissu() {
        return kohi3Nissu;
    }

    /**
     * 公費３日数のsetメソッドです。
     *
     * @param kohi3Nissu 公費３日数
     */
    public void setKohi3Nissu(Decimal kohi3Nissu) {
        this.kohi3Nissu = kohi3Nissu;
    }

    /**
     * 費用額のgetメソッドです。
     *
     * @return 費用額
     */
    public Decimal getHiyogaku() {
        return hiyogaku;
    }

    /**
     * 費用額のsetメソッドです。
     *
     * @param hiyogaku 費用額
     */
    public void setHiyogaku(Decimal hiyogaku) {
        this.hiyogaku = hiyogaku;
    }

    /**
     * 保険分請求額のgetメソッドです。
     *
     * @return 保険分請求額
     */
    public Decimal getHokenbunSeikyugaku() {
        return hokenbunSeikyugaku;
    }

    /**
     * 保険分請求額のsetメソッドです。
     *
     * @param hokenbunSeikyugaku 保険分請求額
     */
    public void setHokenbunSeikyugaku(Decimal hokenbunSeikyugaku) {
        this.hokenbunSeikyugaku = hokenbunSeikyugaku;
    }

    /**
     * 公費１負担額（明細）のgetメソッドです。
     *
     * @return 公費１負担額（明細）
     */
    public Decimal getKohi1Futangaku() {
        return kohi1Futangaku;
    }

    /**
     * 公費１負担額（明細）のsetメソッドです。
     *
     * @param kohi1Futangaku 公費１負担額（明細）
     */
    public void setKohi1Futangaku(Decimal kohi1Futangaku) {
        this.kohi1Futangaku = kohi1Futangaku;
    }

    /**
     * 公費２負担額（明細）のgetメソッドです。
     *
     * @return 公費２負担額（明細）
     */
    public Decimal getKohi2Futangaku() {
        return kohi2Futangaku;
    }

    /**
     * 公費２負担額（明細）のsetメソッドです。
     *
     * @param kohi2Futangaku 公費２負担額（明細）
     */
    public void setKohi2Futangaku(Decimal kohi2Futangaku) {
        this.kohi2Futangaku = kohi2Futangaku;
    }

    /**
     * 公費３負担額（明細）のgetメソッドです。
     *
     * @return 公費３負担額（明細）
     */
    public Decimal getKohi3Futangaku() {
        return kohi3Futangaku;
    }

    /**
     * 公費３負担額（明細）のsetメソッドです。
     *
     * @param kohi3Futangaku 公費３負担額（明細）
     */
    public void setKohi3Futangaku(Decimal kohi3Futangaku) {
        this.kohi3Futangaku = kohi3Futangaku;
    }

    /**
     * 利用者負担額のgetメソッドです。
     *
     * @return 利用者負担額
     */
    public Decimal getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * 利用者負担額のsetメソッドです。
     *
     * @param riyoshaFutangaku 利用者負担額
     */
    public void setRiyoshaFutangaku(Decimal riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * 費用額合計のgetメソッドです。
     *
     * @return 費用額合計
     */
    public Decimal getHiyogakuTotal() {
        return hiyogakuTotal;
    }

    /**
     * 費用額合計のsetメソッドです。
     *
     * @param hiyogakuTotal 費用額合計
     */
    public void setHiyogakuTotal(Decimal hiyogakuTotal) {
        this.hiyogakuTotal = hiyogakuTotal;
    }

    /**
     * 保険分請求額合計のgetメソッドです。
     *
     * @return 保険分請求額合計
     */
    public Decimal getHokenbunSeikyugakuTotal() {
        return hokenbunSeikyugakuTotal;
    }

    /**
     * 保険分請求額合計のsetメソッドです。
     *
     * @param hokenbunSeikyugakuTotal 保険分請求額合計
     */
    public void setHokenbunSeikyugakuTotal(Decimal hokenbunSeikyugakuTotal) {
        this.hokenbunSeikyugakuTotal = hokenbunSeikyugakuTotal;
    }

    /**
     * 利用者負担額合計のgetメソッドです。
     *
     * @return 利用者負担額合計
     */
    public Decimal getRiyoshaFutangakuTotal() {
        return riyoshaFutangakuTotal;
    }

    /**
     * 利用者負担額合計のsetメソッドです。
     *
     * @param riyoshaFutangakuTotal 利用者負担額合計
     */
    public void setRiyoshaFutangakuTotal(Decimal riyoshaFutangakuTotal) {
        this.riyoshaFutangakuTotal = riyoshaFutangakuTotal;
    }

    /**
     * 公費１・負担額合計のgetメソッドです。
     *
     * @return 公費１・負担額合計
     */
    public Decimal getKohi1FutangakuTotal() {
        return kohi1FutangakuTotal;
    }

    /**
     * 公費１・負担額合計のsetメソッドです。
     *
     * @param kohi1FutangakuTotal 公費１・負担額合計
     */
    public void setKohi1FutangakuTotal(Decimal kohi1FutangakuTotal) {
        this.kohi1FutangakuTotal = kohi1FutangakuTotal;
    }

    /**
     * 公費１・請求額のgetメソッドです。
     *
     * @return 公費１・請求額
     */
    public Decimal getKohi1Seikyugaku() {
        return kohi1Seikyugaku;
    }

    /**
     * 公費１・請求額のsetメソッドです。
     *
     * @param kohi1Seikyugaku 公費１・請求額
     */
    public void setKohi1Seikyugaku(Decimal kohi1Seikyugaku) {
        this.kohi1Seikyugaku = kohi1Seikyugaku;
    }

    /**
     * 公費１・本人負担月額のgetメソッドです。
     *
     * @return 公費１・本人負担月額
     */
    public Decimal getKohi1HonninFutanGetsugaku() {
        return kohi1HonninFutanGetsugaku;
    }

    /**
     * 公費１・本人負担月額のsetメソッドです。
     *
     * @param kohi1HonninFutanGetsugaku 公費１・本人負担月額
     */
    public void setKohi1HonninFutanGetsugaku(Decimal kohi1HonninFutanGetsugaku) {
        this.kohi1HonninFutanGetsugaku = kohi1HonninFutanGetsugaku;
    }

    /**
     * 公費２・負担額合計のgetメソッドです。
     *
     * @return 公費２・負担額合計
     */
    public Decimal getKohi2FutangakuTotal() {
        return kohi2FutangakuTotal;
    }

    /**
     * 公費２・負担額合計のsetメソッドです。
     *
     * @param kohi2FutangakuTotal 公費２・負担額合計
     */
    public void setKohi2FutangakuTotal(Decimal kohi2FutangakuTotal) {
        this.kohi2FutangakuTotal = kohi2FutangakuTotal;
    }

    /**
     * 公費２・請求額のgetメソッドです。
     *
     * @return 公費２・請求額
     */
    public Decimal getKohi2Seikyugaku() {
        return kohi2Seikyugaku;
    }

    /**
     * 公費２・請求額のsetメソッドです。
     *
     * @param kohi2Seikyugaku 公費２・請求額
     */
    public void setKohi2Seikyugaku(Decimal kohi2Seikyugaku) {
        this.kohi2Seikyugaku = kohi2Seikyugaku;
    }

    /**
     * 公費２・本人負担月額のgetメソッドです。
     *
     * @return 公費２・本人負担月額
     */
    public Decimal getKohi2HonninFutanGetsugaku() {
        return kohi2HonninFutanGetsugaku;
    }

    /**
     * 公費２・本人負担月額のsetメソッドです。
     *
     * @param kohi2HonninFutanGetsugaku 公費２・本人負担月額
     */
    public void setKohi2HonninFutanGetsugaku(Decimal kohi2HonninFutanGetsugaku) {
        this.kohi2HonninFutanGetsugaku = kohi2HonninFutanGetsugaku;
    }

    /**
     * 公費３・負担額合計のgetメソッドです。
     *
     * @return 公費３・負担額合計
     */
    public Decimal getKohi3FutangakuTotal() {
        return kohi3FutangakuTotal;
    }

    /**
     * 公費３・負担額合計のsetメソッドです。
     *
     * @param kohi3FutangakuTotal 公費３・負担額合計
     */
    public void setKohi3FutangakuTotal(Decimal kohi3FutangakuTotal) {
        this.kohi3FutangakuTotal = kohi3FutangakuTotal;
    }

    /**
     * 公費３・請求額のgetメソッドです。
     *
     * @return 公費３・請求額
     */
    public Decimal getKohi3Seikyugaku() {
        return kohi3Seikyugaku;
    }

    /**
     * 公費３・請求額のsetメソッドです。
     *
     * @param kohi3Seikyugaku 公費３・請求額
     */
    public void setKohi3Seikyugaku(Decimal kohi3Seikyugaku) {
        this.kohi3Seikyugaku = kohi3Seikyugaku;
    }

    /**
     * 公費３・本人負担月額のgetメソッドです。
     *
     * @return 公費３・本人負担月額
     */
    public Decimal getKohi3HonninFutanGetsugaku() {
        return kohi3HonninFutanGetsugaku;
    }

    /**
     * 公費３・本人負担月額のsetメソッドです。
     *
     * @param kohi3HonninFutanGetsugaku 公費３・本人負担月額
     */
    public void setKohi3HonninFutanGetsugaku(Decimal kohi3HonninFutanGetsugaku) {
        this.kohi3HonninFutanGetsugaku = kohi3HonninFutanGetsugaku;
    }

    /**
     * 後・費用単価のgetメソッドです。
     *
     * @return 後・費用単価
     */
    public Decimal getAtoHiyoTanka() {
        return atoHiyoTanka;
    }

    /**
     * 後・費用単価のsetメソッドです。
     *
     * @param atoHiyoTanka 後・費用単価
     */
    public void setAtoHiyoTanka(Decimal atoHiyoTanka) {
        this.atoHiyoTanka = atoHiyoTanka;
    }

    /**
     * 後・日数のgetメソッドです。
     *
     * @return 後・日数
     */
    public Decimal getAtoNissu() {
        return atoNissu;
    }

    /**
     * 後・日数のsetメソッドです。
     *
     * @param atoNissu 後・日数
     */
    public void setAtoNissu(Decimal atoNissu) {
        this.atoNissu = atoNissu;
    }

    /**
     * 後・公費１日数のgetメソッドです。
     *
     * @return 後・公費１日数
     */
    public Decimal getAtoKohi1Nissu() {
        return atoKohi1Nissu;
    }

    /**
     * 後・公費１日数のsetメソッドです。
     *
     * @param atoKohi1Nissu 後・公費１日数
     */
    public void setAtoKohi1Nissu(Decimal atoKohi1Nissu) {
        this.atoKohi1Nissu = atoKohi1Nissu;
    }

    /**
     * 後・公費２日数のgetメソッドです。
     *
     * @return 後・公費２日数
     */
    public Decimal getAtoKohi2Nissu() {
        return atoKohi2Nissu;
    }

    /**
     * 後・公費２日数のsetメソッドです。
     *
     * @param atoKohi2Nissu 後・公費２日数
     */
    public void setAtoKohi2Nissu(Decimal atoKohi2Nissu) {
        this.atoKohi2Nissu = atoKohi2Nissu;
    }

    /**
     * 後・公費３日数のgetメソッドです。
     *
     * @return 後・公費３日数
     */
    public Decimal getAtoKohi3Nissu() {
        return atoKohi3Nissu;
    }

    /**
     * 後・公費３日数のsetメソッドです。
     *
     * @param atoKohi3Nissu 後・公費３日数
     */
    public void setAtoKohi3Nissu(Decimal atoKohi3Nissu) {
        this.atoKohi3Nissu = atoKohi3Nissu;
    }

    /**
     * 後・費用額のgetメソッドです。
     *
     * @return 後・費用額
     */
    public Decimal getAtoHiyogaku() {
        return atoHiyogaku;
    }

    /**
     * 後・費用額のsetメソッドです。
     *
     * @param atoHiyogaku 後・費用額
     */
    public void setAtoHiyogaku(Decimal atoHiyogaku) {
        this.atoHiyogaku = atoHiyogaku;
    }

    /**
     * 後・保険分請求額のgetメソッドです。
     *
     * @return 後・保険分請求額
     */
    public Decimal getAtoHokenbunSeikyugaku() {
        return atoHokenbunSeikyugaku;
    }

    /**
     * 後・保険分請求額のsetメソッドです。
     *
     * @param atoHokenbunSeikyugaku 後・保険分請求額
     */
    public void setAtoHokenbunSeikyugaku(Decimal atoHokenbunSeikyugaku) {
        this.atoHokenbunSeikyugaku = atoHokenbunSeikyugaku;
    }

    /**
     * 後・公費１負担額（明細）のgetメソッドです。
     *
     * @return 後・公費１負担額（明細）
     */
    public Decimal getAtoKohi1Futangaku() {
        return atoKohi1Futangaku;
    }

    /**
     * 後・公費１負担額（明細）のsetメソッドです。
     *
     * @param atoKohi1Futangaku 後・公費１負担額（明細）
     */
    public void setAtoKohi1Futangaku(Decimal atoKohi1Futangaku) {
        this.atoKohi1Futangaku = atoKohi1Futangaku;
    }

    /**
     * 後・公費２負担額（明細）のgetメソッドです。
     *
     * @return 後・公費２負担額（明細）
     */
    public Decimal getAtoKohi2Futangaku() {
        return atoKohi2Futangaku;
    }

    /**
     * 後・公費２負担額（明細）のsetメソッドです。
     *
     * @param atoKohi2Futangaku 後・公費２負担額（明細）
     */
    public void setAtoKohi2Futangaku(Decimal atoKohi2Futangaku) {
        this.atoKohi2Futangaku = atoKohi2Futangaku;
    }

    /**
     * 後・公費３負担額（明細）のgetメソッドです。
     *
     * @return 後・公費３負担額（明細）
     */
    public Decimal getAtoKohi3Futangaku() {
        return atoKohi3Futangaku;
    }

    /**
     * 後・公費３負担額（明細）のsetメソッドです。
     *
     * @param atoKohi3Futangaku 後・公費３負担額（明細）
     */
    public void setAtoKohi3Futangaku(Decimal atoKohi3Futangaku) {
        this.atoKohi3Futangaku = atoKohi3Futangaku;
    }

    /**
     * 後・利用者負担額のgetメソッドです。
     *
     * @return 後・利用者負担額
     */
    public Decimal getAtoRiyoshaFutangaku() {
        return atoRiyoshaFutangaku;
    }

    /**
     * 後・利用者負担額のsetメソッドです。
     *
     * @param atoRiyoshaFutangaku 後・利用者負担額
     */
    public void setAtoRiyoshaFutangaku(Decimal atoRiyoshaFutangaku) {
        this.atoRiyoshaFutangaku = atoRiyoshaFutangaku;
    }

    /**
     * 後・費用額合計のgetメソッドです。
     *
     * @return 後・費用額合計
     */
    public Decimal getAtoHiyogakuTotal() {
        return atoHiyogakuTotal;
    }

    /**
     * 後・費用額合計のsetメソッドです。
     *
     * @param atoHiyogakuTotal 後・費用額合計
     */
    public void setAtoHiyogakuTotal(Decimal atoHiyogakuTotal) {
        this.atoHiyogakuTotal = atoHiyogakuTotal;
    }

    /**
     * 後・保険分請求額合計のgetメソッドです。
     *
     * @return 後・保険分請求額合計
     */
    public Decimal getAtoHokenbunSeikyugakuTotal() {
        return atoHokenbunSeikyugakuTotal;
    }

    /**
     * 後・保険分請求額合計のsetメソッドです。
     *
     * @param atoHokenbunSeikyugakuTotal 後・保険分請求額合計
     */
    public void setAtoHokenbunSeikyugakuTotal(Decimal atoHokenbunSeikyugakuTotal) {
        this.atoHokenbunSeikyugakuTotal = atoHokenbunSeikyugakuTotal;
    }

    /**
     * 後・利用者負担額合計のgetメソッドです。
     *
     * @return 後・利用者負担額合計
     */
    public Decimal getAtoRiyoshaFutangakuTotal() {
        return atoRiyoshaFutangakuTotal;
    }

    /**
     * 後・利用者負担額合計のsetメソッドです。
     *
     * @param atoRiyoshaFutangakuTotal 後・利用者負担額合計
     */
    public void setAtoRiyoshaFutangakuTotal(Decimal atoRiyoshaFutangakuTotal) {
        this.atoRiyoshaFutangakuTotal = atoRiyoshaFutangakuTotal;
    }

    /**
     * 後・公費１・負担額合計のgetメソッドです。
     *
     * @return 後・公費１・負担額合計
     */
    public Decimal getAtoKohi1FutangakuTotal() {
        return atoKohi1FutangakuTotal;
    }

    /**
     * 後・公費１・負担額合計のsetメソッドです。
     *
     * @param atoKohi1FutangakuTotal 後・公費１・負担額合計
     */
    public void setAtoKohi1FutangakuTotal(Decimal atoKohi1FutangakuTotal) {
        this.atoKohi1FutangakuTotal = atoKohi1FutangakuTotal;
    }

    /**
     * 後・公費１・請求額のgetメソッドです。
     *
     * @return 後・公費１・請求額
     */
    public Decimal getAtoKohi1Seikyugaku() {
        return atoKohi1Seikyugaku;
    }

    /**
     * 後・公費１・請求額のsetメソッドです。
     *
     * @param atoKohi1Seikyugaku 後・公費１・請求額
     */
    public void setAtoKohi1Seikyugaku(Decimal atoKohi1Seikyugaku) {
        this.atoKohi1Seikyugaku = atoKohi1Seikyugaku;
    }

    /**
     * 後・公費１・本人負担月額のgetメソッドです。
     *
     * @return 後・公費１・本人負担月額
     */
    public Decimal getAtoKohi1HonninFutanGetsugaku() {
        return atoKohi1HonninFutanGetsugaku;
    }

    /**
     * 後・公費１・本人負担月額のsetメソッドです。
     *
     * @param atoKohi1HonninFutanGetsugaku 後・公費１・本人負担月額
     */
    public void setAtoKohi1HonninFutanGetsugaku(Decimal atoKohi1HonninFutanGetsugaku) {
        this.atoKohi1HonninFutanGetsugaku = atoKohi1HonninFutanGetsugaku;
    }

    /**
     * 後・公費２・負担額合計のgetメソッドです。
     *
     * @return 後・公費２・負担額合計
     */
    public Decimal getAtoKohi2FutangakuTotal() {
        return atoKohi2FutangakuTotal;
    }

    /**
     * 後・公費２・負担額合計のsetメソッドです。
     *
     * @param atoKohi2FutangakuTotal 後・公費２・負担額合計
     */
    public void setAtoKohi2FutangakuTotal(Decimal atoKohi2FutangakuTotal) {
        this.atoKohi2FutangakuTotal = atoKohi2FutangakuTotal;
    }

    /**
     * 後・公費２・請求額のgetメソッドです。
     *
     * @return 後・公費２・請求額
     */
    public Decimal getAtoKohi2Seikyugaku() {
        return atoKohi2Seikyugaku;
    }

    /**
     * 後・公費２・請求額のsetメソッドです。
     *
     * @param atoKohi2Seikyugaku 後・公費２・請求額
     */
    public void setAtoKohi2Seikyugaku(Decimal atoKohi2Seikyugaku) {
        this.atoKohi2Seikyugaku = atoKohi2Seikyugaku;
    }

    /**
     * 後・公費２・本人負担月額のgetメソッドです。
     *
     * @return 後・公費２・本人負担月額
     */
    public Decimal getAtoKohi2HonninFutanGetsugaku() {
        return atoKohi2HonninFutanGetsugaku;
    }

    /**
     * 後・公費２・本人負担月額のsetメソッドです。
     *
     * @param atoKohi2HonninFutanGetsugaku 後・公費２・本人負担月額
     */
    public void setAtoKohi2HonninFutanGetsugaku(Decimal atoKohi2HonninFutanGetsugaku) {
        this.atoKohi2HonninFutanGetsugaku = atoKohi2HonninFutanGetsugaku;
    }

    /**
     * 後・公費３・負担額合計のgetメソッドです。
     *
     * @return 後・公費３・負担額合計
     */
    public Decimal getAtoKohi3FutangakuTotal() {
        return atoKohi3FutangakuTotal;
    }

    /**
     * 後・公費３・負担額合計のsetメソッドです。
     *
     * @param atoKohi3FutangakuTotal 後・公費３・負担額合計
     */
    public void setAtoKohi3FutangakuTotal(Decimal atoKohi3FutangakuTotal) {
        this.atoKohi3FutangakuTotal = atoKohi3FutangakuTotal;
    }

    /**
     * 後・公費３・請求額のgetメソッドです。
     *
     * @return 後・公費３・請求額
     */
    public Decimal getAtoKohi3Seikyugaku() {
        return atoKohi3Seikyugaku;
    }

    /**
     * 後・公費３・請求額のsetメソッドです。
     *
     * @param atoKohi3Seikyugaku 後・公費３・請求額
     */
    public void setAtoKohi3Seikyugaku(Decimal atoKohi3Seikyugaku) {
        this.atoKohi3Seikyugaku = atoKohi3Seikyugaku;
    }

    /**
     * 後・公費３・本人負担月額のgetメソッドです。
     *
     * @return 後・公費３・本人負担月額
     */
    public Decimal getAtoKohi3HonninFutanGetsugaku() {
        return atoKohi3HonninFutanGetsugaku;
    }

    /**
     * 後・公費３・本人負担月額のsetメソッドです。
     *
     * @param atoKohi3HonninFutanGetsugaku 後・公費３・本人負担月額
     */
    public void setAtoKohi3HonninFutanGetsugaku(Decimal atoKohi3HonninFutanGetsugaku) {
        this.atoKohi3HonninFutanGetsugaku = atoKohi3HonninFutanGetsugaku;
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
     * このエンティティの主キーが他の{@literal DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity other) {
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
    public void shallowCopy(DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.recodeJunjiNo = entity.recodeJunjiNo;
        this.serviceSyuruiCode = entity.serviceSyuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.hiyoTanka = entity.hiyoTanka;
        this.futanGendogaku = entity.futanGendogaku;
        this.nissu = entity.nissu;
        this.kohi1Nissu = entity.kohi1Nissu;
        this.kohi2Nissu = entity.kohi2Nissu;
        this.kohi3Nissu = entity.kohi3Nissu;
        this.hiyogaku = entity.hiyogaku;
        this.hokenbunSeikyugaku = entity.hokenbunSeikyugaku;
        this.kohi1Futangaku = entity.kohi1Futangaku;
        this.kohi2Futangaku = entity.kohi2Futangaku;
        this.kohi3Futangaku = entity.kohi3Futangaku;
        this.riyoshaFutangaku = entity.riyoshaFutangaku;
        this.hiyogakuTotal = entity.hiyogakuTotal;
        this.hokenbunSeikyugakuTotal = entity.hokenbunSeikyugakuTotal;
        this.riyoshaFutangakuTotal = entity.riyoshaFutangakuTotal;
        this.kohi1FutangakuTotal = entity.kohi1FutangakuTotal;
        this.kohi1Seikyugaku = entity.kohi1Seikyugaku;
        this.kohi1HonninFutanGetsugaku = entity.kohi1HonninFutanGetsugaku;
        this.kohi2FutangakuTotal = entity.kohi2FutangakuTotal;
        this.kohi2Seikyugaku = entity.kohi2Seikyugaku;
        this.kohi2HonninFutanGetsugaku = entity.kohi2HonninFutanGetsugaku;
        this.kohi3FutangakuTotal = entity.kohi3FutangakuTotal;
        this.kohi3Seikyugaku = entity.kohi3Seikyugaku;
        this.kohi3HonninFutanGetsugaku = entity.kohi3HonninFutanGetsugaku;
        this.atoHiyoTanka = entity.atoHiyoTanka;
        this.atoNissu = entity.atoNissu;
        this.atoKohi1Nissu = entity.atoKohi1Nissu;
        this.atoKohi2Nissu = entity.atoKohi2Nissu;
        this.atoKohi3Nissu = entity.atoKohi3Nissu;
        this.atoHiyogaku = entity.atoHiyogaku;
        this.atoHokenbunSeikyugaku = entity.atoHokenbunSeikyugaku;
        this.atoKohi1Futangaku = entity.atoKohi1Futangaku;
        this.atoKohi2Futangaku = entity.atoKohi2Futangaku;
        this.atoKohi3Futangaku = entity.atoKohi3Futangaku;
        this.atoRiyoshaFutangaku = entity.atoRiyoshaFutangaku;
        this.atoHiyogakuTotal = entity.atoHiyogakuTotal;
        this.atoHokenbunSeikyugakuTotal = entity.atoHokenbunSeikyugakuTotal;
        this.atoRiyoshaFutangakuTotal = entity.atoRiyoshaFutangakuTotal;
        this.atoKohi1FutangakuTotal = entity.atoKohi1FutangakuTotal;
        this.atoKohi1Seikyugaku = entity.atoKohi1Seikyugaku;
        this.atoKohi1HonninFutanGetsugaku = entity.atoKohi1HonninFutanGetsugaku;
        this.atoKohi2FutangakuTotal = entity.atoKohi2FutangakuTotal;
        this.atoKohi2Seikyugaku = entity.atoKohi2Seikyugaku;
        this.atoKohi2HonninFutanGetsugaku = entity.atoKohi2HonninFutanGetsugaku;
        this.atoKohi3FutangakuTotal = entity.atoKohi3FutangakuTotal;
        this.atoKohi3Seikyugaku = entity.atoKohi3Seikyugaku;
        this.atoKohi3HonninFutanGetsugaku = entity.atoKohi3HonninFutanGetsugaku;
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
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, recodeJunjiNo, serviceSyuruiCode, serviceKomokuCode, hiyoTanka, futanGendogaku, nissu, kohi1Nissu, kohi2Nissu, kohi3Nissu, hiyogaku, hokenbunSeikyugaku, kohi1Futangaku, kohi2Futangaku, kohi3Futangaku, riyoshaFutangaku, hiyogakuTotal, hokenbunSeikyugakuTotal, riyoshaFutangakuTotal, kohi1FutangakuTotal, kohi1Seikyugaku, kohi1HonninFutanGetsugaku, kohi2FutangakuTotal, kohi2Seikyugaku, kohi2HonninFutanGetsugaku, kohi3FutangakuTotal, kohi3Seikyugaku, kohi3HonninFutanGetsugaku, atoHiyoTanka, atoNissu, atoKohi1Nissu, atoKohi2Nissu, atoKohi3Nissu, atoHiyogaku, atoHokenbunSeikyugaku, atoKohi1Futangaku, atoKohi2Futangaku, atoKohi3Futangaku, atoRiyoshaFutangaku, atoHiyogakuTotal, atoHokenbunSeikyugakuTotal, atoRiyoshaFutangakuTotal, atoKohi1FutangakuTotal, atoKohi1Seikyugaku, atoKohi1HonninFutanGetsugaku, atoKohi2FutangakuTotal, atoKohi2Seikyugaku, atoKohi2HonninFutanGetsugaku, atoKohi3FutangakuTotal, atoKohi3Seikyugaku, atoKohi3HonninFutanGetsugaku, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
