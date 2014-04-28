/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceJigyoshaSakuseiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceJikoSakuseiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServicePlanIchiranDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SetaiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyotakuServicePlanIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSetaiJoho_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 居宅サービス計画一覧のクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuServicePlanIchiran {

    /**
     * 居宅サービス計画一覧の画面ロード時の処理です。
     *
     * @param panel 居宅サービス計画一覧
     * @return ResponseData
     */
    public ResponseData getOnLoadData(KyotakuServicePlanIchiranDiv panel) {
        ResponseData<KyotakuServicePlanIchiranDiv> response = new ResponseData<>();
        initPanel(panel);
        setServiceIchiran(panel);
        response.data = panel;
        return response;
    }

    /*
     画面ロード時の初期化処理です。
     */
    private void initPanel(KyotakuServicePlanIchiranDiv panel) {
        panel.getSetaiJoho().setVisible(false);
        panel.getKyotakuServiceJigyoshaSakuseiInfo().setVisible(false);
        panel.getKyotakuServiceJikoSakuseiInfo().setVisible(false);
    }

    /**
     * 世帯情報をセットします。
     *
     * @param panel 住民PanelDiv
     * @return 住民PanelDivのResponseData
     */
    public ResponseData<KyotakuServicePlanIchiranDiv> onClick_showSetai(KyotakuServicePlanIchiranDiv panel) {
        ResponseData<KyotakuServicePlanIchiranDiv> response = new ResponseData<>();
        SetaiJohoDiv setai = panel.getSetaiJoho();

        if (setai.isVisible()) {
            setai.setVisible(false);
            setai.setDisplayNone(true);
        } else {
            setai.setVisible(true);
            setai.setDisplayNone(false);
        }

        DataGrid<dgSetaiJoho_Row> grid = setai.getDgSetaiJoho();
        List<dgSetaiJoho_Row> arrayData = create世帯情報();
        grid.setDataSource(arrayData);

        response.data = panel;
        return response;
    }

    private List<dgSetaiJoho_Row> create世帯情報() {
        List<dgSetaiJoho_Row> arrayData = new ArrayList<>();
        dgSetaiJoho_Row item;

        item = create世帯("電算　次郎", "男", "昭52.02.21", "子", "123456789012");
        arrayData.add(item);
        item = create世帯("電算　三郎", "男", "昭54.02.21", "子", "123456789013");
        arrayData.add(item);

        return arrayData;
    }

    private dgSetaiJoho_Row create世帯(
            String name,
            String gender,
            String birthDay,
            String tsuzukiGara,
            String JuminCode) {
        dgSetaiJoho_Row rowData = new dgSetaiJoho_Row(
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowData.setSetaiName(new RString(name));
        rowData.setSetaiGender(new RString(gender));
        rowData.setSetaiBirthDay(new RString(birthDay));
        rowData.setSetaiTsuzukiGara(new RString(tsuzukiGara));
        rowData.setSetaiJuminCode(new RString(JuminCode));
        return rowData;
    }

    /**
     * 居宅サービス計画一覧のデータグリッドで選択した計画を表示する際の処理。
     *
     * @param panel 居宅サービス計画一覧
     * @return ResponseData
     */
    public ResponseData<KyotakuServicePlanIchiranDiv> onClick_ShowDetail(KyotakuServicePlanIchiranDiv panel) {
        ResponseData<KyotakuServicePlanIchiranDiv> response = new ResponseData<>();
        dgKyotakuServicePlanIchiran_Row selectRow = panel.getDgKyotakuServicePlanIchiran().getClickedItem();

        if (selectRow.getTxtPlanSakuseiKubun().compareTo(new RString("居宅支援")) == 0) {
            panel.getKyotakuServiceJigyoshaSakuseiInfo().setVisible(true);
            panel.getKyotakuServiceJigyoshaSakuseiInfo().setDisplayNone(false);
            panel.getKyotakuServiceJikoSakuseiInfo().setVisible(false);
            panel.getKyotakuServiceJikoSakuseiInfo().setDisplayNone(true);
            setKyotakuSienData(panel);
        } else {
            panel.getKyotakuServiceJigyoshaSakuseiInfo().setVisible(false);
            panel.getKyotakuServiceJigyoshaSakuseiInfo().setDisplayNone(true);
            panel.getKyotakuServiceJikoSakuseiInfo().setVisible(true);
            panel.getKyotakuServiceJikoSakuseiInfo().setDisplayNone(false);
            if (new FlexibleDate(selectRow.getTxtTaishoYMInvisible().concat(new RString("01"))).isBefore(new FlexibleDate(new RString("20020101")))) {
                panel.getKyotakuServiceJikoSakuseiInfo().getBtnDlgKyotakuService().setVisible(false);
                panel.getKyotakuServiceJikoSakuseiInfo().getBtnDlgHomonTsusho().setVisible(true);
                panel.getKyotakuServiceJikoSakuseiInfo().getBtnDlgTankiNyusho().setVisible(true);
            } else {
                panel.getKyotakuServiceJikoSakuseiInfo().getBtnDlgKyotakuService().setVisible(true);
                panel.getKyotakuServiceJikoSakuseiInfo().getBtnDlgHomonTsusho().setVisible(false);
                panel.getKyotakuServiceJikoSakuseiInfo().getBtnDlgTankiNyusho().setVisible(false);
            }
            setKojinSakuseiData(panel);
        }
        response.data = panel;
        return response;
    }

    /*
     居宅支援の詳細表示へ計画一覧データグリッドで選択した行のデータを設定します。
     */
    private void setKyotakuSienData(KyotakuServicePlanIchiranDiv panel) {
        KyotakuServiceJigyoshaSakuseiInfoDiv infoDiv = panel.getKyotakuServiceJigyoshaSakuseiInfo();
        dgKyotakuServicePlanIchiran_Row selectRow = panel.getDgKyotakuServicePlanIchiran().getClickedItem();
        infoDiv.getTblKyotakuServiceJigyoshaSakuseiInfo().getTxtJigyoshaSakuseiJigyoshaNo().setValue(selectRow.getTxtJigyoshaNo());
        infoDiv.getTblKyotakuServiceJigyoshaSakuseiInfo().getTxtJigyoshaSakuseiJigyoshaName().setValue(selectRow.getTxtJigyoshaName());
        infoDiv.getTblKyotakuServiceJigyoshaSakuseiInfo().getTxtJigyoshaSakuseiStartYMD().setValue(selectRow.getTxtStartYMD());
        infoDiv.getTblKyotakuServiceJigyoshaSakuseiInfo().getTxtJigyoshaSakuseiEndYMD().setValue(selectRow.getTxtEndYMD());
    }

    /*
     個人作成の詳細表示へ計画一覧データグリッドで選択した行のデータを設定します。
     */
    private void setKojinSakuseiData(KyotakuServicePlanIchiranDiv panel) {
        KyotakuServiceJikoSakuseiInfoDiv infoDiv = panel.getKyotakuServiceJikoSakuseiInfo();
        dgKyotakuServicePlanIchiran_Row selectRow = panel.getDgKyotakuServicePlanIchiran().getClickedItem();
        infoDiv.getTblKyotakuServiceJikoSakuseiInfo().getTxtJikoSakuseiStartYMD().setValue(selectRow.getTxtStartYMD());
        infoDiv.getTblKyotakuServiceJikoSakuseiInfo().getTxtJikoSakuseiEndYMD().setValue(selectRow.getTxtEndYMD());
    }

    /*
     サービス計画一覧データグリッドにデータを設定します。
     */
    private void setServiceIchiran(KyotakuServicePlanIchiranDiv panel) {

        List<dgKyotakuServicePlanIchiran_Row> arraydata = createサービス計画一覧();
        DataGrid<dgKyotakuServicePlanIchiran_Row> grid = panel.getDgKyotakuServicePlanIchiran();
        grid.setDataSource(arraydata);
    }

    private List<dgKyotakuServicePlanIchiran_Row> createサービス計画一覧() {
        List<dgKyotakuServicePlanIchiran_Row> arrayData = new ArrayList<>();
        dgKyotakuServicePlanIchiran_Row item;
        Button btn = new Button();

        item = create計画(btn, "200111", "平13.11", "居宅支援", "", "20001", "電算サービスセンター", "平13.11.01", "", "有効");
        arrayData.add(item);
        item = create計画(btn, "200112", "平13.12", "自己作成", "", "", "", "平13.12.01", "平13.12.31", "有効");
        arrayData.add(item);
        item = create計画(btn, "200201", "平14.01", "自己作成", "", "", "", "平14.01.01", "平14.01.31", "有効");
        arrayData.add(item);
        item = create計画(btn, "201403", "平26.03", "自己作成", "暫定", "", "", "平26.03.01", "平26.03.31", "有効");
        arrayData.add(item);
        item = create計画(btn, "201404", "平26.04", "居宅支援", "", "20002", "福祉サービスセンター", "平26.04.01", "", "有効");
        arrayData.add(item);

        return arrayData;
    }

    private dgKyotakuServicePlanIchiran_Row create計画(
            Button btn,
            String txtTaishoYMInvisible,
            String txtTaishoYM,
            String txtPlanSakuseiKubun,
            String txtZantei,
            String txtJigyoshaNo,
            String txtJigyoshaName,
            String txtStartYMD,
            String txtEndYMD,
            String txtEnable) {
        dgKyotakuServicePlanIchiran_Row rowData = new dgKyotakuServicePlanIchiran_Row(
                btn, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowData.setTxtTaishoYMInvisible(new RString(txtTaishoYMInvisible));
        rowData.setTxtTaishoYM(new RString(txtTaishoYM));
        rowData.setTxtPlanSakuseiKubun(new RString(txtPlanSakuseiKubun));
        rowData.setTxtZantei(new RString(txtZantei));
        rowData.setTxtJigyoshaNo(new RString(txtJigyoshaNo));
        rowData.setTxtJigyoshaName(new RString(txtJigyoshaName));
        rowData.setTxtStartYMD(new RString(txtStartYMD));
        rowData.setTxtEndYMD(new RString(txtEndYMD));
        rowData.setTxtEnable(new RString(txtEnable));
        return rowData;
    }

}
