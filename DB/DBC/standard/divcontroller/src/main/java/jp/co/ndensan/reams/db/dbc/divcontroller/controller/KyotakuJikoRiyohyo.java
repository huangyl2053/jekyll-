/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
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
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
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

    private List<HashMap> getYaml() {
        return YamlLoader.DBC.loadAsList(new RString("dbc0120000/KyotakuJikoRiyohyo.yml"));
    }

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

        for (int index = 0; index < 2; index++) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(index));
            dgServiceRiyohyoList_Row rowItem = createサービス利用票(
                    btnDelete,
                    cg.getAsRString("提供開始時刻"),
                    cg.getAsRString("提供終了時刻"),
                    btnService,
                    cg.getAsRString("サービス内容"),
                    btnJigyosha,
                    cg.getAsRString("サービス事業者"),
                    cg.getAsRString("予定実績"),
                    cg.getAsRString("1日"),
                    cg.getAsRString("2日"),
                    cg.getAsRString("3日"),
                    cg.getAsRString("4日"),
                    cg.getAsRString("5日"),
                    cg.getAsRString("6日"),
                    cg.getAsRString("7日"),
                    cg.getAsRString("8日"),
                    cg.getAsRString("9日"),
                    cg.getAsRString("10日"),
                    cg.getAsRString("11日"),
                    cg.getAsRString("12日"),
                    cg.getAsRString("13日"),
                    cg.getAsRString("14日"),
                    cg.getAsRString("15日"),
                    cg.getAsRString("16日"),
                    cg.getAsRString("17日"),
                    cg.getAsRString("18日"),
                    cg.getAsRString("19日"),
                    cg.getAsRString("20日"),
                    cg.getAsRString("21日"),
                    cg.getAsRString("22日"),
                    cg.getAsRString("23日"),
                    cg.getAsRString("24日"),
                    cg.getAsRString("25日"),
                    cg.getAsRString("26日"),
                    cg.getAsRString("27日"),
                    cg.getAsRString("28日"),
                    cg.getAsRString("29日"),
                    cg.getAsRString("30日"),
                    cg.getAsRString("31日"),
                    cg.getAsRString("合計"));
            dgRiyohyoList.add(rowItem);
        }
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
        setRiyohyoBeppyoMeisaiData(panel);
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
        setRiyohyoBeppyoGokeiData(panel);
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
                jigyosha,
                service,
                new RString(meisai.getTxtTani().getValue().toString()),
                new RString(meisai.getTxtWaribikigoRitsu().getValue().toString()),
                new RString(meisai.getTxtWaribikigoTani().getValue().toString()),
                new RString(meisai.getTxtKaisu().getValue().toString()),
                new RString(meisai.getTxtServiceTani().getValue().toString()),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
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
        ControlGenerator cg = new ControlGenerator(getYaml().get(2));
        rowItem = create別票一覧リスト(btnSelect, btnDelete,
                cg.getAsRString("サービス事業者"),
                cg.getAsRString("サービス内容"),
                cg.getAsRString("単位"),
                cg.getAsRString("割引後率"),
                cg.getAsRString("割引後単位"),
                cg.getAsRString("回数"),
                cg.getAsRString("サービス単位"),
                new RString(gokei.getTxtShuruiGendoChokaTani().getValue().toString()),
                new RString(gokei.getTxtShuruiGendonaiTani().getValue().toString()),
                new RString(gokei.getTxtKubunGendoChokaTani().getValue().toString()),
                new RString(gokei.getTxtKubunGendonaiTani().getValue().toString()),
                new RString(gokei.getTxtTanisuTanka().getValue().toString()),
                new RString(gokei.getTxtHiyoSogaku().getValue().toString()),
                new RString(gokei.getTxtKyufuritsu().getValue().toString()),
                new RString(gokei.getTxtHokenKyufugaku().getValue().toString()),
                new RString(gokei.getTxtRiyoshaFutangakuHoken().getValue().toString()),
                new RString(gokei.getTxtRiyoshaFutangakuZengaku().getValue().toString()));
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
     * KyotakuJikoRiyohyoInfoの別票Tabの明細のデータ初期化
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
     * KyotakuJikoRiyohyoInfoの別票Tabの合計のデータ初期化
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
     * KyotakuJikoRiyohyoInfoの別票Tabの明細のデモ向けデータ設定
     *
     * @param panel panel
     */
    private void setRiyohyoBeppyoMeisaiData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        ControlGenerator cg = new ControlGenerator(getYaml().get(3));
        meisai.getTxtJigyoshaCode().setValue(cg.getAsRString("事業者コード"));
        meisai.getTxtJigyoshaName().setValue(cg.getAsRString("事業者名"));
        meisai.getTxtServiceShuruiCode().setValue(cg.getAsRString("サービス種類コード"));
        meisai.getTxtServiceCode().setValue(cg.getAsRString("サービスコード"));
        meisai.getTxtServiceName().setValue(cg.getAsRString("サービス名称"));
        meisai.getTxtTani().setValue(cg.getAsDecimal("単位"));
        meisai.getTxtWaribikigoRitsu().setValue(cg.getAsDecimal("割引後率"));
        meisai.getTxtWaribikigoTani().setValue(cg.getAsDecimal("割引後単位"));
        meisai.getTxtKaisu().setValue(cg.getAsDecimal("回数"));
        meisai.getTxtServiceTani().setValue(cg.getAsDecimal("サービス単位"));
    }

    /**
     * KyotakuJikoRiyohyoInfoの別票Tabの合計のデモ向けデータ設定
     *
     * @param panel panel
     */
    private void setRiyohyoBeppyoGokeiData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getKyotakuJikoRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
        ControlGenerator cg = new ControlGenerator(getYaml().get(4));
        gokei.getTxtShuruiGendoChokaTani().setValue(cg.getAsDecimal("種類限度超過単位"));
        gokei.getTxtShuruiGendonaiTani().setValue(cg.getAsDecimal("種類限度内単位"));
        gokei.getTxtTanisuTanka().setValue(cg.getAsDecimal("単位数単価"));
        gokei.getTxtKubunGendoChokaTani().setValue(cg.getAsDecimal("区分限度超過単位"));
        gokei.getTxtKubunGendonaiTani().setValue(cg.getAsDecimal("区分限度内単位"));
        gokei.getTxtKyufuritsu().setValue(cg.getAsDecimal("給付率"));
        gokei.getTxtHiyoSogaku().setValue(cg.getAsDecimal("費用総額"));
        gokei.getTxtHokenKyufugaku().setValue(cg.getAsDecimal("保険給付額"));
        gokei.getTxtRiyoshaFutangakuHoken().setValue(cg.getAsDecimal("利用者負担額保険"));
        gokei.getTxtRiyoshaFutangakuZengaku().setValue(cg.getAsDecimal("利用者負担額全額"));
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
        ControlGenerator cg = new ControlGenerator(getYaml().get(5));
        info.getTxtTodokedeYMD().setValue(cg.getAsRDate("届出日"));
        info.getTxtTekiyoKikan().setFromValue(cg.getAsRDate("適用期間開始日"));
        info.getTxtTekiyoKikan().setToValue(cg.getAsRDate("適用期間終了日"));
        info.getTxtTaishoYM().setValue(cg.getAsRDate("対象年月"));
        info.getTxtRiyohyoSakuseiYMD().setValue(cg.getAsRDate("利用票作成年月日"));
        info.getTxtRiyohyoTodokedeYMD().setValue(cg.getAsRDate("利用票届出年月日"));
        info.getTxtKubunShikyuGendogaku().setValue(cg.getAsRString("区分支給限度額"));
        info.getTxtRiyohyoSakuseisha().setValue(cg.getAsRString("利用票作成者"));
        info.getTxtGendoKanriKikan().setFromValue(cg.getAsRDate("限度開始期間開始日"));
        info.getTxtGendoKanriKikan().setToValue(cg.getAsRDate("限度開始期間終了日"));
    }

    /**
     * 届出日など、タブ以外のデータの設定
     *
     * @param panel panel
     */
    private void setSummaryData(KyotakuJikoRiyohyoDiv panel) {
        ServiceRiyohyoInfoDiv info = panel.getKyotakuJikoRiyohyoInfo();
        ControlGenerator cg = new ControlGenerator(getYaml().get(6));
        info.getTxtTodokedeYMD().setValue(cg.getAsRDate("届出日"));
        info.getTxtTekiyoKikan().setFromValue(cg.getAsRDate("適用期間開始日"));
        info.getTxtTekiyoKikan().clearToValue();
        info.getTxtTaishoYM().setValue(cg.getAsRDate("対象年月"));
        info.getTxtRiyohyoSakuseiYMD().setValue(cg.getAsRDate("利用票作成年月日"));
        info.getTxtRiyohyoTodokedeYMD().setValue(cg.getAsRDate("利用票届出年月日"));
        info.getTxtKubunShikyuGendogaku().setValue(cg.getAsRString("区分支給限度額"));
        info.getTxtRiyohyoSakuseisha().setValue(cg.getAsRString("利用票作成者"));
        info.getTxtGendoKanriKikan().setFromValue(cg.getAsRDate("限度開始期間開始日"));
        info.getTxtGendoKanriKikan().setToValue(cg.getAsRDate("限度開始期間終了日"));
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

//        dgServiceRiyohyoList_Row rowItem = createサービス利用票(btnDelete,
//                "10:00",
//                "15:00",
//                btnService,
//                "111111:通所介護",
//                btnJigyosha,
//                "1111111111:電算介護サービス",
//                "予",
//                "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
//                "2", "2", "2", "2", "2", "2", "2", "2", "2", "2",
//                "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3",
//                "63");
//        dgRowList.add(rowItem);
        for (int index = 7; index < 9; index++) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(index));
            dgServiceRiyohyoList_Row rowItem = createサービス利用票(
                    btnDelete,
                    cg.getAsRString("提供開始時刻"),
                    cg.getAsRString("提供終了時刻"),
                    btnService,
                    cg.getAsRString("サービス内容"),
                    btnJigyosha,
                    cg.getAsRString("サービス事業者"),
                    cg.getAsRString("予定実績"),
                    cg.getAsRString("1日"),
                    cg.getAsRString("2日"),
                    cg.getAsRString("3日"),
                    cg.getAsRString("4日"),
                    cg.getAsRString("5日"),
                    cg.getAsRString("6日"),
                    cg.getAsRString("7日"),
                    cg.getAsRString("8日"),
                    cg.getAsRString("9日"),
                    cg.getAsRString("10日"),
                    cg.getAsRString("11日"),
                    cg.getAsRString("12日"),
                    cg.getAsRString("13日"),
                    cg.getAsRString("14日"),
                    cg.getAsRString("15日"),
                    cg.getAsRString("16日"),
                    cg.getAsRString("17日"),
                    cg.getAsRString("18日"),
                    cg.getAsRString("19日"),
                    cg.getAsRString("20日"),
                    cg.getAsRString("21日"),
                    cg.getAsRString("22日"),
                    cg.getAsRString("23日"),
                    cg.getAsRString("24日"),
                    cg.getAsRString("25日"),
                    cg.getAsRString("26日"),
                    cg.getAsRString("27日"),
                    cg.getAsRString("28日"),
                    cg.getAsRString("29日"),
                    cg.getAsRString("30日"),
                    cg.getAsRString("31日"),
                    cg.getAsRString("合計"));
            dgRowList.add(rowItem);
        }
