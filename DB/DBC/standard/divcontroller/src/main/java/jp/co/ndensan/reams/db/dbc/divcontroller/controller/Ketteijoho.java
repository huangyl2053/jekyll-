/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011.KetteijohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011.dgKetteiHokenshaDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0071011.dgKetteiKohiDetail_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 過誤決定取込情報照会画面です。
 *
 * @author N3317 塚田 萌
 * @author n8223 YMLDATA　実施
 */
public class Ketteijoho {

    final static RDate OLDDATE = new RDate("201402");
    final static RDate NEWDATE = new RDate("201404");

    final static String NEWYMLNAME = "dbc0071011/KetteijohoNew4Info.yml";
    final static String OLDYMLNAME = "dbc0071011/KetteijohoOld2Info.yml";

    /**
     * 読み込み時は最新の決定情報を表示します。
     *
     * @param panel 過誤決定取込情報照会パネル
     * @return ResponseData
     */
    public ResponseData<KetteijohoDiv> onLoad(KetteijohoDiv panel) {
        ResponseData<KetteijohoDiv> response = new ResponseData<>();

        //setDefault取扱年月
        setDefault(panel, NEWYMLNAME);
       
        panel.getKetteiHokensha().getTxtKetteiHokenshaSakuseiYMD().clearValue();
        panel.getKetteiKohi().getTxtKetteiKohiSakuseiYMD().clearValue();

//        setHokenshaCellData(panel, NEWYMLNAME);
//        setHokenshaListData(panel, NEWYMLNAME);
//
//        setKohiCellData(panel, NEWYMLNAME);
//        setKohiListData(panel, NEWYMLNAME);

        response.data = panel;

        return response;
    }

    //setDefault取扱年月
    private void setDefault(KetteijohoDiv panel, String ymlName) {
        List<HashMap> ymlData = ymlData(ymlName);

        HashMap hashMap = ymlData.get(0);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        panel.getTxtToriatsukaiYM().setValue(ymlDt.getAsRDate("toriatsukaiYM"));
        
        panel.getKetteiHokensha().getTxtKetteiHokenshaSakuseiYMD().setValue(ymlDt.getAsRDate("ketteiHokenshaSakuseiYMD"));
        panel.getKetteiKohi().getTxtKetteiKohiSakuseiYMD().setValue(ymlDt.getAsRDate("ketteiKohiSakuseiYMD"));

    }

    //create決定保険者集計 
    private void setHokenshaCellData(KetteijohoDiv panel, String ymlName) {
        List<HashMap> ymlData = ymlData(ymlName);

        HashMap hashMap = ymlData.get(1);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell11().
                setValue(ymlDt.getAsDecimal("hokenshaCell11"));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell12().
                setValue(ymlDt.getAsDecimal("hokenshaCell12"));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell13().
                setValue(ymlDt.getAsDecimal("hokenshaCell13"));

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell21().
                setValue(ymlDt.getAsDecimal("hokenshaCell21"));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell22().
                setValue(ymlDt.getAsDecimal("hokenshaCell22"));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell23().
                setValue(ymlDt.getAsDecimal("hokenshaCell23"));

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell31().
                setValue(ymlDt.getAsDecimal("hokenshaCell31"));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell32().
                setValue(ymlDt.getAsDecimal("hokenshaCell32"));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell33().
                setValue(ymlDt.getAsDecimal("hokenshaCell33"));

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell41().
                setValue(ymlDt.getAsDecimal("hokenshaCell41"));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell42().
                setValue(ymlDt.getAsDecimal("hokenshaCell42"));
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell43().
                setValue(ymlDt.getAsDecimal("hokenshaCell43"));
    }

    //create決定保険者明細 
    private void setHokenshaListData(KetteijohoDiv panel, String ymlName) {
        List<dgKetteiHokenshaDetail_Row> arraydata = createRowHokenshaTestData(ymlName);

        DataGrid<dgKetteiHokenshaDetail_Row> grid = panel.getKetteiHokensha().getDgKetteiHokenshaDetail();
        grid.setDataSource(arraydata);

    }

    private List<dgKetteiHokenshaDetail_Row> createRowHokenshaTestData(String ymlName) {
        List<dgKetteiHokenshaDetail_Row> arrayData = new ArrayList<>();
        List<HashMap> ymlData = ymlData(ymlName);

        //TO DO データを増える場合。
        for (int i = 2; i < ymlData.size(); i++) {

            HashMap hashMap = ymlData.get(i);
            ControlGenerator ymlDt = new ControlGenerator(hashMap);

            arrayData.add(createRowHokenshaList(
                    ymlDt.getAsRString("hokenshaJigyoshaNo"),
                    ymlDt.getAsRString("hokenshaJigyoshaName"),
                    ymlDt.getAsRString("hokenshaHihoNo"),
                    ymlDt.getAsRString("hokenshaHihoName"),
                    ymlDt.getAsRString("hokenshaStyle"),
                    ymlDt.getAsRString("hokenshaMoshitateRiyu"),
                    ymlDt.getAsRString("hokenshaServiceTeikyoYM"),
                    ymlDt.getAsRString("hokenshaServiceType"),
                    ymlDt.getAsDecimal("hokenshaTanisu"),
                    ymlDt.getAsDecimal("hkenshaFutangaku")
            ));
        }

        return arrayData;

    }

