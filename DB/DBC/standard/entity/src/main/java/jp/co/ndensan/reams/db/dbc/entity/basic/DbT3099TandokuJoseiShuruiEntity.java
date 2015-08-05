package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 市町村単独助成種類テーブルのエンティティクラスです。
 */
public class DbT3099TandokuJoseiShuruiEntity extends DbTableEntityBase<DbT3099TandokuJoseiShuruiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private int rirekiNo;
    private FlexibleYearMonth tekiyoShuryoYM;
    private RString joseiServiceShuriMeisho;
    private Decimal joseiTani;
    private RString joseiNaiyo;

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
     * 市町村単独助成種類のgetメソッドです。
     *
     * @return 市町村単独助成種類
     */
    public RString getTandokuJoseiShuruiCode() {
        return tandokuJoseiShuruiCode;
    }

    /**
     * 市町村単独助成種類のsetメソッドです。
     *
     * @param tandokuJoseiShuruiCode 市町村単独助成種類
     */
    public void setTandokuJoseiShuruiCode(RString tandokuJoseiShuruiCode) {
        this.tandokuJoseiShuruiCode = tandokuJoseiShuruiCode;
    }

    /**
     * 助成サービス種類コードのgetメソッドです。
     *
     * @return 助成サービス種類コード
     */
    public ServiceShuruiCode getJoseiServiceShuruiCode() {
        return joseiServiceShuruiCode;
    }

    /**
     * 助成サービス種類コードのsetメソッドです。
     *
     * @param joseiServiceShuruiCode 助成サービス種類コード
     */
    public void setJoseiServiceShuruiCode(ServiceShuruiCode joseiServiceShuruiCode) {
        this.joseiServiceShuruiCode = joseiServiceShuruiCode;
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
     * 助成サービス種類名称のgetメソッドです。
     *
     * @return 助成サービス種類名称
     */
    public RString getJoseiServiceShuriMeisho() {
        return joseiServiceShuriMeisho;
    }

    /**
     * 助成サービス種類名称のsetメソッドです。
     *
     * @param joseiServiceShuriMeisho 助成サービス種類名称
     */
    public void setJoseiServiceShuriMeisho(RString joseiServiceShuriMeisho) {
        this.joseiServiceShuriMeisho = joseiServiceShuriMeisho;
    }

    /**
     * 市町村単独助成単位のgetメソッドです。
     *
     * @return 市町村単独助成単位
     */
    public Decimal getJoseiTani() {
        return joseiTani;
    }

    /**
     * 市町村単独助成単位のsetメソッドです。
     *
     * @param joseiTani 市町村単独助成単位
     */
    public void setJoseiTani(Decimal joseiTani) {
        this.joseiTani = joseiTani;
    }

    /**
     * 市町村単独助成内容のgetメソッドです。
     *
     * @return 市町村単独助成内容
     */
    public RString getJoseiNaiyo() {
        return joseiNaiyo;
    }

    /**
     * 市町村単独助成内容のsetメソッドです。
     *
     * @param joseiNaiyo 市町村単独助成内容
     */
    public void setJoseiNaiyo(RString joseiNaiyo) {
        this.joseiNaiyo = joseiNaiyo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3099TandokuJoseiShuruiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3099TandokuJoseiShuruiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(tandokuJoseiShuruiCode, joseiServiceShuruiCode, tekiyoKaishiYM, rirekiNo, tekiyoShuryoYM, joseiServiceShuriMeisho, joseiTani, joseiNaiyo);
    }

// </editor-fold>
}
