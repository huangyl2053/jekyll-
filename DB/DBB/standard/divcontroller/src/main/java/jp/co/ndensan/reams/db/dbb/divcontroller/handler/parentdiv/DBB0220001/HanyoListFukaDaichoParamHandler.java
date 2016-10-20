/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB022001.DBB022001_FukaDaichoHanyoListSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolist.fukadaicho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolist.fukadaicho.JukyushaHantei;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolist.fukadaicho.KijunbiKubun;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolist.fukadaicho.ShikakuKubun;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220001.HanyoListFukaDaichoParamDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 画面設計_DBBGM22001_汎用リスト賦課台帳のクラス
 *
 * @reamsid_L DBB-1900-010 surun
 */
public class HanyoListFukaDaichoParamHandler {

    private final HanyoListFukaDaichoParamDiv div;
    private final RString 定数ONE = new RString("1");
    private final RString 定数THREE = new RString("3");
    private final RString 定数 = new RString("2000");
    private final RString 定数KEY0 = new RString("key0");
    private final ReportId 出力順帳票ID = new ReportId("DBB200033_HanyoListFukaDaicho");
    private final RString 出力項目帳票ID = new RString("DBB200033_HanyoListFukaDaicho");
    private final RString 実行ボタンNAME = new RString("Execute");
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_FOUR = 4;
    private static final RString KEY_調定年度 = new RString("調定年度");
    private static final RString KEY_賦課年度 = new RString("賦課年度");
    private static final RString KEY_基準日 = new RString("基準日");
    private static final RString KEY_基準日区分 = new RString("基準日区分");
    private static final RString KEY_資格区分 = new RString("資格区分");
    private static final RString KEY_受給者判定 = new RString("受給者判定");
    private static final RString KEY_帳票ID = new RString("帳票ID");
    private static final RString KEY_出力順ID = new RString("出力順ID");
    private static final RString KEY_出力項目ID = new RString("出力項目ID");
    private static final RString KEY_宛名抽出条件 = new RString("宛名抽出条件");
    private static final RString KEY_徴収方法 = new RString("徴収方法");
    private static final RString KEY_保険料段階 = new RString("保険料段階s");
    private static final RString KEY_項目名付加 = new RString("項目名付加");
    private static final RString KEY_連番付加 = new RString("連番付加");
    private static final RString KEY_日付スラッシュ付加 = new RString("日付スラッシュ付加");

