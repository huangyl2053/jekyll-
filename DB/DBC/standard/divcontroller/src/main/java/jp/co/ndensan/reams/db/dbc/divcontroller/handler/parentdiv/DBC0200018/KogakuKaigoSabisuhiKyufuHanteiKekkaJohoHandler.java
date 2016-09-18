/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200018;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110040.DBC110040_KogakuServicehiHanteikekkaOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200018.KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv;
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
 * 画面設計_DBCMNF1001_保険者情報送付データ作成_[341]高額介護サービス費給付判定結果情報のハンドラクラスです。
 *
 * @reamsid_L DBC-3300-100 wangxingpeng
 */
public class KogakuKaigoSabisuhiKyufuHanteiKekkaJohoHandler {

    private final KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv div;
    private static final ReportId 帳票ID = ReportIdDBC.DBC200019.getReportId();

    /**
     * コンストラクタです。
     *
     * @param div KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv
     */
    public KogakuKaigoSabisuhiKyufuHanteiKekkaJohoHandler(KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv
     * @return ハンドラ
     */
    public static KogakuKaigoSabisuhiKyufuHanteiKekkaJohoHandler of(KogakuKaigoSabisuhiKyufuHanteiKekkaJohoDiv div) {
        return new KogakuKaigoSabisuhiKyufuHanteiKekkaJohoHandler(div);
    }

    /**
     * setBatchParameterのメソッドです。
     *
     * @param 再処理区分 RString
     * @param 処理年月 RYearMonth
     * @return DBC110040_KogakuServicehiHanteikekkaOutParameter
     */
    public DBC110040_KogakuServicehiHanteikekkaOutParameter setBatchParameter(RString 再処理区分,
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
            DBC110040_KogakuServicehiHanteikekkaOutParameter parameter = new DBC110040_KogakuServicehiHanteikekkaOutParameter();
            parameter.set再処理区分(再処理区分);
            parameter.set処理年月(処理年月);
            parameter.set出力順ID(new RString(出力順ID.toString()));
            return parameter;
        }
        return null;
    }
}
