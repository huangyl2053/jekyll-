/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.InputShikibetsuNo;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonHihokensha;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonKohi;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonKyufuritsu;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonNyutaisho;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKihonServiceKikan;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiYoshiki;
import jp.co.ndensan.reams.db.dbc.definition.core.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.CareManagementhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.FukushiYoguKonyuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.JutakuKaishuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KogakuKaigoServicehiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonHihokenshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonKohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonKyotakuServiceKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonKyufuritsuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonServiceKikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiKihonShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiMeisaiShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.ServiceKeikakuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgFukushiYoguKonyuhi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgJutakuKaishuhi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiShukei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgServiceKeikakuhiFromH2104_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.tabKyufuJissekiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会詳細のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuJisseki {

    private static final int INDEX_6 = 6;

    /**
     * 画面の初期化メソッドです。
     *
     * @param panel KyufuJissekiDiv
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiDiv> dispKyufuJisseki(KyufuJissekiDiv panel) {
        ResponseData<KyufuJissekiDiv> response = new ResponseData<>();

        KyufuJissekiKeyInfo keiInfo = createKeyInfo();
        setKyufuJissekiYoshiki(panel, keiInfo.get入力識別番号().getInputShikibetsuNoCode().value());
        jp.co.ndensan.reams.db.dbc.business.core.KyufuJisseki jisseki = get給付実績(keiInfo);

        KyufuJissekiKihon kihon = jisseki.get基本();
        panel.getTxtKyufuJissekiHihokenshaNo().setValue(kihon.get被保番号().value());
        panel.getTxtKyufuJissekiYokaigodo().setValue(kihon.get要介護度());
        panel.getTxtKyufuJissekiNinteiYukoKikan().setFromValue(toRDate(kihon.get認定有効期間().getFrom()));
        panel.getTxtKyufuJissekiNinteiYukoKikan().setToValue(toRDate(kihon.get認定有効期間().getTo()));
        panel.getTxtKyufuJissekiSeibetsu().setValue(kihon.get性別().getName().getShortJapanese());
        panel.getTxtKyufuJissekiSeinengappi().setValue(toRDate(kihon.get生年月日()));
        panel.getTxtKyufuJissekiTeikyoYM().setValue(toRDate(kihon.get提供年月().value()));
        panel.getTxtKyufuJissekiJissekiKubun().setValue(new RString(kihon.get実績区分().name()));
        panel.getTxtKyufuJissekiSeiriNo().setValue(kihon.get整理番号());
        panel.getTxtKyufuJissekiHokensha().setValue(kihon.get保険者());
        panel.getTxtKyufuJissekiShikibetsuCode().setValue(kihon.get明細書識別番号().getInputShikibetsuNoCode().value());
        panel.getTxtKyufuJissekiJigyosha().setValue(kihon.get事業者());

        panel.getTxtKyufuJissekiJuminShubetsu().setValue(new RString("転出者"));
        panel.getTxtKyufuJissekiName().setValue(new RString("電算　太郎"));

        setKyufuJissekiKihon(panel.getTabKyufuJisseki().getKyufuJissekiKihon(), kihon);
        setKyufuJissekiMeisai(panel.getTabKyufuJisseki().getKyufuJissekiMeisaiShukei(), jisseki);
        setServiceKeikakuhi(panel.getTabKyufuJisseki().getServiceKeikakuhi(), jisseki);
        setFukushiYoguKonyuhi(panel.getTabKyufuJisseki().getFukushiYoguKonyuhi(), jisseki);
        setJutakuKaishuhi(panel.getTabKyufuJisseki().getJutakuKaishuhi(), jisseki);
        setKogakuKaigoServicehi(panel.getTabKyufuJisseki().getKogakuKaigoServicehi());
        setCareManagementhi(panel.getTabKyufuJisseki().getCareManagementhi());

        panel.getBtnShakaiFukushiHojinKeigengaku().setDisabled(jisseki.get社会福祉法人軽減額リスト().isEmpty());
        panel.getBtnTokuteiNyushoshaKaigoServicehi().setDisabled(jisseki.get特定入所者リスト().isEmpty());

        response.data = panel;

        return response;
    }

    private void setKyufuJissekiYoshiki(KyufuJissekiDiv panel, RString 入力識別番号) {

        KyufuJissekiYoshikiKubun kubun = KyufuJissekiYoshiki.get様式区分(入力識別番号);
        tabKyufuJissekiDiv tab = panel.getTabKyufuJisseki();
        tab.getKyufuJissekiKihon().setVisible(kubun.is基本());
        tab.getKyufuJissekiMeisaiShukei().setVisible(kubun.is明細() || kubun.is集計());
        tab.getKyufuJissekiMeisaiShukei().getKyufuJissekiMeisai().setVisible(kubun.is明細());
        tab.getKyufuJissekiMeisaiShukei().getKyufuJissekiMeisai().setTitle(new RString(kubun.is集計() ? "明細" : ""));
        tab.getKyufuJissekiMeisaiShukei().getKyufuJissekiShukei().setVisible(kubun.is集計());
        tab.getKyufuJissekiMeisaiShukei().getKyufuJissekiShukei().setTitle(new RString(kubun.is明細() ? "集計" : ""));
        tab.getKyufuJissekiMeisaiShukei().setTitle(
                new RString((kubun.is明細() && !kubun.is集計()) ? "明細情報" : (!kubun.is明細() && kubun.is集計()) ? "集計情報" : "明細・集計情報"));
        tab.getServiceKeikakuhi().setVisible(kubun.is居宅サービス計画費());
        tab.getFukushiYoguKonyuhi().setVisible(kubun.is福祉用具販売費());
        tab.getJutakuKaishuhi().setVisible(kubun.is住宅改修費());
        tab.getKogakuKaigoServicehi().setVisible(kubun.is高額介護サービス費());
        tab.getCareManagementhi().setVisible(kubun.isケアマネジメント費());

        panel.getBtnKinkyujiShisetsuRyoyohi().setVisible(kubun.is緊急時施設療養() || kubun.is所定疾患施設療養費());
        panel.getBtnKinkyujiShisetsuRyoyohi().setDisplayNone(!kubun.is緊急時施設療養() && !kubun.is所定疾患施設療養費());
        panel.getBtnTokuteiShinryohi().setVisible(kubun.is特定診療費_特別療養費());
        panel.getBtnTokuteiShinryohi().setDisplayNone(!kubun.is特定診療費_特別療養費());
        panel.getBtnShokujiHiyo().setVisible(kubun.is食事費用());
        panel.getBtnShokujiHiyo().setDisplayNone(!kubun.is食事費用());
        panel.getBtnTokuteiNyushoshaKaigoServicehi().setVisible(kubun.is特定入所者介護サービス費用());
        panel.getBtnTokuteiNyushoshaKaigoServicehi().setDisplayNone(!kubun.is特定入所者介護サービス費用());
        panel.getBtnShakaiFukushiHojinKeigengaku().setVisible(kubun.is社会福祉法人軽減額());
        panel.getBtnShakaiFukushiHojinKeigengaku().setDisplayNone(!kubun.is社会福祉法人軽減額());
    }

    private void setKyufuJissekiKihon(KyufuJissekiKihonDiv panel, KyufuJissekiKihon kihon) {

        panel.getTxtKyufuJissekiKihonSakuseiKubun().setValue(new RString(kihon.get作成区分().name()));
        panel.getTxtKyufuJissekiKihonYokaigodo().setValue(kihon.get要介護度());
        panel.getTxtKyufuJissekiKihonNinteiYukoKikan().setFromValue(toRDate(kihon.get認定有効期間().getFrom()));
        panel.getTxtKyufuJissekiKihonNinteiYukoKikan().setToValue(toRDate(kihon.get認定有効期間().getTo()));
        panel.getTxtKyufuJissekiKihonShinsaYM().setValue(toRDate(kihon.get審査年月()));
        panel.getTxtKyufuJissekiKihonKeikokuKubun().setValue(new RString(kihon.get警告区分().name()));

        KyufuJissekiKihonHihokenshaDiv hihokenshaDiv = panel.getKyufuJissekiKihonHihokensha();
        KyufuJissekiKihonHihokensha hihokensha = kihon.get被保険者情報();
        hihokenshaDiv.getTxtKyufuJissekiKihonKyusochiNyushoshaTokurei().setValue((hihokensha.get旧措置入所者特例()));
        hihokenshaDiv.getTxtKyufuJissekiKihonRojinHokenShichosonNo().setValue(hihokensha.get老人保健受給者番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonRojinHokenJukyushaNo().setValue(hihokensha.get老人保健市町村番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonKokiKoreiHokenshaNo().setValue(hihokensha.get後期高齢保険者番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo().setValue(hihokensha.get後期高齢被保番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoHokenshaNo().setValue(hihokensha.get国保保険者番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoHihokenshashoNo().setValue(hihokensha.get被保険者証番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoKojinNo().setValue(hihokensha.get個人番号());

        KyufuJissekiKihonKyotakuServiceKeikakuDiv serviceKeikakuDiv = panel.getKyufuJissekiKihonKyotakuServiceKeikaku();
        KyufuJissekiKihonKyotakuService service = kihon.get居宅サービス計画情報();
        serviceKeikakuDiv.getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun().setValue(service.get居宅サービス計画作成区分());
        serviceKeikakuDiv.getTxtKyufuJissekiKihonJigyoshoNo().setValue(service.get事業所番号().value());
        serviceKeikakuDiv.getTxtKyufuJissekiKihonJigyoshoName().setValue(service.get事業所名());

        KyufuJissekiKihonServiceKikanDiv serviceKikanDiv = panel.getKyufuJissekiKihonServiceKikan();
        KyufuJissekiKihonServiceKikan kikan = kihon.getサービス期間情報();
        serviceKikanDiv.getTxtKyufuJissekiKihonKaishiYMD().setValue(toRDate(kikan.get開始日()));
        serviceKikanDiv.getTxtKyufuJissekiKihonChushiYMD().setValue(toRDate(kikan.get中止日()));
        serviceKikanDiv.getTxtKyufuJissekiKihonChushiRiyu().setValue(kikan.get中止理由());

        KyufuJissekiKihonShisetsuNyutaishoDiv shisetsuNyutaishoDiv = panel.getKyufuJissekiKihonShisetsuNyutaisho();
        KyufuJissekiKihonNyutaisho nyutaisho = kihon.get施設入退所情報();
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoYMD().setValue(toRDate(nyutaisho.get入所日()));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonTaishoYMD().setValue(toRDate(nyutaisho.get退所日()));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoJitsuNissu().setValue(new RString(Integer.toString(nyutaisho.get入所実日数())));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonGaihakuNissu().setValue(new RString(Integer.toString(nyutaisho.get外泊日数())));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoMaeJokyo().setValue(nyutaisho.get入所前の状況());
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoAtoJokyo().setValue(nyutaisho.get退所後の状況());

        KyufuJissekiKihonKyufuritsuDiv kyufuritsuDiv = panel.getKyufuJissekiKihonKyufuritsu();
        KyufuJissekiKihonKyufuritsu kyufuritsu = kihon.get給付率情報();
        kyufuritsuDiv.getTxtKyufuJissekiKihonHokenKyufuRitsu().setValue(new RString(kyufuritsu.get保険().value().toString()));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi1KyufuRitsu().setValue(new RString(kyufuritsu.get公費１().value().toString()));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi2KyufuRitsu().setValue(new RString(kyufuritsu.get公費２().value().toString()));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi3KyufuRitsu().setValue(new RString(kyufuritsu.get公費３().value().toString()));

        KyufuJissekiKihonKohiDiv kohiDiv = panel.getKyufuJissekiKihonKohi();
        KyufuJissekiKihonKohi kohi = kihon.get公費情報();
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo1().setValue(kohi.get公費１負担者番号());
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo2().setValue(kohi.get公費２負担者番号());
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo3().setValue(kohi.get公費３負担者番号());
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo1().setValue(kohi.get公費１受給者番号());
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo2().setValue(kohi.get公費２受給者番号());
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo3().setValue(kohi.get公費３受給者番号());
    }

    private void setKyufuJissekiMeisai(KyufuJissekiMeisaiShukeiDiv panel, jp.co.ndensan.reams.db.dbc.business.core.KyufuJisseki kyufuJisseki) {

        //DBの情報を取る。
        List<dgKyufuJissekiShukei_Row> shukeiList = new ArrayList<>();

        for (KyufuJissekiShukei iShukei : kyufuJisseki.get集計リスト()) {

            RString rsServiceShurui = iShukei.get種類();
            RString rsJitsuNissu = toRString(iShukei.get短実日数());
            RString rsKeikakuTani = toRString(iShukei.get短計画日数());
            RString rsTaishoTani = toRString(iShukei.get短実日数());
            RString rsTaishogaiTani = setCommFormat(iShukei.get対象外単位());
            RString rsTankiKeikakuNissu = toRString(iShukei.get短計画日数());
            RString rsHokenKohi = iShukei.get保険公費();
            RString rsKettei = iShukei.get決定();
            RString rsTankiJitsuNissu = toRString(iShukei.get短実日数());
            RString rsTaniGokei = setCommFormat(iShukei.get単位合計());
            RString rsTanisuTanka = toRString(iShukei.get単位数単価());
            RString rsSeikyugaku = setCommFormat(iShukei.get請求額());
            RString rsRiyoshaFutangaku = setCommFormat(iShukei.get利用者負担額());
            RString rsDekidakaTaniGokei = setCommFormat(iShukei.get単位合計());
            RString rsDekidakaSeikyugaku = toRString(iShukei.get単位数単価());
            RString rsDekidakaHonninFutangaku = setCommFormat(iShukei.get出来高本人負担額());
            RString rsSaiShinsaKaisu = toRString(iShukei.get再審査回数());
            RString rsKagoKaisu = toRString(iShukei.get過誤回数());
            RString rsShinsaYM = toWareki(iShukei.get審査年月());

            shukeiList.add(
                    createKyufuJissekiShukeiRow(rsServiceShurui, rsJitsuNissu, rsKeikakuTani, rsTaishoTani,
                            rsTaishogaiTani, rsTankiKeikakuNissu, rsHokenKohi, rsKettei, rsTankiJitsuNissu, rsTaniGokei, rsTanisuTanka,
                            rsSeikyugaku, rsRiyoshaFutangaku, rsDekidakaTaniGokei, rsDekidakaSeikyugaku, rsDekidakaHonninFutangaku,
                            rsSaiShinsaKaisu, rsKagoKaisu, rsShinsaYM));

        }

        //DBの情報を取る。
        panel.getKyufuJissekiShukei().getDgKyufuJissekiShukei().setDataSource(shukeiList);

        List<dgKyufuJissekiMeisai_Row> meisaiList = new ArrayList<>();

        for (KyufuJissekiMeisai iMeisai : kyufuJisseki.get明細リスト()) {

            RString rsService = iMeisai.getサービス();
            RString rsKettei = iMeisai.get決定();
            RString rsTani = setCommFormat(iMeisai.get単位());
            RString rsKaisu = toRString(iMeisai.get回数日数());
            RString rsKohi1Nissu = toRString(iMeisai.get公費1単位());
            RString rsKohi2Nissu = toRString(iMeisai.get公費2単位());
            RString rsKohi3Nissu = toRString(iMeisai.get公費3単位());
            RString rsServiceTani = setCommFormat(iMeisai.getサービス単位());
            RString rsKohi1Tani = toRString(iMeisai.get公費1日数());
            RString rsKohi2Tani = toRString(iMeisai.get公費2日数());
            RString rsKohi3Tani = toRString(iMeisai.get公費3日数());
            RString rsSaiShinsaKaisu = toRString(iMeisai.get再審査回数());
            RString rsKagoKaisu = toRString(iMeisai.get過誤回数());
            RString rsShinsaYM = toWareki(iMeisai.get審査年月());
            RString rsTekiyo = iMeisai.get適要();

            meisaiList.add(createKyufuJissekiMeisaiRow(
                    rsService, rsKettei, rsTani, rsKaisu, rsKohi1Nissu, rsKohi2Nissu,
                    rsKohi3Nissu, rsServiceTani, rsKohi1Tani, rsKohi2Tani, rsKohi3Tani,
                    rsSaiShinsaKaisu, rsKagoKaisu, rsShinsaYM, rsTekiyo));
        }
        panel.getKyufuJissekiMeisai().getDgKyufuJissekiMeisai().setDataSource(meisaiList);

    }

    private void setServiceKeikakuhi(ServiceKeikakuhiDiv panel, jp.co.ndensan.reams.db.dbc.business.core.KyufuJisseki kyufuJisseki) {

        //DBの情報を取る。
        List<dgServiceKeikakuhiFromH2104_Row> serviceKeikakuhiList = new ArrayList<>();

        for (KyufuJissekiKyotakuService iKyotakuService : kyufuJisseki.getサービス計画費リスト()) {

            RString rsShiteiKijunGaitoKubun = iKyotakuService.get指定基準区分();
            RString rsIraiTodokedeYMD = toWareki(iKyotakuService.get届出日());
            RString rsService = iKyotakuService.getサービス();
            RString rsTanisuTanka = toRString(iKyotakuService.get単位数単価());
            RString rsKettei = iKyotakuService.get決定();
            RString rsMeisaiGokei = iKyotakuService.get明細合計();
            RString rsTanisu = setCommFormat(iKyotakuService.get単位数());
            RString rsKaisu = toRString(iKyotakuService.get回数());
            RString rsServiceTanisu = setCommFormat(iKyotakuService.getサービス単位数());
            RString rsSeikyuKingaku = setCommFormat(iKyotakuService.get請求金額());
            RString rsTantoKaigoShienSenmoninNo = iKyotakuService.get専門員番号();
            RString rsSaishinsaKaisu = toRString(iKyotakuService.get再審査回数());
            RString rsKagoKaisu = toRString(iKyotakuService.get過誤回数());
            RString rsShinsaYM = toWareki(iKyotakuService.get審査年月());

            serviceKeikakuhiList.add(createServiceKeikakuhiFromH2104Row(
                    rsShiteiKijunGaitoKubun, rsIraiTodokedeYMD, rsService, rsTanisuTanka, rsKettei, rsMeisaiGokei,
                    rsTanisu, rsKaisu, rsServiceTanisu, rsSeikyuKingaku,
                    rsTantoKaigoShienSenmoninNo, rsSaishinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getDgServiceKeikakuhiFromH2104().setDataSource(serviceKeikakuhiList);

    }

    private void setFukushiYoguKonyuhi(FukushiYoguKonyuhiDiv panel, jp.co.ndensan.reams.db.dbc.business.core.KyufuJisseki kyufuJisseki) {

        //DBの情報を取る。
        List<dgFukushiYoguKonyuhi_Row> fukushiYoguKonyuhiList = new ArrayList<>();

        for (KyufuJissekiYoguHanbaihi iFukushiYoguKonyuh : kyufuJisseki.get祉用具購入費リスト()) {

            RString rsService = iFukushiYoguKonyuh.getサービス();
            RString rsKonyuYMD = toWareki(iFukushiYoguKonyuh.get購入日());
            RString rsShohinName = iFukushiYoguKonyuh.get商品名();
            RString rsShumoku = iFukushiYoguKonyuh.get種目();
            RString rsSeizoJigyoshaName = iFukushiYoguKonyuh.get製造事業者名();
            RString rsHanbaiJigyoshaName = iFukushiYoguKonyuh.get販売事業者名();
            RString rsKonyuKingaku = setCommFormat(iFukushiYoguKonyuh.get購入金額());
            RString rsShinsaYM = toWareki(iFukushiYoguKonyuh.get審査年月());
            RString rsTekiyo = iFukushiYoguKonyuh.get摘要();

            fukushiYoguKonyuhiList.add(createFukushiYoguKonyuhiRow(
                    rsService, rsKonyuYMD, rsShohinName, rsShumoku, rsSeizoJigyoshaName, rsHanbaiJigyoshaName,
                    rsKonyuKingaku, rsShinsaYM, rsTekiyo));
        }
        panel.getDgFukushiYoguKonyuhi().setDataSource(fukushiYoguKonyuhiList);

    }

    private void setJutakuKaishuhi(JutakuKaishuhiDiv panel, jp.co.ndensan.reams.db.dbc.business.core.KyufuJisseki kyufuJisseki) {

        //DBの情報を取る。
        List<dgJutakuKaishuhi_Row> jutakuKaishuhiList = new ArrayList<>();

        for (KyufuJissekiJutakuKaishuhi iJutakuKaishuhi : kyufuJisseki.get住宅改修費情報リスト()) {

            RString rsService = iJutakuKaishuhi.getサービス();
            RString rsChakkoYMD = toWareki(iJutakuKaishuhi.get着工日());
            RString rsJigyoshaName = iJutakuKaishuhi.get事業者名();
            RString rsJusho = iJutakuKaishuhi.get改修先住所();
            RString rsHiyo = setCommFormat(iJutakuKaishuhi.get改修費用());
            RString rsShinsaYM = toWareki(iJutakuKaishuhi.get審査年月());

            jutakuKaishuhiList.add(createJutakuKaishuhiRow(
                    rsService, rsChakkoYMD, rsJigyoshaName, rsJusho, rsHiyo, rsShinsaYM));
        }
        panel.getDgJutakuKaishuhi().setDataSource(jutakuKaishuhiList);

    }

    private void setKogakuKaigoServicehi(KogakuKaigoServicehiDiv panel) {

        //高額介護サービス費情報取得、設定
        List<HashMap> kogakuKaigoServicehi = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/KogakuKaigoServicehi.yml"));

        HashMap hashMap = kogakuKaigoServicehi.get(0);
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        panel.getTxtKogakuKaigoServicehiTeikyoYM().setValue(ymlData.getAsRString("TeikyoYM"));
        panel.getTxtKogakuKaigoServicehiJissekiKubun().setValue(ymlData.getAsRString("JissekiKubun"));
        panel.getTxtKogakuKaigoServicehiSakuseiKubun().setValue(ymlData.getAsRString("SakuseiKubun"));
        panel.getTxtKogakuKaigoServicehiSeiriNo().setValue(ymlData.getAsRString("SeiriNo"));
        panel.getTxtKogakuKaigoServicehiHokensha().setValue(ymlData.getAsRString("Hokensha"));
        panel.getTxtKogakuKaigoServicehiShikibetsuCode().setValue(ymlData.getAsRString("ShikibetsuCode"));
        panel.getTxtKogakuKaigoServicehiShikibetsuName().setValue(ymlData.getAsRString("ShikibetsuName"));
        panel.getTxtKogakuKaigoServicehiKetteiYMD().setValue(ymlData.getAsRString("KetteiYMD"));
        panel.getTxtKogakuKaigoServicehiUketsukeYMD().setValue(ymlData.getAsRString("UketsukeYMD"));
        panel.getTxtKogakuKaigoServicehiShinsaYM().setValue(ymlData.getAsRString("ShinsaYM"));
        panel.getTxtKogakuKaigoServicehiRiyoshaFutangaku().setValue(ymlData.getAsRString("RiyoshaFutangaku"));
        panel.getTxtKogakuKaigoServicehiShikyugaku().setValue(ymlData.getAsRString("Shikyugaku"));
        panel.getTxtKogakuKaigoServicehiKohi1FutanshaNo().setValue(ymlData.getAsRString("Kohi1FutanshaNo"));
        panel.getTxtKogakuKaigoServicehiKohi1Futangaku().setValue(ymlData.getAsRString("Kohi1Futangaku"));
        panel.getTxtKogakuKaigoServicehiKohi1Shikyugaku().setValue(ymlData.getAsRString("Kohi1Shikyugaku"));
        panel.getTxtKogakuKaigoServicehiKohi2FutanshaNo().setValue(ymlData.getAsRString("Kohi2FutanshaNo"));
        panel.getTxtKogakuKaigoServicehiKohi2Futangaku().setValue(ymlData.getAsRString("Kohi2Futangaku"));
        panel.getTxtKogakuKaigoServicehiKohi2Shikyugaku().setValue(ymlData.getAsRString("Kohi2Shikyugaku"));
        panel.getTxtKogakuKaigoServicehiKohi3FutanshaNo().setValue(ymlData.getAsRString("Kohi3FutanshaNo"));
        panel.getTxtKogakuKaigoServicehiKohi3Futangaku().setValue(ymlData.getAsRString("Kohi3Futangaku"));
        panel.getTxtKogakuKaigoServicehiKohi3Shikyugaku().setValue(ymlData.getAsRString("Kohi3Shikyugaku"));

    }

    private void setCareManagementhi(CareManagementhiDiv panel) {

        //ケアマネジメント費情報取得、設定
        List<HashMap> careManagementhi = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/CareManagementhi.yml"));

        HashMap hashMap = careManagementhi.get(0);
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        panel.getTxtCareManagementhiJigyoshoKubun().setValue(ymlData.getAsRString("JigyoshoKubun"));
        panel.getTxtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD().setValue(
                ymlData.getAsRString("ServiceKeikakuSakuseiIraiTodokedeYMD"));
        panel.getTxtCareManagementhiServiceShurui().setValue(ymlData.getAsRString("ServiceShurui"));
        panel.getTxtCareManagementhiServiceKomoku().setValue(ymlData.getAsRString("ServiceKomoku"));
        panel.getTxtCareManagementhiServiceCode().setValue(ymlData.getAsRString("ServiceCode"));
        panel.getTxtCareManagementhiServiceName().setValue(ymlData.getAsRString("ServiceName"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiTanka().setValue(ymlData.getAsRString("Tanka"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiTani().setValue(ymlData.getAsRString("Tani"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiKaisu().setValue(ymlData.getAsRString("Kaisu"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiServiceTani().setValue(ymlData.getAsRString("ServiceTani"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiServiceTaniGokei().setValue(ymlData.getAsRString("ServiceTaniGokei"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiSeikyuKingaku().setValue(ymlData.getAsRString("SeikyuKingaku"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiRiyoshaFutangaku().setValue(ymlData.getAsRString("RiyoshaFutangaku"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiSenmoninNo().setValue(ymlData.getAsRString("SenmoninNo"));
        panel.getTxtCareManagementhiTekiyo().setValue(ymlData.getAsRString("Tekiyo"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiSaishinsaKaisu().setValue(ymlData.getAsRString("SaishinsaKaisu"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiKagoKaisu().setValue(ymlData.getAsRString("KagoKaisu"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiShinsaYM().setValue(ymlData.getAsRString("ShinsaYM"));
    }

    private dgKyufuJissekiShukei_Row createKyufuJissekiShukeiRow(
            RString txtServiceShurui, RString txtJitsuNissu, RString txtKeikakuTani, RString txtTaishoTani,
            RString txtTaishogaiTani, RString txtTankiKeikakuNissu, RString txtHokenKohi, RString txtKettei, RString txtTankiJitsuNissu,
            RString txtTaniGokei, RString txtTaniTanka, RString txtSeikyugaku, RString txtRiyoshaFutangaku, RString txtDekidakaTaniGokei,
            RString txtDekidakaSeikyugaku, RString txtDekidakaHonninFutangaku, RString txtSaiShinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgKyufuJissekiShukei_Row(
                txtServiceShurui, txtJitsuNissu, txtKeikakuTani, txtTaishoTani,
                txtTaishogaiTani, txtTankiKeikakuNissu, txtHokenKohi, txtKettei, txtTankiJitsuNissu,
                txtTaniGokei, txtTaniTanka, txtSeikyugaku, txtRiyoshaFutangaku, txtDekidakaTaniGokei,
                txtDekidakaSeikyugaku, txtDekidakaHonninFutangaku, txtSaiShinsaKaisu, txtKagoKaisu, txtShinsaYM
        );
    }

    private dgKyufuJissekiMeisai_Row createKyufuJissekiMeisaiRow(
            RString txtService, RString txtKettei, RString txtTani, RString txtKaisu,
            RString txtKohi1Nissu, RString txtKohi2Nissu, RString txtKohi3Nissu, RString txtServiceTani, RString txtKohi1Tani,
            RString txtKohi2Tani, RString txtKohi3Tani, RString txtSaiShinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM,
            RString txtTekiyo) {
        return new dgKyufuJissekiMeisai_Row(
                txtService, txtKettei, txtTani, txtKaisu,
                txtKohi1Nissu, txtKohi2Nissu, txtKohi3Nissu, txtServiceTani, txtKohi1Tani,
                txtKohi2Tani, txtKohi3Tani, txtSaiShinsaKaisu, txtKagoKaisu, txtShinsaYM, txtTekiyo);
    }

    private dgServiceKeikakuhiFromH2104_Row createServiceKeikakuhiFromH2104Row(
            RString txtShiteiKijunGaitoKubun, RString txtIraiTodokedeYMD, RString txtService,
            RString txtTaniTanka, RString txtKettei, RString txtMeisaiGokei, RString txtTanisu, RString txtKaisu, RString txtServiceTanisu,
            RString txtSeikyuKingaku, RString txtTantoKaigoShienSenmoninNo, RString txtSaishinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgServiceKeikakuhiFromH2104_Row(
                txtShiteiKijunGaitoKubun, txtIraiTodokedeYMD, txtService,
                txtTaniTanka, txtKettei, txtMeisaiGokei, txtTanisu, txtKaisu, txtServiceTanisu,
                txtSeikyuKingaku, txtTantoKaigoShienSenmoninNo, txtSaishinsaKaisu, txtKagoKaisu, txtShinsaYM, RString.EMPTY);
    }

    private dgFukushiYoguKonyuhi_Row createFukushiYoguKonyuhiRow(
            RString txtService, RString txtKonyuYMD, RString txtShohinName, RString txtShumoku,
            RString txtSeizoJigyoshaName, RString txtHanbaiJigyoshaName, RString txtKonyuKingaku, RString txtShinsaYM, RString txtTekiyo) {
        return new dgFukushiYoguKonyuhi_Row(
                txtService, txtKonyuYMD, txtShohinName, txtShumoku,
                txtSeizoJigyoshaName, txtHanbaiJigyoshaName, txtKonyuKingaku, txtShinsaYM, txtTekiyo);
    }

    private dgJutakuKaishuhi_Row createJutakuKaishuhiRow(
            RString txtService, RString txtChakkoYMD, RString txtJigyoshaName, RString txtJusho,
            RString txtHiyo, RString txtShinsaYM) {
        return new dgJutakuKaishuhi_Row(
                txtService, txtChakkoYMD, txtJigyoshaName, txtJusho,
                txtHiyo, txtShinsaYM);
    }

    private KyufuJissekiKeyInfo createKeyInfo() {

        RString 被保番号 = (RString) ViewStateHolder.get("被保番号", RString.class);
        RString サービス提供期間開始 = (RString) ViewStateHolder.get("サービス提供期間開始", RString.class);
        RString サービス提供期間終了 = (RString) ViewStateHolder.get("サービス提供期間終了", RString.class);
        RString 入力識別番号 = (RString) ViewStateHolder.get("入力識別番号", RString.class);
        RString サービス種類 = (RString) ViewStateHolder.get("サービス種類", RString.class);
        RString サービス提供年月 = (RString) ViewStateHolder.get("サービス提供年月", RString.class);

        return new KyufuJissekiKeyInfo(
                new HihokenshaNo(被保番号),
                new Range<>(new ServiceTeikyoYM(new FlexibleYearMonth(サービス提供期間開始)), new ServiceTeikyoYM((new FlexibleYearMonth(サービス提供期間終了)))),
                new InputShikibetsuNo(new Code(入力識別番号), RString.EMPTY, RString.EMPTY),
                new ServiceShuruiCode(サービス種類),
                new ServiceTeikyoYM(new FlexibleYearMonth(サービス提供年月)));
    }

    private jp.co.ndensan.reams.db.dbc.business.core.KyufuJisseki get給付実績(KyufuJissekiKeyInfo keyInfo) {
        // TODO 未使用のメソッド引数があります。 Checkstyle 対応。
        keyInfo.getサービス提供年月();
        return null;
// TODO n8300姜　ビルドエラー回避のために暫定対応
//        KyufuJissekiFinder finder = new KyufuJissekiFinder();
//        KyufuJissekiDetailKeyInfo detailKeyInfo = finder.get給付実績詳細キー(keyInfo);
//        return detailKeyInfo != null ? finder.get給付実績(detailKeyInfo) : null;
    }

    private RString setCommFormat(Decimal data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString("##,###,###"));
    }

    private RDate toRDate(FlexibleDate data) {
        if (data == null || !data.isValid()) {
            return null;
        }
        return new RDate(data.toString());
    }

    private RDate toRDate(FlexibleYearMonth data) {
        if (data == null || !data.isValid()) {
            return null;
        }
        return new RDate(data.toString());
    }

    private RString toWareki(FlexibleDate data) {
        if (data == null || !data.isValid()) {
            return RString.EMPTY;
        }
        return data.wareki().toDateString();
    }

    private RString toWareki(FlexibleYearMonth data) {
        if (data == null || !data.isValid()) {
            return RString.EMPTY;
        }
        return data.wareki().toDateString().substring(0, INDEX_6);
    }

    private RString toRString(Decimal data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString());
    }

    private RString toRString(Integer data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return new RString(data.toString());
    }
}
