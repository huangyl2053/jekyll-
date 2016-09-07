/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種お知らせ作成の出力順項目を表す列挙型です。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public enum KogakuJigyoShinseishoHakkoIchiranOrder implements IReportItems {

    /**
     * 施設事業所番号です。
     */
    証記載保険者番号(new RString("0103"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"shoKisaiHokenshaNoChohyo\"")),
    /**
     * 子ども識別コードです。
     */
    郵便番号(new RString("0001"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"yubinNoChohyo\"")),
    /**
     * 住所コードです。
     */
    町域コード(new RString("0002"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"choikiCode\"")),
    /**
     * 行政区コードです。
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"gyoseikuCodeChohyo\"")),
    /**
     * 世帯コードです。
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"shimeikanaChohyo\"")),
    /**
     * 施設事業所明細区分です。
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"hihokenshaNoChohyo\"")),
    /**
     * 公私区分です。
     */
    サービス提供年月(new RString("0364"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"serviceTeikyoYMChohyo\"")),
    /**
     * 子ども生年月日です。
     */
    通知書番号(new RString("0202"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"tsuchishoNoChohyo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KogakuJigyoShinseishoHakkoIchiranOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
        this.項目ID = 項目ID;
        this.フォームフィールド名 = フォームフィールド名;
        this.myBatis項目名 = myBatis項目名;
    }

    /**
     * 項目IDを取得します。
     *
     * @return 項目ID
     */
    @Override
    public RString get項目ID() {
        return 項目ID;
    }

    /**
     * フォームフィールド名を取得します。
     *
     * @return フォームフィールド名
     */
    @Override
    public RString getフォームフィールド名() {
        return フォームフィールド名;
    }

    /**
     * 項目名を取得します。
     *
     * @return 項目名
     */
    @Override
    public RString getMyBatis項目名() {
        return myBatis項目名;
    }
}
