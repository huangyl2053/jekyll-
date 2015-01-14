package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu.HokenryoGemmenShurui;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu.HokenryoGemmenTorikeshiShurui;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT2004Gemmenの項目定義クラスです
 *
 */
public class DbT2004GemmenEntity extends DbTableEntityBase<DbT2004GemmenEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2004Gemmen");

    private RString insertDantaiCd;
    @PrimaryKey
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear choteiNendo;
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @PrimaryKey
    private RDateTime shoriTimestamp;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate torikeshiYMD;
    private RString jotaiKubun;
    private RString sakuseiKubun;
    private RString shinseiJiyu;
    private HokenryoGemmenShurui gemmenShuruiCode;
    private RString gemmenJiyu;
    private HokenryoGemmenTorikeshiShurui gemmenTorikeshiShuruiCode;
    private RString gemmenTorikeshiJiyu;
    private Decimal shinseiGemmenGaku;
    private Decimal ketteiGemmenGaku;
    private Decimal torikeshiGemmenGaku;

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
     * getChoteiNendo
     *
     * @return choteiNendo
     */
    public FlexibleYear getChoteiNendo() {
        return choteiNendo;
    }

    /**
     * setChoteiNendo
     *
     * @param choteiNendo choteiNendo
     */
    public void setChoteiNendo(FlexibleYear choteiNendo) {
        this.choteiNendo = choteiNendo;
    }

    /**
     * getFukaNendo
     *
     * @return fukaNendo
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * setFukaNendo
     *
     * @param fukaNendo fukaNendo
     */
    public void setFukaNendo(FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * getTsuchishoNo
     *
     * @return tsuchishoNo
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * setTsuchishoNo
     *
     * @param tsuchishoNo tsuchishoNo
     */
    public void setTsuchishoNo(TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public RDateTime getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(RDateTime shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getShinseiYMD
     *
     * @return shinseiYMD
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * setShinseiYMD
     *
     * @param shinseiYMD shinseiYMD
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
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
     * getTorikeshiYMD
     *
     * @return torikeshiYMD
     */
    public FlexibleDate getTorikeshiYMD() {
        return torikeshiYMD;
    }

    /**
     * setTorikeshiYMD
     *
     * @param torikeshiYMD torikeshiYMD
     */
    public void setTorikeshiYMD(FlexibleDate torikeshiYMD) {
        this.torikeshiYMD = torikeshiYMD;
    }

    /**
     * getJotaiKubun
     *
     * @return jotaiKubun
     */
    public RString getJotaiKubun() {
        return jotaiKubun;
    }

    /**
     * setJotaiKubun
     *
     * @param jotaiKubun jotaiKubun
     */
    public void setJotaiKubun(RString jotaiKubun) {
        this.jotaiKubun = jotaiKubun;
    }

    /**
     * getSakuseiKubun
     *
     * @return sakuseiKubun
     */
    public RString getSakuseiKubun() {
        return sakuseiKubun;
    }

    /**
     * setSakuseiKubun
     *
     * @param sakuseiKubun sakuseiKubun
     */
    public void setSakuseiKubun(RString sakuseiKubun) {
        this.sakuseiKubun = sakuseiKubun;
    }

    /**
     * getShinseiJiyu
     *
     * @return shinseiJiyu
     */
    public RString getShinseiJiyu() {
        return shinseiJiyu;
    }

    /**
     * setShinseiJiyu
     *
     * @param shinseiJiyu shinseiJiyu
     */
    public void setShinseiJiyu(RString shinseiJiyu) {
        this.shinseiJiyu = shinseiJiyu;
    }

    /**
     * getGemmenShuruiCode
     *
     * @return gemmenShuruiCode
     */
    public HokenryoGemmenShurui getGemmenShuruiCode() {
        return gemmenShuruiCode;
    }

    /**
     * setGemmenShuruiCode
     *
     * @param gemmenShuruiCode gemmenShuruiCode
     */
    public void setGemmenShuruiCode(HokenryoGemmenShurui gemmenShuruiCode) {
        this.gemmenShuruiCode = gemmenShuruiCode;
    }

    /**
     * getGemmenJiyu
     *
     * @return gemmenJiyu
     */
    public RString getGemmenJiyu() {
        return gemmenJiyu;
    }

    /**
     * setGemmenJiyu
     *
     * @param gemmenJiyu gemmenJiyu
     */
    public void setGemmenJiyu(RString gemmenJiyu) {
        this.gemmenJiyu = gemmenJiyu;
    }

    /**
     * getGemmenTorikeshiShuruiCode
     *
     * @return gemmenTorikeshiShuruiCode
     */
    public HokenryoGemmenTorikeshiShurui getGemmenTorikeshiShuruiCode() {
        return gemmenTorikeshiShuruiCode;
    }

    /**
     * setGemmenTorikeshiShuruiCode
     *
     * @param gemmenTorikeshiShuruiCode gemmenTorikeshiShuruiCode
     */
    public void setGemmenTorikeshiShuruiCode(HokenryoGemmenTorikeshiShurui gemmenTorikeshiShuruiCode) {
        this.gemmenTorikeshiShuruiCode = gemmenTorikeshiShuruiCode;
    }

    /**
     * getGemmenTorikeshiJiyu
     *
     * @return gemmenTorikeshiJiyu
     */
    public RString getGemmenTorikeshiJiyu() {
        return gemmenTorikeshiJiyu;
    }

    /**
     * setGemmenTorikeshiJiyu
     *
     * @param gemmenTorikeshiJiyu gemmenTorikeshiJiyu
     */
    public void setGemmenTorikeshiJiyu(RString gemmenTorikeshiJiyu) {
        this.gemmenTorikeshiJiyu = gemmenTorikeshiJiyu;
    }

    /**
     * getShinseiGemmenGaku
     *
     * @return shinseiGemmenGaku
     */
    public Decimal getShinseiGemmenGaku() {
        return shinseiGemmenGaku;
    }

    /**
     * setShinseiGemmenGaku
     *
     * @param shinseiGemmenGaku shinseiGemmenGaku
     */
    public void setShinseiGemmenGaku(Decimal shinseiGemmenGaku) {
        this.shinseiGemmenGaku = shinseiGemmenGaku;
    }

    /**
     * getKetteiGemmenGaku
     *
     * @return ketteiGemmenGaku
     */
    public Decimal getKetteiGemmenGaku() {
        return ketteiGemmenGaku;
    }

    /**
     * setKetteiGemmenGaku
     *
     * @param ketteiGemmenGaku ketteiGemmenGaku
     */
    public void setKetteiGemmenGaku(Decimal ketteiGemmenGaku) {
        this.ketteiGemmenGaku = ketteiGemmenGaku;
    }

    /**
     * getTorikeshiGemmenGaku
     *
     * @return torikeshiGemmenGaku
     */
    public Decimal getTorikeshiGemmenGaku() {
        return torikeshiGemmenGaku;
    }

    /**
     * setTorikeshiGemmenGaku
     *
     * @param torikeshiGemmenGaku torikeshiGemmenGaku
     */
    public void setTorikeshiGemmenGaku(Decimal torikeshiGemmenGaku) {
        this.torikeshiGemmenGaku = torikeshiGemmenGaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2004GemmenEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2004GemmenEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2004GemmenEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.insertTimestamp, other.insertTimestamp)) {
            return false;
        }
        if (!Objects.equals(this.choteiNendo, other.choteiNendo)) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
            return false;
        }
        if (!Objects.equals(this.tsuchishoNo, other.tsuchishoNo)) {
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
    public void shallowCopy(DbT2004GemmenEntity entity) {
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.torikeshiYMD = entity.torikeshiYMD;
        this.jotaiKubun = entity.jotaiKubun;
        this.sakuseiKubun = entity.sakuseiKubun;
        this.shinseiJiyu = entity.shinseiJiyu;
        this.gemmenShuruiCode = entity.gemmenShuruiCode;
        this.gemmenJiyu = entity.gemmenJiyu;
        this.gemmenTorikeshiShuruiCode = entity.gemmenTorikeshiShuruiCode;
        this.gemmenTorikeshiJiyu = entity.gemmenTorikeshiJiyu;
        this.shinseiGemmenGaku = entity.shinseiGemmenGaku;
        this.ketteiGemmenGaku = entity.ketteiGemmenGaku;
        this.torikeshiGemmenGaku = entity.torikeshiGemmenGaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, shoriTimestamp, shinseiYMD, ketteiYMD, torikeshiYMD, jotaiKubun, sakuseiKubun, shinseiJiyu, gemmenShuruiCode, gemmenJiyu, gemmenTorikeshiShuruiCode, gemmenTorikeshiJiyu, shinseiGemmenGaku, ketteiGemmenGaku, torikeshiGemmenGaku);
    }

// </editor-fold>
}
