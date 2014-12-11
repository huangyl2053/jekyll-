package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * DbT3087KyufuhiKashitsukeKinKetteiの項目定義クラスです
 *
 */
public class DbT3087KyufuhiKashitsukeKinKetteiEntity extends DbTableEntityBase<DbT3087KyufuhiKashitsukeKinKetteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3087KyufuhiKashitsukeKinKettei");

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
    private FlexibleDate kashitsukeShinsaKetteiYMD;
    private RString kashitsukeShonin_FuShoninKubun;
    private RString kashitsukeKanriNo;
    private Decimal kashitsukeKingaku;
    private RString shokanHoho;
    private FlexibleDate shokanKigenYMD;
    private FlexibleDate kashitsukeYMD;
    private RString kashitsukeShiharaiHoho;
    private RString kashitsukeMadoguchiShiharaiBasho;
    private FlexibleDate kashitsukeMadoguchiKaishiYMD;
    private FlexibleDate kashitsukeMadoguchiShuryoYMD;
    private RString kashitsukeMadoguchiHeichoNaiyo;
    private RString kashitsukeMadoguchiKaishiTime;
    private RString kashitsukeMadoguchiShuryoTime;
    private RString kashitsukeFuShoninRiyu;
    private ShikibetsuCode shikibetsuCode;

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
     * getKashitsukeShinsaKetteiYMD
     *
     * @return kashitsukeShinsaKetteiYMD
     */
    public FlexibleDate getKashitsukeShinsaKetteiYMD() {
        return kashitsukeShinsaKetteiYMD;
    }

    /**
     * setKashitsukeShinsaKetteiYMD
     *
     * @param kashitsukeShinsaKetteiYMD kashitsukeShinsaKetteiYMD
     */
    public void setKashitsukeShinsaKetteiYMD(FlexibleDate kashitsukeShinsaKetteiYMD) {
        this.kashitsukeShinsaKetteiYMD = kashitsukeShinsaKetteiYMD;
    }

    /**
     * getKashitsukeShonin_FuShoninKubun
     *
     * @return kashitsukeShonin_FuShoninKubun
     */
    public RString getKashitsukeShonin_FuShoninKubun() {
        return kashitsukeShonin_FuShoninKubun;
    }

    /**
     * setKashitsukeShonin_FuShoninKubun
     *
     * @param kashitsukeShonin_FuShoninKubun kashitsukeShonin_FuShoninKubun
     */
    public void setKashitsukeShonin_FuShoninKubun(RString kashitsukeShonin_FuShoninKubun) {
        this.kashitsukeShonin_FuShoninKubun = kashitsukeShonin_FuShoninKubun;
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
     * getKashitsukeKingaku
     *
     * @return kashitsukeKingaku
     */
    public Decimal getKashitsukeKingaku() {
        return kashitsukeKingaku;
    }

    /**
     * setKashitsukeKingaku
     *
     * @param kashitsukeKingaku kashitsukeKingaku
     */
    public void setKashitsukeKingaku(Decimal kashitsukeKingaku) {
        this.kashitsukeKingaku = kashitsukeKingaku;
    }

    /**
     * getShokanHoho
     *
     * @return shokanHoho
     */
    public RString getShokanHoho() {
        return shokanHoho;
    }

    /**
     * setShokanHoho
     *
     * @param shokanHoho shokanHoho
     */
    public void setShokanHoho(RString shokanHoho) {
        this.shokanHoho = shokanHoho;
    }

    /**
     * getShokanKigenYMD
     *
     * @return shokanKigenYMD
     */
    public FlexibleDate getShokanKigenYMD() {
        return shokanKigenYMD;
    }

    /**
     * setShokanKigenYMD
     *
     * @param shokanKigenYMD shokanKigenYMD
     */
    public void setShokanKigenYMD(FlexibleDate shokanKigenYMD) {
        this.shokanKigenYMD = shokanKigenYMD;
    }

    /**
     * getKashitsukeYMD
     *
     * @return kashitsukeYMD
     */
    public FlexibleDate getKashitsukeYMD() {
        return kashitsukeYMD;
    }

    /**
     * setKashitsukeYMD
     *
     * @param kashitsukeYMD kashitsukeYMD
     */
    public void setKashitsukeYMD(FlexibleDate kashitsukeYMD) {
        this.kashitsukeYMD = kashitsukeYMD;
    }

    /**
     * getKashitsukeShiharaiHoho
     *
     * @return kashitsukeShiharaiHoho
     */
    public RString getKashitsukeShiharaiHoho() {
        return kashitsukeShiharaiHoho;
    }

    /**
     * setKashitsukeShiharaiHoho
     *
     * @param kashitsukeShiharaiHoho kashitsukeShiharaiHoho
     */
    public void setKashitsukeShiharaiHoho(RString kashitsukeShiharaiHoho) {
        this.kashitsukeShiharaiHoho = kashitsukeShiharaiHoho;
    }

    /**
     * getKashitsukeMadoguchiShiharaiBasho
     *
     * @return kashitsukeMadoguchiShiharaiBasho
     */
    public RString getKashitsukeMadoguchiShiharaiBasho() {
        return kashitsukeMadoguchiShiharaiBasho;
    }

    /**
     * setKashitsukeMadoguchiShiharaiBasho
     *
     * @param kashitsukeMadoguchiShiharaiBasho kashitsukeMadoguchiShiharaiBasho
     */
    public void setKashitsukeMadoguchiShiharaiBasho(RString kashitsukeMadoguchiShiharaiBasho) {
        this.kashitsukeMadoguchiShiharaiBasho = kashitsukeMadoguchiShiharaiBasho;
    }

    /**
     * getKashitsukeMadoguchiKaishiYMD
     *
     * @return kashitsukeMadoguchiKaishiYMD
     */
    public FlexibleDate getKashitsukeMadoguchiKaishiYMD() {
        return kashitsukeMadoguchiKaishiYMD;
    }

    /**
     * setKashitsukeMadoguchiKaishiYMD
     *
     * @param kashitsukeMadoguchiKaishiYMD kashitsukeMadoguchiKaishiYMD
     */
    public void setKashitsukeMadoguchiKaishiYMD(FlexibleDate kashitsukeMadoguchiKaishiYMD) {
        this.kashitsukeMadoguchiKaishiYMD = kashitsukeMadoguchiKaishiYMD;
    }

    /**
     * getKashitsukeMadoguchiShuryoYMD
     *
     * @return kashitsukeMadoguchiShuryoYMD
     */
    public FlexibleDate getKashitsukeMadoguchiShuryoYMD() {
        return kashitsukeMadoguchiShuryoYMD;
    }

    /**
     * setKashitsukeMadoguchiShuryoYMD
     *
     * @param kashitsukeMadoguchiShuryoYMD kashitsukeMadoguchiShuryoYMD
     */
    public void setKashitsukeMadoguchiShuryoYMD(FlexibleDate kashitsukeMadoguchiShuryoYMD) {
        this.kashitsukeMadoguchiShuryoYMD = kashitsukeMadoguchiShuryoYMD;
    }

    /**
     * getKashitsukeMadoguchiHeichoNaiyo
     *
     * @return kashitsukeMadoguchiHeichoNaiyo
     */
    public RString getKashitsukeMadoguchiHeichoNaiyo() {
        return kashitsukeMadoguchiHeichoNaiyo;
    }

    /**
     * setKashitsukeMadoguchiHeichoNaiyo
     *
     * @param kashitsukeMadoguchiHeichoNaiyo kashitsukeMadoguchiHeichoNaiyo
     */
    public void setKashitsukeMadoguchiHeichoNaiyo(RString kashitsukeMadoguchiHeichoNaiyo) {
        this.kashitsukeMadoguchiHeichoNaiyo = kashitsukeMadoguchiHeichoNaiyo;
    }

    /**
     * getKashitsukeMadoguchiKaishiTime
     *
     * @return kashitsukeMadoguchiKaishiTime
     */
    public RString getKashitsukeMadoguchiKaishiTime() {
        return kashitsukeMadoguchiKaishiTime;
    }

    /**
     * setKashitsukeMadoguchiKaishiTime
     *
     * @param kashitsukeMadoguchiKaishiTime kashitsukeMadoguchiKaishiTime
     */
    public void setKashitsukeMadoguchiKaishiTime(RString kashitsukeMadoguchiKaishiTime) {
        this.kashitsukeMadoguchiKaishiTime = kashitsukeMadoguchiKaishiTime;
    }

    /**
     * getKashitsukeMadoguchiShuryoTime
     *
     * @return kashitsukeMadoguchiShuryoTime
     */
    public RString getKashitsukeMadoguchiShuryoTime() {
        return kashitsukeMadoguchiShuryoTime;
    }

    /**
     * setKashitsukeMadoguchiShuryoTime
     *
     * @param kashitsukeMadoguchiShuryoTime kashitsukeMadoguchiShuryoTime
     */
    public void setKashitsukeMadoguchiShuryoTime(RString kashitsukeMadoguchiShuryoTime) {
        this.kashitsukeMadoguchiShuryoTime = kashitsukeMadoguchiShuryoTime;
    }

    /**
     * getKashitsukeFuShoninRiyu
     *
     * @return kashitsukeFuShoninRiyu
     */
    public RString getKashitsukeFuShoninRiyu() {
        return kashitsukeFuShoninRiyu;
    }

    /**
     * setKashitsukeFuShoninRiyu
     *
     * @param kashitsukeFuShoninRiyu kashitsukeFuShoninRiyu
     */
    public void setKashitsukeFuShoninRiyu(RString kashitsukeFuShoninRiyu) {
        this.kashitsukeFuShoninRiyu = kashitsukeFuShoninRiyu;
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
     * このエンティティの主キーが他の{@literal DbT3087KyufuhiKashitsukeKinKetteiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3087KyufuhiKashitsukeKinKetteiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3087KyufuhiKashitsukeKinKetteiEntity other) {
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
    public void shallowCopy(DbT3087KyufuhiKashitsukeKinKetteiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kariireShinseiYMD = entity.kariireShinseiYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kashitsukeShinsaKetteiYMD = entity.kashitsukeShinsaKetteiYMD;
        this.kashitsukeShonin_FuShoninKubun = entity.kashitsukeShonin_FuShoninKubun;
        this.kashitsukeKanriNo = entity.kashitsukeKanriNo;
        this.kashitsukeKingaku = entity.kashitsukeKingaku;
        this.shokanHoho = entity.shokanHoho;
        this.shokanKigenYMD = entity.shokanKigenYMD;
        this.kashitsukeYMD = entity.kashitsukeYMD;
        this.kashitsukeShiharaiHoho = entity.kashitsukeShiharaiHoho;
        this.kashitsukeMadoguchiShiharaiBasho = entity.kashitsukeMadoguchiShiharaiBasho;
        this.kashitsukeMadoguchiKaishiYMD = entity.kashitsukeMadoguchiKaishiYMD;
        this.kashitsukeMadoguchiShuryoYMD = entity.kashitsukeMadoguchiShuryoYMD;
        this.kashitsukeMadoguchiHeichoNaiyo = entity.kashitsukeMadoguchiHeichoNaiyo;
        this.kashitsukeMadoguchiKaishiTime = entity.kashitsukeMadoguchiKaishiTime;
        this.kashitsukeMadoguchiShuryoTime = entity.kashitsukeMadoguchiShuryoTime;
        this.kashitsukeFuShoninRiyu = entity.kashitsukeFuShoninRiyu;
        this.shikibetsuCode = entity.shikibetsuCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, kariireShinseiYMD, shoriTimestamp, kashitsukeShinsaKetteiYMD, kashitsukeShonin_FuShoninKubun, kashitsukeKanriNo, kashitsukeKingaku, shokanHoho, shokanKigenYMD, kashitsukeYMD, kashitsukeShiharaiHoho, kashitsukeMadoguchiShiharaiBasho, kashitsukeMadoguchiKaishiYMD, kashitsukeMadoguchiShuryoYMD, kashitsukeMadoguchiHeichoNaiyo, kashitsukeMadoguchiKaishiTime, kashitsukeMadoguchiShuryoTime, kashitsukeFuShoninRiyu, shikibetsuCode);
    }

// </editor-fold>
}
