package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;

/**
 * DbT3033KyufujissekiShukeiの項目定義クラスです
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public class DbT3033KyufujissekiShukeiEntity extends DbTableEntityBase<DbT3033KyufujissekiShukeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3033KyufujissekiShukei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    private RString recodeShubetsuCode;
    private HokenshaNo shokisaiHokenshaNo;
    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private JigyoshaNo jigyoshoNo;
    private RString toshiNo;
    private ServiceShuruiCode serviceSyuruiCode;
    private Integer serviceJitsunissu;
    private Decimal planTanisu;
    private Decimal gendogakuKanriTaishoTanisu;
    private Decimal gendogakuKanritaishogaiTanisu;
    private Integer tankiNyushoPlanNissu;
    private Integer tankiNyushoJitsunissu;
    private Decimal hokenTanisuTotal;
    private Decimal hokenTanisuTani;
    private Decimal hokenSeikyugaku;
    private Decimal hokenRiyoshaFutangaku;
    private Decimal kohi1TanisuTotal;
    private Decimal kohi1Seikyugaku;
    private Decimal kohi1HonninFutangaku;
    private Decimal kohi2TanisuTotal;
    private Decimal kohi2Seikyugaku;
    private Decimal kohi2HonninFutangaku;
    private Decimal kohi3TanisuTotal;
    private Decimal kohi3Seikyugaku;
    private Decimal kohi3HonninFutangaku;
    private Decimal hokenDekidakaTanisuTotal;
    private Decimal hokenDekidakaSeikyugaku;
    private Decimal hokenDekidakaIryohiRiyoshaFutangaku;
    private Decimal kohi1DekidakaTanisuTotal;
    private Decimal kohi1DekidakaSeikyugaku;
    private Decimal kohi1DekidakaIryohiRiyoshaFutangaku;
    private Decimal kohi2DekidakaTanisuTotal;
    private Decimal kohi2DekidakaSeikyugaku;
    private Decimal kohi2DekidakaIryohiRiyoshaFutangaku;
    private Decimal kohi3DekidakaTanisuTotal;
    private Decimal kohi3DekidakaSeikyugaku;
    private Decimal kohi3DekidakaIryohiRiyoshaFutangaku;
    private Integer atoTankiNyushoJitsunissu;
    private Decimal atoHokenTanisuTotal;
    private Decimal atoHokenSeikyugaku;
    private Decimal atoKohi1TanisuTotal;
    private Decimal atoKohi1Seikyugaku;
    private Decimal atoKohi2TanisuTotal;
    private Decimal atoKohi2Seikyugaku;
    private Decimal atoKohi3TanisuTotal;
    private Decimal atoKohi3Seikyugaku;
    private Decimal atoHokenDekidakaTanisuTotal;
    private Decimal atoHokenDekidakaSeikyugaku;
    private Decimal atoKohi1DekidakaTanisuTotal;
    private Decimal atoKohi1DekidakaSeikyugaku;
    private Decimal atoKohi2DekidakaTanisuTotal;
    private Decimal atoKohi2DekidakaSeikyugaku;
    private Decimal atoKohi3DekidakaTanisuTotal;
    private Decimal atoKohi3DekidakaSeikyugaku;
    private Integer saishinsaKaisu;
    private Integer kagoKaisu;
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
    public void setKokanJohoShikibetsuNo(@Nonnull KokanShikibetsuNo kokanJohoShikibetsuNo) {
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
    public void setInputShikibetsuNo(@Nonnull NyuryokuShikibetsuNo inputShikibetsuNo) {
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
    public void setRecodeShubetsuCode(@Nonnull RString recodeShubetsuCode) {
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
    public void setShokisaiHokenshaNo(@Nonnull HokenshaNo shokisaiHokenshaNo) {
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
    public void setHiHokenshaNo(@Nonnull HihokenshaNo hiHokenshaNo) {
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
    public void setServiceTeikyoYM(@Nonnull FlexibleYearMonth serviceTeikyoYM) {
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
    public void setJigyoshoNo(@Nonnull JigyoshaNo jigyoshoNo) {
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
    public void setToshiNo(@Nonnull RString toshiNo) {
        this.toshiNo = toshiNo;
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
    public void setServiceSyuruiCode(@Nonnull ServiceShuruiCode serviceSyuruiCode) {
        this.serviceSyuruiCode = serviceSyuruiCode;
    }

    /**
     * サービス実日数のgetメソッドです。
     * 
     * @return サービス実日数
     */
    @CheckForNull
    public Integer getServiceJitsunissu() {
        return serviceJitsunissu;
    }

    /**
     * サービス実日数のsetメソッドです。
     * 
     * @param serviceJitsunissu サービス実日数
     */
    public void setServiceJitsunissu(Integer serviceJitsunissu) {
        this.serviceJitsunissu = serviceJitsunissu;
    }

    /**
     * 計画単位数のgetメソッドです。
     * 
     * @return 計画単位数
     */
    @CheckForNull
    public Decimal getPlanTanisu() {
        return planTanisu;
    }

    /**
     * 計画単位数のsetメソッドです。
     * 
     * @param planTanisu 計画単位数
     */
    public void setPlanTanisu(Decimal planTanisu) {
        this.planTanisu = planTanisu;
    }

    /**
     * 限度額管理対象単位数のgetメソッドです。
     * 
     * @return 限度額管理対象単位数
     */
    @CheckForNull
    public Decimal getGendogakuKanriTaishoTanisu() {
        return gendogakuKanriTaishoTanisu;
    }

    /**
     * 限度額管理対象単位数のsetメソッドです。
     * 
     * @param gendogakuKanriTaishoTanisu 限度額管理対象単位数
     */
    public void setGendogakuKanriTaishoTanisu(Decimal gendogakuKanriTaishoTanisu) {
        this.gendogakuKanriTaishoTanisu = gendogakuKanriTaishoTanisu;
    }

    /**
     * 限度額管理対象外単位数のgetメソッドです。
     * 
     * @return 限度額管理対象外単位数
     */
    @CheckForNull
    public Decimal getGendogakuKanritaishogaiTanisu() {
        return gendogakuKanritaishogaiTanisu;
    }

    /**
     * 限度額管理対象外単位数のsetメソッドです。
     * 
     * @param gendogakuKanritaishogaiTanisu 限度額管理対象外単位数
     */
    public void setGendogakuKanritaishogaiTanisu(Decimal gendogakuKanritaishogaiTanisu) {
        this.gendogakuKanritaishogaiTanisu = gendogakuKanritaishogaiTanisu;
    }

    /**
     * 短期入所計画日数のgetメソッドです。
     * 
     * @return 短期入所計画日数
     */
    @CheckForNull
    public Integer getTankiNyushoPlanNissu() {
        return tankiNyushoPlanNissu;
    }

    /**
     * 短期入所計画日数のsetメソッドです。
     * 
     * @param tankiNyushoPlanNissu 短期入所計画日数
     */
    public void setTankiNyushoPlanNissu(Integer tankiNyushoPlanNissu) {
        this.tankiNyushoPlanNissu = tankiNyushoPlanNissu;
    }

    /**
     * 短期入所実日数のgetメソッドです。
     * 
     * @return 短期入所実日数
     */
    @CheckForNull
    public Integer getTankiNyushoJitsunissu() {
        return tankiNyushoJitsunissu;
    }

    /**
     * 短期入所実日数のsetメソッドです。
     * 
     * @param tankiNyushoJitsunissu 短期入所実日数
     */
    public void setTankiNyushoJitsunissu(Integer tankiNyushoJitsunissu) {
        this.tankiNyushoJitsunissu = tankiNyushoJitsunissu;
    }

    /**
     * 保険・単位数合計のgetメソッドです。
     * 
     * @return 保険・単位数合計
     */
    @CheckForNull
    public Decimal getHokenTanisuTotal() {
        return hokenTanisuTotal;
    }

    /**
     * 保険・単位数合計のsetメソッドです。
     * 
     * @param hokenTanisuTotal 保険・単位数合計
     */
    public void setHokenTanisuTotal(Decimal hokenTanisuTotal) {
        this.hokenTanisuTotal = hokenTanisuTotal;
    }

    /**
     * 保険・単位数単価のgetメソッドです。
     * 
     * @return 保険・単位数単価
     */
    @CheckForNull
    public Decimal getHokenTanisuTani() {
        return hokenTanisuTani;
    }

    /**
     * 保険・単位数単価のsetメソッドです。
     * 
     * @param hokenTanisuTani 保険・単位数単価
     */
    public void setHokenTanisuTani(Decimal hokenTanisuTani) {
        this.hokenTanisuTani = hokenTanisuTani;
    }

    /**
     * 保険・請求額のgetメソッドです。
     * 
     * @return 保険・請求額
     */
    @CheckForNull
    public Decimal getHokenSeikyugaku() {
        return hokenSeikyugaku;
    }

    /**
     * 保険・請求額のsetメソッドです。
     * 
     * @param hokenSeikyugaku 保険・請求額
     */
    public void setHokenSeikyugaku(Decimal hokenSeikyugaku) {
        this.hokenSeikyugaku = hokenSeikyugaku;
    }

    /**
     * 保険・利用者負担額のgetメソッドです。
     * 
     * @return 保険・利用者負担額
     */
    @CheckForNull
    public Decimal getHokenRiyoshaFutangaku() {
        return hokenRiyoshaFutangaku;
    }

    /**
     * 保険・利用者負担額のsetメソッドです。
     * 
     * @param hokenRiyoshaFutangaku 保険・利用者負担額
     */
    public void setHokenRiyoshaFutangaku(Decimal hokenRiyoshaFutangaku) {
        this.hokenRiyoshaFutangaku = hokenRiyoshaFutangaku;
    }

    /**
     * 公費１・単位数合計のgetメソッドです。
     * 
     * @return 公費１・単位数合計
     */
    @CheckForNull
    public Decimal getKohi1TanisuTotal() {
        return kohi1TanisuTotal;
    }

    /**
     * 公費１・単位数合計のsetメソッドです。
     * 
     * @param kohi1TanisuTotal 公費１・単位数合計
     */
    public void setKohi1TanisuTotal(Decimal kohi1TanisuTotal) {
        this.kohi1TanisuTotal = kohi1TanisuTotal;
    }

    /**
     * 公費１・請求額のgetメソッドです。
     * 
     * @return 公費１・請求額
     */
    @CheckForNull
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
     * 公費１・本人負担額のgetメソッドです。
     * 
     * @return 公費１・本人負担額
     */
    @CheckForNull
    public Decimal getKohi1HonninFutangaku() {
        return kohi1HonninFutangaku;
    }

    /**
     * 公費１・本人負担額のsetメソッドです。
     * 
     * @param kohi1HonninFutangaku 公費１・本人負担額
     */
    public void setKohi1HonninFutangaku(Decimal kohi1HonninFutangaku) {
        this.kohi1HonninFutangaku = kohi1HonninFutangaku;
    }

    /**
     * 公費２・単位数合計のgetメソッドです。
     * 
     * @return 公費２・単位数合計
     */
    @CheckForNull
    public Decimal getKohi2TanisuTotal() {
        return kohi2TanisuTotal;
    }

    /**
     * 公費２・単位数合計のsetメソッドです。
     * 
     * @param kohi2TanisuTotal 公費２・単位数合計
     */
    public void setKohi2TanisuTotal(Decimal kohi2TanisuTotal) {
        this.kohi2TanisuTotal = kohi2TanisuTotal;
    }

    /**
     * 公費２・請求額のgetメソッドです。
     * 
     * @return 公費２・請求額
     */
    @CheckForNull
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
     * 公費２・本人負担額のgetメソッドです。
     * 
     * @return 公費２・本人負担額
     */
    @CheckForNull
    public Decimal getKohi2HonninFutangaku() {
        return kohi2HonninFutangaku;
    }

    /**
     * 公費２・本人負担額のsetメソッドです。
     * 
     * @param kohi2HonninFutangaku 公費２・本人負担額
     */
    public void setKohi2HonninFutangaku(Decimal kohi2HonninFutangaku) {
        this.kohi2HonninFutangaku = kohi2HonninFutangaku;
    }

    /**
     * 公費３・単位数合計のgetメソッドです。
     * 
     * @return 公費３・単位数合計
     */
    @CheckForNull
    public Decimal getKohi3TanisuTotal() {
        return kohi3TanisuTotal;
    }

    /**
     * 公費３・単位数合計のsetメソッドです。
     * 
     * @param kohi3TanisuTotal 公費３・単位数合計
     */
    public void setKohi3TanisuTotal(Decimal kohi3TanisuTotal) {
        this.kohi3TanisuTotal = kohi3TanisuTotal;
    }

    /**
     * 公費３・請求額のgetメソッドです。
     * 
     * @return 公費３・請求額
     */
    @CheckForNull
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
     * 公費３・本人負担額のgetメソッドです。
     * 
     * @return 公費３・本人負担額
     */
    @CheckForNull
    public Decimal getKohi3HonninFutangaku() {
        return kohi3HonninFutangaku;
    }

    /**
     * 公費３・本人負担額のsetメソッドです。
     * 
     * @param kohi3HonninFutangaku 公費３・本人負担額
     */
    public void setKohi3HonninFutangaku(Decimal kohi3HonninFutangaku) {
        this.kohi3HonninFutangaku = kohi3HonninFutangaku;
    }

    /**
     * 保険・出来高単位数合計のgetメソッドです。
     * 
     * @return 保険・出来高単位数合計
     */
    @CheckForNull
    public Decimal getHokenDekidakaTanisuTotal() {
        return hokenDekidakaTanisuTotal;
    }

    /**
     * 保険・出来高単位数合計のsetメソッドです。
     * 
     * @param hokenDekidakaTanisuTotal 保険・出来高単位数合計
     */
    public void setHokenDekidakaTanisuTotal(Decimal hokenDekidakaTanisuTotal) {
        this.hokenDekidakaTanisuTotal = hokenDekidakaTanisuTotal;
    }

    /**
     * 保険・出来高請求額のgetメソッドです。
     * 
     * @return 保険・出来高請求額
     */
    @CheckForNull
    public Decimal getHokenDekidakaSeikyugaku() {
        return hokenDekidakaSeikyugaku;
    }

    /**
     * 保険・出来高請求額のsetメソッドです。
     * 
     * @param hokenDekidakaSeikyugaku 保険・出来高請求額
     */
    public void setHokenDekidakaSeikyugaku(Decimal hokenDekidakaSeikyugaku) {
        this.hokenDekidakaSeikyugaku = hokenDekidakaSeikyugaku;
    }

    /**
     * 保険・出来高医療費利用者負担額のgetメソッドです。
     * 
     * @return 保険・出来高医療費利用者負担額
     */
    @CheckForNull
    public Decimal getHokenDekidakaIryohiRiyoshaFutangaku() {
        return hokenDekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * 保険・出来高医療費利用者負担額のsetメソッドです。
     * 
     * @param hokenDekidakaIryohiRiyoshaFutangaku 保険・出来高医療費利用者負担額
     */
    public void setHokenDekidakaIryohiRiyoshaFutangaku(Decimal hokenDekidakaIryohiRiyoshaFutangaku) {
        this.hokenDekidakaIryohiRiyoshaFutangaku = hokenDekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * 公費１・出来高単位数合計のgetメソッドです。
     * 
     * @return 公費１・出来高単位数合計
     */
    @CheckForNull
    public Decimal getKohi1DekidakaTanisuTotal() {
        return kohi1DekidakaTanisuTotal;
    }

    /**
     * 公費１・出来高単位数合計のsetメソッドです。
     * 
     * @param kohi1DekidakaTanisuTotal 公費１・出来高単位数合計
     */
    public void setKohi1DekidakaTanisuTotal(Decimal kohi1DekidakaTanisuTotal) {
        this.kohi1DekidakaTanisuTotal = kohi1DekidakaTanisuTotal;
    }

    /**
     * 公費１・出来高請求額のgetメソッドです。
     * 
     * @return 公費１・出来高請求額
     */
    @CheckForNull
    public Decimal getKohi1DekidakaSeikyugaku() {
        return kohi1DekidakaSeikyugaku;
    }

    /**
     * 公費１・出来高請求額のsetメソッドです。
     * 
     * @param kohi1DekidakaSeikyugaku 公費１・出来高請求額
     */
    public void setKohi1DekidakaSeikyugaku(Decimal kohi1DekidakaSeikyugaku) {
        this.kohi1DekidakaSeikyugaku = kohi1DekidakaSeikyugaku;
    }

    /**
     * 公費１・出来高医療費利用者負担額のgetメソッドです。
     * 
     * @return 公費１・出来高医療費利用者負担額
     */
    @CheckForNull
    public Decimal getKohi1DekidakaIryohiRiyoshaFutangaku() {
        return kohi1DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * 公費１・出来高医療費利用者負担額のsetメソッドです。
     * 
     * @param kohi1DekidakaIryohiRiyoshaFutangaku 公費１・出来高医療費利用者負担額
     */
    public void setKohi1DekidakaIryohiRiyoshaFutangaku(Decimal kohi1DekidakaIryohiRiyoshaFutangaku) {
        this.kohi1DekidakaIryohiRiyoshaFutangaku = kohi1DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * 公費２・出来高単位数合計のgetメソッドです。
     * 
     * @return 公費２・出来高単位数合計
     */
    @CheckForNull
    public Decimal getKohi2DekidakaTanisuTotal() {
        return kohi2DekidakaTanisuTotal;
    }

    /**
     * 公費２・出来高単位数合計のsetメソッドです。
     * 
     * @param kohi2DekidakaTanisuTotal 公費２・出来高単位数合計
     */
    public void setKohi2DekidakaTanisuTotal(Decimal kohi2DekidakaTanisuTotal) {
        this.kohi2DekidakaTanisuTotal = kohi2DekidakaTanisuTotal;
    }

    /**
     * 公費２・出来高請求額のgetメソッドです。
     * 
     * @return 公費２・出来高請求額
     */
    @CheckForNull
    public Decimal getKohi2DekidakaSeikyugaku() {
        return kohi2DekidakaSeikyugaku;
    }

    /**
     * 公費２・出来高請求額のsetメソッドです。
     * 
     * @param kohi2DekidakaSeikyugaku 公費２・出来高請求額
     */
    public void setKohi2DekidakaSeikyugaku(Decimal kohi2DekidakaSeikyugaku) {
        this.kohi2DekidakaSeikyugaku = kohi2DekidakaSeikyugaku;
    }

    /**
     * 公費２・出来高医療費本人負担額のgetメソッドです。
     * 
     * @return 公費２・出来高医療費本人負担額
     */
    @CheckForNull
    public Decimal getKohi2DekidakaIryohiRiyoshaFutangaku() {
        return kohi2DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * 公費２・出来高医療費本人負担額のsetメソッドです。
     * 
     * @param kohi2DekidakaIryohiRiyoshaFutangaku 公費２・出来高医療費本人負担額
     */
    public void setKohi2DekidakaIryohiRiyoshaFutangaku(Decimal kohi2DekidakaIryohiRiyoshaFutangaku) {
        this.kohi2DekidakaIryohiRiyoshaFutangaku = kohi2DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * 公費３・出来高単位数合計のgetメソッドです。
     * 
     * @return 公費３・出来高単位数合計
     */
    @CheckForNull
    public Decimal getKohi3DekidakaTanisuTotal() {
        return kohi3DekidakaTanisuTotal;
    }

    /**
     * 公費３・出来高単位数合計のsetメソッドです。
     * 
     * @param kohi3DekidakaTanisuTotal 公費３・出来高単位数合計
     */
    public void setKohi3DekidakaTanisuTotal(Decimal kohi3DekidakaTanisuTotal) {
        this.kohi3DekidakaTanisuTotal = kohi3DekidakaTanisuTotal;
    }

    /**
     * 公費３・出来高請求額のgetメソッドです。
     * 
     * @return 公費３・出来高請求額
     */
    @CheckForNull
    public Decimal getKohi3DekidakaSeikyugaku() {
        return kohi3DekidakaSeikyugaku;
    }

    /**
     * 公費３・出来高請求額のsetメソッドです。
     * 
     * @param kohi3DekidakaSeikyugaku 公費３・出来高請求額
     */
    public void setKohi3DekidakaSeikyugaku(Decimal kohi3DekidakaSeikyugaku) {
        this.kohi3DekidakaSeikyugaku = kohi3DekidakaSeikyugaku;
    }

    /**
     * 公費３・出来高医療費本人負担額のgetメソッドです。
     * 
     * @return 公費３・出来高医療費本人負担額
     */
    @CheckForNull
    public Decimal getKohi3DekidakaIryohiRiyoshaFutangaku() {
        return kohi3DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * 公費３・出来高医療費本人負担額のsetメソッドです。
     * 
     * @param kohi3DekidakaIryohiRiyoshaFutangaku 公費３・出来高医療費本人負担額
     */
    public void setKohi3DekidakaIryohiRiyoshaFutangaku(Decimal kohi3DekidakaIryohiRiyoshaFutangaku) {
        this.kohi3DekidakaIryohiRiyoshaFutangaku = kohi3DekidakaIryohiRiyoshaFutangaku;
    }

    /**
     * 後・短期入所実日数のgetメソッドです。
     * 
     * @return 後・短期入所実日数
     */
    @CheckForNull
    public Integer getAtoTankiNyushoJitsunissu() {
        return atoTankiNyushoJitsunissu;
    }

    /**
     * 後・短期入所実日数のsetメソッドです。
     * 
     * @param atoTankiNyushoJitsunissu 後・短期入所実日数
     */
    public void setAtoTankiNyushoJitsunissu(Integer atoTankiNyushoJitsunissu) {
        this.atoTankiNyushoJitsunissu = atoTankiNyushoJitsunissu;
    }

    /**
     * 後・単位数合計のgetメソッドです。
     * 
     * @return 後・単位数合計
     */
    @CheckForNull
    public Decimal getAtoHokenTanisuTotal() {
        return atoHokenTanisuTotal;
    }

    /**
     * 後・単位数合計のsetメソッドです。
     * 
     * @param atoHokenTanisuTotal 後・単位数合計
     */
    public void setAtoHokenTanisuTotal(Decimal atoHokenTanisuTotal) {
        this.atoHokenTanisuTotal = atoHokenTanisuTotal;
    }

    /**
     * 後・保険請求分請求額のgetメソッドです。
     * 
     * @return 後・保険請求分請求額
     */
    @CheckForNull
    public Decimal getAtoHokenSeikyugaku() {
        return atoHokenSeikyugaku;
    }

    /**
     * 後・保険請求分請求額のsetメソッドです。
     * 
     * @param atoHokenSeikyugaku 後・保険請求分請求額
     */
    public void setAtoHokenSeikyugaku(Decimal atoHokenSeikyugaku) {
        this.atoHokenSeikyugaku = atoHokenSeikyugaku;
    }

    /**
     * 後・公費１・単位数合計のgetメソッドです。
     * 
     * @return 後・公費１・単位数合計
     */
    @CheckForNull
    public Decimal getAtoKohi1TanisuTotal() {
        return atoKohi1TanisuTotal;
    }

    /**
     * 後・公費１・単位数合計のsetメソッドです。
     * 
     * @param atoKohi1TanisuTotal 後・公費１・単位数合計
     */
    public void setAtoKohi1TanisuTotal(Decimal atoKohi1TanisuTotal) {
        this.atoKohi1TanisuTotal = atoKohi1TanisuTotal;
    }

    /**
     * 後・公費１・請求額のgetメソッドです。
     * 
     * @return 後・公費１・請求額
     */
    @CheckForNull
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
     * 後・公費２・単位数合計のgetメソッドです。
     * 
     * @return 後・公費２・単位数合計
     */
    @CheckForNull
    public Decimal getAtoKohi2TanisuTotal() {
        return atoKohi2TanisuTotal;
    }

    /**
     * 後・公費２・単位数合計のsetメソッドです。
     * 
     * @param atoKohi2TanisuTotal 後・公費２・単位数合計
     */
    public void setAtoKohi2TanisuTotal(Decimal atoKohi2TanisuTotal) {
        this.atoKohi2TanisuTotal = atoKohi2TanisuTotal;
    }

    /**
     * 後・公費２・請求額のgetメソッドです。
     * 
     * @return 後・公費２・請求額
     */
    @CheckForNull
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
     * 後・公費３・単位数合計のgetメソッドです。
     * 
     * @return 後・公費３・単位数合計
     */
    @CheckForNull
    public Decimal getAtoKohi3TanisuTotal() {
        return atoKohi3TanisuTotal;
    }

    /**
     * 後・公費３・単位数合計のsetメソッドです。
     * 
     * @param atoKohi3TanisuTotal 後・公費３・単位数合計
     */
    public void setAtoKohi3TanisuTotal(Decimal atoKohi3TanisuTotal) {
        this.atoKohi3TanisuTotal = atoKohi3TanisuTotal;
    }

    /**
     * 後・公費３・請求額のgetメソッドです。
     * 
     * @return 後・公費３・請求額
     */
    @CheckForNull
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
     * 後・保険・出来高単位数合計のgetメソッドです。
     * 
     * @return 後・保険・出来高単位数合計
     */
    @CheckForNull
    public Decimal getAtoHokenDekidakaTanisuTotal() {
        return atoHokenDekidakaTanisuTotal;
    }

    /**
     * 後・保険・出来高単位数合計のsetメソッドです。
     * 
     * @param atoHokenDekidakaTanisuTotal 後・保険・出来高単位数合計
     */
    public void setAtoHokenDekidakaTanisuTotal(Decimal atoHokenDekidakaTanisuTotal) {
        this.atoHokenDekidakaTanisuTotal = atoHokenDekidakaTanisuTotal;
    }

    /**
     * 後・保険・出来高請求額のgetメソッドです。
     * 
     * @return 後・保険・出来高請求額
     */
    @CheckForNull
    public Decimal getAtoHokenDekidakaSeikyugaku() {
        return atoHokenDekidakaSeikyugaku;
    }

    /**
     * 後・保険・出来高請求額のsetメソッドです。
     * 
     * @param atoHokenDekidakaSeikyugaku 後・保険・出来高請求額
     */
    public void setAtoHokenDekidakaSeikyugaku(Decimal atoHokenDekidakaSeikyugaku) {
        this.atoHokenDekidakaSeikyugaku = atoHokenDekidakaSeikyugaku;
    }

    /**
     * 後・公費１・出来高単位数合計のgetメソッドです。
     * 
     * @return 後・公費１・出来高単位数合計
     */
    @CheckForNull
    public Decimal getAtoKohi1DekidakaTanisuTotal() {
        return atoKohi1DekidakaTanisuTotal;
    }

    /**
     * 後・公費１・出来高単位数合計のsetメソッドです。
     * 
     * @param atoKohi1DekidakaTanisuTotal 後・公費１・出来高単位数合計
     */
    public void setAtoKohi1DekidakaTanisuTotal(Decimal atoKohi1DekidakaTanisuTotal) {
        this.atoKohi1DekidakaTanisuTotal = atoKohi1DekidakaTanisuTotal;
    }

    /**
     * 後・公費１・出来高請求額のgetメソッドです。
     * 
     * @return 後・公費１・出来高請求額
     */
    @CheckForNull
    public Decimal getAtoKohi1DekidakaSeikyugaku() {
        return atoKohi1DekidakaSeikyugaku;
    }

    /**
     * 後・公費１・出来高請求額のsetメソッドです。
     * 
     * @param atoKohi1DekidakaSeikyugaku 後・公費１・出来高請求額
     */
    public void setAtoKohi1DekidakaSeikyugaku(Decimal atoKohi1DekidakaSeikyugaku) {
        this.atoKohi1DekidakaSeikyugaku = atoKohi1DekidakaSeikyugaku;
    }

    /**
     * 後・公費２・出来高単位数合計のgetメソッドです。
     * 
     * @return 後・公費２・出来高単位数合計
     */
    @CheckForNull
    public Decimal getAtoKohi2DekidakaTanisuTotal() {
        return atoKohi2DekidakaTanisuTotal;
    }

    /**
     * 後・公費２・出来高単位数合計のsetメソッドです。
     * 
     * @param atoKohi2DekidakaTanisuTotal 後・公費２・出来高単位数合計
     */
    public void setAtoKohi2DekidakaTanisuTotal(Decimal atoKohi2DekidakaTanisuTotal) {
        this.atoKohi2DekidakaTanisuTotal = atoKohi2DekidakaTanisuTotal;
    }

    /**
     * 後・公費２・出来高請求額のgetメソッドです。
     * 
     * @return 後・公費２・出来高請求額
     */
    @CheckForNull
    public Decimal getAtoKohi2DekidakaSeikyugaku() {
        return atoKohi2DekidakaSeikyugaku;
    }

    /**
     * 後・公費２・出来高請求額のsetメソッドです。
     * 
     * @param atoKohi2DekidakaSeikyugaku 後・公費２・出来高請求額
     */
    public void setAtoKohi2DekidakaSeikyugaku(Decimal atoKohi2DekidakaSeikyugaku) {
        this.atoKohi2DekidakaSeikyugaku = atoKohi2DekidakaSeikyugaku;
    }

    /**
     * 後・公費３・出来高単位数合計のgetメソッドです。
     * 
     * @return 後・公費３・出来高単位数合計
     */
    @CheckForNull
    public Decimal getAtoKohi3DekidakaTanisuTotal() {
        return atoKohi3DekidakaTanisuTotal;
    }

    /**
     * 後・公費３・出来高単位数合計のsetメソッドです。
     * 
     * @param atoKohi3DekidakaTanisuTotal 後・公費３・出来高単位数合計
     */
    public void setAtoKohi3DekidakaTanisuTotal(Decimal atoKohi3DekidakaTanisuTotal) {
        this.atoKohi3DekidakaTanisuTotal = atoKohi3DekidakaTanisuTotal;
    }

    /**
     * 後・公費３・出来高請求額のgetメソッドです。
     * 
     * @return 後・公費３・出来高請求額
     */
    @CheckForNull
    public Decimal getAtoKohi3DekidakaSeikyugaku() {
        return atoKohi3DekidakaSeikyugaku;
    }

    /**
     * 後・公費３・出来高請求額のsetメソッドです。
     * 
     * @param atoKohi3DekidakaSeikyugaku 後・公費３・出来高請求額
     */
    public void setAtoKohi3DekidakaSeikyugaku(Decimal atoKohi3DekidakaSeikyugaku) {
        this.atoKohi3DekidakaSeikyugaku = atoKohi3DekidakaSeikyugaku;
    }

    /**
     * 再審査回数のgetメソッドです。
     * 
     * @return 再審査回数
     */
    @CheckForNull
    public Integer getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * 再審査回数のsetメソッドです。
     * 
     * @param saishinsaKaisu 再審査回数
     */
    public void setSaishinsaKaisu(Integer saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * 過誤回数のgetメソッドです。
     * 
     * @return 過誤回数
     */
    @CheckForNull
    public Integer getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * 過誤回数のsetメソッドです。
     * 
     * @param kagoKaisu 過誤回数
     */
    public void setKagoKaisu(Integer kagoKaisu) {
        this.kagoKaisu = kagoKaisu;
    }

    /**
     * 審査年月のgetメソッドです。
     * 
     * @return 審査年月
     */
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
     * このエンティティの主キーが他の{@literal DbT3033KyufujissekiShukeiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3033KyufujissekiShukeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3033KyufujissekiShukeiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3033KyufujissekiShukeiEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.serviceSyuruiCode = entity.serviceSyuruiCode;
        this.serviceJitsunissu = entity.serviceJitsunissu;
        this.planTanisu = entity.planTanisu;
        this.gendogakuKanriTaishoTanisu = entity.gendogakuKanriTaishoTanisu;
        this.gendogakuKanritaishogaiTanisu = entity.gendogakuKanritaishogaiTanisu;
        this.tankiNyushoPlanNissu = entity.tankiNyushoPlanNissu;
        this.tankiNyushoJitsunissu = entity.tankiNyushoJitsunissu;
        this.hokenTanisuTotal = entity.hokenTanisuTotal;
        this.hokenTanisuTani = entity.hokenTanisuTani;
        this.hokenSeikyugaku = entity.hokenSeikyugaku;
        this.hokenRiyoshaFutangaku = entity.hokenRiyoshaFutangaku;
        this.kohi1TanisuTotal = entity.kohi1TanisuTotal;
        this.kohi1Seikyugaku = entity.kohi1Seikyugaku;
        this.kohi1HonninFutangaku = entity.kohi1HonninFutangaku;
        this.kohi2TanisuTotal = entity.kohi2TanisuTotal;
        this.kohi2Seikyugaku = entity.kohi2Seikyugaku;
        this.kohi2HonninFutangaku = entity.kohi2HonninFutangaku;
        this.kohi3TanisuTotal = entity.kohi3TanisuTotal;
        this.kohi3Seikyugaku = entity.kohi3Seikyugaku;
        this.kohi3HonninFutangaku = entity.kohi3HonninFutangaku;
        this.hokenDekidakaTanisuTotal = entity.hokenDekidakaTanisuTotal;
        this.hokenDekidakaSeikyugaku = entity.hokenDekidakaSeikyugaku;
        this.hokenDekidakaIryohiRiyoshaFutangaku = entity.hokenDekidakaIryohiRiyoshaFutangaku;
        this.kohi1DekidakaTanisuTotal = entity.kohi1DekidakaTanisuTotal;
        this.kohi1DekidakaSeikyugaku = entity.kohi1DekidakaSeikyugaku;
        this.kohi1DekidakaIryohiRiyoshaFutangaku = entity.kohi1DekidakaIryohiRiyoshaFutangaku;
        this.kohi2DekidakaTanisuTotal = entity.kohi2DekidakaTanisuTotal;
        this.kohi2DekidakaSeikyugaku = entity.kohi2DekidakaSeikyugaku;
        this.kohi2DekidakaIryohiRiyoshaFutangaku = entity.kohi2DekidakaIryohiRiyoshaFutangaku;
        this.kohi3DekidakaTanisuTotal = entity.kohi3DekidakaTanisuTotal;
        this.kohi3DekidakaSeikyugaku = entity.kohi3DekidakaSeikyugaku;
        this.kohi3DekidakaIryohiRiyoshaFutangaku = entity.kohi3DekidakaIryohiRiyoshaFutangaku;
        this.atoTankiNyushoJitsunissu = entity.atoTankiNyushoJitsunissu;
        this.atoHokenTanisuTotal = entity.atoHokenTanisuTotal;
        this.atoHokenSeikyugaku = entity.atoHokenSeikyugaku;
        this.atoKohi1TanisuTotal = entity.atoKohi1TanisuTotal;
        this.atoKohi1Seikyugaku = entity.atoKohi1Seikyugaku;
        this.atoKohi2TanisuTotal = entity.atoKohi2TanisuTotal;
        this.atoKohi2Seikyugaku = entity.atoKohi2Seikyugaku;
        this.atoKohi3TanisuTotal = entity.atoKohi3TanisuTotal;
        this.atoKohi3Seikyugaku = entity.atoKohi3Seikyugaku;
        this.atoHokenDekidakaTanisuTotal = entity.atoHokenDekidakaTanisuTotal;
        this.atoHokenDekidakaSeikyugaku = entity.atoHokenDekidakaSeikyugaku;
        this.atoKohi1DekidakaTanisuTotal = entity.atoKohi1DekidakaTanisuTotal;
        this.atoKohi1DekidakaSeikyugaku = entity.atoKohi1DekidakaSeikyugaku;
        this.atoKohi2DekidakaTanisuTotal = entity.atoKohi2DekidakaTanisuTotal;
        this.atoKohi2DekidakaSeikyugaku = entity.atoKohi2DekidakaSeikyugaku;
        this.atoKohi3DekidakaTanisuTotal = entity.atoKohi3DekidakaTanisuTotal;
        this.atoKohi3DekidakaSeikyugaku = entity.atoKohi3DekidakaSeikyugaku;
        this.saishinsaKaisu = entity.saishinsaKaisu;
        this.kagoKaisu = entity.kagoKaisu;
        this.shinsaYM = entity.shinsaYM;
        this.seiriNo = entity.seiriNo;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, serviceSyuruiCode, serviceJitsunissu, planTanisu, gendogakuKanriTaishoTanisu, gendogakuKanritaishogaiTanisu, tankiNyushoPlanNissu, tankiNyushoJitsunissu, hokenTanisuTotal, hokenTanisuTani, hokenSeikyugaku, hokenRiyoshaFutangaku, kohi1TanisuTotal, kohi1Seikyugaku, kohi1HonninFutangaku, kohi2TanisuTotal, kohi2Seikyugaku, kohi2HonninFutangaku, kohi3TanisuTotal, kohi3Seikyugaku, kohi3HonninFutangaku, hokenDekidakaTanisuTotal, hokenDekidakaSeikyugaku, hokenDekidakaIryohiRiyoshaFutangaku, kohi1DekidakaTanisuTotal, kohi1DekidakaSeikyugaku, kohi1DekidakaIryohiRiyoshaFutangaku, kohi2DekidakaTanisuTotal, kohi2DekidakaSeikyugaku, kohi2DekidakaIryohiRiyoshaFutangaku, kohi3DekidakaTanisuTotal, kohi3DekidakaSeikyugaku, kohi3DekidakaIryohiRiyoshaFutangaku, atoTankiNyushoJitsunissu, atoHokenTanisuTotal, atoHokenSeikyugaku, atoKohi1TanisuTotal, atoKohi1Seikyugaku, atoKohi2TanisuTotal, atoKohi2Seikyugaku, atoKohi3TanisuTotal, atoKohi3Seikyugaku, atoHokenDekidakaTanisuTotal, atoHokenDekidakaSeikyugaku, atoKohi1DekidakaTanisuTotal, atoKohi1DekidakaSeikyugaku, atoKohi2DekidakaTanisuTotal, atoKohi2DekidakaSeikyugaku, atoKohi3DekidakaTanisuTotal, atoKohi3DekidakaSeikyugaku, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>

}
