/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0700011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011.JutakuKaishuJizenShinseiContentsPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011.JutakuKaishuJizenShinseiShinsaResultPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 住宅改修費事前申請登録 審査結果のパネルです。
 *
 * @author n8223 朴
 */
public class JutakuKaishuJizenShinseiShinsaResultPanel {

    private final List<HashMap> ymlData = YamlLoader.DBC.loadAsList(new RString("dbc0700011/JutakuData.yml"));

    /**
     * 住宅改修費事前申請登録 審査結果内容の情報を表示する。
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiShinsaResultPanelDiv> onLoad(
            JutakuKaishuJizenShinseiShinsaResultPanelDiv panel, JutakuKaishuJizenShinseiContentsPanelDiv contentsPanel) {
        ResponseData<JutakuKaishuJizenShinseiShinsaResultPanelDiv> response = new ResponseData<>();

        //前回・今回　初期化設定　　　　　　
        setSummary(panel);
        //審査結果の初期値をセットする
        setShinseiShinsaResult(panel);
        //判定区分(承認、不承認）セットする。
        setRadJudgeKubun(panel);

        response.data = panel;
        return response;
    }

    /**
     * 住宅改修費事前申請登録 明細を追加するボタンを押下後、住宅改修明細を表示する。
     *
     * @param resultPanel 結果panel
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiShinsaResultPanelDiv> onClick_btnModifyDetail(
            JutakuKaishuJizenShinseiShinsaResultPanelDiv resultPanel, JutakuKaishuJizenShinseiContentsPanelDiv contentsPanel) {
        ResponseData<JutakuKaishuJizenShinseiShinsaResultPanelDiv> response = new ResponseData<>();

        //今回設定
        setSummaryNowData(resultPanel, contentsPanel.getJutakuJizenShinseiDetailInput()
                .getDgJutakuKaishuDetail().getDataSource().get(0).getTxtMitsumoriAmount().getValue());
        response.data = resultPanel;
        return response;

    }

    /**
     * 限度額チェックボタン押下時に「要介護状態区分３段階変更による」にチェックを入れます。
     *
     * @param resultPanel
     * @param contentsPanel
     * @return
     */
    public ResponseData<JutakuKaishuJizenShinseiShinsaResultPanelDiv> onClick_btnCheckGendogaku(
            JutakuKaishuJizenShinseiShinsaResultPanelDiv resultPanel, JutakuKaishuJizenShinseiContentsPanelDiv contentsPanel) {
        ResponseData<JutakuKaishuJizenShinseiShinsaResultPanelDiv> response = new ResponseData<>();

        resultPanel.getChkResetInfo().setSelectedItems(createSetItems());
        response.data = resultPanel;
        return response;
    }

    private List<KeyValueDataSource> createSetItems() {
        List<KeyValueDataSource> items = new ArrayList<>();
        items.add(new KeyValueDataSource(new RString("threeUp"), new RString("要介護状態区分３段階変更による")));
        return items;
    }

