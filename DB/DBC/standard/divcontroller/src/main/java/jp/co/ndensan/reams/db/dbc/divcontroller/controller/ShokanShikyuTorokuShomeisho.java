/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoMeisaiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoRyoyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonKikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonNyutaishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoRyoyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoRyoyoKinkyujiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoRyoyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoRyoyoOshinTsuinDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoRyoyoShikkanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoRyoyoTensuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceTeikyoShomeishoMeisaiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceTeikyoShomeishoRyoyoList_Row;
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

    private enum 一覧明細表示 {

        一覧表示,
        明細表示,
    }

    private enum イベント {

        追加,
        選択
    }

    /**
     * 支給申請書情報で証明書情報を追加するボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickAddShomeisho(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        setTopData(panel);
        setKihonData(panel);
        setKyufuhiListData(panel);
        setRyoyoListData(panel);

        showKyufuhi(panel, 一覧明細表示.一覧表示);
        showRyoyo(panel, 一覧明細表示.一覧表示);
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

        setTopData(panel);
        setKihonData(panel);
        setKyufuhiListData(panel);
        setRyoyoListData(panel);

        showKyufuhi(panel, 一覧明細表示.一覧表示);
        showRyoyo(panel, 一覧明細表示.一覧表示);
        response.data = panel;
        return response;
    }

    private void setTopData(ShokanShikyuTorokuShomeishoDiv panel) {
        HashMap source = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml")).get(0);
        panel.getTxtShomeishoTeikyoYM().setValue(new RDate(source.get("提供年月").toString()));
        panel.getTxtShomeishoJigyoshaCode().setValue(new RString(source.get("事業者コード").toString()));
        panel.getTxtShomeishoJigyoshaName().setValue(new RString(source.get("事業者名").toString()));
        panel.getTxtShomeishoShinseiYMD().setValue(new RDate(source.get("申請日").toString()));
        panel.getTxtShomeishoShomeisho().setValue(new RString(source.get("証明書").toString()));
    }

    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから基本情報タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private void setKihonData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoKihonDiv kihon = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoKihon();
        ShokanShikyuTorokuShomeishoKihonKeikakuDiv keikaku = kihon.getShokanShikyuTorokuShomeishoKihonKeikaku();
        ShokanShikyuTorokuShomeishoKihonKikanDiv kikan = kihon.getShokanShikyuTorokuShomeishoKihonKikan();
        ShokanShikyuTorokuShomeishoKihonNyutaishoDiv nyutaisho = kihon.getShokanShikyuTorokuShomeishoKihonNyutaisho();

        HashMap source = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml")).get(1);
        keikaku.getTxtShomeishoKihonJigyoshaCode().setValue(new RString(source.get("事業者コード").toString()));
        keikaku.getTxtShomeishoKihonJigyoshaName().setValue(new RString(source.get("事業者名").toString()));
        keikaku.getTxtShomeishoKihonKyufuritsu().setValue(new Decimal(source.get("保険給付率").toString()));
        source = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml")).get(2);
        kikan.getTxtShomeishoKihonKaishiYMD().setValue(new RDate(source.get("開始日").toString()));
        kikan.getTxtShomeishoKihonChushiYMD().setValue(new RDate(source.get("中止日").toString()));
        source = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml")).get(3);
        nyutaisho.getTxtShomeishoKihonNyushoYMD().setValue(new RDate(source.get("入所日").toString()));
        nyutaisho.getTxtShomeishoKihonTaishoYMD().setValue(new RDate(source.get("退所日").toString()));
        nyutaisho.getTxtShomeishoKihonNyushoNissu().setValue(new Decimal(source.get("入所実日数").toString()));
        nyutaisho.getTxtShomeishoKihonGaihakuNissu().setValue(new Decimal(source.get("外泊日数").toString()));
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
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoMeisai();
        ServiceTeikyoShomeishoMeisaiListDiv meisaiList = meisai.getShokanShikyuTorokuShomeishoMeisaiList().getShokanShikyuTorokuShomeishoMeisaiListInfo();
        DataGrid<dgServiceTeikyoShomeishoMeisaiList_Row> dgRow = meisaiList.getDgServiceTeikyoShomeishoMeisaiList();
        List<dgServiceTeikyoShomeishoMeisaiList_Row> dgRowList = dgRow.getDataSource();

        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml"));
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

    private void deleteKyufuhiListData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoMeisai();
        ServiceTeikyoShomeishoMeisaiListDiv meisaiList = meisai.getShokanShikyuTorokuShomeishoMeisaiList().getShokanShikyuTorokuShomeishoMeisaiListInfo();
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
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoMeisai();
        ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv meisaiMeisai = meisai.getShokanShikyuTorokuShomeishoMeisaiMeisai();
        if (event.equals(イベント.追加)) {
            meisaiMeisai.getTxtKyufuhiSelectedIndex().setValue(new RString("-1"));
        } else {
            int index = meisai.getShokanShikyuTorokuShomeishoMeisaiList().getShokanShikyuTorokuShomeishoMeisaiListInfo().getDgServiceTeikyoShomeishoMeisaiList().getActiveRowId();
            meisaiMeisai.getTxtKyufuhiSelectedIndex().setValue(new RString(String.valueOf(index)));
        }
        HashMap source = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml")).get(7);
        meisaiMeisai.getTxtKyufuhiShuruiCode().setValue(new RString(source.get("サービス種類コード").toString()));
        meisaiMeisai.getTxtKyufuhiServiceCode().setValue(new RString(source.get("サービスコード").toString()));
        meisaiMeisai.getTxtKyufuhiServiceName().setValue(new RString(source.get("サービス名称").toString()));
        meisaiMeisai.getTxtKyufuhiTanisu().setValue(new Decimal(source.get("単位数").toString()));
        meisaiMeisai.getTxtKyufuhiKaisuNissu().setValue(new Decimal(source.get("日数回数").toString()));
        meisaiMeisai.getTxtKyufuhiServiceTanisu().setValue(new Decimal(source.get("サービス単位数").toString()));
        meisaiMeisai.getTxtKyufuhiTekiyo().setValue(new RString(source.get("摘要").toString()));
    }

    private void initKyufuhiMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoMeisai();
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
        ShokanShikyuTorokuShomeishoMeisaiDiv meisai = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoMeisai();
        ServiceTeikyoShomeishoMeisaiListDiv meisaiList = meisai.getShokanShikyuTorokuShomeishoMeisaiList().getShokanShikyuTorokuShomeishoMeisaiListInfo();
        ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv meisaiMeisai = meisai.getShokanShikyuTorokuShomeishoMeisaiMeisai();

        DataGrid<dgServiceTeikyoShomeishoMeisaiList_Row> dgRow = meisaiList.getDgServiceTeikyoShomeishoMeisaiList();
        List<dgServiceTeikyoShomeishoMeisaiList_Row> dgRowList = dgRow.getDataSource();
        int index = Integer.parseInt(meisaiMeisai.getTxtKyufuhiSelectedIndex().getValue().toString());

        dgServiceTeikyoShomeishoMeisaiList_Row item = create給付費明細一覧アイテム(
                meisaiMeisai.getTxtKyufuhiShuruiCode().getValue().toString().concat(meisaiMeisai.getTxtKyufuhiServiceCode().getValue().toString()).
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

    // !!!!!!!!!!!!!!!!!!!!!!↓↓ここから緊急時施設療養費タブに関連するコード↓↓!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // Ryoyo
    /**
     * サービス提供証明書情報の緊急時施設療養費タブで明細情報を追加するボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickAddRyoyoMeisai(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        setRyoyoMeisaiData(panel, イベント.追加);
        showRyoyo(panel, 一覧明細表示.明細表示);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の緊急時施設療養費タブで、一覧から行を選択したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onSelectedRyoyoList(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        setRyoyoMeisaiData(panel, イベント.選択);
        showRyoyo(panel, 一覧明細表示.明細表示);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の緊急時施設療養費タブで、一覧の行の削除ボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickRyoyoListDelete(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        deleteRyoyoListData(panel);
        response.data = panel;
        return response;
    }

    /**
     * サービス提供証明書情報の緊急時施設療養費タブで入力内容を確定するボタンを押下したときの処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData<ShokanShikyuTorokuShomeishoDiv> onClickRyoyoKakutei(ShokanShikyuTorokuShomeishoDiv panel) {
        ResponseData<ShokanShikyuTorokuShomeishoDiv> response = new ResponseData<>();

        kakuteiRyoyoMeisaiData(panel);
        initRyoyoMeisaiData(panel);
        showRyoyo(panel, 一覧明細表示.一覧表示);
        response.data = panel;
        return response;
    }

    private void showRyoyo(ShokanShikyuTorokuShomeishoDiv panel, 一覧明細表示 show) {
        ShokanShikyuTorokuShomeishoRyoyoDiv ryoyo = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoRyoyo();
        if (show.equals(一覧明細表示.一覧表示)) {
            ryoyo.getShokanShikyuTorokuShomeishoRyoyoList().setIsOpen(true);
            ryoyo.getShokanShikyuTorokuShomeishoRyoyoMeisai().setIsOpen(false);
        } else if (show.equals(一覧明細表示.明細表示)) {
            ryoyo.getShokanShikyuTorokuShomeishoRyoyoList().setIsOpen(false);
            ryoyo.getShokanShikyuTorokuShomeishoRyoyoMeisai().setIsOpen(true);
        }
    }

    private void setRyoyoListData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoRyoyoDiv ryoyo = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoRyoyo();
        ServiceTeikyoShomeishoRyoyoListDiv ryoyoList = ryoyo.getShokanShikyuTorokuShomeishoRyoyoList().getShokanShikyuTorokuShomeishoRyoyoListInfo();
        DataGrid<dgServiceTeikyoShomeishoRyoyoList_Row> dgRow = ryoyoList.getDgServiceTeikyoShomeishoRyoyoList();
        List<dgServiceTeikyoShomeishoRyoyoList_Row> dgRowList = dgRow.getDataSource();

        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml"));
        dgRowList.clear();
        for (int i = 8; i < 11; i++) {
            dgRowList.add(create療養費明細一覧アイテム(
                    sourceList.get(i).get("所定疾患傷病名１").toString(),
                    sourceList.get(i).get("療養開始日１").toString(),
                    sourceList.get(i).get("所定疾患施設療養費合計").toString(),
                    sourceList.get(i).get("緊急時傷病名１").toString(),
                    sourceList.get(i).get("治療開始日１").toString(),
                    sourceList.get(i).get("緊急時治療管理合計").toString(),
                    sourceList.get(i).get("緊急時施設療養費合計").toString()
            ));
        }
        dgRow.setDataSource(dgRowList);
    }

    private void deleteRyoyoListData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoRyoyoDiv ryoyo = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoRyoyo();
        ServiceTeikyoShomeishoRyoyoListDiv ryoyoList = ryoyo.getShokanShikyuTorokuShomeishoRyoyoList().getShokanShikyuTorokuShomeishoRyoyoListInfo();
        DataGrid<dgServiceTeikyoShomeishoRyoyoList_Row> dgRow = ryoyoList.getDgServiceTeikyoShomeishoRyoyoList();
        List<dgServiceTeikyoShomeishoRyoyoList_Row> dgRowList = dgRow.getDataSource();
        int index = dgRow.getClickedRowId();

        dgServiceTeikyoShomeishoRyoyoList_Row item = dgRow.getClickedItem();
        item.setRowState(RowState.Deleted);
        dgRowList.remove(index);
        dgRowList.add(index, item);

        dgRow.setDataSource(dgRowList);
    }

    private void setRyoyoMeisaiData(ShokanShikyuTorokuShomeishoDiv panel, イベント event) {
        ShokanShikyuTorokuShomeishoRyoyoDiv ryoyo = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoRyoyo();
        ShokanShikyuTorokuShomeishoRyoyoMeisaiDiv ryoyoMeisai = ryoyo.getShokanShikyuTorokuShomeishoRyoyoMeisai();
        if (event.equals(イベント.追加)) {
            ryoyoMeisai.getTxtRyoyoSelectedIndex().setValue(new RString("-1"));
        } else {
            int index = ryoyo.getShokanShikyuTorokuShomeishoRyoyoList().getShokanShikyuTorokuShomeishoRyoyoListInfo().getDgServiceTeikyoShomeishoRyoyoList().getActiveRowId();
            ryoyoMeisai.getTxtRyoyoSelectedIndex().setValue(new RString(String.valueOf(index)));
        }
        HashMap sourceShikkan = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml")).get(11);
        HashMap sourceKinkyuji = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml")).get(12);
        HashMap sourceOshin = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml")).get(13);
        HashMap sourceTensu = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml")).get(14);
        ShokanShikyuTorokuShomeishoRyoyoShikkanDiv shikkan = ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoShikkan();
        ShokanShikyuTorokuShomeishoRyoyoKinkyujiDiv kinkyuji = ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoKinkyuji();
        ShokanShikyuTorokuShomeishoRyoyoOshinTsuinDiv oshin = ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoOshinTsuin();
        ShokanShikyuTorokuShomeishoRyoyoTensuDiv tensu = ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoTensu();
        shikkan.getTxtRyoyohiShikkanName1().setValue(new RString(sourceShikkan.get("疾病名１").toString()));
        shikkan.getTxtRyoyohiShikkanName2().setValue(new RString(sourceShikkan.get("疾病名２").toString()));
        shikkan.getTxtRyoyohiShikkanName3().setValue(new RString(sourceShikkan.get("疾病名３").toString()));
        shikkan.getTxtRyoyohiRyoyoKaishiYMD1().setValue(new RDate(sourceShikkan.get("療養開始日１").toString()));
        shikkan.getTxtRyoyohiRyoyoKaishiYMD2().setValue(new RDate(sourceShikkan.get("療養開始日２").toString()));
        shikkan.getTxtRyoyohiRyoyoKaishiYMD3().setValue(new RDate(sourceShikkan.get("療養開始日３").toString()));
        kinkyuji.getTxtRyoyohiKinkyuName1().setValue(new RString(sourceKinkyuji.get("疾病名１").toString()));
        kinkyuji.getTxtRyoyohiKinkyuName2().setValue(new RString(sourceKinkyuji.get("疾病名２").toString()));
        kinkyuji.getTxtRyoyohiKinkyuName3().setValue(new RString(sourceKinkyuji.get("疾病名３").toString()));
        kinkyuji.getTxtRyoyohiChiryoKaishiYMD1().setValue(new RDate(sourceKinkyuji.get("治療開始日１").toString()));
        kinkyuji.getTxtRyoyohiChiryoKaishiYMD2().setValue(new RDate(sourceKinkyuji.get("治療開始日２").toString()));
        kinkyuji.getTxtRyoyohiChiryoKaishiYMD3().setValue(new RDate(sourceKinkyuji.get("治療開始日３").toString()));
        oshin.getTxtRyoyohiOshinNissu().setValue(new Decimal(sourceOshin.get("往診日数").toString()));
        oshin.getTxtRyoyohiOshinKikanName().setValue(new RString(sourceOshin.get("往診医療機関名").toString()));
        oshin.getTxtRyoyohiTsuinNissu().setValue(new Decimal(sourceOshin.get("通院日数").toString()));
        oshin.getTxtRyoyohiTsuinKikanName().setValue(new RString(sourceOshin.get("通院医療機関名").toString()));
        oshin.getTxtRyoyohiTekiyo().setValue(new RString(sourceOshin.get("摘要").toString()));
        tensu.getTxtRyoyohiRyoyohiTanisu().setValue(new Decimal(sourceTensu.get("療養費単位数").toString()));
        tensu.getTxtRyoyohiRyoyohiNissu().setValue(new Decimal(sourceTensu.get("療養費日数").toString()));
        tensu.getTxtRyoyohiRyoyohiShokei().setValue(new Decimal(sourceTensu.get("療養費小計").toString()));
        tensu.getTxtRyoyohiChiryohiTanisu().setValue(new Decimal(sourceTensu.get("治療費単位数").toString()));
        tensu.getTxtRyoyohiChiryohiNissu().setValue(new Decimal(sourceTensu.get("治療費日数").toString()));
        tensu.getTxtRyoyohiChiryohiShokei().setValue(new Decimal(sourceTensu.get("治療費小計").toString()));
        tensu.getTxtRyoyohiRehabili().setValue(new Decimal(sourceTensu.get("リハビリ").toString()));
        tensu.getTxtRyoyohiShujutsu().setValue(new Decimal(sourceTensu.get("手術").toString()));
        tensu.getTxtRyoyohiHoshasen().setValue(new Decimal(sourceTensu.get("放射線治療").toString()));
        tensu.getTxtRyoyohiShochi().setValue(new Decimal(sourceTensu.get("処置").toString()));
        tensu.getTxtRyoyohiMasui().setValue(new Decimal(sourceTensu.get("麻酔").toString()));
        tensu.getTxtRyoyohiChiryoGokei().setValue(new Decimal(sourceTensu.get("特定治療合計").toString()));
    }

    private void initRyoyoMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoRyoyoDiv ryoyo = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoRyoyo();
        ShokanShikyuTorokuShomeishoRyoyoMeisaiDiv ryoyoMeisai = ryoyo.getShokanShikyuTorokuShomeishoRyoyoMeisai();
        ryoyoMeisai.getTxtRyoyoSelectedIndex().setValue(new RString("-1"));
        ShokanShikyuTorokuShomeishoRyoyoShikkanDiv shikkan = ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoShikkan();
        ShokanShikyuTorokuShomeishoRyoyoKinkyujiDiv kinkyuji = ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoKinkyuji();
        ShokanShikyuTorokuShomeishoRyoyoOshinTsuinDiv oshin = ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoOshinTsuin();
        ShokanShikyuTorokuShomeishoRyoyoTensuDiv tensu = ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoTensu();
        shikkan.getTxtRyoyohiShikkanName1().clearValue();
        shikkan.getTxtRyoyohiShikkanName2().clearValue();
        shikkan.getTxtRyoyohiShikkanName3().clearValue();
        shikkan.getTxtRyoyohiRyoyoKaishiYMD1().clearValue();
        shikkan.getTxtRyoyohiRyoyoKaishiYMD2().clearValue();
        shikkan.getTxtRyoyohiRyoyoKaishiYMD3().clearValue();
        kinkyuji.getTxtRyoyohiKinkyuName1().clearValue();
        kinkyuji.getTxtRyoyohiKinkyuName2().clearValue();
        kinkyuji.getTxtRyoyohiKinkyuName3().clearValue();
        kinkyuji.getTxtRyoyohiChiryoKaishiYMD1().clearValue();
        kinkyuji.getTxtRyoyohiChiryoKaishiYMD2().clearValue();
        kinkyuji.getTxtRyoyohiChiryoKaishiYMD3().clearValue();
        oshin.getTxtRyoyohiOshinNissu().clearValue();
        oshin.getTxtRyoyohiOshinKikanName().clearValue();
        oshin.getTxtRyoyohiTsuinNissu().clearValue();
        oshin.getTxtRyoyohiTsuinKikanName().clearValue();
        oshin.getTxtRyoyohiTekiyo().clearValue();
        tensu.getTxtRyoyohiRyoyohiTanisu().clearValue();
        tensu.getTxtRyoyohiRyoyohiNissu().clearValue();
        tensu.getTxtRyoyohiRyoyohiShokei().clearValue();
        tensu.getTxtRyoyohiChiryohiTanisu().clearValue();
        tensu.getTxtRyoyohiChiryohiNissu().clearValue();
        tensu.getTxtRyoyohiChiryohiShokei().clearValue();
        tensu.getTxtRyoyohiRehabili().clearValue();
        tensu.getTxtRyoyohiShujutsu().clearValue();
        tensu.getTxtRyoyohiHoshasen().clearValue();
        tensu.getTxtRyoyohiShochi().clearValue();
        tensu.getTxtRyoyohiMasui().clearValue();
        tensu.getTxtRyoyohiChiryoGokei().clearValue();
    }

    private void kakuteiRyoyoMeisaiData(ShokanShikyuTorokuShomeishoDiv panel) {
        ShokanShikyuTorokuShomeishoRyoyoDiv ryoyo = panel.getTabShokanShikyuTorokuShomeisho().getShokanShikyuTorokuShomeishoRyoyo();
        ServiceTeikyoShomeishoRyoyoListDiv ryoyoList = ryoyo.getShokanShikyuTorokuShomeishoRyoyoList().getShokanShikyuTorokuShomeishoRyoyoListInfo();
        ShokanShikyuTorokuShomeishoRyoyoMeisaiDiv ryoyoMeisai = ryoyo.getShokanShikyuTorokuShomeishoRyoyoMeisai();

        DataGrid<dgServiceTeikyoShomeishoRyoyoList_Row> dgRow = ryoyoList.getDgServiceTeikyoShomeishoRyoyoList();
        List<dgServiceTeikyoShomeishoRyoyoList_Row> dgRowList = dgRow.getDataSource();
        int index = Integer.parseInt(ryoyoMeisai.getTxtRyoyoSelectedIndex().getValue().toString());

        dgServiceTeikyoShomeishoRyoyoList_Row item = create療養費明細一覧アイテム(
                ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoShikkan().getTxtRyoyohiShikkanName1().getValue().toString(),
                ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoShikkan().getTxtRyoyohiRyoyoKaishiYMD1().getValue().wareki().toDateString().toString(),
                ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoTensu().getTxtRyoyohiRyoyohiShokei().getValue().toString(),
                ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoKinkyuji().getTxtRyoyohiKinkyuName1().getValue().toString(),
                ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoKinkyuji().getTxtRyoyohiChiryoKaishiYMD1().getValue().wareki().toDateString().toString(),
                ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoTensu().getTxtRyoyohiChiryohiShokei().getValue().toString(),
                ryoyoMeisai.getShokanShikyuTorokuShomeishoRyoyoTensu().getTxtRyoyohiChiryoGokei().getValue().toString());

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

    private dgServiceTeikyoShomeishoRyoyoList_Row create療養費明細一覧アイテム(
            String txtShoteiShikkanName,
            String txtRyoyoKaishiYMD,
            String txtShoteiShikkanGokei,
            String txtKinkyujiName,
            String txtChiryoKaishiYMD,
            String txtKinkyujiGokei,
            String txtRyoyohiGokei
    ) {
        Button btnSelect = new Button();
        Button btnEdit = new Button();
        Button btnDelete = new Button();

        return new dgServiceTeikyoShomeishoRyoyoList_Row(
                btnSelect,
                btnEdit,
                btnDelete,
                new RString(txtShoteiShikkanName),
                new RString(txtRyoyoKaishiYMD),
                new RString(txtShoteiShikkanGokei),
                new RString(txtKinkyujiName),
                new RString(txtChiryoKaishiYMD),
                new RString(txtKinkyujiGokei),
                new RString(txtRyoyohiGokei));
    }
    // !!!!!!!!!!!!!!!!!!!!!!↑↑ここまで緊急時施設療養費タブに関連するコード↑↑!!!!!!!!!!!!!!!!!!!!!!!!!!!
}