    private dgKetteiHokenshaDetail_Row createRowHokenshaList(
            RString hokenshaJigyoshaNo,
            RString hokenshaJigyoshaName,
            RString hokenshaHihoNo,
            RString hokenshaHihoName,
            RString hokenshaStyle,
            RString hokenshaMoshitateRiyu,
            RString hokenshaServiceTeikyoYM,
            RString hokenshaServiceType,
            Decimal hokenshaTanisu,
            Decimal hkenshaFutangaku) {

        dgKetteiHokenshaDetail_Row rowHokenshaList;
        rowHokenshaList = new dgKetteiHokenshaDetail_Row(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxNum(),
                new TextBoxNum(),
                RString.EMPTY
        );

        rowHokenshaList.setTxtHokenshaJigyoshaNo(hokenshaJigyoshaNo);
        rowHokenshaList.setTxtHokenshaJigyoshaName(hokenshaJigyoshaName);
        rowHokenshaList.setTxtHokenshaHihoNo(hokenshaHihoNo);
        rowHokenshaList.setTxtHokenshaHihoName(hokenshaHihoName);
        rowHokenshaList.setTxtHokenshaStyle(hokenshaStyle);
        rowHokenshaList.setTxtHokenshaMoshitateRiyu(hokenshaMoshitateRiyu);
        rowHokenshaList.setTxtHokenshaServiceTeikyoYM(hokenshaServiceTeikyoYM);
        rowHokenshaList.setTxtHokenshaServiceType(hokenshaServiceType);
        rowHokenshaList.getTxtHokenshaTanisu().setValue(hokenshaTanisu);
        rowHokenshaList.getTxtHokenshaFutangaku().setValue(hkenshaFutangaku);
        // rowHokenshaList.getTxtHokenshaShokisaiHokenshaNo().setValue();

        return rowHokenshaList;

    }

    //create決定公費負担者集計 
    private void setKohiCellData(KetteijohoDiv panel, String ymlName) {
        List<HashMap> ymlData = ymlData(ymlName);

        HashMap hashMap = ymlData.get(12);
        ControlGenerator ymlDt = new ControlGenerator(hashMap);

        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell11().
                setValue(ymlDt.getAsDecimal("kohiCell11"));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell12().
                setValue(ymlDt.getAsDecimal("kohiCell12"));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell13().
                setValue(ymlDt.getAsDecimal("kohiCell13"));

        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell21().
                setValue(ymlDt.getAsDecimal("kohiCell13"));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell22().
                setValue(ymlDt.getAsDecimal("kohiCell13"));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell23().
                setValue(ymlDt.getAsDecimal("kohiCell13"));

        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell31().
                setValue(ymlDt.getAsDecimal("kohiCell31"));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell32().
                setValue(ymlDt.getAsDecimal("kohiCell32"));
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell33().
                setValue(ymlDt.getAsDecimal("kohiCell33"));

    }

    //create決定公費負担者明細
    private void setKohiListData(KetteijohoDiv panel, String ymlName) {
        List<dgKetteiKohiDetail_Row> arraydata = createRowKohiTestData(ymlName);

        DataGrid<dgKetteiKohiDetail_Row> grid = panel.getKetteiKohi().getDgKetteiKohiDetail();
        grid.setDataSource(arraydata);
    }

    private List<dgKetteiKohiDetail_Row> createRowKohiTestData(String ymlName) {
        List<dgKetteiKohiDetail_Row> arrayData = new ArrayList<>();
        List<HashMap> ymlData = ymlData(ymlName);

        //TO DO データを増える場合。
        for (int i = 13; i < ymlData.size(); i++) {

            HashMap hashMap = ymlData.get(i);
            ControlGenerator ymlDt = new ControlGenerator(hashMap);

            arrayData.add(
                    createRowKohiList(
                            ymlDt.getAsRString("kohiJigyoshaNo"),
                            ymlDt.getAsRString("kohiJigyoshaName"),
                            ymlDt.getAsRString("kohiHihoNo"),
                            ymlDt.getAsRString("kohiHihoName"),
                            ymlDt.getAsRString("kohiStyle"),
                            ymlDt.getAsRString("kohiMoshitateRiyu"),
                            ymlDt.getAsRString("kohiServiceTeikyoYM"),
                            ymlDt.getAsRString("kohiServiceType"),
                            ymlDt.getAsDecimal("kohiTanisu"),
                            ymlDt.getAsDecimal("kohiFutangaku"),
                            ymlDt.getAsRString("kohiJukyushaNo"),
                            ymlDt.getAsRString("kohiFutanshaNo")
                    ));
        }

        return arrayData;

    }

