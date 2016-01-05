package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 予防給付計画自己作成合計テーブルのエンティティクラスです。
 */
public class DbT3012YoboKeikakuJikoSakuseiGokeiEntity extends DbTableEntityBase<DbT3012YoboKeikakuJikoSakuseiGokeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3012YoboKeikakuJikoSakuseiGokei");

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
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private int rirekiNo;
    @PrimaryKey
    private RString kyotakuServiceKubun;
    @PrimaryKey
    private JigyoshaNo serviceTeikyoJigyoshaNo;
    @PrimaryKey
    private ServiceShuruiCode serviceShuruiCode;
    private Decimal keikakuTaniSu;

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
     * 対象年月のgetメソッドです。
     * 
     * @return 対象年月
     */
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * 対象年月のsetメソッドです。
     * 
     * @param taishoYM 対象年月
     */
    public void setTaishoYM(@Nonnull FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
     * 居宅サービス区分のgetメソッドです。
     * <br/>
     * <br/>3:居宅サービス
     * 
     * @return 居宅サービス区分
     */
    public RString getKyotakuServiceKubun() {
        return kyotakuServiceKubun;
    }

    /**
     * 居宅サービス区分のsetメソッドです。
     * <br/>
     * <br/>3:居宅サービス
     * 
     * @param kyotakuServiceKubun 居宅サービス区分
     */
    public void setKyotakuServiceKubun(@Nonnull RString kyotakuServiceKubun) {
        this.kyotakuServiceKubun = kyotakuServiceKubun;
    }

    /**
     * サービス提供事業者番号のgetメソッドです。
     * 
     * @return サービス提供事業者番号
     */
    public JigyoshaNo getServiceTeikyoJigyoshaNo() {
        return serviceTeikyoJigyoshaNo;
    }

    /**
     * サービス提供事業者番号のsetメソッドです。
     * 
     * @param serviceTeikyoJigyoshaNo サービス提供事業者番号
     */
    public void setServiceTeikyoJigyoshaNo(@Nonnull JigyoshaNo serviceTeikyoJigyoshaNo) {
        this.serviceTeikyoJigyoshaNo = serviceTeikyoJigyoshaNo;
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
     * 給付計画単位数のgetメソッドです。
     * <br/>
     * <br/>サービス種類単位の合計単位数
     * 
     * @return 給付計画単位数
     */
    public Decimal getKeikakuTaniSu() {
        return keikakuTaniSu;
    }

    /**
     * 給付計画単位数のsetメソッドです。
     * <br/>
     * <br/>サービス種類単位の合計単位数
     * 
     * @param keikakuTaniSu 給付計画単位数
     */
    public void setKeikakuTaniSu(@Nonnull Decimal keikakuTaniSu) {
        this.keikakuTaniSu = keikakuTaniSu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3012YoboKeikakuJikoSakuseiGokeiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3012YoboKeikakuJikoSakuseiGokeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3012YoboKeikakuJikoSakuseiGokeiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoYM, other.taishoYM)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        if (!Objects.equals(this.kyotakuServiceKubun, other.kyotakuServiceKubun)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoJigyoshaNo, other.serviceTeikyoJigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCode, other.serviceShuruiCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3012YoboKeikakuJikoSakuseiGokeiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoYM = entity.taishoYM;
        this.rirekiNo = entity.rirekiNo;
        this.kyotakuServiceKubun = entity.kyotakuServiceKubun;
        this.serviceTeikyoJigyoshaNo = entity.serviceTeikyoJigyoshaNo;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.keikakuTaniSu = entity.keikakuTaniSu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoYM, rirekiNo, kyotakuServiceKubun, serviceTeikyoJigyoshaNo, serviceShuruiCode, keikakuTaniSu);
    }

// </editor-fold>
}
