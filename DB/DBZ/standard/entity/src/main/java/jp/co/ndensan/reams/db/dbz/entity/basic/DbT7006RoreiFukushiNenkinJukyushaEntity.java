package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 老齢福祉年金受給者テーブルのエンティティクラスです。
 * <br/> 老齢福祉年金受給者	老齢福祉年金受給者を管理する
 */
public class DbT7006RoreiFukushiNenkinJukyushaEntity extends DbTableEntityBase<DbT7006RoreiFukushiNenkinJukyushaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7006RoreiFukushiNenkinJukyusha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private FlexibleDate jukyuKaishiYMD;
    private FlexibleDate jukyuShuryoYMD;
    private HihokenshaNo hihokenshaNo;

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
     * 識別コードのgetメソッドです。
     * <br/>
     * <br/>識別コード
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * <br/>
     * <br/>識別コード
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 受給開始年月日のgetメソッドです。
     * <br/>
     * <br/>受給開始年月日
     *
     * @return 受給開始年月日
     */
    public FlexibleDate getJukyuKaishiYMD() {
        return jukyuKaishiYMD;
    }

    /**
     * 受給開始年月日のsetメソッドです。
     * <br/>
     * <br/>受給開始年月日
     *
     * @param jukyuKaishiYMD 受給開始年月日
     */
    public void setJukyuKaishiYMD(FlexibleDate jukyuKaishiYMD) {
        this.jukyuKaishiYMD = jukyuKaishiYMD;
    }

    /**
     * 受給終了年月日のgetメソッドです。
     * <br/>
     * <br/>受給終了年月日
     *
     * @return 受給終了年月日
     */
    public FlexibleDate getJukyuShuryoYMD() {
        return jukyuShuryoYMD;
    }

    /**
     * 受給終了年月日のsetメソッドです。
     * <br/>
     * <br/>受給終了年月日
     *
     * @param jukyuShuryoYMD 受給終了年月日
     */
    public void setJukyuShuryoYMD(FlexibleDate jukyuShuryoYMD) {
        this.jukyuShuryoYMD = jukyuShuryoYMD;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * <br/>
     * <br/>被保険者番号
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * <br/>
     * <br/>被保険者番号
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7006RoreiFukushiNenkinJukyushaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7006RoreiFukushiNenkinJukyushaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7006RoreiFukushiNenkinJukyushaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.jukyuKaishiYMD, other.jukyuKaishiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7006RoreiFukushiNenkinJukyushaEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.jukyuKaishiYMD = entity.jukyuKaishiYMD;
        this.jukyuShuryoYMD = entity.jukyuShuryoYMD;
        this.hihokenshaNo = entity.hihokenshaNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, jukyuKaishiYMD, jukyuShuryoYMD, hihokenshaNo);
    }

// </editor-fold>
}
