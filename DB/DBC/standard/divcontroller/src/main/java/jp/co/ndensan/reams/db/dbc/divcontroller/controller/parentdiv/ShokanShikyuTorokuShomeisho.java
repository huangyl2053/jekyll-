/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoKihonKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoKihonKikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoKihonNyutaishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoShafukuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoShafukuListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoShafukuMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoShukeiDekidakaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoShukeiGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoShukeiHokenDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoShukeiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoShukeiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.ShokanShikyuTorokuShomeishoShukeiTankiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0800000.tabShokanShikyuTorokuShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.ServiceTeikyoShomeishoMeisaiList.ServiceTeikyoShomeishoMeisaiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.ServiceTeikyoShomeishoMeisaiList.dgServiceTeikyoShomeishoMeisaiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.ServiceTeikyoShomeishoShafukuList.dgServiceTeikyoShomeishoShafukuList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.ServiceTeikyoShomeishoShukeiList.dgServiceTeikyoShomeishoShukeiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 償還支給申請登録のサービス提供証明書情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuTorokuShomeisho {

    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_7 = 7;
    private static final int INDEX_37 = 37;
    private static final int INDEX_38 = 38;
    private static final int INDEX_40 = 40;
    private static final int INDEX_45 = 45;
    private static final int INDEX_46 = 46;
    private static final int INDEX_48 = 48;

    private enum 一覧明細表示 {

        一覧表示,
        明細表示,
    }

    private enum イベント {

        追加,
        選択
    }

    private List<HashMap> getShokanShikyuTorokuShomeishoYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0800000/ShokanShikyuTorokuShomeisho.yml"));
    }

    private HashMap getShokanShikyuTorokuShomeishoYamlId(int index) {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0800000/ShokanShikyuTorokuShomeisho.yml")).get(index);
    }

    /**
     * 支給申請書情報で証明書情報を追加するボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickAddShomeisho(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        tabVisible(panel);

// 南魚沼市のデモ向けに、基本情報」「給付費明細」「請求額集計」「社福系減額」以外のタブの機能をコメントアウト。
        setTopData(panel);
        setKihonData(panel);
        setKyufuhiListData(panel);
//        setRyoyoListData(panel);
//        setShinryoListData(panel);
//        setShokujiListData(panel);
//        setKeikakuData(panel);
        setShukeiListData(panel);
//        setNyushoListData(panel);
        setShafukuListData(panel);

// 南魚沼市のデモ向けに、基本情報」「給付費明細」「請求額集計」「社福系減額」以外のタブの機能をコメントアウト。
        showKihon(panel);
        showKyufuhi(panel, 一覧明細表示.一覧表示);
//        showRyoyo(panel, 一覧明細表示.一覧表示);
//        showShinryo(panel, 一覧明細表示.一覧表示);
//        showShokuji(panel, 一覧明細表示.一覧表示);
//        showKeikaku(panel, 一覧明細表示.一覧表示);
        showShukei(panel, 一覧明細表示.一覧表示);
//        showNyusho(panel, 一覧明細表示.一覧表示);
        showShafuku(panel, 一覧明細表示.一覧表示);

        response.data = panel;
        return response;
    }

    /**
     * 支給申請書情報の一覧で行を選択した時のサービス提供証明書情報パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onSelectedShomeishoList(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        tabVisible(panel);

// 南魚沼市のデモ向けに、基本情報」「給付費明細」「請求額集計」「社福系減額」以外のタブの機能をコメントアウト。
        setTopData(panel);
        setKihonData(panel);
        setKyufuhiListData(panel);
//        setRyoyoListData(panel);
//        setShinryoListData(panel);
//        setShokujiListData(panel);
//        setKeikakuData(panel);
        setShukeiListData(panel);
//        setNyushoListData(panel);
        setShafukuListData(panel);

// 南魚沼市のデモ向けに、基本情報」「給付費明細」「請求額集計」「社福系減額」以外のタブの機能をコメントアウト。
        showKihon(panel);
        showKyufuhi(panel, 一覧明細表示.一覧表示);
//        showRyoyo(panel, 一覧明細表示.一覧表示);
//        showShinryo(panel, 一覧明細表示.一覧表示);
//        showShokuji(panel, 一覧明細表示.一覧表示);
//        showKeikaku(panel, 一覧明細表示.一覧表示);
        showShukei(panel, 一覧明細表示.一覧表示);
//        showNyusho(panel, 一覧明細表示.一覧表示);
        showShafuku(panel, 一覧明細表示.一覧表示);

        response.data = panel;
        return response;
    }

    /**
     * 償還支給申請登録のタブの表示を切り替える。 南魚沼市のデモ向けに、以下のタブの固定表示で実装している。 [2131 訪問通所他]で表示する「基本情報」「給付費明細」「請求額集計」「社福系減額」。
     *
     * @param panel panel
     */
    private void tabVisible(ShokanShikyuTorokuShomeishoDiv panel) {
        tabShokanShikyuTorokuShomeishoDiv tab = panel.getTabShokanShikyuTorokuShomeisho();
        tab.getShokanShikyuTorokuShomeishoKihon().setVisible(true);
        tab.getShokanShikyuTorokuShomeishoMeisai().setVisible(true);
        tab.getShokanShikyuTorokuShomeishoRyoyo().setVisible(false);
        tab.getShokanShikyuTorokuShomeishoShinryo().setVisible(false);
        tab.getShokanShikyuTorokuShomeishoShokuji().setVisible(false);
        tab.getShokanShikyuTorokuShomeishoKeikaku().setVisible(false);
        tab.getShokanShikyuTorokuShomeishoShukei().setVisible(true);
        tab.getShokanShikyuTorokuShomeishoNyusho().setVisible(false);
        tab.getShokanShikyuTorokuShomeishoShafuku().setVisible(true);

    }

    private void setTopData(ShokanShikyuTorokuShomeishoDiv panel) {
        HashMap source = getShokanShikyuTorokuShomeishoYamlId(0);
        panel.getTxtShomeishoTeikyoYM().setValue(new RDate(source.get("提供年月").toString()));
        panel.getTxtShomeishoJigyoshaCode().setValue(new RString(source.get("事業者コード").toString()));
        panel.getTxtShomeishoJigyoshaName().setValue(new RString(source.get("事業者名").toString()));
        panel.getTxtShomeishoShinseiYMD().setValue(new RDate(source.get("申請日").toString()));
        panel.getTxtShomeishoShomeisho().setValue(new RString(source.get("証明書").toString()));
    }

    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから基本情報タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private enum 基本情報切替 {

        H2103(20090331),
        H2104(20090401);
        private final RDate date;

        private 基本情報切替(int dateString) {
            this.date = new RDate(dateString);
        }

        public RDate getDate() {
            return date;
        }
    }

    private void showKihon(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoKihonDiv kihon = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoKihon();
        ShokanShikyuTorokuShomeishoKihonKeikakuDiv keikaku = kihon.getShokanShikyuTorokuShomeishoKihonKeikaku();
        ShokanShikyuTorokuShomeishoKihonKikanDiv kikan = kihon.getShokanShikyuTorokuShomeishoKihonKikan();
        ShokanShikyuTorokuShomeishoKihonNyutaishoDiv nyutaisho = kihon.getShokanShikyuTorokuShomeishoKihonNyutaisho();

        RDate date = panel.getTxtShomeishoTeikyoYM().getValue();
        keikaku.setDisabled(false);
        if (date.isBefore(基本情報切替.H2104.getDate())) {
            kikan.setDisabled(false);
            nyutaisho.setDisabled(true);
        } else {
            kikan.setDisabled(true);
            nyutaisho.setDisabled(false);
        }
    }

    private void setKihonData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoKihonDiv kihon = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoKihon();
        ShokanShikyuTorokuShomeishoKihonKeikakuDiv keikaku = kihon.getShokanShikyuTorokuShomeishoKihonKeikaku();
        ShokanShikyuTorokuShomeishoKihonKikanDiv kikan = kihon.getShokanShikyuTorokuShomeishoKihonKikan();
        ShokanShikyuTorokuShomeishoKihonNyutaishoDiv nyutaisho = kihon.getShokanShikyuTorokuShomeishoKihonNyutaisho();

        HashMap source;
        RDate date = panel.getTxtShomeishoTeikyoYM().getValue();
        source = getShokanShikyuTorokuShomeishoYamlId(1);
        keikaku.getTxtShomeishoKihonJigyoshaCode().setValue(new RString(source.get("事業者コード").toString()));
        keikaku.getTxtShomeishoKihonJigyoshaName().setValue(new RString(source.get("事業者名").toString()));
        keikaku.getTxtShomeishoKihonKyufuritsu().setValue(new Decimal(source.get("保険給付率").toString()));
        if (date.isBefore(基本情報切替.H2104.getDate())) {
            source = getShokanShikyuTorokuShomeishoYamlId(2);
            kikan.getTxtShomeishoKihonKaishiYMD().setValue(new RDate(source.get("開始日").toString()));
            kikan.getTxtShomeishoKihonChushiYMD().setValue(new RDate(source.get("中止日").toString()));
        } else {
            source = getShokanShikyuTorokuShomeishoYamlId(INDEX_3);
            nyutaisho.getTxtShomeishoKihonNyushoYMD().setValue(new RDate(source.get("入所日").toString()));
            nyutaisho.getTxtShomeishoKihonTaishoYMD().setValue(new RDate(source.get("退所日").toString()));
            nyutaisho.getTxtShomeishoKihonNyushoNissu().setValue(new Decimal(source.get("入所実日数").toString()));
            nyutaisho.getTxtShomeishoKihonGaihakuNissu().setValue(new Decimal(source.get("外泊日数").toString()));
        }
    }
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで基本情報タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!

    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから給付費明細タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /**
     * サービス提供証明書情報の給付費明細タブで明細情報を追加するボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickAddKyufuhiMeisai(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        setKyufuhiMeisaiData(panel, イベント.追加);
        showKyufuhi(panel, 一覧明細表示.明細表示);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の給付費明細タブで、一覧から行を選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onSelectedKyufuhiList(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        setKyufuhiMeisaiData(panel, イベント.選択);
        showKyufuhi(panel, 一覧明細表示.明細表示);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の給付費明細タブで、一覧の行の削除ボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickKyufuhiListDelete(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        deleteKyufuhiListData(panel);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の給付費明細タブで入力内容を確定するボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickKyufuhiKakutei(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        kakuteiKyufuhiMeisaiData(panel);
        initKyufuhiMeisaiData(panel);
        showKyufuhi(panel, 一覧明細表示.一覧表示);
        response.data = panel;
        return response;
    }

    private void showKyufuhi(ShokanShikyuTorokuShomeishoDiv panel, 一覧明細表示 show) {
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoMeisai();
        if (show.equals(一覧明細表示.一覧表示)) {
            meisai.getShokanShikyuTorokuShomeishoMeisaiList().setIsOpen(true);
            meisai.getShokanShikyuTorokuShomeishoMeisaiMeisai().setIsOpen(false);
        } else if (show.equals(一覧明細表示.明細表示)) {
            meisai.getShokanShikyuTorokuShomeishoMeisaiList().setIsOpen(false);
            meisai.getShokanShikyuTorokuShomeishoMeisaiMeisai().setIsOpen(true);
        }
    }

    private void setKyufuhiListData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoMeisai();
        ServiceTeikyoShomeishoMeisaiListDiv meisaiList = meisai.getShokanShikyuTorokuShomeishoMeisaiList()
                .getShokanShikyuTorokuShomeishoMeisaiListInfo();
        DataGrid<dgServiceTeikyoShomeishoMeisaiList_Row> dgRow = meisaiList.getDgServiceTeikyoShomeishoMeisaiList();
        List<dgServiceTeikyoShomeishoMeisaiList_Row> dgRowList = dgRow.getDataSource();

        List<HashMap> sourceList = getShokanShikyuTorokuShomeishoYaml();
        dgRowList.clear();
        for (int i = INDEX_4; i < INDEX_7; i++) {
            dgRowList.add(create給付費明細一覧アイテム(
                    sourceList.get(i).get("サービス").toString(),
                    sourceList.get(i).get("単位数").toString(),
                    sourceList.get(i).get("日数回数").toString(),
                    sourceList.get(i).get("サービス単位数").toString(),
                    sourceList.get(i).get("摘要").toString()));
        }
        dgRow.setDataSource(dgRowList);
    }

    private void deleteKyufuhiListData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoMeisai();
        ServiceTeikyoShomeishoMeisaiListDiv meisaiList = meisai.getShokanShikyuTorokuShomeishoMeisaiList()
                .getShokanShikyuTorokuShomeishoMeisaiListInfo();
        DataGrid<dgServiceTeikyoShomeishoMeisaiList_Row> dgRow = meisaiList.getDgServiceTeikyoShomeishoMeisaiList();
        List<dgServiceTeikyoShomeishoMeisaiList_Row> dgRowList = dgRow.getDataSource();
        int index = dgRow.getClickedRowId();

        dgServiceTeikyoShomeishoMeisaiList_Row item = dgRow.getClickedItem();
        item.setRowState(RowState.Deleted);
        dgRowList.remove(index);
        dgRowList.add(index, item);

        dgRow.setDataSource(dgRowList);
    }

    private void setKyufuhiMeisaiData(ShokanShikyuTorokuShomeishoDiv panel, イベント event) {
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoMeisai();
        ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv meisaiMeisai = meisai.getShokanShikyuTorokuShomeishoMeisaiMeisai();
        if (event.equals(イベント.追加)) {
            meisaiMeisai.getTxtKyufuhiSelectedIndex().setValue(new RString("-1"));
        } else {
            int index = meisai.getShokanShikyuTorokuShomeishoMeisaiList().getShokanShikyuTorokuShomeishoMeisaiListInfo().
                    getDgServiceTeikyoShomeishoMeisaiList().getActiveRowId();
            meisaiMeisai.getTxtKyufuhiSelectedIndex().setValue(new RString(String.valueOf(index)));
        }
        HashMap source = getShokanShikyuTorokuShomeishoYamlId(INDEX_7);
        meisaiMeisai.getTxtKyufuhiShuruiCode().setValue(new RString(source.get("サービス種類コード").toString()));
        meisaiMeisai.getTxtKyufuhiServiceCode().setValue(new RString(source.get("サービスコード").toString()));
        meisaiMeisai.getTxtKyufuhiServiceName().setValue(new RString(source.get("サービス名称").toString()));
        meisaiMeisai.getTxtKyufuhiTanisu().setValue(new Decimal(source.get("単位数").toString()));
        meisaiMeisai.getTxtKyufuhiKaisuNissu().setValue(new Decimal(source.get("日数回数").toString()));
        meisaiMeisai.getTxtKyufuhiServiceTanisu().setValue(new Decimal(source.get("サービス単位数").toString()));
        meisaiMeisai.getTxtKyufuhiTekiyo().setValue(new RString(source.get("摘要").toString()));
    }

    private void initKyufuhiMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoMeisai();
        ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv meisaiMeisai = meisai.getShokanShikyuTorokuShomeishoMeisaiMeisai();
        meisaiMeisai.getTxtKyufuhiSelectedIndex().setValue(new RString("-1"));
        meisaiMeisai.getTxtKyufuhiShuruiCode().clearValue();
        meisaiMeisai.getTxtKyufuhiServiceCode().clearValue();
        meisaiMeisai.getTxtKyufuhiServiceName().clearValue();
        meisaiMeisai.getTxtKyufuhiTanisu().clearValue();
        meisaiMeisai.getTxtKyufuhiKaisuNissu().clearValue();
        meisaiMeisai.getTxtKyufuhiServiceTanisu().clearValue();
        meisaiMeisai.getTxtKyufuhiTekiyo().clearValue();
    }

    private void kakuteiKyufuhiMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoMeisai();
        ServiceTeikyoShomeishoMeisaiListDiv meisaiList = meisai.getShokanShikyuTorokuShomeishoMeisaiList()
                .getShokanShikyuTorokuShomeishoMeisaiListInfo();
        ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv meisaiMeisai = meisai.getShokanShikyuTorokuShomeishoMeisaiMeisai();

        DataGrid<dgServiceTeikyoShomeishoMeisaiList_Row> dgRow = meisaiList.getDgServiceTeikyoShomeishoMeisaiList();
        List<dgServiceTeikyoShomeishoMeisaiList_Row> dgRowList = dgRow.getDataSource();
        int index = Integer.parseInt(meisaiMeisai.getTxtKyufuhiSelectedIndex().getValue().toString());

        dgServiceTeikyoShomeishoMeisaiList_Row item = create給付費明細一覧アイテム(
                meisaiMeisai.getTxtKyufuhiShuruiCode().getValue().toString().concat(meisaiMeisai
                        .getTxtKyufuhiServiceCode().getValue().toString()).
                concat(":").concat(meisaiMeisai.getTxtKyufuhiServiceName().getValue().toString()),
                meisaiMeisai.getTxtKyufuhiTanisu().getValue().toString(),
                meisaiMeisai.getTxtKyufuhiKaisuNissu().getValue().toString(),
                meisaiMeisai.getTxtKyufuhiServiceTanisu().getValue().toString(),
                meisaiMeisai.getTxtKyufuhiTekiyo().getValue().toString());
        if (index == -1) {
            item.setRowState(RowState.Added);
            dgRowList.add(item);
        } else {
            item.setRowState(RowState.Modified);
            dgRowList.remove(index);
            dgRowList.add(index, item);
        }
        dgRow.setDataSource(dgRowList);
    }

    private dgServiceTeikyoShomeishoMeisaiList_Row create給付費明細一覧アイテム(
            String txtService,
            String txtTanisu,
            String txtNissuKaisu,
            String txtServiceTanisu,
            String txtTekiyo
    ) {
        Button btnSelect = new Button();
        Button btnEdit = new Button();
        Button btnDelete = new Button();

        return new dgServiceTeikyoShomeishoMeisaiList_Row(
                btnSelect,
                btnEdit,
                btnDelete,
                new RString(txtService),
                new RString(txtTanisu),
                new RString(txtNissuKaisu),
                new RString(txtServiceTanisu),
                new RString(txtTekiyo));
    }
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで給付費明細タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!

    /**
     * サービス提供証明書情報の請求額集計タブで明細情報を追加するボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickAddShukeiMeisai(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        setShukeiMeisaiData(panel, イベント.追加);
        showShukei(panel, 一覧明細表示.明細表示);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の請求額集計タブで、一覧から行を選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onSelectedShukeiList(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        setShukeiMeisaiData(panel, イベント.選択);
        showShukei(panel, 一覧明細表示.明細表示);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の請求額集計タブで、一覧の行の削除ボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickShukeiListDelete(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        deleteShukeiListData(panel);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の請求額集計タブで入力内容を確定するボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickShukeiKakutei(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        kakuteiShukeiMeisaiData(panel);
        initShukeiMeisaiData(panel);
        showShukei(panel, 一覧明細表示.一覧表示);
        response.data = panel;
        return response;
    }

    private void showShukei(ShokanShikyuTorokuShomeishoDiv panel, 一覧明細表示 show) {
        ShokanShikyuTorokuShomeishoShukeiDiv shukei = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoShukei();
        ShokanShikyuTorokuShomeishoShukeiListDiv list = shukei.getShokanShikyuTorokuShomeishoShukeiList();
        ShokanShikyuTorokuShomeishoShukeiMeisaiDiv meisai = shukei.getShokanShikyuTorokuShomeishoShukeiMeisai();
        if (show.equals(一覧明細表示.一覧表示)) {
            list.setIsOpen(true);
            meisai.setIsOpen(false);
        } else if (show.equals(一覧明細表示.明細表示)) {
            list.setIsOpen(false);
            meisai.setIsOpen(true);
        }
    }

    private void setShukeiListData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoShukeiDiv shukei = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoShukei();
        ShokanShikyuTorokuShomeishoShukeiListDiv list = shukei.getShokanShikyuTorokuShomeishoShukeiList();
        DataGrid<dgServiceTeikyoShomeishoShukeiList_Row> dgRow = list.getShokanShikyuTorokuShomeishoShukeiListInfo()
                .getDgServiceTeikyoShomeishoShukeiList();
        List<dgServiceTeikyoShomeishoShukeiList_Row> dgRowList = dgRow.getDataSource();

        List<HashMap> sourceList = getShokanShikyuTorokuShomeishoYaml();
        dgRowList.clear();
        for (int i = INDEX_37; i < INDEX_38; i++) {
            dgRowList.add(create請求額一覧アイテム(
                    sourceList.get(i).get("サービス種類").toString(),
                    sourceList.get(i).get("単位数合計").toString(),
                    sourceList.get(i).get("単位数単価").toString(),
                    sourceList.get(i).get("請求額").toString(),
                    sourceList.get(i).get("利用者負担額").toString(),
                    sourceList.get(i).get("審査方法").toString()
            ));
        }
        dgRow.setDataSource(dgRowList);
    }

    private void deleteShukeiListData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoShukeiDiv shukei = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoShukei();
        ShokanShikyuTorokuShomeishoShukeiListDiv list = shukei.getShokanShikyuTorokuShomeishoShukeiList();

        DataGrid<dgServiceTeikyoShomeishoShukeiList_Row> dgRow = list
                .getShokanShikyuTorokuShomeishoShukeiListInfo().getDgServiceTeikyoShomeishoShukeiList();
        List<dgServiceTeikyoShomeishoShukeiList_Row> dgRowList = dgRow.getDataSource();

        int index = dgRow.getClickedRowId();

        dgServiceTeikyoShomeishoShukeiList_Row item = dgRow.getClickedItem();
        item.setRowState(RowState.Deleted);
        dgRowList.remove(index);
        dgRowList.add(index, item);
        dgRow.setDataSource(dgRowList);
    }

    private void setShukeiMeisaiData(ShokanShikyuTorokuShomeishoDiv panel, イベント event) {
        ShokanShikyuTorokuShomeishoShukeiDiv shukei = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoShukei();
        ShokanShikyuTorokuShomeishoShukeiMeisaiDiv meisai = shukei.getShokanShikyuTorokuShomeishoShukeiMeisai();
        if (event.equals(イベント.追加)) {
            meisai.getTxtShukeiSelectedIndex().setValue(new RString("-1"));
        } else {
            int index = shukei.getShokanShikyuTorokuShomeishoShukeiList().getShokanShikyuTorokuShomeishoShukeiListInfo()
                    .getDgServiceTeikyoShomeishoShukeiList().getActiveRowId();
            meisai.getTxtShukeiSelectedIndex().setValue(new RString(String.valueOf(index)));
        }
        HashMap source = getShokanShikyuTorokuShomeishoYamlId(INDEX_40);
        meisai.getRadShukeiShinsaHoho().setSelectedItem(new RString("key0"));
        meisai.getTxtShukeiShuruiCode().setValue(new RString(source.get("サービス種類").toString()));
        meisai.getTxtShukeiShuruiName().setValue(new RString(source.get("サービス種類名").toString()));
        meisai.getTxtShukeiJitsuNissu().setValue(new Decimal(source.get("実日数").toString()));
        meisai.getTxtShukeiKyufuritsu().setValue(new Decimal(source.get("給付率").toString()));
        meisai.getTxtShukeiKeikakuTani().setValue(new Decimal(source.get("計画単位").toString()));

        ShokanShikyuTorokuShomeishoShukeiGendogakuDiv gendogaku = meisai.getShokanShikyuTorokuShomeishoShukeiGendogaku();
        gendogaku.getTxtShukeiGendoTaishoTani().setValue(new Decimal(source.get("限度額対象単位").toString()));
        gendogaku.getTxtShukeiGendoTaishogaiTani().setValue(new Decimal(source.get("限度額対象外単位").toString()));

        ShokanShikyuTorokuShomeishoShukeiTankiDiv tanki = meisai.getShokanShikyuTorokuShomeishoShukeiTanki();
        tanki.getTxtShukeiTankiKeikakuNissu().setValue(new Decimal(source.get("短期入所計画日数").toString()));
        tanki.getTxtShukeiTankiJitsuNissu().setValue(new Decimal(source.get("短期入所実日数").toString()));

        ShokanShikyuTorokuShomeishoShukeiHokenDiv hoken = meisai.getShokanShikyuTorokuShomeishoShukeiHoken();
        hoken.getTxtShukeiHokenTanisuGokei().setValue(new Decimal(source.get("保険分単位数合計").toString()));
        hoken.getTxtShukeiHokenTanisuTanka().setValue(new Decimal(source.get("保険分単位数単価").toString()));
        hoken.getTxtShukeiHokenSeikyugaku().setValue(new Decimal(source.get("保険分請求額").toString()));
        hoken.getTxtShukeiHokenRiyoshaFutangaku().setValue(new Decimal(source.get("保険分利用者負担額").toString()));

        ShokanShikyuTorokuShomeishoShukeiDekidakaDiv dekidaka = meisai.getShokanShikyuTorokuShomeishoShukeiDekidaka();
        dekidaka.getTxtShukeiDekidakaTanisuGokei().setValue(new Decimal(source.get("出来高分単位数合計").toString()));
        dekidaka.getTxtShukeiDekidakaTanisuTanka().setValue(new Decimal(source.get("出来高分単位数単価").toString()));
        dekidaka.getTxtShukeiDekidakaSeikyugaku().setValue(new Decimal(source.get("出来高分請求額").toString()));
        dekidaka.getTxtShukeiDekidakaRiyoshaFutangaku().setValue(new Decimal(source.get("出来高分利用者負担額").toString()));
    }

    private void initShukeiMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoShukeiDiv shukei = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoShukei();
        ShokanShikyuTorokuShomeishoShukeiMeisaiDiv meisai = shukei.getShokanShikyuTorokuShomeishoShukeiMeisai();
        meisai.getTxtShukeiSelectedIndex().setValue(new RString("-1"));

        meisai.getRadShukeiShinsaHoho().setSelectedItem(new RString(""));
        meisai.getTxtShukeiShuruiCode().clearValue();
        meisai.getTxtShukeiShuruiName().clearValue();
        meisai.getTxtShukeiJitsuNissu().clearValue();
        meisai.getTxtShukeiKyufuritsu().clearValue();
        meisai.getTxtShukeiKeikakuTani().clearValue();

        ShokanShikyuTorokuShomeishoShukeiGendogakuDiv gendogaku = meisai.getShokanShikyuTorokuShomeishoShukeiGendogaku();
        gendogaku.getTxtShukeiGendoTaishoTani().clearValue();
        gendogaku.getTxtShukeiGendoTaishogaiTani().clearValue();

        ShokanShikyuTorokuShomeishoShukeiTankiDiv tanki = meisai.getShokanShikyuTorokuShomeishoShukeiTanki();
        tanki.getTxtShukeiTankiKeikakuNissu().clearValue();
        tanki.getTxtShukeiTankiKeikakuNissu().clearValue();

        ShokanShikyuTorokuShomeishoShukeiHokenDiv hoken = meisai.getShokanShikyuTorokuShomeishoShukeiHoken();
        hoken.getTxtShukeiHokenTanisuGokei().clearValue();
        hoken.getTxtShukeiHokenTanisuTanka().clearValue();
        hoken.getTxtShukeiHokenSeikyugaku().clearValue();
        hoken.getTxtShukeiHokenRiyoshaFutangaku().clearValue();

        ShokanShikyuTorokuShomeishoShukeiDekidakaDiv dekidaka = meisai.getShokanShikyuTorokuShomeishoShukeiDekidaka();
        dekidaka.getTxtShukeiDekidakaTanisuGokei().clearValue();
        dekidaka.getTxtShukeiDekidakaTanisuTanka().clearValue();
        dekidaka.getTxtShukeiDekidakaSeikyugaku().clearValue();
        dekidaka.getTxtShukeiDekidakaRiyoshaFutangaku().clearValue();
    }

    private void kakuteiShukeiMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoShukeiDiv shukei = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoShukei();
        ShokanShikyuTorokuShomeishoShukeiListDiv list = shukei.getShokanShikyuTorokuShomeishoShukeiList();
        ShokanShikyuTorokuShomeishoShukeiMeisaiDiv meisai = shukei.getShokanShikyuTorokuShomeishoShukeiMeisai();

        int index = Integer.parseInt(meisai.getTxtShukeiSelectedIndex().getValue().toString());

        DataGrid<dgServiceTeikyoShomeishoShukeiList_Row> dgRow = list.getShokanShikyuTorokuShomeishoShukeiListInfo()
                .getDgServiceTeikyoShomeishoShukeiList();
        List<dgServiceTeikyoShomeishoShukeiList_Row> dgRowList = dgRow.getDataSource();

        ShokanShikyuTorokuShomeishoShukeiHokenDiv hoken = meisai.getShokanShikyuTorokuShomeishoShukeiHoken();
        dgServiceTeikyoShomeishoShukeiList_Row item = create請求額一覧アイテム(
                meisai.getTxtShukeiShuruiCode().getValue().toString().
                concat(":").
                concat(meisai.getTxtShukeiShuruiName().getValue().toString()),
                hoken.getTxtShukeiHokenTanisuGokei().getValue().toString(),
                hoken.getTxtShukeiHokenTanisuTanka().getValue().toString(),
                hoken.getTxtShukeiHokenSeikyugaku().getValue().toString(),
                hoken.getTxtShukeiHokenRiyoshaFutangaku().getValue().toString(),
                meisai.getRadShukeiShinsaHoho().getSelectedValue().toString());
        if (index == -1) {
            item.setRowState(RowState.Added);
            dgRowList.add(item);
        } else {
            item.setRowState(RowState.Modified);
            dgRowList.remove(index);
            dgRowList.add(index, item);
        }
        dgRow.setDataSource(dgRowList);
    }

    private dgServiceTeikyoShomeishoShukeiList_Row create請求額一覧アイテム(
            String txtServiceShurui,
            String txtTanisuGokei,
            String txtTanisuTanka,
            String txtSeikyugaku,
            String txtRiyoshaFutangaku,
            String txtShinsaHoho
    ) {
        Button btnSelect = new Button();
        Button btnEdit = new Button();
        Button btnDelete = new Button();

        return new dgServiceTeikyoShomeishoShukeiList_Row(
                btnSelect,
                btnEdit,
                btnDelete,
                new RString(txtServiceShurui),
                new RString(txtTanisuGokei),
                new RString(txtTanisuTanka),
                new RString(txtSeikyugaku),
                new RString(txtRiyoshaFutangaku),
                new RString(txtShinsaHoho));
    }
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで請求額集計タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!

// 南魚沼市のデモ向けに、基本情報」「給付費明細」「請求額集計」「社福系減額」以外のタブの機能をコメントアウト。
//    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから特定入所者費用タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    /**
//     * サービス提供証明書情報の特定入所者費用タブで明細情報を追加するボタンを押下したときの処理です。
//     *
//     * @param panel panel
//     * @return ResponseData
//     */
//    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickAddNyushoMeisai(ShokanShikyuTorokuShomeishoDiv panel) {
//        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();
//
//        setNyushoMeisaiData(panel, イベント.追加);
//        showNyusho(panel, 一覧明細表示.明細表示);
//        response.data = panel;
//        return response;
//    }
//
//    /**
//     * サービス提供証明書情報の特定入所者費用タブで、一覧から行を選択したときの処理です。
//     *
//     * @param panel panel
//     * @return ResponseData
//     */
//    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onSelectedNyushoList(ShokanShikyuTorokuShomeishoDiv panel) {
//        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();
//
//        setNyushoMeisaiData(panel, イベント.選択);
//        showNyusho(panel, 一覧明細表示.明細表示);
//        response.data = panel;
//        return response;
//    }
//
//    /**
//     * サービス提供証明書情報の特定入所者費用タブで、一覧の行の削除ボタンを押下したときの処理です。
//     *
//     * @param panel panel
//     * @return ResponseData
//     */
//    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickNyushoListDelete(ShokanShikyuTorokuShomeishoDiv panel) {
//        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();
//
//        deleteNyushoListData(panel);
//        response.data = panel;
//        return response;
//    }
//
//    /**
//     * サービス提供証明書情報の特定入所者費用タブで入力内容を確定するボタンを押下したときの処理です。
//     *
//     * @param panel panel
//     * @return ResponseData
//     */
//    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickNyushoKakutei(ShokanShikyuTorokuShomeishoDiv panel) {
//        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();
//
//        kakuteiNyushoMeisaiData(panel);
//        initNyushoMeisaiData(panel);
//        showNyusho(panel, 一覧明細表示.一覧表示);
//        response.data = panel;
//        return response;
//    }
//
//    private void showNyusho(ShokanShikyuTorokuShomeishoDiv panel, 一覧明細表示 show) {
//        ShokanShikyuTorokuShomeishoNyushoDiv nyusho = panel
//                .getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoNyusho();
//        ShokanShikyuTorokuShomeishoNyushoListDiv list = nyusho.getShokanShikyuTorokuShomeishoNyushoList();
//        ShokanShikyuTorokuShomeishoNyushoMeisaiDiv meisai = nyusho.getShokanShikyuTorokuShomeishoNyushoMeisai();
//
//        if (show.equals(一覧明細表示.一覧表示)) {
//            list.setIsOpen(true);
//            meisai.setIsOpen(false);
//        } else if (show.equals(一覧明細表示.明細表示)) {
//            list.setIsOpen(false);
//            meisai.setIsOpen(true);
//        }
//    }
//
//    private void setNyushoListData(ShokanShikyuTorokuShomeishoDiv panel) {
//        ShokanShikyuTorokuShomeishoNyushoDiv nyusho = panel.getTabShokanShikyuTorokuShomeisho()
//                .getShokanShikyuTorokuShomeishoNyusho();
//        ShokanShikyuTorokuShomeishoNyushoListDiv list = nyusho.getShokanShikyuTorokuShomeishoNyushoList();
//        DataGrid<dgServiceTeikyoShomeishoNyushoList_Row> dgRow = list
//                .getShokanShikyuTorokuShomeishoNyushoListInfo().getDgServiceTeikyoShomeishoNyushoList();
//        List<dgServiceTeikyoShomeishoNyushoList_Row> dgRowList = dgRow.getDataSource();
//
//        List<HashMap> sourceList = getShokanShikyuTorokuShomeishoYaml();
//        dgRowList.clear();
//        for (int i = 41; i < 42; i++) {
//            dgRowList.add(create特定入所者費用一覧アイテム(
//                    sourceList.get(i).get("サービス").toString(),
//                    sourceList.get(i).get("費用単価").toString(),
//                    sourceList.get(i).get("負担限度額").toString(),
//                    sourceList.get(i).get("日数").toString(),
//                    sourceList.get(i).get("費用額").toString(),
//                    sourceList.get(i).get("保険分請求額").toString(),
//                    sourceList.get(i).get("利用者負担額").toString()
//            ));
//        }
//        dgRow.setDataSource(dgRowList);
//    }
//
//    private void deleteNyushoListData(ShokanShikyuTorokuShomeishoDiv panel) {
//        ShokanShikyuTorokuShomeishoNyushoDiv nyusho = panel.getTabShokanShikyuTorokuShomeisho()
//                .getShokanShikyuTorokuShomeishoNyusho();
//        ShokanShikyuTorokuShomeishoNyushoListDiv list = nyusho.getShokanShikyuTorokuShomeishoNyushoList();
//
//        DataGrid<dgServiceTeikyoShomeishoNyushoList_Row> dgRow = list
//                .getShokanShikyuTorokuShomeishoNyushoListInfo().getDgServiceTeikyoShomeishoNyushoList();
//        List<dgServiceTeikyoShomeishoNyushoList_Row> dgRowList = dgRow.getDataSource();
//
//        int index = dgRow.getClickedRowId();
//
//        dgServiceTeikyoShomeishoNyushoList_Row item = dgRow.getClickedItem();
//        item.setRowState(RowState.Deleted);
//        dgRowList.remove(index);
//        dgRowList.add(index, item);
//        dgRow.setDataSource(dgRowList);
//    }
//
//    private void setNyushoMeisaiData(ShokanShikyuTorokuShomeishoDiv panel, イベント event) {
//        ShokanShikyuTorokuShomeishoNyushoDiv nyusho = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoNyusho();
//        ShokanShikyuTorokuShomeishoNyushoMeisaiDiv meisai = nyusho.getShokanShikyuTorokuShomeishoNyushoMeisai();
//        if (event.equals(イベント.追加)) {
//            meisai.getTxtNyushoSelectedIndex().setValue(new RString("-1"));
//        } else {
//            int index = nyusho.getShokanShikyuTorokuShomeishoNyushoList().getShokanShikyuTorokuShomeishoNyushoListInfo()
//                    .getDgServiceTeikyoShomeishoNyushoList().getActiveRowId();
//            meisai.getTxtNyushoSelectedIndex().setValue(new RString(String.valueOf(index)));
//        }
//        HashMap source = getShokanShikyuTorokuShomeishoYamlId(44);
//        meisai.getTxtNyushohiShuruiCode().setValue(new RString(source.get("サービス種類コード").toString()));
//        meisai.getTxtNyushohiServiceCode().setValue(new RString(source.get("サービスコード").toString()));
//        meisai.getTxtNyushohiServiceName().setValue(new RString(source.get("サービス名").toString()));
//        meisai.getTxtNyushohiHiyoTanka().setValue(new Decimal(source.get("費用単価").toString()));
//        meisai.getTxtNyushohiFutanGendogaku().setValue(new Decimal(source.get("負担限度額").toString()));
//        meisai.getTxtNyushohiNissu().setValue(new Decimal(source.get("日数").toString()));
//        meisai.getTxtNyushohiHiyogaku().setValue(new Decimal(source.get("費用額").toString()));
//        meisai.getTxtNyushohiHokengaku().setValue(new Decimal(source.get("保険分請求額").toString()));
//        meisai.getTxtNyushohiFutangaku().setValue(new Decimal(source.get("利用者負担額").toString()));
//    }
//
//    private void initNyushoMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
//        ShokanShikyuTorokuShomeishoNyushoDiv nyusho = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoNyusho();
//        ShokanShikyuTorokuShomeishoNyushoMeisaiDiv meisai = nyusho.getShokanShikyuTorokuShomeishoNyushoMeisai();
//        meisai.getTxtNyushoSelectedIndex().setValue(new RString("-1"));
//
//        meisai.getTxtNyushohiShuruiCode().clearValue();
//        meisai.getTxtNyushohiServiceCode().clearValue();
//        meisai.getTxtNyushohiServiceName().clearValue();
//        meisai.getTxtNyushohiHiyoTanka().clearValue();
//        meisai.getTxtNyushohiFutangaku().clearValue();
//        meisai.getTxtNyushohiNissu().clearValue();
//        meisai.getTxtNyushohiHiyogaku().clearValue();
//        meisai.getTxtNyushohiHokengaku().clearValue();
//        meisai.getTxtNyushohiFutangaku().clearValue();
//    }
//
//    private void kakuteiNyushoMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
//        ShokanShikyuTorokuShomeishoNyushoDiv nyusho = panel.getTabShokanShikyuTorokuShomeisho()
//                .getShokanShikyuTorokuShomeishoNyusho();
//        ShokanShikyuTorokuShomeishoNyushoListDiv list = nyusho.getShokanShikyuTorokuShomeishoNyushoList();
//        ShokanShikyuTorokuShomeishoNyushoMeisaiDiv meisai = nyusho.getShokanShikyuTorokuShomeishoNyushoMeisai();
//
//        int index = Integer.parseInt(meisai.getTxtNyushoSelectedIndex().getValue().toString());
//
//        DataGrid<dgServiceTeikyoShomeishoNyushoList_Row> dgRow = list
//                .getShokanShikyuTorokuShomeishoNyushoListInfo().getDgServiceTeikyoShomeishoNyushoList();
//        List<dgServiceTeikyoShomeishoNyushoList_Row> dgRowList = dgRow.getDataSource();
//
//        dgServiceTeikyoShomeishoNyushoList_Row item = create特定入所者費用一覧アイテム(
//                meisai.getTxtNyushohiShuruiCode().getValue().toString().
//                concat(meisai.getTxtNyushohiServiceCode().getValue().toString()).
//                concat(":").
//                concat(meisai.getTxtNyushohiServiceName().getValue().toString()),
//                meisai.getTxtNyushohiHiyoTanka().getValue().toString(),
//                meisai.getTxtNyushohiFutanGendogaku().getValue().toString(),
//                meisai.getTxtNyushohiNissu().getValue().toString(),
//                meisai.getTxtNyushohiHiyogaku().getValue().toString(),
//                meisai.getTxtNyushohiHokengaku().getValue().toString(),
//                meisai.getTxtNyushohiFutangaku().getValue().toString());
//        if (index == -1) {
//            item.setRowState(RowState.Added);
//            dgRowList.add(item);
//        } else {
//            item.setRowState(RowState.Modified);
//            dgRowList.remove(index);
//            dgRowList.add(index, item);
//        }
//        dgRow.setDataSource(dgRowList);
//    }
//
//    private dgServiceTeikyoShomeishoNyushoList_Row create特定入所者費用一覧アイテム(
//            String txtService,
//            String txtHiyoTanka,
//            String txtFutanGendogaku,
//            String txtNissu,
//            String txtHiyogaku,
//            String txtHokengaku,
//            String txtRiyoshaFutangaku
//    ) {
//        Button btnSelect = new Button();
//        Button btnEdit = new Button();
//        Button btnDelete = new Button();
//
//        return new dgServiceTeikyoShomeishoNyushoList_Row(
//                btnSelect,
//                btnEdit,
//                btnDelete,
//                new RString(txtService),
//                new RString(txtHiyoTanka),
//                new RString(txtFutanGendogaku),
//                new RString(txtNissu),
//                new RString(txtHiyogaku),
//                new RString(txtHokengaku),
//                new RString(txtRiyoshaFutangaku));
//    }
//    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで特定入所者費用タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから社福軽減額タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
    /**
     * サービス提供証明書情報の社福軽減額タブで明細情報を追加するボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickAddShafukuMeisai(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        setShafukuMeisaiData(panel, イベント.追加);
        showShafuku(panel, 一覧明細表示.明細表示);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の社福軽減額タブで、一覧から行を選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onSelectedShafukuList(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        setShafukuMeisaiData(panel, イベント.選択);
        showShafuku(panel, 一覧明細表示.明細表示);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の社福軽減額タブで、一覧の行の削除ボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickShafukuListDelete(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        deleteShafukuListData(panel);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の社福軽減額タブで入力内容を確定するボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickShafukuKakutei(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        kakuteiShafukuMeisaiData(panel);
        initShafukuMeisaiData(panel);
        showShafuku(panel, 一覧明細表示.一覧表示);
        response.data = panel;
        return response;
    }

    private void showShafuku(ShokanShikyuTorokuShomeishoDiv panel, 一覧明細表示 show) {
        ShokanShikyuTorokuShomeishoShafukuDiv shafuku = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoShafuku();
        ShokanShikyuTorokuShomeishoShafukuListDiv list = shafuku.getShokanShikyuTorokuShomeishoShafukuList();
        ShokanShikyuTorokuShomeishoShafukuMeisaiDiv meisai = shafuku.getShokanShikyuTorokuShomeishoShafukuMeisai();

        if (show.equals(一覧明細表示.一覧表示)) {
            list.setIsOpen(true);
            meisai.setIsOpen(false);
        } else if (show.equals(一覧明細表示.明細表示)) {
            list.setIsOpen(false);
            meisai.setIsOpen(true);
        }
    }

    private void setShafukuListData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoShafukuDiv shafuku = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoShafuku();
        ShokanShikyuTorokuShomeishoShafukuListDiv list = shafuku.getShokanShikyuTorokuShomeishoShafukuList();
        DataGrid<dgServiceTeikyoShomeishoShafukuList_Row> dgRow = list.getShokanShikyuTorokuShomeishoShafukuListInfo()
                .getDgServiceTeikyoShomeishoShafukuList();
        List<dgServiceTeikyoShomeishoShafukuList_Row> dgRowList = dgRow.getDataSource();

        List<HashMap> sourceList = getShokanShikyuTorokuShomeishoYaml();
        dgRowList.clear();
        for (int i = INDEX_45; i < INDEX_46; i++) {
            dgRowList.add(create社福軽減額一覧アイテム(
                    sourceList.get(i).get("サービス種類").toString(),
                    sourceList.get(i).get("軽減率").toString(),
                    sourceList.get(i).get("受領すべき利用者負担の総額").toString(),
                    sourceList.get(i).get("軽減額").toString(),
                    sourceList.get(i).get("軽減後利用者負担額").toString(),
                    sourceList.get(i).get("備考").toString()));
        }
        dgRow.setDataSource(dgRowList);
    }

    private void deleteShafukuListData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoShafukuDiv shafuku = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoShafuku();
        ShokanShikyuTorokuShomeishoShafukuListDiv list = shafuku.getShokanShikyuTorokuShomeishoShafukuList();

        DataGrid<dgServiceTeikyoShomeishoShafukuList_Row> dgRow = list
                .getShokanShikyuTorokuShomeishoShafukuListInfo().getDgServiceTeikyoShomeishoShafukuList();
        List<dgServiceTeikyoShomeishoShafukuList_Row> dgRowList = dgRow.getDataSource();

        int index = dgRow.getClickedRowId();

        dgServiceTeikyoShomeishoShafukuList_Row item = dgRow.getClickedItem();
        item.setRowState(RowState.Deleted);
        dgRowList.remove(index);
        dgRowList.add(index, item);
        dgRow.setDataSource(dgRowList);
    }

    private void setShafukuMeisaiData(ShokanShikyuTorokuShomeishoDiv panel, イベント event) {
        ShokanShikyuTorokuShomeishoShafukuDiv shafuku = panel
                .getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoShafuku();
        ShokanShikyuTorokuShomeishoShafukuMeisaiDiv meisai = shafuku.getShokanShikyuTorokuShomeishoShafukuMeisai();
        if (event.equals(イベント.追加)) {
            meisai.getTxtShafukuSelectedIndex().setValue(new RString("-1"));
        } else {
            int index = shafuku.getShokanShikyuTorokuShomeishoShafukuList()
                    .getShokanShikyuTorokuShomeishoShafukuListInfo().getDgServiceTeikyoShomeishoShafukuList().getActiveRowId();
            meisai.getTxtShafukuSelectedIndex().setValue(new RString(String.valueOf(index)));
        }
        HashMap source = getShokanShikyuTorokuShomeishoYamlId(INDEX_48);
        meisai.getTxtShafukugakuFutanSogaku().setValue(new Decimal(source.get("受領すべき利用者負担の総額").toString()));
        meisai.getTxtShafukugakuKeigengaku().setValue(new Decimal(source.get("軽減額").toString()));
        meisai.getTxtShafukugakuKeigengoFutangaku().setValue(new Decimal(source.get("軽減後利用者負担額").toString()));
        meisai.getTxtShafukugakuBiko().setValue(new RString(source.get("備考").toString()));
    }

    private void initShafukuMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoShafukuDiv shafuku = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoShafuku();
        ShokanShikyuTorokuShomeishoShafukuMeisaiDiv meisai = shafuku.getShokanShikyuTorokuShomeishoShafukuMeisai();
        meisai.getTxtShafukuSelectedIndex().setValue(new RString("-1"));

        meisai.getTxtShafukugakuFutanSogaku().clearValue();
        meisai.getTxtShafukugakuKeigengaku().clearValue();
        meisai.getTxtShafukugakuKeigengoFutangaku().clearValue();
        meisai.getTxtShafukugakuBiko().clearValue();
    }

    private void kakuteiShafukuMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoShafukuDiv shafuku = panel.getTabShokanShikyuTorokuShomeisho()
                .getShokanShikyuTorokuShomeishoShafuku();
        ShokanShikyuTorokuShomeishoShafukuListDiv list = shafuku.getShokanShikyuTorokuShomeishoShafukuList();
        ShokanShikyuTorokuShomeishoShafukuMeisaiDiv meisai = shafuku.getShokanShikyuTorokuShomeishoShafukuMeisai();

        int index = Integer.parseInt(meisai.getTxtShafukuSelectedIndex().getValue().toString());

        DataGrid<dgServiceTeikyoShomeishoShafukuList_Row> dgRow = list.getShokanShikyuTorokuShomeishoShafukuListInfo()
                .getDgServiceTeikyoShomeishoShafukuList();
        List<dgServiceTeikyoShomeishoShafukuList_Row> dgRowList = dgRow.getDataSource();

        dgServiceTeikyoShomeishoShafukuList_Row item = create社福軽減額一覧アイテム(
                meisai.getDdlShafukugakuShurui().getSelectedValue().toString(),
                meisai.getDdlShafukugakuKeigenritsu().getSelectedValue().toString(),
                meisai.getTxtShafukugakuFutanSogaku().getValue().toString(),
                meisai.getTxtShafukugakuKeigengaku().getValue().toString(),
                meisai.getTxtShafukugakuKeigengoFutangaku().getValue().toString(),
                meisai.getTxtShafukugakuBiko().getValue().toString());
        if (index == -1) {
            item.setRowState(RowState.Added);
            dgRowList.add(item);
        } else {
            item.setRowState(RowState.Modified);
            dgRowList.remove(index);
            dgRowList.add(index, item);
        }
        dgRow.setDataSource(dgRowList);
    }

    private dgServiceTeikyoShomeishoShafukuList_Row create社福軽減額一覧アイテム(
            String txtShurui,
            String txtKeigenritsu,
            String txtFutanSogaku,
            String txtKeigengaku,
            String txtKeigengoRiyoshaFutangaku,
            String txtBiko
    ) {
        Button btnSelect = new Button();
        Button btnEdit = new Button();
        Button btnDelete = new Button();

        return new dgServiceTeikyoShomeishoShafukuList_Row(
                btnSelect,
                btnEdit,
                btnDelete,
                new RString(txtShurui),
                new RString(txtKeigenritsu),
                new RString(txtFutanSogaku),
                new RString(txtKeigengaku),
                new RString(txtKeigengoRiyoshaFutangaku),
                new RString(txtBiko));
    }
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで社福軽減額タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!
}
