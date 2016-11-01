/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7040001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710040.DBC710040_HanyoListKokuhorenJukyushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710050.DBC710050_HanyoListKyodoJukyushaKihonParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710060.DBC710060_HanyoListKyodoJukyushaKogakuParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710070.DBC710070_HanyoListKyodoJukyushaShokanParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_RiyoshaFutanKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_ServiceKubunCode;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7040001.HanyoListParamKokurenJyukyujyaJyohoDiv;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.gemmen.niteishalist.CSVSettings;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト 国保連受給者情報のHandlerです。
 *
 * @reamsid_L DBC-3104-010 yaodongsheng
 */
public class HanyoListParamKokurenJyukyujyaJyohoHandler {

    private static final RString モード1 = new RString("共同処理用受給者情報（基本）");
    private static final RString モード2 = new RString("共同処理用受給者情報（償還）");
    private static final RString モード3 = new RString("共同処理用受給者情報（高額）");
    private static final RString モード4 = new RString("国保連受給者情報");
    private static final RString 全市町村 = new RString("000000");
    private static final RString 導入形態_単一 = new RString("0");
    private static final RString 導入形態_広域 = new RString("1");
    private static final RString すべて = new RString("0");
    private static final RString 最新履歴のみ = new RString("1");
    private static final RString 範囲指定 = new RString("2");
    private static final RString すべてKEY0 = new RString("key0");
    private static final RString 老齢_受給なし = new RString("key1");
    private static final RString 老齢_受給あり = new RString("key2");
    private static final RString 利用者_該当なし = new RString("key1");
    private static final RString 利用者_該当あり = new RString("key2");
    private static final RString 公費負担_なし = new RString("key1");
    private static final RString 公費負担_あり生保 = new RString("key2");
    private static final RString 利用者_適用なし = new RString("0");
    private static final RString 特定_適用なし = new RString("0");
    private static final RString 適用なし_記号 = new RString("*");
    private static final RString 適用なしEMPTY = new RString("");
    private final HanyoListParamKokurenJyukyujyaJyohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 汎用リスト（資格）パネル
     */
    public HanyoListParamKokurenJyukyujyaJyohoHandler(HanyoListParamKokurenJyukyujyaJyohoDiv div) {
        this.div = div;
    }