    /**
     * 住宅改修費事前申請登録 判定区分を選択するとき、承認条件の内容を入力欄を不入力・入力可能。
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiShinsaResultPanelDiv> onClick_radJudgeKubun(
            JutakuKaishuJizenShinseiShinsaResultPanelDiv panel, JutakuKaishuJizenShinseiContentsPanelDiv contentsPanel) {
        ResponseData<JutakuKaishuJizenShinseiShinsaResultPanelDiv> response = new ResponseData<>();

//        System.out.println("++++" + panel.getRadJudgeKubun().getSelectedItem().toString());
        String selRadJudgeKubun = panel.getRadJudgeKubun().getSelectedItem().toString();

        //判定区分を選択するとき shonin 承認
        if (selRadJudgeKubun.equals("shonin")) {
            panel.getTxtShoninCondition().setDisabled(false);
            panel.getTxtFushoninReason().setDisabled(true);
            //判定区分を選択するとき fushonin 不承認
        } else if (selRadJudgeKubun.equals("fushonin")) {
            panel.getTxtFushoninReason().setDisabled(false);
            panel.getTxtShoninCondition().setDisabled(true);
        }
        response.data = panel;
        return response;
    }

    /*
     前回・今回　初期化設定の初期値をセットします。
     */
    private void setSummary(JutakuKaishuJizenShinseiShinsaResultPanelDiv panel) {

        /////////////////////////////////////////////////////////////////////////////////////////
        //JutakuData.xml Read　②
        //前回
        String payTotalMae = ymlData.get(4).get("payTotalMae").toString();
        String hokenSeikyuAmountMae = ymlData.get(4).get("hokenSeikyuAmountMae").toString();
        String riyoshaFutanAmountMae = ymlData.get(4).get("riyoshaFutanAmountMae").toString();
        String limitOverAmountMae = ymlData.get(4).get("limitOverAmountMae").toString();
        //今回
        String payTotalNow = ymlData.get(4).get("payTotalNow").toString();
        String hokenSeikyuAmountNow = ymlData.get(4).get("hokenSeikyuAmountNow").toString();
        String riyoshaFutanAmountNow = ymlData.get(4).get("riyoshaFutanAmountNow").toString();
        String limitOverAmountNow = ymlData.get(4).get("limitOverAmountNow").toString();
        /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        //前回
        panel.getJutakuJizenShinseiKyufugakuSummary().getTblSeikyuSummary().getTxtHiyoTotalMae().setValue(new Decimal(payTotalMae));
        panel.getJutakuJizenShinseiKyufugakuSummary().getTblSeikyuSummary().getTxtHokenTaishoHiyoMae().setValue(new Decimal(hokenSeikyuAmountMae));
        panel.getJutakuJizenShinseiKyufugakuSummary().getTblSeikyuSummary().getTxtHokenKyufuAmountMae().setValue(new Decimal(riyoshaFutanAmountMae));
        panel.getJutakuJizenShinseiKyufugakuSummary().getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae().setValue(new Decimal(limitOverAmountMae));

        //今回
        panel.getJutakuJizenShinseiKyufugakuSummary().getTblSeikyuSummary().getTxtHiyoTotalNow().setValue(new Decimal(payTotalNow));
        panel.getJutakuJizenShinseiKyufugakuSummary().getTblSeikyuSummary().getTxtHokenTaishoHiyoNow().setValue(new Decimal(hokenSeikyuAmountNow));
        panel.getJutakuJizenShinseiKyufugakuSummary().getTblSeikyuSummary().getTxtHokenKyufuAmountNow().setValue(new Decimal(riyoshaFutanAmountNow));
        panel.getJutakuJizenShinseiKyufugakuSummary().getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(new Decimal(limitOverAmountNow));
    }

    /*
     今回の支払状況の値を設定します。
     */
    private void setSummaryNowData(JutakuKaishuJizenShinseiShinsaResultPanelDiv resultPanel, Decimal mitsumoriAmount) {

//        /////////////////////////////////////////////////////////////////////////////////////////
//        //JutakuData.xml Read　②
//        //今回
//        String payTotalNow = ymlData.get(9).get("payTotalNow").toString();
//        String hokenSeikyuAmountNow = ymlData.get(9).get("hokenSeikyuAmountNow").toString();
//        String riyoshaFutanAmountNow = ymlData.get(9).get("riyoshaFutanAmountNow").toString();
//        String limitOverAmountNow = ymlData.get(9).get("limitOverAmountNow").toString();
//        /////////////////////////////////////////////////////////////////////////////////////////
        resultPanel.getJutakuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtHiyoTotalNow().setValue(mitsumoriAmount);
        resultPanel.getJutakuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtHokenTaishoHiyoNow().setValue(mitsumoriAmount);
        resultPanel.getJutakuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtHokenKyufuAmountNow().setValue(mitsumoriAmount.multiply(0.9));
        resultPanel.getJutakuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(mitsumoriAmount.multiply(0.1));
    }

    /*
     審査結果の初期値をセットします。
     */
    private void setShinseiShinsaResult(JutakuKaishuJizenShinseiShinsaResultPanelDiv panel) {

//        /////////////////////////////////////////////////////////////////////////////////////////
//        //JutakuData.xml Read　②
//        String judgeDate = ymlData.get(10).get("judgeDate").toString();
//        String judgeKubun = ymlData.get(10).get("judgeKubun").toString();
//        String shoninCondition = ymlData.get(10).get("shoninCondition").toString();
//
//        /////////////////////////////////////////////////////////////////////////////////////////
//        //TO DO  JutakuData.xml Write　③
//        panel.getTxtJudgeDate().setValue(new RDate(judgeDate));
        panel.getRadJudgeKubun().setSelectedItem(new RString("shonin"));
//        panel.getTxtShoninCondition().setValue(new RString(shoninCondition));

    }

    /*
     *判定区分(承認、不承認）セットする。
     */
    private void setRadJudgeKubun(JutakuKaishuJizenShinseiShinsaResultPanelDiv panel) {

        panel.getTxtFushoninReason().setDisabled(true);
    }
}
