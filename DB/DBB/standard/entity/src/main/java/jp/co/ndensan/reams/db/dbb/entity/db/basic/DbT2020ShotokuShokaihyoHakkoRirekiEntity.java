package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 所得照会票発行履歴テーブルのエンティティクラスです。
 * <br/> 所得照会票の発行履歴を管理します。リアル・バッチともに対象とします。）
 */
public class DbT2020ShotokuShokaihyoHakkoRirekiEntity extends DbTableEntityBase<DbT2020ShotokuShokaihyoHakkoRirekiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT2020ShotokuShokaihyoHakkoRireki");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear shoriNendo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private int rirekiNo;
    private LasdecCode shokaisakiLasdecCode;
    private SetaiCode setaiCode;
    private RString hakkoReamsLoginId;
    private FlexibleDate hakkoYMD;
    private YMDHMS sakuseiTimestamp;

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
     * 照会年度のgetメソッドです。
     * 
     * @return 照会年度
     */
    public FlexibleYear getShoriNendo() {
        return shoriNendo;
    }

    /**
     * 照会年度のsetメソッドです。
     * 
     * @param shoriNendo 照会年度
     */
    public void setShoriNendo(@Nonnull FlexibleYear shoriNendo) {
        this.shoriNendo = shoriNendo;
    }

    /**
     * 識別コードのgetメソッドです。
     * 
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 照会先地方公共団体コードのgetメソッドです。
     * 
     * @return 照会先地方公共団体コード
     */
    @CheckForNull
    public LasdecCode getShokaisakiLasdecCode() {
        return shokaisakiLasdecCode;
    }

    /**
     * 照会先地方公共団体コードのsetメソッドです。
     * 
     * @param shokaisakiLasdecCode 照会先地方公共団体コード
     */
    public void setShokaisakiLasdecCode(LasdecCode shokaisakiLasdecCode) {
        this.shokaisakiLasdecCode = shokaisakiLasdecCode;
    }

    /**
     * 世帯コードのgetメソッドです。
     * 
     * @return 世帯コード
     */
    @CheckForNull
    public SetaiCode getSetaiCode() {
        return setaiCode;
    }

    /**
     * 世帯コードのsetメソッドです。
     * 
     * @param setaiCode 世帯コード
     */
    public void setSetaiCode(SetaiCode setaiCode) {
        this.setaiCode = setaiCode;
    }

    /**
     * 発行ユーザーIDのgetメソッドです。
     * 
     * @return 発行ユーザーID
     */
    @CheckForNull
    public RString getHakkoReamsLoginId() {
        return hakkoReamsLoginId;
    }

    /**
     * 発行ユーザーIDのsetメソッドです。
     * 
     * @param hakkoReamsLoginId 発行ユーザーID
     */
    public void setHakkoReamsLoginId(RString hakkoReamsLoginId) {
        this.hakkoReamsLoginId = hakkoReamsLoginId;
    }

    /**
     * 発行日のgetメソッドです。
     * 
     * @return 発行日
     */
    @CheckForNull
    public FlexibleDate getHakkoYMD() {
        return hakkoYMD;
    }

    /**
     * 発行日のsetメソッドです。
     * 
     * @param hakkoYMD 発行日
     */
    public void setHakkoYMD(FlexibleDate hakkoYMD) {
        this.hakkoYMD = hakkoYMD;
    }

    /**
     * 作成日時のgetメソッドです。
     * 
     * @return 作成日時
     */
    @CheckForNull
    public YMDHMS getSakuseiTimestamp() {
        return sakuseiTimestamp;
    }

    /**
     * 作成日時のsetメソッドです。
     * 
     * @param sakuseiTimestamp 作成日時
     */
    public void setSakuseiTimestamp(YMDHMS sakuseiTimestamp) {
        this.sakuseiTimestamp = sakuseiTimestamp;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2020ShotokuShokaihyoHakkoRirekiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2020ShotokuShokaihyoHakkoRirekiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2020ShotokuShokaihyoHakkoRirekiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoriNendo, other.shoriNendo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT2020ShotokuShokaihyoHakkoRirekiEntity entity) {
        this.shoriNendo = entity.shoriNendo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.shokaisakiLasdecCode = entity.shokaisakiLasdecCode;
        this.setaiCode = entity.setaiCode;
        this.hakkoReamsLoginId = entity.hakkoReamsLoginId;
        this.hakkoYMD = entity.hakkoYMD;
        this.sakuseiTimestamp = entity.sakuseiTimestamp;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoriNendo, shikibetsuCode, rirekiNo, shokaisakiLasdecCode, setaiCode, hakkoReamsLoginId, hakkoYMD, sakuseiTimestamp);
    }

// </editor-fold>
}
