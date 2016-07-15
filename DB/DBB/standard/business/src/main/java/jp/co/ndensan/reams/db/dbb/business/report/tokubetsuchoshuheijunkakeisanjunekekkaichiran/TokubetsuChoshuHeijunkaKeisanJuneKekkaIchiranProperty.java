/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IReportItems;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.Breakers;
import jp.co.ndensan.reams.uz.uza.report.ReportPropertyBase;

/**
 * 特別徴収平準化計算（特別徴収6月分）結果一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0810-030 yebangqiang
 */
public class TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty extends ReportPropertyBase<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource> {

    private static final ReportId ID = ReportIdDBB.DBB200003.getReportId();
    private static final RString ENCLOSURE = new RString("\"");

    /**
     * コンストラクタです。
     */
    public TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty() {
        super(SubGyomuCode.DBB介護賦課, ID);
    }

    /**
     * 改頁メソッド
     *
     * @param breakers Breakers<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource>
     * @param catalog BreakerCatalog<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource>
     * @return Breaker
     */
    @Override
    protected Breakers<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource> defineBreakers(
            Breakers<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource> breakers,
            BreakerCatalog<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource> catalog) {
        return super.defineBreakers(breakers, catalog);
    }

    /**
     * 帳票分類ID「DBB100014_arisanteiHokenryoNonyuTsuchishoDaihyo」（仮算定額変更通知書(平準化)）出力順設定可能項目です。
     */
    public enum DBB100014NonyuTsuchishoEnum implements IReportItems {

        /**
         * 郵便番号
         */
        郵便番号(new RString("0001"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_yubinNo").concat(ENCLOSURE))),
        /**
         * 町域コード
         */
        町域コード(new RString("0002"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_choikiCode").concat(ENCLOSURE))),
        /**
         * 番地コード
         */
        番地コード(new RString("0003"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 行政区コード
         */
        行政区コード(new RString("0004"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_gyoseikuCode").concat(ENCLOSURE))),
        /**
         * 地区１
         */
        地区１(new RString("0005"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_chikuCode1").concat(ENCLOSURE))),
        /**
         * 地区２
         */
        地区２(new RString("0006"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_chikuCode2").concat(ENCLOSURE))),
        /**
         * 地区３
         */
        地区３(new RString("0007"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_chikuCode3").concat(ENCLOSURE))),
        /**
         * 世帯コード
         */
        世帯コード(new RString("0008"), new RString(""), ENCLOSURE.concat(new RString("dbT2015KeisangoJoho_setaiCode").concat(
                ENCLOSURE))),
        /**
         * 識別コード
         */
        識別コード(new RString("0009"), new RString(""), ENCLOSURE.concat(new RString("dbT2015KeisangoJoho_shikibetsuCode").concat(ENCLOSURE))),
        /**
         * 氏名５０音カナ
         */
        氏名５０音カナ(new RString("0010"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 生年月日
         */
        生年月日(new RString("0012"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_seinengappiYMD").concat(ENCLOSURE))),
        /**
         * 性別
         */
        性別(new RString("0013"), new RString(""), ENCLOSURE.concat(new RString("ShikibetsuTaisho_seibetsuCode").concat(ENCLOSURE))),
        /**
         * 市町村コード
         */
        市町村コード(new RString("0016"), new RString(""), ENCLOSURE.concat(new RString("").concat(ENCLOSURE))),
        /**
         * 被保険者番号
         */
        被保険者番号(new RString("0104"), new RString(""), ENCLOSURE.concat(new RString("dbT2015KeisangoJoho_hihokenshaNo").concat(ENCLOSURE))),
        /**
         * 生活保護種別
         */
        生活保護種別(new RString("0116"), new RString(""), ENCLOSURE.concat(new RString("6").concat(ENCLOSURE))),
        /**
         * 現金口座区分
         */
        現金口座区分(new RString("0210"), new RString(""), ENCLOSURE.concat(new RString("6").concat(ENCLOSURE))),
        /**
         * 8月特徴開始者
         */
        月8特徴開始者(new RString("0220"), new RString(""), ENCLOSURE.concat(new RString("6").concat(ENCLOSURE))),
        /**
         * 10月特徴開始者
         */
        月10特徴開始者(new RString("0219"), new RString(""), ENCLOSURE.concat(new RString("6").concat(ENCLOSURE))),
        /**
         * 納組コード
         */
        納組コード(new RString("0208"), new RString(""), ENCLOSURE.concat(
                new RString("CaT0714nokumiCode").concat(ENCLOSURE)));

        private final RString 項目ID;
        private final RString フォームフィールド名;
        private final RString myBatis項目名;

        private DBB100014NonyuTsuchishoEnum(
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
