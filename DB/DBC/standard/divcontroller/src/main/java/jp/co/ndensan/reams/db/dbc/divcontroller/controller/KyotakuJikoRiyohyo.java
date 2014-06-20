/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0120000.KyotakuJikoRiyohyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoBeppyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoBeppyoGokeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoBeppyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoBeppyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoBeppyoRiyoNissuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.dgServiceRiyohyoBeppyoList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.dgServiceRiyohyoList_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumn;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 居宅サービス自己作成サービス利用票登録の居宅サービス自己作成サービス利用票をコントロールするクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuJikoRiyohyo {

    private enum 別票画面表示 {

        初期表示,
        明細,
        合計
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel 履歴一覧
     * @return ResponseData
     */
    public ResponseData onLoad(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();
        setRiyohyoData(panel);
        setRiyohyoBeppyoVisible(panel, 別票画面表示.初期表示);
// TBD N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンをDisableにする。共通パネルの仕様が固まってから対応する。
//        kyotsu.getBtnRiyohyoSave().setDisabled(true);
        response.data = panel;
        return response;
    }

    /**
     * KyotakuJikoRiyohyoInfoの「前月の情報をコピー」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickZengetsuCopy(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();
        setSummaryZengetsuData(panel);
        setServiceRiyohyoYobi(panel);
        setServiceRiyohyoZengetsuData(panel);
        setServiceRiyohyoBeppyoZengetsuData(panel);
// TBD N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンを有効/無効にする。共通パネルの仕様が固まってから対応する。
//        validateRiyohyoSave(panel, kyotsu);
        response.data = panel;
        return response;
    }

    /**
     * KyotakuJikoRiyohyoInfoのサービス利用票Tabの「明細行を追加する」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickRiyohyoMeisaiAdd(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();

        DataGrid<dgServiceRiyohyoList_Row> dgRiyohyo = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyo().getDgServiceRiyohyoList();
        List<dgServiceRiyohyoList_Row> dgRiyohyoList = dgRiyohyo.getDataSource();
        Button btnDelete = new Button();
        Button btnService = new Button();
        Button btnJigyosha = new Button();

        // デモ向けにデータ決め打ちで明細行を追加する。
        dgServiceRiyohyoList_Row rowItem = createサービス利用票(btnDelete,
                "10:00",
                "15:00",
                btnService,
                "111111:通所介護",
                btnJigyosha,
                "1111111111:電算介護サービス",
                "予",
                "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
                "2", "2", "2", "2", "2", "2", "2", "2", "2", "2",
                "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3",
                "63");
        dgRiyohyoList.add(rowItem);
        rowItem = createサービス利用票(btnDelete,
                "",
                "",
                btnService,
                "",
                btnJigyosha,
                "",
                "実",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
                "0");

        // デモ向けではない空の明細行を追加する。
//        rowItem = createサービス利用票(btnDelete,
//                "",
//                "",
//                btnService,
//                "",
//                btnJigyosha,
//                "",
//                "予",
//                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
//                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
//                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
//                "0");
//
//        dgRiyohyoList.add(rowItem);
//        rowItem = createサービス利用票(btnDelete,
//                "",
//                "",
//                btnService,
//                "",
//                btnJigyosha,
//                "",
//                "実",
//                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
//                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
//                "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
//                "0");
//
        dgRiyohyoList.add(rowItem);
        dgRiyohyo.setDataSource(dgRiyohyoList);
//        validateRiyohyoSave(panel, kyotsu);

        response.data = panel;
        return response;
    }

    /**
     * KyotakuJikoRiyohyoInfoのサービス利用票Tabの明細表の削除ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickServiceRiyohyoListDelete(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();
        panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyo().
                getDgServiceRiyohyoList().getActiveRow().setRowState(RowState.Deleted);
        response.data = panel;
        return response;
    }

    /**
     * KyotakuJikoRiyohyoInfoの別票Tabの「明細情報を追加する」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBeppyoMeisaiNew(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();
        panel.getTxtBeppyoListSelectIndex().setValue(new RString("-1"));
        setRiyohyoBeppyoVisible(panel, 別票画面表示.明細);
        setRiyohyoBeppyoMeisaiDemoData(panel);
        response.data = panel;
        return response;
    }

    /**
     * KyotakuJikoRiyohyoInfoの別票Tabの「合計情報を追加する」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBeppyoGokeiNew(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();
        panel.getTxtBeppyoListSelectIndex().setValue(new RString("-1"));
        setRiyohyoBeppyoVisible(panel, 別票画面表示.合計);
        setRiyohyoBeppyoGokeiDemoData(panel);
        response.data = panel;
        return response;
    }

    /**
     * KyotakuJikoRiyohyoInfoのサービス別票Tabの明細表の選択ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickServiceRiyohyoBeppyoListSelect(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();
        dgServiceRiyohyoBeppyoList_Row row = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getActiveRow();
        int index = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyoBeppyo().
                getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getActiveRowId();
        panel.getTxtBeppyoListSelectIndex().setValue(new RString(String.valueOf(index)));

        RString service = row.getTxtService();
        if (service.contains(new RString("合計"))) {
            beppyoGokeiModify(panel);
        } else {
            beppyoMeisaiModify(panel);
        }

        response.data = panel;
        return response;
    }

    /**
     * KyotakuJikoRiyohyoInfoのサービス別票Tabの明細表の削除ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickServiceRiyohyoBeppyoListDelete(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();
        panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().
                getDgServiceRiyohyoBeppyoList().getActiveRow().setRowState(RowState.Deleted);
        response.data = panel;
        return response;
    }

    /**
     * KyotakuJikoRiyohyoInfoの別票Tabの「明細情報を確定する」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBeppyoMeisaiKakutei(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();
        setBeppyoListMeisaiKakutei(panel);
        initRiyohyoBeppyoMeisaiData(panel);
        setRiyohyoBeppyoVisible(panel, 別票画面表示.初期表示);
// TBD N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンを有効/無効にする。共通パネルの仕様が固まってから対応する。
//        validateRiyohyoSave(panel, kyotsu);
        response.data = panel;
        return response;
    }

    /**
     * KyotakuJikoRiyohyoInfoの別票Tabの「合計情報を確定する」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBeppyoGokeiKakutei(KyotakuJikoRiyohyoDiv panel) {
        ResponseData<KyotakuJikoRiyohyoDiv> response = new ResponseData<>();
        setBeppyoListGokeiKakutei(panel);
        initRiyohyoBeppyoGokeiData(panel);
        setRiyohyoBeppyoVisible(panel, 別票画面表示.初期表示);
// TBD N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンを有効/無効にする。共通パネルの仕様が固まってから対応する。
//        validateRiyohyoSave(panel, kyotsu);
        response.data = panel;
        return response;
    }

//    /**
//     * サービス利用票及び別票が入力されているか判定する。 双方入力されている場合、共通パネルの「サービス利用票を保存する」ボタンをEnableにする。
//     *
//     * @param panel panel
//     * @param kyotsu kyotsu
//     */
//    private void validateRiyohyoSave(KyotakuJikoRiyohyoDiv panel, KyotsuPanelDiv kyotsu) {
//        ServiceRiyohyoDiv riyohyo = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyo();
//        ServiceRiyohyoBeppyoDiv beppyo = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyoBeppyo();
//
//        if (!riyohyo.getDgServiceRiyohyoList().getDataSource().isEmpty()
//                && !beppyo.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource().isEmpty()) {
//            kyotsu.getBtnRiyohyoSave().setDisabled(false);
//        }
//    }
    private void beppyoMeisaiModify(KyotakuJikoRiyohyoDiv panel) {
        dgServiceRiyohyoBeppyoList_Row row = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getActiveRow();
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        meisai.getTxtJigyoshaCode().setValue(row.getTxtJigyosha().substring(0, 10));
        meisai.getTxtJigyoshaName().setValue(row.getTxtJigyosha().substring(11));
        meisai.getTxtServiceShuruiCode().setValue(row.getTxtService().substring(0, 2));
        meisai.getTxtServiceCode().setValue(row.getTxtService().substring(2, 6));
        meisai.getTxtServiceName().setValue(row.getTxtService().substring(7));
        meisai.getTxtTani().setValue(new Decimal(row.getTxtTani().toString()));
        meisai.getTxtWaribikigoRitsu().setValue(new Decimal(row.getTxtWaribikigoRitsu().toString()));
        meisai.getTxtWaribikigoTani().setValue(new Decimal(row.getTxtWaribikigoTani().toString()));
        meisai.getTxtKaisu().setValue(new Decimal(row.getTxtKaisu().toString()));
        meisai.getTxtServiceTani().setValue(new Decimal(row.getTxtServiceTani().toString()));

        setRiyohyoBeppyoVisible(panel, 別票画面表示.明細);
    }

    private void beppyoGokeiModify(KyotakuJikoRiyohyoDiv panel) {
        dgServiceRiyohyoBeppyoList_Row row = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getActiveRow();
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
        gokei.getTxtShuruiGendoChokaTani().setValue(new Decimal(row.getTxtShuruiGendoChokaTani().toString()));
        gokei.getTxtShuruiGendonaiTani().setValue(new Decimal(row.getTxtShuruiGendonaiTani().toString()));
        gokei.getTxtTanisuTanka().setValue(new Decimal(row.getTxtTanisuTanka().toString()));
        gokei.getTxtKubunGendoChokaTani().setValue(new Decimal(row.getTxtKubunGendoChokaTani().toString()));
        gokei.getTxtKubunGendonaiTani().setValue(new Decimal(row.getTxtKubunGendonaiTani().toString()));
        gokei.getTxtKyufuritsu().setValue(new Decimal(row.getTxtKyufuritsu().toString()));
        gokei.getTxtHiyoSogaku().setValue(new Decimal(row.getTxtHiyoSogaku().toString()));
        gokei.getTxtHokenKyufugaku().setValue(new Decimal(row.getTxtHokenFutangaku().toString()));
        gokei.getTxtRiyoshaFutangakuHoken().setValue(new Decimal(row.getTxtRiyoshaFutangakuHoken().toString()));
        gokei.getTxtRiyoshaFutangakuZengaku().setValue(new Decimal(row.getTxtRiyoshaFutangakuZengaku().toString()));

        setRiyohyoBeppyoVisible(panel, 別票画面表示.合計);
    }

    /**
     * 利用票のデータ設定
     */
    private void setRiyohyoData(KyotakuJikoRiyohyoDiv panel) {
        setSummaryData(panel);
        setServiceRiyohyoYobi(panel);
        setServiceRiyohyoBeppyoData(panel);
    }

    /**
     * yotakuJikoRiyohyoInfoの別票Tabの明細のデータを一覧に反映する。
     *
     * @param panel panel
     */
    private void setBeppyoListMeisaiKakutei(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoListDiv beppyoList = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList();
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        List<dgServiceRiyohyoBeppyoList_Row> listRow = beppyoList.getDgServiceRiyohyoBeppyoList().getDataSource();
        int index = Integer.parseInt(panel.getTxtBeppyoListSelectIndex().getValue().toString());

        Button btnSelect = new Button();
        Button btnDelete = new Button();
        RString jigyosha = meisai.getTxtJigyoshaCode().getValue().concat(new RString(":")).
                concat(meisai.getTxtJigyoshaName().getValue());
        RString service = meisai.getTxtServiceShuruiCode().getValue().concat(meisai.getTxtServiceCode().getValue()).
                concat(new RString(":")).concat(meisai.getTxtServiceName().getValue());

        dgServiceRiyohyoBeppyoList_Row rowItem;
        rowItem = create別票一覧リスト(
                btnSelect,
                btnDelete,
                jigyosha.toString(),
                service.toString(),
                meisai.getTxtTani().getValue().toString(),
                meisai.getTxtWaribikigoRitsu().getValue().toString(),
                meisai.getTxtWaribikigoTani().getValue().toString(),
                meisai.getTxtKaisu().getValue().toString(),
                meisai.getTxtServiceTani().getValue().toString(),
                "", "", "", "", "", "", "", "", "", "");

        if (Integer.valueOf(index).equals(Integer.valueOf("-1"))) {
            rowItem.setRowState(RowState.Added);
            listRow.add(rowItem);
        } else {
            if (validateMeisai(panel, index)) {
                rowItem.setRowState(RowState.Modified);
                listRow.remove(index);
                listRow.add(index, rowItem);
            } else {
                rowItem.setRowState(RowState.Unchanged);
                listRow.remove(index);
                listRow.add(index, rowItem);
            }
        }
        panel.getTxtBeppyoListSelectIndex().setValue(new RString("-1"));

        beppyoList.getDgServiceRiyohyoBeppyoList().setDataSource(listRow);
    }

    private boolean validateMeisai(KyotakuJikoRiyohyoDiv panel, int index) {
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        List<dgServiceRiyohyoBeppyoList_Row> listRow = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource();
        dgServiceRiyohyoBeppyoList_Row currentRow = listRow.get(index);

        if (meisai.getTxtTani().getValue().equals(new Decimal(currentRow.getTxtTani().toString()))
                && meisai.getTxtWaribikigoRitsu().getValue().equals(new Decimal(currentRow.getTxtWaribikigoRitsu().toString()))
                && meisai.getTxtKaisu().getValue().equals(new Decimal(currentRow.getTxtKaisu().toString()))) {
            return false;
        }
        return true;
    }

    /**
     * yotakuJikoRiyohyoInfoの別票Tabの合計のデータを一覧に反映する。
     *
     * @param panel panel
     */
    private void setBeppyoListGokeiKakutei(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoListDiv beppyoList = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList();
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
        List<dgServiceRiyohyoBeppyoList_Row> listRow = beppyoList.getDgServiceRiyohyoBeppyoList().getDataSource();
        int index = Integer.parseInt(panel.getTxtBeppyoListSelectIndex().getValue().toString());

        Button btnSelect = new Button();
        Button btnDelete = new Button();

        dgServiceRiyohyoBeppyoList_Row rowItem;
        rowItem = create別票一覧リスト(btnSelect, btnDelete,
                "1111111111:電算サービスセンター",
                "111111:通所介護合計",
                "", "", "", "",
                "(638)",
                gokei.getTxtShuruiGendoChokaTani().getValue().toString(),
                gokei.getTxtShuruiGendonaiTani().getValue().toString(),
                gokei.getTxtKubunGendoChokaTani().getValue().toString(),
                gokei.getTxtKubunGendonaiTani().getValue().toString(),
                gokei.getTxtTanisuTanka().getValue().toString(),
                gokei.getTxtHiyoSogaku().getValue().toString(),
                gokei.getTxtKyufuritsu().getValue().toString(),
                gokei.getTxtHokenKyufugaku().getValue().toString(),
                gokei.getTxtRiyoshaFutangakuHoken().getValue().toString(),
                gokei.getTxtRiyoshaFutangakuZengaku().getValue().toString());
        if (Integer.valueOf(index).equals(Integer.valueOf("-1"))) {
            rowItem.setRowState(RowState.Added);
            listRow.add(rowItem);
        } else {
            if (validateGokei(panel, index)) {
                rowItem.setRowState(RowState.Modified);
                listRow.remove(index);
                listRow.add(index, rowItem);
            } else {
                rowItem.setRowState(RowState.Unchanged);
                listRow.remove(index);
                listRow.add(index, rowItem);
            }
        }
        panel.getTxtBeppyoListSelectIndex().setValue(new RString("-1"));
        beppyoList.getDgServiceRiyohyoBeppyoList().setDataSource(listRow);
    }

    private boolean validateGokei(KyotakuJikoRiyohyoDiv panel, int index) {
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
        List<dgServiceRiyohyoBeppyoList_Row> listRow = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().
                getDgServiceRiyohyoBeppyoList().getDataSource();
        dgServiceRiyohyoBeppyoList_Row currentRow = listRow.get(index);

        if (gokei.getTxtShuruiGendoChokaTani().getValue().equals(new Decimal(currentRow.getTxtShuruiGendoChokaTani().toString()))
                && gokei.getTxtShuruiGendonaiTani().getValue().equals(new Decimal(currentRow.getTxtShuruiGendonaiTani().toString()))
                && gokei.getTxtTanisuTanka().getValue().equals(new Decimal(currentRow.getTxtTanisuTanka().toString()))
                && gokei.getTxtKubunGendoChokaTani().getValue().equals(new Decimal(currentRow.getTxtKubunGendoChokaTani().toString()))
                && gokei.getTxtKubunGendonaiTani().getValue().equals(new Decimal(currentRow.getTxtKubunGendonaiTani().toString()))
                && gokei.getTxtKyufuritsu().getValue().equals(new Decimal(currentRow.getTxtKyufuritsu().toString()))) {
            return false;
        }
        return true;
    }

    /**
     * yotakuJikoRiyohyoInfoの別票Tabの明細のデータ初期化
     *
     * @param panel panel
     */
    private void initRiyohyoBeppyoMeisaiData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        meisai.getTxtJigyoshaCode().clearValue();
        meisai.getTxtJigyoshaName().clearValue();
        meisai.getTxtServiceShuruiCode().clearValue();
        meisai.getTxtServiceCode().clearValue();
        meisai.getTxtServiceName().clearValue();
        meisai.getTxtTani().clearValue();
        meisai.getTxtWaribikigoRitsu().clearValue();
        meisai.getTxtWaribikigoTani().clearValue();
        meisai.getTxtKaisu().clearValue();
        meisai.getTxtServiceTani().clearValue();
    }

    /**
     * yotakuJikoRiyohyoInfoの別票Tabの合計のデータ初期化
     *
     * @param panel panel
     */
    private void initRiyohyoBeppyoGokeiData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
        gokei.getTxtShuruiGendoChokaTani().clearValue();
        gokei.getTxtShuruiGendonaiTani().clearValue();
        gokei.getTxtTanisuTanka().clearValue();
        gokei.getTxtKubunGendoChokaTani().clearValue();
        gokei.getTxtKubunGendonaiTani().clearValue();
        gokei.getTxtKyufuritsu().clearValue();
        gokei.getTxtHiyoSogaku().clearValue();
        gokei.getTxtHokenKyufugaku().clearValue();
        gokei.getTxtRiyoshaFutangakuHoken().clearValue();
        gokei.getTxtRiyoshaFutangakuZengaku().clearValue();
    }

    /**
     * yotakuJikoRiyohyoInfoの別票Tabの明細のデモ向けデータ設定
     *
     * @param panel panel
     */
    private void setRiyohyoBeppyoMeisaiDemoData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        meisai.getTxtJigyoshaCode().setValue(new RString("1111111111"));
        meisai.getTxtJigyoshaName().setValue(new RString("電算サービスセンター"));
        meisai.getTxtServiceShuruiCode().setValue(new RString("11"));
        meisai.getTxtServiceCode().setValue(new RString("1111"));
        meisai.getTxtServiceName().setValue(new RString("通所介護サービス"));
        meisai.getTxtTani().setValue(new Decimal("10"));
        meisai.getTxtWaribikigoRitsu().setValue(new Decimal("90"));
        meisai.getTxtWaribikigoTani().setValue(new Decimal("9"));
        meisai.getTxtKaisu().setValue(new Decimal("1"));
        meisai.getTxtServiceTani().setValue(new Decimal("588"));
    }

    /**
     * yotakuJikoRiyohyoInfoの別票Tabの合計のデモ向けデータ設定
     *
     * @param panel panel
     */
    private void setRiyohyoBeppyoGokeiDemoData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
        gokei.getTxtShuruiGendoChokaTani().setValue(new Decimal("0"));
        gokei.getTxtShuruiGendonaiTani().setValue(new Decimal("0"));
        gokei.getTxtTanisuTanka().setValue(new Decimal("10"));
        gokei.getTxtKubunGendoChokaTani().setValue(new Decimal("0"));
        gokei.getTxtKubunGendonaiTani().setValue(new Decimal("638"));
        gokei.getTxtKyufuritsu().setValue(new Decimal("90"));
        gokei.getTxtHiyoSogaku().setValue(new Decimal("6380"));
        gokei.getTxtHokenKyufugaku().setValue(new Decimal("5742"));
        gokei.getTxtRiyoshaFutangakuHoken().setValue(new Decimal("638"));
        gokei.getTxtRiyoshaFutangakuZengaku().setValue(new Decimal("0"));
    }

    /**
     * KyotakuJikoRiyohyoInfoの別票のPanel表示設定
     *
     * @param panel panel
     * @param 表示 表示
     */
    private void setRiyohyoBeppyoVisible(KyotakuJikoRiyohyoDiv panel, 別票画面表示 表示) {
        ServiceRiyohyoBeppyoDiv beppyo = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo();
        if (表示.equals(別票画面表示.初期表示)) {
            beppyo.getServiceRiyohyoBeppyoList().setVisible(true);
            beppyo.getServiceRiyohyoBeppyoList().setDisplayNone(false);
            beppyo.getServiceRiyohyoBeppyoMeisai().setVisible(false);
            beppyo.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
            beppyo.getServiceRiyohyoBeppyoGokei().setVisible(false);
            beppyo.getServiceRiyohyoBeppyoGokei().setDisplayNone(true);
        } else if (表示.equals(別票画面表示.明細)) {
            beppyo.getServiceRiyohyoBeppyoList().setVisible(true);
            beppyo.getServiceRiyohyoBeppyoList().setDisplayNone(false);
            beppyo.getServiceRiyohyoBeppyoMeisai().setVisible(true);
            beppyo.getServiceRiyohyoBeppyoMeisai().setDisplayNone(false);
            beppyo.getServiceRiyohyoBeppyoGokei().setVisible(false);
            beppyo.getServiceRiyohyoBeppyoGokei().setDisplayNone(true);
        } else if (表示.equals(別票画面表示.合計)) {
            beppyo.getServiceRiyohyoBeppyoList().setVisible(true);
            beppyo.getServiceRiyohyoBeppyoList().setDisplayNone(false);
            beppyo.getServiceRiyohyoBeppyoMeisai().setVisible(false);
            beppyo.getServiceRiyohyoBeppyoMeisai().setDisplayNone(true);
            beppyo.getServiceRiyohyoBeppyoGokei().setVisible(true);
            beppyo.getServiceRiyohyoBeppyoGokei().setDisplayNone(false);
        }
    }

    /**
     * 届出日など、タブ以外のデータの設定(前月分)
     *
     * @param panel panel
     */
    private void setSummaryZengetsuData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoInfoDiv info = panel.getKyotakuJikoRiyohyoInfo();
        info.getTxtTodokedeYMD().setValue(new RDate("20140501"));
        info.getTxtTekiyoKikan().setFromValue(new RDate("20140501"));
        info.getTxtTekiyoKikan().setToValue(new RDate("20140531"));
        info.getTxtTaishoYM().setValue(new RDate("20140601"));
        info.getTxtRiyohyoSakuseiYMD().setValue(new RDate("20140501"));
        info.getTxtRiyohyoTodokedeYMD().setValue(new RDate("20140501"));
        info.getTxtKubunShikyuGendogaku().setValue(new RString("30"));
        info.getTxtRiyohyoSakuseisha().setValue(new RString("電算　太郎"));
        info.getTxtGendoKanriKikan().setFromValue(new RDate("20140401"));
        info.getTxtGendoKanriKikan().setToValue(new RDate("20150331"));

    }

    /**
     * 届出日など、タブ以外のデータの設定
     *
     * @param panel panel
     */
    private void setSummaryData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoInfoDiv info = panel.getKyotakuJikoRiyohyoInfo();
        info.getTxtTodokedeYMD().setValue(new RDate("20140601"));
        info.getTxtTekiyoKikan().setFromValue(new RDate("20140601"));
        info.getTxtTekiyoKikan().clearToValue();
        info.getTxtTaishoYM().setValue(new RDate("20140701"));
        info.getTxtRiyohyoSakuseiYMD().setValue(new RDate("20140601"));
        info.getTxtRiyohyoTodokedeYMD().setValue(new RDate("20140601"));
        info.getTxtKubunShikyuGendogaku().setValue(new RString("30"));
        info.getTxtRiyohyoSakuseisha().setValue(new RString("電算　太郎"));
        info.getTxtGendoKanriKikan().setFromValue(new RDate("20140401"));
        info.getTxtGendoKanriKikan().setToValue(new RDate("20150331"));

    }

    /**
     * サービス利用票タブの曜日の設定
     *
     * @param panel panel
     */
    private void setServiceRiyohyoYobi(KyotakuJikoRiyohyoDiv panel) {
        RDate taishoYMD = new RDate(panel.getKyotakuJikoRiyohyoInfo().getTxtTaishoYM().getValue().getYearMonth().toString().concat("01"));
        ServiceRiyohyoDiv riyohyo = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyo();
        DataGrid<dgServiceRiyohyoList_Row> dg = riyohyo.getDgServiceRiyohyoList();
        int dateNum = taishoYMD.getLastDay();
        for (int i = 0; i < dateNum; i++) {
            RString txtDay = new RString("txtDay").concat(String.valueOf(i + 1));
            DataGridColumn column = dg.getGridSetting().getColumn(txtDay);
            column.setColumnName(new RString(taishoYMD.getDayOfWeek().getShortTerm()));
            taishoYMD = taishoYMD.plusDay(1);
        }
    }

    /**
     * サービス利用票タブのデータ設定
     *
     * @param panel panel
     */
    private void setServiceRiyohyoZengetsuData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoDiv riyohyo = panel.getKyotakuJikoRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyo();
        List<dgServiceRiyohyoList_Row> dgRowList = riyohyo.getDgServiceRiyohyoList().getDataSource();
        dgRowList.clear();
        Button btnDelete = new Button();
        Button btnService = new Button();
        Button btnJigyosha = new Button();

        dgServiceRiyohyoList_Row rowItem = createサービス利用票(btnDelete,
                "10:00",
                "15:00",
                btnService,
                "111111:通所介護",
                btnJigyosha,
                "1111111111:電算介護サービス",
                "予",
                "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
                "2", "2", "2", "2", "2", "2", "2", "2", "2", "2",
                "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3",
                "63");
        dgRowList.add(rowItem);
        rowItem = createサービス利用票(btnDelete,
                "",
                "",
                btnService,
                "",
                btnJigyosha,
                "",
                "実",
                "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
                "2", "2", "2", "2", "2", "2", "2", "2", "2", "2",
                "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3",
                "63");
        dgRowList.add(rowItem);
        riyohyo.getDgServiceRiyohyoList().setDataSource(dgRowList);
    }

    private void setServiceRiyohyoBeppyoData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoDiv beppyo = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo();
        ServiceRiyohyoBeppyoRiyoNissuDiv nissu = beppyo.getServiceRiyohyoBeppyoRiyoNissu();
        setBeppyoNissuData(nissu);
        initRiyohyoBeppyoMeisaiData(panel);
        initRiyohyoBeppyoGokeiData(panel);
    }

    private void setBeppyoNissuData(ServiceRiyohyoBeppyoRiyoNissuDiv nissu) {
        nissu.getTxtZengetsuRiyoNissu().setValue(new Decimal("30"));
        nissu.getTxtTogetsuRiyoNissu().setValue(new Decimal("30"));
        nissu.getTxtRuikeiRiyoNissu().setValue(new Decimal("60"));
    }

    private void setServiceRiyohyoBeppyoZengetsuData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoDiv beppyo = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo();
        ServiceRiyohyoBeppyoRiyoNissuDiv nissu = beppyo.getServiceRiyohyoBeppyoRiyoNissu();
        ServiceRiyohyoBeppyoListDiv list = beppyo.getServiceRiyohyoBeppyoList();
        setBeppyoNissuZengetsuData(nissu);
        setBeppyoListZengetsuData(list);
        initRiyohyoBeppyoMeisaiData(panel);
        initRiyohyoBeppyoGokeiData(panel);
    }

    private void setBeppyoNissuZengetsuData(ServiceRiyohyoBeppyoRiyoNissuDiv nissu) {
        nissu.getTxtZengetsuRiyoNissu().setValue(new Decimal("0"));
        nissu.getTxtTogetsuRiyoNissu().setValue(new Decimal("30"));
        nissu.getTxtRuikeiRiyoNissu().setValue(new Decimal("30"));
    }

    private void setBeppyoListZengetsuData(ServiceRiyohyoBeppyoListDiv list) {
        List<dgServiceRiyohyoBeppyoList_Row> listRow = list.getDgServiceRiyohyoBeppyoList().getDataSource();
        listRow.clear();
        Button btnSelect = new Button();
        Button btnDelete = new Button();

        dgServiceRiyohyoBeppyoList_Row rowItem = create別票一覧リスト(btnSelect, btnDelete,
                "1111111111:電算サービスセンター", "111111:通所介護１１１", "10.00", "90", "9", "1", "588", "", "", "", "", "", "", "", "", "", "");
        listRow.add(rowItem);
        rowItem = create別票一覧リスト(btnSelect, btnDelete,
                "1111111111:電算サービスセンター", "111112:通所介護１１２", "10.00", "90", "9", "1", "50", "", "", "", "", "", "", "", "", "", "");
        listRow.add(rowItem);
        rowItem = create別票一覧リスト(btnSelect, btnDelete,
                "1111111111:電算サービスセンター", "111111:通所介護合計", "", "", "", "", "(638)", "0", "0", "0", "638", "10", "6380", "90", "5742", "638", "0");
        listRow.add(rowItem);
        list.getDgServiceRiyohyoBeppyoList().setDataSource(listRow);
    }

    private dgServiceRiyohyoBeppyoList_Row create別票一覧リスト(
            Button btnSelect,
            Button btnDelete,
            String txtJigyosha,
            String txtService,
            String txtTani,
            String txtWaribikigoRitsu,
            String txtWaribikigoTani,
            String txtKaisu,
            String txtServiceTani,
            String txtShuruiGendoChokaTani,
            String txtShuruiGendonaiTani,
            String txtKubunGendoChokaTani,
            String txtKubunGendonaiTani,
            String txtTanisuTanka,
            String txtHiyoSogaku,
            String txtKyufuritsu,
            String txtHokenFutangaku,
            String txtRiyoshaFutangakuHoken,
            String txtRiyoshaFutangakuZengaku
    ) {

        return new dgServiceRiyohyoBeppyoList_Row(
                btnSelect,
                btnDelete,
                new RString(txtJigyosha),
                new RString(txtService),
                new RString(txtTani),
                new RString(txtWaribikigoRitsu),
                new RString(txtWaribikigoTani),
                new RString(txtKaisu),
                new RString(txtServiceTani),
                new RString(txtShuruiGendoChokaTani),
                new RString(txtShuruiGendonaiTani),
                new RString(txtKubunGendoChokaTani),
                new RString(txtKubunGendonaiTani),
                new RString(txtTanisuTanka),
                new RString(txtHiyoSogaku),
                new RString(txtKyufuritsu),
                new RString(txtHokenFutangaku),
                new RString(txtRiyoshaFutangakuHoken),
                new RString(txtRiyoshaFutangakuZengaku)
        );

    }

    private dgServiceRiyohyoList_Row createサービス利用票(Button btnDelete,
            String txtKaishi,
            String txtShuryo,
            Button btnService,
            String txtService,
            Button btnJigyosha,
            String txtJigyosha,
            String txtYoJitsu,
            String txtDay1, String txtDay2, String txtDay3, String txtDay4, String txtDay5,
            String txtDay6, String txtDay7, String txtDay8, String txtDay9, String txtDay10,
            String txtDay11, String txtDay12, String txtDay13, String txtDay14, String txtDay15,
            String txtDay16, String txtDay17, String txtDay18, String txtDay19, String txtDay20,
            String txtDay21, String txtDay22, String txtDay23, String txtDay24, String txtDay25,
            String txtDay26, String txtDay27, String txtDay28, String txtDay29, String txtDay30,
            String txtDay31, String txtGokei) {

        TextBox txtBoxKaishi = new TextBox();
        TextBox txtBoxShuryo = new TextBox();
        txtBoxKaishi.setValue(new RString(txtKaishi));
        txtBoxShuryo.setValue(new RString(txtShuryo));
        TextBoxNum txtBoxDay1 = new TextBoxNum();
        TextBoxNum txtBoxDay2 = new TextBoxNum();
        TextBoxNum txtBoxDay3 = new TextBoxNum();
        TextBoxNum txtBoxDay4 = new TextBoxNum();
        TextBoxNum txtBoxDay5 = new TextBoxNum();
        TextBoxNum txtBoxDay6 = new TextBoxNum();
        TextBoxNum txtBoxDay7 = new TextBoxNum();
        TextBoxNum txtBoxDay8 = new TextBoxNum();
        TextBoxNum txtBoxDay9 = new TextBoxNum();
        TextBoxNum txtBoxDay10 = new TextBoxNum();
        TextBoxNum txtBoxDay11 = new TextBoxNum();
        TextBoxNum txtBoxDay12 = new TextBoxNum();
        TextBoxNum txtBoxDay13 = new TextBoxNum();
        TextBoxNum txtBoxDay14 = new TextBoxNum();
        TextBoxNum txtBoxDay15 = new TextBoxNum();
        TextBoxNum txtBoxDay16 = new TextBoxNum();
        TextBoxNum txtBoxDay17 = new TextBoxNum();
        TextBoxNum txtBoxDay18 = new TextBoxNum();
        TextBoxNum txtBoxDay19 = new TextBoxNum();
        TextBoxNum txtBoxDay20 = new TextBoxNum();
        TextBoxNum txtBoxDay21 = new TextBoxNum();
        TextBoxNum txtBoxDay22 = new TextBoxNum();
        TextBoxNum txtBoxDay23 = new TextBoxNum();
        TextBoxNum txtBoxDay24 = new TextBoxNum();
        TextBoxNum txtBoxDay25 = new TextBoxNum();
        TextBoxNum txtBoxDay26 = new TextBoxNum();
        TextBoxNum txtBoxDay27 = new TextBoxNum();
        TextBoxNum txtBoxDay28 = new TextBoxNum();
        TextBoxNum txtBoxDay29 = new TextBoxNum();
        TextBoxNum txtBoxDay30 = new TextBoxNum();
        TextBoxNum txtBoxDay31 = new TextBoxNum();
        txtBoxDay1.setValue(new Decimal(txtDay1));
        txtBoxDay2.setValue(new Decimal(txtDay2));
        txtBoxDay3.setValue(new Decimal(txtDay3));
        txtBoxDay4.setValue(new Decimal(txtDay4));
        txtBoxDay5.setValue(new Decimal(txtDay5));
        txtBoxDay6.setValue(new Decimal(txtDay6));
        txtBoxDay7.setValue(new Decimal(txtDay7));
        txtBoxDay8.setValue(new Decimal(txtDay8));
        txtBoxDay9.setValue(new Decimal(txtDay9));
        txtBoxDay10.setValue(new Decimal(txtDay10));
        txtBoxDay11.setValue(new Decimal(txtDay11));
        txtBoxDay12.setValue(new Decimal(txtDay12));
        txtBoxDay13.setValue(new Decimal(txtDay13));
        txtBoxDay14.setValue(new Decimal(txtDay14));
        txtBoxDay15.setValue(new Decimal(txtDay15));
        txtBoxDay16.setValue(new Decimal(txtDay16));
        txtBoxDay17.setValue(new Decimal(txtDay17));
        txtBoxDay18.setValue(new Decimal(txtDay18));
        txtBoxDay19.setValue(new Decimal(txtDay19));
        txtBoxDay20.setValue(new Decimal(txtDay20));
        txtBoxDay21.setValue(new Decimal(txtDay21));
        txtBoxDay22.setValue(new Decimal(txtDay22));
        txtBoxDay23.setValue(new Decimal(txtDay23));
        txtBoxDay24.setValue(new Decimal(txtDay24));
        txtBoxDay25.setValue(new Decimal(txtDay25));
        txtBoxDay26.setValue(new Decimal(txtDay26));
        txtBoxDay27.setValue(new Decimal(txtDay27));
        txtBoxDay28.setValue(new Decimal(txtDay28));
        txtBoxDay29.setValue(new Decimal(txtDay29));
        txtBoxDay30.setValue(new Decimal(txtDay30));
        txtBoxDay31.setValue(new Decimal(txtDay31));

        return new dgServiceRiyohyoList_Row(
                btnDelete,
                txtBoxKaishi,
                txtBoxShuryo,
                btnService,
                new RString(txtService),
                btnJigyosha,
                new RString(txtJigyosha),
                new RString(txtYoJitsu),
                txtBoxDay1, txtBoxDay2, txtBoxDay3, txtBoxDay4, txtBoxDay5,
                txtBoxDay6, txtBoxDay7, txtBoxDay8, txtBoxDay9, txtBoxDay10,
                txtBoxDay11, txtBoxDay12, txtBoxDay13, txtBoxDay14, txtBoxDay15,
                txtBoxDay16, txtBoxDay17, txtBoxDay18, txtBoxDay19, txtBoxDay20,
                txtBoxDay21, txtBoxDay22, txtBoxDay23, txtBoxDay24, txtBoxDay25,
                txtBoxDay26, txtBoxDay27, txtBoxDay28, txtBoxDay29, txtBoxDay30, txtBoxDay31,
                new RString(txtGokei));
    }

}
