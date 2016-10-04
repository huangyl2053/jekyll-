package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 事業高額合算支給額計算結果明細テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-9999-012 zhujun
 */
public class DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity extends DbTableEntityBase<DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisai");

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
    private FlexibleYear taishoNendo;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private RString shikyuShinseishoSeiriNo;
    @PrimaryKey
    private RString meisanNo;
    @PrimaryKey
    private int rirekiNo;
    private RString hokenSeidoCode;
    private RString uchiwakeHokenshaNo;
    private RString kokuho_HihokenshaShoKigo;
    private RString hiHokenshaShoNo;
    private RString uchiwakeHokenshaMei;
    private RString jikoFutanSeiriNo;
    private RString taishoshaShimei;
    private RString over70_Futangaku;
    private RString over70_AmbunRitsu;
    private RString over70_Shikyugaku;
    private RString under70_Futangaku;
    private RString futangaku;
    private RString ambunRitsu;
    private RString under70_Shikyugaku;
    private RString shikyugaku;
    private RString over70_Biko;
    private RString under70_Biko;
    private RString dataKubun;
    private FlexibleYearMonth uketoriYM;
    private FlexibleYearMonth sofuYM;

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
     * 対象年度のgetメソッドです。
     *
     * @return 対象年度
     */
    public FlexibleYear getTaishoNendo() {
        return taishoNendo;
    }

    /**
     * 対象年度のsetメソッドです。
     *
     * @param taishoNendo 対象年度
     */
    public void setTaishoNendo(@Nonnull FlexibleYear taishoNendo) {
        this.taishoNendo = taishoNendo;
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
    public void setShoKisaiHokenshaNo(@Nonnull HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 支給申請書整理番号のgetメソッドです。
     * <br/>
     * <br/>IF上は「連絡票整理番号」
     *
     * @return 支給申請書整理番号
     */
    public RString getShikyuShinseishoSeiriNo() {
        return shikyuShinseishoSeiriNo;
    }

    /**
     * 支給申請書整理番号のsetメソッドです。
     * <br/>
     * <br/>IF上は「連絡票整理番号」
     *
     * @param shikyuShinseishoSeiriNo 支給申請書整理番号
     */
    public void setShikyuShinseishoSeiriNo(@Nonnull RString shikyuShinseishoSeiriNo) {
        this.shikyuShinseishoSeiriNo = shikyuShinseishoSeiriNo;
    }

    /**
     * 明細番号のgetメソッドです。
     *
     * @return 明細番号
     */
    public RString getMeisanNo() {
        return meisanNo;
    }

    /**
     * 明細番号のsetメソッドです。
     *
     * @param meisanNo 明細番号
     */
    public void setMeisanNo(@Nonnull RString meisanNo) {
        this.meisanNo = meisanNo;
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
     * 保険制度コードのgetメソッドです。
     *
     * @return 保険制度コード
     */
    @CheckForNull
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
     * 内訳保険者番号のgetメソッドです。
     *
     * @return 内訳保険者番号
     */
    @CheckForNull
    public RString getUchiwakeHokenshaNo() {
        return uchiwakeHokenshaNo;
    }

    /**
     * 内訳保険者番号のsetメソッドです。
     *
     * @param uchiwakeHokenshaNo 内訳保険者番号
     */
    public void setUchiwakeHokenshaNo(RString uchiwakeHokenshaNo) {
        this.uchiwakeHokenshaNo = uchiwakeHokenshaNo;
    }

    /**
     * 国保被保険者証記号のgetメソッドです。
     *
     * @return 国保被保険者証記号
     */
    @CheckForNull
    public RString getKokuho_HihokenshaShoKigo() {
        return kokuho_HihokenshaShoKigo;
    }

    /**
     * 国保被保険者証記号のsetメソッドです。
     *
     * @param kokuho_HihokenshaShoKigo 国保被保険者証記号
     */
    public void setKokuho_HihokenshaShoKigo(RString kokuho_HihokenshaShoKigo) {
        this.kokuho_HihokenshaShoKigo = kokuho_HihokenshaShoKigo;
    }

    /**
     * 被保険者（証）番号のgetメソッドです。
     *
     * @return 被保険者（証）番号
     */
    @CheckForNull
    public RString getHiHokenshaShoNo() {
        return hiHokenshaShoNo;
    }

    /**
     * 被保険者（証）番号のsetメソッドです。
     *
     * @param hiHokenshaShoNo 被保険者（証）番号
     */
    public void setHiHokenshaShoNo(RString hiHokenshaShoNo) {
        this.hiHokenshaShoNo = hiHokenshaShoNo;
    }

    /**
     * 内訳保険者名のgetメソッドです。
     *
     * @return 内訳保険者名
     */
    @CheckForNull
    public RString getUchiwakeHokenshaMei() {
        return uchiwakeHokenshaMei;
    }

    /**
     * 内訳保険者名のsetメソッドです。
     *
     * @param uchiwakeHokenshaMei 内訳保険者名
     */
    public void setUchiwakeHokenshaMei(RString uchiwakeHokenshaMei) {
        this.uchiwakeHokenshaMei = uchiwakeHokenshaMei;
    }

    /**
     * 自己負担額証明書整理番号のgetメソッドです。
     *
     * @return 自己負担額証明書整理番号
     */
    @CheckForNull
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
     * 対象者氏名（漢字）のgetメソッドです。
     *
     * @return 対象者氏名（漢字）
     */
    @CheckForNull
    public RString getTaishoshaShimei() {
        return taishoshaShimei;
    }

    /**
     * 対象者氏名（漢字）のsetメソッドです。
     *
     * @param taishoshaShimei 対象者氏名（漢字）
     */
    public void setTaishoshaShimei(RString taishoshaShimei) {
        this.taishoshaShimei = taishoshaShimei;
    }

    /**
     * 70歳以上負担額のgetメソッドです。
     * <br/>
     * <br/>① 70歳以上負担額
     *
     * @return 70歳以上負担額
     */
    @CheckForNull
    public RString getOver70_Futangaku() {
        return over70_Futangaku;
    }

    /**
     * 70歳以上負担額のsetメソッドです。
     * <br/>
     * <br/>① 70歳以上負担額
     *
     * @param over70_Futangaku 70歳以上負担額
     */
    public void setOver70_Futangaku(RString over70_Futangaku) {
        this.over70_Futangaku = over70_Futangaku;
    }

    /**
     * 70歳以上按分率のgetメソッドです。
     * <br/>
     * <br/>② 70歳以上按分率
     *
     * @return 70歳以上按分率
     */
    @CheckForNull
    public RString getOver70_AmbunRitsu() {
        return over70_AmbunRitsu;
    }

    /**
     * 70歳以上按分率のsetメソッドです。
     * <br/>
     * <br/>② 70歳以上按分率
     *
     * @param over70_AmbunRitsu 70歳以上按分率
     */
    public void setOver70_AmbunRitsu(RString over70_AmbunRitsu) {
        this.over70_AmbunRitsu = over70_AmbunRitsu;
    }

    /**
     * 70歳以上支給額のgetメソッドです。
     * <br/>
     * <br/>③ ①にかかる支給額
     *
     * @return 70歳以上支給額
     */
    @CheckForNull
    public RString getOver70_Shikyugaku() {
        return over70_Shikyugaku;
    }

    /**
     * 70歳以上支給額のsetメソッドです。
     * <br/>
     * <br/>③ ①にかかる支給額
     *
     * @param over70_Shikyugaku 70歳以上支給額
     */
    public void setOver70_Shikyugaku(RString over70_Shikyugaku) {
        this.over70_Shikyugaku = over70_Shikyugaku;
    }

    /**
     * 70歳未満負担額のgetメソッドです。
     * <br/>
     * <br/>④ 70歳未満負担額
     *
     * @return 70歳未満負担額
     */
    @CheckForNull
    public RString getUnder70_Futangaku() {
        return under70_Futangaku;
    }

    /**
     * 70歳未満負担額のsetメソッドです。
     * <br/>
     * <br/>④ 70歳未満負担額
     *
     * @param under70_Futangaku 70歳未満負担額
     */
    public void setUnder70_Futangaku(RString under70_Futangaku) {
        this.under70_Futangaku = under70_Futangaku;
    }

    /**
     * 負担額のgetメソッドです。
     * <br/>
     * <br/>⑤ ④＋（①－③）
     *
     * @return 負担額
     */
    @CheckForNull
    public RString getFutangaku() {
        return futangaku;
    }

    /**
     * 負担額のsetメソッドです。
     * <br/>
     * <br/>⑤ ④＋（①－③）
     *
     * @param futangaku 負担額
     */
    public void setFutangaku(RString futangaku) {
        this.futangaku = futangaku;
    }

    /**
     * 按分率のgetメソッドです。
     * <br/>
     * <br/>⑥ 按分率
     *
     * @return 按分率
     */
    @CheckForNull
    public RString getAmbunRitsu() {
        return ambunRitsu;
    }

    /**
     * 按分率のsetメソッドです。
     * <br/>
     * <br/>⑥ 按分率
     *
     * @param ambunRitsu 按分率
     */
    public void setAmbunRitsu(RString ambunRitsu) {
        this.ambunRitsu = ambunRitsu;
    }

    /**
     * 70歳未満支給額のgetメソッドです。
     * <br/>
     * <br/>⑦ ⑤に係る支給額
     *
     * @return 70歳未満支給額
     */
    @CheckForNull
    public RString getUnder70_Shikyugaku() {
        return under70_Shikyugaku;
    }

    /**
     * 70歳未満支給額のsetメソッドです。
     * <br/>
     * <br/>⑦ ⑤に係る支給額
     *
     * @param under70_Shikyugaku 70歳未満支給額
     */
    public void setUnder70_Shikyugaku(RString under70_Shikyugaku) {
        this.under70_Shikyugaku = under70_Shikyugaku;
    }

    /**
     * 支給額のgetメソッドです。
     * <br/>
     * <br/>⑧ ③＋⑦
     *
     * @return 支給額
     */
    @CheckForNull
    public RString getShikyugaku() {
        return shikyugaku;
    }

    /**
     * 支給額のsetメソッドです。
     * <br/>
     * <br/>⑧ ③＋⑦
     *
     * @param shikyugaku 支給額
     */
    public void setShikyugaku(RString shikyugaku) {
        this.shikyugaku = shikyugaku;
    }

    /**
     * 備考欄記載70歳以上負担額のgetメソッドです。
     * <br/>
     * <br/>（平成20年4月～7月分）
     *
     * @return 備考欄記載70歳以上負担額
     */
    @CheckForNull
    public RString getOver70_Biko() {
        return over70_Biko;
    }

    /**
     * 備考欄記載70歳以上負担額のsetメソッドです。
     * <br/>
     * <br/>（平成20年4月～7月分）
     *
     * @param over70_Biko 備考欄記載70歳以上負担額
     */
    public void setOver70_Biko(RString over70_Biko) {
        this.over70_Biko = over70_Biko;
    }

    /**
     * 備考欄記載70歳未満負担額のgetメソッドです。
     * <br/>
     * <br/>（平成20年4月～7月分）
     *
     * @return 備考欄記載70歳未満負担額
     */
    @CheckForNull
    public RString getUnder70_Biko() {
        return under70_Biko;
    }

    /**
     * 備考欄記載70歳未満負担額のsetメソッドです。
     * <br/>
     * <br/>（平成20年4月～7月分）
     *
     * @param under70_Biko 備考欄記載70歳未満負担額
     */
    public void setUnder70_Biko(RString under70_Biko) {
        this.under70_Biko = under70_Biko;
    }

    /**
     * データ区分のgetメソッドです。
     *
     * @return データ区分
     */
    @CheckForNull
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
     * 受取年月のgetメソッドです。
     *
     * @return 受取年月
     */
    @CheckForNull
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
    @CheckForNull
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
     * このエンティティの主キーが他の{@literal DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.taishoNendo, other.taishoNendo)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikyuShinseishoSeiriNo, other.shikyuShinseishoSeiriNo)) {
            return false;
        }
        if (!Objects.equals(this.meisanNo, other.meisanNo)) {
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
    public void shallowCopy(DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoNendo = entity.taishoNendo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikyuShinseishoSeiriNo = entity.shikyuShinseishoSeiriNo;
        this.meisanNo = entity.meisanNo;
        this.rirekiNo = entity.rirekiNo;
        this.hokenSeidoCode = entity.hokenSeidoCode;
        this.uchiwakeHokenshaNo = entity.uchiwakeHokenshaNo;
        this.kokuho_HihokenshaShoKigo = entity.kokuho_HihokenshaShoKigo;
        this.hiHokenshaShoNo = entity.hiHokenshaShoNo;
        this.uchiwakeHokenshaMei = entity.uchiwakeHokenshaMei;
        this.jikoFutanSeiriNo = entity.jikoFutanSeiriNo;
        this.taishoshaShimei = entity.taishoshaShimei;
        this.over70_Futangaku = entity.over70_Futangaku;
        this.over70_AmbunRitsu = entity.over70_AmbunRitsu;
        this.over70_Shikyugaku = entity.over70_Shikyugaku;
        this.under70_Futangaku = entity.under70_Futangaku;
        this.futangaku = entity.futangaku;
        this.ambunRitsu = entity.ambunRitsu;
        this.under70_Shikyugaku = entity.under70_Shikyugaku;
        this.shikyugaku = entity.shikyugaku;
        this.over70_Biko = entity.over70_Biko;
        this.under70_Biko = entity.under70_Biko;
        this.dataKubun = entity.dataKubun;
        this.uketoriYM = entity.uketoriYM;
        this.sofuYM = entity.sofuYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, taishoNendo, shoKisaiHokenshaNo, shikyuShinseishoSeiriNo, meisanNo, rirekiNo, hokenSeidoCode, uchiwakeHokenshaNo, kokuho_HihokenshaShoKigo, hiHokenshaShoNo, uchiwakeHokenshaMei, jikoFutanSeiriNo, taishoshaShimei, over70_Futangaku, over70_AmbunRitsu, over70_Shikyugaku, under70_Futangaku, futangaku, ambunRitsu, under70_Shikyugaku, shikyugaku, over70_Biko, under70_Biko, dataKubun, uketoriYM, sofuYM);
    }

// </editor-fold>
}
