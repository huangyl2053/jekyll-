/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.CareManagementhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.FukushiYoguKonyuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.JutakuKaishuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiKihonHihokenshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiKihonKohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiKihonKyotakuServiceKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiKihonServiceKikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiKihonShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.dgKyufuJissekiMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KogakuKaigoServicehiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiKihonKyufuritsuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiMeisaiShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.ServiceKeikakuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.dgFukushiYoguKonyuhi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.dgJutakuKaishuhi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.dgKyufuJissekiShukei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.dgServiceKeikakuhiFromH2104_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.*;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.db.dbc.realservice.KyufuJissekiFinder;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiDetailKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.InputShikibetsuNo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiJutakuKaishuhi;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonHihokensha;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonKohi;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonKyufuritsu;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonNyutaisho;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihonServiceKikan;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKyotakuService;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiMeisai;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiYoguHanbaihi;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuJisseki {

    public ResponseData<KyufuJissekiDiv> dispKyufuJisseki(KyufuJissekiDiv panel) {
        ResponseData<KyufuJissekiDiv> response = new ResponseData<>();

        jp.co.ndensan.reams.db.dbc.business.KyufuJisseki jisseki = get給付実績();

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

        response.data = panel;

        return response;
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

    private RDate toRDate(FlexibleDate date) {
        if (date == null || !date.isValid()) {
            return null;
        }
        return new RDate(date.toString());
    }

    private RDate toRDate(FlexibleYearMonth date) {
        if (date == null || !date.isValid()) {
            return null;
        }
        return new RDate(date.toString());
    }

    private void setKyufuJissekiMeisai(KyufuJissekiMeisaiShukeiDiv panel, jp.co.ndensan.reams.db.dbc.business.KyufuJisseki kyufuJisseki) {

        //DBの情報を取る。
        List<dgKyufuJissekiShukei_Row> shukeiList = new ArrayList<>();

        for (KyufuJissekiShukei iShukei : kyufuJisseki.get集計リスト()) {

            RString rsServiceShurui = iShukei.get種類();
            RString rsJitsuNissu = new RString(String.valueOf(iShukei.get短実日数()));
            RString rsKeikakuTani = new RString(String.valueOf(iShukei.get短計画日数()));
            RString rsTaishoTani = new RString(String.valueOf(iShukei.get短実日数()));
            RString rsTaishogaiTani = new RString(setCommFormat(iShukei.get対象外単位().toString()));
            RString rsTankiKeikakuNissu = new RString(String.valueOf(iShukei.get短計画日数()));
            RString rsHokenKohi = iShukei.get保険公費();
            RString rsKettei = iShukei.get決定();
            RString rsTankiJitsuNissu = new RString(String.valueOf(iShukei.get短実日数()));
            RString rsTaniGokei = new RString(setCommFormat(iShukei.get単位合計().toString()));
            RString rsTanisuTanka = new RString(iShukei.get単位数単価().toString());
            RString rsSeikyugaku = new RString(setCommFormat(iShukei.get請求額().toString()));
            RString rsRiyoshaFutangaku = new RString(setCommFormat(iShukei.get利用者負担額().toString()));
            RString rsDekidakaTaniGokei = new RString(setCommFormat(iShukei.get単位合計().toString()));
            RString rsDekidakaSeikyugaku = new RString(iShukei.get単位数単価().toString());
            RString rsDekidakaHonninFutangaku = new RString(setCommFormat(iShukei.get出来高本人負担額().toString()));
            RString rsSaiShinsaKaisu = new RString(String.valueOf(iShukei.get再審査回数()));
            RString rsKagoKaisu = new RString(String.valueOf(iShukei.get過誤回数()));
            RString rsShinsaYM = new RString(String.valueOf(setWareki(iShukei.get審査年月().toDateString()).substring(0, 6)));

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
            RString rsTani = new RString(setCommFormat(iMeisai.get単位().toString()));
            RString rsKaisu = new RString(String.valueOf(iMeisai.get回数日数()));
            RString rsKohi1Nissu = new RString(setCommFormat(String.valueOf(iMeisai.get公費1単位())));
            RString rsKohi2Nissu = new RString(setCommFormat(String.valueOf(iMeisai.get公費2単位())));
            RString rsKohi3Nissu = new RString(setCommFormat(String.valueOf(iMeisai.get公費3単位())));
            RString rsServiceTani = new RString(setCommFormat(iMeisai.getサービス単位().toString()));
            RString rsKohi1Tani = new RString(String.valueOf(iMeisai.get公費1日数()));
            RString rsKohi2Tani = new RString(String.valueOf(iMeisai.get公費2日数()));
            RString rsKohi3Tani = new RString(String.valueOf(iMeisai.get公費3日数()));
            RString rsSaiShinsaKaisu = new RString(String.valueOf(iMeisai.get再審査回数()));
            RString rsKagoKaisu = new RString(String.valueOf(iMeisai.get過誤回数()));
            RString rsShinsaYM = setWareki(iMeisai.get審査年月().toDateString()).substring(0, 6);
            RString rsTekiyo = iMeisai.get適要();

            meisaiList.add(createKyufuJissekiMeisaiRow(
                    rsService, rsKettei, rsTani, rsKaisu, rsKohi1Nissu, rsKohi2Nissu,
                    rsKohi3Nissu, rsServiceTani, rsKohi1Tani, rsKohi2Tani, rsKohi3Tani,
                    rsSaiShinsaKaisu, rsKagoKaisu, rsShinsaYM, rsTekiyo));
        }
        panel.getKyufuJissekiMeisai().getDgKyufuJissekiMeisai().setDataSource(meisaiList);

    }

    private void setServiceKeikakuhi(ServiceKeikakuhiDiv panel, jp.co.ndensan.reams.db.dbc.business.KyufuJisseki kyufuJisseki) {

        //DBの情報を取る。
        List<dgServiceKeikakuhiFromH2104_Row> serviceKeikakuhiList = new ArrayList<>();

        for (KyufuJissekiKyotakuService iKyotakuService : kyufuJisseki.getサービス計画費リスト()) {

            RString rsShiteiKijunGaitoJigyoshoKubun = iKyotakuService.get指定基準区分();
            RString rsIraiTodokedeYMD = setWareki(toRDate(iKyotakuService.get届出日()).toDateString());
            RString rsService = iKyotakuService.getサービス();
            RString rsTanisuTanka = new RString(setCommFormat(String.valueOf(iKyotakuService.get単位数単価())));
            RString rsKettei = iKyotakuService.get決定();
            RString rsMeisaiGokei = iKyotakuService.get明細合計();
            RString rsTanisu = new RString(setCommFormat(String.valueOf(iKyotakuService.get単位数())));
            RString rsKaisu = new RString(String.valueOf(iKyotakuService.get回数()));
            RString rsServiceTanisu = new RString(String.valueOf(iKyotakuService.getサービス単位数()));
            RString rsSeikyuKingaku = new RString(String.valueOf(iKyotakuService.getサービス単位数()));
            RString rsTantoKaigoShienSenmoninNo = new RString(String.valueOf(iKyotakuService.get過誤回数()));
            RString rsSaishinsaKaisu = new RString(String.valueOf(iKyotakuService.get再審査回数()));
            RString rsKagoKaisu = new RString(String.valueOf(iKyotakuService.get過誤回数()));
            RString rsShinsaYM = setWareki(iKyotakuService.get審査年月().toDateString()).substring(0, 6);

            serviceKeikakuhiList.add(createServiceKeikakuhiFromH2104Row(
                    rsShiteiKijunGaitoJigyoshoKubun, rsIraiTodokedeYMD, rsService, rsTanisuTanka, rsKettei, rsMeisaiGokei,
                    rsTanisu, rsKaisu, rsServiceTanisu, rsSeikyuKingaku,
                    rsTantoKaigoShienSenmoninNo, rsSaishinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getDgServiceKeikakuhiFromH2104().setDataSource(serviceKeikakuhiList);

    }

    private void setFukushiYoguKonyuhi(FukushiYoguKonyuhiDiv panel, jp.co.ndensan.reams.db.dbc.business.KyufuJisseki kyufuJisseki) {

        //DBの情報を取る。
        List<dgFukushiYoguKonyuhi_Row> fukushiYoguKonyuhiList = new ArrayList<>();

        for (KyufuJissekiYoguHanbaihi iFukushiYoguKonyuh : kyufuJisseki.get祉用具購入費リスト()) {

            RString rsService = iFukushiYoguKonyuh.getサービス();
            RString rsKonyuYMD = setWareki(toRDate(iFukushiYoguKonyuh.get購入日()).toDateString());
            RString rsShohinName = iFukushiYoguKonyuh.get商品名();
            RString rsShumoku = iFukushiYoguKonyuh.get種目();
            RString rsSeizoJigyoshaName = iFukushiYoguKonyuh.get製造事業者名();
            RString rsHanbaiJigyoshaName = iFukushiYoguKonyuh.get販売事業者名();
            RString rsKonyuKingaku = new RString(setCommFormat(String.valueOf(iFukushiYoguKonyuh.get購入金額())));
            RString rsShinsaYM = setWareki(iFukushiYoguKonyuh.get審査年月().toDateString()).substring(0, 6);
            RString rsTekiyo = iFukushiYoguKonyuh.get摘要();

            fukushiYoguKonyuhiList.add(createFukushiYoguKonyuhiRow(
                    rsService, rsKonyuYMD, rsShohinName, rsShumoku, rsSeizoJigyoshaName, rsHanbaiJigyoshaName,
                    rsKonyuKingaku, rsShinsaYM, rsTekiyo));
        }
        panel.getDgFukushiYoguKonyuhi().setDataSource(fukushiYoguKonyuhiList);

    }

    private void setJutakuKaishuhi(JutakuKaishuhiDiv panel, jp.co.ndensan.reams.db.dbc.business.KyufuJisseki kyufuJisseki) {

        //DBの情報を取る。
        List<dgJutakuKaishuhi_Row> jutakuKaishuhiList = new ArrayList<>();

        for (KyufuJissekiJutakuKaishuhi iJutakuKaishuhi : kyufuJisseki.get住宅改修費情報リスト()) {

            RString rsService = iJutakuKaishuhi.getサービス();
            RString rsChakkoYMD = setWareki(toRDate(iJutakuKaishuhi.get着工日()).toDateString());
            RString rsJigyoshaName = iJutakuKaishuhi.get事業者名();
            RString rsJusho = iJutakuKaishuhi.get改修先住所();
            RString rsHiyo = new RString(setCommFormat(String.valueOf(iJutakuKaishuhi.get改修費用())));
            RString rsShinsaYM = setWareki(iJutakuKaishuhi.get審査年月().toDateString()).substring(0, 6);

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
            RString txtShiteiKijunGaitoJigyoshoKubun, RString txtIraiTodokedeYMD, RString txtService,
            RString txtTaniTanka, RString txtKettei, RString txtMeisaiGokei, RString txtTanisu, RString txtKaisu, RString txtServiceTanisu,
            RString txtSeikyuKingaku, RString txtTantoKaigoShienSenmoninNo, RString txtSaishinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgServiceKeikakuhiFromH2104_Row(
                txtShiteiKijunGaitoJigyoshoKubun, txtIraiTodokedeYMD, txtService,
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

    private jp.co.ndensan.reams.db.dbc.business.KyufuJisseki get給付実績() {

        RString 被保番号 = (RString) ViewStateHolder.get("被保番号", RString.class);
        RString サービス提供期間開始 = (RString) ViewStateHolder.get("サービス提供期間開始", RString.class);
        RString サービス提供期間終了 = (RString) ViewStateHolder.get("サービス提供期間終了", RString.class);
        RString 入力識別番号 = (RString) ViewStateHolder.get("入力識別番号", RString.class);
        RString サービス種類 = (RString) ViewStateHolder.get("サービス種類", RString.class);
        RString サービス提供年月 = (RString) ViewStateHolder.get("サービス提供年月", RString.class);

        KyufuJissekiKeyInfo keyInfo = new KyufuJissekiKeyInfo(
                new KaigoHihokenshaNo(被保番号),
                new Range<>(new ServiceTeikyoYM(new FlexibleYearMonth(サービス提供期間開始)), new ServiceTeikyoYM((new FlexibleYearMonth(サービス提供期間終了)))),
                new InputShikibetsuNo(new Code(入力識別番号), RString.EMPTY, RString.EMPTY),
                new ServiceShuruiCode(サービス種類),
                new ServiceTeikyoYM(new FlexibleYearMonth(サービス提供年月)));

        KyufuJissekiFinder finder = new KyufuJissekiFinder();
        KyufuJissekiDetailKeyInfo detailKeyInfo = finder.get給付実績詳細キー(keyInfo);
        return detailKeyInfo != null ? finder.get給付実績(detailKeyInfo) : null;
    }

    private String setCommFormat(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return new Decimal(str).toString("##,###,###");
    }

    private RString setWareki(RString wareki) {
        FlexibleDate warekiYmd = new FlexibleDate(wareki);
        return warekiYmd.wareki().toDateString();
    }
}
