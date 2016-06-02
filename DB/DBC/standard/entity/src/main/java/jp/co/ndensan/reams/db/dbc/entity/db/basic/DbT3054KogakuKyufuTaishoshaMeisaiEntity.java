package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;

/**
 * 高額介護サービス費給付対象者明細テーブルのエンティティクラスです。
 */
public class DbT3054KogakuKyufuTaishoshaMeisaiEntity extends DbTableEntityBase<DbT3054KogakuKyufuTaishoshaMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3054KogakuKyufuTaishoshaMeisai");

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
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private ServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
    private int rirekiNo;
    private Decimal serviceHiyoGokeiGaku;
    private Decimal riyoshaFutanGaku;
    private RString kogakuKyufuKonkyo;
    private FlexibleYearMonth taishoshaUketoriYM;

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
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
     * 事業者番号のgetメソッドです。
     * 
     * @return 事業者番号
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     * 
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(@Nonnull JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
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
    public void setServiceShuruiCode(@Nonnull ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
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
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * サービス費用合計額のgetメソッドです。
     * 
     * @return サービス費用合計額
     */
    public Decimal getServiceHiyoGokeiGaku() {
        return serviceHiyoGokeiGaku;
    }

    /**
     * サービス費用合計額のsetメソッドです。
     * 
     * @param serviceHiyoGokeiGaku サービス費用合計額
     */
    public void setServiceHiyoGokeiGaku(@Nonnull Decimal serviceHiyoGokeiGaku) {
        this.serviceHiyoGokeiGaku = serviceHiyoGokeiGaku;
    }

    /**
     * 利用者負担額のgetメソッドです。
     * 
     * @return 利用者負担額
     */
    public Decimal getRiyoshaFutanGaku() {
        return riyoshaFutanGaku;
    }

    /**
     * 利用者負担額のsetメソッドです。
     * 
     * @param riyoshaFutanGaku 利用者負担額
     */
    public void setRiyoshaFutanGaku(@Nonnull Decimal riyoshaFutanGaku) {
        this.riyoshaFutanGaku = riyoshaFutanGaku;
    }

    /**
     * 高額給付根拠のgetメソッドです。
     * <br/>
     * <br/>低所得者等識別、世帯合算状況等
     * 
     * @return 高額給付根拠
     */
    public RString getKogakuKyufuKonkyo() {
        return kogakuKyufuKonkyo;
    }

    /**
     * 高額給付根拠のsetメソッドです。
     * <br/>
     * <br/>低所得者等識別、世帯合算状況等
     * 
     * @param kogakuKyufuKonkyo 高額給付根拠
     */
    public void setKogakuKyufuKonkyo(@Nonnull RString kogakuKyufuKonkyo) {
        this.kogakuKyufuKonkyo = kogakuKyufuKonkyo;
    }

    /**
     * 対象者受取年月のgetメソッドです。
     * 
     * @return 対象者受取年月
     */
    public FlexibleYearMonth getTaishoshaUketoriYM() {
        return taishoshaUketoriYM;
    }

    /**
     * 対象者受取年月のsetメソッドです。
     * 
     * @param taishoshaUketoriYM 対象者受取年月
     */
    public void setTaishoshaUketoriYM(@Nonnull FlexibleYearMonth taishoshaUketoriYM) {
        this.taishoshaUketoriYM = taishoshaUketoriYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3054KogakuKyufuTaishoshaMeisaiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3054KogakuKyufuTaishoshaMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3054KogakuKyufuTaishoshaMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCode, other.serviceShuruiCode)) {
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
    public void shallowCopy(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.rirekiNo = entity.rirekiNo;
        this.serviceHiyoGokeiGaku = entity.serviceHiyoGokeiGaku;
        this.riyoshaFutanGaku = entity.riyoshaFutanGaku;
        this.kogakuKyufuKonkyo = entity.kogakuKyufuKonkyo;
        this.taishoshaUketoriYM = entity.taishoshaUketoriYM;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, serviceTeikyoYM, jigyoshaNo, serviceShuruiCode, rirekiNo, serviceHiyoGokeiGaku, riyoshaFutanGaku, kogakuKyufuKonkyo, taishoshaUketoriYM);
    }

// </editor-fold>

}
