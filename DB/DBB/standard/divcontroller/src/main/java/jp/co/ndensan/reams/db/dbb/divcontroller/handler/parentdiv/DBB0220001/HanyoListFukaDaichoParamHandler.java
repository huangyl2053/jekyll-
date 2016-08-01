/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0220001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.hanyolistfukadaicho.HanyoListFukaDaichoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220001.HanyoListFukaDaichoParamDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_FOUR = 4;

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
     * @return HanyoListFukaDaichoBatchParameter
     */
    public HanyoListFukaDaichoBatchParameter onClick_btnExecute() {
        HanyoListFukaDaichoBatchParameter parameter = new HanyoListFukaDaichoBatchParameter();
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
        //TODO 　DBBEnum.賦課台帳.基準日区分 (QA#1027)
        parameter.set基準日区分(null);
        //TODO DBBEnum.賦課台帳.資格区分 DBBEnum.賦課台帳.受給者判定 (QA#1027)
        parameter.set資格区分(null);
        parameter.set受給者判定(null);
        parameter.set徴収方法(div.getChushutsuJokenPanel().getDdlChosyuHoho().getSelectedKey());
        parameter.set保険料段階s(div.getChushutsuJokenPanel().getChkHokenryoDankai().getSelectedKeys());
        return parameter;
    }

    /**
     * 宛名抽出条件と出力順と出力項目
     *
     * @param parameter HanyoListShotokuJohoBatchParameter
     */
    private void 宛名抽出条件と出力順と出力項目(HanyoListFukaDaichoBatchParameter parameter) {
        AtenaSelectBatchParameter 宛名抽出条件 = new AtenaSelectBatchParameter();
        if (div.getChushutsuPanel2() != null && div.getChushutsuPanel2().getCcdAtenaJoken() != null) {
            NenreiSoChushutsuHoho 年齢層抽出方法 = div.getChushutsuPanel2().getCcdAtenaJoken().get年齢層抽出方法();
            宛名抽出条件.setAgeSelectKijun(年齢層抽出方法);
            Decimal 年齢開始 = div.getChushutsuPanel2().getCcdAtenaJoken().get年齢開始();
            Decimal 年齢終了 = div.getChushutsuPanel2().getCcdAtenaJoken().get年齢終了();
            Range<Decimal> 年齢範囲 = new Range<>(年齢開始, 年齢終了);
            宛名抽出条件.setNenreiRange(年齢範囲);
            RDate 年齢基準日 = div.getChushutsuPanel2().getCcdAtenaJoken().get年齢基準日();
            宛名抽出条件.setNenreiKijunbi(年齢基準日);
            RDate 生年月日開始 = div.getChushutsuPanel2().getCcdAtenaJoken().get生年月日開始();
            RDate 生年月日終了 = div.getChushutsuPanel2().getCcdAtenaJoken().get生年月日終了();
            Range<RDate> 生年月日範囲 = new Range<>(生年月日開始, 生年月日終了);
            宛名抽出条件.setSeinengappiRange(生年月日範囲);
            LasdecCode 市町村コード = div.getChushutsuPanel2().getCcdAtenaJoken().get保険者().get市町村コード();
            宛名抽出条件.setShichoson_Code(市町村コード);
            RString 市町村名称 = div.getChushutsuPanel2().getCcdAtenaJoken().get保険者().get市町村名称();
            宛名抽出条件.setShichoson_Mesho(市町村名称);
            Chiku 地区区分 = div.getChushutsuPanel2().getCcdAtenaJoken().get地区();
            宛名抽出条件.setChiku_Kubun(地区区分);
            RString 町域From = div.getChushutsuPanel2().getCcdAtenaJoken().get住所開始();
            宛名抽出条件.setJusho_From(町域From);
            RString 町域To = div.getChushutsuPanel2().getCcdAtenaJoken().get住所終了();
            宛名抽出条件.setJusho_To(町域To);
            RString 行政区From = div.getChushutsuPanel2().getCcdAtenaJoken().get行政区開始();
            宛名抽出条件.setGyoseiku_From(行政区From);
            RString 行政区To = div.getChushutsuPanel2().getCcdAtenaJoken().get行政区終了();
            宛名抽出条件.setGyoseiku_To(行政区To);
            RString 地区１開始 = div.getChushutsuPanel2().getCcdAtenaJoken().get地区１開始();
            宛名抽出条件.setChiku1_From(地区１開始);
            RString 地区１終了 = div.getChushutsuPanel2().getCcdAtenaJoken().get地区１終了();
            宛名抽出条件.setChiku1_To(地区１終了);
            RString 地区２開始 = div.getChushutsuPanel2().getCcdAtenaJoken().get地区２開始();
            宛名抽出条件.setChiku2_From(地区２開始);
            RString 地区２終了 = div.getChushutsuPanel2().getCcdAtenaJoken().get地区２終了();
            宛名抽出条件.setChiku2_To(地区２終了);
            RString 地区３開始 = div.getChushutsuPanel2().getCcdAtenaJoken().get地区３開始();
            宛名抽出条件.setChiku3_From(地区３開始);
            RString 地区３終了 = div.getChushutsuPanel2().getCcdAtenaJoken().get地区３終了();
            宛名抽出条件.setChiku3_To(地区３終了);
        }
        parameter.set宛名抽出条件(宛名抽出条件);
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
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("Execute"), false);
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
        div.getNendoKijumbiSitei().getRadKijumbiSentaku().setSelectedKey(定数KEY0);
        //TODO DBBEnum.賦課台帳.資格区分 DBBEnum.賦課台帳.受給者判定 (QA#1027)
        List<KeyValueDataSource> dataSource1 = new ArrayList<>();
        for (ChoshuHoho 徴収方法 : ChoshuHoho.values()) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(徴収方法.getコード());
            keyValue.setValue(徴収方法.get名称());
            dataSource1.add(keyValue);
        }
        div.getChushutsuJokenPanel().getDdlChosyuHoho().setDataSource(dataSource1);
        if (!dataSource1.isEmpty()) {
            div.getChushutsuJokenPanel().getDdlChosyuHoho().setSelectedIndex(INDEX_ZERO);
        }
        div.getChushutsuJokenPanel().getChkHokenryoDankai().setIsAllSelectable(true);
    }
}
