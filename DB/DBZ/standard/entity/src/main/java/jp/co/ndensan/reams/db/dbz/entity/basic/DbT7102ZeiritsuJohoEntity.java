package jp.co.ndensan.reams.db.dbz.entity.basic;

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
 * DbT7102ZeiritsuJohoの項目定義クラスです
 *
 */
public class DbT7102ZeiritsuJohoEntity extends DbTableEntityBase<DbT7102ZeiritsuJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
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
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getZeiritsu
     * @return zeiritsu
     */
    public int getZeiritsu() {
        return zeiritsu;
    }

    /**
     * setZeiritsu
     * @param zeiritsu zeiritsu
     */
    public void setZeiritsu(int zeiritsu) {
        this.zeiritsu = zeiritsu;
    }

    /**
     * getZeiritsuKaishiYMD
     * @return zeiritsuKaishiYMD
     */
    public FlexibleDate getZeiritsuKaishiYMD() {
        return zeiritsuKaishiYMD;
    }

    /**
     * setZeiritsuKaishiYMD
     * @param zeiritsuKaishiYMD zeiritsuKaishiYMD
     */
    public void setZeiritsuKaishiYMD(FlexibleDate zeiritsuKaishiYMD) {
        this.zeiritsuKaishiYMD = zeiritsuKaishiYMD;
    }

    /**
     * getZeiritsuShuryoYMD
     * @return zeiritsuShuryoYMD
     */
    public FlexibleDate getZeiritsuShuryoYMD() {
        return zeiritsuShuryoYMD;
    }

    /**
     * setZeiritsuShuryoYMD
     * @param zeiritsuShuryoYMD zeiritsuShuryoYMD
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
