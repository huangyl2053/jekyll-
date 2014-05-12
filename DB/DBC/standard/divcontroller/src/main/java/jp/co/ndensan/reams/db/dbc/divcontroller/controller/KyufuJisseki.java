/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.CareManagementhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.FukushiYoguKonyuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiKihonHihokenshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiKihonKohiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiKihonKyotakuServiceKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiKihonServiceKikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiKihonShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyufuJissekiMeisai_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KogakuKaigoServicehiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiKihonKyufuritsuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyufuJissekiMeisaiShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceKeikakuhiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgFukushiYoguKonyuhi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuhi_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyufuJissekiShukei_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceKeikakuhiFromH2104_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.*;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJisseki {

    public ResponseData<KyufuJissekiDiv> onLoad(KyufuJissekiDiv panel) {
        ResponseData<KyufuJissekiDiv> response = new ResponseData<>();

        panel.getTxtKyufuJissekiHihokenshaNo().setValue(new RString("0000314323"));
        panel.getTxtKyufuJissekiJuminShubetsu().setValue(new RString("転出者"));
        panel.getTxtKyufuJissekiYokaigodo().setValue(new RString("要介護１"));
//        panel.getTxtKyufuJissekiNinteiYukoKikan().setFromValue(new RDate("20140101"));
//        panel.getTxtKyufuJissekiNinteiYukoKikan().setToValue(new RDate("20140202"));
        panel.getTxtKyufuJissekiName().setValue(new RString("電算　太郎"));
        panel.getTxtKyufuJissekiSeibetsu().setValue(new RString("男"));
        panel.getTxtKyufuJissekiSeinengappi().setValue(new RString("昭03.03.03"));
        panel.getTxtKyufuJissekiTeikyoYM().setValue(new RString("平26.01"));
        panel.getTxtKyufuJissekiJissekiKubun().setValue(new RString("償還"));
        panel.getTxtKyufuJissekiSeiriNo().setValue(new RString("0000000001"));
        panel.getTxtKyufuJissekiHokensha().setValue(new RString("保険　次郎"));
        panel.getTxtKyufuJissekiShikibetsuCode().setValue(new RString("0001"));
        panel.getTxtKyufuJissekiShikibetsuName().setValue(new RString("サービス提供証明書（訪問通所他）"));

        List<KeyValueDataSource> list = new ArrayList<>();
        list.add(new KeyValueDataSource(new RString("key0"), new RString("1114301032:雛菊サービス機関")));
        list.add(new KeyValueDataSource(new RString("key1"), new RString("2070500448:アネモネ福祉ランド")));
        panel.getDdlKyufuJissekiJigyosha().setDataSource(list);

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

        panel.getTxtKyufuJissekiKihonSakuseiKubun().setValue(new RString("新規"));
        panel.getTxtKyufuJissekiKihonYokaigodo().setValue(new RString("要介護１"));
//        panel.getTxtKyufuJissekiKihonNinteiYukoKikan().setFromValue(new RDate("20140101"));
//        panel.getTxtKyufuJissekiKihonNinteiYukoKikan().setToValue(new RDate("20140202"));
        panel.getTxtKyufuJissekiKihonShinsaYM().setValue(new RString("平26.01"));
        panel.getTxtKyufuJissekiKihonKeikokuKubun().setValue(new RString("警告なし"));

        KyufuJissekiKihonHihokenshaDiv hihokenshaDiv = panel.getKyufuJissekiKihonHihokensha();
        hihokenshaDiv.getTxtKyufuJissekiKihonKyusochiNyushoshaTokurei().setValue(new RString("特例１"));
        hihokenshaDiv.getTxtKyufuJissekiKihonRojinHokenShichosonNo().setValue(new RString("00000001"));
        hihokenshaDiv.getTxtKyufuJissekiKihonRojinHokenJukyushaNo().setValue(new RString("0000001"));
        hihokenshaDiv.getTxtKyufuJissekiKihonKokiKoreiHokenshaNo().setValue(new RString("0000001"));
        hihokenshaDiv.getTxtKyufuJissekiKihonKokiKoreiHihokenshaNo().setValue(new RString("0000002"));
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoHokenshaNo().setValue(new RString("0000003"));
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoHihokenshashoNo().setValue(new RString("0000004"));
        hihokenshaDiv.getTxtKyufuJissekiKihonKokuhoKojinNo().setValue(new RString("0000005"));

        KyufuJissekiKihonKyotakuServiceKeikakuDiv serviceKeikakuDiv = panel.getKyufuJissekiKihonKyotakuServiceKeikaku();
        serviceKeikakuDiv.getTxtKyufuJissekiKihonKyotakuServiceKeikakuSakuseiKubun().setValue(new RString("自己作成"));
        serviceKeikakuDiv.getTxtKyufuJissekiKihonJigyoshoNo().setValue(new RString("0000000001"));
        serviceKeikakuDiv.getTxtKyufuJissekiKihonJigyoshoName().setValue(new RString("事業者１"));

        KyufuJissekiKihonServiceKikanDiv serviceKikanDiv = panel.getKyufuJissekiKihonServiceKikan();
        serviceKikanDiv.getTxtKyufuJissekiKihonKaishiYMD().setValue(new RString("平26.01.01"));
        serviceKikanDiv.getTxtKyufuJissekiKihonChushiYMD().setValue(new RString("平26.03.03"));
        serviceKikanDiv.getTxtKyufuJissekiKihonChushiRiyu().setValue(new RString("諸事情の為"));

        KyufuJissekiKihonShisetsuNyutaishoDiv shisetsuNyutaishoDiv = panel.getKyufuJissekiKihonShisetsuNyutaisho();
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoYMD().setValue(new RString("平26.01.01"));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonTaishoYMD().setValue(new RString("平26.03.03"));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoJitsuNissu().setValue(new RString("10"));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonGaihakuNissu().setValue(new RString("30"));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoMaeJokyo().setValue(new RString("居宅"));
        shisetsuNyutaishoDiv.getTxtKyufuJissekiKihonNyushoAtoJokyo().setValue(new RString("医療機関入院"));

        KyufuJissekiKihonKyufuritsuDiv kyufuritsuDiv = panel.getKyufuJissekiKihonKyufuritsu();
        kyufuritsuDiv.getTxtKyufuJissekiKihonHokenKyufuRitsu().setValue(new RString("90"));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi1KyufuRitsu().setValue(new RString("1"));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi2KyufuRitsu().setValue(new RString("2"));
        kyufuritsuDiv.getTxtKyufuJissekiKihonKohi3KyufuRitsu().setValue(new RString("3"));

        KyufuJissekiKihonKohiDiv kohiDiv = panel.getKyufuJissekiKihonKohi();
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo1().setValue(new RString("0000000001"));
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo2().setValue(new RString("0000000002"));
        kohiDiv.getTxtKyufuJissekiKihonKohiFutanshaNo3().setValue(new RString("0000000003"));
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo1().setValue(new RString("0000000001"));
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo2().setValue(new RString("0000000002"));
        kohiDiv.getTxtKyufuJissekiKihonKohiJukyushaNo3().setValue(new RString("0000000003"));
    }

    private void setKyufuJissekiMeisai(KyufuJissekiMeisaiShukeiDiv panel) {
        List<dgKyufuJissekiShukei_Row> shukeiList = new ArrayList<>();
        shukeiList.add(createKyufuJissekiShukeiRow("15:通所介護", "4", "2,852", "2,852", "0", "0", "保険", "", "0", "2,852", "12.34", "25,668", "2,852", "2,852", "2,852", "2,852", "0", "0", "平18.05"));
        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "", "後", "0", "2,852", "12.34", "25,668", "2,852", "2,852", "2,852", "2,852", "", "", ""));
        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "公費１", "", "1", "1,000", "10.00", "10,000", "1,111", "1,111", "1,111", "1,111", "1", "1", "平26.01"));
        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "", "後", "1", "1,000", "10.00", "10,000", "1,111", "1,111", "1,111", "1,111", "", "", ""));
        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "公費２", "", "2", "2,000", "20.00", "20,000", "2,222", "2,222", "2,222", "2,222", "2", "2", "平26.02"));
        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "", "後", "2", "2,000", "20.00", "20,000", "2,222", "2,222", "2,222", "2,222", "", "", ""));
        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "公費３", "", "3", "3,000", "30.00", "30,000", "3,333", "3,333", "3,333", "3,333", "3", "3", "平26.03"));
        shukeiList.add(createKyufuJissekiShukeiRow("", "", "", "", "", "", "", "後", "3", "3,000", "30.00", "30,000", "3,333", "3,333", "3,333", "3,333", "", "", ""));
        panel.getKyufuJissekiShukei().getDgKyufuJissekiShukei().setDataSource(shukeiList);
        List<dgKyufuJissekiMeisai_Row> meisaiList = new ArrayList<>();
        meisaiList.add(createKyufuJissekiMeisaiRow("155100:通所介護食事加算", "", "1,000", "4", "0", "0", "0", "1,500", "0", "0", "0", "1", "2", "平26.01"));
        meisaiList.add(createKyufuJissekiMeisaiRow("", "後", "1,000", "4", "0", "0", "0", "1,500", "0", "0", "0", "", "", ""));
        meisaiList.add(createKyufuJissekiMeisaiRow("155301:通所介護入浴介助加算あいうえおかきくけこ", "", "1,000", "4", "0", "0", "0", "1,500", "0", "0", "0", "1", "2", "平26.01"));
        meisaiList.add(createKyufuJissekiMeisaiRow("", "後", "1,000", "4", "0", "0", "0", "1,500", "0", "0", "0", "", "", ""));
        panel.getKyufuJissekiMeisai().getDgKyufuJissekiMeisai().setDataSource(meisaiList);
    }

    private void setServiceKeikakuhi(ServiceKeikakuhiDiv panel) {
        List<dgServiceKeikakuhiFromH2104_Row> list = new ArrayList<>();
        list.add(createServiceKeikakuhiFromH2104Row("指定事業所", "平21.03.02", "432111:居宅支援I１", "10.00", "", "明細", "1,000", "10", "10,000", "", "20050594", "0", "0", "平26.02"));
        list.add(createServiceKeikakuhiFromH2104Row("", "", "", "", "", "合計", "", "", "10,000", "100,000", "", "", "", ""));
        list.add(createServiceKeikakuhiFromH2104Row("指定事業所", "平21.03.02", "432111:居宅支援I１", "10.00", "後", "明細", "1,000", "10", "10,000", "", "20050594", "0", "0", "平26.02"));
        list.add(createServiceKeikakuhiFromH2104Row("", "", "", "", "後", "合計", "", "", "10,000", "100,000", "", "", "", ""));
        panel.getDgServiceKeikakuhiFromH2104().setDataSource(list);
    }

    private void setFukushiYoguKonyuhi(FukushiYoguKonyuhiDiv panel) {
        List<dgFukushiYoguKonyuhi_Row> list = new ArrayList<>();
        list.add(createFukushiYoguKonyuhiRow("410000:特定福祉用具販売", "平18.10.13", "浴槽補助椅子", "03:特殊寝台", "ＤＥＮＳＡＮ（株）", "ＤＥＮＳＡＮ（株）", "12,500", "平18.12"));
        panel.getDgFukushiYoguKonyuhi().setDataSource(list);
    }

    private void setJutakuKaishuhi(JutakuKaishuhiDiv panel) {
        List<dgJutakuKaishuhi_Row> list = new ArrayList<>();
        list.add(createJutakuKaishuhiRow("420000:住宅改修", "平14.10.01", "銀杏組", "電算町紫原７２丁目", "56,000", "平18.05"));
        panel.getDgJutakuKaishuhi().setDataSource(list);
    }

    private void setKogakuKaigoServicehi(KogakuKaigoServicehiDiv panel) {
        panel.getTxtKogakuKaigoServicehiTeikyoYM().setValue(new RString("平26.01"));
        panel.getTxtKogakuKaigoServicehiJissekiKubun().setValue(new RString("償還"));
        panel.getTxtKogakuKaigoServicehiSakuseiKubun().setValue(new RString("新規"));
        panel.getTxtKogakuKaigoServicehiSeiriNo().setValue(new RString("0000000001"));
        panel.getTxtKogakuKaigoServicehiHokensha().setValue(new RString("保険　次郎"));
        panel.getTxtKogakuKaigoServicehiShikibetsuCode().setValue(new RString("0001"));
        panel.getTxtKogakuKaigoServicehiShikibetsuName().setValue(new RString("サービス提供証明書（訪問通所他）"));
        panel.getTxtKogakuKaigoServicehiKetteiYMD().setValue(new RString("平26.01.01"));
        panel.getTxtKogakuKaigoServicehiUketsukeYMD().setValue(new RString("平26.02.02"));
        panel.getTxtKogakuKaigoServicehiShinsaYM().setValue(new RString("平26.03"));
        panel.getTxtKogakuKaigoServicehiRiyoshaFutangaku().setValue(new RString("1,111"));
        panel.getTxtKogakuKaigoServicehiShikyugaku().setValue(new RString("2,222"));
        panel.getTxtKogakuKaigoServicehiKohi1FutanshaNo().setValue(new RString("0000000001"));
        panel.getTxtKogakuKaigoServicehiKohi1Futangaku().setValue(new RString("3,333"));
        panel.getTxtKogakuKaigoServicehiKohi1Shikyugaku().setValue(new RString("3,333"));
        panel.getTxtKogakuKaigoServicehiKohi2FutanshaNo().setValue(new RString("0000000002"));
        panel.getTxtKogakuKaigoServicehiKohi2Futangaku().setValue(new RString("4,444"));
        panel.getTxtKogakuKaigoServicehiKohi2Shikyugaku().setValue(new RString("4,444"));
        panel.getTxtKogakuKaigoServicehiKohi3FutanshaNo().setValue(new RString("0000000003"));
        panel.getTxtKogakuKaigoServicehiKohi3Futangaku().setValue(new RString("5,555"));
        panel.getTxtKogakuKaigoServicehiKohi3Shikyugaku().setValue(new RString("5,555"));
    }

    private void setCareManagementhi(CareManagementhiDiv panel) {
        panel.getTxtCareManagementhiJigyoshoKubun().setValue(new RString("指定事業所"));
        panel.getTxtCareManagementhiServiceKeikakuSakuseiIraiTodokedeYMD().setValue(new RString("平26.01.01"));
        panel.getTxtCareManagementhiServiceShurui().setValue(new RString("サービス種類"));
        panel.getTxtCareManagementhiServiceKomoku().setValue(new RString("サービス項目"));
        panel.getTxtCareManagementhiServiceCode().setValue(new RString("0000000001"));
        panel.getTxtCareManagementhiServiceName().setValue(new RString("サービス名称"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiTanka().setValue(new RString("10.00"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiTani().setValue(new RString("1,000"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiKaisu().setValue(new RString("1"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiServiceTani().setValue(new RString("1,000"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiServiceTaniGokei().setValue(new RString("10,000"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiSeikyuKingaku().setValue(new RString("20,000"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiRiyoshaFutangaku().setValue(new RString("5,000"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiSenmoninNo().setValue(new RString("0000000001"));
        panel.getTxtCareManagementhiTekiyo().setValue(new RString("摘要"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiSaishinsaKaisu().setValue(new RString("1"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiKagoKaisu().setValue(new RString("2"));
        panel.getCareManagementhiEtc().getTxtCareManagementhiShinsaYM().setValue(new RString("平26.02"));
    }

    private dgKyufuJissekiShukei_Row createKyufuJissekiShukeiRow(
            String txtServiceShurui, String txtJitsuNissu, String txtKeikakuTani, String txtTaishoTani,
            String txtTaishogaiTani, String txtTankiKeikakuNissu, String txtHokenKohi, String txtKettei, String txtTankiJitsuNissu,
            String txtTaniGokei, String txtTaniTanka, String txtSeikyugaku, String txtRiyoshaFutangaku, String txtDekidakaTaniGokei,
            String txtDekidakaSeikyugaku, String txtDekidakaHonninFutangaku, String txtSaiShinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgKyufuJissekiShukei_Row(
                new RString(txtServiceShurui), new RString(txtJitsuNissu), new RString(txtKeikakuTani), new RString(txtTaishoTani),
                new RString(txtTaishogaiTani), new RString(txtTankiKeikakuNissu), new RString(txtHokenKohi), new RString(txtKettei), new RString(txtTankiJitsuNissu),
                new RString(txtTaniGokei), new RString(txtTaniTanka), new RString(txtSeikyugaku), new RString(txtRiyoshaFutangaku), new RString(txtDekidakaTaniGokei),
                new RString(txtDekidakaSeikyugaku), new RString(txtDekidakaHonninFutangaku), new RString(txtSaiShinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }

    private dgKyufuJissekiMeisai_Row createKyufuJissekiMeisaiRow(
            String txtService, String txtKettei, String txtTani, String txtKaisu,
            String txtKohi1Nissu, String txtKohi2Nissu, String txtKohi3Nissu, String txtServiceTani, String txtKohi1Tani,
            String txtKohi2Tani, String txtKohi3Tani, String txtSaiShinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgKyufuJissekiMeisai_Row(
                new RString(txtService), new Button(), new RString(txtKettei), new RString(txtTani), new RString(txtKaisu),
                new RString(txtKohi1Nissu), new RString(txtKohi2Nissu), new RString(txtKohi3Nissu), new RString(txtServiceTani), new RString(txtKohi1Tani),
                new RString(txtKohi2Tani), new RString(txtKohi3Tani), new RString(txtSaiShinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }

    private dgServiceKeikakuhiFromH2104_Row createServiceKeikakuhiFromH2104Row(
            String txtShiteiKijunGaitoJigyoshoKubun, String txtIraiTodokedeYMD, String txtService,
            String txtTaniTanka, String txtKettei, String txtMeisaiGokei, String txtTanisu, String txtKaisu, String txtServiceTanisu,
            String txtSeikyuKingaku, String txtTantoKaigoShienSenmoninNo, String txtSaishinsaKaisu, String txtKagoKaisu, String txtShinsaYM) {
        return new dgServiceKeikakuhiFromH2104_Row(
                new RString(txtShiteiKijunGaitoJigyoshoKubun), new RString(txtIraiTodokedeYMD), new RString(txtService),
                new RString(txtTaniTanka), new Button(), new RString(txtKettei), new RString(txtMeisaiGokei), new RString(txtTanisu), new RString(txtKaisu), new RString(txtServiceTanisu),
                new RString(txtSeikyuKingaku), new RString(txtTantoKaigoShienSenmoninNo), new RString(txtSaishinsaKaisu), new RString(txtKagoKaisu), new RString(txtShinsaYM));
    }

    private dgFukushiYoguKonyuhi_Row createFukushiYoguKonyuhiRow(
            String txtService, String txtKonyuYMD, String txtShohinName, String txtShumoku,
            String txtSeizoJigyoshaName, String txtHanbaiJigyoshaName, String txtKonyuKingaku, String txtShinsaYM) {
        return new dgFukushiYoguKonyuhi_Row(
                new RString(txtService), new Button(), new RString(txtKonyuYMD), new RString(txtShohinName), new RString(txtShumoku),
                new RString(txtSeizoJigyoshaName), new RString(txtHanbaiJigyoshaName), new RString(txtKonyuKingaku), new RString(txtShinsaYM));
    }

    private dgJutakuKaishuhi_Row createJutakuKaishuhiRow(
            String txtService, String txtChakkoYMD, String txtJigyoshaName, String txtJusho,
            String txtHiyo, String txtShinsaYM) {
        return new dgJutakuKaishuhi_Row(
                new RString(txtService), new RString(txtChakkoYMD), new RString(txtJigyoshaName), new RString(txtJusho),
                new RString(txtHiyo), new RString(txtShinsaYM));
    }
}
