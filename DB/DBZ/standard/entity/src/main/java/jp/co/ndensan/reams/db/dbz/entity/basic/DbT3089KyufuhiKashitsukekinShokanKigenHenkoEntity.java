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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3089KyufuhiKashitsukekinShokanKigenHenkoの項目定義クラスです
 *
 */
public class DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity extends DbTableEntityBase<DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3089KyufuhiKashitsukekinShokanKigenHenko");

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
    private FlexibleDate shokanKigenEnchoUketsukeYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate shokanKigenEnchoShinseiYMD;
    private YubinNo kariukeninYubinNo;
    private RString kariukeninJusho;
    private AtenaKanaMeisho kariukeninShimeiKana;
    private AtenaMeisho kariukeninShimei;
    private TelNo kariukeninTelNo;
    private Decimal miShokanKingaku;
    private FlexibleDate enchoKiboKaishiYMD;
    private FlexibleDate enchoKiboShuryoYMD;
    private RString enchoRiyu;
    private FlexibleDate henkoKetteiYMD;
    private RString henkoShonin_FuShoninKubun;
    private FlexibleDate henkoGoShokanKigenYMD;
    private RString henkoFuShoninRiyu;

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
     * getShokanKigenEnchoUketsukeYMD
     *
     * @return shokanKigenEnchoUketsukeYMD
     */
    public FlexibleDate getShokanKigenEnchoUketsukeYMD() {
        return shokanKigenEnchoUketsukeYMD;
    }

    /**
     * setShokanKigenEnchoUketsukeYMD
     *
     * @param shokanKigenEnchoUketsukeYMD shokanKigenEnchoUketsukeYMD
     */
    public void setShokanKigenEnchoUketsukeYMD(FlexibleDate shokanKigenEnchoUketsukeYMD) {
        this.shokanKigenEnchoUketsukeYMD = shokanKigenEnchoUketsukeYMD;
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
     * getShokanKigenEnchoShinseiYMD
     *
     * @return shokanKigenEnchoShinseiYMD
     */
    public FlexibleDate getShokanKigenEnchoShinseiYMD() {
        return shokanKigenEnchoShinseiYMD;
    }

    /**
     * setShokanKigenEnchoShinseiYMD
     *
     * @param shokanKigenEnchoShinseiYMD shokanKigenEnchoShinseiYMD
     */
    public void setShokanKigenEnchoShinseiYMD(FlexibleDate shokanKigenEnchoShinseiYMD) {
        this.shokanKigenEnchoShinseiYMD = shokanKigenEnchoShinseiYMD;
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
     * getMiShokanKingaku
     *
     * @return miShokanKingaku
     */
    public Decimal getMiShokanKingaku() {
        return miShokanKingaku;
    }

    /**
     * setMiShokanKingaku
     *
     * @param miShokanKingaku miShokanKingaku
     */
    public void setMiShokanKingaku(Decimal miShokanKingaku) {
        this.miShokanKingaku = miShokanKingaku;
    }

    /**
     * getEnchoKiboKaishiYMD
     *
     * @return enchoKiboKaishiYMD
     */
    public FlexibleDate getEnchoKiboKaishiYMD() {
        return enchoKiboKaishiYMD;
    }

    /**
     * setEnchoKiboKaishiYMD
     *
     * @param enchoKiboKaishiYMD enchoKiboKaishiYMD
     */
    public void setEnchoKiboKaishiYMD(FlexibleDate enchoKiboKaishiYMD) {
        this.enchoKiboKaishiYMD = enchoKiboKaishiYMD;
    }

    /**
     * getEnchoKiboShuryoYMD
     *
     * @return enchoKiboShuryoYMD
     */
    public FlexibleDate getEnchoKiboShuryoYMD() {
        return enchoKiboShuryoYMD;
    }

    /**
     * setEnchoKiboShuryoYMD
     *
     * @param enchoKiboShuryoYMD enchoKiboShuryoYMD
     */
    public void setEnchoKiboShuryoYMD(FlexibleDate enchoKiboShuryoYMD) {
        this.enchoKiboShuryoYMD = enchoKiboShuryoYMD;
    }

    /**
     * getEnchoRiyu
     *
     * @return enchoRiyu
     */
    public RString getEnchoRiyu() {
        return enchoRiyu;
    }

    /**
     * setEnchoRiyu
     *
     * @param enchoRiyu enchoRiyu
     */
    public void setEnchoRiyu(RString enchoRiyu) {
        this.enchoRiyu = enchoRiyu;
    }

    /**
     * getHenkoKetteiYMD
     *
     * @return henkoKetteiYMD
     */
    public FlexibleDate getHenkoKetteiYMD() {
        return henkoKetteiYMD;
    }

    /**
     * setHenkoKetteiYMD
     *
     * @param henkoKetteiYMD henkoKetteiYMD
     */
    public void setHenkoKetteiYMD(FlexibleDate henkoKetteiYMD) {
        this.henkoKetteiYMD = henkoKetteiYMD;
    }

    /**
     * getHenkoShonin_FuShoninKubun
     *
     * @return henkoShonin_FuShoninKubun
     */
    public RString getHenkoShonin_FuShoninKubun() {
        return henkoShonin_FuShoninKubun;
    }

    /**
     * setHenkoShonin_FuShoninKubun
     *
     * @param henkoShonin_FuShoninKubun henkoShonin_FuShoninKubun
     */
    public void setHenkoShonin_FuShoninKubun(RString henkoShonin_FuShoninKubun) {
        this.henkoShonin_FuShoninKubun = henkoShonin_FuShoninKubun;
    }

    /**
     * getHenkoGoShokanKigenYMD
     *
     * @return henkoGoShokanKigenYMD
     */
    public FlexibleDate getHenkoGoShokanKigenYMD() {
        return henkoGoShokanKigenYMD;
    }

    /**
     * setHenkoGoShokanKigenYMD
     *
     * @param henkoGoShokanKigenYMD henkoGoShokanKigenYMD
     */
    public void setHenkoGoShokanKigenYMD(FlexibleDate henkoGoShokanKigenYMD) {
        this.henkoGoShokanKigenYMD = henkoGoShokanKigenYMD;
    }

    /**
     * getHenkoFuShoninRiyu
     *
     * @return henkoFuShoninRiyu
     */
    public RString getHenkoFuShoninRiyu() {
        return henkoFuShoninRiyu;
    }

    /**
     * setHenkoFuShoninRiyu
     *
     * @param henkoFuShoninRiyu henkoFuShoninRiyu
     */
    public void setHenkoFuShoninRiyu(RString henkoFuShoninRiyu) {
        this.henkoFuShoninRiyu = henkoFuShoninRiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kashitsukeKanriNo, other.kashitsukeKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.shokanKigenEnchoUketsukeYMD, other.shokanKigenEnchoUketsukeYMD)) {
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
    public void shallowCopy(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kashitsukeKanriNo = entity.kashitsukeKanriNo;
        this.shokanKigenEnchoUketsukeYMD = entity.shokanKigenEnchoUketsukeYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shokanKigenEnchoShinseiYMD = entity.shokanKigenEnchoShinseiYMD;
        this.kariukeninYubinNo = entity.kariukeninYubinNo;
        this.kariukeninJusho = entity.kariukeninJusho;
        this.kariukeninShimeiKana = entity.kariukeninShimeiKana;
        this.kariukeninShimei = entity.kariukeninShimei;
        this.kariukeninTelNo = entity.kariukeninTelNo;
        this.miShokanKingaku = entity.miShokanKingaku;
        this.enchoKiboKaishiYMD = entity.enchoKiboKaishiYMD;
        this.enchoKiboShuryoYMD = entity.enchoKiboShuryoYMD;
        this.enchoRiyu = entity.enchoRiyu;
        this.henkoKetteiYMD = entity.henkoKetteiYMD;
        this.henkoShonin_FuShoninKubun = entity.henkoShonin_FuShoninKubun;
        this.henkoGoShokanKigenYMD = entity.henkoGoShokanKigenYMD;
        this.henkoFuShoninRiyu = entity.henkoFuShoninRiyu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kashitsukeKanriNo, shokanKigenEnchoUketsukeYMD, shoriTimestamp, shokanKigenEnchoShinseiYMD, kariukeninYubinNo, kariukeninJusho, kariukeninShimeiKana, kariukeninShimei, kariukeninTelNo, miShokanKingaku, enchoKiboKaishiYMD, enchoKiboShuryoYMD, enchoRiyu, henkoKetteiYMD, henkoShonin_FuShoninKubun, henkoGoShokanKigenYMD, henkoFuShoninRiyu);
    }

// </editor-fold>
}
