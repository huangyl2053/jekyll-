/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA7020001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.tekiyojogaisha.JiyuChushutsuKubun;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolistroreifukushinenkinjukyusha.HanyoListRoreiFukushiNenkinJukyushaBatchParameter;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolistseikatsuhogojukyusha.HanyoListSeikatsuhogoJukyushaBatchParameter;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisttashichosonjushochitokureisha.HanyoListTaShichosonJushochiTokureishaBatchParameter;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolisttekiyojogaisha.HanyoListTekiyoJogaishaBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7020001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.common.CSVSettings;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト（資格）のHandlerクラスです。
 *
 * @reamsid_L DBA-1600-010 yaodongsheng
 */
public class HanyoListParamHandler {

    private static final RString 両方 = new RString("0");
    private static final RString 他特例適用者のみ = new RString("1");
    private static final RString 他特例解除者のみ = new RString("2");
    private static final RString 日本人 = new RString("1");
    private static final RString 外国人 = new RString("2");
    private static final RString 施設変更あり = new RString("key0");
    private static final RString 施設変更なし = new RString("key1");
    private static final RString 項目名 = new RString("1");
    private static final RString 連番 = new RString("2");
    private static final RString 日付 = new RString("3");
    private static final RString 適用開始日 = new RString("1");
    private static final RString 適用日 = new RString("1");
    private static final RString 老齢開始日 = new RString("1");
    private static final RString 生活開始日 = new RString("1");
    private static final RString モード2 = new RString("適用除外者");
    private static final RString モード3 = new RString("他市町村住所地特例者");
    private static final RString モード4 = new RString("老齢福祉年金受給者");
    private static final RString モード5 = new RString("生活保護受給者");

    private final HanyoListParamDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト（資格）パネル
     */
    public HanyoListParamHandler(HanyoListParamDiv div) {
        this.div = div;
    }

    /**
     * 画面を初期化します。
     *
     * @param モード 画面のモード
     */
    public void onLoad(RString モード) {
        div.getChushutsuPanel2().getCcdHanyoListAtenaSelect().initialize();
        if (モード.equals(モード2)) {
            div.getRadTekiyoJogaishaChushutsu().setSelectedKey(HizukeChushutsuKubun.直近.getコード());
            div.getRadTekiyoJogaishaTekiyoKijyun().setSelectedKey(適用開始日);
            div.getRadTekiyoJogaishaTekiyoHani().setSelectedKey(適用日);
            div.getRadTekiyoJogaisha().setSelectedKey(両方);
        } else if (モード.equals(モード3)) {
            div.getRadTaShichosonJushotiTokureishaChushutsu().setSelectedKey(HizukeChushutsuKubun.直近.getコード());
            div.getRadTaShichosonJushotiTokureishaTekiyoKijyun().setSelectedKey(適用開始日);
            div.getRadTaShichosonJushotiTokureishaTekiyoHani().setSelectedKey(適用日);
            div.getRadTaShichosonJushotiTokureisha().setSelectedKey(両方);
        } else if (モード.equals(モード4)) {
            div.getRadRoreiFukushiNenkinJukyushaChushutsu().setSelectedKey(HizukeChushutsuKubun.直近.getコード());
            div.getRadRoreiFukushiNenkinJukyushaHani().setSelectedKey(老齢開始日);
        } else if (モード.equals(モード5)) {
            div.getRadSeikatuhogoJukyushaChushutsu().setSelectedKey(HizukeChushutsuKubun.直近.getコード());
            div.getRadSeikatuhogoHani().setSelectedKey(生活開始日);
        }
        set基準日Disable(モード);
        set範囲Disable(モード);
        List<RString> selectKey = new ArrayList<>();
        selectKey.add(項目名);
        selectKey.add(日付);
        div.getCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(selectKey);
    }

    /**
     * 日付抽出区分のonChangeです。
     *
     * @param モード 画面のモード
     */
    public void onChange_日付抽出区分(RString モード) {
        RString 抽出区分 = RString.EMPTY;
        if (モード2.equals(モード)) {
            抽出区分 = div.getRadTekiyoJogaishaChushutsu().getSelectedKey();
        } else if (モード3.equals(モード)) {
            抽出区分 = div.getRadTaShichosonJushotiTokureishaChushutsu().getSelectedKey();
        } else if (モード4.equals(モード)) {
            抽出区分 = div.getRadRoreiFukushiNenkinJukyushaChushutsu().getSelectedKey();
        } else if (モード5.equals(モード)) {
            抽出区分 = div.getRadSeikatuhogoJukyushaChushutsu().getSelectedKey();
        }
        set日付抽出区分(抽出区分, モード);
    }

    /**
     * 適用除外者事由抽出区分のonChangeです。
     */
    public void onChange_適用除外者事由抽出区分() {
        RString 事由抽出区分 = div.getRadTekiyoJogaisha().getSelectedKey();
        set適用除外者事由抽出区分(事由抽出区分);
    }

    /**
     * 他市町村住所地特例者事由抽出区分のonChangeです。
     */
    public void onChange_他市町村住所地特例者事由抽出区分() {
        RString 事由抽出区分 = div.getRadTaShichosonJushotiTokureisha().getSelectedKey();
        set他市町村住所地特例者事由抽出区分(事由抽出区分);

    }

    /**
     * 条件を保存するボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter HanyoListSeikatsuhogoJukyushaBatchParameter
     */
    public HanyoListSeikatsuhogoJukyushaBatchParameter onClick_btnSeikatsuKogakuParamSave() {
        HanyoListSeikatsuhogoJukyushaBatchParameter parameter = new HanyoListSeikatsuhogoJukyushaBatchParameter();
        parameter.setChohyoId(div.getCcdShutsuryokujun().get帳票ID().value());
        parameter.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        parameter.setShutsuryokuKomokuId(div.getCcdShutsuryokuKomoku().get出力項目ID());
        boolean is項目名付加 = false;
        boolean is連番付加 = false;
        boolean is日付編集 = false;
        List<RString> 編集方法List = div.getChkCsvHenshuHoho().getSelectedKeys();
        for (RString 編集方法 : 編集方法List) {
            if (CSVSettings.項目名付加.getコード().equals(編集方法)) {
                is項目名付加 = true;
            } else if (CSVSettings.連番付加.getコード().equals(編集方法)) {
                is連番付加 = true;
            } else if (CSVSettings.日付スラッシュ編集.getコード().equals(編集方法)) {
                is日付編集 = true;
            }
        }
        parameter.setKomokumeiFuka(is項目名付加);
        parameter.setRenbanFuka(is連番付加);
        parameter.setHitsukeHenshu(is日付編集);
        生活抽出条件保存(parameter);
        return parameter;
    }

