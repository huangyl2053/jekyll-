/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC4200011.dgServicehiHiritsu_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC4200011.dgServicehiShurui_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC4200011.ShikyuGendogakuKyotakuServiceDetailPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC4200011.ShikyuGendogakuKyotakuServiceListPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 支給限度額登録（居宅サービス費）
 * @author n8223
 */
public class ShikyuGendogakuKyotakuServiceDetailPanel {

//    final static String RadIdoKubun1 = "1:新規";
//    final static String RadIdoKubun2 = "2:変更";
//    final static String RadIdoKubun3 = "3:終了";

    final static String ShikyuKun = "区分支給";
    final static String ShuruiKun = "種類支給";

    final static String AddedFlg = "追加";
    final static String ModifiedFlg = "修正";
    final static String DeletefFlag = "削除";

    /**
     * 支給限度額登録（居宅サービス費）　区分支給限度額を追加するボタン押下後、（居宅サービス費）サービス費区分支給限度内容の情報を表示する
     *
     * @author n8223
     */
    public ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> onClick_btnAddKubunShikyuGendogaku(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel, ShikyuGendogakuKyotakuServiceListPanelDiv panel1) {
        ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> response = new ResponseData<>();

        panel.getKubunShikyuGendogaku().setDisplayNone(false);
        panel.getKubunShikyuGendogaku().setVisible(true);
            
        //支給限度額
        setShikyuKubunGendogakuKyotaku(panel);

        response.data = panel;
        return response;

    }

    private void setShikyuKubunGendogakuKyotaku(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel) {

        List<HashMap> ymlData = ymlData("dbc4200011/ShikyuGendogakuKyotakuServiceDetailKubunShikyuGendogaku.yml");

        //VIEWPUT
        String kun = ShikyuKun;
        String flg = AddedFlg;
        setViewPutState(panel,
                kun,
                flg,
                ymlData.get(0).get("idoDate").toString(),
                panel.getShikyuGendogakuKyotakuServiceTop().getRadIdoKubun().getSelectedValue().toString(),
                ymlData.get(0).get("yukoDateRangefrom").toString(),
               (String) ymlData.get(0).get("yukoDateRangeto"));
        
        //TOP
        //異動日
        panel.getShikyuGendogakuKyotakuServiceTop().getTxtIdoDate().setValue(new RDate(ymlData.get(0).get("idoDate").toString()));
        //異動区分 new 
        panel.getShikyuGendogakuKyotakuServiceTop().getRadIdoKubun().setSelectedItem(new RString("radIdoKubun"));
        //異動事由
        panel.getShikyuGendogakuKyotakuServiceTop().getTxtIdoJiyu().setValue(new RString(ymlData.get(0).get("idoJiyu").toString()));
        //有効期間 from ~ to 
        panel.getShikyuGendogakuKyotakuServiceTop().getTxtYukoDateRange().setFromValue(new RDate(ymlData.get(0).get("yukoDateRangefrom").toString()));
        
        //panel.getShikyuGendogakuKyotakuServiceTop().getTxtYukoDateRange().setToValue(new RDate((String) ymlData.get(0).get("yukoDateRangeto")));

        
        //サービス費区分支給限度基準額
        //支給限度基準額（旧訪問通所） 
        //要介護1
        panel.getKubunShikyuGendogaku().getTplKubunShikyuGendogaku().getTxtShikyuGendoKijungakuYokaigo1().setValue(new Decimal(
                ymlData.get(0).get("shikyuGendoKijungakuYokaigo1").toString()));
        //要介護2
        panel.getKubunShikyuGendogaku().getTplKubunShikyuGendogaku().getTxtShikyuGendoKijungakuYokaigo2().setValue(new Decimal(
                ymlData.get(0).get("shikyuGendoKijungakuYokaigo2").toString()));
        //要介護3
        panel.getKubunShikyuGendogaku().getTplKubunShikyuGendogaku().getTxtShikyuGendoKijungakuYokaigo3().setValue(new Decimal(
                ymlData.get(0).get("shikyuGendoKijungakuYokaigo3").toString()));
        //要介護4
        panel.getKubunShikyuGendogaku().getTplKubunShikyuGendogaku().getTxtShikyuGendoKijungakuYokaigo4().setValue(new Decimal(
                ymlData.get(0).get("shikyuGendoKijungakuYokaigo4").toString()));
        //要介護5
        panel.getKubunShikyuGendogaku().getTplKubunShikyuGendogaku().getTxtShikyuGendoKijungakuYokaigo5().setValue(new Decimal(
                ymlData.get(0).get("shikyuGendoKijungakuYokaigo5").toString()));
        //介護予防
        panel.getKubunShikyuGendogaku().getTplKubunShikyuGendogaku().getTxtShikyuGendoKijungakuKyotakuShien().setValue(new Decimal(
                ymlData.get(0).get("shikyuGendoKijungakuKyotakuShien").toString()));
        //要支援1
        panel.getKubunShikyuGendogaku().getTplKubunShikyuGendogaku().getTxtShikyuGendoKijungakuYoshien1().setValue(new Decimal(
                ymlData.get(0).get("shikyuGendoKijungakuYoshien1").toString()));
        //要支援2
        panel.getKubunShikyuGendogaku().getTplKubunShikyuGendogaku().getTxtShikyuGendoKijungakuYoshien2().setValue(new Decimal(
                ymlData.get(0).get("shikyuGendoKijungakuYoshien2").toString()));

    }

