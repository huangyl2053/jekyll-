package jp.co.ndensan.reams.db.dbc.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 特定診療サービスコードテーブルのエンティティクラスです。
 */
public class DbT7120TokuteiShinryoServiceCodeEntity extends DbTableEntityBase<DbT7120TokuteiShinryoServiceCodeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

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
    private int rirekiNo;
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
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     *
     * @param serviceShuruiCode サービス種類コード
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * サービス項目コードのgetメソッドです。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getServiceKomokuCode() {
        return serviceKomokuCode;
    }

    /**
     * サービス項目コードのsetメソッドです。
     *
     * @param serviceKomokuCode サービス項目コード
     */
    public void setServiceKomokuCode(ServiceKomokuCode serviceKomokuCode) {
        this.serviceKomokuCode = serviceKomokuCode;
    }

    /**
     * 適用開始年月のgetメソッドです。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth getTekiyoKaishiYM() {
        return tekiyoKaishiYM;
    }

    /**
     * 適用開始年月のsetメソッドです。
     *
     * @param tekiyoKaishiYM 適用開始年月
     */
    public void setTekiyoKaishiYM(FlexibleYearMonth tekiyoKaishiYM) {
        this.tekiyoKaishiYM = tekiyoKaishiYM;
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
     * 適用終了年月のgetメソッドです。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth getTekiyoShuryoYM() {
        return tekiyoShuryoYM;
    }

    /**
     * 適用終了年月のsetメソッドです。
     *
     * @param tekiyoShuryoYM 適用終了年月
     */
    public void setTekiyoShuryoYM(FlexibleYearMonth tekiyoShuryoYM) {
        this.tekiyoShuryoYM = tekiyoShuryoYM;
    }

    /**
     * サービス名称のgetメソッドです。
     *
     * @return サービス名称
     */
    public RString getServiceMeisho() {
        return serviceMeisho;
    }

    /**
     * サービス名称のsetメソッドです。
     *
     * @param serviceMeisho サービス名称
     */
    public void setServiceMeisho(RString serviceMeisho) {
        this.serviceMeisho = serviceMeisho;
    }

    /**
     * 単位数のgetメソッドです。
     *
     * @return 単位数
     */
    public Decimal getTaniSu() {
        return taniSu;
    }

    /**
     * 単位数のsetメソッドです。
     *
     * @param taniSu 単位数
     */
    public void setTaniSu(Decimal taniSu) {
        this.taniSu = taniSu;
    }

    /**
     * 単位数識別のgetメソッドです。
     *
     * @return 単位数識別
     */
    public RString getTaniSuShikibetsu() {
        return taniSuShikibetsu;
    }

    /**
     * 単位数識別のsetメソッドです。
     *
     * @param taniSuShikibetsu 単位数識別
     */
    public void setTaniSuShikibetsu(RString taniSuShikibetsu) {
        this.taniSuShikibetsu = taniSuShikibetsu;
    }

    /**
     * 算定単位のgetメソッドです。
     *
     * @return 算定単位
     */
    public RString getSanteiTani() {
        return santeiTani;
    }

    /**
     * 算定単位のsetメソッドです。
     *
     * @param santeiTani 算定単位
     */
    public void setSanteiTani(RString santeiTani) {
        this.santeiTani = santeiTani;
    }

    /**
     * 合成識別区分のgetメソッドです。
     *
     * @return 合成識別区分
     */
    public RString getGoseiShikibetsuKubun() {
        return goseiShikibetsuKubun;
    }

    /**
     * 合成識別区分のsetメソッドです。
     *
     * @param goseiShikibetsuKubun 合成識別区分
     */
    public void setGoseiShikibetsuKubun(RString goseiShikibetsuKubun) {
        this.goseiShikibetsuKubun = goseiShikibetsuKubun;
    }

    /**
     * 特定診療区分コードのgetメソッドです。
     *
     * @return 特定診療区分コード
     */
    public RString getTokuteiShinryoKubunCode() {
        return tokuteiShinryoKubunCode;
    }

    /**
     * 特定診療区分コードのsetメソッドです。
     *
     * @param tokuteiShinryoKubunCode 特定診療区分コード
     */
    public void setTokuteiShinryoKubunCode(RString tokuteiShinryoKubunCode) {
        this.tokuteiShinryoKubunCode = tokuteiShinryoKubunCode;
    }

    /**
     * 特定診療項目コードのgetメソッドです。
     * <br/>
     * <br/>回数（日数）
     *
     * @return 特定診療項目コード
     */
    public RString getTokuteiShinryoKomokuCode() {
        return tokuteiShinryoKomokuCode;
    }

    /**
     * 特定診療項目コードのsetメソッドです。
     * <br/>
     * <br/>回数（日数）
     *
     * @param tokuteiShinryoKomokuCode 特定診療項目コード
     */
    public void setTokuteiShinryoKomokuCode(RString tokuteiShinryoKomokuCode) {
        this.tokuteiShinryoKomokuCode = tokuteiShinryoKomokuCode;
    }

    /**
     * 算定制約期間のgetメソッドです。
     *
     * @return 算定制約期間
     */
    public RString getSanteiSeiyakuKikan() {
        return santeiSeiyakuKikan;
    }

    /**
     * 算定制約期間のsetメソッドです。
     *
     * @param santeiSeiyakuKikan 算定制約期間
     */
    public void setSanteiSeiyakuKikan(RString santeiSeiyakuKikan) {
        this.santeiSeiyakuKikan = santeiSeiyakuKikan;
    }

    /**
     * 算定制約回数のgetメソッドです。
     *
     * @return 算定制約回数
     */
    public Decimal getSanteiSeiyakuKaisu() {
        return santeiSeiyakuKaisu;
    }

    /**
     * 算定制約回数のsetメソッドです。
     *
     * @param santeiSeiyakuKaisu 算定制約回数
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(serviceShuruiCode, serviceKomokuCode, tekiyoKaishiYM, rirekiNo, tekiyoShuryoYM, serviceMeisho, taniSu, taniSuShikibetsu, santeiTani, goseiShikibetsuKubun, tokuteiShinryoKubunCode, tokuteiShinryoKomokuCode, santeiSeiyakuKikan, santeiSeiyakuKaisu);
    }

// </editor-fold>
}
