/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7010001;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisthihokenshadaicho.HanyoListHihokenshadaichoBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010001.DvHikokenshaDaichoDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト被保険者台帳のクラスです。
 *
 * @reamsid_L DBA-1610-010 linghuhang
 */
public class DvHikokenshaDaichoDivHandler {

    private final DvHikokenshaDaichoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト被保険者台帳パネル
     */
    public DvHikokenshaDaichoDivHandler(DvHikokenshaDaichoDiv div) {
        this.div = div;
    }

    /**
     * 画面を初期化します。
     */
    public void onLoad() {
        日付抽出区分が直近非活性();
        div.getCcdHanyoListAtenaSelect().initialize();
    }

    /**
     * 日付抽出エリア内の表示制御を設定します。
     *
     * @param 日付抽出区分 日付抽出区分
     */
    public void onClick_Chushutsu(RString 日付抽出区分) {
        if (HizukeChushutsuKubun.直近.getコード().equals(日付抽出区分)) {
            日付抽出区分が直近非活性();
        } else if (HizukeChushutsuKubun.基準日.getコード().equals(日付抽出区分)) {
            日付抽出区分が基準日非活性();
        } else {
            日付抽出区分が範囲非活性();
        }
    }

    /**
     * 資格抽出エリア内の表示制御を設定します。
     *
     * @param 資格抽出区分 資格抽出区分
     */
    public void onClick_ChushutsuKijun(RString 資格抽出区分) {
        if (ShikakuChushutsuKubun.両方.getコード().equals(資格抽出区分)) {
            資格抽出区分が両方非活性();
        } else if (ShikakuChushutsuKubun.資格取得者のみ.getコード().equals(資格抽出区分)) {
            資格抽出区分が資格取得者のみ非活性();
        } else {
            資格抽出区分が資格喪失者のみ非活性();
        }
    }

    /**
     * 条件を復元するボタンを押下する場合、バッチパラメータの設定値を画面に表示する。
     */
    public void onClick_btnKogakuParamRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnKogakuParamRestore().getRestoreBatchParameterMap();
        List<RString> 編集方法 = restoreBatchParameterMap.getParameterValue(List.class, new RString("chkCsvHenshuHoho"));
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        RString 日付抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("radChushutsu"));
        div.getRadChushutsu().setSelectedKey(日付抽出区分);
        RString 基準日区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("radKijunbiDate"));
        div.getRadKijunbiDate().setSelectedKey(基準日区分);
        RDate 基準日 = restoreBatchParameterMap.getParameterValue(RDate.class, new RString("txtKijunDate"));
        div.getTxtKijunDate().setValue(基準日);
        boolean 基準日時点の受給者を除く = restoreBatchParameterMap.getParameterValue(boolean.class, new RString("chkKijunDateNozoku"));
        div.getChkKijunDateNozoku().setIsAllSelectable(基準日時点の受給者を除く);
        RString 範囲抽出日区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("radHani"));
        div.getRadHani().setSelectedKey(範囲抽出日区分);
        RDate 範囲抽出日From = restoreBatchParameterMap.getParameterValue(RDate.class, new RString("txtChushutsuHani"));
        div.getTxtChushutsuHani().setFromValue(範囲抽出日From);
        RDate 範囲抽出日To = restoreBatchParameterMap.getParameterValue(RDate.class, new RString("txtChushutsuHani"));
        div.getTxtChushutsuHani().setToValue(範囲抽出日To);
        List<RString> 被保険者情報 = restoreBatchParameterMap.getParameterValue(List.class, new RString("chkHihokenshaJoho"));
        div.getChkHihokenshaJoho().setSelectedItemsByKey(被保険者情報);
        RString 資格抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("radChushutsuKijun"));
        div.getRadChushutsuKijun().setSelectedKey(資格抽出区分);
        List<RString> 取得事由 = restoreBatchParameterMap.getParameterValue(List.class, new RString("chkShutokuJiyu"));
        div.getChkShutokuJiyu().setSelectedItemsByKey(取得事由);
        List<RString> 喪失事由 = restoreBatchParameterMap.getParameterValue(List.class, new RString("chkSoshitsuJiyu"));
        div.getChkSoshitsuJiyu().setSelectedItemsByKey(喪失事由);
        // TODO 宛名抽出条件DIVに項目設定無し、技術点NO.65
        // 改頁出力順ID
        // 出力項目ID
        //        bparam.set改頁出力順ID(new RString(div.getCcdChohyoShutsuryokujun().get出力順ID().toString()));
