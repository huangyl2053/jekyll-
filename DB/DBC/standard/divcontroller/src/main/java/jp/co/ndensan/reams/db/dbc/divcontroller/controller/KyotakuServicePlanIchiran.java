/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServicePlanIchiranDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceTodokedeCommonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceTodokedeJigyoshaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyotakuServiceTodokedeJikoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SetaiJohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgKyotakuServicePlanIchiran_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSetaiJoho_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJigyoshaSakuseiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tblKyotakuServiceJikoSakuseiInfoDiv;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
        panel.getSetaiJoho().setDisplayNone(true);
        panel.getKyotakuServiceTodokedeInfo().setVisible(false);
        panel.getKyotakuServiceTodokedeInfo().setDisplayNone(true);
        panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeCommon().setVisible(false);
        panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeCommon().setDisplayNone(true);
        panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeJigyosha().setVisible(false);
        panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeJigyosha().setDisplayNone(true);
        panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeJiko().setVisible(false);
        panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeJiko().setDisplayNone(true);
    }

    /**
     * 世帯情報をセットします。
     *
     * @param panel 住民PanelDiv
     * @return 住民PanelDivのResponseData
     */
    public ResponseData<KyotakuServicePlanIchiranDiv> onClick_ShowSetai(KyotakuServicePlanIchiranDiv panel) {
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
        rowData.setSetaiShikibetsuCode(new RString(JuminCode));
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

        KyotakuServiceTodokedeCommonDiv common = panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeCommon();
        KyotakuServiceTodokedeJigyoshaDiv jigyosha = panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeJigyosha();
        KyotakuServiceTodokedeJikoDiv jiko = panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeJiko();

        panel.getKyotakuServiceTodokedeInfo().setVisible(true);
        panel.getKyotakuServiceTodokedeInfo().setDisplayNone(false);

        common.setVisible(true);
        common.setDisplayNone(false);
        common.getTxtPlanSakuseiKubun1().setValue(new RString("計画依頼受付情報"));
        common.getTxtPlanSakuseiKubun2().setValue(new RString("自己作成計画情報"));
        common.getTxtPlanSakuseiKubun3().setValue(new RString("居宅・介護予防サービス情報"));
        common.getTxtTodokedeStatus1().setValue(new RString("新規申請"));
        common.getTxtTodokedeStatus2().setValue(new RString("再申請"));
        common.getTxtTodokedeStatus2().setDisabled(true);
        common.getTxtTodokedeStatus3().setValue(new RString("変更申請"));
        common.getTxtTodokedeStatus3().setDisabled(true);
        common.getTxtTodokedeStatus4().setValue(new RString("サービス変更"));
        common.getTxtTodokedeStatus4().setDisabled(true);

        if (selectRow.getTxtPlanSakuseiKubun().compareTo(new RString("居宅支援")) == 0) {
            jigyosha.setVisible(true);
            jigyosha.setDisplayNone(false);
            jiko.setVisible(false);
            jiko.setDisplayNone(true);
            common.getTxtPlanSakuseiKubun1().setDisabled(false);
            common.getTxtPlanSakuseiKubun2().setDisabled(true);
            common.getTxtPlanSakuseiKubun3().setDisabled(true);
            setKyotakuSienData(panel);
        } else {
            jigyosha.setVisible(false);
            jigyosha.setDisplayNone(true);
            jiko.setVisible(true);
            jiko.setDisplayNone(false);
            if (new FlexibleDate(selectRow.getTxtTaishoYMInvisible().concat(new RString("01"))).isBefore(new FlexibleDate(new RString("20020101")))) {
                common.getTxtPlanSakuseiKubun1().setDisabled(true);
                common.getTxtPlanSakuseiKubun2().setDisabled(true);
                common.getTxtPlanSakuseiKubun3().setDisabled(false);
                jiko.getBtnDlgKyotakuService().setVisible(false);
                jiko.getBtnDlgHomonTsusho().setVisible(true);
                jiko.getBtnDlgTankiNyusho().setVisible(true);
            } else {
                common.getTxtPlanSakuseiKubun1().setDisabled(true);
                common.getTxtPlanSakuseiKubun2().setDisabled(false);
                common.getTxtPlanSakuseiKubun3().setDisabled(true);
                jiko.getBtnDlgKyotakuService().setVisible(true);
                jiko.getBtnDlgHomonTsusho().setVisible(false);
                jiko.getBtnDlgTankiNyusho().setVisible(false);
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
        tblKyotakuServiceJigyoshaSakuseiInfoDiv jigyoshaInfoDiv = panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeJigyosha().getTblKyotakuServiceJigyoshaSakuseiInfo();
        dgKyotakuServicePlanIchiran_Row selectRow = panel.getDgKyotakuServicePlanIchiran().getClickedItem();

        jigyoshaInfoDiv.getTxtJigyoshaSakuseiTodokedeKubun().setValue(new RString("新規"));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiTodokedeYMD().setValue(new FlexibleDate(selectRow.getTxtStartYMDInvisible()));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiStartYMD().setValue(new FlexibleDate(selectRow.getTxtStartYMDInvisible()));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiEndYMD().setValue(new FlexibleDate(selectRow.getTxtEndYMDInvisible()));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiKubun().setValue(new RString("居宅介護支援事業所作成"));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiJigyoshaNo().setValue(selectRow.getTxtJigyoshaNo());
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiJigyoshaName().setValue(selectRow.getTxtJigyoshaName());
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiCategory1().setValue(new RString("居宅介護"));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiCategory2().setValue(new RString("居宅予防"));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiCategory3().setValue(new RString("小規模介護"));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiCategory4().setValue(new RString("小規模予防"));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiYubinNo().setValue(new YubinNo("381-0010"));
        RString jusho = new RString("長野県長野市鶴賀七瀬中町276-6１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０１２３４５６７８９０");
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiJusho().setValue(jusho);
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiJusho().setToolTip(jusho);
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiKanrisha().setValue(new RString("電算　十郎"));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiTelNo().setValue(new RString("123-456-7890"));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiItakusakiNo().setValue(new RString("1234567890"));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiItakusakiName().setValue(new RString("いいい介護施設"));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiModifyYMD().setValue(new FlexibleDate(selectRow.getTxtStartYMDInvisible()));
        jigyoshaInfoDiv.getTxtJigyoshaSakuseiModifyRiyu().setValue(new RString("ああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああああ"));

    }

    /*
     個人作成の詳細表示へ計画一覧データグリッドで選択した行のデータを設定します。
     */
    private void setKojinSakuseiData(KyotakuServicePlanIchiranDiv panel) {
        tblKyotakuServiceJikoSakuseiInfoDiv jikoInfoDiv = panel.getKyotakuServiceTodokedeInfo().getKyotakuServiceTodokedeJiko().getTblKyotakuServiceJikoSakuseiInfo();
        dgKyotakuServicePlanIchiran_Row selectRow = panel.getDgKyotakuServicePlanIchiran().getClickedItem();
        jikoInfoDiv.getTxtJikoSakuseiTishoYM().setValue(new FlexibleDate(selectRow.getTxtTaishoYMInvisible().concat(new RString("01"))));
        jikoInfoDiv.getTxtJikoSakuseiCreateYMD().setValue(new FlexibleDate(selectRow.getTxtTaishoYMInvisible().concat(new RString("01"))));
        jikoInfoDiv.getTxtJikoSakuseiTodokedeYMD().setValue(new FlexibleDate(selectRow.getTxtTaishoYMInvisible().concat(new RString("01"))));
        jikoInfoDiv.getTxtJikoSakuseiStartYMD().setValue(new FlexibleDate(selectRow.getTxtStartYMDInvisible().toString()));
        jikoInfoDiv.getTxtJikoSakuseiEndYMD().setValue(new FlexibleDate(selectRow.getTxtEndYMDInvisible().toString()));
        jikoInfoDiv.getTxtJikoSakuseiYoukaigodo().setValue(new RString("要介護度３"));
        jikoInfoDiv.getTxtJikoSakuseiYukoKikan().setFromValue(new RDate(selectRow.getTxtStartYMDInvisible().toString()));
        jikoInfoDiv.getTxtJikoSakuseiYukoKikan().setToValue(new RDate(selectRow.getTxtEndYMDInvisible().toString()));

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

        item = create計画(btn, "200111", "平13.11", "居宅支援", "", "20001", "電算サービスセンター", "20011101", "平13.11.01", "", "", "有効");
        arrayData.add(item);
        item = create計画(btn, "200112", "平13.12", "自己作成", "", "", "", "20011201", "平13.12.01", "20011231", "平13.12.31", "有効");
        arrayData.add(item);
        item = create計画(btn, "200201", "平14.01", "自己作成", "", "", "", "20020101", "平14.01.01", "20020131", "平14.01.31", "有効");
        arrayData.add(item);
        item = create計画(btn, "201403", "平26.03", "自己作成", "暫定", "", "", "20140301", "平26.03.01", "20140331", "平26.03.31", "有効");
        arrayData.add(item);
        item = create計画(btn, "201404", "平26.04", "居宅支援", "", "20002", "福祉サービスセンター", "20140401", "平26.04.01", "", "", "有効");
        arrayData.add(item);

        Collections.sort(arrayData, new DateComparator());

        return arrayData;
    }

    private class DateComparator implements Comparator<dgKyotakuServicePlanIchiran_Row> {

        @Override
        public int compare(dgKyotakuServicePlanIchiran_Row o1, dgKyotakuServicePlanIchiran_Row o2) {
            return new FlexibleDate(o2.getTxtTaishoYMInvisible().concat(new RString("01"))).compareTo(new FlexibleDate(o1.getTxtTaishoYMInvisible().concat(new RString("01"))));
        }
    }

    private dgKyotakuServicePlanIchiran_Row create計画(
            Button btn,
            String txtTaishoYMInvisible,
            String txtTaishoYM,
            String txtPlanSakuseiKubun,
            String txtZantei,
            String txtJigyoshaNo,
            String txtJigyoshaName,
            String txtStartYMDInvisible,
            String txtStartYMD,
            String txtEndYMDInvisible,
            String txtEndYMD,
            String txtEnable) {
        dgKyotakuServicePlanIchiran_Row rowData = new dgKyotakuServicePlanIchiran_Row(
                btn, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowData.setTxtTaishoYMInvisible(new RString(txtTaishoYMInvisible));
        rowData.setTxtTaishoYM(new RString(txtTaishoYM));
        rowData.setTxtPlanSakuseiKubun(new RString(txtPlanSakuseiKubun));
        rowData.setTxtZantei(new RString(txtZantei));
        rowData.setTxtJigyoshaNo(new RString(txtJigyoshaNo));
        rowData.setTxtJigyoshaName(new RString(txtJigyoshaName));
        if (!txtStartYMDInvisible.isEmpty()) {
            rowData.setTxtStartYMDInvisible(new RString(txtStartYMDInvisible));
            rowData.setTxtStartYMD(new RString(txtStartYMD));
        }
        if (!txtEndYMDInvisible.isEmpty()) {
            rowData.setTxtEndYMDInvisible(new RString(txtEndYMDInvisible));
            rowData.setTxtEndYMD(new RString(txtEndYMD));
        }
        rowData.setTxtEnable(new RString(txtEnable));
        return rowData;
    }

}