    /**
     * 条件を保存するボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter HanyoListRoreiFukushiNenkinJukyushaBatchParameter
     */
    public HanyoListRoreiFukushiNenkinJukyushaBatchParameter onClick_btnRoreiKogakuParamSave() {
        HanyoListRoreiFukushiNenkinJukyushaBatchParameter parameter = new HanyoListRoreiFukushiNenkinJukyushaBatchParameter();
        parameter.setChohyoId(div.getCcdShutsuryokujun().get帳票ID().value());
        parameter.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        parameter.setShutsuryokuKomokuId(div.getCcdShutsuryokuKomoku().get出力項目ID());
        boolean is項目名付加 = false;
        boolean is連番付加 = false;
        boolean is日付編集 = false;
        List<RString> 編集方法List = div.getChkCsvHenshuHoho().getSelectedKeys();
        for (RString 編集方法 : 編集方法List) {
            if (CSVSettings.項目名付加.getコード().equals(編集方法)) {
                is項目名付加 = true;
            } else if (CSVSettings.連番付加.getコード().equals(編集方法)) {
                is連番付加 = true;
            } else if (CSVSettings.日付スラッシュ編集.getコード().equals(編集方法)) {
                is日付編集 = true;
            }
        }
        parameter.setKomokumeiFuka(is項目名付加);
        parameter.setRenbanFuka(is連番付加);
        parameter.setHitsukeHenshu(is日付編集);
        老齢抽出条件保存(parameter);
        return parameter;
    }

    /**
     * 条件を保存するボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter HanyoListTaShichosonJushochiTokureishaBatchParameter
     */
    public HanyoListTaShichosonJushochiTokureishaBatchParameter onClick_btnTashichoKogakuParamSave() {
        HanyoListTaShichosonJushochiTokureishaBatchParameter parameter = new HanyoListTaShichosonJushochiTokureishaBatchParameter();
        parameter.setChohyoId(div.getCcdShutsuryokujun().get帳票ID().value());
        parameter.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        parameter.setShutsuryokuKomokuId(div.getCcdShutsuryokuKomoku().get出力項目ID());
        boolean is項目名付加 = false;
        boolean is連番付加 = false;
        boolean is日付編集 = false;
        List<RString> 編集方法List = div.getChkCsvHenshuHoho().getSelectedKeys();
        for (RString 編集方法 : 編集方法List) {
            if (CSVSettings.項目名付加.getコード().equals(編集方法)) {
                is項目名付加 = true;
            } else if (CSVSettings.連番付加.getコード().equals(編集方法)) {
                is連番付加 = true;
            } else if (CSVSettings.日付スラッシュ編集.getコード().equals(編集方法)) {
                is日付編集 = true;
            }
        }
        parameter.setKomokumeiFuka(is項目名付加);
        parameter.setRenbanFuka(is連番付加);
        parameter.setHitsukeHenshu(is日付編集);
        他市町村抽出条件保存(parameter);
        return parameter;
    }

    /**
     * 条件を保存するボタンを押下する場合、画面項目の設定値をバッチパラメータに設定、更新する。
     *
     * @return parameter HanyoListTekiyoJogaishaBatchParameter
     */
    public HanyoListTekiyoJogaishaBatchParameter onClick_btnTekiyoKogakuParamSave() {
        HanyoListTekiyoJogaishaBatchParameter parameter = new HanyoListTekiyoJogaishaBatchParameter();
        parameter.setChohyoId(div.getCcdShutsuryokujun().get帳票ID().value());
        parameter.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        parameter.setShutsuryokuKomokuId(div.getCcdShutsuryokuKomoku().get出力項目ID());
        boolean is項目名付加 = false;
        boolean is連番付加 = false;
        boolean is日付編集 = false;
        List<RString> 編集方法List = div.getChkCsvHenshuHoho().getSelectedKeys();
        for (RString 編集方法 : 編集方法List) {
            if (CSVSettings.項目名付加.getコード().equals(編集方法)) {
                is項目名付加 = true;
            } else if (CSVSettings.連番付加.getコード().equals(編集方法)) {
                is連番付加 = true;
            } else if (CSVSettings.日付スラッシュ編集.getコード().equals(編集方法)) {
                is日付編集 = true;
            }
        }
        parameter.setKomokumeiFuka(is項目名付加);
        parameter.setRenbanFuka(is連番付加);
        parameter.setHitsukeHenshu(is日付編集);
        適用抽出条件保存(parameter);
        return parameter;
    }

