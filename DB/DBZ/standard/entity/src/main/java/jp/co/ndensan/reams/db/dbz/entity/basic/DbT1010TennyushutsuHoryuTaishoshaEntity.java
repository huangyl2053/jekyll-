package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;

/**
 * DbT1010TennyushutsuHoryuTaishoshaの項目定義クラスです
 *
 */
public class DbT1010TennyushutsuHoryuTaishoshaEntity extends DbTableEntityBase<DbT1010TennyushutsuHoryuTaishoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT1010TennyushutsuHoryuTaishosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private YMDHMS shoriTimeStamp;

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
     * getShichosonCode
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getShikibetsuCode
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getShoriTimeStamp
     * @return shoriTimeStamp
     */
    public YMDHMS getShoriTimeStamp() {
        return shoriTimeStamp;
    }

    /**
     * setShoriTimeStamp
     * @param shoriTimeStamp shoriTimeStamp
     */
    public void setShoriTimeStamp(YMDHMS shoriTimeStamp) {
        this.shoriTimeStamp = shoriTimeStamp;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1010TennyushutsuHoryuTaishoshaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1010TennyushutsuHoryuTaishoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1010TennyushutsuHoryuTaishoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimeStamp, other.shoriTimeStamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1010TennyushutsuHoryuTaishoshaEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shoriTimeStamp = entity.shoriTimeStamp;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shikibetsuCode, shoriTimeStamp);
    }

// </editor-fold>



}
