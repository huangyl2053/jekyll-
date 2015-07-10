package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import java.util.Objects;

/**
 * DbT7105KaigoninteiJukyuFlagの項目定義クラスです
 *
 */
public class DbT7105KaigoninteiJukyuFlagEntity extends DbTableEntityBase<DbT7105KaigoninteiJukyuFlagEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7105KaigoninteiJukyuFlag");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private boolean kihonJokyoFlag;
    private boolean mobileDataFlag;
    private boolean ninteiJohoTeikyoKiboAriFlag;
    private boolean shinsakaiShinsajunKakuteiFlag;
    private boolean gogitaiDummyFlag;
    private boolean gogitaiSeishinkaiFlag;
    private boolean shinsakaiKyukaiFlag;

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
     * getKihonJokyoFlag
     * @return kihonJokyoFlag
     */
    public boolean getKihonJokyoFlag() {
        return kihonJokyoFlag;
    }

    /**
     * setKihonJokyoFlag
     * @param kihonJokyoFlag kihonJokyoFlag
     */
    public void setKihonJokyoFlag(boolean kihonJokyoFlag) {
        this.kihonJokyoFlag = kihonJokyoFlag;
    }

    /**
     * getMobileDataFlag
     * @return mobileDataFlag
     */
    public boolean getMobileDataFlag() {
        return mobileDataFlag;
    }

    /**
     * setMobileDataFlag
     * @param mobileDataFlag mobileDataFlag
     */
    public void setMobileDataFlag(boolean mobileDataFlag) {
        this.mobileDataFlag = mobileDataFlag;
    }

    /**
     * getNinteiJohoTeikyoKiboAriFlag
     * @return ninteiJohoTeikyoKiboAriFlag
     */
    public boolean getNinteiJohoTeikyoKiboAriFlag() {
        return ninteiJohoTeikyoKiboAriFlag;
    }

    /**
     * setNinteiJohoTeikyoKiboAriFlag
     * @param ninteiJohoTeikyoKiboAriFlag ninteiJohoTeikyoKiboAriFlag
     */
    public void setNinteiJohoTeikyoKiboAriFlag(boolean ninteiJohoTeikyoKiboAriFlag) {
        this.ninteiJohoTeikyoKiboAriFlag = ninteiJohoTeikyoKiboAriFlag;
    }

    /**
     * getShinsakaiShinsajunKakuteiFlag
     * @return shinsakaiShinsajunKakuteiFlag
     */
    public boolean getShinsakaiShinsajunKakuteiFlag() {
        return shinsakaiShinsajunKakuteiFlag;
    }

    /**
     * setShinsakaiShinsajunKakuteiFlag
     * @param shinsakaiShinsajunKakuteiFlag shinsakaiShinsajunKakuteiFlag
     */
    public void setShinsakaiShinsajunKakuteiFlag(boolean shinsakaiShinsajunKakuteiFlag) {
        this.shinsakaiShinsajunKakuteiFlag = shinsakaiShinsajunKakuteiFlag;
    }

    /**
     * getGogitaiDummyFlag
     * @return gogitaiDummyFlag
     */
    public boolean getGogitaiDummyFlag() {
        return gogitaiDummyFlag;
    }

    /**
     * setGogitaiDummyFlag
     * @param gogitaiDummyFlag gogitaiDummyFlag
     */
    public void setGogitaiDummyFlag(boolean gogitaiDummyFlag) {
        this.gogitaiDummyFlag = gogitaiDummyFlag;
    }

    /**
     * getGogitaiSeishinkaiFlag
     * @return gogitaiSeishinkaiFlag
     */
    public boolean getGogitaiSeishinkaiFlag() {
        return gogitaiSeishinkaiFlag;
    }

    /**
     * setGogitaiSeishinkaiFlag
     * @param gogitaiSeishinkaiFlag gogitaiSeishinkaiFlag
     */
    public void setGogitaiSeishinkaiFlag(boolean gogitaiSeishinkaiFlag) {
        this.gogitaiSeishinkaiFlag = gogitaiSeishinkaiFlag;
    }

    /**
     * getShinsakaiKyukaiFlag
     * @return shinsakaiKyukaiFlag
     */
    public boolean getShinsakaiKyukaiFlag() {
        return shinsakaiKyukaiFlag;
    }

    /**
     * setShinsakaiKyukaiFlag
     * @param shinsakaiKyukaiFlag shinsakaiKyukaiFlag
     */
    public void setShinsakaiKyukaiFlag(boolean shinsakaiKyukaiFlag) {
        this.shinsakaiKyukaiFlag = shinsakaiKyukaiFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7105KaigoninteiJukyuFlagEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7105KaigoninteiJukyuFlagEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7105KaigoninteiJukyuFlagEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7105KaigoninteiJukyuFlagEntity entity) {
        this.kihonJokyoFlag = entity.kihonJokyoFlag;
        this.mobileDataFlag = entity.mobileDataFlag;
        this.ninteiJohoTeikyoKiboAriFlag = entity.ninteiJohoTeikyoKiboAriFlag;
        this.shinsakaiShinsajunKakuteiFlag = entity.shinsakaiShinsajunKakuteiFlag;
        this.gogitaiDummyFlag = entity.gogitaiDummyFlag;
        this.gogitaiSeishinkaiFlag = entity.gogitaiSeishinkaiFlag;
        this.shinsakaiKyukaiFlag = entity.shinsakaiKyukaiFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kihonJokyoFlag, mobileDataFlag, ninteiJohoTeikyoKiboAriFlag, shinsakaiShinsajunKakuteiFlag, gogitaiDummyFlag, gogitaiSeishinkaiFlag, shinsakaiKyukaiFlag);
    }

// </editor-fold>

}
