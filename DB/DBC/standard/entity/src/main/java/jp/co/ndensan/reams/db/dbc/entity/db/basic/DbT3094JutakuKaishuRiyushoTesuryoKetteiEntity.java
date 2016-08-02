package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 住宅改修理由書作成手数料請求決定テーブルのエンティティクラスです。
 */
public class DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity extends DbTableEntityBase<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3094JutakuKaishuRiyushoTesuryoKettei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private JigyoshaNo riyushoSakuseiJigyoshaNo;
    @PrimaryKey
    private FlexibleDate ketteiYMD;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleDate shikyu_FushikyuKetteiYMD;
    private RString shikyu_FushikyuKubun;
    private RString fushikyuRiyu;
    private FlexibleDate tesuryoShiharaiYoteiYMD;
    private RString shukeiNo;
    private FlexibleDate ketteiTsuchiSakuseiYMD;
    private FlexibleDate furikomiTsuchiSakuseiYMD;
    private FlexibleYearMonth uketoriYM;
    private long kozaID;

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
     * 介護住宅改修理由書作成事業者番号のgetメソッドです。
     * 
     * @return 介護住宅改修理由書作成事業者番号
     */
    public JigyoshaNo getRiyushoSakuseiJigyoshaNo() {
        return riyushoSakuseiJigyoshaNo;
    }

    /**
     * 介護住宅改修理由書作成事業者番号のsetメソッドです。
     * 
     * @param riyushoSakuseiJigyoshaNo 介護住宅改修理由書作成事業者番号
     */
    public void setRiyushoSakuseiJigyoshaNo(@Nonnull JigyoshaNo riyushoSakuseiJigyoshaNo) {
        this.riyushoSakuseiJigyoshaNo = riyushoSakuseiJigyoshaNo;
    }

    /**
     * 決定年月日のgetメソッドです。
     * 
     * @return 決定年月日
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 決定年月日のsetメソッドです。
     * 
     * @param ketteiYMD 決定年月日
     */
    public void setKetteiYMD(@Nonnull FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 支給・不支給決定年月日のgetメソッドです。
     * 
     * @return 支給・不支給決定年月日
     */
    @CheckForNull
    public FlexibleDate getShikyu_FushikyuKetteiYMD() {
        return shikyu_FushikyuKetteiYMD;
    }

    /**
     * 支給・不支給決定年月日のsetメソッドです。
     * 
     * @param shikyu_FushikyuKetteiYMD 支給・不支給決定年月日
     */
    public void setShikyu_FushikyuKetteiYMD(FlexibleDate shikyu_FushikyuKetteiYMD) {
        this.shikyu_FushikyuKetteiYMD = shikyu_FushikyuKetteiYMD;
    }

    /**
     * 支給・不支給区分のgetメソッドです。
     * 
     * @return 支給・不支給区分
     */
    @CheckForNull
    public RString getShikyu_FushikyuKubun() {
        return shikyu_FushikyuKubun;
    }

    /**
     * 支給・不支給区分のsetメソッドです。
     * 
     * @param shikyu_FushikyuKubun 支給・不支給区分
     */
    public void setShikyu_FushikyuKubun(RString shikyu_FushikyuKubun) {
        this.shikyu_FushikyuKubun = shikyu_FushikyuKubun;
    }

    /**
     * 償還不支給理由等のgetメソッドです。
     * 
     * @return 償還不支給理由等
     */
    @CheckForNull
    public RString getFushikyuRiyu() {
        return fushikyuRiyu;
    }

    /**
     * 償還不支給理由等のsetメソッドです。
     * 
     * @param fushikyuRiyu 償還不支給理由等
     */
    public void setFushikyuRiyu(RString fushikyuRiyu) {
        this.fushikyuRiyu = fushikyuRiyu;
    }

    /**
     * 住宅改修理由書作成手数料支払予定日のgetメソッドです。
     * 
     * @return 住宅改修理由書作成手数料支払予定日
     */
    @CheckForNull
    public FlexibleDate getTesuryoShiharaiYoteiYMD() {
        return tesuryoShiharaiYoteiYMD;
    }

    /**
     * 住宅改修理由書作成手数料支払予定日のsetメソッドです。
     * 
     * @param tesuryoShiharaiYoteiYMD 住宅改修理由書作成手数料支払予定日
     */
    public void setTesuryoShiharaiYoteiYMD(FlexibleDate tesuryoShiharaiYoteiYMD) {
        this.tesuryoShiharaiYoteiYMD = tesuryoShiharaiYoteiYMD;
    }

    /**
     * 集計関連付け番号のgetメソッドです。
     * <br/>
     * <br/>連番
     * 
     * @return 集計関連付け番号
     */
    @CheckForNull
    public RString getShukeiNo() {
        return shukeiNo;
    }

    /**
     * 集計関連付け番号のsetメソッドです。
     * <br/>
     * <br/>連番
     * 
     * @param shukeiNo 集計関連付け番号
     */
    public void setShukeiNo(RString shukeiNo) {
        this.shukeiNo = shukeiNo;
    }

    /**
     * 決定通知書作成年月日のgetメソッドです。
     * 
     * @return 決定通知書作成年月日
     */
    @CheckForNull
    public FlexibleDate getKetteiTsuchiSakuseiYMD() {
        return ketteiTsuchiSakuseiYMD;
    }

    /**
     * 決定通知書作成年月日のsetメソッドです。
     * 
     * @param ketteiTsuchiSakuseiYMD 決定通知書作成年月日
     */
    public void setKetteiTsuchiSakuseiYMD(FlexibleDate ketteiTsuchiSakuseiYMD) {
        this.ketteiTsuchiSakuseiYMD = ketteiTsuchiSakuseiYMD;
    }

    /**
     * 振込通知書作成年月日のgetメソッドです。
     * 
     * @return 振込通知書作成年月日
     */
    @CheckForNull
    public FlexibleDate getFurikomiTsuchiSakuseiYMD() {
        return furikomiTsuchiSakuseiYMD;
    }

    /**
     * 振込通知書作成年月日のsetメソッドです。
     * 
     * @param furikomiTsuchiSakuseiYMD 振込通知書作成年月日
     */
    public void setFurikomiTsuchiSakuseiYMD(FlexibleDate furikomiTsuchiSakuseiYMD) {
        this.furikomiTsuchiSakuseiYMD = furikomiTsuchiSakuseiYMD;
    }

    /**
     * 受取年月のgetメソッドです。
     * 
     * @return 受取年月
     */
    @CheckForNull
    public FlexibleYearMonth getUketoriYM() {
        return uketoriYM;
    }

    /**
     * 受取年月のsetメソッドです。
     * 
     * @param uketoriYM 受取年月
     */
    public void setUketoriYM(FlexibleYearMonth uketoriYM) {
        this.uketoriYM = uketoriYM;
    }

    /**
     * 口座IDのgetメソッドです。
     * 
     * @return 口座ID
     */
    @CheckForNull
    public long getKozaID() {
        return kozaID;
    }

    /**
     * 口座IDのsetメソッドです。
     * 
     * @param kozaID 口座ID
     */
    public void setKozaID(long kozaID) {
        this.kozaID = kozaID;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.riyushoSakuseiJigyoshaNo, other.riyushoSakuseiJigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.ketteiYMD, other.ketteiYMD)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        this.riyushoSakuseiJigyoshaNo = entity.riyushoSakuseiJigyoshaNo;
        this.ketteiYMD = entity.ketteiYMD;
        this.rirekiNo = entity.rirekiNo;
        this.shikyu_FushikyuKetteiYMD = entity.shikyu_FushikyuKetteiYMD;
        this.shikyu_FushikyuKubun = entity.shikyu_FushikyuKubun;
        this.fushikyuRiyu = entity.fushikyuRiyu;
        this.tesuryoShiharaiYoteiYMD = entity.tesuryoShiharaiYoteiYMD;
        this.shukeiNo = entity.shukeiNo;
        this.ketteiTsuchiSakuseiYMD = entity.ketteiTsuchiSakuseiYMD;
        this.furikomiTsuchiSakuseiYMD = entity.furikomiTsuchiSakuseiYMD;
        this.uketoriYM = entity.uketoriYM;
        this.kozaID = entity.kozaID;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(riyushoSakuseiJigyoshaNo, ketteiYMD, rirekiNo, shikyu_FushikyuKetteiYMD, shikyu_FushikyuKubun, fushikyuRiyu, tesuryoShiharaiYoteiYMD, shukeiNo, ketteiTsuchiSakuseiYMD, furikomiTsuchiSakuseiYMD, uketoriYM, kozaID);
    }

// </editor-fold>


}