//        bparam.set出力項目ID(div.getCcdChohyoShutsuryokukoumoku().get出力項目ID());
        // TODO 帳票IDの値が不明、 QA：1112回答まち、
    }

    /**
     * 条件を保存するボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     */
    public void onClick_btnKogakuParamSave() {
        HanyoListHihokenshadaichoBatchParameter batchParameter = new HanyoListHihokenshadaichoBatchParameter();
        set編集方法(batchParameter);
        batchParameter.setHidukeTyuushutuKubun(div.getRadChushutsu().getSelectedKey());
        batchParameter.setKijunniKubun(div.getRadKijunbiDate().getSelectedKey());
        if (div.getTxtKijunDate() != null && div.getTxtKijunDate().getValue() != null) {
            batchParameter.setKijunni(new FlexibleDate(div.getTxtKijunDate().getValue().toDateString()));
        }
        boolean 基準日時点の受給者を除く = false;
        if (div.getChkKijunDateNozoku().isAllSelected()) {
            基準日時点の受給者を除く = true;
        }
        batchParameter.setKijunNichijiJukyusha(基準日時点の受給者を除く);
        batchParameter.setRangeChushutsuhiKubun(div.getRadHani().getSelectedKey());
        if (div.getTxtChushutsuHani() != null) {
            if (div.getTxtChushutsuHani().getFromValue() != null) {
                batchParameter.setRangeChushutsuhiFrom(new FlexibleDate(div.getTxtChushutsuHani().getFromValue().toDateString()));
            }
            if (div.getTxtChushutsuHani().getToValue() != null) {
                batchParameter.setRangeChushutsuhiTo(new FlexibleDate(div.getTxtChushutsuHani().getToValue().toDateString()));
            }
        }
        batchParameter.setHiHokenshaJyoho(div.getChkHihokenshaJoho().getSelectedKeys());
        batchParameter.setShikakuChushutsuKubun(div.getRadChushutsuKijun().getSelectedKey());
        batchParameter.setShutokujiyu(div.getChkShutokuJiyu().getSelectedKeys());
        batchParameter.setSoshitsujiyu(div.getChkSoshitsuJiyu().getSelectedKeys());

        AtenaSelectBatchParameter 宛名抽出条件 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件();

        batchParameter.setPsmChushutsu_Kubun(div.getCcdHanyoListAtenaSelect().get年齢層抽出方法().getコード());
        batchParameter.setPsmChushutsuAge_Start(nullToEmpty(div.getCcdHanyoListAtenaSelect().get年齢開始()));
        batchParameter.setPsmChushutsuAge_End(nullToEmpty(div.getCcdHanyoListAtenaSelect().get年齢終了()));
        batchParameter.setPsmSeinengappiYMD_Start(nullToEmpty(div.getCcdHanyoListAtenaSelect().get生年月日開始()));
        batchParameter.setPsmSeinengappiYMD_End(nullToEmpty(div.getCcdHanyoListAtenaSelect().get生年月日終了()));
        batchParameter.setPsmAgeKijunni(日期(div.getCcdHanyoListAtenaSelect().get年齢基準日()));
        if (div.getCcdHanyoListAtenaSelect().get保険者() != null && div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード() != null
                && !div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().isEmpty()) {
            batchParameter.setShichoson_Code(div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().getColumnValue());
            batchParameter.setShichoson_Name(div.getCcdHanyoListAtenaSelect().get保険者().get市町村名称());
        }
        batchParameter.setPsmChiku_Kubun(div.getCcdHanyoListAtenaSelect().get地区().getコード());
        batchParameter.setPsmJusho_From(nullToEmpty(div.getCcdHanyoListAtenaSelect().get住所開始()));
        batchParameter.setPsmJusho_From_Name(宛名抽出条件.getJusho_FromMesho());
        batchParameter.setPsmJusho_To(nullToEmpty(div.getCcdHanyoListAtenaSelect().get住所終了()));
        batchParameter.setPsmJusho_To_Name(宛名抽出条件.getJusho_ToMesho());
        batchParameter.setPsmGyoseiku_From(nullToEmpty(div.getCcdHanyoListAtenaSelect().get行政区開始()));
        batchParameter.setPsmGyoseiku_From_Name(宛名抽出条件.getGyoseiku_FromMesho());
        batchParameter.setPsmGyoseiku_To(nullToEmpty(div.getCcdHanyoListAtenaSelect().get行政区終了()));
        batchParameter.setPsmGyoseiku_To_Name(宛名抽出条件.getGyoseiku_ToMesho());
        batchParameter.setPsmChiku1_From(nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区１開始()));
        batchParameter.setPsmChiku1_From_Name(宛名抽出条件.getChiku1_FromMesho());
        batchParameter.setPsmChiku1_To(nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区１終了()));
        batchParameter.setPsmChiku1_To_Name(宛名抽出条件.getChiku1_ToMesho());
        batchParameter.setPsmChiku2_From(nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区２開始()));
        batchParameter.setPsmChiku2_From_Name(宛名抽出条件.getChiku2_FromMesho());
        batchParameter.setPsmChiku2_To(nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区２終了()));
        batchParameter.setPsmChiku2_To_Name(宛名抽出条件.getChiku2_ToMesho());
        batchParameter.setPsmChiku3_From(nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区３開始()));
        batchParameter.setPsmChiku3_From_Name(宛名抽出条件.getChiku3_FromMesho());
        batchParameter.setPsmChiku3_To(nullToEmpty(div.getCcdHanyoListAtenaSelect().get地区３終了()));
        batchParameter.setPsmChiku3_To_Name(宛名抽出条件.getChiku3_ToMesho());
        // TODO QA #73393 出力順ID実装方式 回復待ち  2016/01/20まで
