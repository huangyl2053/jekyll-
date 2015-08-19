package jp.co.ndensan.reams.db.dbc.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 基準収入額適用管理テーブルのエンティティクラスです。
 */
public class DbT3116KijunShunyugakuTekiyoKanriEntity extends DbTableEntityBase<DbT3116KijunShunyugakuTekiyoKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3116KijunShunyugakuTekiyoKanri");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private SetaiCode setaiCode;
    @PrimaryKey
    private FlexibleYear nendo;
    @PrimaryKey
    private Decimal rirekiNo;
    @PrimaryKey
    private HokenshaNo hihokenshaNo;
    private Decimal kotekiNenkinShunyugaku;
    private Decimal kyuyoShunyugaku;
    private Decimal sonotaShunyugaku;
    private Decimal santeiKijungaku;
    private FlexibleYearMonth tekiyoKaishiYMD;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate shinseishoSakuseiYMD;
    private FlexibleDate shinseishoSakuseiSetaiKijunYMD;
    private FlexibleDate ketteiTsuchishoHakkoYMD;
    private boolean atesakiInjiTaishoshaFlag;
    private Decimal nenshoFuyokojoUnder16Ninzu;
    private Decimal nenshoFuyokojoOver16Ninzu;
    private Decimal setaiinSoShunyugaku;
    private boolean setainushiFlag;
    private Decimal kazeiShotokugaku;
    private Decimal kazeiShotokugakuKojogo;

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
     * 世帯コードのgetメソッドです。
     *
     * @return 世帯コード
     */
    public SetaiCode getSetaiCode() {
        return setaiCode;
    }

    /**
     * 世帯コードのsetメソッドです。
     *
     * @param setaiCode 世帯コード
     */
    public void setSetaiCode(SetaiCode setaiCode) {
        this.setaiCode = setaiCode;
    }

    /**
     * 年度のgetメソッドです。
     *
     * @return 年度
     */
    public FlexibleYear getNendo() {
        return nendo;
    }

    /**
     * 年度のsetメソッドです。
     *
     * @param nendo 年度
     */
    public void setNendo(FlexibleYear nendo) {
        this.nendo = nendo;
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
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 公的年金収入額のgetメソッドです。
     *
     * @return 公的年金収入額
     */
    public Decimal getKotekiNenkinShunyugaku() {
        return kotekiNenkinShunyugaku;
    }

    /**
     * 公的年金収入額のsetメソッドです。
     *
     * @param kotekiNenkinShunyugaku 公的年金収入額
     */
    public void setKotekiNenkinShunyugaku(Decimal kotekiNenkinShunyugaku) {
        this.kotekiNenkinShunyugaku = kotekiNenkinShunyugaku;
    }

    /**
     * 給与収入額のgetメソッドです。
     *
     * @return 給与収入額
     */
    public Decimal getKyuyoShunyugaku() {
        return kyuyoShunyugaku;
    }

    /**
     * 給与収入額のsetメソッドです。
     *
     * @param kyuyoShunyugaku 給与収入額
     */
    public void setKyuyoShunyugaku(Decimal kyuyoShunyugaku) {
        this.kyuyoShunyugaku = kyuyoShunyugaku;
    }

    /**
     * その他の収入額のgetメソッドです。
     *
     * @return その他の収入額
     */
    public Decimal getSonotaShunyugaku() {
        return sonotaShunyugaku;
    }

    /**
     * その他の収入額のsetメソッドです。
     *
     * @param sonotaShunyugaku その他の収入額
     */
    public void setSonotaShunyugaku(Decimal sonotaShunyugaku) {
        this.sonotaShunyugaku = sonotaShunyugaku;
    }

    /**
     * 算定基準額のgetメソッドです。
     *
     * @return 算定基準額
     */
    public Decimal getSanteiKijungaku() {
        return santeiKijungaku;
    }

    /**
     * 算定基準額のsetメソッドです。
     *
     * @param santeiKijungaku 算定基準額
     */
    public void setSanteiKijungaku(Decimal santeiKijungaku) {
        this.santeiKijungaku = santeiKijungaku;
    }

    /**
     * 適用開始年月のgetメソッドです。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * 適用開始年月のsetメソッドです。
     *
     * @param tekiyoKaishiYMD 適用開始年月
     */
    public void setTekiyoKaishiYMD(FlexibleYearMonth tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * 申請日のgetメソッドです。
     *
     * @return 申請日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請日のsetメソッドです。
     *
     * @param shinseiYMD 申請日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 決定日のgetメソッドです。
     *
     * @return 決定日
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 決定日のsetメソッドです。
     *
     * @param ketteiYMD 決定日
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * 申請書作成日のgetメソッドです。
     *
     * @return 申請書作成日
     */
    public FlexibleDate getShinseishoSakuseiYMD() {
        return shinseishoSakuseiYMD;
    }

    /**
     * 申請書作成日のsetメソッドです。
     *
     * @param shinseishoSakuseiYMD 申請書作成日
     */
    public void setShinseishoSakuseiYMD(FlexibleDate shinseishoSakuseiYMD) {
        this.shinseishoSakuseiYMD = shinseishoSakuseiYMD;
    }

    /**
     * 申請書作成の世帯基準日のgetメソッドです。
     *
     * @return 申請書作成の世帯基準日
     */
    public FlexibleDate getShinseishoSakuseiSetaiKijunYMD() {
        return shinseishoSakuseiSetaiKijunYMD;
    }

    /**
     * 申請書作成の世帯基準日のsetメソッドです。
     *
     * @param shinseishoSakuseiSetaiKijunYMD 申請書作成の世帯基準日
     */
    public void setShinseishoSakuseiSetaiKijunYMD(FlexibleDate shinseishoSakuseiSetaiKijunYMD) {
        this.shinseishoSakuseiSetaiKijunYMD = shinseishoSakuseiSetaiKijunYMD;
    }

    /**
     * 決定通知書発行日のgetメソッドです。
     *
     * @return 決定通知書発行日
     */
    public FlexibleDate getKetteiTsuchishoHakkoYMD() {
        return ketteiTsuchishoHakkoYMD;
    }

    /**
     * 決定通知書発行日のsetメソッドです。
     *
     * @param ketteiTsuchishoHakkoYMD 決定通知書発行日
     */
    public void setKetteiTsuchishoHakkoYMD(FlexibleDate ketteiTsuchishoHakkoYMD) {
        this.ketteiTsuchishoHakkoYMD = ketteiTsuchishoHakkoYMD;
    }

    /**
     * 宛先印字対象者フラグのgetメソッドです。
     * <br/>
     * <br/>お知らせ通知の宛先に印字した被保険者かどうか
     *
     * @return 宛先印字対象者フラグ
     */
    public boolean getAtesakiInjiTaishoshaFlag() {
        return atesakiInjiTaishoshaFlag;
    }

    /**
     * 宛先印字対象者フラグのsetメソッドです。
     * <br/>
     * <br/>お知らせ通知の宛先に印字した被保険者かどうか
     *
     * @param atesakiInjiTaishoshaFlag 宛先印字対象者フラグ
     */
    public void setAtesakiInjiTaishoshaFlag(boolean atesakiInjiTaishoshaFlag) {
        this.atesakiInjiTaishoshaFlag = atesakiInjiTaishoshaFlag;
    }

    /**
     * 年少扶養控除（16歳未満）人数のgetメソッドです。
     *
     * @return 年少扶養控除（16歳未満）人数
     */
    public Decimal getNenshoFuyokojoUnder16Ninzu() {
        return nenshoFuyokojoUnder16Ninzu;
    }

    /**
     * 年少扶養控除（16歳未満）人数のsetメソッドです。
     *
     * @param nenshoFuyokojoUnder16Ninzu 年少扶養控除（16歳未満）人数
     */
    public void setNenshoFuyokojoUnder16Ninzu(Decimal nenshoFuyokojoUnder16Ninzu) {
        this.nenshoFuyokojoUnder16Ninzu = nenshoFuyokojoUnder16Ninzu;
    }

    /**
     * 年少扶養控除（16～18歳未満）人数のgetメソッドです。
     *
     * @return 年少扶養控除（16～18歳未満）人数
     */
    public Decimal getNenshoFuyokojoOver16Ninzu() {
        return nenshoFuyokojoOver16Ninzu;
    }

    /**
     * 年少扶養控除（16～18歳未満）人数のsetメソッドです。
     *
     * @param nenshoFuyokojoOver16Ninzu 年少扶養控除（16～18歳未満）人数
     */
    public void setNenshoFuyokojoOver16Ninzu(Decimal nenshoFuyokojoOver16Ninzu) {
        this.nenshoFuyokojoOver16Ninzu = nenshoFuyokojoOver16Ninzu;
    }

    /**
     * 世帯員の総収入額のgetメソッドです。
     *
     * @return 世帯員の総収入額
     */
    public Decimal getSetaiinSoShunyugaku() {
        return setaiinSoShunyugaku;
    }

    /**
     * 世帯員の総収入額のsetメソッドです。
     *
     * @param setaiinSoShunyugaku 世帯員の総収入額
     */
    public void setSetaiinSoShunyugaku(Decimal setaiinSoShunyugaku) {
        this.setaiinSoShunyugaku = setaiinSoShunyugaku;
    }

    /**
     * 世帯主フラグのgetメソッドです。
     * <br/>
     * <br/>年度の前年12/31時点の世帯主かどうか
     *
     * @return 世帯主フラグ
     */
    public boolean getSetainushiFlag() {
        return setainushiFlag;
    }

    /**
     * 世帯主フラグのsetメソッドです。
     * <br/>
     * <br/>年度の前年12/31時点の世帯主かどうか
     *
     * @param setainushiFlag 世帯主フラグ
     */
    public void setSetainushiFlag(boolean setainushiFlag) {
        this.setainushiFlag = setainushiFlag;
    }

    /**
     * 課税所得額のgetメソッドです。
     *
     * @return 課税所得額
     */
    public Decimal getKazeiShotokugaku() {
        return kazeiShotokugaku;
    }

    /**
     * 課税所得額のsetメソッドです。
     *
     * @param kazeiShotokugaku 課税所得額
     */
    public void setKazeiShotokugaku(Decimal kazeiShotokugaku) {
        this.kazeiShotokugaku = kazeiShotokugaku;
    }

    /**
     * 課税所得額（控除後）のgetメソッドです。
     *
     * @return 課税所得額（控除後）
     */
    public Decimal getKazeiShotokugakuKojogo() {
        return kazeiShotokugakuKojogo;
    }

    /**
     * 課税所得額（控除後）のsetメソッドです。
     *
     * @param kazeiShotokugakuKojogo 課税所得額（控除後）
     */
    public void setKazeiShotokugakuKojogo(Decimal kazeiShotokugakuKojogo) {
        this.kazeiShotokugakuKojogo = kazeiShotokugakuKojogo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3116KijunShunyugakuTekiyoKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3116KijunShunyugakuTekiyoKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3116KijunShunyugakuTekiyoKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.setaiCode, other.setaiCode)) {
            return false;
        }
        if (!Objects.equals(this.nendo, other.nendo)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3116KijunShunyugakuTekiyoKanriEntity entity) {
        this.setaiCode = entity.setaiCode;
        this.nendo = entity.nendo;
        this.rirekiNo = entity.rirekiNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kotekiNenkinShunyugaku = entity.kotekiNenkinShunyugaku;
        this.kyuyoShunyugaku = entity.kyuyoShunyugaku;
        this.sonotaShunyugaku = entity.sonotaShunyugaku;
        this.santeiKijungaku = entity.santeiKijungaku;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.shinseishoSakuseiYMD = entity.shinseishoSakuseiYMD;
        this.shinseishoSakuseiSetaiKijunYMD = entity.shinseishoSakuseiSetaiKijunYMD;
        this.ketteiTsuchishoHakkoYMD = entity.ketteiTsuchishoHakkoYMD;
        this.atesakiInjiTaishoshaFlag = entity.atesakiInjiTaishoshaFlag;
        this.nenshoFuyokojoUnder16Ninzu = entity.nenshoFuyokojoUnder16Ninzu;
        this.nenshoFuyokojoOver16Ninzu = entity.nenshoFuyokojoOver16Ninzu;
        this.setaiinSoShunyugaku = entity.setaiinSoShunyugaku;
        this.setainushiFlag = entity.setainushiFlag;
        this.kazeiShotokugaku = entity.kazeiShotokugaku;
        this.kazeiShotokugakuKojogo = entity.kazeiShotokugakuKojogo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(setaiCode, nendo, rirekiNo, hihokenshaNo, kotekiNenkinShunyugaku, kyuyoShunyugaku, sonotaShunyugaku, santeiKijungaku, tekiyoKaishiYMD, shinseiYMD, ketteiYMD, shinseishoSakuseiYMD, shinseishoSakuseiSetaiKijunYMD, ketteiTsuchishoHakkoYMD, atesakiInjiTaishoshaFlag, nenshoFuyokojoUnder16Ninzu, nenshoFuyokojoOver16Ninzu, setaiinSoShunyugaku, setainushiFlag, kazeiShotokugaku, kazeiShotokugakuKojogo);
    }

// </editor-fold>
}
