/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030010.DBU030010_JigyoHokokuNenpo_MainParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030040.DBU030040_JigyoHokokuNenpo_IppanGenbutsuParameter;
import jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU030070.DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBU030000_事業状況報告資料（年報）作成(親)のバッチフロークラスです。
 *
 * @reamsid_L DBU-5600-290 lishengli
 */
public class DBU030010_JigyoHokokuNenpo_Main extends BatchFlowBase<DBU030010_JigyoHokokuNenpo_MainParameter> {

    private static final String 事業状況報告資料年報作成様式１_２ = "事業状況報告資料（年報）作成　様式１・２";
    private static final RString 事業状況報告資料年報作成様式１_２バッチID = new RString("DBU030020_JigyoHokokuNenpo_Yoshiki1To2");
    private static final String 事業状況報告資料年報作成一般状況_１_１１ = "事業状況報告資料（年報）作成　一般状況（１～１１）";
    private static final RString 事業状況報告資料年報作成一般状況_１_１１バッチID = new RString("DBU030030_JigyoHokokuNenpo_Ippan");
    private static final String 事業状況報告資料年報作成一般状況_１２_１４_3 = "事業状況報告資料（年報）作成　一般状況（１２～１４）_3";
    private static final String 事業状況報告資料年報作成一般状況_１２_１４_4 = "事業状況報告資料（年報）作成　一般状況（１２～１４）_4";
    private static final RString 事業状況報告資料年報作成一般状況_１２_１４バッチID = new RString("DBU030040_JigyoHokokuNenpo_IppanGenbutsu");
    private static final String 事業状況報告資料年報作成_保険給付決定情報_5 = "事業状況報告資料（年報）作成　保険給付決定情報_5";
    private static final String 事業状況報告資料年報作成_保険給付決定情報_6 = "事業状況報告資料（年報）作成　保険給付決定情報_6";
    private static final RString 事業状況報告資料年報作成_保険給付決定情報バッチID = new RString("DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsu");
    private static final String 事業状況報告資料年報作成_保険給付決定状況_高額分 = "事業状況報告資料（年報）作成　保険給付決定状況(高額分)";
    private static final RString 事業状況報告資料年報作成_保険給付決定状況_高額分バッチID
            = new RString("DBU030100_JigyoHokokuNenpo_HokenkyufuKogaku");
    private static final String 事業状況報告資料月報作成_保険給付決定状況_高額合算分 = "事業状況報告資料（月報）作成　保険給付決定状況(高額合算分)";
    private static final RString 事業状況報告資料月報作成_保険給付決定状況_高額合算分バッチID
            = new RString("DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassan");
    private static final RString 選択 = new RString("1");
    private static final RString 給付集計区分_1 = new RString("1");
    private static final RString 給付集計区分_2 = new RString("2");
    private static final RString 給付集計区分_3 = new RString("3");
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;

    @Override
    protected void defineFlow() {
        if (選択.equals(getParameter().get出力区分リスト().get(1))) {
            executeStep(事業状況報告資料年報作成様式１_２);
        }
        if (選択.equals(getParameter().get出力区分リスト().get(2))) {
            executeStep(事業状況報告資料年報作成一般状況_１_１１);
        }
        if (選択.equals(getParameter().get出力区分リスト().get(INDEX_3))) {
            executeStep(事業状況報告資料年報作成一般状況_１２_１４_3);
        }
        if (給付集計区分_2.equals(getParameter().get出力区分リスト().get(INDEX_4))
                || 給付集計区分_3.equals(getParameter().get出力区分リスト().get(INDEX_4))) {
            executeStep(事業状況報告資料年報作成一般状況_１２_１４_4);
        }
        if (選択.equals(getParameter().get出力区分リスト().get(INDEX_5))) {
            executeStep(事業状況報告資料年報作成_保険給付決定情報_5);
        }
        if (給付集計区分_2.equals(getParameter().get出力区分リスト().get(INDEX_6))
                || 給付集計区分_3.equals(getParameter().get出力区分リスト().get(INDEX_6))) {
            executeStep(事業状況報告資料年報作成_保険給付決定情報_6);
        }
        if (選択.equals(getParameter().get出力区分リスト().get(INDEX_7))) {
            executeStep(事業状況報告資料年報作成_保険給付決定状況_高額分);
        }
        if (選択.equals(getParameter().get出力区分リスト().get(INDEX_8))) {
            executeStep(事業状況報告資料月報作成_保険給付決定状況_高額合算分);
        }
    }