//        batchParameter.setPageShuturyokujun_Id(new RString(div.getCcdKogakuShutsuryokujun().get出力順ID().toString()));
        // TODO 出力項目ID
//        batchParameter.setShutsuryokuKomuku_Id(div.getCcdKogakuShutsuryokuKomoku().get出力項目ID());
        batchParameter.setChohyoId(new RString("DBA701001_HanyoListHihokenshaDaicho"));
    }

    private void 日付抽出区分が直近非活性() {
        div.getRadKijunbiDate().setDisabled(true);
        div.getTxtIryokikan().setDisabled(true);
        div.getTxtKijunDate().setDisabled(true);
        div.getChkKijunDateNozoku().setDisabled(true);
        div.getRadHani().setDisabled(true);
        div.getTxtChushutsuHani().setDisabled(true);
    }

    private void 日付抽出区分が基準日非活性() {
        div.getRadKijunbiDate().setDisabled(false);
        div.getTxtIryokikan().setDisabled(false);
        div.getTxtKijunDate().setDisabled(false);
        div.getChkKijunDateNozoku().setDisabled(false);
        div.getRadHani().setDisabled(true);
        div.getTxtChushutsuHani().setDisabled(true);
    }

    private void 日付抽出区分が範囲非活性() {
        div.getRadKijunbiDate().setDisabled(true);
        div.getTxtIryokikan().setDisabled(true);
        div.getTxtKijunDate().setDisabled(true);
        div.getChkKijunDateNozoku().setDisabled(true);
        div.getRadHani().setDisabled(false);
        div.getTxtChushutsuHani().setDisabled(false);
    }

    private void 資格抽出区分が両方非活性() {
        div.getChkShutokuJiyu().setDisabled(false);
        div.getChkSoshitsuJiyu().setDisabled(false);
    }

    private void 資格抽出区分が資格取得者のみ非活性() {
        div.getChkShutokuJiyu().setDisabled(false);
        div.getChkSoshitsuJiyu().setDisabled(true);
    }

    private void 資格抽出区分が資格喪失者のみ非活性() {
        div.getChkShutokuJiyu().setDisabled(true);
        div.getChkSoshitsuJiyu().setDisabled(false);
    }

    private HanyoListHihokenshadaichoBatchParameter set編集方法(HanyoListHihokenshadaichoBatchParameter batchParameter) {
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
        batchParameter.setKomukuFukaMeyi(項目名付加);
        batchParameter.setRembanfuka(連番付加);
        batchParameter.setHidukeHensyu(日付編集);
        return batchParameter;
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
        return FlexibleDate.EMPTY;
    }

    private RString nullToEmpty(RString 項目) {
        if (!RString.isNullOrEmpty(項目)) {
            return 項目;
        }
        return RString.EMPTY;
    }

}
