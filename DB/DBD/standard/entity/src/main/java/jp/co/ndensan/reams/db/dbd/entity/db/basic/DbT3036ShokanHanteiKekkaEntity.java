package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 償還払支給判定結果テーブルのエンティティクラスです。
 */
public class DbT3036ShokanHanteiKekkaEntity extends DbTableEntityBase<DbT3036ShokanHanteiKekkaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

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
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private FlexibleDate ketteiYMD;
    private RString shikyuHushikyuKetteiKubun;
    private Decimal shiharaiKingaku;
    private Decimal shiharaiKingakuUchiwakeRiyoshabun;
    private FlexibleYearMonth ketteiIchiranTorikomiYM;
    private Decimal zenkaiShiharaiKingaku;
    private Decimal sagakuKingakuGokei;
    private FlexibleDate ketteiTsuchishoSakuseiYMD;
    private RString ketteiTsuchiNo;
    private FlexibleDate furikomiMeisaishoSakuseiYMD;
    private RString ketteiTsuchiHakkoKubun;

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
    public void setHiHokenshaNo(@Nonnull HihokenshaNo hiHokenshaNo) {
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
    public void setServiceTeikyoYM(@Nonnull FlexibleYearMonth serviceTeikyoYM) {
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
    public void setSeiriNo(@Nonnull RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
     * 支給・不支給決定区分のgetメソッドです。
     *
     * @return 支給・不支給決定区分
     */
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
     * 前回支払金額のgetメソッドです。
     *
     * @return 前回支払金額
     */
    @CheckForNull
    public Decimal getZenkaiShiharaiKingaku() {
        return zenkaiShiharaiKingaku;
    }

    /**
     * 前回支払金額のsetメソッドです。
     *
     * @param zenkaiShiharaiKingaku 前回支払金額
     */
    public void setZenkaiShiharaiKingaku(Decimal zenkaiShiharaiKingaku) {
        this.zenkaiShiharaiKingaku = zenkaiShiharaiKingaku;
    }

    /**
     * 差額金額合計のgetメソッドです。
     *
     * @return 差額金額合計
     */
    @CheckForNull
    public Decimal getSagakuKingakuGokei() {
        return sagakuKingakuGokei;
    }

    /**
     * 差額金額合計のsetメソッドです。
     *
     * @param sagakuKingakuGokei 差額金額合計
     */
    public void setSagakuKingakuGokei(Decimal sagakuKingakuGokei) {
        this.sagakuKingakuGokei = sagakuKingakuGokei;
    }

    /**
     * 決定通知書作成年月日のgetメソッドです。
     *
     * @return 決定通知書作成年月日
     */
    @CheckForNull
    public FlexibleDate getKetteiTsuchishoSakuseiYMD() {
        return ketteiTsuchishoSakuseiYMD;
    }

    /**
     * 決定通知書作成年月日のsetメソッドです。
     *
     * @param ketteiTsuchishoSakuseiYMD 決定通知書作成年月日
     */
    public void setKetteiTsuchishoSakuseiYMD(FlexibleDate ketteiTsuchishoSakuseiYMD) {
        this.ketteiTsuchishoSakuseiYMD = ketteiTsuchishoSakuseiYMD;
    }

    /**
     * 決定通知Noのgetメソッドです。
     *
     * @return 決定通知No
     */
    @CheckForNull
    public RString getKetteiTsuchiNo() {
        return ketteiTsuchiNo;
    }

    /**
     * 決定通知Noのsetメソッドです。
     *
     * @param ketteiTsuchiNo 決定通知No
     */
    public void setKetteiTsuchiNo(RString ketteiTsuchiNo) {
        this.ketteiTsuchiNo = ketteiTsuchiNo;
    }

    /**
     * 振込明細書作成年月日のgetメソッドです。
     *
     * @return 振込明細書作成年月日
     */
    @CheckForNull
    public FlexibleDate getFurikomiMeisaishoSakuseiYMD() {
        return furikomiMeisaishoSakuseiYMD;
    }

    /**
     * 振込明細書作成年月日のsetメソッドです。
     *
     * @param furikomiMeisaishoSakuseiYMD 振込明細書作成年月日
     */
    public void setFurikomiMeisaishoSakuseiYMD(FlexibleDate furikomiMeisaishoSakuseiYMD) {
        this.furikomiMeisaishoSakuseiYMD = furikomiMeisaishoSakuseiYMD;
    }

    /**
     * 決定通知リアル発行区分のgetメソッドです。
     * <br/>
     * <br/>0:未発行、1:発行済
     *
     * @return 決定通知リアル発行区分
     */
    @CheckForNull
    public RString getKetteiTsuchiHakkoKubun() {
        return ketteiTsuchiHakkoKubun;
    }

    /**
     * 決定通知リアル発行区分のsetメソッドです。
     * <br/>
     * <br/>0:未発行、1:発行済
     *
     * @param ketteiTsuchiHakkoKubun 決定通知リアル発行区分
     */
    public void setKetteiTsuchiHakkoKubun(RString ketteiTsuchiHakkoKubun) {
        this.ketteiTsuchiHakkoKubun = ketteiTsuchiHakkoKubun;
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
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.ketteiYMD = entity.ketteiYMD;
        this.shikyuHushikyuKetteiKubun = entity.shikyuHushikyuKetteiKubun;
        this.shiharaiKingaku = entity.shiharaiKingaku;
        this.shiharaiKingakuUchiwakeRiyoshabun = entity.shiharaiKingakuUchiwakeRiyoshabun;
        this.ketteiIchiranTorikomiYM = entity.ketteiIchiranTorikomiYM;
        this.zenkaiShiharaiKingaku = entity.zenkaiShiharaiKingaku;
        this.sagakuKingakuGokei = entity.sagakuKingakuGokei;
        this.ketteiTsuchishoSakuseiYMD = entity.ketteiTsuchishoSakuseiYMD;
        this.ketteiTsuchiNo = entity.ketteiTsuchiNo;
        this.furikomiMeisaishoSakuseiYMD = entity.furikomiMeisaishoSakuseiYMD;
        this.ketteiTsuchiHakkoKubun = entity.ketteiTsuchiHakkoKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, shoKisaiHokenshaNo, ketteiYMD, shikyuHushikyuKetteiKubun, shiharaiKingaku, shiharaiKingakuUchiwakeRiyoshabun, ketteiIchiranTorikomiYM, zenkaiShiharaiKingaku, sagakuKingakuGokei, ketteiTsuchishoSakuseiYMD, ketteiTsuchiNo, furikomiMeisaishoSakuseiYMD, ketteiTsuchiHakkoKubun);
    }

// </editor-fold>
}
