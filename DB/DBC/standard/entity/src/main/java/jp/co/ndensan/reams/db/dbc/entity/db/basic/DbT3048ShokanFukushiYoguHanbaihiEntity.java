package jp.co.ndensan.reams.db.dbc.entity.db.basic;

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
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;

/**
 * 償還払請求福祉用具販売費テーブルのエンティティクラスです。
 */
public class DbT3048ShokanFukushiYoguHanbaihiEntity extends DbTableEntityBase<DbT3048ShokanFukushiYoguHanbaihiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3048ShokanFukushiYoguHanbaihi");

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
    private ServiceCode serviceCode;
    private FlexibleDate fukushiYoguHanbaiYMD;
    private RString fukushiYoguShohinName;
    private RString fukushiYoguShumokuCode;
    private RString fukushiYoguSeizoJigyoshaName;
    private RString fukushiYoguHanbaiJigyoshaName;
    private int kounyuKingaku;
    private RString hinmokuCode;
    private RString shinsaHohoKubunCode;
    private int sagakuKingaku;

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
    public void setSeiriNo(@Nonnull RString seiriNo) {
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
    public void setJigyoshaNo(@Nonnull JigyoshaNo jigyoshaNo) {
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
    public void setYoshikiNo(@Nonnull RString yoshikiNo) {
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
    public void setMeisaiNo(@Nonnull RString meisaiNo) {
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
    public void setRenban(@Nonnull RString renban) {
        this.renban = renban;
    }

    /**
     * サービスコードのgetメソッドです。
     *
     * @return サービスコード
     */
    @CheckForNull
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
    @CheckForNull
    public FlexibleDate getFukushiYoguHanbaiYMD() {
        return fukushiYoguHanbaiYMD;
    }

    /**
     * 福祉用具販売年月日のsetメソッドです。
     *
     * @param fukushiYoguHanbaiYMD 福祉用具販売年月日
     */
    public void setFukushiYoguHanbaiYMD(FlexibleDate fukushiYoguHanbaiYMD) {
        this.fukushiYoguHanbaiYMD = fukushiYoguHanbaiYMD;
    }

    /**
     * 福祉用具商品名のgetメソッドです。
     *
     * @return 福祉用具商品名
     */
    @CheckForNull
    public RString getFukushiYoguShohinName() {
        return fukushiYoguShohinName;
    }

    /**
     * 福祉用具商品名のsetメソッドです。
     *
     * @param fukushiYoguShohinName 福祉用具商品名
     */
    public void setFukushiYoguShohinName(RString fukushiYoguShohinName) {
        this.fukushiYoguShohinName = fukushiYoguShohinName;
    }

    /**
     * 福祉用具種目コードのgetメソッドです。
     *
     * @return 福祉用具種目コード
     */
    @CheckForNull
    public RString getFukushiYoguShumokuCode() {
        return fukushiYoguShumokuCode;
    }

    /**
     * 福祉用具種目コードのsetメソッドです。
     *
     * @param fukushiYoguShumokuCode 福祉用具種目コード
     */
    public void setFukushiYoguShumokuCode(RString fukushiYoguShumokuCode) {
        this.fukushiYoguShumokuCode = fukushiYoguShumokuCode;
    }

    /**
     * 福祉用具製造事業者名のgetメソッドです。
     *
     * @return 福祉用具製造事業者名
     */
    @CheckForNull
    public RString getFukushiYoguSeizoJigyoshaName() {
        return fukushiYoguSeizoJigyoshaName;
    }

    /**
     * 福祉用具製造事業者名のsetメソッドです。
     *
     * @param fukushiYoguSeizoJigyoshaName 福祉用具製造事業者名
     */
    public void setFukushiYoguSeizoJigyoshaName(RString fukushiYoguSeizoJigyoshaName) {
        this.fukushiYoguSeizoJigyoshaName = fukushiYoguSeizoJigyoshaName;
    }

    /**
     * 福祉用具販売事業者名のgetメソッドです。
     *
     * @return 福祉用具販売事業者名
     */
    @CheckForNull
    public RString getFukushiYoguHanbaiJigyoshaName() {
        return fukushiYoguHanbaiJigyoshaName;
    }

    /**
     * 福祉用具販売事業者名のsetメソッドです。
     *
     * @param fukushiYoguHanbaiJigyoshaName 福祉用具販売事業者名
     */
    public void setFukushiYoguHanbaiJigyoshaName(RString fukushiYoguHanbaiJigyoshaName) {
        this.fukushiYoguHanbaiJigyoshaName = fukushiYoguHanbaiJigyoshaName;
    }

    /**
     * 購入金額のgetメソッドです。
     *
     * @return 購入金額
     */
    @CheckForNull
    public int getKounyuKingaku() {
        return kounyuKingaku;
    }

    /**
     * 購入金額のsetメソッドです。
     *
     * @param kounyuKingaku 購入金額
     */
    public void setKounyuKingaku(int kounyuKingaku) {
        this.kounyuKingaku = kounyuKingaku;
    }

    /**
     * 品目コードのgetメソッドです。
     *
     * @return 品目コード
     */
    @CheckForNull
    public RString getHinmokuCode() {
        return hinmokuCode;
    }

    /**
     * 品目コードのsetメソッドです。
     *
     * @param hinmokuCode 品目コード
     */
    public void setHinmokuCode(RString hinmokuCode) {
        this.hinmokuCode = hinmokuCode;
    }

    /**
     * 審査方法区分コードのgetメソッドです。
     *
     * @return 審査方法区分コード
     */
    @CheckForNull
    public RString getShinsaHohoKubunCode() {
        return shinsaHohoKubunCode;
    }

    /**
     * 審査方法区分コードのsetメソッドです。
     *
     * @param shinsaHohoKubunCode 審査方法区分コード
     */
    public void setShinsaHohoKubunCode(RString shinsaHohoKubunCode) {
        this.shinsaHohoKubunCode = shinsaHohoKubunCode;
    }

    /**
     * 差額金額のgetメソッドです。
     *
     * @return 差額金額
     */
    @CheckForNull
    public int getSagakuKingaku() {
        return sagakuKingaku;
    }

    /**
     * 差額金額のsetメソッドです。
     *
     * @param sagakuKingaku 差額金額
     */
    public void setSagakuKingaku(int sagakuKingaku) {
        this.sagakuKingaku = sagakuKingaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3048ShokanFukushiYoguHanbaihiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3048ShokanFukushiYoguHanbaihiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3048ShokanFukushiYoguHanbaihiEntity other) {
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
        if (!Objects.equals(this.renban, other.renban)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3048ShokanFukushiYoguHanbaihiEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.meisaiNo = entity.meisaiNo;
        this.renban = entity.renban;
        this.serviceCode = entity.serviceCode;
        this.fukushiYoguHanbaiYMD = entity.fukushiYoguHanbaiYMD;
        this.fukushiYoguShohinName = entity.fukushiYoguShohinName;
        this.fukushiYoguShumokuCode = entity.fukushiYoguShumokuCode;
        this.fukushiYoguSeizoJigyoshaName = entity.fukushiYoguSeizoJigyoshaName;
        this.fukushiYoguHanbaiJigyoshaName = entity.fukushiYoguHanbaiJigyoshaName;
        this.kounyuKingaku = entity.kounyuKingaku;
        this.hinmokuCode = entity.hinmokuCode;
        this.shinsaHohoKubunCode = entity.shinsaHohoKubunCode;
        this.sagakuKingaku = entity.sagakuKingaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, meisaiNo, renban, serviceCode, fukushiYoguHanbaiYMD, fukushiYoguShohinName, fukushiYoguShumokuCode, fukushiYoguSeizoJigyoshaName, fukushiYoguHanbaiJigyoshaName, kounyuKingaku, hinmokuCode, shinsaHohoKubunCode, sagakuKingaku);
    }

// </editor-fold>
}
