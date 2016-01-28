package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 合議体情報テーブルのエンティティクラスです。
 */
public class DbT5591GogitaiJohoEntity extends DbTableEntityBase<DbT5591GogitaiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5591GogitaiJoho");

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
    private RString gogitaiMei;
    @PrimaryKey
    private FlexibleDate gogitaiYukoKikanKaishiYMD;
    private FlexibleDate gogitaiYukoKikanShuryoYMD;
    private RString gogitaiKaishiYoteiTime;
    private RString gogitaiShuryoYoteiTime;
    private RString shinsakaiKaisaiBashoCode;
    private int shinsakaiYoteiTeiin;
    private int shinsakaiJidoWariateTeiin;
    private int shinsakaiIinTeiin;
    private boolean gogitaiSeishinkaSonzaiFlag;
    private boolean gogitaiDummyFlag;

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
     * 合議体名称のgetメソッドです。
     *
     * @return 合議体名称
     */
    public RString getGogitaiMei() {
        return gogitaiMei;
    }

    /**
     * 合議体名称のsetメソッドです。
     *
     * @param gogitaiMei 合議体名称
     */
    public void setGogitaiMei(@Nonnull RString gogitaiMei) {
        this.gogitaiMei = gogitaiMei;
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
     * 合議体開始予定時刻のgetメソッドです。
     *
     * @return 合議体開始予定時刻
     */
    public RString getGogitaiKaishiYoteiTime() {
        return gogitaiKaishiYoteiTime;
    }

    /**
     * 合議体開始予定時刻のsetメソッドです。
     *
     * @param gogitaiKaishiYoteiTime 合議体開始予定時刻
     */
    public void setGogitaiKaishiYoteiTime(@Nonnull RString gogitaiKaishiYoteiTime) {
        this.gogitaiKaishiYoteiTime = gogitaiKaishiYoteiTime;
    }

    /**
     * 合議体終了予定時刻のgetメソッドです。
     *
     * @return 合議体終了予定時刻
     */
    public RString getGogitaiShuryoYoteiTime() {
        return gogitaiShuryoYoteiTime;
    }

    /**
     * 合議体終了予定時刻のsetメソッドです。
     *
     * @param gogitaiShuryoYoteiTime 合議体終了予定時刻
     */
    public void setGogitaiShuryoYoteiTime(@Nonnull RString gogitaiShuryoYoteiTime) {
        this.gogitaiShuryoYoteiTime = gogitaiShuryoYoteiTime;
    }

    /**
     * 介護認定審査会開催場所コードのgetメソッドです。
     *
     * @return 介護認定審査会開催場所コード
     */
    public RString getShinsakaiKaisaiBashoCode() {
        return shinsakaiKaisaiBashoCode;
    }

    /**
     * 介護認定審査会開催場所コードのsetメソッドです。
     *
     * @param shinsakaiKaisaiBashoCode 介護認定審査会開催場所コード
     */
    public void setShinsakaiKaisaiBashoCode(@Nonnull RString shinsakaiKaisaiBashoCode) {
        this.shinsakaiKaisaiBashoCode = shinsakaiKaisaiBashoCode;
    }

    /**
     * 介護認定審査会予定定員のgetメソッドです。
     *
     * @return 介護認定審査会予定定員
     */
    public int getShinsakaiYoteiTeiin() {
        return shinsakaiYoteiTeiin;
    }

    /**
     * 介護認定審査会予定定員のsetメソッドです。
     *
     * @param shinsakaiYoteiTeiin 介護認定審査会予定定員
     */
    public void setShinsakaiYoteiTeiin(@Nonnull int shinsakaiYoteiTeiin) {
        this.shinsakaiYoteiTeiin = shinsakaiYoteiTeiin;
    }

    /**
     * 介護認定審査会自動割当定員のgetメソッドです。
     *
     * @return 介護認定審査会自動割当定員
     */
    @CheckForNull
    public int getShinsakaiJidoWariateTeiin() {
        return shinsakaiJidoWariateTeiin;
    }

    /**
     * 介護認定審査会自動割当定員のsetメソッドです。
     *
     * @param shinsakaiJidoWariateTeiin 介護認定審査会自動割当定員
     */
    public void setShinsakaiJidoWariateTeiin(int shinsakaiJidoWariateTeiin) {
        this.shinsakaiJidoWariateTeiin = shinsakaiJidoWariateTeiin;
    }

    /**
     * 介護認定審査会委員定員のgetメソッドです。
     *
     * @return 介護認定審査会委員定員
     */
    public int getShinsakaiIinTeiin() {
        return shinsakaiIinTeiin;
    }

    /**
     * 介護認定審査会委員定員のsetメソッドです。
     *
     * @param shinsakaiIinTeiin 介護認定審査会委員定員
     */
    public void setShinsakaiIinTeiin(@Nonnull int shinsakaiIinTeiin) {
        this.shinsakaiIinTeiin = shinsakaiIinTeiin;
    }

    /**
     * 合議体精神科医存在フラグのgetメソッドです。
     *
     * @return 合議体精神科医存在フラグ
     */
    @CheckForNull
    public boolean getGogitaiSeishinkaSonzaiFlag() {
        return gogitaiSeishinkaSonzaiFlag;
    }

    /**
     * 合議体精神科医存在フラグのsetメソッドです。
     *
     * @param gogitaiSeishinkaSonzaiFlag 合議体精神科医存在フラグ
     */
    public void setGogitaiSeishinkaSonzaiFlag(boolean gogitaiSeishinkaSonzaiFlag) {
        this.gogitaiSeishinkaSonzaiFlag = gogitaiSeishinkaSonzaiFlag;
    }

    /**
     * 合議体ダミーフラグのgetメソッドです。
     *
     * @return 合議体ダミーフラグ
     */
    @CheckForNull
    public boolean getGogitaiDummyFlag() {
        return gogitaiDummyFlag;
    }

    /**
     * 合議体ダミーフラグのsetメソッドです。
     *
     * @param gogitaiDummyFlag 合議体ダミーフラグ
     */
    public void setGogitaiDummyFlag(boolean gogitaiDummyFlag) {
        this.gogitaiDummyFlag = gogitaiDummyFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5591GogitaiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT5591GogitaiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5591GogitaiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (this.gogitaiNo != other.gogitaiNo) {
            return false;
        }
        if (!Objects.equals(this.gogitaiYukoKikanKaishiYMD, other.gogitaiYukoKikanKaishiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5591GogitaiJohoEntity entity) {
        this.gogitaiNo = entity.gogitaiNo;
        this.gogitaiMei = entity.gogitaiMei;
        this.gogitaiYukoKikanKaishiYMD = entity.gogitaiYukoKikanKaishiYMD;
        this.gogitaiYukoKikanShuryoYMD = entity.gogitaiYukoKikanShuryoYMD;
        this.gogitaiKaishiYoteiTime = entity.gogitaiKaishiYoteiTime;
        this.gogitaiShuryoYoteiTime = entity.gogitaiShuryoYoteiTime;
        this.shinsakaiKaisaiBashoCode = entity.shinsakaiKaisaiBashoCode;
        this.shinsakaiYoteiTeiin = entity.shinsakaiYoteiTeiin;
        this.shinsakaiJidoWariateTeiin = entity.shinsakaiJidoWariateTeiin;
        this.shinsakaiIinTeiin = entity.shinsakaiIinTeiin;
        this.gogitaiSeishinkaSonzaiFlag = entity.gogitaiSeishinkaSonzaiFlag;
        this.gogitaiDummyFlag = entity.gogitaiDummyFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(gogitaiNo, gogitaiMei, gogitaiYukoKikanKaishiYMD, gogitaiYukoKikanShuryoYMD, gogitaiKaishiYoteiTime, gogitaiShuryoYoteiTime, shinsakaiKaisaiBashoCode, shinsakaiYoteiTeiin, shinsakaiJidoWariateTeiin, shinsakaiIinTeiin, gogitaiSeishinkaSonzaiFlag, gogitaiDummyFlag);
    }

// </editor-fold>
}
