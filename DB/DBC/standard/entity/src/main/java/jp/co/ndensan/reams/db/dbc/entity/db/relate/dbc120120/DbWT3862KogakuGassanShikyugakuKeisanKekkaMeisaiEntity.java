/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc120120;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 高額合算支給額計算結果明細一時TBL項目定義クラスです。
 *
 * @reamsid_L DBC-2680-010 xicongwang
 */
public class DbWT3862KogakuGassanShikyugakuKeisanKekkaMeisaiEntity extends DbTableEntityBase<DbWT3862KogakuGassanShikyugakuKeisanKekkaMeisaiEntity>
        implements IDbAccessable {

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
    private Decimal rirekiNo;
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
    public void setTaishoNendo(FlexibleYear taishoNendo) {
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
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
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
    public void setShikyuShinseishoSeiriNo(RString shikyuShinseishoSeiriNo) {
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
    public void setMeisanNo(RString meisanNo) {
        this.meisanNo = meisanNo;
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
     * 内訳保険者番号のgetメソッドです。
     *
     * @return 内訳保険者番号
     */
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
}
