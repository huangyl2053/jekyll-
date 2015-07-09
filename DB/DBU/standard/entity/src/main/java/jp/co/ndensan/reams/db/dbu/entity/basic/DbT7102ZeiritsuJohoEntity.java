package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 税率情報テーブルのエンティティクラスです。
 */
public class DbT7102ZeiritsuJohoEntity extends DbTableEntityBase<DbT7102ZeiritsuJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7102ZeiritsuJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private int zeiritsu;
    @PrimaryKey
    private FlexibleDate zeiritsuKaishiYMD;
    @PrimaryKey
    private FlexibleDate zeiritsuShuryoYMD;

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
     * 税率のgetメソッドです。
     * 
     * @return 税率
     */
    public int getZeiritsu() {
        return zeiritsu;
    }

    /**
     * 税率のsetメソッドです。
     * 
     * @param zeiritsu 税率
     */
    public void setZeiritsu(int zeiritsu) {
        this.zeiritsu = zeiritsu;
    }

    /**
     * 開始年月のgetメソッドです。
     * 
     * @return 開始年月
     */
    public FlexibleDate getZeiritsuKaishiYMD() {
        return zeiritsuKaishiYMD;
    }

    /**
     * 開始年月のsetメソッドです。
     * 
     * @param zeiritsuKaishiYMD 開始年月
     */
    public void setZeiritsuKaishiYMD(FlexibleDate zeiritsuKaishiYMD) {
        this.zeiritsuKaishiYMD = zeiritsuKaishiYMD;
    }

    /**
     * 終了年月のgetメソッドです。
     * 
     * @return 終了年月
     */
    public FlexibleDate getZeiritsuShuryoYMD() {
        return zeiritsuShuryoYMD;
    }

    /**
     * 終了年月のsetメソッドです。
     * 
     * @param zeiritsuShuryoYMD 終了年月
     */
    public void setZeiritsuShuryoYMD(FlexibleDate zeiritsuShuryoYMD) {
        this.zeiritsuShuryoYMD = zeiritsuShuryoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7102ZeiritsuJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7102ZeiritsuJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7102ZeiritsuJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.zeiritsuKaishiYMD, other.zeiritsuKaishiYMD)) {
            return false;
        }
        if (!Objects.equals(this.zeiritsuShuryoYMD, other.zeiritsuShuryoYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7102ZeiritsuJohoEntity entity) {
        this.zeiritsu = entity.zeiritsu;
        this.zeiritsuKaishiYMD = entity.zeiritsuKaishiYMD;
        this.zeiritsuShuryoYMD = entity.zeiritsuShuryoYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(zeiritsu, zeiritsuKaishiYMD, zeiritsuShuryoYMD);
    }

// </editor-fold>
}
