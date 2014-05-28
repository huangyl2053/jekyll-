/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoMeisaiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonKeikakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonKikanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoKihonNyutaishoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ShokanShikyuTorokuShomeishoMeisaiMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceTeikyoShomeishoMeisaiList_Row;
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

        showKyufuhi(panel, 一覧明細表示.一覧表示);
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

        showKyufuhi(panel, 一覧明細表示.一覧表示);
        response.data = panel;
        return response;
    }

    // ↓↓ここから給付費明細に関連するコード↓↓
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

    private void setTopData(ShokanShikyuTorokuShomeishoDiv panel) {
        HashMap source = YamlLoader.FOR_DBC.loadAsList(new RString("ShokanShikyuTorokuShomeisho.yml")).get(0);
        panel.getTxtShomeishoTeikyoYM().setValue(new RDate(source.get("提供年月").toString()));
        panel.getTxtShomeishoJigyoshaCode().setValue(new RString(source.get("事業者コード").toString()));
        panel.getTxtShomeishoJigyoshaName().setValue(new RString(source.get("事業者名").toString()));
        panel.getTxtShomeishoShinseiYMD().setValue(new RDate(source.get("申請日").toString()));
        panel.getTxtShomeishoShomeisho().setValue(new RString(source.get("証明書").toString()));
    }

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
    // ↑↑ここまで給付費明細に関連するコード↑↑

}
