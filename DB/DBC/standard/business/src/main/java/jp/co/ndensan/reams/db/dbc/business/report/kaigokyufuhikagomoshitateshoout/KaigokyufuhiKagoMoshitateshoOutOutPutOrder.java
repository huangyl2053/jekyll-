/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigokyufuhikagomoshitateshoout;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 帳票設計_DBC200045_給付過誤申立書情報送付一覧表のPageBreakenumクラスです
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
public enum KaigokyufuhiKagoMoshitateshoOutOutPutOrder implements IReportItems {

    /**
     * 証記載保険者番号
     */
    証記載保険者番号("0103", "証記載保険者番号", "\"DbWT1731KagoMoshitate\".\"shoKisaiHokenshaNo\""),
    /**
     * 郵便番号
     */
    郵便番号("0001", "郵便番号", "\"DbWT1001Hihokensha\".\"yubinNo\""),
    /**
     * 町域コード
     */
    町域コード("0002", "町域コード", "\"DbWT1001Hihokensha\".\"choikiCode\""),
    /**
     * 行政区コード
     */
    行政区コード("0004", "行政区コード", "\"DbWT1001Hihokensha\".\"gyoseikuCode\""),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ("0010", "氏名５０音カナ", "\"DbWT1001Hihokensha\".\"shimei50onKana\""),
    /**
     * 市町村コード
     */
    市町村コード("0016", "市町村コード", "\"DbWT1001Hihokensha\".\"shichosonCode\""),
    /**
     * 被保険者番号
     */
    被保険者番号("0104", "被保険者番号", "\"DbWT1731KagoMoshitate\".\"hiHokenshaNo\""),
    /**
     * 事業者番号
     */
    事業者番号("0366", "事業者番号", "\"DbWT1731KagoMoshitate\".\"jigyoshaNo\""),
    /**
     * サービス提供年月
     */
    サービス提供年月("0364", "サービス提供年月", "\"DbWT1731KagoMoshitate\".\"serviceTeikyoYM\"");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KaigokyufuhiKagoMoshitateshoOutOutPutOrder(String 項目ID, String フォームフィールド名, String myBatis項目名) {
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
