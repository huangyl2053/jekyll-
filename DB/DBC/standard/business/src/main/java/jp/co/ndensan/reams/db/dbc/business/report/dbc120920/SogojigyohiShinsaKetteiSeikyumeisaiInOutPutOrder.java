/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc120920;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 
帳票設計_DBC200084_総合事業費審査決定請求明細表帳票のPageBreakenum。
 *
 * @reamsid_L DBC-2500-032 jiangxiaolong
 */
public enum SogojigyohiShinsaKetteiSeikyumeisaiInOutPutOrder implements IReportItems {

    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("shoKisaiHokenshaNo"), new RString("\"DbWT1613SinsaKetteiSeikyuGokei\".\"shoKisaiHokenshaNo\"")),
    /**
     * 事業者番号
     */
    事業者番号(new RString("0366"), new RString("listMeisai_1"), new RString("\"DbWT1611SinsaKetteiSeikyuMeisai\".\"jigyoshoNo\"")),
    /**
     * サービス提供年月
     */
    サービス提供年月(new RString("0364"), new RString("listMeisai_3"), new RString("\"DbWT1611SinsaKetteiSeikyuMeisai\".\"serviceTeikyouYM\"")),
    /**
     * サービス種類コード
     */
    サービス種類コード(new RString("0308"), new RString("listMeisai_4"), new RString("\"DbWT1611SinsaKetteiSeikyuMeisai\".\"serviceShuruiCode\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private SogojigyohiShinsaKetteiSeikyumeisaiInOutPutOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
        this.項目ID = 項目ID;
        this.フォームフィールド名 = フォームフィールド名;
        this.myBatis項目名 = myBatis項目名;
    }

    @Override
    public RString get項目ID() {
        return 項目ID;
    }

    @Override
    public RString getフォームフィールド名() {
        return フォームフィールド名;
    }

    @Override
    public RString getMyBatis項目名() {
        return myBatis項目名;
    }

}
