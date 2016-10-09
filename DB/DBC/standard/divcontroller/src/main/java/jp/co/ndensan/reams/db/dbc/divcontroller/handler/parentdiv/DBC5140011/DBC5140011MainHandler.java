/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC5140011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.dbc5140011main.DBC5140011MainResult;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150050.DBC150050_ServicecodeTaniMeisaiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011.DBC5140011MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5140011.dgServiceShuruiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.dbc5140011main.DBC5140011MainFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * サービスコード単位明細リストのHandlerです。
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public class DBC5140011MainHandler {

    private DBC5140011MainDiv div;
    private static final RString アンだライン = new RString("_");
    private static final RString 全て = new RString("全て");
    private static final RString 町域 = new RString("町域");
    private static final RString 行政区 = new RString("行政区");
    private static final RString 地区1 = new RString("地区1");
    private static final RString 地区2 = new RString("地区2");
    private static final RString 地区3 = new RString("地区3");
    private static final RString ゼロ1 = new RString("0");
    private static final RString 一1 = new RString("1");
    private static final RString 二1 = new RString("2");
    private static final RString 三1 = new RString("3");
    private static final RString 四1 = new RString("4");
    private static final RString 五1 = new RString("5");
    private static final int 一 = 1;
    private static final int 二 = 2;
    private static final int 三 = 3;
    private static final int ゼロ = 0;

    /**
     * コンストラクタです。
     *
     * @param div DBC5140011MainDiv
     */
    public DBC5140011MainHandler(DBC5140011MainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     */
    public void initialize() {

        ViewStateHolder.put(ViewStateKeys.台帳種別表示, new RString("台帳種別表示有り"));
        div.getChushutsuJoken1().getCcdJigyoshaNo().initialize();
        div.getChikuShitei().getCcdChikuShichosonSelect().initialize();
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200005.getReportId());
        div.getCcdChohyoShutsuryokuKomoku().load(ReportIdDBC.DBC200005.getReportId().getColumnValue(), SubGyomuCode.DBC介護給付);

        List<DBC5140011MainResult> resultList = DBC5140011MainFinder.createInstance().get介護サービス種類データ();
        if (resultList.isEmpty()) {
            div.getDgServiceShuruiList().getGridSetting().setLimitRowCount(0);
        } else {
            List<dgServiceShuruiList_Row> rowList = new ArrayList<>();
            for (DBC5140011MainResult result : resultList) {
                dgServiceShuruiList_Row row = new dgServiceShuruiList_Row();
                row.setHdnServiceBunruiCode(result.getEntity().getServiceBunrruicode().getColumnValue());
                row.setServiceShuruiCode(result.getEntity().getServiceShuruiCd().getColumnValue());
                row.setServiceShuruiName(result.getEntity().getServiceShuruiMeisho());
                rowList.add(row);
            }
            div.getDgServiceShuruiList().setDataSource(rowList);
        }

    }

    /**
     * 条件を保存するボタンのメソッドです。
     *
     * @return DBC150050_ServicecodeTaniMeisaiIchiranParameter
     */
    public DBC150050_ServicecodeTaniMeisaiIchiranParameter pamaHozon() {

        DBC150050_ServicecodeTaniMeisaiIchiranParameter parameter = new DBC150050_ServicecodeTaniMeisaiIchiranParameter();
        if (div.getCcdChohyoShutsuryokujun().getSelected出力順() != null) {
            parameter.set出力順ID(div.getCcdChohyoShutsuryokujun().getSelected出力順().get出力順ID());
        }
        if (div.getRadTaishoYM().getSelectedValue() != null && !div.getRadTaishoYM().getSelectedValue().isEmpty()) {
            parameter.set対象年月(div.getRadTaishoYM().getSelectedKey());
        }
        parameter.set開始年月(new FlexibleYearMonth(div.getTxtTaishoYmRange().getFromValue().getYearMonth().toDateString()));
        parameter.set終了年月(new FlexibleYearMonth(div.getTxtTaishoYmRange().getToValue().getYearMonth().toDateString()));
        if (div.getTxtHihokenshaNo().getValue() != null && !div.getTxtHihokenshaNo().getValue().isEmpty()) {
            parameter.set被保険者番号(div.getTxtHihokenshaNo().getValue());
        }
        if (div.getCcdJigyoshaNo().getNyuryokuShisetsuKodo() != null && !div.getCcdJigyoshaNo().getNyuryokuShisetsuKodo().isEmpty()) {
            parameter.set事業者番号(div.getCcdJigyoshaNo().getNyuryokuShisetsuKodo());
        }
        if (div.getChkNinteiKekka().getSelectedValues() != null && !div.getChkNinteiKekka().getSelectedValues().isEmpty()) {
            parameter.set認定結果リスト(div.getChkNinteiKekka().getSelectedKeys());
        }
        List<RString> list = new ArrayList();
        for (dgServiceShuruiList_Row row : div.getDgServiceShuruiList().getSelectedItems()) {
            list.add(row.getServiceShuruiCode());
        }
        parameter.setサービス種類コードリスト(list);
        RString serviceKomokuCode = new RString("");
        RString serviceShuruiCode1 = div.getChushutsuJoken2().getTxtServiceKomokuCode1().getValue();
        RString serviceShuruiCode2 = div.getChushutsuJoken2().getTxtServiceKomokuCode2().getValue();
        RString serviceShuruiCode3 = div.getChushutsuJoken2().getTxtServiceKomokuCode3().getValue();
        RString serviceShuruiCode4 = div.getChushutsuJoken2().getTxtServiceKomokuCode4().getValue();
        List<RString> listStr = new ArrayList();
        listStr.add(serviceShuruiCode1);
        listStr.add(serviceShuruiCode2);
        listStr.add(serviceShuruiCode3);
        listStr.add(serviceShuruiCode4);
        for (RString serviceShuruiCode : listStr) {
            if (!serviceShuruiCode.isNullOrEmpty()) {
                serviceKomokuCode = serviceKomokuCode.concat(serviceShuruiCode);
            } else {
                serviceKomokuCode = serviceKomokuCode.concat(アンだライン);
            }
        }
        parameter.setサービス項目コード(serviceKomokuCode);
        saveParamater(parameter);
        return parameter;
    }

    private void saveParamater(DBC150050_ServicecodeTaniMeisaiIchiranParameter parameter) {
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get選択対象() != null
                && !div.getChikuShitei().getCcdChikuShichosonSelect().get選択対象().isEmpty()) {
            set地区(parameter);
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get選択結果() != null
                && !div.getChikuShitei().getCcdChikuShichosonSelect().get選択結果().isEmpty()) {
            Map<RString, RString> map = div.getChikuShitei().getCcdChikuShichosonSelect().get選択結果();
            List<RString> list = new ArrayList<>();
            if (null != map && !map.isEmpty()) {
                for (RString key : map.keySet()) {
                    list.add(key);
                }
            }
            parameter.set選択地区リスト(sort昇順ByKey(list));
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get市町村コード() != null
                && !div.getChikuShitei().getCcdChikuShichosonSelect().get市町村コード().isEmpty()) {
            parameter.set市町村コード(div.getChikuShitei().getCcdChikuShichosonSelect().get市町村コード());
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get市町村名称() != null
                && !div.getChikuShitei().getCcdChikuShichosonSelect().get市町村名称().isEmpty()) {
            parameter.set市町村名称(div.getChikuShitei().getCcdChikuShichosonSelect().get市町村名称());
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get旧市町村コード() != null
                && !div.getChikuShitei().getCcdChikuShichosonSelect().get旧市町村コード().isEmpty()) {
            parameter.set旧市町村コード(div.getChikuShitei().getCcdChikuShichosonSelect().get旧市町村コード());
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get旧市町村名称() != null
                && !div.getChikuShitei().getCcdChikuShichosonSelect().get旧市町村名称().isEmpty()) {
            parameter.set旧市町村名称(div.getChikuShitei().getCcdChikuShichosonSelect().get旧市町村名称());
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get導入形態コード() != null
                && !div.getChikuShitei().getCcdChikuShichosonSelect().get導入形態コード().isEmpty()) {
            parameter.set導入形態コード(div.getChikuShitei().getCcdChikuShichosonSelect().get導入形態コード());
        }
    }

    private void set地区(DBC150050_ServicecodeTaniMeisaiIchiranParameter parameter) {
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get選択対象().equals(全て)) {
            parameter.set地区指定(ゼロ1);
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get選択対象().equals(町域)) {
            parameter.set地区指定(一1);
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get選択対象().equals(行政区)) {
            parameter.set地区指定(二1);
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get選択対象().equals(地区1)) {
            parameter.set地区指定(三1);
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get選択対象().equals(地区2)) {
            parameter.set地区指定(四1);
        }
        if (div.getChikuShitei().getCcdChikuShichosonSelect().get選択対象().equals(地区3)) {
            parameter.set地区指定(五1);
        }
    }

    private List<RString> sort昇順ByKey(List<RString> list) {
        if (list.isEmpty()) {
            return list;
        }
        Collections.sort(list,
                new Comparator<RString>() {
                    @Override
                    public int compare(RString arg0, RString arg1) {
                        return arg0.compareTo(arg1);
                    }
                }
        );
        return list;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     */
    public void pamaRestore() {

        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        pamaRestore1(restoreBatchParameterMap);
        List<RString> 認定結果リスト = new ArrayList();
        if (restoreBatchParameterMap.getParameterListValue(RString.class, new RString("認定結果リスト")) != null) {

            認定結果リスト = restoreBatchParameterMap.getParameterListValue(RString.class, new RString("認定結果リスト"));
        }
        if (認定結果リスト != null && !認定結果リスト.isEmpty()) {
            div.getChkNinteiKekka().setSelectedItemsByKey(認定結果リスト);
        }
        List<RString> サービス種類コードリスト
                = restoreBatchParameterMap.getParameterListValue(RString.class, new RString("サービス種類コードリスト"));
        List<dgServiceShuruiList_Row> rowListMoto = div.getChushutsuJoken2().getDgServiceShuruiList().getDataSource();
        List<dgServiceShuruiList_Row> rowList = new ArrayList();
        if (サービス種類コードリスト != null && !サービス種類コードリスト.isEmpty()) {
            for (RString serviceShuruiCode : サービス種類コードリスト) {
                for (dgServiceShuruiList_Row row : rowListMoto) {
                    if (row.getServiceShuruiCode().equals(serviceShuruiCode)) {
                        rowList.add(row);
                    }
                }
            }
        }
        div.getChushutsuJoken2().getDgServiceShuruiList().setSelectedItems(rowList);
        RString サービス項目コード = restoreBatchParameterMap.getParameterValue(RString.class, new RString("サービス項目コード"));
        if (サービス項目コード != null && !サービス項目コード.isEmpty()) {
            List<RString> rstringList = サービス項目コード.toRStringList();
            div.getChushutsuJoken2().getTxtServiceKomokuCode1().setValue(rstringList.get(ゼロ));
            div.getChushutsuJoken2().getTxtServiceKomokuCode2().setValue(rstringList.get(一));
            div.getChushutsuJoken2().getTxtServiceKomokuCode3().setValue(rstringList.get(二));
            div.getChushutsuJoken2().getTxtServiceKomokuCode4().setValue(rstringList.get(三));
        }
        RString 地区指定 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("地区指定"));
        if (地区指定 != null && !地区指定.isEmpty()) {
            div.getChikuShitei().getCcdChikuShichosonSelect().set選択対象(地区指定);
        }
        Map<RString, RString> 選択地区リスト = restoreBatchParameterMap.getParameterValue(Map.class, new RString("選択地区リスト"));
        if (選択地区リスト != null && !選択地区リスト.isEmpty()) {
            div.getChikuShitei().getCcdChikuShichosonSelect().set選択結果(選択地区リスト);
        }
        RString 市町村コード = restoreBatchParameterMap.getParameterValue(RString.class, new RString("市町村コード"));
        if (市町村コード != null && !市町村コード.isEmpty()) {
            div.getChikuShitei().getCcdChikuShichosonSelect().set市町村コード(市町村コード);
        }
        RString 旧市町村コード = restoreBatchParameterMap.getParameterValue(RString.class, new RString("旧市町村コード"));
        if (旧市町村コード != null && !旧市町村コード.isEmpty()) {
            div.getChikuShitei().getCcdChikuShichosonSelect().set旧市町村コード(旧市町村コード);
        }
    }

    private void pamaRestore1(BatchParameterMap restoreBatchParameterMap) throws IllegalArgumentException {
        RString 対象年月 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("対象年月"));
        if (対象年月 != null && !対象年月.isEmpty()) {
            div.getRadTaishoYM().setSelectedKey(対象年月);
        }
        FlexibleYearMonth 開始年月 = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, new RString("開始年月"));
        if (開始年月 != null && !開始年月.isEmpty()) {
            div.getTxtTaishoYmRange().setFromValue(new RDate(開始年月.toString()));
        }
        FlexibleYearMonth 終了年月 = restoreBatchParameterMap.getParameterValue(FlexibleYearMonth.class, new RString("終了年月"));
        if (終了年月 != null && !終了年月.isEmpty()) {
            div.getTxtTaishoYmRange().setToValue(new RDate(終了年月.toString()));
        }
        RString 被保険者番号 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("被保険者番号"));
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.getTxtHihokenshaNo().setValue(被保険者番号);
        }
        RString 事業者番号 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("事業者番号"));
        if (事業者番号 != null && !事業者番号.isEmpty()) {

            div.getCcdJigyoshaNo().setNyuryokuShisetsuKodo(事業者番号);
        }
    }
}
