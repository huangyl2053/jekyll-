package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3093KyufuhiKashitsukeKinKyoseiHenkanの項目定義クラスです
 *
 */
public class DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity extends DbTableEntityBase<DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3093KyufuhiKashitsukeKinKyoseiHenkan");

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
    private RString kashitsukeKanriNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString henkanKinKubun;
    private Decimal henkanKingaku;
    private FlexibleDate henkanKigenYMD;
    private RString henkanRiyu;

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
     * getKashitsukeKanriNo
     *
     * @return kashitsukeKanriNo
     */
    public RString getKashitsukeKanriNo() {
        return kashitsukeKanriNo;
    }

    /**
     * setKashitsukeKanriNo
     *
     * @param kashitsukeKanriNo kashitsukeKanriNo
     */
    public void setKashitsukeKanriNo(RString kashitsukeKanriNo) {
        this.kashitsukeKanriNo = kashitsukeKanriNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getHenkanKinKubun
     *
     * @return henkanKinKubun
     */
    public RString getHenkanKinKubun() {
        return henkanKinKubun;
    }

    /**
     * setHenkanKinKubun
     *
     * @param henkanKinKubun henkanKinKubun
     */
    public void setHenkanKinKubun(RString henkanKinKubun) {
        this.henkanKinKubun = henkanKinKubun;
    }

    /**
     * getHenkanKingaku
     *
     * @return henkanKingaku
     */
    public Decimal getHenkanKingaku() {
        return henkanKingaku;
    }

    /**
     * setHenkanKingaku
     *
     * @param henkanKingaku henkanKingaku
     */
    public void setHenkanKingaku(Decimal henkanKingaku) {
        this.henkanKingaku = henkanKingaku;
    }

    /**
     * getHenkanKigenYMD
     *
     * @return henkanKigenYMD
     */
    public FlexibleDate getHenkanKigenYMD() {
        return henkanKigenYMD;
    }

    /**
     * setHenkanKigenYMD
     *
     * @param henkanKigenYMD henkanKigenYMD
     */
    public void setHenkanKigenYMD(FlexibleDate henkanKigenYMD) {
        this.henkanKigenYMD = henkanKigenYMD;
    }

    /**
     * getHenkanRiyu
     *
     * @return henkanRiyu
     */
    public RString getHenkanRiyu() {
        return henkanRiyu;
    }

    /**
     * setHenkanRiyu
     *
     * @param henkanRiyu henkanRiyu
     */
    public void setHenkanRiyu(RString henkanRiyu) {
        this.henkanRiyu = henkanRiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kashitsukeKanriNo, other.kashitsukeKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kashitsukeKanriNo = entity.kashitsukeKanriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.henkanKinKubun = entity.henkanKinKubun;
        this.henkanKingaku = entity.henkanKingaku;
        this.henkanKigenYMD = entity.henkanKigenYMD;
        this.henkanRiyu = entity.henkanRiyu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kashitsukeKanriNo, shoriTimestamp, henkanKinKubun, henkanKingaku, henkanKigenYMD, henkanRiyu);
    }

// </editor-fold>
}
