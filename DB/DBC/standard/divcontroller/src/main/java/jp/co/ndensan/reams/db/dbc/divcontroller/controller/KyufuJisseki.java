/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.db.dbc.realservice.KyufuJissekiFinder;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiDetailKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.InputShikibetsuNo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiMeisai;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShukei;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiShukeiCollection;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.db.dbc.business.ServiceTeikyoYMListOfServiceShurui;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJisseki {

    private KyufuJissekiKihon 基本情報 = null;
    private KyufuJissekiDetailKeyInfo 詳細キー情報 = null;
    private jp.co.ndensan.reams.db.dbc.business.KyufuJisseki kyufuJisseki = null;

    public ResponseData<KyufuJissekiDiv> dispKyufuJisseki(KyufuJissekiDiv panel) {
        ResponseData<KyufuJissekiDiv> response = new ResponseData<>();

        List<HashMap> kyufuJisseki = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/KyufuJisseki.yml"));

        //ヘッダー情報取得、設定
        HashMap hashMap = kyufuJisseki.get(0);
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        panel.getTxtKyufuJissekiHihokenshaNo().setValue(ymlData.getAsRString("HihokenshaNo"));
        panel.getTxtKyufuJissekiJuminShubetsu().setValue(ymlData.getAsRString("JuminShubetsu"));
        panel.getTxtKyufuJissekiYokaigodo().setValue(ymlData.getAsRString("Yokaigodo"));
        panel.getTxtKyufuJissekiNinteiYukoKikan().setFromValue(ymlData.getAsRDate("NinteiYukoKikanFrom"));
        panel.getTxtKyufuJissekiNinteiYukoKikan().setToValue(ymlData.getAsRDate("NinteiYukoKikanTo"));
        panel.getTxtKyufuJissekiName().setValue(ymlData.getAsRString("Name"));
        panel.getTxtKyufuJissekiSeibetsu().setValue(ymlData.getAsRString("Seibetsu"));
        panel.getTxtKyufuJissekiSeinengappi().setValue(ymlData.getAsRString("Seinengappi"));
        panel.getTxtKyufuJissekiTeikyoYM().setValue(ymlData.getAsRString("TeikyoYM"));
        panel.getTxtKyufuJissekiJissekiKubun().setValue(ymlData.getAsRString("JissekiKubun"));
        panel.getTxtKyufuJissekiSeiriNo().setValue(ymlData.getAsRString("SeiriNo"));
        panel.getTxtKyufuJissekiHokensha().setValue(ymlData.getAsRString("Hokensha"));
        panel.getTxtKyufuJissekiShikibetsuCode().setValue(ymlData.getAsRString("ShikibetsuCode"));
//        panel.getTxtKyufuJissekiShikibetsuName().setValue(ymlData.getAsRString("ShikibetsuName"));
        panel.getTxtKyufuJissekiJigyosha().setValue(ymlData.getAsRString("Jigyosha"));

        panel.getTxtKyufuJissekiHihokenshaNo().setValue(new RString("0000314323"));
        panel.getTxtKyufuJissekiJuminShubetsu().setValue(new RString("転出者"));
        panel.getTxtKyufuJissekiYokaigodo().setValue(new RString("要介護１"));
        panel.getTxtKyufuJissekiNinteiYukoKikan().setFromValue(new RDate("20140101"));
        panel.getTxtKyufuJissekiNinteiYukoKikan().setToValue(new RDate("20140202"));
        panel.getTxtKyufuJissekiName().setValue(new RString("電算　太郎"));
        panel.getTxtKyufuJissekiSeibetsu().setValue(new RString("男"));
        panel.getTxtKyufuJissekiSeinengappi().setValue(new RString("昭03.03.03"));
        panel.getTxtKyufuJissekiTeikyoYM().setValue(new RString("平26.01"));
        panel.getTxtKyufuJissekiJissekiKubun().setValue(new RString("償還"));
        panel.getTxtKyufuJissekiSeiriNo().setValue(new RString("0000000001"));
        panel.getTxtKyufuJissekiHokensha().setValue(new RString("保険　次郎"));
        panel.getTxtKyufuJissekiShikibetsuCode().setValue(new RString("0001"));
//        panel.getTxtKyufuJissekiShikibetsuName().setValue(new RString("サービス提供証明書（訪問通所他）"));
//        List<KeyValueDataSource> list = new ArrayList<>();
//        list.add(new KeyValueDataSource(new RString("key0"), new RString("1114301032:雛菊サービス機関")));
//        list.add(new KeyValueDataSource(new RString("key1"), new RString("2070500448:アネモネ福祉ランド")));
//        panel.getDdlKyufuJissekiJigyosha().setDataSource(list);
//        panel.getBtnTokuteiShinryohi().setWrap(true);
//        panel.getBtnShokujiHiyo().setWrap(true);
//        panel.getBtnTokuteiNyushoshaKaigoServicehi().setWrap(true);
//        panel.getBtnShakaiFukushiHojinKeigengaku().setWrap(true);

        jp.co.ndensan.reams.db.dbc.business.KyufuJisseki parmKyufuJisseki = get給付実績();

        setKyufuJissekiKihon(panel.getTabKyufuJisseki().getKyufuJissekiKihon(), parmKyufuJisseki);
        setKyufuJissekiMeisai(panel.getTabKyufuJisseki().getKyufuJissekiMeisaiShukei(), parmKyufuJisseki);
        setServiceKeikakuhi(panel.getTabKyufuJisseki().getServiceKeikakuhi());
        setFukushiYoguKonyuhi(panel.getTabKyufuJisseki().getFukushiYoguKonyuhi());
        setJutakuKaishuhi(panel.getTabKyufuJisseki().getJutakuKaishuhi());
        setKogakuKaigoServicehi(panel.getTabKyufuJisseki().getKogakuKaigoServicehi());
        setCareManagementhi(panel.getTabKyufuJisseki().getCareManagementhi());
        response.data = panel;
        return response;
    }

    private void setKyufuJissekiKihon(KyufuJissekiKihonDiv panel, jp.co.ndensan.reams.db.dbc.business.KyufuJisseki kyufuJisseki) {

        //ヘッダー情報取得、設定
        panel.getTxtKyufuJissekiKihonSakuseiKubun().setValue(kyufuJisseki.get基本().get作成区分().getCode());
        panel.getTxtKyufuJissekiKihonYokaigodo().setValue(kyufuJisseki.get基本().get要介護度());
        panel.getTxtKyufuJissekiKihonNinteiYukoKikan().setFromValue(new RDate(kyufuJisseki.get基本().get認定有効期間().getFrom().toString()));
        panel.getTxtKyufuJissekiKihonNinteiYukoKikan().setFromValue(new RDate(kyufuJisseki.get基本().get認定有効期間().getTo().toString()));
        panel.getTxtKyufuJissekiKihonShinsaYM().setValue(kyufuJisseki.get基本().get審査年月().toDateString());
        panel.getTxtKyufuJissekiKihonKeikokuKubun().setValue(kyufuJisseki.get基本().get警告区分().getCode());

        KyufuJissekiKihonHihokenshaDiv hihokenshaDiv = panel.getKyufuJissekiKihonHihokensha();
        hihokenshaDiv.getTxtKyufuJissekiKihonKyusochiNyushoshaTokurei().setValue((kyufuJisseki.get基本().get被保険者情報().get旧措置入所者特例()));
        hihokenshaDiv.getTxtKyufuJissekiKihonRojinHokenShichosonNo().setValue(kyufuJisseki.get基本().get被保険者情報().get老人保健受給者番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonRojinHokenJukyushaNo().setValue(kyufuJisseki.get基本().get被保険者情報().get老人保健市町村番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonKokiKoreiHokenshaNo().setValue(kyufuJisseki.get基本().get被保険者情報().get後期高齢保険者番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo().setValue(kyufuJisseki.get基本().get被保険者情報().get後期高齢被保番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoHokenshaNo().setValue(kyufuJisseki.get基本().get被保険者情報().get国保保険者番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoHihokenshashoNo().setValue(kyufuJisseki.get基本().get被保険者情報().get被保険者証番号());
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoKojinNo().setValue(kyufuJisseki.get基本().get被保険者情報().get個人番号());

        KyufuJissekiKihonKyotakuServiceKeikakuDiv serviceKeikakuDiv = panel.getKyufuJissekiKihonKyotakuServiceKeikaku();
        serviceKeikakuDiv.getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun().setValue(
                kyufuJisseki.get基本().get居宅サービス計画情報().get居宅サービス計画作成区分());
        serviceKeikakuDiv.getTxtKyufuJissekiKihonJigyoshoNo().setValue(kyufuJisseki.get基本().get居宅サービス計画情報().get事業所番号().value());
        serviceKeikakuDiv.getTxtKyufuJissekiKihonJigyoshoName().setValue(kyufuJisseki.get基本().get居宅サービス計画情報().get事業所名());

        KyufuJissekiKihonServiceKikanDiv serviceKikanDiv = panel.getKyufuJissekiKihonServiceKikan();
        serviceKikanDiv.getTxtKyufuJissekiKihonKaishiYMD().setValue(new RString(kyufuJisseki.get基本().getサービス期間情報().get開始日().toString()));
        serviceKikanDiv.getTxtKyufuJissekiKihonChushiYMD().setValue(new RString(kyufuJisseki.get基本().getサービス期間情報().get中止日().toString()));
        serviceKikanDiv.getTxtKyufuJissekiKihonChushiRiyu().setValue(kyufuJisseki.get基本().getサービス期間情報().get中止理由());

        KyufuJissekiKihonShisetsuNyutaishoDiv shisetsuNyutaishoDiv = panel.getKyufuJissekiKihonShisetsuNyutaisho();
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoYMD().setValue(new RString(kyufuJisseki.get基本().get施設入退所情報().get入所日().toString()));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonTaishoYMD().setValue(new RString(kyufuJisseki.get基本().get施設入退所情報().get退所日().toString()));
//        String nyushoJitsuNissu = kyufuJisseki.get基本().get施設入退所情報().get入所実日数();
//        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoJitsuNissu().setValue(new RString(nyushoJitsuNissu));
//        String gaihakuNissu = kyufuJisseki.get基本().get施設入退所情報().get外泊日数();
//        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonGaihakuNissu().setValue(new RString(gaihakuNissu));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoMaeJokyo().setValue(kyufuJisseki.get基本().get施設入退所情報().get入所前の状況());
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoAtoJokyo().setValue(kyufuJisseki.get基本().get施設入退所情報().get退所後の状況());

        KyufuJissekiKihonKyufuritsuDiv kyufuritsuDiv = panel.getKyufuJissekiKihonKyufuritsu();
        kyufuritsuDiv.getTxtKyufuJissekiKihonHokenKyufuRitsu().setValue(new RString(kyufuJisseki.get基本().get給付率情報().get保険().value().toString()));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi1KyufuRitsu().setValue(new RString(kyufuJisseki.get基本().get給付率情報().get公費１().value().toString()));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi2KyufuRitsu().setValue(new RString(kyufuJisseki.get基本().get給付率情報().get公費２().value().toString()));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi3KyufuRitsu().setValue(new RString(kyufuJisseki.get基本().get給付率情報().get公費３().value().toString()));

        KyufuJissekiKihonKohiDiv kohiDiv = panel.getKyufuJissekiKihonKohi();
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo1().setValue(kyufuJisseki.get基本().get公費情報().get公費１負担者番号());
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo2().setValue(kyufuJisseki.get基本().get公費情報().get公費２負担者番号());
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo3().setValue(kyufuJisseki.get基本().get公費情報().get公費３負担者番号());
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo1().setValue(kyufuJisseki.get基本().get公費情報().get公費１受給者番号());
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo2().setValue(kyufuJisseki.get基本().get公費情報().get公費２受給者番号());
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo3().setValue(kyufuJisseki.get基本().get公費情報().get公費３受給者番号());

    }

    private void setKyufuJissekiMeisai(KyufuJissekiMeisaiShukeiDiv panel, jp.co.ndensan.reams.db.dbc.business.KyufuJisseki kyufuJisseki) {

        ///DBの情報を取る。
        List<dgKyufuJissekiShukei_Row> shukeiList = new ArrayList<>();

        //給付実績集計データ取得、設定　集計
        KyufuJissekiShukei iShukei = null;

        for (Iterator<KyufuJissekiShukei> i = kyufuJisseki.get集計リスト().iterator(); i.hasNext();) {

            iShukei = i.next();

            RString rsServiceShurui = iShukei.get種類();
            RString rsJitsuNissu = new RString(String.valueOf(iShukei.get短実日数()));
            RString rsKeikakuTani = new RString(String.valueOf(iShukei.get短計画日数()));
            RString rsTaishoTani = new RString(String.valueOf(iShukei.get短実日数()));
            RString rsTaishogaiTani = new RString(iShukei.get対象外単位().toString());
            RString rsTankiKeikakuNissu = new RString(String.valueOf(iShukei.get短計画日数()));
            RString rsHokenKohi = iShukei.get保険公費();
            RString rsKettei = iShukei.get決定();
            RString rsTankiJitsuNissu = new RString(String.valueOf(iShukei.get短実日数()));
            RString rsTaniGokei = new RString(iShukei.get単位合計().toString());
            RString rsTanisuTanka = new RString(iShukei.get単位数単価().toString());
            RString rsSeikyugaku = new RString(iShukei.get請求額().toString());
            RString rsRiyoshaFutangaku = new RString(iShukei.get利用者負担額().toString());
            RString rsDekidakaTaniGokei = new RString(iShukei.get単位合計().toString());
            RString rsDekidakaSeikyugaku = new RString(iShukei.get単位数単価().toString());
            RString rsDekidakaHonninFutangaku = new RString(iShukei.get出来高本人負担額().toString());
            RString rsSaiShinsaKaisu = new RString(String.valueOf(iShukei.get再審査回数()));
            RString rsKagoKaisu = new RString(String.valueOf(iShukei.get過誤回数()));
            RString rsShinsaYM = new RString(String.valueOf(iShukei.get審査年月().toDateString()));

            shukeiList.add(
                    createKyufuJissekiShukeiRow(rsServiceShurui, rsJitsuNissu, rsKeikakuTani, rsTaishoTani,
                            rsTaishogaiTani, rsTankiKeikakuNissu, rsHokenKohi, rsKettei, rsTankiJitsuNissu, rsTaniGokei, rsTanisuTanka,
                            rsSeikyugaku, rsRiyoshaFutangaku, rsDekidakaTaniGokei, rsDekidakaSeikyugaku, rsDekidakaHonninFutangaku,
                            rsSaiShinsaKaisu, rsKagoKaisu, rsShinsaYM));

        }

        ///DBの情報を取る。
        panel.getKyufuJissekiShukei().getDgKyufuJissekiShukei().setDataSource(shukeiList);

        List<dgKyufuJissekiMeisai_Row> meisaiList = new ArrayList<>();

        //給付実績明細データ取得、設定 明細
        KyufuJissekiMeisai iMeisai = null;

        for (Iterator<KyufuJissekiMeisai> i = kyufuJisseki.get明細リスト().iterator(); i.hasNext();) {

            iMeisai = i.next();

            RString rsService = iMeisai.getサービス();
            RString rsKettei = iMeisai.get決定();
            RString rsTani = new RString(iMeisai.get単位().toString());
            RString rsKaisu = new RString(String.valueOf(iMeisai.get回数日数()));
            RString rsKohi1Nissu = new RString(String.valueOf(iMeisai.get公費1単位()));
            RString rsKohi2Nissu = new RString(String.valueOf(iMeisai.get公費2単位()));
            RString rsKohi3Nissu = new RString(String.valueOf(iMeisai.get公費3単位()));
            RString rsServiceTani = new RString(iMeisai.getサービス単位().toString());
            RString rsKohi1Tani = new RString(String.valueOf(iMeisai.get公費1日数()));
            RString rsKohi2Tani = new RString(String.valueOf(iMeisai.get公費2日数()));
            RString rsKohi3Tani = new RString(String.valueOf(iMeisai.get公費3日数()));
            RString rsSaiShinsaKaisu = new RString(String.valueOf(iMeisai.get再審査回数()));
            RString rsKagoKaisu = new RString(String.valueOf(iMeisai.get過誤回数()));
            RString rsShinsaYM = iMeisai.get審査年月().toDateString();

            meisaiList.add(createKyufuJissekiMeisaiRow(
                    rsService, rsKettei, rsTani, rsKaisu, rsKohi1Nissu, rsKohi2Nissu,
                    rsKohi3Nissu, rsServiceTani, rsKohi1Tani, rsKohi2Tani, rsKohi3Tani,
                    rsSaiShinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getKyufuJissekiMeisai().getDgKyufuJissekiMeisai().setDataSource(meisaiList);

    }

    private void setServiceKeikakuhi(ServiceKeikakuhiDiv panel) {

        //サービス計画費データ取得、設定
        List<HashMap> serviceKeikakuhi = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/ServiceKeikakuhi.yml"));

        List<dgServiceKeikakuhiFromH2104_Row> serviceKeikakuhiList = new ArrayList<>();
        for (int i = 0; i < serviceKeikakuhi.size(); i++) {
            HashMap hashMap = serviceKeikakuhi.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsShiteiKijunGaitoJigyoshoKubun = ymlData.getAsRString("txtShiteiKijunGaitoJigyoshoKubun");
            RString rsIraiTodokedeYMD = ymlData.getAsRString("txtIraiTodokedeYMD");
            RString rsService = ymlData.getAsRString("txtService");
            RString rsTanisuTanka = ymlData.getAsRString("txtTanisuTanka");
            RString rsKettei = ymlData.getAsRString("txtKettei");
            RString rsMeisaiGokei = ymlData.getAsRString("txtMeisaiGokei");
            RString rsTanisu = ymlData.getAsRString("txtTanisu");
            RString rsKaisu = ymlData.getAsRString("txtKaisu");
            RString rsServiceTanisu = ymlData.getAsRString("txtServiceTanisu");
            RString rsSeikyuKingaku = ymlData.getAsRString("txtSeikyuKingaku");
            RString rsTantoKaigoShienSenmoninNo = ymlData.getAsRString("txtTantoKaigoShienSenmoninNo");
            RString rsSaishinsaKaisu = ymlData.getAsRString("txtSaishinsaKaisu");
            RString rsKagoKaisu = ymlData.getAsRString("txtKagoKaisu");
            RString rsShinsaYM = ymlData.getAsRString("txtShinsaYM");

            serviceKeikakuhiList.add(createServiceKeikakuhiFromH2104Row(
                    rsShiteiKijunGaitoJigyoshoKubun, rsIraiTodokedeYMD, rsService, rsTanisuTanka, rsKettei, rsMeisaiGokei,
                    rsTanisu, rsKaisu, rsServiceTanisu, rsSeikyuKingaku,
                    rsTantoKaigoShienSenmoninNo, rsSaishinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getDgServiceKeikakuhiFromH2104().setDataSource(serviceKeikakuhiList);

//        List<dgServiceKeikakuhiFromH2104_Row> list = new ArrayList<>();
//        list.add(createServiceKeikakuhiFromH2104Row("指定事業所", "平21.03.02", "432111:居宅支援I１", "10.00", "", "明細", "1,000", "10", "10,000", "", "20050594", "0", "0", "平26.02"));
//        list.add(createServiceKeikakuhiFromH2104Row("", "", "", "", "", "合計", "", "", "10,000", "100,000", "", "", "", ""));
//        list.add(createServiceKeikakuhiFromH2104Row("指定事業所", "平21.03.02", "432111:居宅支援I１", "10.00", "後", "明細", "1,000", "10", "10,000", "", "20050594", "0", "0", "平26.02"));
//        list.add(createServiceKeikakuhiFromH2104Row("", "", "", "", "後", "合計", "", "", "10,000", "100,000", "", "", "", ""));
//        panel.getDgServiceKeikakuhiFromH2104().setDataSource(list);
    }

    private void setFukushiYoguKonyuhi(FukushiYoguKonyuhiDiv panel) {

        //福祉用具購入費データ取得、設定
        List<HashMap> fukushiYoguKonyuhi = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/FukushiYoguKonyuhi.yml"));

        List<dgFukushiYoguKonyuhi_Row> fukushiYoguKonyuhiList = new ArrayList<>();
        for (int i = 0; i < fukushiYoguKonyuhi.size(); i++) {
            HashMap hashMap = fukushiYoguKonyuhi.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsService = ymlData.getAsRString("txtService");
            RString rsKonyuYMD = ymlData.getAsRString("txtKonyuYMD");
            RString rsShohinName = ymlData.getAsRString("txtShohinName");
            RString rsShumoku = ymlData.getAsRString("txtShumoku");
            RString rsSeizoJigyoshaName = ymlData.getAsRString("txtSeizoJigyoshaName");
            RString rsHanbaiJigyoshaName = ymlData.getAsRString("txtHanbaiJigyoshaName");
            RString rsKonyuKingaku = ymlData.getAsRString("txtKonyuKingaku");
            RString rsShinsaYM = ymlData.getAsRString("txtShinsaYM");

            fukushiYoguKonyuhiList.add(createFukushiYoguKonyuhiRow(
                    rsService, rsKonyuYMD, rsShohinName, rsShumoku, rsSeizoJigyoshaName, rsHanbaiJigyoshaName,
                    rsKonyuKingaku, rsShinsaYM));
        }
        panel.getDgFukushiYoguKonyuhi().setDataSource(fukushiYoguKonyuhiList);

//        List<dgFukushiYoguKonyuhi_Row> list = new ArrayList<>();
//        list.add(createFukushiYoguKonyuhiRow("410000:特定福祉用具販売", "平18.10.13", "浴槽補助椅子", "03:特殊寝台", "ＤＥＮＳＡＮ（株）", "ＤＥＮＳＡＮ（株）", "12,500", "平18.12"));
//        panel.getDgFukushiYoguKonyuhi().setDataSource(list);
    }

    private void setJutakuKaishuhi(JutakuKaishuhiDiv panel) {

        //住宅改修費データ取得、設定
        List<HashMap> jutakuKaishuhi = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/JutakuKaishuhi.yml"));

        List<dgJutakuKaishuhi_Row> jutakuKaishuhiList = new ArrayList<>();
        for (int i = 0; i < jutakuKaishuhi.size(); i++) {
            HashMap hashMap = jutakuKaishuhi.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsService = ymlData.getAsRString("txtService");
            RString rsChakkoYMD = ymlData.getAsRString("txtChakkoYMD");
            RString rsJigyoshaName = ymlData.getAsRString("txtJigyoshaName");
            RString rsJusho = ymlData.getAsRString("txtJusho");
            RString rsHiyo = ymlData.getAsRString("txtHiyo");
            RString rsShinsaYM = ymlData.getAsRString("txtShinsaYM");

            jutakuKaishuhiList.add(createJutakuKaishuhiRow(
                    rsService, rsChakkoYMD, rsJigyoshaName, rsJusho, rsHiyo, rsShinsaYM));
        }
        panel.getDgJutakuKaishuhi().setDataSource(jutakuKaishuhiList);

//        List<dgJutakuKaishuhi_Row> list = new ArrayList<>();
//        list.add(createJutakuKaishuhiRow("420000:住宅改修", "平14.10.01", "銀杏組", "電算町紫原７２丁目", "56,000", "平18.05"));
//        panel.getDgJutakuKaishuhi().setDataSource(list);
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

//        panel.getTxtKogakuKaigoServicehiTeikyoYM().setValue(new RString("平26.01"));
//        panel.getTxtKogakuKaigoServicehiJissekiKubun().setValue(new RString("償還"));
//        panel.getTxtKogakuKaigoServicehiSakuseiKubun().setValue(new RString("新規"));
//        panel.getTxtKogakuKaigoServicehiSeiriNo().setValue(new RString("0000000001"));
//        panel.getTxtKogakuKaigoServicehiHokensha().setValue(new RString("保険　次郎"));
//        panel.getTxtKogakuKaigoServicehiShikibetsuCode().setValue(new RString("0001"));
//        panel.getTxtKogakuKaigoServicehiShikibetsuName().setValue(new RString("サービス提供証明書（訪問通所他）"));
//        panel.getTxtKogakuKaigoServicehiKetteiYMD().setValue(new RString("平26.01.01"));
//        panel.getTxtKogakuKaigoServicehiUketsukeYMD().setValue(new RString("平26.02.02"));
//        panel.getTxtKogakuKaigoServicehiShinsaYM().setValue(new RString("平26.03"));
//        panel.getTxtKogakuKaigoServicehiRiyoshaFutangaku().setValue(new RString("1,111"));
//        panel.getTxtKogakuKaigoServicehiShikyugaku().setValue(new RString("2,222"));
//        panel.getTxtKogakuKaigoServicehiKohi1FutanshaNo().setValue(new RString("0000000001"));
//        panel.getTxtKogakuKaigoServicehiKohi1Futangaku().setValue(new RString("3,333"));
//        panel.getTxtKogakuKaigoServicehiKohi1Shikyugaku().setValue(new RString("3,333"));
//        panel.getTxtKogakuKaigoServicehiKohi2FutanshaNo().setValue(new RString("0000000002"));
//        panel.getTxtKogakuKaigoServicehiKohi2Futangaku().setValue(new RString("4,444"));
//        panel.getTxtKogakuKaigoServicehiKohi2Shikyugaku().setValue(new RString("4,444"));
//        panel.getTxtKogakuKaigoServicehiKohi3FutanshaNo().setValue(new RString("0000000003"));
//        panel.getTxtKogakuKaigoServicehiKohi3Futangaku().setValue(new RString("5,555"));
//        panel.getTxtKogakuKaigoServicehiKohi3Shikyugaku().setValue(new RString("5,555"));
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

//        panel.getTxtCareManagementhiJigyoshoKubun().setValue(new RString("指定事業所"));
//        panel.getTxtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD().setValue(new RString("平26.01.01"));
//        panel.getTxtCareManagementhiServiceShurui().setValue(new RString("サービス種類"));
//        panel.getTxtCareManagementhiServiceKomoku().setValue(new RString("サービス項目"));
//        panel.getTxtCareManagementhiServiceCode().setValue(new RString("0000000001"));
//        panel.getTxtCareManagementhiServiceName().setValue(new RString("サービス名称"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiTanka().setValue(new RString("10.00"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiTani().setValue(new RString("1,000"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiKaisu().setValue(new RString("1"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiServiceTani().setValue(new RString("1,000"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiServiceTaniGokei().setValue(new RString("10,000"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiSeikyuKingaku().setValue(new RString("20,000"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiRiyoshaFutangaku().setValue(new RString("5,000"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiSenmoninNo().setValue(new RString("0000000001"));
//        panel.getTxtCareManagementhiTekiyo().setValue(new RString("摘要"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiSaishinsaKaisu().setValue(new RString("1"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiKagoKaisu().setValue(new RString("2"));
//        panel.getCareManagementhiEtc().getTxtCareManagementhiShinsaYM().setValue(new RString("平26.02"));
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
            RString txtKohi2Tani, RString txtKohi3Tani, RString txtSaiShinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgKyufuJissekiMeisai_Row(
                txtService, new Button(), txtKettei, txtTani, txtKaisu,
                txtKohi1Nissu, txtKohi2Nissu, txtKohi3Nissu, txtServiceTani, txtKohi1Tani,
                txtKohi2Tani, txtKohi3Tani, txtSaiShinsaKaisu, txtKagoKaisu, txtShinsaYM);
    }

    private dgServiceKeikakuhiFromH2104_Row createServiceKeikakuhiFromH2104Row(
            RString txtShiteiKijunGaitoJigyoshoKubun, RString txtIraiTodokedeYMD, RString txtService,
            RString txtTaniTanka, RString txtKettei, RString txtMeisaiGokei, RString txtTanisu, RString txtKaisu, RString txtServiceTanisu,
            RString txtSeikyuKingaku, RString txtTantoKaigoShienSenmoninNo, RString txtSaishinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgServiceKeikakuhiFromH2104_Row(
                txtShiteiKijunGaitoJigyoshoKubun, txtIraiTodokedeYMD, txtService,
                txtTaniTanka, new Button(), txtKettei, txtMeisaiGokei, txtTanisu, txtKaisu, txtServiceTanisu,
                txtSeikyuKingaku, txtTantoKaigoShienSenmoninNo, txtSaishinsaKaisu, txtKagoKaisu, txtShinsaYM);
    }

    private dgFukushiYoguKonyuhi_Row createFukushiYoguKonyuhiRow(
            RString txtService, RString txtKonyuYMD, RString txtShohinName, RString txtShumoku,
            RString txtSeizoJigyoshaName, RString txtHanbaiJigyoshaName, RString txtKonyuKingaku, RString txtShinsaYM) {
        return new dgFukushiYoguKonyuhi_Row(
                txtService, new Button(), txtKonyuYMD, txtShohinName, txtShumoku,
                txtSeizoJigyoshaName, txtHanbaiJigyoshaName, txtKonyuKingaku, txtShinsaYM);
    }

    private dgJutakuKaishuhi_Row createJutakuKaishuhiRow(
            RString txtService, RString txtChakkoYMD, RString txtJigyoshaName, RString txtJusho,
            RString txtHiyo, RString txtShinsaYM) {
        return new dgJutakuKaishuhi_Row(
                txtService, txtChakkoYMD, txtJigyoshaName, txtJusho,
                txtHiyo, txtShinsaYM);
    }

//    private KyufuJissekiDetailKeyInfo createKyufuJissekiDetailKeyInfo() {
//
//
//        return new KyufuJissekiDetailKeyInfo(
//                new KokanShikibetsuNo(new RString("1117")),
//                new InputShikibetsuNo(new Code("7131"), new RString("名称"), new RString("略称")),
//                new RString("H1"),
//                new ShoKisaiHokenshaNo(new RString("00202169")),
//                new KaigoHihokenshaNo(new RString("0000000034")),
//                new ServiceTeikyoYM(new FlexibleYearMonth("201207")),
//                new JigyoshaNo(new RString("2000190013")),
//                new ToshiNo(new RString("0000524400")),
//                new ArrayList<ServiceTeikyoYMListOfServiceShurui>());
////                new ArrayList<ServiceTeikyoYMListOfServiceShurui>());
////                new KokanShikibetsuNo(new RString("1234")),
////                new InputShikibetsuNo(new Code("0001"), new RString("名称"), new RString("略称")),
////                new RString("03"),
////                new ShoKisaiHokenshaNo(new RString("00000003")),
////                new KaigoHihokenshaNo(new RString("0000000004")),
////                new ServiceTeikyoYM(new FlexibleYearMonth("201401")),
////                new JigyoshaNo(new RString("0000000005")),
////                new ToshiNo(new RString("0000000006")),
////                new ArrayList<ServiceTeikyoYMListOfServiceShurui>());
//    }
//
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

}
