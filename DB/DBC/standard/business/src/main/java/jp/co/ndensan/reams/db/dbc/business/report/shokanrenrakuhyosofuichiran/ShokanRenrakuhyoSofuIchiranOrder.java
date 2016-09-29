/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.shokanrenrakuhyosofuichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還連絡票送付一覧表の出力順項目を表す列挙型です。
 *
 * @reamsid_L DBC-2570-030 jianglaisheng
 */
public enum ShokanRenrakuhyoSofuIchiranOrder implements IReportItems {

    /**
     * 保険者番号 です。
     */
    保険者番号(new RString("0365"), new RString(""), new RString("\"hokenshaNo\"")),
    /**
     * 郵便番号 です。
     */
    郵便番号(new RString("0001"), new RString(""), new RString("\"yubinNo\"")),
    /**
     * 町域コード です。
     */
    町域コード(new RString("0002"), new RString(""), new RString("\"choikiCode\"")),
    /**
     * 行政区コード です。
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"gyoseikuCode\"")),
    /**
     * 氏名５０音カナ です。
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"shimei50onKana\"")),
    /**
     * 市町村コード です。
     */
    市町村コード(new RString("0016"), new RString(""), new RString("\"shichosonCode\"")),
    /**
     * 被保険者番号 です。
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("\"hiHokenshaNo\"")),
    /**
     * サービス提供年月 です。
     */
    サービス提供年月(new RString("0364"), new RString(""), new RString("\"serviceTeikyoYM\"")),
    /**
     * 整理番号 です。
     */
    整理番号(new RString("0305"), new RString(""), new RString("\"seiriNo\"")),
    /**
     * 償還払申請日 です。
     */
    償還払申請日(new RString("0313"), new RString(""), new RString("\"shinseiYMD\"")),
    /**
     * 指定事業者番号 です。
     */
    指定事業者番号(new RString("0303"), new RString(""), new RString("\"shinseiJigyoshaNo\"")),
    /**
     * 様式番号 です。
     */
    様式番号(new RString("0315"), new RString(""), new RString("\"yoshikiNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private ShokanRenrakuhyoSofuIchiranOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
