/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7080001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710080.DBC710080_HanyoListKyufuKanriHyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufukanrihyo.KyufuKanrihyo_MeisaigyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7080001.HanyoListParamKyoufuKannrihyouDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 汎用リスト出力(給付管理票)
 *
 * @reamsid_L DBC-3096-010 zhengshenlei
 */
public class HanyoListParamKyoufuKannrihyouHandler {

    private final HanyoListParamKyoufuKannrihyouDiv div;
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString KEY_項目名付加 = new RString("項目名付加");
    private static final RString KEY_連番付加 = new RString("連番付加");
    private static final RString KEY_日付編集 = new RString("日付編集");
    private static final RString KEY_給付対象年月FROM = new RString("給付対象年月From");
    private static final RString KEY_給付対象年月TO = new RString("給付対象年月To");
    private static final RString KEY_居宅支援事業者コード = new RString("居宅支援事業者コード");
    private static final RString KEY_居宅支援事業者名 = new RString("居宅支援事業者名");
    private static final RString KEY_保険者コード = new RString("保険者コード");
    private static final RString KEY_委託先支援事業者コード = new RString("委託先支援事業者コード");
    private static final RString KEY_委託先支援事業者名 = new RString("委託先支援事業者名");
    private static final RString KEY_明細行出力有無 = new RString("明細行出力有無");
    private static final RString KEY_日付スラッシュ付加 = new RString("日付スラッシュ付加");
    private static final RString KEY_出力順 = new RString("出力順");
    private static final RString KEY_出力項目 = new RString("出力項目");
    private static final RString 台帳種別表示無し = new RString("台帳種別表示無し");

