/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBPR81003_1_特別徴収同定一覧表の出力順設定
 *
 * @reamsid_L DBB-1860-050 pengxingyi
 *
 */
public enum TokubetsuChoshuDoteiIchiranOutputOrder implements IReportItems {

    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("町域コード"), new RString("\"choikiCode\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"gyoseikuCode\"")),
    /**
     * 地区１
     */
    地区１(new RString("0005"), new RString("地区１"), new RString("\"chikuCode1\"")),
    /**
     * 地区２
     */
    地区２(new RString("0006"), new RString("地区２"), new RString("\"chikuCode2\"")),
    /**
     * 地区３
     */
    地区３(new RString("0007"), new RString("地区３"), new RString("\"chikuCode3\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString("世帯コード"), new RString("\"setaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), new RString("\"shikibetsuCode\"")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"kanaShimei\"")),
    /**
     * 生年月日
     */
    生年月日(new RString("0012"), new RString("生年月日"), new RString("\"seinengappiYMD\"")),
    /**
     * 市町村コード
     */
    性別(new RString("0013"), new RString("性別"), new RString("\"seibetsuCode\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0021"), new RString("市町村コード"), new RString("")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0031"), new RString("被保険者番号"), new RString("\"hihokenshaNo\"")),
    /**
     * 年金コード
     */
    年金コード(new RString("0051"), new RString("年金コード"), new RString("\"nenkinCode\"")),
    /**
     * 被保険者番号
     */
    年金番号(new RString("0052"), new RString("年金番号"), new RString("\"kisoNenkinNo\""));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private TokubetsuChoshuDoteiIchiranOutputOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