//        rowItem = createサービス利用票(btnDelete,
//                "",
//                "",
//                btnService,
//                "",
//                btnJigyosha,
//                "",
//                "実",
//                "1", "1", "1", "1", "1", "1", "1", "1", "1", "1",
//                "2", "2", "2", "2", "2", "2", "2", "2", "2", "2",
//                "3", "3", "3", "3", "3", "3", "3", "3", "3", "3", "3",
//                "63");
//        dgRowList.add(rowItem);
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
        ControlGenerator cg = new ControlGenerator(getYaml().get(9));
        nissu.getTxtZengetsuRiyoNissu().setValue(cg.getAsDecimal("前月利用日数"));
        nissu.getTxtTogetsuRiyoNissu().setValue(cg.getAsDecimal("当月利用日数"));
        nissu.getTxtRuikeiRiyoNissu().setValue(cg.getAsDecimal("累計利用日数"));
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
        ControlGenerator cg = new ControlGenerator(getYaml().get(10));
        nissu.getTxtZengetsuRiyoNissu().setValue(cg.getAsDecimal("前月利用日数"));
        nissu.getTxtTogetsuRiyoNissu().setValue(cg.getAsDecimal("当月利用日数"));
        nissu.getTxtRuikeiRiyoNissu().setValue(cg.getAsDecimal("累計利用日数"));
