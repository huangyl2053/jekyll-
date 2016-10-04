/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010010.DBU010010_JigyoHokokuGeppo_MainParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010020.DBU010020_JigyoHokokuGeppo_IppanParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010090.DBU010090_JigyoHokokuGeppo_HokenkyufuKogakuParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU010100.DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBU010000_事業状況報告資料（月報）作成(親)のバッチフ処理クラスです。
 *
 * @reamsid_L DBU-5550-060 dongyabin
 */
public class DBU010010_JigyoHokokuGeppo_Main extends BatchFlowBase<DBU010010_JigyoHokokuGeppo_MainParameter> {

    private static final String CALL_FLOW_DBU010090 = "DBU010090_JigyoHokokuGeppo_HokenkyufuKogaku";
    private static final RString DBU010090FLOW_FLOWID = new RString("DBU010090_JigyoHokokuGeppo_HokenkyufuKogaku");
    private static final String CALL_FLOW_DBU010100 = "DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassan";
    private static final RString DBU010100FLOW_FLOWID = new RString("DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassan");
    private static final String 事業報告月報_一般状況 = "DBU010020_JigyoHokokuGeppo_Ippan";
    private static final RString 事業報告月報_一般状況_FLOWID = new RString("DBU010020_JigyoHokokuGeppo_Ippan");
    private static final RString 出力区分_1 = new RString("1");
    private static final int 連番_1 = 1;
    private static final int 連番_2 = 2;
    private static final int 連番_3 = 3;
    private static final int 連番_6 = 6;
    private static final int 連番_7 = 7;
    private static final int 連番_8 = 7;

    @Override
    protected void defineFlow() {
        if (出力区分_1.equals(getParameter().getSyutyoryokuKubun().get(0))) {
            executeStep(事業報告月報_一般状況);
        }
        if (出力区分_1.equals(getParameter().getSyutyoryokuKubun().get(連番_7))) {
            executeStep(CALL_FLOW_DBU010090);
        }
        if (出力区分_1.equals(getParameter().getSyutyoryokuKubun().get(連番_8))) {
            executeStep(CALL_FLOW_DBU010100);
        }
    }

    /**
     * 事業報告月報_一般状況です。
     *
     * @return IBatchFlowCommand
     */
    @Step(事業報告月報_一般状況)
    protected IBatchFlowCommand callJigyoHokokuGeppo_Ippan() {
        DBU010020_JigyoHokokuGeppo_IppanParameter parameter = new DBU010020_JigyoHokokuGeppo_IppanParameter();
        parameter.setPrintControlKbn(getParameter().getPrintControlKbn());
        parameter.setSyukeiYM(new FlexibleYearMonth(getParameter().getShuukeiNengetu().get(0)));
        parameter.setHokokuYM(new FlexibleYearMonth(getParameter().getHoukokuNengetu()));
        parameter.setNendo(new FlexibleYear(getParameter().getNendo().get(0)));
        parameter.setSakuseiYMD(new RString(getParameter().getSakuseiNitizi().get(0).toString()));
        parameter.setSyoriYMDHMS(new YMDHMS(getParameter().getSyoriNitizi().getDate(), getParameter().getSyoriNitizi().getTime()));
        parameter.setKyuShichosonKbn(getParameter().getOldShichosonKubun());
        parameter.setKoseiShichosonKbn(getParameter().getKouseiShichosonKubun());
        parameter.setShichosonCode(getParameter().getShichosonCode().value());
        parameter.setKoseiShichosonList(codeList(getParameter().getKouseiShichosonCode()));
        parameter.setKyuShichosonList(codeList(getParameter().getOldShichosonCode()));
        parameter.setKakoShukeiShichosonList(getParameter().getShuukeibunShichosonCode());
        parameter.setKakoShukeiKyuShichosonKbn(getParameter().getShuukeibunShichosonKubun());
        parameter.setSakuseiCSVFileID(getParameter().getCsvID().get(0));
        parameter.setBatchID(getParameter().getBatchID().get(0));
        return otherBatchFlow(事業報告月報_一般状況_FLOWID, SubGyomuCode.DBU介護統計報告, parameter).define();
    }

