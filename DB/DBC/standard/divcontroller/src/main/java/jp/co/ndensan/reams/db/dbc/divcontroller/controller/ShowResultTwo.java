/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.SetaiInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.ShowResultTwoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgJudgementResultL_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0030011.dgJudgementResultR_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * 高額介護サービス費照会 #37963
 *
 * @author n8223
 */
public class ShowResultTwo {

    /**
     * 高額介護サービス費照会 並べて表示
     *
     * @author n8223
     * @param panel
     * @param setaiInfopanel
     * @return
     */
    public ResponseData<ShowResultTwoDiv> onClick_btnShowTwo(ShowResultTwoDiv panel, SetaiInfoDiv setaiInfopanel) {
        ResponseData<ShowResultTwoDiv> response = new ResponseData<>();
        // 並べて表示 提供年月～世帯集約番号        
        //2014.07.01 追加
        setKogakuServicehiShowResultTwo(panel,setaiInfopanel);
        //判定結果　L
        //2014.07.01 追加
        setKogakuServicehiShowResultTwoJudgementResultL(panel);
        //判定結果　R
        //2014.07.01 追加
        setKogakuServicehiShowResultTwoJudgementResultR(panel);

        response.data = panel;
        return response;
    }

    // 並べて表示 提供年月～世帯集約番号の情報を設定する。
    private void setKogakuServicehiShowResultTwo(ShowResultTwoDiv panel ,SetaiInfoDiv setaiInfopanel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiShowResultTwo.yml");
        HashMap hashMap;
        ControlGenerator ymlDt;

        hashMap = ymlData.get(0);
        ymlDt = new ControlGenerator(hashMap);

        // 提供年月～世帯集約番号(氏名）   
        panel.getTxtTeikyoYMShowTwo().setValue(ymlDt.getAsRDate("teikyoYMShowTwo"));
        panel.getTxtSetaiShuyakuNo().setValue(ymlDt.getAsRString("setaiShuyakuNo"));
        //2014.07.01 追加　朴
//        panel.getTxtSetaiShuyakuNo().setValue(ymlDt.getAsRString(
//                servicehiListpanel.getDgKogakuServicehiRireki().getClickedItem().getTxtHihoName().toString())
//        );

        System.out.println("+++++++++++++++++" + setaiInfopanel.getSetaiinShotoku().getDgSetaiShotoku().getSelectedItems().toArray().length);
                
        //setsetaiInfopanel　所得選択された情報　2014.07.04 
        // 選択行の情報を取得
        if (setaiInfopanel.getSetaiinShotoku().getDgSetaiShotoku().getSelectedItems().size() > 0) {

            for (int i = 0; i < setaiInfopanel.getSetaiinShotoku().getDgSetaiShotoku().getSelectedItems().size(); i++) {
                //dgJudgementResultLR	 判定結果
                if (i == 0) {
                    
                    System.out.println("++++++++++++++++++++! I " + i);
                    panel.getTxtHihoNoL().setValue(setaiInfopanel.getSetaiinShotoku().getDgSetaiShotoku().getSelectedItems().get(i).getTxtKetsugo01().replace("<br>", ""));
                    panel.getTxtHihoNameR().setValue(setaiInfopanel.getSetaiinShotoku().getDgSetaiShotoku().getSelectedItems().get(i).getTxtShimei());
                } else if (i == 1) {
                    System.out.println("++++++++++++++++++++! I " + i);
                    panel.getTxtHihoNoR().setValue(setaiInfopanel.getSetaiinShotoku().getDgSetaiShotoku().getSelectedItems().get(i).getTxtKetsugo01().replace("<br>", ""));
                    panel.getTxtHihoNameL().setValue(setaiInfopanel.getSetaiinShotoku().getDgSetaiShotoku().getSelectedItems().get(i).getTxtShimei());

                }
            }

        } else {
            //dgJudgementResultLR	 判定結果
            panel.getTxtHihoNoL().setValue(ymlDt.getAsRString("hihoNoL"));
            panel.getTxtHihoNameR().setValue(ymlDt.getAsRString("hhoNameR"));
            panel.getTxtHihoNoR().setValue(ymlDt.getAsRString("hihoNoR"));
            panel.getTxtHihoNameL().setValue(ymlDt.getAsRString("hihoNameL"));
        }


        hashMap = ymlData.get(1);
        ymlDt = new ControlGenerator(hashMap);

        panel.getJudgementResultL().getTxtBikoL().setValue(ymlDt.getAsRString("bkoL"));
        panel.getJudgementResultL().getTxtUketsukeDateL().setValue(ymlDt.getAsRDate("uketsukeDateL"));

        //2014.07.01 park 追加
        panel.getJudgementResultL().getTxtKetteiDateL().setValue(ymlDt.getAsRDate("ketteiDateL"));
//        panel.getJudgementResultL().getTxtKetteiDateL().setValue(
//                new RDate(servicehiListpanel.getDgKogakuServicehiRireki().getClickedItem().getTxtKetteiDate().toString()));

        //2014.07.01 park　追加
        panel.getJudgementResultL().getTxtShiharaiAmountL().setValue(ymlDt.getAsDecimal("shiharaiAmountL"));
//        panel.getJudgementResultL().getTxtShiharaiAmountL().setValue(
//                servicehiListpanel.getDgKogakuServicehiRireki().getClickedItem().getTxtShikyuKingaku().getValue());

        panel.getJudgementResultL().getTxtFushikyuRiyuL().setValue(ymlDt.getAsRString("fushikyuRiyuL"));

        //2014.07.01 park　追加
        panel.getJudgementResultL().getTxtShikyuAmountL().setValue(ymlDt.getAsDecimal("shikyuAmountL"));
//        panel.getJudgementResultL().getTxtShikyuAmountL().setValue(
//                servicehiListpanel.getDgKogakuServicehiRireki().getClickedItem().getTxtShikyuKingaku().getValue());

        hashMap = ymlData.get(2);
        ymlDt = new ControlGenerator(hashMap);

        panel.getJudgementResultR().getTxtBikoR().setValue(ymlDt.getAsRString("bkoR"));
        panel.getJudgementResultR().getTxtUketsukeDateR().setValue(ymlDt.getAsRDate("uketsukeDateR"));

        //2014.07.01 park　追加
        panel.getJudgementResultR().getTxtKetteiDateR().setValue(ymlDt.getAsRDate("ketteiDateR"));
//        panel.getJudgementResultR().getTxtKetteiDateR().setValue(
//                new RDate(servicehiListpanel.getDgKogakuServicehiRireki().getClickedItem().getTxtKetteiDate().toString()));
        //2014.07.01 park　追加
        panel.getJudgementResultR().getTxtShiharaiAmountR().setValue(ymlDt.getAsDecimal("shiharaiAmountR"));
//        panel.getJudgementResultR().getTxtShiharaiAmountR().setValue(
//                servicehiListpanel.getDgKogakuServicehiRireki().getClickedItem().getTxtShikyuKingaku().getValue());

        panel.getJudgementResultR().getTxtFushikyuRiyuR().setValue(ymlDt.getAsRString("fushikyuRiyuR"));

        //2014.07.01 park　追加
        panel.getJudgementResultR().getTxtShikyuAmountR().setValue(ymlDt.getAsDecimal("shikyuAmountR"));
//        panel.getJudgementResultR().getTxtShikyuAmountR().setValue(
//                servicehiListpanel.getDgKogakuServicehiRireki().getClickedItem().getTxtShikyuKingaku().getValue());
    }

