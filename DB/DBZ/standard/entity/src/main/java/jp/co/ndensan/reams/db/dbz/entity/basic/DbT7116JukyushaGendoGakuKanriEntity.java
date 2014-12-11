package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
 * DbT7116JukyushaGendoGakuKanriの項目定義クラスです
 *
 */
public class DbT7116JukyushaGendoGakuKanriEntity extends DbTableEntityBase<DbT7116JukyushaGendoGakuKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private YMDHMS shoriTimestamp;
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
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getShikibetsuKubun
     *
     * @return shikibetsuKubun
     */
    public RString getShikibetsuKubun() {
        return shikibetsuKubun;
    }

    /**
     * setShikibetsuKubun
     *
     * @param shikibetsuKubun shikibetsuKubun
     */
    public void setShikibetsuKubun(RString shikibetsuKubun) {
        this.shikibetsuKubun = shikibetsuKubun;
    }

    /**
     * getYukoKaishiYM
     *
     * @return yukoKaishiYM
     */
    public FlexibleYearMonth getYukoKaishiYM() {
        return yukoKaishiYM;
    }

    /**
     * setYukoKaishiYM
     *
     * @param yukoKaishiYM yukoKaishiYM
     */
    public void setYukoKaishiYM(FlexibleYearMonth yukoKaishiYM) {
        this.yukoKaishiYM = yukoKaishiYM;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getYukoShuryoYM
     *
     * @return yukoShuryoYM
     */
    public FlexibleYearMonth getYukoShuryoYM() {
        return yukoShuryoYM;
    }

    /**
     * setYukoShuryoYM
     *
     * @param yukoShuryoYM yukoShuryoYM
     */
    public void setYukoShuryoYM(FlexibleYearMonth yukoShuryoYM) {
        this.yukoShuryoYM = yukoShuryoYM;
    }

    /**
     * getYoKaigoJotaiKubun
     *
     * @return yoKaigoJotaiKubun
     */
    public RString getYoKaigoJotaiKubun() {
        return yoKaigoJotaiKubun;
    }

    /**
     * setYoKaigoJotaiKubun
     *
     * @param yoKaigoJotaiKubun yoKaigoJotaiKubun
     */
    public void setYoKaigoJotaiKubun(RString yoKaigoJotaiKubun) {
        this.yoKaigoJotaiKubun = yoKaigoJotaiKubun;
    }

    /**
     * getKakudaiBaisu
     *
     * @return kakudaiBaisu
     */
    public RString getKakudaiBaisu() {
        return kakudaiBaisu;
    }

    /**
     * setKakudaiBaisu
     *
     * @param kakudaiBaisu kakudaiBaisu
     */
    public void setKakudaiBaisu(RString kakudaiBaisu) {
        this.kakudaiBaisu = kakudaiBaisu;
    }

    /**
     * getKiriwakeTaniSu
     *
     * @return kiriwakeTaniSu
     */
    public Decimal getKiriwakeTaniSu() {
        return kiriwakeTaniSu;
    }

    /**
     * setKiriwakeTaniSu
     *
     * @param kiriwakeTaniSu kiriwakeTaniSu
     */
    public void setKiriwakeTaniSu(Decimal kiriwakeTaniSu) {
        this.kiriwakeTaniSu = kiriwakeTaniSu;
    }

    /**
     * getTorokuYMD
     *
     * @return torokuYMD
     */
    public FlexibleDate getTorokuYMD() {
        return torokuYMD;
    }

    /**
     * setTorokuYMD
     *
     * @param torokuYMD torokuYMD
     */
    public void setTorokuYMD(FlexibleDate torokuYMD) {
        this.torokuYMD = torokuYMD;
    }

    /**
     * getHenkoYMD
     *
     * @return henkoYMD
     */
    public FlexibleDate getHenkoYMD() {
        return henkoYMD;
    }

    /**
     * setHenkoYMD
     *
     * @param henkoYMD henkoYMD
     */
    public void setHenkoYMD(FlexibleDate henkoYMD) {
        this.henkoYMD = henkoYMD;
    }

    /**
     * getGendoGakuKanriKikanSu
     *
     * @return gendoGakuKanriKikanSu
     */
    public RString getGendoGakuKanriKikanSu() {
        return gendoGakuKanriKikanSu;
    }

    /**
     * setGendoGakuKanriKikanSu
     *
     * @param gendoGakuKanriKikanSu gendoGakuKanriKikanSu
     */
    public void setGendoGakuKanriKikanSu(RString gendoGakuKanriKikanSu) {
        this.gendoGakuKanriKikanSu = gendoGakuKanriKikanSu;
    }

    /**
     * getShinTaikeiKanriKubun
     *
     * @return shinTaikeiKanriKubun
     */
    public RString getShinTaikeiKanriKubun() {
        return shinTaikeiKanriKubun;
    }

    /**
     * setShinTaikeiKanriKubun
     *
     * @param shinTaikeiKanriKubun shinTaikeiKanriKubun
     */
    public void setShinTaikeiKanriKubun(RString shinTaikeiKanriKubun) {
        this.shinTaikeiKanriKubun = shinTaikeiKanriKubun;
    }

    /**
     * getShinTaikeiKakudaiTekiyoUmu
     *
     * @return shinTaikeiKakudaiTekiyoUmu
     */
    public RString getShinTaikeiKakudaiTekiyoUmu() {
        return shinTaikeiKakudaiTekiyoUmu;
    }

    /**
     * setShinTaikeiKakudaiTekiyoUmu
     *
     * @param shinTaikeiKakudaiTekiyoUmu shinTaikeiKakudaiTekiyoUmu
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
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
        this.shoriTimestamp = entity.shoriTimestamp;
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
        return super.toMd5(hihokenshaNo, shikibetsuKubun, yukoKaishiYM, shoriTimestamp, yukoShuryoYM, yoKaigoJotaiKubun, kakudaiBaisu, kiriwakeTaniSu, torokuYMD, henkoYMD, gendoGakuKanriKikanSu, shinTaikeiKanriKubun, shinTaikeiKakudaiTekiyoUmu);
    }

// </editor-fold>
}