    /**
     * 事業状況報告資料（年報）作成　様式１・２バッチのです。
     *
     * @return DBU030020_JigyoHokokuNenpo_Yoshiki1To2
     */
    @Step(事業状況報告資料年報作成様式１_２)
    protected IBatchFlowCommand callDBU030020_JigyoHokokuNenpo_Yoshiki1To2Flow() {
        //TODO 事業状況報告資料（年報）作成　様式１・２時装なし。対応不可。
        return otherBatchFlow(事業状況報告資料年報作成様式１_２バッチID, SubGyomuCode.DBU介護統計報告, getParameter()).define();
    }

    /**
     * 事業状況報告資料（年報）作成　一般状況（１～１１）バッチのです。
     *
     * @return DBU030030_JigyoHokokuNenpo_Ippan
     */
    @Step(事業状況報告資料年報作成一般状況_１_１１)
    protected IBatchFlowCommand callDBU030030_JigyoHokokuNenpo_IppanFlow() {
        return otherBatchFlow(事業状況報告資料年報作成一般状況_１_１１バッチID,
                SubGyomuCode.DBU介護統計報告, getParameter().toDBU030030Parameter()).define();
    }

    /**
     * 事業状況報告資料（年報）作成　一般状況（１２～１４）バッチのです。
     *
     * @return DBU030040_JigyoHokokuNenpo_IppanGenbutsu
     */
    @Step(事業状況報告資料年報作成一般状況_１２_１４_3)
    protected IBatchFlowCommand callDBU030040_JigyoHokokuNenpo_IppanGenbutsu_3Flow() {
        return otherBatchFlow(事業状況報告資料年報作成一般状況_１２_１４バッチID,
                SubGyomuCode.DBU介護統計報告, getDBU030040Parameter(INDEX_3)).define();
    }

    /**
     * 事業状況報告資料（年報）作成　一般状況（１２～１４）バッチのです。
     *
     * @return DBU030040_JigyoHokokuNenpo_IppanGenbutsu
     */
    @Step(事業状況報告資料年報作成一般状況_１２_１４_4)
    protected IBatchFlowCommand callDBU030040_JigyoHokokuNenpo_IppanGenbutsu_4Flow() {
        return otherBatchFlow(事業状況報告資料年報作成一般状況_１２_１４バッチID,
                SubGyomuCode.DBU介護統計報告, getDBU030040Parameter(INDEX_4)).define();
    }

    /**
     * 事業状況報告資料（年報）作成　保険給付決定情報バッチのです。
     *
     * @return DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsu
     */
    @Step(事業状況報告資料年報作成_保険給付決定情報_5)
    protected IBatchFlowCommand callDBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsu_5Flow() {
        return otherBatchFlow(事業状況報告資料年報作成_保険給付決定情報バッチID,
                SubGyomuCode.DBU介護統計報告, getDBU030070Parameter(INDEX_5)).define();
    }

    /**
     * 事業状況報告資料（年報）作成　保険給付決定情報バッチのです。
     *
     * @return DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsu
     */
    @Step(事業状況報告資料年報作成_保険給付決定情報_6)
    protected IBatchFlowCommand callDBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsu_6Flow() {
        return otherBatchFlow(事業状況報告資料年報作成_保険給付決定情報バッチID,
                SubGyomuCode.DBU介護統計報告, getDBU030070Parameter(INDEX_6)).define();
    }

