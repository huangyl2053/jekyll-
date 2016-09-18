/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010021;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiHedajyoho2;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010021.TokuteiNyushoshahiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010021.dgTokuteiNyushoshaKaigoServicehi_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特定入所者費用のHandlerです。
 *
 * @reamsid_L DBC-2970-130 wangrenze
 */
public class TokuteiNyushoshahiHandler {

    private static final RString 前月 = new RString("前月");
    private static final RString 前事業者 = new RString("前事業者");
    private final TokuteiNyushoshahiDiv div;
    private static final RString DISABLED = new RString("0");

    /**
     * 画面の初期化です。
     *
     * @param div TokuteiNyushoshahiDiv
     */
    public TokuteiNyushoshahiHandler(TokuteiNyushoshahiDiv div) {
        this.div = div;
    }

    /**
     * 画面の共有子Divを初期化する。
     *
     * @param 引き継ぎ情報 KyufuJissekiPrmBusiness
     * @param 整理番号 RString
     * @param サービス提供年月 FlexibleYearMonth
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void load共有子Div(KyufuJissekiPrmBusiness 引き継ぎ情報, RString 整理番号, FlexibleYearMonth サービス提供年月, NyuryokuShikibetsuNo 識別番号) {
        HihokenshaNo 被保険者番号 = 引き継ぎ情報.getKojinKakuteiKey().get被保険者番号();
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, サービス提供年月, 整理番号, 識別番号);

    }

    /**
     * 画面のデータを初期化する。
     *
     * @param business List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness>
     */
    public void setDataGrid(List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> business) {
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RDate サービス提供 = div.getCcdKyufuJissekiHeader().getサービス提供年月();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> 特定入所者介護サービス費用list = get給付実績データ(business,
                整理番号, 事業者番号, 様式番号, サービス提供.getYearMonth().toDateString());
        List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> dataToRepeat = getサービス提供年月list(business);
        List<dgTokuteiNyushoshaKaigoServicehi_Row> rowList = new ArrayList<>();
        int 費用額合計 = 0;
        int 保険分請求額合計 = 0;
        int 利用者負担額合計 = 0;
        int 公費１_負担額合計 = 0;
        int 公費２_負担額合計 = 0;
        int 公費３_負担額合計 = 0;
        for (KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness 特定入所者介護サービス費用 : 特定入所者介護サービス費用list) {
            rowList.add(getデータ(特定入所者介護サービス費用));
            費用額合計 = 特定入所者介護サービス費用.get特定入所者費用().get費用額合計().intValue() + 費用額合計;
            保険分請求額合計 = 特定入所者介護サービス費用.get特定入所者費用().get保険分請求額合計().intValue() + 保険分請求額合計;
            利用者負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get利用者負担額合計().intValue() + 利用者負担額合計;
            公費１_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get公費１_負担額合計().intValue() + 公費１_負担額合計;
            公費２_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get公費２_負担額合計().intValue() + 公費２_負担額合計;
            公費３_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get公費３_負担額合計().intValue() + 公費３_負担額合計;
        }
        dgTokuteiNyushoshaKaigoServicehi_Row 合計row = new dgTokuteiNyushoshaKaigoServicehi_Row();
        合計row.setTxtMeisaiGokei(new RString("合計"));
        合計row.setTxtHiyogaku(get金額(new Decimal(費用額合計)));
        合計row.setTxtSeikyugaku(get金額(new Decimal(保険分請求額合計)));
        合計row.setTxtRiyoshaFutangaku(get金額(new Decimal(利用者負担額合計)));
        合計row.setTxtKohi1Futangaku(get金額(new Decimal(公費１_負担額合計)));
        合計row.setTxtKohi2Futangaku(get金額(new Decimal(公費２_負担額合計)));
        合計row.setTxtKohi3Futangaku(get金額(new Decimal(公費３_負担額合計)));
        rowList.add(合計row);
        int 後_費用額合計 = 0;
        int 後_保険分請求額合計 = 0;
        int 後_利用者負担額合計 = 0;
        int 後_公費１_負担額合計 = 0;
        int 後_公費２_負担額合計 = 0;
        int 後_公費３_負担額合計 = 0;
        for (KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness 特定入所者介護サービス費用 : 特定入所者介護サービス費用list) {
            rowList.add(get後のデータ(特定入所者介護サービス費用));
            後_費用額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_費用額合計().intValue() + 後_費用額合計;
            後_保険分請求額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_保険分請求額合計().intValue() + 後_保険分請求額合計;
            後_利用者負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_利用者負担額合計().intValue() + 後_利用者負担額合計;
            後_公費１_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_公費１_負担額合計().intValue() + 後_公費１_負担額合計;
            後_公費２_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_公費２_負担額合計().intValue() + 後_公費２_負担額合計;
            後_公費３_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_公費３_負担額合計().intValue() + 後_公費３_負担額合計;
        }
        dgTokuteiNyushoshaKaigoServicehi_Row 後_合計row = new dgTokuteiNyushoshaKaigoServicehi_Row();
        後_合計row.setTxtMeisaiGokei(new RString("合計"));
        後_合計row.setTxtHiyogaku(get金額(new Decimal(後_費用額合計)));
        後_合計row.setTxtSeikyugaku(get金額(new Decimal(後_保険分請求額合計)));
        後_合計row.setTxtRiyoshaFutangaku(get金額(new Decimal(後_利用者負担額合計)));
        後_合計row.setTxtKohi1Futangaku(get金額(new Decimal(後_公費１_負担額合計)));
        後_合計row.setTxtKohi2Futangaku(get金額(new Decimal(後_公費２_負担額合計)));
        後_合計row.setTxtKohi3Futangaku(get金額(new Decimal(後_公費３_負担額合計)));
        rowList.add(後_合計row);
        div.getDgTokuteiNyushoshaKaigoServicehi().setDataSource(rowList);
        setGetsuBtn(dataToRepeat, new FlexibleYearMonth(div.getCcdKyufuJissekiHeader().getサービス提供年月()
                .getYearMonth().toDateString()));
    }

