/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7010001;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoBatchParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010001.DvHihokenshaDaichoParamDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト被保険者台帳のクラスです。
 *
 * @reamsid_L DBA-1610-010 linghuhang
 */
public class DvHihokenshaDaichoParamDivHandler {

    private final RString 帳票ID = new RString("DBA701001_HanyoListHihokenshaDaicho");
    private final DvHihokenshaDaichoParamDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト被保険者台帳パネル
     */
    public DvHihokenshaDaichoParamDivHandler(DvHihokenshaDaichoParamDiv div) {
        this.div = div;
    }

    /**
     * 画面を初期化します。
     */
    public void initialize() {
        日付抽出区分が直近非活性();
        div.getCcdHanyoListAtenaSelect().initialize();
        div.getCcdKogakuShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA701001.getReportId());
        // TODO QA #73393 出力順ID実装方式 回復待ち  2016/01/20まで
//        div.getCcdKogakuShutsuryokuKomoku().load(帳票ID, SubGyomuCode.DBA介護資格);

        // TODO n3327 三浦 出力順実装完了まで
        div.getCcdKogakuShutsuryokujun().setDisplayNone(true);
    }

    /**
     * 日付抽出エリア内の表示制御を設定します。
     *
     * @param 日付抽出区分 日付抽出区分
     */
    public void set日付抽出区分FromCode(RString 日付抽出区分) {
        if (HizukeChushutsuKubun.直近.getコード().equals(日付抽出区分)) {
            日付抽出区分が直近非活性();
        } else if (HizukeChushutsuKubun.基準日.getコード().equals(日付抽出区分)) {
            日付抽出区分が基準日非活性();
        } else {
            日付抽出区分が範囲非活性();
        }
    }

    /**
     * 現在選択中の日付抽出区分(直近・基準日・範囲)を返却します。
     *
     * @param div DvHihokenshaDaichoParamDiv
     * @return 日付抽出区分. 未選択の場合は、{@code null}
     */
    @CheckForNull
    public HizukeChushutsuKubun get日付抽出区分() {
        if (!RString.isNullOrEmpty(this.div.getRadChushutsuChokkin().getSelectedKey())) {
            return HizukeChushutsuKubun.直近;
        }
        if (!RString.isNullOrEmpty(this.div.getRadChushutsuKijunBi().getSelectedKey())) {
            return HizukeChushutsuKubun.基準日;
        }
        if (!RString.isNullOrEmpty(this.div.getRadChushutsuHani().getSelectedKey())) {
            return HizukeChushutsuKubun.範囲;
        }
        return null;
    }

    /**
     * 現在選択中の日付抽出区分(直近・基準日・範囲)のコードを返します。
     * 例外的に、選択されている項目が無い場合、{@link RString#EMPTY}を返却します。
     *
     * @return 日付抽出区分(直近・基準日・範囲)のコード. もしくは、 {@link RString#EMPTY}
     */
    RString get日付抽出区分AsCode() {
        HizukeChushutsuKubun kubun = this.get日付抽出区分();
        return kubun == null ? RString.EMPTY : kubun.getコード();
    }

    /**
     * 資格抽出エリア内の表示制御を設定します。
     *
     * @param 資格抽出区分 資格抽出区分
     */
    public void set抽出対象資格状況(RString 資格抽出区分) {
        if (ShikakuChushutsuKubun.両方.getコード().equals(資格抽出区分)) {
            資格抽出区分が両方活性();
        } else if (ShikakuChushutsuKubun.資格取得者のみ.getコード().equals(資格抽出区分)) {
            資格抽出区分が資格取得者のみ活性();
        } else {
            資格抽出区分が両方活性();
        }
    }

    /**
     * 条件を復元するボタンを押下する場合、バッチパラメータの設定値を画面に表示する。
     */
    public void restoreBatchParameter() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnParamRestore().getRestoreBatchParameterMap();
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("komukuFukaMeyi"));
        if (is項目名付加) {
            編集方法.add(new RString("1"));
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("rembanfuka"));
        if (is連番付加) {
            編集方法.add(new RString("2"));
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("hidukeHensyu"));
        if (is日付編集) {
            編集方法.add(new RString("3"));
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        RString 日付抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("hidukeTyuushutuKubun"));
        this.set日付抽出区分FromCode(日付抽出区分);
        RString 基準日区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kijunniKubun"));
        div.getRadKijunbiDateKind().setSelectedKey(基準日区分);
        FlexibleDate 基準日 = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("kijunni"));
        if (基準日 != null && !基準日.isEmpty()) {
            div.getTxtKijunDate().setValue(new RDate(基準日.toString()));
        }
        List<RString> 基準日時点 = new ArrayList<>();
        boolean 基準日時点の受給者を除く = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("kijunNichijiJukyusha"));
        if (基準日時点の受給者を除く) {
            基準日時点.add(new RString("0"));
        }
        div.getChkKijunDateNozoku().setSelectedItemsByKey(基準日時点);
        RString 範囲抽出日区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("rangeChushutsuhiKubun"));
        div.getRadHani().setSelectedKey(範囲抽出日区分);
        FlexibleDate 範囲抽出日From = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("rangeChushutsuhiFrom"));
        if (範囲抽出日From != null && !範囲抽出日From.isEmpty()) {
            div.getTxtChushutsuHani().setFromValue(new RDate(範囲抽出日From.toString()));
        }
        FlexibleDate 範囲抽出日To = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("rangeChushutsuhiTo"));
        if (範囲抽出日To != null && !範囲抽出日To.isEmpty()) {
            div.getTxtChushutsuHani().setToValue(new RDate(範囲抽出日To.toString()));
        }
        List<String> 被保険者情報 = restoreBatchParameterMap.getParameterValue(List.class, new RString("hiHokenshaJyoho"));
        div.getChkHihokenshaJoho().setSelectedItemsByKey(転換(被保険者情報));
        RString 資格抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shikakuChushutsuKubun"));
        div.getRadShikakuJokyo().setSelectedKey(資格抽出区分);
        List<String> 取得事由 = restoreBatchParameterMap.getParameterValue(List.class, new RString("shutokujiyu"));
        div.getChkShutokuJiyu().setSelectedItemsByKey(転換(取得事由));
        List<String> 喪失事由 = restoreBatchParameterMap.getParameterValue(List.class, new RString("soshitsujiyu"));
        div.getChkSoshitsuJiyu().setSelectedItemsByKey(転換(喪失事由));
        宛名抽出条件復元(restoreBatchParameterMap);
        // 改頁出力順ID
