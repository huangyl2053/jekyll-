/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbb021051;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）の出力順の列挙類です。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
public enum DBB021051OutPutOrder implements IReportItems {

    /**
     * 郵便番号です。
     */
    郵便番号(new RString("0001"), new RString(""), new RString("\"TempTable\".\"郵便番号\""), new RString("郵便番号")),
    /**
     * 住所コードです。
     */
    住所コード(new RString("0002"), new RString(""), new RString("\"TempTable\".\"住所コード\""), new RString("住所コード")),
    /**
     * 番地コードです。
     */
    番地コード(new RString("0003"), new RString(""), new RString("\"TempTable\".\"番地コード\""), new RString("番地コード")),
    /**
     * 行政区コードです。
     */
    行政区コード(new RString("0004"), new RString(""), new RString("\"TempTable\".\"行政区コード\""), new RString("行政区コード")),
    /**
     * 地区コード1です。
     */
    地区コード1(new RString("0005"), new RString(""), new RString("\"TempTable\".\"地区コード1\""), new RString("地区コード1")),
    /**
     * 地区コード2です。
     */
    地区コード2(new RString("0006"), new RString(""), new RString("\"TempTable\".\"地区コード2\""), new RString("地区コード2")),
    /**
     * 地区コード3です。
     */
    地区コード3(new RString("0007"), new RString(""), new RString("\"TempTable\".\"地区コード3\""), new RString("地区コード3")),
    /**
     * 世帯コードです。
     */
    世帯コード(new RString("0008"), new RString(""), new RString("\"TempTable\".\"世帯コード\""), new RString("世帯コード")),
    /**
     * 生年月日です。
     */
    生年月日(new RString("0012"), new RString(""), new RString("\"TempTable\".\"生年月日\""), new RString("生年月日")),
    /**
     * 性別です。
     */
    性別(new RString("0013"), new RString(""), new RString("\"TempTable\".\"性別\""), new RString("性別")),
    /**
     * 住民コードです。
     */
    住民コード(new RString("0014"), new RString(""), new RString("\"TempTable\".\"識別コード\""), new RString("住民コード")),
    /**
     * 氏名５０音カナです。
     */
    氏名５０音カナ(new RString("0010"), new RString(""), new RString("\"TempTable\".\"氏名カナ\""), new RString("氏名５０音カナ")),
    /**
     * 氏名５０音漢字です。
     */
    氏名５０音漢字(new RString("0011"), new RString(""), new RString("\"TempTable\".\"氏名\""), new RString("氏名５０音漢字")),
    /**
     * 市町村コードです。
     */
    市町村コード(new RString("0016"), new RString(""), new RString("\"TempTable\".\"市町村コード\""), new RString("市町村コード")),
    /**
     * 被保険者番号です。
     */
    被保険者番号(new RString("0104"), new RString(""), new RString("\"TempTable\".\"被保険者番号\""), new RString("被保険者番号"));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;
    private final RString 項目名;

    private DBB021051OutPutOrder(RString 項目ID, RString フォームフィールド名, RString myBatis項目名, RString 項目名) {
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
