package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
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
 * DbT7120TokuteiShinryoServiceCodeの項目定義クラスです
 *
 */
public class DbT7120TokuteiShinryoServiceCodeEntity extends DbTableEntityBase<DbT7120TokuteiShinryoServiceCodeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7120TokuteiShinryoServiceCode");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
    private ServiceKomokuCode serviceKomokuCode;
    @PrimaryKey
    private FlexibleYearMonth tekiyoKaishiYM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleYearMonth tekiyoShuryoYM;
    private RString serviceMeisho;
    private Decimal taniSu;
    private RString taniSuShikibetsu;
    private RString santeiTani;
    private RString goseiShikibetsuKubun;
    private RString tokuteiShinryoKubunCode;
    private RString tokuteiShinryoKomokuCode;
    private RString santeiSeiyakuKikan;
    private Decimal santeiSeiyakuKaisu;

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
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getServiceKomokuCode
     *
     * @return serviceKomokuCode
     */
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * setServiceKomokuCode
     *
     * @param serviceKomokuCode serviceKomokuCode
     */
    public void setServiceKomokuCode(ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
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
     * getServiceMeisho
     *
     * @return serviceMeisho
     */
    public RString getServiceMeisho() {
        return serviceMeisho;
    }

    /**
     * setServiceMeisho
     *
     * @param serviceMeisho serviceMeisho
     */
    public void setServiceMeisho(RString serviceMeisho) {
        this.serviceMeisho = serviceMeisho;
    }

    /**
     * getTaniSu
     *
     * @return taniSu
     */
    public Decimal getTaniSu() {
        return taniSu;
    }

    /**
     * setTaniSu
     *
     * @param taniSu taniSu
     */
    public void setTaniSu(Decimal taniSu) {
        this.taniSu = taniSu;
    }

    /**
     * getTaniSuShikibetsu
     *
     * @return taniSuShikibetsu
     */
    public RString getTaniSuShikibetsu() {
        return taniSuShikibetsu;
    }

    /**
     * setTaniSuShikibetsu
     *
     * @param taniSuShikibetsu taniSuShikibetsu
     */
    public void setTaniSuShikibetsu(RString taniSuShikibetsu) {
        this.taniSuShikibetsu = taniSuShikibetsu;
    }

    /**
     * getSanteiTani
     *
     * @return santeiTani
     */
    public RString getSanteiTani() {
        return santeiTani;
    }

    /**
     * setSanteiTani
     *
     * @param santeiTani santeiTani
     */
    public void setSanteiTani(RString santeiTani) {
        this.santeiTani = santeiTani;
    }

    /**
     * getGoseiShikibetsuKubun
     *
     * @return goseiShikibetsuKubun
     */
    public RString getGoseiShikibetsuKubun() {
        return goseiShikibetsuKubun;
    }

    /**
     * setGoseiShikibetsuKubun
     *
     * @param goseiShikibetsuKubun goseiShikibetsuKubun
     */
    public void setGoseiShikibetsuKubun(RString goseiShikibetsuKubun) {
        this.goseiShikibetsuKubun = goseiShikibetsuKubun;
    }

    /**
     * getTokuteiShinryoKubunCode
     *
     * @return tokuteiShinryoKubunCode
     */
    public RString getTokuteiShinryoKubunCode() {
        return tokuteiShinryoKubunCode;
    }

    /**
     * setTokuteiShinryoKubunCode
     *
     * @param tokuteiShinryoKubunCode tokuteiShinryoKubunCode
     */
    public void setTokuteiShinryoKubunCode(RString tokuteiShinryoKubunCode) {
        this.tokuteiShinryoKubunCode = tokuteiShinryoKubunCode;
    }

    /**
     * getTokuteiShinryoKomokuCode
     *
     * @return tokuteiShinryoKomokuCode
     */
    public RString getTokuteiShinryoKomokuCode() {
        return tokuteiShinryoKomokuCode;
    }

    /**
     * setTokuteiShinryoKomokuCode
     *
     * @param tokuteiShinryoKomokuCode tokuteiShinryoKomokuCode
     */
    public void setTokuteiShinryoKomokuCode(RString tokuteiShinryoKomokuCode) {
        this.tokuteiShinryoKomokuCode = tokuteiShinryoKomokuCode;
    }

    /**
     * getSanteiSeiyakuKikan
     *
     * @return santeiSeiyakuKikan
     */
    public RString getSanteiSeiyakuKikan() {
        return santeiSeiyakuKikan;
    }

    /**
     * setSanteiSeiyakuKikan
     *
     * @param santeiSeiyakuKikan santeiSeiyakuKikan
     */
    public void setSanteiSeiyakuKikan(RString santeiSeiyakuKikan) {
        this.santeiSeiyakuKikan = santeiSeiyakuKikan;
    }

    /**
     * getSanteiSeiyakuKaisu
     *
     * @return santeiSeiyakuKaisu
     */
    public Decimal getSanteiSeiyakuKaisu() {
        return santeiSeiyakuKaisu;
    }

    /**
     * setSanteiSeiyakuKaisu
     *
     * @param santeiSeiyakuKaisu santeiSeiyakuKaisu
     */
    public void setSanteiSeiyakuKaisu(Decimal santeiSeiyakuKaisu) {
        this.santeiSeiyakuKaisu = santeiSeiyakuKaisu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7120TokuteiShinryoServiceCodeEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7120TokuteiShinryoServiceCodeEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7120TokuteiShinryoServiceCodeEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCode, other.serviceShuruiCode)) {
            return false;
        }
        if (!Objects.equals(this.serviceKomokuCode, other.serviceKomokuCode)) {
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
    public void shallowCopy(DbT7120TokuteiShinryoServiceCodeEntity entity) {
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.tekiyoKaishiYM = entity.tekiyoKaishiYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.tekiyoShuryoYM = entity.tekiyoShuryoYM;
        this.serviceMeisho = entity.serviceMeisho;
        this.taniSu = entity.taniSu;
        this.taniSuShikibetsu = entity.taniSuShikibetsu;
        this.santeiTani = entity.santeiTani;
        this.goseiShikibetsuKubun = entity.goseiShikibetsuKubun;
        this.tokuteiShinryoKubunCode = entity.tokuteiShinryoKubunCode;
        this.tokuteiShinryoKomokuCode = entity.tokuteiShinryoKomokuCode;
        this.santeiSeiyakuKikan = entity.santeiSeiyakuKikan;
        this.santeiSeiyakuKaisu = entity.santeiSeiyakuKaisu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceShuruiCode, serviceKomokuCode, tekiyoKaishiYM, shoriTimestamp, tekiyoShuryoYM, serviceMeisho, taniSu, taniSuShikibetsu, santeiTani, goseiShikibetsuKubun, tokuteiShinryoKubunCode, tokuteiShinryoKomokuCode, santeiSeiyakuKikan, santeiSeiyakuKaisu);
    }

// </editor-fold>
}
