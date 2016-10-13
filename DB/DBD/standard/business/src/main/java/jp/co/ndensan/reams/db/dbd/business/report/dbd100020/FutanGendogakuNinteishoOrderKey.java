/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100020;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力順設定可能項目です。
 *
 * @reamsid_L DBD-3981-050 x_miaocl
 */
public enum FutanGendogakuNinteishoOrderKey implements IReportItems {

    /**
     * 郵便番号
     */
    郵便番号(new RString("0001"), new RString("郵便番号"), new RString("\"ShikibetsuTaisho\".\"yubinNo\"")),
    /**
     * 町域コード
     */
    町域コード(new RString("0002"), new RString("町域コード"), new RString("\"ShikibetsuTaisho\".\"choikiCode\"")),
    /**
     * 番地コード
     */
    番地コード(new RString("0003"), new RString("番地コード"), new RString("\"ShikibetsuTaisho\".\"banchi\"")),
    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), new RString("\"ShikibetsuTaisho\".\"gyoseikuCode\"")),
    /**
     * 地区１
     */
    地区１(new RString("0005"), new RString("地区１"), new RString("\"ShikibetsuTaisho\".\"chikuCode1\"")),
    /**
     * 地区２
     */
    地区２(new RString("0006"), new RString("地区２"), new RString("\"ShikibetsuTaisho\".\"chikuCode2\"")),
    /**
     * 世帯コード
     */
    世帯コード(new RString("0008"), new RString("世帯コード"), new RString("\"ShikibetsuTaisho\".\"setaiCode\"")),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), new RString("識別コード")),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), new RString("\"ShikibetsuTaisho\".\"kanaShimei\"")),
    /**
     * 生年月日
     */
    生年月日(new RString("0012"), new RString("生年月日"), new RString("\"ShikibetsuTaisho\".\"seinengappiYMD\"")),
    /**
     * 性別
     */
    性別(new RString("0013"), new RString("性別"), new RString("\"ShikibetsuTaisho\".\"seibetsuCode\"")),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), new RString("市町村コード")),
    /**
     * 証記載保険者番号
     */
    証記載保険者番号(new RString("0103"), new RString("証記載保険者番号"), new RString("A.\"shoKisaiHokenshaNo\"")),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), new RString("被保険者番号"));
//    /** QA:445
//     * 入所施設コード
//     */
//    入所施設コード(new RString("0108"), new RString("入所施設コード"), new RString("入所施設コード"));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private FutanGendogakuNinteishoOrderKey(RString 項目ID, RString フォームフィールド名, RString myBatis項目名) {
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
