package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3088KyufuhiKashitsukekinShakuyoshoJuriの項目定義クラスです
 *
 */
public class DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity extends DbTableEntityBase<DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3088KyufuhiKashitsukekinShakuyoshoJuri");

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
    private FlexibleDate kariireShinseiYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate kariukeYMD;
    private YubinNo kariukeninYubinNo;
    private RString kariukeninJusho;
    private AtenaKanaMeisho kariukeninShimeiKana;
    private AtenaMeisho kariukeninShimei;
    private TelNo kariukeninTelNo;
    private AtenaKanaMeisho hoshoninShimeiKana;
    private AtenaKanaMeisho hoshoninShimei;
    private YubinNo hoshoninYubinNo;
    private RString hoshoninJusho;
    private TelNo hoshoninTelNo;

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
     * getKariireShinseiYMD
     *
     * @return kariireShinseiYMD
     */
    public FlexibleDate getKariireShinseiYMD() {
        return kariireShinseiYMD;
    }

    /**
     * setKariireShinseiYMD
     *
     * @param kariireShinseiYMD kariireShinseiYMD
     */
    public void setKariireShinseiYMD(FlexibleDate kariireShinseiYMD) {
        this.kariireShinseiYMD = kariireShinseiYMD;
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
     * getKariukeYMD
     *
     * @return kariukeYMD
     */
    public FlexibleDate getKariukeYMD() {
        return kariukeYMD;
    }

    /**
     * setKariukeYMD
     *
     * @param kariukeYMD kariukeYMD
     */
    public void setKariukeYMD(FlexibleDate kariukeYMD) {
        this.kariukeYMD = kariukeYMD;
    }

    /**
     * getKariukeninYubinNo
     *
     * @return kariukeninYubinNo
     */
    public YubinNo getKariukeninYubinNo() {
        return kariukeninYubinNo;
    }

    /**
     * setKariukeninYubinNo
     *
     * @param kariukeninYubinNo kariukeninYubinNo
     */
    public void setKariukeninYubinNo(YubinNo kariukeninYubinNo) {
        this.kariukeninYubinNo = kariukeninYubinNo;
    }

    /**
     * getKariukeninJusho
     *
     * @return kariukeninJusho
     */
    public RString getKariukeninJusho() {
        return kariukeninJusho;
    }

    /**
     * setKariukeninJusho
     *
     * @param kariukeninJusho kariukeninJusho
     */
    public void setKariukeninJusho(RString kariukeninJusho) {
        this.kariukeninJusho = kariukeninJusho;
    }

    /**
     * getKariukeninShimeiKana
     *
     * @return kariukeninShimeiKana
     */
    public AtenaKanaMeisho getKariukeninShimeiKana() {
        return kariukeninShimeiKana;
    }

    /**
     * setKariukeninShimeiKana
     *
     * @param kariukeninShimeiKana kariukeninShimeiKana
     */
    public void setKariukeninShimeiKana(AtenaKanaMeisho kariukeninShimeiKana) {
        this.kariukeninShimeiKana = kariukeninShimeiKana;
    }

    /**
     * getKariukeninShimei
     *
     * @return kariukeninShimei
     */
    public AtenaMeisho getKariukeninShimei() {
        return kariukeninShimei;
    }

    /**
     * setKariukeninShimei
     *
     * @param kariukeninShimei kariukeninShimei
     */
    public void setKariukeninShimei(AtenaMeisho kariukeninShimei) {
        this.kariukeninShimei = kariukeninShimei;
    }

    /**
     * getKariukeninTelNo
     *
     * @return kariukeninTelNo
     */
    public TelNo getKariukeninTelNo() {
        return kariukeninTelNo;
    }

    /**
     * setKariukeninTelNo
     *
     * @param kariukeninTelNo kariukeninTelNo
     */
    public void setKariukeninTelNo(TelNo kariukeninTelNo) {
        this.kariukeninTelNo = kariukeninTelNo;
    }

    /**
     * getHoshoninShimeiKana
     *
     * @return hoshoninShimeiKana
     */
    public AtenaKanaMeisho getHoshoninShimeiKana() {
        return hoshoninShimeiKana;
    }

    /**
     * setHoshoninShimeiKana
     *
     * @param hoshoninShimeiKana hoshoninShimeiKana
     */
    public void setHoshoninShimeiKana(AtenaKanaMeisho hoshoninShimeiKana) {
        this.hoshoninShimeiKana = hoshoninShimeiKana;
    }

    /**
     * getHoshoninShimei
     *
     * @return hoshoninShimei
     */
    public AtenaKanaMeisho getHoshoninShimei() {
        return hoshoninShimei;
    }

    /**
     * setHoshoninShimei
     *
     * @param hoshoninShimei hoshoninShimei
     */
    public void setHoshoninShimei(AtenaKanaMeisho hoshoninShimei) {
        this.hoshoninShimei = hoshoninShimei;
    }

    /**
     * getHoshoninYubinNo
     *
     * @return hoshoninYubinNo
     */
    public YubinNo getHoshoninYubinNo() {
        return hoshoninYubinNo;
    }

    /**
     * setHoshoninYubinNo
     *
     * @param hoshoninYubinNo hoshoninYubinNo
     */
    public void setHoshoninYubinNo(YubinNo hoshoninYubinNo) {
        this.hoshoninYubinNo = hoshoninYubinNo;
    }

    /**
     * getHoshoninJusho
     *
     * @return hoshoninJusho
     */
    public RString getHoshoninJusho() {
        return hoshoninJusho;
    }

    /**
     * setHoshoninJusho
     *
     * @param hoshoninJusho hoshoninJusho
     */
    public void setHoshoninJusho(RString hoshoninJusho) {
        this.hoshoninJusho = hoshoninJusho;
    }

    /**
     * getHoshoninTelNo
     *
     * @return hoshoninTelNo
     */
    public TelNo getHoshoninTelNo() {
        return hoshoninTelNo;
    }

    /**
     * setHoshoninTelNo
     *
     * @param hoshoninTelNo hoshoninTelNo
     */
    public void setHoshoninTelNo(TelNo hoshoninTelNo) {
        this.hoshoninTelNo = hoshoninTelNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kariireShinseiYMD, other.kariireShinseiYMD)) {
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
    public void shallowCopy(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kariireShinseiYMD = entity.kariireShinseiYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kariukeYMD = entity.kariukeYMD;
        this.kariukeninYubinNo = entity.kariukeninYubinNo;
        this.kariukeninJusho = entity.kariukeninJusho;
        this.kariukeninShimeiKana = entity.kariukeninShimeiKana;
        this.kariukeninShimei = entity.kariukeninShimei;
        this.kariukeninTelNo = entity.kariukeninTelNo;
        this.hoshoninShimeiKana = entity.hoshoninShimeiKana;
        this.hoshoninShimei = entity.hoshoninShimei;
        this.hoshoninYubinNo = entity.hoshoninYubinNo;
        this.hoshoninJusho = entity.hoshoninJusho;
        this.hoshoninTelNo = entity.hoshoninTelNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kariireShinseiYMD, shoriTimestamp, kariukeYMD, kariukeninYubinNo, kariukeninJusho, kariukeninShimeiKana, kariukeninShimei, kariukeninTelNo, hoshoninShimeiKana, hoshoninShimei, hoshoninYubinNo, hoshoninJusho, hoshoninTelNo);
    }

// </editor-fold>
}
