package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * コンフィグメンテナンス制御テーブルのエンティティクラスです。
 * <br/> コンフィグメンテナンス画面で表示のみ（修正不可）のキーを管理します。
 */
public class DbT7070ConfigMaintenanceControlEntity extends DbTableEntityBase<DbT7070ConfigMaintenanceControlEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7070ConfigMaintenanceControl");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private SubGyomuCode subGyomuCode;
    @PrimaryKey
    private RString configName;
    private int hyojiJun1;
    private int hyojiJun2;
    private int hyojiJun3;

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
     * サブ業務コードのgetメソッドです。
     * 
     * @return サブ業務コード
     */
    public SubGyomuCode getSubGyomuCode() {
        return subGyomuCode;
    }

    /**
     * サブ業務コードのsetメソッドです。
     * 
     * @param subGyomuCode サブ業務コード
     */
    public void setSubGyomuCode(@Nonnull SubGyomuCode subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /**
     * コンフィグ名のgetメソッドです。
     * 
     * @return コンフィグ名
     */
    public RString getConfigName() {
        return configName;
    }

    /**
     * コンフィグ名のsetメソッドです。
     * 
     * @param configName コンフィグ名
     */
    public void setConfigName(@Nonnull RString configName) {
        this.configName = configName;
    }

    /**
     * 表示順１のgetメソッドです。
     * 
     * @return 表示順１
     */
    @CheckForNull
    public int getHyojiJun1() {
        return hyojiJun1;
    }

    /**
     * 表示順１のsetメソッドです。
     * 
     * @param hyojiJun1 表示順１
     */
    public void setHyojiJun1(int hyojiJun1) {
        this.hyojiJun1 = hyojiJun1;
    }

    /**
     * 表示順２のgetメソッドです。
     * 
     * @return 表示順２
     */
    @CheckForNull
    public int getHyojiJun2() {
        return hyojiJun2;
    }

    /**
     * 表示順２のsetメソッドです。
     * 
     * @param hyojiJun2 表示順２
     */
    public void setHyojiJun2(int hyojiJun2) {
        this.hyojiJun2 = hyojiJun2;
    }

    /**
     * 表示順３のgetメソッドです。
     * 
     * @return 表示順３
     */
    @CheckForNull
    public int getHyojiJun3() {
        return hyojiJun3;
    }

    /**
     * 表示順３のsetメソッドです。
     * 
     * @param hyojiJun3 表示順３
     */
    public void setHyojiJun3(int hyojiJun3) {
        this.hyojiJun3 = hyojiJun3;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7070ConfigMaintenanceControlEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7070ConfigMaintenanceControlEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7070ConfigMaintenanceControlEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.subGyomuCode, other.subGyomuCode)) {
            return false;
        }
        if (!Objects.equals(this.configName, other.configName)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7070ConfigMaintenanceControlEntity entity) {
        this.subGyomuCode = entity.subGyomuCode;
        this.configName = entity.configName;
        this.hyojiJun1 = entity.hyojiJun1;
        this.hyojiJun2 = entity.hyojiJun2;
        this.hyojiJun3 = entity.hyojiJun3;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(subGyomuCode, configName, hyojiJun1, hyojiJun2, hyojiJun3);
    }

// </editor-fold>
}