//        nissu.getTxtZengetsuRiyoNissu().setValue(new Decimal("0"));
//        nissu.getTxtTogetsuRiyoNissu().setValue(new Decimal("30"));
//        nissu.getTxtRuikeiRiyoNissu().setValue(new Decimal("30"));
    }

    private void setBeppyoListZengetsuData(ServiceRiyohyoBeppyoListDiv list) {
        List<dgServiceRiyohyoBeppyoList_Row> listRow = list.getDgServiceRiyohyoBeppyoList().getDataSource();
        listRow.clear();
        Button btnSelect = new Button();
        Button btnDelete = new Button();

        dgServiceRiyohyoBeppyoList_Row rowItem;
//        rowItem = create別票一覧リスト(btnSelect, btnDelete,
//                "1111111111:電算サービスセンター", "111111:通所介護１１１", "10.00", "90", "9", "1", "588", "", "", "", "", "", "", "", "", "", "");
//        listRow.add(rowItem);
        for (int index = 11; index < 14; index++) {
            ControlGenerator cg = new ControlGenerator(getYaml().get(index));
            rowItem = create別票一覧リスト(
                    btnSelect,
                    btnDelete,
                    cg.getAsRString("事業者"),
                    cg.getAsRString("サービス"),
                    cg.getAsRString("単位"),
                    cg.getAsRString("割引後率"),
                    cg.getAsRString("割引後単位"),
                    cg.getAsRString("回数"),
                    cg.getAsRString("サービス単位"),
                    cg.getAsRString("種類限度超過単位"),
                    cg.getAsRString("種類限度内単位"),
                    cg.getAsRString("区分限度超過単位"),
                    cg.getAsRString("区分限度内単位"),
                    cg.getAsRString("単位数単価"),
                    cg.getAsRString("費用総額"),
                    cg.getAsRString("給付率"),
                    cg.getAsRString("保険給付額"),
                    cg.getAsRString("利用者負担額保険"),
                    cg.getAsRString("利用者負担額全額"));
            listRow.add(rowItem);
//  事業者: !!str "1111111111:電算サービスセンター"
//  サービス: !!str "111111:通所介護合計"
//  単位: !!str ""
//  割引後率: !!str ""
//  割引後単位: !!str ""
//  回数: !!str ""
//  サービス単位: !!str "(638)"
//  種類限度超過単位: !!str "0"
//  種類限度内単位: !!str "0"
//  単位数単価: !!str "0"
//  区分限度超過単位: !!str "638"
//  区分限度内単位: !!str "10"
//  給付率: !!str "6380"
//  費用総額: !!str "90"
//  保険給付額: !!str "5742"
//  利用者負担額保険: !!str "638"
//  利用者負担額全額: !!str "0"
        }
//        rowItem = create別票一覧リスト(btnSelect, btnDelete,
//                "1111111111:電算サービスセンター", "111112:通所介護１１２", "10.00", "90", "9", "1", "50", "", "", "", "", "", "", "", "", "", "");
//        listRow.add(rowItem);
//        rowItem = create別票一覧リスト(btnSelect, btnDelete,
//                "1111111111:電算サービスセンター", "111111:通所介護合計", "", "", "", "", "(638)", "0", "0", "0", "638", "10", "6380", "90", "5742", "638", "0");
//        listRow.add(rowItem);
        list.getDgServiceRiyohyoBeppyoList().setDataSource(listRow);
    }

    private dgServiceRiyohyoBeppyoList_Row create別票一覧リスト(
            Button btnSelect,
            Button btnDelete,
            RString txtJigyosha,
            RString txtService,
            RString txtTani,
            RString txtWaribikigoRitsu,
            RString txtWaribikigoTani,
            RString txtKaisu,
            RString txtServiceTani,
            RString txtShuruiGendoChokaTani,
            RString txtShuruiGendonaiTani,
            RString txtKubunGendoChokaTani,
            RString txtKubunGendonaiTani,
            RString txtTanisuTanka,
            RString txtHiyoSogaku,
            RString txtKyufuritsu,
            RString txtHokenFutangaku,
            RString txtRiyoshaFutangakuHoken,
            RString txtRiyoshaFutangakuZengaku
    ) {

        return new dgServiceRiyohyoBeppyoList_Row(
                btnSelect,
                btnDelete,
                txtJigyosha,
                txtService,
                txtTani,
                txtWaribikigoRitsu,
                txtWaribikigoTani,
                txtKaisu,
                txtServiceTani,
                txtShuruiGendoChokaTani,
                txtShuruiGendonaiTani,
                txtKubunGendoChokaTani,
                txtKubunGendonaiTani,
                txtTanisuTanka,
                txtHiyoSogaku,
                txtKyufuritsu,
                txtHokenFutangaku,
                txtRiyoshaFutangakuHoken,
                txtRiyoshaFutangakuZengaku);

    }

    private dgServiceRiyohyoList_Row createサービス利用票(
            Button btnDelete,
            RString txtKaishi,
            RString txtShuryo,
            Button btnService,
            RString txtService,
            Button btnJigyosha,
            RString txtJigyosha,
            RString txtYoJitsu,
            RString txtDay1, RString txtDay2, RString txtDay3, RString txtDay4, RString txtDay5,
            RString txtDay6, RString txtDay7, RString txtDay8, RString txtDay9, RString txtDay10,
            RString txtDay11, RString txtDay12, RString txtDay13, RString txtDay14, RString txtDay15,
            RString txtDay16, RString txtDay17, RString txtDay18, RString txtDay19, RString txtDay20,
            RString txtDay21, RString txtDay22, RString txtDay23, RString txtDay24, RString txtDay25,
            RString txtDay26, RString txtDay27, RString txtDay28, RString txtDay29, RString txtDay30,
            RString txtDay31, RString txtGokei) {

        TextBox txtBoxKaishi = new TextBox();
        TextBox txtBoxShuryo = new TextBox();
        txtBoxKaishi.setValue(txtKaishi);
        txtBoxShuryo.setValue(txtShuryo);
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
        txtBoxDay1.setValue(new Decimal(txtDay1.toString()));
        txtBoxDay2.setValue(new Decimal(txtDay2.toString()));
        txtBoxDay3.setValue(new Decimal(txtDay3.toString()));
        txtBoxDay4.setValue(new Decimal(txtDay4.toString()));
        txtBoxDay5.setValue(new Decimal(txtDay5.toString()));
        txtBoxDay6.setValue(new Decimal(txtDay6.toString()));
        txtBoxDay7.setValue(new Decimal(txtDay7.toString()));
        txtBoxDay8.setValue(new Decimal(txtDay8.toString()));
        txtBoxDay9.setValue(new Decimal(txtDay9.toString()));
        txtBoxDay10.setValue(new Decimal(txtDay10.toString()));
        txtBoxDay11.setValue(new Decimal(txtDay11.toString()));
        txtBoxDay12.setValue(new Decimal(txtDay12.toString()));
        txtBoxDay13.setValue(new Decimal(txtDay13.toString()));
        txtBoxDay14.setValue(new Decimal(txtDay14.toString()));
        txtBoxDay15.setValue(new Decimal(txtDay15.toString()));
        txtBoxDay16.setValue(new Decimal(txtDay16.toString()));
        txtBoxDay17.setValue(new Decimal(txtDay17.toString()));
        txtBoxDay18.setValue(new Decimal(txtDay18.toString()));
        txtBoxDay19.setValue(new Decimal(txtDay19.toString()));
        txtBoxDay20.setValue(new Decimal(txtDay20.toString()));
        txtBoxDay21.setValue(new Decimal(txtDay21.toString()));
        txtBoxDay22.setValue(new Decimal(txtDay22.toString()));
        txtBoxDay23.setValue(new Decimal(txtDay23.toString()));
        txtBoxDay24.setValue(new Decimal(txtDay24.toString()));
        txtBoxDay25.setValue(new Decimal(txtDay25.toString()));
        txtBoxDay26.setValue(new Decimal(txtDay26.toString()));
        txtBoxDay27.setValue(new Decimal(txtDay27.toString()));
        txtBoxDay28.setValue(new Decimal(txtDay28.toString()));
        txtBoxDay29.setValue(new Decimal(txtDay29.toString()));
        txtBoxDay30.setValue(new Decimal(txtDay30.toString()));
        txtBoxDay31.setValue(new Decimal(txtDay31.toString()));

        return new dgServiceRiyohyoList_Row(
                btnDelete,
                txtBoxKaishi,
                txtBoxShuryo,
                btnService,
                txtService,
                btnJigyosha,
                txtJigyosha,
                txtYoJitsu,
                txtBoxDay1, txtBoxDay2, txtBoxDay3, txtBoxDay4, txtBoxDay5,
                txtBoxDay6, txtBoxDay7, txtBoxDay8, txtBoxDay9, txtBoxDay10,
                txtBoxDay11, txtBoxDay12, txtBoxDay13, txtBoxDay14, txtBoxDay15,
                txtBoxDay16, txtBoxDay17, txtBoxDay18, txtBoxDay19, txtBoxDay20,
                txtBoxDay21, txtBoxDay22, txtBoxDay23, txtBoxDay24, txtBoxDay25,
                txtBoxDay26, txtBoxDay27, txtBoxDay28, txtBoxDay29, txtBoxDay30, txtBoxDay31,
                txtGokei);
    }

}
