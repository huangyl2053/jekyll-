package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
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
 * 償還払請求社会福祉法人軽減額テーブルのエンティティクラスです。
 */
public class DbT3051ShokanShakaiFukushiHojinKeigengakuEntity extends DbTableEntityBase<DbT3051ShokanShakaiFukushiHojinKeigengakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3051ShokanShakaiFukushiHojinKeigengaku");

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
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private RString yoshikiNo;
    @PrimaryKey
    private RString meisaiNo;
    @PrimaryKey
    private RString renban;
    private Decimal keigenritsu;
    private ServiceShuruiCode serviceShuruiCode;
    private int riyoshaFutangakuTotal;
    private int keigengaku;
    private int keigengoRiyoshaFutangaku;
    private RString biko;

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
     * 様式番号のgetメソッドです。
     *
     * @return 様式番号
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * 様式番号のsetメソッドです。
     *
     * @param yoshikiNo 様式番号
     */
    public void setYoshikiNo(@Nonnull RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * 明細番号のgetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @return 明細番号
     */
    public RString getMeisaiNo() {
        return meisaiNo;
    }

    /**
     * 明細番号のsetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @param meisaiNo 明細番号
     */
    public void setMeisaiNo(@Nonnull RString meisaiNo) {
        this.meisaiNo = meisaiNo;
    }

    /**
     * 連番のgetメソッドです。
     *
     * @return 連番
     */
    public RString getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     *
     * @param renban 連番
     */
    public void setRenban(@Nonnull RString renban) {
        this.renban = renban;
    }

    /**
     * 軽減率のgetメソッドです。
     *
     * @return 軽減率
     */
    @CheckForNull
    public Decimal getKeigenritsu() {
        return keigenritsu;
    }

    /**
     * 軽減率のsetメソッドです。
     *
     * @param keigenritsu 軽減率
     */
    public void setKeigenritsu(Decimal keigenritsu) {
        this.keigenritsu = keigenritsu;
    }

    /**
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    @CheckForNull
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
     * 受領すべき利用者負担の総額のgetメソッドです。
     *
     * @return 受領すべき利用者負担の総額
     */
    @CheckForNull
    public int getRiyoshaFutangakuTotal() {
        return riyoshaFutangakuTotal;
    }

    /**
     * 受領すべき利用者負担の総額のsetメソッドです。
     *
     * @param riyoshaFutangakuTotal 受領すべき利用者負担の総額
     */
    public void setRiyoshaFutangakuTotal(int riyoshaFutangakuTotal) {
        this.riyoshaFutangakuTotal = riyoshaFutangakuTotal;
    }

    /**
     * 軽減額のgetメソッドです。
     *
     * @return 軽減額
     */
    @CheckForNull
    public int getKeigengaku() {
        return keigengaku;
    }

    /**
     * 軽減額のsetメソッドです。
     *
     * @param keigengaku 軽減額
     */
    public void setKeigengaku(int keigengaku) {
        this.keigengaku = keigengaku;
    }

    /**
     * 軽減後利用者負担額のgetメソッドです。
     *
     * @return 軽減後利用者負担額
     */
    @CheckForNull
    public int getKeigengoRiyoshaFutangaku() {
        return keigengoRiyoshaFutangaku;
    }

    /**
     * 軽減後利用者負担額のsetメソッドです。
     *
     * @param keigengoRiyoshaFutangaku 軽減後利用者負担額
     */
    public void setKeigengoRiyoshaFutangaku(int keigengoRiyoshaFutangaku) {
        this.keigengoRiyoshaFutangaku = keigengoRiyoshaFutangaku;
    }

    /**
     * 備考のgetメソッドです。
     *
     * @return 備考
     */
    @CheckForNull
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     *
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3051ShokanShakaiFukushiHojinKeigengakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3051ShokanShakaiFukushiHojinKeigengakuEntity other) {
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
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yoshikiNo, other.yoshikiNo)) {
            return false;
        }
        if (!Objects.equals(this.meisaiNo, other.meisaiNo)) {
            return false;
        }
        if (!Objects.equals(this.renban, other.renban)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.meisaiNo = entity.meisaiNo;
        this.renban = entity.renban;
        this.keigenritsu = entity.keigenritsu;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.riyoshaFutangakuTotal = entity.riyoshaFutangakuTotal;
        this.keigengaku = entity.keigengaku;
        this.keigengoRiyoshaFutangaku = entity.keigengoRiyoshaFutangaku;
        this.biko = entity.biko;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, meisaiNo, renban, keigenritsu, serviceShuruiCode, riyoshaFutangakuTotal, keigengaku, keigengoRiyoshaFutangaku, biko);
    }

// </editor-fold>
}
