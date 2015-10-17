package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;

/**
 * 高額合算給付実績テーブルのエンティティクラスです。
 */
public class DbT3075KogakuGassanKyufuJissekiEntity extends DbTableEntityBase<DbT3075KogakuGassanKyufuJissekiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3075KogakuGassanKyufuJisseki");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString shikyuShinseiSeiriNo;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private RString jikoFutanSeiriNo;
    private RString hokenSeidoCode;
    private RString kyufuJissekiSakuseiKubunCode;
    private HokenshaNo shoKisaiHokenshaNo;
    private RString kokuho_HihokenshaShoKigo;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private Decimal jikoFutanSogaku;
    private Decimal shikyuGaku;
    private FlexibleYearMonth shoriYM;
    private FlexibleYearMonth uketoriYM;
    private FlexibleYearMonth sofuYM;
    private RString dataKubun;

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
     * 交換情報識別番号のgetメソッドです。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * 交換情報識別番号のsetメソッドです。
     *
     * @param kokanJohoShikibetsuNo 交換情報識別番号
     */
    public void setKokanJohoShikibetsuNo(KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
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
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 支給申請書整理番号のgetメソッドです。
     *
     * @return 支給申請書整理番号
     */
    public RString getShikyuShinseiSeiriNo() {
        return shikyuShinseiSeiriNo;
    }

    /**
     * 支給申請書整理番号のsetメソッドです。
     *
     * @param shikyuShinseiSeiriNo 支給申請書整理番号
     */
    public void setShikyuShinseiSeiriNo(RString shikyuShinseiSeiriNo) {
        this.shikyuShinseiSeiriNo = shikyuShinseiSeiriNo;
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
     * 自己負担額証明書整理番号のgetメソッドです。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString getJikoFutanSeiriNo() {
        return jikoFutanSeiriNo;
    }

    /**
     * 自己負担額証明書整理番号のsetメソッドです。
     *
     * @param jikoFutanSeiriNo 自己負担額証明書整理番号
     */
    public void setJikoFutanSeiriNo(RString jikoFutanSeiriNo) {
        this.jikoFutanSeiriNo = jikoFutanSeiriNo;
    }

    /**
     * 保険制度コードのgetメソッドです。
     *
     * @return 保険制度コード
     */
    public RString getHokenSeidoCode() {
        return hokenSeidoCode;
    }

    /**
     * 保険制度コードのsetメソッドです。
     *
     * @param hokenSeidoCode 保険制度コード
     */
    public void setHokenSeidoCode(RString hokenSeidoCode) {
        this.hokenSeidoCode = hokenSeidoCode;
    }

    /**
     * 給付実績作成区分コードのgetメソッドです。
     *
     * @return 給付実績作成区分コード
     */
    public RString getKyufuJissekiSakuseiKubunCode() {
        return kyufuJissekiSakuseiKubunCode;
    }

    /**
     * 給付実績作成区分コードのsetメソッドです。
     *
     * @param kyufuJissekiSakuseiKubunCode 給付実績作成区分コード
     */
    public void setKyufuJissekiSakuseiKubunCode(RString kyufuJissekiSakuseiKubunCode) {
        this.kyufuJissekiSakuseiKubunCode = kyufuJissekiSakuseiKubunCode;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 国保 被保険者証記号のgetメソッドです。
     *
     * @return 国保 被保険者証記号
     */
    public RString getKokuho_HihokenshaShoKigo() {
        return kokuho_HihokenshaShoKigo;
    }

    /**
     * 国保 被保険者証記号のsetメソッドです。
     *
     * @param kokuho_HihokenshaShoKigo 国保 被保険者証記号
     */
    public void setKokuho_HihokenshaShoKigo(RString kokuho_HihokenshaShoKigo) {
        this.kokuho_HihokenshaShoKigo = kokuho_HihokenshaShoKigo;
    }

    /**
     * 申請年月日のgetメソッドです。
     *
     * @return 申請年月日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     *
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 決定年月日のgetメソッドです。
     *
     * @return 決定年月日
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 決定年月日のsetメソッドです。
     *
     * @param ketteiYMD 決定年月日
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * 自己負担総額のgetメソッドです。
     *
     * @return 自己負担総額
     */
    public Decimal getJikoFutanSogaku() {
        return jikoFutanSogaku;
    }

    /**
     * 自己負担総額のsetメソッドです。
     *
     * @param jikoFutanSogaku 自己負担総額
     */
    public void setJikoFutanSogaku(Decimal jikoFutanSogaku) {
        this.jikoFutanSogaku = jikoFutanSogaku;
    }

    /**
     * 支給額のgetメソッドです。
     *
     * @return 支給額
     */
    public Decimal getShikyuGaku() {
        return shikyuGaku;
    }

    /**
     * 支給額のsetメソッドです。
     *
     * @param shikyuGaku 支給額
     */
    public void setShikyuGaku(Decimal shikyuGaku) {
        this.shikyuGaku = shikyuGaku;
    }

    /**
     * 処理年月のgetメソッドです。
     *
     * @return 処理年月
     */
    public FlexibleYearMonth getShoriYM() {
        return shoriYM;
    }

    /**
     * 処理年月のsetメソッドです。
     *
     * @param shoriYM 処理年月
     */
    public void setShoriYM(FlexibleYearMonth shoriYM) {
        this.shoriYM = shoriYM;
    }

    /**
     * 受取年月のgetメソッドです。
     *
     * @return 受取年月
     */
    public FlexibleYearMonth getUketoriYM() {
        return uketoriYM;
    }

    /**
     * 受取年月のsetメソッドです。
     *
     * @param uketoriYM 受取年月
     */
    public void setUketoriYM(FlexibleYearMonth uketoriYM) {
        this.uketoriYM = uketoriYM;
    }

    /**
     * 送付年月のgetメソッドです。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * 送付年月のsetメソッドです。
     *
     * @param sofuYM 送付年月
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * データ区分のgetメソッドです。
     *
     * @return データ区分
     */
    public RString getDataKubun() {
        return dataKubun;
    }

    /**
     * データ区分のsetメソッドです。
     *
     * @param dataKubun データ区分
     */
    public void setDataKubun(RString dataKubun) {
        this.dataKubun = dataKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3075KogakuGassanKyufuJissekiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3075KogakuGassanKyufuJissekiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3075KogakuGassanKyufuJissekiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kokanJohoShikibetsuNo, other.kokanJohoShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikyuShinseiSeiriNo, other.shikyuShinseiSeiriNo)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
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
    public void shallowCopy(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shikyuShinseiSeiriNo = entity.shikyuShinseiSeiriNo;
        this.seiriNo = entity.seiriNo;
        this.rirekiNo = entity.rirekiNo;
        this.jikoFutanSeiriNo = entity.jikoFutanSeiriNo;
        this.hokenSeidoCode = entity.hokenSeidoCode;
        this.kyufuJissekiSakuseiKubunCode = entity.kyufuJissekiSakuseiKubunCode;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.kokuho_HihokenshaShoKigo = entity.kokuho_HihokenshaShoKigo;
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.jikoFutanSogaku = entity.jikoFutanSogaku;
        this.shikyuGaku = entity.shikyuGaku;
        this.shoriYM = entity.shoriYM;
        this.uketoriYM = entity.uketoriYM;
        this.sofuYM = entity.sofuYM;
        this.dataKubun = entity.dataKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, hihokenshaNo, shikyuShinseiSeiriNo, seiriNo, rirekiNo, jikoFutanSeiriNo, hokenSeidoCode, kyufuJissekiSakuseiKubunCode, shoKisaiHokenshaNo, kokuho_HihokenshaShoKigo, shinseiYMD, ketteiYMD, jikoFutanSogaku, shikyuGaku, shoriYM, uketoriYM, sofuYM, dataKubun);
    }

// </editor-fold>
}
