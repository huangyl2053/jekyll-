package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu.HokenryoChoshuYuyoShurui;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.code.kyotsu.HokenryoChoshuYuyoTorikeshiShurui;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT2006ChoshuYuyoの項目定義クラスです
 *
 */
public class DbT2006ChoshuYuyoEntity extends DbTableEntityBase<DbT2006ChoshuYuyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2006ChoshuYuyo");

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
    private HokenryoChoshuYuyoShurui yuyoShuruiCode;
    private RString yuyoJiyu;
    private HokenryoChoshuYuyoTorikeshiShurui yuyoTorikeshiShuruiCode;
    private RString yuyoTorikeshiJiyu;

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
     * getYuyoShuruiCode
     *
     * @return yuyoShuruiCode
     */
    public HokenryoChoshuYuyoShurui getYuyoShuruiCode() {
        return yuyoShuruiCode;
    }

    /**
     * setYuyoShuruiCode
     *
     * @param yuyoShuruiCode yuyoShuruiCode
     */
    public void setYuyoShuruiCode(HokenryoChoshuYuyoShurui yuyoShuruiCode) {
        this.yuyoShuruiCode = yuyoShuruiCode;
    }

    /**
     * getYuyoJiyu
     *
     * @return yuyoJiyu
     */
    public RString getYuyoJiyu() {
        return yuyoJiyu;
    }

    /**
     * setYuyoJiyu
     *
     * @param yuyoJiyu yuyoJiyu
     */
    public void setYuyoJiyu(RString yuyoJiyu) {
        this.yuyoJiyu = yuyoJiyu;
    }

    /**
     * getYuyoTorikeshiShuruiCode
     *
     * @return yuyoTorikeshiShuruiCode
     */
    public HokenryoChoshuYuyoTorikeshiShurui getYuyoTorikeshiShuruiCode() {
        return yuyoTorikeshiShuruiCode;
    }

    /**
     * setYuyoTorikeshiShuruiCode
     *
     * @param yuyoTorikeshiShuruiCode yuyoTorikeshiShuruiCode
     */
    public void setYuyoTorikeshiShuruiCode(HokenryoChoshuYuyoTorikeshiShurui yuyoTorikeshiShuruiCode) {
        this.yuyoTorikeshiShuruiCode = yuyoTorikeshiShuruiCode;
    }

    /**
     * getYuyoTorikeshiJiyu
     *
     * @return yuyoTorikeshiJiyu
     */
    public RString getYuyoTorikeshiJiyu() {
        return yuyoTorikeshiJiyu;
    }

    /**
     * setYuyoTorikeshiJiyu
     *
     * @param yuyoTorikeshiJiyu yuyoTorikeshiJiyu
     */
    public void setYuyoTorikeshiJiyu(RString yuyoTorikeshiJiyu) {
        this.yuyoTorikeshiJiyu = yuyoTorikeshiJiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2006ChoshuYuyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2006ChoshuYuyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2006ChoshuYuyoEntity other) {
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
    public void shallowCopy(DbT2006ChoshuYuyoEntity entity) {
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
        this.yuyoShuruiCode = entity.yuyoShuruiCode;
        this.yuyoJiyu = entity.yuyoJiyu;
        this.yuyoTorikeshiShuruiCode = entity.yuyoTorikeshiShuruiCode;
        this.yuyoTorikeshiJiyu = entity.yuyoTorikeshiJiyu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, shoriTimestamp, shinseiYMD, ketteiYMD, torikeshiYMD, jotaiKubun, sakuseiKubun, shinseiJiyu, yuyoShuruiCode, yuyoJiyu, yuyoTorikeshiShuruiCode, yuyoTorikeshiJiyu);
    }

// </editor-fold>
}
