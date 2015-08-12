package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuの項目定義クラスです
 *
 */
public class DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity extends DbTableEntityBase<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private Decimal rirekiNo;
    private Decimal zenkaiRiyoNissu;
    private Decimal konkaiKeikakuRiyoNissu;

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
    public void setTaishoYM(FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
     * 前回迄利用日数のgetメソッドです。
     *
     * @return 前回迄利用日数
     */
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
        this.zenkaiRiyoNissu = entity.zenkaiRiyoNissu;
        this.konkaiKeikakuRiyoNissu = entity.konkaiKeikakuRiyoNissu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoYM, rirekiNo, zenkaiRiyoNissu, konkaiKeikakuRiyoNissu);
    }

// </editor-fold>
}
