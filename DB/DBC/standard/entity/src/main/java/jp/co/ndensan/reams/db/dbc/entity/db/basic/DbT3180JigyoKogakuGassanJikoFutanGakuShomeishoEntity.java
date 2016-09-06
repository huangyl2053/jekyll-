package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
 * 事業高額合算自己負担額証明書テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-9999-012 zhujun
 */
public class DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity extends DbTableEntityBase<DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho");

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
    private HokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private RString shikyuShinseishoSeiriNo;
    @PrimaryKey
    private HokenshaNo tennyumaeHokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private RString jikoFutanSeiriNo;
    private RString tennyumaeHokenshaMei;
    private FlexibleDate taishoKeisanKaishiYMD;
    private FlexibleDate taishoKeisanShuryoYMD;
    private FlexibleDate hihokenshaKaishiYMD;
    private FlexibleDate hihokenshaShuryoYMD;
    private FlexibleDate hakkoDate;
    private Decimal gokei_JikoFutanGaku;
    private Decimal gokei_70_74JikoFutanGaku;
    private Decimal gokei_Under70KogakuShikyuGaku;
    private Decimal gokei_70_74KogakuShikyuGaku;
    private YubinNo atesakiYubinNo;
    private RString atesakiShimei;
    private RString atesakiJusho;
    private RString madoguchi_TaishoshaHanteiCode;
    private RString biko;
    private FlexibleDate uketsukeDate;
    private FlexibleDate shikyugakuKeisanDate;

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
     * 証記載保険者番号のgetメソッドです。
     * <br/>
     * <br/>証記載保険者番号
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * <br/>
     * <br/>証記載保険者番号
     *
     * @param shokisaiHokenshaNo 証記載保険者番号
     */
    public void setShokisaiHokenshaNo(@Nonnull HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * 支給申請書整理番号のgetメソッドです。
     *
     * @return 支給申請書整理番号
     */
    public RString getShikyuShinseishoSeiriNo() {
        return shikyuShinseishoSeiriNo;
    }

    /**
     * 支給申請書整理番号のsetメソッドです。
     *
     * @param shikyuShinseishoSeiriNo 支給申請書整理番号
     */
    public void setShikyuShinseishoSeiriNo(@Nonnull RString shikyuShinseishoSeiriNo) {
        this.shikyuShinseishoSeiriNo = shikyuShinseishoSeiriNo;
    }

    /**
     * 転入前保険者番号のgetメソッドです。
     * <br/>
     * <br/>転入前の証記載保険者番号
     *
     * @return 転入前保険者番号
     */
    public HokenshaNo getTennyumaeHokenshaNo() {
        return tennyumaeHokenshaNo;
    }

    /**
     * 転入前保険者番号のsetメソッドです。
     * <br/>
     * <br/>転入前の証記載保険者番号
     *
     * @param tennyumaeHokenshaNo 転入前保険者番号
     */
    public void setTennyumaeHokenshaNo(@Nonnull HokenshaNo tennyumaeHokenshaNo) {
        this.tennyumaeHokenshaNo = tennyumaeHokenshaNo;
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
     * 転入前保険者名のgetメソッドです。
     *
     * @return 転入前保険者名
     */
    @CheckForNull
    public RString getTennyumaeHokenshaMei() {
        return tennyumaeHokenshaMei;
    }

    /**
     * 転入前保険者名のsetメソッドです。
     *
     * @param tennyumaeHokenshaMei 転入前保険者名
     */
    public void setTennyumaeHokenshaMei(RString tennyumaeHokenshaMei) {
        this.tennyumaeHokenshaMei = tennyumaeHokenshaMei;
    }

    /**
     * 対象計算期間開始年月日のgetメソッドです。
     *
     * @return 対象計算期間開始年月日
     */
    @CheckForNull
    public FlexibleDate getTaishoKeisanKaishiYMD() {
        return taishoKeisanKaishiYMD;
    }

    /**
     * 対象計算期間開始年月日のsetメソッドです。
     *
     * @param taishoKeisanKaishiYMD 対象計算期間開始年月日
     */
    public void setTaishoKeisanKaishiYMD(FlexibleDate taishoKeisanKaishiYMD) {
        this.taishoKeisanKaishiYMD = taishoKeisanKaishiYMD;
    }

    /**
     * 対象計算期間終了年月日のgetメソッドです。
     *
     * @return 対象計算期間終了年月日
     */
    @CheckForNull
    public FlexibleDate getTaishoKeisanShuryoYMD() {
        return taishoKeisanShuryoYMD;
    }

    /**
     * 対象計算期間終了年月日のsetメソッドです。
     *
     * @param taishoKeisanShuryoYMD 対象計算期間終了年月日
     */
    public void setTaishoKeisanShuryoYMD(FlexibleDate taishoKeisanShuryoYMD) {
        this.taishoKeisanShuryoYMD = taishoKeisanShuryoYMD;
    }

    /**
     * 被保険者期間開始年月日のgetメソッドです。
     *
     * @return 被保険者期間開始年月日
     */
    @CheckForNull
    public FlexibleDate getHihokenshaKaishiYMD() {
        return hihokenshaKaishiYMD;
    }

    /**
     * 被保険者期間開始年月日のsetメソッドです。
     *
     * @param hihokenshaKaishiYMD 被保険者期間開始年月日
     */
    public void setHihokenshaKaishiYMD(FlexibleDate hihokenshaKaishiYMD) {
        this.hihokenshaKaishiYMD = hihokenshaKaishiYMD;
    }

    /**
     * 被保険者期間終了年月日のgetメソッドです。
     *
     * @return 被保険者期間終了年月日
     */
    @CheckForNull
    public FlexibleDate getHihokenshaShuryoYMD() {
        return hihokenshaShuryoYMD;
    }

    /**
     * 被保険者期間終了年月日のsetメソッドです。
     *
     * @param hihokenshaShuryoYMD 被保険者期間終了年月日
     */
    public void setHihokenshaShuryoYMD(FlexibleDate hihokenshaShuryoYMD) {
        this.hihokenshaShuryoYMD = hihokenshaShuryoYMD;
    }

    /**
     * 発行年月日のgetメソッドです。
     *
     * @return 発行年月日
     */
    @CheckForNull
    public FlexibleDate getHakkoDate() {
        return hakkoDate;
    }

    /**
     * 発行年月日のsetメソッドです。
     *
     * @param hakkoDate 発行年月日
     */
    public void setHakkoDate(FlexibleDate hakkoDate) {
        this.hakkoDate = hakkoDate;
    }

    /**
     * 合計・自己負担額のgetメソッドです。
     *
     * @return 合計・自己負担額
     */
    @CheckForNull
    public Decimal getGokei_JikoFutanGaku() {
        return gokei_JikoFutanGaku;
    }

    /**
     * 合計・自己負担額のsetメソッドです。
     *
     * @param gokei_JikoFutanGaku 合計・自己負担額
     */
    public void setGokei_JikoFutanGaku(Decimal gokei_JikoFutanGaku) {
        this.gokei_JikoFutanGaku = gokei_JikoFutanGaku;
    }

    /**
     * 合計・70-74自己負担額（内訳）のgetメソッドです。
     *
     * @return 合計・70-74自己負担額（内訳）
     */
    @CheckForNull
    public Decimal getGokei_70_74JikoFutanGaku() {
        return gokei_70_74JikoFutanGaku;
    }

    /**
     * 合計・70-74自己負担額（内訳）のsetメソッドです。
     *
     * @param gokei_70_74JikoFutanGaku 合計・70-74自己負担額（内訳）
     */
    public void setGokei_70_74JikoFutanGaku(Decimal gokei_70_74JikoFutanGaku) {
        this.gokei_70_74JikoFutanGaku = gokei_70_74JikoFutanGaku;
    }

    /**
     * 合計・70未満高額支給額のgetメソッドです。
     *
     * @return 合計・70未満高額支給額
     */
    @CheckForNull
    public Decimal getGokei_Under70KogakuShikyuGaku() {
        return gokei_Under70KogakuShikyuGaku;
    }

    /**
     * 合計・70未満高額支給額のsetメソッドです。
     *
     * @param gokei_Under70KogakuShikyuGaku 合計・70未満高額支給額
     */
    public void setGokei_Under70KogakuShikyuGaku(Decimal gokei_Under70KogakuShikyuGaku) {
        this.gokei_Under70KogakuShikyuGaku = gokei_Under70KogakuShikyuGaku;
    }

    /**
     * 合計・70-74高額支給額のgetメソッドです。
     *
     * @return 合計・70-74高額支給額
     */
    @CheckForNull
    public Decimal getGokei_70_74KogakuShikyuGaku() {
        return gokei_70_74KogakuShikyuGaku;
    }

    /**
     * 合計・70-74高額支給額のsetメソッドです。
     *
     * @param gokei_70_74KogakuShikyuGaku 合計・70-74高額支給額
     */
    public void setGokei_70_74KogakuShikyuGaku(Decimal gokei_70_74KogakuShikyuGaku) {
        this.gokei_70_74KogakuShikyuGaku = gokei_70_74KogakuShikyuGaku;
    }

    /**
     * 支給額計算結果連絡先郵便番号のgetメソッドです。
     *
     * @return 支給額計算結果連絡先郵便番号
     */
    @CheckForNull
    public YubinNo getAtesakiYubinNo() {
        return atesakiYubinNo;
    }

    /**
     * 支給額計算結果連絡先郵便番号のsetメソッドです。
     *
     * @param atesakiYubinNo 支給額計算結果連絡先郵便番号
     */
    public void setAtesakiYubinNo(YubinNo atesakiYubinNo) {
        this.atesakiYubinNo = atesakiYubinNo;
    }

    /**
     * 支給額計算結果連絡先住所のgetメソッドです。
     *
     * @return 支給額計算結果連絡先住所
     */
    @CheckForNull
    public RString getAtesakiShimei() {
        return atesakiShimei;
    }

    /**
     * 支給額計算結果連絡先住所のsetメソッドです。
     *
     * @param atesakiShimei 支給額計算結果連絡先住所
     */
    public void setAtesakiShimei(RString atesakiShimei) {
        this.atesakiShimei = atesakiShimei;
    }

    /**
     * 支給額計算結果連絡先名称1のgetメソッドです。
     *
     * @return 支給額計算結果連絡先名称1
     */
    @CheckForNull
    public RString getAtesakiJusho() {
        return atesakiJusho;
    }

    /**
     * 支給額計算結果連絡先名称1のsetメソッドです。
     *
     * @param atesakiJusho 支給額計算結果連絡先名称1
     */
    public void setAtesakiJusho(RString atesakiJusho) {
        this.atesakiJusho = atesakiJusho;
    }

    /**
     * 支給額計算結果連絡先名称2のgetメソッドです。
     *
     * @return 支給額計算結果連絡先名称2
     */
    @CheckForNull
    public RString getMadoguchi_TaishoshaHanteiCode() {
        return madoguchi_TaishoshaHanteiCode;
    }

    /**
     * 支給額計算結果連絡先名称2のsetメソッドです。
     *
     * @param madoguchi_TaishoshaHanteiCode 支給額計算結果連絡先名称2
     */
    public void setMadoguchi_TaishoshaHanteiCode(RString madoguchi_TaishoshaHanteiCode) {
        this.madoguchi_TaishoshaHanteiCode = madoguchi_TaishoshaHanteiCode;
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
     * 受付年月日のgetメソッドです。
     *
     * @return 受付年月日
     */
    @CheckForNull
    public FlexibleDate getUketsukeDate() {
        return uketsukeDate;
    }

    /**
     * 受付年月日のsetメソッドです。
     *
     * @param uketsukeDate 受付年月日
     */
    public void setUketsukeDate(FlexibleDate uketsukeDate) {
        this.uketsukeDate = uketsukeDate;
    }

    /**
     * 支給額計算年月日のgetメソッドです。
     *
     * @return 支給額計算年月日
     */
    @CheckForNull
    public FlexibleDate getShikyugakuKeisanDate() {
        return shikyugakuKeisanDate;
    }

    /**
     * 支給額計算年月日のsetメソッドです。
     *
     * @param shikyugakuKeisanDate 支給額計算年月日
     */
    public void setShikyugakuKeisanDate(FlexibleDate shikyugakuKeisanDate) {
        this.shikyugakuKeisanDate = shikyugakuKeisanDate;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoNendo, other.taishoNendo)) {
            return false;
        }
        if (!Objects.equals(this.shokisaiHokenshaNo, other.shokisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikyuShinseishoSeiriNo, other.shikyuShinseishoSeiriNo)) {
            return false;
        }
        if (!Objects.equals(this.tennyumaeHokenshaNo, other.tennyumaeHokenshaNo)) {
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
    public void shallowCopy(DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.shikyuShinseishoSeiriNo = entity.shikyuShinseishoSeiriNo;
        this.tennyumaeHokenshaNo = entity.tennyumaeHokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.jikoFutanSeiriNo = entity.jikoFutanSeiriNo;
        this.tennyumaeHokenshaMei = entity.tennyumaeHokenshaMei;
        this.taishoKeisanKaishiYMD = entity.taishoKeisanKaishiYMD;
        this.taishoKeisanShuryoYMD = entity.taishoKeisanShuryoYMD;
        this.hihokenshaKaishiYMD = entity.hihokenshaKaishiYMD;
        this.hihokenshaShuryoYMD = entity.hihokenshaShuryoYMD;
        this.hakkoDate = entity.hakkoDate;
        this.gokei_JikoFutanGaku = entity.gokei_JikoFutanGaku;
        this.gokei_70_74JikoFutanGaku = entity.gokei_70_74JikoFutanGaku;
        this.gokei_Under70KogakuShikyuGaku = entity.gokei_Under70KogakuShikyuGaku;
        this.gokei_70_74KogakuShikyuGaku = entity.gokei_70_74KogakuShikyuGaku;
        this.atesakiYubinNo = entity.atesakiYubinNo;
        this.atesakiShimei = entity.atesakiShimei;
        this.atesakiJusho = entity.atesakiJusho;
        this.madoguchi_TaishoshaHanteiCode = entity.madoguchi_TaishoshaHanteiCode;
        this.biko = entity.biko;
        this.uketsukeDate = entity.uketsukeDate;
        this.shikyugakuKeisanDate = entity.shikyugakuKeisanDate;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, shokisaiHokenshaNo, shikyuShinseishoSeiriNo, tennyumaeHokenshaNo, rirekiNo, jikoFutanSeiriNo, tennyumaeHokenshaMei, taishoKeisanKaishiYMD, taishoKeisanShuryoYMD, hihokenshaKaishiYMD, hihokenshaShuryoYMD, hakkoDate, gokei_JikoFutanGaku, gokei_70_74JikoFutanGaku, gokei_Under70KogakuShikyuGaku, gokei_70_74KogakuShikyuGaku, atesakiYubinNo, atesakiShimei, atesakiJusho, madoguchi_TaishoshaHanteiCode, biko, uketsukeDate, shikyugakuKeisanDate);
    }

// </editor-fold>
}
