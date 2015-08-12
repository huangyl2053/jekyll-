package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算申請書加入歴テーブルのエンティティクラスです。
 */
public class DbT3069KogakuGassanShinseishoKanyurekiEntity extends DbTableEntityBase<DbT3069KogakuGassanShinseishoKanyurekiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3069KogakuGassanShinseishoKanyureki");

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
    private RString seiriNo;
    @PrimaryKey
    private RString kanyurekiNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private RString hokenshaMei;
    private FlexibleDate kanyuKaishiYMD;
    private FlexibleDate kanyuShuryoYMD;
    private RString jikoFutanShomeisho_SeiriNo;

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
    public void setTaishoNendo(FlexibleYear taishoNendo) {
        this.taishoNendo = taishoNendo;
    }

    /**
     * 保険者番号のgetメソッドです。
     * <br/>
     * <br/>証記載保険者番号では無い
     *
     * @return 保険者番号
     */
    public HokenshaNo getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * 保険者番号のsetメソッドです。
     * <br/>
     * <br/>証記載保険者番号では無い
     *
     * @param hokenshaNo 保険者番号
     */
    public void setHokenshaNo(HokenshaNo hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * 整理番号のgetメソッドです。
     * <br/>
     * <br/>年度単位で”000001”からの連番
     *
     * @return 整理番号
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * 整理番号のsetメソッドです。
     * <br/>
     * <br/>年度単位で”000001”からの連番
     *
     * @param seiriNo 整理番号
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * 加入歴番号のgetメソッドです。
     * <br/>
     * <br/>”01”からの連番
     *
     * @return 加入歴番号
     */
    public RString getKanyurekiNo() {
        return kanyurekiNo;
    }

    /**
     * 加入歴番号のsetメソッドです。
     * <br/>
     * <br/>”01”からの連番
     *
     * @param kanyurekiNo 加入歴番号
     */
    public void setKanyurekiNo(RString kanyurekiNo) {
        this.kanyurekiNo = kanyurekiNo;
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
     * 保険者名のgetメソッドです。
     *
     * @return 保険者名
     */
    public RString getHokenshaMei() {
        return hokenshaMei;
    }

    /**
     * 保険者名のsetメソッドです。
     *
     * @param hokenshaMei 保険者名
     */
    public void setHokenshaMei(RString hokenshaMei) {
        this.hokenshaMei = hokenshaMei;
    }

    /**
     * 加入期間開始年月日のgetメソッドです。
     *
     * @return 加入期間開始年月日
     */
    public FlexibleDate getKanyuKaishiYMD() {
        return kanyuKaishiYMD;
    }

    /**
     * 加入期間開始年月日のsetメソッドです。
     *
     * @param kanyuKaishiYMD 加入期間開始年月日
     */
    public void setKanyuKaishiYMD(FlexibleDate kanyuKaishiYMD) {
        this.kanyuKaishiYMD = kanyuKaishiYMD;
    }

    /**
     * 加入期間終了年月日のgetメソッドです。
     *
     * @return 加入期間終了年月日
     */
    public FlexibleDate getKanyuShuryoYMD() {
        return kanyuShuryoYMD;
    }

    /**
     * 加入期間終了年月日のsetメソッドです。
     *
     * @param kanyuShuryoYMD 加入期間終了年月日
     */
    public void setKanyuShuryoYMD(FlexibleDate kanyuShuryoYMD) {
        this.kanyuShuryoYMD = kanyuShuryoYMD;
    }

    /**
     * 自己負担額証明書整理番号のgetメソッドです。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString getJikoFutanShomeisho_SeiriNo() {
        return jikoFutanShomeisho_SeiriNo;
    }

    /**
     * 自己負担額証明書整理番号のsetメソッドです。
     *
     * @param jikoFutanShomeisho_SeiriNo 自己負担額証明書整理番号
     */
    public void setJikoFutanShomeisho_SeiriNo(RString jikoFutanShomeisho_SeiriNo) {
        this.jikoFutanShomeisho_SeiriNo = jikoFutanShomeisho_SeiriNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3069KogakuGassanShinseishoKanyurekiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3069KogakuGassanShinseishoKanyurekiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3069KogakuGassanShinseishoKanyurekiEntity other) {
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
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
            return false;
        }
        if (!Objects.equals(this.kanyurekiNo, other.kanyurekiNo)) {
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
    public void shallowCopy(DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.hokenshaNo = entity.hokenshaNo;
        this.seiriNo = entity.seiriNo;
        this.kanyurekiNo = entity.kanyurekiNo;
        this.rirekiNo = entity.rirekiNo;
        this.hokenshaMei = entity.hokenshaMei;
        this.kanyuKaishiYMD = entity.kanyuKaishiYMD;
        this.kanyuShuryoYMD = entity.kanyuShuryoYMD;
        this.jikoFutanShomeisho_SeiriNo = entity.jikoFutanShomeisho_SeiriNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, hokenshaNo, seiriNo, kanyurekiNo, rirekiNo, hokenshaMei, kanyuKaishiYMD, kanyuShuryoYMD, jikoFutanShomeisho_SeiriNo);
    }

// </editor-fold>
}
