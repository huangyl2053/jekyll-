/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1310001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD710010.DBD710010_HanyoListJukyushaDaichoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1310001.JukyushaDaichoDiv;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)のハンドラークラスです。
 *
 * @reamsid_L DBD-1800-010 liwul
 */
public class JukyushaDaichoPanelHandler {

    private final JukyushaDaichoDiv div;
    private static final RString 有効データ内最新KEY = new RString("key0");
    private static final RString 要介護１KEY = new RString("key0");
    private static final RString 要介護２KEY = new RString("key1");
    private static final RString 要介護３KEY = new RString("key2");
    private static final RString 要介護４KEY = new RString("key3");
    private static final RString 要介護５KEY = new RString("key4");
    private static final RString 要支援１KEY = new RString("key5");
    private static final RString 要支援２KEY = new RString("key6");
    private static final RString 経過的要介護_要支援_KEY = new RString("key7");
    private static final RString 自立KEY = new RString("key8");
    private static final RString 申請取消KEY = new RString("key9");
    private static final RString 却下_職権取消_他KEY = new RString("key10");
    private static final RString 旧措置者KEY = new RString("key0");
    private static final RString 被保険者１号KEY = new RString("key0");
    private static final RString 被保険者２号KEY = new RString("key1");
    private static final RString サービス指定者のみ = new RString("key0");
    private static final RString 項目名付加KEY = new RString(1);
    private static final RString 連番付加KEY = new RString(2);
    private static final RString 日付スラッシュ付加KEY = new RString(3);
    private static final RString 抽出方法区分名 = new RString("cyusyutsuhohokubun");
    private static final RString 有効データ内最新名 = new RString("isYukoudatasaisin");
    private static final RString 基準日名 = new RString("kizyunnichi");
    private static final RString 日付範囲開始名 = new RString("hitsukehanifrom");
    private static final RString 日付範囲終了名 = new RString("hitsukehanito");
    private static final RString 認定結果_0名 = new RString("isNinteikekka0");
    private static final RString 認定結果_1名 = new RString("isNinteikekka1");
    private static final RString 認定結果_2名 = new RString("isNinteikekka2");
    private static final RString 認定結果_3名 = new RString("isNinteikekka3");
    private static final RString 認定結果_4名 = new RString("isNinteikekka4");
    private static final RString 認定結果_5名 = new RString("isNinteikekka5");
    private static final RString 認定結果_6名 = new RString("isNinteikekka6");
    private static final RString 認定結果_7名 = new RString("isNinteikekka7");
    private static final RString 認定結果_8名 = new RString("isNinteikekka8");
    private static final RString 認定結果_9名 = new RString("isNinteikekka9");
    private static final RString 認定結果_10名 = new RString("isNinteikekka10");
    private static final RString 喪失区分名 = new RString("soshitsukubun");
    private static final RString 旧措置者名 = new RString("isKyusochisha");
    private static final RString 被保険者１号名 = new RString("isHihokensya1");
    private static final RString 被保険者２号名 = new RString("isHihokensya2");
    private static final RString サービス指定者名 = new RString("isNinteiSabisu");
    private static final RString 項目名付加名 = new RString("isCsvkomokumeifuka");
    private static final RString 連番付加名 = new RString("isCsvrenbanfuka");
    private static final RString 日付スラッシュ付加名 = new RString("isCsvhitsukesurasyuhensyu");
    private static final RString 宛名抽出条件名 = new RString("atenacyusyutsujyoken");
    private static final RString 出力順名 = new RString("syutsuryokujunparameter");
    private static final RString 出力項目名 = new RString("syutsuryokukomoku");
    private static final RString 帳票ID = new RString("DBD701001_HanyoListJukyushaDaicho");

    /**
     * コンストラクタです。
     *
     * @param div ドメインオブジェクトを取り出したい {@link JukyushaDaichoPanelHandler}
     */
    public JukyushaDaichoPanelHandler(JukyushaDaichoDiv div) {
        this.div = div;
    }

