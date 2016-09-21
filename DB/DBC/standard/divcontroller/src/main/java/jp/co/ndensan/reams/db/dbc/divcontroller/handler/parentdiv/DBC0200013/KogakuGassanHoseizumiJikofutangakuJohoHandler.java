/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0200013;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC110080.DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_KokiKokuhoShoriKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0200013.KogakuGassanHoseizumiJikofutangakuJohoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder._ChohyoShutsuryokujunManager;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;

/**
 * 保険者情報送付データ作成_[37K]高額合算補正済自己負担額情報のハンドラクラスです。
 *
 * @reamsid_L DBC-3300-050 wangxingpeng
 */
public class KogakuGassanHoseizumiJikofutangakuJohoHandler {

    private final KogakuGassanHoseizumiJikofutangakuJohoDiv div;
    private RString 外部ＣＳＶファイル名;
    private RString 処理区分;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final RString 状態パターン = new RString("1");
    private static final ReportId 帳票ID = ReportIdDBC.DBC200032.getReportId();

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanHoseizumiJikofutangakuJohoDiv
     */
    public KogakuGassanHoseizumiJikofutangakuJohoHandler(KogakuGassanHoseizumiJikofutangakuJohoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanHoseizumiJikofutangakuJohoDiv
     * @return ハンドラ
     */
    public static KogakuGassanHoseizumiJikofutangakuJohoHandler of(KogakuGassanHoseizumiJikofutangakuJohoDiv div) {
        return new KogakuGassanHoseizumiJikofutangakuJohoHandler(div);
    }

    /**
     * onloadのメソッドです。
     *
     * @param 再処理区分 RString
     * @param 処理年月 RYearMonth
     * @param 交換情報識別番号 RString
     */
    public void onload(RString 再処理区分, RYearMonth 処理年月, RString 交換情報識別番号) {
        if (交換情報識別番号.length() == NUM_4) {
            処理区分 = 交換情報識別番号.substring(NUM_3);
            div.getTxtShoriTaisho().setValue(KaigoGassan_KokiKokuhoShoriKubun.toValue(処理区分).get名称());
            div.getTxtShori().setValue(処理区分);
        } else {
            div.getTxtShoriTaisho().setValue(RString.EMPTY);
            div.getTxtShori().setValue(RString.EMPTY);
        }
        RDate 基準日 = RDate.getNowDate();
        外部ＣＳＶファイル名 = DbBusinessConfig.get(ConfigNameDBC.国保連送付媒体_補正自己負担Ｆ_外部ＣＳＶファイル名, 基準日, SubGyomuCode.DBC介護給付);
        div.getCcdKokuhorenJohoSofu().initialize(処理年月, 再処理区分, 外部ＣＳＶファイル名, 状態パターン);
        div.getCcdShutsuryokujun().load(SubGyomuCode.DBC介護給付, 帳票ID);
    }

    /**
     * setBatchParameterのメソッドです。
     *
     * @param 再処理区分 RString
     * @param 処理年月 RYearMonth
     * @return DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter
     */
    public DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter setBatchParameter(RString 再処理区分,
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
            DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter parameter = new DBC110080_KogakugassanHoseisumiJikofutangakuOutParameter();
            parameter.setSaishoriKubun(再処理区分);
            FlexibleYearMonth 処理年月Fle = 処理年月 == null ? FlexibleYearMonth.EMPTY : new FlexibleYearMonth(処理年月.toDateString());
            parameter.setShoriYM(処理年月Fle);
            if (div.getTxtShori().getValue() == null || div.getTxtShori().getValue().isEmpty()) {
                parameter.setShoriKunbun(RString.EMPTY);
            } else {
                parameter.setShoriKunbun(div.getTxtShori().getValue());
            }
            parameter.setShutsuryokujunId(new RString(出力順ID.toString()));
            return parameter;
        }
        return null;
    }
}
