/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoBeppyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoBeppyoGokeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoBeppyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoBeppyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.ServiceRiyohyoInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SogoJigyohiRiyohyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.dgServiceRiyohyoBeppyoList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.dgServiceRiyohyoList_Row;
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
 * 総合事業費サービス利用票登録の総合事業費サービス利用票のコントロールクラスです。
 *
 * @author N8187 久保田 英男
 */
public class SogoJigyohiRiyohyo {

    private enum 別票画面表示 {

        初期表示,
        明細,
        合計
    }

    /**
     * 画面ロード時の処理です。
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onLoad(SogoJigyohiRiyohyoDiv panel) {
        ResponseData<SogoJigyohiRiyohyoDiv> response = new ResponseData<>();
        setSummaryData(panel);
        setRiyohyoYobi(panel);
        initBeppyoData(panel);
        setBeppyoVisible(panel, 別票画面表示.初期表示);
// TODO N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンをDisableにする。共通パネルの仕様が固まってから対応する。
//        kyotsu.getBtnRiyohyoSave().setDisabled(true);
        response.data = panel;
        return response;
    }

    /**
     * 「前月の情報をコピー」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickZengetsuCopy(SogoJigyohiRiyohyoDiv panel) {
        ResponseData<SogoJigyohiRiyohyoDiv> response = new ResponseData<>();
        setSummaryZengetsuData(panel);
        setRiyohyoYobi(panel);
        setZengetsuData(panel);
        setBeppyoZengetsuData(panel);
// TODO N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンを有効/無効にする。共通パネルの仕様が固まってから対応する。
//        validateRiyohyoSave(panel, kyotsu);
        response.data = panel;
        return response;
    }

    /**
     * サービス利用票Tabの「明細行を追加する」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickRiyohyoMeisaiAdd(SogoJigyohiRiyohyoDiv panel) {
        ResponseData<SogoJigyohiRiyohyoDiv> response = new ResponseData<>();
        DataGrid<dgServiceRiyohyoList_Row> dgRiyohyo = panel.getSogoJigyohiRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyo().getDgServiceRiyohyoList();
        List<dgServiceRiyohyoList_Row> dgRiyohyoList = dgRiyohyo.getDataSource();

        for (int yamlIndex = 0; yamlIndex < 2; yamlIndex++) {
            dgServiceRiyohyoList_Row rowItem = createサービス利用票(yamlIndex);
            dgRiyohyoList.add(rowItem);
        }
        dgRiyohyo.setDataSource(dgRiyohyoList);
// TODO N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンを有効/無効にする。共通パネルの仕様が固まってから対応する。
//        validateRiyohyoSave(panel, kyotsu);
        response.data = panel;
        return response;
    }

    /**
     * サービス利用票Tabの明細表の削除ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickListDelete(SogoJigyohiRiyohyoDiv panel) {
        ResponseData<SogoJigyohiRiyohyoDiv> response = new ResponseData<>();
        panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyo().
                getDgServiceRiyohyoList().getActiveRow().setRowState(RowState.Deleted);
// TODO N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンを有効/無効にする。共通パネルの仕様が固まってから対応する。
//        validateRiyohyoSave(panel, kyotsu);
        response.data = panel;
        return response;
    }

    /**
     * 別票Tabの「明細情報を追加する」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBeppyoMeisaiNew(SogoJigyohiRiyohyoDiv panel) {
        ResponseData<SogoJigyohiRiyohyoDiv> response = new ResponseData<>();
        panel.getTxtBeppyoListSelectIndex().setValue(new RString("-1"));
        setBeppyoVisible(panel, 別票画面表示.明細);
        setBeppyoMeisaiDemoData(panel);
        response.data = panel;
        return response;
    }

    /**
     * 別票Tabの「合計情報を追加する」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBeppyoGokeiNew(SogoJigyohiRiyohyoDiv panel) {
        ResponseData<SogoJigyohiRiyohyoDiv> response = new ResponseData<>();
        panel.getTxtBeppyoListSelectIndex().setValue(new RString("-1"));
        setBeppyoVisible(panel, 別票画面表示.合計);
        setBeppyoGokeiDemoData(panel);
        response.data = panel;
        return response;
    }

    /**
     * 別票Tabの明細表の選択ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBeppyoListSelect(SogoJigyohiRiyohyoDiv panel) {
        ResponseData<SogoJigyohiRiyohyoDiv> response = new ResponseData<>();
        dgServiceRiyohyoBeppyoList_Row row = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getActiveRow();
        int index = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getActiveRowId();
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
     * 別票Tabの明細表の削除ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBeppyoListDelete(SogoJigyohiRiyohyoDiv panel) {
        ResponseData<SogoJigyohiRiyohyoDiv> response = new ResponseData<>();
        panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().
                getDgServiceRiyohyoBeppyoList().getActiveRow().setRowState(RowState.Deleted);
// TODO N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンを有効/無効にする。共通パネルの仕様が固まってから対応する。
//        validateRiyohyoSave(panel, kyotsu);
        response.data = panel;
        return response;
    }

    /**
     * 別票Tabの「明細情報を確定する」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBeppyoMeisaiKakutei(SogoJigyohiRiyohyoDiv panel) {
        ResponseData<SogoJigyohiRiyohyoDiv> response = new ResponseData<>();
        setBeppyoMeisaiKakutei(panel);
        initBeppyoMeisaiData(panel);
        setBeppyoVisible(panel, 別票画面表示.初期表示);
// TBD N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンを有効/無効にする。共通パネルの仕様が固まってから対応する。
//        validateRiyohyoSave(panel, kyotsu);
        response.data = panel;
        return response;
    }

    /**
     * 別票Tabの「合計情報を確定する」ボタン押下時の処理
     *
     * @param panel panel
     * @return ResponseData
     */
    public ResponseData onClickBeppyoGokeiKakutei(SogoJigyohiRiyohyoDiv panel) {
        ResponseData<SogoJigyohiRiyohyoDiv> response = new ResponseData<>();
        setBeppyoGokeiKakutei(panel);
        initBeppyoGokeiData(panel);
        setBeppyoVisible(panel, 別票画面表示.初期表示);
// TBD N8187 久保田英男 共通パネルの「サービス利用票を保存する」ボタンを有効/無効にする。共通パネルの仕様が固まってから対応する。
//        validateRiyohyoSave(panel, kyotsu);
        response.data = panel;
        return response;
    }

