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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;

/**
 * DbT3026KyufujissekiFukushiYoguHanbaihiの項目定義クラスです
 *
 */
public class DbT3026KyufujissekiFukushiYoguHanbaihiEntity extends DbTableEntityBase<DbT3026KyufujissekiFukushiYoguHanbaihiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3026KyufujissekiFukushiYoguHanbaihi");

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
    private RString meisaiNo;
    private ServiceCode serviceCode;
    private FlexibleDate fukushiyoguHanbaiYMD;
    private RString fukushiyoguShohinName;
    private RString fukushiyoguSyumokuCode;
    private RString fukushiyoguSeizoJigyoshaName;
    private RString fukushiyoguHanbaiJigyoshaName;
    private Decimal hanbaiKingaku;
    private RString tekiyo;
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
     * 明細番号のgetメソッドです。
     *
     * @return 明細番号
     */
    public RString getMeisaiNo() {
        return meisaiNo;
    }

    /**
     * 明細番号のsetメソッドです。
     *
     * @param meisaiNo 明細番号
     */
    public void setMeisaiNo(RString meisaiNo) {
        this.meisaiNo = meisaiNo;
    }

    /**
     * サービスコードのgetメソッドです。
     *
     * @return サービスコード
     */
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * サービスコードのsetメソッドです。
     *
     * @param serviceCode サービスコード
     */
    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * 福祉用具販売年月日のgetメソッドです。
     *
     * @return 福祉用具販売年月日
     */
    public FlexibleDate getFukushiyoguHanbaiYMD() {
        return fukushiyoguHanbaiYMD;
    }

    /**
     * 福祉用具販売年月日のsetメソッドです。
     *
     * @param fukushiyoguHanbaiYMD 福祉用具販売年月日
     */
    public void setFukushiyoguHanbaiYMD(FlexibleDate fukushiyoguHanbaiYMD) {
        this.fukushiyoguHanbaiYMD = fukushiyoguHanbaiYMD;
    }

    /**
     * 福祉用具商品名のgetメソッドです。
     *
     * @return 福祉用具商品名
     */
    public RString getFukushiyoguShohinName() {
        return fukushiyoguShohinName;
    }

    /**
     * 福祉用具商品名のsetメソッドです。
     *
     * @param fukushiyoguShohinName 福祉用具商品名
     */
    public void setFukushiyoguShohinName(RString fukushiyoguShohinName) {
        this.fukushiyoguShohinName = fukushiyoguShohinName;
    }

    /**
     * 福祉用具種目コードのgetメソッドです。
     *
     * @return 福祉用具種目コード
     */
    public RString getFukushiyoguSyumokuCode() {
        return fukushiyoguSyumokuCode;
    }

    /**
     * 福祉用具種目コードのsetメソッドです。
     *
     * @param fukushiyoguSyumokuCode 福祉用具種目コード
     */
    public void setFukushiyoguSyumokuCode(RString fukushiyoguSyumokuCode) {
        this.fukushiyoguSyumokuCode = fukushiyoguSyumokuCode;
    }

    /**
     * 福祉用具製造事業者名のgetメソッドです。
     *
     * @return 福祉用具製造事業者名
     */
    public RString getFukushiyoguSeizoJigyoshaName() {
        return fukushiyoguSeizoJigyoshaName;
    }

    /**
     * 福祉用具製造事業者名のsetメソッドです。
     *
     * @param fukushiyoguSeizoJigyoshaName 福祉用具製造事業者名
     */
    public void setFukushiyoguSeizoJigyoshaName(RString fukushiyoguSeizoJigyoshaName) {
        this.fukushiyoguSeizoJigyoshaName = fukushiyoguSeizoJigyoshaName;
    }

    /**
     * 福祉用具販売事業者名のgetメソッドです。
     *
     * @return 福祉用具販売事業者名
     */
    public RString getFukushiyoguHanbaiJigyoshaName() {
        return fukushiyoguHanbaiJigyoshaName;
    }

    /**
     * 福祉用具販売事業者名のsetメソッドです。
     *
     * @param fukushiyoguHanbaiJigyoshaName 福祉用具販売事業者名
     */
    public void setFukushiyoguHanbaiJigyoshaName(RString fukushiyoguHanbaiJigyoshaName) {
        this.fukushiyoguHanbaiJigyoshaName = fukushiyoguHanbaiJigyoshaName;
    }

    /**
     * 販売金額のgetメソッドです。
     *
     * @return 販売金額
     */
    public Decimal getHanbaiKingaku() {
        return hanbaiKingaku;
    }

    /**
     * 販売金額のsetメソッドです。
     *
     * @param hanbaiKingaku 販売金額
     */
    public void setHanbaiKingaku(Decimal hanbaiKingaku) {
        this.hanbaiKingaku = hanbaiKingaku;
    }

    /**
     * 摘要（品目コード）のgetメソッドです。
     *
     * @return 摘要（品目コード）
     */
    public RString getTekiyo() {
        return tekiyo;
    }

    /**
     * 摘要（品目コード）のsetメソッドです。
     *
     * @param tekiyo 摘要（品目コード）
     */
    public void setTekiyo(RString tekiyo) {
        this.tekiyo = tekiyo;
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
     * このエンティティの主キーが他の{@literal DbT3026KyufujissekiFukushiYoguHanbaihiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3026KyufujissekiFukushiYoguHanbaihiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3026KyufujissekiFukushiYoguHanbaihiEntity other) {
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
        if (!Objects.equals(this.meisaiNo, other.meisaiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3026KyufujissekiFukushiYoguHanbaihiEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.meisaiNo = entity.meisaiNo;
        this.serviceCode = entity.serviceCode;
        this.fukushiyoguHanbaiYMD = entity.fukushiyoguHanbaiYMD;
        this.fukushiyoguShohinName = entity.fukushiyoguShohinName;
        this.fukushiyoguSyumokuCode = entity.fukushiyoguSyumokuCode;
        this.fukushiyoguSeizoJigyoshaName = entity.fukushiyoguSeizoJigyoshaName;
        this.fukushiyoguHanbaiJigyoshaName = entity.fukushiyoguHanbaiJigyoshaName;
        this.hanbaiKingaku = entity.hanbaiKingaku;
        this.tekiyo = entity.tekiyo;
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
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, meisaiNo, serviceCode, fukushiyoguHanbaiYMD, fukushiyoguShohinName, fukushiyoguSyumokuCode, fukushiyoguSeizoJigyoshaName, fukushiyoguHanbaiJigyoshaName, hanbaiKingaku, tekiyo, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