    /**
     * 画面設計_DBDGM13003_汎用リスト出力(受給者台帳)の初期化。
     *
     */
    public void onLoad() {
        List<KeyValueDataSource> 受給者台帳抽出方法 = new ArrayList<>();
        for (ChushutsuHohoKubun chushutsuHohoKubun : ChushutsuHohoKubun.values()) {
            受給者台帳抽出方法.add(new KeyValueDataSource(chushutsuHohoKubun.getコード(), chushutsuHohoKubun.get名称()));
        }
        div.getRadChushutsuTaisho().setDataSource(受給者台帳抽出方法);
        div.getRadChushutsuTaisho().setSelectedKey(ChushutsuHohoKubun.直近.getコード());
        set有効データ内最新Cb(false, true);
        set基準日(true);
        set範囲(true);
        List<RString> 認定結果isDisabledKeys = new ArrayList<>();
        List<RString> 認定結果isOnKeys = new ArrayList<>();
        認定結果isDisabledKeys.addAll(get自立_却下Keys());
        div.getChkNinteiKekka().setDisabledItemsByKey(認定結果isDisabledKeys);
        div.getChkNinteiKekka().setSelectedItemsByKey(認定結果isOnKeys);
        List<KeyValueDataSource> 喪失区分DDL = new ArrayList<>();
        for (SoshitsuKubun soshitsuKubun : SoshitsuKubun.values()) {
            喪失区分DDL.add(new KeyValueDataSource(soshitsuKubun.getコード(), soshitsuKubun.get名称()));
        }
        div.getDdlShikakuSoshitsuKubun().setDataSource(喪失区分DDL);
        div.getDdlShikakuSoshitsuKubun().setSelectedKey(SoshitsuKubun.資格判定なし.getコード());
        div.getDdlShikakuSoshitsuKubun().setDisabled(false);
        List<RString> isOff = new ArrayList<>();
        div.getＣｈｋKyuSochisya().setSelectedItemsByKey(isOff);
        div.getＣｈｋKyuSochisya().setDisabled(false);
        div.getChkHihokensya().setSelectedItemsByKey(isOff);
        div.getChkHihokensya().setDisabled(false);
        div.getChkNinteiSabisu().setSelectedItemsByKey(isOff);
        div.getChkNinteiSabisu().setDisabled(false);
        div.getCcdAtenaJoken().initialize();
        div.getCcdAtenaJoken().set保険者();
        div.getCcdAtenaJoken().set地区(Chiku.全て.getコード());
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getCcdGyoseikuFrom().setDisabled(false);
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getCcdJushoFrom().setDisabled(false);
        div.getCcdAtenaJoken().get宛名抽出条件子Div().getCcdJushoTo().setDisabled(false);
        setCSV編集条件();
        div.getCcdShutsuryokujun().setDisabled(false);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(帳票ID));
        div.getCcdShutsuryokuKoumoku().load(帳票ID, SubGyomuCode.DBD介護受給);
        div.getCcdShutsuryokuKoumoku().setDisabled(true);
        onChange_chkSaisin();
    }

    /**
     * 条件の復元。
     *
     *
     */
    public void restoreBatchParameter() {
        BatchParameterMap map = div.getBtnBatchParameterRestore().getRestoreBatchParameterMap();
        ChushutsuHohoKubun 抽出方法区分 = map.getParameterValue(ChushutsuHohoKubun.class, 抽出方法区分名);
        div.getRadChushutsuTaisho().setSelectedKey(抽出方法区分.getコード());
        List<RString> 有効データ内最新SelectedKeys = new ArrayList<>();
        if (getParameterBooleanValue(map, 有効データ内最新名)) {
            有効データ内最新SelectedKeys.add(有効データ内最新KEY);
        }
        div.getChkSaisin().setSelectedItemsByKey(有効データ内最新SelectedKeys);
        div.getTxtKijyunYmd().setValue(flexibleDateToRDate(map.getParameterValue(FlexibleDate.class, 基準日名)));
        div.getTxtNinteiYmdHani().setFromValue(flexibleDateToRDate(map.getParameterValue(FlexibleDate.class, 日付範囲開始名)));
        div.getTxtNinteiYmdHani().setToValue(flexibleDateToRDate(map.getParameterValue(FlexibleDate.class, 日付範囲終了名)));
        List<RString> 認定結果SelectedKeys = new ArrayList<>();
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_0名), 要介護１KEY);
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_1名), 要介護２KEY);
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_2名), 要介護３KEY);
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_3名), 要介護４KEY);
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_4名), 要介護５KEY);
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_5名), 要支援１KEY);
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_6名), 要支援２KEY);
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_7名), 経過的要介護_要支援_KEY);
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_8名), 自立KEY);
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_9名), 申請取消KEY);
        認定結果SelectedKeys = addSelectedKey(認定結果SelectedKeys, getParameterBooleanValue(map, 認定結果_10名), 却下_職権取消_他KEY);
        div.getChkNinteiKekka().setSelectedItemsByKey(認定結果SelectedKeys);
        div.getDdlShikakuSoshitsuKubun().setSelectedKey(map.getParameterValue(SoshitsuKubun.class, 喪失区分名).getコード());
        List<RString> 旧措置者SelectedKey = new ArrayList<>();
        div.getＣｈｋKyuSochisya().setSelectedItemsByKey(addSelectedKey(旧措置者SelectedKey, getParameterBooleanValue(map, 旧措置者名), 旧措置者KEY));
        List<RString> 被保険者情報SelectedKeys = new ArrayList<>();
        被保険者情報SelectedKeys = addSelectedKey(被保険者情報SelectedKeys, getParameterBooleanValue(map, 被保険者１号名), 被保険者１号KEY);
        被保険者情報SelectedKeys = addSelectedKey(被保険者情報SelectedKeys, getParameterBooleanValue(map, 被保険者２号名), 被保険者２号KEY);
        div.getChkHihokensya().setSelectedItemsByKey(被保険者情報SelectedKeys);
        List<RString> サービス指定者 = new ArrayList<>();
        div.getChkNinteiSabisu().setSelectedItemsByKey(addSelectedKey(サービス指定者, getParameterBooleanValue(map, サービス指定者名), サービス指定者のみ));
        restore宛名抽出条件(map);
        List<RString> csv編集条件 = new ArrayList<>();
        csv編集条件 = addSelectedKey(csv編集条件, getParameterBooleanValue(map, 項目名付加名), 項目名付加KEY);
        csv編集条件 = addSelectedKey(csv編集条件, getParameterBooleanValue(map, 連番付加名), 連番付加KEY);
        csv編集条件 = addSelectedKey(csv編集条件, getParameterBooleanValue(map, 日付スラッシュ付加名), 日付スラッシュ付加KEY);
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(csv編集条件);
        Long 出力順ID = map.getParameterValue(Long.class, 出力順名);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBD介護受給, new ReportId(帳票ID), 出力順ID);
        RString 出力項目 = map.getParameterValue(RString.class, 出力項目名);
        div.getCcdShutsuryokuKoumoku().load(帳票ID, SubGyomuCode.DBD介護受給, 出力項目);
        onChange_chkSaisin();
        onSelect_radChushutsuTaisho();
    }

    /**
     * 基準日RbGr onSelect画面制御。
     */
    public void onSelect_radChushutsuTaisho() {
        if (div.getRadChushutsuTaisho().getSelectedKey().equals(ChushutsuHohoKubun.直近.getコード())) {
            set有効データ内最新Cb(false, false);
            set基準日(true);
            set範囲(true);
        } else if (div.getRadChushutsuTaisho().getSelectedKey().equals(ChushutsuHohoKubun.基準日.getコード())) {
            set有効データ内最新Cb(true, false);
            set基準日(false);
            set範囲(true);
        } else {
            set有効データ内最新Cb(true, false);
            set基準日(true);
            set範囲(false);
        }
    }

    /**
     * 有効データ内最新Cb onChange画面制御。
     */
    public void onChange_chkSaisin() {
        List<RString> selectedKeys = div.getChkNinteiKekka().getSelectedKeys();
        if (div.getChkSaisin().isAllSelected()) {
            selectedKeys.removeAll(get自立_却下Keys());
            div.getChkNinteiKekka().setDisabledItemsByKey(get自立_却下Keys());
        } else {
            List<RString> isDisabledKey = new ArrayList<>();
            if (selectedKeys.containsAll(get要介護１_経過要介護Keys())) {
                selectedKeys.addAll(get自立_却下Keys());
            }
            div.getChkNinteiKekka().setDisabledItemsByKey(isDisabledKey);
        }
        div.getChkNinteiKekka().setSelectedItemsByKey(selectedKeys);
    }

    /**
     * バッチパラメータの作成。
     *
     * @return バッチパラメータ
     */
    public DBD710010_HanyoListJukyushaDaichoParameter getBatchParameter() {
        DBD710010_HanyoListJukyushaDaichoParameter para = new DBD710010_HanyoListJukyushaDaichoParameter();
        para.setCyusyutsuhohokubun(ChushutsuHohoKubun.toValue(div.getRadChushutsuTaisho().getSelectedKey()));
        if (div.getRadChushutsuTaisho().getSelectedKey().equals(ChushutsuHohoKubun.直近.getコード())) {
            para.setYukoudatasaisin(div.getChkSaisin().isAllSelected());
        } else {
            para.setYukoudatasaisin(false);
        }
        if (div.getRadChushutsuTaisho().getSelectedKey().equals(ChushutsuHohoKubun.基準日.getコード())) {
            para.setKizyunnichi(rDateToFlexibleDate(div.getTxtKijyunYmd().getValue()));
            para.setHitsukehanifrom(rDateToFlexibleDate(div.getTxtNinteiYmdHani().getFromValue()));
            para.setHitsukehanito(rDateToFlexibleDate(div.getTxtNinteiYmdHani().getToValue()));
        } else {
            para.setKizyunnichi(FlexibleDate.EMPTY);
            para.setHitsukehanifrom(FlexibleDate.EMPTY);
            para.setHitsukehanito(FlexibleDate.EMPTY);
        }
        para.setNinteikekka0(get認定結果SelectedKeys().contains(要介護１KEY));
        para.setNinteikekka1(get認定結果SelectedKeys().contains(要介護２KEY));
        para.setNinteikekka2(get認定結果SelectedKeys().contains(要介護３KEY));
        para.setNinteikekka3(get認定結果SelectedKeys().contains(要介護４KEY));
        para.setNinteikekka4(get認定結果SelectedKeys().contains(要介護５KEY));
        para.setNinteikekka5(get認定結果SelectedKeys().contains(要支援１KEY));
        para.setNinteikekka6(get認定結果SelectedKeys().contains(要支援２KEY));
        para.setNinteikekka7(get認定結果SelectedKeys().contains(経過的要介護_要支援_KEY));
        para.setNinteikekka8(get認定結果SelectedKeys().contains(自立KEY));
        para.setNinteikekka9(get認定結果SelectedKeys().contains(申請取消KEY));
        para.setNinteikekka10(get認定結果SelectedKeys().contains(却下_職権取消_他KEY));
        para.setSoshitsukubun(SoshitsuKubun.toValue(div.getDdlShikakuSoshitsuKubun().getSelectedKey()));
        para.setKyusochisha(div.getＣｈｋKyuSochisya().isAllSelected());
        para.setHihokensya1(div.getChkHihokensya().getSelectedKeys().contains(被保険者１号KEY));
        para.setHihokensya2(div.getChkHihokensya().getSelectedKeys().contains(被保険者２号KEY));
        para.setNinteiSabisu(div.getChkNinteiSabisu().isAllSelected());
        para.setCsvkomokumeifuka(getCSV編集条件SelectedKeys().contains(項目名付加KEY));
        para.setCsvrenbanfuka(getCSV編集条件SelectedKeys().contains(連番付加KEY));
        para.setCsvhitsukesurasyuhensyu(getCSV編集条件SelectedKeys().contains(日付スラッシュ付加KEY));
        para.setAtenacyusyutsujyoken(div.getCcdAtenaJoken().get宛名抽出条件());
        para.setSyutsuryokujunparameter(div.getCcdShutsuryokujun().get出力順ID());
        if (!div.getCcdShutsuryokuKoumoku().isDisabled()) {
            para.setSyutsuryokukomoku(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        } else {
            para.setSyutsuryokukomoku(RString.EMPTY);
        }
        return para;
    }

    private List<RString> addSelectedKey(List<RString> selectedKeys, boolean isAdd, RString key) {
        if (isAdd) {
            selectedKeys.add(key);
        }
        return selectedKeys;
    }

    private boolean getParameterBooleanValue(BatchParameterMap map, RString name) {
        return map.getParameterValue(boolean.class, name);
    }

    private void restore宛名抽出条件(BatchParameterMap map) {
        AtenaSelectBatchParameter 宛名抽出条件 = map.getParameterValue(AtenaSelectBatchParameter.class, 宛名抽出条件名);
        get宛名抽出条件div().set年齢層抽出方法(宛名抽出条件.getAgeSelectKijun().getコード());
        get宛名抽出条件div().set年齢開始(宛名抽出条件.getNenreiRange().getFrom());
        get宛名抽出条件div().set年齢終了(宛名抽出条件.getNenreiRange().getTo());
        get宛名抽出条件div().set年齢基準日(宛名抽出条件.getNenreiKijunbi());
        get宛名抽出条件div().set生年月日開始(宛名抽出条件.getSeinengappiRange().getFrom());
        get宛名抽出条件div().set生年月日終了(宛名抽出条件.getSeinengappiRange().getTo());
        get宛名抽出条件div().set地区(宛名抽出条件.getChiku_Kubun().getコード());
        get宛名抽出条件div().set住所開始(new ChoikiCode(宛名抽出条件.getJusho_From()));
        get宛名抽出条件div().set住所終了(new ChoikiCode(宛名抽出条件.getJusho_To()));
        get宛名抽出条件div().set行政区開始(new GyoseikuCode(宛名抽出条件.getGyoseiku_From()));
        get宛名抽出条件div().set行政区終了(new GyoseikuCode(宛名抽出条件.getGyoseiku_To()));
        get宛名抽出条件div().set地区１開始(new ChikuCode(宛名抽出条件.getChiku1_From()));
        get宛名抽出条件div().set地区１終了(new ChikuCode(宛名抽出条件.getChiku1_To()));
        get宛名抽出条件div().set地区２開始(new ChikuCode(宛名抽出条件.getChiku2_From()));
        get宛名抽出条件div().set地区２終了(new ChikuCode(宛名抽出条件.getChiku2_To()));
        get宛名抽出条件div().set地区３開始(new ChikuCode(宛名抽出条件.getChiku3_From()));
        get宛名抽出条件div().set地区３終了(new ChikuCode(宛名抽出条件.getChiku2_To()));
        get宛名抽出条件div().set保険者(宛名抽出条件.getShichoson_Code());
    }

    private IHanyoListAtenaSelectDiv get宛名抽出条件div() {
        return div.getCcdAtenaJoken();
    }

    private List<RString> get認定結果SelectedKeys() {
        return div.getChkNinteiKekka().getSelectedKeys();
    }

    private List<RString> getCSV編集条件SelectedKeys() {
        return div.getChkCsvHenshuHoho().getSelectedKeys();
    }

    private FlexibleDate rDateToFlexibleDate(RDate date) {
        if (date != null) {
            return new FlexibleDate(date.getYearValue(), date.getMonthValue(), date.getDayValue());
        }
        return FlexibleDate.EMPTY;
    }

    private RDate flexibleDateToRDate(FlexibleDate date) {
        if (date != null && date.isValid()) {
            return new RDate(date.getYearValue(), date.getMonthValue(), date.getDayValue());
        }
        return null;
    }

    private void set有効データ内最新Cb(boolean isDisabled, boolean isOn) {
        List<RString> 有効データ内最新Cb = new ArrayList<>();
        if (isOn) {
            有効データ内最新Cb.add(有効データ内最新KEY);
        }
        div.getChkSaisin().setSelectedItemsByKey(有効データ内最新Cb);
        div.getChkSaisin().setDisabled(isDisabled);
    }

    private void set基準日(boolean isDisabled) {
        div.getTxtKijyunYmd().setValue(RDate.getNowDate());
        div.getTxtKijyunYmd().setDisabled(isDisabled);
    }

    private void set範囲(boolean isDisabled) {
        div.getTxtNinteiYmdHani().clearFromValue();
        div.getTxtNinteiYmdHani().clearToValue();
        div.getTxtNinteiYmdHani().setDisabled(isDisabled);
    }

    private void setCSV編集条件() {
        List<RString> csv編集条件isOnKeys = new ArrayList<>();
        csv編集条件isOnKeys.add(項目名付加KEY);
        csv編集条件isOnKeys.add(日付スラッシュ付加KEY);
        div.getChkCsvHenshuHoho().setSelectedItemsByKey(csv編集条件isOnKeys);
    }

    private List<RString> get要介護１_経過要介護Keys() {
        List<RString> 認定結果 = new ArrayList<>();
        認定結果.add(要介護１KEY);
        認定結果.add(要介護２KEY);
        認定結果.add(要介護３KEY);
        認定結果.add(要介護４KEY);
        認定結果.add(要介護５KEY);
        認定結果.add(要支援１KEY);
        認定結果.add(要支援２KEY);
        認定結果.add(経過的要介護_要支援_KEY);
        return 認定結果;
    }

    private List<RString> get自立_却下Keys() {
        List<RString> 認定結果 = new ArrayList<>();
        認定結果.add(自立KEY);
        認定結果.add(申請取消KEY);
        認定結果.add(却下_職権取消_他KEY);
        return 認定結果;
    }
}
