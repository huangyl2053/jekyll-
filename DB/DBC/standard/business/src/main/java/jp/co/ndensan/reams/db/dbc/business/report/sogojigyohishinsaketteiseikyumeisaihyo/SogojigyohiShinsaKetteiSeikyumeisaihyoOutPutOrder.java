/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohishinsaketteiseikyumeisaihyo;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 帳票設計_DBC200070_介護予防・日常生活支援総合事業費審査決定請求明細表のPageBreakenumクラスです
 *
 * @reamsid_L DBC-2500-031 jiangwenkai
 */
public enum SogojigyohiShinsaKetteiSeikyumeisaihyoOutPutOrder implements IReportItems {

    /**
     * 証記載保険者番号
     */
    証記載保険者番号("0103", "証記載保険者番号", "\"DbWT1613SinsaKetteiSeikyuGokei\".\"shoKisaiHokenshaNo\""),
    /**
     * 事業者番号
     */
    事業者番号("0366", "事業者番号", "\"DbWT1611SinsaKetteiSeikyuMeisai\".\"jigyoshoNo\""),
    /**
     * サービス提供年月
     */
    サービス提供年月("0364", "サービス提供年月", "\"DbWT1611SinsaKetteiSeikyuMeisai\".\"serviceTeikyouYM\""),
    /**
     * サービス種類コード
     */
    サービス種類コード("0308", "サービス種類コード", "\"DbWT1611SinsaKetteiSeikyuMeisai\".\"serviceShuruiCode\"");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private SogojigyohiShinsaKetteiSeikyumeisaihyoOutPutOrder(String 項目ID, String フォームフィールド名, String myBatis項目名) {
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