    /**
     * 条件を復元するボタンを押下する場合、適用除外者の条件を復元。
     */
    public void onClick_btnTekiyoKogakuParamRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnTekiyoJogaishaParamRestore().getRestoreBatchParameterMap();
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("komokumeiFuka"));
        if (is項目名付加) {
            編集方法.add(項目名);
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("renbanFuka"));
        if (is連番付加) {
            編集方法.add(連番);
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("hitsukeHenshu"));
        if (is日付編集) {
            編集方法.add(日付);
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        適用除外者Restore(restoreBatchParameterMap);
        宛名抽出条件復元(restoreBatchParameterMap);
    }

    /**
     * 条件を復元するボタンを押下する場合、他市町村住所地特例者の条件を復元。
     */
    public void onClick_btnTaShichosonKogakuParamRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnTaShichosonJushochiTokureishaParamRestore().getRestoreBatchParameterMap();
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("komokumeiFuka"));
        if (is項目名付加) {
            編集方法.add(項目名);
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("renbanFuka"));
        if (is連番付加) {
            編集方法.add(連番);
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("hitsukeHenshu"));
        if (is日付編集) {
            編集方法.add(日付);
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        他市町村住所地特例者Restore(restoreBatchParameterMap);
        宛名抽出条件復元(restoreBatchParameterMap);
    }

    /**
     * 条件を復元するボタンを押下する場合、老齢福祉年金受給者の条件を復元。
     */
    public void onClick_btnRoreiKogakuParamRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnRoreiFukushiNenkinJukyushaParamRestore().getRestoreBatchParameterMap();
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("komokumeiFuka"));
        if (is項目名付加) {
            編集方法.add(項目名);
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("renbanFuka"));
        if (is連番付加) {
            編集方法.add(連番);
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("hitsukeHenshu"));
        if (is日付編集) {
            編集方法.add(日付);
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        老齢福祉年金受給者Restore(restoreBatchParameterMap);
        宛名抽出条件復元(restoreBatchParameterMap);
    }

    /**
     * 条件を復元するボタンを押下する場合、生活保護受給者の条件を復元。
     *
     */
    public void onClick_btnSeikatsuKogakuParamRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getBtnSeikatsuhogoJukyushaParamRestore().getRestoreBatchParameterMap();
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("komokumeiFuka"));
        if (is項目名付加) {
            編集方法.add(項目名);
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("renbanFuka"));
        if (is連番付加) {
            編集方法.add(連番);
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("hitsukeHenshu"));
        if (is日付編集) {
            編集方法.add(日付);
        }
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
        生活保護受給者Restore(restoreBatchParameterMap);
        宛名抽出条件復元(restoreBatchParameterMap);
    }

    private void set基準日Disable(RString モード) {
        if (モード.equals(モード2)) {
            div.getRadTekiyoJogaishaTekiyoKijyun().setDisabled(true);
            div.getTexTekiyoJogaishaKijyunDate().setDisabled(true);
        } else if (モード.equals(モード3)) {
            div.getRadTaShichosonJushotiTokureishaTekiyoKijyun().setDisabled(true);
            div.getTexTaShichosonJushotiTokureishaKijyunDate().setDisabled(true);
        } else if (モード.equals(モード4)) {
            div.getTexRoreiFukushiNenkinJukyushaKijyunDate().setDisabled(true);
        } else if (モード.equals(モード5)) {
            div.getTexSeikatuhogoKijunDate().setDisabled(true);
        }
    }

    private void set範囲Disable(RString モード) {
        if (モード.equals(モード2)) {
            div.getRadTekiyoJogaishaTekiyoHani().setDisabled(true);
            div.getTexTekiyoJogaishaTekiyoDateHani().setDisabled(true);
        } else if (モード.equals(モード3)) {
            div.getRadTaShichosonJushotiTokureishaTekiyoHani().setDisabled(true);
            div.getTexTaShichosonJushotiTokureishaTekiyoDateHani().setDisabled(true);
        } else if (モード.equals(モード4)) {
            div.getRadRoreiFukushiNenkinJukyushaHani().setDisabled(true);
            div.getTexRoreiFukushiNenkinJukyushaDateHani().setDisabled(true);
        } else if (モード.equals(モード5)) {
            div.getRadSeikatuhogoHani().setDisabled(true);
            div.getTexSeikatuhogoDateHani().setDisabled(true);
        }
    }

    private void set基準日unDisable(RString モード) {
        if (モード.equals(モード2)) {
            div.getRadTekiyoJogaishaTekiyoKijyun().setDisabled(false);
            div.getTexTekiyoJogaishaKijyunDate().setDisabled(false);
        } else if (モード.equals(モード3)) {
            div.getRadTaShichosonJushotiTokureishaTekiyoKijyun().setDisabled(false);
            div.getTexTaShichosonJushotiTokureishaKijyunDate().setDisabled(false);
        } else if (モード.equals(モード4)) {
            div.getTexRoreiFukushiNenkinJukyushaKijyunDate().setDisabled(false);
        } else if (モード.equals(モード5)) {
            div.getTexSeikatuhogoKijunDate().setDisabled(false);
        }
    }

    private void set範囲unDisable(RString モード) {
        if (モード.equals(モード2)) {
            div.getRadTekiyoJogaishaTekiyoHani().setDisabled(false);
            div.getTexTekiyoJogaishaTekiyoDateHani().setDisabled(false);
        } else if (モード.equals(モード3)) {
            div.getRadTaShichosonJushotiTokureishaTekiyoHani().setDisabled(false);
            div.getTexTaShichosonJushotiTokureishaTekiyoDateHani().setDisabled(false);
        } else if (モード.equals(モード4)) {
            div.getRadRoreiFukushiNenkinJukyushaHani().setDisabled(false);
            div.getTexRoreiFukushiNenkinJukyushaDateHani().setDisabled(false);
        } else if (モード.equals(モード5)) {
            div.getRadSeikatuhogoHani().setDisabled(false);
            div.getTexSeikatuhogoDateHani().setDisabled(false);
        }
    }

    private void 生活抽出条件保存(HanyoListSeikatsuhogoJukyushaBatchParameter parameter) {
        生活保護受給者保存(parameter);
        RString 市町村コード = RString.EMPTY;
        RString 市町村名称 = RString.EMPTY;
        if (div.getCcdHanyoListAtenaSelect().get保険者() != null && div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード() != null
                && !div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().isEmpty()) {
            市町村コード = div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().getColumnValue();
            市町村名称 = div.getCcdHanyoListAtenaSelect().get保険者().get市町村名称();
        }
        parameter.setShichoson_Code(市町村コード);
        parameter.setShichoson_Name(市町村名称);
        AtenaSelectBatchParameter 宛名抽出条件 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件();
        parameter.setPsmChushutsu_Kubun(宛名抽出条件.getAgeSelectKijun().getコード());
        parameter.setPsmChushutsuAge_Start(宛名抽出条件.getNenreiRange().getFrom());
        parameter.setPsmChushutsuAge_End(宛名抽出条件.getNenreiRange().getTo());
        parameter.setPsmSeinengappiYMD_Start(宛名抽出条件.getSeinengappiRange().getFrom());
        parameter.setPsmSeinengappiYMD_End(宛名抽出条件.getSeinengappiRange().getTo());
        parameter.setPsmAgeKijunni(宛名抽出条件.getNenreiKijunbi());
        parameter.setPsmChiku_Kubun(宛名抽出条件.getChiku_Kubun().getコード());
        parameter.setPsmJusho_From(宛名抽出条件.getJusho_From());
        parameter.setPsmJusho_From_Name(宛名抽出条件.getJusho_FromMesho());
        parameter.setPsmJusho_To(宛名抽出条件.getJusho_To());
        parameter.setPsmJusho_To_Name(宛名抽出条件.getJusho_ToMesho());
        parameter.setPsmGyoseiku_From(宛名抽出条件.getGyoseiku_From());
        parameter.setPsmGyoseiku_From_Name(宛名抽出条件.getGyoseiku_FromMesho());
        parameter.setPsmGyoseiku_To(宛名抽出条件.getGyoseiku_To());
        parameter.setPsmGyoseiku_To_Name(宛名抽出条件.getGyoseiku_ToMesho());
        parameter.setPsmChiku1_From(宛名抽出条件.getChiku1_From());
        parameter.setPsmChiku1_To(宛名抽出条件.getChiku1_To());
        parameter.setPsmChiku2_From(宛名抽出条件.getChiku2_From());
        parameter.setPsmChiku2_To(宛名抽出条件.getChiku2_To());
        parameter.setPsmChiku3_From(宛名抽出条件.getChiku3_From());
        parameter.setPsmChiku3_To(宛名抽出条件.getChiku3_To());
        parameter.setPsmChiku1_From_Name(宛名抽出条件.getChiku1_FromMesho());
        parameter.setPsmChiku1_To_Name(宛名抽出条件.getChiku1_ToMesho());
        parameter.setPsmChiku2_From_Name(宛名抽出条件.getChiku2_FromMesho());
        parameter.setPsmChiku2_To_Name(宛名抽出条件.getChiku2_ToMesho());
        parameter.setPsmChiku3_From_Name(宛名抽出条件.getChiku3_FromMesho());
        parameter.setPsmChiku3_To_Name(宛名抽出条件.getChiku3_ToMesho());
    }

    private void 老齢抽出条件保存(HanyoListRoreiFukushiNenkinJukyushaBatchParameter parameter) {
        老齢福祉年金受給者保存(parameter);
        RString 市町村コード = RString.EMPTY;
        RString 市町村名称 = RString.EMPTY;
        if (div.getCcdHanyoListAtenaSelect().get保険者() != null && div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード() != null
                && !div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().isEmpty()) {
            市町村コード = div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().getColumnValue();
            市町村名称 = div.getCcdHanyoListAtenaSelect().get保険者().get市町村名称();
        }
        parameter.setShichoson_Code(市町村コード);
        parameter.setShichoson_Name(市町村名称);
        AtenaSelectBatchParameter 宛名抽出条件 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件();
        parameter.setPsmChushutsu_Kubun(宛名抽出条件.getAgeSelectKijun().getコード());
        parameter.setPsmChushutsuAge_Start(宛名抽出条件.getNenreiRange().getFrom());
        parameter.setPsmChushutsuAge_End(宛名抽出条件.getNenreiRange().getTo());
        parameter.setPsmSeinengappiYMD_Start(宛名抽出条件.getSeinengappiRange().getFrom());
        parameter.setPsmSeinengappiYMD_End(宛名抽出条件.getSeinengappiRange().getTo());
        parameter.setPsmAgeKijunni(宛名抽出条件.getNenreiKijunbi());
        parameter.setPsmChiku_Kubun(宛名抽出条件.getChiku_Kubun().getコード());
        parameter.setPsmJusho_From(宛名抽出条件.getJusho_From());
        parameter.setPsmJusho_From_Name(宛名抽出条件.getJusho_FromMesho());
        parameter.setPsmJusho_To(宛名抽出条件.getJusho_To());
        parameter.setPsmJusho_To_Name(宛名抽出条件.getJusho_ToMesho());
        parameter.setPsmGyoseiku_From(宛名抽出条件.getGyoseiku_From());
        parameter.setPsmGyoseiku_From_Name(宛名抽出条件.getGyoseiku_FromMesho());
        parameter.setPsmGyoseiku_To(宛名抽出条件.getGyoseiku_To());
        parameter.setPsmGyoseiku_To_Name(宛名抽出条件.getGyoseiku_ToMesho());
        parameter.setPsmChiku1_From(宛名抽出条件.getChiku1_From());
        parameter.setPsmChiku1_To(宛名抽出条件.getChiku1_To());
        parameter.setPsmChiku2_From(宛名抽出条件.getChiku2_From());
        parameter.setPsmChiku2_To(宛名抽出条件.getChiku2_To());
        parameter.setPsmChiku3_From(宛名抽出条件.getChiku3_From());
        parameter.setPsmChiku3_To(宛名抽出条件.getChiku3_To());
        parameter.setPsmChiku1_From_Name(宛名抽出条件.getChiku1_FromMesho());
        parameter.setPsmChiku1_To_Name(宛名抽出条件.getChiku1_ToMesho());
        parameter.setPsmChiku2_From_Name(宛名抽出条件.getChiku2_FromMesho());
        parameter.setPsmChiku2_To_Name(宛名抽出条件.getChiku2_ToMesho());
        parameter.setPsmChiku3_From_Name(宛名抽出条件.getChiku3_FromMesho());
        parameter.setPsmChiku3_To_Name(宛名抽出条件.getChiku3_ToMesho());
    }

    private void 他市町村抽出条件保存(HanyoListTaShichosonJushochiTokureishaBatchParameter parameter) {
        他市町村住所地特例者保存(parameter);
        RString 市町村コード = RString.EMPTY;
        RString 市町村名称 = RString.EMPTY;
        if (div.getCcdHanyoListAtenaSelect().get保険者() != null && div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード() != null
                && !div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().isEmpty()) {
            市町村コード = div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().getColumnValue();
            市町村名称 = div.getCcdHanyoListAtenaSelect().get保険者().get市町村名称();
        }
        parameter.setShichoson_Code(市町村コード);
        parameter.setShichoson_Name(市町村名称);
        AtenaSelectBatchParameter 宛名抽出条件 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件();
        parameter.setPsmChushutsu_Kubun(宛名抽出条件.getAgeSelectKijun().getコード());
        parameter.setPsmChushutsuAge_Start(宛名抽出条件.getNenreiRange().getFrom());
        parameter.setPsmChushutsuAge_End(宛名抽出条件.getNenreiRange().getTo());
        parameter.setPsmSeinengappiYMD_Start(宛名抽出条件.getSeinengappiRange().getFrom());
        parameter.setPsmSeinengappiYMD_End(宛名抽出条件.getSeinengappiRange().getTo());
        parameter.setPsmAgeKijunni(宛名抽出条件.getNenreiKijunbi());
        parameter.setPsmChiku_Kubun(宛名抽出条件.getChiku_Kubun().getコード());
        parameter.setPsmJusho_From(宛名抽出条件.getJusho_From());
        parameter.setPsmJusho_From_Name(宛名抽出条件.getJusho_FromMesho());
        parameter.setPsmJusho_To(宛名抽出条件.getJusho_To());
        parameter.setPsmJusho_To_Name(宛名抽出条件.getJusho_ToMesho());
        parameter.setPsmGyoseiku_From(宛名抽出条件.getGyoseiku_From());
        parameter.setPsmGyoseiku_From_Name(宛名抽出条件.getGyoseiku_FromMesho());
        parameter.setPsmGyoseiku_To(宛名抽出条件.getGyoseiku_To());
        parameter.setPsmGyoseiku_To_Name(宛名抽出条件.getGyoseiku_ToMesho());
        parameter.setPsmChiku1_From(宛名抽出条件.getChiku1_From());
        parameter.setPsmChiku1_To(宛名抽出条件.getChiku1_To());
        parameter.setPsmChiku2_From(宛名抽出条件.getChiku2_From());
        parameter.setPsmChiku2_To(宛名抽出条件.getChiku2_To());
        parameter.setPsmChiku3_From(宛名抽出条件.getChiku3_From());
        parameter.setPsmChiku3_To(宛名抽出条件.getChiku3_To());
        parameter.setPsmChiku1_From_Name(宛名抽出条件.getChiku1_FromMesho());
        parameter.setPsmChiku1_To_Name(宛名抽出条件.getChiku1_ToMesho());
        parameter.setPsmChiku2_From_Name(宛名抽出条件.getChiku2_FromMesho());
        parameter.setPsmChiku2_To_Name(宛名抽出条件.getChiku2_ToMesho());
        parameter.setPsmChiku3_From_Name(宛名抽出条件.getChiku3_FromMesho());
        parameter.setPsmChiku3_To_Name(宛名抽出条件.getChiku3_ToMesho());
    }

    private void 適用抽出条件保存(HanyoListTekiyoJogaishaBatchParameter parameter) {
        適用除外者保存(parameter);
        RString 市町村コード = RString.EMPTY;
        RString 市町村名称 = RString.EMPTY;
        if (div.getCcdHanyoListAtenaSelect().get保険者() != null && div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード() != null
                && !div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().isEmpty()) {
            市町村コード = div.getCcdHanyoListAtenaSelect().get保険者().get市町村コード().getColumnValue();
            市町村名称 = div.getCcdHanyoListAtenaSelect().get保険者().get市町村名称();
        }
        parameter.setShichoson_Code(市町村コード);
        parameter.setShichoson_Name(市町村名称);
        AtenaSelectBatchParameter 宛名抽出条件 = div.getCcdHanyoListAtenaSelect().get宛名抽出条件();
        parameter.setPsmChushutsu_Kubun(宛名抽出条件.getAgeSelectKijun().getコード());
        parameter.setPsmChushutsuAge_Start(宛名抽出条件.getNenreiRange().getFrom());
        parameter.setPsmChushutsuAge_End(宛名抽出条件.getNenreiRange().getTo());
        parameter.setPsmSeinengappiYMD_Start(宛名抽出条件.getSeinengappiRange().getFrom());
        parameter.setPsmSeinengappiYMD_End(宛名抽出条件.getSeinengappiRange().getTo());
        parameter.setPsmAgeKijunni(宛名抽出条件.getNenreiKijunbi());
        parameter.setPsmChiku_Kubun(宛名抽出条件.getChiku_Kubun().getコード());
        parameter.setPsmJusho_From(宛名抽出条件.getJusho_From());
        parameter.setPsmJusho_From_Name(宛名抽出条件.getJusho_FromMesho());
        parameter.setPsmJusho_To(宛名抽出条件.getJusho_To());
        parameter.setPsmJusho_To_Name(宛名抽出条件.getJusho_ToMesho());
        parameter.setPsmGyoseiku_From(宛名抽出条件.getGyoseiku_From());
        parameter.setPsmGyoseiku_From_Name(宛名抽出条件.getGyoseiku_FromMesho());
        parameter.setPsmGyoseiku_To(宛名抽出条件.getGyoseiku_To());
        parameter.setPsmGyoseiku_To_Name(宛名抽出条件.getGyoseiku_ToMesho());
        parameter.setPsmChiku1_From(宛名抽出条件.getChiku1_From());
        parameter.setPsmChiku1_To(宛名抽出条件.getChiku1_To());
        parameter.setPsmChiku2_From(宛名抽出条件.getChiku2_From());
        parameter.setPsmChiku2_To(宛名抽出条件.getChiku2_To());
        parameter.setPsmChiku3_From(宛名抽出条件.getChiku3_From());
        parameter.setPsmChiku3_To(宛名抽出条件.getChiku3_To());
        parameter.setPsmChiku1_From_Name(宛名抽出条件.getChiku1_FromMesho());
        parameter.setPsmChiku1_To_Name(宛名抽出条件.getChiku1_ToMesho());
        parameter.setPsmChiku2_From_Name(宛名抽出条件.getChiku2_FromMesho());
        parameter.setPsmChiku2_To_Name(宛名抽出条件.getChiku2_ToMesho());
        parameter.setPsmChiku3_From_Name(宛名抽出条件.getChiku3_FromMesho());
        parameter.setPsmChiku3_To_Name(宛名抽出条件.getChiku3_ToMesho());
    }

    private void 適用除外者保存(HanyoListTekiyoJogaishaBatchParameter parameter) {
        parameter.setHitsukeChushutsuKubun(div.getRadTekiyoJogaishaChushutsu().getSelectedKey());
        parameter.setKijunYMDkubun(div.getRadTekiyoJogaishaTekiyoKijyun().getSelectedKey());
        if (div.getTexTekiyoJogaishaKijyunDate().getValue() != null) {
            parameter.setKijunYMD(div.getTexTekiyoJogaishaKijyunDate().getValue().toDateString());
        }
        parameter.setChushutsunichiKubun(div.getRadTekiyoJogaishaTekiyoHani().getSelectedKey());
        if (div.getTexTekiyoJogaishaTekiyoDateHani().getFromValue() != null) {
            parameter.setChushutsunichiFrom(div.getTexTekiyoJogaishaTekiyoDateHani().getFromValue().toDateString());
        }
        if (div.getTexTekiyoJogaishaTekiyoDateHani().getToValue() != null) {
            parameter.setChushutsunichiTo(div.getTexTekiyoJogaishaTekiyoDateHani().getToValue().toDateString());
        }
        boolean 日本人情報 = false;
        boolean 外国人情報 = false;
        for (RString key : div.getChkTekiyoJogaishaJoho().getSelectedKeys()) {
            if (日本人.equals(key)) {
                日本人情報 = true;
            } else if (外国人.equals(key)) {
                外国人情報 = true;
            }
        }
        parameter.setJukyushaJoho_Nihonjin(日本人情報);
        parameter.setJukyushaJoho_Gaikokujin(外国人情報);
        parameter.setJyuChusyutsuKubun(div.getRadTekiyoJogaisha().getSelectedKey());
        parameter.setDekyujyu(div.getChkTekiyoJogaishaTekiyoJiyu().getSelectedKeys());
        parameter.setKaijyojyu(div.getChkTekiyoJogaishaKaijoJiyu().getSelectedKeys());
        boolean 施設変更あり区分 = false;
        boolean 施設変更なし区分 = false;
        for (RString key : div.getChkTekiyoJogaishaShisetsuHenko().getSelectedKeys()) {
            if (施設変更あり.equals(key)) {
                施設変更あり区分 = true;
            } else if (施設変更なし.equals(key)) {
                施設変更なし区分 = true;
            }
        }
        parameter.setShisetsuHenkoari(施設変更あり区分);
        parameter.setShisetsuHenkonashi(施設変更なし区分);
    }

    private void 他市町村住所地特例者保存(HanyoListTaShichosonJushochiTokureishaBatchParameter parameter) {
        parameter.setHitsukeChushutsuKubun(div.getRadTaShichosonJushotiTokureishaChushutsu().getSelectedKey());
        parameter.setKijunYMDkubun(div.getRadTaShichosonJushotiTokureishaTekiyoKijyun().getSelectedKey());
        if (div.getTexTaShichosonJushotiTokureishaKijyunDate().getValue() != null) {
            parameter.setKijunYMD(div.getTexTaShichosonJushotiTokureishaKijyunDate().getValue().toDateString());
        }
        parameter.setChushutsunichiKubun(div.getRadTaShichosonJushotiTokureishaTekiyoHani().getSelectedKey());
        if (div.getTexTaShichosonJushotiTokureishaTekiyoDateHani().getFromValue() != null) {
            parameter.setChushutsunichiFrom(div.getTexTaShichosonJushotiTokureishaTekiyoDateHani().getFromValue().toDateString());
        }
        if (div.getTexTaShichosonJushotiTokureishaTekiyoDateHani().getToValue() != null) {
            parameter.setChushutsunichiTo(div.getTexTaShichosonJushotiTokureishaTekiyoDateHani().getToValue().toDateString());
        }
        boolean 日本人情報 = false;
        boolean 外国人情報 = false;
        for (RString key : div.getChkTaShichosonJushotiTokureishaJoho().getSelectedKeys()) {
            if (日本人.equals(key)) {
                日本人情報 = true;
            } else if (外国人.equals(key)) {
                外国人情報 = true;
            }
        }
        parameter.setJukyushaJoho_Nihonjin(日本人情報);
        parameter.setJukyushaJoho_Gaikokujin(外国人情報);
        parameter.setJyuChusyutsuKubun(div.getRadTaShichosonJushotiTokureisha().getSelectedKey());
        parameter.setDekyujyu(div.getChkTaShichosonJushotiTokureishaTekiyoJiyu().getSelectedKeys());
        parameter.setKaijyojyu(div.getChkTaShichosonJushotiTokureishaKaijoJiyu().getSelectedKeys());
        boolean 施設変更あり区分 = false;
        boolean 施設変更なし区分 = false;
        for (RString key : div.getChkTaShichosonJushotiTokureishaShisetsuHenko().getSelectedKeys()) {
            if (施設変更あり.equals(key)) {
                施設変更あり区分 = true;
            } else if (施設変更なし.equals(key)) {
                施設変更なし区分 = true;
            }
        }
        parameter.setShisetsuHenkoari(施設変更あり区分);
        parameter.setShisetsuHenkonashi(施設変更なし区分);
    }

    private void 老齢福祉年金受給者保存(HanyoListRoreiFukushiNenkinJukyushaBatchParameter parameter) {
        parameter.setHitsukeChushutsuKubun(div.getRadRoreiFukushiNenkinJukyushaChushutsu().getSelectedKey());
        if (div.getTexRoreiFukushiNenkinJukyushaKijyunDate().getValue() != null) {
            parameter.setKijunYMD(div.getTexRoreiFukushiNenkinJukyushaKijyunDate().getValue().toDateString());
        }
        parameter.setChushutsunichiKubun(div.getRadRoreiFukushiNenkinJukyushaHani().getSelectedKey());
        if (div.getTexRoreiFukushiNenkinJukyushaDateHani().getFromValue() != null) {
            parameter.setChushutsunichiFrom(div.getTexRoreiFukushiNenkinJukyushaDateHani().getFromValue().toDateString());
        }
        if (div.getTexRoreiFukushiNenkinJukyushaDateHani().getToValue() != null) {
            parameter.setChushutsunichiTo(div.getTexRoreiFukushiNenkinJukyushaDateHani().getToValue().toDateString());
        }
    }

    private void 生活保護受給者保存(HanyoListSeikatsuhogoJukyushaBatchParameter parameter) {
        parameter.setHitsukeChushutsuKubun(div.getRadSeikatuhogoJukyushaChushutsu().getSelectedKey());
        if (div.getTexSeikatuhogoKijunDate().getValue() != null) {
            parameter.setKijunYMD(div.getTexSeikatuhogoKijunDate().getValue().toDateString());
        }
        parameter.setChushutsunichiKubun(div.getRadSeikatuhogoHani().getSelectedKey());
        if (div.getTexSeikatuhogoDateHani().getFromValue() != null) {
            parameter.setChushutsunichiFrom(div.getTexSeikatuhogoDateHani().getFromValue().toDateString());
        }
        if (div.getTexSeikatuhogoDateHani().getToValue() != null) {
            parameter.setChushutsunichiTo(div.getTexSeikatuhogoDateHani().getToValue().toDateString());
        }
        boolean 日本人情報 = false;
        boolean 外国人情報 = false;
        for (RString key : div.getChkSeikatsuHogoJukyushaJoho().getSelectedKeys()) {
            if (日本人.equals(key)) {
                日本人情報 = true;
            } else if (外国人.equals(key)) {
                外国人情報 = true;
            }
        }
        parameter.setJukyushaJoho_Nihonjin(日本人情報);
        parameter.setJukyushaJoho_Gaikokujin(外国人情報);
        parameter.setFujoShurui(div.getChkSeikatsuHogo().getSelectedKeys());
    }

    private void 適用除外者Restore(BatchParameterMap restoreBatchParameterMap) {
        RString 抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("hitsukeChushutsuKubun"));
        set日付抽出区分(抽出区分, モード2);
        div.getRadTekiyoJogaishaChushutsu().setSelectedKey(抽出区分);
        div.getRadTekiyoJogaishaTekiyoKijyun().setSelectedKey(
                restoreBatchParameterMap.getParameterValue(RString.class, new RString("kijunYMDkubun")));
        RString 基準年月日 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kijunYMD"));
        if (!RString.isNullOrEmpty(基準年月日)) {
            div.getTexTekiyoJogaishaKijyunDate().setValue(new RDate(基準年月日.toString()));
        }
        div.getRadTekiyoJogaishaTekiyoHani().setSelectedKey(
                restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiKubun")));
        RString 範囲抽出日From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiFrom"));
        if (!RString.isNullOrEmpty(範囲抽出日From)) {
            div.getTexTekiyoJogaishaTekiyoDateHani().setFromValue(new RDate(範囲抽出日From.toString()));
        }
        RString 範囲抽出日To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiTo"));
        if (!RString.isNullOrEmpty(範囲抽出日To)) {
            div.getTexTekiyoJogaishaTekiyoDateHani().setToValue(new RDate(範囲抽出日To.toString()));
        }
        List<RString> selectKey = new ArrayList<>();
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("jukyushaJoho_Nihonjin"))) {
            selectKey.add(日本人);
        }
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("jukyushaJoho_Gaikokujin"))) {
            selectKey.add(外国人);
        }
        div.getChkTekiyoJogaishaJoho().setSelectedItemsByKey(selectKey);
        RString 事由抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("jyuChusyutsuKubun"));
        div.getRadTekiyoJogaisha().setSelectedKey(事由抽出区分);
        set適用除外者事由抽出区分(事由抽出区分);
        List<RString> dekyujyuItem = new ArrayList<>();
        for (Object dekyujyu : restoreBatchParameterMap.getParameterValue(List.class, new RString("dekyujyu"))) {
            dekyujyuItem.add(new RString(dekyujyu.toString()));
        }
        div.getChkTekiyoJogaishaTekiyoJiyu().setSelectedItemsByKey(dekyujyuItem);
        List<RString> kaijyojyuItem = new ArrayList<>();
        for (Object kaijyojyu : restoreBatchParameterMap.getParameterValue(List.class, new RString("kaijyojyu"))) {
            kaijyojyuItem.add(new RString(kaijyojyu.toString()));
        }
        div.getChkTekiyoJogaishaKaijoJiyu().setSelectedItemsByKey(kaijyojyuItem);
        List<RString> 施設変更 = new ArrayList<>();
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("shisetsuHenkoari"))) {
            施設変更.add(施設変更あり);
        }
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("shisetsuHenkonashi"))) {
            施設変更.add(施設変更なし);
        }
        div.getChkTekiyoJogaishaShisetsuHenko().setSelectedItemsByKey(施設変更);
    }

    private void 他市町村住所地特例者Restore(BatchParameterMap restoreBatchParameterMap) {
        RString 抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("hitsukeChushutsuKubun"));
        set日付抽出区分(抽出区分, モード3);
        div.getRadTaShichosonJushotiTokureishaChushutsu().setSelectedKey(抽出区分);
        div.getRadTaShichosonJushotiTokureishaTekiyoKijyun().setSelectedKey(
                restoreBatchParameterMap.getParameterValue(RString.class, new RString("kijunYMDkubun")));
        RString 基準年月日 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kijunYMD"));
        if (!RString.isNullOrEmpty(基準年月日)) {
            div.getTexTaShichosonJushotiTokureishaKijyunDate().setValue(new RDate(基準年月日.toString()));
        }
        div.getRadTaShichosonJushotiTokureishaTekiyoHani().setSelectedKey(
                restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiKubun")));
        RString 範囲抽出日From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiFrom"));
        if (!RString.isNullOrEmpty(範囲抽出日From)) {
            div.getTexTaShichosonJushotiTokureishaTekiyoDateHani().setFromValue(new RDate(範囲抽出日From.toString()));
        }
        RString 範囲抽出日To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiTo"));
        if (!RString.isNullOrEmpty(範囲抽出日To)) {
            div.getTexTaShichosonJushotiTokureishaTekiyoDateHani().setToValue(new RDate(範囲抽出日To.toString()));
        }
        List<RString> selectKey = new ArrayList<>();
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("jukyushaJoho_Nihonjin"))) {
            selectKey.add(日本人);
        }
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("jukyushaJoho_Gaikokujin"))) {
            selectKey.add(外国人);
        }
        div.getChkTaShichosonJushotiTokureishaJoho().setSelectedItemsByKey(selectKey);
        RString 事由抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("jyuChusyutsuKubun"));
        div.getRadTaShichosonJushotiTokureisha().setSelectedKey(事由抽出区分);
        set他市町村住所地特例者事由抽出区分(事由抽出区分);
        List<RString> dekyujyuItem = new ArrayList<>();
        for (Object dekyujyu : restoreBatchParameterMap.getParameterValue(List.class, new RString("dekyujyu"))) {
            dekyujyuItem.add(new RString(dekyujyu.toString()));
        }
        div.getChkTaShichosonJushotiTokureishaTekiyoJiyu().setSelectedItemsByKey(dekyujyuItem);
        List<RString> kaijyojyuItem = new ArrayList<>();
        for (Object kaijyojyu : restoreBatchParameterMap.getParameterValue(List.class, new RString("kaijyojyu"))) {
            kaijyojyuItem.add(new RString(kaijyojyu.toString()));
        }
        div.getChkTaShichosonJushotiTokureishaKaijoJiyu().setSelectedItemsByKey(kaijyojyuItem);
        List<RString> 施設変更 = new ArrayList<>();
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("shisetsuHenkoari"))) {
            施設変更.add(施設変更あり);
        }
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("shisetsuHenkonashi"))) {
            施設変更.add(施設変更なし);
        }
        div.getChkTaShichosonJushotiTokureishaShisetsuHenko().setSelectedItemsByKey(施設変更);
    }

    private void 老齢福祉年金受給者Restore(BatchParameterMap restoreBatchParameterMap) {
        RString 抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("hitsukeChushutsuKubun"));
        set日付抽出区分(抽出区分, モード4);
        div.getRadRoreiFukushiNenkinJukyushaChushutsu().setSelectedKey(抽出区分);
        RString 日付抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("hitsukeChushutsuKubun"));
        if (!RString.isNullOrEmpty(日付抽出区分)) {
            div.getTexRoreiFukushiNenkinJukyushaKijyunDate().setValue(new RDate(日付抽出区分.toString()));
        }
        div.getRadRoreiFukushiNenkinJukyushaHani().setSelectedKey(
                restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiKubun")));
        RString 範囲抽出日From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiFrom"));
        if (!RString.isNullOrEmpty(範囲抽出日From)) {
            div.getTexRoreiFukushiNenkinJukyushaDateHani().setFromValue(new RDate(範囲抽出日From.toString()));
        }
        RString 範囲抽出日To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiTo"));
        if (!RString.isNullOrEmpty(範囲抽出日To)) {
            div.getTexRoreiFukushiNenkinJukyushaDateHani().setToValue(new RDate(範囲抽出日To.toString()));
        }
    }

    private void 生活保護受給者Restore(BatchParameterMap restoreBatchParameterMap) {
        RString 抽出区分 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("hitsukeChushutsuKubun"));
        set日付抽出区分(抽出区分, モード5);
        div.getRadSeikatuhogoJukyushaChushutsu().setSelectedKey(抽出区分);
        RString 基準年月日 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("kijunYMD"));
        if (!RString.isNullOrEmpty(基準年月日)) {
            div.getTexSeikatuhogoKijunDate().setValue(new RDate(基準年月日.toString()));
        }
        div.getRadSeikatuhogoHani().setSelectedKey(restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiKubun")));
        RString 範囲抽出日From = restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiFrom"));
        if (!RString.isNullOrEmpty(範囲抽出日From)) {
            div.getTexSeikatuhogoDateHani().setFromValue(new RDate(範囲抽出日From.toString()));
        }
        RString 範囲抽出日To = restoreBatchParameterMap.getParameterValue(RString.class, new RString("chushutsunichiTo"));
        if (!RString.isNullOrEmpty(範囲抽出日To)) {
            div.getTexSeikatuhogoDateHani().setToValue(new RDate(範囲抽出日To.toString()));
        }

        List<RString> selectKey = new ArrayList<>();
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("jukyushaJoho_Nihonjin"))) {
            selectKey.add(日本人);
        }
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("jukyushaJoho_Gaikokujin"))) {
            selectKey.add(外国人);
        }
        div.getChkSeikatsuHogoJukyushaJoho().setSelectedItemsByKey(selectKey);
        List<RString> fujoShuruiItem = new ArrayList<>();
        for (Object fujoShurui : restoreBatchParameterMap.getParameterValue(List.class, new RString("fujoShurui"))) {
            fujoShuruiItem.add(new RString(fujoShurui.toString()));
        }
        div.getChkSeikatsuHogo().setSelectedItemsByKey(fujoShuruiItem);
    }

    private void set日付抽出区分(RString 抽出区分, RString モード) {
        if (HizukeChushutsuKubun.直近.getコード().equals(抽出区分)) {
            set基準日Disable(モード);
            set範囲Disable(モード);
        } else if (HizukeChushutsuKubun.基準日.getコード().equals(抽出区分)) {
            set範囲Disable(モード);
            set基準日unDisable(モード);
        } else if (HizukeChushutsuKubun.範囲.getコード().equals(抽出区分)) {
            set範囲unDisable(モード);
            set基準日Disable(モード);
        }
    }

    private void set適用除外者事由抽出区分(RString 事由抽出区分) {
        if (JiyuChushutsuKubun.適用除外者のみ.getコード().equals(事由抽出区分)) {
            div.getTekiyoJogaishaJoken().getChkTekiyoJogaishaTekiyoJiyu().setDisabled(false);
            div.getTekiyoJogaishaJoken().getChkTekiyoJogaishaKaijoJiyu().setDisabled(true);
        } else if (JiyuChushutsuKubun.適用除外解除者のみ.getコード().equals(事由抽出区分)) {
            div.getTekiyoJogaishaJoken().getChkTekiyoJogaishaTekiyoJiyu().setDisabled(true);
            div.getTekiyoJogaishaJoken().getChkTekiyoJogaishaKaijoJiyu().setDisabled(false);
        } else if (JiyuChushutsuKubun.両方.getコード().equals(事由抽出区分)) {
            div.getTekiyoJogaishaJoken().getChkTekiyoJogaishaTekiyoJiyu().setDisabled(false);
            div.getTekiyoJogaishaJoken().getChkTekiyoJogaishaKaijoJiyu().setDisabled(false);
        }
    }

    private void set他市町村住所地特例者事由抽出区分(RString 事由抽出区分) {
        if (他特例適用者のみ.equals(事由抽出区分)) {
            div.getTaShichosonJushotiTokureishaJoken().getChkTaShichosonJushotiTokureishaTekiyoJiyu().setDisabled(false);
            div.getTaShichosonJushotiTokureishaJoken().getChkTaShichosonJushotiTokureishaKaijoJiyu().setDisabled(true);
        } else if (他特例解除者のみ.equals(事由抽出区分)) {
            div.getTaShichosonJushotiTokureishaJoken().getChkTaShichosonJushotiTokureishaTekiyoJiyu().setDisabled(true);
            div.getTaShichosonJushotiTokureishaJoken().getChkTaShichosonJushotiTokureishaKaijoJiyu().setDisabled(false);
        } else if (両方.equals(事由抽出区分)) {
            div.getTaShichosonJushotiTokureishaJoken().getChkTaShichosonJushotiTokureishaTekiyoJiyu().setDisabled(false);
            div.getTaShichosonJushotiTokureishaJoken().getChkTaShichosonJushotiTokureishaKaijoJiyu().setDisabled(false);
        }
    }

    private void 宛名抽出条件復元(BatchParameterMap restoreBatchParameterMap) {
        RString 年齢層抽出方法 = restoreBatchParameterMap.getParameterValue(RString.class, new RString("psmChushutsu_Kubun"));
        div.getCcdHanyoListAtenaSelect().set年齢層抽出方法(年齢層抽出方法);
        Decimal 宛名抽出年齢開始 = restoreBatchParameterMap.getParameterValue(Decimal.class, new RString("psmChushutsuAge_Start"));
        if (宛名抽出年齢開始 != null) {
            div.getCcdHanyoListAtenaSelect().set年齢開始(宛名抽出年齢開始);
        }
        Decimal 宛名抽出年齢終了 = restoreBatchParameterMap.getParameterValue(Decimal.class, new RString("psmChushutsuAge_End"));
        if (宛名抽出年齢終了 != null) {
            div.getCcdHanyoListAtenaSelect().set年齢終了(宛名抽出年齢終了);
        }
        RDate 宛名抽出生年月日開始 = restoreBatchParameterMap.getParameterValue(RDate.class, new RString("psmSeinengappiYMD_Start"));
        if (宛名抽出生年月日開始 != null) {
            div.getCcdHanyoListAtenaSelect().set生年月日開始(宛名抽出生年月日開始);
        }
        RDate 宛名抽出生年月日終了 = restoreBatchParameterMap.getParameterValue(RDate.class, new RString("psmSeinengappiYMD_End"));
        if (宛名抽出生年月日終了 != null) {
            div.getCcdHanyoListAtenaSelect().set生年月日終了(宛名抽出生年月日終了);
        }
        RDate 年齢基準日 = restoreBatchParameterMap.getParameterValue(RDate.class, new RString("psmAgeKijunni"));
        if (年齢基準日 != null) {
            div.getCcdHanyoListAtenaSelect().set年齢基準日(年齢基準日);
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
