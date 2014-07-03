/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoKihonKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoKihonKikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoKihonNyutaishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoShafukuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.ShokanShikyuKetteiShomeishoShukeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000.tabShokanShikyuKetteiShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoMeisaiList.ServiceTeikyoShomeishoMeisaiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoMeisaiList.dgServiceTeikyoShomeishoMeisaiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShafukuList.ServiceTeikyoShomeishoShafukuListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShafukuList.dgServiceTeikyoShomeishoShafukuList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShukeiList.ServiceTeikyoShomeishoShukeiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShukeiList.dgServiceTeikyoShomeishoShukeiList_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 償還支給申請決定のサービス提供証明書情報のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class ShokanShikyuKetteiShomeisho {

    private enum 一覧明細表示 {

        一覧表示,
        明細表示,
    }

    private enum イベント {

        追加,
        選択
    }

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0800000/ShokanShikyuTorokuShomeisho.yml"));
    }

    /**
     * 支給申請書情報の一覧で行を選択した時のサービス提供証明書情報パネルの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuKetteiShomeishoDiv> onSelectedShomeishoList(ShokanShikyuKetteiShomeishoDiv panel) {
        ResponseData<ShokanShikyuKetteiShomeishoDiv> response = new ResponseData<>();

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
//        showKyufuhi(panel, 一覧明細表示.一覧表示);
//        showRyoyo(panel, 一覧明細表示.一覧表示);
//        showShinryo(panel, 一覧明細表示.一覧表示);
//        showShokuji(panel, 一覧明細表示.一覧表示);
//        showKeikaku(panel, 一覧明細表示.一覧表示);
//        showShukei(panel, 一覧明細表示.一覧表示);
//        showNyusho(panel, 一覧明細表示.一覧表示);
//        showShafuku(panel, 一覧明細表示.一覧表示);

        response.data = panel;
        return response;
    }

    /**
     * 償還支給申請登録のタブの表示を切り替える。 南魚沼市のデモ向けに、以下のタブの固定表示で実装している。 [2131
     * 訪問通所他]で表示する「基本情報」「給付費明細」「請求額集計」「社福系減額」。
     *
     * @param panel panel
     */
    private void tabVisible(ShokanShikyuKetteiShomeishoDiv panel) {
        tabShokanShikyuKetteiShomeishoDiv tab = panel.getTabShokanShikyuKetteiShomeisho();
        tab.getShokanShikyuKetteiShomeishoKihon().setVisible(true);
        tab.getShokanShikyuKetteiShomeishoMeisai().setVisible(true);
        tab.getShokanShikyuKetteiShomeishoRyoyo().setVisible(false);
        tab.getShokanShikyuKetteiShomeishoShinryo().setVisible(false);
        tab.getShokanShikyuKetteiShomeishoShokuji().setVisible(false);
        tab.getShokanShikyuKetteiShomeishoKeikaku().setVisible(false);
        tab.getShokanShikyuKetteiShomeishoShukei().setVisible(true);
        tab.getShokanShikyuKetteiShomeishoNyusho().setVisible(false);
        tab.getShokanShikyuKetteiShomeishoShafuku().setVisible(true);

    }

    private void setTopData(ShokanShikyuKetteiShomeishoDiv panel) {
        HashMap source = getYaml().get(0);
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

    private void showKihon(ShokanShikyuKetteiShomeishoDiv panel) {
        ShokanShikyuKetteiShomeishoKihonDiv kihon = panel.getTabShokanShikyuKetteiShomeisho()
                .getShokanShikyuKetteiShomeishoKihon();
        ShokanShikyuKetteiShomeishoKihonKeikakuDiv keikaku = kihon.getShokanShikyuKetteiShomeishoKihonKeikaku();
        ShokanShikyuKetteiShomeishoKihonKikanDiv kikan = kihon.getShokanShikyuKetteiShomeishoKihonKikan();
        ShokanShikyuKetteiShomeishoKihonNyutaishoDiv nyutaisho = kihon.getShokanShikyuKetteiShomeishoKihonNyutaisho();

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

    private void setKihonData(ShokanShikyuKetteiShomeishoDiv panel) {
        ShokanShikyuKetteiShomeishoKihonDiv kihon = panel.getTabShokanShikyuKetteiShomeisho().getShokanShikyuKetteiShomeishoKihon();
        ShokanShikyuKetteiShomeishoKihonKeikakuDiv keikaku = kihon.getShokanShikyuKetteiShomeishoKihonKeikaku();
        ShokanShikyuKetteiShomeishoKihonKikanDiv kikan = kihon.getShokanShikyuKetteiShomeishoKihonKikan();
        ShokanShikyuKetteiShomeishoKihonNyutaishoDiv nyutaisho = kihon.getShokanShikyuKetteiShomeishoKihonNyutaisho();

        HashMap source = getYaml().get(1);
        RDate date = panel.getTxtShomeishoTeikyoYM().getValue();
        keikaku.getTxtShomeishoKihonSakuseiKubun().setValue(new RString(source.get("計画作成区分").toString()));
        keikaku.getTxtShomeishoKihonTokurei().setValue(new RString(source.get("旧措置入所者特例").toString()));
        keikaku.getTxtShomeishoKihonJigyoshaCode().setValue(new RString(source.get("事業者コード").toString()));
        keikaku.getTxtShomeishoKihonJigyoshaName().setValue(new RString(source.get("事業者名").toString()));
        keikaku.getTxtShomeishoKihonKyufuritsu().setValue(new Decimal(source.get("保険給付率").toString()));
        if (date.isBefore(基本情報切替.H2104.getDate())) {
            source = getYaml().get(2);
            kikan.getTxtShomeishoKihonKaishiYMD().setValue(new RDate(source.get("開始日").toString()));
            kikan.getTxtShomeishoKihonChushiYMD().setValue(new RDate(source.get("中止日").toString()));
        } else {
            source = getYaml().get(3);
            nyutaisho.getTxtShomeishoKihonNyushoYMD().setValue(new RDate(source.get("入所日").toString()));
            nyutaisho.getTxtShomeishoKihonTaishoYMD().setValue(new RDate(source.get("退所日").toString()));
            nyutaisho.getTxtShomeishoKihonNyushoNissu().setValue(new Decimal(source.get("入所実日数").toString()));
            nyutaisho.getTxtShomeishoKihonGaihakuNissu().setValue(new Decimal(source.get("外泊日数").toString()));
            nyutaisho.getTxtShomeishoKihonNyushoMaeJokyo().setValue(new RString(source.get("入所前の状況").toString()));
            nyutaisho.getTxtShomeishoKihonTaishoGoJokyo().setValue(new RString(source.get("入所後の状況").toString()));
        }
    }
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで基本情報タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!

    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから給付費明細タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private void setKyufuhiListData(ShokanShikyuKetteiShomeishoDiv panel) {
        ShokanShikyuKetteiShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuKetteiShomeisho()
                .getShokanShikyuKetteiShomeishoMeisai();
        ServiceTeikyoShomeishoMeisaiListDiv meisaiList = meisai.getShokanShikyuKetteiShomeishoMeisaiListInfo();
        DataGrid<dgServiceTeikyoShomeishoMeisaiList_Row> dgRow = meisaiList.getDgServiceTeikyoShomeishoMeisaiList();
        List<dgServiceTeikyoShomeishoMeisaiList_Row> dgRowList = dgRow.getDataSource();

        List<HashMap> sourceList = getYaml();
        dgRowList.clear();
        for (int i = 4; i < 7; i++) {
            dgRowList.add(create給付費明細一覧アイテム(
                    sourceList.get(i).get("サービス").toString(),
                    sourceList.get(i).get("単位数").toString(),
                    sourceList.get(i).get("日数回数").toString(),
                    sourceList.get(i).get("サービス単位数").toString(),
                    sourceList.get(i).get("摘要").toString()));
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

// 南魚沼市のデモ向けに、基本情報」「給付費明細」「請求額集計」「社福系減額」以外のタブの機能をコメントアウト。
    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから緊急時施設療養費タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
//       ShokanShikyuTorokuShomeishoを参考に実装する。
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで緊急時施設療養費タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 南魚沼市のデモ向けに、基本情報」「給付費明細」「請求額集計」「社福系減額」以外のタブの機能をコメントアウト。
    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから特定診療費タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
//       ShokanShikyuTorokuShomeishoを参考に実装する。
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで特定診療費タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 南魚沼市のデモ向けに、基本情報」「給付費明細」「請求額集計」「社福系減額」以外のタブの機能をコメントアウト。
    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから食事費用タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
//       ShokanShikyuTorokuShomeishoを参考に実装する。
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで食事費用タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 南魚沼市のデモ向けに、基本情報」「給付費明細」「請求額集計」「社福系減額」以外のタブの機能をコメントアウト。
    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから計画費タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
//       ShokanShikyuTorokuShomeishoを参考に実装する。
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで計画費タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから請求額集計タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private void setShukeiListData(ShokanShikyuKetteiShomeishoDiv panel) {
        ShokanShikyuKetteiShomeishoShukeiDiv shukei = panel.getTabShokanShikyuKetteiShomeisho()
                .getShokanShikyuKetteiShomeishoShukei();
        ServiceTeikyoShomeishoShukeiListDiv list = shukei.getShokanShikyuKetteiShomeishoShukeiListInfo();
        DataGrid<dgServiceTeikyoShomeishoShukeiList_Row> dgRow = list.getDgServiceTeikyoShomeishoShukeiList();
        List<dgServiceTeikyoShomeishoShukeiList_Row> dgRowList = dgRow.getDataSource();

        List<HashMap> sourceList = getYaml();
        dgRowList.clear();
        for (int i = 37; i < 38; i++) {
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
    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから特定入所者費用タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
//       ShokanShikyuTorokuShomeishoを参考に実装する。
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで特定入所者費用タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから社福軽減額タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private void setShafukuListData(ShokanShikyuKetteiShomeishoDiv panel) {
        ShokanShikyuKetteiShomeishoShafukuDiv shafuku = panel.getTabShokanShikyuKetteiShomeisho()
                .getShokanShikyuKetteiShomeishoShafuku();
        ServiceTeikyoShomeishoShafukuListDiv list = shafuku.getShokanShikyuKetteiShomeishoShafukuListInfo();
        DataGrid<dgServiceTeikyoShomeishoShafukuList_Row> dgRow = list.getDgServiceTeikyoShomeishoShafukuList();
        List<dgServiceTeikyoShomeishoShafukuList_Row> dgRowList = dgRow.getDataSource();

        List<HashMap> sourceList = getYaml();
        dgRowList.clear();
        for (int i = 45; i < 46; i++) {
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
