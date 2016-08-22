/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7080001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc710080.DBC710080_HanyoListKyufuKanriHyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.chushutsujoken.ChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7080001.HanyoListParamDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(給付管理票)
 *
 * @reamsid_L DBC-3096-010 zhengshenlei
 */
public class HanyoListParamHandler {

    private final HanyoListParamDiv div;
    private static final RString 帳票ID = new RString("DBC701008_HanyoList_KyufuKanriHyo");
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString KEY_項目名付加 = new RString("項目名付加");
    private static final RString KEY_連番付加 = new RString("連番付加");
    private static final RString KEY_日付編集 = new RString("日付編集");
    private static final RString 広域 = new RString("広域");
    private static final RString 単一 = new RString("単一");

    /**
     * コンストラクタです。
     *
     * @param div NendoKirikaeDiv
     */
    public HanyoListParamHandler(HanyoListParamDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     */
    public void initialize() {
        RString 稼働市町村;
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = shichosonSecurityJoho.get導入形態コード();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getKey())) {
            稼働市町村 = 広域;
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisplayNone(true);
        } else {
            稼働市町村 = 単一;
            div.getChushutsuJokenPanel().getTxtKyufuTaishoNengetu().setDisplayNone(true);
        }
        if (単一 == 稼働市町村) {
            div.getChushutsuJokenPanel().getCcdHokenshaList().setDisabled(true);
            div.getChushutsuJokenPanel().getCcdHokenshaList().setVisible(false);
        }

        div.getCcdShutsuryokuKoumoku().setDisabled(true);

        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, new ReportId(帳票ID));
        div.getCcdShutsuryokuKoumoku().load(帳票ID, SubGyomuCode.DBC介護給付);
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
            parameter.set明細行出力有無(ChushutsuJoken.終端行);
        } else if (KEY_1.equals(key)) {
            parameter.set明細行出力有無(null);
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

        if (!div.getChushutsuJokenPanel().getCcdHokenshaList().isDisplayNone()) {
            parameter.set保険者コード(div.getChushutsuJokenPanel().getCcdHokenshaList().getSelectedItem().get市町村コード());
        }

        parameter.set出力順(div.getCcdShutsuryokujun().get出力順ID());

        if (!div.getCcdShutsuryokuKoumoku().isDisabled()) {
            parameter.set出力項目(div.getCcdShutsuryokuKoumoku().get出力項目ID());
        } else {
            parameter.set出力項目(null);
        }

        return parameter;
    }
}
