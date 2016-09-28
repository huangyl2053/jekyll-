/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012001;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴平準化（特徴6月分）バッチ平準化前賦課Temp出力です。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
public class PrtKaigoFukaTokuchoHeijunkaCore {

    private static final ReportId 帳票ID = ReportIdDBB.DBB200003.getReportId();

    /**
     * 出力順を取得するメソッドです。
     *
     * @param 出力順ID RString
     * @return 導入団体クラス
     */
    public IOutputOrder beforeExecuteCore(RString 出力順ID) {
        return ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 帳票ID,
                Long.parseLong(出力順ID.toString()));
    }

    /**
     * 市町村情報を取得するメソッドです。
     *
     * @return 市町村情報
     */
    public Association getAssociation() {
        return AssociationFinderFactory.createInstance().getAssociation();
    }
}