    /**
     * 事業状況報告資料（月報）作成 保険給付決定情報（高額介護サービス費）です。
     *
     * @return DBU010090_JigyoHokokuGeppo_HokenkyufuKogaku
     */
    @Step(CALL_FLOW_DBU010090)
    protected IBatchFlowCommand callDbu010090Flow() {
        DBU010090_JigyoHokokuGeppo_HokenkyufuKogakuParameter parameter = new DBU010090_JigyoHokokuGeppo_HokenkyufuKogakuParameter();
        parameter.setバッチID(getParameter().getBatchID().get(連番_7));
        parameter.setプリントコントロール区分(getParameter().getPrintControlKbn());
        parameter.set作成日時(new RString(getParameter().getSakuseiNitizi().get(連番_7).toString()));
        parameter.set処理日時(new RString(getParameter().getSyoriNitizi().toString()));
        parameter.set報告年月(getParameter().getHoukokuNengetu());
        parameter.set市町村コード(getParameter().getShichosonCode().value());
        parameter.set年度(getParameter().getNendo().get(連番_2));
        parameter.set旧市町村コードリスト(codeList(getParameter().getOldShichosonCode()));
        parameter.set旧市町村区分(getParameter().getOldShichosonKubun());
        parameter.set構成市町村コードリスト(codeList(getParameter().getKouseiShichosonCode()));
        parameter.set構成市町村区分(getParameter().getKouseiShichosonKubun());
        parameter.set過去集計分市町村コードリスト(getParameter().getShuukeibunShichosonCode());
        parameter.set過去集計分旧市町村区分(getParameter().getShuukeibunShichosonKubun());
        parameter.set集計年月(getParameter().getShuukeiNengetu().get(連番_6));
        return otherBatchFlow(DBU010090FLOW_FLOWID, SubGyomuCode.DBU介護統計報告, parameter).define();
    }

    /**
     * 事業状況報告資料（月報）作成 保険給付決定状況（高額合算分）です。
     *
     * @return DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter
     */
    @Step(CALL_FLOW_DBU010100)
    protected IBatchFlowCommand callDbu010100Flow() {
        DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter parameter = new DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanParameter();
        parameter.setバッチID(getParameter().getBatchID().get(連番_8));
        parameter.setプリントコントロール区分(getParameter().getPrintControlKbn());
        parameter.set報告区分(getParameter().getHokokuKubun());
        parameter.set報告年月(getParameter().getHoukokuNengetu());
        parameter.set年度(getParameter().getNendo().get(連番_3));
        parameter.set決定年月(getParameter().getKetteiYm().get(連番_1));
        parameter.set報告年度(getParameter().getHokokuNendo());
        parameter.set集計年度(getParameter().getShukeiNendo());
        parameter.set集計開始年月(getParameter().getKaishiYm());
        parameter.set集計終了年月(getParameter().getShusyoYm());
        parameter.set作成日時(new RString(getParameter().getSakuseiNitizi().get(連番_8).toString()));
        parameter.set処理日時(new RString(getParameter().getSyoriNitizi().toString()));
        parameter.set市町村コード(getParameter().getShichosonCode().value());
        parameter.set構成市町村区分(getParameter().getKouseiShichosonKubun());
        parameter.set旧市町村区分(getParameter().getOldShichosonKubun());
        parameter.set旧市町村コードリスト(codeList(getParameter().getOldShichosonCode()));
        parameter.set構成市町村コードリスト(codeList(getParameter().getKouseiShichosonCode()));
        parameter.set過去集計分市町村コードリスト(getParameter().getShuukeibunShichosonCode());
        parameter.set過去集計分旧市町村区分(getParameter().getShuukeibunShichosonKubun());
        return otherBatchFlow(DBU010100FLOW_FLOWID, SubGyomuCode.DBU介護統計報告, parameter).define();
    }

    private List<RString> codeList(List<LasdecCode> 市町村コードリスト) {
        List<RString> コードリスト = new ArrayList();
        for (LasdecCode shichosonCode : 市町村コードリスト) {
            コードリスト.add(shichosonCode.value());
        }
        return コードリスト;
    }
}
