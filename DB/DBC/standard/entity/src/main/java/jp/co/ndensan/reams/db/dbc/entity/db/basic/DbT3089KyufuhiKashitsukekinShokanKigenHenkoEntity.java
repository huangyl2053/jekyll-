package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 給付費貸付金償還期限変更テーブルのエンティティクラスです。
 */
public class DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity extends DbTableEntityBase<DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private Decimal rirekiNo;
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
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 貸付管理番号のgetメソッドです。
     *
     * @return 貸付管理番号
     */
    public RString getKashitsukeKanriNo() {
        return kashitsukeKanriNo;
    }

    /**
     * 貸付管理番号のsetメソッドです。
     *
     * @param kashitsukeKanriNo 貸付管理番号
     */
    public void setKashitsukeKanriNo(RString kashitsukeKanriNo) {
        this.kashitsukeKanriNo = kashitsukeKanriNo;
    }

    /**
     * 償還期限延長受付年月日のgetメソッドです。
     *
     * @return 償還期限延長受付年月日
     */
    public FlexibleDate getShokanKigenEnchoUketsukeYMD() {
        return shokanKigenEnchoUketsukeYMD;
    }

    /**
     * 償還期限延長受付年月日のsetメソッドです。
     *
     * @param shokanKigenEnchoUketsukeYMD 償還期限延長受付年月日
     */
    public void setShokanKigenEnchoUketsukeYMD(FlexibleDate shokanKigenEnchoUketsukeYMD) {
        this.shokanKigenEnchoUketsukeYMD = shokanKigenEnchoUketsukeYMD;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 償還期限延長申請年月日のgetメソッドです。
     *
     * @return 償還期限延長申請年月日
     */
    public FlexibleDate getShokanKigenEnchoShinseiYMD() {
        return shokanKigenEnchoShinseiYMD;
    }

    /**
     * 償還期限延長申請年月日のsetメソッドです。
     *
     * @param shokanKigenEnchoShinseiYMD 償還期限延長申請年月日
     */
    public void setShokanKigenEnchoShinseiYMD(FlexibleDate shokanKigenEnchoShinseiYMD) {
        this.shokanKigenEnchoShinseiYMD = shokanKigenEnchoShinseiYMD;
    }

    /**
     * 借受人郵便番号のgetメソッドです。
     *
     * @return 借受人郵便番号
     */
    public YubinNo getKariukeninYubinNo() {
        return kariukeninYubinNo;
    }

    /**
     * 借受人郵便番号のsetメソッドです。
     *
     * @param kariukeninYubinNo 借受人郵便番号
     */
    public void setKariukeninYubinNo(YubinNo kariukeninYubinNo) {
        this.kariukeninYubinNo = kariukeninYubinNo;
    }

    /**
     * 借受人住所のgetメソッドです。
     *
     * @return 借受人住所
     */
    public RString getKariukeninJusho() {
        return kariukeninJusho;
    }

    /**
     * 借受人住所のsetメソッドです。
     *
     * @param kariukeninJusho 借受人住所
     */
    public void setKariukeninJusho(RString kariukeninJusho) {
        this.kariukeninJusho = kariukeninJusho;
    }

    /**
     * 借受人氏名カナのgetメソッドです。
     *
     * @return 借受人氏名カナ
     */
    public AtenaKanaMeisho getKariukeninShimeiKana() {
        return kariukeninShimeiKana;
    }

    /**
     * 借受人氏名カナのsetメソッドです。
     *
     * @param kariukeninShimeiKana 借受人氏名カナ
     */
    public void setKariukeninShimeiKana(AtenaKanaMeisho kariukeninShimeiKana) {
        this.kariukeninShimeiKana = kariukeninShimeiKana;
    }

    /**
     * 借受人氏名のgetメソッドです。
     *
     * @return 借受人氏名
     */
    public AtenaMeisho getKariukeninShimei() {
        return kariukeninShimei;
    }

    /**
     * 借受人氏名のsetメソッドです。
     *
     * @param kariukeninShimei 借受人氏名
     */
    public void setKariukeninShimei(AtenaMeisho kariukeninShimei) {
        this.kariukeninShimei = kariukeninShimei;
    }

    /**
     * 借受人電話番号のgetメソッドです。
     *
     * @return 借受人電話番号
     */
    public TelNo getKariukeninTelNo() {
        return kariukeninTelNo;
    }

    /**
     * 借受人電話番号のsetメソッドです。
     *
     * @param kariukeninTelNo 借受人電話番号
     */
    public void setKariukeninTelNo(TelNo kariukeninTelNo) {
        this.kariukeninTelNo = kariukeninTelNo;
    }

    /**
     * 未償還金額のgetメソッドです。
     *
     * @return 未償還金額
     */
    public Decimal getMiShokanKingaku() {
        return miShokanKingaku;
    }

    /**
     * 未償還金額のsetメソッドです。
     *
     * @param miShokanKingaku 未償還金額
     */
    public void setMiShokanKingaku(Decimal miShokanKingaku) {
        this.miShokanKingaku = miShokanKingaku;
    }

    /**
     * 償還期限延長希望期間開始年月日のgetメソッドです。
     *
     * @return 償還期限延長希望期間開始年月日
     */
    public FlexibleDate getEnchoKiboKaishiYMD() {
        return enchoKiboKaishiYMD;
    }

    /**
     * 償還期限延長希望期間開始年月日のsetメソッドです。
     *
     * @param enchoKiboKaishiYMD 償還期限延長希望期間開始年月日
     */
    public void setEnchoKiboKaishiYMD(FlexibleDate enchoKiboKaishiYMD) {
        this.enchoKiboKaishiYMD = enchoKiboKaishiYMD;
    }

    /**
     * 償還期限延長希望期間終了年月日のgetメソッドです。
     *
     * @return 償還期限延長希望期間終了年月日
     */
    public FlexibleDate getEnchoKiboShuryoYMD() {
        return enchoKiboShuryoYMD;
    }

    /**
     * 償還期限延長希望期間終了年月日のsetメソッドです。
     *
     * @param enchoKiboShuryoYMD 償還期限延長希望期間終了年月日
     */
    public void setEnchoKiboShuryoYMD(FlexibleDate enchoKiboShuryoYMD) {
        this.enchoKiboShuryoYMD = enchoKiboShuryoYMD;
    }

    /**
     * 償還期限延長理由等のgetメソッドです。
     *
     * @return 償還期限延長理由等
     */
    public RString getEnchoRiyu() {
        return enchoRiyu;
    }

    /**
     * 償還期限延長理由等のsetメソッドです。
     *
     * @param enchoRiyu 償還期限延長理由等
     */
    public void setEnchoRiyu(RString enchoRiyu) {
        this.enchoRiyu = enchoRiyu;
    }

    /**
     * 償還期限変更決定年月日のgetメソッドです。
     *
     * @return 償還期限変更決定年月日
     */
    public FlexibleDate getHenkoKetteiYMD() {
        return henkoKetteiYMD;
    }

    /**
     * 償還期限変更決定年月日のsetメソッドです。
     *
     * @param henkoKetteiYMD 償還期限変更決定年月日
     */
    public void setHenkoKetteiYMD(FlexibleDate henkoKetteiYMD) {
        this.henkoKetteiYMD = henkoKetteiYMD;
    }

    /**
     * 償還期限変更承認・不承認区分のgetメソッドです。
     *
     * @return 償還期限変更承認・不承認区分
     */
    public RString getHenkoShonin_FuShoninKubun() {
        return henkoShonin_FuShoninKubun;
    }

    /**
     * 償還期限変更承認・不承認区分のsetメソッドです。
     *
     * @param henkoShonin_FuShoninKubun 償還期限変更承認・不承認区分
     */
    public void setHenkoShonin_FuShoninKubun(RString henkoShonin_FuShoninKubun) {
        this.henkoShonin_FuShoninKubun = henkoShonin_FuShoninKubun;
    }

    /**
     * 変更後償還期限のgetメソッドです。
     *
     * @return 変更後償還期限
     */
    public FlexibleDate getHenkoGoShokanKigenYMD() {
        return henkoGoShokanKigenYMD;
    }

    /**
     * 変更後償還期限のsetメソッドです。
     *
     * @param henkoGoShokanKigenYMD 変更後償還期限
     */
    public void setHenkoGoShokanKigenYMD(FlexibleDate henkoGoShokanKigenYMD) {
        this.henkoGoShokanKigenYMD = henkoGoShokanKigenYMD;
    }

    /**
     * 償還期限変更不承認理由のgetメソッドです。
     *
     * @return 償還期限変更不承認理由
     */
    public RString getHenkoFuShoninRiyu() {
        return henkoFuShoninRiyu;
    }

    /**
     * 償還期限変更不承認理由のsetメソッドです。
     *
     * @param henkoFuShoninRiyu 償還期限変更不承認理由
     */
    public void setHenkoFuShoninRiyu(RString henkoFuShoninRiyu) {
        this.henkoFuShoninRiyu = henkoFuShoninRiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(hihokenshaNo, kashitsukeKanriNo, shokanKigenEnchoUketsukeYMD, rirekiNo, shokanKigenEnchoShinseiYMD, kariukeninYubinNo, kariukeninJusho, kariukeninShimeiKana, kariukeninShimei, kariukeninTelNo, miShokanKingaku, enchoKiboKaishiYMD, enchoKiboShuryoYMD, enchoRiyu, henkoKetteiYMD, henkoShonin_FuShoninKubun, henkoGoShokanKigenYMD, henkoFuShoninRiyu);
    }

// </editor-fold>
}
