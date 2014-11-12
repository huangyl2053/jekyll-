package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3094JutakuKaishuRiyushoTesuryoKetteiの項目定義クラスです
 *
 */
public class DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity extends DbTableEntityBase<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3094JutakuKaishuRiyushoTesuryoKettei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo riyushoSakuseiJigyoshaNo;
    @PrimaryKey
    private FlexibleDate ketteiYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate shikyu_FushikyuKetteiYMD;
    private RString shikyu_FushikyuKubun;
    private RString fushikyuRiyu;
    private FlexibleDate tesuryoShiharaiYoteiYMD;

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
     * getRiyushoSakuseiJigyoshaNo
     *
     * @return riyushoSakuseiJigyoshaNo
     */
    public HihokenshaNo getRiyushoSakuseiJigyoshaNo() {
        return riyushoSakuseiJigyoshaNo;
    }

    /**
     * setRiyushoSakuseiJigyoshaNo
     *
     * @param riyushoSakuseiJigyoshaNo riyushoSakuseiJigyoshaNo
     */
    public void setRiyushoSakuseiJigyoshaNo(HihokenshaNo riyushoSakuseiJigyoshaNo) {
        this.riyushoSakuseiJigyoshaNo = riyushoSakuseiJigyoshaNo;
    }

    /**
     * getKetteiYMD
     *
     * @return ketteiYMD
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * setKetteiYMD
     *
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
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
     * getShikyu_FushikyuKetteiYMD
     *
     * @return shikyu_FushikyuKetteiYMD
     */
    public FlexibleDate getShikyu_FushikyuKetteiYMD() {
        return shikyu_FushikyuKetteiYMD;
    }

    /**
     * setShikyu_FushikyuKetteiYMD
     *
     * @param shikyu_FushikyuKetteiYMD shikyu_FushikyuKetteiYMD
     */
    public void setShikyu_FushikyuKetteiYMD(FlexibleDate shikyu_FushikyuKetteiYMD) {
        this.shikyu_FushikyuKetteiYMD = shikyu_FushikyuKetteiYMD;
    }

    /**
     * getShikyu_FushikyuKubun
     *
     * @return shikyu_FushikyuKubun
     */
    public RString getShikyu_FushikyuKubun() {
        return shikyu_FushikyuKubun;
    }

    /**
     * setShikyu_FushikyuKubun
     *
     * @param shikyu_FushikyuKubun shikyu_FushikyuKubun
     */
    public void setShikyu_FushikyuKubun(RString shikyu_FushikyuKubun) {
        this.shikyu_FushikyuKubun = shikyu_FushikyuKubun;
    }

    /**
     * getFushikyuRiyu
     *
     * @return fushikyuRiyu
     */
    public RString getFushikyuRiyu() {
        return fushikyuRiyu;
    }

    /**
     * setFushikyuRiyu
     *
     * @param fushikyuRiyu fushikyuRiyu
     */
    public void setFushikyuRiyu(RString fushikyuRiyu) {
        this.fushikyuRiyu = fushikyuRiyu;
    }

    /**
     * getTesuryoShiharaiYoteiYMD
     *
     * @return tesuryoShiharaiYoteiYMD
     */
    public FlexibleDate getTesuryoShiharaiYoteiYMD() {
        return tesuryoShiharaiYoteiYMD;
    }

    /**
     * setTesuryoShiharaiYoteiYMD
     *
     * @param tesuryoShiharaiYoteiYMD tesuryoShiharaiYoteiYMD
     */
    public void setTesuryoShiharaiYoteiYMD(FlexibleDate tesuryoShiharaiYoteiYMD) {
        this.tesuryoShiharaiYoteiYMD = tesuryoShiharaiYoteiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.riyushoSakuseiJigyoshaNo, other.riyushoSakuseiJigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.ketteiYMD, other.ketteiYMD)) {
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
    public void shallowCopy(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        this.riyushoSakuseiJigyoshaNo = entity.riyushoSakuseiJigyoshaNo;
        this.ketteiYMD = entity.ketteiYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shikyu_FushikyuKetteiYMD = entity.shikyu_FushikyuKetteiYMD;
        this.shikyu_FushikyuKubun = entity.shikyu_FushikyuKubun;
        this.fushikyuRiyu = entity.fushikyuRiyu;
        this.tesuryoShiharaiYoteiYMD = entity.tesuryoShiharaiYoteiYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(riyushoSakuseiJigyoshaNo, ketteiYMD, shoriTimestamp, shikyu_FushikyuKetteiYMD, shikyu_FushikyuKubun, fushikyuRiyu, tesuryoShiharaiYoteiYMD);
    }

// </editor-fold>
}
