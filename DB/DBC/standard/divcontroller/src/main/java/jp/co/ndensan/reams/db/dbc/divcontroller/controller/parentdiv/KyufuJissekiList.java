/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.parentdiv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiKeyInfo;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiServiceCategory;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiServiceCollection;
import jp.co.ndensan.reams.db.dbc.business.core.KyufuJissekiServiceCollections;
import jp.co.ndensan.reams.db.dbc.definition.core.servicetitle.ServiceCategorySubTitle;
import jp.co.ndensan.reams.db.dbc.definition.core.servicetitle.ServiceCategoryTitle;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.KyufuJissekiSearchDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiGokeiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000.dgKyufuJissekiMeisaiList_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumn;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 給付実績照会一覧のコントローラークラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuJissekiList {

    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;

    /**
     * onClick_btnKyufuJissekiSearchメソッドです。
     *
     * @param panel KyufuJissekiListDiv
     * @param panel2 KyufuJissekiSearchDiv
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiListDiv> onClick_btnKyufuJissekiSearch(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {
        ResponseData<KyufuJissekiListDiv> response = new ResponseData<>();

        setData(panel, panel2);

        response.data = panel;
        return response;
    }

    /**
     * onClick_btnKyufuJissekiResearchメソッドです。
     *
     * @param panel KyufuJissekiListDiv
     * @param panel2 KyufuJissekiSearchDiv
     * @return ResponseData
     */
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

    /**
     * onClick_Meisai_btnYMメソッドです。
     *
     * @param panel KyufuJissekiListDiv
     * @param panel2 KyufuJissekiSearchDiv
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiListDiv> onClick_Meisai_btnYM(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {
        ResponseData<KyufuJissekiListDiv> response = new ResponseData<>();

        putViewState(panel2, panel.getDgKyufuJissekiMeisaiList().getClickedItem().getTxtServiceShurui());

        // TODO ViewState設定後に状態遷移させる為のダミーイベント（要見直）
        panel.getDgKyufuJissekiMeisaiList().setIsTriggerEventOnMultiRow(true);

        response.data = panel;
        return response;
    }

    /**
     * onClick_Gokei_btnYMメソッドです。
     *
     * @param panel KyufuJissekiListDiv
     * @param panel2 KyufuJissekiSearchDiv
     * @return ResponseData
     */
    public ResponseData<KyufuJissekiListDiv> onClick_Gokei_btnYM(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {
        ResponseData<KyufuJissekiListDiv> response = new ResponseData<>();

        putViewState(panel2, panel.getDgKyufuJissekiGokeiList().getClickedItem().getTxtServiceShurui());

        // TODO ViewState設定後に状態遷移させる為のダミーイベント（要見直）
        panel.getDgKyufuJissekiGokeiList().setIsTriggerEventOnMultiRow(true);

        response.data = panel;
        return response;
    }

    private void putViewState(KyufuJissekiSearchDiv panel2, RString serviceShurui) {

        KyufuJissekiKeyInfo keyInfo = getKyufuJissekiKeyInfo(panel2, serviceShurui);

        ViewStateHolder.put("被保番号", new RString(keyInfo.get被保番号().toString()));
        ViewStateHolder.put("サービス提供期間開始", new RString(keyInfo.getサービス提供期間().getFrom().value().toString()));
        ViewStateHolder.put("サービス提供期間終了", new RString(keyInfo.getサービス提供期間().getTo().value().toString()));
        ViewStateHolder.put("入力識別番号", new RString(keyInfo.get入力識別番号().getInputShikibetsuNoCode().value().toString()));
        ViewStateHolder.put("サービス種類", keyInfo.getサービス種類コード().value());
        ViewStateHolder.put("サービス提供年月", new RString(keyInfo.getサービス提供年月().value().toString()));
    }

    private Range<ServiceTeikyoYM> getServiceTeikyoKikan(KyufuJissekiSearchDiv panel2) {
        TextBoxDateRange kikan = panel2.getTxtKyufuJissekiSearchServiceTeikyoYM();
        ServiceTeikyoYM start = new ServiceTeikyoYM(new FlexibleDate(kikan.getFromText()).getYearMonth());
        ServiceTeikyoYM end = new ServiceTeikyoYM(new FlexibleDate(kikan.getToText()).getYearMonth());
        return new Range(start, end);
    }

    private KyufuJissekiServiceCollections getKyufuJissekiServiceCollections(KyufuJissekiSearchDiv panel2) {
        // TODO 未使用のメソッド引数があります。 Checkstyle 対応。
        panel2.getBtnKyufuJissekiSearch();
        return null;
        // TODO n8300姜　ビルドエラー回避のために暫定対応
//        KyufuJissekiServiceFinder finder = new KyufuJissekiServiceFinder();
//        HihokenshaNo hihoNo = new HihokenshaNo(panel2.getTxtKyufuJissekiSearchHihokenshaNo().getValue());
//        return finder.get給付実績一覧(hihoNo, getServiceTeikyoKikan(panel2));
    }

    private KyufuJissekiKeyInfo getKyufuJissekiKeyInfo(KyufuJissekiSearchDiv panel2, RString serviceShurui) {
        KyufuJissekiServiceCollections collections = getKyufuJissekiServiceCollections(panel2);
        KyufuJissekiServiceCategory category = new KyufuJissekiServiceCategory();
        ServiceTeikyoYM serviceTeikyoYM = getServiceTeikyoKikan(panel2).getFrom();
        ServiceShuruiCode serviceShuruiCode = category.getサービス種類コード(serviceShurui);
        return collections.get給付実績月別集計(serviceTeikyoYM).getKeyInfo(serviceShuruiCode);
    }

    private void setData(KyufuJissekiListDiv panel, KyufuJissekiSearchDiv panel2) {

        KyufuJissekiServiceCollections collections = getKyufuJissekiServiceCollections(panel2);

        setHeaderData(panel, panel2);
        setMeisaiData(panel, collections, getServiceTeikyoKikan(panel2));
        setGokeiData(panel, collections, getServiceTeikyoKikan(panel2));
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

    private void setMeisaiData(KyufuJissekiListDiv panel, KyufuJissekiServiceCollections collections, Range<ServiceTeikyoYM> serviceTeikyoYMRange) {

        List<dgKyufuJissekiMeisaiList_Row> arrayMeisaidata = createRowKyufuJissekiMeisaiList(collections, serviceTeikyoYMRange);

        Boolean blnChangeColorFlg1 = false;
        Boolean blnChangeColorFlg2 = false;

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
                        default:
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
                        default:
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
        setcolMeisaiList(colMeisaiList);
        panel.getDgKyufuJissekiMeisaiList().setDataSource(arrayMeisaidata);
    }

    private void setcolMeisaiList(List<DataGridColumn> colMeisaiList) {
        for (int i = 0; i < colMeisaiList.size(); i++) {
            colMeisaiList.get(i).setVisible(true);
            if (colMeisaiList.get(i).getDataName().toString().equals("txtYM3")) {
                break;
            }
        }
    }

    private void setGokeiData(KyufuJissekiListDiv panel, KyufuJissekiServiceCollections collections, Range<ServiceTeikyoYM> serviceTeikyoYMRange) {

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

    private static class RowData {

        private RString txtServiceGroup1;
        private RString txtServiceGroup2;
        private RString txtServiceShurui;
//        private List<RString> txtYM = new ArrayList();
    }

    private List createRowKyufuJissekiMeisaiList(KyufuJissekiServiceCollections collections, Range<ServiceTeikyoYM> range) {

        KyufuJissekiServiceCategory category = new KyufuJissekiServiceCategory();
        List<RowData> allDataList = createListDate(collections, range, category.get一覧表示サービス種類(), true);

        List arrayDataList = new ArrayList();
        for (RowData row : allDataList) {
            List<RString> rsYM = createYMList(row);
            arrayDataList.add(createRowKyufuJissekiMeisaiList(
                    row.txtServiceGroup1, row.txtServiceGroup2, row.txtServiceShurui,
                    rsYM.get(0), rsYM.get(1), rsYM.get(2), rsYM.get(INDEX_3), rsYM.get(INDEX_4), rsYM.get(INDEX_5), rsYM.get(INDEX_6),
                    rsYM.get(INDEX_7), rsYM.get(INDEX_8), rsYM.get(INDEX_9), rsYM.get(INDEX_10), rsYM.get(INDEX_11)));
        }

        return arrayDataList;
    }

    private List createRowKyufuJissekiGokeiList(KyufuJissekiServiceCollections collections, Range<ServiceTeikyoYM> range) {

        KyufuJissekiServiceCategory category = new KyufuJissekiServiceCategory();
        List<RowData> allDataList = createListDate(collections, range, category.get合計表示サービス種類(), false);

        List arrayDataList = new ArrayList();
        for (RowData row : allDataList) {
            List<RString> rsYM = createYMList(row);
            arrayDataList.add(createRowKyufuJissekiGokeiList(
                    row.txtServiceGroup1, row.txtServiceGroup2, row.txtServiceShurui,
                    rsYM.get(0), rsYM.get(1), rsYM.get(2), rsYM.get(INDEX_3), rsYM.get(INDEX_4), rsYM.get(INDEX_5), rsYM.get(INDEX_6),
                    rsYM.get(INDEX_7), rsYM.get(INDEX_8), rsYM.get(INDEX_9), rsYM.get(INDEX_10), rsYM.get(INDEX_11)));
        }

        return arrayDataList;
    }

    private List<RowData> createListDate(
            KyufuJissekiServiceCollections collections,
            Range<ServiceTeikyoYM> range,
            List<ServiceShuruiCode> dispList,
            boolean isMeisai) {

        List<RowData> allDataList = new ArrayList();
        KyufuJissekiServiceCategory category = new KyufuJissekiServiceCategory();

        for (ServiceShuruiCode code : dispList) {
            FlexibleYearMonth start = range.getFrom().value();
            RowData row = new RowData();
            row.txtServiceShurui = new RString(category.getサービス種類タイトル(code).toString());

            ServiceCategoryTitle title = category.get一覧タイトル(code);
            row.txtServiceGroup1 = (title != null) ? new RString(title.toString()) : RString.EMPTY;

            ServiceCategorySubTitle subTitle = category.get一覧サブタイトル(code);
            row.txtServiceGroup2 = RString.EMPTY;
            row.txtServiceGroup2 = (subTitle != null && !subTitle.equals(ServiceCategorySubTitle.サブタイトルなし)) ? new RString(subTitle.toString()) : RString.EMPTY;

            while (start.isBeforeOrEquals(range.getTo().value())) {
                KyufuJissekiServiceCollection col = collections.get給付実績月別集計(new ServiceTeikyoYM(start));
                if (col != null) {
                    Decimal data = isMeisai ? col.get単位数合計Byサービス種類(code) : col.get保険請求分請求額合計Byサービス種類(code);
                    // TODO 未使用のローカル変数です。 Checkstyle 対応。
                    data.hashCode();
//                    row.txtYM.add(setCommFormat(data));
                }
                start = start.plusMonth(1);
            }
            allDataList.add(row);
        }

        return allDataList;
    }

    private List<RString> createYMList(RowData row) {
        List<RString> list = new ArrayList<>();
        for (int i = 0; i < INDEX_12; i++) {
            // TODO 少なくとも1文はあるはずです。Checkstyle対応。
            row.hashCode();
//            list.add(i < row.txtYM.size() ? row.txtYM.get(i) : RString.EMPTY);
        }
        return list;
    }

//    private RString setCommFormat(Decimal data) {
//        if (data == null) {
//            return RString.EMPTY;
//        }
//        return new RString(data.toString("##,###,###"));
//    }
    private dgKyufuJissekiMeisaiList_Row createRowKyufuJissekiMeisaiList(
            RString rsServiceGroup1, RString rsServiceGroup2, RString rsServiceShurui,
            RString rsYM1, RString rsYM2, RString rsYM3, RString rsYM4, RString rsYM5, RString rsYM6,
            RString rsYM7, RString rsYM8, RString rsYM9, RString rsYM10, RString rsYM11, RString rsYM12) {
        return new dgKyufuJissekiMeisaiList_Row(
                rsServiceGroup1, rsServiceGroup2, rsServiceShurui,
                new Button(), rsYM1, new Button(), rsYM2, new Button(), rsYM3, new Button(), rsYM4, new Button(), rsYM5, new Button(), rsYM6,
                new Button(), rsYM7, new Button(), rsYM8, new Button(), rsYM9, new Button(), rsYM10, new Button(), rsYM11, new Button(), rsYM12);
    }

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
