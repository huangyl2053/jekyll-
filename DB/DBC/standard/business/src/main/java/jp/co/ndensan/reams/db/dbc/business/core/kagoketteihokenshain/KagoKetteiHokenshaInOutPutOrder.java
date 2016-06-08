/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kagoketteihokenshain;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤決定通知書情報取込（保険者分）enum
 *
 * @reamsid_L DBC-0980-300 xupeng
 */
public enum KagoKetteiHokenshaInOutPutOrder implements IReportItems {

    /**
     * 被保険者番号
     */
    被保険者番号("listLower1_1", "", "Meisai.\"hiHokenshaNo\""),
    /**
     * 事業者番号
     */
    事業者番号("listUpper_3", "", "Meisai.\"jigyoshoNo\""),
    /**
     * 取扱年月
     */
    取扱年月("listUpper_2", "", "Meisai.\"toriatsukaiYM\"");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KagoKetteiHokenshaInOutPutOrder(String 項目ID, String フォームフィールド名, String myBatis項目名) {
        this.項目ID = new RString(項目ID);
        this.フォームフィールド名 = new RString(フォームフィールド名);
        this.myBatis項目名 = new RString(myBatis項目名);
    }

    @Override
    public RString get項目ID() {
        return this.項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return this.フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return this.myBatis項目名;
    }

}
