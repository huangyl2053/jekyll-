/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220002;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB022002.DBB022002_ShotokuJohoHanyoListSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220002.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBBGM22002_汎用リスト 所得情報のHandlerクラス
 *
 * @reamsid_L DBB-1901-010 surun
 */
public class HanyoListParamHandler {

    private final HanyoListParamDiv div;
    private final RString 表示しない = new RString("0");
    private final RString 表示する = new RString("1");
    private final RString 定数 = new RString("2000");
    private final RString 定数課税区分 = new RString("課税区分");
    private final RString 定数課税区分減免前 = new RString("課税区分（減免前）");
    private final RString 定数課税区分減免後 = new RString("課税区分（減免後）");
    private final ReportId 出力順帳票ID = new ReportId("DBB200034_HanyoListShotokuJoho");
    private final RString 出力項目帳票ID = new RString("DBB200034_HanyoListShotokuJoho");
    private final RString 課税 = new RString("課税");
    private final RString 非課税 = new RString("非課税");
    private final RString 未申告 = new RString("未申告");
    private final RString 所得調査中 = new RString("所得調査中");
    private final RString 課税取消 = new RString("課税取消");
    private final RString 定数1 = new RString("1");
    private final RString 定数2 = new RString("2");
    private final RString 定数3 = new RString("3");
    private final RString 定数4 = new RString("4");
    private final RString 定数5 = new RString("5");
    private final RString 時間_START = new RString("00:00:00");
    private final RString 時間_END = new RString("23:59:59");
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_FOUR = 4;
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");
    private static final RString KEY3 = new RString("3");

    /**
     * コンストラクタです。
     *
     * @param div HanyoListParamDiv
     */
    public HanyoListParamHandler(HanyoListParamDiv div) {
        this.div = div;
    }

    /**
     * 初期化イベント。
     */
    public void onLoad() {
        set初期項目状態();
        set初期項目内容();
    }

    /**
     * 実行ボタンイベント。
     *
     * @return DBB022002_ShotokuJohoHanyoListSakuseiParameter
     */
    public DBB022002_ShotokuJohoHanyoListSakuseiParameter onClick_btnExecute() {
        DBB022002_ShotokuJohoHanyoListSakuseiParameter parameter = new DBB022002_ShotokuJohoHanyoListSakuseiParameter();
        if (div.getCcdShutsuryokujun() != null) {
            ReportId 帳票ID = div.getCcdShutsuryokujun().get帳票ID();
            parameter.set帳票ID(帳票ID);
        }
        boolean 項目名付加 = false;
        boolean 連番付加 = false;
        boolean 日付編集 = false;
        List<RString> 編集方法List = div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys();
        for (RString 編集方法 : 編集方法List) {
            if (CSVSettings.項目名付加.getコード().equals(編集方法)) {
                項目名付加 = true;
                continue;
            }
            if (CSVSettings.連番付加.getコード().equals(編集方法)) {
                連番付加 = true;
                continue;
            }
            if (CSVSettings.日付スラッシュ編集.getコード().equals(編集方法)) {
                日付編集 = true;
            }
        }
        parameter.set項目名付加(項目名付加);
        parameter.set連番付加(連番付加);
        parameter.set日付編集(日付編集);
        if (div.getFukaNendo() != null && div.getFukaNendo().getDdlFukaNendo() != null
                && div.getFukaNendo().getDdlFukaNendo().getSelectedValue().toString() != null) {
            FlexibleYear 賦課年度 = new FlexibleYear(new RDate(div.getFukaNendo().getDdlFukaNendo().getSelectedValue().
                    toString()).toDateString().substring(INDEX_ZERO, INDEX_FOUR));
            parameter.set賦課年度(賦課年度);
        }
        if (div.getChushutsuJokenPanel() != null && div.getChushutsuJokenPanel().getTxtChushutsuKikan() != null
                && div.getChushutsuJokenPanel().getTxtChushutsuKikan().getFromValue() != null) {
            parameter.set抽出期間From(new YMDHMS(div.getChushutsuJokenPanel().getTxtChushutsuKikan().getFromValue(),
                    new RTime(時間_START)));
        }
        if (div.getChushutsuJokenPanel() != null && div.getChushutsuJokenPanel().getTxtChushutsuKikan() != null
                && div.getChushutsuJokenPanel().getTxtChushutsuKikan().getToValue() != null) {
            parameter.set抽出期間To(new YMDHMS(div.getChushutsuJokenPanel().getTxtChushutsuKikan().getToValue(),
                    new RTime(時間_END)));
        }
        課税区分減免前後(parameter);
        宛名抽出条件と出力順と出力項目(parameter);
        return parameter;
    }

