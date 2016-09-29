/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohoichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokuChoHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 帳票設計_DBBPR82001_1_特別徴収依頼情報一覧表クラスです。
 *
 * @reamsid_L DBB-1840-060 xuzhao
 */
public class TokubetsuChoshuIraiJohoIchiranProperty extends ReportPropertyBase<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> {

    private static final ReportId ID = ReportIdDBB.DBB200019.getReportId();
    private static final RString ENCLOSURE = new RString("\"");

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuIraiJohoIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }

    /**
     * 改頁メソッド
     *
     * @param breakers Breakers<KariNonyuTsuchishoHakkoIchiranSource>
     * @param catalog BreakerCatalog<KariNonyuTsuchishoHakkoIchiranSource>
     * @return Breaker
     */
    @Override
    protected Breakers<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> defineBreakers(
            Breakers<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> breakers,
            BreakerCatalog<TokuChoHeijunkaKeisanJuneKekkaIchiranSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }

    /**
     * 帳票分類ID「DBB200019_TokubetsuChoshuIraiJohoIchiran」（特別徴収依頼情報一覧表）出力順設定可能項目です。
     */
    public enum DBB200019_TokubetsuChoshuIraiJohoIchiranEnum implements IReportItems {

        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_gyoseikuCode").concat(ENCLOSURE))),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_shikibetsuCode").concat(ENCLOSURE))),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_dtKanaShimei").concat(ENCLOSURE))),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_dtBirthDay").concat(ENCLOSURE))),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_dtSeibetsu").concat(ENCLOSURE))),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_koseiCityCode").concat(ENCLOSURE))),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_hihokenshaNo").concat(ENCLOSURE))),
        /**
         * 年金コード
         */
        年金コード(new RString("0206"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_nenkinCode").concat(
                ENCLOSURE))),
        /**
         * 年金番号
         */
        年金番号(new RString("0207"), new RString(""), ENCLOSURE.concat(new RString("ueT0511NenkinTokuchoKaifuJoho_kisoNenkinNo").concat(ENCLOSURE)));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB200019_TokubetsuChoshuIraiJohoIchiranEnum(
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
}
