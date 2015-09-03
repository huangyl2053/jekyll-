package jp.co.ndensan.reams.db.dbc.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 受給者限度額管理テーブルのエンティティクラスです。
 */
public class DbT7116JukyushaGendoGakuKanriEntity extends DbTableEntityBase<DbT7116JukyushaGendoGakuKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7116JukyushaGendoGakuKanri");

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
    private RString shikibetsuKubun;
    @PrimaryKey
    private FlexibleYearMonth yukoKaishiYM;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleYearMonth yukoShuryoYM;
    private RString yoKaigoJotaiKubun;
    private RString kakudaiBaisu;
    private Decimal kiriwakeTaniSu;
    private FlexibleDate torokuYMD;
    private FlexibleDate henkoYMD;
    private RString gendoGakuKanriKikanSu;
    private RString shinTaikeiKanriKubun;
    private RString shinTaikeiKakudaiTekiyoUmu;

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
     * 識別区分のgetメソッドです。
     *
     * @return 識別区分
     */
    public RString getShikibetsuKubun() {
        return shikibetsuKubun;
    }

    /**
     * 識別区分のsetメソッドです。
     *
     * @param shikibetsuKubun 識別区分
     */
    public void setShikibetsuKubun(RString shikibetsuKubun) {
        this.shikibetsuKubun = shikibetsuKubun;
    }

    /**
     * 有効開始年月のgetメソッドです。
     *
     * @return 有効開始年月
     */
    public FlexibleYearMonth getYukoKaishiYM() {
        return yukoKaishiYM;
    }

    /**
     * 有効開始年月のsetメソッドです。
     *
     * @param yukoKaishiYM 有効開始年月
     */
    public void setYukoKaishiYM(FlexibleYearMonth yukoKaishiYM) {
        this.yukoKaishiYM = yukoKaishiYM;
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
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 有効終了年月のgetメソッドです。
     *
     * @return 有効終了年月
     */
    public FlexibleYearMonth getYukoShuryoYM() {
        return yukoShuryoYM;
    }

    /**
     * 有効終了年月のsetメソッドです。
     *
     * @param yukoShuryoYM 有効終了年月
     */
    public void setYukoShuryoYM(FlexibleYearMonth yukoShuryoYM) {
        this.yukoShuryoYM = yukoShuryoYM;
    }

    /**
     * 要介護状態区分のgetメソッドです。
     *
     * @return 要介護状態区分
     */
    public RString getYoKaigoJotaiKubun() {
        return yoKaigoJotaiKubun;
    }

    /**
     * 要介護状態区分のsetメソッドです。
     *
     * @param yoKaigoJotaiKubun 要介護状態区分
     */
    public void setYoKaigoJotaiKubun(RString yoKaigoJotaiKubun) {
        this.yoKaigoJotaiKubun = yoKaigoJotaiKubun;
    }

    /**
     * 拡大倍数のgetメソッドです。
     *
     * @return 拡大倍数
     */
    public RString getKakudaiBaisu() {
        return kakudaiBaisu;
    }

    /**
     * 拡大倍数のsetメソッドです。
     *
     * @param kakudaiBaisu 拡大倍数
     */
    public void setKakudaiBaisu(RString kakudaiBaisu) {
        this.kakudaiBaisu = kakudaiBaisu;
    }

    /**
     * 切り分け単位数のgetメソッドです。
     *
     * @return 切り分け単位数
     */
    public Decimal getKiriwakeTaniSu() {
        return kiriwakeTaniSu;
    }

    /**
     * 切り分け単位数のsetメソッドです。
     *
     * @param kiriwakeTaniSu 切り分け単位数
     */
    public void setKiriwakeTaniSu(Decimal kiriwakeTaniSu) {
        this.kiriwakeTaniSu = kiriwakeTaniSu;
    }

    /**
     * 登録年月日のgetメソッドです。
     *
     * @return 登録年月日
     */
    public FlexibleDate getTorokuYMD() {
        return torokuYMD;
    }

    /**
     * 登録年月日のsetメソッドです。
     *
     * @param torokuYMD 登録年月日
     */
    public void setTorokuYMD(FlexibleDate torokuYMD) {
        this.torokuYMD = torokuYMD;
    }

    /**
     * 変更年月日のgetメソッドです。
     *
     * @return 変更年月日
     */
    public FlexibleDate getHenkoYMD() {
        return henkoYMD;
    }

    /**
     * 変更年月日のsetメソッドです。
     *
     * @param henkoYMD 変更年月日
     */
    public void setHenkoYMD(FlexibleDate henkoYMD) {
        this.henkoYMD = henkoYMD;
    }

    /**
     * 限度額管理期間数のgetメソッドです。
     *
     * @return 限度額管理期間数
     */
    public RString getGendoGakuKanriKikanSu() {
        return gendoGakuKanriKikanSu;
    }

    /**
     * 限度額管理期間数のsetメソッドです。
     *
     * @param gendoGakuKanriKikanSu 限度額管理期間数
     */
    public void setGendoGakuKanriKikanSu(RString gendoGakuKanriKikanSu) {
        this.gendoGakuKanriKikanSu = gendoGakuKanriKikanSu;
    }

    /**
     * 新体系管理区分のgetメソッドです。
     *
     * @return 新体系管理区分
     */
    public RString getShinTaikeiKanriKubun() {
        return shinTaikeiKanriKubun;
    }

    /**
     * 新体系管理区分のsetメソッドです。
     *
     * @param shinTaikeiKanriKubun 新体系管理区分
     */
    public void setShinTaikeiKanriKubun(RString shinTaikeiKanriKubun) {
        this.shinTaikeiKanriKubun = shinTaikeiKanriKubun;
    }

    /**
     * 新体系拡大適用有無のgetメソッドです。
     *
     * @return 新体系拡大適用有無
     */
    public RString getShinTaikeiKakudaiTekiyoUmu() {
        return shinTaikeiKakudaiTekiyoUmu;
    }

    /**
     * 新体系拡大適用有無のsetメソッドです。
     *
     * @param shinTaikeiKakudaiTekiyoUmu 新体系拡大適用有無
     */
    public void setShinTaikeiKakudaiTekiyoUmu(RString shinTaikeiKakudaiTekiyoUmu) {
        this.shinTaikeiKakudaiTekiyoUmu = shinTaikeiKakudaiTekiyoUmu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7116JukyushaGendoGakuKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7116JukyushaGendoGakuKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7116JukyushaGendoGakuKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuKubun, other.shikibetsuKubun)) {
            return false;
        }
        if (!Objects.equals(this.yukoKaishiYM, other.yukoKaishiYM)) {
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
    public void shallowCopy(DbT7116JukyushaGendoGakuKanriEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikibetsuKubun = entity.shikibetsuKubun;
        this.yukoKaishiYM = entity.yukoKaishiYM;
        this.rirekiNo = entity.rirekiNo;
        this.yukoShuryoYM = entity.yukoShuryoYM;
        this.yoKaigoJotaiKubun = entity.yoKaigoJotaiKubun;
        this.kakudaiBaisu = entity.kakudaiBaisu;
        this.kiriwakeTaniSu = entity.kiriwakeTaniSu;
        this.torokuYMD = entity.torokuYMD;
        this.henkoYMD = entity.henkoYMD;
        this.gendoGakuKanriKikanSu = entity.gendoGakuKanriKikanSu;
        this.shinTaikeiKanriKubun = entity.shinTaikeiKanriKubun;
        this.shinTaikeiKakudaiTekiyoUmu = entity.shinTaikeiKakudaiTekiyoUmu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shikibetsuKubun, yukoKaishiYM, rirekiNo, yukoShuryoYM, yoKaigoJotaiKubun, kakudaiBaisu, kiriwakeTaniSu, torokuYMD, henkoYMD, gendoGakuKanriKikanSu, shinTaikeiKanriKubun, shinTaikeiKakudaiTekiyoUmu);
    }

// </editor-fold>
}