    /**
     * コンストラクタです。
     *
     * @param div HanyoListFukaDaichoParamDiv
     */
    public HanyoListFukaDaichoParamHandler(HanyoListFukaDaichoParamDiv div) {
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
     * 最新状態で抽出CKBがチェック。
     */
    public void onChange_chkKijyunbiSiteiUmu() {
        if (div.getNendoKijumbiSitei().getChkKijyunbiSiteiUmu().isAllSelected()) {
            div.getNendoKijumbiSitei().getTxtKijyunbi().setDisabled(true);
            div.getNendoKijumbiSitei().getRadKijumbiSentaku().setDisabled(true);
        } else {
            div.getNendoKijumbiSitei().getTxtKijyunbi().setDisabled(false);
            div.getNendoKijumbiSitei().getRadKijumbiSentaku().setDisabled(false);
        }
    }

    /**
     * 実行ボタンイベント。
     *
     * @return DBB022001_FukaDaichoHanyoListSakuseiParameter
     */
    public DBB022001_FukaDaichoHanyoListSakuseiParameter onClick_btnExecute() {
        DBB022001_FukaDaichoHanyoListSakuseiParameter parameter = new DBB022001_FukaDaichoHanyoListSakuseiParameter();
        parameter.set帳票ID(div.getCcdShutsuryokujun().get帳票ID());
        宛名抽出条件と出力順と出力項目(parameter);
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
        if (div.getNendoKijumbiSitei().getDdlChoteiNendo().
                getSelectedValue().toString() != null) {
            FlexibleYear 調定年度 = new FlexibleYear(new RDate(div.getNendoKijumbiSitei().getDdlChoteiNendo().
                    getSelectedValue().toString()).toDateString().substring(INDEX_ZERO, INDEX_FOUR));
            parameter.set調定年度(調定年度);
        }
        if (div.getNendoKijumbiSitei().getDdlFukaNendo().
                getSelectedValue().toString() != null) {
            FlexibleYear 賦課年度 = new FlexibleYear(new RDate(div.getNendoKijumbiSitei().getDdlFukaNendo().
                    getSelectedValue().toString()).toDateString().substring(INDEX_ZERO, INDEX_FOUR));
            parameter.set賦課年度(賦課年度);
        }
        parameter.set最新状態で抽出(div.getNendoKijumbiSitei().getChkKijyunbiSiteiUmu().isAllSelected());
        parameter.set基準日(div.getNendoKijumbiSitei().getTxtKijyunbi().getValue());
        parameter.set基準日区分(div.getNendoKijumbiSitei().getRadKijumbiSentaku().getSelectedKey());
        parameter.set資格区分(div.getChushutsuJokenPanel().getDdlShikakuKubun().getSelectedKey());
        parameter.set受給者判定(div.getChushutsuJokenPanel().getDdlJukyushaHantei().getSelectedKey());
        parameter.set徴収方法(div.getChushutsuJokenPanel().getDdlChosyuHoho().getSelectedKey());
        parameter.set保険料段階s(div.getChushutsuJokenPanel().getChkHokenryoDankai().getSelectedKeys());
        return parameter;
    }

    /**
     * 宛名抽出条件と出力順と出力項目
     *
     * @param parameter HanyoListShotokuJohoBatchParameter
     */
    private void 宛名抽出条件と出力順と出力項目(DBB022001_FukaDaichoHanyoListSakuseiParameter parameter) {
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

    private void set初期項目状態() {
        div.getJokenFukugenHozonl().getBtnBatchParameterRestore().setDisabled(false);
        div.getJokenFukugenHozonl().getBtnBatchParameterSave().setDisabled(false);
        div.getChushutsuPanel2().getCcdAtenaJoken().initialize();
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBB介護賦課, 出力順帳票ID);
        div.getCcdShutsuryokuKoumoku().load(出力項目帳票ID, SubGyomuCode.DBB介護賦課);
        div.getCcdShutsuryokuKoumoku().setDisplayNone(false);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setDisabled(false);
        div.getNendoKijumbiSitei().getDdlChoteiNendo().setDisabled(false);
        div.getNendoKijumbiSitei().getDdlFukaNendo().setDisabled(false);
        div.getNendoKijumbiSitei().getChkKijyunbiSiteiUmu().setDisabled(false);
        div.getNendoKijumbiSitei().getTxtKijyunbi().setDisabled(true);
        div.getNendoKijumbiSitei().getRadKijumbiSentaku().setDisabled(true);
        div.getChushutsuJokenPanel().getDdlShikakuKubun().setDisabled(false);
        div.getChushutsuJokenPanel().getDdlJukyushaHantei().setDisabled(false);
        div.getChushutsuJokenPanel().getDdlChosyuHoho().setDisabled(false);
        div.getChushutsuJokenPanel().getChkHokenryoDankai().setDisabled(false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(実行ボタンNAME, false);
    }

    private void set初期項目内容() {
        List<RString> item = new ArrayList<>();
        item.add(定数ONE);
        item.add(定数THREE);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(item);
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        int start = Integer.parseInt(定数.toString());
        int end = Integer.parseInt(調定年度.toString());
        for (int i = end; i >= start; i--) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            FlexibleYear flexibleYear = new FlexibleYear(new RString(i));
            keyValue.setKey(new RString(i));
            keyValue.setValue(flexibleYear.wareki().toDateString());
            dataSource.add(keyValue);
        }
        div.getNendoKijumbiSitei().getDdlChoteiNendo().setDataSource(dataSource);
        div.getNendoKijumbiSitei().getDdlFukaNendo().setDataSource(dataSource);
        List<RString> keyList = new ArrayList<>();
        keyList.add(定数KEY0);
        div.getNendoKijumbiSitei().getChkKijyunbiSiteiUmu().setSelectedItemsByKey(keyList);
        div.getNendoKijumbiSitei().getTxtKijyunbi().clearValue();

        List<KeyValueDataSource> 基準日区分_dataSource = new ArrayList<>();
        for (KijunbiKubun 基準日区分 : KijunbiKubun.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(基準日区分.getコード());
            keyValue.setValue(基準日区分.get名称());
            基準日区分_dataSource.add(keyValue);
        }
        div.getNendoKijumbiSitei().getRadKijumbiSentaku().setDataSource(基準日区分_dataSource);
        if (!基準日区分_dataSource.isEmpty()) {
            div.getNendoKijumbiSitei().getRadKijumbiSentaku().setSelectedIndex(INDEX_ZERO);
        }
        List<KeyValueDataSource> 資格区分_dataSource = new ArrayList<>();
        for (ShikakuKubun 資格区分 : ShikakuKubun.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(資格区分.getコード());
            keyValue.setValue(資格区分.get名称());
            資格区分_dataSource.add(keyValue);
        }
        div.getChushutsuJokenPanel().getDdlShikakuKubun().setDataSource(資格区分_dataSource);
        if (!資格区分_dataSource.isEmpty()) {
            div.getChushutsuJokenPanel().getDdlShikakuKubun().setSelectedIndex(INDEX_ZERO);
        }
        List<KeyValueDataSource> 受給者判定_dataSource = new ArrayList<>();
        for (JukyushaHantei 受給者判定 : JukyushaHantei.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(受給者判定.getコード());
            keyValue.setValue(受給者判定.get名称());
            受給者判定_dataSource.add(keyValue);
        }
        div.getChushutsuJokenPanel().getDdlJukyushaHantei().setDataSource(受給者判定_dataSource);
        if (!受給者判定_dataSource.isEmpty()) {
            div.getChushutsuJokenPanel().getDdlJukyushaHantei().setSelectedIndex(INDEX_ZERO);
        }
        List<KeyValueDataSource> 徴収方法_dataSource = new ArrayList<>();
        for (ChoshuHoho 徴収方法 : ChoshuHoho.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(徴収方法.getコード());
            keyValue.setValue(徴収方法.get名称());
            徴収方法_dataSource.add(keyValue);
        }
        div.getChushutsuJokenPanel().getDdlChosyuHoho().setDataSource(徴収方法_dataSource);
        if (!徴収方法_dataSource.isEmpty()) {
            div.getChushutsuJokenPanel().getDdlChosyuHoho().setSelectedIndex(INDEX_ZERO);
        }
        div.getChushutsuJokenPanel().getChkHokenryoDankai().setIsAllSelectable(true);
    }

    /**
     * 条件を復元するボタンのメソッドです。
     */
    public void pamaRestore() {

        BatchParameterMap restoreBatchParameterMap = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        List<RString> csv編集方法リスト = new ArrayList<>();
        boolean 項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_項目名付加);
        if (項目名付加) {
            csv編集方法リスト.add(CSVSettings.項目名付加.getコード());
        }
        boolean 連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_連番付加);
        if (連番付加) {
            csv編集方法リスト.add(CSVSettings.連番付加.getコード());
        }
        boolean 日付スラッシュ付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_日付スラッシュ付加);
        if (日付スラッシュ付加) {
            csv編集方法リスト.add(CSVSettings.日付スラッシュ編集.getコード());
        }
        if (!csv編集方法リスト.isEmpty()) {
            div.getChkCsvHenshuHoho().setSelectedItemsByKey(csv編集方法リスト);
        }
        FlexibleYear 調定年度 = restoreBatchParameterMap.getParameterValue(FlexibleYear.class, KEY_調定年度);
        if (調定年度 != null && !調定年度.isEmpty()) {
            div.getNendoKijumbiSitei().getDdlChoteiNendo().setSelectedValue(調定年度.toDateString());
        }
        FlexibleYear 賦課年度 = restoreBatchParameterMap.getParameterValue(FlexibleYear.class, KEY_賦課年度);
        if (賦課年度 != null && !賦課年度.isEmpty()) {
            div.getNendoKijumbiSitei().getDdlFukaNendo().setSelectedValue(賦課年度.toDateString());
        }
        div.getNendoKijumbiSitei().getTxtKijyunbi().clearValue();
        RDate 基準日 = restoreBatchParameterMap.getParameterValue(RDate.class, KEY_基準日);
        if (基準日 != null) {
            div.getNendoKijumbiSitei().getTxtKijyunbi().setValue(基準日);
        }
        RString 基準日区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_基準日区分);
        if (基準日区分 != null && !基準日区分.isEmpty()) {
            div.getNendoKijumbiSitei().getRadKijumbiSentaku().setSelectedKey(基準日区分);
        }
        RString 資格区分 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_資格区分);
        if (資格区分 != null && !資格区分.isEmpty()) {
            div.getChushutsuJokenPanel().getDdlShikakuKubun().setSelectedKey(資格区分);
        }
        RString 受給者判定 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_受給者判定);
        if (受給者判定 != null && !受給者判定.isEmpty()) {
            div.getChushutsuJokenPanel().getDdlJukyushaHantei().setSelectedKey(受給者判定);
        }
        pamaRestorePart2(restoreBatchParameterMap);
    }

    private void pamaRestorePart2(BatchParameterMap restoreBatchParameterMap) {
        ReportId 帳票ID = restoreBatchParameterMap.getParameterValue(ReportId.class, KEY_帳票ID);
        long 出力順ID = restoreBatchParameterMap.getParameterValue(long.class, KEY_出力順ID);
        if (帳票ID != null) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBB介護賦課, 帳票ID, 出力順ID);
        }
        RString 出力項目ID = restoreBatchParameterMap.getParameterValue(RString.class, KEY_出力項目ID);
        if (出力項目ID != null && !出力項目ID.isEmpty()) {
            div.getCcdShutsuryokuKoumoku().load(出力項目ID, SubGyomuCode.DBB介護賦課);
        }
        AtenaSelectBatchParameter 宛名抽出条件 = restoreBatchParameterMap.getParameterValue(AtenaSelectBatchParameter.class, KEY_宛名抽出条件);
        if (宛名抽出条件 != null) {
            div.getChushutsuPanel2().getCcdAtenaJoken().set住所終了(new ChoikiCode(宛名抽出条件.getJusho_To()));
            div.getChushutsuPanel2().getCcdAtenaJoken().set住所開始(new ChoikiCode(宛名抽出条件.getJusho_From()));
            div.getChushutsuPanel2().getCcdAtenaJoken().set保険者(宛名抽出条件.getShichoson_Code());
            div.getChushutsuPanel2().getCcdAtenaJoken().set地区(宛名抽出条件.getChiku_Kubun().get名称());
            div.getChushutsuPanel2().getCcdAtenaJoken().set地区１終了(new ChikuCode(宛名抽出条件.getChiku1_To()));
            div.getChushutsuPanel2().getCcdAtenaJoken().set地区１開始(new ChikuCode(宛名抽出条件.getChiku1_From()));
            div.getChushutsuPanel2().getCcdAtenaJoken().set地区２終了(new ChikuCode(宛名抽出条件.getChiku2_To()));
            div.getChushutsuPanel2().getCcdAtenaJoken().set地区２開始(new ChikuCode(宛名抽出条件.getChiku2_From()));
            div.getChushutsuPanel2().getCcdAtenaJoken().set地区３終了(new ChikuCode(宛名抽出条件.getChiku3_To()));
            div.getChushutsuPanel2().getCcdAtenaJoken().set地区３開始(new ChikuCode(宛名抽出条件.getChiku3_From()));
            div.getChushutsuPanel2().getCcdAtenaJoken().set年齢基準日(宛名抽出条件.getNenreiKijunbi());
            div.getChushutsuPanel2().getCcdAtenaJoken().set年齢層抽出方法(宛名抽出条件.getAgeSelectKijun().get名称());
            div.getChushutsuPanel2().getCcdAtenaJoken().set年齢終了(宛名抽出条件.getNenreiRange().getTo());
            div.getChushutsuPanel2().getCcdAtenaJoken().set年齢開始(宛名抽出条件.getNenreiRange().getFrom());
            div.getChushutsuPanel2().getCcdAtenaJoken().set生年月日終了(宛名抽出条件.getSeinengappiRange().getTo());
            div.getChushutsuPanel2().getCcdAtenaJoken().set生年月日開始(宛名抽出条件.getSeinengappiRange().getFrom());
            div.getChushutsuPanel2().getCcdAtenaJoken().set行政区終了(new GyoseikuCode(宛名抽出条件.getGyoseiku_To()));
            div.getChushutsuPanel2().getCcdAtenaJoken().set行政区開始(new GyoseikuCode(宛名抽出条件.getGyoseiku_From()));
        }
        RString 徴収方法 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_徴収方法);
        if (徴収方法 != null && !徴収方法.isEmpty()) {
            div.getChushutsuJokenPanel().getDdlChosyuHoho().setSelectedKey(徴収方法);
        }
        List<RString> 保険料段階s = restoreBatchParameterMap.getParameterValue(List.class, KEY_保険料段階);
        if (保険料段階s != null && !保険料段階s.isEmpty()) {
            div.getChushutsuJokenPanel().getChkHokenryoDankai().setSelectedItemsByKey(保険料段階s);
        }
    }
}
