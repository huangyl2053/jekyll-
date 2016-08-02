package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;

/**
 * 高額合算支給不支給決定テーブルのエンティティクラスです。
 */
public class DbT3074KogakuGassanShikyuFushikyuKetteiEntity extends DbTableEntityBase<DbT3074KogakuGassanShikyuFushikyuKetteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3074KogakuGassanShikyuFushikyuKettei");

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
    private RString shikyuSeiriNo;
    @PrimaryKey
    private int rirekiNo;
    private RString jikoFutanSeiriNo;
    private RString hokenSeidoCode;
    private RString kokuho_HihokenshaShoKigo;
    private FlexibleDate keisanKaishiYMD;
    private FlexibleDate keisanShuryoYMD;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private Decimal jikoFutanSogaku;
    private RString shikyuKubunCode;
    private Decimal shikyugaku;
    private RString kyufuShurui;
    private RString fushikyuRiyu;
    private RString biko;
    private RString shiharaiHohoKubun;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString heichoNaiyo;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private FlexibleDate ketteiTsuchiSakuseiYMD;
    private FlexibleDate furikomiTsuchiSakuseiYMD;
    private FlexibleYearMonth uketoriYM;
    private long kozaID;
    private RString ketteiTsuchiRealHakkoFlag;

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
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 対象年度のgetメソッドです。
     * 
     * @return 対象年度
     */
    public FlexibleYear getTaishoNendo() {
        return taishoNendo;
    }

    /**
     * 対象年度のsetメソッドです。
     * 
     * @param taishoNendo 対象年度
     */
    public void setTaishoNendo(@Nonnull FlexibleYear taishoNendo) {
        this.taishoNendo = taishoNendo;
    }

    /**
     * 保険者番号のgetメソッドです。
     * 
     * @return 保険者番号
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * 保険者番号のsetメソッドです。
     * 
     * @param hokenshaNo 保険者番号
     */
    public void setHokenshaNo(@Nonnull HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * 支給申請書整理番号のgetメソッドです。
     * <br/>
     * <br/>IF上は「連絡票整理番号」
     * 
     * @return 支給申請書整理番号
     */
    public RString getShikyuSeiriNo() {
        return shikyuSeiriNo;
    }

    /**
     * 支給申請書整理番号のsetメソッドです。
     * <br/>
     * <br/>IF上は「連絡票整理番号」
     * 
     * @param shikyuSeiriNo 支給申請書整理番号
     */
    public void setShikyuSeiriNo(@Nonnull RString shikyuSeiriNo) {
        this.shikyuSeiriNo = shikyuSeiriNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 自己負担額証明書整理番号のgetメソッドです。
     * 
     * @return 自己負担額証明書整理番号
     */
    @CheckForNull
    public RString getJikoFutanSeiriNo() {
        return jikoFutanSeiriNo;
    }

    /**
     * 自己負担額証明書整理番号のsetメソッドです。
     * 
     * @param jikoFutanSeiriNo 自己負担額証明書整理番号
     */
    public void setJikoFutanSeiriNo(RString jikoFutanSeiriNo) {
        this.jikoFutanSeiriNo = jikoFutanSeiriNo;
    }

    /**
     * 保険制度コードのgetメソッドです。
     * 
     * @return 保険制度コード
     */
    @CheckForNull
    public RString getHokenSeidoCode() {
        return hokenSeidoCode;
    }

    /**
     * 保険制度コードのsetメソッドです。
     * 
     * @param hokenSeidoCode 保険制度コード
     */
    public void setHokenSeidoCode(RString hokenSeidoCode) {
        this.hokenSeidoCode = hokenSeidoCode;
    }

    /**
     * 国保 被保険者証記号のgetメソッドです。
     * 
     * @return 国保 被保険者証記号
     */
    @CheckForNull
    public RString getKokuho_HihokenshaShoKigo() {
        return kokuho_HihokenshaShoKigo;
    }

    /**
     * 国保 被保険者証記号のsetメソッドです。
     * 
     * @param kokuho_HihokenshaShoKigo 国保 被保険者証記号
     */
    public void setKokuho_HihokenshaShoKigo(RString kokuho_HihokenshaShoKigo) {
        this.kokuho_HihokenshaShoKigo = kokuho_HihokenshaShoKigo;
    }

    /**
     * 対象計算期間開始年月日のgetメソッドです。
     * 
     * @return 対象計算期間開始年月日
     */
    @CheckForNull
    public FlexibleDate getKeisanKaishiYMD() {
        return keisanKaishiYMD;
    }

    /**
     * 対象計算期間開始年月日のsetメソッドです。
     * 
     * @param keisanKaishiYMD 対象計算期間開始年月日
     */
    public void setKeisanKaishiYMD(FlexibleDate keisanKaishiYMD) {
        this.keisanKaishiYMD = keisanKaishiYMD;
    }

    /**
     * 対象計算期間終了年月日のgetメソッドです。
     * 
     * @return 対象計算期間終了年月日
     */
    @CheckForNull
    public FlexibleDate getKeisanShuryoYMD() {
        return keisanShuryoYMD;
    }

    /**
     * 対象計算期間終了年月日のsetメソッドです。
     * 
     * @param keisanShuryoYMD 対象計算期間終了年月日
     */
    public void setKeisanShuryoYMD(FlexibleDate keisanShuryoYMD) {
        this.keisanShuryoYMD = keisanShuryoYMD;
    }

    /**
     * 申請年月日のgetメソッドです。
     * 
     * @return 申請年月日
     */
    @CheckForNull
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     * 
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 決定年月日のgetメソッドです。
     * 
     * @return 決定年月日
     */
    @CheckForNull
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 決定年月日のsetメソッドです。
     * 
     * @param ketteiYMD 決定年月日
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * 自己負担総額のgetメソッドです。
     * 
     * @return 自己負担総額
     */
    @CheckForNull
    public Decimal getJikoFutanSogaku() {
        return jikoFutanSogaku;
    }

    /**
     * 自己負担総額のsetメソッドです。
     * 
     * @param jikoFutanSogaku 自己負担総額
     */
    public void setJikoFutanSogaku(Decimal jikoFutanSogaku) {
        this.jikoFutanSogaku = jikoFutanSogaku;
    }

    /**
     * 支給区分コードのgetメソッドです。
     * 
     * @return 支給区分コード
     */
    @CheckForNull
    public RString getShikyuKubunCode() {
        return shikyuKubunCode;
    }

    /**
     * 支給区分コードのsetメソッドです。
     * 
     * @param shikyuKubunCode 支給区分コード
     */
    public void setShikyuKubunCode(RString shikyuKubunCode) {
        this.shikyuKubunCode = shikyuKubunCode;
    }

    /**
     * 支給額のgetメソッドです。
     * 
     * @return 支給額
     */
    @CheckForNull
    public Decimal getShikyugaku() {
        return shikyugaku;
    }

    /**
     * 支給額のsetメソッドです。
     * 
     * @param shikyugaku 支給額
     */
    public void setShikyugaku(Decimal shikyugaku) {
        this.shikyugaku = shikyugaku;
    }

    /**
     * 給付の種類のgetメソッドです。
     * 
     * @return 給付の種類
     */
    @CheckForNull
    public RString getKyufuShurui() {
        return kyufuShurui;
    }

    /**
     * 給付の種類のsetメソッドです。
     * 
     * @param kyufuShurui 給付の種類
     */
    public void setKyufuShurui(RString kyufuShurui) {
        this.kyufuShurui = kyufuShurui;
    }

    /**
     * 不支給理由のgetメソッドです。
     * 
     * @return 不支給理由
     */
    @CheckForNull
    public RString getFushikyuRiyu() {
        return fushikyuRiyu;
    }

    /**
     * 不支給理由のsetメソッドです。
     * 
     * @param fushikyuRiyu 不支給理由
     */
    public void setFushikyuRiyu(RString fushikyuRiyu) {
        this.fushikyuRiyu = fushikyuRiyu;
    }

    /**
     * 備考のgetメソッドです。
     * 
     * @return 備考
     */
    @CheckForNull
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     * 
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * 支払方法区分のgetメソッドです。
     * 
     * @return 支払方法区分
     */
    @CheckForNull
    public RString getShiharaiHohoKubun() {
        return shiharaiHohoKubun;
    }

    /**
     * 支払方法区分のsetメソッドです。
     * 
     * @param shiharaiHohoKubun 支払方法区分
     */
    public void setShiharaiHohoKubun(RString shiharaiHohoKubun) {
        this.shiharaiHohoKubun = shiharaiHohoKubun;
    }

    /**
     * 支払場所のgetメソッドです。
     * 
     * @return 支払場所
     */
    @CheckForNull
    public RString getShiharaiBasho() {
        return shiharaiBasho;
    }

    /**
     * 支払場所のsetメソッドです。
     * 
     * @param shiharaiBasho 支払場所
     */
    public void setShiharaiBasho(RString shiharaiBasho) {
        this.shiharaiBasho = shiharaiBasho;
    }

    /**
     * 支払期間開始年月日のgetメソッドです。
     * 
     * @return 支払期間開始年月日
     */
    @CheckForNull
    public FlexibleDate getShiharaiKaishiYMD() {
        return shiharaiKaishiYMD;
    }

    /**
     * 支払期間開始年月日のsetメソッドです。
     * 
     * @param shiharaiKaishiYMD 支払期間開始年月日
     */
    public void setShiharaiKaishiYMD(FlexibleDate shiharaiKaishiYMD) {
        this.shiharaiKaishiYMD = shiharaiKaishiYMD;
    }

    /**
     * 支払期間終了年月日のgetメソッドです。
     * 
     * @return 支払期間終了年月日
     */
    @CheckForNull
    public FlexibleDate getShiharaiShuryoYMD() {
        return shiharaiShuryoYMD;
    }

    /**
     * 支払期間終了年月日のsetメソッドです。
     * 
     * @param shiharaiShuryoYMD 支払期間終了年月日
     */
    public void setShiharaiShuryoYMD(FlexibleDate shiharaiShuryoYMD) {
        this.shiharaiShuryoYMD = shiharaiShuryoYMD;
    }

    /**
     * 閉庁内容のgetメソッドです。
     * 
     * @return 閉庁内容
     */
    @CheckForNull
    public RString getHeichoNaiyo() {
        return heichoNaiyo;
    }

    /**
     * 閉庁内容のsetメソッドです。
     * 
     * @param heichoNaiyo 閉庁内容
     */
    public void setHeichoNaiyo(RString heichoNaiyo) {
        this.heichoNaiyo = heichoNaiyo;
    }

    /**
     * 支払期間開始時間のgetメソッドです。
     * 
     * @return 支払期間開始時間
     */
    @CheckForNull
    public RString getShiharaiKaishiTime() {
        return shiharaiKaishiTime;
    }

    /**
     * 支払期間開始時間のsetメソッドです。
     * 
     * @param shiharaiKaishiTime 支払期間開始時間
     */
    public void setShiharaiKaishiTime(RString shiharaiKaishiTime) {
        this.shiharaiKaishiTime = shiharaiKaishiTime;
    }

    /**
     * 支払期間終了時間のgetメソッドです。
     * 
     * @return 支払期間終了時間
     */
    @CheckForNull
    public RString getShiharaiShuryoTime() {
        return shiharaiShuryoTime;
    }

    /**
     * 支払期間終了時間のsetメソッドです。
     * 
     * @param shiharaiShuryoTime 支払期間終了時間
     */
    public void setShiharaiShuryoTime(RString shiharaiShuryoTime) {
        this.shiharaiShuryoTime = shiharaiShuryoTime;
    }

    /**
     * 決定通知書作成年月日のgetメソッドです。
     * 
     * @return 決定通知書作成年月日
     */
    @CheckForNull
    public FlexibleDate getKetteiTsuchiSakuseiYMD() {
        return ketteiTsuchiSakuseiYMD;
    }

    /**
     * 決定通知書作成年月日のsetメソッドです。
     * 
     * @param ketteiTsuchiSakuseiYMD 決定通知書作成年月日
     */
    public void setKetteiTsuchiSakuseiYMD(FlexibleDate ketteiTsuchiSakuseiYMD) {
        this.ketteiTsuchiSakuseiYMD = ketteiTsuchiSakuseiYMD;
    }

    /**
     * 振込通知書作成年月日のgetメソッドです。
     * 
     * @return 振込通知書作成年月日
     */
    @CheckForNull
    public FlexibleDate getFurikomiTsuchiSakuseiYMD() {
        return furikomiTsuchiSakuseiYMD;
    }

    /**
     * 振込通知書作成年月日のsetメソッドです。
     * 
     * @param furikomiTsuchiSakuseiYMD 振込通知書作成年月日
     */
    public void setFurikomiTsuchiSakuseiYMD(FlexibleDate furikomiTsuchiSakuseiYMD) {
        this.furikomiTsuchiSakuseiYMD = furikomiTsuchiSakuseiYMD;
    }

    /**
     * 受取年月のgetメソッドです。
     * 
     * @return 受取年月
     */
    @CheckForNull
    public FlexibleYearMonth getUketoriYM() {
        return uketoriYM;
    }

    /**
     * 受取年月のsetメソッドです。
     * 
     * @param uketoriYM 受取年月
     */
    public void setUketoriYM(FlexibleYearMonth uketoriYM) {
        this.uketoriYM = uketoriYM;
    }

    /**
     * 口座IDのgetメソッドです。
     * 
     * @return 口座ID
     */
    @CheckForNull
    public long getKozaID() {
        return kozaID;
    }

    /**
     * 口座IDのsetメソッドです。
     * 
     * @param kozaID 口座ID
     */
    public void setKozaID(long kozaID) {
        this.kozaID = kozaID;
    }

    /**
     * 決定通知リアル発行フラグのgetメソッドです。
     * 
     * @return 決定通知リアル発行フラグ
     */
    @CheckForNull
    public RString getKetteiTsuchiRealHakkoFlag() {
        return ketteiTsuchiRealHakkoFlag;
    }

    /**
     * 決定通知リアル発行フラグのsetメソッドです。
     * 
     * @param ketteiTsuchiRealHakkoFlag 決定通知リアル発行フラグ
     */
    public void setKetteiTsuchiRealHakkoFlag(RString ketteiTsuchiRealHakkoFlag) {
        this.ketteiTsuchiRealHakkoFlag = ketteiTsuchiRealHakkoFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3074KogakuGassanShikyuFushikyuKetteiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3074KogakuGassanShikyuFushikyuKetteiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3074KogakuGassanShikyuFushikyuKetteiEntity other) {
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
        if (!Objects.equals(this.shikyuSeiriNo, other.shikyuSeiriNo)) {
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
    public void shallowCopy(DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.hokenshaNo = entity.hokenshaNo;
        this.shikyuSeiriNo = entity.shikyuSeiriNo;
        this.rirekiNo = entity.rirekiNo;
        this.jikoFutanSeiriNo = entity.jikoFutanSeiriNo;
        this.hokenSeidoCode = entity.hokenSeidoCode;
        this.kokuho_HihokenshaShoKigo = entity.kokuho_HihokenshaShoKigo;
        this.keisanKaishiYMD = entity.keisanKaishiYMD;
        this.keisanShuryoYMD = entity.keisanShuryoYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.jikoFutanSogaku = entity.jikoFutanSogaku;
        this.shikyuKubunCode = entity.shikyuKubunCode;
        this.shikyugaku = entity.shikyugaku;
        this.kyufuShurui = entity.kyufuShurui;
        this.fushikyuRiyu = entity.fushikyuRiyu;
        this.biko = entity.biko;
        this.shiharaiHohoKubun = entity.shiharaiHohoKubun;
        this.shiharaiBasho = entity.shiharaiBasho;
        this.shiharaiKaishiYMD = entity.shiharaiKaishiYMD;
        this.shiharaiShuryoYMD = entity.shiharaiShuryoYMD;
        this.heichoNaiyo = entity.heichoNaiyo;
        this.shiharaiKaishiTime = entity.shiharaiKaishiTime;
        this.shiharaiShuryoTime = entity.shiharaiShuryoTime;
        this.ketteiTsuchiSakuseiYMD = entity.ketteiTsuchiSakuseiYMD;
        this.furikomiTsuchiSakuseiYMD = entity.furikomiTsuchiSakuseiYMD;
        this.uketoriYM = entity.uketoriYM;
        this.kozaID = entity.kozaID;
        this.ketteiTsuchiRealHakkoFlag = entity.ketteiTsuchiRealHakkoFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, hokenshaNo, shikyuSeiriNo, rirekiNo, jikoFutanSeiriNo, hokenSeidoCode, kokuho_HihokenshaShoKigo, keisanKaishiYMD, keisanShuryoYMD, shinseiYMD, ketteiYMD, jikoFutanSogaku, shikyuKubunCode, shikyugaku, kyufuShurui, fushikyuRiyu, biko, shiharaiHohoKubun, shiharaiBasho, shiharaiKaishiYMD, shiharaiShuryoYMD, heichoNaiyo, shiharaiKaishiTime, shiharaiShuryoTime, ketteiTsuchiSakuseiYMD, furikomiTsuchiSakuseiYMD, uketoriYM, kozaID, ketteiTsuchiRealHakkoFlag);
    }

// </editor-fold>


}
