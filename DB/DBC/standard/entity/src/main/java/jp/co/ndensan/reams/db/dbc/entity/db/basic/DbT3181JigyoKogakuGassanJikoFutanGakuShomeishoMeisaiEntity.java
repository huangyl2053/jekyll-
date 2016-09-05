package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 事業高額合算自己負担額証明書明細テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-9999-012 zhujun
 */
public class DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity extends DbTableEntityBase<DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisai");

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
    private HokenshaNo tennyumaeHokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    @PrimaryKey
    private RString taishoM;
    private Decimal jikoFutanGaku;
    private Decimal uchisu_70_74JikoFutanGaku;
    private Decimal under_70KogakuShikyuGaku;
    private Decimal over_70_74KogakuShikyuGaku;
    private RString tekiyo;

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
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * <br/>
     * <br/>証記載保険者番号
     *
     * @param hokenshaNo 証記載保険者番号
     */
    public void setHokenshaNo(@Nonnull HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
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
     *
     * @return 転入前保険者番号
     */
    public HokenshaNo getTennyumaeHokenshaNo() {
        return tennyumaeHokenshaNo;
    }

    /**
     * 転入前保険者番号のsetメソッドです。
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
     * 対象月のgetメソッドです。
     * <br/>
     * <br/>平成20年度：当年004月-012月＋翌年101月-107月、以降の年度：当年008月-012月＋翌年101月-107月
     *
     * @return 対象月
     */
    public RString getTaishoM() {
        return taishoM;
    }

    /**
     * 対象月のsetメソッドです。
     * <br/>
     * <br/>平成20年度：当年004月-012月＋翌年101月-107月、以降の年度：当年008月-012月＋翌年101月-107月
     *
     * @param taishoM 対象月
     */
    public void setTaishoM(@Nonnull RString taishoM) {
        this.taishoM = taishoM;
    }

    /**
     * 自己負担額のgetメソッドです。
     *
     * @return 自己負担額
     */
    @CheckForNull
    public Decimal getJikoFutanGaku() {
        return jikoFutanGaku;
    }

    /**
     * 自己負担額のsetメソッドです。
     *
     * @param jikoFutanGaku 自己負担額
     */
    public void setJikoFutanGaku(Decimal jikoFutanGaku) {
        this.jikoFutanGaku = jikoFutanGaku;
    }

    /**
     * 70-74自己負担額（内数）のgetメソッドです。
     *
     * @return 70-74自己負担額（内数）
     */
    @CheckForNull
    public Decimal getUchisu_70_74JikoFutanGaku() {
        return uchisu_70_74JikoFutanGaku;
    }

    /**
     * 70-74自己負担額（内数）のsetメソッドです。
     *
     * @param uchisu_70_74JikoFutanGaku 70-74自己負担額（内数）
     */
    public void setUchisu_70_74JikoFutanGaku(Decimal uchisu_70_74JikoFutanGaku) {
        this.uchisu_70_74JikoFutanGaku = uchisu_70_74JikoFutanGaku;
    }

    /**
     * 70未満高額支給額のgetメソッドです。
     *
     * @return 70未満高額支給額
     */
    @CheckForNull
    public Decimal getUnder_70KogakuShikyuGaku() {
        return under_70KogakuShikyuGaku;
    }

    /**
     * 70未満高額支給額のsetメソッドです。
     *
     * @param under_70KogakuShikyuGaku 70未満高額支給額
     */
    public void setUnder_70KogakuShikyuGaku(Decimal under_70KogakuShikyuGaku) {
        this.under_70KogakuShikyuGaku = under_70KogakuShikyuGaku;
    }

    /**
     * 70-74高額支給額のgetメソッドです。
     *
     * @return 70-74高額支給額
     */
    @CheckForNull
    public Decimal getOver_70_74KogakuShikyuGaku() {
        return over_70_74KogakuShikyuGaku;
    }

    /**
     * 70-74高額支給額のsetメソッドです。
     *
     * @param over_70_74KogakuShikyuGaku 70-74高額支給額
     */
    public void setOver_70_74KogakuShikyuGaku(Decimal over_70_74KogakuShikyuGaku) {
        this.over_70_74KogakuShikyuGaku = over_70_74KogakuShikyuGaku;
    }

    /**
     * 摘要のgetメソッドです。
     *
     * @return 摘要
     */
    @CheckForNull
    public RString getTekiyo() {
        return tekiyo;
    }

    /**
     * 摘要のsetメソッドです。
     *
     * @param tekiyo 摘要
     */
    public void setTekiyo(RString tekiyo) {
        this.tekiyo = tekiyo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity other) {
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
        if (!Objects.equals(this.tennyumaeHokenshaNo, other.tennyumaeHokenshaNo)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        if (!Objects.equals(this.taishoM, other.taishoM)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.hokenshaNo = entity.hokenshaNo;
        this.shikyuShinseishoSeiriNo = entity.shikyuShinseishoSeiriNo;
        this.tennyumaeHokenshaNo = entity.tennyumaeHokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.taishoM = entity.taishoM;
        this.jikoFutanGaku = entity.jikoFutanGaku;
        this.uchisu_70_74JikoFutanGaku = entity.uchisu_70_74JikoFutanGaku;
        this.under_70KogakuShikyuGaku = entity.under_70KogakuShikyuGaku;
        this.over_70_74KogakuShikyuGaku = entity.over_70_74KogakuShikyuGaku;
        this.tekiyo = entity.tekiyo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, hokenshaNo, shikyuShinseishoSeiriNo, tennyumaeHokenshaNo, rirekiNo, taishoM, jikoFutanGaku, uchisu_70_74JikoFutanGaku, under_70KogakuShikyuGaku, over_70_74KogakuShikyuGaku, tekiyo);
    }

// </editor-fold>
}
