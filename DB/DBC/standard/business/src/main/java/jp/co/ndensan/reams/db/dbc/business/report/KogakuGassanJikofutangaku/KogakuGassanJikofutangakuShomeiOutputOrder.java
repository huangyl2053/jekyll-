/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.KogakuGassanJikofutangaku;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200034_高額合算自己負担額証明書情報取込一覧表 Property
 *
 * @reamsid_L DBC-2640-030 zhengshenlei
 */
public enum KogakuGassanJikofutangakuShomeiOutputOrder implements IReportItems {

    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("shoKisaiHokenshaNo"), new RString("\"DbWT37H1\".\"hokenshaNoIn\"")),
    /**
     * 自己負担額の差異
     */
    自己負担額の差異(new RString("0372"), new RString("jikoFutangakuSaiFlag"), new RString("\"DbWT37H1\".\"jikoFutangakuSaiFlag\"")),
    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("yubinNo"), new RString("\"DbWT0001\".\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("choikiCode"), new RString("\"DbWT0001\".\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("gyoseikuCode"), new RString("\"DbWT0001\".\"gyoseikuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("shimei50onKana"), new RString("\"DbWT0001\".\"shimei50onKana\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("\"DbWT0001\".\"shichosonCode\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("hihokenshaNo"), new RString("\"DbWT0001\".\"hihokenshaNo\"")),
    /**
     * 対象年度
     */
    対象年度(new RString("0334"), new RString("taishoNendo"), new RString("\"DbWT37H1\".\"taishoNendo\"")),
    /**
     * 申請年月日
     */
    申請年月日(new RString("0333"), new RString("shinseiYMD"), new RString("\"DbWT37H1\".\"shinseiYMD\"")),
    /**
     * 申請書整理番号
     */
    申請書整理番号(new RString("'0337"), new RString("shinseiYMD"), new RString("\"DbWT37H1\".\"shikyuShinseishoSeiriNo\"")),
    /**
     * 証明書整理番号
     */
    証明書整理番号(new RString("'0338"), new RString("shinseiYMD"), new RString("\"DbWT37H1\".\"jikoFutanSeiriNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KogakuGassanJikofutangakuShomeiOutputOrder(
            RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