    /**
     * 支給限度額登録（居宅サービス費）　種類支給限度額を追加するボタン押下後、（居宅サービス費）サービス費種類支給限度内容の情報を表示する
     *
     * @author n8223
     */
    public ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> onClick_btnAddShuruiShikyuGendogaku(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel, ShikyuGendogakuKyotakuServiceListPanelDiv panel1) {
        ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> response = new ResponseData<>();

         panel.getShuruiShikyuGendogaku().setDisplayNone(false);
         panel.getShuruiShikyuGendogaku().setVisible(true);
        
        //種類支給額
        setShikyuGendogakuKyotaku(panel);

        response.data = panel;
        return response;
    }

    private void setShikyuGendogakuKyotaku(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel) {

        List<HashMap> ymlData = ymlData("dbc4200011/ShikyuGendogakuKyotakuServiceDetailKubunShikyuGendogaku.yml");
        
        
         //VIEWPUT
        String kun = ShuruiKun;
        String flg = AddedFlg;
        setViewPutState(panel,
                kun,
                flg,
                ymlData.get(0).get("idoDate").toString(),
                panel.getShikyuGendogakuKyotakuServiceTop().getRadIdoKubun().getSelectedValue().toString(),
                ymlData.get(0).get("yukoDateRangefrom").toString(),
               (String) ymlData.get(0).get("yukoDateRangeto"));

        //TOP
        //異動日
        panel.getShikyuGendogakuKyotakuServiceTop().getTxtIdoDate().setValue(new RDate(ymlData.get(0).get("idoDate").toString()));
        //異動区分 new 
        panel.getShikyuGendogakuKyotakuServiceTop().getRadIdoKubun().setSelectedItem(new RString("radIdoKubun"));
        //異動事由
        panel.getShikyuGendogakuKyotakuServiceTop().getTxtIdoJiyu().setValue(new RString(ymlData.get(0).get("idoJiyu").toString()));
        //有効期間 from ~ to 
        panel.getShikyuGendogakuKyotakuServiceTop().getTxtYukoDateRange().setFromValue(new RDate(ymlData.get(0).get("yukoDateRangefrom").toString()));
       // panel.getShikyuGendogakuKyotakuServiceTop().getTxtYukoDateRange().setToValue(new RDate((String) ymlData.get(0).get("yukoDateRangeto")));

    }

    /**
     * 支給限度額登録（居宅サービス費）　サービス費種類支給限度標準額の内容を追加するため、追加ボタン押す。
     *
     * @author n8223
     */
    public ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> onClick_btnAddServicehiShurui(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel, ShikyuGendogakuKyotakuServiceListPanelDiv panel1) {
        ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> response = new ResponseData<>();

        List<dgServicehiShurui_Row> arraydata = setAddServicehiShuruiList(panel);
        DataGrid<dgServicehiShurui_Row> grid = panel.getShuruiShikyuGendogaku().getDgServicehiShurui();

        // grid.getDataSource().addAll(arraydata);
        grid.setDataSource(arraydata);

        response.data = panel;
        return response;
    }

    private List<dgServicehiShurui_Row> setAddServicehiShuruiList(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel) {

        List<HashMap> ymlData = ymlData("dbc4200011/ShikyuGendogakuKyotakuServiceDetaildgServicehiShurui.yml");

        List<dgServicehiShurui_Row> arrayData = new ArrayList<>();
        dgServicehiShurui_Row item;

        item = createRowAddServicehiShuruiList(
                //要介護1
                ymlData.get(0).get("yokaigo1").toString(),
                //要介護2
                ymlData.get(0).get("yokaigo2").toString(),
                //要介護3 
                ymlData.get(0).get("yokaigo3").toString(),
                //要介護4
                ymlData.get(0).get("yokaigo4").toString(),
                //要介護5 
                ymlData.get(0).get("yokaigo5").toString(),
                //要支援1
                ymlData.get(0).get("yoshien1").toString(),
                //要支援2
                ymlData.get(0).get("yoshien2").toString()
        );

        arrayData.add(item);
        return arrayData;

    }