    // dgJudgementResultL	 判定結果
    private void setKogakuServicehiShowResultTwoJudgementResultL(ShowResultTwoDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiShowResultTwoJudgementResultL.yml");

        List<dgJudgementResultL_Row> arraydata = createRowKogakuServicehiShowResultTwoJudgementResultLTestData(ymlData );
        DataGrid<dgJudgementResultL_Row> grid = panel.getJudgementResultL().getDgJudgementResultL();

        grid.setDataSource(arraydata);

    }

    private List<dgJudgementResultL_Row> createRowKogakuServicehiShowResultTwoJudgementResultLTestData(List<HashMap> ymlData) {
        List<dgJudgementResultL_Row> arrayData = new ArrayList<>();

        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);
            ControlGenerator ymlDt = new ControlGenerator(hashMap);
            hashMapResultL(ymlDt, arrayData);
        }

        return arrayData;
    }

    //gJudgementResultL	 判定結果
    private void hashMapResultL(ControlGenerator hashMap, List<dgJudgementResultL_Row> arrayData) {

        dgJudgementResultL_Row item;
        
        item = createRowKogakuServicehiShowResultLData(
                hashMap.getAsRString("jigyosha"),
                hashMap.getAsRString("serviceShurui"),
                hashMap.getAsRString("serviceHiyoTotalAmount"),
                hashMap.getAsRString("riyoshaFutanTotalAmount"),
                hashMap.getAsRString("santeiKijunAmount"),
                hashMap.getAsRString("shiharaizumiAmount"),
                hashMap.getAsRString("kogakuShikyuAmount")

        );
        arrayData.add(item);
    }

    private dgJudgementResultL_Row createRowKogakuServicehiShowResultLData(
            RString jigyosha,
            RString serviceShurui,
            RString serviceHiyoTotalAmount,
            RString riyoshaFutanTotalAmount,
            RString santeiKijunAmount,
            RString shiharaizumiAmount,
            RString kogakuShikyuAmount
    ) {
        dgJudgementResultL_Row rowKogakuServicehiShowResultLData;
        rowKogakuServicehiShowResultLData = new dgJudgementResultL_Row(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY
        );

        //事業者
        rowKogakuServicehiShowResultLData.setTxtJigyosha(jigyosha);
        //サービス種類
        rowKogakuServicehiShowResultLData.setTxtServiceShurui(serviceShurui);
        //サービス費用合計
        rowKogakuServicehiShowResultLData.setTxtServiceHiyoTotalAmount(serviceHiyoTotalAmount);
        //利用者<負担額合計
        rowKogakuServicehiShowResultLData.setTxtRiyoshaFutanTotalAmount(riyoshaFutanTotalAmount);
        //算定基準額
        rowKogakuServicehiShowResultLData.setTxtSanteiKijunAmount(santeiKijunAmount);
        //支払済金額
        rowKogakuServicehiShowResultLData.setTxtShiharaizumiAmount(shiharaizumiAmount);
        //高額支給額
        rowKogakuServicehiShowResultLData.setTxtKogakuShikyuAmount(kogakuShikyuAmount);

        return rowKogakuServicehiShowResultLData;

    }

    // dgJudgementResultR	 判定結果
    private void setKogakuServicehiShowResultTwoJudgementResultR(ShowResultTwoDiv panel) {
        List<HashMap> ymlData = ymlData("dbc0030011/KogakuServicehiShowResultTwoJudgementResultR.yml");

        List<dgJudgementResultR_Row> arraydata = createRowKogakuServicehiShowResultTwoJudgementResultRTestData(ymlData);
        DataGrid<dgJudgementResultR_Row> grid = panel.getJudgementResultR().getDgJudgementResultR();

        grid.setDataSource(arraydata);

    }

    private List<dgJudgementResultR_Row> createRowKogakuServicehiShowResultTwoJudgementResultRTestData(List<HashMap> ymlData) {
        List<dgJudgementResultR_Row> arrayData = new ArrayList<>();

        //TO DO データを増える場合。
        for (int i = 0; i < ymlData.size(); i++) {
            HashMap hashMap = ymlData.get(i);
            ControlGenerator ymlDt = new ControlGenerator(hashMap);
            hashMapResultR(ymlDt, arrayData);
        }

        return arrayData;

    }

    private void hashMapResultR(ControlGenerator hashMap, List<dgJudgementResultR_Row> arrayData) {
        dgJudgementResultR_Row item;

        item = createRowKogakuServicehiShowResultRData(
                hashMap.getAsRString("jigyosha"),
                hashMap.getAsRString("serviceShurui"),
                hashMap.getAsRString("serviceHiyoTotalAmount"),
                hashMap.getAsRString("riyoshaFutanTotalAmount"),
                hashMap.getAsRString("santeiKijunAmount"),
                hashMap.getAsRString("shiharaizumiAmount"),
                hashMap.getAsRString("kogakuShikyuAmount")
        );
        arrayData.add(item);

    }

    private dgJudgementResultR_Row createRowKogakuServicehiShowResultRData(
            RString jigyosha,
            RString serviceShurui,
            RString serviceHiyoTotalAmount,
            RString riyoshaFutanTotalAmount,
            RString santeiKijunAmount,
            RString shiharaizumiAmount,
            RString kogakuShikyuAmount
    ) {
        dgJudgementResultR_Row rowKogakuServicehiShowResultRData;
        rowKogakuServicehiShowResultRData = new dgJudgementResultR_Row(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY
        );

        //事業者
        rowKogakuServicehiShowResultRData.setTxtJigyosha(jigyosha);
        //サービス種類
        rowKogakuServicehiShowResultRData.setTxtServiceShurui(serviceShurui);
        //サービス費用合計
        rowKogakuServicehiShowResultRData.setTxtServiceHiyoTotalAmount(serviceHiyoTotalAmount);
        //利用者<負担額合計
        rowKogakuServicehiShowResultRData.setTxtRiyoshaFutanTotalAmount(riyoshaFutanTotalAmount);
        //算定基準額
        rowKogakuServicehiShowResultRData.setTxtSanteiKijunAmount(santeiKijunAmount);
        //支払済金額
        rowKogakuServicehiShowResultRData.setTxtShiharaizumiAmount(shiharaizumiAmount);
        //高額支給額
        rowKogakuServicehiShowResultRData.setTxtKogakuShikyuAmount(kogakuShikyuAmount);

        return rowKogakuServicehiShowResultRData;
    }

    private List<HashMap> ymlData(String ymlData) {
        return YamlLoader.DBC.loadAsList(new RString(ymlData));
    }

}
