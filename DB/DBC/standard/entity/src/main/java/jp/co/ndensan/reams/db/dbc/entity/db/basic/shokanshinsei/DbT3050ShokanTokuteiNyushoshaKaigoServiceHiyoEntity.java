package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求特定入所者介護サービス費用テーブルのエンティティクラスです。
 */
public class DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity extends DbTableEntityBase<DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo");

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
    private RString junjiNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private ServiceShuruiCode serviceShuruiCode;
    private ServiceKomokuCode serviceKomokuCode;
    private Decimal hiyoTanka;
    private Decimal futanGendogaku;
    private Decimal nissu;
    private int hiyogaku;
    private int hokenbunSeikyugaku;
    private int riyoshaFutangaku;
    private int hiyogakuTotal;
    private int hokenbunSeikyugakuTotal;
    private int riyoshaFutangakuTotal;
    private RString shikyuKubunCode;
    private int tensuKingaku;
    private int shikyuKingaku;
    private int zougenten;
    private int sagakuKingaku;

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
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
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
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
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
    public void setSeiriNo(RString seiriNo) {
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
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
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
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * 順次番号のgetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @return 順次番号
     */
    public RString getJunjiNo() {
        return junjiNo;
    }

    /**
     * 順次番号のsetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @param junjiNo 順次番号
     */
    public void setJunjiNo(RString junjiNo) {
        this.junjiNo = junjiNo;
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
     * 費用単価のgetメソッドです。
     *
     * @return 費用単価
     */
    public Decimal getHiyoTanka() {
        return hiyoTanka;
    }

    /**
     * 費用単価のsetメソッドです。
     *
     * @param hiyoTanka 費用単価
     */
    public void setHiyoTanka(Decimal hiyoTanka) {
        this.hiyoTanka = hiyoTanka;
    }

    /**
     * 負担限度額のgetメソッドです。
     *
     * @return 負担限度額
     */
    public Decimal getFutanGendogaku() {
        return futanGendogaku;
    }

    /**
     * 負担限度額のsetメソッドです。
     *
     * @param futanGendogaku 負担限度額
     */
    public void setFutanGendogaku(Decimal futanGendogaku) {
        this.futanGendogaku = futanGendogaku;
    }

    /**
     * 日数のgetメソッドです。
     *
     * @return 日数
     */
    public Decimal getNissu() {
        return nissu;
    }

    /**
     * 日数のsetメソッドです。
     *
     * @param nissu 日数
     */
    public void setNissu(Decimal nissu) {
        this.nissu = nissu;
    }

    /**
     * 費用額のgetメソッドです。
     *
     * @return 費用額
     */
    public int getHiyogaku() {
        return hiyogaku;
    }

    /**
     * 費用額のsetメソッドです。
     *
     * @param hiyogaku 費用額
     */
    public void setHiyogaku(int hiyogaku) {
        this.hiyogaku = hiyogaku;
    }

    /**
     * 保険分請求額のgetメソッドです。
     *
     * @return 保険分請求額
     */
    public int getHokenbunSeikyugaku() {
        return hokenbunSeikyugaku;
    }

    /**
     * 保険分請求額のsetメソッドです。
     *
     * @param hokenbunSeikyugaku 保険分請求額
     */
    public void setHokenbunSeikyugaku(int hokenbunSeikyugaku) {
        this.hokenbunSeikyugaku = hokenbunSeikyugaku;
    }

    /**
     * 利用者負担額のgetメソッドです。
     *
     * @return 利用者負担額
     */
    public int getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * 利用者負担額のsetメソッドです。
     *
     * @param riyoshaFutangaku 利用者負担額
     */
    public void setRiyoshaFutangaku(int riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * 費用額合計のgetメソッドです。
     * <br/>
     * <br/>順次番号が最大の情報にのみ設定
     *
     * @return 費用額合計
     */
    public int getHiyogakuTotal() {
        return hiyogakuTotal;
    }

    /**
     * 費用額合計のsetメソッドです。
     * <br/>
     * <br/>順次番号が最大の情報にのみ設定
     *
     * @param hiyogakuTotal 費用額合計
     */
    public void setHiyogakuTotal(int hiyogakuTotal) {
        this.hiyogakuTotal = hiyogakuTotal;
    }

    /**
     * 保険分請求額合計のgetメソッドです。
     * <br/>
     * <br/>順次番号が最大の情報にのみ設定
     *
     * @return 保険分請求額合計
     */
    public int getHokenbunSeikyugakuTotal() {
        return hokenbunSeikyugakuTotal;
    }

    /**
     * 保険分請求額合計のsetメソッドです。
     * <br/>
     * <br/>順次番号が最大の情報にのみ設定
     *
     * @param hokenbunSeikyugakuTotal 保険分請求額合計
     */
    public void setHokenbunSeikyugakuTotal(int hokenbunSeikyugakuTotal) {
        this.hokenbunSeikyugakuTotal = hokenbunSeikyugakuTotal;
    }

    /**
     * 利用者負担額合計のgetメソッドです。
     * <br/>
     * <br/>順次番号が最大の情報にのみ設定
     *
     * @return 利用者負担額合計
     */
    public int getRiyoshaFutangakuTotal() {
        return riyoshaFutangakuTotal;
    }

    /**
     * 利用者負担額合計のsetメソッドです。
     * <br/>
     * <br/>順次番号が最大の情報にのみ設定
     *
     * @param riyoshaFutangakuTotal 利用者負担額合計
     */
    public void setRiyoshaFutangakuTotal(int riyoshaFutangakuTotal) {
        this.riyoshaFutangakuTotal = riyoshaFutangakuTotal;
    }

    /**
     * 支給区分コードのgetメソッドです。
     *
     * @return 支給区分コード
     */
    public RString getShikyuKubunCode() {
        return shikyuKubunCode;
    }

    /**
     * 支給区分コードのsetメソッドです。
     *
     * @param shikyuKubunCode 支給区分コード
     */
    public void setShikyuKubunCode(RString shikyuKubunCode) {
        this.shikyuKubunCode = shikyuKubunCode;
    }

    /**
     * 点数／金額のgetメソッドです。
     *
     * @return 点数／金額
     */
    public int getTensuKingaku() {
        return tensuKingaku;
    }

    /**
     * 点数／金額のsetメソッドです。
     *
     * @param tensuKingaku 点数／金額
     */
    public void setTensuKingaku(int tensuKingaku) {
        this.tensuKingaku = tensuKingaku;
    }

    /**
     * 支給金額のgetメソッドです。
     *
     * @return 支給金額
     */
    public int getShikyuKingaku() {
        return shikyuKingaku;
    }

    /**
     * 支給金額のsetメソッドです。
     *
     * @param shikyuKingaku 支給金額
     */
    public void setShikyuKingaku(int shikyuKingaku) {
        this.shikyuKingaku = shikyuKingaku;
    }

    /**
     * 増減点のgetメソッドです。
     *
     * @return 増減点
     */
    public int getZougenten() {
        return zougenten;
    }

    /**
     * 増減点のsetメソッドです。
     *
     * @param zougenten 増減点
     */
    public void setZougenten(int zougenten) {
        this.zougenten = zougenten;
    }

    /**
     * 差額金額のgetメソッドです。
     *
     * @return 差額金額
     */
    public int getSagakuKingaku() {
        return sagakuKingaku;
    }

    /**
     * 差額金額のsetメソッドです。
     *
     * @param sagakuKingaku 差額金額
     */
    public void setSagakuKingaku(int sagakuKingaku) {
        this.sagakuKingaku = sagakuKingaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity other) {
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
        if (!Objects.equals(this.junjiNo, other.junjiNo)) {
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
    public void shallowCopy(DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyoEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.junjiNo = entity.junjiNo;
        this.rirekiNo = entity.rirekiNo;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.serviceKomokuCode = entity.serviceKomokuCode;
        this.hiyoTanka = entity.hiyoTanka;
        this.futanGendogaku = entity.futanGendogaku;
        this.nissu = entity.nissu;
        this.hiyogaku = entity.hiyogaku;
        this.hokenbunSeikyugaku = entity.hokenbunSeikyugaku;
        this.riyoshaFutangaku = entity.riyoshaFutangaku;
        this.hiyogakuTotal = entity.hiyogakuTotal;
        this.hokenbunSeikyugakuTotal = entity.hokenbunSeikyugakuTotal;
        this.riyoshaFutangakuTotal = entity.riyoshaFutangakuTotal;
        this.shikyuKubunCode = entity.shikyuKubunCode;
        this.tensuKingaku = entity.tensuKingaku;
        this.shikyuKingaku = entity.shikyuKingaku;
        this.zougenten = entity.zougenten;
        this.sagakuKingaku = entity.sagakuKingaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, junjiNo, rirekiNo, serviceShuruiCode, serviceKomokuCode, hiyoTanka, futanGendogaku, nissu, hiyogaku, hokenbunSeikyugaku, riyoshaFutangaku, hiyogakuTotal, hokenbunSeikyugakuTotal, riyoshaFutangakuTotal, shikyuKubunCode, tensuKingaku, shikyuKingaku, zougenten, sagakuKingaku);
    }

// </editor-fold>
}
