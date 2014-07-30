/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiServiceCategory;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiServiceCollection;
import jp.co.ndensan.reams.db.dbc.business.KyufuJissekiServiceCollections;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ServiceCategorySubTitle;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ServiceCategoryTitle;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.KyufuJissekiSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.dgKyufuJissekiMeisaiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0010000.dgKyufuJissekiGokeiList_Row;
import jp.co.ndensan.reams.db.dbc.realservice.KyufuJissekiServiceFinder;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.*;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumn;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiList {

    public ResponseData<KyufuJissekiListDiv> onClick_btnKyufuJissekiSearch(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {
        ResponseData<KyufuJissekiListDiv> response = new ResponseData<>();

        setHeaderData(panel, panel2);
        setMeisaiData(panel, panel2);
        setGokeiData(panel, panel2);

        response.data = panel;
        return response;
    }

    public ResponseData<KyufuJissekiListDiv> onClick_btnKyufuJissekiResearch(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {
        ResponseData<KyufuJissekiListDiv> response = new ResponseData<>();
        panel.getTxtKyufuJissekiListHihokenshaNo().setValue(RString.EMPTY);
        panel.getTxtKyufuJissekiListJuminShubetsu().setValue(RString.EMPTY);
        panel.getTxtKyufuJissekiListYokaigodo().setValue(RString.EMPTY);
        panel.getTxtKyufuJissekiListNinteiYukoKikan().clearFromValue();
        panel.getTxtKyufuJissekiListNinteiYukoKikan().clearToValue();
        panel.getTxtKyufuJissekiListName().setValue(RString.EMPTY);
        panel.getTxtKyufuJissekiListSeibetsu().setValue(RString.EMPTY);
        panel.getTxtKyufuJissekiListSeinengappi().setValue(RString.EMPTY);
        panel.getDgKyufuJissekiMeisaiList().setDataSource(Collections.EMPTY_LIST);
        panel.getDgKyufuJissekiGokeiList().setDataSource(Collections.EMPTY_LIST);
        List<DataGridColumn> colMeisaiList = panel.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns();
        for (int i = 0; i < colMeisaiList.size(); i++) {
            colMeisaiList.get(i).setVisible(false);
        }
        List<DataGridColumn> colGokeiList = panel.getDgKyufuJissekiGokeiList().getGridSetting().getColumns();
        for (int i = 0; i < colGokeiList.size(); i++) {
            colGokeiList.get(i).setVisible(false);
        }
        response.data = panel;
        return response;
    }

    public ResponseData<KyufuJissekiListDiv> onClick_Meisai_btnYM(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {
        ResponseData<KyufuJissekiListDiv> response = new ResponseData<>();

        putViewState(panel2, panel.getDgKyufuJissekiMeisaiList().getClickedItem().getTxtServiceShurui());

        response.data = panel;
        return response;
    }

    public ResponseData<KyufuJissekiListDiv> onClick_Gokei_btnYM(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {
        ResponseData<KyufuJissekiListDiv> response = new ResponseData<>();

        putViewState(panel2, panel.getDgKyufuJissekiGokeiList().getClickedItem().getTxtServiceShurui());

        response.data = panel;
        return response;
    }

    private void putViewState(KyufuJissekiSearchDiv panel2, RString serviceShurui) {

        ServiceTeikyoYM start = new ServiceTeikyoYM(new FlexibleDate(panel2.getTxtKyufuJissekiSearchServiceTeikyoYM().getFromText()).getYearMonth());
        ServiceTeikyoYM end = new ServiceTeikyoYM(new FlexibleDate(panel2.getTxtKyufuJissekiSearchServiceTeikyoYM().getToText()).getYearMonth());
        Range<ServiceTeikyoYM> serviceTeikyoYMRange = new Range(start, end);
        KyufuJissekiServiceFinder finder = new KyufuJissekiServiceFinder();
        KaigoHihokenshaNo hihokenshaNo = new KaigoHihokenshaNo(panel2.getTxtKyufuJissekiSearchHihokenshaNo().getValue());
        KyufuJissekiServiceCollections collections = finder.get給付実績一覧(hihokenshaNo, serviceTeikyoYMRange);

        KyufuJissekiServiceCategory category = new KyufuJissekiServiceCategory();
        ServiceShuruiCode shuruiCode = category.getサービス種類コード(serviceShurui);
        KyufuJissekiKeyInfo keyInfo = collections.get給付実績月別集計(serviceTeikyoYMRange.getFrom()).getKeyInfo(shuruiCode);

        ViewStateHolder.put("被保番号", new RString(keyInfo.get被保番号().toString()));
        ViewStateHolder.put("サービス提供期間開始", new RString(keyInfo.getサービス提供期間().getFrom().value().toString()));
        ViewStateHolder.put("サービス提供期間終了", new RString(keyInfo.getサービス提供期間().getTo().value().toString()));
        ViewStateHolder.put("入力識別番号", new RString(keyInfo.get入力識別番号().getInputShikibetsuNoCode().value().toString()));
        ViewStateHolder.put("サービス種類", keyInfo.getサービス種類コード().value());
        ViewStateHolder.put("サービス提供年月", new RString(keyInfo.getサービス提供年月().value().toString()));
    }

    private void setHeaderData(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {

        ControlGenerator ymlData = new ControlGenerator(YamlLoader.DBC.loadAsList(new RString("dbc0010000/KyufuJissekiMeisaiList.yml")).get(0));
        panel.getTxtKyufuJissekiListHihokenshaNo().setValue(panel2.getTxtKyufuJissekiSearchHihokenshaNo().getValue());
        panel.getTxtKyufuJissekiListJuminShubetsu().setValue(ymlData.getAsRString("JuminShubetsu"));
        panel.getTxtKyufuJissekiListYokaigodo().setValue(ymlData.getAsRString("Yokaigodo"));
        panel.getTxtKyufuJissekiListNinteiYukoKikan().setFromValue(ymlData.getAsRDate("NinteiYukoKikanFrom"));
        panel.getTxtKyufuJissekiListNinteiYukoKikan().setToValue(ymlData.getAsRDate("NinteiYukoKikanTo"));
        panel.getTxtKyufuJissekiListName().setValue(ymlData.getAsRString("Name"));
        panel.getTxtKyufuJissekiListSeibetsu().setValue(ymlData.getAsRString("Seibetsu"));
        panel.getTxtKyufuJissekiListSeinengappi().setValue(ymlData.getAsRString("Seinengappi"));
    }

    private void setMeisaiData(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {

        Boolean blnChangeColorFlg1 = false;
        Boolean blnChangeColorFlg2 = false;

        ServiceTeikyoYM start = new ServiceTeikyoYM(new FlexibleDate(panel2.getTxtKyufuJissekiSearchServiceTeikyoYM().getFromText()).getYearMonth());
        ServiceTeikyoYM end = new ServiceTeikyoYM(new FlexibleDate(panel2.getTxtKyufuJissekiSearchServiceTeikyoYM().getToText()).getYearMonth());
        Range<ServiceTeikyoYM> serviceTeikyoYMRange = new Range(start, end);
        KyufuJissekiServiceFinder finder = new KyufuJissekiServiceFinder();
        KaigoHihokenshaNo hihokenshaNo = new KaigoHihokenshaNo(panel2.getTxtKyufuJissekiSearchHihokenshaNo().getValue());
        KyufuJissekiServiceCollections collections = finder.get給付実績一覧(hihokenshaNo, serviceTeikyoYMRange);

        //給付実績一覧明細データ取得、設定
        List<dgKyufuJissekiMeisaiList_Row> arrayMeisaidata = createRowKyufuJissekiMeisaiList(collections, serviceTeikyoYMRange);

        //バックカラーの設定
        RString serviceGroup1Value = RString.EMPTY;
        RString serviceGroup2Value = RString.EMPTY;
        DataGridCellBgColor group1Color = DataGridCellBgColor.bgColorBlue;
        DataGridCellBgColor group2Color = DataGridCellBgColor.bgColorLightBlue;

        for (int i = 0; i < arrayMeisaidata.size(); i++) {

            if (i == 0) {
                blnChangeColorFlg1 = Boolean.TRUE;
                blnChangeColorFlg2 = Boolean.TRUE;
            } else {
                if (!serviceGroup1Value.equals(arrayMeisaidata.get(i).getTxtServiceGroup1())) {
                    switch (group1Color) {
                        case bgColorBlue:
                            group1Color = DataGridCellBgColor.bgColorRed;
                            break;
                        case bgColorRed:
                            group1Color = DataGridCellBgColor.bgColorYellow;
                            break;
                        case bgColorYellow:
                            group1Color = DataGridCellBgColor.bgColorGreen;
                            break;
                        case bgColorGreen:
                            group1Color = DataGridCellBgColor.bgColorGray;
                            break;
                        case bgColorGray:
                            group1Color = DataGridCellBgColor.bgColorBlue;
                            break;
                    }
                    blnChangeColorFlg1 = Boolean.TRUE;
                }

                if (!serviceGroup1Value.equals(arrayMeisaidata.get(i).getTxtServiceGroup1())
                        || !serviceGroup2Value.equals(arrayMeisaidata.get(i).getTxtServiceGroup2())) {
                    switch (group2Color) {
                        case bgColorLightBlue:
                            group2Color = DataGridCellBgColor.bgColorLightRed;
                            break;
                        case bgColorLightRed:
                            group2Color = DataGridCellBgColor.bgColorLightYellow;
                            break;
                        case bgColorLightYellow:
                            group2Color = DataGridCellBgColor.bgColorLightGreen;
                            break;
                        case bgColorLightGreen:
                            group2Color = DataGridCellBgColor.bgColorLightGray;
                            break;
                        case bgColorLightGray:
                            group2Color = DataGridCellBgColor.bgColorLightBlue;
                            break;
                    }
                    blnChangeColorFlg2 = Boolean.TRUE;
                }
            }
            arrayMeisaidata.get(i).setCellBgColor("txtServiceGroup1", group1Color);
            arrayMeisaidata.get(i).setCellBgColor("txtServiceGroup2", group2Color);
            arrayMeisaidata.get(i).setCellBgColor("txtServiceShurui", group2Color);
            arrayMeisaidata.get(i).setCellBgColor("btnYM1", group2Color);
            arrayMeisaidata.get(i).setCellBgColor("txtYM1", group2Color);
            arrayMeisaidata.get(i).setCellBgColor("btnYM2", group2Color);
            arrayMeisaidata.get(i).setCellBgColor("txtYM2", group2Color);
            arrayMeisaidata.get(i).setCellBgColor("btnYM3", group2Color);
            arrayMeisaidata.get(i).setCellBgColor("txtYM3", group2Color);
            if (blnChangeColorFlg1.equals(Boolean.TRUE)) {
                serviceGroup1Value = arrayMeisaidata.get(i).getTxtServiceGroup1();
                blnChangeColorFlg1 = Boolean.FALSE;
            }
            if (blnChangeColorFlg2.equals(Boolean.TRUE)) {
                serviceGroup2Value = arrayMeisaidata.get(i).getTxtServiceGroup2();
                blnChangeColorFlg2 = Boolean.FALSE;
            }
        }

        List<DataGridColumn> colMeisaiList = panel.getDgKyufuJissekiMeisaiList().getGridSetting().getColumns();
        for (int i = 0; i < colMeisaiList.size(); i++) {
            colMeisaiList.get(i).setVisible(true);
            if (colMeisaiList.get(i).getDataName().toString().equals("txtYM3")) {
                break;
            }
        }

        panel.getDgKyufuJissekiMeisaiList().setDataSource(arrayMeisaidata);
    }

    private void setGokeiData(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {

//        //給付実績一覧合計データ取得、設定
//        List<HashMap> kyufuJissekiGokeiList = YamlLoader.DBC.loadAsList(new RString("dbc0010000/KyufuJissekiGokeiList.yml"));
//
//        List<dgKyufuJissekiGokeiList_Row> arrayGokeidata = createRowKyufuJissekiGokeiList(kyufuJissekiGokeiList);
//
//        List<DataGridColumn> colGokeiList = panel.getDgKyufuJissekiGokeiList().getGridSetting().getColumns();
//        for (int i = 0; i < colGokeiList.size(); i++) {
//            colGokeiList.get(i).setVisible(true);
//            if (colGokeiList.get(i).getDataName().toString().equals("txtYM3")) {
//                break;
//            }
//        }
//        panel.getDgKyufuJissekiGokeiList().setDataSource(arrayGokeidata);
        ServiceTeikyoYM start = new ServiceTeikyoYM(new FlexibleDate(panel2.getTxtKyufuJissekiSearchServiceTeikyoYM().getFromText()).getYearMonth());
        ServiceTeikyoYM end = new ServiceTeikyoYM(new FlexibleDate(panel2.getTxtKyufuJissekiSearchServiceTeikyoYM().getToText()).getYearMonth());
        Range<ServiceTeikyoYM> serviceTeikyoYMRange = new Range(start, end);
        KyufuJissekiServiceFinder finder = new KyufuJissekiServiceFinder();
        KaigoHihokenshaNo hihokenshaNo = new KaigoHihokenshaNo(panel2.getTxtKyufuJissekiSearchHihokenshaNo().getValue());
        KyufuJissekiServiceCollections collections = finder.get給付実績一覧(hihokenshaNo, serviceTeikyoYMRange);

        //給付実績一覧明細データ取得、設定
        List<dgKyufuJissekiGokeiList_Row> arrayGokeidata = createRowKyufuJissekiGokeiList(collections, serviceTeikyoYMRange);

        List<DataGridColumn> colGokeiList = panel.getDgKyufuJissekiGokeiList().getGridSetting().getColumns();
        for (int i = 0; i < colGokeiList.size(); i++) {
            colGokeiList.get(i).setVisible(true);
            if (colGokeiList.get(i).getDataName().toString().equals("txtYM3")) {
                break;
            }
        }

        panel.getDgKyufuJissekiGokeiList().setDataSource(arrayGokeidata);
    }

    private class rowData {

        RString txtServiceGroup1;
        RString txtServiceGroup2;
        RString txtServiceShurui;
        List<RString> txtYM = new ArrayList();
    }

    /*
     *給付実績一覧明細情報の初期値をセットします。
     */
    private List createRowKyufuJissekiMeisaiList(KyufuJissekiServiceCollections collections, Range<ServiceTeikyoYM> range) {

        List arrayDataList = new ArrayList();
        KyufuJissekiServiceCategory category = new KyufuJissekiServiceCategory();

        List<ServiceShuruiCode> dispList = category.get一覧表示サービス種類();
        List<rowData> allDataList = new ArrayList();

        for (ServiceShuruiCode code : dispList) {
            FlexibleYearMonth start = range.getFrom().value();
            rowData row = new rowData();
            row.txtServiceShurui = new RString(category.getサービス種類タイトル(code).toString());

            ServiceCategoryTitle title = category.get一覧タイトル(code);
            row.txtServiceGroup1 = RString.EMPTY;
            if (title != null) {
                row.txtServiceGroup1 = new RString(title.toString());
            }

            ServiceCategorySubTitle subTitle = category.get一覧サブタイトル(code);
            row.txtServiceGroup2 = RString.EMPTY;
            if (subTitle != null && !subTitle.equals(ServiceCategorySubTitle.サブタイトルなし)) {
                row.txtServiceGroup2 = new RString(subTitle.toString());
            }

            while (start.isBeforeOrEquals(range.getTo().value())) {
                KyufuJissekiServiceCollection col = collections.get給付実績月別集計(new ServiceTeikyoYM(start));
                if (col != null) {
                    Decimal data = col.get単位数合計Byサービス種類(code);
                    if (data.equals(Decimal.ZERO)) {
                        row.txtYM.add(RString.EMPTY);
                    } else {
                        row.txtYM.add(new RString(data.toString()));
                    }
                }
                start = start.plusMonth(1);
            }
            allDataList.add(row);
        }

        for (rowData row : allDataList) {
            List<RString> rsYM = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                if (i < row.txtYM.size()) {
                    rsYM.add(row.txtYM.get(i));
                } else {
                    rsYM.add(RString.EMPTY);
                }
            }

            arrayDataList.add(createRowKyufuJissekiMeisaiList(
                    row.txtServiceGroup1, row.txtServiceGroup2, row.txtServiceShurui,
                    rsYM.get(0), rsYM.get(1), rsYM.get(2), rsYM.get(3), rsYM.get(4), rsYM.get(5), rsYM.get(6),
                    rsYM.get(7), rsYM.get(8), rsYM.get(9), rsYM.get(10), rsYM.get(11)));
        }

        return arrayDataList;
    }

    /*
     *給付実績一覧合計情報の初期値をセットします。
     */
    private List createRowKyufuJissekiGokeiList(KyufuJissekiServiceCollections collections, Range<ServiceTeikyoYM> range) {

//        List arrayDataList = new ArrayList();
//
//        for (int i = 1; i < kyufuJissekiGokeiList.size(); i++) {
//            HashMap hashMap = kyufuJissekiGokeiList.get(i);
//            ControlGenerator ymlData = new ControlGenerator(hashMap);
//
//            RString rsServiceGroup1 = ymlData.getAsRString("txtServiceGroup1");
//            RString rsServiceGroup2 = ymlData.getAsRString("txtServiceGroup2");
//            RString rsServiceShurui = ymlData.getAsRString("txtServiceShurui");
//            RString rsYM1 = ymlData.getAsRString("txtYM1");
//            RString rsYM2 = ymlData.getAsRString("txtYM2");
//            RString rsYM3 = ymlData.getAsRString("txtYM3");
//            RString rsYM4 = ymlData.getAsRString("txtYM4");
//            RString rsYM5 = ymlData.getAsRString("txtYM5");
//            RString rsYM6 = ymlData.getAsRString("txtYM6");
//            RString rsYM7 = ymlData.getAsRString("txtYM7");
//            RString rsYM8 = ymlData.getAsRString("txtYM8");
//            RString rsYM9 = ymlData.getAsRString("txtYM9");
//            RString rsYM10 = ymlData.getAsRString("txtYM10");
//            RString rsYM11 = ymlData.getAsRString("txtYM11");
//            RString rsYM12 = ymlData.getAsRString("txtYM12");
//
//            arrayDataList.add(createRowKyufuJissekiGokeiList(
//                    rsServiceGroup1, rsServiceGroup2, rsServiceShurui,
//                    rsYM1, rsYM2, rsYM3, rsYM4, rsYM5, rsYM6,
//                    rsYM7, rsYM8, rsYM9, rsYM10, rsYM11, rsYM12));
//        }
//
//        return arrayDataList;
        List arrayDataList = new ArrayList();
        KyufuJissekiServiceCategory category = new KyufuJissekiServiceCategory();

        List<ServiceShuruiCode> dispList = category.get合計表示サービス種類();
        List<rowData> allDataList = new ArrayList();

        for (ServiceShuruiCode code : dispList) {
            FlexibleYearMonth start = range.getFrom().value();
            rowData row = new rowData();
            row.txtServiceShurui = new RString(category.getサービス種類タイトル(code).toString());

            ServiceCategoryTitle title = category.get一覧タイトル(code);
            row.txtServiceGroup1 = RString.EMPTY;
            if (title != null) {
                row.txtServiceGroup1 = new RString(title.toString());
            }

            ServiceCategorySubTitle subTitle = category.get一覧サブタイトル(code);
            row.txtServiceGroup2 = RString.EMPTY;
            if (subTitle != null && !subTitle.equals(ServiceCategorySubTitle.サブタイトルなし)) {
                row.txtServiceGroup2 = new RString(subTitle.toString());
            }

            while (start.isBeforeOrEquals(range.getTo().value())) {
                KyufuJissekiServiceCollection col = collections.get給付実績月別集計(new ServiceTeikyoYM(start));
                if (col != null) {
                    Decimal data = col.get保険請求分請求額合計Byサービス種類(code);
                    if (data.equals(Decimal.ZERO)) {
                        row.txtYM.add(RString.EMPTY);
                    } else {
                        row.txtYM.add(new RString(data.toString()));
                    }
                }
                start = start.plusMonth(1);
            }
            allDataList.add(row);
        }

        for (rowData row : allDataList) {
            List<RString> rsYM = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                if (i < row.txtYM.size()) {
                    rsYM.add(row.txtYM.get(i));
                } else {
                    rsYM.add(RString.EMPTY);
                }
            }

            arrayDataList.add(createRowKyufuJissekiGokeiList(
                    row.txtServiceGroup1, row.txtServiceGroup2, row.txtServiceShurui,
                    rsYM.get(0), rsYM.get(1), rsYM.get(2), rsYM.get(3), rsYM.get(4), rsYM.get(5), rsYM.get(6),
                    rsYM.get(7), rsYM.get(8), rsYM.get(9), rsYM.get(10), rsYM.get(11)));
        }

        return arrayDataList;
    }

    /*
     *引数を元にデータグリッド内に挿入する給付実績一覧明細データを作成します。
     */
    private dgKyufuJissekiMeisaiList_Row createRowKyufuJissekiMeisaiList(
            RString rsServiceGroup1, RString rsServiceGroup2, RString rsServiceShurui,
            RString rsYM1, RString rsYM2, RString rsYM3, RString rsYM4, RString rsYM5, RString rsYM6,
            RString rsYM7, RString rsYM8, RString rsYM9, RString rsYM10, RString rsYM11, RString rsYM12) {
        return new dgKyufuJissekiMeisaiList_Row(
                rsServiceGroup1, rsServiceGroup2, rsServiceShurui,
                new Button(), rsYM1, new Button(), rsYM2, new Button(), rsYM3, new Button(), rsYM4, new Button(), rsYM5, new Button(), rsYM6,
                new Button(), rsYM7, new Button(), rsYM8, new Button(), rsYM9, new Button(), rsYM10, new Button(), rsYM11, new Button(), rsYM12);
    }

    /*
     *引数を元にデータグリッド内に挿入する給付実績一覧合計データを作成します。
     */
    private dgKyufuJissekiGokeiList_Row createRowKyufuJissekiGokeiList(
            RString rsServiceGroup1, RString rsServiceGroup2, RString rsServiceShurui,
            RString rsYM1, RString rsYM2, RString rsYM3, RString rsYM4, RString rsYM5, RString rsYM6,
            RString rsYM7, RString rsYM8, RString rsYM9, RString rsYM10, RString rsYM11, RString rsYM12) {
        return new dgKyufuJissekiGokeiList_Row(
                rsServiceGroup1, rsServiceGroup2, rsServiceShurui,
                new Button(), rsYM1, new Button(), rsYM2, new Button(), rsYM3, new Button(), rsYM4, new Button(), rsYM5, new Button(), rsYM6,
                new Button(), rsYM7, new Button(), rsYM8, new Button(), rsYM9, new Button(), rsYM10, new Button(), rsYM11, new Button(), rsYM12);
    }
}
