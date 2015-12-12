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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求住宅改修テーブルのエンティティクラスです。
 */
public class DbT3049ShokanJutakuKaishuEntity extends DbTableEntityBase<DbT3049ShokanJutakuKaishuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3049ShokanJutakuKaishu");

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
    private ServiceCode serviceCode;
    private FlexibleDate jutakuKaishuChakkoYMD;
    private RString jutakuKaishuJigyoshaName;
    private RString jutakuKaishuJutakuAddress;
    private int kaishuKingaku;
    private RString shinsaHohoKubunCode;
    private FlexibleDate jutakuKaishuKanseiYMD;
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
     * サービスコードのgetメソッドです。
     *
     * @return サービスコード
     */
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * サービスコードのsetメソッドです。
     *
     * @param serviceCode サービスコード
     */
    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * 住宅改修着工年月日のgetメソッドです。
     *
     * @return 住宅改修着工年月日
     */
    public FlexibleDate getJutakuKaishuChakkoYMD() {
        return jutakuKaishuChakkoYMD;
    }

    /**
     * 住宅改修着工年月日のsetメソッドです。
     *
     * @param jutakuKaishuChakkoYMD 住宅改修着工年月日
     */
    public void setJutakuKaishuChakkoYMD(FlexibleDate jutakuKaishuChakkoYMD) {
        this.jutakuKaishuChakkoYMD = jutakuKaishuChakkoYMD;
    }

    /**
     * 住宅改修事業者名のgetメソッドです。
     *
     * @return 住宅改修事業者名
     */
    public RString getJutakuKaishuJigyoshaName() {
        return jutakuKaishuJigyoshaName;
    }

    /**
     * 住宅改修事業者名のsetメソッドです。
     *
     * @param jutakuKaishuJigyoshaName 住宅改修事業者名
     */
    public void setJutakuKaishuJigyoshaName(RString jutakuKaishuJigyoshaName) {
        this.jutakuKaishuJigyoshaName = jutakuKaishuJigyoshaName;
    }

    /**
     * 住宅改修住宅住所のgetメソッドです。
     *
     * @return 住宅改修住宅住所
     */
    public RString getJutakuKaishuJutakuAddress() {
        return jutakuKaishuJutakuAddress;
    }

    /**
     * 住宅改修住宅住所のsetメソッドです。
     *
     * @param jutakuKaishuJutakuAddress 住宅改修住宅住所
     */
    public void setJutakuKaishuJutakuAddress(RString jutakuKaishuJutakuAddress) {
        this.jutakuKaishuJutakuAddress = jutakuKaishuJutakuAddress;
    }

    /**
     * 改修金額のgetメソッドです。
     *
     * @return 改修金額
     */
    public int getKaishuKingaku() {
        return kaishuKingaku;
    }

    /**
     * 改修金額のsetメソッドです。
     *
     * @param kaishuKingaku 改修金額
     */
    public void setKaishuKingaku(int kaishuKingaku) {
        this.kaishuKingaku = kaishuKingaku;
    }

    /**
     * 審査方法区分コードのgetメソッドです。
     *
     * @return 審査方法区分コード
     */
    public RString getShinsaHohoKubunCode() {
        return shinsaHohoKubunCode;
    }

    /**
     * 審査方法区分コードのsetメソッドです。
     *
     * @param shinsaHohoKubunCode 審査方法区分コード
     */
    public void setShinsaHohoKubunCode(RString shinsaHohoKubunCode) {
        this.shinsaHohoKubunCode = shinsaHohoKubunCode;
    }

    /**
     * 住宅改修完成年月日のgetメソッドです。
     *
     * @return 住宅改修完成年月日
     */
    public FlexibleDate getJutakuKaishuKanseiYMD() {
        return jutakuKaishuKanseiYMD;
    }

    /**
     * 住宅改修完成年月日のsetメソッドです。
     *
     * @param jutakuKaishuKanseiYMD 住宅改修完成年月日
     */
    public void setJutakuKaishuKanseiYMD(FlexibleDate jutakuKaishuKanseiYMD) {
        this.jutakuKaishuKanseiYMD = jutakuKaishuKanseiYMD;
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
     * このエンティティの主キーが他の{@literal DbT3049ShokanJutakuKaishuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3049ShokanJutakuKaishuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3049ShokanJutakuKaishuEntity other) {
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
    public void shallowCopy(DbT3049ShokanJutakuKaishuEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.junjiNo = entity.junjiNo;
        this.rirekiNo = entity.rirekiNo;
        this.serviceCode = entity.serviceCode;
        this.jutakuKaishuChakkoYMD = entity.jutakuKaishuChakkoYMD;
        this.jutakuKaishuJigyoshaName = entity.jutakuKaishuJigyoshaName;
        this.jutakuKaishuJutakuAddress = entity.jutakuKaishuJutakuAddress;
        this.kaishuKingaku = entity.kaishuKingaku;
        this.shinsaHohoKubunCode = entity.shinsaHohoKubunCode;
        this.jutakuKaishuKanseiYMD = entity.jutakuKaishuKanseiYMD;
        this.sagakuKingaku = entity.sagakuKingaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, junjiNo, rirekiNo, serviceCode, jutakuKaishuChakkoYMD, jutakuKaishuJigyoshaName, jutakuKaishuJutakuAddress, kaishuKingaku, shinsaHohoKubunCode, jutakuKaishuKanseiYMD, sagakuKingaku);
    }

// </editor-fold>
}