    /**
     * 課税区分減免前後
     *
     * @param parameter DBB022002_ShotokuJohoHanyoListSakuseiParameter
     */
    private void 課税区分減免前後(DBB022002_ShotokuJohoHanyoListSakuseiParameter parameter) {
        RString code = DbBusinessConfig.get(ConfigNameDBB.所得引出_住民税減免前後表示区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        parameter.set住民税減免前後表示区分(code);
        if (div.getChushutsuJokenPanel() != null && div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae() != null
                && div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().getSelectedValues() != null) {
            List<RString> listコード課税区分減免前 = new ArrayList<>();
            List<RString> list課税区分減免前 = div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().getSelectedValues();
            Iterator<RString> it減免前 = list課税区分減免前.iterator();
            while (it減免前.hasNext()) {
                RString 減免前 = it減免前.next();
                if (課税.equals(減免前)) {
                    listコード課税区分減免前.add(定数1);
                }
                if (非課税.equals(減免前)) {
                    listコード課税区分減免前.add(定数2);
                }
                if (未申告.equals(減免前)) {
                    listコード課税区分減免前.add(定数3);
                }
                if (所得調査中.equals(減免前)) {
                    listコード課税区分減免前.add(定数4);
                }
                if (課税取消.equals(減免前)) {
                    listコード課税区分減免前.add(定数5);
                }
            }
            parameter.set課税区分減免前s(listコード課税区分減免前);
        }
        if (div.getChushutsuJokenPanel() != null && div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo() != null
                && div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().getSelectedValues() != null) {
            List<RString> listコード課税区分減免後 = new ArrayList<>();
            List<RString> list課税区分減免後 = div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().getSelectedValues();
            Iterator<RString> it減免後 = list課税区分減免後.iterator();
            while (it減免後.hasNext()) {
                RString 減免後 = it減免後.next();
                if (課税.equals(減免後)) {
                    listコード課税区分減免後.add(定数1);
                }
                if (非課税.equals(減免後)) {
                    listコード課税区分減免後.add(定数2);
                }
                if (未申告.equals(減免後)) {
                    listコード課税区分減免後.add(定数3);
                }
                if (所得調査中.equals(減免後)) {
                    listコード課税区分減免後.add(定数4);
                }
                if (課税取消.equals(減免後)) {
                    listコード課税区分減免後.add(定数5);
                }
            }
            parameter.set課税区分減免後s(listコード課税区分減免後);
        }
    }

    /**
     * 宛名抽出条件と出力順と出力項目
     *
     * @param parameter DBB022002_ShotokuJohoHanyoListSakuseiParameter
     */
    private void 宛名抽出条件と出力順と出力項目(DBB022002_ShotokuJohoHanyoListSakuseiParameter parameter) {
        parameter.set宛名抽出条件(div.getChushutsuPanel2().getCcdAtenaJoken().get宛名抽出条件());
        if (div.getCcdShutsuryokujun() != null && div.getCcdShutsuryokujun().get出力順ID() != null) {
            long 出力順ID = div.getCcdShutsuryokujun().get出力順ID();
            parameter.set出力順ID(出力順ID);
        }
        if (div.getCcdShutsuryokuKoumoku() != null) {
            RString 出力項目ID = div.getCcdShutsuryokuKoumoku().get出力項目ID();
            parameter.set出力項目ID(出力項目ID);
        }
    }

    /**
     * set初期項目状態
     */
    private void set初期項目状態() {
        div.getJokenFukugenHozonl().getBtnBatchParameterRestore().setDisabled(false);
        div.getJokenFukugenHozonl().getBtnBatchParameterSave().setDisabled(false);
        div.getChushutsuPanel2().getCcdAtenaJoken().initialize();
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBB介護賦課, 出力順帳票ID);
        div.getCcdShutsuryokuKoumoku().load(出力項目帳票ID, SubGyomuCode.DBB介護賦課);
        div.getCcdShutsuryokuKoumoku().setDisplayNone(false);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setDisabled(false);
        div.getFukaNendo().getDdlFukaNendo().setDisabled(false);
        div.getChushutsuJokenPanel().getTxtChushutsuKikan().setDisabled(false);
        RString code = DbBusinessConfig.get(ConfigNameDBB.所得引出_住民税減免前後表示区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        if (code.equals(表示しない)) {
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setDisabled(false);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setLabelLText(定数課税区分);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().setDisplayNone(true);
        } else if (code.equals(表示する)) {
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setDisabled(false);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setLabelLText(定数課税区分減免前);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().setDisabled(false);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().setLabelLText(定数課税区分減免後);
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("Execute"), false);
    }

    /**
     * set初期項目内容
     */
    private void set初期項目内容() {
        List<RString> items = new ArrayList<>();
        items.add(定数1);
        items.add(定数3);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(items);
        RString code = DbBusinessConfig.get(ConfigNameDBB.所得引出_住民税減免前後表示区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        if (code.equals(表示しない)) {
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setIsAllSelectable(true);
        } else if (code.equals(表示する)) {
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setIsAllSelectable(true);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().setIsAllSelectable(true);
        }
        div.getChushutsuJokenPanel().getTxtChushutsuKikan().clearFromValue();
        div.getChushutsuJokenPanel().getTxtChushutsuKikan().clearToValue();

        List<KeyValueDataSource> dataSource = new ArrayList<>();
        RString 日付関連調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        int start = Integer.parseInt(定数.toString());
        int end = Integer.parseInt(日付関連調定年度.toString());
        for (int i = end; i >= start; i--) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            FlexibleYear flexibleYear = new FlexibleYear(new RString(i));
            keyValue.setKey(new RString(i));
            keyValue.setValue(flexibleYear.wareki().toDateString());
            dataSource.add(keyValue);
        }
        div.getFukaNendo().getDdlFukaNendo().setDataSource(dataSource);
    }

    /**
     * 条件を保存するボタンのメソッドです。
     *
     * @return DBB022002_ShotokuJohoHanyoListSakuseiParameter
     */
    public DBB022002_ShotokuJohoHanyoListSakuseiParameter 条件を保存() {

        DBB022002_ShotokuJohoHanyoListSakuseiParameter parameter = new DBB022002_ShotokuJohoHanyoListSakuseiParameter();
        if (div.getCcdShutsuryokujun() != null) {
            parameter.set帳票ID(div.getCcdShutsuryokujun().get帳票ID());
        }
        parameter.set宛名抽出条件(div.getChushutsuPanel2().getCcdAtenaJoken().get宛名抽出条件());
        if (div.getCcdShutsuryokujun().getSelected出力順() != null) {
            parameter.set出力順ID(div.getCcdShutsuryokujun().getSelected出力順().get出力順ID());
        }
        if (div.getCcdShutsuryokuKoumoku() != null) {
            parameter.set出力項目ID(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        }
        List<RString> 編集方法list = div.getChkCsvHenshuHoho().getSelectedKeys();
        if (編集方法list.contains(KEY1)) {
            parameter.set項目名付加(true);
        }
        if (編集方法list.contains(KEY2)) {
            parameter.set連番付加(true);
        }
        if (編集方法list.contains(KEY3)) {
            parameter.set日付編集(true);
        }
        RString 年度 = div.getDdlFukaNendo().getSelectedValue();
        if (年度 != null && !年度.isEmpty()) {
            parameter.set賦課年度(new FlexibleYear(年度));
        }
        RDate 抽出期間From = div.getTxtChushutsuKikan().getFromValue();
        if (抽出期間From != null) {
            parameter.set抽出期間From(new YMDHMS(抽出期間From, RTime.now()));
        }
        RDate 抽出期間To = div.getTxtChushutsuKikan().getToValue();
        if (抽出期間To != null) {
            parameter.set抽出期間To(new YMDHMS(抽出期間To, RTime.now()));
        }
        if (div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().isDisplayNone()) {
            parameter.set住民税減免前後表示区分(表示しない);
        } else {
            parameter.set住民税減免前後表示区分(表示する);
        }
        if (div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae() != null) {
            parameter.set課税区分減免前s(div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().getSelectedKeys());
        }
        if (div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo() != null) {
            parameter.set課税区分減免後s(div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().getSelectedKeys());
        }
        return parameter;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     */
    public void 条件を復元() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        ReportId 条件保存の帳票ID = restoreBatchParameterMap.getParameterValue(ReportId.class, new RString("帳票ID"));
        long 条件保存の出力順ID = restoreBatchParameterMap.getParameterValue(long.class, new RString("出力順ID"));
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBB介護賦課, 条件保存の帳票ID, 条件保存の出力順ID);
        RString 条件保存の出力項目ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("出力項目ID"));
        div.getCcdShutsuryokuKoumoku().load(条件保存の出力項目ID, SubGyomuCode.DBB介護賦課);
        RString 表示区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("住民税減免前後表示区分"));
        if (表示区分.equals(表示しない)) {
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setDisabled(false);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setLabelLText(定数課税区分);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().setDisplayNone(true);
        } else if (表示区分.equals(表示する)) {
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setDisabled(false);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setLabelLText(定数課税区分減免前);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().setDisabled(false);
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().setLabelLText(定数課税区分減免後);
        }
        AtenaSelectBatchParameter 宛名抽出条件 = restoreBatchParameterMap
                .getParameterValue(AtenaSelectBatchParameter.class, new RString("宛名抽出条件"));
        IHanyoListAtenaSelectDiv selectDiv = div.getChushutsuPanel2().getCcdAtenaJoken();
        if (宛名抽出条件 != null) {
            selectDiv.set住所終了(new ChoikiCode(宛名抽出条件.getJusho_To()));
            selectDiv.set住所開始(new ChoikiCode(宛名抽出条件.getJusho_From()));
            selectDiv.set保険者(宛名抽出条件.getShichoson_Code());
            selectDiv.set地区(宛名抽出条件.getChiku_Kubun().get名称());
            selectDiv.set地区１終了(new ChikuCode(宛名抽出条件.getChiku1_To()));
            selectDiv.set地区１開始(new ChikuCode(宛名抽出条件.getChiku1_From()));
            selectDiv.set地区２終了(new ChikuCode(宛名抽出条件.getChiku2_To()));
            selectDiv.set地区２開始(new ChikuCode(宛名抽出条件.getChiku2_From()));
            selectDiv.set地区３終了(new ChikuCode(宛名抽出条件.getChiku3_To()));
            selectDiv.set地区３開始(new ChikuCode(宛名抽出条件.getChiku3_From()));
            selectDiv.set年齢基準日(宛名抽出条件.getNenreiKijunbi());
            selectDiv.set年齢層抽出方法(宛名抽出条件.getAgeSelectKijun().get名称());
            selectDiv.set年齢終了(宛名抽出条件.getNenreiRange().getTo());
            selectDiv.set年齢開始(宛名抽出条件.getNenreiRange().getFrom());
            selectDiv.set生年月日終了(宛名抽出条件.getSeinengappiRange().getTo());
            selectDiv.set生年月日開始(宛名抽出条件.getSeinengappiRange().getFrom());
            selectDiv.set行政区終了(new GyoseikuCode(宛名抽出条件.getGyoseiku_To()));
            selectDiv.set行政区開始(new GyoseikuCode(宛名抽出条件.getGyoseiku_From()));
        }
        boolean 項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("項目名付加"));
        List<RString> 編集方法list = new ArrayList<>();
        if (項目名付加) {
            編集方法list.add(KEY1);
        }
        boolean 連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("連番付加"));
        if (連番付加) {
            編集方法list.add(KEY2);
        }
        boolean 日付編集 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("日付編集"));
        if (日付編集) {
            編集方法list.add(KEY3);
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法list);
        FlexibleYear 賦課年度 = restoreBatchParameterMap.getParameterValue(FlexibleYear.class, new RString("賦課年度"));
        if (賦課年度 != null && !賦課年度.isEmpty()) {
            div.getDdlFukaNendo().setSelectedValue(賦課年度.toDateString());
        }
        YMDHMS 抽出期間From = restoreBatchParameterMap.getParameterValue(YMDHMS.class, new RString("抽出期間From"));
        if (抽出期間From != null && !抽出期間From.isEmpty()) {
            div.getTxtChushutsuKikan().setFromValue(抽出期間From.getDate());
        }
        YMDHMS 抽出期間To = restoreBatchParameterMap.getParameterValue(YMDHMS.class, new RString("抽出期間To"));
        if (抽出期間To != null && !抽出期間To.isEmpty()) {
            div.getTxtChushutsuKikan().setToValue(抽出期間To.getDate());
        }
        List<RString> 課税区分減免前s = restoreBatchParameterMap.getParameterValue(List.class, new RString("課税区分減免前s"));
        if (div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae() != null) {
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenMae().setSelectedItemsByKey(課税区分減免前s);
        }
        List<RString> 課税区分減免後s = restoreBatchParameterMap.getParameterValue(List.class, new RString("課税区分減免後s"));
        if (div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo() != null) {
            div.getChushutsuJokenPanel().getChkKazeiKubunGenmenGo().setSelectedItemsByKey(課税区分減免後s);
        }
    }
}
