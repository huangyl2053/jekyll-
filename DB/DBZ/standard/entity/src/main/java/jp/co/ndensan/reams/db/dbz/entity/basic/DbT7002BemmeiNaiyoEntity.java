package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7002BemmeiNaiyoの項目定義クラスです
 *
 */
public class DbT7002BemmeiNaiyoEntity extends DbTableEntityBase<DbT7002BemmeiNaiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7002BemmeiNaiyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private HihokenshaNo genshobunHihokenshaNo;
    @PrimaryKey
    private FlexibleDate shinsaseikyuTodokedeYMD;
    @PrimaryKey
    private FlexibleDate bemmeishoSakuseiYMD;
    private RString shinsaseikyuKankeiShobunNaiyo;
    private RString bemmeiNaiyo;
    private FlexibleDate bemmeishoSakuseiTeishutsuYMD;

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
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getGenshobunHihokenshaNo
     *
     * @return genshobunHihokenshaNo
     */
    public HihokenshaNo getGenshobunHihokenshaNo() {
        return genshobunHihokenshaNo;
    }

    /**
     * setGenshobunHihokenshaNo
     *
     * @param genshobunHihokenshaNo genshobunHihokenshaNo
     */
    public void setGenshobunHihokenshaNo(HihokenshaNo genshobunHihokenshaNo) {
        this.genshobunHihokenshaNo = genshobunHihokenshaNo;
    }

    /**
     * getShinsaseikyuTodokedeYMD
     *
     * @return shinsaseikyuTodokedeYMD
     */
    public FlexibleDate getShinsaseikyuTodokedeYMD() {
        return shinsaseikyuTodokedeYMD;
    }

    /**
     * setShinsaseikyuTodokedeYMD
     *
     * @param shinsaseikyuTodokedeYMD shinsaseikyuTodokedeYMD
     */
    public void setShinsaseikyuTodokedeYMD(FlexibleDate shinsaseikyuTodokedeYMD) {
        this.shinsaseikyuTodokedeYMD = shinsaseikyuTodokedeYMD;
    }

    /**
     * getBemmeishoSakuseiYMD
     *
     * @return bemmeishoSakuseiYMD
     */
    public FlexibleDate getBemmeishoSakuseiYMD() {
        return bemmeishoSakuseiYMD;
    }

    /**
     * setBemmeishoSakuseiYMD
     *
     * @param bemmeishoSakuseiYMD bemmeishoSakuseiYMD
     */
    public void setBemmeishoSakuseiYMD(FlexibleDate bemmeishoSakuseiYMD) {
        this.bemmeishoSakuseiYMD = bemmeishoSakuseiYMD;
    }

    /**
     * getShinsaseikyuKankeiShobunNaiyo
     *
     * @return shinsaseikyuKankeiShobunNaiyo
     */
    public RString getShinsaseikyuKankeiShobunNaiyo() {
        return shinsaseikyuKankeiShobunNaiyo;
    }

    /**
     * setShinsaseikyuKankeiShobunNaiyo
     *
     * @param shinsaseikyuKankeiShobunNaiyo shinsaseikyuKankeiShobunNaiyo
     */
    public void setShinsaseikyuKankeiShobunNaiyo(RString shinsaseikyuKankeiShobunNaiyo) {
        this.shinsaseikyuKankeiShobunNaiyo = shinsaseikyuKankeiShobunNaiyo;
    }

    /**
     * getBemmeiNaiyo
     *
     * @return bemmeiNaiyo
     */
    public RString getBemmeiNaiyo() {
        return bemmeiNaiyo;
    }

    /**
     * setBemmeiNaiyo
     *
     * @param bemmeiNaiyo bemmeiNaiyo
     */
    public void setBemmeiNaiyo(RString bemmeiNaiyo) {
        this.bemmeiNaiyo = bemmeiNaiyo;
    }

    /**
     * getBemmeishoSakuseiTeishutsuYMD
     *
     * @return bemmeishoSakuseiTeishutsuYMD
     */
    public FlexibleDate getBemmeishoSakuseiTeishutsuYMD() {
        return bemmeishoSakuseiTeishutsuYMD;
    }

    /**
     * setBemmeishoSakuseiTeishutsuYMD
     *
     * @param bemmeishoSakuseiTeishutsuYMD bemmeishoSakuseiTeishutsuYMD
     */
    public void setBemmeishoSakuseiTeishutsuYMD(FlexibleDate bemmeishoSakuseiTeishutsuYMD) {
        this.bemmeishoSakuseiTeishutsuYMD = bemmeishoSakuseiTeishutsuYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7002BemmeiNaiyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT7002BemmeiNaiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7002BemmeiNaiyoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.genshobunHihokenshaNo, other.genshobunHihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shinsaseikyuTodokedeYMD, other.shinsaseikyuTodokedeYMD)) {
            return false;
        }
        if (!Objects.equals(this.bemmeishoSakuseiYMD, other.bemmeishoSakuseiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7002BemmeiNaiyoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.genshobunHihokenshaNo = entity.genshobunHihokenshaNo;
        this.shinsaseikyuTodokedeYMD = entity.shinsaseikyuTodokedeYMD;
        this.bemmeishoSakuseiYMD = entity.bemmeishoSakuseiYMD;
        this.shinsaseikyuKankeiShobunNaiyo = entity.shinsaseikyuKankeiShobunNaiyo;
        this.bemmeiNaiyo = entity.bemmeiNaiyo;
        this.bemmeishoSakuseiTeishutsuYMD = entity.bemmeishoSakuseiTeishutsuYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, shikibetsuCode, genshobunHihokenshaNo, shinsaseikyuTodokedeYMD, bemmeishoSakuseiYMD, shinsaseikyuKankeiShobunNaiyo, bemmeiNaiyo, bemmeishoSakuseiTeishutsuYMD);
    }

// </editor-fold>
}
