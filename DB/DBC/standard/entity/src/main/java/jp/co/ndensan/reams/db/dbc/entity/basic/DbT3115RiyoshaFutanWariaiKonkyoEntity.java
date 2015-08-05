package jp.co.ndensan.reams.db.dbc.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 利用者負担割合世帯員テーブルのエンティティクラスです。
 * <br/> 利用者負担割合を決定する根拠となる世帯員を管理します。
 */
public class DbT3115RiyoshaFutanWariaiKonkyoEntity extends DbTableEntityBase<DbT3115RiyoshaFutanWariaiKonkyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3115RiyoshaFutanWariaiKonkyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear nendo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    @PrimaryKey
    private int edaNo;
    @PrimaryKey
    private HihokenshaNo setaiinHihokenshaNo;
    private int setaiinShotokuRirekiNo;

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
     * 年度のgetメソッドです。
     *
     * @return 年度
     */
    public FlexibleYear getNendo() {
        return nendo;
    }

    /**
     * 年度のsetメソッドです。
     *
     * @param nendo 年度
     */
    public void setNendo(FlexibleYear nendo) {
        this.nendo = nendo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 枝番号のgetメソッドです。
     *
     * @return 枝番号
     */
    public int getEdaNo() {
        return edaNo;
    }

    /**
     * 枝番号のsetメソッドです。
     *
     * @param edaNo 枝番号
     */
    public void setEdaNo(int edaNo) {
        this.edaNo = edaNo;
    }

    /**
     * 世帯員被保険者番号のgetメソッドです。
     *
     * @return 世帯員被保険者番号
     */
    public HihokenshaNo getSetaiinHihokenshaNo() {
        return setaiinHihokenshaNo;
    }

    /**
     * 世帯員被保険者番号のsetメソッドです。
     *
     * @param setaiinHihokenshaNo 世帯員被保険者番号
     */
    public void setSetaiinHihokenshaNo(HihokenshaNo setaiinHihokenshaNo) {
        this.setaiinHihokenshaNo = setaiinHihokenshaNo;
    }

    /**
     * 世帯員所得履歴番号のgetメソッドです。
     *
     * @return 世帯員所得履歴番号
     */
    public int getSetaiinShotokuRirekiNo() {
        return setaiinShotokuRirekiNo;
    }

    /**
     * 世帯員所得履歴番号のsetメソッドです。
     *
     * @param setaiinShotokuRirekiNo 世帯員所得履歴番号
     */
    public void setSetaiinShotokuRirekiNo(int setaiinShotokuRirekiNo) {
        this.setaiinShotokuRirekiNo = setaiinShotokuRirekiNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3115RiyoshaFutanWariaiKonkyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3115RiyoshaFutanWariaiKonkyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3115RiyoshaFutanWariaiKonkyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.nendo, other.nendo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        if (this.edaNo != other.edaNo) {
            return false;
        }
        if (!Objects.equals(this.setaiinHihokenshaNo, other.setaiinHihokenshaNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3115RiyoshaFutanWariaiKonkyoEntity entity) {
        this.nendo = entity.nendo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.edaNo = entity.edaNo;
        this.setaiinHihokenshaNo = entity.setaiinHihokenshaNo;
        this.setaiinShotokuRirekiNo = entity.setaiinShotokuRirekiNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(nendo, hihokenshaNo, rirekiNo, edaNo, setaiinHihokenshaNo, setaiinShotokuRirekiNo);
    }

// </editor-fold>
}
