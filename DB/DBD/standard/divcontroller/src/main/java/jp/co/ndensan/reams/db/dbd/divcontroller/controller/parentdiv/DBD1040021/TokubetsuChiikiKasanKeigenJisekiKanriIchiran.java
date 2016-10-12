/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1040021;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD204010.DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.tokuchijissekilist.TargetArea;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.tokuchijissekilist.TargetYearMonth;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021.TokubetsuPanelDiv;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 特別地域加算軽減実績管理リスト(画面）のビジネスクラスです。
 *
 * @reamsid_L DBD-3880-040 xuejm
 */
public class TokubetsuChiikiKasanKeigenJisekiKanriIchiran {

    private final DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter bparameter
            = new DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter();
    private static final ReportId REPORTID = ReportIdDBD.DBD200012.getReportId();
    private static final RString KEY0 = new RString("0");
    private static final RString KEY1 = new RString("1");
    private static final RString KEY2 = new RString("2");

    /**
     * コンストラクタです。
     */
    public TokubetsuChiikiKasanKeigenJisekiKanriIchiran() {
    }

    /**
     * バッチパラメターを取得します．
     *
     * @param div TokubetsuPanelDiv
     * @return 特別地域加算軽減実績管理リスト（画面）バッチパラメター
     */
    public DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter createParameter(TokubetsuPanelDiv div) {
        if (div.getRadTaishoYM().getSelectedKey().equals(KEY1)) {
            bparameter.set対象年月(TargetYearMonth.サービス提供年月);
        } else {
            bparameter.set対象年月(TargetYearMonth.審査年月);
        }

        if (div.getTxtRangeYM().getFromValue() != null) {
            RYearMonth txtrangeymfrom = div.getTxtRangeYM().getFromValue().getYearMonth();
            bparameter.set年月範囲の開始(new FlexibleYearMonth(txtrangeymfrom.toDateString()));
        }

        if (div.getTxtRangeYM().getToValue() != null) {
            RString txtrangeymto = div.getTxtRangeYM().getToValue().getYearMonth().toDateString();
            bparameter.set年月範囲の終了(new FlexibleYearMonth(txtrangeymto));
        }
        bparameter.set事業者番号(div.getCcdShisetsuJohoCommonChildDiv().getNyuryokuShisetsuKodo());
        set地区バッチパラメター(div);
        if (div.getShichosonPanel().isVisible() && div.getCcdHokenshaList().getSelectedItem() != null) {
            bparameter.set市町村コード(div.getCcdHokenshaList().getSelectedItem().get市町村コード());
        }

        ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200012.getReportId());
        bparameter.set改頁出力順ID(div.getCcdChohyoShutsuryokujun().get出力順ID());

        bparameter.set帳票ID(REPORTID);
        return bparameter;
    }

    /**
     * 地区バッチパラメターを取得します．
     *
     * @param div TokubetsuPanelDiv
     * @return 特別地域加算軽減実績管理リスト（画面）バッチパラメター
     */
    public DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter set地区バッチパラメター(TokubetsuPanelDiv div) {
        if (div.getChushutsuJoken().isVisible()) {
            if (div.getDdlChiku().getSelectedKey().equals(KEY0)) {
                set地区(bparameter, TargetArea.全て, RString.EMPTY, RString.EMPTY);
            } else if (div.getDdlChiku().getSelectedKey().equals(KEY1)) {
                set地区(bparameter, TargetArea.住所,
                        div.getChushutsuJoken().getCcdJyuusyoStart().get町域コード().value(),
                        div.getChushutsuJoken().getCcdJyuusyoEnd().get町域コード().value());
            } else if (div.getDdlChiku().getSelectedKey().equals(KEY2)) {
                set地区(bparameter, TargetArea.行政区,
                        div.getChushutsuJoken().getCcdGyouseiStart().get行政区コード().value(),
                        div.getChushutsuJoken().getCcdGyouseiEnd().get行政区コード().value());
            } else {
                set地区(bparameter, TargetArea.地区,
                        div.getChushutsuJoken().getCcdChikuStart().get地区2コード().value(),
                        div.getChushutsuJoken().getCcdChikuEnd().get地区2コード().value());
            }
        }
        return bparameter;
    }

    private void set地区(DBD204010_TokubetsuChiikiKasanKeigenJissekiKanriListParameter bparameter,
            TargetArea 地区コード種類,
            RString 開始地区コード,
            RString 終了地区コード) {
        bparameter.set地区コード種類(地区コード種類);
        bparameter.set開始地区コード(開始地区コード);
        bparameter.set終了地区コード(終了地区コード);
    }
}