//        RString 改頁出力順ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("pageShuturyokujun_Id"));
//        div.getCcdKogakuShutsuryokuKomoku().
        // 出力項目ID
//        RString 出力項目ID = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shutsuryokuKomuku_Id"));
        //        div.getCcdKogakuShutsuryokuKomoku().

    }

    /**
     * 条件を保存するボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter HanyoListHihokenshadaichoBatchParameter
     */
    public HanyoListHihokenshadaichoBatchParameter createBatchParameter() {
        boolean 項目名付加 = false;
        boolean 連番付加 = false;
        boolean 日付編集 = false;
        List<RString> 編集方法List = div.getChkCsvHenshuHoho().getSelectedKeys();
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
        FlexibleDate 基準日 = FlexibleDate.EMPTY;
        FlexibleDate 範囲抽出日From = FlexibleDate.EMPTY;
        FlexibleDate 範囲抽出日To = FlexibleDate.EMPTY;
        if (div.getTxtKijunDate() != null && div.getTxtKijunDate().getValue() != null) {
            基準日 = new FlexibleDate(div.getTxtKijunDate().getValue().toDateString());
        }
        boolean 基準日時点の受給者を除く = false;
        if (div.getChkKijunDateNozoku().isAllSelected()) {
            基準日時点の受給者を除く = true;
        }
        if (div.getTxtChushutsuHani() != null) {
            if (div.getTxtChushutsuHani().getFromValue() != null) {
                範囲抽出日From = new FlexibleDate(div.getTxtChushutsuHani().getFromValue().toDateString());
            }
            if (div.getTxtChushutsuHani().getToValue() != null) {
                範囲抽出日To = new FlexibleDate(div.getTxtChushutsuHani().getToValue().toDateString());
            }
        }
        RString 市町村コード = RString.EMPTY;
        RString 市町村名称 = RString.EMPTY;
        if (div.getCcdHanyoListAtenaSelect().get保険者() != null && div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード() != null
            && !div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().isEmpty()) {
            市町村コード = div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().getColumnValue();
            市町村名称 = div.getCcdHanyoListAtenaSelect().get保険者().get市町村名称();
        }
        AtenaSelectBatchParameter 宛名抽出条件 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件();
        // TODO QA #73393 出力順ID実装方式 回復待ち  2016/01/20まで
//        batchParameter.setPageShuturyokujun_Id(new RString(div.getCcdKogakuShutsuryokujun().get出力順ID().toString()));
        // TODO 出力項目ID
//        batchParameter.setShutsuryokuKomuku_Id(div.getCcdKogakuShutsuryokuKomoku().get出力項目ID());
        return new HanyoListHihokenshadaichoBatchParameter(項目名付加, 連番付加, 日付編集,
                this.get日付抽出区分AsCode(),
                div.getRadKijunbiDateKind().getSelectedKey(), 基準日, 基準日時点の受給者を除く, div.getRadHani().getSelectedKey(),
                範囲抽出日From, 範囲抽出日To, div.getChkHihokenshaJoho().getSelectedKeys(),
                div.getRadShikakuJokyo().getSelectedKey(), div.getChkShutokuJiyu().getSelectedKeys(), div.getChkSoshitsuJiyu().getSelectedKeys(),
                RString.EMPTY, RString.EMPTY, 帳票ID,
                div.getCcdHanyoListAtenaSelect().get年齢層抽出方法().getコード(), nullToEmpty(div.getCcdHanyoListAtenaSelect().get年齢開始()),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get年齢終了()), nullToEmpty(div.getCcdHanyoListAtenaSelect().get生年月日開始()),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get生年月日終了()), 日期(div.getCcdHanyoListAtenaSelect().get年齢基準日()),
                市町村コード, 市町村名称, div.getCcdHanyoListAtenaSelect().get地区().getコード(),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get住所開始()), 宛名抽出条件.getJusho_FromMesho(),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get住所終了()), 宛名抽出条件.getJusho_ToMesho(),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get行政区開始()), 宛名抽出条件.getGyoseiku_FromMesho(),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get行政区終了()), 宛名抽出条件.getGyoseiku_ToMesho(),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区１開始()),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区１終了()),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区２開始()),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区２終了()),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区３開始()),
                nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区３終了()),
                宛名抽出条件.getChiku1_FromMesho(),
                宛名抽出条件.getChiku1_ToMesho(),
                宛名抽出条件.getChiku2_FromMesho(),
                宛名抽出条件.getChiku2_ToMesho(),
                宛名抽出条件.getChiku3_FromMesho(),
                宛名抽出条件.getChiku3_ToMesho());
    }

    private void 日付抽出区分が直近非活性() {
        div.getRadKijunbiDateKind().setDisabled(true);
        div.getTxtKijunDate().setDisabled(true);
        div.getChkKijunDateNozoku().setDisabled(true);
        div.getRadHani().setDisabled(true);
        div.getTxtChushutsuHani().setDisabled(true);
    }

    private void 日付抽出区分が基準日非活性() {
        div.getRadKijunbiDateKind().setDisabled(false);
        div.getTxtKijunDate().setDisabled(false);
        div.getChkKijunDateNozoku().setDisabled(false);
        div.getRadHani().setDisabled(true);
        div.getTxtChushutsuHani().setDisabled(true);
    }

    private void 日付抽出区分が範囲非活性() {
        div.getRadKijunbiDateKind().setDisabled(true);
        div.getTxtKijunDate().setDisabled(true);
        div.getChkKijunDateNozoku().setDisabled(true);
        div.getRadHani().setDisabled(false);
        div.getTxtChushutsuHani().setDisabled(false);
    }

    private void 資格抽出区分が両方活性() {
        div.getChkShutokuJiyu().setDisabled(false);
        div.getChkSoshitsuJiyu().setDisabled(false);
    }

    private void 資格抽出区分が資格取得者のみ活性() {
        div.getChkShutokuJiyu().setDisabled(false);
        div.getChkSoshitsuJiyu().setDisabled(true);
    }

    private RString nullToEmpty(Decimal 項目) {
        if (項目 != null) {
            return new RString(項目.toString());
        }
        return RString.EMPTY;
    }

    private RString nullToEmpty(RDate 項目) {
        if (項目 != null) {
            return 項目.toDateString();
        }
        return RString.EMPTY;
    }

    private FlexibleDate 日期(RDate 項目) {
        if (項目 != null) {
            return new FlexibleDate(項目.toDateString());
        }
        return FlexibleDate.getNowDate();
    }

    private RString nullToEmpty(RString 項目) {
        if (!RString.isNullOrEmpty(項目)) {
            return 項目;
        }
        return RString.EMPTY;
    }

    private List<RString> 転換(List<String> 項目List) {
        List<RString> 転換項目 = new ArrayList<>();
        for (int i = 0; i < 項目List.size(); i++) {
            転換項目.add(new RString(項目List.get(i)));
        }
        return 転換項目;
    }

    private void 宛名抽出条件復元(BatchParameterMap restoreBatchParameterMap) {
        RString 年齢層抽出方法 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChushutsu_Kubun"));
        div.getCcdHanyoListAtenaSelect().set年齢層抽出方法(年齢層抽出方法);
        RString 宛名抽出年齢開始 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChushutsuAge_Start"));
        if (!RString.isNullOrEmpty(宛名抽出年齢開始)) {
            div.getCcdHanyoListAtenaSelect().set年齢開始(new Decimal(宛名抽出年齢開始.toString()));
        }
        RString 宛名抽出年齢終了 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChushutsuAge_End"));
        if (!RString.isNullOrEmpty(宛名抽出年齢終了)) {
            div.getCcdHanyoListAtenaSelect().set年齢終了(new Decimal(宛名抽出年齢終了.toString()));
        }
        RString 宛名抽出生年月日開始 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmSeinengappiYMD_Start"));
        if (!RString.isNullOrEmpty(宛名抽出生年月日開始)) {
            div.getCcdHanyoListAtenaSelect().set生年月日開始(new RDate(宛名抽出生年月日開始.toString()));
        }
        RString 宛名抽出生年月日終了 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmSeinengappiYMD_End"));
        if (!RString.isNullOrEmpty(宛名抽出生年月日終了)) {
            div.getCcdHanyoListAtenaSelect().set生年月日終了(new RDate(宛名抽出生年月日終了.toString()));
        }
        FlexibleDate 年齢基準日 = restoreBatchParameterMap.getParameterValue(FlexibleDate.class, new RString("psmAgeKijunni"));
        if (年齢基準日 != null && !年齢基準日.isEmpty()) {
            div.getCcdHanyoListAtenaSelect().set年齢基準日(new RDate(年齢基準日.toString()));
        }
        div.getCcdHanyoListAtenaSelect().set保険者();
        RString 地区区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChiku_Kubun"));
        div.getCcdHanyoListAtenaSelect().set地区(地区区分);

        RString 町域From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmJusho_From"));
        if (!RString.isNullOrEmpty(町域From)) {
            div.getCcdHanyoListAtenaSelect().set住所開始(new ChoikiCode(町域From));
        }
        RString 町域To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmJusho_To"));
        if (!RString.isNullOrEmpty(町域To)) {
            div.getCcdHanyoListAtenaSelect().set住所終了(new ChoikiCode(町域To));
        }
        RString 行政区From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmGyoseiku_From"));
        if (!RString.isNullOrEmpty(行政区From)) {
            div.getCcdHanyoListAtenaSelect().set行政区開始(new GyoseikuCode(行政区From));
        }
        RString 行政区To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmGyoseiku_To"));
        if (!RString.isNullOrEmpty(行政区To)) {
            div.getCcdHanyoListAtenaSelect().set行政区終了(new GyoseikuCode(行政区To));
        }
        RString 地区１From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChiku1_From"));
        if (!RString.isNullOrEmpty(地区１From)) {
            div.getCcdHanyoListAtenaSelect().set地区１開始(new ChikuCode(地区１From));
        }
        RString 地区１To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChiku1_To"));
        if (!RString.isNullOrEmpty(地区１To)) {
            div.getCcdHanyoListAtenaSelect().set地区１終了(new ChikuCode(地区１To));
        }
        RString 地区２From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChiku2_From"));
        if (!RString.isNullOrEmpty(地区２From)) {
            div.getCcdHanyoListAtenaSelect().set地区２開始(new ChikuCode(地区２From));
        }
        RString 地区２To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChiku2_To"));
        if (!RString.isNullOrEmpty(地区２To)) {
            div.getCcdHanyoListAtenaSelect().set地区２終了(new ChikuCode(地区２To));
        }
        RString 地区３From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChiku3_From"));
        if (!RString.isNullOrEmpty(地区３From)) {
            div.getCcdHanyoListAtenaSelect().set地区３開始(new ChikuCode(地区３From));
        }
        RString 地区３To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChiku3_To"));
        if (!RString.isNullOrEmpty(地区３To)) {
            div.getCcdHanyoListAtenaSelect().set地区３終了(new ChikuCode(地区３To));
        }
    }
}