    /**
     * 事業状況報告資料（年報）作成　保険給付決定状況(高額分)バッチのです。
     *
     * @return DBU030100_JigyoHokokuNenpo_HokenkyufuKogaku
     */
    @Step(事業状況報告資料年報作成_保険給付決定状況_高額分)
    protected IBatchFlowCommand callDBU030100_JigyoHokokuNenpo_HokenkyufuKogakuFlow() {
        return otherBatchFlow(事業状況報告資料年報作成_保険給付決定状況_高額分バッチID,
                SubGyomuCode.DBU介護統計報告, getParameter().toDBU030100Parameter()).define();
    }

    /**
     * 事業状況報告資料（月報）作成　保険給付決定状況(高額合算分)バッチのです。
     *
     * @return DBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassan
     */
    @Step(事業状況報告資料月報作成_保険給付決定状況_高額合算分)
    protected IBatchFlowCommand callDBU010100_JigyoHokokuGeppo_HokenkyufuKogakuGassanFlow() {
        return otherBatchFlow(事業状況報告資料月報作成_保険給付決定状況_高額合算分バッチID,
                SubGyomuCode.DBU介護統計報告, getParameter().toDBU010100Parameter()).define();
    }

    private DBU030040_JigyoHokokuNenpo_IppanGenbutsuParameter getDBU030040Parameter(int index) {
        DBU030040_JigyoHokokuNenpo_IppanGenbutsuParameter parameter = new DBU030040_JigyoHokokuNenpo_IppanGenbutsuParameter();
        if (index == INDEX_3) {
            parameter = getParameter().toDBU030040Parameter(getParameter().get集計年度().get(INDEX_3),
                    getParameter().get集計開始年月().get(INDEX_3),
                    getParameter().get集計終了年月().get(INDEX_3), getParameter().get作成日時().get(INDEX_3), 給付集計区分_1);
        } else if (index == INDEX_4) {
            if (給付集計区分_2.equals(getParameter().get出力区分リスト().get(INDEX_4))) {
                parameter = getParameter().toDBU030040Parameter(getParameter().get集計年度().get(INDEX_4),
                        getParameter().get集計開始年月().get(INDEX_4),
                        getParameter().get集計終了年月().get(INDEX_4), getParameter().get作成日時().get(INDEX_4), 給付集計区分_2);
            } else if (給付集計区分_3.equals(getParameter().get出力区分リスト().get(INDEX_4))) {
                parameter = getParameter().toDBU030040Parameter(getParameter().get集計年度().get(INDEX_4),
                        getParameter().get集計開始年月().get(INDEX_4),
                        getParameter().get集計終了年月().get(INDEX_4), getParameter().get作成日時().get(INDEX_4), 給付集計区分_3);
            }
        }
        return parameter;
    }

    private DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter getDBU030070Parameter(int index) {
        DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter parameter = new DBU030070_JigyoHokokuNenpo_HokenkyufuGenbutsuParameter();
        if (index == INDEX_5) {
            parameter = getParameter().toDBU030070Parameter(getParameter().get集計年度().get(INDEX_5),
                    getParameter().get集計開始年月().get(INDEX_5),
                    getParameter().get集計終了年月().get(INDEX_5), getParameter().get作成日時().get(INDEX_5), 給付集計区分_1);
        } else if (index == INDEX_6) {
            if (給付集計区分_2.equals(getParameter().get出力区分リスト().get(INDEX_6))) {
                parameter = getParameter().toDBU030070Parameter(getParameter().get集計年度().get(INDEX_6),
                        getParameter().get集計開始年月().get(INDEX_6),
                        getParameter().get集計終了年月().get(INDEX_6), getParameter().get作成日時().get(INDEX_6), 給付集計区分_2);
            } else if (給付集計区分_3.equals(getParameter().get出力区分リスト().get(INDEX_6))) {
                parameter = getParameter().toDBU030070Parameter(getParameter().get集計年度().get(INDEX_6),
                        getParameter().get集計開始年月().get(INDEX_6),
                        getParameter().get集計終了年月().get(INDEX_6), getParameter().get作成日時().get(INDEX_6), 給付集計区分_3);
            }
        }
        return parameter;
    }

}
