/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1330001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710100.DBD710100_HanyoListHikazeiNenkinTaishoshaParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1330001.HanyoListJukyushaDaichoPanelDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * 画面設計_DBD1330001_汎用リスト出力(非課税年金対象者)のハンドラクラスです。
 *
 * @reamsid_L DBD-5820-010 zhengsongling
 */
public class HanyoListJukyushaDaichoPanelHandler {

    private static final RString 非課税年金下限年度 = new RString("2016");
    private static final int 最大DDL表示 = 6;
    private static final RString 単一 = new RString("単一");
    private static final RString 広域 = new RString("広域");
    private static final RString 月日の補正 = new RString("0401");
    private static final RString 抽出条件_コード1 = new RString("1");
    private static final RString 抽出条件_コード2 = new RString("2");
    private static final RString 抽出条件_名称1 = new RString("年指定");
    private static final RString 抽出条件_名称2 = new RString("全件");
    private static final RString 年指定_コード1 = new RString("1");
    private static final RString 年指定_コード2 = new RString("2");
    private static final RString 年指定_名称1 = new RString("年度（取込・登録年度）");
    private static final RString 年指定_名称2 = new RString("年（対象年：非課税年金受給年）");
    private static final RString 被保険者抽出_コード1 = new RString("1");
    private static final RString 被保険者抽出_コード2 = new RString("2");
    private static final RString 被保険者抽出_コード3 = new RString("3");
    private static final RString 被保険者抽出_名称1 = new RString("被保険者のみ");
    private static final RString 被保険者抽出_名称2 = new RString("被保険者以外のみ");
    private static final RString 被保険者抽出_名称3 = new RString("全て");
    private static final RString 最新情報_コード = new RString("1");
    private static final RString 最新情報_名称 = new RString("最新情報");
    private final HanyoListJukyushaDaichoPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HanyoListParamPanelDiv
     */
    public HanyoListJukyushaDaichoPanelHandler(HanyoListJukyushaDaichoPanelDiv div) {
        this.div = div;
    }

