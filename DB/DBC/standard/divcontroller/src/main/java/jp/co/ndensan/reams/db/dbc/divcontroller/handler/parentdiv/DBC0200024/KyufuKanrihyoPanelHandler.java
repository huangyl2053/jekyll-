/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200024;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110010.DBC110010_KyufukanrihyoOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200024.KyufuKanrihyoPanelDiv;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[821]給付管理票のハンドラクラスです。
 *
 * @reamsid_L DBC-3300-120 wangxingpeng
 */
public class KyufuKanrihyoPanelHandler {

    private final KyufuKanrihyoPanelDiv div;
    private static final ReportId 帳票ID = ReportIdDBC.DBC200009.getReportId();

    /**
     * コンストラクタです。
     *
     * @param div KyufuKanrihyoPanelDiv
     */
    public KyufuKanrihyoPanelHandler(KyufuKanrihyoPanelDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div KyufuKanrihyoPanelDiv
     * @return ハンドラ
     */
    public static KyufuKanrihyoPanelHandler of(KyufuKanrihyoPanelDiv div) {
        return new KyufuKanrihyoPanelHandler(div);
    }

    /**
     * setBatchParameterのメソッドです。
     *
     * @param 再処理区分 RString
     * @param 処理年月 RYearMonth
     * @return DBC110010_KyufukanrihyoOutParameter
     */
    public DBC110010_KyufukanrihyoOutParameter setBatchParameter(RString 再処理区分,
            RYearMonth 処理年月) {
        if (div.getCcdShutsuryokujun().get出力順ID() != null) {
            Long 出力順ID = div.getCcdShutsuryokujun().get出力順ID();
            IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
            IOutputOrder iOutputOrder = finder.get出力順(
                    SubGyomuCode.DBC介護給付,
                    帳票ID,
                    出力順ID);
            if (iOutputOrder != null) {
                IChohyoShutsuryokujunManager manager = new _ChohyoShutsuryokujunManager();
                manager.save前回出力順(iOutputOrder);
            }
            DBC110010_KyufukanrihyoOutParameter parameter = new DBC110010_KyufukanrihyoOutParameter();
            parameter.set再処理区分(再処理区分);
            parameter.set処理年月(処理年月);
            parameter.set出力順ID(new RString(出力順ID.toString()));
            parameter.set最終更新年月日(div.getTxtSaishuKoshinbi().getValue());
            return parameter;
        }
        return null;
    }
}
