/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohoichiran;

import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票分類ID「DBB200021_TokubetsuChoshuIdojohoIchiran」（特別徴収異動情報一覧表）出力順設定可能項目です。
 */
public enum DBB200021_TokubetsuChoshuIdojohoIchiranEnum implements IReportItems {

    /**
     * 行政区コード
     */
    行政区コード(new RString("0004"), new RString("行政区コード"), Contents.ENCLOSURE.concat(new RString("ShikibetsuTaisho_gyoseikuCode").concat(Contents.ENCLOSURE))),
    /**
     * 識別コード
     */
    識別コード(new RString("0009"), new RString("識別コード"), Contents.ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_shikibetsuCode").concat(Contents.ENCLOSURE))),
    /**
     * 氏名５０音カナ
     */
    氏名５０音カナ(new RString("0010"), new RString("氏名５０音カナ"), Contents.ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_dtKanaShimei").concat(Contents.ENCLOSURE))),
    /**
     * 生年月日
     */
    生年月日(new RString("0012"), new RString("生年月日"), Contents.ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_dtBirthDay").concat(Contents.ENCLOSURE))),
    /**
     * 性別
     */
    性別(new RString("0013"), new RString("性別"), Contents.ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_dtSeibetsu").concat(Contents.ENCLOSURE))),
    /**
     * 市町村コード
     */
    市町村コード(new RString("0016"), new RString("市町村コード"), Contents.ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_koseiCityCode").concat(Contents.ENCLOSURE))),
    /**
     * 被保険者番号
     */
    被保険者番号(new RString("0104"), new RString("被保険者番号"), Contents.ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_hihokenshaNo").concat(Contents.ENCLOSURE))),
    /**
     * 年金コード
     */
    年金コード(new RString("0206"), new RString("年金コード"), Contents.ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_nenkinCode").concat(
            Contents.ENCLOSURE))),
    /**
     * 年金番号
     */
    年金番号(new RString("0207"), new RString("年金番号"), Contents.ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_kisoNenkinNo").concat(Contents.ENCLOSURE)));

    private final RString 項目ID;
    private final RString フォームフィールド名;
    private final RString myBatis項目名;

    private DBB200021_TokubetsuChoshuIdojohoIchiranEnum(
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

    private static class Contents {

        private static final RString ENCLOSURE = new RString("\"");
    }

}
