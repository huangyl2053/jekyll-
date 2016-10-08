/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseisho;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * DBC100064_基準収入額適用申請書のPageBreakenumクラスです
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
public enum KijunShunyugakuTekiyoShinseishoPutOrder implements IReportItems {

//    /**
//     * 郵便番号
//     */
//    郵便番号("0001", "郵便番号", "\"DbWT1001Hihokensha\".\"yubinNo\""),
//    /**
//     * 町域コード
//     */
//    町域コード("0002", "町域コード", "\"DbWT1001Hihokensha\".\"choikiCode\""),
//    /**
//     * 行政区コード
//     */
//    行政区コード("0004", "行政区コード", "\"DbWT1001Hihokensha\".\"gyoseikuCode\""),
//    /**
//     * 世帯コード
//     */
//    世帯コード("00008", "世帯コード", "\"DbWT1001Hihokensha\".\"shimei50onKana\""),
    /**
     * 市町村コード
     */
    市町村コード("0016", "市町村コード", "\"A\".\"shichosonCode\"");

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KijunShunyugakuTekiyoShinseishoPutOrder(String 項目ID, String フォームフィールド名, String myBatis項目名) {
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
