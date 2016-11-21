/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.keikakutodokedejokyoichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種お知らせ作成の出力順項目を表す列挙型です。
 *
 * @reamsid_L DBC-1960-030 jianglaisheng
 */
public enum KeikakuTodokedeJokyoIchiranOrder implements IReportItems {

    /**
     * 郵便番号です。
     */
    郵便番号(new RString("0001"), new RString(""), new RString("\"ShikibetsuTaisho\".\"yubinNo\"")),
    /**
     * 町域コード です。
     */
    町域コード(new RString("0002"), new RString(""), new RString("\"ShikibetsuTaisho\".\"choikiCode\"")),
    /**
     * 番地コード です。
     */
    番地コード(new RString("0003"), new RString(""), new RString("\"atesaki_banchiCode\"")),
    /**
     * 行政区コード です。
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"ShikibetsuTaisho\".\"gyoseikuCode\"")),
    /**
     * 識別コード です。
     */
    識別コード(new RString("0009"), new RString(""), new RString("\"ShikibetsuTaisho\".\"shikibetsuCode\"")),
    /**
     * 氏名５０音カナ です。
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"ShikibetsuTaisho\".\"kanaMeisho\"")),
    /**
     * 生年月日 です。
     */
    生年月日(new RString("0012"), new RString(""), new RString("\"ShikibetsuTaisho\".\"seinengappiYMD\"")),
    /**
     * 性別 です。
     */
    性別(new RString("0013"), new RString(""), new RString("\"ShikibetsuTaisho\".\"seibetsuCode\"")),
    /**
     * 市町村コード です。
     */
    市町村コード(new RString("0016"), new RString(""), new RString("受給者台帳.\"shichosonCode\"")),
    /**
     * 被保険者番号 です。
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("受給者台帳.\"hihokenshaNo\"")),
    /**
     * 計画届出日 です。
     */
    計画届出日(new RString("0302"), new RString(""), new RString("居宅サービス計画_todokedeYMD")),
    /**
     * 指定事業者番号 です。
     */
    指定事業者番号(new RString("0303"), new RString(""), new RString("居宅サービス計画_keikakuJigyoshaNo")),
    /**
     * 受給申請日 です。
     */
    受給申請日(new RString("0405"), new RString(""), new RString("DbT4001_jukyuShinseiYMD")),
    /**
     * 認定日 です。
     */
    認定日(new RString("0407"), new RString(""), new RString("DbT4001_ninteiYMD"));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KeikakuTodokedeJokyoIchiranOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