    /**
     * 画面を初期化します。
     *
     * @param list List<KaigoDonyuKeitai>
     */
    public void onLoad(List<KaigoDonyuKeitai> list) {
        if (list.get(0).get導入形態コード().is単一()) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisplayNone(true);
            div.setHdnDonyuKeitai(導入形態_単一);
        } else if (list.get(0).get導入形態コード().is広域()) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList();
            div.setHdnDonyuKeitai(導入形態_広域);
        }
        div.getRadChushutsuHaniSentaku().setSelectedKey(すべて);
        List<RString> csvHenshu = new ArrayList<>();
        csvHenshu.add(CSVSettings.項目名付加.getコード());
        csvHenshu.add(CSVSettings.日付スラッシュ編集.getコード());
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(csvHenshu);
        set範囲Disable();
    }

    /**
     * 日付抽出区分のonChange事件です。
     */
    public void onChange_HaniSentaku() {
        if (すべて.equals(div.getRadChushutsuHaniSentaku().getSelectedKey())
                || 最新履歴のみ.equals(div.getRadChushutsuHaniSentaku().getSelectedKey())) {
            set範囲Disable();
        } else if (範囲指定.equals(div.getRadChushutsuHaniSentaku().getSelectedKey())) {
            set範囲unDisable();
        }
    }

    /**
     * 共同処理用受給者情報（基本）のBatchParameterSave。
     *
     * @return parameter DBC710050_HanyoListKyodoJukyushaKihonParameter
     */
    public DBC710050_HanyoListKyodoJukyushaKihonParameter onClick_btnKyodoJukyushaKihonParameterSave() {
        DBC710050_HanyoListKyodoJukyushaKihonParameter parameter = new DBC710050_HanyoListKyodoJukyushaKihonParameter();
        parameter.setChohyoId(div.getCcdShutsuryokujun().get帳票ID().value());
        parameter.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        parameter.setShutsuryokukomokuId(div.getCcdShutsuryokuKoumoku().get出力項目ID());
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
        parameter.setKomokumeFuka(is項目名付加);
        parameter.setRenbanFuka(is連番付加);
        parameter.setHitsukeHenshu(is日付編集);
        RString 市町村コード = RString.EMPTY;
        if (導入形態_広域.equals(div.getHdnDonyuKeitai())) {
            if (!div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().isEmpty()) {
                市町村コード = div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().value();
            } else {
                市町村コード = 全市町村;
            }
        }
        parameter.setHokenshaKodo(市町村コード);
        parameter.setHitsukeChushutsuKubun(div.getRadChushutsuHaniSentaku().getSelectedKey());
        parameter.setShoriTaishoNengetsuFrom(rDateToRString(div.getTxtShoriTaishoNengetsu().getFromValue()));
        parameter.setShoriTaishoNengetsuTo(rDateToRString(div.getTxtShoriTaishoNengetsu().getToValue()));
        parameter.setIdoNengetsuFrom(rDateToRString(div.getTxtIdoNengetsu().getFromValue()));
        parameter.setIdoNengetsuTo(rDateToRString(div.getTxtIdoNengetsu().getToValue()));
        List<RString> kakuidozukinoSaishinNomi = div.getChkIdotukiSaisinJohoChushutsu().getSelectedKeys();
        boolean isSelectNomi = false;
        if (!kakuidozukinoSaishinNomi.isEmpty()) {
            isSelectNomi = true;
        }
        parameter.setKakuidozukinoSaishinNomi(isSelectNomi);
        parameter.setIdoKubun(div.getChkIdokubunKodo1().getSelectedKeys());
        List<RString> sakujyoMeru = div.getChkSakujyoDataChushutsu().getSelectedKeys();
        boolean isSelectSakujyoMeru = false;
        if (!sakujyoMeru.isEmpty()) {
            isSelectSakujyoMeru = true;
        }
        parameter.setSakujyoMeru(isSelectSakujyoMeru);
        return parameter;
    }

    /**
     * 共同処理用受給者情報（基本）の条件復元するボタンを押下します。
     */
    public void onClick_btnKyodoJukyushaKihonParameterRestore() {
        parameterRestore(モード1);
    }

    /**
     * 共同処理用受給者情報（償還）のBatchParameterSave。
     *
     * @return parameter DBC710070_HanyoListKyodoJukyushaShokanParameter
     */
    public DBC710070_HanyoListKyodoJukyushaShokanParameter onClick_btnKyodoJukyushaShokanParameterSave() {
        DBC710070_HanyoListKyodoJukyushaShokanParameter parameter = new DBC710070_HanyoListKyodoJukyushaShokanParameter();
        parameter.setChohyoId(div.getCcdShutsuryokujun().get帳票ID().value());
        parameter.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        parameter.setShutsuryokukomokuId(div.getCcdShutsuryokuKoumoku().get出力項目ID());
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
        parameter.setKomokumeFuka(is項目名付加);
        parameter.setRenbanFuka(is連番付加);
        parameter.setHitsukeHenshu(is日付編集);
        RString 市町村コード = RString.EMPTY;
        if (導入形態_広域.equals(div.getHdnDonyuKeitai())) {
            if (!div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().isEmpty()) {
                市町村コード = div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().value();
            } else {
                市町村コード = 全市町村;
            }
        }
        parameter.setHokenshaKodo(市町村コード);
        parameter.setHitsukeChushutsuKubun(div.getRadChushutsuHaniSentaku().getSelectedKey());
        parameter.setShoriTaishoNengetsuFrom(rDateToRString(div.getTxtShoriTaishoNengetsu().getFromValue()));
        parameter.setShoriTaishoNengetsuTo(rDateToRString(div.getTxtShoriTaishoNengetsu().getToValue()));
        parameter.setIdoNengetsuFrom(rDateToRString(div.getTxtIdoNengetsu().getFromValue()));
        parameter.setIdoNengetsuTo(rDateToRString(div.getTxtIdoNengetsu().getToValue()));
        List<RString> kakuidozukinoSaishinNomi = div.getChkIdotukiSaisinJohoChushutsu().getSelectedKeys();
        boolean isSelectNomi = false;
        if (!kakuidozukinoSaishinNomi.isEmpty()) {
            isSelectNomi = true;
        }
        parameter.setKakuidozukinoSaishinNomi(isSelectNomi);
        parameter.setIdoKubun(div.getChkIdokubunKodo1().getSelectedKeys());
        List<RString> sakujyoMeru = div.getChkSakujyoDataChushutsu().getSelectedKeys();
        boolean isSelectSakujyoMeru = false;
        if (!sakujyoMeru.isEmpty()) {
            isSelectSakujyoMeru = true;
        }
        parameter.setSakujyoMeru(isSelectSakujyoMeru);
        return parameter;
    }

    /**
     * 共同処理用受給者情報（償還）の条件復元するボタンを押下します。
     */
    public void onClick_btnKyodoJukyushaShokanParameterRestore() {
        parameterRestore(モード2);
    }

    /**
     * 共同処理用受給者情報（高額）のBatchParameterSave。
     *
     * @return parameter DBC710060_HanyoListKyodoJukyushaKogakuParameter
     */
    public DBC710060_HanyoListKyodoJukyushaKogakuParameter onClick_btnKyodoJukyushaKogakuParameterSave() {
        DBC710060_HanyoListKyodoJukyushaKogakuParameter parameter = new DBC710060_HanyoListKyodoJukyushaKogakuParameter();
        parameter.setChohyoId(div.getCcdShutsuryokujun().get帳票ID().value());
        parameter.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        parameter.setShutsuryokukomokuId(div.getCcdShutsuryokuKoumoku().get出力項目ID());
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
        parameter.setKomokumeFuka(is項目名付加);
        parameter.setRenbanFuka(is連番付加);
        parameter.setHitsukeHenshu(is日付編集);
        RString 市町村コード = RString.EMPTY;
        if (導入形態_広域.equals(div.getHdnDonyuKeitai())) {
            if (!div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().isEmpty()) {
                市町村コード = div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().value();
            } else {
                市町村コード = 全市町村;
            }
        }
        parameter.setHokenshaKodo(市町村コード);
        parameter.setHitsukeChushutsuKubun(div.getRadChushutsuHaniSentaku().getSelectedKey());
        parameter.setShoriTaishoNengetsuFrom(rDateToRString(div.getTxtShoriTaishoNengetsu().getFromValue()));
        parameter.setShoriTaishoNengetsuTo(rDateToRString(div.getTxtShoriTaishoNengetsu().getToValue()));
        parameter.setIdoNengetsuFrom(rDateToRString(div.getTxtIdoNengetsu().getFromValue()));
        parameter.setIdoNengetsuTo(rDateToRString(div.getTxtIdoNengetsu().getToValue()));
        List<RString> kakuidozukinoSaishinNomi = div.getChkIdotukiSaisinJohoChushutsu().getSelectedKeys();
        boolean isSelectNomi = false;
        if (!kakuidozukinoSaishinNomi.isEmpty()) {
            isSelectNomi = true;
        }
        parameter.setKakuidozukinoSaishinNomi(isSelectNomi);
        parameter.setIdoKubun(div.getChkIdokubunKodo2().getSelectedKeys());
        parameter.setSeidaiKubun(div.getChkSetaiShotokuKubun().getSelectedKeys());
        parameter.setShotokuKubun(div.getChkShotokuKubun().getSelectedKeys());
        List<Boolean> roreiKubuns = new ArrayList<>();
        RString roreikubun = div.getRadRoreiNenkinJukyuKubun().getSelectedKey();
        if (すべてKEY0.equals(roreikubun)) {
            roreiKubuns.add(true);
            roreiKubuns.add(false);
        } else if (老齢_受給なし.equals(roreikubun)) {
            roreiKubuns.add(false);
        } else if (老齢_受給あり.equals(roreikubun)) {
            roreiKubuns.add(true);
        }
        parameter.setRoreiNenkinJyukyuKubun(roreiKubuns);
        List<Boolean> riyoshas = new ArrayList<>();
        RString riyosha = div.getRadRoreiNenkinJukyuKubun().getSelectedKey();
        if (すべてKEY0.equals(riyosha)) {
            riyoshas.add(true);
            riyoshas.add(false);
        } else if (利用者_該当なし.equals(riyosha)) {
            riyoshas.add(false);
        } else if (利用者_該当あり.equals(riyosha)) {
            riyoshas.add(true);
        }
        parameter.setRyoshaFutanDainiDankai(riyoshas);
        List<RString> sakujyoMeru = div.getChkSakujyoDataChushutsu().getSelectedKeys();
        boolean isSelectSakujyoMeru = false;
        if (!sakujyoMeru.isEmpty()) {
            isSelectSakujyoMeru = true;
        }
        parameter.setSakujyoMeru(isSelectSakujyoMeru);
        return parameter;
    }

    /**
     * 共同処理用受給者情報（高額）の条件復元するボタンを押下します。
     */
    public void onClick_btnKyodoJukyushaKogakuParameterRestore() {
        parameterRestore(モード3);
    }

    /**
     * 国保連受給者情報 のBatchParameterSave。
     *
     * @return parameter DBC710040_HanyoListKokuhorenJukyushaParameter
     */
    public DBC710040_HanyoListKokuhorenJukyushaParameter onClick_btnKokuhorenJukyushaParameterSave() {
        DBC710040_HanyoListKokuhorenJukyushaParameter parameter = new DBC710040_HanyoListKokuhorenJukyushaParameter();
        parameter.setChohyoId(div.getCcdShutsuryokujun().get帳票ID().value());
        parameter.setShutsuryokujunId(div.getCcdShutsuryokujun().get出力順ID());
        parameter.setShutsuryokukomokuId(div.getCcdShutsuryokuKoumoku().get出力項目ID());
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
        parameter.setKomokumeFuka(is項目名付加);
        parameter.setRenbanFuka(is連番付加);
        parameter.setHitsukeHenshu(is日付編集);
        RString 市町村コード = RString.EMPTY;
        if (導入形態_広域.equals(div.getHdnDonyuKeitai())) {
            if (!div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().isEmpty()) {
                市町村コード = div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード().value();
            } else {
                市町村コード = 全市町村;
            }
        }
        parameter.setHokenshaKodo(市町村コード);
        parameter.setHitsukeChushutsuKubun(div.getRadChushutsuHaniSentaku().getSelectedKey());
        parameter.setShoriTaishoNengetsuFrom(rDateToRString(div.getTxtShoriTaishoNengetsu().getFromValue()));
        parameter.setShoriTaishoNengetsuTo(rDateToRString(div.getTxtShoriTaishoNengetsu().getToValue()));
        parameter.setIdoNengetsuFrom(rDateToRString(div.getTxtIdoNengetsu().getFromValue()));
        parameter.setIdoNengetsuTo(rDateToRString(div.getTxtIdoNengetsu().getToValue()));
        parameter.setKakuidozukinoSaishinNomi(!div.getChkIdotukiSaisinJohoChushutsu().getSelectedKeys().isEmpty());
        parameter.setIdoKubun(div.getChkIdokubunKodo3().getSelectedKeys());
        parameter.setMinashiYokaigoKubun(div.getChkMinashiYoKaigoKubun().getSelectedKeys());
        parameter.setJigyoshaBanggo(setJigyoshaNo(div.getCcdkyotakuSienJigyoshaBango().getNyuryokuShisetsuKodo()));
        List<Boolean> futangakugengakus = new ArrayList<>();
        RString futangakugengaku = div.getRadKohiFutangakuGengaku().getSelectedKey();
        if (すべてKEY0.equals(futangakugengaku)) {
            futangakugengakus.add(true);
            futangakugengakus.add(false);
        } else if (公費負担_なし.equals(futangakugengaku)) {
            futangakugengakus.add(false);
        } else if (公費負担_あり生保.equals(futangakugengaku)) {
            futangakugengakus.add(true);
        }
        parameter.setKohiFutanJyogengakuGengaku(futangakugengakus);
        List<RString> riyoshaFutanKubun = new ArrayList<>();
        for (RString riyosha : div.getChkRiyoshaFutanKubunKodo().getSelectedKeys()) {
            if (利用者_適用なし.equals(riyosha)) {
                riyoshaFutanKubun.add(適用なし_記号);
                riyoshaFutanKubun.add(適用なしEMPTY);
            } else {
                riyoshaFutanKubun.add(riyosha);
            }
        }
        parameter.setRiyoshaFutanKubun(riyoshaFutanKubun);
        List<RString> tokuteiNyushoshaSabisuKubun = new ArrayList<>();
        for (RString tokutei : div.getChkTokuteiNyushoshaSabisuKubun().getSelectedKeys()) {
            if (利用者_適用なし.equals(tokutei)) {
                tokuteiNyushoshaSabisuKubun.add(適用なし_記号);
                tokuteiNyushoshaSabisuKubun.add(適用なしEMPTY);
            } else {
                tokuteiNyushoshaSabisuKubun.add(tokutei);
            }
        }
        parameter.setTokuteiNyushoshaSabisuKubun(tokuteiNyushoshaSabisuKubun);
        parameter.setSakujyoMeru(!div.getChkSakujyoDataChushutsu().getSelectedKeys().isEmpty());
        return parameter;
    }

    /**
     * 国保連受給者情報の条件復元するボタンを押下します。
     */
    public void onClick_btnKokuhorenJukyushaParameterRestore() {
        parameterRestore(モード4);
    }

    private void parameterRestore(RString モード) {
        BatchParameterMap restoreBatchParameterMap;
        if (モード1.equals(モード)) {
            restoreBatchParameterMap = div.getBtnKihonBatchParameterRestore().getRestoreBatchParameterMap();
        } else if (モード2.equals(モード)) {
            restoreBatchParameterMap = div.getBtnShokanBatchParameterRestore().getRestoreBatchParameterMap();
        } else if (モード3.equals(モード)) {
            restoreBatchParameterMap = div.getBtnKogakuBatchParameterRestore().getRestoreBatchParameterMap();
        } else {
            restoreBatchParameterMap = div.getBtnKokuhoBatchParameterRestore().getRestoreBatchParameterMap();
        }
        set編集方法(restoreBatchParameterMap);
        if (導入形態_広域.equals(div.getHdnDonyuKeitai())) {
            RString honkenshaCode = restoreBatchParameterMap.getParameterValue(RString.class, new RString("hokenshaKodo"));
            if (全市町村.equals(honkenshaCode)) {
                div.getCcdHokenshaList().loadHokenshaList();
            } else {
                div.getChushutsuJokenPanel().getCcdHokenshaList().setSelectedShichosonIfExist(
                        new LasdecCode(honkenshaCode));
            }
        }
        List<RString> idoKubunList = new ArrayList<>();
        for (Object idokubun : restoreBatchParameterMap.getParameterValue(List.class, new RString("idoKubun"))) {
            idoKubunList.add(new RString(idokubun.toString()));
        }
        if (モード1.equals(モード) || モード2.equals(モード)) {
            div.getChkIdokubunKodo1().setSelectedItemsByKey(idoKubunList);
        } else if (モード3.equals(モード)) {
            div.getChkIdokubunKodo2().setSelectedItemsByKey(idoKubunList);
            set償還(restoreBatchParameterMap);
        } else if (モード4.equals(モード)) {
            div.getChkIdokubunKodo3().setSelectedItemsByKey(idoKubunList);
            set国保(restoreBatchParameterMap);
        }
        List<RString> list = new ArrayList<>();
        if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("sakujyoMeru"))) {
            list.add(new RString("key0"));
        }
        div.getChkSakujyoDataChushutsu().setSelectedItemsByKey(list);
        RString histsukeChushutsuKubun = restoreBatchParameterMap.getParameterValue(RString.class, new RString("hitsukeChushutsuKubun"));
        if (!RString.isNullOrEmpty(histsukeChushutsuKubun)) {
            div.getRadChushutsuHaniSentaku().setSelectedKey(histsukeChushutsuKubun);
        }
        if (すべて.equals(histsukeChushutsuKubun)) {
            set範囲Disable();
        } else if (最新履歴のみ.equals(histsukeChushutsuKubun)) {
            set範囲Disable();
        } else if (範囲指定.equals(histsukeChushutsuKubun)) {
            set範囲unDisable();
            set日付(restoreBatchParameterMap);
            if (restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("kakuidozukinoSaishinNomi"))) {
                List<RString> 各異動月S = new ArrayList<>();
                各異動月S.add(すべてKEY0);
                div.getChkIdotukiSaisinJohoChushutsu().setSelectedItemsByKey(各異動月S);
            }
        }
    }

    private void set編集方法(BatchParameterMap restoreBatchParameterMap) {
        List<RString> 編集方法 = new ArrayList<>();
        boolean is項目名付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("komokumeFuka"));
        if (is項目名付加) {
            編集方法.add(CSVSettings.項目名付加.getコード());
        }
        boolean is連番付加 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("renbanFuka"));
        if (is連番付加) {
            編集方法.add(CSVSettings.連番付加.getコード());
        }
        boolean is日付編集 = restoreBatchParameterMap.getParameterValue(Boolean.class, new RString("hitsukeHenshu"));
        if (is日付編集) {
            編集方法.add(CSVSettings.日付スラッシュ編集.getコード());
        }
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(編集方法);
    }

    private void set償還(BatchParameterMap restoreBatchParameterMap) {
        List<RString> setaiShotokuKubuns = new ArrayList<>();
        for (Object setaiShotokuKubun : restoreBatchParameterMap.getParameterValue(List.class, new RString("seidaiKubun"))) {
            setaiShotokuKubuns.add(new RString(setaiShotokuKubun.toString()));
        }
        div.getChkSetaiShotokuKubun().setSelectedItemsByKey(setaiShotokuKubuns);
        List<RString> shotokuKubuns = new ArrayList<>();
        for (Object shotokuKubun : restoreBatchParameterMap.getParameterValue(List.class, new RString("shotokuKubun"))) {
            shotokuKubuns.add(new RString(shotokuKubun.toString()));
        }
        div.getChkShotokuKubun().setSelectedItemsByKey(shotokuKubuns);
        if (restoreBatchParameterMap.getParameterValue(List.class, new RString("roreiNenkinJyukyuKubun")).size() == 2) {
            div.getRadRoreiNenkinJukyuKubun().setSelectedKey(すべてKEY0);
        } else {
            for (Object roreiNenkinJyukyuKubun : restoreBatchParameterMap.getParameterValue(List.class, new RString("roreiNenkinJyukyuKubun"))) {
                if ((boolean) roreiNenkinJyukyuKubun) {
                    div.getRadRoreiNenkinJukyuKubun().setSelectedKey(老齢_受給あり);
                } else {
                    div.getRadRoreiNenkinJukyuKubun().setSelectedKey(老齢_受給なし);
                }
            }
        }
        if (restoreBatchParameterMap.getParameterValue(List.class, new RString("ryoshaFutanDainiDankai")).size() == 2) {
            div.getRadRiyoshaFutanDai2Dankai().setSelectedKey(すべてKEY0);
        } else {
            for (Object ryoshaFutanDainiDankai : restoreBatchParameterMap.getParameterValue(List.class, new RString("ryoshaFutanDainiDankai"))) {
                if ((boolean) ryoshaFutanDainiDankai) {
                    div.getRadRiyoshaFutanDai2Dankai().setSelectedKey(利用者_該当あり);
                } else {
                    div.getRadRiyoshaFutanDai2Dankai().setSelectedKey(利用者_該当なし);
                }
            }
        }
    }

    private void set国保(BatchParameterMap restoreBatchParameterMap) {
        List<RString> minashiYokaigoKubuns = new ArrayList<>();
        for (Object minashiYokaigoKubun : restoreBatchParameterMap.getParameterValue(List.class, new RString("minashiYokaigoKubun"))) {
            minashiYokaigoKubuns.add(new RString(minashiYokaigoKubun.toString()));
        }
        div.getChkMinashiYoKaigoKubun().setSelectedItemsByKey(minashiYokaigoKubuns);
        RString jigyoshaBanggo = restoreBatchParameterMap.getParameterValue(RString.class, new RString("jigyoshaBanggo"));
        if (!RString.isNullOrEmpty(jigyoshaBanggo)) {
            div.getCcdkyotakuSienJigyoshaBango().setNyuryokuShisetsuKodo(jigyoshaBanggo);
        } else {
            div.getCcdkyotakuSienJigyoshaBango().clear();
        }
        if (restoreBatchParameterMap.getParameterValue(List.class, new RString("kohiFutanJyogengakuGengaku")).size() == 2) {
            div.getRadKohiFutangakuGengaku().setSelectedKey(すべてKEY0);
        } else {
            for (Object kohiFutanJyogengakuGengaku : restoreBatchParameterMap.getParameterValue(List.class,
                    new RString("kohiFutanJyogengakuGengaku"))) {
                if ((boolean) kohiFutanJyogengakuGengaku) {
                    div.getRadKohiFutangakuGengaku().setSelectedKey(公費負担_あり生保);
                } else {
                    div.getRadKohiFutangakuGengaku().setSelectedKey(公費負担_なし);
                }
            }
        }
        List<RString> riyoshaFutanKubuns = new ArrayList<>();
        for (Object riyoshaFutanKubun : restoreBatchParameterMap.getParameterValue(List.class, new RString("riyoshaFutanKubun"))) {
            if (適用なし_記号.equals(new RString(riyoshaFutanKubun.toString()))) {
                riyoshaFutanKubuns.add(利用者_適用なし);
            } else if (JukyushaIF_RiyoshaFutanKubunCode.利用者負担.getコード().equals(new RString(riyoshaFutanKubun.toString()))
                    || JukyushaIF_RiyoshaFutanKubunCode.旧措置入所者利用者負担.getコード().equals(new RString(riyoshaFutanKubun.toString()))) {
                riyoshaFutanKubuns.add(new RString(riyoshaFutanKubun.toString()));
            }
        }
        div.getChkRiyoshaFutanKubunKodo().setSelectedItemsByKey(riyoshaFutanKubuns);
        List<RString> tokuteiNyushoshaSabisuKubuns = new ArrayList<>();
        for (Object tokuteiNyushoshaSabisuKubun : restoreBatchParameterMap.getParameterValue(List.class,
                new RString("tokuteiNyushoshaSabisuKubun"))) {
            if (適用なし_記号.equals(new RString(tokuteiNyushoshaSabisuKubun.toString()))) {
                tokuteiNyushoshaSabisuKubuns.add(特定_適用なし);
            } else if (JukyushaIF_ServiceKubunCode.通常の受給者.getコード().equals(new RString(tokuteiNyushoshaSabisuKubun.toString()))
                    || JukyushaIF_ServiceKubunCode.旧措置入所者.getコード().equals(
                            new RString(tokuteiNyushoshaSabisuKubun.toString()))) {
                tokuteiNyushoshaSabisuKubuns.add(new RString(tokuteiNyushoshaSabisuKubun.toString()));
            }
        }
        div.getChkTokuteiNyushoshaSabisuKubun().setSelectedItemsByKey(tokuteiNyushoshaSabisuKubuns);
    }

    private void set日付(BatchParameterMap restoreBatchParameterMap) {
        RString shoriTaishoNengetsuFrom = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shoriTaishoNengetsuFrom"));
        if (!RString.isNullOrEmpty(shoriTaishoNengetsuFrom)) {
            div.getTxtShoriTaishoNengetsu().setFromValue(new RDate(shoriTaishoNengetsuFrom.toString()));
        } else {
            div.getTxtShoriTaishoNengetsu().clearFromValue();
        }
        RString shoriTaishoNengetsuTo = restoreBatchParameterMap.getParameterValue(RString.class, new RString("shoriTaishoNengetsuTo"));
        if (!RString.isNullOrEmpty(shoriTaishoNengetsuTo)) {
            div.getTxtShoriTaishoNengetsu().setToValue(new RDate(shoriTaishoNengetsuTo.toString()));
        } else {
            div.getTxtShoriTaishoNengetsu().clearToValue();
        }
        RString idoNengetsuFrom = restoreBatchParameterMap.getParameterValue(RString.class, new RString("idoNengetsuFrom"));
        if (!RString.isNullOrEmpty(idoNengetsuFrom)) {
            div.getTxtIdoNengetsu().setFromValue(new RDate(idoNengetsuFrom.toString()));
        } else {
            div.getTxtIdoNengetsu().clearFromValue();
        }
        RString idoNengetsuTo = restoreBatchParameterMap.getParameterValue(RString.class, new RString("idoNengetsuTo"));
        if (!RString.isNullOrEmpty(idoNengetsuTo)) {
            div.getTxtIdoNengetsu().setToValue(new RDate(idoNengetsuTo.toString()));
        } else {
            div.getTxtIdoNengetsu().clearToValue();
        }
    }

    private void set範囲Disable() {
        div.getTxtShoriTaishoNengetsu().setDisabled(true);
        div.getTxtIdoNengetsu().setDisabled(true);
        div.getChkIdotukiSaisinJohoChushutsu().setDisabled(true);
    }

    private void set範囲unDisable() {
        div.getTxtShoriTaishoNengetsu().setDisabled(false);
        div.getTxtIdoNengetsu().setDisabled(false);
        div.getChkIdotukiSaisinJohoChushutsu().setDisabled(false);
    }

    private RString setJigyoshaNo(RString jigyoshaNo) {
        if (RString.isNullOrEmpty(jigyoshaNo)) {
            return RString.EMPTY;
        }
        return jigyoshaNo;
    }

    private RString rDateToRString(RDate 日付) {
        if (日付 == null) {
            return RString.EMPTY;
        }
        return 日付.getYearMonth().toDateString();
    }
}
