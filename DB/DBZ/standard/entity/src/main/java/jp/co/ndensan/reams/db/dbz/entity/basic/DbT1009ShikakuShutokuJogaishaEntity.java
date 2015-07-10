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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * DbT1009ShikakuShutokuJogaishaの項目定義クラスです
 *
 */
public class DbT1009ShikakuShutokuJogaishaEntity extends DbTableEntityBase<DbT1009ShikakuShutokuJogaishaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT1009ShikakuShutokuJogaisha");

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
    private RString shikakuShutokuJogaiRiyu;
    private FlexibleDate shikakuShutokuJogaiYMD;
    private FlexibleDate shikakuShutokuJogaiKaijoYMD;

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
     * getShikakuShutokuJogaiRiyu
     * @return shikakuShutokuJogaiRiyu
     */
    public RString getShikakuShutokuJogaiRiyu() {
        return shikakuShutokuJogaiRiyu;
    }

    /**
     * setShikakuShutokuJogaiRiyu
     * @param shikakuShutokuJogaiRiyu shikakuShutokuJogaiRiyu
     */
    public void setShikakuShutokuJogaiRiyu(RString shikakuShutokuJogaiRiyu) {
        this.shikakuShutokuJogaiRiyu = shikakuShutokuJogaiRiyu;
    }

    /**
     * getShikakuShutokuJogaiYMD
     * @return shikakuShutokuJogaiYMD
     */
    public FlexibleDate getShikakuShutokuJogaiYMD() {
        return shikakuShutokuJogaiYMD;
    }

    /**
     * setShikakuShutokuJogaiYMD
     * @param shikakuShutokuJogaiYMD shikakuShutokuJogaiYMD
     */
    public void setShikakuShutokuJogaiYMD(FlexibleDate shikakuShutokuJogaiYMD) {
        this.shikakuShutokuJogaiYMD = shikakuShutokuJogaiYMD;
    }

    /**
     * getShikakuShutokuJogaiKaijoYMD
     * @return shikakuShutokuJogaiKaijoYMD
     */
    public FlexibleDate getShikakuShutokuJogaiKaijoYMD() {
        return shikakuShutokuJogaiKaijoYMD;
    }

    /**
     * setShikakuShutokuJogaiKaijoYMD
     * @param shikakuShutokuJogaiKaijoYMD shikakuShutokuJogaiKaijoYMD
     */
    public void setShikakuShutokuJogaiKaijoYMD(FlexibleDate shikakuShutokuJogaiKaijoYMD) {
        this.shikakuShutokuJogaiKaijoYMD = shikakuShutokuJogaiKaijoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1009ShikakuShutokuJogaishaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1009ShikakuShutokuJogaishaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1009ShikakuShutokuJogaishaEntity other) {
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
    public void shallowCopy(DbT1009ShikakuShutokuJogaishaEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shoriTimeStamp = entity.shoriTimeStamp;
        this.shikakuShutokuJogaiRiyu = entity.shikakuShutokuJogaiRiyu;
        this.shikakuShutokuJogaiYMD = entity.shikakuShutokuJogaiYMD;
        this.shikakuShutokuJogaiKaijoYMD = entity.shikakuShutokuJogaiKaijoYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shikibetsuCode, shoriTimeStamp, shikakuShutokuJogaiRiyu, shikakuShutokuJogaiYMD, shikakuShutokuJogaiKaijoYMD);
    }

// </editor-fold>



}
