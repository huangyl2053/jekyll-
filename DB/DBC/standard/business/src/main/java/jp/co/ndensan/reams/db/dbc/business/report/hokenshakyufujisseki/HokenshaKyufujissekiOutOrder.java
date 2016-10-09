/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.hokenshakyufujisseki;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成の帳票出力項目管理Enumクラスです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public enum HokenshaKyufujissekiOutOrder implements IReportItems {

    /**
     * 保険者番号
     */
    保険者番号(new RString("0365"), new RString("保険者番号"), new RString("\"DbWT1111KyufuJisseki\".\"hokenshaNo\"")),
    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("郵便番号"), new RString("\"DbWT1001Hihokensha\".\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("町域コード"), new RString("\"DbWT1001Hihokensha\".\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"DbWT1001Hihokensha\".\"gyoseikuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"DbWT1001Hihokensha\".\"shimei50onKana\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), new RString("\"DbWT1001Hihokensha\".\"shichosonCode\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("\"DbWT1001Hihokensha\".\"exHihokenshaNo\"")),
    /**
     * 被保険者番号
     */
    サービス提供年月(new RString("0364"), new RString("サービス提供年月"), new RString("\"DbWT1111KyufuJisseki\".\"serviceTeikyoYM\"")),
    /**
     * 被保険者番号
     */
    事業者番号(new RString("0366"), new RString("事業者番号"), new RString("\"DbWT1111KyufuJisseki\".\"jigyoshoNo\"")),
    /**
     * 被保険者番号
     */
    入力識別番号(new RString("0304"), new RString("入力識別番号"), new RString("\"DbWT1111KyufuJisseki\".\"nyuryokuShikibetsuNo\"")),
    /**
     * 被保険者番号
     */
    整理番号(new RString("0305"), new RString("整理番号"), new RString("\"DbWT1111KyufuJisseki\".\"seiriNo\"")),
    /**
     * 被保険者番号
     */
    現物償還の別(new RString("0306"), new RString("現物償還の別"), new RString("\"DbWT1111KyufuJisseki\".\"kyufuJissekiKubun\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private HokenshaKyufujissekiOutOrder(RString 項目ID, RString フォームフィールド名,
            RString myBatis項目名) {
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