    /**
     * 初期化状態です。
     *
     * @param 導入形態 導入形態
     * @param 調定年度 調定年度
     */
    public void onLoad(RString 導入形態, RString 調定年度) {
        onLoad_被保険者抽出();
        onLoad_抽出条件選択();
        onLoad_年指定選択();
        onLoad_最新情報();
        onClick_抽出条件選択(調定年度);
        if (単一.equals(導入形態)) {
            div.getChushutsuPanel2().getCcdAtenaJoken().setDisabled(true);
        } else if (広域.equals(導入形態)) {
            div.getChushutsuPanel2().getCcdAtenaJoken().setDisabled(false);
        }
        List<RString> listCSV = new ArrayList<>();
        listCSV.add(CSVSettings.項目名付加.getコード());
        listCSV.add(CSVSettings.日付スラッシュ編集.getコード());
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(listCSV);
        div.getCcdAtenaJoken().initialize();
        div.getCcdAtenaJoken().get宛名抽出条件子Div().setDisabled(false);
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getRadSelectKijun().setDisabled(false);
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtNenrei().setDisabled(false);
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtNenreiKijunbi().setDisabled(false);
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getTxtSeinengappi().setDisabled(false);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD701008.getReportId());
        div.getCcdShutsuryokuKoumoku().load(ReportIdDBD.DBD701008.getReportId().value(), SubGyomuCode.DBD介護受給);
    }

    /**
     * 年度選択肢の設定です。
     *
     * @param 調定年度 調定年度
     */
    public void onClick_抽出条件選択(RString 調定年度) {
        RString 抽出条件 = div.getRadChushutsuJokenSentaku().getSelectedKey();
        RString 年指定 = div.getRadNenSiteiSentaku().getSelectedKey();
        if (抽出条件_コード1.equals(抽出条件)
                && 年指定_コード1.equals(年指定)) {
            List<RString> empty = new ArrayList<>();
            div.getChkSaisinJoho().setSelectedItemsByKey(empty);
            div.getChkSaisinJoho().setDisabled(true);
            div.getDdlSiteiNen().setDisabled(false);
            set年指定_年度(調定年度);
        } else if (抽出条件_コード2.equals(抽出条件)
                && 年指定_コード1.equals(年指定)) {
            List<RString> empty = new ArrayList<>();
            div.getChkSaisinJoho().setSelectedItemsByKey(empty);
            div.getChkSaisinJoho().setDisabled(true);
            div.getDdlSiteiNen().setDisabled(true);
            set全件_年度(調定年度);
        } else if (抽出条件_コード1.equals(抽出条件)
                && 年指定_コード2.equals(年指定)) {
            div.getChkSaisinJoho().setDisabled(false);
            div.getDdlSiteiNen().setDisabled(false);
            set年指定_年(調定年度);
        } else {
            div.getChkSaisinJoho().setDisabled(false);
            div.getDdlSiteiNen().setDisabled(true);
            set全件_年(調定年度);
        }
    }

    /**
     * 非課税年金対象者の条件を保存する。
     *
     * @return DBD710100_HanyoListHikazeiNenkinTaishoshaParameter
     */
    public DBD710100_HanyoListHikazeiNenkinTaishoshaParameter 条件を保存する() {
        DBD710100_HanyoListHikazeiNenkinTaishoshaParameter param = new DBD710100_HanyoListHikazeiNenkinTaishoshaParameter();
        RString 抽出条件 = div.getRadChushutsuJokenSentaku().getSelectedKey();
        RString 年指定 = div.getRadNenSiteiSentaku().getSelectedKey();
        param.set抽出方法(抽出条件.concat(年指定));
        param.set抽出年度(div.getDdlSiteiNen().getSelectedKey());
        param.set被保険者抽出方法(div.getRadHihokenshaChushutsu().getSelectedKey());
        param.set最新情報(div.getChkSaisinJoho().isAllSelected());
        List<RString> listCSV = div.getChkCsvHenshuHoho().getSelectedKeys();
        if (listCSV.contains(CSVSettings.項目名付加.getコード())) {
            param.set項目名付加(true);
        } else {
            param.set項目名付加(false);
        }
        if (listCSV.contains(CSVSettings.連番付加.getコード())) {
            param.set連番付加(true);
        } else {
            param.set連番付加(false);
        }
        if (listCSV.contains(CSVSettings.日付スラッシュ編集.getコード())) {
            param.set日付編集(true);
        } else {
            param.set日付編集(false);
        }
        param.set宛名抽出条件(div.getChushutsuPanel2().getCcdAtenaJoken().get宛名抽出条件());
        param.set出力順(div.getCcdShutsuryokujun().get出力順ID());
        if (div.getCcdShutsuryokuKoumoku().isDisabled()) {
            param.set出力項目(RString.EMPTY);
        } else {
            param.set出力項目(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        }
        return param;
    }

    /**
     * 非課税年金対象者の条件を復元する。
     *
     * @param 調定年度 調定年度
     */
    public void 条件を復元する(RString 調定年度) {
        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        RString 抽出方法 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("抽出方法"));
        div.getRadChushutsuJokenSentaku().setSelectedKey(抽出方法.substring(0, 1));
        div.getRadNenSiteiSentaku().setSelectedKey(抽出方法.substring(1, 2));
        onClick_抽出条件選択(調定年度);
        RString 抽出年度 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("抽出年度"));
        if (!抽出年度.isNullOrEmpty()) {
            div.getDdlSiteiNen().setSelectedKey(抽出年度);
        }
        RString 被保険者抽出方法 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("被保険者抽出方法"));
        div.getRadHihokenshaChushutsu().setSelectedKey(被保険者抽出方法);
        List<RString> 最新情報 = new ArrayList<>();
        最新情報.add(new RString("1"));
        if (restoreBatchParameterMap.getParameterValue(boolean.class, new RString("最新情報"))) {
            div.getChkSaisinJoho().setSelectedItemsByKey(最新情報);
        }
        List<RString> 編集方法 = new ArrayList<>();
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("項目名付加"))) {
            編集方法.add(CSVSettings.項目名付加.getコード());
        }
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("連番付加"))) {
            編集方法.add(CSVSettings.連番付加.getコード());
        }
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("日付編集"))) {
            編集方法.add(CSVSettings.日付スラッシュ編集.getコード());
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        AtenaSelectBatchParameter 宛名抽出条件 = restoreBatchParameterMap.getParameterValue(AtenaSelectBatchParameter.class, new RString("宛名抽出条件"));
        div.getChushutsuPanel2().getCcdAtenaJoken().set年齢層抽出方法(宛名抽出条件.getAgeSelectKijun().getコード());
        div.getChushutsuPanel2().getCcdAtenaJoken().set年齢開始(宛名抽出条件.getNenreiRange().getFrom());
        div.getChushutsuPanel2().getCcdAtenaJoken().set年齢終了(宛名抽出条件.getNenreiRange().getTo());
        div.getChushutsuPanel2().getCcdAtenaJoken().set年齢基準日(宛名抽出条件.getNenreiKijunbi());
        div.getChushutsuPanel2().getCcdAtenaJoken().set生年月日開始(宛名抽出条件.getSeinengappiRange().getFrom());
        div.getChushutsuPanel2().getCcdAtenaJoken().set生年月日終了(宛名抽出条件.getSeinengappiRange().getTo());
        div.getChushutsuPanel2().getCcdAtenaJoken().set保険者();
        div.getChushutsuPanel2().getCcdAtenaJoken().set地区(宛名抽出条件.getChiku_Kubun().getコード());
        div.getChushutsuPanel2().getCcdAtenaJoken().set住所開始(new ChoikiCode(宛名抽出条件.getJusho_From()));
        div.getChushutsuPanel2().getCcdAtenaJoken().set住所終了(new ChoikiCode(宛名抽出条件.getJusho_To()));
        div.getChushutsuPanel2().getCcdAtenaJoken().set行政区開始(new GyoseikuCode(宛名抽出条件.getGyoseiku_From()));
        div.getChushutsuPanel2().getCcdAtenaJoken().set行政区終了(new GyoseikuCode(宛名抽出条件.getGyoseiku_To()));
        div.getChushutsuPanel2().getCcdAtenaJoken().set地区１開始(new ChikuCode(宛名抽出条件.getChiku1_From()));
        div.getChushutsuPanel2().getCcdAtenaJoken().set地区１終了(new ChikuCode(宛名抽出条件.getChiku1_To()));
        div.getChushutsuPanel2().getCcdAtenaJoken().set地区２開始(new ChikuCode(宛名抽出条件.getChiku2_From()));
        div.getChushutsuPanel2().getCcdAtenaJoken().set地区２終了(new ChikuCode(宛名抽出条件.getChiku2_To()));
        div.getChushutsuPanel2().getCcdAtenaJoken().set地区３開始(new ChikuCode(宛名抽出条件.getChiku3_From()));
        div.getChushutsuPanel2().getCcdAtenaJoken().set地区３終了(new ChikuCode(宛名抽出条件.getChiku3_To()));
    }

    /**
     * 非課税年金対象者の実行です。
     *
     * @return DBD710100_HanyoListHikazeiNenkinTaishoshaParameter
     */
    public DBD710100_HanyoListHikazeiNenkinTaishoshaParameter onClick_実行() {
        RString 抽出条件 = div.getRadChushutsuJokenSentaku().getSelectedKey();
        RString 年指定 = div.getRadNenSiteiSentaku().getSelectedKey();
        RString 抽出方法 = 抽出条件.concat(年指定);
        RString 抽出年度 = div.getDdlSiteiNen().getSelectedKey();
        RString 被保険者抽出方法 = div.getRadHihokenshaChushutsu().getSelectedKey();
        boolean 項目名付加 = false;
        boolean 連番付加 = false;
        boolean 日付編集 = false;
        List<RString> listCSV = div.getChkCsvHenshuHoho().getSelectedKeys();
        for (RString list : listCSV) {
            if (CSVSettings.項目名付加.getコード().equals(list)) {
                項目名付加 = true;
            }
            if (CSVSettings.連番付加.getコード().equals(list)) {
                連番付加 = true;
            }
            if (CSVSettings.日付スラッシュ編集.getコード().equals(list)) {
                日付編集 = true;
            }
        }
        AtenaSelectBatchParameter 宛名抽出条件 = div.getCcdAtenaJoken().get宛名抽出条件();
        Long 出力順ID = div.getCcdShutsuryokujun().get出力順ID();
        RString 出力項目ID = div.getCcdShutsuryokuKoumoku().get出力項目ID();
        return new DBD710100_HanyoListHikazeiNenkinTaishoshaParameter(
                抽出方法,
                抽出年度,
                被保険者抽出方法,
                div.getChkSaisinJoho().isAllSelected(),
                項目名付加,
                連番付加,
                日付編集,
                宛名抽出条件,
                出力順ID,
                出力項目ID);
    }

    private void set年指定_年度(RString 調定年度) {
        div.getDdlSiteiNen().getDataSource().clear();
        KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
        List<KeyValueDataSource> listKeyValueDataSource = new ArrayList<>();
        keyValueDataSource.setKey(調定年度);
        keyValueDataSource.setValue(new FlexibleDate(調定年度.concat(月日の補正)).wareki().getYear());
        listKeyValueDataSource.add(keyValueDataSource);
        div.getDdlSiteiNen().setDataSource(listKeyValueDataSource);

    }

    private void set全件_年度(RString 調定年度) {
        div.getDdlSiteiNen().getDataSource().clear();
        List<KeyValueDataSource> listKeyValueDataSource = new ArrayList<>();
        if (非課税年金下限年度.compareTo(調定年度) > 0) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
            keyValueDataSource.setKey(RString.EMPTY);
            keyValueDataSource.setValue(RString.EMPTY);
            listKeyValueDataSource.add(keyValueDataSource);
        } else {
            Integer 年度差 = Integer.valueOf(調定年度.toString()) - Integer.valueOf(非課税年金下限年度.toString());
            if (年度差 > 最大DDL表示) {
                年度差 = 最大DDL表示;
            }
            for (int i = 0; i < 年度差; i++) {
                KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
                keyValueDataSource.setKey(new FlexibleDate(調定年度.concat(月日の補正)).minusYear(i).getYear().toDateString());
                keyValueDataSource.setValue(new FlexibleDate(調定年度.concat(月日の補正)).minusYear(i).wareki().getYear());
                listKeyValueDataSource.add(keyValueDataSource);
            }
        }
        div.getDdlSiteiNen().setDataSource(listKeyValueDataSource);
    }

    private void set年指定_年(RString 調定年度) {
        div.getDdlSiteiNen().getDataSource().clear();
        RString 算出した日付 = new FlexibleDate(調定年度.concat(月日の補正)).minusYear(1).getYear().toDateString();
        KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
        List<KeyValueDataSource> listKeyValueDataSource = new ArrayList<>();
        keyValueDataSource.setKey(算出した日付);
        keyValueDataSource.setValue(new FlexibleDate(算出した日付.concat(月日の補正)).wareki().getYear());
        listKeyValueDataSource.add(keyValueDataSource);
        div.getDdlSiteiNen().setDataSource(listKeyValueDataSource);
    }

    private void set全件_年(RString 調定年度) {
        div.getDdlSiteiNen().getDataSource().clear();
        List<KeyValueDataSource> listKeyValueDataSource = new ArrayList<>();
        if (非課税年金下限年度.compareTo(調定年度) > 0) {
            KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
            keyValueDataSource.setKey(RString.EMPTY);
            keyValueDataSource.setValue(RString.EMPTY);
            listKeyValueDataSource.add(keyValueDataSource);
        } else {
            Integer 年度差 = Integer.valueOf(調定年度.toString()) - Integer.valueOf(非課税年金下限年度.toString());
            if (年度差 > 最大DDL表示) {
                年度差 = 最大DDL表示;
            }
            for (int i = 0; i < 年度差; i++) {
                RString 算出した日付 = new FlexibleDate(調定年度.concat(月日の補正)).minusYear(i + 1).getYear().toDateString();
                KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
                keyValueDataSource.setKey(算出した日付);
                keyValueDataSource.setValue(new FlexibleDate(算出した日付.concat(月日の補正)).wareki().getYear());
                listKeyValueDataSource.add(keyValueDataSource);
            }
        }
        div.getDdlSiteiNen().setDataSource(listKeyValueDataSource);
    }

    private void onLoad_被保険者抽出() {
        List<KeyValueDataSource> listdataSource = new ArrayList<>();
        KeyValueDataSource keyValueDataSource1 = new KeyValueDataSource();
        keyValueDataSource1.setKey(被保険者抽出_コード1);
        keyValueDataSource1.setValue(被保険者抽出_名称1);
        listdataSource.add(keyValueDataSource1);
        KeyValueDataSource keyValueDataSource2 = new KeyValueDataSource();
        keyValueDataSource2.setKey(被保険者抽出_コード2);
        keyValueDataSource2.setValue(被保険者抽出_名称2);
        listdataSource.add(keyValueDataSource2);
        KeyValueDataSource keyValueDataSource3 = new KeyValueDataSource();
        keyValueDataSource3.setKey(被保険者抽出_コード3);
        keyValueDataSource3.setValue(被保険者抽出_名称3);
        listdataSource.add(keyValueDataSource3);
        div.getRadHihokenshaChushutsu().setDataSource(listdataSource);
        div.getRadHihokenshaChushutsu().setSelectedKey(被保険者抽出_コード3);
    }

    private void onLoad_抽出条件選択() {
        div.getRadChushutsuJokenSentaku().getDataSource().clear();
        List<KeyValueDataSource> listdataSource = new ArrayList<>();
        KeyValueDataSource keyValueDataSource1 = new KeyValueDataSource();
        keyValueDataSource1.setKey(抽出条件_コード1);
        keyValueDataSource1.setValue(抽出条件_名称1);
        listdataSource.add(keyValueDataSource1);
        KeyValueDataSource keyValueDataSource2 = new KeyValueDataSource();
        keyValueDataSource2.setKey(抽出条件_コード2);
        keyValueDataSource2.setValue(抽出条件_名称2);
        listdataSource.add(keyValueDataSource2);
        div.getRadChushutsuJokenSentaku().setDataSource(listdataSource);
        div.getRadChushutsuJokenSentaku().setSelectedKey(抽出条件_コード1);
    }

    private void onLoad_年指定選択() {
        div.getRadNenSiteiSentaku().getDataSource().clear();
        List<KeyValueDataSource> listdataSource = new ArrayList<>();
        KeyValueDataSource keyValueDataSource1 = new KeyValueDataSource();
        keyValueDataSource1.setKey(年指定_コード1);
        keyValueDataSource1.setValue(年指定_名称1);
        listdataSource.add(keyValueDataSource1);
        KeyValueDataSource keyValueDataSource2 = new KeyValueDataSource();
        keyValueDataSource2.setKey(年指定_コード2);
        keyValueDataSource2.setValue(年指定_名称2);
        listdataSource.add(keyValueDataSource2);
        div.getRadNenSiteiSentaku().setDataSource(listdataSource);
        div.getRadNenSiteiSentaku().setSelectedKey(年指定_コード1);
    }

    private void onLoad_最新情報() {
        div.getChkSaisinJoho().getDataSource().clear();
        List<KeyValueDataSource> listdataSource = new ArrayList<>();
        KeyValueDataSource keyValueDataSource = new KeyValueDataSource();
        keyValueDataSource.setKey(最新情報_コード);
        keyValueDataSource.setValue(最新情報_名称);
        listdataSource.add(keyValueDataSource);
        div.getChkSaisinJoho().setDataSource(listdataSource);
        div.getChkSaisinJoho().setDisabled(true);
    }
}
