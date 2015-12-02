package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 地区市町村テーブルのエンティティクラスです。
 */
public class DbT5224ChikuShichosonEntity extends DbTableEntityBase<DbT5224ChikuShichosonEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5224ChikuShichoson");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private Code chosaChikuCode;
    @PrimaryKey
    private LasdecCode shichosonCode;
    private int yusenNo;
    private boolean jiChikuFlag;

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
     * 調査地区コードのgetメソッドです。
     * <br/>
     * <br/>Code（DBE：5002）
     * 
     * @return 調査地区コード
     */
    public Code getChosaChikuCode() {
        return chosaChikuCode;
    }

    /**
     * 調査地区コードのsetメソッドです。
     * <br/>
     * <br/>Code（DBE：5002）
     * 
     * @param chosaChikuCode 調査地区コード
     */
    public void setChosaChikuCode(@Nonnull Code chosaChikuCode) {
        this.chosaChikuCode = chosaChikuCode;
    }

    /**
     * 市町村コードのgetメソッドです。
     * 
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     * 
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(@Nonnull LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 優先番号のgetメソッドです。
     * 
     * @return 優先番号
     */
    public int getYusenNo() {
        return yusenNo;
    }

    /**
     * 優先番号のsetメソッドです。
     * 
     * @param yusenNo 優先番号
     */
    public void setYusenNo(@Nonnull int yusenNo) {
        this.yusenNo = yusenNo;
    }

    /**
     * 自地区フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：自地区フラグ）
     * 
     * @return 自地区フラグ
     */
    public boolean getJiChikuFlag() {
        return jiChikuFlag;
    }

    /**
     * 自地区フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：自地区フラグ）
     * 
     * @param jiChikuFlag 自地区フラグ
     */
    public void setJiChikuFlag(@Nonnull boolean jiChikuFlag) {
        this.jiChikuFlag = jiChikuFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5224ChikuShichosonEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5224ChikuShichosonEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5224ChikuShichosonEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.chosaChikuCode, other.chosaChikuCode)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5224ChikuShichosonEntity entity) {
        this.chosaChikuCode = entity.chosaChikuCode;
        this.shichosonCode = entity.shichosonCode;
        this.yusenNo = entity.yusenNo;
        this.jiChikuFlag = entity.jiChikuFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(chosaChikuCode, shichosonCode, yusenNo, jiChikuFlag);
    }

// </editor-fold>
}
