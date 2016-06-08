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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import java.util.Objects;

/**
 * 給付費貸付金決定テーブルのエンティティクラスです。
 */
public class DbT3087KyufuhiKashitsukeKinKetteiEntity extends DbTableEntityBase<DbT3087KyufuhiKashitsukeKinKetteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private Decimal rirekiNo;
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
     * 借入申請年月日のgetメソッドです。
     *
     * @return 借入申請年月日
     */
    public FlexibleDate getKariireShinseiYMD() {
        return kariireShinseiYMD;
    }

    /**
     * 借入申請年月日のsetメソッドです。
     *
     * @param kariireShinseiYMD 借入申請年月日
     */
    public void setKariireShinseiYMD(FlexibleDate kariireShinseiYMD) {
        this.kariireShinseiYMD = kariireShinseiYMD;
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
     * 貸付審査決定年月日のgetメソッドです。
     *
     * @return 貸付審査決定年月日
     */
    public FlexibleDate getKashitsukeShinsaKetteiYMD() {
        return kashitsukeShinsaKetteiYMD;
    }

    /**
     * 貸付審査決定年月日のsetメソッドです。
     *
     * @param kashitsukeShinsaKetteiYMD 貸付審査決定年月日
     */
    public void setKashitsukeShinsaKetteiYMD(FlexibleDate kashitsukeShinsaKetteiYMD) {
        this.kashitsukeShinsaKetteiYMD = kashitsukeShinsaKetteiYMD;
    }

    /**
     * 貸付承認・不承認区分のgetメソッドです。
     *
     * @return 貸付承認・不承認区分
     */
    public RString getKashitsukeShonin_FuShoninKubun() {
        return kashitsukeShonin_FuShoninKubun;
    }

    /**
     * 貸付承認・不承認区分のsetメソッドです。
     *
     * @param kashitsukeShonin_FuShoninKubun 貸付承認・不承認区分
     */
    public void setKashitsukeShonin_FuShoninKubun(RString kashitsukeShonin_FuShoninKubun) {
        this.kashitsukeShonin_FuShoninKubun = kashitsukeShonin_FuShoninKubun;
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
     * 貸付金額のgetメソッドです。
     *
     * @return 貸付金額
     */
    public Decimal getKashitsukeKingaku() {
        return kashitsukeKingaku;
    }

    /**
     * 貸付金額のsetメソッドです。
     *
     * @param kashitsukeKingaku 貸付金額
     */
    public void setKashitsukeKingaku(Decimal kashitsukeKingaku) {
        this.kashitsukeKingaku = kashitsukeKingaku;
    }

    /**
     * 償還方法のgetメソッドです。
     *
     * @return 償還方法
     */
    public RString getShokanHoho() {
        return shokanHoho;
    }

    /**
     * 償還方法のsetメソッドです。
     *
     * @param shokanHoho 償還方法
     */
    public void setShokanHoho(RString shokanHoho) {
        this.shokanHoho = shokanHoho;
    }

    /**
     * 償還期限のgetメソッドです。
     *
     * @return 償還期限
     */
    public FlexibleDate getShokanKigenYMD() {
        return shokanKigenYMD;
    }

    /**
     * 償還期限のsetメソッドです。
     *
     * @param shokanKigenYMD 償還期限
     */
    public void setShokanKigenYMD(FlexibleDate shokanKigenYMD) {
        this.shokanKigenYMD = shokanKigenYMD;
    }

    /**
     * 貸付年月日のgetメソッドです。
     *
     * @return 貸付年月日
     */
    public FlexibleDate getKashitsukeYMD() {
        return kashitsukeYMD;
    }

    /**
     * 貸付年月日のsetメソッドです。
     *
     * @param kashitsukeYMD 貸付年月日
     */
    public void setKashitsukeYMD(FlexibleDate kashitsukeYMD) {
        this.kashitsukeYMD = kashitsukeYMD;
    }

    /**
     * 貸付支払方法のgetメソッドです。
     * <br/>
     * <br/>1:窓口払い,2:口座払い
     *
     * @return 貸付支払方法
     */
    public RString getKashitsukeShiharaiHoho() {
        return kashitsukeShiharaiHoho;
    }

    /**
     * 貸付支払方法のsetメソッドです。
     * <br/>
     * <br/>1:窓口払い,2:口座払い
     *
     * @param kashitsukeShiharaiHoho 貸付支払方法
     */
    public void setKashitsukeShiharaiHoho(RString kashitsukeShiharaiHoho) {
        this.kashitsukeShiharaiHoho = kashitsukeShiharaiHoho;
    }

    /**
     * 貸付窓口支払場所のgetメソッドです。
     *
     * @return 貸付窓口支払場所
     */
    public RString getKashitsukeMadoguchiShiharaiBasho() {
        return kashitsukeMadoguchiShiharaiBasho;
    }

    /**
     * 貸付窓口支払場所のsetメソッドです。
     *
     * @param kashitsukeMadoguchiShiharaiBasho 貸付窓口支払場所
     */
    public void setKashitsukeMadoguchiShiharaiBasho(RString kashitsukeMadoguchiShiharaiBasho) {
        this.kashitsukeMadoguchiShiharaiBasho = kashitsukeMadoguchiShiharaiBasho;
    }

    /**
     * 貸付窓口開始年月日のgetメソッドです。
     *
     * @return 貸付窓口開始年月日
     */
    public FlexibleDate getKashitsukeMadoguchiKaishiYMD() {
        return kashitsukeMadoguchiKaishiYMD;
    }

    /**
     * 貸付窓口開始年月日のsetメソッドです。
     *
     * @param kashitsukeMadoguchiKaishiYMD 貸付窓口開始年月日
     */
    public void setKashitsukeMadoguchiKaishiYMD(FlexibleDate kashitsukeMadoguchiKaishiYMD) {
        this.kashitsukeMadoguchiKaishiYMD = kashitsukeMadoguchiKaishiYMD;
    }

    /**
     * 貸付窓口終了年月日のgetメソッドです。
     *
     * @return 貸付窓口終了年月日
     */
    public FlexibleDate getKashitsukeMadoguchiShuryoYMD() {
        return kashitsukeMadoguchiShuryoYMD;
    }

    /**
     * 貸付窓口終了年月日のsetメソッドです。
     *
     * @param kashitsukeMadoguchiShuryoYMD 貸付窓口終了年月日
     */
    public void setKashitsukeMadoguchiShuryoYMD(FlexibleDate kashitsukeMadoguchiShuryoYMD) {
        this.kashitsukeMadoguchiShuryoYMD = kashitsukeMadoguchiShuryoYMD;
    }

    /**
     * 貸付窓口閉庁内容のgetメソッドです。
     *
     * @return 貸付窓口閉庁内容
     */
    public RString getKashitsukeMadoguchiHeichoNaiyo() {
        return kashitsukeMadoguchiHeichoNaiyo;
    }

    /**
     * 貸付窓口閉庁内容のsetメソッドです。
     *
     * @param kashitsukeMadoguchiHeichoNaiyo 貸付窓口閉庁内容
     */
    public void setKashitsukeMadoguchiHeichoNaiyo(RString kashitsukeMadoguchiHeichoNaiyo) {
        this.kashitsukeMadoguchiHeichoNaiyo = kashitsukeMadoguchiHeichoNaiyo;
    }

    /**
     * 貸付窓口開始時間のgetメソッドです。
     *
     * @return 貸付窓口開始時間
     */
    public RString getKashitsukeMadoguchiKaishiTime() {
        return kashitsukeMadoguchiKaishiTime;
    }

    /**
     * 貸付窓口開始時間のsetメソッドです。
     *
     * @param kashitsukeMadoguchiKaishiTime 貸付窓口開始時間
     */
    public void setKashitsukeMadoguchiKaishiTime(RString kashitsukeMadoguchiKaishiTime) {
        this.kashitsukeMadoguchiKaishiTime = kashitsukeMadoguchiKaishiTime;
    }

    /**
     * 貸付窓口終了時間のgetメソッドです。
     *
     * @return 貸付窓口終了時間
     */
    public RString getKashitsukeMadoguchiShuryoTime() {
        return kashitsukeMadoguchiShuryoTime;
    }

    /**
     * 貸付窓口終了時間のsetメソッドです。
     *
     * @param kashitsukeMadoguchiShuryoTime 貸付窓口終了時間
     */
    public void setKashitsukeMadoguchiShuryoTime(RString kashitsukeMadoguchiShuryoTime) {
        this.kashitsukeMadoguchiShuryoTime = kashitsukeMadoguchiShuryoTime;
    }

    /**
     * 貸付不承認理由のgetメソッドです。
     *
     * @return 貸付不承認理由
     */
    public RString getKashitsukeFuShoninRiyu() {
        return kashitsukeFuShoninRiyu;
    }

    /**
     * 貸付不承認理由のsetメソッドです。
     *
     * @param kashitsukeFuShoninRiyu 貸付不承認理由
     */
    public void setKashitsukeFuShoninRiyu(RString kashitsukeFuShoninRiyu) {
        this.kashitsukeFuShoninRiyu = kashitsukeFuShoninRiyu;
    }

    /**
     * 識別コードのgetメソッドです。
     * <br/>
     * <br/>口座情報取得用
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * <br/>
     * <br/>口座情報取得用
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3087KyufuhiKashitsukeKinKetteiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(hihokenshaNo, kariireShinseiYMD, rirekiNo, kashitsukeShinsaKetteiYMD, kashitsukeShonin_FuShoninKubun, kashitsukeKanriNo, kashitsukeKingaku, shokanHoho, shokanKigenYMD, kashitsukeYMD, kashitsukeShiharaiHoho, kashitsukeMadoguchiShiharaiBasho, kashitsukeMadoguchiKaishiYMD, kashitsukeMadoguchiShuryoYMD, kashitsukeMadoguchiHeichoNaiyo, kashitsukeMadoguchiKaishiTime, kashitsukeMadoguchiShuryoTime, kashitsukeFuShoninRiyu, shikibetsuCode);
    }

// </editor-fold>
}
