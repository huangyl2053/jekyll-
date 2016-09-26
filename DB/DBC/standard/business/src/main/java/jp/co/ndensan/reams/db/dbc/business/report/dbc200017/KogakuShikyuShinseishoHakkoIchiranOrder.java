/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200017;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請書発行一覧表のorderクラスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public enum KogakuShikyuShinseishoHakkoIchiranOrder implements IReportItems {

    /**
     * 郵便番号です。
     */
    郵便番号(new RString("0001"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"yubinNoChohyo\"")),
    /**
     * 町域コードです。
     */
    町域コード(new RString("0002"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"jushoChohyo\"")),
    /**
     * 行政区コードです。
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"gyoseikuCodeChohyo\"")),
    /**
     * 氏名５０音カナです。
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"shimeikanaChohyo\"")),
    /**
     * 市町村コードです。
     */
    市町村コード(new RString("0016"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"shoKisaiHokenshaNoChohyo\"")),
    /**
     * 証記載保険者番号です。
     */
    証記載保険者番号(new RString("0103"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"shoKisaiHokenshaNoChohyo\"")),
    /**
     * 被保険者番号です。
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"hihokenshaNoChohyo\"")),
    /**
     * サービス年月です。
     */
    サービス年月(new RString("0301"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"serviceTeikyoYMChohyo\"")),
    /**
     * サービス分類です。
     */
    サービス分類(new RString("0324"), new RString(""), new RString("\"ShinseiJohoChohyoTemp\".\"serviceShuruiCodeChohyo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private KogakuShikyuShinseishoHakkoIchiranOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
