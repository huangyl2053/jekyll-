/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020080;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票分類ID「DBC020080GassanKekkaIchiranOutputOrder」（高額合算自己負担額計算結果一覧表）出力順設定可能項目です。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
public enum DBC200029GassanKekkaIchiranOutputOrder implements IReportItems {

    /**
     * 郵便番号です。
     */
    郵便番号(new RString("0001"), new RString("郵便番号"), new RString("\"temp\".\"ichiranYubinNo\"")),
    /**
     * 町域コードです。
     */
    町域コード(new RString("0002"), new RString("町域コード"), new RString("\"temp\".\"ichiranChoikiCode\"")),
    /**
     * 行政区コードです。
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"temp\".\"ichiranGyoseikuCode\"")),
    /**
     * 氏名５０音カナです。
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"temp\".\"hihokenshaShimeiKana\"")),
    /**
     * 市町村コードです。
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), new RString("\"temp\".\"ichiranShichosonCode\"")),
    /**
     * 証記載保険者番号です。
     */
    証記載保険者番号(new RString("0103"), new RString("証記載保険者番号"), new RString("\"temp\".\"hokenshaNo\"")),
    /**
     * 被保険者番号です。
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("\"temp\".\"hihokenshaNo\"")),
    /**
     * 申請年月日です。
     */
    申請年月日(new RString("0333"), new RString("申請年月日"), new RString("\"temp\".\"shinseiYMD\"")),
    /**
     * 対象年度です。
     */
    対象年度(new RString("0334"), new RString("対象年度"), new RString("\"temp\".\"taishoNendo\"")),
    /**
     * 申請書整理番号です。
     */
    申請書整理番号(new RString("0337"), new RString("申請書整理番号"), new RString("\"temp\".\"shikyuShinseishoSeiriNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private DBC200029GassanKekkaIchiranOutputOrder(
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