    private dgKetteiKohiDetail_Row createRowKohiList(
            RString kohiJigyoshaNo,
            RString kohiJigyoshaName,
            RString kohiHihoNo,
            RString kohiHihoName,
            RString kohiStyle,
            RString kohiMoshitateRiyu,
            RString kohiServiceTeikyoYM,
            RString kohiServiceType,
            Decimal kohiTanisu,
            Decimal kohiFutangaku,
            RString kohiJukyushaNo,
            RString kohiFutanshaNo
    ) {

        dgKetteiKohiDetail_Row rowKohiList;
        rowKohiList = new dgKetteiKohiDetail_Row(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                new TextBoxNum(),
                new TextBoxNum(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY
        );

        rowKohiList.setTxtKohiJigyoshaNo(kohiJigyoshaNo);
        rowKohiList.setTxtKohiJigyoshaName(kohiJigyoshaName);
        rowKohiList.setTxtKohiHihoNo(kohiHihoNo);
        rowKohiList.setTxtKohiHihoName(kohiHihoName);
        rowKohiList.setTxtKohiStyle(kohiStyle);
        rowKohiList.setTxtKohiMoshitateRiyu(kohiMoshitateRiyu);
        rowKohiList.setTxtKohiServiceTeikyoYM(kohiServiceTeikyoYM);
        rowKohiList.setTxtKohiServiceType(kohiServiceType);
        rowKohiList.getTxtKohiTanisu().setValue(kohiTanisu);
        rowKohiList.getTxtKohiFutangaku().setValue(kohiFutangaku);
        rowKohiList.setTxtKohiJukyushaNo(kohiJukyushaNo);
        rowKohiList.setTxtKohiFutanshaNo(kohiFutanshaNo);
        // rowKohiList.getTxtHokenshaShokisaiHokenshaNo().setValue();

        return rowKohiList;

    }

    /**
     * 取扱年月を指定して表示するボタンで、指定年月の決定情報を表示します。
     *
     * @param panel 過誤決定取込情報照会パネル
     * @return ResponseData
     */
    public ResponseData<KetteijohoDiv> onClick_btnSearch(KetteijohoDiv panel) {
        ResponseData<KetteijohoDiv> response = new ResponseData<>();

        //取扱年月を指定した
        RDate txtToriatsukaiYM = panel.getTxtToriatsukaiYM().getValue();

        if (txtToriatsukaiYM.equals(OLDDATE)) {

            //setDefault取扱年月
            setDefault(panel, OLDYMLNAME);

            //create決定保険者集計
            setHokenshaCellData(panel, OLDYMLNAME);
            //create決定保険者明細 
            setHokenshaListData(panel, OLDYMLNAME);

            setKohiCellData(panel, OLDYMLNAME);
            setKohiListData(panel, OLDYMLNAME);

        } else if (txtToriatsukaiYM.equals(NEWDATE)) {

            //setDefault取扱年月
            setDefault(panel, NEWYMLNAME);

            //create決定保険者集計
            setHokenshaCellData(panel, NEWYMLNAME);
            //create決定保険者明細 
            setHokenshaListData(panel, NEWYMLNAME);

            setKohiCellData(panel, NEWYMLNAME);
            setKohiListData(panel, NEWYMLNAME);

        } else {
            setHokenshaKetteiClear(panel);

        }

        response.data = panel;
        return response;

    }

    private void setHokenshaKetteiClear(KetteijohoDiv panel) {

        panel.getKetteiHokensha().getTxtKetteiHokenshaSakuseiYMD().clearValue();
        panel.getKetteiKohi().getTxtKetteiKohiSakuseiYMD().clearValue();

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell11().clearValue();
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell12().clearValue();
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell13().clearValue();

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell21().clearValue();
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell22().clearValue();
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell23().clearValue();

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell31().clearValue();
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell32().clearValue();
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell33().clearValue();

        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell41().clearValue();
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell42().clearValue();
        panel.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell43().clearValue();

        List<dgKetteiHokenshaDetail_Row> arrayHokenshaDetaildata = new ArrayList<>();
        DataGrid<dgKetteiHokenshaDetail_Row> gridHokenshaDetail = panel.getKetteiHokensha().getDgKetteiHokenshaDetail();
        gridHokenshaDetail.setDataSource(arrayHokenshaDetaildata);

        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell11().clearValue();
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell12().clearValue();
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell13().clearValue();

        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell21().clearValue();
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell22().clearValue();
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell23().clearValue();

        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell31().clearValue();
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell32().clearValue();
        panel.getKetteiKohi().getKetteiKohiShukei().getTxtKohiCell33().clearValue();

        List<dgKetteiKohiDetail_Row> arrayKohiDetaildata = new ArrayList<>();
        DataGrid<dgKetteiKohiDetail_Row> gridKetteiKohiDetail = panel.getKetteiKohi().getDgKetteiKohiDetail();
        gridKetteiKohiDetail.setDataSource(arrayKohiDetaildata);

    }

    private List<HashMap> ymlData(String ymlName) {
        return YamlLoader.DBC.loadAsList(new RString(ymlName));
    }

}