    private dgServicehiShurui_Row createRowAddServicehiShuruiList(
            String 要介護1,
            String 要介護2,
            String 要介護3,
            String 要介護4,
            String 要介護5,
            String 要支援1,
            String 要支援2
    ) {
        dgServicehiShurui_Row rowAddServicehiShuruiListData;
        rowAddServicehiShuruiListData = new dgServicehiShurui_Row(
                new DropDownList(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum(),
                new TextBoxNum()
        );

        rowAddServicehiShuruiListData.getYokaigo1().setValue(new Decimal(要介護1));
        rowAddServicehiShuruiListData.getYokaigo2().setValue(new Decimal(要介護2));
        rowAddServicehiShuruiListData.getYokaigo3().setValue(new Decimal(要介護3));
        rowAddServicehiShuruiListData.getYokaigo4().setValue(new Decimal(要介護4));
        rowAddServicehiShuruiListData.getYokaigo5().setValue(new Decimal(要介護5));
        rowAddServicehiShuruiListData.getYoshien1().setValue(new Decimal(要支援1));
        rowAddServicehiShuruiListData.getYoshien2().setValue(new Decimal(要支援2));

        return rowAddServicehiShuruiListData;
    }

    /**
     * 支給限度額登録（居宅サービス費）　標準該該当サービス費比率の内容を追加するため、追加ボタン押す。
     *
     * @author n8223
     */
    public ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> onClick_btnAddServicehiHiritsu(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel, ShikyuGendogakuKyotakuServiceListPanelDiv panel1) {
        ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> response = new ResponseData<>();

        List<dgServicehiHiritsu_Row> arraydata = setAddServicehiHiritsuList(panel);
        DataGrid<dgServicehiHiritsu_Row> grid = panel.getShuruiShikyuGendogaku().getDgServicehiHiritsu();

        // grid.getDataSource().addAll(arraydata);
        grid.setDataSource(arraydata);

        response.data = panel;
        return response;

    }

    private List<dgServicehiHiritsu_Row> setAddServicehiHiritsuList(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel) {

        List<HashMap> ymlData = ymlData("dbc4200011/ShikyuGendogakuKyotakuServiceDetaildgServicehiHiritsu.yml");

        List<dgServicehiHiritsu_Row> arrayData = new ArrayList<>();
        dgServicehiHiritsu_Row item;

        item = createRowAddServicehiHiritsuList(
                //比率
                ymlData.get(0).get("hiritsu").toString()
        );

        arrayData.add(item);
        return arrayData;

    }

    private dgServicehiHiritsu_Row createRowAddServicehiHiritsuList(
            String 比率
    ) {
        dgServicehiHiritsu_Row rowAddServicehiHiritsuListData;
        rowAddServicehiHiritsuListData = new dgServicehiHiritsu_Row(
                new DropDownList(),
                new TextBoxNum()
        );

        rowAddServicehiHiritsuListData.getHiritsu().setValue(new Decimal(比率));

        return rowAddServicehiHiritsuListData;
    }

    /**
     * 支給限度額登録（居宅サービス費）　支給限度額一覧の行を選択によって【　区分支給処理、　種類支給処理　】の内容を入力する。
     *
     * @author n8223
     */
    public ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> onClick_btnModifyRow(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel, ShikyuGendogakuKyotakuServiceListPanelDiv panel1) {
        ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> response = new ResponseData<>();

        if (panel1.getDgShikyuGendogakuKyotakuService().getClickedItem().getTxtKubunOrShurui().toString().equals(ShikyuKun)) {
            setViewPutState(panel,
                    ShikyuKun,
                    ModifiedFlg,
                    panel.getShikyuGendogakuKyotakuServiceTop().getTxtIdoDate().getValue().toString(),
                    panel.getShikyuGendogakuKyotakuServiceTop().getRadIdoKubun().getSelectedValue().toString(),
                    panel.getShikyuGendogakuKyotakuServiceTop().getTxtYukoDateRange().getFromValue().toString(),
                    panel.getShikyuGendogakuKyotakuServiceTop().getTxtYukoDateRange().getToValue().toString()
            );

            panel.getShuruiShikyuGendogaku().setDisplayNone(true);
            panel.getShuruiShikyuGendogaku().setVisible(true);

        } else if (panel1.getDgShikyuGendogakuKyotakuService().getClickedItem().getTxtKubunOrShurui().toString().equals(ShuruiKun)) {
            setViewPutState(panel,
                    ShuruiKun,
                    ModifiedFlg,
                    panel.getShikyuGendogakuKyotakuServiceTop().getTxtIdoDate().getValue().toString(),
                    panel.getShikyuGendogakuKyotakuServiceTop().getRadIdoKubun().getSelectedValue().toString(),
                    panel.getShikyuGendogakuKyotakuServiceTop().getTxtYukoDateRange().getFromValue().toString(),
                    panel.getShikyuGendogakuKyotakuServiceTop().getTxtYukoDateRange().getToValue().toString()
            );

            panel.getKubunShikyuGendogaku().setDisplayNone(true);
            panel.getKubunShikyuGendogaku().setVisible(true);
        }

        response.data = panel;
        return response;
    }

    public ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> onClick_radIdoKubun(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel, ShikyuGendogakuKyotakuServiceListPanelDiv panel1) {
        ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> response = new ResponseData<>();

        //setRadIdoKubunViewStateHolder(panel);
        String radIdoKubun = panel.getShikyuGendogakuKyotakuServiceTop().getRadIdoKubun().getSelectedValue().toString();
         ViewStateHolder.put("RADIOKUBUN", radIdoKubun);

//        if (radIdoKubun.equals(RadIdoKubun1)) {
//            ViewStateHolder.put("RADIOKUBUN", RadIdoKubun1);
//        } else if (radIdoKubun.equals(RadIdoKubun2)) {
//            ViewStateHolder.put("RADIOKUBUN", RadIdoKubun2);
//        } else if (radIdoKubun.equals(RadIdoKubun3)) {
//            ViewStateHolder.put("RADIOKUBUN", RadIdoKubun3);
//        }

        response.data = panel;
        return response;
    }

    
    public ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> onBlur_txtIdoJiyu(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel, ShikyuGendogakuKyotakuServiceListPanelDiv panel1) {
        ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> response = new ResponseData<>();

        //setIdoJiyuViewStateHolder(panel);
        String txtIdoJiyu = panel.getShikyuGendogakuKyotakuServiceTop().getTxtIdoJiyu().getValue().toString();
        ViewStateHolder.put("IDOJIYU", txtIdoJiyu);

        response.data = panel;
        return response;
    }

    public ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> onBlur_txtYukoDateRange(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel, ShikyuGendogakuKyotakuServiceListPanelDiv panel1) {
        ResponseData<ShikyuGendogakuKyotakuServiceDetailPanelDiv> response = new ResponseData<>();

        //setYukoDateRangeFromValueViewStateHolder(panel);
        String txtYukoDateRangeFromValue = panel.getShikyuGendogakuKyotakuServiceTop().getTxtYukoDateRange().getFromValue().toString();
       // String txtYukoDateRangeToValue = panel.getShikyuGendogakuKyotakuServiceTop().getTxtYukoDateRange().getToValue().toString();

        ViewStateHolder.put("YUKODATERANGEFROMVALUE", txtYukoDateRangeFromValue);
        //ViewStateHolder.put("YUKODATERANGETOVALUE", txtYukoDateRangeToValue);

        response.data = panel;
        return response;
    }

    private void setViewPutState(ShikyuGendogakuKyotakuServiceDetailPanelDiv panel, String kun, String flg, String  radiokubun, String  idojiyu, String yukoDateRangeFromValue , String yukoDateRangeToValue) {
     
        
        ViewStateHolder.put("GUBUN", kun);
        ViewStateHolder.put("FLG", flg);
     
        
        radiokubun = panel.getShikyuGendogakuKyotakuServiceTop().getRadIdoKubun().getSelectedValue().toString();
        
        ViewStateHolder.put("RADIOKUBUN", radiokubun);
        
//        if (radiokubun.equals(RadIdoKubun1)) {
//            ViewStateHolder.put("RADIOKUBUN", RadIdoKubun1);
//        } else if (radiokubun.equals(RadIdoKubun2)) {
//            ViewStateHolder.put("RADIOKUBUN", RadIdoKubun2);
//        } else if (radiokubun.equals(RadIdoKubun3)) {
//            ViewStateHolder.put("RADIOKUBUN", RadIdoKubun3);
//        }
//         
        ViewStateHolder.put("IDOJIYU", idojiyu);
   
        ViewStateHolder.put("YUKODATERANGEFROMVALUE", yukoDateRangeFromValue);
        
        if (yukoDateRangeToValue.length() > 0) ViewStateHolder.put("YUKODATERANGETOVALUE", yukoDateRangeToValue);
        
        
    }

    private List<HashMap> ymlData(String ymlName) {
        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlName));
    }

}
