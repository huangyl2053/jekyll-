package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3071KogakuGassanJikoFutanGakuMeisaiの項目定義クラスです
 *
 */
public class DbT3071KogakuGassanJikoFutanGakuMeisaiEntity extends DbTableEntityBase<DbT3071KogakuGassanJikoFutanGakuMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3071KogakuGassanJikoFutanGakuMeisai");

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
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo hokenshaNo;
    @PrimaryKey
    private RString shikyuShinseishoSeiriNo;
    @PrimaryKey
    private RString taishoM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private Decimal jikoFutanGaku;
    private Decimal uchisu_70_74JikoFutanGaku;
    private Decimal under_70KogakuShikyuGaku;
    private Decimal over_70_74KogakuShikyuGaku;
    private RString tekiyo;
    private Decimal sumi_JikoFutanGaku;
    private Decimal sumi_70_74JikoFutanGaku;
    private Decimal sumi_under_70KogakuShikyuGaku;
    private Decimal sumi_70_74KogakuShikyuGaku;
    private RString sumi_Tekiyo;

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
     * getTaishoNendo
     *
     * @return taishoNendo
     */
    public FlexibleYear getTaishoNendo() {
        return taishoNendo;
    }

    /**
     * setTaishoNendo
     *
     * @param taishoNendo taishoNendo
     */
    public void setTaishoNendo(FlexibleYear taishoNendo) {
        this.taishoNendo = taishoNendo;
    }

    /**
     * getHokenshaNo
     *
     * @return hokenshaNo
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * setHokenshaNo
     *
     * @param hokenshaNo hokenshaNo
     */
    public void setHokenshaNo(HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * getShikyuShinseishoSeiriNo
     *
     * @return shikyuShinseishoSeiriNo
     */
    public RString getShikyuShinseishoSeiriNo() {
        return shikyuShinseishoSeiriNo;
    }

    /**
     * setShikyuShinseishoSeiriNo
     *
     * @param shikyuShinseishoSeiriNo shikyuShinseishoSeiriNo
     */
    public void setShikyuShinseishoSeiriNo(RString shikyuShinseishoSeiriNo) {
        this.shikyuShinseishoSeiriNo = shikyuShinseishoSeiriNo;
    }

    /**
     * getTaishoM
     *
     * @return taishoM
     */
    public RString getTaishoM() {
        return taishoM;
    }

    /**
     * setTaishoM
     *
     * @param taishoM taishoM
     */
    public void setTaishoM(RString taishoM) {
        this.taishoM = taishoM;
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
     * getJikoFutanGaku
     *
     * @return jikoFutanGaku
     */
    public Decimal getJikoFutanGaku() {
        return jikoFutanGaku;
    }

    /**
     * setJikoFutanGaku
     *
     * @param jikoFutanGaku jikoFutanGaku
     */
    public void setJikoFutanGaku(Decimal jikoFutanGaku) {
        this.jikoFutanGaku = jikoFutanGaku;
    }

    /**
     * getUchisu_70_74JikoFutanGaku
     *
     * @return uchisu_70_74JikoFutanGaku
     */
    public Decimal getUchisu_70_74JikoFutanGaku() {
        return uchisu_70_74JikoFutanGaku;
    }

    /**
     * setUchisu_70_74JikoFutanGaku
     *
     * @param uchisu_70_74JikoFutanGaku uchisu_70_74JikoFutanGaku
     */
    public void setUchisu_70_74JikoFutanGaku(Decimal uchisu_70_74JikoFutanGaku) {
        this.uchisu_70_74JikoFutanGaku = uchisu_70_74JikoFutanGaku;
    }

    /**
     * getUnder_70KogakuShikyuGaku
     *
     * @return under_70KogakuShikyuGaku
     */
    public Decimal getUnder_70KogakuShikyuGaku() {
        return under_70KogakuShikyuGaku;
    }

    /**
     * setUnder_70KogakuShikyuGaku
     *
     * @param under_70KogakuShikyuGaku under_70KogakuShikyuGaku
     */
    public void setUnder_70KogakuShikyuGaku(Decimal under_70KogakuShikyuGaku) {
        this.under_70KogakuShikyuGaku = under_70KogakuShikyuGaku;
    }

    /**
     * getOver_70_74KogakuShikyuGaku
     *
     * @return over_70_74KogakuShikyuGaku
     */
    public Decimal getOver_70_74KogakuShikyuGaku() {
        return over_70_74KogakuShikyuGaku;
    }

    /**
     * setOver_70_74KogakuShikyuGaku
     *
     * @param over_70_74KogakuShikyuGaku over_70_74KogakuShikyuGaku
     */
    public void setOver_70_74KogakuShikyuGaku(Decimal over_70_74KogakuShikyuGaku) {
        this.over_70_74KogakuShikyuGaku = over_70_74KogakuShikyuGaku;
    }

    /**
     * getTekiyo
     *
     * @return tekiyo
     */
    public RString getTekiyo() {
        return tekiyo;
    }

    /**
     * setTekiyo
     *
     * @param tekiyo tekiyo
     */
    public void setTekiyo(RString tekiyo) {
        this.tekiyo = tekiyo;
    }

    /**
     * getSumi_JikoFutanGaku
     *
     * @return sumi_JikoFutanGaku
     */
    public Decimal getSumi_JikoFutanGaku() {
        return sumi_JikoFutanGaku;
    }

    /**
     * setSumi_JikoFutanGaku
     *
     * @param sumi_JikoFutanGaku sumi_JikoFutanGaku
     */
    public void setSumi_JikoFutanGaku(Decimal sumi_JikoFutanGaku) {
        this.sumi_JikoFutanGaku = sumi_JikoFutanGaku;
    }

    /**
     * getSumi_70_74JikoFutanGaku
     *
     * @return sumi_70_74JikoFutanGaku
     */
    public Decimal getSumi_70_74JikoFutanGaku() {
        return sumi_70_74JikoFutanGaku;
    }

    /**
     * setSumi_70_74JikoFutanGaku
     *
     * @param sumi_70_74JikoFutanGaku sumi_70_74JikoFutanGaku
     */
    public void setSumi_70_74JikoFutanGaku(Decimal sumi_70_74JikoFutanGaku) {
        this.sumi_70_74JikoFutanGaku = sumi_70_74JikoFutanGaku;
    }

    /**
     * getSumi_under_70KogakuShikyuGaku
     *
     * @return sumi_under_70KogakuShikyuGaku
     */
    public Decimal getSumi_under_70KogakuShikyuGaku() {
        return sumi_under_70KogakuShikyuGaku;
    }

    /**
     * setSumi_under_70KogakuShikyuGaku
     *
     * @param sumi_under_70KogakuShikyuGaku sumi_under_70KogakuShikyuGaku
     */
    public void setSumi_under_70KogakuShikyuGaku(Decimal sumi_under_70KogakuShikyuGaku) {
        this.sumi_under_70KogakuShikyuGaku = sumi_under_70KogakuShikyuGaku;
    }

    /**
     * getSumi_70_74KogakuShikyuGaku
     *
     * @return sumi_70_74KogakuShikyuGaku
     */
    public Decimal getSumi_70_74KogakuShikyuGaku() {
        return sumi_70_74KogakuShikyuGaku;
    }

    /**
     * setSumi_70_74KogakuShikyuGaku
     *
     * @param sumi_70_74KogakuShikyuGaku sumi_70_74KogakuShikyuGaku
     */
    public void setSumi_70_74KogakuShikyuGaku(Decimal sumi_70_74KogakuShikyuGaku) {
        this.sumi_70_74KogakuShikyuGaku = sumi_70_74KogakuShikyuGaku;
    }

    /**
     * getSumi_Tekiyo
     *
     * @return sumi_Tekiyo
     */
    public RString getSumi_Tekiyo() {
        return sumi_Tekiyo;
    }

    /**
     * setSumi_Tekiyo
     *
     * @param sumi_Tekiyo sumi_Tekiyo
     */
    public void setSumi_Tekiyo(RString sumi_Tekiyo) {
        this.sumi_Tekiyo = sumi_Tekiyo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3071KogakuGassanJikoFutanGakuMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3071KogakuGassanJikoFutanGakuMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3071KogakuGassanJikoFutanGakuMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoNendo, other.taishoNendo)) {
            return false;
        }
        if (!Objects.equals(this.hokenshaNo, other.hokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikyuShinseishoSeiriNo, other.shikyuShinseishoSeiriNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoM, other.taishoM)) {
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
    public void shallowCopy(DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.hokenshaNo = entity.hokenshaNo;
        this.shikyuShinseishoSeiriNo = entity.shikyuShinseishoSeiriNo;
        this.taishoM = entity.taishoM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.jikoFutanGaku = entity.jikoFutanGaku;
        this.uchisu_70_74JikoFutanGaku = entity.uchisu_70_74JikoFutanGaku;
        this.under_70KogakuShikyuGaku = entity.under_70KogakuShikyuGaku;
        this.over_70_74KogakuShikyuGaku = entity.over_70_74KogakuShikyuGaku;
        this.tekiyo = entity.tekiyo;
        this.sumi_JikoFutanGaku = entity.sumi_JikoFutanGaku;
        this.sumi_70_74JikoFutanGaku = entity.sumi_70_74JikoFutanGaku;
        this.sumi_under_70KogakuShikyuGaku = entity.sumi_under_70KogakuShikyuGaku;
        this.sumi_70_74KogakuShikyuGaku = entity.sumi_70_74KogakuShikyuGaku;
        this.sumi_Tekiyo = entity.sumi_Tekiyo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, hokenshaNo, shikyuShinseishoSeiriNo, taishoM, shoriTimestamp, jikoFutanGaku, uchisu_70_74JikoFutanGaku, under_70KogakuShikyuGaku, over_70_74KogakuShikyuGaku, tekiyo, sumi_JikoFutanGaku, sumi_70_74JikoFutanGaku, sumi_under_70KogakuShikyuGaku, sumi_70_74KogakuShikyuGaku, sumi_Tekiyo);
    }

// </editor-fold>
}
