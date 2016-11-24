/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0010021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufuJissekiPrmBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai.KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010021.TokuteiNyushoshahiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010021.dgTokuteiNyushoshaKaigoServicehi_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特定入所者費用のHandlerです。
 *
 * @reamsid_L DBC-2970-130 wangrenze
 */
public class TokuteiNyushoshahiHandler {

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
        List<dgTokuteiNyushoshaKaigoServicehi_Row> rowList = new ArrayList<>();
        if (business != null && !business.isEmpty()) {
            int 費用額合計 = 0;
            int 保険分請求額合計 = 0;
            int 利用者負担額合計 = 0;
            int 公費１_負担額合計 = 0;
            int 公費２_負担額合計 = 0;
            int 公費３_負担額合計 = 0;
            for (KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness 特定入所者介護サービス費用 : business) {
                rowList.add(getデータ(特定入所者介護サービス費用));
                費用額合計 = 特定入所者介護サービス費用.get特定入所者費用().get費用額().intValue() + 費用額合計;
                保険分請求額合計 = 特定入所者介護サービス費用.get特定入所者費用().get保険分請求額().intValue() + 保険分請求額合計;
                利用者負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get利用者負担額().intValue() + 利用者負担額合計;
                公費１_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get公費１負担額_明細().intValue() + 公費１_負担額合計;
                公費２_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get公費２負担額_明細().intValue() + 公費２_負担額合計;
                公費３_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get公費３負担額_明細().intValue() + 公費３_負担額合計;
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
            for (KyufujissekiTokuteiNyushosyaKaigoServiceHiyoBusiness 特定入所者介護サービス費用 : business) {
                rowList.add(get後のデータ(特定入所者介護サービス費用));
                後_費用額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_費用額().intValue() + 後_費用額合計;
                後_保険分請求額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_保険分請求額().intValue() + 後_保険分請求額合計;
                後_利用者負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_利用者負担額().intValue() + 後_利用者負担額合計;
                後_公費１_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_公費１負担額_明細().intValue() + 後_公費１_負担額合計;
                後_公費２_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_公費２負担額_明細().intValue() + 後_公費２_負担額合計;
                後_公費３_負担額合計 = 特定入所者介護サービス費用.get特定入所者費用().get後_公費３負担額_明細().intValue() + 後_公費３_負担額合計;
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
        }
        div.getDgTokuteiNyushoshaKaigoServicehi().setDataSource(rowList);
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
        div.getBtnKogakuKaigoService().setDisabled(true);
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
}