    /**
     * コンストラクタです。
     *
     * @param div HanyoListParamKyoufuKannrihyouDiv
     */
    public HanyoListParamKyoufuKannrihyouHandler(HanyoListParamKyoufuKannrihyouDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     */
    public void initialize() {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = shichosonSecurityJoho.get導入形態コード();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getKey())) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisplayNone(false);
            div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務);
        } else {
            div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().setDisplayNone(false);
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisabled(true);
            div.getChushutsuJokenPanel().getCcdHokenshaList().setVisible(false);
        }

        div.getCcdShutsuryokuKoumoku().setDisabled(true);
        div.getCcdShutsuryokuKoumoku().setVisible(true);
        ViewStateHolder.put(ViewStateKeys.台帳種別表示, 台帳種別表示無し);
        div.getChushutsuJokenPanel().getＣｃｄKyotakuSienJigyoshaBango().initialize();
        div.getChushutsuJokenPanel().getＣｃｄKyotakuSienJigyoshaBango().getRadKaigoHokenShisetsu().setDisplayNone(true);
        div.getChushutsuJokenPanel().getＣｃｄKyotakuSienJigyoshaBango().getRadOtherTokureiShisetsu().setDisplayNone(true);
        div.getChushutsuJokenPanel().getＣｃｄKyotakuSienJigyoshaBango().getRadTekiyoJyogaiShisetsu().setDisplayNone(true);
        div.getChushutsuJokenPanel().getCcdItakusakiSienJigyoshaBango().initialize();
        div.getChushutsuJokenPanel().getCcdItakusakiSienJigyoshaBango().getRadKaigoHokenShisetsu().setDisplayNone(true);
        div.getChushutsuJokenPanel().getCcdItakusakiSienJigyoshaBango().getRadOtherTokureiShisetsu().setDisplayNone(true);
        div.getChushutsuJokenPanel().getCcdItakusakiSienJigyoshaBango().getRadTekiyoJyogaiShisetsu().setDisplayNone(true);
        List<RString> keyList = new ArrayList<>();
        keyList.add(KEY_項目名付加);
        keyList.add(KEY_日付編集);
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(keyList);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701008.getReportId());
        div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701008.getReportId().getColumnValue(), SubGyomuCode.DBC介護給付);
    }

    /**
     * バッチ実行のメソッドです。
     *
     * @return parameter DBC710080_HanyoListKyufuKanriHyoParameter
     */
    public DBC710080_HanyoListKyufuKanriHyoParameter バッチ実行() {
        DBC710080_HanyoListKyufuKanriHyoParameter parameter = new DBC710080_HanyoListKyufuKanriHyoParameter();

        parameter.set給付対象年月From(div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().getFromValue());
        parameter.set給付対象年月To(div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().getToValue());

        parameter.set居宅支援事業者コード(div.getChushutsuJokenPanel().getＣｃｄKyotakuSienJigyoshaBango().getNyuryokuShisetsuKodo());
        parameter.set居宅支援事業者名(div.getChushutsuJokenPanel().getＣｃｄKyotakuSienJigyoshaBango().getNyuryokuShisetsuMeisho());
        parameter.set委託先支援事業者コード(div.getChushutsuJokenPanel().getCcdItakusakiSienJigyoshaBango().getNyuryokuShisetsuKodo());
        parameter.set委託先支援事業者名(div.getChushutsuJokenPanel().getCcdItakusakiSienJigyoshaBango().getNyuryokuShisetsuMeisho());

        RString key = div.getChushutsuJokenPanel().getRadMeisaigyoSyuturyokuUmu().getSelectedKey();
        if (KEY_0.equals(key)) {
            parameter.set明細行出力有無(KyufuKanrihyo_MeisaigyoKubun.集計行のみ.getコード());
        } else if (KEY_1.equals(key)) {
            parameter.set明細行出力有無(RString.EMPTY);
        }

        List<RString> keyList = div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().getSelectedKeys();
        if (keyList.contains(KEY_項目名付加)) {
            parameter.set項目名付加(true);
        } else {
            parameter.set項目名付加(false);
        }

        if (keyList.contains(KEY_連番付加)) {
            parameter.set連番付加(true);
        } else {
            parameter.set連番付加(false);
        }

        if (keyList.contains(KEY_日付編集)) {
            parameter.set日付スラッシュ付加(true);
        } else {
            parameter.set日付スラッシュ付加(false);
        }

        if (div.getChushutsuJokenPanel().getCcdHokenshaList().isVisible()) {
            parameter.set保険者コード(div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード());
        }

        parameter.set出力順(div.getCcdShutsuryokujun().get出力順ID());

        if (!div.getCcdShutsuryokuKoumoku().isDisabled()) {
            parameter.set出力項目(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        } else {
            parameter.set出力項目(RString.EMPTY);
        }

        return parameter;
    }

    /**
     * 条件を復元するボタンのメソッドです。
     *
     */
    public void pamaRestore() {
        BatchParameterMap restoreBatchParameterMap = div.getJokenFukugenHozonl().getBtnBatchParameterRestore()
                .getRestoreBatchParameterMap();
        RDate 給付対象年月From = restoreBatchParameterMap.getParameterValue(RDate.class, KEY_給付対象年月FROM);
        div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().clearFromValue();
        div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().clearToValue();
        if (給付対象年月From != null) {
            div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().setFromValue(給付対象年月From);
        }
        RDate 給付対象年月To = restoreBatchParameterMap.getParameterValue(RDate.class, KEY_給付対象年月TO);
        if (給付対象年月To != null) {
            div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().setToValue(給付対象年月To);
        }
        RString 居宅支援事業者コード = restoreBatchParameterMap.getParameterValue(RString.class, KEY_居宅支援事業者コード);
        if (居宅支援事業者コード != null) {
            div.getChushutsuJokenPanel().getＣｃｄKyotakuSienJigyoshaBango().setNyuryokuShisetsuKodo(居宅支援事業者コード);
        }
        RString 居宅支援事業者名 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_居宅支援事業者名);
        if (居宅支援事業者名 != null) {
            div.getChushutsuJokenPanel().getＣｃｄKyotakuSienJigyoshaBango().setShisetsuMeisho(居宅支援事業者名);
        }
        RString 委託先支援事業者コード = restoreBatchParameterMap.getParameterValue(RString.class, KEY_委託先支援事業者コード);
        if (委託先支援事業者コード != null) {
            div.getChushutsuJokenPanel().getCcdItakusakiSienJigyoshaBango().setNyuryokuShisetsuKodo(委託先支援事業者コード);
        }
        RString 委託先支援事業者名 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_委託先支援事業者名);
        if (委託先支援事業者名 != null) {
            div.getChushutsuJokenPanel().getCcdItakusakiSienJigyoshaBango().setShisetsuMeisho(委託先支援事業者名);
        }
        RString 明細行出力有無 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_明細行出力有無);
        if (!RString.isNullOrEmpty(明細行出力有無)) {
            div.getChushutsuJokenPanel().getRadMeisaigyoSyuturyokuUmu().setSelectedKey(KEY_0);
        } else {
            div.getChushutsuJokenPanel().getRadMeisaigyoSyuturyokuUmu().setSelectedKey(KEY_1);
        }
        List<RString> csv編集方法リスト = new ArrayList<>();
        boolean 項目名付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_項目名付加);
        if (項目名付加) {
            csv編集方法リスト.add(KEY_項目名付加);
        }
        boolean 連番付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_連番付加);
        if (連番付加) {
            csv編集方法リスト.add(KEY_連番付加);
        }
        boolean 日付スラッシュ付加 = restoreBatchParameterMap.getParameterValue(boolean.class, KEY_日付スラッシュ付加);
        if (日付スラッシュ付加) {
            csv編集方法リスト.add(KEY_日付編集);
        }
        div.getDvCsvHenshuHoho().getChkCsvHenshuHoho().setSelectedItemsByKey(csv編集方法リスト);
        LasdecCode 保険者コード = restoreBatchParameterMap.getParameterValue(LasdecCode.class, KEY_保険者コード);

        if (保険者コード != null) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().loadHokenshaList(GyomuBunrui.介護事務);
            if (!保険者コード.isEmpty()) {
                div.getChushutsuJokenPanel().getCcdHokenshaList().setSelectedShichosonIfExist(保険者コード);
            }
        }
        Long 出力順 = restoreBatchParameterMap.getParameterValue(Long.class, KEY_出力順);
        if (出力順 != null) {
            div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701008.getReportId(), 出力順);
        }
        RString 出力項目 = restoreBatchParameterMap.getParameterValue(RString.class, KEY_出力項目);
        if (RString.isNullOrEmpty(出力項目)) {
            div.getCcdShutsuryokuKoumoku().load(ReportIdDBC.DBC701008.getReportId().getColumnValue(),
                    SubGyomuCode.DBC介護給付, 出力項目);
        }

    }
}
