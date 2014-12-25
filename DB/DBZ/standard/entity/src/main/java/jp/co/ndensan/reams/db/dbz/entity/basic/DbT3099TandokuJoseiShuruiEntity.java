package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3099TandokuJoseiShuruiの項目定義クラスです
 *
 */
public class DbT3099TandokuJoseiShuruiEntity extends DbTableEntityBase<DbT3099TandokuJoseiShuruiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3099TandokuJoseiShurui");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString tandokuJoseiShuruiCode;
    @PrimaryKey
    private ServiceShuruiCode joseiServiceShuruiCode;
    @PrimaryKey
    private FlexibleYearMonth tekiyoKaishiYM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleYearMonth tekiyoShuryoYM;
    private RString joseiServiceShuriMeisho;
    private Decimal joseiTani;
    private RString joseiNaiyo;

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
     * getTandokuJoseiShuruiCode
     *
     * @return tandokuJoseiShuruiCode
     */
    public RString getTandokuJoseiShuruiCode() {
        return tandokuJoseiShuruiCode;
    }

    /**
     * setTandokuJoseiShuruiCode
     *
     * @param tandokuJoseiShuruiCode tandokuJoseiShuruiCode
     */
    public void setTandokuJoseiShuruiCode(RString tandokuJoseiShuruiCode) {
        this.tandokuJoseiShuruiCode = tandokuJoseiShuruiCode;
    }

    /**
     * getJoseiServiceShuruiCode
     *
     * @return joseiServiceShuruiCode
     */
    public ServiceShuruiCode getJoseiServiceShuruiCode() {
        return joseiServiceShuruiCode;
    }

    /**
     * setJoseiServiceShuruiCode
     *
     * @param joseiServiceShuruiCode joseiServiceShuruiCode
     */
    public void setJoseiServiceShuruiCode(ServiceShuruiCode joseiServiceShuruiCode) {
        this.joseiServiceShuruiCode = joseiServiceShuruiCode;
    }

    /**
     * getTekiyoKaishiYM
     *
     * @return tekiyoKaishiYM
     */
    public FlexibleYearMonth getTekiyoKaishiYM() {
        return tekiyoKaishiYM;
    }

    /**
     * setTekiyoKaishiYM
     *
     * @param tekiyoKaishiYM tekiyoKaishiYM
     */
    public void setTekiyoKaishiYM(FlexibleYearMonth tekiyoKaishiYM) {
        this.tekiyoKaishiYM = tekiyoKaishiYM;
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
     * getTekiyoShuryoYM
     *
     * @return tekiyoShuryoYM
     */
    public FlexibleYearMonth getTekiyoShuryoYM() {
        return tekiyoShuryoYM;
    }

    /**
     * setTekiyoShuryoYM
     *
     * @param tekiyoShuryoYM tekiyoShuryoYM
     */
    public void setTekiyoShuryoYM(FlexibleYearMonth tekiyoShuryoYM) {
        this.tekiyoShuryoYM = tekiyoShuryoYM;
    }

    /**
     * getJoseiServiceShuriMeisho
     *
     * @return joseiServiceShuriMeisho
     */
    public RString getJoseiServiceShuriMeisho() {
        return joseiServiceShuriMeisho;
    }

    /**
     * setJoseiServiceShuriMeisho
     *
     * @param joseiServiceShuriMeisho joseiServiceShuriMeisho
     */
    public void setJoseiServiceShuriMeisho(RString joseiServiceShuriMeisho) {
        this.joseiServiceShuriMeisho = joseiServiceShuriMeisho;
    }

    /**
     * getJoseiTani
     *
     * @return joseiTani
     */
    public Decimal getJoseiTani() {
        return joseiTani;
    }

    /**
     * setJoseiTani
     *
     * @param joseiTani joseiTani
     */
    public void setJoseiTani(Decimal joseiTani) {
        this.joseiTani = joseiTani;
    }

    /**
     * getJoseiNaiyo
     *
     * @return joseiNaiyo
     */
    public RString getJoseiNaiyo() {
        return joseiNaiyo;
    }

    /**
     * setJoseiNaiyo
     *
     * @param joseiNaiyo joseiNaiyo
     */
    public void setJoseiNaiyo(RString joseiNaiyo) {
        this.joseiNaiyo = joseiNaiyo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3099TandokuJoseiShuruiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3099TandokuJoseiShuruiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3099TandokuJoseiShuruiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.tandokuJoseiShuruiCode, other.tandokuJoseiShuruiCode)) {
            return false;
        }
        if (!Objects.equals(this.joseiServiceShuruiCode, other.joseiServiceShuruiCode)) {
            return false;
        }
        if (!Objects.equals(this.tekiyoKaishiYM, other.tekiyoKaishiYM)) {
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
    public void shallowCopy(DbT3099TandokuJoseiShuruiEntity entity) {
        this.tandokuJoseiShuruiCode = entity.tandokuJoseiShuruiCode;
        this.joseiServiceShuruiCode = entity.joseiServiceShuruiCode;
        this.tekiyoKaishiYM = entity.tekiyoKaishiYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.tekiyoShuryoYM = entity.tekiyoShuryoYM;
        this.joseiServiceShuriMeisho = entity.joseiServiceShuriMeisho;
        this.joseiTani = entity.joseiTani;
        this.joseiNaiyo = entity.joseiNaiyo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(tandokuJoseiShuruiCode, joseiServiceShuruiCode, tekiyoKaishiYM, shoriTimestamp, tekiyoShuryoYM, joseiServiceShuriMeisho, joseiTani, joseiNaiyo);
    }

// </editor-fold>
}
