package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT2018RealHakkoRirekiテーブルのエンティティクラスです。
 */
public class DbT2018RealHakkoRirekiEntity extends DbTableEntityBase<DbT2018RealHakkoRirekiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT2018RealHakkoRireki");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear choteiNendo;
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @PrimaryKey
    private ReportId chohyoBunruiID;
    @PrimaryKey
    private YMDHMS tsuchishoPrintTimeStamp;
    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;

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
     * choteiNendoのgetメソッドです。
     * 
     * @return choteiNendo
     */
    public FlexibleYear getChoteiNendo() {
        return choteiNendo;
    }

    /**
     * choteiNendoのsetメソッドです。
     * 
     * @param choteiNendo choteiNendo
     */
    public void setChoteiNendo(@Nonnull FlexibleYear choteiNendo) {
        this.choteiNendo = choteiNendo;
    }

    /**
     * fukaNendoのgetメソッドです。
     * 
     * @return fukaNendo
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * fukaNendoのsetメソッドです。
     * 
     * @param fukaNendo fukaNendo
     */
    public void setFukaNendo(@Nonnull FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * tsuchishoNoのgetメソッドです。
     * 
     * @return tsuchishoNo
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * tsuchishoNoのsetメソッドです。
     * 
     * @param tsuchishoNo tsuchishoNo
     */
    public void setTsuchishoNo(@Nonnull TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * chohyoBunruiIDのgetメソッドです。
     * 
     * @return chohyoBunruiID
     */
    public ReportId getChohyoBunruiID() {
        return chohyoBunruiID;
    }

    /**
     * chohyoBunruiIDのsetメソッドです。
     * 
     * @param chohyoBunruiID chohyoBunruiID
     */
    public void setChohyoBunruiID(@Nonnull ReportId chohyoBunruiID) {
        this.chohyoBunruiID = chohyoBunruiID;
    }

    /**
     * tsuchishoPrintTimeStampのgetメソッドです。
     * 
     * @return tsuchishoPrintTimeStamp
     */
    public YMDHMS getTsuchishoPrintTimeStamp() {
        return tsuchishoPrintTimeStamp;
    }

    /**
     * tsuchishoPrintTimeStampのsetメソッドです。
     * 
     * @param tsuchishoPrintTimeStamp tsuchishoPrintTimeStamp
     */
    public void setTsuchishoPrintTimeStamp(@Nonnull YMDHMS tsuchishoPrintTimeStamp) {
        this.tsuchishoPrintTimeStamp = tsuchishoPrintTimeStamp;
    }

    /**
     * hihokenshaNoのgetメソッドです。
     * 
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * hihokenshaNoのsetメソッドです。
     * 
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * shikibetsuCodeのgetメソッドです。
     * 
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * shikibetsuCodeのsetメソッドです。
     * 
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2018RealHakkoRirekiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2018RealHakkoRirekiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2018RealHakkoRirekiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.choteiNendo, other.choteiNendo)) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
            return false;
        }
        if (!Objects.equals(this.tsuchishoNo, other.tsuchishoNo)) {
            return false;
        }
        if (!Objects.equals(this.chohyoBunruiID, other.chohyoBunruiID)) {
            return false;
        }
        if (!Objects.equals(this.tsuchishoPrintTimeStamp, other.tsuchishoPrintTimeStamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT2018RealHakkoRirekiEntity entity) {
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.chohyoBunruiID = entity.chohyoBunruiID;
        this.tsuchishoPrintTimeStamp = entity.tsuchishoPrintTimeStamp;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, chohyoBunruiID, tsuchishoPrintTimeStamp, hihokenshaNo, shikibetsuCode);
    }

// </editor-fold>
}
