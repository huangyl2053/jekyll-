/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.dbc190030;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC110065_基準収入額適用申請書_異動分作成の出力順の列挙類です。
 *
 * @reamsid_L DBC-4640-030 liuyang
 */
public enum DBC190030OutPutOrder implements IReportItems {

    /**
     * 郵便番号です。
     */
    郵便番号(new RString("0001"), new RString(""), new RString("\"TempTable\".\"郵便番号\""), new RString("郵便番号")),
    /**
     * 住所コードです。
     */
    町域コード(new RString("0002"), new RString(""), new RString("\"TempTable\".\"町域コード\""), new RString("町域コード")),
    /**
     * 行政区コードです。
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"TempTable\".\"行政区コード\""), new RString("行政区コード")),
    /**
     * 世帯コードです。
     */
    世帯コード(new RString("0008"), new RString(""), new RString("\"TempTable\".\"世帯コード\""), new RString("世帯コード")),
    /**
     * 市町村コードです。
     */
    市町村コード(new RString("0016"), new RString(""), new RString("\"TempTable\".\"市町村コード\""), new RString("市町村コード"));

    private final RString 項目ID;

    private final RString フォームフィールド名;
    private final RString myBatis項目名;
    private final RString 項目名;

    private DBC190030OutPutOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名, RString 項目名) {
        this.項目ID = 項目ID;
        this.フォームフィールド名 = フォームフィールド名;
        this.myBatis項目名 = myBatis項目名;
        this.項目名 = 項目名;
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

    /**
     * 項目名を取得します。
     *
     * @return RString
     */
    public RString get項目名() {
        return 項目名;
    }

}
