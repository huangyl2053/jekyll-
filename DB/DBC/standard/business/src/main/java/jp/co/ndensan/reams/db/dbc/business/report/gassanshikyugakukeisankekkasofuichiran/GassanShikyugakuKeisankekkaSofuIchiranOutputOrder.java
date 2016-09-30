/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者情報更新結果情報取込一覧表帳票のenumです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
public enum GassanShikyugakuKeisankekkaSofuIchiranOutputOrder implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("yubinNo"), new RString("\"DbWT1001Hihokensha\".\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("choikiCode"), new RString("\"DbWT1001Hihokensha\".\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("gyoseikuCode"), new RString("\"DbWT1001Hihokensha\".\"gyoseikuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("shimei50onKana"), new RString("\"DbWT1001Hihokensha\".\"shimei50onKana\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("shichosonCode"), new RString("\"DbWT1001Hihokensha\".\"shichosonCode\"")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("shoKisaiHokenshaNo"),
            new RString("\"DbWT3811KogakuGassanShikyuGakuKeisanKekka\".\"shoKisaiHokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("hihokenshaNo"),
            new RString("\"DbWT3811KogakuGassanShikyuGakuKeisanKekka\".\"hihokenshaNo\"")),
    /**
     * 対象年度
     */
    対象年度(new RString("0334"), new RString("taishoNendo"),
            new RString("\"DbWT3811KogakuGassanShikyuGakuKeisanKekka\".\"taishoNendo\"")),
    /**
     * 申請書整理番号
     */
    申請書整理番号(new RString("0337"), new RString("shikyuShinseishoSeiriNo"),
            new RString("\"DbWT3811KogakuGassanShikyuGakuKeisanKekka\".\"shikyuShinseishoSeiriNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private GassanShikyugakuKeisankekkaSofuIchiranOutputOrder(
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
