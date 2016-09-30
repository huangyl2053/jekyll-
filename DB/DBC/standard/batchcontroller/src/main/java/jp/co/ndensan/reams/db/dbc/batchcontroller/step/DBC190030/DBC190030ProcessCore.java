/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030;

import jp.co.ndensan.reams.db.dbc.business.core.dbc190030.DBC190030OutPutOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC110065_基準収入額適用申請書_異動分作成のutilクラス。
 *
 * @reamsid_L DBC-4640-030 liuyang
 */
public class DBC190030ProcessCore {

    private static final RString ORDERBY = new RString("order by");

    /**
     * init出力順のメソッドです。
     *
     * @param 帳票ID ReportId
     * @param 出力順ID Long
     * @return RString
     */
    public RString init出力順(ReportId 帳票ID, Long 出力順ID) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBC介護給付, 帳票ID, 出力順ID);
        RString 出力順 = MyBatisOrderByClauseCreator.create(DBC190030OutPutOrder.class, outputOrder);
        return 出力順.replace(ORDERBY, RString.EMPTY);
    }
}
