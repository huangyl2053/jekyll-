package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 合議体割当委員情報テーブルのエンティティクラスです。
 */
public class DbT5593GogitaiWariateIinJohoEntity extends DbTableEntityBase<DbT5593GogitaiWariateIinJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5593GogitaiWariateIinJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private int gogitaiNo;
    @PrimaryKey
    private FlexibleDate gogitaiYukoKikanKaishiYMD;
    private FlexibleDate gogitaiYukoKikanShuryoYMD;
    @PrimaryKey
    private RString shinsakaiIinCode;
    private Code gogitaichoKubunCode;
    private boolean substituteFlag;

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
     * 合議体番号のgetメソッドです。
     *
     * @return 合議体番号
     */
    public int getGogitaiNo() {
        return gogitaiNo;
    }

    /**
     * 合議体番号のsetメソッドです。
     *
     * @param gogitaiNo 合議体番号
     */
    public void setGogitaiNo(@Nonnull int gogitaiNo) {
        this.gogitaiNo = gogitaiNo;
    }

    /**
     * 合議体有効期間開始年月日のgetメソッドです。
     *
     * @return 合議体有効期間開始年月日
     */
    public FlexibleDate getGogitaiYukoKikanKaishiYMD() {
        return gogitaiYukoKikanKaishiYMD;
    }

    /**
     * 合議体有効期間開始年月日のsetメソッドです。
     *
     * @param gogitaiYukoKikanKaishiYMD 合議体有効期間開始年月日
     */
    public void setGogitaiYukoKikanKaishiYMD(@Nonnull FlexibleDate gogitaiYukoKikanKaishiYMD) {
        this.gogitaiYukoKikanKaishiYMD = gogitaiYukoKikanKaishiYMD;
    }

    /**
     * 合議体有効期間終了年月日のgetメソッドです。
     *
     * @return 合議体有効期間終了年月日
     */
    public FlexibleDate getGogitaiYukoKikanShuryoYMD() {
        return gogitaiYukoKikanShuryoYMD;
    }

    /**
     * 合議体有効期間終了年月日のsetメソッドです。
     *
     * @param gogitaiYukoKikanShuryoYMD 合議体有効期間終了年月日
     */
    public void setGogitaiYukoKikanShuryoYMD(@Nonnull FlexibleDate gogitaiYukoKikanShuryoYMD) {
        this.gogitaiYukoKikanShuryoYMD = gogitaiYukoKikanShuryoYMD;
    }

    /**
     * 介護認定審査会委員コードのgetメソッドです。
     *
     * @return 介護認定審査会委員コード
     */
    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    /**
     * 介護認定審査会委員コードのsetメソッドです。
     *
     * @param shinsakaiIinCode 介護認定審査会委員コード
     */
    public void setShinsakaiIinCode(@Nonnull RString shinsakaiIinCode) {
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    /**
     * 合議体長区分コードのgetメソッドです。
     *
     * @return 合議体長区分コード
     */
    @CheckForNull
    public Code getGogitaichoKubunCode() {
        return gogitaichoKubunCode;
    }

    /**
     * 合議体長区分コードのsetメソッドです。
     *
     * @param gogitaichoKubunCode 合議体長区分コード
     */
    public void setGogitaichoKubunCode(Code gogitaichoKubunCode) {
        this.gogitaichoKubunCode = gogitaichoKubunCode;
    }

    /**
     * 補欠のgetメソッドです。
     *
     * @return 補欠
     */
    @CheckForNull
    public boolean getSubstituteFlag() {
        return substituteFlag;
    }

    /**
     * 補欠のsetメソッドです。
     *
     * @param substituteFlag 補欠
     */
    public void setSubstituteFlag(boolean substituteFlag) {
        this.substituteFlag = substituteFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5593GogitaiWariateIinJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5593GogitaiWariateIinJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5593GogitaiWariateIinJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (this.gogitaiNo != other.gogitaiNo) {
            return false;
        }
        if (!Objects.equals(this.gogitaiYukoKikanKaishiYMD, other.gogitaiYukoKikanKaishiYMD)) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiIinCode, other.shinsakaiIinCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT5593GogitaiWariateIinJohoEntity entity) {
        this.gogitaiNo = entity.gogitaiNo;
        this.gogitaiYukoKikanKaishiYMD = entity.gogitaiYukoKikanKaishiYMD;
        this.gogitaiYukoKikanShuryoYMD = entity.gogitaiYukoKikanShuryoYMD;
        this.shinsakaiIinCode = entity.shinsakaiIinCode;
        this.gogitaichoKubunCode = entity.gogitaichoKubunCode;
        this.substituteFlag = entity.substituteFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(gogitaiNo, gogitaiYukoKikanKaishiYMD, gogitaiYukoKikanShuryoYMD, shinsakaiIinCode, gogitaichoKubunCode, substituteFlag);
    }

// </editor-fold>
}
