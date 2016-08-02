package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuの項目定義クラスです
 *
 */
public class DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity extends DbTableEntityBase<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu");

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
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private int rirekiNo;
    @PrimaryKey
    private FlexibleYearMonth riyoYM;
    private Decimal zenkaiRiyoNissu;
    private Decimal konkaiKeikakuRiyoNissu;
    private RString zanteiKubun;
    private RString koshinKubun;
    private FlexibleDate koshinYMD;
    private FlexibleYearMonth sofuYM;

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
     * 対象年月のgetメソッドです。
     * 
     * @return 対象年月
     */
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * 対象年月のsetメソッドです。
     * 
     * @param taishoYM 対象年月
     */
    public void setTaishoYM(@Nonnull FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
     * 利用年月のgetメソッドです。
     * 
     * @return 利用年月
     */
    public FlexibleYearMonth getRiyoYM() {
        return riyoYM;
    }

    /**
     * 利用年月のsetメソッドです。
     * 
     * @param riyoYM 利用年月
     */
    public void setRiyoYM(@Nonnull FlexibleYearMonth riyoYM) {
        this.riyoYM = riyoYM;
    }

    /**
     * 前回迄利用日数のgetメソッドです。
     * 
     * @return 前回迄利用日数
     */
    @CheckForNull
    public Decimal getZenkaiRiyoNissu() {
        return zenkaiRiyoNissu;
    }

    /**
     * 前回迄利用日数のsetメソッドです。
     * 
     * @param zenkaiRiyoNissu 前回迄利用日数
     */
    public void setZenkaiRiyoNissu(Decimal zenkaiRiyoNissu) {
        this.zenkaiRiyoNissu = zenkaiRiyoNissu;
    }

    /**
     * 今回計画利用日数のgetメソッドです。
     * 
     * @return 今回計画利用日数
     */
    @CheckForNull
    public Decimal getKonkaiKeikakuRiyoNissu() {
        return konkaiKeikakuRiyoNissu;
    }

    /**
     * 今回計画利用日数のsetメソッドです。
     * 
     * @param konkaiKeikakuRiyoNissu 今回計画利用日数
     */
    public void setKonkaiKeikakuRiyoNissu(Decimal konkaiKeikakuRiyoNissu) {
        this.konkaiKeikakuRiyoNissu = konkaiKeikakuRiyoNissu;
    }

    /**
     * 暫定区分のgetメソッドです。
     * 
     * @return 暫定区分
     */
    @CheckForNull
    public RString getZanteiKubun() {
        return zanteiKubun;
    }

    /**
     * 暫定区分のsetメソッドです。
     * 
     * @param zanteiKubun 暫定区分
     */
    public void setZanteiKubun(RString zanteiKubun) {
        this.zanteiKubun = zanteiKubun;
    }

    /**
     * 更新区分のgetメソッドです。
     * <br/>
     * <br/>DBC.Enum.給付管理表情報作成区分コード
     * 
     * @return 更新区分
     */
    @CheckForNull
    public RString getKoshinKubun() {
        return koshinKubun;
    }

    /**
     * 更新区分のsetメソッドです。
     * <br/>
     * <br/>DBC.Enum.給付管理表情報作成区分コード
     * 
     * @param koshinKubun 更新区分
     */
    public void setKoshinKubun(RString koshinKubun) {
        this.koshinKubun = koshinKubun;
    }

    /**
     * 更新年月日のgetメソッドです。
     * 
     * @return 更新年月日
     */
    @CheckForNull
    public FlexibleDate getKoshinYMD() {
        return koshinYMD;
    }

    /**
     * 更新年月日のsetメソッドです。
     * 
     * @param koshinYMD 更新年月日
     */
    public void setKoshinYMD(FlexibleDate koshinYMD) {
        this.koshinYMD = koshinYMD;
    }

    /**
     * 送付年月のgetメソッドです。
     * 
     * @return 送付年月
     */
    @CheckForNull
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * 送付年月のsetメソッドです。
     * 
     * @param sofuYM 送付年月
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoYM, other.taishoYM)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        if (!Objects.equals(this.riyoYM, other.riyoYM)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoYM = entity.taishoYM;
        this.rirekiNo = entity.rirekiNo;
        this.riyoYM = entity.riyoYM;
        this.zenkaiRiyoNissu = entity.zenkaiRiyoNissu;
        this.konkaiKeikakuRiyoNissu = entity.konkaiKeikakuRiyoNissu;
        this.zanteiKubun = entity.zanteiKubun;
        this.koshinKubun = entity.koshinKubun;
        this.koshinYMD = entity.koshinYMD;
        this.sofuYM = entity.sofuYM;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoYM, rirekiNo, riyoYM, zenkaiRiyoNissu, konkaiKeikakuRiyoNissu, zanteiKubun, koshinKubun, koshinYMD, sofuYM);
    }

// </editor-fold>


}
