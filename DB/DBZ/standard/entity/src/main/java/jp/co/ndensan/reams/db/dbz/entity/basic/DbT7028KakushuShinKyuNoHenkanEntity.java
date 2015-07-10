package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7028KakushuShinKyuNoHenkanの項目定義クラスです
 *
 */
public class DbT7028KakushuShinKyuNoHenkanEntity extends DbTableEntityBase<DbT7028KakushuShinKyuNoHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7028KakushuShinKyuNoHenkan");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString noKubun;
    private RString shinNo;
    @PrimaryKey
    private RString kyuNo;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getNoKubun
     *
     * @return noKubun
     */
    public RString getNoKubun() {
        return noKubun;
    }

    /**
     * setNoKubun
     *
     * @param noKubun noKubun
     */
    public void setNoKubun(RString noKubun) {
        this.noKubun = noKubun;
    }

    /**
     * getShinNo
     *
     * @return shinNo
     */
    public RString getShinNo() {
        return shinNo;
    }

    /**
     * setShinNo
     *
     * @param shinNo shinNo
     */
    public void setShinNo(RString shinNo) {
        this.shinNo = shinNo;
    }

    /**
     * getKyuNo
     *
     * @return kyuNo
     */
    public RString getKyuNo() {
        return kyuNo;
    }

    /**
     * setKyuNo
     *
     * @param kyuNo kyuNo
     */
    public void setKyuNo(RString kyuNo) {
        this.kyuNo = kyuNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7028KakushuShinKyuNoHenkanEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7028KakushuShinKyuNoHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7028KakushuShinKyuNoHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.noKubun, other.noKubun)) {
            return false;
        }
        if (!Objects.equals(this.kyuNo, other.kyuNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7028KakushuShinKyuNoHenkanEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.noKubun = entity.noKubun;
        this.shinNo = entity.shinNo;
        this.kyuNo = entity.kyuNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, noKubun, shinNo, kyuNo);
    }

// </editor-fold>
}
