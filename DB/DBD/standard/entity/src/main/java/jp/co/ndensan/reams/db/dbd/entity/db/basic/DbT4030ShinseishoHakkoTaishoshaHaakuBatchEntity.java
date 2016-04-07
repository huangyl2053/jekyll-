package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * 申請書発行対象者把握テーブルのエンティティクラスです。
 * <br/> 申請書発行対象者把握処理の内容を保持する。
 */
public class DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity extends DbTableEntityBase<DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4030ShinseishoHakkoTaishoshaHaakuBatch");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private UUID haakuShoriID;
    private YMDHMS batchExecutedTimestamp;
    private RString gemmenGengakuShurui;
    private FlexibleDate kijunYmd;
    private FlexibleYearMonth shotokuNendo;

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
     * 把握処理IDのgetメソッドです。
     * 
     * @return 把握処理ID
     */
    public UUID getHaakuShoriID() {
        return haakuShoriID;
    }

    /**
     * 把握処理IDのsetメソッドです。
     * 
     * @param haakuShoriID 把握処理ID
     */
    public void setHaakuShoriID(@Nonnull UUID haakuShoriID) {
        this.haakuShoriID = haakuShoriID;
    }

    /**
     * バッチ処理日時のgetメソッドです。
     * 
     * @return バッチ処理日時
     */
    public YMDHMS getBatchExecutedTimestamp() {
        return batchExecutedTimestamp;
    }

    /**
     * バッチ処理日時のsetメソッドです。
     * 
     * @param batchExecutedTimestamp バッチ処理日時
     */
    public void setBatchExecutedTimestamp(@Nonnull YMDHMS batchExecutedTimestamp) {
        this.batchExecutedTimestamp = batchExecutedTimestamp;
    }

    /**
     * 減免減額種類のgetメソッドです。
     * 
     * @return 減免減額種類
     */
    public RString getGemmenGengakuShurui() {
        return gemmenGengakuShurui;
    }

    /**
     * 減免減額種類のsetメソッドです。
     * 
     * @param gemmenGengakuShurui 減免減額種類
     */
    public void setGemmenGengakuShurui(@Nonnull RString gemmenGengakuShurui) {
        this.gemmenGengakuShurui = gemmenGengakuShurui;
    }

    /**
     * 基準日のgetメソッドです。
     * 
     * @return 基準日
     */
    public FlexibleDate getKijunYmd() {
        return kijunYmd;
    }

    /**
     * 基準日のsetメソッドです。
     * 
     * @param kijunYmd 基準日
     */
    public void setKijunYmd(@Nonnull FlexibleDate kijunYmd) {
        this.kijunYmd = kijunYmd;
    }

    /**
     * 所得年度のgetメソッドです。
     * 
     * @return 所得年度
     */
    public FlexibleYearMonth getShotokuNendo() {
        return shotokuNendo;
    }

    /**
     * 所得年度のsetメソッドです。
     * 
     * @param shotokuNendo 所得年度
     */
    public void setShotokuNendo(@Nonnull FlexibleYearMonth shotokuNendo) {
        this.shotokuNendo = shotokuNendo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.haakuShoriID, other.haakuShoriID)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4030ShinseishoHakkoTaishoshaHaakuBatchEntity entity) {
        this.haakuShoriID = entity.haakuShoriID;
        this.batchExecutedTimestamp = entity.batchExecutedTimestamp;
        this.gemmenGengakuShurui = entity.gemmenGengakuShurui;
        this.kijunYmd = entity.kijunYmd;
        this.shotokuNendo = entity.shotokuNendo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(haakuShoriID, batchExecutedTimestamp, gemmenGengakuShurui, kijunYmd, shotokuNendo);
    }

// </editor-fold>
}
