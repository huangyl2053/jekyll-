package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.Nonnull;

/**
 * 負担限度額一括認定テーブルのエンティティクラスです。
 */
public class DbT4035FutanGendogakuNinteiBatchEntity extends DbTableEntityBase<DbT4035FutanGendogakuNinteiBatchEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4035FutanGendogakuNinteiBatch");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private YMDHMS ninteiBatchExecutedTimestamp;
    private FlexibleYear sakuseiNendo;
    private FlexibleDate ketteiYmd;
    private boolean isTest;
    private boolean hadApproved;

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
     * 一括認定バッチ処理日時のgetメソッドです。
     * 
     * @return 一括認定バッチ処理日時
     */
    public YMDHMS getNinteiBatchExecutedTimestamp() {
        return ninteiBatchExecutedTimestamp;
    }

    /**
     * 一括認定バッチ処理日時のsetメソッドです。
     * 
     * @param ninteiBatchExecutedTimestamp 一括認定バッチ処理日時
     */
    public void setNinteiBatchExecutedTimestamp(@Nonnull YMDHMS ninteiBatchExecutedTimestamp) {
        this.ninteiBatchExecutedTimestamp = ninteiBatchExecutedTimestamp;
    }

    /**
     * 作成年度のgetメソッドです。
     * 
     * @return 作成年度
     */
    public FlexibleYear getSakuseiNendo() {
        return sakuseiNendo;
    }

    /**
     * 作成年度のsetメソッドです。
     * 
     * @param sakuseiNendo 作成年度
     */
    public void setSakuseiNendo(@Nonnull FlexibleYear sakuseiNendo) {
        this.sakuseiNendo = sakuseiNendo;
    }

    /**
     * 決定日のgetメソッドです。
     * 
     * @return 決定日
     */
    public FlexibleDate getKetteiYmd() {
        return ketteiYmd;
    }

    /**
     * 決定日のsetメソッドです。
     * 
     * @param ketteiYmd 決定日
     */
    public void setKetteiYmd(@Nonnull FlexibleDate ketteiYmd) {
        this.ketteiYmd = ketteiYmd;
    }

    /**
     * テスト処理フラグのgetメソッドです。
     * 
     * @return テスト処理フラグ
     */
    public boolean getIsTest() {
        return isTest;
    }

    /**
     * テスト処理フラグのsetメソッドです。
     * 
     * @param isTest テスト処理フラグ
     */
    public void setIsTest(@Nonnull boolean isTest) {
        this.isTest = isTest;
    }

    /**
     * 承認済みフラグのgetメソッドです。
     * 
     * @return 承認済みフラグ
     */
    public boolean getHadApproved() {
        return hadApproved;
    }

    /**
     * 承認済みフラグのsetメソッドです。
     * 
     * @param hadApproved 承認済みフラグ
     */
    public void setHadApproved(@Nonnull boolean hadApproved) {
        this.hadApproved = hadApproved;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4035FutanGendogakuNinteiBatchEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4035FutanGendogakuNinteiBatchEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4035FutanGendogakuNinteiBatchEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.ninteiBatchExecutedTimestamp, other.ninteiBatchExecutedTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4035FutanGendogakuNinteiBatchEntity entity) {
        this.ninteiBatchExecutedTimestamp = entity.ninteiBatchExecutedTimestamp;
        this.sakuseiNendo = entity.sakuseiNendo;
        this.ketteiYmd = entity.ketteiYmd;
        this.isTest = entity.isTest;
        this.hadApproved = entity.hadApproved;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(ninteiBatchExecutedTimestamp, sakuseiNendo, ketteiYmd, isTest, hadApproved);
    }

// </editor-fold>
}
