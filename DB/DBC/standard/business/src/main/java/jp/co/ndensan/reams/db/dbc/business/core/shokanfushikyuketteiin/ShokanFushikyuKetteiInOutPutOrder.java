/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanfushikyuketteiin;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払不支給決定情報取込enum
 *
 * @reamsid_L DBC-2590-010 xuhao
 */
public enum ShokanFushikyuKetteiInOutPutOrder implements IReportItems {

    /**
     * 事業者番号
     */
    事業者番号("00002", "", "TEMP.\"jigyoshoNo\""),
    /**
     * 被保険者番号
     */
    被保険者番号("00001", "", "TEMP.\"hiHokenshaNo\"");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private ShokanFushikyuKetteiInOutPutOrder(String 項目ID, String フォームフィールド名, String myBatis項目名) {
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