    private void setGetsuBtn(List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> 特定入所者介護サービス費用list, FlexibleYearMonth サービス提供年月) {
        div.getBtnZengetsu().setDisabled(true);
        div.getBtnJigetsu().setDisabled(true);
        if (特定入所者介護サービス費用list != null && !特定入所者介護サービス費用list.isEmpty()) {
            Collections.sort(特定入所者介護サービス費用list, new TokuteiNyushoshahiHandler.DateComparatorServiceTeikyoYM());
            if (!サービス提供年月.isBeforeOrEquals(特定入所者介護サービス費用list.get(特定入所者介護サービス費用list.size() - 1).get特定入所者費用().getサービス提供年月())) {
                div.getBtnZengetsu().setDisabled(false);
            }
            if (!特定入所者介護サービス費用list.get(0).get特定入所者費用().getサービス提供年月()
                    .isBeforeOrEquals(サービス提供年月)) {
                div.getBtnJigetsu().setDisabled(false);
            }
        }
    }

    private dgTokuteiNyushoshaKaigoServicehi_Row getデータ(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness 特定入所者介護サービス費用) {
        dgTokuteiNyushoshaKaigoServicehi_Row row = new dgTokuteiNyushoshaKaigoServicehi_Row();
        row.setTxtService(特定入所者介護サービス費用.getサービス種類略称());
        row.setTxtFutanGendogaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get負担限度額()));
        row.setTxtKettei(RString.EMPTY);
        row.setTxtMeisaiGokei(new RString("明細"));
        row.setTxtHiyoTanka(get金額(特定入所者介護サービス費用.get特定入所者費用().get費用単価()));
        row.setTxtNissu(new RString(特定入所者介護サービス費用.get特定入所者費用().get日数()));
        row.setTxtHiyogaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get費用額()));
        row.setTxtSeikyugaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get保険分請求額()));
        row.setTxtRiyoshaFutangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get利用者負担額()));
        row.setTxtKohi1Nissu(new RString(特定入所者介護サービス費用.get特定入所者費用().get公費１日数()));
        row.setTxtKohi1Futangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get公費１負担額_明細()));
        row.setTxtKohi1Seikyugaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get公費１_請求額()));
        row.setTxtKohi1HonninFutangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get公費１_本人負担月額()));
        row.setTxtKohi2Nissu(new RString(特定入所者介護サービス費用.get特定入所者費用().get公費２日数()));
        row.setTxtKohi2Futangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get公費２負担額_明細()));
        row.setTxtKohi2Seikyugaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get公費２_請求額()));
        row.setTxtKohi2HonninFutangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get公費２_本人負担月額()));
        row.setTxtKohi3Nissu(new RString(特定入所者介護サービス費用.get特定入所者費用().get公費３日数()));
        row.setTxtKohi3Futangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get公費３負担額_明細()));
        row.setTxtKohi3Seikyugaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get公費３_請求額()));
        row.setTxtKohi3HonninFutangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get公費３_本人負担月額()));
        row.setTxtSaishinsaKaisu(new RString(特定入所者介護サービス費用.get特定入所者費用().get再審査回数()));
        row.setTxtKagoKaisu(new RString(特定入所者介護サービス費用.get特定入所者費用().get過誤回数()));
        row.setTxtShinsaYM(getパターン51(特定入所者介護サービス費用.get特定入所者費用().get審査年月()));
        return row;
    }

    private dgTokuteiNyushoshaKaigoServicehi_Row get後のデータ(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness 特定入所者介護サービス費用) {
        dgTokuteiNyushoshaKaigoServicehi_Row row = new dgTokuteiNyushoshaKaigoServicehi_Row();
        row.setTxtKettei(new RString("後"));
        row.setTxtMeisaiGokei(new RString("明細"));
        row.setTxtHiyoTanka(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_費用単価()));
        row.setTxtNissu(new RString(特定入所者介護サービス費用.get特定入所者費用().get後_日数()));
        row.setTxtHiyogaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_費用額()));
        row.setTxtSeikyugaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_保険分請求額()));
        row.setTxtRiyoshaFutangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_利用者負担額()));
        row.setTxtKohi1Nissu(new RString(特定入所者介護サービス費用.get特定入所者費用().get後_公費１日数()));
        row.setTxtKohi1Futangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_公費１負担額_明細()));
        row.setTxtKohi1Seikyugaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_公費１_請求額()));
        row.setTxtKohi1HonninFutangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_公費１_本人負担月額()));
        row.setTxtKohi2Nissu(new RString(特定入所者介護サービス費用.get特定入所者費用().get後_公費２日数()));
        row.setTxtKohi2Futangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_公費２負担額_明細()));
        row.setTxtKohi2Seikyugaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_公費２_請求額()));
        row.setTxtKohi2HonninFutangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_公費２_本人負担月額()));
        row.setTxtKohi3Nissu(new RString(特定入所者介護サービス費用.get特定入所者費用().get後_公費３日数()));
        row.setTxtKohi3Futangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_公費３負担額_明細()));
        row.setTxtKohi3Seikyugaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_公費３_請求額()));
        row.setTxtKohi3HonninFutangaku(get金額(特定入所者介護サービス費用.get特定入所者費用().get後_公費３_本人負担月額()));
        return row;
    }

    /**
     * ボタン状態の設定です。
     *
     * @param 識別番号管理 ShikibetsuNoKanri
     */
    public void setButton(ShikibetsuNoKanri 識別番号管理) {
        if (DISABLED.equals(識別番号管理.get基本設定区分())) {
            div.getBtnKihon().setDisabled(true);
        } else {
            div.getBtnKihon().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get明細設定区分())) {
            div.getBtnMeisaiShukei().setDisabled(true);
        } else {
            div.getBtnMeisaiShukei().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get所定疾患施設療養設定区分())) {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnShoteiShikkanShisetsuRyoyo().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get緊急時施設療養設定区分())) {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(true);
        } else {
            div.getBtnKinkyujiShisetsuRyoyo().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get食事費用設定区分())) {
            div.getBtnShokuji().setDisabled(true);
        } else {
            div.getBtnShokuji().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get福祉用具購入費設定区分())) {
            div.getBtnFukushiYoguKonyu().setDisabled(true);
        } else {
            div.getBtnFukushiYoguKonyu().setDisabled(false);
        }
        add(識別番号管理);
    }

    private void add(ShikibetsuNoKanri 識別番号管理) {
        if (DISABLED.equals(識別番号管理.get居宅計画費設定区分())) {
            div.getBtnKyotakuServiceKeikaku().setDisabled(true);
        } else {
            div.getBtnKyotakuServiceKeikaku().setDisabled(false);
        }
        div.getBtnTokuteiNyushosha().setDisabled(true);
        if (DISABLED.equals(識別番号管理.get高額介護サービス費設定区分())) {
            div.getBtnKogakuKaigoService().setDisabled(true);
        } else {
            div.getBtnKogakuKaigoService().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get特定診療費設定区分())) {
            div.getBtnTokuteiShinryo().setDisabled(true);
        } else {
            div.getBtnTokuteiShinryo().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get住宅改修費設定区分())) {
            div.getBtnJutakuKaishu().setDisabled(true);
        } else {
            div.getBtnJutakuKaishu().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.getケアマネジメント設定区分())) {
            div.getBtnCareManagement().setDisabled(true);
        } else {
            div.getBtnCareManagement().setDisabled(false);
        }
        if (DISABLED.equals(識別番号管理.get社会福祉法人軽減設定区分())) {
            div.getBtnShafukuKeigen().setDisabled(true);
        } else {
            div.getBtnShafukuKeigen().setDisabled(false);
        }
    }

    /**
     * 事業者番号の設定です。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 整理番号 RString
     * @param 事業者番号 RString
     * @param 様式番号 RString
     * @param サービス提供年月 RString
     * @param 実績区分コード RString
     * @return index index
     */
    public int get事業者番号index(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        for (int index = 0; index < 事業者番号リスト.size(); index++) {
            if (事業者番号.equals(事業者番号リスト.get(index).get事業所番号().value())
                    && 整理番号.equals(事業者番号リスト.get(index).get整理番号())
                    && 様式番号.equals(事業者番号リスト.get(index).get識別番号())
                    && サービス提供年月.equals(事業者番号リスト.get(index).getサービス提供年月().toDateString())
                    && 実績区分コード.equals(事業者番号リスト.get(index).get給付実績区分コード())) {
                return index;
            }
        }
        return 0;
    }

    /**
     * change年月です。
     *
     * @param change月 RString
     * @param 特定入所者費用 List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness>
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 識別番号 NyuryokuShikibetsuNo
     */
    public void change年月(RString change月, List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> 特定入所者費用,
            FlexibleYearMonth サービス提供年月, RString 整理番号, HihokenshaNo 被保険者番号, NyuryokuShikibetsuNo 識別番号) {
        int index = 0;
        List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> dataToRepeat = getサービス提供年月list(特定入所者費用);
        Collections.sort(dataToRepeat, new TokuteiNyushoshahiHandler.DateComparatorServiceTeikyoYM());
        for (int i = 0; i < dataToRepeat.size(); i++) {
            if (サービス提供年月.equals(dataToRepeat.get(i).get特定入所者費用().getサービス提供年月())) {
                index = i;
                break;
            }
        }
        FlexibleYearMonth 年月;
        RString 新整理番号;
        NyuryokuShikibetsuNo 新識別番号;
        if (前月.equals(change月)) {
            年月 = dataToRepeat.get(index + 1).get特定入所者費用().getサービス提供年月();
            新整理番号 = dataToRepeat.get(index + 1).get特定入所者費用().get整理番号();
            新識別番号 = dataToRepeat.get(index + 1).get特定入所者費用().get入力識別番号();
            div.getBtnJigetsu().setDisabled(false);
        } else {
            年月 = dataToRepeat.get(index - 1).get特定入所者費用().getサービス提供年月();
            新整理番号 = dataToRepeat.get(index - 1).get特定入所者費用().get整理番号();
            新識別番号 = dataToRepeat.get(index - 1).get特定入所者費用().get入力識別番号();
            div.getBtnZengetsu().setDisabled(false);
        }
        div.getCcdKyufuJissekiHeader().initialize(被保険者番号, 年月, 新整理番号, 新識別番号);
        setDataGrid(dataToRepeat);

    }

    private List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> getサービス提供年月list(List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> 給付実績居宅サービス計画費list) {
        List<FlexibleYearMonth> サービス提供年月list = new ArrayList<>();
        List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> dataToRepeat = new ArrayList<>();
        for (KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness date : 給付実績居宅サービス計画費list) {
            if (!サービス提供年月list.contains(date.get特定入所者費用().getサービス提供年月())) {
                サービス提供年月list.add(date.get特定入所者費用().getサービス提供年月());
                dataToRepeat.add(date);
            }
        }
        return dataToRepeat;
    }

    /**
     * change事業者です。
     *
     * @param date RString
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 給付実績特定入所者介護サービス費用list List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness>
     */
    public void change事業者(RString date, List<KyufuJissekiHedajyoho2> 事業者番号リスト, List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> 給付実績特定入所者介護サービス費用list) {
        RString 事業者番号 = div.getCcdKyufuJissekiHeader().get事業者番号();
        RString 整理番号 = div.getCcdKyufuJissekiHeader().get整理番号();
        RString 様式番号 = div.getCcdKyufuJissekiHeader().get様式番号();
        RString 実績区分コード = div.getCcdKyufuJissekiHeader().get実績区分コード();
        RDate サービス提供 = div.getCcdKyufuJissekiHeader().getサービス提供年月();
        RString サービス提供年月 = サービス提供.getYearMonth().toDateString();
        int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
        int i;
        if (前事業者.equals(date)) {
            i = -1;
        } else {
            i = 1;
        }
        div.getCcdKyufuJissekiHeader().set事業者名称(事業者番号リスト.get(index + i).get事業者名称());
        div.getCcdKyufuJissekiHeader().set事業者番号(事業者番号リスト.get(index + i).get事業所番号().value());
        div.getCcdKyufuJissekiHeader().set実績区分(事業者番号リスト.get(index + i).get給付実績区分コード());
        div.getCcdKyufuJissekiHeader().set整理番号(事業者番号リスト.get(index + i).get整理番号());
        div.getCcdKyufuJissekiHeader().set識別番号名称(事業者番号リスト.get(index + i).get識別番号名称());
        div.getCcdKyufuJissekiHeader().set様式番号(事業者番号リスト.get(index + i).get識別番号());
        setDataGrid(給付実績特定入所者介護サービス費用list);
        div.getBtnMaeJigyosha().setDisabled(true);
        div.getBtnAtoJigyosha().setDisabled(true);
        if (0 < index + i) {
            div.getBtnMaeJigyosha().setDisabled(false);
        }
        if (index + i + 1 < 事業者番号リスト.size()) {
            div.getBtnAtoJigyosha().setDisabled(false);
        }
    }

    private List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> get給付実績データ(List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> 給付実績特定入所者介護サービス費用list, RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月) {
        List<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness> 特定入所者介護サービス費用list = new ArrayList<>();
        for (int index = 0; index < 給付実績特定入所者介護サービス費用list.size(); index++) {
            if (事業者番号.equals(給付実績特定入所者介護サービス費用list.get(index).get特定入所者費用().get事業所番号().value())
                    && 整理番号.equals(給付実績特定入所者介護サービス費用list.get(index).get特定入所者費用().get整理番号())
                    && 様式番号.equals(給付実績特定入所者介護サービス費用list.get(index).get特定入所者費用().get入力識別番号().value())
                    && サービス提供年月.equals(給付実績特定入所者介護サービス費用list.get(index).get特定入所者費用().getサービス提供年月().toDateString())) {
                特定入所者介護サービス費用list.add(給付実績特定入所者介護サービス費用list.get(index));
            }
        }
        return 特定入所者介護サービス費用list;
    }

    /**
     * 事業者btnのstateです。
     *
     * @param 事業者番号リスト List<KyufuJissekiHedajyoho2>
     * @param 整理番号 RString
     * @param 様式番号 RString
     * @param 事業者番号 RString
     * @param サービス提供年月 RString
     * @param 実績区分コード RString
     */
    public void check事業者btn(List<KyufuJissekiHedajyoho2> 事業者番号リスト, RString 整理番号, RString 事業者番号, RString 様式番号, RString サービス提供年月, RString 実績区分コード) {
        div.getBtnMaeJigyosha().setDisabled(true);
        div.getBtnAtoJigyosha().setDisabled(true);
        if (!事業者番号リスト.isEmpty()) {
            int index = get事業者番号index(事業者番号リスト, 整理番号, 事業者番号, 様式番号, サービス提供年月, 実績区分コード);
            if (0 < index) {
                div.getBtnMaeJigyosha().setDisabled(false);
            }
            if (index + 1 < 事業者番号リスト.size()) {
                div.getBtnAtoJigyosha().setDisabled(false);
            }
        }
    }

    private RString get金額(Decimal 金額) {
        if (金額 != null) {
            return DecimalFormatter.toコンマ区切りRString(金額, 0);
        }
        return new RString(Decimal.ZERO.intValue());
    }

    private RString getパターン51(FlexibleYearMonth 年月) {
        if (年月 != null && !年月.isEmpty()) {
            return 年月.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private static class DateComparatorServiceTeikyoYM implements Comparator<KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness>, Serializable {

        private static final long serialVersionUID = -300796001015547240L;

        @Override
        public int compare(KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness o1, KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness o2) {
            return o2.get特定入所者費用().getサービス提供年月().compareTo(o1.get特定入所者費用().getサービス提供年月());
        }
    }
}
