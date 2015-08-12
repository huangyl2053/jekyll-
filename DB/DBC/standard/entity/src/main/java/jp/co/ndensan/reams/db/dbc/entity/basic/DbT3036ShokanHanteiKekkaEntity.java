package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 償還払支給判定結果テーブルのエンティティクラスです。
 */
public class DbT3036ShokanHanteiKekkaEntity extends DbTableEntityBase<DbT3036ShokanHanteiKekkaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3036ShokanHanteiKekka");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private HokenshaNo shoKisaiHokenshaNo;
    private FlexibleDate ketteiYMD;
    private RString shikyuHushikyuKetteiKubun;
    private Decimal shiharaiKingaku;
    private Decimal shiharaiKingakuUchiwakeRiyoshabun;
    private FlexibleYearMonth ketteiIchiranTorikomiYM;

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
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hiHokenshaNo 被保険者番号
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * サービス提供年月のsetメソッドです。
     *
     * @param serviceTeikyoYM サービス提供年月
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * 整理番号のsetメソッドです。
     *
     * @param seiriNo 整理番号
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
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
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 決定年月日のgetメソッドです。
     *
     * @return 決定年月日
     */
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
     * 支給・不支給決定区分のgetメソッドです。
     *
     * @return 支給・不支給決定区分
     */
    public RString getShikyuHushikyuKetteiKubun() {
        return shikyuHushikyuKetteiKubun;
    }

    /**
     * 支給・不支給決定区分のsetメソッドです。
     *
     * @param shikyuHushikyuKetteiKubun 支給・不支給決定区分
     */
    public void setShikyuHushikyuKetteiKubun(RString shikyuHushikyuKetteiKubun) {
        this.shikyuHushikyuKetteiKubun = shikyuHushikyuKetteiKubun;
    }

    /**
     * 支払金額のgetメソッドです。
     *
     * @return 支払金額
     */
    public Decimal getShiharaiKingaku() {
        return shiharaiKingaku;
    }

    /**
     * 支払金額のsetメソッドです。
     *
     * @param shiharaiKingaku 支払金額
     */
    public void setShiharaiKingaku(Decimal shiharaiKingaku) {
        this.shiharaiKingaku = shiharaiKingaku;
    }

    /**
     * 支払金額内訳・利用者分のgetメソッドです。
     *
     * @return 支払金額内訳・利用者分
     */
    public Decimal getShiharaiKingakuUchiwakeRiyoshabun() {
        return shiharaiKingakuUchiwakeRiyoshabun;
    }

    /**
     * 支払金額内訳・利用者分のsetメソッドです。
     *
     * @param shiharaiKingakuUchiwakeRiyoshabun 支払金額内訳・利用者分
     */
    public void setShiharaiKingakuUchiwakeRiyoshabun(Decimal shiharaiKingakuUchiwakeRiyoshabun) {
        this.shiharaiKingakuUchiwakeRiyoshabun = shiharaiKingakuUchiwakeRiyoshabun;
    }

    /**
     * 決定一覧取込年月のgetメソッドです。
     *
     * @return 決定一覧取込年月
     */
    public FlexibleYearMonth getKetteiIchiranTorikomiYM() {
        return ketteiIchiranTorikomiYM;
    }

    /**
     * 決定一覧取込年月のsetメソッドです。
     *
     * @param ketteiIchiranTorikomiYM 決定一覧取込年月
     */
    public void setKetteiIchiranTorikomiYM(FlexibleYearMonth ketteiIchiranTorikomiYM) {
        this.ketteiIchiranTorikomiYM = ketteiIchiranTorikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3036ShokanHanteiKekkaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3036ShokanHanteiKekkaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3036ShokanHanteiKekkaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
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
    public void shallowCopy(DbT3036ShokanHanteiKekkaEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.rirekiNo = entity.rirekiNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.ketteiYMD = entity.ketteiYMD;
        this.shikyuHushikyuKetteiKubun = entity.shikyuHushikyuKetteiKubun;
        this.shiharaiKingaku = entity.shiharaiKingaku;
        this.shiharaiKingakuUchiwakeRiyoshabun = entity.shiharaiKingakuUchiwakeRiyoshabun;
        this.ketteiIchiranTorikomiYM = entity.ketteiIchiranTorikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, rirekiNo, shoKisaiHokenshaNo, ketteiYMD, shikyuHushikyuKetteiKubun, shiharaiKingaku, shiharaiKingakuUchiwakeRiyoshabun, ketteiIchiranTorikomiYM);
    }

// </editor-fold>
}