    /**
     * 届出日など、Tab以外のデータの設定
     *
     * @param panel panel
     */
    private void setSummaryData(SogoJigyohiRiyohyoDiv panel) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("SogoJigyohiRiyohyo.yml"));
        int yamlIndex = 2;
        ServiceRiyohyoInfoDiv info = panel.getSogoJigyohiRiyohyoInfo();
        info.getTxtTodokedeYMD().setValue(new RDate(sourceList.get(yamlIndex).get("届出日").toString()));
        info.getTxtTekiyoKikan().setFromValue(new RDate(sourceList.get(yamlIndex).get("適用期間開始日").toString()));
        info.getTxtTekiyoKikan().clearToValue();
        info.getTxtKeikakuJigyoshaCode().setValue(new RString(sourceList.get(yamlIndex).get("計画作成事業者コード").toString()));
        info.getTxtKeikakuJigyoshaName().setValue(new RString(sourceList.get(yamlIndex).get("計画作成事業者名").toString()));
        info.getTxtTaishoYM().setValue(new RDate(sourceList.get(yamlIndex).get("対象年月").toString()));
        info.getTxtRiyohyoSakuseiYMD().setValue(new RDate(sourceList.get(yamlIndex).get("利用票作成日").toString()));
        info.getTxtRiyohyoTodokedeYMD().setValue(new RDate(sourceList.get(yamlIndex).get("利用票届出日").toString()));
        info.getTxtKubunShikyuGendogaku().setValue(new RString(sourceList.get(yamlIndex).get("区分支給限度額").toString()));
        info.getTxtRiyohyoSakuseisha().setValue(new RString(sourceList.get(yamlIndex).get("利用票作成者").toString()));
        info.getTxtGendoKanriKikan().setFromValue(new RDate(sourceList.get(yamlIndex).get("限度管理期間開始日").toString()));
        info.getTxtGendoKanriKikan().setToValue(new RDate(sourceList.get(yamlIndex).get("限度管理期間終了日").toString()));
    }

    /**
     * 届出日など、Tab以外のデータの設定(前月分)
     *
     * @param panel panel
     */
    private void setSummaryZengetsuData(SogoJigyohiRiyohyoDiv panel) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("SogoJigyohiRiyohyo.yml"));
        int yamlIndex = 3;
        ServiceRiyohyoInfoDiv info = panel.getSogoJigyohiRiyohyoInfo();
        info.getTxtTodokedeYMD().setValue(new RDate(sourceList.get(yamlIndex).get("届出日").toString()));
        info.getTxtTekiyoKikan().setFromValue(new RDate(sourceList.get(yamlIndex).get("適用期間開始日").toString()));
        info.getTxtTekiyoKikan().setToValue(new RDate(sourceList.get(yamlIndex).get("適用期間終了日").toString()));
        info.getTxtKeikakuJigyoshaCode().setValue(new RString(sourceList.get(yamlIndex).get("計画作成事業者コード").toString()));
        info.getTxtKeikakuJigyoshaName().setValue(new RString(sourceList.get(yamlIndex).get("計画作成事業者名").toString()));
        info.getTxtTaishoYM().setValue(new RDate(sourceList.get(yamlIndex).get("対象年月").toString()));
        info.getTxtRiyohyoSakuseiYMD().setValue(new RDate(sourceList.get(yamlIndex).get("利用票作成日").toString()));
        info.getTxtRiyohyoTodokedeYMD().setValue(new RDate(sourceList.get(yamlIndex).get("利用票届出日").toString()));
        info.getTxtKubunShikyuGendogaku().setValue(new RString(sourceList.get(yamlIndex).get("区分支給限度額").toString()));
        info.getTxtRiyohyoSakuseisha().setValue(new RString(sourceList.get(yamlIndex).get("利用票作成者").toString()));
        info.getTxtGendoKanriKikan().setFromValue(new RDate(sourceList.get(yamlIndex).get("限度管理期間開始日").toString()));
        info.getTxtGendoKanriKikan().setToValue(new RDate(sourceList.get(yamlIndex).get("限度管理期間終了日").toString()));
    }

    /**
     * サービス利用票Tabのデータ設定(前月分)
     *
     * @param panel panel
     */
    private void setZengetsuData(SogoJigyohiRiyohyoDiv panel) {
        ServiceRiyohyoDiv riyohyo = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyo();
        List<dgServiceRiyohyoList_Row> dgRowList = riyohyo.getDgServiceRiyohyoList().getDataSource();
        dgRowList.clear();

        for (int yamlIndex = 4; yamlIndex < 6; yamlIndex++) {
            dgServiceRiyohyoList_Row rowItem = createサービス利用票(yamlIndex);
            dgRowList.add(rowItem);
        }
        riyohyo.getDgServiceRiyohyoList().setDataSource(dgRowList);
    }

    /**
     * 別票Tabのデータ設定(前月分)
     *
     * @param panel panel
     */
    private void setBeppyoZengetsuData(SogoJigyohiRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoDiv beppyo = panel.getSogoJigyohiRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo();
        ServiceRiyohyoBeppyoListDiv list = beppyo.getServiceRiyohyoBeppyoList();
        setBeppyoListZengetsuData(list);
        initBeppyoData(panel);
    }

    private void setBeppyoListZengetsuData(ServiceRiyohyoBeppyoListDiv list) {
        List<dgServiceRiyohyoBeppyoList_Row> listRow = list.getDgServiceRiyohyoBeppyoList().getDataSource();
        listRow.clear();

        dgServiceRiyohyoBeppyoList_Row rowItem;
        for (int yamlIndex = 6; yamlIndex < 9; yamlIndex++) {
            rowItem = create別票一覧リスト(yamlIndex);
            listRow.add(rowItem);
        }
        list.getDgServiceRiyohyoBeppyoList().setDataSource(listRow);
    }

    /**
     * 別票Tabの一覧の「明細」行を修正状態にする。
     *
     * @param panel panel
     */
    private void beppyoMeisaiModify(SogoJigyohiRiyohyoDiv panel) {
        dgServiceRiyohyoBeppyoList_Row row = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getActiveRow();
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        meisai.getTxtJigyoshaCode().setValue(row.getTxtJigyosha().substring(0, 10));
        meisai.getTxtJigyoshaName().setValue(row.getTxtJigyosha().substring(11));
        meisai.getTxtServiceCode().setValue(row.getTxtService().substring(2, 6));
        meisai.getTxtServiceName().setValue(row.getTxtService().substring(7));
        meisai.getTxtTani().setValue(new Decimal(row.getTxtTani().toString()));
        meisai.getTxtWaribikigoRitsu().setValue(new Decimal(row.getTxtWaribikigoRitsu().toString()));
        meisai.getTxtWaribikigoTani().setValue(new Decimal(row.getTxtWaribikigoTani().toString()));
        meisai.getTxtKaisu().setValue(new Decimal(row.getTxtKaisu().toString()));
        meisai.getTxtServiceTani().setValue(new Decimal(row.getTxtServiceTani().toString()));

        setBeppyoVisible(panel, 別票画面表示.明細);
    }

    /**
     * 別票Tabの一覧の「合計」行を修正状態にする。
     *
     * @param panel panel
     */
    private void beppyoGokeiModify(SogoJigyohiRiyohyoDiv panel) {
        dgServiceRiyohyoBeppyoList_Row row = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getActiveRow();
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().
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

        setBeppyoVisible(panel, 別票画面表示.合計);
    }

    /**
     * 別票Tabの明細のデータを一覧に反映する。
     *
     * @param panel panel
     */
    private void setBeppyoMeisaiKakutei(SogoJigyohiRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoListDiv beppyoList = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList();
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        List<dgServiceRiyohyoBeppyoList_Row> listRow = beppyoList.getDgServiceRiyohyoBeppyoList().getDataSource();
        int index = Integer.parseInt(panel.getTxtBeppyoListSelectIndex().getValue().toString());

        Button btnSelect = new Button();
        Button btnDelete = new Button();
        RString jigyosha = meisai.getTxtJigyoshaCode().getValue().concat(new RString(":")).
                concat(meisai.getTxtJigyoshaName().getValue());
        RString service = meisai.getTxtServiceCode().getValue().
                concat(new RString(":")).concat(meisai.getTxtServiceName().getValue());

        dgServiceRiyohyoBeppyoList_Row rowItem;
        rowItem = create別票一覧リストアイテム(
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

    /**
     * 別票Tabの一覧から明細を選択して明細Panelで確定したとき、明細が修正されているか判定する。
     *
     * @param panel panel
     * @param index index
     * @return true:修正あり、false:修正なし
     */
    private boolean validateMeisai(SogoJigyohiRiyohyoDiv panel, int index) {
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().
                getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        List<dgServiceRiyohyoBeppyoList_Row> listRow = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().
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
     * 別票Tabの合計のデータを一覧に反映する。
     *
     * @param panel panel
     */
    private void setBeppyoGokeiKakutei(SogoJigyohiRiyohyoDiv panel) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("SogoJigyohiRiyohyo.yml"));
        int yamlIndex = 9;
        ServiceRiyohyoBeppyoListDiv beppyoList = panel.getSogoJigyohiRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList();
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getSogoJigyohiRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
        List<dgServiceRiyohyoBeppyoList_Row> listRow = beppyoList.getDgServiceRiyohyoBeppyoList().getDataSource();
        int index = Integer.parseInt(panel.getTxtBeppyoListSelectIndex().getValue().toString());

        Button btnSelect = new Button();
        Button btnDelete = new Button();

        dgServiceRiyohyoBeppyoList_Row rowItem;
        rowItem = create別票一覧リストアイテム(btnSelect, btnDelete,
                sourceList.get(yamlIndex).get("事業者").toString(),
                sourceList.get(yamlIndex).get("サービス").toString(),
                "", "", "", "",
                sourceList.get(yamlIndex).get("サービス単位").toString(),
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

    /**
     * 別票Tabの一覧から合計を選択して合計Panelで確定したとき、合計が修正されているか判定する。
     *
     * @param panel panel
     * @param index index
     * @return true:修正あり、false:修正なし
     */
    private boolean validateGokei(SogoJigyohiRiyohyoDiv panel, int index) {
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getSogoJigyohiRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
        List<dgServiceRiyohyoBeppyoList_Row> listRow = panel.getSogoJigyohiRiyohyoInfo().
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
     * 別票Tabの明細のデータ初期化
     *
     * @param panel panel
     */
    private void initBeppyoMeisaiData(SogoJigyohiRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getSogoJigyohiRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        meisai.getTxtJigyoshaCode().clearValue();
        meisai.getTxtJigyoshaName().clearValue();
        meisai.getTxtServiceCode().clearValue();
        meisai.getTxtServiceName().clearValue();
        meisai.getTxtTani().clearValue();
        meisai.getTxtWaribikigoRitsu().clearValue();
        meisai.getTxtWaribikigoTani().clearValue();
        meisai.getTxtKaisu().clearValue();
        meisai.getTxtServiceTani().clearValue();
    }

    /**
     * 別票Tabの合計のデータ初期化
     *
     * @param panel panel
     */
    private void initBeppyoGokeiData(SogoJigyohiRiyohyoDiv panel) {
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getSogoJigyohiRiyohyoInfo().
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
     * 別票Tabの明細のデモ向けデータ設定
     *
     * @param panel panel
     */
    private void setBeppyoMeisaiDemoData(SogoJigyohiRiyohyoDiv panel) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("SogoJigyohiRiyohyo.yml"));
        int yamlIndex = 10;
        ServiceRiyohyoBeppyoMeisaiDiv meisai = panel.getSogoJigyohiRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
        meisai.getTxtJigyoshaCode().setValue(new RString(sourceList.get(yamlIndex).get("事業者コード").toString()));
        meisai.getTxtJigyoshaName().setValue(new RString(sourceList.get(yamlIndex).get("事業者名").toString()));
        meisai.getTxtServiceCode().setValue(new RString(sourceList.get(yamlIndex).get("サービスコード").toString()));
        meisai.getTxtServiceName().setValue(new RString(sourceList.get(yamlIndex).get("サービス名").toString()));
        meisai.getTxtTani().setValue(new Decimal(sourceList.get(yamlIndex).get("単位").toString()));
        meisai.getTxtWaribikigoRitsu().setValue(new Decimal(sourceList.get(yamlIndex).get("割引適用後割引率").toString()));
        meisai.getTxtWaribikigoTani().setValue(new Decimal(sourceList.get(yamlIndex).get("割引適用後単位").toString()));
        meisai.getTxtKaisu().setValue(new Decimal(sourceList.get(yamlIndex).get("回数").toString()));
        meisai.getTxtServiceTani().setValue(new Decimal(sourceList.get(yamlIndex).get("サービス単位").toString()));
    }

    /**
     * 別票Tabの合計のデモ向けデータ設定
     *
     * @param panel panel
     */
    private void setBeppyoGokeiDemoData(SogoJigyohiRiyohyoDiv panel) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("SogoJigyohiRiyohyo.yml"));
        int yamlIndex = 11;
        ServiceRiyohyoBeppyoGokeiDiv gokei = panel.getSogoJigyohiRiyohyoInfo().
                getTabServiceRiyohyo().getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
        gokei.getTxtShuruiGendoChokaTani().setValue(new Decimal(sourceList.get(yamlIndex).get("種類限度超過単位").toString()));
        gokei.getTxtShuruiGendonaiTani().setValue(new Decimal(sourceList.get(yamlIndex).get("種類限度内単位").toString()));
        gokei.getTxtTanisuTanka().setValue(new Decimal(sourceList.get(yamlIndex).get("単位数単価").toString()));
        gokei.getTxtKubunGendoChokaTani().setValue(new Decimal(sourceList.get(yamlIndex).get("区分限度超過単位").toString()));
        gokei.getTxtKubunGendonaiTani().setValue(new Decimal(sourceList.get(yamlIndex).get("区分限度内単位").toString()));
        gokei.getTxtKyufuritsu().setValue(new Decimal(sourceList.get(yamlIndex).get("給付率").toString()));
        gokei.getTxtHiyoSogaku().setValue(new Decimal(sourceList.get(yamlIndex).get("費用総額").toString()));
        gokei.getTxtHokenKyufugaku().setValue(new Decimal(sourceList.get(yamlIndex).get("保険給付額").toString()));
        gokei.getTxtRiyoshaFutangakuHoken().setValue(new Decimal(sourceList.get(yamlIndex).get("保険対象利用者負担額").toString()));
        gokei.getTxtRiyoshaFutangakuZengaku().setValue(new Decimal(sourceList.get(yamlIndex).get("全額利用者負担額").toString()));
    }

    /**
     * サービス利用票Tabの曜日の設定
     *
     * @param panel panel
     */
    private void setRiyohyoYobi(SogoJigyohiRiyohyoDiv panel) {
        RDate taishoYMD = new RDate(panel.getSogoJigyohiRiyohyoInfo().getTxtTaishoYM().getValue().getYearMonth().toString().concat("01"));
        ServiceRiyohyoDiv riyohyo = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyo();
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
     * 別票Tabの明細Panel、合計Panelの初期化
     *
     * @param panel panel
     */
    private void initBeppyoData(SogoJigyohiRiyohyoDiv panel) {
        initBeppyoMeisaiData(panel);
        initBeppyoGokeiData(panel);
    }

//    /**
//     * サービス利用票及び別票が入力されているか判定する。 双方入力されている場合、共通パネルの「サービス利用票を保存する」ボタンをEnableにする。
//     *
//     * @param panel panel
//     * @param kyotsu kyotsu
//     */
//    private void validateRiyohyoSave(SogoJigyohiRiyohyoDiv panel, KyotsuPanelDiv kyotsu) {
//        ServiceRiyohyoDiv riyohyo = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyo();
//        ServiceRiyohyoBeppyoDiv beppyo = panel.getSogoJigyohiRiyohyoInfo().getTabServiceRiyohyo().getServiceRiyohyoBeppyo();
//
//        if (!riyohyo.getDgServiceRiyohyoList().getDataSource().isEmpty()
//                && !beppyo.getServiceRiyohyoBeppyoList().getDgServiceRiyohyoBeppyoList().getDataSource().isEmpty()) {
//            kyotsu.getBtnRiyohyoSave().setDisabled(false);
//        }
//    }
    /**
     * 別票のPanel表示設定
     *
     * @param panel panel
     * @param 表示 表示
     */
    private void setBeppyoVisible(SogoJigyohiRiyohyoDiv panel, 別票画面表示 表示) {
        ServiceRiyohyoBeppyoDiv beppyo = panel.getSogoJigyohiRiyohyoInfo().
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

    private dgServiceRiyohyoBeppyoList_Row create別票一覧リスト(int yamlIndex) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("SogoJigyohiRiyohyo.yml"));
        Button btnSelect = new Button();
        Button btnDelete = new Button();
        return create別票一覧リストアイテム(btnSelect, btnDelete,
                sourceList.get(yamlIndex).get("事業者").toString(),
                sourceList.get(yamlIndex).get("サービス").toString(),
                sourceList.get(yamlIndex).get("単位").toString(),
                sourceList.get(yamlIndex).get("割引適用後割引率").toString(),
                sourceList.get(yamlIndex).get("割引適用後単位").toString(),
                sourceList.get(yamlIndex).get("回数").toString(),
                sourceList.get(yamlIndex).get("サービス単位").toString(),
                sourceList.get(yamlIndex).get("種類限度超過単位").toString(),
                sourceList.get(yamlIndex).get("種類限度内単位").toString(),
                sourceList.get(yamlIndex).get("区分限度超過単位").toString(),
                sourceList.get(yamlIndex).get("区分限度内単位").toString(),
                sourceList.get(yamlIndex).get("単位数単価").toString(),
                sourceList.get(yamlIndex).get("費用総額").toString(),
                sourceList.get(yamlIndex).get("給付率").toString(),
                sourceList.get(yamlIndex).get("保険給付額").toString(),
                sourceList.get(yamlIndex).get("保険対象利用者負担額").toString(),
                sourceList.get(yamlIndex).get("全額利用者負担額").toString());
    }

    private dgServiceRiyohyoBeppyoList_Row create別票一覧リストアイテム(
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
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum());
//        return new dgServiceRiyohyoBeppyoList_Row(
//                btnSelect,
//                btnDelete,
//                new RString(txtJigyosha),
//                new RString(txtService),
//                new RString(txtTani),
//                new RString(txtWaribikigoRitsu),
//                new RString(txtWaribikigoTani),
//                new RString(txtKaisu),
//                new RString(txtServiceTani),
//                new RString(txtShuruiGendoChokaTani),
//                new RString(txtShuruiGendonaiTani),
//                new RString(txtKubunGendoChokaTani),
//                new RString(txtKubunGendonaiTani),
//                new RString(txtTanisuTanka),
//                new RString(txtHiyoSogaku),
//                new RString(txtKyufuritsu),
//                new RString(txtHokenFutangaku),
//                new RString(txtRiyoshaFutangakuHoken),
//                new RString(txtRiyoshaFutangakuZengaku)
//        );

    }

    private dgServiceRiyohyoList_Row createサービス利用票(int yamlIndex) {
        List<HashMap> sourceList = YamlLoader.FOR_DBC.loadAsList(new RString("SogoJigyohiRiyohyo.yml"));
        Button btnDelete = new Button();
        Button btnService = new Button();
        Button btnJigyosha = new Button();
        return createサービス利用票アイテム(
                btnDelete,
                sourceList.get(yamlIndex).get("開始時刻").toString(),
                sourceList.get(yamlIndex).get("終了時刻").toString(),
                btnService,
                sourceList.get(yamlIndex).get("サービス内容").toString(),
                btnJigyosha,
                sourceList.get(yamlIndex).get("サービス事業者").toString(),
                sourceList.get(yamlIndex).get("予実").toString(),
                sourceList.get(yamlIndex).get("1日").toString(),
                sourceList.get(yamlIndex).get("2日").toString(),
                sourceList.get(yamlIndex).get("3日").toString(),
                sourceList.get(yamlIndex).get("4日").toString(),
                sourceList.get(yamlIndex).get("5日").toString(),
                sourceList.get(yamlIndex).get("6日").toString(),
                sourceList.get(yamlIndex).get("7日").toString(),
                sourceList.get(yamlIndex).get("8日").toString(),
                sourceList.get(yamlIndex).get("9日").toString(),
                sourceList.get(yamlIndex).get("10日").toString(),
                sourceList.get(yamlIndex).get("11日").toString(),
                sourceList.get(yamlIndex).get("12日").toString(),
                sourceList.get(yamlIndex).get("13日").toString(),
                sourceList.get(yamlIndex).get("14日").toString(),
                sourceList.get(yamlIndex).get("15日").toString(),
                sourceList.get(yamlIndex).get("16日").toString(),
                sourceList.get(yamlIndex).get("17日").toString(),
                sourceList.get(yamlIndex).get("18日").toString(),
                sourceList.get(yamlIndex).get("19日").toString(),
                sourceList.get(yamlIndex).get("20日").toString(),
                sourceList.get(yamlIndex).get("21日").toString(),
                sourceList.get(yamlIndex).get("22日").toString(),
                sourceList.get(yamlIndex).get("23日").toString(),
                sourceList.get(yamlIndex).get("24日").toString(),
                sourceList.get(yamlIndex).get("25日").toString(),
                sourceList.get(yamlIndex).get("26日").toString(),
                sourceList.get(yamlIndex).get("27日").toString(),
                sourceList.get(yamlIndex).get("28日").toString(),
                sourceList.get(yamlIndex).get("29日").toString(),
                sourceList.get(yamlIndex).get("30日").toString(),
                sourceList.get(yamlIndex).get("31日").toString(),
                sourceList.get(yamlIndex).get("合計").toString());
    }

    private dgServiceRiyohyoList_Row createサービス利用票アイテム(Button btnDelete,
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
