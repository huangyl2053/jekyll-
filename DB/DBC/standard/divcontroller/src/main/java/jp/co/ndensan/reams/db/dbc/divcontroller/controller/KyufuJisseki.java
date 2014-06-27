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
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJisseki {

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
        //panel.getTxtKyufuJissekiShikibetsuName().setValue(ymlData.getAsRString("ShikibetsuName"));
        panel.getTxtKyufuJissekiJigyosha().setValue(ymlData.getAsRString("Jigyosha"));

//        panel.getTxtKyufuJissekiHihokenshaNo().setValue(new RString("0000314323"));
//        panel.getTxtKyufuJissekiJuminShubetsu().setValue(new RString("転出者"));
//        panel.getTxtKyufuJissekiYokaigodo().setValue(new RString("要介護１"));
////        panel.getTxtKyufuJissekiNinteiYukoKikan().setFromValue(new RDate("20140101"));
////        panel.getTxtKyufuJissekiNinteiYukoKikan().setToValue(new RDate("20140202"));
//        panel.getTxtKyufuJissekiName().setValue(new RString("電算　太郎"));
//        panel.getTxtKyufuJissekiSeibetsu().setValue(new RString("男"));
//        panel.getTxtKyufuJissekiSeinengappi().setValue(new RString("昭03.03.03"));
//        panel.getTxtKyufuJissekiTeikyoYM().setValue(new RString("平26.01"));
//        panel.getTxtKyufuJissekiJissekiKubun().setValue(new RString("償還"));
//        panel.getTxtKyufuJissekiSeiriNo().setValue(new RString("0000000001"));
//        panel.getTxtKyufuJissekiHokensha().setValue(new RString("保険　次郎"));
//        panel.getTxtKyufuJissekiShikibetsuCode().setValue(new RString("0001"));
//        panel.getTxtKyufuJissekiShikibetsuName().setValue(new RString("サービス提供証明書（訪問通所他）"));
//        List<KeyValueDataSource> list = new ArrayList<>();
//        list.add(new KeyValueDataSource(new RString("key0"), new RString("1114301032:雛菊サービス機関")));
//        list.add(new KeyValueDataSource(new RString("key1"), new RString("2070500448:アネモネ福祉ランド")));
//        panel.getDdlKyufuJissekiJigyosha().setDataSource(list);
        panel.getBtnTokuteiShinryohi().setWrap(true);
        panel.getBtnShokujiHiyo().setWrap(true);
        panel.getBtnTokuteiNyushoshaKaigoServicehi().setWrap(true);
        panel.getBtnShakaiFukushiHojinKeigengaku().setWrap(true);

        setKyufuJissekiKihon(panel.getTabKyufuJisseki().getKyufuJissekiKihon());
        setKyufuJissekiMeisai(panel.getTabKyufuJisseki().getKyufuJissekiMeisaiShukei());
        setServiceKeikakuhi(panel.getTabKyufuJisseki().getServiceKeikakuhi());
        setFukushiYoguKonyuhi(panel.getTabKyufuJisseki().getFukushiYoguKonyuhi());
        setJutakuKaishuhi(panel.getTabKyufuJisseki().getJutakuKaishuhi());
        setKogakuKaigoServicehi(panel.getTabKyufuJisseki().getKogakuKaigoServicehi());
        setCareManagementhi(panel.getTabKyufuJisseki().getCareManagementhi());
        response.data = panel;
        return response;
    }

    private void setKyufuJissekiKihon(KyufuJissekiKihonDiv panel) {

        List<HashMap> kyufuJisseki = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/KyufuJissekiKihon.yml"));

        //ヘッダー情報取得、設定
        HashMap hashMap = kyufuJisseki.get(0);
        ControlGenerator ymlData = new ControlGenerator(hashMap);

        panel.getTxtKyufuJissekiKihonSakuseiKubun().setValue(ymlData.getAsRString("SakuseiKubun"));
        panel.getTxtKyufuJissekiKihonYokaigodo().setValue(ymlData.getAsRString("Yokaigodo"));
        panel.getTxtKyufuJissekiKihonNinteiYukoKikan().setFromValue(ymlData.getAsRDate("NinteiYukoKikanFrom"));
        panel.getTxtKyufuJissekiKihonNinteiYukoKikan().setToValue(ymlData.getAsRDate("NinteiYukoKikanTo"));
        panel.getTxtKyufuJissekiKihonShinsaYM().setValue(ymlData.getAsRString("ShinsaYM"));
        panel.getTxtKyufuJissekiKihonKeikokuKubun().setValue(ymlData.getAsRString("KeikokuKubun"));

        KyufuJissekiKihonHihokenshaDiv hihokenshaDiv = panel.getKyufuJissekiKihonHihokensha();
        hihokenshaDiv.getTxtKyufuJissekiKihonKyusochiNyushoshaTokurei().setValue(ymlData.getAsRString("KyusochiNyushoshaTokurei"));
        hihokenshaDiv.getTxtKyufuJissekiKihonRojinHokenShichosonNo().setValue(ymlData.getAsRString("RojinHokenShichosonNo"));
        hihokenshaDiv.getTxtKyufuJissekiKihonRojinHokenJukyushaNo().setValue(ymlData.getAsRString("RojinHokenJukyushaNo"));
        hihokenshaDiv.getTxtKyufuJissekiKihonKokiKoreiHokenshaNo().setValue(ymlData.getAsRString("KokiKoreiHokenshaNo"));
        hihokenshaDiv.getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo().setValue(ymlData.getAsRString("KokiKoreiHihokenshaNo"));
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoHokenshaNo().setValue(ymlData.getAsRString("KokuhoHokenshaNo"));
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoHihokenshashoNo().setValue(ymlData.getAsRString("KokuhoHihokenshashoNo"));
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoKojinNo().setValue(ymlData.getAsRString("KokuhoKojinNo"));

        KyufuJissekiKihonKyotakuServiceKeikakuDiv serviceKeikakuDiv = panel.getKyufuJissekiKihonKyotakuServiceKeikaku();
        serviceKeikakuDiv.getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun().setValue(
                ymlData.getAsRString("KyotakuServiceKeikakuSakuseiKubun"));
        serviceKeikakuDiv.getTxtKyufuJissekiKihonJigyoshoNo().setValue(ymlData.getAsRString("JigyoshoNo"));
        serviceKeikakuDiv.getTxtKyufuJissekiKihonJigyoshoName().setValue(ymlData.getAsRString("JigyoshoName"));

        KyufuJissekiKihonServiceKikanDiv serviceKikanDiv = panel.getKyufuJissekiKihonServiceKikan();
        serviceKikanDiv.getTxtKyufuJissekiKihonKaishiYMD().setValue(ymlData.getAsRString("KaishiYMD"));
        serviceKikanDiv.getTxtKyufuJissekiKihonChushiYMD().setValue(ymlData.getAsRString("ChushiYMD"));
        serviceKikanDiv.getTxtKyufuJissekiKihonChushiRiyu().setValue(ymlData.getAsRString("ChushiRiyu"));

        KyufuJissekiKihonShisetsuNyutaishoDiv shisetsuNyutaishoDiv = panel.getKyufuJissekiKihonShisetsuNyutaisho();
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoYMD().setValue(ymlData.getAsRString("NyushoYMD"));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonTaishoYMD().setValue(ymlData.getAsRString("TaishoYMD"));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoJitsuNissu().setValue(ymlData.getAsRString("NyushoJitsuNissu"));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonGaihakuNissu().setValue(ymlData.getAsRString("GaihakuNissu"));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoMaeJokyo().setValue(ymlData.getAsRString("NyushoMaeJokyo"));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoAtoJokyo().setValue(ymlData.getAsRString("NyushoAtoJokyo"));

        KyufuJissekiKihonKyufuritsuDiv kyufuritsuDiv = panel.getKyufuJissekiKihonKyufuritsu();
        kyufuritsuDiv.getTxtKyufuJissekiKihonHokenKyufuRitsu().setValue(ymlData.getAsRString("HokenKyufuRitsu"));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi1KyufuRitsu().setValue(ymlData.getAsRString("Kohi1KyufuRitsu"));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi2KyufuRitsu().setValue(ymlData.getAsRString("Kohi2KyufuRitsu"));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi3KyufuRitsu().setValue(ymlData.getAsRString("Kohi3KyufuRitsu"));

        KyufuJissekiKihonKohiDiv kohiDiv = panel.getKyufuJissekiKihonKohi();
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo1().setValue(ymlData.getAsRString("KohiFutanshaNo1"));
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo2().setValue(ymlData.getAsRString("KohiFutanshaNo2"));
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo3().setValue(ymlData.getAsRString("KohiFutanshaNo3"));
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo1().setValue(ymlData.getAsRString("KohiJukyushaNo1"));
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo2().setValue(ymlData.getAsRString("KohiJukyushaNo2"));
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo3().setValue(ymlData.getAsRString("KohiJukyushaNo3"));

//        panel.getTxtKyufuJissekiKihonSakuseiKubun().setValue(new RString("新規"));
//        panel.getTxtKyufuJissekiKihonYokaigodo().setValue(new RString("要介護１"));
////        panel.getTxtKyufuJissekiKihonNinteiYukoKikan().setFromValue(new RDate("20140101"));
////        panel.getTxtKyufuJissekiKihonNinteiYukoKikan().setToValue(new RDate("20140202"));
//        panel.getTxtKyufuJissekiKihonShinsaYM().setValue(new RString("平26.01"));
//        panel.getTxtKyufuJissekiKihonKeikokuKubun().setValue(new RString("警告なし"));
//        KyufuJissekiKihonHihokenshaDiv hihokenshaDiv = panel.getKyufuJissekiKihonHihokensha();
//        hihokenshaDiv.getTxtKyufuJissekiKihonKyusochiNyushoshaTokurei().setValue(new RString("特例１"));
//        hihokenshaDiv.getTxtKyufuJissekiKihonRojinHokenShichosonNo().setValue(new RString("00000001"));
//        hihokenshaDiv.getTxtKyufuJissekiKihonRojinHokenJukyushaNo().setValue(new RString("0000001"));
//        hihokenshaDiv.getTxtKyufuJissekiKihonKokiKoreiHokenshaNo().setValue(new RString("0000001"));
//        hihokenshaDiv.getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo().setValue(new RString("0000002"));
//        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoHokenshaNo().setValue(new RString("0000003"));
//        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoHihokenshashoNo().setValue(new RString("0000004"));
//        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoKojinNo().setValue(new RString("0000005"));
//        KyufuJissekiKihonKyotakuServiceKeikakuDiv serviceKeikakuDiv = panel.getKyufuJissekiKihonKyotakuServiceKeikaku();
//        serviceKeikakuDiv.getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun().setValue(new RString("自己作成"));
//        serviceKeikakuDiv.getTxtKyufuJissekiKihonJigyoshoNo().setValue(new RString("0000000001"));
//        serviceKeikakuDiv.getTxtKyufuJissekiKihonJigyoshoName().setValue(new RString("事業者１"));
//        KyufuJissekiKihonServiceKikanDiv serviceKikanDiv = panel.getKyufuJissekiKihonServiceKikan();
//        serviceKikanDiv.getTxtKyufuJissekiKihonKaishiYMD().setValue(new RString("平26.01.01"));
//        serviceKikanDiv.getTxtKyufuJissekiKihonChushiYMD().setValue(new RString("平26.03.03"));
//        serviceKikanDiv.getTxtKyufuJissekiKihonChushiRiyu().setValue(new RString("諸事情の為"));
//        KyufuJissekiKihonShisetsuNyutaishoDiv shisetsuNyutaishoDiv = panel.getKyufuJissekiKihonShisetsuNyutaisho();
//        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoYMD().setValue(new RString("平26.01.01"));
//        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonTaishoYMD().setValue(new RString("平26.03.03"));
//        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoJitsuNissu().setValue(new RString("10"));
//        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonGaihakuNissu().setValue(new RString("30"));
//        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoMaeJokyo().setValue(new RString("居宅"));
//        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoAtoJokyo().setValue(new RString("医療機関入院"));
//        KyufuJissekiKihonKyufuritsuDiv kyufuritsuDiv = panel.getKyufuJissekiKihonKyufuritsu();
//        kyufuritsuDiv.getTxtKyufuJissekiKihonHokenKyufuRitsu().setValue(new RString("90"));
//        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi1KyufuRitsu().setValue(new RString("1"));
//        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi2KyufuRitsu().setValue(new RString("2"));
//        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi3KyufuRitsu().setValue(new RString("3"));
//        KyufuJissekiKihonKohiDiv kohiDiv = panel.getKyufuJissekiKihonKohi();
//        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo1().setValue(new RString("0000000001"));
//        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo2().setValue(new RString("0000000002"));
//        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo3().setValue(new RString("0000000003"));
//        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo1().setValue(new RString("0000000001"));
//        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo2().setValue(new RString("0000000002"));
//        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo3().setValue(new RString("0000000003"));
    }

    private void setKyufuJissekiMeisai(KyufuJissekiMeisaiShukeiDiv panel) {

        //給付実績集計データ取得、設定
        List<HashMap> kyufuJissekiShukei = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/KyufuJissekiShukei.yml"));

        List<dgKyufuJissekiShukei_Row> shukeiList = new ArrayList<>();
        for (int i = 0; i < kyufuJissekiShukei.size(); i++) {
            HashMap hashMap = kyufuJissekiShukei.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsServiceShurui = ymlData.getAsRString("txtServiceShurui");
            RString rsJitsuNissu = ymlData.getAsRString("txtJitsuNissu");
            RString rsKeikakuTani = ymlData.getAsRString("txtKeikakuTani");
            RString rsTaishoTani = ymlData.getAsRString("txtTaishoTani");
            RString rsTaishogaiTani = ymlData.getAsRString("txtTaishogaiTani");
            RString rsTankiKeikakuNissu = ymlData.getAsRString("txtTankiKeikakuNissu");
            RString rsHokenKohi = ymlData.getAsRString("txtHokenKohi");
            RString rsKettei = ymlData.getAsRString("txtKettei");
            RString rsTankiJitsuNissu = ymlData.getAsRString("txtTankiJitsuNissu");
            RString rsTaniGokei = ymlData.getAsRString("txtTaniGokei");
            RString rsTanisuTanka = ymlData.getAsRString("txtTanisuTanka");
            RString rsSeikyugaku = ymlData.getAsRString("txtSeikyugaku");
            RString rsRiyoshaFutangaku = ymlData.getAsRString("txtRiyoshaFutangaku");
            RString rsDekidakaTaniGokei = ymlData.getAsRString("txtDekidakaTaniGokei");
            RString rsDekidakaSeikyugaku = ymlData.getAsRString("txtDekidakaSeikyugaku");
            RString rsDekidakaHonninFutangaku = ymlData.getAsRString("txtDekidakaHonninFutangaku");
            RString rsSaiShinsaKaisu = ymlData.getAsRString("txtSaiShinsaKaisu");
            RString rsKagoKaisu = ymlData.getAsRString("txtKagoKaisu");
            RString rsShinsaYM = ymlData.getAsRString("txtShinsaYM");

            shukeiList.add(createKyufuJissekiShukeiRow(rsServiceShurui, rsJitsuNissu, rsKeikakuTani, rsTaishoTani,
                    rsTaishogaiTani, rsTankiKeikakuNissu, rsHokenKohi, rsKettei, rsTankiJitsuNissu, rsTaniGokei, rsTanisuTanka,
                    rsSeikyugaku, rsRiyoshaFutangaku, rsDekidakaTaniGokei, rsDekidakaSeikyugaku, rsDekidakaHonninFutangaku,
                    rsSaiShinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getKyufuJissekiShukei().getDgKyufuJissekiShukei().setDataSource(shukeiList);

        //給付実績明細データ取得、設定
        List<HashMap> kyufuJissekiMeisai = YamlLoader.DBC.loadAsList(
                new RString("dbc0010000/KyufuJissekiMeisai.yml"));

        List<dgKyufuJissekiMeisai_Row> meisaiList = new ArrayList<>();
        for (int i = 0; i < kyufuJissekiMeisai.size(); i++) {
            HashMap hashMap = kyufuJissekiMeisai.get(i);
            ControlGenerator ymlData = new ControlGenerator(hashMap);

            RString rsService = ymlData.getAsRString("txtService");
            RString rsKettei = ymlData.getAsRString("txtKettei");
            RString rsTani = ymlData.getAsRString("txtTani");
            RString rsKaisu = ymlData.getAsRString("txtKaisu");
            RString rsKohi1Nissu = ymlData.getAsRString("txtKohi1Nissu");
            RString rsKohi2Nissu = ymlData.getAsRString("txtKohi2Nissu");
            RString rsKohi3Nissu = ymlData.getAsRString("txtKohi3Nissu");
            RString rsServiceTani = ymlData.getAsRString("txtServiceTani");
            RString rsKohi1Tani = ymlData.getAsRString("txtKohi1Tani");
            RString rsKohi2Tani = ymlData.getAsRString("txtKohi2Tani");
            RString rsKohi3Tani = ymlData.getAsRString("txtKohi3Tani");
            RString rsSaiShinsaKaisu = ymlData.getAsRString("txtSaiShinsaKaisu");
            RString rsKagoKaisu = ymlData.getAsRString("txtKagoKaisu");
            RString rsShinsaYM = ymlData.getAsRString("txtShinsaYM");

            meisaiList.add(createKyufuJissekiMeisaiRow(
                    rsService, rsKettei, rsTani, rsKaisu, rsKohi1Nissu, rsKohi2Nissu,
                    rsKohi3Nissu, rsServiceTani, rsKohi1Tani, rsKohi2Tani, rsKohi3Tani,
                    rsSaiShinsaKaisu, rsKagoKaisu, rsShinsaYM));
        }
        panel.getKyufuJissekiMeisai().getDgKyufuJissekiMeisai().setDataSource(meisaiList);

//        List<dgKyufuJissekiShukei_Row> shukeiList = new ArrayList<>();
//        shukeiList.add(createKyufuJissekiShukeiRow("15:通所介護", "4", "2,852", "2,852", "0", "0", "保険", "", "0", "2,852", "12.34", "25,668", "2,852", "2,852", "2,852", "2,852", "0", "0", "平18.05"));
//        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "", "後", "0", "2,852", "12.34", "25,668", "2,852", "2,852", "2,852", "2,852", "", "", ""));
//        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "公費１", "", "1", "1,000", "10.00", "10,000", "1,111", "1,111", "1,111", "1,111", "1", "1", "平26.01"));
//        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "", "後", "1", "1,000", "10.00", "10,000", "1,111", "1,111", "1,111", "1,111", "", "", ""));
//        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "公費２", "", "2", "2,000", "20.00", "20,000", "2,222", "2,222", "2,222", "2,222", "2", "2", "平26.02"));
//        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "", "後", "2", "2,000", "20.00", "20,000", "2,222", "2,222", "2,222", "2,222", "", "", ""));
//        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "公費３", "", "3", "3,000", "30.00", "30,000", "3,333", "3,333", "3,333", "3,333", "3", "3", "平26.03"));
//        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "", "後", "3", "3,000", "30.00", "30,000", "3,333", "3,333", "3,333", "3,333", "", "", ""));
//        panel.getKyufuJissekiShukei().getDgKyufuJissekiShukei().setDataSource(shukeiList);
//        List<dgKyufuJissekiMeisai_Row> meisaiList = new ArrayList<>();
//        meisaiList.add(createKyufuJissekiMeisaiRow("155100:通所介護食事加算", "", "1,000", "4", "0", "0", "0", "1,500", "0", "0", "0", "1", "2", "平26.01"));
//        meisaiList.add(createKyufuJissekiMeisaiRow("", "後", "1,000", "4", "0", "0", "0", "1,500", "0", "0", "0", "", "", ""));
//        meisaiList.add(createKyufuJissekiMeisaiRow("155301:通所介護入浴介助加算あいうえおかきくけこ", "", "1,000", "4", "0", "0", "0", "1,500", "0", "0", "0", "1", "2", "平26.01"));
//        meisaiList.add(createKyufuJissekiMeisaiRow("", "後", "1,000", "4", "0", "0", "0", "1,500", "0", "0", "0", "", "", ""));
//        panel.getKyufuJissekiMeisai().getDgKyufuJissekiMeisai().setDataSource(meisaiList);
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
            //            String txtServiceShurui, String txtJitsuNissu, String txtKeikakuTani, String txtTaishoTani,
            //            String txtTaishogaiTani, String txtTankiKeikakuNissu, String txtHokenKohi, String txtKettei, String txtTankiJitsuNissu,
            //            String txtTaniGokei, String txtTaniTanka, String txtSeikyugaku, String txtRiyoshaFutangaku, String txtDekidakaTaniGokei,
            //            String txtDekidakaSeikyugaku, String txtDekidakaHonninFutangaku, String txtSaiShinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
            RString txtServiceShurui, RString txtJitsuNissu, RString txtKeikakuTani, RString txtTaishoTani,
            RString txtTaishogaiTani, RString txtTankiKeikakuNissu, RString txtHokenKohi, RString txtKettei, RString txtTankiJitsuNissu,
            RString txtTaniGokei, RString txtTaniTanka, RString txtSeikyugaku, RString txtRiyoshaFutangaku, RString txtDekidakaTaniGokei,
            RString txtDekidakaSeikyugaku, RString txtDekidakaHonninFutangaku, RString txtSaiShinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgKyufuJissekiShukei_Row(
                //                new RString(txtServiceShurui), new RString(txtJitsuNissu), new RString(txtKeikakuTani), new RString(txtTaishoTani),
                //                new RString(txtTaishogaiTani), new RString(txtTankiKeikakuNissu), new RString(txtHokenKohi), new RString(txtKettei), new RString(txtTankiJitsuNissu),
                //                new RString(txtTaniGokei), new RString(txtTaniTanka), new RString(txtSeikyugaku), new RString(txtRiyoshaFutangaku), new RString(txtDekidakaTaniGokei),
                //                new RString(txtDekidakaSeikyugaku), new RString(txtDekidakaHonninFutangaku), new RString(txtSaiShinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
                txtServiceShurui, txtJitsuNissu, txtKeikakuTani, txtTaishoTani,
                txtTaishogaiTani, txtTankiKeikakuNissu, txtHokenKohi, txtKettei, txtTankiJitsuNissu,
                txtTaniGokei, txtTaniTanka, txtSeikyugaku, txtRiyoshaFutangaku, txtDekidakaTaniGokei,
                txtDekidakaSeikyugaku, txtDekidakaHonninFutangaku, txtSaiShinsaKaisu, txtKagoKaisu, txtShinsaYM
        );
    }

    private dgKyufuJissekiMeisai_Row createKyufuJissekiMeisaiRow(
            //            String txtService, String txtKettei, String txtTani, String txtKaisu,
            //            String txtKohi1Nissu, String txtKohi2Nissu, String txtKohi3Nissu, String txtServiceTani, String txtKohi1Tani,
            //            String txtKohi2Tani, String txtKohi3Tani, String txtSaiShinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
            RString txtService, RString txtKettei, RString txtTani, RString txtKaisu,
            RString txtKohi1Nissu, RString txtKohi2Nissu, RString txtKohi3Nissu, RString txtServiceTani, RString txtKohi1Tani,
            RString txtKohi2Tani, RString txtKohi3Tani, RString txtSaiShinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgKyufuJissekiMeisai_Row(
                //                new RString(txtService), new Button(), new RString(txtKettei), new RString(txtTani), new RString(txtKaisu),
                //                new RString(txtKohi1Nissu), new RString(txtKohi2Nissu), new RString(txtKohi3Nissu), new RString(txtServiceTani), new RString(txtKohi1Tani),
                //                new RString(txtKohi2Tani), new RString(txtKohi3Tani), new RString(txtSaiShinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
                txtService, new Button(), txtKettei, txtTani, txtKaisu,
                txtKohi1Nissu, txtKohi2Nissu, txtKohi3Nissu, txtServiceTani, txtKohi1Tani,
                txtKohi2Tani, txtKohi3Tani, txtSaiShinsaKaisu, txtKagoKaisu, txtShinsaYM);
    }

    private dgServiceKeikakuhiFromH2104_Row createServiceKeikakuhiFromH2104Row(
            //            String txtShiteiKijunGaitoJigyoshoKubun, String txtIraiTodokedeYMD, String txtService,
            //            String txtTaniTanka, String txtKettei, String txtMeisaiGokei, String txtTanisu, String txtKaisu, String txtServiceTanisu,
            //            String txtSeikyuKingaku, String txtTantoKaigoShienSenmoninNo, String txtSaishinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
            RString txtShiteiKijunGaitoJigyoshoKubun, RString txtIraiTodokedeYMD, RString txtService,
            RString txtTaniTanka, RString txtKettei, RString txtMeisaiGokei, RString txtTanisu, RString txtKaisu, RString txtServiceTanisu,
            RString txtSeikyuKingaku, RString txtTantoKaigoShienSenmoninNo, RString txtSaishinsaKaisu, RString txtKagoKaisu, RString txtShinsaYM) {
        return new dgServiceKeikakuhiFromH2104_Row(
                //                new RString(txtShiteiKijunGaitoJigyoshoKubun), new RString(txtIraiTodokedeYMD), new RString(txtService),
                //                new RString(txtTaniTanka), new Button(), new RString(txtKettei), new RString(txtMeisaiGokei), new RString(txtTanisu), new RString(txtKaisu), new RString(txtServiceTanisu),
                //                new RString(txtSeikyuKingaku), new RString(txtTantoKaigoShienSenmoninNo), new RString(txtSaishinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
                txtShiteiKijunGaitoJigyoshoKubun, txtIraiTodokedeYMD, txtService,
                txtTaniTanka, new Button(), txtKettei, txtMeisaiGokei, txtTanisu, txtKaisu, txtServiceTanisu,
                txtSeikyuKingaku, txtTantoKaigoShienSenmoninNo, txtSaishinsaKaisu, txtKagoKaisu, txtShinsaYM);
    }

    private dgFukushiYoguKonyuhi_Row createFukushiYoguKonyuhiRow(
            //            String txtService, String txtKonyuYMD, String txtShohinName, String txtShumoku,
            //            String txtSeizoJigyoshaName, String txtHanbaiJigyoshaName, String txtKonyuKingaku, String txtShinsaYM) {
            RString txtService, RString txtKonyuYMD, RString txtShohinName, RString txtShumoku,
            RString txtSeizoJigyoshaName, RString txtHanbaiJigyoshaName, RString txtKonyuKingaku, RString txtShinsaYM) {
        return new dgFukushiYoguKonyuhi_Row(
                //                new RString(txtService), new Button(), new RString(txtKonyuYMD), new RString(txtShohinName), new RString(txtShumoku),
                //                new RString(txtSeizoJigyoshaName), new RString(txtHanbaiJigyoshaName), new RString(txtKonyuKingaku), new RString(txtShinsaYM));
                txtService, new Button(), txtKonyuYMD, txtShohinName, txtShumoku,
                txtSeizoJigyoshaName, txtHanbaiJigyoshaName, txtKonyuKingaku, txtShinsaYM);
    }

    private dgJutakuKaishuhi_Row createJutakuKaishuhiRow(
            //            String txtService, String txtChakkoYMD, String txtJigyoshaName, String txtJusho,
            //            String txtHiyo, String txtShinsaYM) {
            RString txtService, RString txtChakkoYMD, RString txtJigyoshaName, RString txtJusho,
            RString txtHiyo, RString txtShinsaYM) {
        return new dgJutakuKaishuhi_Row(
                //                new RString(txtService), new RString(txtChakkoYMD), new RString(txtJigyoshaName), new RString(txtJusho),
                //                new RString(txtHiyo), new RString(txtShinsaYM));
                txtService, txtChakkoYMD, txtJigyoshaName, txtJusho,
                txtHiyo, txtShinsaYM);
    }
}
