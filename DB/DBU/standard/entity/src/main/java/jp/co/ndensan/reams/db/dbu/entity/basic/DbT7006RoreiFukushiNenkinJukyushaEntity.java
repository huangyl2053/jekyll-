package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;

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
    private FlexibleDate jukyuHaishiYMD;
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
     * 受給開始日のgetメソッドです。
     * <br/>
     * <br/>受給開始日
     *
     * @return 受給開始日
     */
    public FlexibleDate getJukyuKaishiYMD() {
        return jukyuKaishiYMD;
    }

    /**
     * 受給開始日のsetメソッドです。
     * <br/>
     * <br/>受給開始日
     *
     * @param jukyuKaishiYMD 受給開始日
     */
    public void setJukyuKaishiYMD(FlexibleDate jukyuKaishiYMD) {
        this.jukyuKaishiYMD = jukyuKaishiYMD;
    }

    /**
     * 受給廃止日のgetメソッドです。
     * <br/>
     * <br/>受給廃止日
     *
     * @return 受給廃止日
     */
    public FlexibleDate getJukyuHaishiYMD() {
        return jukyuHaishiYMD;
    }

    /**
     * 受給廃止日のsetメソッドです。
     * <br/>
     * <br/>受給廃止日
     *
     * @param jukyuHaishiYMD 受給廃止日
     */
    public void setJukyuHaishiYMD(FlexibleDate jukyuHaishiYMD) {
        this.jukyuHaishiYMD = jukyuHaishiYMD;
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
        this.jukyuHaishiYMD = entity.jukyuHaishiYMD;
        this.hihokenshaNo = entity.hihokenshaNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, jukyuKaishiYMD, jukyuHaishiYMD, hihokenshaNo);
    }

// </editor-fold>
}
